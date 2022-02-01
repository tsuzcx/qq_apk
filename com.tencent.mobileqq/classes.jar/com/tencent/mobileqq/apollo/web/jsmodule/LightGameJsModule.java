package com.tencent.mobileqq.apollo.web.jsmodule;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.apollo.game.CmGameStartChecker;
import com.tencent.mobileqq.apollo.game.DefaultGameCheckListener;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.ipc.ApolloIPCModule;
import com.tencent.mobileqq.apollo.model.StartCheckParam;
import com.tencent.mobileqq.apollo.utils.RequestRoute;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.web.CmshowWebReqParam;
import com.tencent.mobileqq.apollo.web.ipc.IStoreAvatar2D;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONObject;

@Deprecated
public class LightGameJsModule
  extends BaseJsModule
{
  private long b = 0L;
  private CmGameStartChecker c;
  private DefaultGameCheckListener d;
  
  public LightGameJsModule(VasWebviewJsPlugin paramVasWebviewJsPlugin)
  {
    super(paramVasWebviewJsPlugin);
  }
  
  private void a(String paramString, StartCheckParam paramStartCheckParam)
  {
    if (paramStartCheckParam == null)
    {
      a(paramString, HardCodeUtil.a(2131898702));
      return;
    }
    AppInterface localAppInterface = CmGameUtil.b();
    this.c = new CmGameStartChecker(localAppInterface);
    this.d = new LightGameJsModule.3(this, localAppInterface, false, paramString);
    this.c.a(paramStartCheckParam, this.d);
  }
  
  private void b(int paramInt)
  {
    ThreadManager.getUIHandler().post(new LightGameJsModule.4(this, paramInt));
  }
  
  @RequestRoute(a="checkGameStatus")
  public void checkGameStatus(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    JSONObject localJSONObject = paramCmshowWebReqParam.a;
    paramCmshowWebReqParam = paramCmshowWebReqParam.b;
    if (!FileUtils.hasSDCardAndWritable())
    {
      a(paramCmshowWebReqParam, "sdcard未装");
      return;
    }
    if (FileUtils.getAvailableExternalMemorySize() < 52428800.0F)
    {
      a(paramCmshowWebReqParam, HardCodeUtil.a(2131898664));
      return;
    }
    int i = localJSONObject.optInt("gameId");
    ((IStoreAvatar2D)ApolloIPCModule.a(IStoreAvatar2D.class)).a(i, new LightGameJsModule.2(this, paramCmshowWebReqParam));
  }
  
  @RequestRoute(a="startApolloGame")
  public void startApolloGame(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    Object localObject2 = paramCmshowWebReqParam.a;
    String str1 = paramCmshowWebReqParam.b;
    Activity localActivity = paramCmshowWebReqParam.c;
    long l = System.currentTimeMillis();
    if (l - this.b <= 1000L)
    {
      a(str1, HardCodeUtil.a(2131898665));
      return;
    }
    this.b = l;
    int j = ((JSONObject)localObject2).optInt("gameId");
    l = ((JSONObject)localObject2).optLong("roomId");
    boolean bool1;
    if (((JSONObject)localObject2).optInt("isCreator", 1) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    int i;
    if (((JSONObject)localObject2).has("gameMode")) {
      i = ((JSONObject)localObject2).optInt("gameMode");
    } else {
      i = 1;
    }
    int k = ((JSONObject)localObject2).optInt("src");
    String str2 = ((JSONObject)localObject2).optString("gameParam");
    Object localObject1 = ((JSONObject)localObject2).optString("friendUin");
    paramCmshowWebReqParam = ((JSONObject)localObject2).optString("friendOpenId");
    boolean bool2 = ((JSONObject)localObject2).optBoolean("isEnterAIO");
    if (TextUtils.isEmpty(paramCmshowWebReqParam)) {
      paramCmshowWebReqParam = (CmshowWebReqParam)localObject1;
    }
    String str3 = ((JSONObject)localObject2).optString("uinName");
    int m = ((JSONObject)localObject2).optInt("openTempAIOOnFinish");
    String str4 = ((JSONObject)localObject2).optString("tempAIOUin");
    String str5 = ((JSONObject)localObject2).optString("tempAIONickName");
    String str6 = ((JSONObject)localObject2).optString("gameName");
    if ((localActivity != null) && (!localActivity.isFinishing()))
    {
      if (bool2)
      {
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("uin", (String)localObject1);
        ((Bundle)localObject2).putInt("uintype", 0);
        ((Bundle)localObject2).putString("troop_uin", "");
        ((Bundle)localObject2).putString("uinname", str3);
        ((Bundle)localObject2).putBoolean("launchApolloGame", true);
        ((Bundle)localObject2).putInt("gameId", j);
        ((Bundle)localObject2).putInt("gameMode", i);
        ((Bundle)localObject2).putString("openId", paramCmshowWebReqParam);
        ((Bundle)localObject2).putString("gameParam", str2);
        ((Bundle)localObject2).putString("gameName", str6);
        ((Bundle)localObject2).putInt("src", k);
        ((Bundle)localObject2).putInt("enter", 3);
        paramCmshowWebReqParam = AIOUtils.a(new Intent(localActivity, SplashActivity.class), new int[] { 2 });
        paramCmshowWebReqParam.putExtras((Bundle)localObject2);
        localActivity.startActivity(paramCmshowWebReqParam);
        if (QLog.isColorLevel())
        {
          paramCmshowWebReqParam = new StringBuilder();
          paramCmshowWebReqParam.append("[startApolloGame] openAIO:");
          paramCmshowWebReqParam.append(((Bundle)localObject2).toString());
          QLog.d("[cmshow]LightGameJsModule", 2, paramCmshowWebReqParam.toString());
        }
        b(str1);
        return;
      }
      localObject1 = new StartCheckParam(j, bool1, "luanch", l, 4, i, 0, 0, "", k, str6);
      ((StartCheckParam)localObject1).mExtraStr = ((JSONObject)localObject2).toString();
      ((StartCheckParam)localObject1).extendJson = str2;
      ((StartCheckParam)localObject1).mFriendUin = paramCmshowWebReqParam;
      ((StartCheckParam)localObject1).mTempAIONickName = str5;
      ((StartCheckParam)localObject1).mTempAIOUin = str4;
      if (m == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ((StartCheckParam)localObject1).mOpenTempAIOOnFinish = bool1;
      if (((StartCheckParam)localObject1).src == 318) {
        ((StartCheckParam)localObject1).disableMinGame = true;
      }
      if (!TextUtils.isEmpty(str2))
      {
        paramCmshowWebReqParam = ApolloUtilImpl.getJsonStrValue(str2, "rbOpenId");
        if (!TextUtils.isEmpty(paramCmshowWebReqParam))
        {
          ((StartCheckParam)localObject1).mRobotOpenId = paramCmshowWebReqParam;
          if (((IApolloUtil)QRoute.api(IApolloUtil.class)).getJsonIntValue(str2, "gameId") > 0) {
            ((StartCheckParam)localObject1).gameId = j;
          }
          ((StartCheckParam)localObject1).src = 318001;
          ((StartCheckParam)localObject1).disableMinGame = true;
        }
      }
      ((IStoreAvatar2D)ApolloIPCModule.a(IStoreAvatar2D.class)).a((StartCheckParam)localObject1, new LightGameJsModule.1(this, str1));
      return;
    }
    a(str1, HardCodeUtil.a(2131898659));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.LightGameJsModule
 * JD-Core Version:    0.7.0.1
 */