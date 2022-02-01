import android.content.Context;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class arhq
{
  private String a = "";
  private String b = "";
  
  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return paramString;
      try
      {
        Object localObject1 = new JSONObject(paramString).getString("oac_triggle").split("&");
        if (localObject1 == null) {
          continue;
        }
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          if (localObject2.startsWith("busi_id"))
          {
            localObject1 = blhn.b(localObject2.split("=")[1]);
            return localObject1;
          }
          i += 1;
        }
        return paramString;
      }
      catch (Exception localException)
      {
        QLog.e("QQComicConfBean", 1, localException, new Object[0]);
      }
    }
  }
  
  private static String a(String paramString1, String paramString2, String paramString3)
  {
    int i = paramString1.indexOf('?');
    int j = paramString1.indexOf('#');
    String str;
    if (i == -1) {
      str = "?";
    }
    try
    {
      for (;;)
      {
        paramString2 = str + blhn.a(new StringBuilder().append(paramString2).append('=').append(paramString3).toString());
        if (j != -1) {
          break;
        }
        paramString2 = paramString1 + paramString2;
        return paramString2;
        str = blhn.a("&");
      }
      paramString2 = paramString1.substring(0, j) + paramString2 + paramString1.substring(j);
      paramString1 = paramString2;
    }
    catch (Exception paramString2)
    {
      return paramString1;
    }
    return paramString1;
  }
  
  public boolean a(String paramString)
  {
    return TextUtils.equals(paramString, this.a);
  }
  
  public boolean a(String paramString, Context paramContext, int paramInt, QQAppInterface paramQQAppInterface)
  {
    if ((a(paramString)) && (!TextUtils.isEmpty(this.b)))
    {
      String str3 = this.b;
      String str2 = null;
      QQMessageFacade.Message localMessage = paramQQAppInterface.a().a(paramString, 1008);
      String str1 = str2;
      if (localMessage != null)
      {
        str1 = str2;
        if (!localMessage.isread) {
          str1 = a(localMessage.getExtInfoFromExtStr("report_key_bytes_oac_msg_extend"));
        }
      }
      str2 = str3;
      if (!TextUtils.isEmpty(str1)) {
        str2 = a(str3, "_ext", str1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQComicConfBean", 2, new Object[] { "launchIfMatched, params=", str1, ", finalUrl=", str2 });
      }
      return MiniAppLauncher.startMiniApp(paramContext, str2, paramInt, new arhr(this, paramQQAppInterface, paramString));
    }
    return false;
  }
  
  public String toString()
  {
    return "ServiceAccountConfig{uin=" + this.a + ", url=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arhq
 * JD-Core Version:    0.7.0.1
 */