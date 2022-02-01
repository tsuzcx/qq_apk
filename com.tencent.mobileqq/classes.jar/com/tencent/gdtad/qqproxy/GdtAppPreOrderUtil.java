package com.tencent.gdtad.qqproxy;

import com.tencent.ad.tangram.preorder.AdAppPreOrderManager;

public class GdtAppPreOrderUtil
{
  public static boolean a()
  {
    return AdAppPreOrderManager.INSTANCE.isAppPreOrderDownloadLaunched();
  }
  
  public static void b()
  {
    AdAppPreOrderManager.INSTANCE.onMessagesSynced();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.qqproxy.GdtAppPreOrderUtil
 * JD-Core Version:    0.7.0.1
 */