package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.aelight.camera.ae.AEMaterialViewModel;
import com.tencent.aelight.camera.ae.AEViewModelProviders;
import com.tencent.aelight.camera.ae.camera.ui.panel.AECosmeticsViewModel;
import com.tencent.aelight.camera.ae.camera.ui.panel.BeautyAndFilterPanel;
import com.tencent.aelight.camera.ae.camera.ui.panel.DYAEBeautyPanelConfigHolder;
import com.tencent.aelight.camera.ae.camera.ui.panel.DYAEBeautyPanelConfigUtil;
import com.tencent.aelight.camera.ae.camera.ui.panel.DYBeautyAndFilterPanelViewStubHolder;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import com.tencent.aelight.camera.ae.control.AEQIMManager;
import com.tencent.aelight.camera.ae.data.AEMaterialCategory;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.flashshow.AEFlashShowCameraUnit;
import com.tencent.aelight.camera.ae.part.AEVideoStoryStateViewModel;
import com.tencent.aelight.camera.ae.part.VideoStoryBasePart;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.ae.view.CountDownView;
import com.tencent.aelight.camera.aioeditor.capture.util.QIMAnimationUtils;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.common.Observer;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class AEFlashShowBottomPart
  extends VideoStoryBasePart
  implements Observer
{
  private String A;
  private AEFlashCameraCaptureButtonLayout.IStartCaptureCallBack B = new AEFlashShowBottomPart.6(this);
  public int a = e();
  boolean b = false;
  private AEFlashShowCameraUnit c;
  private AEVideoStoryTopBarViewModel d;
  private AEFlashShowBottomPanelViewModel e;
  private CountDownView f;
  private AEFlashCameraCaptureButtonLayout g;
  private AEFlashShowChangeModeViewModel h;
  private AEVideoStoryStateViewModel i;
  private AEFlashShowBottomPanelViewModel j;
  private MusicSourceViewModel k;
  private MusicVolumeControlViewModel l;
  private AEMaterialViewModel m;
  private AECosmeticsViewModel n;
  private AEFlashSHOWFilterViewModel o;
  private ImageView p;
  private AEFlashShowMaterialManager q;
  private boolean r = false;
  private View s;
  private AEFlashShowMaterialFavoriteView t;
  private AEFlashShowMaterialPanel u;
  private View v;
  private BeautyAndFilterPanel w;
  private Context x;
  private View y;
  private AEFlashShowFilterPanelViewHolder z;
  
  public AEFlashShowBottomPart(Activity paramActivity, View paramView, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    super(paramActivity, paramView, paramVideoStoryCapturePartManager);
    this.c = ((AEFlashShowCameraUnit)paramVideoStoryCapturePartManager.a(65537, new Object[0]));
    this.x = paramActivity;
    b();
    paramActivity = paramActivity.getIntent();
    if (paramActivity != null)
    {
      paramActivity = (HashMap)paramActivity.getSerializableExtra("key_attrs");
      if ((paramActivity != null) && (!paramActivity.isEmpty()) && (paramActivity.containsKey("meterial")) && (!TextUtils.isEmpty((CharSequence)paramActivity.get("meterial")))) {
        this.A = ((String)paramActivity.get("meterial"));
      }
    }
  }
  
  private void a()
  {
    Object localObject = this.q.c(false);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      if (((List)localObject).size() < 2) {
        return;
      }
      localObject = ((AEMaterialCategory)((List)localObject).get(1)).a;
      if (localObject != null)
      {
        if (((List)localObject).isEmpty()) {
          return;
        }
        localObject = (AEMaterialMetaData)((List)localObject).get(0);
        if (localObject == null) {
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateEntranceData");
        localStringBuilder.append(((AEMaterialMetaData)localObject).q);
        AEQLog.a("AEFlashShowBottomPart", localStringBuilder.toString());
        if (this.p != null) {
          a((AEMaterialMetaData)localObject);
        }
      }
    }
  }
  
  private void a(Runnable paramRunnable)
  {
    Object localObject = new AnimatorSet();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "translationY", new float[] { this.a, 0.0F });
    localObjectAnimator.addUpdateListener(new AEFlashShowBottomPart.18(this));
    ((AnimatorSet)localObject).play(localObjectAnimator);
    ((AnimatorSet)localObject).addListener(new AEFlashShowBottomPart.19(this));
    ((AnimatorSet)localObject).setDuration(300L).start();
    localObject = QIMAnimationUtils.a(this.y, 0.0F, 1.0F);
    ((Animation)localObject).setStartOffset(200L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new AEFlashShowBottomPart.20(this, paramRunnable));
    this.y.startAnimation((Animation)localObject);
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("start apply preset material, once = ");
    ((StringBuilder)localObject1).append(paramBoolean);
    AEQLog.b("AEFlashShowBottomPart", ((StringBuilder)localObject1).toString());
    if (TextUtils.isEmpty(this.A)) {
      return;
    }
    Iterator localIterator1 = this.q.c(false).iterator();
    localObject1 = null;
    for (;;)
    {
      if (!localIterator1.hasNext()) {
        break label135;
      }
      Object localObject2 = ((AEMaterialCategory)localIterator1.next()).a;
      if (localObject2 != null)
      {
        Iterator localIterator2 = ((List)localObject2).iterator();
        if (localIterator2.hasNext())
        {
          localObject2 = (AEMaterialMetaData)localIterator2.next();
          if (!TextUtils.equals(this.A, ((AEMaterialMetaData)localObject2).m)) {
            break;
          }
          localObject1 = localObject2;
        }
      }
    }
    label135:
    if (localObject1 != null) {
      this.e.a().postValue(new MaterialPanelOpenState(true, (AEMaterialMetaData)localObject1));
    }
    if ((paramBoolean) || (localObject1 != null)) {
      this.A = null;
    }
  }
  
  private void b()
  {
    this.q = ((AEFlashShowMaterialManager)AEQIMManager.a(3));
    this.q.b(false);
  }
  
  private void b(Runnable paramRunnable)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "translationY", new float[] { 0.0F, this.a });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator);
    localAnimatorSet.addListener(new AEFlashShowBottomPart.21(this, paramRunnable));
    localAnimatorSet.setDuration(300L).start();
    paramRunnable = QIMAnimationUtils.a(this.y, 1.0F, 0.0F);
    paramRunnable.setStartOffset(0L);
    paramRunnable.setDuration(100L);
    paramRunnable.setAnimationListener(new AEFlashShowBottomPart.22(this));
    this.y.startAnimation(paramRunnable);
  }
  
  private void c()
  {
    this.y = this.mRootView.findViewById(2063991110);
    this.g = ((AEFlashCameraCaptureButtonLayout)this.mRootView.findViewById(2063990959));
    this.g.setStartCallBack(this.B);
    this.s = this.mRootView.findViewById(2063990920);
    this.s.setOnClickListener(new AEFlashShowBottomPart.2(this));
    this.v = this.mRootView.findViewById(2063990913);
    this.v.setOnClickListener(new AEFlashShowBottomPart.3(this));
    View localView = ((ViewStub)this.mRootView.findViewById(2063991450)).inflate();
    this.t = ((AEFlashShowMaterialFavoriteView)localView.findViewById(2063991114));
    this.t.setOnClickListener(new AEFlashShowBottomPart.4(this));
    this.u = ((AEFlashShowMaterialPanel)localView.findViewById(2063991113));
    this.e = ((AEFlashShowBottomPanelViewModel)AEViewModelProviders.a(this.c).get(AEFlashShowBottomPanelViewModel.class));
    this.u.setPartManager(this.mPartManager);
    this.u.setCaptureController(this.c.am());
    this.u.setMaterialPanelListener(new AEFlashShowBottomPart.5(this));
    DYAEBeautyPanelConfigHolder.a(DYAEBeautyPanelConfigUtil.b());
    this.w = new DYBeautyAndFilterPanelViewStubHolder((ViewStub)this.mRootView.findViewById(2063991457), false);
    this.w.a(this.c.am(), this.mPartManager);
    this.z = new AEFlashShowFilterPanelViewHolder((ViewStub)this.mRootView.findViewById(2063991440));
    this.z.a(this.c.am(), this.mPartManager);
    this.p = ((ImageView)this.mRootView.findViewById(2063991257));
    VideoReport.setElementId(this.s, "em_xsj_props_button");
    VideoReport.setElementId(this.v, "em_xsj_beauty_button");
    VideoReport.setElementId(this.g, "em_xsj_shoot_button");
  }
  
  private void d()
  {
    this.o = ((AEFlashSHOWFilterViewModel)AEViewModelProviders.a(this.c).get(AEFlashSHOWFilterViewModel.class));
    this.n = ((AECosmeticsViewModel)AEViewModelProviders.a(this.c).get(AECosmeticsViewModel.class));
    this.m = ((AEMaterialViewModel)AEViewModelProviders.a(this.c).get(AEMaterialViewModel.class));
    this.l = ((MusicVolumeControlViewModel)AEViewModelProviders.a(this.c).get(MusicVolumeControlViewModel.class));
    this.k = ((MusicSourceViewModel)AEViewModelProviders.a(this.c).get(MusicSourceViewModel.class));
    this.d = ((AEVideoStoryTopBarViewModel)AEViewModelProviders.a(this.c).get(AEVideoStoryTopBarViewModel.class));
    this.d.b().observe(this.c, new AEFlashShowBottomPart.7(this));
    this.d.c().observe(this.c, new AEFlashShowBottomPart.8(this));
    AEFlashShowBottomPanelViewModel.k().observe(this.c, new AEFlashShowBottomPart.9(this));
    AEFlashShowBottomPanelViewModel.l().observe(this.c, new AEFlashShowBottomPart.10(this));
    this.e = ((AEFlashShowBottomPanelViewModel)AEViewModelProviders.a(this.c).get(AEFlashShowBottomPanelViewModel.class));
    this.e.a().observe(this.c, new AEFlashShowBottomPart.11(this));
    this.e.b().observe(this.c, new AEFlashShowBottomPart.12(this));
    this.e.c().observe(this.c, new AEFlashShowBottomPart.13(this));
    this.h = ((AEFlashShowChangeModeViewModel)AEViewModelProviders.a(this.c).get(AEFlashShowChangeModeViewModel.class));
    this.h.a().observe(this.c, new AEFlashShowBottomPart.14(this));
    this.i = ((AEVideoStoryStateViewModel)AEViewModelProviders.a(this.c).get(AEVideoStoryStateViewModel.class));
    this.i.a().observe(this.c, new AEFlashShowBottomPart.15(this));
    this.j = ((AEFlashShowBottomPanelViewModel)AEViewModelProviders.a(this.c).get(AEFlashShowBottomPanelViewModel.class));
    this.j.f().observe(this.c, new AEFlashShowBottomPart.16(this));
    this.j.e().observe(this.c, new AEFlashShowBottomPart.17(this));
  }
  
  private int e()
  {
    return UIUtils.a(this.x, 200.0F);
  }
  
  private void f()
  {
    if (this.f != null) {
      return;
    }
    this.f = ((CountDownView)((ViewStub)this.mRootView.findViewById(2063990789)).inflate().findViewById(2063990791));
    this.f.setCountDownListener(new AEFlashShowBottomPart.23(this));
  }
  
  public void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    ThreadManager.getUIHandler().post(new AEFlashShowBottomPart.1(this, paramAEMaterialMetaData));
  }
  
  public <T> T get(int paramInt, Object... paramVarArgs)
  {
    return super.get(paramInt, paramVarArgs);
  }
  
  public ViewStub getStub()
  {
    return super.getStub();
  }
  
  protected void initView()
  {
    if (this.mRootView == null) {
      return;
    }
    ViewStub localViewStub = (ViewStub)this.mRootView.findViewById(2063991433);
    if (localViewStub != null) {
      localViewStub.inflate();
    }
    c();
    d();
    b();
  }
  
  public void notify(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    a();
    a(true);
  }
  
  public void onActivityPause()
  {
    super.onActivityPause();
    this.q.a(this);
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    View localView = this.y;
    if (localView != null) {
      localView.setVisibility(0);
    }
    this.q.a(this, 116);
    a();
    a(false);
  }
  
  public void onActivityStart()
  {
    super.onActivityStart();
  }
  
  public void onActivityStop()
  {
    super.onActivityStop();
    AEFlashShowMaterialPanel localAEFlashShowMaterialPanel = this.u;
    if (localAEFlashShowMaterialPanel != null) {
      localAEFlashShowMaterialPanel.d();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    AEFlashShowMaterialPanel localAEFlashShowMaterialPanel = this.u;
    if (localAEFlashShowMaterialPanel != null) {
      localAEFlashShowMaterialPanel.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowBottomPart
 * JD-Core Version:    0.7.0.1
 */