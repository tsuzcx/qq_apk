package com.tencent.beacon.module;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

public abstract interface BeaconModule
{
  public static final Map<ModuleName, BeaconModule> a = new HashMap();
  
  public abstract void a(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.module.BeaconModule
 * JD-Core Version:    0.7.0.1
 */