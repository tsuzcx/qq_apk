package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class AEBeautyProviderView
  extends FrameLayout
{
  public boolean a = false;
  protected View b;
  protected TextView c;
  protected TextView d;
  private Animation e;
  private int f = 500;
  private final int g = 300;
  private float h = 1.0F;
  private AECaptureController i;
  private View j;
  private AEProviderContainerView k;
  private View l;
  private View m;
  private SeekBar n;
  private SeekBar o;
  private SeekBar.OnSeekBarChangeListener p = new AEBeautyProviderView.1(this);
  private SeekBar.OnSeekBarChangeListener q = new AEBeautyProviderView.2(this);
  
  public AEBeautyProviderView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AEBeautyProviderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private Animation a(AEProviderContainerView paramAEProviderContainerView, View paramView, float paramFloat1, float paramFloat2)
  {
    return new ValueAnimation(Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), new AEBeautyProviderView.3(this, paramAEProviderContainerView, paramView));
  }
  
  private void a(int paramInt)
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ae_beauty_level_");
    localStringBuilder.append(str);
    localStringBuilder.append("_CAMERA_ID_");
    localStringBuilder.append(FlowCameraConstant.b);
    str = localStringBuilder.toString();
    AECameraPrefsUtil.a().a(str, paramInt, 0);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveBeautyFeature BeautyLevel=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", key: ");
      localStringBuilder.append(str);
      QLog.d("AEBeautyProviderView", 2, localStringBuilder.toString());
    }
  }
  
  private void a(View paramView1, View paramView2)
  {
    Object localObject = this.j;
    if ((localObject != null) && ((localObject instanceof ViewGroup))) {
      ((ViewGroup)localObject).setMotionEventSplittingEnabled(false);
    }
    int i2 = 300;
    localObject = this.e;
    int i1 = i2;
    if (localObject != null)
    {
      i1 = i2;
      if (!((Animation)localObject).hasEnded())
      {
        this.e.cancel();
        i1 = 0;
      }
    }
    paramView1.setAlpha(1.0F);
    if (!this.k.j())
    {
      if (this.k.k()) {
        return;
      }
      this.e = a(this.k, paramView2, this.h, 0.0F);
      this.e.setDuration((this.h * this.f));
      this.e.setStartOffset(i1);
      startAnimation(this.e);
    }
  }
  
  private void b(int paramInt)
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ae_sharp_face_level_");
    localStringBuilder.append(str);
    localStringBuilder.append("_CAMERA_ID_");
    localStringBuilder.append(FlowCameraConstant.b);
    str = localStringBuilder.toString();
    AECameraPrefsUtil.a().a(str, paramInt, 0);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveSharpFaceFeature SharpFaceLevel = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", key:");
      localStringBuilder.append(str);
      QLog.d("AEBeautyProviderView", 2, localStringBuilder.toString());
    }
  }
  
  private void b(View paramView1, View paramView2)
  {
    Animation localAnimation = this.e;
    if ((localAnimation != null) && (!localAnimation.hasEnded())) {
      this.e.cancel();
    }
    paramView1.setAlpha(1.0F);
    if (!this.k.j())
    {
      if (this.k.k()) {
        return;
      }
      this.e = a(this.k, paramView2, this.h, 1.0F);
      this.e.setDuration(((1.0F - this.h) * this.f));
      startAnimation(this.e);
    }
  }
  
  private int getAndSetBeautyLevel()
  {
    int i1 = getBeautyFeature();
    this.n.setProgress(i1);
    TextView localTextView = this.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("+");
    localStringBuilder.append(i1 / 10.0F);
    localTextView.setText(localStringBuilder.toString());
    return i1;
  }
  
  private int getAndSetSharpFaceLevel()
  {
    int i1 = getSharpFaceFeature();
    this.o.setProgress(i1);
    TextView localTextView = this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("+");
    localStringBuilder.append(String.format("%.1f", new Object[] { Float.valueOf(i1 / 10.0F) }));
    localTextView.setText(localStringBuilder.toString());
    return i1;
  }
  
  public static int getBeautyFeature()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ae_beauty_level_");
    localStringBuilder.append(str);
    localStringBuilder.append("_CAMERA_ID_");
    localStringBuilder.append(FlowCameraConstant.b);
    str = localStringBuilder.toString();
    if (FlowCameraConstant.b == 2) {
      i1 = 0;
    } else {
      i1 = 55;
    }
    int i1 = AECameraPrefsUtil.a().b(str, i1, 0);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getBeautyFeature BeautyLevel=");
      localStringBuilder.append(i1);
      localStringBuilder.append(", key:");
      localStringBuilder.append(str);
      QLog.d("AEBeautyProviderView", 2, localStringBuilder.toString());
    }
    return i1;
  }
  
  public static int getSharpFaceFeature()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if (FlowCameraConstant.b == 2) {
      i1 = 0;
    } else {
      i1 = 40;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ae_sharp_face_level_");
    localStringBuilder.append(str);
    localStringBuilder.append("_CAMERA_ID_");
    localStringBuilder.append(FlowCameraConstant.b);
    str = localStringBuilder.toString();
    int i1 = AECameraPrefsUtil.a().b(str, i1, 0);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSharpFaceFeature SharpFaceLevel = ");
      localStringBuilder.append(i1);
      localStringBuilder.append(", key:");
      localStringBuilder.append(str);
      QLog.d("AEBeautyProviderView", 2, localStringBuilder.toString());
    }
    return i1;
  }
  
  public void a()
  {
    c();
  }
  
  @TargetApi(11)
  public void a(Bundle paramBundle)
  {
    if (this.b == null)
    {
      this.b = LayoutInflater.from(getContext()).inflate(2131629312, this, true);
      this.a = true;
    }
    this.j = ((Activity)getContext()).findViewById(2063991107);
    this.k = ((AEProviderContainerView)((Activity)getContext()).findViewById(2063990904));
    this.l = this.b.findViewById(2131429382);
    if (!CaptureUtil.d()) {
      this.l.setVisibility(8);
    }
    this.n = ((SeekBar)this.b.findViewById(2131429389));
    this.n.setOnSeekBarChangeListener(this.p);
    if (Build.VERSION.SDK_INT >= 21) {
      this.n.setSplitTrack(false);
    }
    this.c = ((TextView)this.b.findViewById(2131429383));
    getAndSetBeautyLevel();
    this.m = this.b.findViewById(2131445828);
    this.o = ((SeekBar)this.b.findViewById(2131445830));
    this.o.setOnSeekBarChangeListener(this.q);
    if (Build.VERSION.SDK_INT >= 21) {
      this.o.setSplitTrack(false);
    }
    this.d = ((TextView)this.b.findViewById(2131445829));
    getAndSetSharpFaceLevel();
  }
  
  public void b()
  {
    if (this.b == null) {
      return;
    }
    int i1 = getAndSetBeautyLevel();
    AECaptureController localAECaptureController = this.i;
    if (localAECaptureController != null) {
      localAECaptureController.a(i1);
    }
  }
  
  public void c()
  {
    if (this.b != null)
    {
      int i1 = getAndSetSharpFaceLevel();
      AECaptureController localAECaptureController = this.i;
      if (localAECaptureController != null) {
        localAECaptureController.b(i1);
      }
      i1 = getAndSetBeautyLevel();
      localAECaptureController = this.i;
      if (localAECaptureController != null) {
        localAECaptureController.a(i1);
      }
    }
  }
  
  public void setController(AECaptureController paramAECaptureController)
  {
    this.i = paramAECaptureController;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEBeautyProviderView
 * JD-Core Version:    0.7.0.1
 */