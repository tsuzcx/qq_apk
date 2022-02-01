package com.tencent.mobileqq.apollo.api.impl;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.utils.OSUtils;
import com.tencent.mobileqq.apollo.game.ApolloGameConfig;
import com.tencent.mobileqq.apollo.game.process.chanel.CmGameCmdChannel;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.res.api.ICmShowRscUpdateHandler;
import com.tencent.mobileqq.apollo.res.api.impl.CmShowRscUpdateHandlerImpl;
import com.tencent.mobileqq.apollo.script.SpriteActionScript;
import com.tencent.mobileqq.apollo.statistics.product.ApolloConfigDataReport;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.apollo.statistics.trace.sdk.TraceConfig.Builder;
import com.tencent.mobileqq.apollo.utils.VersionUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Timer;
import mqq.app.AppRuntime;

class ApolloManagerServiceImpl$2
  implements Runnable
{
  ApolloManagerServiceImpl$2(ApolloManagerServiceImpl paramApolloManagerServiceImpl) {}
  
  public void run()
  {
    Object localObject1 = ApolloManagerServiceImpl.access$200(this.this$0);
    if (localObject1 != null)
    {
      long l = 0L;
      if (QLog.isColorLevel()) {
        l = System.currentTimeMillis();
      }
      Object localObject2 = ((AppInterface)localObject1).getCurrentAccountUin();
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 4);
      ApolloManagerServiceImpl localApolloManagerServiceImpl = this.this$0;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append("_");
      localStringBuilder.append("sp_key_last_shop_tab");
      localApolloManagerServiceImpl.mLastShopTab = localSharedPreferences.getString(localStringBuilder.toString(), "");
      FileUtils.createFileIfNotExits("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/.nomedia");
      this.this$0.initApolloConfig();
      TraceReportUtil.a(new TraceConfig.Builder().a(1).a(((AppInterface)localObject1).getCurrentAccountUin()).a());
      boolean bool2 = false;
      new SpriteActionScript(0, null);
      this.this$0.isApolloSupport(((AppInterface)localObject1).getApplication());
      this.this$0.initCmShowBaseScript(false);
      localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_pet_sp", 0);
      this.this$0.mPetConfig = ((SharedPreferences)localObject2).getString("pet_config", null);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("init apollo data from db done cost: ");
        ((StringBuilder)localObject2).append(System.currentTimeMillis() - l);
        ((StringBuilder)localObject2).append(", app: ");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.d("[cmshow]ApolloManager", 2, ((StringBuilder)localObject2).toString());
      }
      ApolloGameConfig.a();
      ApolloConfigDataReport.a((AppRuntime)localObject1);
      ApolloManagerServiceImpl.sInitDone = true;
      ApolloManagerServiceImpl.access$300(this.this$0);
      ApolloUtilImpl.getHardwareInfo();
      ((CmShowRscUpdateHandlerImpl)QRoute.api(ICmShowRscUpdateHandler.class)).checkCmShowContentUpdate((AppInterface)localObject1, 0, false);
      localObject2 = this.this$0.getApolloBaseInfo(((AppInterface)localObject1).getCurrentAccountUin());
      if (localObject2 != null)
      {
        ((ApolloBaseInfo)localObject2).getApolloDress();
        ((ApolloBaseInfo)localObject2).getApolloDress3D();
        ((ApolloBaseInfo)localObject2).getApolloPetDress();
      }
      CmGameCmdChannel.a((AppInterface)localObject1);
      new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/shader_code/").mkdirs();
      localObject1 = OSUtils.getEMUIVersion();
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        if (((String)localObject1).contains("EmotionUI "))
        {
          bool1 = bool2;
          if (VersionUtil.a(((String)localObject1).substring(10), "10") < 0) {
            break label433;
          }
        }
        else
        {
          bool1 = bool2;
          if (!((String)localObject1).contains("EmotionUI_")) {
            break label433;
          }
          bool1 = bool2;
          if (VersionUtil.a(((String)localObject1).substring(10), "10") < 0) {
            break label433;
          }
        }
        boolean bool1 = true;
        label433:
        if (bool1) {
          this.this$0.mGlobalTimer = new Timer();
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("emui:");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" emui10Plus:");
        ((StringBuilder)localObject2).append(bool1);
        QLog.i("[cmshow]ApolloManager", 1, ((StringBuilder)localObject2).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */