package com.tencent.mobileqq.ark;

import apmp;
import apms;
import apmt;
import apng;
import aqnh;
import aqnt;
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
  public ArkAiDictUpdateMgr$1(apms paramapms) {}
  
  public void run()
  {
    if ((QQAppInterface)apms.a(this.this$0).get() == null) {
      ArkAppCenter.c("ArkApp.Dict.Update", "updateLocalDict, qq app is NULL, return");
    }
    for (;;)
    {
      return;
      aqnh localaqnh1 = apms.a();
      Object localObject2 = apms.a(localaqnh1);
      aqnh localaqnh3 = apms.b();
      Object localObject1 = new ArrayList();
      Object localObject3 = ((Map)localObject2).keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        String str = (String)((Iterator)localObject3).next();
        aqnt localaqnt = (aqnt)((Map)localObject2).get(str);
        if (!apms.a(this.this$0, localaqnt))
        {
          ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateLocalDict, local dict is not integrity, update, id=%s", new Object[] { str }));
          ((ArrayList)localObject1).add(localaqnt);
        }
        else
        {
          ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateLocalDict, local dict is integrity, ignore, id=%s", new Object[] { str }));
        }
      }
      if (((ArrayList)localObject1).isEmpty())
      {
        apms.a(localaqnh1);
        apmp.b((AppInterface)apms.a(this.this$0).get());
        return;
      }
      try
      {
        if (apms.a(this.this$0))
        {
          ArkAppCenter.c("ArkApp.Dict.Update", "updateLocalDict, update in progress, wait current task complete");
          apms.a(this.this$0, true);
          return;
        }
      }
      finally {}
      apms.b(this.this$0, true);
      localObject2 = new apng(null);
      ((apng)localObject2).jdField_a_of_type_Boolean = true;
      ((apng)localObject2).jdField_a_of_type_Int = ((ArrayList)localObject1).size();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (aqnt)((Iterator)localObject1).next();
        apms.a(this.this$0, localaqnh3, (aqnt)localObject3, new apmt(this, (aqnt)localObject3, (apng)localObject2, localaqnh2));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiDictUpdateMgr.1
 * JD-Core Version:    0.7.0.1
 */