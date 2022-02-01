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
    if (paramUri != null)
    {
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
      return;
    }
    throw new NullPointerException("uri == null");
  }
  
  public VFSFile(Uri paramUri, String paramString)
  {
    if (paramString != null)
    {
      if (paramUri == null)
      {
        paramUri = new Uri.Builder().path(paramString);
      }
      else
      {
        localObject = paramUri.buildUpon();
        paramUri = (Uri)localObject;
        if (!paramString.isEmpty())
        {
          ((Uri.Builder)localObject).appendPath(paramString);
          paramUri = (Uri)localObject;
        }
      }
      Object localObject = paramUri.build();
      String str = ((Uri)localObject).getPath();
      paramString = (String)localObject;
      if (str != null)
      {
        str = VFSUtils.normalizePath(str, false, false);
        paramString = (String)localObject;
        if (!((Uri)localObject).getPath().equals(str)) {
          paramString = paramUri.path(str).build();
        }
      }
      this.mUri = paramString;
      return;
    }
    throw new NullPointerException("name == null");
  }
  
  public VFSFile(VFSFile paramVFSFile, String paramString)
  {
    this(paramVFSFile, paramString);
  }
  
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
    if (!str2.isEmpty())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str1);
      localStringBuilder.append('/');
      localStringBuilder.append(str2);
      str1 = localStringBuilder.toString();
    }
    return this.mUri.buildUpon().path(str1).build();
  }
  
  public boolean canExecute()
  {
    Object localObject = resolve();
    boolean bool1 = ((FileSystemManager.Resolution)localObject).valid();
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    FileSystem localFileSystem = ((FileSystemManager.Resolution)localObject).fileSystem;
    if ((localFileSystem.capabilityFlags() & 0x2) == 0) {
      return false;
    }
    localObject = localFileSystem.realPath(((FileSystemManager.Resolution)localObject).path, false);
    bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (new File((String)localObject).canExecute()) {
        bool1 = true;
      }
    }
    return bool1;
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
    if (!localResolution.valid()) {
      return false;
    }
    FileSystem localFileSystem = localResolution.fileSystem;
    if ((localFileSystem.capabilityFlags() & 0x1) == 0) {
      return false;
    }
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
    Object localObject = resolve();
    if (((FileSystemManager.Resolution)localObject).valid())
    {
      if (((FileSystemManager.Resolution)localObject).fileSystem.exists(((FileSystemManager.Resolution)localObject).path)) {
        return false;
      }
      ((FileSystemManager.Resolution)localObject).fileSystem.openWrite(((FileSystemManager.Resolution)localObject).path, false).close();
      return true;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Cannot resolve path or URI: ");
    ((StringBuilder)localObject).append(this.mUri);
    throw new FileNotFoundException(((StringBuilder)localObject).toString());
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
    if ((j != -1) && (str.charAt(i - 1) != '/'))
    {
      if ((str.indexOf('/') == j) && (str.charAt(0) == '/')) {
        str = str.substring(0, j + 1);
      } else {
        str = str.substring(0, j);
      }
      return this.mUri.buildUpon().path(str).build();
    }
    return null;
  }
  
  public String getPath()
  {
    return VFSUtils.uriToString(this.mUri);
  }
  
  public long getTotalSpace()
  {
    Object localObject = resolve();
    if (!((FileSystemManager.Resolution)localObject).valid()) {
      return 0L;
    }
    localObject = ((FileSystemManager.Resolution)localObject).fileSystem.fileSystemStat(((FileSystemManager.Resolution)localObject).path);
    if (localObject == null) {
      return 0L;
    }
    return ((FileSystem.FsStat)localObject).totalSpace;
  }
  
  public Uri getUri()
  {
    return this.mUri;
  }
  
  public long getUsableSpace()
  {
    Object localObject = resolve();
    if (!((FileSystemManager.Resolution)localObject).valid()) {
      return 0L;
    }
    localObject = ((FileSystemManager.Resolution)localObject).fileSystem.fileSystemStat(((FileSystemManager.Resolution)localObject).path);
    if (localObject == null) {
      return 0L;
    }
    return ((FileSystem.FsStat)localObject).availableSpace;
  }
  
  public int hashCode()
  {
    return getPath().hashCode() ^ 0x12D591;
  }
  
  public boolean isAbsolute()
  {
    String str = this.mUri.getPath();
    boolean bool1 = this.mUri.isAbsolute();
    boolean bool2 = false;
    if (!bool1)
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
    FileSystemManager.Resolution localResolution = resolve();
    if (!localResolution.valid()) {
      return false;
    }
    return new File(localResolution.fileSystem.realPath(localResolution.path, false)).isDirectory();
  }
  
  public boolean isFile()
  {
    FileSystemManager.Resolution localResolution = resolve();
    if (!localResolution.valid()) {
      return false;
    }
    return new File(localResolution.fileSystem.realPath(localResolution.path, false)).isFile();
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
    if (!((FileSystemManager.Resolution)localObject).valid()) {
      return 0L;
    }
    localObject = ((FileSystemManager.Resolution)localObject).fileSystem.stat(((FileSystemManager.Resolution)localObject).path);
    if (localObject == null) {
      return 0L;
    }
    return ((FileSystem.FileEntry)localObject).modifiedTime;
  }
  
  public long length()
  {
    FileSystemManager.Resolution localResolution = resolve();
    if (!localResolution.valid()) {
      return 0L;
    }
    return new File(localResolution.fileSystem.realPath(localResolution.path, false)).length();
  }
  
  public String[] list()
  {
    Object localObject1 = resolve();
    if (!((FileSystemManager.Resolution)localObject1).valid()) {
      return null;
    }
    Object localObject2 = ((FileSystemManager.Resolution)localObject1).fileSystem.list(((FileSystemManager.Resolution)localObject1).path, false);
    if (localObject2 == null) {
      return null;
    }
    localObject1 = new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add(((FileSystem.FileEntry)((Iterator)localObject2).next()).name);
    }
    return (String[])((ArrayList)localObject1).toArray(new String[0]);
  }
  
  public String[] list(VFSFilenameFilter paramVFSFilenameFilter)
  {
    if (paramVFSFilenameFilter == null) {
      return list();
    }
    Object localObject1 = resolve();
    if (!((FileSystemManager.Resolution)localObject1).valid()) {
      return null;
    }
    Object localObject2 = ((FileSystemManager.Resolution)localObject1).fileSystem.list(((FileSystemManager.Resolution)localObject1).path, false);
    if (localObject2 == null) {
      return null;
    }
    localObject1 = new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      FileSystem.FileEntry localFileEntry = (FileSystem.FileEntry)((Iterator)localObject2).next();
      if (paramVFSFilenameFilter.accept(this, localFileEntry.name)) {
        ((ArrayList)localObject1).add(localFileEntry.name);
      }
    }
    return (String[])((ArrayList)localObject1).toArray(new String[0]);
  }
  
  public VFSFile[] listFiles()
  {
    Object localObject1 = resolve();
    if (!((FileSystemManager.Resolution)localObject1).valid()) {
      return null;
    }
    Object localObject2 = ((FileSystemManager.Resolution)localObject1).fileSystem.list(((FileSystemManager.Resolution)localObject1).path, false);
    if (localObject2 == null) {
      return null;
    }
    localObject1 = new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add(new VFSFile(this, ((FileSystem.FileEntry)((Iterator)localObject2).next()).name));
    }
    return (VFSFile[])((ArrayList)localObject1).toArray(new VFSFile[0]);
  }
  
  public VFSFile[] listFiles(VFSFileFilter paramVFSFileFilter)
  {
    if (paramVFSFileFilter == null) {
      return listFiles();
    }
    Object localObject1 = resolve();
    if (!((FileSystemManager.Resolution)localObject1).valid()) {
      return null;
    }
    Object localObject2 = ((FileSystemManager.Resolution)localObject1).fileSystem.list(((FileSystemManager.Resolution)localObject1).path, false);
    if (localObject2 == null) {
      return null;
    }
    localObject1 = new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      VFSFile localVFSFile = new VFSFile(this, ((FileSystem.FileEntry)((Iterator)localObject2).next()).name);
      if (paramVFSFileFilter.accept(localVFSFile)) {
        ((ArrayList)localObject1).add(localVFSFile);
      }
    }
    return (VFSFile[])((ArrayList)localObject1).toArray(new VFSFile[0]);
  }
  
  public VFSFile[] listFiles(VFSFilenameFilter paramVFSFilenameFilter)
  {
    if (paramVFSFilenameFilter == null) {
      return listFiles();
    }
    Object localObject1 = resolve();
    if (!((FileSystemManager.Resolution)localObject1).valid()) {
      return null;
    }
    Object localObject2 = ((FileSystemManager.Resolution)localObject1).fileSystem.list(((FileSystemManager.Resolution)localObject1).path, false);
    if (localObject2 == null) {
      return null;
    }
    localObject1 = new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      FileSystem.FileEntry localFileEntry = (FileSystem.FileEntry)((Iterator)localObject2).next();
      if (paramVFSFilenameFilter.accept(this, localFileEntry.name)) {
        ((ArrayList)localObject1).add(new VFSFile(this, localFileEntry.name));
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
    if (localResolution.valid()) {
      if (!paramVFSFile.valid()) {
        return false;
      }
    }
    try
    {
      paramVFSFile.fileSystem.moveFile(paramVFSFile.path, localResolution.fileSystem, localResolution.path);
      return true;
    }
    catch (IOException paramVFSFile) {}
    return false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.vfs.VFSFile
 * JD-Core Version:    0.7.0.1
 */