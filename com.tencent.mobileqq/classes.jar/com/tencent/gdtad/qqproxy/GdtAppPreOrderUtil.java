package com.tencent.gdtad.qqproxy;

import com.tencent.ad.tangram.preorder.AdAppPreOrderManager;

public class GdtAppPreOrderUtil
{
  public static void a()
  {
    AdAppPreOrderManager.INSTANCE.onMessagesSynced();
  }
  
  public static boolean a()
  {
    return AdAppPreOrderManager.INSTANCE.isAppPreOrderDownloadLaunched();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.qqproxy.GdtAppPreOrderUtil
 * JD-Core Version:    0.7.0.1
 */