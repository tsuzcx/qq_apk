package com.tencent.aelight.camera.ae.biz.circle;

import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class AECirclePhotoListLogic$12
  implements Runnable
{
  AECirclePhotoListLogic$12(AECirclePhotoListLogic paramAECirclePhotoListLogic, ArrayList paramArrayList1, ArrayList paramArrayList2, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("serialCompressVideos---begin, need compress count=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayList.size());
    AEQLog.b("AECirclePhotoListLogic", localStringBuilder.toString());
    AECirclePhotoListLogic.b(this.this$0, false);
    AECirclePhotoListLogic.a(this.this$0, this.jdField_a_of_type_JavaUtilArrayList);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("serialCompressVideos---end, canceled=");
    localStringBuilder.append(AECirclePhotoListLogic.a(this.this$0));
    AEQLog.b("AECirclePhotoListLogic", localStringBuilder.toString());
    if ((!AECirclePhotoListLogic.a(this.this$0)) && (!AECirclePhotoListLogic.b(this.this$0))) {
      ThreadManager.getUIHandler().post(new AECirclePhotoListLogic.12.1(this));
    } else {
      ThreadManager.getUIHandler().post(new AECirclePhotoListLogic.12.2(this));
    }
    AECirclePhotoListLogic.a(this.this$0, false);
    AECirclePhotoListLogic.b(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoListLogic.12
 * JD-Core Version:    0.7.0.1
 */