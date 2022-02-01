package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import android.text.TextUtils;
import bkwm;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import pbt;
import rck;

public class AwesomeCommentConfigHandler
  implements AladdinConfigHandler
{
  private static final String TAG = "AwesomeCommentConfigHandler";
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    QLog.d("AwesomeCommentConfigHandler", 2, "[onReceiveConfig] " + paramInt1 + " " + paramString);
    Map localMap = pbt.a(paramString);
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)localMap.get(str1);
      QLog.d("AwesomeCommentConfigHandler", 2, "[onReceiveConfig] key=" + str1 + ", value=" + str2);
      if (TextUtils.equals(str1, "awesome_comment_plan"))
      {
        if (TextUtils.equals(str2, "1")) {
          paramInt2 = 1;
        }
        for (;;)
        {
          bkwm.a(rck.h, Integer.valueOf(paramInt2));
          break;
          if (TextUtils.equals(str2, "2")) {
            paramInt2 = 2;
          } else {
            paramInt2 = 0;
          }
        }
      }
      if (TextUtils.equals(str1, "awesome_comment_line_number")) {
        try
        {
          bkwm.a(rck.i, Integer.valueOf(str2));
          Aladdin.getConfig(paramInt1).update(paramString);
        }
        catch (NumberFormatException localNumberFormatException)
        {
          localNumberFormatException.printStackTrace();
          QLog.e("AwesomeCommentConfigHandler", 2, localNumberFormatException.getLocalizedMessage());
        }
      }
    }
    return true;
  }
  
  public void onWipeConfig(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.AwesomeCommentConfigHandler
 * JD-Core Version:    0.7.0.1
 */