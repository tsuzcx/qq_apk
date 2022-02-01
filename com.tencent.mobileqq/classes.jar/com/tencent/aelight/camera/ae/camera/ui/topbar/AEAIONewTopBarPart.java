package com.tencent.aelight.camera.ae.camera.ui.topbar;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.LinearLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.aelight.camera.ae.AECameraConfig;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.AEViewModelProviders;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.mode.AEVideoStoryCaptureModeViewModel;
import com.tencent.aelight.camera.ae.part.AEVideoStoryStateViewModel;
import com.tencent.aelight.camera.ae.part.VideoStoryBasePart;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.view.AECompoundButton;
import com.tencent.aelight.camera.aioeditor.capture.view.PressScaleAnimDelegate;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.videostory.support.VSReporter;
import org.light.DeviceSupportUtil;

public class AEAIONewTopBarPart
  extends VideoStoryBasePart
  implements View.OnClickListener
{
  public AECompoundButton a;
  boolean b = false;
  private int c = 3;
  private AEVideoStoryCaptureModeViewModel d;
  private AEVideoStoryStateViewModel e;
  private AEVideoStoryTopBarViewModel f;
  private AEPituCameraUnit g;
  private View h;
  private LinearLayout i;
  private AECompoundButton j;
  private AECompoundButton k;
  private AECompoundButton l;
  private AECompoundButton m;
  private AECompoundButton n;
  private AECaptureMode o;
  
  public AEAIONewTopBarPart(Activity paramActivity, View paramView, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    super(paramActivity, paramView, paramVideoStoryCapturePartManager);
    this.g = ((AEPituCameraUnit)paramVideoStoryCapturePartManager.a(65537, new Object[0]));
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.d.a())
      {
        try
        {
          paramBoolean = DeviceSupportUtil.isAbilityDeviceSupport("shareGLContextError");
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[DeviceSupportUtil.isAbilityDeviceSupport] e = ");
          localStringBuilder.append(localException.toString());
          AEQLog.d("AEVideoStoryTopBarPart", localStringBuilder.toString());
          paramBoolean = false;
        }
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[switchOnLowPriorityTopBtns]: deviceNotSupportSegment = ");
        ((StringBuilder)localObject).append(paramBoolean);
        AEQLog.a("AEVideoStoryTopBarPart", ((StringBuilder)localObject).toString());
        localObject = this.n;
        int i1;
        if (paramBoolean) {
          i1 = 8;
        } else {
          i1 = 0;
        }
        ((AECompoundButton)localObject).setVisibility(i1);
        this.m.setVisibility(0);
      }
      this.l.setVisibility(0);
    }
    else
    {
      if (this.d.a())
      {
        this.n.setVisibility(8);
        this.m.setVisibility(8);
      }
      this.l.setVisibility(8);
    }
    if (a()) {
      this.l.setVisibility(8);
    }
  }
  
  private void b()
  {
    this.d = ((AEVideoStoryCaptureModeViewModel)AEViewModelProviders.a(this.g).get(AEVideoStoryCaptureModeViewModel.class));
    this.f = ((AEVideoStoryTopBarViewModel)AEViewModelProviders.a(this.g).get(AEVideoStoryTopBarViewModel.class));
    this.f.b().observe(this.g, new AEAIONewTopBarPart.1(this));
    this.f.a().observe(this.g, new AEAIONewTopBarPart.2(this));
    this.d.a.observe(this.g, new AEAIONewTopBarPart.3(this));
    this.f.d().observe(this.g, new AEAIONewTopBarPart.4(this));
    this.e = ((AEVideoStoryStateViewModel)AEViewModelProviders.a(this.g).get(AEVideoStoryStateViewModel.class));
    this.e.a().observe(this.g, new AEAIONewTopBarPart.5(this));
    this.e.b().observe(this.g, new AEAIONewTopBarPart.6(this));
    this.e.c().observe(this.g, new AEAIONewTopBarPart.7(this));
    this.e.d().observe(this.g, new AEAIONewTopBarPart.8(this));
  }
  
  private boolean c()
  {
    Object localObject = this.f;
    boolean bool = false;
    if (localObject != null)
    {
      if (((AEVideoStoryTopBarViewModel)localObject).d() == null) {
        return false;
      }
      localObject = (Boolean)this.f.d().getValue();
      if (localObject == null) {
        return false;
      }
      bool = ((Boolean)localObject).booleanValue();
    }
    return bool;
  }
  
  protected boolean a()
  {
    return (!this.g.u().f()) || (!this.g.u().i()) || (!this.g.u().d());
  }
  
  protected void initView()
  {
    ViewStub localViewStub = (ViewStub)this.mRootView.findViewById(2063991455);
    this.b = AECameraEntryManager.k(this.mActivity.getIntent());
    if (localViewStub != null) {
      this.h = localViewStub.inflate();
    }
    this.h = this.mRootView.findViewById(2063990872);
    this.i = ((LinearLayout)this.mRootView.findViewById(2063990940));
    this.a = ((AECompoundButton)this.h.findViewById(2063990955));
    this.a.setOnClickListener(this);
    this.k = ((AECompoundButton)this.h.findViewById(2063990956));
    this.k.setOnClickListener(this);
    this.j = ((AECompoundButton)this.h.findViewById(2063990965));
    this.l = ((AECompoundButton)this.h.findViewById(2063990903));
    this.l.setOnClickListener(this);
    this.m = ((AECompoundButton)this.h.findViewById(2063990987));
    this.m.setOnClickListener(this);
    this.n = ((AECompoundButton)this.h.findViewById(2063991464));
    this.n.setOnClickListener(this);
    this.n.setSelected(false);
    b();
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    Object localObject = this.f;
    if ((localObject != null) && (((AEVideoStoryTopBarViewModel)localObject).d() != null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("【抠背开关】-> onResume -> post:");
      ((StringBuilder)localObject).append(c());
      AEQLog.a("AEVideoStoryTopBarPart", ((StringBuilder)localObject).toString());
      this.f.d().postValue(Boolean.valueOf(c()));
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    int i2 = 0;
    switch (i1)
    {
    default: 
    case 2063991464: 
      PressScaleAnimDelegate.a(this.n.getForegroundView(), 200L, null);
      boolean bool = c();
      paramView = new StringBuilder();
      paramView.append("【抠背开关】-> 点击 ->post:");
      paramView.append(bool ^ true);
      AEQLog.a("AEVideoStoryTopBarPart", paramView.toString());
      this.f.d().postValue(Boolean.valueOf(bool ^ true));
      if (this.d.a())
      {
        AEBaseReportParam.a().g(bool ^ true);
        AEBaseDataReporter.a().as();
        return;
      }
      break;
    case 2063990987: 
      PressScaleAnimDelegate.a(this.m.getForegroundView(), 200L, null);
      paramView = (AEVideoStoryTopBarViewModel.CountDownSetting)this.f.b().getValue();
      i1 = i2;
      if (paramView != null)
      {
        i1 = i2;
        if (paramView.a()) {
          i1 = 1;
        }
      }
      this.f.b().postValue(new AEVideoStoryTopBarViewModel.CountDownSetting(i1 ^ 0x1, this.c));
      if (this.d.a())
      {
        AEBaseReportParam.a().h(i1 ^ 0x1);
        return;
      }
      break;
    case 2063990955: 
    case 2063990956: 
      PressScaleAnimDelegate.a(paramView, 200L, null);
      this.g.ax();
      return;
    case 2063990933: 
      if (this.mPartManager != null)
      {
        AEBaseDataReporter.a().az();
        this.mPartManager.b(131078, new Object[0]);
        return;
      }
      break;
    case 2063990903: 
      AEBaseDataReporter.a().R();
      PressScaleAnimDelegate.a(this.l.getForegroundView(), 200L, null);
      VSReporter.a("mystatus_shoot", "beauty_clk", 0, 0, new String[0]);
      if (AEDashboardUtil.d()) {
        AEBaseDataReporter.a().ae();
      }
      if (this.mPartManager != null)
      {
        if (this.e.g())
        {
          this.mPartManager.b(327686, new Object[0]);
          return;
        }
        if (this.e.h()) {
          return;
        }
        this.mPartManager.b(131077, new Object[0]);
      }
      break;
    }
  }
  
  public void send(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 458753) {
      return;
    }
    paramVarArgs = this.f;
    if ((paramVarArgs != null) && (paramVarArgs.d() != null))
    {
      paramVarArgs = new StringBuilder();
      paramVarArgs.append("【抠背开关】-> 相机启动检查 -> post:");
      paramVarArgs.append(c());
      AEQLog.a("AEVideoStoryTopBarPart", paramVarArgs.toString());
      this.f.d().postValue(Boolean.valueOf(c()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.topbar.AEAIONewTopBarPart
 * JD-Core Version:    0.7.0.1
 */