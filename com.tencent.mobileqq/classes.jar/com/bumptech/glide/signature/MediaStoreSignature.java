package com.bumptech.glide.signature;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.Key;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public class MediaStoreSignature
  implements Key
{
  @NonNull
  private final String b;
  private final long c;
  private final int d;
  
  public void a(@NonNull MessageDigest paramMessageDigest)
  {
    paramMessageDigest.update(ByteBuffer.allocate(12).putLong(this.c).putInt(this.d).array());
    paramMessageDigest.update(this.b.getBytes(a));
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (MediaStoreSignature)paramObject;
      if (this.c != paramObject.c) {
        return false;
      }
      if (this.d != paramObject.d) {
        return false;
      }
      return this.b.equals(paramObject.b);
    }
    return false;
  }
  
  public int hashCode()
  {
    int i = this.b.hashCode();
    long l = this.c;
    return (i * 31 + (int)(l ^ l >>> 32)) * 31 + this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.signature.MediaStoreSignature
 * JD-Core Version:    0.7.0.1
 */