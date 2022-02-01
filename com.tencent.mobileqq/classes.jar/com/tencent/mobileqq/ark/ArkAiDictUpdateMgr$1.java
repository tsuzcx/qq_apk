package com.tencent.mobileqq.ark;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.ArkManageConfig.AIDictConfig;
import com.tencent.mobileqq.config.business.ArkManageConfig.DictConfig;
import java.lang.ref.WeakReference;
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
    if ((QQAppInterface)ArkAiDictUpdateMgr.a(this.this$0).get() == null) {
      ArkAppCenter.c("ArkApp.Dict.Update", "updateLocalDict, qq app is NULL, return");
    }
    for (;;)
    {
      return;
      ArkManageConfig.AIDictConfig localAIDictConfig1 = ArkAiDictUpdateMgr.a();
      Object localObject2 = ArkAiDictUpdateMgr.a(localAIDictConfig1);
      ArkManageConfig.AIDictConfig localAIDictConfig3 = ArkAiDictUpdateMgr.b();
      Object localObject1 = new ArrayList();
      Object localObject3 = ((Map)localObject2).keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        String str = (String)((Iterator)localObject3).next();
        ArkManageConfig.DictConfig localDictConfig = (ArkManageConfig.DictConfig)((Map)localObject2).get(str);
        if (!ArkAiDictUpdateMgr.a(this.this$0, localDictConfig))
        {
          ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateLocalDict, local dict is not integrity, update, id=%s", new Object[] { str }));
          ((ArrayList)localObject1).add(localDictConfig);
        }
        else
        {
          ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateLocalDict, local dict is integrity, ignore, id=%s", new Object[] { str }));
        }
      }
      if (((ArrayList)localObject1).isEmpty())
      {
        ArkAiDictUpdateMgr.a(localAIDictConfig1);
        ArkAiDictMgr.b((AppInterface)ArkAiDictUpdateMgr.a(this.this$0).get());
        return;
      }
      try
      {
        if (ArkAiDictUpdateMgr.a(this.this$0))
        {
          ArkAppCenter.c("ArkApp.Dict.Update", "updateLocalDict, update in progress, wait current task complete");
          ArkAiDictUpdateMgr.a(this.this$0, true);
          return;
        }
      }
      finally {}
      ArkAiDictUpdateMgr.b(this.this$0, true);
      localObject2 = new ArkAiDictUpdateMgr.UpdateState(null);
      ((ArkAiDictUpdateMgr.UpdateState)localObject2).jdField_a_of_type_Boolean = true;
      ((ArkAiDictUpdateMgr.UpdateState)localObject2).jdField_a_of_type_Int = ((ArrayList)localObject1).size();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (ArkManageConfig.DictConfig)((Iterator)localObject1).next();
        ArkAiDictUpdateMgr.a(this.this$0, localAIDictConfig3, (ArkManageConfig.DictConfig)localObject3, new ArkAiDictUpdateMgr.1.1(this, (ArkManageConfig.DictConfig)localObject3, (ArkAiDictUpdateMgr.UpdateState)localObject2, localAIDictConfig2));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiDictUpdateMgr.1
 * JD-Core Version:    0.7.0.1
 */