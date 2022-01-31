package com.tencent.mobileqq.ark;

import alcv;
import alcy;
import alcz;
import aldm;
import ambf;
import ambr;
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
  public ArkAiDictUpdateMgr$1(alcy paramalcy) {}
  
  public void run()
  {
    if ((QQAppInterface)alcy.a(this.this$0).get() == null) {
      ArkAppCenter.c("ArkApp.Dict.Update", "updateLocalDict, qq app is NULL, return");
    }
    for (;;)
    {
      return;
      ambf localambf1 = alcy.a();
      Object localObject2 = alcy.a(localambf1);
      ambf localambf3 = alcy.b();
      Object localObject1 = new ArrayList();
      Object localObject3 = ((Map)localObject2).keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        String str = (String)((Iterator)localObject3).next();
        ambr localambr = (ambr)((Map)localObject2).get(str);
        if (!alcy.a(this.this$0, localambr))
        {
          ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateLocalDict, local dict is not integrity, update, id=%s", new Object[] { str }));
          ((ArrayList)localObject1).add(localambr);
        }
        else
        {
          ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateLocalDict, local dict is integrity, ignore, id=%s", new Object[] { str }));
        }
      }
      if (((ArrayList)localObject1).isEmpty())
      {
        alcy.a(localambf1);
        alcv.b((AppInterface)alcy.a(this.this$0).get());
        return;
      }
      try
      {
        if (alcy.a(this.this$0))
        {
          ArkAppCenter.c("ArkApp.Dict.Update", "updateLocalDict, update in progress, wait current task complete");
          alcy.a(this.this$0, true);
          return;
        }
      }
      finally {}
      alcy.b(this.this$0, true);
      localObject2 = new aldm(null);
      ((aldm)localObject2).jdField_a_of_type_Boolean = true;
      ((aldm)localObject2).jdField_a_of_type_Int = ((ArrayList)localObject1).size();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (ambr)((Iterator)localObject1).next();
        alcy.a(this.this$0, localambf3, (ambr)localObject3, new alcz(this, (ambr)localObject3, (aldm)localObject2, localambf2));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiDictUpdateMgr.1
 * JD-Core Version:    0.7.0.1
 */