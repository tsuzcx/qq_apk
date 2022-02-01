package com.tencent.aelight.camera.ae.camera.ui.topbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
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
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.ae.mode.AEVideoStoryCaptureModeViewModel;
import com.tencent.aelight.camera.ae.part.AEVideoStoryStateViewModel;
import com.tencent.aelight.camera.ae.part.VideoStoryBasePart;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.util.AEFastClickThrottle;
import com.tencent.aelight.camera.ae.view.AECircleCaptureStyle;
import com.tencent.aelight.camera.ae.view.AECompoundButton;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aioeditor.capture.view.PressScaleAnimDelegate;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.light.DeviceSupportUtil;

public class AEVideoStoryTopBarPart
  extends VideoStoryBasePart
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = 0;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AEPituCameraUnit jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit;
  private AEVideoStoryTopBarViewModel jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel;
  private AEVideoStoryCaptureModeViewModel jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModeViewModel;
  private AEVideoStoryStateViewModel jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel;
  private AECompoundButton jdField_a_of_type_ComTencentAelightCameraAeViewAECompoundButton;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 3;
  private AECompoundButton jdField_b_of_type_ComTencentAelightCameraAeViewAECompoundButton;
  private AECompoundButton c;
  private AECompoundButton d;
  private AECompoundButton e;
  private AECompoundButton f;
  private AECompoundButton g;
  private AECompoundButton h;
  private AECompoundButton i;
  
  public AEVideoStoryTopBarPart(Activity paramActivity, View paramView, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    super(paramActivity, paramView, paramVideoStoryCapturePartManager);
    this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit = ((AEPituCameraUnit)paramVideoStoryCapturePartManager.a(65537, new Object[0]));
  }
  
  private void a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    ((StringBuilder)localObject).append(";");
    ((StringBuilder)localObject).append(Build.MODEL);
    if (!"VIVO;V1836T".equalsIgnoreCase(((StringBuilder)localObject).toString())) {
      return;
    }
    localObject = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localObject;
      localMarginLayoutParams.topMargin += DisplayUtil.a(this.mActivity, 20.0F);
      this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  private void a(@NonNull AECircleCaptureStyle paramAECircleCaptureStyle)
  {
    if (!AECameraEntryManager.k(this.mActivity.getIntent())) {
      return;
    }
    AECompoundButton localAECompoundButton = this.g;
    if (localAECompoundButton != null) {
      localAECompoundButton.setForegroundResource(paramAECircleCaptureStyle.k);
    }
    localAECompoundButton = this.jdField_b_of_type_ComTencentAelightCameraAeViewAECompoundButton;
    if (localAECompoundButton != null) {
      localAECompoundButton.setForegroundResource(paramAECircleCaptureStyle.l);
    }
    localAECompoundButton = this.c;
    if (localAECompoundButton != null) {
      localAECompoundButton.setForegroundResource(paramAECircleCaptureStyle.m);
    }
    localAECompoundButton = this.f;
    if (localAECompoundButton != null) {
      localAECompoundButton.setForegroundResource(paramAECircleCaptureStyle.n);
    }
    localAECompoundButton = this.jdField_a_of_type_ComTencentAelightCameraAeViewAECompoundButton;
    if (localAECompoundButton != null) {
      localAECompoundButton.setForegroundResource(paramAECircleCaptureStyle.o);
    }
    localAECompoundButton = this.e;
    if (localAECompoundButton != null) {
      localAECompoundButton.setForegroundResource(paramAECircleCaptureStyle.p);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModeViewModel.a())
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
        localObject = this.i;
        int j;
        if (paramBoolean) {
          j = 8;
        } else {
          j = 0;
        }
        ((AECompoundButton)localObject).setVisibility(j);
        this.h.setVisibility(0);
        this.c.setVisibility(8);
      }
      else
      {
        this.c.setVisibility(0);
      }
      this.f.setVisibility(0);
      localObject = this.e;
      if (localObject != null) {
        ((AECompoundButton)localObject).setVisibility(0);
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModeViewModel.a())
      {
        this.i.setVisibility(8);
        this.h.setVisibility(8);
      }
      this.jdField_b_of_type_ComTencentAelightCameraAeViewAECompoundButton.setVisibility(8);
      this.c.setVisibility(8);
      this.f.setVisibility(8);
      localObject = this.e;
      if (localObject != null) {
        ((AECompoundButton)localObject).setVisibility(8);
      }
    }
    if (a()) {
      this.f.setVisibility(8);
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModeViewModel = ((AEVideoStoryCaptureModeViewModel)AEViewModelProviders.a(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit).get(AEVideoStoryCaptureModeViewModel.class));
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModeViewModel.a.observe(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit, new AEVideoStoryTopBarPart.2(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel = ((AEVideoStoryTopBarViewModel)AEViewModelProviders.a(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit).get(AEVideoStoryTopBarViewModel.class));
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel.a().observe(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit, new AEVideoStoryTopBarPart.3(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel.b().observe(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit, new AEVideoStoryTopBarPart.4(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel.a.observe(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit, new AEVideoStoryTopBarPart.5(this));
    this.jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel = ((AEVideoStoryStateViewModel)AEViewModelProviders.a(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit).get(AEVideoStoryStateViewModel.class));
    this.jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel.a().observe(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit, new AEVideoStoryTopBarPart.6(this));
    this.jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel.b().observe(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit, new AEVideoStoryTopBarPart.7(this));
    this.jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel.c().observe(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit, new AEVideoStoryTopBarPart.8(this));
    this.jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel.d().observe(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit, new AEVideoStoryTopBarPart.9(this));
  }
  
  private boolean b()
  {
    if (AECameraEntryManager.a(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit)) {
      return false;
    }
    Object localObject1 = new HashMap();
    Object localObject2 = new ArrayList();
    ((List)localObject2).add("PCAM10");
    ((List)localObject2).add("PBBM30");
    ((List)localObject2).add("PBAM00");
    ((List)localObject2).add("PBBM00");
    ((List)localObject2).add("PADM00");
    ((List)localObject2).add("pcnm00");
    ((List)localObject2).add("PACM00");
    ((List)localObject2).add("R15x");
    ((List)localObject2).add("PBBM00");
    ((List)localObject2).add("pbft00");
    Object localObject3 = new ArrayList();
    ((List)localObject3).add("Y85A");
    ((List)localObject3).add("Y85");
    ((List)localObject3).add("u3x");
    ((List)localObject3).add("X21A");
    ((List)localObject3).add("Y93");
    ((List)localObject3).add("Y81s");
    ((List)localObject3).add("V1914A");
    ((List)localObject3).add("V1918A");
    ((List)localObject3).add("V1818CA");
    ((List)localObject3).add("V1732T");
    ((List)localObject3).add("V1914T");
    ((List)localObject3).add("V1818CT");
    ((List)localObject3).add("Y83A");
    ((List)localObject3).add("X21");
    ((Map)localObject1).put("vivo", localObject3);
    ((Map)localObject1).put("oppo", localObject2);
    if (Build.MANUFACTURER != null)
    {
      localObject1 = (List)((Map)localObject1).get(Build.MANUFACTURER.toLowerCase());
      if (localObject1 == null) {
        return "meizu 17".equals(Build.MODEL);
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (localObject2 != null) {
          if (!((String)localObject2).equalsIgnoreCase(Build.MODEL))
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(Build.MANUFACTURER);
            ((StringBuilder)localObject3).append(" ");
            ((StringBuilder)localObject3).append((String)localObject2);
            if (!((StringBuilder)localObject3).toString().equalsIgnoreCase(Build.MODEL)) {
              break;
            }
          }
          else
          {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  private boolean c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel;
    boolean bool = false;
    if (localObject != null)
    {
      if (((AEVideoStoryTopBarViewModel)localObject).b() == null) {
        return false;
      }
      localObject = (Boolean)this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel.b().getValue();
      if (localObject == null) {
        return false;
      }
      bool = ((Boolean)localObject).booleanValue();
    }
    return bool;
  }
  
  protected boolean a()
  {
    return (!this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.b().c()) || (!this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.b().f()) || (!this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.b().a());
  }
  
  protected void initView()
  {
    Object localObject = (ViewStub)this.mRootView.findViewById(2064122663);
    if (localObject != null) {
      this.jdField_a_of_type_AndroidViewView = ((ViewStub)localObject).inflate();
    }
    ViewCompat.setOnApplyWindowInsetsListener(this.jdField_a_of_type_AndroidViewView, new AEVideoStoryTopBarPart.1(this));
    ViewCompat.requestApplyInsets(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mRootView.findViewById(2064122009));
    this.g = ((AECompoundButton)this.jdField_a_of_type_AndroidViewView.findViewById(2064122022));
    this.g.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAECompoundButton = ((AECompoundButton)this.jdField_a_of_type_AndroidViewView.findViewById(2064122036));
    this.jdField_b_of_type_ComTencentAelightCameraAeViewAECompoundButton = ((AECompoundButton)this.jdField_a_of_type_AndroidViewView.findViewById(2064122095));
    this.f = ((AECompoundButton)this.jdField_a_of_type_AndroidViewView.findViewById(2064121975));
    this.f.setOnClickListener(this);
    this.e = ((AECompoundButton)this.jdField_a_of_type_AndroidViewView.findViewById(2064122001));
    localObject = this.e;
    if (localObject != null) {
      ((AECompoundButton)localObject).setOnClickListener(this);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mRootView.findViewById(2064122712));
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    this.c = ((AECompoundButton)this.jdField_a_of_type_AndroidViewView.findViewById(2064122215));
    this.h = ((AECompoundButton)this.jdField_a_of_type_AndroidViewView.findViewById(2064122072));
    this.h.setOnClickListener(this);
    this.i = ((AECompoundButton)this.jdField_a_of_type_AndroidViewView.findViewById(2064122667));
    this.i.setOnClickListener(this);
    this.i.setSelected(false);
    this.d = ((AECompoundButton)this.jdField_a_of_type_AndroidViewView.findViewById(2064122533));
    this.c.setOnClickListener(this);
    this.c.setSelected(this.jdField_a_of_type_Boolean);
    b();
    a();
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel;
    if ((localObject != null) && (((AEVideoStoryTopBarViewModel)localObject).b() != null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("【抠背开关】-> onResume -> post:");
      ((StringBuilder)localObject).append(c());
      AEQLog.a("AEVideoStoryTopBarPart", ((StringBuilder)localObject).toString());
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel.b().postValue(Boolean.valueOf(c()));
    }
    localObject = this.c;
    if (localObject != null) {
      ((AECompoundButton)localObject).setSelected(this.jdField_a_of_type_Boolean);
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool1 = AECameraEntryManager.k(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.a().getIntent());
    int j = paramView.getId();
    int k = 0;
    switch (j)
    {
    default: 
    case 2064122667: 
      PressScaleAnimDelegate.a(this.i.a(), 200L, null);
      bool1 = c();
      paramView = new StringBuilder();
      paramView.append("【抠背开关】-> 点击 ->post:");
      paramView.append(bool1 ^ true);
      AEQLog.a("AEVideoStoryTopBarPart", paramView.toString());
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel.b().postValue(Boolean.valueOf(bool1 ^ true));
      if (this.jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModeViewModel.a())
      {
        AEBaseReportParam.a().f(bool1 ^ true);
        AEBaseDataReporter.a().an();
        return;
      }
      break;
    case 2064122533: 
      paramView = AEVideoStoryTopBarViewModel.Ratio.FULL;
      j = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = (j + 1);
      j %= 4;
      if (j != 0)
      {
        if (j != 1)
        {
          if (j != 2)
          {
            if (j == 3) {
              paramView = AEVideoStoryTopBarViewModel.Ratio.R_1_1;
            }
          }
          else {
            paramView = AEVideoStoryTopBarViewModel.Ratio.R_4_3;
          }
        }
        else {
          paramView = AEVideoStoryTopBarViewModel.Ratio.R_16_9;
        }
      }
      else {
        paramView = AEVideoStoryTopBarViewModel.Ratio.FULL;
      }
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel.a.setValue(paramView);
      return;
    case 2064122215: 
      PressScaleAnimDelegate.a(this.c.a(), 200L, null);
      boolean bool2 = this.c.isSelected() ^ true;
      if (this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.a(bool2))
      {
        this.jdField_a_of_type_Boolean = bool2;
        this.c.setSelected(bool2);
        if (QLog.isDevelopLevel())
        {
          paramView = new StringBuilder();
          paramView.append("onClick, mFlashButton.setSelected(), on=");
          paramView.append(bool2);
          AEQLog.a("AEVideoStoryTopBarPart", paramView.toString());
        }
      }
      AEBaseDataReporter.a().L();
      if (bool1)
      {
        AEReportUtils.b(6, null);
        return;
      }
      break;
    case 2064122072: 
      PressScaleAnimDelegate.a(this.h.a(), 200L, null);
      paramView = (AEVideoStoryTopBarViewModel.CountDownSetting)this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel.a().getValue();
      j = k;
      if (paramView != null)
      {
        j = k;
        if (paramView.a()) {
          j = 1;
        }
      }
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel.a().postValue(new AEVideoStoryTopBarViewModel.CountDownSetting(j ^ 0x1, this.jdField_b_of_type_Int));
      if (this.jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModeViewModel.a())
      {
        AEBaseReportParam.a().g(j ^ 0x1);
        return;
      }
      break;
    case 2064122022: 
      PressScaleAnimDelegate.a(paramView, 200L, null);
      this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.T();
      if (bool1)
      {
        AEReportUtils.b(3, null);
        return;
      }
      break;
    case 2064122001: 
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
          this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.a().sendBroadcast(paramView);
          AEReportUtils.b(7, null);
        }
        AEBaseDataReporter.a().au();
        this.mPartManager.a(131078, new Object[0]);
        return;
      }
      break;
    case 2064121975: 
      AEBaseDataReporter.a().Q();
      PressScaleAnimDelegate.a(this.f.a(), 200L, null);
      VSReporter.a("mystatus_shoot", "beauty_clk", 0, 0, new String[0]);
      if (this.mPartManager != null)
      {
        if (this.jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel.a())
        {
          this.mPartManager.a(327686, new Object[0]);
          return;
        }
        if (this.jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel.b()) {
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
          this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.a().sendBroadcast(paramView);
          AEReportUtils.b(10, null);
        }
        this.mPartManager.a(131077, new Object[0]);
      }
      break;
    }
  }
  
  public void send(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 458753) {
      return;
    }
    paramVarArgs = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel;
    if ((paramVarArgs != null) && (paramVarArgs.b() != null))
    {
      paramVarArgs = new StringBuilder();
      paramVarArgs.append("【抠背开关】-> 相机启动检查 -> post:");
      paramVarArgs.append(c());
      AEQLog.a("AEVideoStoryTopBarPart", paramVarArgs.toString());
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel.b().postValue(Boolean.valueOf(c()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarPart
 * JD-Core Version:    0.7.0.1
 */