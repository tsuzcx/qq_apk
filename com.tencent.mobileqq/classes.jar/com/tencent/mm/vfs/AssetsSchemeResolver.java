package com.tencent.mm.vfs;

import android.net.Uri;
import android.util.Pair;

public final class AssetsSchemeResolver
  extends SchemeResolver.Base
{
  public static final AssetsSchemeResolver.SingletonCreator CREATOR = new AssetsSchemeResolver.SingletonCreator(null);
  private final AssetsSchemeResolver.AssetsFileSystem mFileSystem = new AssetsSchemeResolver.AssetsFileSystem(FileSystemManager.instance().getContext());
  
  public static AssetsSchemeResolver instance()
  {
    return AssetsSchemeResolver.SingletonCreator.INSTANCE;
  }
  
  public Pair<FileSystem, String> resolve(SchemeResolver.ResolverContext paramResolverContext, Uri paramUri)
  {
    paramResolverContext = paramUri.getPath();
    if (paramResolverContext == null) {}
    for (paramResolverContext = "";; paramResolverContext = VFSUtils.normalizePath(paramResolverContext, true, true)) {
      return new Pair(this.mFileSystem, paramResolverContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mm.vfs.AssetsSchemeResolver
 * JD-Core Version:    0.7.0.1
 */