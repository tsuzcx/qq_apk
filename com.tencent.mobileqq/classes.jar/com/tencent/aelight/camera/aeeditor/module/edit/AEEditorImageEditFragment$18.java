package com.tencent.aelight.camera.aeeditor.module.edit;

import android.text.TextUtils;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.aeeditor.module.aifilter.ComicsFilterResult;
import com.tencent.aelight.camera.aeeditor.util.AEQCircleReport;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleConstants;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import java.util.Map;
import mqq.os.MqqHandler;

class AEEditorImageEditFragment$18
  implements INetEngineListener
{
  AEEditorImageEditFragment$18(AEEditorImageEditFragment paramAEEditorImageEditFragment, int paramInt1, MetaMaterial paramMetaMaterial, int paramInt2) {}
  
  public void onResp(NetResp paramNetResp)
  {
    AEEditorImageEditFragment.a(this.d, null);
    if (AEEditorImageEditFragment.f(this.d) == null) {
      return;
    }
    if (AEEditorImageEditFragment.s(this.d)) {
      return;
    }
    if (paramNetResp.mRespData != null)
    {
      paramNetResp = AEEditorImageEditFragment.a(this.d, this.a, paramNetResp.mRespData, paramNetResp.reqCost, this.b);
      if (!TextUtils.isEmpty(paramNetResp))
      {
        localObject1 = new ComicsFilterResult(paramNetResp);
        AEEditorImageEditFragment.t(this.d).put(AEEditorImageEditFragment.a(this.d, this.a, this.b), localObject1);
        localObject2 = AEQCircleReport.a();
        paramNetResp = this.b;
        if (paramNetResp != null) {
          paramNetResp = paramNetResp.id;
        } else {
          paramNetResp = "";
        }
        ((AEQCircleReport)localObject2).a(paramNetResp, "", QCircleConstants.A, "0");
        AEEditorImageEditFragment.a(this.d, this.a, (ComicsFilterResult)localObject1, this.c, this.b);
        return;
      }
      localObject1 = AEQCircleReport.a();
      paramNetResp = this.b;
      if (paramNetResp != null) {
        paramNetResp = paramNetResp.id;
      } else {
        paramNetResp = "";
      }
      ((AEQCircleReport)localObject1).a(paramNetResp, "", QCircleConstants.A, "-90000003");
      AEQLog.d("AEEditorImageEditFragment", "processComicResponse return path is empty");
      ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.18.1(this));
      return;
    }
    Object localObject2 = AEQCircleReport.a();
    Object localObject1 = this.b;
    if (localObject1 != null) {
      localObject1 = ((MetaMaterial)localObject1).id;
    } else {
      localObject1 = "";
    }
    ((AEQCircleReport)localObject2).a((String)localObject1, "", QCircleConstants.A, String.valueOf(paramNetResp.mErrCode));
    localObject1 = AEBaseDataReporter.a();
    int i = paramNetResp.mErrCode;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramNetResp.reqCost);
    ((StringBuilder)localObject2).append("");
    ((AEBaseDataReporter)localObject1).a(i, ((StringBuilder)localObject2).toString(), "lut_comics", -2);
    ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.18.2(this));
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorImageEditFragment.18
 * JD-Core Version:    0.7.0.1
 */