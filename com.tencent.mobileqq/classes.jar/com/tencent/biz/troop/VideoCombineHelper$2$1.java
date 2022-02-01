package com.tencent.biz.troop;

import com.tencent.qphone.base.util.QLog;

class VideoCombineHelper$2$1
  extends VideoCombineHelper.TaskListener
{
  VideoCombineHelper$2$1(VideoCombineHelper.2 param2)
  {
    super(param2.this$0);
  }
  
  public void a(VideoCombineHelper.Task paramTask)
  {
    VideoCombineHelper.Callback localCallback;
    StringBuilder localStringBuilder;
    if ((paramTask instanceof VideoCombineHelper.DownLoadTask))
    {
      localCallback = this.a.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("download failed! msg = ");
      localStringBuilder.append(paramTask.i);
      localCallback.a("", false, localStringBuilder.toString());
      return;
    }
    if ((paramTask instanceof VideoCombineHelper.CombineTask))
    {
      localCallback = this.a.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("combine failed! msg = ");
      localStringBuilder.append(paramTask.i);
      localCallback.a("", false, localStringBuilder.toString());
      return;
    }
    if ((paramTask instanceof VideoCombineHelper.SendingTask))
    {
      localCallback = this.a.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("sending failed! msg = ");
      localStringBuilder.append(paramTask.i);
      localCallback.a("", false, localStringBuilder.toString());
    }
  }
  
  public void b(VideoCombineHelper.Task paramTask)
  {
    if ((paramTask instanceof VideoCombineHelper.SendingTask))
    {
      paramTask = paramTask.c();
      this.a.a.a(paramTask.j, true, "seding success");
      paramTask = new StringBuilder();
      paramTask.append("totalTime = ");
      paramTask.append(System.currentTimeMillis() - this.a.b);
      QLog.d(".troop.trace_video_combine", 2, paramTask.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.VideoCombineHelper.2.1
 * JD-Core Version:    0.7.0.1
 */