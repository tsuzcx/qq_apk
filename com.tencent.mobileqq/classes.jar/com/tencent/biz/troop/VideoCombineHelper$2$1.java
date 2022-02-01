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
    if ((paramTask instanceof VideoCombineHelper.DownLoadTask)) {
      this.a.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Callback.a("", false, "download failed! msg = " + paramTask.d);
    }
    do
    {
      return;
      if ((paramTask instanceof VideoCombineHelper.CombineTask))
      {
        this.a.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Callback.a("", false, "combine failed! msg = " + paramTask.d);
        return;
      }
    } while (!(paramTask instanceof VideoCombineHelper.SendingTask));
    this.a.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Callback.a("", false, "sending failed! msg = " + paramTask.d);
  }
  
  public void b(VideoCombineHelper.Task paramTask)
  {
    if ((paramTask instanceof VideoCombineHelper.SendingTask))
    {
      paramTask = paramTask.a();
      this.a.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Callback.a(paramTask.e, true, "seding success");
      QLog.d(".troop.trace_video_combine", 2, "totalTime = " + (System.currentTimeMillis() - this.a.jdField_a_of_type_Long));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.VideoCombineHelper.2.1
 * JD-Core Version:    0.7.0.1
 */