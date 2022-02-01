package com.tencent.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class AccountDPCHelper
{
  public static boolean a(Context paramContext, boolean paramBoolean)
  {
    return paramContext.getSharedPreferences("LIGHT_DPC_CFG", 0).getBoolean("IS_USER_EXIT_RECEIVING_MSG", paramBoolean);
  }
  
  public static void b(Context paramContext, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("LIGHT_DPC_CFG", 0).edit();
    paramContext.putBoolean("IS_USER_EXIT_RECEIVING_MSG", paramBoolean);
    paramContext.commit();
  }
  
  public static boolean c(Context paramContext, boolean paramBoolean)
  {
    return paramContext.getSharedPreferences("LIGHT_DPC_CFG", 0).getBoolean("SUPPORT_SYNC_ACCOUNT_LOGINI", paramBoolean);
  }
  
  public static void d(Context paramContext, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("LIGHT_DPC_CFG", 0).edit();
    paramContext.putBoolean("SUPPORT_SYNC_ACCOUNT_LOGINI", paramBoolean);
    paramContext.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.AccountDPCHelper
 * JD-Core Version:    0.7.0.1
 */