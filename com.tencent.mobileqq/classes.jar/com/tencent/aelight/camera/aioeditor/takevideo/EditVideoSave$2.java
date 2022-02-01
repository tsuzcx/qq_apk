package com.tencent.aelight.camera.aioeditor.takevideo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.SaveVideoActivity;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateContext;
import com.tencent.aelight.camera.struct.editor.PublishParam;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;

class EditVideoSave$2
  extends SimpleObserver<GenerateContext>
{
  EditVideoSave$2(EditVideoSave paramEditVideoSave, GenerateContext paramGenerateContext) {}
  
  public void a(GenerateContext paramGenerateContext)
  {
    super.onNext(paramGenerateContext);
    this.b.a(5);
    paramGenerateContext = this.a.m;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("publishParam = ");
    ((StringBuilder)localObject).append(paramGenerateContext);
    SLog.b("EditVideoSave", ((StringBuilder)localObject).toString());
    if (this.b.u.getActivity() != null)
    {
      localObject = this.b.u.getActivity().getIntent();
      int i;
      int j;
      if (localObject != null)
      {
        i = ((Intent)localObject).getIntExtra("sv_total_frame_count", 0);
        j = ((Intent)localObject).getIntExtra("sv_total_record_time", 0);
      }
      else
      {
        i = 0;
        j = 0;
      }
      Intent localIntent = SaveVideoActivity.a(this.b.u.getContext(), paramGenerateContext.b, j, i, this.b.t.I.h());
      EditVideoSave.a(this.b, paramGenerateContext.b);
      boolean bool = true;
      localIntent.putExtra("mediacodec_encode_enable", true);
      if (paramGenerateContext.m == 0) {
        bool = false;
      }
      localIntent.putExtra("video_edit_flag", bool);
      if (localObject != null) {
        localIntent.putExtra("qqstory_slide_show_scene", ((Intent)localObject).getIntExtra("qqstory_slide_show_scene", -1));
      }
      if (this.b.d == 19) {
        this.b.u.getActivity().startActivityForResult(localIntent, 222);
      } else {
        this.b.u.getActivity().startActivityForResult(localIntent, 111);
      }
      localObject = this.b;
      ((EditVideoSave)localObject).a = 5.0F;
      ((EditVideoSave)localObject).b = false;
      ((EditVideoSave)localObject).c = (50000.0F / (float)paramGenerateContext.j);
      if (this.b.c == 0.0F) {
        this.b.c = 1.0F;
      }
      this.b.c();
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    SLog.d("EditVideoSave", "saveVideo cancel !");
    this.b.t.d(0);
    this.b.d();
    QQToast.makeText(this.b.u.getContext(), HardCodeUtil.a(2131901890), 0).show();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("saveVideo error ：");
    ((StringBuilder)localObject).append(paramError);
    SLog.e("EditVideoSave", ((StringBuilder)localObject).toString());
    this.b.t.d(0);
    localObject = this.b.u.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131901830));
    localStringBuilder.append(paramError);
    QQToast.makeText((Context)localObject, 1, localStringBuilder.toString(), 0).show();
    this.b.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoSave.2
 * JD-Core Version:    0.7.0.1
 */