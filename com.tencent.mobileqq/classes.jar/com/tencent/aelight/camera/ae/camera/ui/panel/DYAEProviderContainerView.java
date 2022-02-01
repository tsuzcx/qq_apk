package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.aelight.camera.ae.AEMaterialViewModel;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.AEViewModelProviders;
import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.ae.flashshow.FlashShowDtReportHelper;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.report_datong.AECameraDaTongHelper;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.aelight.camera.aioeditor.capture.util.QIMAnimationUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.videostory.animator.AnimationBuilder;
import com.tencent.biz.videostory.animator.ViewAnimator;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.ttpic.facedetect.GenderType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class DYAEProviderContainerView
  extends AEAbsBottomPanal
  implements StartPointSeekBar.OnSeekBarChangeListener
{
  private boolean A = false;
  private int B = GenderType.DEFAULT.value;
  private AECaptureController C;
  private VideoStoryCapturePartManager D;
  private AECaptureMode E = AECaptureMode.NORMAL;
  private int F = 0;
  private int G = 0;
  private DYAEBeautyPanelConfig H;
  public int a = UIUtils.a(getContext(), 241.0F);
  private View b;
  private ViewGroup c;
  private ViewGroup d;
  private DYTabLayout e;
  private View g;
  private TextView h;
  private View i;
  private ViewGroup j;
  private ViewGroup k;
  private View l;
  private View m;
  private TextView n;
  private DYAEFilterProviderView o;
  private DYAEBeautyProviderView p;
  private DYAEEffectListHolder q;
  private AECosmeticsProviderView r;
  private StartPointSeekBar s;
  private TextView t;
  private AEProviderViewModel u;
  private AEFilterProviderViewModel v;
  private AEBeautyProviderViewModel w;
  private AECosmeticsViewModel x;
  private AEMaterialViewModel y;
  private AECosmeticsTypeViewModel z;
  
  public DYAEProviderContainerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DYAEProviderContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DYAEProviderContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(View paramView)
  {
    this.c = ((ViewGroup)paramView.findViewById(2063991322));
    this.d = ((ViewGroup)paramView.findViewById(2063991323));
    this.e = ((DYTabLayout)paramView.findViewById(2063991326));
    this.e.setupTabs(DYAEBeautyPanelConfigUtil.a(this.H), new DYAEProviderContainerView.1(this));
    this.g = paramView.findViewById(2063991325);
    View localView = this.g;
    int i1;
    if (this.H.c()) {
      i1 = 0;
    } else {
      i1 = 4;
    }
    localView.setVisibility(i1);
    this.h = ((TextView)paramView.findViewById(2063990924));
    this.h.setCompoundDrawablePadding(c(8));
    this.h.setOnClickListener(new DYAEProviderContainerView.2(this));
    this.i = paramView.findViewById(2063991085);
    this.i.setOnClickListener(new DYAEProviderContainerView.3(this));
  }
  
  private void a(AEBeautyConfigModel paramAEBeautyConfigModel)
  {
    Object localObject = new ArrayList();
    Iterator localIterator = paramAEBeautyConfigModel.i().iterator();
    while (localIterator.hasNext()) {
      ((List)localObject).add(new DYAESecondaryBeautyItem((AEBeautySecondaryConfigModel)localIterator.next()));
    }
    this.q.a((List)localObject);
    localObject = AEProviderViewModel.b(paramAEBeautyConfigModel);
    if (localObject != null) {
      this.q.a(((AEBeautySecondaryConfigModel)localObject).c(), false);
    }
    this.n.setText(paramAEBeautyConfigModel.b());
  }
  
  private void a(@NonNull Object paramObject)
  {
    int i1 = AEProviderViewModel.b(paramObject);
    int i2 = AEProviderViewModel.c(paramObject);
    int i3 = AEProviderViewModel.d(paramObject);
    int i4 = AEProviderViewModel.a(paramObject);
    if ((i4 <= i2) && (i4 >= i1))
    {
      this.s.setAbsoluteMinMaxValue(i1, i2);
      this.s.setDefaultValue(i3);
      paramObject = this.s;
      boolean bool;
      if ((i3 < i2) && (i3 > i1)) {
        bool = true;
      } else {
        bool = false;
      }
      paramObject.setSectionEnable(bool);
      this.s.setProgress(i4);
      StartPointSeekBar.a(this.s, i4, this.t);
    }
  }
  
  private void a(Runnable paramRunnable)
  {
    AEBeautyProviderViewModel localAEBeautyProviderViewModel = this.w;
    if (localAEBeautyProviderViewModel != null) {
      localAEBeautyProviderViewModel.h().setValue(Boolean.valueOf(false));
    }
    ViewAnimator.a(new View[] { this.c }).c(new float[] { -250.0F, 0.0F }).d(new float[] { 0.0F, 1.0F }).a(new View[] { this.j }).c(new float[] { 0.0F, 250.0F }).d(new float[] { 1.0F, 0.0F }).a(300L).a(new DYAEProviderContainerView.17(this)).a(new DYAEProviderContainerView.16(this, paramRunnable)).d();
  }
  
  private void b(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        o();
        return;
      }
      n();
      return;
    }
    m();
  }
  
  private void b(View paramView)
  {
    this.j = ((ViewGroup)paramView.findViewById(2063991413));
    this.k = ((ViewGroup)paramView.findViewById(2063991414));
    this.n = ((TextView)paramView.findViewById(2063991417));
    this.l = paramView.findViewById(2063991416);
    View localView = this.l;
    int i1;
    if (this.H.c()) {
      i1 = 0;
    } else {
      i1 = 4;
    }
    localView.setVisibility(i1);
    this.m = paramView.findViewById(2063990926);
    this.m.setOnClickListener(new DYAEProviderContainerView.5(this));
    this.q = new DYAEEffectListHolder(getContext(), this.k, new DYAEProviderContainerView.6(this));
  }
  
  private int c(int paramInt)
  {
    return (int)TypedValue.applyDimension(1, paramInt, getResources().getDisplayMetrics());
  }
  
  private void c(View paramView)
  {
    this.t = ((TextView)paramView.findViewById(2063991505));
    this.s = ((StartPointSeekBar)paramView.findViewById(2063991427));
    this.s.setOnSeekBarChangeListener(this);
  }
  
  private void k()
  {
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(getContext(), 2131953338);
    localQQCustomDialog.setContentView(2131624611);
    localQQCustomDialog.setTitle(2064187398);
    localQQCustomDialog.setMessage(2064187397);
    localQQCustomDialog.setNegativeButton(2064187396, new DYAEProviderContainerView.4(this));
    localQQCustomDialog.setPositiveButton(null, null);
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    localQQCustomDialog.show();
  }
  
  private void l()
  {
    AEPituCameraUnit localAEPituCameraUnit = (AEPituCameraUnit)this.D.a(65537, new Object[0]);
    if (localAEPituCameraUnit == null) {
      return;
    }
    this.v = ((AEFilterProviderViewModel)AEViewModelProviders.a(localAEPituCameraUnit).get(AEFilterProviderViewModel.class));
    this.x = ((AECosmeticsViewModel)AEViewModelProviders.a(localAEPituCameraUnit).get(AECosmeticsViewModel.class));
    this.z = ((AECosmeticsTypeViewModel)AEViewModelProviders.a(localAEPituCameraUnit).get(AECosmeticsTypeViewModel.class));
    this.z.a().observe(localAEPituCameraUnit, new DYAEProviderContainerView.7(this));
    this.w = ((AEBeautyProviderViewModel)AEViewModelProviders.a(localAEPituCameraUnit).get(AEBeautyProviderViewModel.class));
    this.w.e().observe(localAEPituCameraUnit, new DYAEProviderContainerView.8(this));
    this.w.g().observe(localAEPituCameraUnit, new DYAEProviderContainerView.9(this));
    this.w.k().observe(localAEPituCameraUnit, new DYAEProviderContainerView.10(this));
    this.u = ((AEProviderViewModel)AEViewModelProviders.a(localAEPituCameraUnit, new AEProviderViewModelFactory(this.w, this.x, this.v)).get(AEProviderViewModel.class));
    this.u.e().observe(localAEPituCameraUnit, new DYAEProviderContainerView.11(this));
    this.u.b().observe(localAEPituCameraUnit, new DYAEProviderContainerView.12(this));
    this.u.c().observe(localAEPituCameraUnit, new DYAEProviderContainerView.13(this));
    this.y = ((AEMaterialViewModel)AEViewModelProviders.a(localAEPituCameraUnit).get(AEMaterialViewModel.class));
    this.y.a().observe(localAEPituCameraUnit, new -..Lambda.DYAEProviderContainerView.kIFsCx4ZvWb00EdTCrvSsLahfTE(this));
  }
  
  private void m()
  {
    ViewUtils.setViewVisibility(this.r, 8);
    ViewUtils.setViewVisibility(this.p, 8);
    if (this.o == null)
    {
      this.o = new DYAEFilterProviderView(getContext());
      this.d.addView(this.o, new ViewGroup.LayoutParams(-1, -1));
      this.o.setNeedTabBar(false);
      this.o.d(c(162));
      if (!this.o.B)
      {
        this.o.a(this.D);
        this.o.a(null);
      }
    }
    ViewUtils.setViewVisibility(this.o, 0);
    this.o.c();
    Object localObject = this.v;
    if (localObject != null)
    {
      localObject = (QIMFilterCategoryItem)((AEFilterProviderViewModel)localObject).a().getValue();
      if (localObject != null) {
        a(localObject);
      }
    }
  }
  
  private void n()
  {
    ViewUtils.setViewVisibility(this.o, 8);
    ViewUtils.setViewVisibility(this.r, 8);
    if (this.p == null)
    {
      this.p = new DYAEBeautyProviderView(getContext());
      this.d.addView(this.p, new ViewGroup.LayoutParams(-1, -1));
      this.p.setControllerAndManager(this.C, this.D);
    }
    ViewUtils.setViewVisibility(this.p, 0);
    this.p.c();
    if (AECameraEntryManager.o(((Activity)getContext()).getIntent()))
    {
      this.F = AEBeautyProviderView.getBeautyFeature();
      this.G = AEBeautyProviderView.getSharpFaceFeature();
      AEReportUtils.a(12, null);
    }
    if (this.j.getVisibility() == 0) {
      this.q.a(true);
    }
    if (this.v != null)
    {
      AEBeautyConfigModel localAEBeautyConfigModel = (AEBeautyConfigModel)this.w.e().getValue();
      if (localAEBeautyConfigModel != null) {
        a(localAEBeautyConfigModel);
      }
    }
  }
  
  private void o()
  {
    ViewUtils.setViewVisibility(this.o, 8);
    ViewUtils.setViewVisibility(this.p, 8);
    if (this.r == null)
    {
      this.r = new AECosmeticsProviderView(getContext());
      this.r.a(this.D);
      this.d.addView(this.r, new ViewGroup.LayoutParams(-1, -1));
    }
    ViewUtils.setViewVisibility(this.r, 0);
    if (this.B == GenderType.DEFAULT.value) {
      this.B = ((Integer)this.z.a().getValue()).intValue();
    }
    this.r.setGenderType(this.B);
    this.r.a();
    if (this.v != null)
    {
      DYAEEffectItem localDYAEEffectItem = (DYAEEffectItem)this.x.b().getValue();
      if (localDYAEEffectItem != null) {
        a(localDYAEEffectItem);
      }
    }
  }
  
  private void p()
  {
    AEBeautyProviderViewModel localAEBeautyProviderViewModel = this.w;
    if (localAEBeautyProviderViewModel != null) {
      localAEBeautyProviderViewModel.h().setValue(Boolean.valueOf(true));
    }
    ViewAnimator.a(new View[] { this.c }).c(new float[] { 0.0F, -250.0F }).d(new float[] { 1.0F, 0.0F }).a(new View[] { this.j }).c(new float[] { 250.0F, 0.0F }).d(new float[] { 0.0F, 1.0F }).a(300L).a(new DYAEProviderContainerView.15(this)).a(new DYAEProviderContainerView.14(this)).d();
  }
  
  private void q()
  {
    this.A = true;
    Object localObject = new AnimatorSet();
    ((AnimatorSet)localObject).play(ObjectAnimator.ofFloat(this, "translationY", new float[] { this.a, 0.0F }));
    ((AnimatorSet)localObject).addListener(new DYAEProviderContainerView.18(this));
    ((AnimatorSet)localObject).setDuration(300L).start();
    localObject = QIMAnimationUtils.a(this, 0.0F, 1.0F);
    ((Animation)localObject).setStartOffset(200L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new DYAEProviderContainerView.19(this));
    startAnimation((Animation)localObject);
  }
  
  private void r()
  {
    this.A = false;
    Object localObject = ObjectAnimator.ofFloat(this, "translationY", new float[] { 0.0F, this.a });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play((Animator)localObject);
    localAnimatorSet.addListener(new DYAEProviderContainerView.20(this));
    localAnimatorSet.setDuration(300L).start();
    localObject = QIMAnimationUtils.a(this, 1.0F, 0.0F);
    ((Animation)localObject).setStartOffset(0L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new DYAEProviderContainerView.21(this));
    startAnimation((Animation)localObject);
  }
  
  private void s()
  {
    if (AECameraEntryManager.o(((Activity)getContext()).getIntent()))
    {
      int i1 = AEBeautyProviderView.getBeautyFeature();
      HashMap localHashMap;
      if (i1 != this.F)
      {
        localHashMap = new HashMap();
        localHashMap.put("ext15", String.valueOf(i1));
        AEReportUtils.a(12, 3, localHashMap);
      }
      i1 = AEBeautyProviderView.getSharpFaceFeature();
      if (i1 != this.G)
      {
        localHashMap = new HashMap();
        localHashMap.put("ext15", String.valueOf(i1));
        AEReportUtils.a(12, 4, localHashMap);
      }
    }
  }
  
  private void t()
  {
    VideoReport.setElementId(this.e, "em_xsj_beauty_tab");
    VideoReport.setElementParams(this.e, FlashShowDtReportHelper.a().d());
    VideoReport.reportEvent("dt_clck", this.e, null);
    AECameraDaTongHelper.a.a(this.e, "em_ae_beauty_tab");
    AECameraDaTongHelper.a.a(this.e, null);
  }
  
  private void u()
  {
    VideoReport.setElementId(this.e, "em_xsj_makeup_tab");
    VideoReport.setElementParams(this.e, FlashShowDtReportHelper.a().d());
    VideoReport.reportEvent("dt_clck", this.e, null);
    AECameraDaTongHelper.a.a(this.e, "em_ae_cosmetic_tab");
    AECameraDaTongHelper.a.a(this.e, null);
  }
  
  private void v()
  {
    VideoReport.setElementId(this.h, "em_xsj_beauty_ai");
    VideoReport.setElementParams(this.h, FlashShowDtReportHelper.a().d());
    VideoReport.reportEvent("dt_clck", this.h, null);
  }
  
  private void w()
  {
    VideoReport.setElementId(this.i, "em_xsj_beauty_ai_explain");
    VideoReport.setElementParams(this.i, FlashShowDtReportHelper.a().d());
    VideoReport.reportEvent("dt_clck", this.i, null);
  }
  
  public void a()
  {
    DYAEFilterProviderView localDYAEFilterProviderView = this.o;
    if (localDYAEFilterProviderView != null) {
      localDYAEFilterProviderView.f();
    }
  }
  
  public void a(int paramInt)
  {
    this.e.a(paramInt);
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    this.H = DYAEBeautyPanelConfigHolder.a();
    paramContext = LayoutInflater.from(paramContext).inflate(2064056502, this);
    this.b = paramContext.findViewById(2063991293);
    this.b.setBackgroundResource(this.H.a());
    a(paramContext);
    b(paramContext);
    c(paramContext);
  }
  
  public void a(StartPointSeekBar paramStartPointSeekBar)
  {
    paramStartPointSeekBar = this.u;
    if (paramStartPointSeekBar != null)
    {
      paramStartPointSeekBar = (SeekBarOpDataWrapper)paramStartPointSeekBar.d().getValue();
      if (paramStartPointSeekBar == null) {
        return;
      }
      paramStartPointSeekBar = paramStartPointSeekBar.b();
      if (paramStartPointSeekBar == null) {
        return;
      }
      this.u.a();
      Object localObject;
      if ((paramStartPointSeekBar instanceof AEBeautyConfigModel))
      {
        paramStartPointSeekBar = (AEBeautyConfigModel)paramStartPointSeekBar;
        localObject = AEProviderViewModel.b(paramStartPointSeekBar);
        if (localObject == null) {
          paramStartPointSeekBar = paramStartPointSeekBar.b();
        } else {
          paramStartPointSeekBar = ((AEBeautySecondaryConfigModel)localObject).b();
        }
        AEBaseDataReporter.a().j(paramStartPointSeekBar);
        return;
      }
      if ((paramStartPointSeekBar instanceof DYAEEffectItem))
      {
        localObject = (DYAEEffectItem)paramStartPointSeekBar;
        AEBaseDataReporter.a().c(((DYAEEffectItem)localObject).b(), AEProviderViewModel.a(paramStartPointSeekBar));
        return;
      }
      if ((paramStartPointSeekBar instanceof QIMFilterCategoryItem))
      {
        localObject = (QIMFilterCategoryItem)paramStartPointSeekBar;
        AEBaseDataReporter.a().f(((QIMFilterCategoryItem)localObject).a, AEProviderViewModel.a(paramStartPointSeekBar));
      }
    }
  }
  
  public void a(StartPointSeekBar paramStartPointSeekBar, int paramInt)
  {
    Object localObject1 = this.u;
    if (localObject1 != null)
    {
      localObject1 = (SeekBarOpDataWrapper)((AEProviderViewModel)localObject1).d().getValue();
      if (localObject1 == null) {
        return;
      }
      Object localObject2 = ((SeekBarOpDataWrapper)localObject1).b();
      if (localObject2 == null) {
        return;
      }
      AEProviderViewModel.c(localObject2, paramInt);
      AEPituCameraUnit localAEPituCameraUnit = (AEPituCameraUnit)this.D.a(65537, new Object[0]);
      if (localAEPituCameraUnit != null) {
        localAEPituCameraUnit.a(((SeekBarOpDataWrapper)localObject1).a(), localObject2, paramInt, true);
      }
    }
    StartPointSeekBar.a(paramStartPointSeekBar, Math.round(paramInt), this.t);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.A) {
      r();
    }
    Object localObject = this.o;
    if (localObject != null)
    {
      ((DYAEFilterProviderView)localObject).d();
      this.o.setVisibility(8);
    }
    localObject = this.p;
    if (localObject != null)
    {
      ((DYAEBeautyProviderView)localObject).d();
      this.p.setVisibility(8);
      s();
    }
    localObject = this.r;
    if (localObject != null)
    {
      ((AECosmeticsProviderView)localObject).b();
      this.r.setVisibility(8);
    }
    localObject = this.D;
    if (localObject != null) {
      ((VideoStoryCapturePartManager)localObject).b(196613, new Object[0]);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AEProviderContainerView", 2, "panel closed");
    }
  }
  
  public void b()
  {
    DYAEFilterProviderView localDYAEFilterProviderView = this.o;
    if (localDYAEFilterProviderView != null) {
      localDYAEFilterProviderView.b();
    }
    VideoFilterTools.a().b(null, (Activity)getContext(), 0);
    VideoFilterTools.a().a(null, 0);
    ((CaptureComboManager)QIMManager.a(5)).a((Activity)getContext());
  }
  
  public void b(StartPointSeekBar paramStartPointSeekBar)
  {
    Object localObject1 = this.u;
    if (localObject1 != null)
    {
      localObject1 = (SeekBarOpDataWrapper)((AEProviderViewModel)localObject1).d().getValue();
      if (localObject1 == null) {
        return;
      }
      Object localObject2 = ((SeekBarOpDataWrapper)localObject1).b();
      if (localObject2 == null) {
        return;
      }
      int i1 = (int)paramStartPointSeekBar.getProgress();
      AEProviderViewModel.c(localObject2, i1);
      AEProviderViewModel.b(localObject2, i1);
      paramStartPointSeekBar = this.u;
      if (paramStartPointSeekBar != null) {
        paramStartPointSeekBar.a(localObject2, i1);
      }
      paramStartPointSeekBar = (AEPituCameraUnit)this.D.a(65537, new Object[0]);
      if (paramStartPointSeekBar != null) {
        paramStartPointSeekBar.a(((SeekBarOpDataWrapper)localObject1).a(), localObject2, i1, true);
      }
    }
  }
  
  public void c()
  {
    Object localObject = this.o;
    if (localObject != null)
    {
      ((DYAEFilterProviderView)localObject).a();
      this.o = null;
    }
    localObject = this.p;
    if (localObject != null)
    {
      ((DYAEBeautyProviderView)localObject).b();
      this.p = null;
    }
    localObject = this.r;
    if (localObject != null)
    {
      ((AECosmeticsProviderView)localObject).d();
      this.r = null;
    }
  }
  
  public void d()
  {
    DYTabLayout localDYTabLayout = this.e;
    if (localDYTabLayout == null) {
      return;
    }
    int i1 = localDYTabLayout.getSelectTabIndex();
    b(DYAEBeautyPanelConfigUtil.a(this.H, i1));
    q();
  }
  
  public boolean e()
  {
    return j() ^ true;
  }
  
  public void f()
  {
    Object localObject = this.o;
    if (localObject != null) {
      ((DYAEFilterProviderView)localObject).e();
    }
    localObject = this.p;
    if (localObject != null) {
      ((DYAEBeautyProviderView)localObject).a();
    }
    localObject = this.r;
    if (localObject != null) {
      ((AECosmeticsProviderView)localObject).c();
    }
  }
  
  public void g() {}
  
  public void h()
  {
    a(true);
  }
  
  public boolean i()
  {
    return this.E == AECaptureMode.GIF;
  }
  
  public boolean j()
  {
    Object localObject = this.o;
    boolean bool2 = false;
    if ((localObject == null) && (this.p == null) && (this.r == null)) {
      return false;
    }
    localObject = this.o;
    boolean bool1;
    if (localObject != null)
    {
      if (((DYAEFilterProviderView)localObject).getVisibility() == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      bool4 = bool1 | false;
    }
    else
    {
      bool4 = false;
    }
    localObject = this.p;
    boolean bool3 = bool4;
    if (localObject != null)
    {
      if (((DYAEBeautyProviderView)localObject).getVisibility() == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      bool3 = bool4 | bool1;
    }
    localObject = this.r;
    boolean bool4 = bool3;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((AECosmeticsProviderView)localObject).getVisibility() == 0) {
        bool1 = true;
      }
      bool4 = bool3 | bool1;
    }
    return bool4;
  }
  
  public void setCaptureMode(AECaptureMode paramAECaptureMode)
  {
    this.E = paramAECaptureMode;
  }
  
  public void setControllerAndManager(AECaptureController paramAECaptureController, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    this.C = paramAECaptureController;
    this.D = paramVideoStoryCapturePartManager;
    l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.DYAEProviderContainerView
 * JD-Core Version:    0.7.0.1
 */