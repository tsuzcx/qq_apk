package com.tencent.aelight.camera.ae.camera.ui.topbar;

import android.app.Activity;
import android.content.res.Resources;
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
import com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowBottomPanelViewModel;
import com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowChangeModeViewModel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEBottomPanelViewModel;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.mode.AEVideoStoryCaptureModeViewModel;
import com.tencent.aelight.camera.ae.part.AEVideoStoryStateViewModel;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.report_datong.AECameraDaTongHelper;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.ae.util.AEPreviewSizeUtil;
import com.tencent.aelight.camera.ae.view.AECompoundButton;
import com.tencent.aelight.camera.aioeditor.CaptureReportUtil;
import com.tencent.aelight.camera.aioeditor.capture.view.PressScaleAnimDelegate;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.camera.utils.CameraUtils;
import com.tencent.mobileqq.richmedia.capture.util.ReportUtil;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.util.LiuHaiUtils;

public class AETopRightBarPart
  extends AEVideoStoryTopBarPart
  implements View.OnClickListener
{
  View a;
  private AEPituCameraUnit h;
  private AEVideoStoryTopBarViewModel i;
  private AEVideoStoryStateViewModel j;
  private AEFlashShowChangeModeViewModel k;
  private AEFlashShowBottomPanelViewModel l;
  private AEVideoStoryCaptureModeViewModel m;
  private AEBottomPanelViewModel n;
  private AECompoundButton o;
  private AECompoundButton p;
  private AECompoundButton q;
  private AECompoundButton r;
  private View s;
  private View t;
  private View u;
  private View v;
  private View w;
  private int x;
  private AECaptureMode y;
  
  public AETopRightBarPart(Activity paramActivity, View paramView, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    super(paramActivity, paramView, paramVideoStoryCapturePartManager);
    this.h = ((AEPituCameraUnit)paramVideoStoryCapturePartManager.a(65537, new Object[0]));
  }
  
  private void a(boolean paramBoolean)
  {
    int i1;
    if (paramBoolean) {
      i1 = 8;
    } else {
      i1 = 0;
    }
    this.w.setVisibility(i1);
    if (c()) {
      this.u.setVisibility(i1);
    } else {
      this.u.setVisibility(8);
    }
    this.t.setVisibility(i1);
    this.d.setVisibility(i1);
    if (paramBoolean) {
      this.v.setVisibility(8);
    }
  }
  
  private void b()
  {
    this.m = ((AEVideoStoryCaptureModeViewModel)AEViewModelProviders.a(this.h).get(AEVideoStoryCaptureModeViewModel.class));
    this.m.a.observe(this.h, new AETopRightBarPart.1(this));
    this.i = ((AEVideoStoryTopBarViewModel)AEViewModelProviders.a(this.h).get(AEVideoStoryTopBarViewModel.class));
    this.i.a().observe(this.h, new AETopRightBarPart.2(this));
    this.i.a.observe(this.h, new AETopRightBarPart.3(this));
    this.j = ((AEVideoStoryStateViewModel)AEViewModelProviders.a(this.h).get(AEVideoStoryStateViewModel.class));
    this.j.a().observe(this.h, new AETopRightBarPart.4(this));
    this.j.c().observe(this.h, new AETopRightBarPart.5(this));
    this.k = ((AEFlashShowChangeModeViewModel)AEViewModelProviders.a(this.h).get(AEFlashShowChangeModeViewModel.class));
    this.l = ((AEFlashShowBottomPanelViewModel)AEViewModelProviders.a(this.h).get(AEFlashShowBottomPanelViewModel.class));
    this.l.f().observe(this.h, new AETopRightBarPart.6(this));
    this.l.d().observe(this.h, new AETopRightBarPart.7(this));
    this.l.e().observe(this.h, new AETopRightBarPart.8(this));
    this.n = ((AEBottomPanelViewModel)AEViewModelProviders.a(this.h).get(AEBottomPanelViewModel.class));
    this.n.a().observe(this.h, new AETopRightBarPart.9(this));
  }
  
  private boolean c()
  {
    return d();
  }
  
  private boolean d()
  {
    Object localObject = AEPreviewSizeUtil.a();
    int i1 = ((Size)localObject).a();
    double d1 = ((Size)localObject).b();
    double d2 = i1;
    Double.isNaN(d2);
    Double.isNaN(d1);
    d1 /= d2 * 1.0D;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("adjustRatio value ");
    ((StringBuilder)localObject).append(d1);
    AEQLog.b("AETopRightBarPart", ((StringBuilder)localObject).toString());
    return d1 >= 1.973000049591065D;
  }
  
  public <T> T get(int paramInt, Object... paramVarArgs)
  {
    return super.get(paramInt, paramVarArgs);
  }
  
  protected void initView()
  {
    AEQLog.a("AETopRightBarPart", "initView");
    this.x = LiuHaiUtils.d;
    Object localObject = (ViewStub)this.mRootView.findViewById(2063991453);
    this.a = this.mRootView.findViewById(2063990788);
    if (localObject != null) {
      this.a = ((ViewStub)localObject).inflate();
    }
    this.q = ((AECompoundButton)this.a.findViewById(2063991259));
    this.w = this.a.findViewById(2063991260);
    this.q.setOnClickListener(this);
    this.o = ((AECompoundButton)this.a.findViewById(2063990965));
    this.o.setOnClickListener(this);
    localObject = this.o;
    ((AECompoundButton)localObject).setContentDescription(((AECompoundButton)localObject).getResources().getString(2064187700));
    if (!CameraUtils.d())
    {
      this.o.setVisibility(4);
      this.o.setEnabled(false);
    }
    AECameraDaTongHelper.a.a(this.o, "em_ae_switch_btn");
    this.u = this.a.findViewById(2063991352);
    this.p = ((AECompoundButton)this.a.findViewById(2063991351));
    this.p.setOnClickListener(this);
    if (this.p != null)
    {
      localObject = AEVideoStoryTopBarViewModel.Ratio.fromCode(AECameraPrefsUtil.a().b("sp_key_ae_camera_ratio", AEVideoStoryTopBarViewModel.Ratio.FULL.code, 0));
      if (localObject == AEVideoStoryTopBarViewModel.Ratio.FULL) {
        this.p.getForegroundView().setImageResource(2063925371);
      } else if (localObject == AEVideoStoryTopBarViewModel.Ratio.R_16_9) {
        this.p.getForegroundView().setImageResource(2063925370);
      }
    }
    this.s = this.a.findViewById(2063991367);
    this.c = ((AECompoundButton)this.a.findViewById(2063991096));
    this.c.setOnClickListener(this);
    this.v = this.a.findViewById(2063991008);
    this.v.setVisibility(8);
    this.r = ((AECompoundButton)this.a.findViewById(2063991009));
    this.r.setOnClickListener(this);
    this.r.setSelected(false);
    localObject = this.h;
    if ((localObject != null) && (((AEPituCameraUnit)localObject).ae))
    {
      localObject = this.h;
      ((AEPituCameraUnit)localObject).a(((AEPituCameraUnit)localObject).ae, this.v);
    }
    this.d = ((AECompoundButton)this.a.findViewById(2063990955));
    this.d.setOnClickListener(this);
    this.t = this.a.findViewById(2063991097);
    b();
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    boolean bool1 = false;
    Object localObject1;
    switch (i1)
    {
    default: 
      break;
    case 2063991351: 
      Object localObject2 = (AEVideoStoryTopBarViewModel.Ratio)this.i.a.getValue();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("adjustRatio screen radtio: ");
      ((StringBuilder)localObject1).append(localObject2);
      AEQLog.a("AETopRightBarPart", ((StringBuilder)localObject1).toString());
      if (localObject2 == AEVideoStoryTopBarViewModel.Ratio.FULL)
      {
        localObject1 = AEVideoStoryTopBarViewModel.Ratio.R_16_9;
        localObject2 = this.p;
        if (localObject2 != null) {
          ((AECompoundButton)localObject2).getForegroundView().setImageResource(2063925370);
        }
        this.i.a.setValue(localObject1);
      }
      else
      {
        localObject1 = localObject2;
        if (localObject2 == AEVideoStoryTopBarViewModel.Ratio.R_16_9)
        {
          localObject1 = AEVideoStoryTopBarViewModel.Ratio.FULL;
          localObject2 = this.p;
          if (localObject2 != null) {
            ((AECompoundButton)localObject2).getForegroundView().setImageResource(2063925371);
          }
          this.i.a.setValue(localObject1);
        }
      }
      if (localObject1 == AEVideoStoryTopBarViewModel.Ratio.R_16_9) {
        localObject1 = "16VS9";
      } else {
        localObject1 = "FULL";
      }
      AEBaseDataReporter.a().k((String)localObject1);
      break;
    case 2063991259: 
      AEBaseDataReporter.a().R();
      PressScaleAnimDelegate.a(this.q.getForegroundView(), 200L, null);
      VSReporter.a("mystatus_shoot", "beauty_clk", 0, 0, new String[0]);
      AEBaseDataReporter.a().ae();
      if (this.mPartManager != null) {
        if (this.j.g()) {
          this.mPartManager.b(327686, new Object[0]);
        } else {
          this.mPartManager.b(131077, new Object[0]);
        }
      }
      break;
    case 2063991009: 
      localObject1 = this.r;
      if (localObject1 != null)
      {
        PressScaleAnimDelegate.a(((AECompoundButton)localObject1).getForegroundView(), 200L, null);
        boolean bool2 = this.r.isSelected();
        i1 = 1;
        bool2 ^= true;
        this.r.setSelected(bool2);
        this.h.c(bool2);
        localObject1 = this.h;
        if (!bool2) {
          bool1 = true;
        }
        ((AEPituCameraUnit)localObject1).an = bool1;
        ReportUtil.a(bool2);
        if (!bool2) {
          i1 = 2;
        }
        CaptureReportUtil.a(i1);
      }
      break;
    case 2063990965: 
      localObject1 = this.h;
      if (localObject1 != null) {
        ((AEPituCameraUnit)localObject1).a(this.o);
      }
      break;
    case 2063990955: 
      VideoReport.reportEvent("dt_clck", this.d, null);
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
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.topbar.AETopRightBarPart
 * JD-Core Version:    0.7.0.1
 */