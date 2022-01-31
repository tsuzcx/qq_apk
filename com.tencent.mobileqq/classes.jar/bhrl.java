import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.manager.TicketManager;
import org.json.JSONObject;

public class bhrl
  extends bhsh
  implements bhlf
{
  private String a;
  
  private void a(WebViewPlugin paramWebViewPlugin, bcdp parambcdp, String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      long l;
      String str1;
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]);
        l = paramVarArgs.optLong("uin");
        str1 = paramVarArgs.optString("payKey");
        localObject = paramVarArgs.optString("nickName");
        this.jdField_a_of_type_JavaLangString = paramVarArgs.optString("callback");
        if (l == 0L)
        {
          QLog.e("QZoneRedPocketGiftJsPlugin", 1, "uin error , uin " + l);
          return;
        }
        if (TextUtils.isEmpty(str1))
        {
          QLog.e("QZoneRedPocketGiftJsPlugin", 1, "payKey error , paykey = " + str1);
          return;
        }
      }
      catch (Exception paramWebViewPlugin)
      {
        a(this.jdField_a_of_type_JavaLangString, null, ajya.a(2131712305), -1);
        QLog.e("QZoneRedPocketGiftJsPlugin", 1, paramWebViewPlugin.getMessage());
        return;
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        QLog.e("QZoneRedPocketGiftJsPlugin", 1, "callback is empty.");
        return;
      }
      paramVarArgs = (String[])localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramVarArgs = String.valueOf(l);
      }
      bhlc.a().a().a(l, str1);
      Object localObject = bgyw.a();
      String str2 = ((TicketManager)parambcdp.a().getManager(2)).getSkey(parambcdp.a().getAccount());
      int i = bgyp.a(paramWebViewPlugin, parambcdp, 8);
      bgyp.a(parambcdp.a(), (bgyw)localObject, str2, l, paramVarArgs, str1, i);
    }
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(Intent paramIntent, byte paramByte, int paramInt)
  {
    switch (paramByte)
    {
    default: 
      return;
    }
    if ((paramInt == -1) && (paramIntent != null))
    {
      a(this.jdField_a_of_type_JavaLangString, null, ajya.a(2131712303), 0);
      return;
    }
    a(this.jdField_a_of_type_JavaLangString, null, ajya.a(2131712306), -1);
  }
  
  protected void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    JSONObject localJSONObject;
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin != null)
    {
      if (TextUtils.isEmpty(paramString1))
      {
        paramInt = -1;
        paramString3 = ajya.a(2131712304);
      }
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("code", paramInt);
      localJSONObject.put("data", paramString2);
      localJSONObject.put("message", paramString3);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramString1, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        paramString2.printStackTrace();
      }
    }
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!"Qzone".equals(paramString2)) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime == null)) {}
    while (!"sendRedPocketGift".equals(paramString3)) {
      return false;
    }
    bhlc.a().a(this);
    a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, paramVarArgs);
    return true;
  }
  
  public boolean a(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    return super.a(paramString, paramLong, paramMap);
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ((paramBundle == null) || (!paramBundle.containsKey("data"))) {}
    do
    {
      do
      {
        return;
        if (paramBundle.getBundle("data") != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("QZoneRedPocketGiftJsPlugin", 2, "call js function,bundle is empty");
      return;
    } while (!"cmd.qzoneSendRedPocketGift".equals(paramString));
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      a(this.jdField_a_of_type_JavaLangString, null, ajya.a(2131712302), -1);
      return;
    }
    a(this.jdField_a_of_type_JavaLangString, null, ajya.a(2131712307), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhrl
 * JD-Core Version:    0.7.0.1
 */