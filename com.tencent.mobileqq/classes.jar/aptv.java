import UserGrowth.stSimpleMetaFeed;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.API.ArkAppSchemeCenter.QQSchemeHandler.1;
import com.tencent.mobileqq.ark.API.ArkAppSchemeCenter.QQSchemeHandler.2;
import com.tencent.mobileqq.ark.API.ArkAppSchemeCenter.QQSchemeHandler.3;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.ar.VipARShowActivity;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class aptv
  implements aptt
{
  private void a(String paramString1, String paramString2)
  {
    Map localMap;
    try
    {
      QLog.i("QQSchemeHandler", 1, "handleTogether " + paramString1 + paramString2);
      paramString1 = bkyp.a(paramString1);
      localMap = aptq.a(new JSONObject(paramString2));
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
    Object localObject;
    try
    {
      paramString2 = new JSONObject(paramString2);
      paramString1 = paramString2.optString("jumpType");
      localObject = paramString2.optString("feed");
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        QLog.i("terry_ark", 1, "handleArkJump: err, strFeed = " + (String)localObject);
        bjkv.a().a("请求失败，请稍后再试");
        return;
      }
      localObject = vno.a((String)localObject);
      if ((localObject == null) || (TextUtils.isEmpty(((stSimpleMetaFeed)localObject).id)) || (TextUtils.isEmpty(((stSimpleMetaFeed)localObject).poster_id)))
      {
        QLog.i("terry_ark", 1, "handleArkJump: err, feed is err.");
        bjkv.a().a("请求失败，请稍后再试");
        return;
      }
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    String str = paramString2.optString("groupNum");
    paramString2 = paramString2.optString("schema");
    QLog.i("terry_ark", 1, "handleArkJump: schema = " + paramString2);
    if ((paramString1.equals("jumpApp")) && (!TextUtils.isEmpty(paramString2)) && (paramString2.startsWith("weishi://")) && (zfn.a(BaseActivity.sTopActivity)))
    {
      vmr.a(BaseActivity.sTopActivity, "biz_src_jc_gzh_weishi", paramString2);
      vsi.a(str, 1000003, (stSimpleMetaFeed)localObject);
      return;
    }
    vno.a((stSimpleMetaFeed)localObject, BaseActivity.sTopActivity);
    vsi.a(str, 1000001, (stSimpleMetaFeed)localObject);
    WSPublicAccReport.getInstance().enterPublicAccReport(null, 2, "from_qq_chat");
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
          break label205;
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
      paramString = bhey.a(a(), localBaseActivity, String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.PoiMapActivity&type=sharedmap&lat=%s&lon=%s&title=%s&loc=%s&dpid=null", new Object[] { paramString, str1, str2, str3 }));
      if (paramString != null)
      {
        paramString.a();
        return;
        label205:
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
          if ((paramString1 != null) && ((paramString1 instanceof aido))) {
            ((aido)paramString1).a(paramString2);
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
        ((amme)paramString1.getManager(QQManagerFactory.APOLLO_MANAGER)).a().a(paramString2);
      }
      return true;
    }
    if ("readinjoy/groupopen".equals(paramString1)) {}
    label266:
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
              ((aoep)paramString2.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(paramLong + "", l);
            }
            bhbu.a("Grp_AIO", "Grp_aio_subscription", "Grp_aio_clk", 1, 0, new String[] { String.valueOf(paramLong) });
            osg.a(BaseActivity.sTopActivity, paramString1, 1);
            return false;
          }
          catch (JSONException paramString2)
          {
            break label266;
          }
          paramString2 = paramString2;
          paramString1 = null;
        }
        continue;
        if ("troop/openManage".equals(paramString1))
        {
          apwe.a().a(paramString2);
        }
        else if ("troop/report".equals(paramString1))
        {
          bhbu.a(paramString2);
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
          if (paramString1 != null)
          {
            paramString1 = (bazk)paramString1.getManager(QQManagerFactory.QZONE_GIFT_MANAGER);
            paramString1.a(paramString2);
            paramString1 = paramString1.a(paramString2);
            if ((paramString1 != null) && (!TextUtils.isEmpty(paramString1.b)) && (bmmh.a().a()))
            {
              bmmb.a().b();
              bmmb.a().a();
              bjwe.a("1018", true, null);
              bmmh.a().a(paramString1, null);
            }
            else
            {
              QLog.i("VipARPreDownload", 1, "predownload vipARConfig not match ARgift or isEnableOpen3D = " + bmmh.a().a());
            }
          }
        }
        else
        {
          if (!"gift/playAnimation".equals(paramString1)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.i("VipARPreDownload", 2, "playAnimation path = " + paramString2);
          }
          paramString1 = a();
          if (paramString1 != null)
          {
            paramJSONObject = (bazk)paramString1.getManager(QQManagerFactory.QZONE_GIFT_MANAGER);
            paramString1 = paramJSONObject.a(paramString2);
            if ((paramString1 != null) && (!TextUtils.isEmpty(paramString1.b)) && (bmmh.a().a()))
            {
              if (bmmb.a(600))
              {
                paramString2 = new Intent(BaseActivity.sTopActivity, VipARShowActivity.class);
                paramString2.putExtra("modelResUrl", paramString1.b);
                paramString2.putExtra("modelResMd5", paramString1.c);
                paramString2.putExtra("key_refer", "value_refer_aio");
                BaseActivity.sTopActivity.startActivity(paramString2);
              }
              else
              {
                QLog.i("VipARPreDownload", 1, "playAnimation isClickEnable = false ");
              }
            }
            else
            {
              QLog.i("VipARPreDownload", 1, "playAnimation vipARConfig not match ARgift or isEnableOpen3D = " + bmmh.a().a());
              paramJSONObject.b(paramString2);
            }
          }
        }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aptv
 * JD-Core Version:    0.7.0.1
 */