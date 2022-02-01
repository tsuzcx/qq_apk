package com.tencent.gdtad.basics.motivevideo;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.io.Serializable;
import java.lang.ref.WeakReference;

public class GdtMotiveVideoDialog
  extends ReportDialog
{
  private Activity a;
  private Intent b;
  private GdtMvViewController c;
  private GdtMotiveVideoModel d;
  private GdtMotiveVideoPageData e;
  private Intent f;
  private Application.ActivityLifecycleCallbacks g;
  private GdtMvViewController.Listener h = new GdtMotiveVideoDialog.1(this);
  private ResultReceiver i;
  
  public GdtMotiveVideoDialog(@NonNull Context paramContext)
  {
    super(paramContext, 16973834);
    this.a = ((Activity)paramContext);
  }
  
  private static GdtMotiveVideoPageData a(@Nullable Serializable paramSerializable)
  {
    if (!(paramSerializable instanceof GdtMotiveVideoPageData)) {
      return null;
    }
    return (GdtMotiveVideoPageData)paramSerializable;
  }
  
  private void a()
  {
    this.f = this.a.getIntent();
    this.a.setIntent(this.b);
    Bundle localBundle = this.b.getExtras();
    if (localBundle == null) {
      return;
    }
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = a(localBundle.getSerializable("data"));
    if (localGdtMotiveVideoPageData == null)
    {
      QLog.e("GdtMotiveVideoDialog", 4, "[initData] firstVideoData is null");
      return;
    }
    this.d = new GdtMotiveVideoModel(localGdtMotiveVideoPageData);
    this.e = a(localBundle.getSerializable("second_data"));
  }
  
  private void b()
  {
    this.c = new GdtMvViewController(new GdtMotiveVideoDialog.2(this), this.d, true);
  }
  
  private void c()
  {
    b();
    if (this.e != null)
    {
      this.c.d(true);
      this.c.a(new WeakReference(this.h));
    }
    this.c.a(1);
    Object localObject1 = getWindow();
    if (Build.VERSION.SDK_INT >= 28)
    {
      localObject2 = ((Window)localObject1).getAttributes();
      ((WindowManager.LayoutParams)localObject2).layoutInDisplayCutoutMode = 1;
      ((Window)localObject1).setAttributes((WindowManager.LayoutParams)localObject2);
    }
    ((Window)localObject1).setFlags(1024, 1024);
    ((Window)localObject1).setVolumeControlStream(3);
    localObject1 = (ViewGroup)((Window)localObject1).getDecorView();
    ((ViewGroup)localObject1).setSystemUiVisibility(7942);
    if (Build.VERSION.SDK_INT >= 19) {
      ((ViewGroup)localObject1).setOnSystemUiVisibilityChangeListener(new GdtMotiveVideoDialog.3(this, (ViewGroup)localObject1));
    }
    Object localObject2 = this.c.a(LayoutInflater.from(this.a), (ViewGroup)localObject1);
    setContentView((View)localObject2);
    setOnDismissListener(new GdtMotiveVideoDialog.MyDismissListener(this));
    ((ViewGroup)localObject1).getViewTreeObserver().addOnGlobalLayoutListener(new GdtMotiveVideoDialog.4(this, (ViewGroup)localObject1, (View)localObject2));
    this.g = new GdtMotiveVideoDialog.5(this);
    this.a.getApplication().registerActivityLifecycleCallbacks(this.g);
    this.c.n();
  }
  
  public void a(Intent paramIntent)
  {
    this.b = paramIntent;
  }
  
  public void a(ResultReceiver paramResultReceiver)
  {
    this.i = paramResultReceiver;
  }
  
  public void onBackPressed()
  {
    if (this.c.f()) {
      return;
    }
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a();
    c();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  protected void onStart()
  {
    super.onStart();
    this.c.l();
  }
  
  protected void onStop()
  {
    super.onStop();
    this.c.k();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onWindowFocusChanged() called with: hasFocus = [");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("]");
    GdtLog.a("GdtMotiveVideoDialog", localStringBuilder.toString());
    if ((paramBoolean) && (Build.VERSION.SDK_INT >= 19)) {
      getWindow().getDecorView().setSystemUiVisibility(7942);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.GdtMotiveVideoDialog
 * JD-Core Version:    0.7.0.1
 */