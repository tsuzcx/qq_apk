package com.tencent.biz.qqstory.network.handler;

import android.util.Base64;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class ReportEvilToXinanHandler
{
  private String a()
  {
    String str2 = "abcdabcdabcdabcd";
    String str1 = str2;
    try
    {
      String str3 = HttpUtil.openUrl(BaseApplicationImpl.getContext(), "https://jubao.qq.com/uniform_impeach/impeach_cryptokey", "GET", null, null);
      str1 = str2;
      SLog.a("ReportEvilToXinanHandler", "get report key. response = %s.", str3);
      str1 = str2;
      str2 = a(str3);
      str1 = str2;
      SLog.a("ReportEvilToXinanHandler", "get encrypted key. encryptedKey = %s.", str2);
      str1 = str2;
    }
    catch (Exception localException)
    {
      SLog.e("ReportEvilToXinanHandler", "get encrypted key error. exception = %s.", new Object[] { localException.getMessage() });
    }
    str1 = a("d41d8cd98f00b204e9800998ecf8427e", str1);
    SLog.a("ReportEvilToXinanHandler", "get decryptedKey key. decryptedKey = %s.", str1);
    return str1;
  }
  
  public static String a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).getString("key");
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return "abcdabcdabcdabcd";
  }
  
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      boolean bool = paramString2.equals("abcdabcdabcdabcd");
      if (bool) {
        paramString2 = paramString2.getBytes("UTF-8");
      } else {
        paramString2 = Base64.decode(paramString2.getBytes("UTF-8"), 0);
      }
      Cipher localCipher = Cipher.getInstance("AES/ECB/NoPadding");
      localCipher.init(2, new SecretKeySpec(paramString1.getBytes(), "AES"));
      paramString1 = new String(localCipher.doFinal(paramString2));
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("decrypt Key has something wrong : ");
      paramString2.append(paramString1.toString());
      QLog.e("", 1, paramString2.toString());
      paramString1.printStackTrace();
    }
    return null;
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handle report response. response = ");
    ((StringBuilder)localObject).append(paramString4);
    SLog.b("ReportEvilToXinanHandler", ((StringBuilder)localObject).toString());
    localObject = ((UserManager)SuperManager.a(2)).b(paramString1);
    boolean bool;
    if ((localObject != null) && (((QQUserUIItem)localObject).isVip)) {
      bool = true;
    } else {
      bool = false;
    }
    ThreadManager.getUIHandler().post(new ReportEvilToXinanHandler.2(this, paramString4, bool, paramString3, paramString2, paramString1));
  }
  
  private void a(String paramString1, boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    ThreadManager.post(new ReportEvilToXinanHandler.1(this, paramBoolean, paramString4, paramString5, paramString1, paramString3, paramString2), 5, null, false);
  }
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    SLog.a("ReportEvilToXinanHandler", "report user with arguments: eviluin = %s, isFriend = %s, evilType = %s.", paramString1, Boolean.valueOf(paramBoolean), paramString2);
    a(paramString1, paramBoolean, null, paramString2, "", "");
  }
  
  public void a(String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    SLog.a("ReportEvilToXinanHandler", "report comment with arguments: eviluin = %s, isFriend = %s, evilType = %s, textEvidence = %s.", paramString1, Boolean.valueOf(paramBoolean), paramString2, paramString3);
    a(paramString1, paramBoolean, null, paramString2, paramString3, "");
  }
  
  public void a(String paramString1, boolean paramBoolean, String paramString2, String paramString3, String paramString4)
  {
    SLog.a("ReportEvilToXinanHandler", "report video with arguments: eviluin = %s, isFriend = %s, evilType = %s, videoEvidence = %s.", paramString1, Boolean.valueOf(paramBoolean), paramString3, paramString4);
    a(paramString1, paramBoolean, paramString2, paramString3, "", paramString4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.ReportEvilToXinanHandler
 * JD-Core Version:    0.7.0.1
 */