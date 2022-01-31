package com.tencent.mobileqq.apollo.game;

import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.io.File;
import java.net.URL;
import java.net.URLDecoder;
import ymd;

public class ApolloGameResManager
{
  public static ApolloGameResManager a;
  private static LRULinkedHashMap a;
  
  static
  {
    jdField_a_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(2);
  }
  
  public static ApolloGameResManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameResManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameResManager == null) {
        jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameResManager = new ApolloGameResManager();
      }
      return jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameResManager;
    }
    finally {}
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      String str2 = ApolloGameTool.a(paramString2);
      if (paramString1.trim().startsWith("file://"))
      {
        paramString2 = paramString1.replace("file://", "");
        if (!paramString2.startsWith(str2)) {
          break label172;
        }
      }
      for (;;)
      {
        for (;;)
        {
          paramString1 = new File(paramString2);
          if ((!paramString1.exists()) || (paramString1.isDirectory()) || (!paramString1.getAbsolutePath().startsWith(str2))) {
            break label200;
          }
          return paramString2;
          if (!paramString1.trim().startsWith("http://"))
          {
            paramString2 = paramString1;
            if (!paramString1.trim().startsWith("https://")) {
              break;
            }
          }
          paramString2 = paramString1;
          String str1 = paramString1;
          try
          {
            if (!paramString1.contains("_gameid")) {
              break;
            }
            str1 = paramString1;
            paramString1 = URLDecoder.decode(paramString1, "UTF-8");
            str1 = paramString1;
            paramString2 = new URL(paramString1).getPath();
            str1 = paramString2;
            boolean bool = TextUtils.isEmpty(paramString2);
            if (!bool) {
              break;
            }
            return null;
          }
          catch (Throwable paramString1)
          {
            QLog.e("ApolloGameResManager", 1, paramString1, new Object[0]);
            paramString2 = str1;
          }
        }
        break;
        label172:
        paramString2 = str2 + "/" + paramString2;
      }
    }
    label200:
    return null;
  }
  
  public ApolloGameResManager.ApolloGameRes a(String paramString1, String paramString2)
  {
    String str;
    if (!TextUtils.isEmpty(paramString1))
    {
      str = a(paramString1, paramString2);
      if (!TextUtils.isEmpty(str))
      {
        paramString1 = (LruCache)jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get(paramString2);
        if (paramString1 != null) {
          break label190;
        }
        paramString1 = new ymd(this, 10485760);
        jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put(paramString2, paramString1);
      }
    }
    label190:
    for (paramString2 = paramString1;; paramString2 = paramString1)
    {
      ApolloGameResManager.ApolloGameRes localApolloGameRes = (ApolloGameResManager.ApolloGameRes)paramString2.get(str);
      paramString1 = localApolloGameRes;
      if (localApolloGameRes == null)
      {
        localApolloGameRes = new ApolloGameResManager.ApolloGameRes();
        localApolloGameRes.b = str;
        paramString1 = "text/html";
        if (!str.contains(".css")) {
          break label126;
        }
        paramString1 = "text/css";
      }
      for (;;)
      {
        localApolloGameRes.a = paramString1;
        localApolloGameRes.a();
        paramString2.put(str, localApolloGameRes);
        paramString1 = localApolloGameRes;
        return paramString1;
        label126:
        if (str.contains(".js")) {
          paramString1 = "application/x-javascript";
        } else if ((str.contains(".jpg")) || (str.contains(".gif")) || (str.contains(".png")) || (str.contains(".jpeg"))) {
          paramString1 = "image/*";
        }
      }
      return null;
    }
  }
  
  public void a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameResManager != null) {
        jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameResManager = null;
      }
      if (jdField_a_of_type_ComTencentUtilLRULinkedHashMap != null) {
        jdField_a_of_type_ComTencentUtilLRULinkedHashMap.clear();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloGameResManager", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGameResManager
 * JD-Core Version:    0.7.0.1
 */