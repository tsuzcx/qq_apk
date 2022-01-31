package com.tencent.mm.vfs;

import android.net.Uri;
import android.util.Pair;

public final class ContentsSchemeResolver
  extends SchemeResolver.Base
{
  public static final ContentsSchemeResolver.SingletonCreator CREATOR = new ContentsSchemeResolver.SingletonCreator(null);
  private final ContentsSchemeResolver.ContentProviderFileSystem mFileSystem = new ContentsSchemeResolver.ContentProviderFileSystem(FileSystemManager.instance().getContext());
  
  public static ContentsSchemeResolver instance()
  {
    return ContentsSchemeResolver.SingletonCreator.INSTANCE;
  }
  
  public Pair<FileSystem, String> resolve(SchemeResolver.ResolverContext paramResolverContext, Uri paramUri)
  {
    return new Pair(this.mFileSystem, paramUri.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.ContentsSchemeResolver
 * JD-Core Version:    0.7.0.1
 */