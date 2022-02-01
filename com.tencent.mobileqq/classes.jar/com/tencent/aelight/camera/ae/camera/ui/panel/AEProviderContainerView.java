package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager;
import com.tencent.aelight.camera.aioeditor.capture.util.QIMAnimationUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class AEProviderContainerView
  extends AEAbsBottomPanal
{
  public int a = UIUtils.a(getContext(), 195.0F);
  View.OnClickListener b = new AEProviderContainerView.1(this);
  private View c;
  private View d;
  private FrameLayout e;
  private View g;
  private View h;
  private ArrayList<View> i = new ArrayList();
  private AEBeautyProviderView j;
  private AEFilterProviderView k;
  private boolean l = false;
  private boolean m = false;
  private AECaptureController n;
  private VideoStoryCapturePartManager o;
  private int p = 0;
  private AECaptureMode q = AECaptureMode.NORMAL;
  private int r = 0;
  private int s = 0;
  
  public AEProviderContainerView(Context paramContext)
  {
    super(paramContext);
    m();
  }
  
  public AEProviderContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    m();
  }
  
  public AEProviderContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    m();
  }
  
  private void m()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2064056389, null);
    addView(localView);
    this.c = localView.findViewById(2063990905);
    this.c.setOnClickListener(this.b);
    this.d = localView.findViewById(2063991079);
    this.d.setOnClickListener(this.b);
    this.e = ((FrameLayout)localView.findViewById(2063991332));
    this.g = localView.findViewById(2063991333);
    this.h = localView.findViewById(2063990962);
    this.i.add(this.g);
    this.i.add(this.h);
    this.i.add(this.c);
    this.i.add(this.d);
  }
  
  private void n()
  {
    int i1 = this.p;
    if (i1 != 0)
    {
      if (i1 != 1) {
        return;
      }
      p();
      return;
    }
    o();
  }
  
  private void o()
  {
    this.p = 0;
    this.d.setSelected(true);
    this.c.setSelected(false);
    Object localObject = this.j;
    if (localObject != null)
    {
      ((AEBeautyProviderView)localObject).setAlpha(1.0F);
      this.j.setVisibility(8);
      this.j = null;
      r();
    }
    if (this.k == null)
    {
      this.k = new AEFilterProviderView(getContext());
      this.k.setNeedTabBar(false);
      this.k.d(UIUtils.a(getContext(), 162.0F));
      localObject = this.k;
      if (localObject != null) {
        this.e.addView((View)localObject);
      }
    }
    localObject = this.k;
    if (localObject != null)
    {
      if (!((AEFilterProviderView)localObject).B) {
        this.k.a(null);
      }
      this.k.setAlpha(1.0F);
      this.k.setVisibility(0);
      this.k.c();
    }
    if (AECameraEntryManager.o(((Activity)getContext()).getIntent())) {
      AEReportUtils.a(11, null);
    }
  }
  
  private void p()
  {
    this.p = 1;
    this.d.setSelected(false);
    this.c.setSelected(true);
    Object localObject = this.k;
    if (localObject != null)
    {
      ((AEFilterProviderView)localObject).d();
      this.k.setAlpha(1.0F);
      this.k.setVisibility(8);
    }
    if (this.j == null)
    {
      this.j = new AEBeautyProviderView(getContext());
      localObject = this.j;
      if (localObject != null) {
        this.e.addView((View)localObject);
      }
    }
    localObject = this.j;
    if (localObject != null)
    {
      if (!((AEBeautyProviderView)localObject).a)
      {
        this.j.setController(this.n);
        this.j.a(null);
      }
      this.j.setAlpha(1.0F);
      this.j.setVisibility(0);
      this.j.a();
    }
    if (AECameraEntryManager.o(((Activity)getContext()).getIntent()))
    {
      this.r = AEBeautyProviderView.getBeautyFeature();
      this.s = AEBeautyProviderView.getSharpFaceFeature();
      AEReportUtils.a(12, null);
    }
  }
  
  private void q()
  {
    this.l = false;
    Object localObject = ObjectAnimator.ofFloat(this, "translationY", new float[] { 0.0F, this.a });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play((Animator)localObject);
    localAnimatorSet.addListener(new AEProviderContainerView.4(this));
    localAnimatorSet.setDuration(300L).start();
    localObject = QIMAnimationUtils.a(this, 1.0F, 0.0F);
    ((Animation)localObject).setStartOffset(0L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new AEProviderContainerView.5(this));
    startAnimation((Animation)localObject);
  }
  
  private void r()
  {
    if (AECameraEntryManager.o(((Activity)getContext()).getIntent()))
    {
      int i1 = AEBeautyProviderView.getBeautyFeature();
      HashMap localHashMap;
      if (i1 != this.r)
      {
        localHashMap = new HashMap();
        localHashMap.put("ext15", String.valueOf(i1));
        AEReportUtils.a(12, 3, localHashMap);
      }
      i1 = AEBeautyProviderView.getSharpFaceFeature();
      if (i1 != this.s)
      {
        localHashMap = new HashMap();
        localHashMap.put("ext15", String.valueOf(i1));
        AEReportUtils.a(12, 4, localHashMap);
      }
    }
  }
  
  public void a()
  {
    AEFilterProviderView localAEFilterProviderView = this.k;
    if (localAEFilterProviderView != null)
    {
      localAEFilterProviderView.a();
      this.k = null;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.l) {
      q();
    }
    Object localObject = this.k;
    if (localObject != null)
    {
      ((AEFilterProviderView)localObject).d();
      this.k.setVisibility(8);
    }
    localObject = this.j;
    if (localObject != null)
    {
      ((AEBeautyProviderView)localObject).setVisibility(8);
      this.j = null;
      r();
    }
    localObject = this.o;
    if (localObject != null) {
      ((VideoStoryCapturePartManager)localObject).b(196613, new Object[0]);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AEProviderContainerView", 2, "panel closed");
    }
  }
  
  public void b()
  {
    if (!this.m)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doOpenProviderView failed isInflated");
        localStringBuilder.append(this.m);
        QLog.e("AEProviderContainerView", 2, localStringBuilder.toString());
      }
      return;
    }
    n();
    d();
  }
  
  public void c()
  {
    Object localObject = this.k;
    if (localObject != null) {
      ((AEFilterProviderView)localObject).e();
    }
    localObject = this.j;
    if (localObject != null) {
      ((AEBeautyProviderView)localObject).b();
    }
  }
  
  public void d()
  {
    this.l = true;
    Object localObject = new AnimatorSet();
    ((AnimatorSet)localObject).play(ObjectAnimator.ofFloat(this, "translationY", new float[] { this.a, 0.0F }));
    ((AnimatorSet)localObject).addListener(new AEProviderContainerView.2(this));
    ((AnimatorSet)localObject).setDuration(300L).start();
    localObject = QIMAnimationUtils.a(this, 0.0F, 1.0F);
    ((Animation)localObject).setStartOffset(200L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new AEProviderContainerView.3(this));
    startAnimation((Animation)localObject);
  }
  
  public boolean e()
  {
    return l() ^ true;
  }
  
  public void f()
  {
    AEFilterProviderView localAEFilterProviderView = this.k;
    if (localAEFilterProviderView != null) {
      localAEFilterProviderView.f();
    }
  }
  
  public void g()
  {
    AEFilterProviderView localAEFilterProviderView = this.k;
    if (localAEFilterProviderView != null) {
      localAEFilterProviderView.b();
    }
    VideoFilterTools.a().b(null, (Activity)getContext(), 0);
    VideoFilterTools.a().a(null, 0);
    ((CaptureComboManager)QIMManager.a(5)).a((Activity)getContext());
  }
  
  public void h()
  {
    a(true);
  }
  
  public void i()
  {
    AEBeautyProviderView localAEBeautyProviderView = this.j;
    if (localAEBeautyProviderView != null) {
      localAEBeautyProviderView.c();
    }
  }
  
  public boolean j()
  {
    return this.q == AECaptureMode.GIF;
  }
  
  public boolean k()
  {
    return (getContext() != null) && (AECameraEntryManager.o(((Activity)getContext()).getIntent()));
  }
  
  public boolean l()
  {
    Object localObject = this.k;
    int i2 = 0;
    if ((localObject == null) && (this.j == null)) {
      return false;
    }
    localObject = this.k;
    int i1;
    boolean bool1;
    if (localObject != null)
    {
      if (((AEFilterProviderView)localObject).getVisibility() == 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      bool1 = i1 | 0x0;
    }
    else
    {
      bool1 = false;
    }
    localObject = this.j;
    boolean bool2 = bool1;
    if (localObject != null)
    {
      i1 = i2;
      if (((AEBeautyProviderView)localObject).getVisibility() == 0) {
        i1 = 1;
      }
      bool2 = bool1 | i1;
    }
    return bool2;
  }
  
  public void setBackGroundAlpha(float paramFloat)
  {
    Object localObject = this.i;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        View localView = (View)((Iterator)localObject).next();
        if (localView != null) {
          localView.setAlpha(paramFloat);
        }
      }
    }
  }
  
  public void setCaptureMode(AECaptureMode paramAECaptureMode)
  {
    this.q = paramAECaptureMode;
  }
  
  public void setControllerAndManager(AECaptureController paramAECaptureController, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    this.n = paramAECaptureController;
    this.o = paramVideoStoryCapturePartManager;
    this.m = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEProviderContainerView
 * JD-Core Version:    0.7.0.1
 */