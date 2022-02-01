package com.tencent.aelight.camera.aioeditor.takevideo;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateContext;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateEditPicDoodleSegment;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GeneratePicArgs;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.MergePicSegment;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.PublishFileManager;
import com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.SendPanelItemInfo;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.editor.params.EditVideoParams.EditSource;
import com.tencent.mobileqq.widget.ProgressPieDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import java.util.Iterator;
import java.util.List;

public class EditPicSave
  extends EditVideoPart
{
  int a;
  boolean b;
  int c = 20;
  ProgressPieDrawable d;
  ThreadExcutor.IThreadListener e = new EditPicSave.1(this);
  private Dialog f;
  private String g;
  private boolean h = false;
  private boolean i = true;
  private int j = 0;
  private SendPanelItemInfo k;
  
  public EditPicSave(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  private String a(Context paramContext)
  {
    if (paramContext != null) {
      return paramContext.getSharedPreferences("mini_launch_ae_tag", 0).getString("mini_launch_ae_app_id", "");
    }
    return "";
  }
  
  private void i()
  {
    Object localObject1 = new GenerateContext(this.t.I);
    ((GenerateContext)localObject1).p = PublishFileManager.a(2);
    ((GenerateContext)localObject1).l = new GeneratePicArgs(this.t.I.e.a());
    Object localObject2 = this.t.J.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((EditVideoPart)((Iterator)localObject2).next()).a(0, (GenerateContext)localObject1);
    }
    SLog.d("EditPicSave", "PUBLISH start ...");
    a(HardCodeUtil.a(2131901793), false, 0);
    a(20);
    localObject1 = Stream.of(localObject1).map(new GenerateEditPicDoodleSegment((EditDoodleExport)b(EditDoodleExport.class), null)).map(new ThreadOffFunction("EditPicSave", 2));
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(EditPicConstants.a);
    ((StringBuilder)localObject2).append("qq_pic_merged_");
    ((StringBuilder)localObject2).append(System.currentTimeMillis());
    ((StringBuilder)localObject2).append(".jpg");
    ((Stream)localObject1).map(new MergePicSegment(((StringBuilder)localObject2).toString(), true, null)).map(new UIThreadOffFunction(this)).subscribe(new EditPicSave.2(this));
  }
  
  private ProgressPieDrawable k()
  {
    ProgressPieDrawable localProgressPieDrawable = new ProgressPieDrawable(u());
    localProgressPieDrawable.a(AIOUtils.b(50.0F, s()));
    localProgressPieDrawable.a(true);
    localProgressPieDrawable.c(false);
    localProgressPieDrawable.h(-1);
    localProgressPieDrawable.g(0);
    localProgressPieDrawable.e(-15550475);
    localProgressPieDrawable.j(3);
    localProgressPieDrawable.D = true;
    localProgressPieDrawable.A = 2;
    localProgressPieDrawable.e(true);
    localProgressPieDrawable.a(new EditPicSave.5(this));
    return localProgressPieDrawable;
  }
  
  public void a(int paramInt)
  {
    if (this.h) {
      return;
    }
    Object localObject = this.d;
    if (localObject == null) {
      return;
    }
    ((ProgressPieDrawable)localObject).b();
    this.d.d(paramInt);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[setProgress] current:");
      ((StringBuilder)localObject).append(this.d.c());
      ((StringBuilder)localObject).append(", progress:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.w("EditPicSave", 2, ((StringBuilder)localObject).toString());
    }
    this.d.b(true);
    this.d.d(false);
    localObject = this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(paramInt));
    localStringBuilder.append("%");
    ((ProgressPieDrawable)localObject).a(localStringBuilder.toString());
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (paramInt != 0)
    {
      if (paramInt != 9)
      {
        if (paramInt != 20) {
          return;
        }
        this.j = paramInt;
        if ((paramObject instanceof SendPanelItemInfo)) {
          this.k = ((SendPanelItemInfo)paramObject);
        }
      }
      else
      {
        VideoEditReport.b("0X80080E1", VideoEditReport.c);
        i();
      }
    }
    else
    {
      this.j = paramInt;
      this.k = null;
    }
  }
  
  @TargetApi(14)
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if (this.h) {
      return;
    }
    if (this.f == null)
    {
      this.f = new Dialog(u());
      Object localObject = this.f.getWindow();
      if (localObject != null)
      {
        ((Window)localObject).setBackgroundDrawable(new ColorDrawable());
        if (Build.VERSION.SDK_INT >= 14) {
          ((Window)localObject).setDimAmount(0.0F);
        }
      }
      this.f.requestWindowFeature(1);
      this.f.setContentView(2131628207);
      localObject = (ImageView)this.f.findViewById(2131440726);
      this.d = k();
      ((ImageView)localObject).setImageDrawable(this.d);
    }
    ((TextView)this.f.findViewById(2131438908)).setText(paramString);
    this.f.setCancelable(paramBoolean);
    this.f.setCanceledOnTouchOutside(paramBoolean);
    this.d.d(0);
    t().getRootView().postDelayed(new EditPicSave.3(this), paramInt);
  }
  
  void c()
  {
    if (this.h) {
      return;
    }
    this.u.getRootView().postDelayed(new EditPicSave.4(this), 1000L);
  }
  
  public void d()
  {
    Dialog localDialog = this.f;
    if (localDialog != null) {
      localDialog.dismiss();
    }
  }
  
  public void g()
  {
    this.h = true;
    d();
    super.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditPicSave
 * JD-Core Version:    0.7.0.1
 */