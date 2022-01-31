package com.tencent.biz.qqstory.takevideo.bitmap;

import android.graphics.Bitmap;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.utils.StackBlur;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

public class BlurJobSegment
  extends JobSegment
{
  public int a;
  
  public BlurJobSegment()
  {
    this.a = 10;
  }
  
  public BlurJobSegment(int paramInt)
  {
    this.a = paramInt;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    if (paramBitmap == null) {
      return null;
    }
    StackBlur.a(paramBitmap, paramInt);
    return paramBitmap;
  }
  
  protected void a(JobContext paramJobContext, Bitmap paramBitmap)
  {
    long l = System.currentTimeMillis();
    paramJobContext = a(paramBitmap, this.a, false);
    SLog.b("BlurJobSegment", "blur time = " + (System.currentTimeMillis() - l) + ", blur ratio = " + this.a);
    if (paramJobContext == null)
    {
      super.notifyError(new BitmapError("BlurJobSegment", 7));
      return;
    }
    super.notifyResult(paramJobContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.bitmap.BlurJobSegment
 * JD-Core Version:    0.7.0.1
 */