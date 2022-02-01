package com.tencent.av.utils;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.AboutActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.util.Map;

public class GVideoUpdateUtil
{
  static Map<String, GVideoUpdateUtil.Record> a;
  
  static void a(Context paramContext)
  {
    paramContext.startActivity(new Intent(paramContext, AboutActivity.class));
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, GVideoUpdateUtil.OnGVideoUpdateListener paramOnGVideoUpdateListener)
  {
    paramOnGVideoUpdateListener.a(paramContext, paramString);
  }
  
  static void a(Context paramContext, String paramString, GVideoUpdateUtil.OnGVideoUpdateListener paramOnGVideoUpdateListener)
  {
    paramOnGVideoUpdateListener.a(paramContext, paramString);
  }
  
  static void a(Context paramContext, String paramString1, String paramString2, String paramString3, GVideoUpdateUtil.OnGVideoUpdateListener paramOnGVideoUpdateListener)
  {
    DialogUtil.a(paramContext, 230, paramString1, paramString2, 2131893370, 2131893372, new GVideoUpdateUtil.2(paramContext), new GVideoUpdateUtil.3(paramOnGVideoUpdateListener, paramContext, paramString3)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.GVideoUpdateUtil
 * JD-Core Version:    0.7.0.1
 */