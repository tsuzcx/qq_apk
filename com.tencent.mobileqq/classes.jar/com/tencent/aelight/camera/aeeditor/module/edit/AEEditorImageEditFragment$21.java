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
    if (this.a.j != null) {
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
    if (AEEditorImageEditFragment.f(this.a) == null) {
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
      while (paramInt < AEEditorImageEditFragment.y(this.a))
      {
        StringBuilder localStringBuilder2;
        if (paramInt == AEEditorImageEditFragment.e(this.a))
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(AEEditorImageEditFragment.w(this.a).a((String)AEEditorImageEditFragment.r(this.a).get(paramInt)).a());
          localStringBuilder2.append("(当前图)|");
          localStringBuilder1.append(localStringBuilder2.toString());
        }
        else if ((AEEditorImageEditFragment.w(this.a).a((String)AEEditorImageEditFragment.r(this.a).get(paramInt)) != null) && (((SingleImageAIFilterResult)paramAIFilterResult.b.get(paramInt)).a))
        {
          AEEditorImageEditFragment.u(this.a).a(paramInt, AEEditorImageEditFragment.w(this.a).a((String)AEEditorImageEditFragment.r(this.a).get(paramInt)));
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(AEEditorImageEditFragment.w(this.a).a((String)AEEditorImageEditFragment.r(this.a).get(paramInt)).a());
          localStringBuilder2.append("(err)|");
          localStringBuilder1.append(localStringBuilder2.toString());
        }
        else
        {
          AEEditorImageEditFragment.w(this.a).a((String)AEEditorImageEditFragment.r(this.a).get(paramInt), (AIFilterResult)paramAIFilterResult.b.get(paramInt));
          AEEditorImageEditFragment.x(this.a).put(String.valueOf(paramInt), this.a.a((AIFilterResult)paramAIFilterResult.b.get(paramInt)));
          AEEditorImageEditFragment.u(this.a).a(paramInt, (AIFilterResult)paramAIFilterResult.b.get(paramInt));
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(((SingleImageAIFilterResult)paramAIFilterResult.b.get(paramInt)).a());
          localStringBuilder2.append("|");
          localStringBuilder1.append(localStringBuilder2.toString());
        }
        paramInt += 1;
      }
      this.a.a("智能滤镜label", localStringBuilder1.toString());
    }
    paramAIFilterResult = this.a;
    AEEditorImageEditFragment.e(paramAIFilterResult, AEEditorImageEditFragment.e(paramAIFilterResult));
    paramAIFilterResult = this.a;
    AEEditorImageEditFragment.f(paramAIFilterResult, AEEditorImageEditFragment.e(paramAIFilterResult));
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
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorImageEditFragment.21
 * JD-Core Version:    0.7.0.1
 */