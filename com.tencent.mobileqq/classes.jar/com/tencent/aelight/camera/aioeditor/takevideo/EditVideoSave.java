package com.tencent.aelight.camera.aioeditor.takevideo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateContext;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateLocalVideoSegment;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateThumbArgs;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.HWEncodeMergeThumbSegment;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.PublishFileManager;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.PublishVideoSegment;
import com.tencent.aelight.camera.util.api.IMediaCodecDPC;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.editor.params.EditLocalVideoSource;
import com.tencent.mobileqq.editor.params.EditTakeVideoSource;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.editor.params.EditVideoParams.EditSource;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.ProgressPieDrawable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import java.util.Iterator;
import java.util.List;

public class EditVideoSave
  extends EditVideoPart
{
  float a;
  boolean b;
  float c = 3.0F;
  int d = -1;
  ProgressPieDrawable e;
  private String f;
  private Dialog g;
  
  public EditVideoSave(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  private void i()
  {
    SLog.b("EditVideoSave", "saveHWVideo");
    Object localObject1 = this.t.I.e;
    int i;
    if ((localObject1 instanceof EditLocalVideoSource)) {
      i = ((EditLocalVideoSource)localObject1).b.rotation;
    }
    for (;;)
    {
      break;
      if ((localObject1 instanceof EditTakeVideoSource)) {
        i = ((EditTakeVideoSource)localObject1).b.rotation;
      } else {
        i = 0;
      }
    }
    GenerateContext localGenerateContext = new GenerateContext(this.t.I);
    localGenerateContext.d.videoMaxrate = CodecParam.mMaxrate;
    if (((IMediaCodecDPC)QRoute.api(IMediaCodecDPC.class)).isCqBitrateModeSwitchOpen()) {
      localGenerateContext.d.videoMaxrate = (((IMediaCodecDPC)QRoute.api(IMediaCodecDPC.class)).getCqMaxBitrate() * 1000);
    }
    localGenerateContext.p = PublishFileManager.a(2);
    Object localObject2 = this.u.getActivity();
    int j = ((EditVideoParams.EditSource)localObject1).b();
    int k = ((EditVideoParams.EditSource)localObject1).c();
    String str = ((EditVideoParams.EditSource)localObject1).a();
    float f1 = ((EditVideoParams.EditSource)localObject1).b() * 1.0F / ((EditVideoParams.EditSource)localObject1).c();
    boolean bool;
    if ((this.t.P != null) && (this.t.P.c() == 5)) {
      bool = true;
    } else {
      bool = false;
    }
    localGenerateContext.i = new GenerateThumbArgs((Activity)localObject2, j, k, str, f1, bool, i, 0.0D, 0.0D, "", false);
    localObject1 = this.t.J.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((EditVideoPart)((Iterator)localObject1).next()).a(0, localGenerateContext);
    }
    SLog.d("EditVideoSave", "PUBLISH start ...");
    a(HardCodeUtil.a(2131901811), false, 0);
    a(2);
    localObject2 = Stream.of(localGenerateContext).map(new ThreadOffFunction("EditVideoSave", 2)).map(new GenerateLocalVideoSegment());
    localObject1 = localObject2;
    if (this.t.O != null) {
      localObject1 = ((Stream)localObject2).map(this.t.O.c(0));
    }
    ((Stream)localObject1).map(new HWEncodeMergeThumbSegment()).map(new PublishVideoSegment(this.t.I)).map(new UIThreadOffFunction(this)).subscribe(new EditVideoSave.2(this, localGenerateContext));
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
    localProgressPieDrawable.a(new EditVideoSave.5(this));
    return localProgressPieDrawable;
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.e;
    if (localObject == null) {
      return;
    }
    ((ProgressPieDrawable)localObject).b();
    this.e.d(paramInt);
    this.e.b(true);
    this.e.d(false);
    localObject = this.e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(paramInt));
    localStringBuilder.append("%");
    ((ProgressPieDrawable)localObject).a(localStringBuilder.toString());
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[setProgress] current:");
      ((StringBuilder)localObject).append(this.e.c());
      ((StringBuilder)localObject).append(", progress:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.w("EditVideoSave", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 != 111) && (paramInt1 != 222)) {
      return;
    }
    Object localObject;
    if (paramIntent != null)
    {
      localObject = this.f;
      if ((localObject == null) || (!((String)localObject).equals(paramIntent.getStringExtra("fakeId")))) {
        return;
      }
    }
    this.t.d(0);
    this.b = true;
    if (paramInt2 == -1)
    {
      a(100);
      this.u.getRootView().postDelayed(new EditVideoSave.1(this, paramInt1, paramIntent), 500L);
      return;
    }
    if (paramInt2 == 1)
    {
      d();
      if (paramInt1 == 222) {
        localObject = new StringBuilder(HardCodeUtil.a(2131901935));
      } else {
        localObject = new StringBuilder(HardCodeUtil.a(2131901832));
      }
      if ((paramIntent != null) && (paramIntent.getStringExtra("error") != null))
      {
        ((StringBuilder)localObject).append(": ");
        ((StringBuilder)localObject).append(paramIntent.getStringExtra("error"));
      }
      QQToast.makeText(this.u.getContext(), 1, (CharSequence)localObject, 0).show();
      return;
    }
    if (paramInt2 == 0) {
      d();
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if ((paramInt != 9) && (paramInt != 19)) {
      return;
    }
    this.d = paramInt;
    i();
  }
  
  @TargetApi(14)
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if (this.g == null)
    {
      this.g = new Dialog(u());
      Object localObject = this.g.getWindow();
      if (localObject != null)
      {
        ((Window)localObject).setBackgroundDrawable(new ColorDrawable());
        if (Build.VERSION.SDK_INT >= 14) {
          ((Window)localObject).setDimAmount(0.0F);
        }
      }
      this.g.requestWindowFeature(1);
      this.g.setContentView(2131628207);
      localObject = (ImageView)this.g.findViewById(2131440726);
      this.e = k();
      ((ImageView)localObject).setImageDrawable(this.e);
    }
    ((TextView)this.g.findViewById(2131438908)).setText(paramString);
    this.g.setCancelable(paramBoolean);
    this.g.setCanceledOnTouchOutside(paramBoolean);
    this.e.d(0);
    t().getRootView().postDelayed(new EditVideoSave.3(this), paramInt);
  }
  
  void c()
  {
    if (this.u == null) {
      return;
    }
    this.u.getRootView().postDelayed(new EditVideoSave.4(this), 1000L);
  }
  
  public void d()
  {
    Dialog localDialog = this.g;
    if (localDialog != null) {
      localDialog.dismiss();
    }
  }
  
  public void g()
  {
    d();
    super.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoSave
 * JD-Core Version:    0.7.0.1
 */