package com.tencent.aelight.camera.ae.camera.ui.dashboard;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.aelight.camera.ae.AEViewModelProviders;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import mqq.os.MqqHandler;

class AEVideoStoryDashboardPart$5
  implements INetEngineListener
{
  AEVideoStoryDashboardPart$5(AEVideoStoryDashboardPart paramAEVideoStoryDashboardPart, String paramString1, String paramString2, String paramString3) {}
  
  public void onResp(NetResp paramNetResp)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("downLoadMaterial---result=");
    ((StringBuilder)localObject).append(paramNetResp.mResult);
    ((StringBuilder)localObject).append(", url=");
    ((StringBuilder)localObject).append(this.a);
    AEQLog.a("AEVideoStoryDashboardPart", ((StringBuilder)localObject).toString());
    if (paramNetResp.mResult == 0)
    {
      int i = ZipUtils.unZipFolder(this.b, this.c);
      localObject = this.c;
      paramNetResp = (NetResp)localObject;
      if (i == 0) {
        paramNetResp = this.d.a((String)localObject);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downLoadMaterial---realMaterialFolder=");
      ((StringBuilder)localObject).append(paramNetResp);
      AEQLog.a("AEVideoStoryDashboardPart", ((StringBuilder)localObject).toString());
      ((AEVideoStoryDashboardPart.DashBoardVM)AEViewModelProviders.a(AEVideoStoryDashboardPart.d(this.d)).get(AEVideoStoryDashboardPart.DashBoardVM.class)).a.postValue(paramNetResp);
      ThreadManager.getUIHandler().post(new AEVideoStoryDashboardPart.5.1(this));
      return;
    }
    ThreadManager.getUIHandler().post(new AEVideoStoryDashboardPart.5.2(this));
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.5
 * JD-Core Version:    0.7.0.1
 */