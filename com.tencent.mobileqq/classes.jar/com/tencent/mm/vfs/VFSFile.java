package com.tencent.mm.vfs;

import android.net.Uri;
import android.net.Uri.Builder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class VFSFile
  implements Comparable<VFSFile>
{
  public static final String pathSeparator = ":";
  public static final char pathSeparatorChar = ':';
  public static final String separator = "/";
  public static final char separatorChar = '/';
  private FileSystemManager.Resolution mResolved = null;
  private final Uri mUri;
  
  public VFSFile(Uri paramUri)
  {
    if (paramUri == null) {
      throw new NullPointerException("uri == null");
    }
    String str = paramUri.getPath();
    Uri localUri = paramUri;
    if (str != null)
    {
      str = VFSUtils.normalizePath(str, false, false);
      localUri = paramUri;
      if (!paramUri.getPath().equals(str)) {
        localUri = paramUri.buildUpon().path(str).build();
      }
    }
    this.mUri = localUri;
  }
  
  public VFSFile(Uri paramUri, String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("name == null");
    }
    Object localObject;
    if (paramUri == null)
    {
      paramUri = new Uri.Builder().path(paramString);
      paramString = paramUri.build();
      localObject = paramString.getPath();
      if (localObject == null) {
        break label111;
      }
      localObject = VFSUtils.normalizePath((String)localObject, false, false);
      if (paramString.getPath().equals(localObject)) {
        break label111;
      }
    }
    label111:
    for (paramUri = paramUri.path((String)localObject).build();; paramUri = paramString)
    {
      this.mUri = paramUri;
      return;
      localObject = paramUri.buildUpon();
      paramUri = (Uri)localObject;
      if (paramString.isEmpty()) {
        break;
      }
      ((Uri.Builder)localObject).appendPath(paramString);
      paramUri = (Uri)localObject;
      break;
    }
  }
  
  public VFSFile(VFSFile paramVFSFile, String paramString) {}
  
  public VFSFile(File paramFile)
  {
    this(VFSUtils.parseUri(paramFile.getPath()));
  }
  
  public VFSFile(File paramFile, String paramString)
  {
    this(VFSUtils.parseUri(paramFile.getPath()), paramString);
  }
  
  public VFSFile(String paramString)
  {
    this(VFSUtils.parseUri(paramString));
  }
  
  public VFSFile(String paramString1, String paramString2)
  {
    this(VFSUtils.parseUri(paramString1), paramString2);
  }
  
  private Uri getAbsoluteUri()
  {
    if (isAbsolute()) {
      return this.mUri;
    }
    String str2 = this.mUri.getPath();
    String str1 = System.getProperty("user.dir");
    if (str2.isEmpty()) {}
    for (;;)
    {
      return this.mUri.buildUpon().path(str1).build();
      str1 = str1 + '/' + str2;
    }
  }
  
  public boolean canExecute()
  {
    Object localObject = resolve();
    if (!((FileSystemManager.Resolution)localObject).valid()) {}
    do
    {
      FileSystem localFileSystem;
      do
      {
        return false;
        localFileSystem = ((FileSystemManager.Resolution)localObject).fileSystem;
      } while ((localFileSystem.capabilityFlags() & 0x2) == 0);
      localObject = localFileSystem.realPath(((FileSystemManager.Resolution)localObject).path, false);
    } while ((localObject == null) || (!new File((String)localObject).canExecute()));
    return true;
  }
  
  public boolean canRead()
  {
    FileSystemManager.Resolution localResolution = resolve();
    if (!localResolution.valid()) {
      return false;
    }
    FileSystem localFileSystem = localResolution.fileSystem;
    String str = localFileSystem.realPath(localResolution.path, false);
    if (str != null) {
      return new File(str).canRead();
    }
    return localFileSystem.exists(localResolution.path);
  }
  
  public boolean canWrite()
  {
    FileSystemManager.Resolution localResolution = resolve();
    if (!localResolution.valid()) {}
    FileSystem localFileSystem;
    do
    {
      return false;
      localFileSystem = localResolution.fileSystem;
    } while ((localFileSystem.capabilityFlags() & 0x1) == 0);
    String str = localFileSystem.realPath(localResolution.path, true);
    if (str != null) {
      return new File(str).canWrite();
    }
    return localFileSystem.exists(localResolution.path);
  }
  
  public int compareTo(VFSFile paramVFSFile)
  {
    return getPath().compareTo(paramVFSFile.getPath());
  }
  
  public boolean createNewFile()
  {
    FileSystemManager.Resolution localResolution = resolve();
    if (!localResolution.valid()) {
      throw new FileNotFoundException("Cannot resolve path or URI: " + this.mUri);
    }
    if (localResolution.fileSystem.exists(localResolution.path)) {
      return false;
    }
    localResolution.fileSystem.openWrite(localResolution.path, false).close();
    return true;
  }
  
  public boolean delete()
  {
    FileSystemManager.Resolution localResolution = resolve();
    return (localResolution.valid()) && (localResolution.fileSystem.delete(localResolution.path));
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof VFSFile)) {
      return false;
    }
    return this.mUri.equals(((VFSFile)paramObject).mUri);
  }
  
  public boolean exists()
  {
    FileSystemManager.Resolution localResolution = resolve();
    if (!localResolution.valid()) {
      return false;
    }
    return localResolution.fileSystem.exists(localResolution.path);
  }
  
  public VFSFile getAbsoluteFile()
  {
    return new VFSFile(getAbsoluteUri());
  }
  
  public String getAbsolutePath()
  {
    return VFSUtils.uriToString(getAbsoluteUri());
  }
  
  public long getFreeSpace()
  {
    return getUsableSpace();
  }
  
  public String getName()
  {
    String str = this.mUri.getPath();
    int i = str.lastIndexOf("/");
    if (i < 0) {
      return str;
    }
    return str.substring(i + 1, str.length());
  }
  
  public String getParent()
  {
    Uri localUri = getParentUri();
    if (localUri == null) {
      return null;
    }
    return VFSUtils.uriToString(localUri);
  }
  
  public VFSFile getParentFile()
  {
    Uri localUri = getParentUri();
    if (localUri == null) {
      return null;
    }
    return new VFSFile(localUri);
  }
  
  public Uri getParentUri()
  {
    String str = this.mUri.getPath();
    int i = str.length();
    int j = str.lastIndexOf('/');
    if ((j == -1) || (str.charAt(i - 1) == '/')) {
      return null;
    }
    if ((str.indexOf('/') == j) && (str.charAt(0) == '/')) {}
    for (str = str.substring(0, j + 1);; str = str.substring(0, j)) {
      return this.mUri.buildUpon().path(str).build();
    }
  }
  
  public String getPath()
  {
    return VFSUtils.uriToString(this.mUri);
  }
  
  public long getTotalSpace()
  {
    Object localObject = resolve();
    if (!((FileSystemManager.Resolution)localObject).valid()) {}
    do
    {
      return 0L;
      localObject = ((FileSystemManager.Resolution)localObject).fileSystem.fileSystemStat(((FileSystemManager.Resolution)localObject).path);
    } while (localObject == null);
    return ((FileSystem.FsStat)localObject).totalSpace;
  }
  
  public Uri getUri()
  {
    return this.mUri;
  }
  
  public long getUsableSpace()
  {
    Object localObject = resolve();
    if (!((FileSystemManager.Resolution)localObject).valid()) {}
    do
    {
      return 0L;
      localObject = ((FileSystemManager.Resolution)localObject).fileSystem.fileSystemStat(((FileSystemManager.Resolution)localObject).path);
    } while (localObject == null);
    return ((FileSystem.FsStat)localObject).availableSpace;
  }
  
  public int hashCode()
  {
    return getPath().hashCode() ^ 0x12D591;
  }
  
  public boolean isAbsolute()
  {
    boolean bool2 = false;
    String str = this.mUri.getPath();
    boolean bool1;
    if (!this.mUri.isAbsolute())
    {
      bool1 = bool2;
      if (str.length() > 0)
      {
        bool1 = bool2;
        if (str.charAt(0) != '/') {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public boolean isDirectory()
  {
    Object localObject = resolve();
    if (!((FileSystemManager.Resolution)localObject).valid()) {}
    do
    {
      return false;
      localObject = ((FileSystemManager.Resolution)localObject).fileSystem.stat(((FileSystemManager.Resolution)localObject).path);
    } while ((localObject == null) || (!((FileSystem.FileEntry)localObject).isDirectory));
    return true;
  }
  
  public boolean isFile()
  {
    Object localObject = resolve();
    if (!((FileSystemManager.Resolution)localObject).valid()) {}
    do
    {
      return false;
      localObject = ((FileSystemManager.Resolution)localObject).fileSystem.stat(((FileSystemManager.Resolution)localObject).path);
    } while ((localObject == null) || (((FileSystem.FileEntry)localObject).isDirectory));
    return true;
  }
  
  public boolean isHidden()
  {
    if (this.mUri.getPath().isEmpty()) {
      return false;
    }
    return getName().startsWith(".");
  }
  
  public long lastModified()
  {
    Object localObject = resolve();
    if (!((FileSystemManager.Resolution)localObject).valid()) {}
    do
    {
      return 0L;
      localObject = ((FileSystemManager.Resolution)localObject).fileSystem.stat(((FileSystemManager.Resolution)localObject).path);
    } while (localObject == null);
    return ((FileSystem.FileEntry)localObject).modifiedTime;
  }
  
  public long length()
  {
    Object localObject = resolve();
    if (!((FileSystemManager.Resolution)localObject).valid()) {}
    do
    {
      return 0L;
      localObject = ((FileSystemManager.Resolution)localObject).fileSystem.stat(((FileSystemManager.Resolution)localObject).path);
    } while (localObject == null);
    return ((FileSystem.FileEntry)localObject).size;
  }
  
  public String[] list()
  {
    Object localObject1 = resolve();
    if (!((FileSystemManager.Resolution)localObject1).valid()) {}
    do
    {
      return null;
      localObject2 = ((FileSystemManager.Resolution)localObject1).fileSystem.list(((FileSystemManager.Resolution)localObject1).path, false);
    } while (localObject2 == null);
    localObject1 = new ArrayList();
    Object localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add(((FileSystem.FileEntry)((Iterator)localObject2).next()).name);
    }
    return (String[])((ArrayList)localObject1).toArray(new String[0]);
  }
  
  public String[] list(VFSFilenameFilter paramVFSFilenameFilter)
  {
    Iterator localIterator = null;
    if (paramVFSFilenameFilter == null) {
      localObject1 = list();
    }
    Object localObject2;
    do
    {
      do
      {
        return localObject1;
        localObject2 = resolve();
        localObject1 = localIterator;
      } while (!((FileSystemManager.Resolution)localObject2).valid());
      localObject2 = ((FileSystemManager.Resolution)localObject2).fileSystem.list(((FileSystemManager.Resolution)localObject2).path, false);
      localObject1 = localIterator;
    } while (localObject2 == null);
    Object localObject1 = new ArrayList();
    localIterator = ((Iterable)localObject2).iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (FileSystem.FileEntry)localIterator.next();
      if (paramVFSFilenameFilter.accept(this, ((FileSystem.FileEntry)localObject2).name)) {
        ((ArrayList)localObject1).add(((FileSystem.FileEntry)localObject2).name);
      }
    }
    return (String[])((ArrayList)localObject1).toArray(new String[0]);
  }
  
  public VFSFile[] listFiles()
  {
    Object localObject1 = resolve();
    if (!((FileSystemManager.Resolution)localObject1).valid()) {}
    do
    {
      return null;
      localObject2 = ((FileSystemManager.Resolution)localObject1).fileSystem.list(((FileSystemManager.Resolution)localObject1).path, false);
    } while (localObject2 == null);
    localObject1 = new ArrayList();
    Object localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add(new VFSFile(this, ((FileSystem.FileEntry)((Iterator)localObject2).next()).name));
    }
    return (VFSFile[])((ArrayList)localObject1).toArray(new VFSFile[0]);
  }
  
  public VFSFile[] listFiles(VFSFileFilter paramVFSFileFilter)
  {
    Iterator localIterator = null;
    if (paramVFSFileFilter == null) {
      localObject1 = listFiles();
    }
    Object localObject2;
    do
    {
      do
      {
        return localObject1;
        localObject2 = resolve();
        localObject1 = localIterator;
      } while (!((FileSystemManager.Resolution)localObject2).valid());
      localObject2 = ((FileSystemManager.Resolution)localObject2).fileSystem.list(((FileSystemManager.Resolution)localObject2).path, false);
      localObject1 = localIterator;
    } while (localObject2 == null);
    Object localObject1 = new ArrayList();
    localIterator = ((Iterable)localObject2).iterator();
    while (localIterator.hasNext())
    {
      localObject2 = new VFSFile(this, ((FileSystem.FileEntry)localIterator.next()).name);
      if (paramVFSFileFilter.accept((VFSFile)localObject2)) {
        ((ArrayList)localObject1).add(localObject2);
      }
    }
    return (VFSFile[])((ArrayList)localObject1).toArray(new VFSFile[0]);
  }
  
  public VFSFile[] listFiles(VFSFilenameFilter paramVFSFilenameFilter)
  {
    Iterator localIterator = null;
    if (paramVFSFilenameFilter == null) {
      localObject1 = listFiles();
    }
    Object localObject2;
    do
    {
      do
      {
        return localObject1;
        localObject2 = resolve();
        localObject1 = localIterator;
      } while (!((FileSystemManager.Resolution)localObject2).valid());
      localObject2 = ((FileSystemManager.Resolution)localObject2).fileSystem.list(((FileSystemManager.Resolution)localObject2).path, false);
      localObject1 = localIterator;
    } while (localObject2 == null);
    Object localObject1 = new ArrayList();
    localIterator = ((Iterable)localObject2).iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (FileSystem.FileEntry)localIterator.next();
      if (paramVFSFilenameFilter.accept(this, ((FileSystem.FileEntry)localObject2).name)) {
        ((ArrayList)localObject1).add(new VFSFile(this, ((FileSystem.FileEntry)localObject2).name));
      }
    }
    return (VFSFile[])((ArrayList)localObject1).toArray(new VFSFile[0]);
  }
  
  public boolean mkdir()
  {
    return mkdirs();
  }
  
  public boolean mkdirs()
  {
    FileSystemManager.Resolution localResolution = resolve();
    if (!localResolution.valid()) {
      return false;
    }
    return localResolution.fileSystem.mkdirs(localResolution.path);
  }
  
  public boolean renameTo(VFSFile paramVFSFile)
  {
    FileSystemManager.Resolution localResolution = resolve();
    paramVFSFile = paramVFSFile.resolve();
    if ((!localResolution.valid()) || (!paramVFSFile.valid())) {
      return false;
    }
    try
    {
      paramVFSFile.fileSystem.moveFile(paramVFSFile.path, localResolution.fileSystem, localResolution.path);
      return true;
    }
    catch (IOException paramVFSFile) {}
    return false;
  }
  
  FileSystemManager.Resolution resolve()
  {
    this.mResolved = FileSystemManager.instance().resolve(this.mUri, this.mResolved);
    return this.mResolved;
  }
  
  public String toString()
  {
    return getPath();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mm.vfs.VFSFile
 * JD-Core Version:    0.7.0.1
 */