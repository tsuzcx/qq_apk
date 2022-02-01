package com.tencent.aelight.camera.ae.cmshow;

import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import mqq.os.MqqHandler;

class AECMShowRequestController$3
  implements INetEngineListener
{
  AECMShowRequestController$3(AECMShowRequestController paramAECMShowRequestController) {}
  
  public void onResp(NetResp paramNetResp)
  {
    AECMShowRequestController.a(this.a, null);
    if ((paramNetResp != null) && (paramNetResp.mRespData != null))
    {
      AEQLog.a("AECMShowRequestController", "[onResp] succeeded");
      AECMShowRequestController.a(this.a, paramNetResp);
      return;
    }
    AEQLog.a("AECMShowRequestController", "[onResp] failed");
    if (AECMShowRequestController.a(this.a) != null) {
      ThreadManager.getUIHandler().removeCallbacks(AECMShowRequestController.a(this.a));
    }
    if (AECMShowRequestController.a(this.a) != null) {
      AECMShowRequestController.a(this.a).a(2, null);
    }
    AEBaseDataReporter.a().a(paramNetResp.mErrCode, String.valueOf(paramNetResp.reqCost), "CartoonPta", -2);
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.cmshow.AECMShowRequestController.3
 * JD-Core Version:    0.7.0.1
 */