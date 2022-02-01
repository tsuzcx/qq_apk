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
    do
    {
      synchronized (this.a.this$0.jdField_a_of_type_JavaLangObject)
      {
        this.a.this$0.jdField_a_of_type_JavaUtilHashMap.remove(paramTask.c);
        if ((paramTask instanceof VideoCombineHelper.DownLoadTask))
        {
          this.a.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Callback.a("", false, "download failed! msg = " + paramTask.d);
          return;
        }
      }
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
    VideoCombineHelper.CombineParams localCombineParams = paramTask.a();
    if (((paramTask instanceof VideoCombineHelper.CombineTask)) || (localCombineParams.b)) {}
    synchronized (this.a.this$0.jdField_a_of_type_JavaLangObject)
    {
      this.a.this$0.jdField_a_of_type_JavaUtilHashMap.remove(paramTask.c);
      this.a.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Callback.a(localCombineParams.e, true, "seding success");
      QLog.d(".troop.trace_video_combine", 2, "totalTime = " + (System.currentTimeMillis() - this.a.jdField_a_of_type_Long));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.VideoCombineHelper.3.1
 * JD-Core Version:    0.7.0.1
 */