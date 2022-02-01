package com.tencent.mobileqq.activity.springfestival.js;

import android.net.Uri;
import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class SpringHbUrlInterceptor
{
  private static String a;
  private static InputStream b;
  
  public static void a()
  {
    InputStream localInputStream = b;
    if (localInputStream != null) {
      try
      {
        localInputStream.close();
        b = null;
        return;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    if (StringUtil.isEmpty(paramString)) {
      return false;
    }
    Object localObject = c(paramString);
    if (localObject != null) {
      if (((Map)localObject).isEmpty()) {
        return false;
      }
    }
    try
    {
      i = Integer.parseInt((String)((Map)localObject).get("o"));
    }
    catch (Exception localException)
    {
      int i;
      label51:
      break label51;
    }
    i = 0;
    localObject = d(paramString);
    if (i == 1)
    {
      if ((!((String)localObject).endsWith(".mp4")) && (!((String)localObject).endsWith(".MP4"))) {
        return false;
      }
      try
      {
        paramString = Uri.parse(paramString).getHost();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("do intercept url's domain: ");
          ((StringBuilder)localObject).append(paramString);
          QLog.d("springHb_SpringHbUrlInterceptor", 2, ((StringBuilder)localObject).toString());
        }
        if (StringUtil.isEmpty(a))
        {
          localObject = QIPCClientHelper.getInstance().getClient().callServer("SpringHbIPCModule", "GetDomain", new Bundle());
          if ((localObject != null) && (((EIPCResult)localObject).data != null)) {
            a = ((EIPCResult)localObject).data.getString("res_domain");
          } else {
            a = "down.qq.com";
          }
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("get domain from IPC: ");
          ((StringBuilder)localObject).append(a);
          QLog.d("springHb_SpringHbUrlInterceptor", 2, ((StringBuilder)localObject).toString());
        }
        if (!StringUtil.isEmpty(a))
        {
          localObject = a.split("\\|");
          int j = localObject.length;
          i = 0;
          while (i < j)
          {
            boolean bool = localObject[i].equals(paramString);
            if (bool) {
              return true;
            }
            i += 1;
          }
        }
        return false;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        QLog.e("springHb_SpringHbUrlInterceptor", 2, paramString.getLocalizedMessage());
      }
    }
    return false;
  }
  
  public static WebResourceResponse b(String paramString)
  {
    paramString = PreloadStaticApi.a(d(paramString));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getWebResponse resPath: ");
      localStringBuilder.append(paramString);
      QLog.d("springHb_SpringHbUrlInterceptor", 2, localStringBuilder.toString());
    }
    if (StringUtil.isEmpty(paramString)) {
      return null;
    }
    try
    {
      b = new BufferedInputStream(new FileInputStream(paramString));
      paramString = new WebResourceResponse("video/mp4", "UTF-8", b);
      return paramString;
    }
    catch (IOException paramString)
    {
      QLog.e("springHb_SpringHbUrlInterceptor", 1, paramString, new Object[0]);
      a();
    }
    return null;
  }
  
  private static Map<String, String> c(String paramString)
  {
    Object localObject = paramString.substring(paramString.indexOf("?") + 1);
    paramString = new HashMap();
    try
    {
      localObject = ((String)localObject).split("&");
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString = localObject[i].split("=");
        if ((arrayOfString != null) && (arrayOfString.length == 2)) {
          paramString.put(arrayOfString[0], URLDecoder.decode(arrayOfString[1]));
        }
        i += 1;
      }
      return paramString;
    }
    catch (Exception localException) {}
    return paramString;
  }
  
  private static String d(String paramString)
  {
    if (StringUtil.isEmpty(paramString)) {
      return "";
    }
    String str = paramString;
    if (paramString.lastIndexOf("?") != -1) {
      str = paramString.split("\\?")[0];
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.js.SpringHbUrlInterceptor
 * JD-Core Version:    0.7.0.1
 */