package com.tencent.comic.config;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import org.json.JSONObject;

public class QQComicConfBean$ServiceAccountConfig
{
  private String a = "";
  private String b = "";
  
  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    try
    {
      Object localObject1 = new JSONObject(paramString).getString("oac_triggle").split("&");
      if (localObject1 != null)
      {
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          if (localObject2.startsWith("busi_id"))
          {
            localObject1 = URLUtil.b(localObject2.split("=")[1]);
            return localObject1;
          }
          i += 1;
        }
      }
      return paramString;
    }
    catch (Exception localException)
    {
      QLog.e("QQComicConfBean", 1, localException, new Object[0]);
    }
  }
  
  private static String a(String paramString1, String paramString2, String paramString3)
  {
    int i = paramString1.indexOf('?');
    int j = paramString1.indexOf('#');
    Object localObject;
    if (i == -1) {
      localObject = "?";
    }
    try
    {
      localObject = URLUtil.a("&");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append('=');
      ((StringBuilder)localObject).append(paramString3);
      localStringBuilder.append(URLUtil.a(((StringBuilder)localObject).toString()));
      paramString2 = localStringBuilder.toString();
      if (j == -1)
      {
        paramString3 = new StringBuilder();
        paramString3.append(paramString1);
      }
      for (;;)
      {
        paramString3.append(paramString2);
        return paramString3.toString();
        paramString3 = new StringBuilder();
        paramString3.append(paramString1.substring(0, j));
        paramString3.append(paramString2);
        paramString2 = paramString1.substring(j);
      }
      return paramString1;
    }
    catch (Exception paramString2) {}
  }
  
  public boolean a(String paramString)
  {
    return TextUtils.equals(paramString, this.a);
  }
  
  public boolean a(String paramString, Context paramContext, int paramInt, AppInterface paramAppInterface)
  {
    if ((a(paramString)) && (!TextUtils.isEmpty(this.b)))
    {
      String str2 = this.b;
      String str1 = null;
      IMessageFacade localIMessageFacade = (IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "");
      Message localMessage = localIMessageFacade.getLastMessage(paramString, 1008);
      paramAppInterface = str1;
      if (localMessage != null)
      {
        paramAppInterface = str1;
        if (!localMessage.isread) {
          paramAppInterface = a(localMessage.getExtInfoFromExtStr("report_key_bytes_oac_msg_extend"));
        }
      }
      str1 = str2;
      if (!TextUtils.isEmpty(paramAppInterface)) {
        str1 = a(str2, "_ext", paramAppInterface);
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQComicConfBean", 2, new Object[] { "launchIfMatched, params=", paramAppInterface, ", finalUrl=", str1 });
      }
      paramString = new QQComicConfBean.ServiceAccountConfig.1(this, localIMessageFacade, paramString);
      return ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramContext, str1, paramInt, paramString);
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ServiceAccountConfig{uin=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", url=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.config.QQComicConfBean.ServiceAccountConfig
 * JD-Core Version:    0.7.0.1
 */