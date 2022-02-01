package com.tencent.ark.open;

import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.open.delegate.ArkDelegateManager;
import com.tencent.ark.open.delegate.IArkDelegateSetup;
import java.util.ArrayList;
import java.util.Iterator;

class ArkAppMgr$14
  implements ArkAppMgr.IEnumInstalledAppCallback
{
  ArkAppMgr$14(ArkAppMgr paramArkAppMgr) {}
  
  public void onEnumInstalledApp(String[] arg1)
  {
    Object localObject2 = new ArrayList();
    if (??? != null)
    {
      int j = ???.length;
      int i = 0;
      while (i < j)
      {
        ((ArrayList)localObject2).add(???[i]);
        i += 1;
      }
    }
    String str;
    synchronized (ArkAppMgr.access$1900(this.this$0))
    {
      Iterator localIterator = ArkAppMgr.access$1900(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (!((ArrayList)localObject2).contains(str)) {
          ((ArrayList)localObject2).add(str);
        }
      }
    }
    ArkAppMgr.access$1900(this.this$0).clear();
    ArrayList localArrayList = new ArrayList();
    ??? = ArkDelegateManager.getInstance().getSetupDelegate();
    if (??? != null) {}
    for (??? = ???.onGetPredownloadApp();; ??? = null)
    {
      if (??? != null)
      {
        ArkAppMgr.access$100().logI("ArkApp.ArkAppMgr", String.format("updateInstalledAppsReal, msg ai app, count=%d", new Object[] { Integer.valueOf(???.size()) }));
        ??? = ???.iterator();
        while (???.hasNext())
        {
          str = (String)???.next();
          if ((this.this$0.getAppPathByNameFromLocal(str, "", "0.0.0.0", false) == null) && (!localArrayList.contains(str))) {
            localArrayList.add(str);
          }
        }
      }
      if (((ArrayList)localObject2).isEmpty()) {
        ArkAppMgr.access$100().logI("ArkApp.ArkAppMgr", "updateInstalledAppsReal, checkAppList is empty.");
      }
      while (localArrayList.isEmpty())
      {
        ArkAppMgr.access$100().logI("ArkApp.ArkAppMgr", "updateInstalledAppsReal, no app need update.");
        return;
        ??? = ((ArrayList)localObject2).iterator();
        while (???.hasNext())
        {
          localObject2 = (String)???.next();
          if (((ArkAppMgr.access$2000(this.this$0, (String)localObject2)) || (ArkAppMgr.access$1800())) && (!localArrayList.contains(localObject2))) {
            localArrayList.add(localObject2);
          }
        }
      }
      ??? = new StringBuffer();
      localObject2 = localArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ???.append((String)((Iterator)localObject2).next());
        ???.append(';');
      }
      ArkAppMgr.access$100().logI("ArkApp.ArkAppMgr", String.format("ArkSafe.updateInstalledAppsReal, start to update, last-time=%d, app-count=%d, app-name-list=%s.", new Object[] { Long.valueOf(ArkAppMgr.access$2100(this.this$0)), Integer.valueOf(localArrayList.size()), ???.toString() }));
      ??? = new ArkAppMgr.UpdateLocalAppTask(null);
      ???.appNameList = localArrayList;
      ArkAppMgr.access$2300(this.this$0, ???);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppMgr.14
 * JD-Core Version:    0.7.0.1
 */