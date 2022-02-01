package com.tencent.biz.common.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.TraceUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class Util
{
  @ConfigInject(configPath="Foundation/QQCommon/src/main/resources/Inject_Util.yml", version=1)
  public static ArrayList<Class<? extends IUtil>> a = new ArrayList();
  
  static
  {
    a.add(TraceUtil.class);
  }
  
  public static final String a(int paramInt)
  {
    if (paramInt == 0) {
      return "contact";
    }
    if (paramInt == 1) {
      return "group";
    }
    if (paramInt == 3000) {
      return "discussions";
    }
    return "";
  }
  
  public static String a(InputStream paramInputStream)
  {
    try
    {
      paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream));
      StringBuilder localStringBuilder = new StringBuilder();
      for (;;)
      {
        String str = paramInputStream.readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str);
      }
      paramInputStream = localStringBuilder.toString();
      return paramInputStream;
    }
    catch (Exception paramInputStream)
    {
      paramInputStream.printStackTrace();
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("\"");
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      char c = paramString.charAt(i);
      if (c != '\f')
      {
        if (c != '\r')
        {
          if ((c != '"') && (c != '/') && (c != '\\')) {}
          switch (c)
          {
          default: 
            if (c <= '\037') {
              localStringBuilder.append(String.format("\\u%04x", new Object[] { Integer.valueOf(c) }));
            } else {
              localStringBuilder.append(c);
            }
            break;
          case '\n': 
            localStringBuilder.append("\\n");
            break;
          case '\t': 
            localStringBuilder.append("\\t");
            break;
          case '\b': 
            localStringBuilder.append("\\b");
            break;
            localStringBuilder.append('\\');
            localStringBuilder.append(c);
            break;
          }
        }
        else
        {
          localStringBuilder.append("\\r");
        }
      }
      else {
        localStringBuilder.append("\\f");
      }
      i += 1;
    }
    localStringBuilder.append("\"");
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString, int paramInt)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject3 = "";
    Object localObject1 = localObject3;
    if (!bool)
    {
      localObject1 = localObject3;
      if (paramInt <= 0) {}
    }
    for (;;)
    {
      int i;
      try
      {
        localObject4 = Uri.parse(paramString);
        localObject1 = localObject3;
        if (!((Uri)localObject4).isHierarchical()) {
          break label164;
        }
        localObject4 = ((Uri)localObject4).getHost();
        localObject1 = localObject3;
        if (localObject4 == null) {
          break label164;
        }
        localObject4 = ((String)localObject4).split("\\.");
        localObject1 = localObject3;
        if (localObject4.length <= 0) {
          break label164;
        }
        i = Math.max(0, localObject4.length - (paramInt + 1));
        localObject1 = new StringBuilder(256);
        ((StringBuilder)localObject1).append(localObject4[i]);
      }
      catch (Exception localException)
      {
        Object localObject4;
        localException.printStackTrace();
        localObject2 = localObject3;
      }
      if (i < localObject4.length)
      {
        ((StringBuilder)localObject1).append('.');
        ((StringBuilder)localObject1).append(localObject4[i]);
      }
      else
      {
        localObject1 = ((StringBuilder)localObject1).toString();
        Object localObject2;
        label164:
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("Get ");
          ((StringBuilder)localObject3).append(paramInt);
          ((StringBuilder)localObject3).append(" level domain= ");
          ((StringBuilder)localObject3).append(localObject2);
          ((StringBuilder)localObject3).append(" from ");
          ((StringBuilder)localObject3).append(paramString);
          QLog.d("QLog", 2, ((StringBuilder)localObject3).toString());
        }
        return localObject2;
      }
      i += 1;
    }
  }
  
  public static String a(String paramString, String... paramVarArgs)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    paramString = paramString.replaceAll("(?<=\\?|#|&)((?i)sid|3g_sid|uin|sec_sig|MOBINFO|originuin)=[^&#]*&", "").replaceAll("[\\?#&]((?i)sid|3g_sid|uin|sec_sig|MOBINFO|originuin)=[^&#]*(?=#|$)", "").replaceAll("(?<=\\?|#|&)((?i)from)=androidqq&", "").replaceAll("[\\?#&]((?i)from)=androidqq(?=#|$)", "");
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramString = paramString.replace(paramVarArgs[i], "");
      i += 1;
    }
    return paramString;
  }
  
  public static void a(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_error_code", paramInt);
    localIntent.putExtra("key_error_msg", paramString1);
    localIntent.putExtra("key_error_detail", paramString2);
    localIntent.putExtra("key_response", "");
    ((Activity)paramContext).setResult(-1, localIntent);
  }
  
  public static void a(String paramString)
  {
    try
    {
      ((IUtil)((Class)a.get(0)).newInstance()).a(paramString);
      return;
    }
    catch (InstantiationException paramString)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("beginTimeTrack error:");
      localStringBuilder.append(paramString);
      QLog.e("Util", 1, localStringBuilder.toString());
      return;
    }
    catch (IllegalAccessException paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("beginTimeTrack error:");
      localStringBuilder.append(paramString);
      QLog.e("Util", 1, localStringBuilder.toString());
    }
  }
  
  public static final void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, long paramLong1, long paramLong2, String paramString3)
  {
    a(paramAppRuntime, paramString1, "connect_share2qq", paramString2, paramLong1, paramLong2, paramString3);
  }
  
  public static final void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, String paramString4)
  {
    String str2 = "";
    if (paramString4 == null) {
      paramString4 = "";
    }
    if (paramString1 == null) {
      paramString1 = "";
    }
    String str1;
    if (paramLong2 > 0L) {
      str1 = String.valueOf(paramLong2);
    } else {
      str1 = "";
    }
    if (paramLong1 > 0L) {
      str2 = String.valueOf(paramLong1);
    }
    ReportController.b(paramAppRuntime, "P_CliOper", "qqconnect", paramString1, paramString2, paramString3, 0, 0, str2, str1, paramString4, "");
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = paramString;
    if (!paramString.endsWith(File.separator))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(File.separator);
      localObject = ((StringBuilder)localObject).toString();
    }
    paramString = new File((String)localObject);
    if (paramString.exists())
    {
      if (!paramString.isDirectory()) {
        return false;
      }
      File[] arrayOfFile = paramString.listFiles();
      if (arrayOfFile == null) {
        return false;
      }
      int i = 0;
      while (i < arrayOfFile.length)
      {
        if (arrayOfFile[i] != null) {
          if (arrayOfFile[i].isFile()) {
            b(arrayOfFile[i].getAbsolutePath());
          } else {
            a(arrayOfFile[i].getAbsolutePath());
          }
        }
        i += 1;
      }
      paramString.delete();
      if (QLog.isColorLevel()) {
        QLog.d("Util", 2, new Object[] { "deleteDirectory dirPath:", localObject });
      }
      return true;
    }
    return false;
  }
  
  public static String b(String paramString)
  {
    return a(paramString, 1);
  }
  
  public static String b(String paramString, String... paramVarArgs)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    return paramString.replaceAll("((?i)sid|uin|sec_sig|MOBINFO)=[^&#]+", "$1=****");
  }
  
  public static void b(String paramString)
  {
    try
    {
      ((IUtil)((Class)a.get(0)).newInstance()).b(paramString);
      return;
    }
    catch (InstantiationException paramString)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("endTimeTrack error:");
      localStringBuilder.append(paramString);
      QLog.e("Util", 1, localStringBuilder.toString());
      return;
    }
    catch (IllegalAccessException paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("endTimeTrack error:");
      localStringBuilder.append(paramString);
      QLog.e("Util", 1, localStringBuilder.toString());
    }
  }
  
  public static boolean b(String paramString)
  {
    paramString = new File(paramString);
    if ((paramString.isFile()) && (paramString.exists())) {
      try
      {
        paramString.delete();
        return true;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    return false;
  }
  
  public static String c(String paramString)
  {
    paramString = paramString.toCharArray();
    int i = 0;
    while (i < paramString.length)
    {
      if (paramString[i] == '　') {
        paramString[i] = 32;
      } else if ((paramString[i] > 65280) && (paramString[i] < 65375)) {
        paramString[i] = ((char)(paramString[i] - 65248));
      }
      i += 1;
    }
    return new String(paramString);
  }
  
  public static String c(String paramString, String... paramVarArgs)
  {
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      if ((paramVarArgs != null) && (paramVarArgs.length != 0))
      {
        localObject = new StringBuilder("");
        int j = paramVarArgs.length;
        int i = 0;
        while (i < j)
        {
          String str = paramVarArgs[i];
          if (!TextUtils.isEmpty(str))
          {
            ((StringBuilder)localObject).append("|");
            ((StringBuilder)localObject).append(str);
          }
          i += 1;
        }
        paramVarArgs = String.format("(?<=(a1|a2|key|token|uin|sid|sig|stwxweb%s)=\\S)[^; ]+(?=[^;$])", new Object[] { ((StringBuilder)localObject).toString() });
      }
      else
      {
        paramVarArgs = "(?<=(a1|a2|key|token|uin|sid|sig|stwxweb)=\\S)[^; ]+(?=[^;$])";
      }
      localObject = paramString.toLowerCase().replaceAll(paramVarArgs, "*");
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.common.util.Util
 * JD-Core Version:    0.7.0.1
 */