package com.tencent.mobileqq.ark.API;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.apollo.ApolloGameNormalStartHandler;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ArkAppSchemeCenter$QQSchemeHandler
  implements ArkAppSchemeCenter.IRegScheme
{
  protected QQAppInterface a()
  {
    return (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
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
        paramString.b();
        return;
        label196:
        paramString = null;
      }
    }
  }
  
  public boolean a(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    if (paramLong != 0L) {}
    do
    {
      return false;
      if (paramString1.equals("pubaccount/pendant"))
      {
        if ((BaseActivity.sTopActivity instanceof FragmentActivity))
        {
          paramString1 = (ChatFragment)((FragmentActivity)BaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
          if (paramString1 != null)
          {
            paramString1 = paramString1.a();
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
    } while (!"cmshow/openGame".equals(paramString1));
    paramString1 = a();
    if (paramString1 != null) {
      ((ApolloManager)paramString1.getManager(152)).a().a(paramString2);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppSchemeCenter.QQSchemeHandler
 * JD-Core Version:    0.7.0.1
 */