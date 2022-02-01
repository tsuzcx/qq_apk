package com.tencent.biz.troop;

import com.tencent.qphone.base.util.QLog;
import java.io.File;

class VideoCombineHelper$CombineTask$1$2
  implements VideoCombineHelper.Callback
{
  VideoCombineHelper$CombineTask$1$2(VideoCombineHelper.CombineTask.1 param1, long paramLong) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("combineWording end! isSuccess:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" path = ");
      ((StringBuilder)localObject).append(paramString1);
      QLog.d(".troop.VideoCombineHelper", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("combineWordingTime:");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - this.a);
      QLog.d(".troop.trace_video_combine", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new File(paramString1);
    if ((paramBoolean) && (((File)localObject).exists()))
    {
      this.b.a.j = paramString1;
      this.b.b.f.b(this.b.b);
      this.b.b.b();
      return;
    }
    this.b.b.i = paramString2;
    this.b.b.f.a(this.b.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.VideoCombineHelper.CombineTask.1.2
 * JD-Core Version:    0.7.0.1
 */