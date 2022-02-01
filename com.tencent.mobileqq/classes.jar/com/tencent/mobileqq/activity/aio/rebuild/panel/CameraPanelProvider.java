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
  protected AIOFakePanel a = null;
  private AIOContext b;
  
  public CameraPanelProvider(AIOContext paramAIOContext)
  {
    this.b = paramAIOContext;
  }
  
  private void c()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (this.b.b().checkSelfPermission("android.permission.CAMERA") == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i != 0) && (this.b.b().checkSelfPermission("android.permission.RECORD_AUDIO") == 0)) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i == 0) || (!PermissionUtils.isStorePermissionEnable(this.b.b())))
      {
        i = 0;
        break label83;
      }
    }
    int i = 1;
    label83:
    if (i == 0) {
      this.b.b().requestPermissions(new CameraPanelProvider.1(this), 1, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
    } else {
      b();
    }
    AIOPanelUtiles.a(this.b.a(), "0X800407A", this.b.O().a);
  }
  
  public AIOFakePanel a()
  {
    return this.a;
  }
  
  public AIOFakePanel a(Context paramContext)
  {
    this.a = new AIOFakePanel(this.b.b());
    return this.a;
  }
  
  public void b()
  {
    QLog.d("CheckPermission", 1, "CheckPermission user grant");
    this.b.q().a(true);
    ((AudioPanelAioHelper)this.b.a(128)).k();
    if (this.b.O().a == 9501) {}
    try
    {
      localObject = SmartDeviceProxyMgr.a(this.b.a(), Long.parseLong(this.b.O().b));
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
    PlusPanelUtils.a(this.b.a(), this.b.b(), this.b.b(), this.b.O(), i, 0);
    localObject = (BabyQHandler)this.b.a().getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER);
    if (((BabyQHandler)localObject).b(0)) {
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
    c();
    paramXPanelContainer = this.b;
    if (((paramXPanelContainer instanceof BaseTroopAIOContext)) && (((BaseTroopAIOContext)paramXPanelContainer).P())) {
      ReportController.b(this.b.a(), "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_shoot", 0, 0, this.b.O().b, "", "", "");
    }
    paramXPanelContainer = this.b;
    if ((paramXPanelContainer instanceof LimitContext)) {
      ReportController.b(paramXPanelContainer.a(), "dc00898", "", "", "0X80096AB", "0X80096AB", ((LimitContext)this.b).P(), 0, "", "", "", "");
    }
  }
  
  public void onPanelIconClickBeforeCreate(int paramInt) {}
  
  public void postOnPanelChanged(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.panel.CameraPanelProvider
 * JD-Core Version:    0.7.0.1
 */