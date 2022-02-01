package com.tencent.biz.qqstory.newshare.util;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import mqq.os.MqqHandler;

public class StoryShareEncryptHelper
{
  public static String a(String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = null;
    int i = 1;
    String[] arrayOfString = paramString.split("&");
    int k = arrayOfString.length;
    int j = 0;
    paramString = str1;
    if (j < k)
    {
      str1 = arrayOfString[j];
      String str2 = str1.split("=")[0];
      if ((str2.equals("src_type")) || (str2.equals("version")) || (str2.equals("type")) || (str2.equals("actionnamekey")) || (str2.equals("storysharefrom")) || ((paramBoolean) && (str2.equals("videoId"))) || ((paramBoolean) && (str2.equals("videoOwnerUin"))) || ((paramBoolean) && (str2.equals("unionid"))))
      {
        if (i != 0) {
          i = 0;
        }
        for (;;)
        {
          localStringBuilder.append(str1);
          j += 1;
          break;
          localStringBuilder.append('&');
        }
      }
      str1 = paramString;
      if (QLog.isColorLevel())
      {
        if (paramString != null) {
          break label216;
        }
        paramString = new StringBuilder();
      }
      for (;;)
      {
        paramString.append(str2);
        str1 = paramString;
        paramString = str1;
        break;
        label216:
        paramString.append('|');
      }
    }
    if ((paramString != null) && (QLog.isColorLevel())) {
      QLog.d("Q.qqstory.share.trans.helper", 2, "remove params:" + paramString);
    }
    return localStringBuilder.toString();
  }
  
  public static void a(Context paramContext, String paramString, StoryShareEncryptHelper.DecryptCallback paramDecryptCallback, QQProgressDialog paramQQProgressDialog)
  {
    ThreadManager.getUIHandler().post(new StoryShareEncryptHelper.2(paramString, paramQQProgressDialog, paramContext, paramDecryptCallback));
  }
  
  public static void a(String paramString, HashMap<String, String> paramHashMap)
  {
    paramString = paramString.split("&");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String[] arrayOfString = paramString[i].split("=");
      if (arrayOfString.length == 2) {
        paramHashMap.put(arrayOfString[0], arrayOfString[1]);
      }
      i += 1;
    }
  }
  
  public static void a(HashMap<String, String> paramHashMap)
  {
    HashMap<String, String> localHashMap = null;
    Iterator localIterator = paramHashMap.keySet().iterator();
    paramHashMap = localHashMap;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!str.equals("src_type")) && (!str.equals("version")) && (!str.equals("from_leba")) && (!str.equals("leba_resid")) && (!str.equals("config_res_plugin_item_name")) && (!str.equals("redtouch_click_timestamp")) && (!str.equals("lebaVersion")) && (!str.equals("redid")))
      {
        localHashMap = paramHashMap;
        if (QLog.isColorLevel())
        {
          if (paramHashMap != null) {
            break label144;
          }
          paramHashMap = new StringBuilder();
        }
        for (;;)
        {
          paramHashMap.append(str);
          localHashMap = paramHashMap;
          localIterator.remove();
          paramHashMap = localHashMap;
          break;
          label144:
          paramHashMap.append('|');
        }
      }
    }
    if ((paramHashMap != null) && (QLog.isColorLevel())) {
      QLog.d("Q.qqstory.share.trans.helper", 2, "remove attrs:" + paramHashMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.util.StoryShareEncryptHelper
 * JD-Core Version:    0.7.0.1
 */