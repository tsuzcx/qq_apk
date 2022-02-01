package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.vas.config.business.qvip.QVIPPrettyTroopProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipPrettyTroopConfig;

public class TroopManager$LiangGroupHelper
{
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", QVIPPrettyTroopProcessor.e().a(paramString2, paramString1));
    localIntent.putExtra("hide_operation_bar", true);
    paramContext.startActivity(localIntent);
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt != 0;
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public static boolean c(int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopManager.LiangGroupHelper
 * JD-Core Version:    0.7.0.1
 */