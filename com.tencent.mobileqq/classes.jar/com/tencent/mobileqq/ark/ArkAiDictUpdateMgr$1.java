package com.tencent.mobileqq.ark;

import apww;
import apwz;
import apxa;
import apxn;
import aqzf;
import aqzr;
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
  public ArkAiDictUpdateMgr$1(apwz paramapwz) {}
  
  public void run()
  {
    if ((QQAppInterface)apwz.a(this.this$0).get() == null) {
      ArkAppCenter.c("ArkApp.Dict.Update", "updateLocalDict, qq app is NULL, return");
    }
    for (;;)
    {
      return;
      aqzf localaqzf1 = apwz.a();
      Object localObject2 = apwz.a(localaqzf1);
      aqzf localaqzf3 = apwz.b();
      Object localObject1 = new ArrayList();
      Object localObject3 = ((Map)localObject2).keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        String str = (String)((Iterator)localObject3).next();
        aqzr localaqzr = (aqzr)((Map)localObject2).get(str);
        if (!apwz.a(this.this$0, localaqzr))
        {
          ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateLocalDict, local dict is not integrity, update, id=%s", new Object[] { str }));
          ((ArrayList)localObject1).add(localaqzr);
        }
        else
        {
          ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateLocalDict, local dict is integrity, ignore, id=%s", new Object[] { str }));
        }
      }
      if (((ArrayList)localObject1).isEmpty())
      {
        apwz.a(localaqzf1);
        apww.b((AppInterface)apwz.a(this.this$0).get());
        return;
      }
      try
      {
        if (apwz.a(this.this$0))
        {
          ArkAppCenter.c("ArkApp.Dict.Update", "updateLocalDict, update in progress, wait current task complete");
          apwz.a(this.this$0, true);
          return;
        }
      }
      finally {}
      apwz.b(this.this$0, true);
      localObject2 = new apxn(null);
      ((apxn)localObject2).jdField_a_of_type_Boolean = true;
      ((apxn)localObject2).jdField_a_of_type_Int = ((ArrayList)localObject1).size();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (aqzr)((Iterator)localObject1).next();
        apwz.a(this.this$0, localaqzf3, (aqzr)localObject3, new apxa(this, (aqzr)localObject3, (apxn)localObject2, localaqzf2));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiDictUpdateMgr.1
 * JD-Core Version:    0.7.0.1
 */