package com.tencent.gdtad.net;

import android.content.Context;
import com.tencent.ad.tangram.net.AdNet;
import com.tencent.mobileqq.utils.NetworkUtil;

public class GdtNetUtil
{
  public static int a(Context paramContext)
  {
    return AdNet.getType(paramContext);
  }
  
  public static boolean a(Context paramContext)
  {
    return NetworkUtil.d(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.net.GdtNetUtil
 * JD-Core Version:    0.7.0.1
 */