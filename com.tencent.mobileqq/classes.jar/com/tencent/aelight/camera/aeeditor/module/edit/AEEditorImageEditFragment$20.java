package com.tencent.aelight.camera.aeeditor.module.edit;

import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.report.AEEditReportData;
import com.tencent.aelight.camera.aeeditor.module.aifilter.AEEditorAIFilterManager.AIFilterObserver;
import com.tencent.aelight.camera.aeeditor.module.aifilter.AIFilterDataCache;
import com.tencent.aelight.camera.aeeditor.module.aifilter.AIFilterResult;
import com.tencent.aelight.camera.aeeditor.module.aifilter.SingleImageAIFilterResult;
import com.tencent.aelight.camera.aeeditor.module.filter.ImageFilterInfoCache;
import com.tencent.aelight.camera.aeeditor.util.AEQCircleReport;
import com.tencent.aelight.camera.aeeditor.view.AEEditorLoadingView;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleConstants;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qcircle.tavcut.session.TAVCutImageSession;
import com.tencent.ttpic.filter.aifilter.NewEnhanceCategories;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

class AEEditorImageEditFragment$20
  implements AEEditorAIFilterManager.AIFilterObserver
{
  AEEditorImageEditFragment$20(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void a(int paramInt, AIFilterResult paramAIFilterResult)
  {
    if (this.a.j != null) {
      ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.20.1(this, paramAIFilterResult));
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[AICost] ae editor ai cost: ");
    ((StringBuilder)localObject1).append(System.currentTimeMillis() - AEEditorImageEditFragment.v(this.a));
    AEQLog.a("AEEditorImageEditFragment", ((StringBuilder)localObject1).toString());
    if (paramInt == 0)
    {
      AEQLog.b("AEEditorImageEditFragment", "onAIFilterApplySuccess");
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onAIFilterAppliedFailed:");
      ((StringBuilder)localObject1).append(paramInt);
      AEQLog.b("AEEditorImageEditFragment", ((StringBuilder)localObject1).toString());
      ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.20.2(this));
    }
    ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.20.3(this));
    if (AEEditorImageEditFragment.f(this.a) == null) {
      return;
    }
    if (paramAIFilterResult == null) {
      return;
    }
    AEEditorImageEditFragment.w(this.a).a((String)AEEditorImageEditFragment.r(this.a).get(AEEditorImageEditFragment.e(this.a)), paramAIFilterResult);
    AEEditorImageEditFragment.x(this.a).put(String.valueOf(AEEditorImageEditFragment.e(this.a)), this.a.a(paramAIFilterResult));
    localObject1 = (SingleImageAIFilterResult)paramAIFilterResult;
    if (localObject1 != null)
    {
      AEEditorImageEditFragment.u(this.a).a(AEEditorImageEditFragment.e(this.a), paramAIFilterResult);
      AEEditorImageEditFragment.f(this.a).resetAEKitModelForAI(AEEditorImageEditFragment.e(this.a), ((SingleImageAIFilterResult)localObject1).e, ((SingleImageAIFilterResult)localObject1).g, ((SingleImageAIFilterResult)localObject1).i, (int)(((SingleImageAIFilterResult)localObject1).j * 100.0F), ((SingleImageAIFilterResult)localObject1).h);
      this.a.a(new String[] { "智能滤镜label", ((SingleImageAIFilterResult)localObject1).d, "智能滤镜errCode", String.valueOf(paramInt) });
      AEQCircleReport.a().a(QCircleConstants.B, QCircleConstants.y, QCircleConstants.A, "0");
      Object localObject2 = NewEnhanceCategories.newEnhanceTypes.iterator();
      paramAIFilterResult = "none";
      while (((Iterator)localObject2).hasNext())
      {
        NewEnhanceCategories localNewEnhanceCategories = (NewEnhanceCategories)((Iterator)localObject2).next();
        if (localNewEnhanceCategories.serverLabel.equals(((SingleImageAIFilterResult)localObject1).d)) {
          paramAIFilterResult = localNewEnhanceCategories.filterType;
        }
      }
      localObject1 = AEBaseReportParam.a().n().e;
      paramInt = AEEditorImageEditFragment.e(this.a);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("effect_aieffect_");
      ((StringBuilder)localObject2).append(paramAIFilterResult);
      ((HashMap)localObject1).put(Integer.valueOf(paramInt), ((StringBuilder)localObject2).toString());
      AEBaseReportParam.a().n().f.put(Integer.valueOf(AEEditorImageEditFragment.e(this.a)), Float.valueOf(-1.0F));
      AEEditorImageEditFragment.u(this.a).a(AEEditorImageEditFragment.e(this.a), "effect_aieffect");
    }
  }
  
  public void ar_()
  {
    if (this.a.j != null) {
      this.a.j.a();
    }
    QQToast.makeText(this.a.o, "资源下载中，请稍后再试", 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorImageEditFragment.20
 * JD-Core Version:    0.7.0.1
 */