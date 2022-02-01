package com.tencent.falco.base.libapi;

import android.content.Context;

public abstract interface ServiceBaseInterface
{
  public abstract void clearEventOutput();
  
  public abstract void onCreate(Context paramContext);
  
  public abstract void onDestroy();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.base.libapi.ServiceBaseInterface
 * JD-Core Version:    0.7.0.1
 */