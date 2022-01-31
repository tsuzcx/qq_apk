package com.tencent.mm.vfs;

import android.net.Uri;
import android.os.Parcelable;
import android.util.Pair;
import java.util.Map;

public abstract interface SchemeResolver
  extends Parcelable
{
  public abstract void configure(Map<String, String> paramMap);
  
  public abstract Uri exportUri(SchemeResolver.ResolverContext paramResolverContext, Uri paramUri);
  
  public abstract void maintain(CancellationSignalCompat paramCancellationSignalCompat);
  
  public abstract Pair<FileSystem, String> resolve(SchemeResolver.ResolverContext paramResolverContext, Uri paramUri);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mm.vfs.SchemeResolver
 * JD-Core Version:    0.7.0.1
 */