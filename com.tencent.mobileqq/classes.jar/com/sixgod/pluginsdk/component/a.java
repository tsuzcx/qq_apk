package com.sixgod.pluginsdk.component;

import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
{
  List a = new ArrayList();
  protected Context b;
  protected com.sixgod.pluginsdk.apkmanager.a c;
  
  public a(Context paramContext, com.sixgod.pluginsdk.apkmanager.a parama)
  {
    this.b = paramContext;
    this.c = parama;
  }
  
  public final void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      try
      {
        this.b.unregisterReceiver(localb);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public final void a(ActivityInfo paramActivityInfo, List paramList)
  {
    paramActivityInfo = new b(this, paramActivityInfo);
    this.a.add(paramActivityInfo);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      IntentFilter localIntentFilter = (IntentFilter)paramList.next();
      this.b.registerReceiver(paramActivityInfo, localIntentFilter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.sixgod.pluginsdk.component.a
 * JD-Core Version:    0.7.0.1
 */