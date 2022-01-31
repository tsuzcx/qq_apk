package com.tencent.mm.vfs;

import java.util.HashMap;
import java.util.TreeMap;

public final class FileSystemManager$Editor
{
  private boolean mClean = false;
  private final HashMap<String, String> mEnvVars = new HashMap();
  private final HashMap<String, FileSystem> mFileSystems = new HashMap();
  private final TreeMap<String, String> mMountPoints = new TreeMap();
  private FileSystem mRoot = null;
  private final HashMap<String, SchemeResolver> mSchemeResolvers = new HashMap();
  
  public FileSystemManager$Editor(FileSystemManager paramFileSystemManager) {}
  
  public Editor clear()
  {
    this.mFileSystems.clear();
    this.mMountPoints.clear();
    this.mEnvVars.clear();
    this.mRoot = null;
    this.mClean = true;
    return this;
  }
  
  public void commit()
  {
    commit(FileSystemManager.access$500(this.this$0));
  }
  
  public void commit(boolean paramBoolean)
  {
    FileSystemManager.access$600(this.this$0, this, paramBoolean);
    this.mFileSystems.clear();
    this.mMountPoints.clear();
    this.mEnvVars.clear();
    this.mClean = false;
  }
  
  public Editor install(String paramString, FileSystem paramFileSystem)
  {
    this.mFileSystems.put(paramString, paramFileSystem);
    return this;
  }
  
  public Editor mount(String paramString1, String paramString2)
  {
    paramString1 = VFSUtils.normalizePath(paramString1, true, false);
    this.mMountPoints.put(paramString1, paramString2);
    return this;
  }
  
  public Editor root(FileSystem paramFileSystem)
  {
    this.mRoot = paramFileSystem;
    return this;
  }
  
  public Editor scheme(String paramString, SchemeResolver paramSchemeResolver)
  {
    this.mSchemeResolvers.put(paramString, paramSchemeResolver);
    return this;
  }
  
  public Editor setEnv(String paramString1, String paramString2)
  {
    this.mEnvVars.put(paramString1, paramString2);
    return this;
  }
  
  public Editor uninstall(String paramString)
  {
    this.mFileSystems.put(paramString, null);
    return this;
  }
  
  public Editor unmount(String paramString)
  {
    paramString = VFSUtils.normalizePath(paramString, true, false);
    this.mMountPoints.put(paramString, null);
    return this;
  }
  
  public Editor unsetEnv(String paramString)
  {
    this.mEnvVars.put(paramString, null);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mm.vfs.FileSystemManager.Editor
 * JD-Core Version:    0.7.0.1
 */