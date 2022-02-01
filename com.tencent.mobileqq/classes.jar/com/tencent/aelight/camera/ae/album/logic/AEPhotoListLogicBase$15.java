package com.tencent.aelight.camera.ae.album.logic;

import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class AEPhotoListLogicBase$15
  implements Runnable
{
  AEPhotoListLogicBase$15(AEPhotoListLogicBase paramAEPhotoListLogicBase, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("serialCompressVideos---begin, need compress count=");
    localStringBuilder.append(this.a.size());
    AEQLog.b("AEPhotoListLogicBase", localStringBuilder.toString());
    AEPhotoListLogicBase.b(this.this$0, false);
    AEPhotoListLogicBase.a(this.this$0, this.a);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("serialCompressVideos---end, canceled=");
    localStringBuilder.append(AEPhotoListLogicBase.i(this.this$0));
    AEQLog.b("AEPhotoListLogicBase", localStringBuilder.toString());
    if ((!AEPhotoListLogicBase.i(this.this$0)) && (!AEPhotoListLogicBase.j(this.this$0))) {
      ThreadManager.getUIHandler().post(new AEPhotoListLogicBase.15.1(this));
    } else {
      ThreadManager.getUIHandler().post(new AEPhotoListLogicBase.15.2(this));
    }
    AEPhotoListLogicBase.a(this.this$0, false);
    AEPhotoListLogicBase.b(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase.15
 * JD-Core Version:    0.7.0.1
 */