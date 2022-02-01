package com.tencent.aelight.camera.aeeditor.module.edit;

import com.tencent.aelight.camera.aeeditor.module.aifilter.AEEditorAIFilterManager.AIFilterObserver;
import com.tencent.aelight.camera.aeeditor.module.aifilter.AIFilterDataCache;
import com.tencent.aelight.camera.aeeditor.module.aifilter.AIFilterResult;
import com.tencent.aelight.camera.aeeditor.module.aifilter.BatchImageAIFilterResult;
import com.tencent.aelight.camera.aeeditor.module.aifilter.SingleImageAIFilterResult;
import com.tencent.aelight.camera.aeeditor.module.filter.ImageFilterInfoCache;
import com.tencent.aelight.camera.aeeditor.view.AEEditorLoadingView;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

class AEEditorImageEditFragment$21
  implements AEEditorAIFilterManager.AIFilterObserver
{
  AEEditorImageEditFragment$21(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void a(int paramInt, AIFilterResult paramAIFilterResult)
  {
    if (this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorLoadingView != null) {
      ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.21.1(this, paramAIFilterResult));
    }
    StringBuilder localStringBuilder1;
    if (paramInt == 0)
    {
      AEQLog.b("AEEditorImageEditFragment", "onAIFilterApplySuccess:");
    }
    else
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("onAIFilterAppliedFailed:");
      localStringBuilder1.append(paramInt);
      AEQLog.b("AEEditorImageEditFragment", localStringBuilder1.toString());
      ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.21.2(this));
    }
    ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.21.3(this));
    if (AEEditorImageEditFragment.a(this.a) == null) {
      return;
    }
    if (paramAIFilterResult == null) {
      return;
    }
    paramAIFilterResult = (BatchImageAIFilterResult)paramAIFilterResult;
    if (paramAIFilterResult != null)
    {
      localStringBuilder1 = new StringBuilder();
      paramInt = 0;
      while (paramInt < AEEditorImageEditFragment.b(this.a))
      {
        StringBuilder localStringBuilder2;
        if (paramInt == AEEditorImageEditFragment.a(this.a))
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(AEEditorImageEditFragment.a(this.a).a((String)AEEditorImageEditFragment.a(this.a).get(paramInt)).a());
          localStringBuilder2.append("(当前图)|");
          localStringBuilder1.append(localStringBuilder2.toString());
        }
        else if ((AEEditorImageEditFragment.a(this.a).a((String)AEEditorImageEditFragment.a(this.a).get(paramInt)) != null) && (((SingleImageAIFilterResult)paramAIFilterResult.a.get(paramInt)).a))
        {
          AEEditorImageEditFragment.a(this.a).a(paramInt, AEEditorImageEditFragment.a(this.a).a((String)AEEditorImageEditFragment.a(this.a).get(paramInt)));
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(AEEditorImageEditFragment.a(this.a).a((String)AEEditorImageEditFragment.a(this.a).get(paramInt)).a());
          localStringBuilder2.append("(err)|");
          localStringBuilder1.append(localStringBuilder2.toString());
        }
        else
        {
          AEEditorImageEditFragment.a(this.a).a((String)AEEditorImageEditFragment.a(this.a).get(paramInt), (AIFilterResult)paramAIFilterResult.a.get(paramInt));
          AEEditorImageEditFragment.a(this.a).put(String.valueOf(paramInt), this.a.a((AIFilterResult)paramAIFilterResult.a.get(paramInt)));
          AEEditorImageEditFragment.a(this.a).a(paramInt, (AIFilterResult)paramAIFilterResult.a.get(paramInt));
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(((SingleImageAIFilterResult)paramAIFilterResult.a.get(paramInt)).a());
          localStringBuilder2.append("|");
          localStringBuilder1.append(localStringBuilder2.toString());
        }
        paramInt += 1;
      }
      this.a.a("智能滤镜label", localStringBuilder1.toString());
    }
    paramAIFilterResult = this.a;
    AEEditorImageEditFragment.e(paramAIFilterResult, AEEditorImageEditFragment.a(paramAIFilterResult));
    paramAIFilterResult = this.a;
    AEEditorImageEditFragment.f(paramAIFilterResult, AEEditorImageEditFragment.a(paramAIFilterResult));
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
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorImageEditFragment.21
 * JD-Core Version:    0.7.0.1
 */