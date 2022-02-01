package com.bumptech.glide.load.resource.bytes;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

public class BytesResource
  implements Resource<byte[]>
{
  private final byte[] a;
  
  public BytesResource(byte[] paramArrayOfByte)
  {
    this.a = ((byte[])Preconditions.a(paramArrayOfByte));
  }
  
  @NonNull
  public byte[] a()
  {
    return this.a;
  }
  
  @NonNull
  public Class<byte[]> c()
  {
    return [B.class;
  }
  
  public int e()
  {
    return this.a.length;
  }
  
  public void f() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.bytes.BytesResource
 * JD-Core Version:    0.7.0.1
 */