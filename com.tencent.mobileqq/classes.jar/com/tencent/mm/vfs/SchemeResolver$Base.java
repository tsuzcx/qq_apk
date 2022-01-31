package com.tencent.mm.vfs;

import android.net.Uri;
import android.os.Parcel;
import java.util.Map;

public abstract class SchemeResolver$Base
  implements SchemeResolver
{
  public void configure(Map<String, String> paramMap) {}
  
  public int describeContents()
  {
    return 0;
  }
  
  public Uri exportUri(SchemeResolver.ResolverContext paramResolverContext, Uri paramUri)
  {
    Uri localUri = paramUri;
    if (resolve(paramResolverContext, paramUri) == null) {
      localUri = null;
    }
    return localUri;
  }
  
  public void maintain(CancellationSignalCompat paramCancellationSignalCompat) {}
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mm.vfs.SchemeResolver.Base
 * JD-Core Version:    0.7.0.1
 */