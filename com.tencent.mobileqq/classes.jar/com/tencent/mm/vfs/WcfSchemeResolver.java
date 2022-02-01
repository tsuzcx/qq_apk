package com.tencent.mm.vfs;

import android.net.Uri;
import android.util.Pair;
import java.util.Map;

public final class WcfSchemeResolver
  extends SchemeResolver.Base
{
  public static final WcfSchemeResolver.SingletonCreator CREATOR = new WcfSchemeResolver.SingletonCreator(null);
  
  public static WcfSchemeResolver instance()
  {
    return WcfSchemeResolver.SingletonCreator.INSTANCE;
  }
  
  public Pair<FileSystem, String> resolve(SchemeResolver.ResolverContext paramResolverContext, Uri paramUri)
  {
    FileSystem localFileSystem = (FileSystem)((ResolverState)paramResolverContext).mFileSystems.get(paramUri.getAuthority());
    paramResolverContext = paramUri.getPath();
    if (paramResolverContext == null) {
      paramResolverContext = "";
    } else {
      paramResolverContext = VFSUtils.normalizePath(paramResolverContext, true, true);
    }
    return new Pair(localFileSystem, paramResolverContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.vfs.WcfSchemeResolver
 * JD-Core Version:    0.7.0.1
 */