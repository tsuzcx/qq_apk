package com.tencent.biz.qqstory.newshare.util;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashMap<Ljava.lang.String;Ljava.lang.String;>;
import java.util.Iterator;
import java.util.Set;
import mqq.os.MqqHandler;

public class StoryShareEncryptHelper
{
  public static String a(String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String[] arrayOfString = paramString.split("&");
    int m = arrayOfString.length;
    paramString = null;
    int j = 0;
    Object localObject;
    int k;
    for (int i = 1; j < m; i = k)
    {
      localObject = arrayOfString[j];
      String str = localObject.split("=")[0];
      if ((!str.equals("src_type")) && (!str.equals("version")) && (!str.equals("type")) && (!str.equals("actionnamekey")) && (!str.equals("storysharefrom")) && ((!paramBoolean) || (!str.equals("videoId"))) && ((!paramBoolean) || (!str.equals("videoOwnerUin"))) && ((!paramBoolean) || (!str.equals("unionid"))))
      {
        localObject = paramString;
        k = i;
        if (QLog.isColorLevel())
        {
          if (paramString == null) {
            paramString = new StringBuilder();
          } else {
            paramString.append('|');
          }
          paramString.append(str);
          localObject = paramString;
          k = i;
        }
      }
      else
      {
        if (i != 0) {
          i = 0;
        } else {
          localStringBuilder.append('&');
        }
        localStringBuilder.append((String)localObject);
        k = i;
        localObject = paramString;
      }
      j += 1;
      paramString = (String)localObject;
    }
    if ((paramString != null) && (QLog.isColorLevel()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("remove params:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("Q.qqstory.share.trans.helper", 2, ((StringBuilder)localObject).toString());
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
    Iterator localIterator = paramHashMap.keySet().iterator();
    label12:
    Object localObject;
    for (paramHashMap = null; localIterator.hasNext(); paramHashMap = (HashMap<String, String>)localObject)
    {
      String str = (String)localIterator.next();
      if ((str.equals("src_type")) || (str.equals("version")) || (str.equals("from_leba")) || (str.equals("leba_resid")) || (str.equals("config_res_plugin_item_name")) || (str.equals("redtouch_click_timestamp")) || (str.equals("lebaVersion")) || (str.equals("redid"))) {
        break label12;
      }
      localObject = paramHashMap;
      if (QLog.isColorLevel())
      {
        if (paramHashMap == null) {
          paramHashMap = new StringBuilder();
        } else {
          paramHashMap.append('|');
        }
        paramHashMap.append(str);
        localObject = paramHashMap;
      }
      localIterator.remove();
    }
    if ((paramHashMap != null) && (QLog.isColorLevel()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("remove attrs:");
      ((StringBuilder)localObject).append(paramHashMap);
      QLog.d("Q.qqstory.share.trans.helper", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.util.StoryShareEncryptHelper
 * JD-Core Version:    0.7.0.1
 */