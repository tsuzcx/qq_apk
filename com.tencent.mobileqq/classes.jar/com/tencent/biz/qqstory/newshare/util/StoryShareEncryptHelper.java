package com.tencent.biz.qqstory.newshare.util;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import mqq.os.MqqHandler;
import nht;

public class StoryShareEncryptHelper
{
  public static void a(Context paramContext, String paramString, StoryShareEncryptHelper.DecryptCallback paramDecryptCallback, QQProgressDialog paramQQProgressDialog)
  {
    ThreadManager.getUIHandler().post(new nht(paramString, paramQQProgressDialog, paramContext, paramDecryptCallback));
  }
  
  public static void a(String paramString, HashMap paramHashMap)
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
  
  public static void a(HashMap paramHashMap)
  {
    HashMap localHashMap = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.util.StoryShareEncryptHelper
 * JD-Core Version:    0.7.0.1
 */