package com.tencent.biz.troop;

import com.tencent.qphone.base.util.QLog;
import java.io.File;

class VideoCombineHelper$CombineTask$1
  implements VideoCombineHelper.Callback
{
  VideoCombineHelper$CombineTask$1(VideoCombineHelper.CombineTask paramCombineTask, VideoCombineHelper.CombineParams paramCombineParams) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("combineVideos end! isSuccess:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" path = ");
      ((StringBuilder)localObject).append(paramString1);
      QLog.d(".troop.VideoCombineHelper", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new File(paramString1);
    if ((paramBoolean) && (((File)localObject).exists()))
    {
      if (this.a.a)
      {
        this.b.f.b(this.b);
        return;
      }
      if (this.b.b != null)
      {
        l = System.currentTimeMillis();
        this.b.e.a(paramString1, this.b.b, new VideoCombineHelper.CombineTask.1.1(this, l));
        return;
      }
      long l = System.currentTimeMillis();
      paramString1 = this.b;
      paramString1.a((File)localObject, paramString1.c, new VideoCombineHelper.CombineTask.1.2(this, l));
      return;
    }
    paramString1 = this.b;
    paramString1.i = paramString2;
    paramString1.f.a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.VideoCombineHelper.CombineTask.1
 * JD-Core Version:    0.7.0.1
 */