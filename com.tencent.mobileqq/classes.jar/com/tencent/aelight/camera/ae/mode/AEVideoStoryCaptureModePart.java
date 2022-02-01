package com.tencent.aelight.camera.ae.mode;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.AEViewModelProviders;
import com.tencent.aelight.camera.ae.control.AEQIMManager;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.part.AEVideoStoryStateViewModel;
import com.tencent.aelight.camera.ae.part.VideoStoryBasePart;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.aioeditor.shortvideo.util.ScreenUtil;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;

public class AEVideoStoryCaptureModePart
  extends VideoStoryBasePart
{
  private AEVideoStoryCaptureModeViewModel a;
  private AEVideoStoryStateViewModel b;
  private AEPituCameraUnit c;
  private View d;
  private AECaptureModeSelectPager e;
  private PagerAdapter f;
  private ImageView g;
  private boolean h;
  private boolean i;
  private RelativeLayout j;
  private AECaptureMode[] k;
  private AECaptureMode l;
  
  public AEVideoStoryCaptureModePart(Activity paramActivity, View paramView, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    super(paramActivity, paramView, paramVideoStoryCapturePartManager);
    this.c = ((AEPituCameraUnit)paramVideoStoryCapturePartManager.a(65537, new Object[0]));
  }
  
  private void a()
  {
    this.a = ((AEVideoStoryCaptureModeViewModel)AEViewModelProviders.a(this.c).get(AEVideoStoryCaptureModeViewModel.class));
    this.a.a.observe(this.c, new AEVideoStoryCaptureModePart.2(this));
    this.b = ((AEVideoStoryStateViewModel)AEViewModelProviders.a(this.c).get(AEVideoStoryStateViewModel.class));
    this.b.a().observe(this.c, new AEVideoStoryCaptureModePart.3(this));
  }
  
  private void a(AECaptureMode paramAECaptureMode)
  {
    if (this.l == paramAECaptureMode) {
      return;
    }
    if (this.a.e()) {
      return;
    }
    this.a.a.postValue(new AECaptureModeChangingEvent(this.l, paramAECaptureMode, 0));
  }
  
  private void a(boolean paramBoolean)
  {
    View localView = this.d;
    if (localView == null) {
      return;
    }
    this.i = paramBoolean;
    if (paramBoolean)
    {
      if (localView.getVisibility() != 0) {
        this.d.setVisibility(0);
      }
    }
    else if (localView.getVisibility() == 0) {
      this.d.setVisibility(8);
    }
  }
  
  private AEMaterialManager b()
  {
    return (AEMaterialManager)AEQIMManager.a().b(1);
  }
  
  protected void initView()
  {
    Object localObject = (ViewStub)this.mRootView.findViewById(2063991435);
    if (localObject != null)
    {
      ((ViewStub)localObject).inflate();
      AEQLog.b("AEVideoStoryCaptureModePart", "AEPartAction--inflate captureMode");
    }
    this.d = this.mRootView.findViewById(2063991385);
    this.g = ((ImageView)this.d.findViewById(2063991176));
    this.e = ((AECaptureModeSelectPager)this.d.findViewById(2063991613));
    this.j = ((RelativeLayout)this.mRootView.findViewById(2063991108));
    int n = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
    int i1 = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
    int m = n;
    if (ScreenUtil.a(n, i1)) {
      m = i1 * 9 / 16;
    }
    m = (m - ViewUtils.dip2px(53.0F)) / 2;
    this.e.setPadding(m, 0, m, 0);
    localObject = this.e;
    boolean bool = true;
    ((AECaptureModeSelectPager)localObject).setDisableScroll(true);
    this.e.setOnPageChangeListener(new AEVideoStoryCaptureModePart.1(this));
    this.k = ((AECaptureMode[])((AEVideoStoryCaptureModeViewModel)AEViewModelProviders.a(this.c).get(AEVideoStoryCaptureModeViewModel.class)).b.getValue());
    localObject = this.k;
    if (localObject != null)
    {
      if (localObject.length <= 1) {
        bool = false;
      }
      a(bool);
    }
    this.f = new AEVideoStoryCaptureModePart.AECaptureModeAdapter(this, this.mRootView.getContext());
    this.e.setAdapter(this.f);
    a();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((this.mActivity != null) && (paramInt1 == 101) && (paramInt2 == 201)) {
      this.mActivity.finish();
    }
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    if (AECaptureMode.NORMAL == this.l)
    {
      AEPituCameraUnit localAEPituCameraUnit = this.c;
      if (localAEPituCameraUnit != null) {
        localAEPituCameraUnit.g(true);
      }
    }
  }
  
  public void send(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 393219: 
      a(AECaptureMode.PLAY);
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 1) && ((paramVarArgs[0] instanceof AEMaterialMetaData)))
    {
      if (this.l != AECaptureMode.PLAY) {
        return;
      }
      b().a((AEMaterialMetaData)paramVarArgs[0], true);
      Object localObject = this.c;
      if (localObject != null)
      {
        localObject = ((AEPituCameraUnit)localObject).s().getIntent();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("camera^");
        localStringBuilder.append(((AEMaterialMetaData)paramVarArgs[0]).m);
        ((Intent)localObject).putExtra("widgetinfo", localStringBuilder.toString());
      }
    }
    a(AECaptureMode.NORMAL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.mode.AEVideoStoryCaptureModePart
 * JD-Core Version:    0.7.0.1
 */