package com.tencent.mobileqq.ark.dict;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class ArkAiDictUpdateMgr$1
  implements Runnable
{
  ArkAiDictUpdateMgr$1(ArkAiDictUpdateMgr paramArkAiDictUpdateMgr) {}
  
  public void run()
  {
    DictConfig localDictConfig1 = ArkAiDictUpdateMgr.a();
    Object localObject3 = ArkAiDictUpdateMgr.a(localDictConfig1);
    DictConfig localDictConfig2 = ArkAiDictUpdateMgr.b();
    Object localObject2 = new ArrayList();
    Object localObject4 = ((Map)localObject3).keySet().iterator();
    while (((Iterator)localObject4).hasNext())
    {
      String str = (String)((Iterator)localObject4).next();
      DictConfig localDictConfig3 = (DictConfig)((Map)localObject3).get(str);
      if (!ArkAiDictUpdateMgr.a(this.this$0, localDictConfig3))
      {
        QLog.i("ArkDict.Update", 1, String.format("updateLocalDict, local dict is not integrity, update, id=%s", new Object[] { str }));
        ((ArrayList)localObject2).add(localDictConfig3);
      }
      else
      {
        QLog.i("ArkDict.Update", 1, String.format("updateLocalDict, local dict is integrity, ignore, id=%s", new Object[] { str }));
      }
    }
    if (((ArrayList)localObject2).isEmpty())
    {
      ArkAiDictUpdateMgr.a(localDictConfig1);
      ArkAiDictMgr.b(ArkAiDictUpdateMgr.a(this.this$0));
      return;
    }
    try
    {
      if (ArkAiDictUpdateMgr.a(this.this$0))
      {
        QLog.i("ArkDict.Update", 1, "updateLocalDict, update in progress, wait current task complete");
        ArkAiDictUpdateMgr.a(this.this$0, true);
        return;
      }
      ArkAiDictUpdateMgr.b(this.this$0, true);
      localObject3 = new ArkAiDictUpdateMgr.UpdateState(null);
      ((ArkAiDictUpdateMgr.UpdateState)localObject3).jdField_a_of_type_Boolean = true;
      ((ArkAiDictUpdateMgr.UpdateState)localObject3).jdField_a_of_type_Int = ((ArrayList)localObject2).size();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (DictConfig)((Iterator)localObject2).next();
        ArkAiDictUpdateMgr.a(this.this$0, localDictConfig2, (DictConfig)localObject4, new ArkAiDictUpdateMgr.1.1(this, (DictConfig)localObject4, (ArkAiDictUpdateMgr.UpdateState)localObject3, localDictConfig1));
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.dict.ArkAiDictUpdateMgr.1
 * JD-Core Version:    0.7.0.1
 */