package com.tencent.mobileqq.apollo.web.jsmodule;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.game.CmGameStartChecker.ICmGameConfirmListener;
import com.tencent.mobileqq.apollo.game.DefaultGameCheckListener;
import com.tencent.mobileqq.apollo.game.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.model.ApolloGameData;
import com.tencent.mobileqq.apollo.model.StartCheckParam;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;

class LightGameJsModule$3
  extends DefaultGameCheckListener
{
  LightGameJsModule$3(LightGameJsModule paramLightGameJsModule, AppInterface paramAppInterface, boolean paramBoolean, String paramString)
  {
    super(paramAppInterface, paramBoolean);
  }
  
  public void a(long paramLong, StartCheckParam paramStartCheckParam, CmGameInitParams paramCmGameInitParams) {}
  
  public void a(StartCheckParam paramStartCheckParam, int paramInt)
  {
    super.a(paramStartCheckParam, paramInt);
    int i = 99;
    if (paramInt >= 99) {
      paramInt = i;
    }
    LightGameJsModule.a(this.b, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]LightGameJsModule", 2, new Object[] { "IPC_APOLLO_DOWNLOAD_GAME onDownloadGameResProgress percent:", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(StartCheckParam paramStartCheckParam, CmGameStartChecker.ICmGameConfirmListener paramICmGameConfirmListener, long paramLong)
  {
    String str = String.format(HardCodeUtil.a(2131898704), new Object[] { Float.valueOf((float)paramLong * 1.0F / 1024.0F / 1024.0F) });
    Activity localActivity = this.b.a().d();
    if (localActivity == null) {
      return;
    }
    DialogUtil.a(localActivity, 0, null, str, 2131892267, 2131887648, new LightGameJsModule.3.1(this), new LightGameJsModule.3.2(this, paramICmGameConfirmListener, paramStartCheckParam)).show();
    VipUtils.a(null, "cmshow", "Apollo", "download_confirm_toast", 0, 3, new String[] { String.valueOf(paramStartCheckParam.game.gameId) });
  }
  
  public void b(long paramLong, StartCheckParam paramStartCheckParam, CmGameInitParams paramCmGameInitParams)
  {
    if (paramLong == 0L)
    {
      this.b.b(this.a);
      LightGameJsModule.a(this.b, 100);
    }
    else
    {
      this.b.a(this.a, HardCodeUtil.a(2131898666));
      LightGameJsModule.a(this.b, -1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]LightGameJsModule", 2, new Object[] { "IPC_APOLLO_DOWNLOAD_GAME onVerifyGameFinish resultCode:", Long.valueOf(paramLong) });
    }
  }
  
  public void b(StartCheckParam paramStartCheckParam)
  {
    this.b.a(this.a, HardCodeUtil.a(2131898670));
    LightGameJsModule.a(this.b, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.LightGameJsModule.3
 * JD-Core Version:    0.7.0.1
 */