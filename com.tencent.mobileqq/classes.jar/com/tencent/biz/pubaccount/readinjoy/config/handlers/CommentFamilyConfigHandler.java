package com.tencent.biz.pubaccount.readinjoy.config.handlers;

import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.AladdinParseUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CommentFamilyConfigHandler
  extends SimpleConfigHandler
{
  public static String a = "CommentFamilyConfigHandler";
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    QLog.d(a, 2, "[onReceiveConfig] id=" + paramInt1 + ", version=" + paramInt2 + ", content=" + paramString);
    paramString = AladdinParseUtils.a(paramString);
    Object localObject = paramString.keySet();
    for (;;)
    {
      String str1;
      String str2;
      try
      {
        localObject = ((Set)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          str1 = (String)((Iterator)localObject).next();
          str2 = (String)paramString.get(str1);
          if (TextUtils.equals(str1, "rij_comment_family_entrance_switch")) {
            ReadInJoyHelper.m(Integer.parseInt(str2));
          }
        }
        else
        {
          return true;
        }
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
      if (TextUtils.equals(str1, "rij_small_zhitiao_entrance_switch")) {
        ReadInJoyHelper.a("readinjjoy_notes_config", Integer.valueOf(Integer.parseInt(str2)));
      }
    }
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    ReadInJoyHelper.m(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.config.handlers.CommentFamilyConfigHandler
 * JD-Core Version:    0.7.0.1
 */