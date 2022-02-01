package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.AEViewModelProviders;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarPart;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.CountDownSetting;
import com.tencent.aelight.camera.ae.flashshow.FlashShowDtReportHelper;
import com.tencent.aelight.camera.ae.part.AEVideoStoryStateViewModel;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.ae.view.AECompoundButton;
import com.tencent.aelight.camera.aioeditor.capture.view.PressScaleAnimDelegate;
import com.tencent.qqlive.module.videoreport.VideoReport;

public class AEFlashShowRightBarPart
  extends AEVideoStoryTopBarPart
  implements View.OnClickListener
{
  View a;
  private AEPituCameraUnit h;
  private AECompoundButton i;
  private AEVideoStoryTopBarViewModel j;
  private AEVideoStoryStateViewModel k;
  private AEFlashShowChangeModeViewModel l;
  private AEFlashShowBottomPanelViewModel m;
  private AECompoundButton n;
  private View o;
  private View p;
  private View q;
  private int r = 3;
  private boolean s = true;
  private AEFlashCameraCaptureButtonLayout.Style t = AEFlashCameraCaptureButtonLayout.Style.PIC_STYLE;
  
  public AEFlashShowRightBarPart(Activity paramActivity, View paramView, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    super(paramActivity, paramView, paramVideoStoryCapturePartManager);
    this.h = ((AEPituCameraUnit)paramVideoStoryCapturePartManager.a(65537, new Object[0]));
  }
  
  private void b()
  {
    this.j = ((AEVideoStoryTopBarViewModel)AEViewModelProviders.a(this.h).get(AEVideoStoryTopBarViewModel.class));
    this.j.b().observe(this.h, new AEFlashShowRightBarPart.1(this));
    this.k = ((AEVideoStoryStateViewModel)AEViewModelProviders.a(this.h).get(AEVideoStoryStateViewModel.class));
    this.k.a().observe(this.h, new AEFlashShowRightBarPart.2(this));
    this.l = ((AEFlashShowChangeModeViewModel)AEViewModelProviders.a(this.h).get(AEFlashShowChangeModeViewModel.class));
    this.l.a().observe(this.h, new AEFlashShowRightBarPart.3(this));
    this.m = ((AEFlashShowBottomPanelViewModel)AEViewModelProviders.a(this.h).get(AEFlashShowBottomPanelViewModel.class));
    this.m.f().observe(this.h, new AEFlashShowRightBarPart.4(this));
    this.m.d().observe(this.h, new AEFlashShowRightBarPart.5(this));
    this.m.e().observe(this.h, new AEFlashShowRightBarPart.6(this));
  }
  
  public <T> T get(int paramInt, Object... paramVarArgs)
  {
    return super.get(paramInt, paramVarArgs);
  }
  
  protected void initView()
  {
    ViewStub localViewStub = (ViewStub)this.mRootView.findViewById(2063991453);
    this.a = this.mRootView.findViewById(2063990788);
    if (localViewStub != null) {
      this.a = localViewStub.inflate();
    }
    this.n = ((AECompoundButton)this.a.findViewById(2063991069));
    this.n.setOnClickListener(this);
    this.c = ((AECompoundButton)this.a.findViewById(2063991096));
    this.c.setOnClickListener(this);
    this.d = ((AECompoundButton)this.a.findViewById(2063990955));
    this.d.setOnClickListener(this);
    this.i = ((AECompoundButton)this.a.findViewById(2063991006));
    this.i.setOnClickListener(this);
    this.q = this.a.findViewById(2063991007);
    this.o = this.a.findViewById(2063991072);
    this.p = this.a.findViewById(2063991097);
    VideoReport.setElementId(this.n, "em_xsj_filter_button");
    VideoReport.setElementId(this.d, "em_xsj_close_button");
    b();
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2063990955)
    {
      if (i1 != 2063991006)
      {
        if (i1 == 2063991069)
        {
          this.m.c().postValue(Boolean.valueOf(true));
          VideoReport.reportEvent("dt_clck", this.n, FlashShowDtReportHelper.a().d());
        }
      }
      else
      {
        PressScaleAnimDelegate.a(this.i.getForegroundView(), 200L, null);
        i1 = this.r;
        if (i1 != 0)
        {
          if (i1 != 3)
          {
            if (i1 == 10) {
              this.i.getForegroundView().setImageResource(2063925322);
            }
          }
          else {
            this.i.getForegroundView().setImageResource(2063925323);
          }
        }
        else {
          this.i.getForegroundView().setImageResource(2063925321);
        }
        this.j.b().postValue(new AEVideoStoryTopBarViewModel.CountDownSetting(this.s, this.r));
      }
    }
    else {
      VideoReport.reportEvent("dt_clck", this.d, FlashShowDtReportHelper.a().d());
    }
    super.onClick(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void send(int paramInt, Object... paramVarArgs)
  {
    super.send(paramInt, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowRightBarPart
 * JD-Core Version:    0.7.0.1
 */