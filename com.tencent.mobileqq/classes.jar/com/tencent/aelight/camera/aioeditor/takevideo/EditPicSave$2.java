package com.tencent.aelight.camera.aioeditor.takevideo;

import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateContext;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GeneratePicArgs;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;

class EditPicSave$2
  extends SimpleObserver<GenerateContext>
{
  EditPicSave$2(EditPicSave paramEditPicSave) {}
  
  public void a(GenerateContext paramGenerateContext)
  {
    super.onNext(paramGenerateContext);
    this.a.a(40);
    paramGenerateContext = paramGenerateContext.l.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("picPath = ");
    localStringBuilder.append(paramGenerateContext);
    SLog.b("EditPicSave", localStringBuilder.toString());
    if (this.a.u.getActivity() != null)
    {
      ThreadManager.excute(new EditPicSave.2.1(this, paramGenerateContext), 64, this.a.e, true);
      paramGenerateContext = this.a;
      paramGenerateContext.a = 40;
      paramGenerateContext.b = false;
      paramGenerateContext.c = 10;
      paramGenerateContext.c();
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    SLog.d("EditPicSave", "saveVideo cancel !");
    if (!EditPicSave.a(this.a))
    {
      if (this.a.t.I.h() == 14) {
        this.a.t.E = false;
      }
      this.a.t.d(0);
    }
    this.a.d();
    QQToast.makeText(this.a.u.getContext(), HardCodeUtil.a(2131901789), 0).show();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("saveVideo error ：");
    ((StringBuilder)localObject).append(paramError);
    SLog.e("EditPicSave", ((StringBuilder)localObject).toString());
    if (!EditPicSave.a(this.a))
    {
      if (this.a.t.I.h() == 14) {
        this.a.t.E = false;
      }
      this.a.t.d(0);
    }
    localObject = this.a.u.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131901791));
    localStringBuilder.append(paramError);
    QQToast.makeText((Context)localObject, 1, localStringBuilder.toString(), 0).show();
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditPicSave.2
 * JD-Core Version:    0.7.0.1
 */