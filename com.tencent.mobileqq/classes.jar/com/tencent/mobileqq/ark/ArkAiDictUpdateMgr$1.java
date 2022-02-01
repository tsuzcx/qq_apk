package com.tencent.mobileqq.ark;

import aots;
import aotv;
import aotw;
import aouj;
import apwc;
import apwo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ArkAiDictUpdateMgr$1
  implements Runnable
{
  public ArkAiDictUpdateMgr$1(aotv paramaotv) {}
  
  public void run()
  {
    if ((QQAppInterface)aotv.a(this.this$0).get() == null) {
      ArkAppCenter.c("ArkApp.Dict.Update", "updateLocalDict, qq app is NULL, return");
    }
    for (;;)
    {
      return;
      apwc localapwc1 = aotv.a();
      Object localObject2 = aotv.a(localapwc1);
      apwc localapwc3 = aotv.b();
      Object localObject1 = new ArrayList();
      Object localObject3 = ((Map)localObject2).keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        String str = (String)((Iterator)localObject3).next();
        apwo localapwo = (apwo)((Map)localObject2).get(str);
        if (!aotv.a(this.this$0, localapwo))
        {
          ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateLocalDict, local dict is not integrity, update, id=%s", new Object[] { str }));
          ((ArrayList)localObject1).add(localapwo);
        }
        else
        {
          ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateLocalDict, local dict is integrity, ignore, id=%s", new Object[] { str }));
        }
      }
      if (((ArrayList)localObject1).isEmpty())
      {
        aotv.a(localapwc1);
        aots.b((AppInterface)aotv.a(this.this$0).get());
        return;
      }
      try
      {
        if (aotv.a(this.this$0))
        {
          ArkAppCenter.c("ArkApp.Dict.Update", "updateLocalDict, update in progress, wait current task complete");
          aotv.a(this.this$0, true);
          return;
        }
      }
      finally {}
      aotv.b(this.this$0, true);
      localObject2 = new aouj(null);
      ((aouj)localObject2).jdField_a_of_type_Boolean = true;
      ((aouj)localObject2).jdField_a_of_type_Int = ((ArrayList)localObject1).size();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (apwo)((Iterator)localObject1).next();
        aotv.a(this.this$0, localapwc3, (apwo)localObject3, new aotw(this, (apwo)localObject3, (aouj)localObject2, localapwc2));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiDictUpdateMgr.1
 * JD-Core Version:    0.7.0.1
 */