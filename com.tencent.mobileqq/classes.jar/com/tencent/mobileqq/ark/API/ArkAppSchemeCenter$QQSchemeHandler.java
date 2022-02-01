package com.tencent.mobileqq.ark.API;

import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.biz.pubaccount.weishi_new.api.IWSManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.apollo.api.uitls.IApolloLauncher;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.config.business.qvip.QVipGiftConfig;
import com.tencent.mobileqq.config.business.qvip.QVipGiftProcessor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qzonevip.gift.QzoneGiftManager;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.vaswebviewplugin.GiftJsPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class ArkAppSchemeCenter$QQSchemeHandler
  implements ArkAppSchemeCenter.IRegScheme
{
  private void a(String paramString1, String paramString2)
  {
    Map localMap;
    try
    {
      QLog.i("QQSchemeHandler", 1, "handleTogether " + paramString1 + paramString2);
      paramString1 = URLUtil.a(paramString1);
      localMap = ArkAppSchemeCenter.a(new JSONObject(paramString2));
      Object localObject = localMap.get("type");
      if ((localObject == null) || (!(localObject instanceof String))) {
        break label165;
      }
      paramString2 = ((String)localObject).toLowerCase();
      if ("watch".equals(paramString2))
      {
        a(localMap, paramString1);
        return;
      }
      if ("sing".equals(paramString2))
      {
        b(localMap, paramString1);
        return;
      }
    }
    catch (Exception paramString1)
    {
      QLog.e("QQSchemeHandler", 1, paramString1, new Object[0]);
      return;
    }
    if ("listen".equals(paramString2))
    {
      c(localMap, paramString1);
      return;
    }
    QLog.i("QQSchemeHandler", 1, "handleTogether type no support" + paramString2);
    return;
    label165:
    QLog.i("QQSchemeHandler", 1, "handleTogether metaJson error" + paramString2);
  }
  
  private void a(Map<String, Object> paramMap, Map<String, String> paramMap1)
  {
    paramMap = new ArkAppSchemeCenter.QQSchemeHandler.1(this, paramMap, paramMap1);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ThreadManagerV2.getUIHandlerV2().post(paramMap);
      return;
    }
    paramMap.run();
  }
  
  private void b(String paramString1, String paramString2)
  {
    ((IWSManager)QRoute.api(IWSManager.class)).handleArkJump(paramString1, paramString2);
  }
  
  private void b(Map<String, Object> paramMap, Map<String, String> paramMap1)
  {
    paramMap = new ArkAppSchemeCenter.QQSchemeHandler.2(this, paramMap, paramMap1);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ThreadManagerV2.getUIHandlerV2().post(paramMap);
      return;
    }
    paramMap.run();
  }
  
  private void c(Map<String, Object> paramMap, Map<String, String> paramMap1)
  {
    paramMap = new ArkAppSchemeCenter.QQSchemeHandler.3(this, paramMap, paramMap1);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ThreadManagerV2.getUIHandlerV2().post(paramMap);
      return;
    }
    paramMap.run();
  }
  
  protected QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  protected void a(String paramString)
  {
    String str1 = null;
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    String str2;
    String str3;
    if ((localBaseActivity instanceof FragmentActivity))
    {
      str2 = "";
      str3 = "";
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if (!localJSONObject.has("lat")) {
          break label196;
        }
        paramString = localJSONObject.getString("lat");
        if (localJSONObject.has("lon")) {
          str1 = localJSONObject.getString("lon");
        }
        if (localJSONObject.has("title")) {
          str2 = localJSONObject.getString("title");
        }
        if (localJSONObject.has("loc")) {
          str3 = localJSONObject.getString("loc");
        }
        if ((paramString == null) || (str1 == null)) {
          return;
        }
      }
      catch (JSONException paramString)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("ArkApp", 1, "QQ.showQMapView parameter error: " + paramString.getMessage());
        return;
      }
      paramString = JumpParser.a(a(), localBaseActivity, String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.PoiMapActivity&type=sharedmap&lat=%s&lon=%s&title=%s&loc=%s&dpid=null", new Object[] { paramString, str1, str2, str3 }));
      if (paramString != null)
      {
        paramString.a();
        return;
        label196:
        paramString = null;
      }
    }
  }
  
  public boolean a(String paramString1, String paramString2, JSONObject paramJSONObject, long paramLong, String paramString3)
  {
    if (paramLong != 0L) {
      return false;
    }
    if (paramString1.equals("pubaccount/pendant"))
    {
      if ((BaseActivity.sTopActivity instanceof FragmentActivity))
      {
        paramString1 = (ChatFragment)((FragmentActivity)BaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
        if (paramString1 != null)
        {
          paramString1 = paramString1.a();
          if ((paramString1 != null) && ((paramString1 instanceof PublicAccountChatPie))) {
            ((PublicAccountChatPie)paramString1).i(paramString2);
          }
        }
      }
      return true;
    }
    if (paramString1.equals("map"))
    {
      a(paramString2);
      return true;
    }
    if ("cmshow/openGame".equals(paramString1))
    {
      paramString1 = a();
      if (paramString1 != null) {
        ((IApolloLauncher)QRoute.api(IApolloLauncher.class)).startGameFromArkApp(paramString1, paramString2);
      }
      return true;
    }
    if ("readinjoy/groupopen".equals(paramString1)) {}
    label258:
    do
    {
      for (;;)
      {
        try
        {
          paramString1 = new JSONObject(paramString2);
          paramLong = paramString1.getLong("troopUin");
          long l = paramString1.getLong("appId");
          paramString1 = paramString1.optString("jumpData");
          paramString2.printStackTrace();
        }
        catch (JSONException paramString2)
        {
          try
          {
            paramString2 = a();
            if (paramString2 != null) {
              ((TroopHandler)paramString2.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(paramLong + "", l);
            }
            TroopReportor.a("Grp_AIO", "Grp_aio_subscription", "Grp_aio_clk", 1, 0, new String[] { String.valueOf(paramLong) });
            ReadInJoyActivityHelper.a(BaseActivity.sTopActivity, paramString1, 1);
            return false;
          }
          catch (JSONException paramString2)
          {
            break label258;
          }
          paramString2 = paramString2;
          paramString1 = null;
        }
        continue;
        if ("troop/openManage".equals(paramString1))
        {
          TroopArkHelper.a().a(paramString2);
        }
        else if ("troop/report".equals(paramString1))
        {
          TroopReportor.a(paramString2);
          if (QLog.isColorLevel()) {
            QLog.d("navigate report", 2, "rags are:" + paramString2);
          }
        }
        else if ("gift/predownload".equals(paramString1))
        {
          if (QLog.isColorLevel()) {
            QLog.i("VipARPreDownload", 2, "predownload path = " + paramString2);
          }
          paramString1 = a();
          if (paramString1 != null) {
            ((QzoneGiftManager)paramString1.getManager(QQManagerFactory.QZONE_GIFT_MANAGER)).a(paramString2);
          }
        }
        else if ("gift/playAnimation".equals(paramString1))
        {
          if (QLog.isColorLevel()) {
            QLog.i("VipARPreDownload", 2, "playAnimation path = " + paramString2);
          }
          paramString1 = a();
          if (paramString1 != null)
          {
            paramString1 = (QzoneGiftManager)paramString1.getManager(QQManagerFactory.QZONE_GIFT_MANAGER);
            QLog.i("VipARPreDownload", 1, "playAnimation vipARConfig not match ARgift or isEnableOpen3D = false");
            paramString1.b(paramString2);
          }
        }
        else
        {
          if (!"qungift/openAioDialog".equals(paramString1)) {
            break;
          }
          if (QVipGiftProcessor.a().isEnable()) {
            try
            {
              paramString1 = new JSONObject(paramString2).getString("troopUin");
              GiftJsPlugin.openGiftBrowser(BaseActivity.sTopActivity, paramString1);
            }
            catch (JSONException paramString1)
            {
              paramString1.printStackTrace();
            }
          }
        }
      }
      if ("qungift/playAnimation".equals(paramString1))
      {
        paramString1 = a();
        if (paramString1 == null) {
          return true;
        }
        paramString1 = (AIOAnimationControlManager)paramString1.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
        if (paramString1 != null) {
          paramString1.b(paramString2);
        }
        return true;
      }
      if (paramString1.startsWith("together?"))
      {
        a(paramString1, paramString2);
        return true;
      }
    } while (!paramString1.startsWith("weishi"));
    b(paramString1, paramString2);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppSchemeCenter.QQSchemeHandler
 * JD-Core Version:    0.7.0.1
 */