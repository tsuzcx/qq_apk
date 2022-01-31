package com.tencent.mobileqq.ark;

import alri;
import alrl;
import alrm;
import alrz;
import amrc;
import amro;
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
  public ArkAiDictUpdateMgr$1(alrl paramalrl) {}
  
  public void run()
  {
    if ((QQAppInterface)alrl.a(this.this$0).get() == null) {
      ArkAppCenter.c("ArkApp.Dict.Update", "updateLocalDict, qq app is NULL, return");
    }
    for (;;)
    {
      return;
      amrc localamrc1 = alrl.a();
      Object localObject2 = alrl.a(localamrc1);
      amrc localamrc3 = alrl.b();
      Object localObject1 = new ArrayList();
      Object localObject3 = ((Map)localObject2).keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        String str = (String)((Iterator)localObject3).next();
        amro localamro = (amro)((Map)localObject2).get(str);
        if (!alrl.a(this.this$0, localamro))
        {
          ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateLocalDict, local dict is not integrity, update, id=%s", new Object[] { str }));
          ((ArrayList)localObject1).add(localamro);
        }
        else
        {
          ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateLocalDict, local dict is integrity, ignore, id=%s", new Object[] { str }));
        }
      }
      if (((ArrayList)localObject1).isEmpty())
      {
        alrl.a(localamrc1);
        alri.b((AppInterface)alrl.a(this.this$0).get());
        return;
      }
      try
      {
        if (alrl.a(this.this$0))
        {
          ArkAppCenter.c("ArkApp.Dict.Update", "updateLocalDict, update in progress, wait current task complete");
          alrl.a(this.this$0, true);
          return;
        }
      }
      finally {}
      alrl.b(this.this$0, true);
      localObject2 = new alrz(null);
      ((alrz)localObject2).jdField_a_of_type_Boolean = true;
      ((alrz)localObject2).jdField_a_of_type_Int = ((ArrayList)localObject1).size();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (amro)((Iterator)localObject1).next();
        alrl.a(this.this$0, localamrc3, (amro)localObject3, new alrm(this, (amro)localObject3, (alrz)localObject2, localamrc2));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiDictUpdateMgr.1
 * JD-Core Version:    0.7.0.1
 */