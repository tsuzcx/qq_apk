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
import com.tencent.tavcut.session.TAVCutImageSession;
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
    if (this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorLoadingView != null) {
      ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.20.1(this, paramAIFilterResult));
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[AICost] ae editor ai cost: ");
    ((StringBuilder)localObject1).append(System.currentTimeMillis() - AEEditorImageEditFragment.a(this.a));
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
    if (AEEditorImageEditFragment.a(this.a) == null) {
      return;
    }
    if (paramAIFilterResult == null) {
      return;
    }
    AEEditorImageEditFragment.a(this.a).a((String)AEEditorImageEditFragment.a(this.a).get(AEEditorImageEditFragment.a(this.a)), paramAIFilterResult);
    AEEditorImageEditFragment.a(this.a).put(String.valueOf(AEEditorImageEditFragment.a(this.a)), this.a.a(paramAIFilterResult));
    localObject1 = (SingleImageAIFilterResult)paramAIFilterResult;
    if (localObject1 != null)
    {
      AEEditorImageEditFragment.a(this.a).a(AEEditorImageEditFragment.a(this.a), paramAIFilterResult);
      AEEditorImageEditFragment.a(this.a).resetAEKitModelForAI(AEEditorImageEditFragment.a(this.a), ((SingleImageAIFilterResult)localObject1).jdField_b_of_type_JavaLangString, ((SingleImageAIFilterResult)localObject1).jdField_a_of_type_Float, ((SingleImageAIFilterResult)localObject1).jdField_a_of_type_JavaUtilHashMap, (int)(((SingleImageAIFilterResult)localObject1).c * 100.0F), ((SingleImageAIFilterResult)localObject1).jdField_b_of_type_Float);
      this.a.a(new String[] { "智能滤镜label", ((SingleImageAIFilterResult)localObject1).jdField_a_of_type_JavaLangString, "智能滤镜errCode", String.valueOf(paramInt) });
      AEQCircleReport.a().a(QCircleConstants.KEY_AIPHOTOCONFIG, QCircleConstants.KEY_PIC, QCircleConstants.KEY_NETWORK, "0");
      Object localObject2 = NewEnhanceCategories.newEnhanceTypes.iterator();
      paramAIFilterResult = "none";
      while (((Iterator)localObject2).hasNext())
      {
        NewEnhanceCategories localNewEnhanceCategories = (NewEnhanceCategories)((Iterator)localObject2).next();
        if (localNewEnhanceCategories.serverLabel.equals(((SingleImageAIFilterResult)localObject1).jdField_a_of_type_JavaLangString)) {
          paramAIFilterResult = localNewEnhanceCategories.filterType;
        }
      }
      localObject1 = AEBaseReportParam.a().a().jdField_a_of_type_JavaUtilHashMap;
      paramInt = AEEditorImageEditFragment.a(this.a);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("effect_aieffect_");
      ((StringBuilder)localObject2).append(paramAIFilterResult);
      ((HashMap)localObject1).put(Integer.valueOf(paramInt), ((StringBuilder)localObject2).toString());
      AEBaseReportParam.a().a().b.put(Integer.valueOf(AEEditorImageEditFragment.a(this.a)), Float.valueOf(-1.0F));
      AEEditorImageEditFragment.a(this.a).a(AEEditorImageEditFragment.a(this.a), "effect_aieffect");
    }
  }
  
  public void s_()
  {
    if (this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorLoadingView != null) {
      this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorLoadingView.a();
    }
    QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, "资源下载中，请稍后再试", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorImageEditFragment.20
 * JD-Core Version:    0.7.0.1
 */