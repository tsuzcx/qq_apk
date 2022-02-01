package com.tencent.aelight.camera.ae.camera.ui.topbar;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
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
import com.tencent.aelight.camera.ae.util.AEFastClickThrottle;
import com.tencent.aelight.camera.ae.view.AECompoundButton;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aioeditor.CaptureReportUtil;
import com.tencent.aelight.camera.aioeditor.capture.view.PressScaleAnimDelegate;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.richmedia.capture.util.ReportUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import org.light.DeviceSupportUtil;

public class AEVideoStoryTopBarPart
  extends VideoStoryBasePart
  implements View.OnClickListener
{
  private int a = 3;
  protected AECompoundButton b;
  public AECompoundButton c;
  public AECompoundButton d;
  boolean e = false;
  boolean f = false;
  int g = 0;
  private AEVideoStoryCaptureModeViewModel h;
  private AEVideoStoryStateViewModel i;
  private AEVideoStoryTopBarViewModel j;
  private AEPituCameraUnit k;
  private View l;
  private View m;
  private LinearLayout n;
  private AECompoundButton o;
  private AECompoundButton p;
  private AECompoundButton q;
  private AECompoundButton r;
  private AECompoundButton s;
  private int t = 0;
  private boolean u;
  private TextView v;
  private AECaptureMode w;
  
  public AEVideoStoryTopBarPart(Activity paramActivity, View paramView, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    super(paramActivity, paramView, paramVideoStoryCapturePartManager);
    this.k = ((AEPituCameraUnit)paramVideoStoryCapturePartManager.a(65537, new Object[0]));
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      if (this.h.a())
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
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[switchOnLowPriorityTopBtns]: deviceNotSupportSegment = ");
        ((StringBuilder)localObject).append(paramBoolean);
        AEQLog.a("AEVideoStoryTopBarPart", ((StringBuilder)localObject).toString());
        localObject = this.s;
        int i1;
        if (paramBoolean) {
          i1 = 8;
        } else {
          i1 = 0;
        }
        ((AECompoundButton)localObject).setVisibility(i1);
        this.r.setVisibility(0);
        this.c.setVisibility(8);
      }
      else
      {
        this.c.setVisibility(0);
      }
      this.q.setVisibility(0);
      localObject = this.p;
      if (localObject != null) {
        ((AECompoundButton)localObject).setVisibility(0);
      }
    }
    else
    {
      if (this.h.a())
      {
        this.s.setVisibility(8);
        this.r.setVisibility(8);
      }
      this.b.setVisibility(8);
      this.c.setVisibility(8);
      this.q.setVisibility(8);
      localObject = this.p;
      if (localObject != null) {
        ((AECompoundButton)localObject).setVisibility(8);
      }
    }
    if (a()) {
      this.q.setVisibility(8);
    }
  }
  
  private boolean b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Build.MANUFACTURER);
    localStringBuilder.append(";");
    localStringBuilder.append(Build.MODEL);
    return "VIVO;V1836T".equalsIgnoreCase(localStringBuilder.toString());
  }
  
  private void c()
  {
    this.h = ((AEVideoStoryCaptureModeViewModel)AEViewModelProviders.a(this.k).get(AEVideoStoryCaptureModeViewModel.class));
    TextView localTextView = this.v;
    if (localTextView != null) {
      localTextView.setVisibility(8);
    }
    this.j = ((AEVideoStoryTopBarViewModel)AEViewModelProviders.a(this.k).get(AEVideoStoryTopBarViewModel.class));
    this.j.b().observe(this.k, new AEVideoStoryTopBarPart.1(this));
    this.j.a().observe(this.k, new AEVideoStoryTopBarPart.2(this));
    this.h.a.observe(this.k, new AEVideoStoryTopBarPart.3(this));
    this.j.d().observe(this.k, new AEVideoStoryTopBarPart.4(this));
    this.i = ((AEVideoStoryStateViewModel)AEViewModelProviders.a(this.k).get(AEVideoStoryStateViewModel.class));
    this.i.a().observe(this.k, new AEVideoStoryTopBarPart.5(this));
    this.i.b().observe(this.k, new AEVideoStoryTopBarPart.6(this));
    this.i.c().observe(this.k, new AEVideoStoryTopBarPart.7(this));
    this.i.d().observe(this.k, new AEVideoStoryTopBarPart.8(this));
  }
  
  private int d()
  {
    int i2 = this.t;
    Object localObject = this.mActivity.getIntent();
    int i1;
    if (!AECameraEntryManager.o((Intent)localObject))
    {
      i1 = i2;
      if (!AECameraEntryManager.p((Intent)localObject)) {}
    }
    else
    {
      int i3 = LiuHaiUtils.b(this.mActivity);
      i1 = i2;
      if (i2 < i3)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Circle camera, no LiuHai exists, statusBarHeight=");
        ((StringBuilder)localObject).append(i3);
        AEQLog.b("AEVideoStoryTopBarPart", ((StringBuilder)localObject).toString());
        i1 = i3;
      }
    }
    i2 = i1;
    if (b())
    {
      i2 = (int)(i1 + TypedValue.applyDimension(1, 20.0F, this.mActivity.getResources().getDisplayMetrics()));
      DisplayUtil.a(this.mActivity, 20.0F);
    }
    return i2;
  }
  
  private boolean e()
  {
    Object localObject = this.j;
    boolean bool = false;
    if (localObject != null)
    {
      if (((AEVideoStoryTopBarViewModel)localObject).d() == null) {
        return false;
      }
      localObject = (Boolean)this.j.d().getValue();
      if (localObject == null) {
        return false;
      }
      bool = ((Boolean)localObject).booleanValue();
    }
    return bool;
  }
  
  protected boolean a()
  {
    return (!this.k.u().f()) || (!this.k.u().i()) || (!this.k.u().d());
  }
  
  protected void initView()
  {
    Object localObject = (ViewStub)this.mRootView.findViewById(2063991454);
    this.t = LiuHaiUtils.d;
    this.e = AECameraEntryManager.k(this.mActivity.getIntent());
    this.f = AECameraEntryManager.o(this.mActivity.getIntent());
    if (localObject != null) {
      this.l = ((ViewStub)localObject).inflate();
    }
    this.l = this.mRootView.findViewById(2063991105);
    localObject = this.l;
    if (localObject != null)
    {
      localObject = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = d();
      this.l.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.m = this.l.findViewById(2063990958);
    this.n = ((LinearLayout)this.mRootView.findViewById(2063990940));
    this.d = ((AECompoundButton)this.l.findViewById(2063990955));
    this.d.setOnClickListener(this);
    this.o = ((AECompoundButton)this.l.findViewById(2063990965));
    this.b = ((AECompoundButton)this.l.findViewById(2063991009));
    this.b.setOnClickListener(this);
    this.b.setSelected(false);
    localObject = this.k;
    if ((localObject != null) && (((AEPituCameraUnit)localObject).ae))
    {
      localObject = this.k;
      ((AEPituCameraUnit)localObject).a(((AEPituCameraUnit)localObject).ae, this.b);
    }
    this.q = ((AECompoundButton)this.l.findViewById(2063990903));
    this.q.setOnClickListener(this);
    this.p = ((AECompoundButton)this.l.findViewById(2063990933));
    localObject = this.p;
    if (localObject != null) {
      ((AECompoundButton)localObject).setOnClickListener(this);
    }
    this.v = ((TextView)this.mRootView.findViewById(2063991495));
    localObject = this.v;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    this.c = ((AECompoundButton)this.l.findViewById(2063991096));
    this.r = ((AECompoundButton)this.l.findViewById(2063990987));
    this.r.setOnClickListener(this);
    this.s = ((AECompoundButton)this.l.findViewById(2063991464));
    this.s.setOnClickListener(this);
    this.s.setSelected(false);
    this.c.setOnClickListener(this);
    this.c.setSelected(this.u);
    c();
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    Object localObject = this.j;
    if ((localObject != null) && (((AEVideoStoryTopBarViewModel)localObject).d() != null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("【抠背开关】-> onResume -> post:");
      ((StringBuilder)localObject).append(e());
      AEQLog.a("AEVideoStoryTopBarPart", ((StringBuilder)localObject).toString());
      this.j.d().postValue(Boolean.valueOf(e()));
    }
    localObject = this.c;
    if (localObject != null) {
      ((AECompoundButton)localObject).setSelected(this.u);
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool1 = AECameraEntryManager.o(this.k.s().getIntent());
    int i3 = paramView.getId();
    int i1 = 1;
    int i2 = 0;
    switch (i3)
    {
    default: 
    case 2063991464: 
      PressScaleAnimDelegate.a(this.s.getForegroundView(), 200L, null);
      bool1 = e();
      paramView = new StringBuilder();
      paramView.append("【抠背开关】-> 点击 ->post:");
      paramView.append(bool1 ^ true);
      AEQLog.a("AEVideoStoryTopBarPart", paramView.toString());
      this.j.d().postValue(Boolean.valueOf(bool1 ^ true));
      if (this.h.a())
      {
        AEBaseReportParam.a().g(bool1 ^ true);
        AEBaseDataReporter.a().as();
        return;
      }
      break;
    case 2063991096: 
      PressScaleAnimDelegate.a(this.c.getForegroundView(), 200L, null);
      boolean bool2 = this.c.isSelected() ^ true;
      if (this.k.d(bool2))
      {
        this.u = bool2;
        this.c.setSelected(bool2);
        if (QLog.isDevelopLevel())
        {
          paramView = new StringBuilder();
          paramView.append("onClick, mFlashButton.setSelected(), on=");
          paramView.append(bool2);
          AEQLog.a("AEVideoStoryTopBarPart", paramView.toString());
        }
      }
      AEBaseDataReporter.a().M();
      if (bool1)
      {
        AEReportUtils.b(6, null);
        return;
      }
      break;
    case 2063991009: 
      paramView = this.b;
      if (paramView == null) {
        return;
      }
      PressScaleAnimDelegate.a(paramView.getForegroundView(), 200L, null);
      bool1 = this.b.isSelected() ^ true;
      this.b.setSelected(bool1);
      this.k.c(bool1);
      if (!bool1) {
        this.k.an = true;
      } else {
        this.k.an = false;
      }
      ReportUtil.a(bool1);
      if (!bool1) {
        i1 = 2;
      }
      CaptureReportUtil.a(i1);
      return;
    case 2063990987: 
      PressScaleAnimDelegate.a(this.r.getForegroundView(), 200L, null);
      paramView = (AEVideoStoryTopBarViewModel.CountDownSetting)this.j.b().getValue();
      i1 = i2;
      if (paramView != null)
      {
        i1 = i2;
        if (paramView.a()) {
          i1 = 1;
        }
      }
      this.j.b().postValue(new AEVideoStoryTopBarViewModel.CountDownSetting(i1 ^ 0x1, this.a));
      if (this.h.a())
      {
        AEBaseReportParam.a().h(i1 ^ 0x1);
        return;
      }
      break;
    case 2063990955: 
      PressScaleAnimDelegate.a(paramView, 200L, null);
      this.k.ax();
      if (bool1)
      {
        AEReportUtils.b(3, null);
        return;
      }
      break;
    case 2063990933: 
      if (this.mPartManager != null)
      {
        if (bool1)
        {
          if (AEFastClickThrottle.a(paramView)) {
            return;
          }
          paramView = new Intent();
          paramView.setAction("ae_editor_bottom_tab_show_hide");
          paramView.putExtra("is_show", false);
          this.k.s().sendBroadcast(paramView);
          AEReportUtils.b(7, null);
        }
        AEBaseDataReporter.a().az();
        this.mPartManager.b(131078, new Object[0]);
        return;
      }
      break;
    case 2063990903: 
      AEBaseDataReporter.a().R();
      PressScaleAnimDelegate.a(this.q.getForegroundView(), 200L, null);
      VSReporter.a("mystatus_shoot", "beauty_clk", 0, 0, new String[0]);
      if (AEDashboardUtil.d()) {
        AEBaseDataReporter.a().ae();
      }
      if (this.mPartManager != null)
      {
        if (this.i.g())
        {
          this.mPartManager.b(327686, new Object[0]);
          return;
        }
        if (this.i.h()) {
          return;
        }
        if (bool1)
        {
          if (AEFastClickThrottle.a(paramView)) {
            return;
          }
          paramView = new Intent();
          paramView.setAction("ae_editor_bottom_tab_show_hide");
          paramView.putExtra("is_show", false);
          this.k.s().sendBroadcast(paramView);
          AEReportUtils.b(10, null);
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
    paramVarArgs = this.j;
    if ((paramVarArgs != null) && (paramVarArgs.d() != null))
    {
      paramVarArgs = new StringBuilder();
      paramVarArgs.append("【抠背开关】-> 相机启动检查 -> post:");
      paramVarArgs.append(e());
      AEQLog.a("AEVideoStoryTopBarPart", paramVarArgs.toString());
      this.j.d().postValue(Boolean.valueOf(e()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarPart
 * JD-Core Version:    0.7.0.1
 */