package com.tencent.gdtad.ipc;

import acfs;
import acho;
import acik;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.gdtad.aditem.GdtBaseAdItem;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AppInstallerReceiver
  extends BroadcastReceiver
{
  private Map<String, GdtBaseAdItem> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean;
  
  public static AppInstallerReceiver a()
  {
    return acfs.a;
  }
  
  public void a(Context paramContext)
  {
    if ((!this.jdField_a_of_type_Boolean) && (paramContext != null))
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
      localIntentFilter.addDataScheme("package");
      paramContext.registerReceiver(this, localIntentFilter);
      this.jdField_a_of_type_Boolean = true;
      acho.a("GdtAppOpenUtil", "regeist AppInstallerReceiver");
    }
  }
  
  public void a(GdtBaseAdItem paramGdtBaseAdItem)
  {
    if (paramGdtBaseAdItem != null) {
      this.jdField_a_of_type_JavaUtilMap.put(paramGdtBaseAdItem.a, paramGdtBaseAdItem);
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getDataString();
    if ((paramIntent != null) && (paramIntent.startsWith("package:"))) {
      paramIntent = paramIntent.substring("package:".length());
    }
    for (;;)
    {
      acho.a("GdtAppOpenUtil", "package added " + paramIntent);
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramIntent))
      {
        acik.a(paramContext, (GdtBaseAdItem)this.jdField_a_of_type_JavaUtilMap.get(paramIntent));
        this.jdField_a_of_type_JavaUtilMap.remove(paramIntent);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.ipc.AppInstallerReceiver
 * JD-Core Version:    0.7.0.1
 */