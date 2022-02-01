package com.tencent.mobileqq.ark.api.scheme;

import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentManager;
import com.tencent.biz.pubaccount.weishi_new.api.IWSManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.module.SchemeHandler;
import com.tencent.mobileqq.ark.util.StringUtil;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qzonevip.gift.QzoneGiftManager;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAppHandler;
import com.tencent.mobileqq.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipGiftConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipGiftProcessor;
import com.tencent.mobileqq.vaswebviewplugin.GiftJsPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class QQSchemeHandler
  implements SchemeHandler
{
  private void a(String paramString1, String paramString2)
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleTogether ");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(paramString2);
      QLog.i("QQSchemeHandler", 1, ((StringBuilder)localObject1).toString());
      paramString1 = URLUtil.a(paramString1);
      localObject1 = StringUtil.a(new JSONObject(paramString2));
      Object localObject2 = ((Map)localObject1).get("type");
      if ((localObject2 != null) && ((localObject2 instanceof String)))
      {
        paramString2 = ((String)localObject2).toLowerCase();
        if ("watch".equals(paramString2))
        {
          a((Map)localObject1, paramString1);
          return;
        }
        if ("sing".equals(paramString2))
        {
          b((Map)localObject1, paramString1);
          return;
        }
        if ("listen".equals(paramString2))
        {
          c((Map)localObject1, paramString1);
          return;
        }
        paramString1 = new StringBuilder();
        paramString1.append("handleTogether type no support");
        paramString1.append(paramString2);
        QLog.i("QQSchemeHandler", 1, paramString1.toString());
        return;
      }
      paramString1 = new StringBuilder();
      paramString1.append("handleTogether metaJson error");
      paramString1.append(paramString2);
      QLog.i("QQSchemeHandler", 1, paramString1.toString());
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("QQSchemeHandler", 1, paramString1, new Object[0]);
    }
  }
  
  private void a(Map<String, Object> paramMap, Map<String, String> paramMap1)
  {
    paramMap = new QQSchemeHandler.1(this, paramMap, paramMap1);
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
    paramMap = new QQSchemeHandler.2(this, paramMap, paramMap1);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ThreadManagerV2.getUIHandlerV2().post(paramMap);
      return;
    }
    paramMap.run();
  }
  
  private void c(Map<String, Object> paramMap, Map<String, String> paramMap1)
  {
    paramMap = new QQSchemeHandler.3(this, paramMap, paramMap1);
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
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((localBaseActivity instanceof BaseActivity)) {}
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        boolean bool = localJSONObject.has("lat");
        localObject = null;
        if (!bool) {
          break label212;
        }
        paramString = localJSONObject.getString("lat");
        if (localJSONObject.has("lon")) {
          localObject = localJSONObject.getString("lon");
        }
        bool = localJSONObject.has("title");
        String str2 = "";
        if (!bool) {
          break label217;
        }
        str1 = localJSONObject.getString("title");
        if (localJSONObject.has("loc")) {
          str2 = localJSONObject.getString("loc");
        }
        if (paramString != null)
        {
          if (localObject == null) {
            return;
          }
          paramString = JumpParser.a(a(), localBaseActivity, String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.PoiMapActivity&type=sharedmap&lat=%s&lon=%s&title=%s&loc=%s&dpid=null", new Object[] { paramString, localObject, str1, str2 }));
          if (paramString != null) {
            paramString.a();
          }
        }
        else
        {
          return;
        }
      }
      catch (JSONException paramString)
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("QQ.showQMapView parameter error: ");
          ((StringBuilder)localObject).append(paramString.getMessage());
          QLog.i("ArkApp", 1, ((StringBuilder)localObject).toString());
        }
      }
      return;
      label212:
      paramString = null;
      continue;
      label217:
      String str1 = "";
    }
  }
  
  public boolean a(String paramString1, String paramString2, JSONObject paramJSONObject, long paramLong, String paramString3)
  {
    if (paramLong != 0L) {
      return false;
    }
    if (paramString1.equals("pubaccount/pendant"))
    {
      if ((BaseActivity.sTopActivity instanceof BaseActivity))
      {
        paramString1 = (ChatFragment)BaseActivity.sTopActivity.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
        if (paramString1 != null)
        {
          paramString1 = paramString1.k();
          if ((paramString1 != null) && ((paramString1 instanceof PublicAccountChatPie))) {
            ((PublicAccountChatPie)paramString1).e(paramString2);
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
    if ("cmshow/openGame".equals(paramString1)) {
      return true;
    }
    if ("readinjoy/groupopen".equals(paramString1))
    {
      paramJSONObject = null;
      paramString1 = paramJSONObject;
      try
      {
        paramString2 = new JSONObject(paramString2);
        paramString1 = paramJSONObject;
        paramLong = paramString2.getLong("troopUin");
        paramString1 = paramJSONObject;
        long l = paramString2.getLong("appId");
        paramString1 = paramJSONObject;
        paramString2 = paramString2.optString("jumpData");
        paramString1 = paramString2;
        paramJSONObject = a();
        if (paramJSONObject != null)
        {
          paramString1 = paramString2;
          paramJSONObject = (ITroopAppHandler)paramJSONObject.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopAppHandlerName());
          paramString1 = paramString2;
          paramString3 = new StringBuilder();
          paramString1 = paramString2;
          paramString3.append(paramLong);
          paramString1 = paramString2;
          paramString3.append("");
          paramString1 = paramString2;
          paramJSONObject.a(paramString3.toString(), l);
        }
        paramString1 = paramString2;
        TroopReportor.a("Grp_AIO", "Grp_aio_subscription", "Grp_aio_clk", 1, 0, new String[] { String.valueOf(paramLong) });
        paramString1 = paramString2;
      }
      catch (JSONException paramString2)
      {
        paramString2.printStackTrace();
      }
      ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchGroupSubscribeChannelActivity(BaseActivity.sTopActivity, paramString1, 1);
      return false;
    }
    if ("troop/openManage".equals(paramString1))
    {
      TroopArkHelper.a().a(paramString2);
      return false;
    }
    if ("troop/report".equals(paramString1))
    {
      TroopReportor.a(paramString2);
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("rags are:");
        paramString1.append(paramString2);
        QLog.d("navigate report", 2, paramString1.toString());
        return false;
      }
    }
    else if ("gift/predownload".equals(paramString1))
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("predownload path = ");
        paramString1.append(paramString2);
        QLog.i("VipARPreDownload", 2, paramString1.toString());
      }
      paramString1 = a();
      if (paramString1 != null)
      {
        ((QzoneGiftManager)paramString1.getManager(QQManagerFactory.QZONE_GIFT_MANAGER)).a(paramString2);
        return false;
      }
    }
    else if ("gift/playAnimation".equals(paramString1))
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("playAnimation path = ");
        paramString1.append(paramString2);
        QLog.i("VipARPreDownload", 2, paramString1.toString());
      }
      paramString1 = a();
      if (paramString1 != null)
      {
        paramString1 = (QzoneGiftManager)paramString1.getManager(QQManagerFactory.QZONE_GIFT_MANAGER);
        QLog.i("VipARPreDownload", 1, "playAnimation vipARConfig not match ARgift or isEnableOpen3D = false");
        paramString1.b(paramString2);
        return false;
      }
    }
    else
    {
      if ("qungift/openAioDialog".equals(paramString1))
      {
        if (!QVipGiftProcessor.a().isEnable()) {
          break label658;
        }
        try
        {
          paramString1 = new JSONObject(paramString2).getString("troopUin");
          GiftJsPlugin.openGiftBrowser(BaseActivity.sTopActivity, paramString1);
          return false;
        }
        catch (JSONException paramString1)
        {
          paramString1.printStackTrace();
          return false;
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
          paramString1.c(paramString2);
        }
        return true;
      }
      if (paramString1.startsWith("together?"))
      {
        a(paramString1, paramString2);
        return true;
      }
      if (paramString1.startsWith("weishi"))
      {
        b(paramString1, paramString2);
        return true;
      }
    }
    label658:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.scheme.QQSchemeHandler
 * JD-Core Version:    0.7.0.1
 */