package com.tencent.mobileqq.activity.aio.photo;

import android.os.IInterface;
import com.tencent.mobileqq.pic.CompressInfo;

public abstract interface ICompressionCallBack
  extends IInterface
{
  public abstract void a(CompressInfo paramCompressInfo);
  
  public abstract void b(CompressInfo paramCompressInfo);
  
  public abstract void c(CompressInfo paramCompressInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack
 * JD-Core Version:    0.7.0.1
 */