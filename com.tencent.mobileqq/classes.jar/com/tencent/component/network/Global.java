package com.tencent.component.network;

import android.content.Context;
import com.tencent.component.network.module.common.NetworkState;

public class Global
{
  private static Context a;
  
  public static Context a()
  {
    return a;
  }
  
  public static void a(Context paramContext)
  {
    a = paramContext;
    NetworkManager.init(a());
    NetworkState.g().setContext(a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.Global
 * JD-Core Version:    0.7.0.1
 */