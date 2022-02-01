package com.tencent.mobileqq.apollo.player.manager;

import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionObserver;
import com.tencent.mobileqq.apollo.player.CMSHelper;
import com.tencent.mobileqq.apollo.script.SpriteAioScript;
import com.tencent.mobileqq.apollo.script.SpriteScriptCreator;
import com.tencent.mobileqq.apollo.script.SpriteScriptManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/apollo/player/manager/CMSBornPlayer$CMSActionContext$dressChangeListener$2$1", "Lcom/tencent/mobileqq/apollo/handler/ApolloExtensionObserver;", "onApolloDressChange", "", "result", "", "data", "", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CMSBornPlayer$CMSActionContext$dressChangeListener$2$1
  extends ApolloExtensionObserver
{
  protected void b(boolean paramBoolean, @Nullable Object paramObject)
  {
    super.b(paramBoolean, paramObject);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onApolloDressChange, result:");
    ((StringBuilder)localObject1).append(paramBoolean);
    ((StringBuilder)localObject1).append(", data:");
    ((StringBuilder)localObject1).append(paramObject);
    ((StringBuilder)localObject1).append(", cacheUins:");
    ((StringBuilder)localObject1).append(this.a.this$0.a());
    QLog.w("[cmshow][scripted][CMSPlayer]CMSBornPlayer", 1, ((StringBuilder)localObject1).toString());
    if (paramBoolean) {
      if (paramObject == null) {
        return;
      }
    }
    try
    {
      localObject1 = (ArrayList)paramObject;
      if (((ArrayList)localObject1).size() == 0) {
        return;
      }
      paramObject = this.a.this$0.a().getSpriteCreator().b(0);
      if (paramObject != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          String str = (String)((Iterator)localObject1).next();
          if (this.a.this$0.a().contains(str))
          {
            Object localObject2 = CMSHelper.a.a();
            if (localObject2 == null) {
              break;
            }
            if (((IApolloManagerService)((QQAppInterface)localObject2).getRuntimeService(IApolloManagerService.class, "all")).getCmShowStatus(str) == 1)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("onApolloDressChange, checkDressRec for ");
              ((StringBuilder)localObject2).append(str);
              QLog.w("[cmshow][scripted][CMSPlayer]CMSBornPlayer", 1, ((StringBuilder)localObject2).toString());
              paramObject.a(str, true);
            }
          }
        }
      }
      return;
    }
    catch (Exception paramObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.manager.CMSBornPlayer.CMSActionContext.dressChangeListener.2.1
 * JD-Core Version:    0.7.0.1
 */