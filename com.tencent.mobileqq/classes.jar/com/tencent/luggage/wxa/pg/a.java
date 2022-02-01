package com.tencent.luggage.wxa.pg;

import android.os.Bundle;
import com.tencent.luggage.wxa.ba.b;

public abstract interface a
  extends b
{
  public abstract void getLocation(String paramString, a.b paramb, Bundle paramBundle);
  
  public abstract boolean registerLocation(String paramString, a.b paramb, Bundle paramBundle);
  
  public abstract boolean unregisterLocation(String paramString, a.b paramb, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pg.a
 * JD-Core Version:    0.7.0.1
 */