package com.tencent.mobileqq.ark;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.multiproc.ArkMultiProcUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class ArkAppCenter
  implements Manager
{
  private final QQAppInterface a;
  
  static {}
  
  public ArkAppCenter(QQAppInterface paramQQAppInterface)
  {
    QLog.i("ArkApp", 1, "ArkAppCenter.init");
    this.a = paramQQAppInterface;
  }
  
  public static void a(Intent paramIntent)
  {
    a(paramIntent, null);
  }
  
  public static void a(Intent paramIntent, String paramString)
  {
    if (paramIntent != null)
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = "biz_src_jc_ark";
      }
      paramIntent.putExtra("big_brother_source_key", str);
    }
  }
  
  public static void a(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.putString("big_brother_source_key", "biz_src_jc_ark");
    }
  }
  
  @Deprecated
  public static void a(String paramString1, String paramString2)
  {
    QLog.i(paramString1, 1, paramString2);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppCenter
 * JD-Core Version:    0.7.0.1
 */