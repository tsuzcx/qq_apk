package com.tencent.mobileqq.ark;

import alrj;
import alrm;
import alrn;
import alsa;
import amrd;
import amrp;
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
  public ArkAiDictUpdateMgr$1(alrm paramalrm) {}
  
  public void run()
  {
    if ((QQAppInterface)alrm.a(this.this$0).get() == null) {
      ArkAppCenter.c("ArkApp.Dict.Update", "updateLocalDict, qq app is NULL, return");
    }
    for (;;)
    {
      return;
      amrd localamrd1 = alrm.a();
      Object localObject2 = alrm.a(localamrd1);
      amrd localamrd3 = alrm.b();
      Object localObject1 = new ArrayList();
      Object localObject3 = ((Map)localObject2).keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        String str = (String)((Iterator)localObject3).next();
        amrp localamrp = (amrp)((Map)localObject2).get(str);
        if (!alrm.a(this.this$0, localamrp))
        {
          ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateLocalDict, local dict is not integrity, update, id=%s", new Object[] { str }));
          ((ArrayList)localObject1).add(localamrp);
        }
        else
        {
          ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateLocalDict, local dict is integrity, ignore, id=%s", new Object[] { str }));
        }
      }
      if (((ArrayList)localObject1).isEmpty())
      {
        alrm.a(localamrd1);
        alrj.b((AppInterface)alrm.a(this.this$0).get());
        return;
      }
      try
      {
        if (alrm.a(this.this$0))
        {
          ArkAppCenter.c("ArkApp.Dict.Update", "updateLocalDict, update in progress, wait current task complete");
          alrm.a(this.this$0, true);
          return;
        }
      }
      finally {}
      alrm.b(this.this$0, true);
      localObject2 = new alsa(null);
      ((alsa)localObject2).jdField_a_of_type_Boolean = true;
      ((alsa)localObject2).jdField_a_of_type_Int = ((ArrayList)localObject1).size();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (amrp)((Iterator)localObject1).next();
        alrm.a(this.this$0, localamrd3, (amrp)localObject3, new alrn(this, (amrp)localObject3, (alsa)localObject2, localamrd2));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiDictUpdateMgr.1
 * JD-Core Version:    0.7.0.1
 */