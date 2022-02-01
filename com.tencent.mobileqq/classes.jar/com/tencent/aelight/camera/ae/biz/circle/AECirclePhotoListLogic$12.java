package com.tencent.aelight.camera.ae.biz.circle;

import android.os.Bundle;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class AECirclePhotoListLogic$12
  implements Runnable
{
  AECirclePhotoListLogic$12(AECirclePhotoListLogic paramAECirclePhotoListLogic, ArrayList paramArrayList1, ArrayList paramArrayList2, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("serialCompressVideos---begin, need compress count=");
    localStringBuilder.append(this.a.size());
    AEQLog.b("AECirclePhotoListLogic", localStringBuilder.toString());
    AECirclePhotoListLogic.b(this.this$0, false);
    AECirclePhotoListLogic.a(this.this$0, this.a);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("serialCompressVideos---end, canceled=");
    localStringBuilder.append(AECirclePhotoListLogic.d(this.this$0));
    AEQLog.b("AECirclePhotoListLogic", localStringBuilder.toString());
    if ((!AECirclePhotoListLogic.d(this.this$0)) && (!AECirclePhotoListLogic.e(this.this$0))) {
      ThreadManager.getUIHandler().post(new AECirclePhotoListLogic.12.1(this));
    } else {
      ThreadManager.getUIHandler().post(new AECirclePhotoListLogic.12.2(this));
    }
    AECirclePhotoListLogic.a(this.this$0, false);
    AECirclePhotoListLogic.b(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoListLogic.12
 * JD-Core Version:    0.7.0.1
 */