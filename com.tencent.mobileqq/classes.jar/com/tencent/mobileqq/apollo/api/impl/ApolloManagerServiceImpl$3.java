package com.tencent.mobileqq.apollo.api.impl;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.utils.OSUtils;
import com.tencent.mobileqq.apollo.api.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.api.res.ICmShowRscUpdateHandler;
import com.tencent.mobileqq.apollo.api.res.impl.CmShowRscUpdateHandlerImpl;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.game.ApolloGameConfig;
import com.tencent.mobileqq.apollo.process.chanel.CmGameCmdChannel;
import com.tencent.mobileqq.apollo.script.SpriteActionScript;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.apollo.statistics.trace.sdk.TraceConfig.Builder;
import com.tencent.mobileqq.apollo.utils.ApolloConfigDataReport;
import com.tencent.mobileqq.apollo.utils.ApolloConfigUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Timer;

class ApolloManagerServiceImpl$3
  implements Runnable
{
  ApolloManagerServiceImpl$3(ApolloManagerServiceImpl paramApolloManagerServiceImpl) {}
  
  public void run()
  {
    boolean bool2 = false;
    Object localObject1 = ApolloManagerServiceImpl.access$300(this.this$0);
    boolean bool1;
    if (localObject1 != null)
    {
      long l = 0L;
      if (QLog.isColorLevel()) {
        l = System.currentTimeMillis();
      }
      ApolloManagerServiceImpl.access$400(this.this$0);
      ApolloManagerServiceImpl.access$500(this.this$0);
      FileUtils.c("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/.nomedia");
      this.this$0.initApolloConfig();
      TraceReportUtil.a(new TraceConfig.Builder().a(1).a(((QQAppInterface)localObject1).getCurrentAccountUin()).a());
      new SpriteActionScript(0, null);
      this.this$0.isApolloFuncOpen(((QQAppInterface)localObject1).getApplication());
      this.this$0.initCmShowBaseScript(false);
      Object localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_pet_sp", 0);
      this.this$0.mPetConfig = ((SharedPreferences)localObject2).getString("pet_config", null);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "init apollo data from db done cost: " + (System.currentTimeMillis() - l) + ", app: " + localObject1);
      }
      ApolloGameConfig.a();
      ApolloConfigDataReport.a((QQAppInterface)localObject1);
      ApolloManagerServiceImpl.sInitedDone = true;
      ApolloManagerServiceImpl.access$600(this.this$0);
      ApolloUtilImpl.getHardwareInfo();
      ((CmShowRscUpdateHandlerImpl)QRoute.api(ICmShowRscUpdateHandler.class)).checkCmShowContentUpdate((AppInterface)localObject1, 0, false);
      localObject2 = this.this$0.getApolloBaseInfo(((QQAppInterface)localObject1).getCurrentAccountUin());
      if (localObject2 != null)
      {
        ((ApolloBaseInfo)localObject2).getApolloDress();
        ((ApolloBaseInfo)localObject2).getApolloDress3D();
        ((ApolloBaseInfo)localObject2).getApolloPetDress();
      }
      CmGameCmdChannel.a((QQAppInterface)localObject1);
      new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/shader_code/").mkdirs();
      localObject1 = OSUtils.getEMUIVersion();
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        if (!((String)localObject1).contains("EmotionUI ")) {
          break label374;
        }
        if (ApolloConfigUtils.a(((String)localObject1).substring("EmotionUI ".length()), "10") < 0) {
          break label413;
        }
        bool1 = true;
      }
    }
    for (;;)
    {
      if (bool1) {
        this.this$0.mGlobalTimer = new Timer();
      }
      QLog.i("ApolloManager", 1, "emui:" + (String)localObject1 + " emui10Plus:" + bool1);
      return;
      label374:
      bool1 = bool2;
      if (((String)localObject1).contains("EmotionUI_"))
      {
        bool1 = bool2;
        if (ApolloConfigUtils.a(((String)localObject1).substring("EmotionUI_".length()), "10") >= 0)
        {
          bool1 = true;
          continue;
          label413:
          bool1 = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */