package com.tencent.mobileqq.activity.aio.photo;

import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoResult;
import com.tencent.mobileqq.shortvideo.UiCallBack.DownAdapter;

class AIOImageProviderService$3
  extends UiCallBack.DownAdapter
{
  AIOImageProviderService$3(AIOImageProviderService paramAIOImageProviderService, long paramLong, int paramInt1, int paramInt2) {}
  
  public void a(int paramInt)
  {
    IAIOImageProviderCallBack localIAIOImageProviderCallBack = this.d.y;
    if (localIAIOImageProviderCallBack != null) {
      localIAIOImageProviderCallBack.a(this.a, this.b, this.c, paramInt, 0L, true);
    }
  }
  
  public void a(int paramInt, ShortVideoResult paramShortVideoResult)
  {
    IAIOImageProviderCallBack localIAIOImageProviderCallBack = this.d.y;
    if (paramShortVideoResult.a == 0)
    {
      paramShortVideoResult = (DownCallBack.DownResult)paramShortVideoResult.d;
      if (localIAIOImageProviderCallBack != null) {
        localIAIOImageProviderCallBack.a(this.a, this.b, this.c, 1, paramShortVideoResult.e, false);
      }
      this.d.a(this.a, this.b, this.c, paramShortVideoResult.e);
      return;
    }
    if (localIAIOImageProviderCallBack != null)
    {
      long l = this.a;
      paramInt = this.b;
      int i = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("step:");
      localStringBuilder.append(paramShortVideoResult.b.a);
      localStringBuilder.append(", desc:");
      localStringBuilder.append(paramShortVideoResult.b.b);
      localIAIOImageProviderCallBack.a(l, paramInt, i, 2, localStringBuilder.toString(), false);
    }
    this.d.a(this.a, this.b, this.c, "I:E");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService.3
 * JD-Core Version:    0.7.0.1
 */