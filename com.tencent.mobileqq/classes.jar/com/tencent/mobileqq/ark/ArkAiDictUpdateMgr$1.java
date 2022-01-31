package com.tencent.mobileqq.ark;

import ania;
import anid;
import anie;
import anir;
import aoia;
import aoim;
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
  public ArkAiDictUpdateMgr$1(anid paramanid) {}
  
  public void run()
  {
    if ((QQAppInterface)anid.a(this.this$0).get() == null) {
      ArkAppCenter.c("ArkApp.Dict.Update", "updateLocalDict, qq app is NULL, return");
    }
    for (;;)
    {
      return;
      aoia localaoia1 = anid.a();
      Object localObject2 = anid.a(localaoia1);
      aoia localaoia3 = anid.b();
      Object localObject1 = new ArrayList();
      Object localObject3 = ((Map)localObject2).keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        String str = (String)((Iterator)localObject3).next();
        aoim localaoim = (aoim)((Map)localObject2).get(str);
        if (!anid.a(this.this$0, localaoim))
        {
          ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateLocalDict, local dict is not integrity, update, id=%s", new Object[] { str }));
          ((ArrayList)localObject1).add(localaoim);
        }
        else
        {
          ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateLocalDict, local dict is integrity, ignore, id=%s", new Object[] { str }));
        }
      }
      if (((ArrayList)localObject1).isEmpty())
      {
        anid.a(localaoia1);
        ania.b((AppInterface)anid.a(this.this$0).get());
        return;
      }
      try
      {
        if (anid.a(this.this$0))
        {
          ArkAppCenter.c("ArkApp.Dict.Update", "updateLocalDict, update in progress, wait current task complete");
          anid.a(this.this$0, true);
          return;
        }
      }
      finally {}
      anid.b(this.this$0, true);
      localObject2 = new anir(null);
      ((anir)localObject2).jdField_a_of_type_Boolean = true;
      ((anir)localObject2).jdField_a_of_type_Int = ((ArrayList)localObject1).size();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (aoim)((Iterator)localObject1).next();
        anid.a(this.this$0, localaoia3, (aoim)localObject3, new anie(this, (aoim)localObject3, (anir)localObject2, localaoia2));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiDictUpdateMgr.1
 * JD-Core Version:    0.7.0.1
 */