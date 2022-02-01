package com.tencent.mobileqq.activity.aio.rebuild.panel;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelAioHelper;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseTroopAIOContext;
import com.tencent.mobileqq.activity.aio.panel.AIOFakePanel;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.panel.PanelProvider;
import com.tencent.mobileqq.activity.aio.rebuild.LimitContext;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.app.BabyQHandler;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;

public class CameraPanelProvider
  implements PanelProvider<AIOFakePanel>
{
  private AIOContext a;
  protected AIOFakePanel a;
  
  public CameraPanelProvider(AIOContext paramAIOContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAIOFakePanel = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
  }
  
  private void b()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().checkSelfPermission("android.permission.CAMERA") == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().checkSelfPermission("android.permission.RECORD_AUDIO") == 0)) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i == 0) || (!PermissionUtils.isStorePermissionEnable(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a())))
      {
        i = 0;
        break label83;
      }
    }
    int i = 1;
    label83:
    if (i == 0) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().requestPermissions(new CameraPanelProvider.1(this), 1, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
    } else {
      a();
    }
    AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), "0X800407A", this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().jdField_a_of_type_Int);
  }
  
  public AIOFakePanel a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAIOFakePanel;
  }
  
  public AIOFakePanel a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAIOFakePanel = new AIOFakePanel(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a());
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAIOFakePanel;
  }
  
  public void a()
  {
    QLog.d("CheckPermission", 1, "CheckPermission user grant");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a(true);
    ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(128)).f();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().jdField_a_of_type_Int == 9501) {}
    try
    {
      localObject = SmartDeviceProxyMgr.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().jdField_a_of_type_JavaLangString));
      if (localObject != null) {
        i = ((DeviceInfo)localObject).productId;
      } else {
        i = 0;
      }
    }
    catch (Exception localException)
    {
      Object localObject;
      int i;
      label92:
      break label92;
    }
    i = 0;
    PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), i, 0);
    localObject = (BabyQHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER);
    if (((BabyQHandler)localObject).a(0)) {
      ((BabyQHandler)localObject).a();
    }
  }
  
  public int getPanelId()
  {
    return 5;
  }
  
  public boolean isNeedRecreatePanel()
  {
    return false;
  }
  
  public void onHideAllPanel() {}
  
  public void onPanelChanged(int paramInt1, int paramInt2) {}
  
  public void onPanelIconClick(XPanelContainer paramXPanelContainer)
  {
    b();
    paramXPanelContainer = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
    if (((paramXPanelContainer instanceof BaseTroopAIOContext)) && (((BaseTroopAIOContext)paramXPanelContainer).k())) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_shoot", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().jdField_a_of_type_JavaLangString, "", "", "");
    }
    paramXPanelContainer = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
    if ((paramXPanelContainer instanceof LimitContext)) {
      ReportController.b(paramXPanelContainer.a(), "dc00898", "", "", "0X80096AB", "0X80096AB", ((LimitContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).f(), 0, "", "", "", "");
    }
  }
  
  public void onPanelIconClickBeforeCreate(int paramInt) {}
  
  public void postOnPanelChanged(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.panel.CameraPanelProvider
 * JD-Core Version:    0.7.0.1
 */