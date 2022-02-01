package com.tencent.mobileqq.activity.aio.photo;

import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.UiCallBack.DownAdapter;

class AIOImageProviderService$2
  extends UiCallBack.DownAdapter
{
  AIOImageProviderService$2(AIOImageProviderService paramAIOImageProviderService, long paramLong1, int paramInt1, int paramInt2, long paramLong2, String paramString) {}
  
  public void a(int paramInt, PicResult paramPicResult)
  {
    Object localObject = this.f.y;
    long l;
    int i;
    StringBuilder localStringBuilder;
    if (localObject != null) {
      if (paramPicResult.a == 0)
      {
        ((IAIOImageProviderCallBack)localObject).a(this.a, this.b, this.c, 1, this.e, paramPicResult.e);
        this.f.a(this.a, this.b, this.c, this.e);
      }
      else
      {
        l = this.a;
        paramInt = this.b;
        i = this.c;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("step:");
        localStringBuilder.append(paramPicResult.b.a);
        localStringBuilder.append(", desc:");
        localStringBuilder.append(paramPicResult.b.b);
        ((IAIOImageProviderCallBack)localObject).a(l, paramInt, i, 2, localStringBuilder.toString(), paramPicResult.e);
        this.f.a(this.a, this.b, this.c, "I:E");
      }
    }
    localObject = this.f.u;
    if (localObject != null)
    {
      if (paramPicResult.a == 0)
      {
        ((AIOImageProviderService.AIOImageProviderListener)localObject).a(this.a, this.b, this.c, 1, this.e, paramPicResult.e);
        this.f.a(this.a, this.b, this.c, this.e);
        return;
      }
      l = this.a;
      paramInt = this.b;
      i = this.c;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("step:");
      localStringBuilder.append(paramPicResult.b.a);
      localStringBuilder.append(", desc:");
      localStringBuilder.append(paramPicResult.b.b);
      ((AIOImageProviderService.AIOImageProviderListener)localObject).a(l, paramInt, i, 2, localStringBuilder.toString(), paramPicResult.e);
      this.f.a(this.a, this.b, this.c, "I:E");
    }
  }
  
  public void a_(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.f.y;
    if (localObject != null) {
      ((IAIOImageProviderCallBack)localObject).a(this.a, this.b, this.c, paramInt, this.d, paramBoolean);
    }
    localObject = this.f.u;
    if (localObject != null) {
      ((AIOImageProviderService.AIOImageProviderListener)localObject).a(this.a, this.b, this.c, paramInt, this.d, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService.2
 * JD-Core Version:    0.7.0.1
 */