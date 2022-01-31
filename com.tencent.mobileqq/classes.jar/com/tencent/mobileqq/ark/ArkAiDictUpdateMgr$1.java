package com.tencent.mobileqq.ark;

import anmj;
import anmm;
import anmn;
import anna;
import aomj;
import aomv;
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
  public ArkAiDictUpdateMgr$1(anmm paramanmm) {}
  
  public void run()
  {
    if ((QQAppInterface)anmm.a(this.this$0).get() == null) {
      ArkAppCenter.c("ArkApp.Dict.Update", "updateLocalDict, qq app is NULL, return");
    }
    for (;;)
    {
      return;
      aomj localaomj1 = anmm.a();
      Object localObject2 = anmm.a(localaomj1);
      aomj localaomj3 = anmm.b();
      Object localObject1 = new ArrayList();
      Object localObject3 = ((Map)localObject2).keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        String str = (String)((Iterator)localObject3).next();
        aomv localaomv = (aomv)((Map)localObject2).get(str);
        if (!anmm.a(this.this$0, localaomv))
        {
          ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateLocalDict, local dict is not integrity, update, id=%s", new Object[] { str }));
          ((ArrayList)localObject1).add(localaomv);
        }
        else
        {
          ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateLocalDict, local dict is integrity, ignore, id=%s", new Object[] { str }));
        }
      }
      if (((ArrayList)localObject1).isEmpty())
      {
        anmm.a(localaomj1);
        anmj.b((AppInterface)anmm.a(this.this$0).get());
        return;
      }
      try
      {
        if (anmm.a(this.this$0))
        {
          ArkAppCenter.c("ArkApp.Dict.Update", "updateLocalDict, update in progress, wait current task complete");
          anmm.a(this.this$0, true);
          return;
        }
      }
      finally {}
      anmm.b(this.this$0, true);
      localObject2 = new anna(null);
      ((anna)localObject2).jdField_a_of_type_Boolean = true;
      ((anna)localObject2).jdField_a_of_type_Int = ((ArrayList)localObject1).size();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (aomv)((Iterator)localObject1).next();
        anmm.a(this.this$0, localaomj3, (aomv)localObject3, new anmn(this, (aomv)localObject3, (anna)localObject2, localaomj2));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiDictUpdateMgr.1
 * JD-Core Version:    0.7.0.1
 */