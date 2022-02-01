package com.tencent.mobileqq.ark;

import aqaf;
import aqai;
import aqaj;
import aqaw;
import arcm;
import arcy;
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
  public ArkAiDictUpdateMgr$1(aqai paramaqai) {}
  
  public void run()
  {
    if ((QQAppInterface)aqai.a(this.this$0).get() == null) {
      ArkAppCenter.c("ArkApp.Dict.Update", "updateLocalDict, qq app is NULL, return");
    }
    for (;;)
    {
      return;
      arcm localarcm1 = aqai.a();
      Object localObject2 = aqai.a(localarcm1);
      arcm localarcm3 = aqai.b();
      Object localObject1 = new ArrayList();
      Object localObject3 = ((Map)localObject2).keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        String str = (String)((Iterator)localObject3).next();
        arcy localarcy = (arcy)((Map)localObject2).get(str);
        if (!aqai.a(this.this$0, localarcy))
        {
          ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateLocalDict, local dict is not integrity, update, id=%s", new Object[] { str }));
          ((ArrayList)localObject1).add(localarcy);
        }
        else
        {
          ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateLocalDict, local dict is integrity, ignore, id=%s", new Object[] { str }));
        }
      }
      if (((ArrayList)localObject1).isEmpty())
      {
        aqai.a(localarcm1);
        aqaf.b((AppInterface)aqai.a(this.this$0).get());
        return;
      }
      try
      {
        if (aqai.a(this.this$0))
        {
          ArkAppCenter.c("ArkApp.Dict.Update", "updateLocalDict, update in progress, wait current task complete");
          aqai.a(this.this$0, true);
          return;
        }
      }
      finally {}
      aqai.b(this.this$0, true);
      localObject2 = new aqaw(null);
      ((aqaw)localObject2).jdField_a_of_type_Boolean = true;
      ((aqaw)localObject2).jdField_a_of_type_Int = ((ArrayList)localObject1).size();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (arcy)((Iterator)localObject1).next();
        aqai.a(this.this$0, localarcm3, (arcy)localObject3, new aqaj(this, (arcy)localObject3, (aqaw)localObject2, localarcm2));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiDictUpdateMgr.1
 * JD-Core Version:    0.7.0.1
 */