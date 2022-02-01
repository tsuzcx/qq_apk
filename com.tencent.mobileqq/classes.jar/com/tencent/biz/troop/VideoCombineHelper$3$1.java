package com.tencent.biz.troop;

import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class VideoCombineHelper$3$1
  extends VideoCombineHelper.TaskListener
{
  VideoCombineHelper$3$1(VideoCombineHelper.3 param3)
  {
    super(param3.this$0);
  }
  
  public void a(VideoCombineHelper.Task paramTask)
  {
    synchronized (this.a.this$0.f)
    {
      this.a.this$0.g.remove(paramTask.g);
      StringBuilder localStringBuilder;
      if ((paramTask instanceof VideoCombineHelper.DownLoadTask))
      {
        ??? = this.a.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("download failed! msg = ");
        localStringBuilder.append(paramTask.i);
        ((VideoCombineHelper.Callback)???).a("", false, localStringBuilder.toString());
        return;
      }
      if ((paramTask instanceof VideoCombineHelper.CombineTask))
      {
        ??? = this.a.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("combine failed! msg = ");
        localStringBuilder.append(paramTask.i);
        ((VideoCombineHelper.Callback)???).a("", false, localStringBuilder.toString());
        return;
      }
      if ((paramTask instanceof VideoCombineHelper.SendingTask))
      {
        ??? = this.a.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("sending failed! msg = ");
        localStringBuilder.append(paramTask.i);
        ((VideoCombineHelper.Callback)???).a("", false, localStringBuilder.toString());
      }
      return;
    }
  }
  
  public void b(VideoCombineHelper.Task paramTask)
  {
    VideoCombineHelper.CombineParams localCombineParams = paramTask.c();
    if (((paramTask instanceof VideoCombineHelper.CombineTask)) || (localCombineParams.b)) {}
    synchronized (this.a.this$0.f)
    {
      this.a.this$0.g.remove(paramTask.g);
      this.a.a.a(localCombineParams.j, true, "seding success");
      paramTask = new StringBuilder();
      paramTask.append("totalTime = ");
      paramTask.append(System.currentTimeMillis() - this.a.b);
      QLog.d(".troop.trace_video_combine", 2, paramTask.toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.VideoCombineHelper.3.1
 * JD-Core Version:    0.7.0.1
 */