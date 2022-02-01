package com.tencent.mobileqq.apollo.player.manager;

import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionObserverImpl;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/apollo/player/manager/CMSBornPlayer$CMSActionContext$dressChangeListener$2$1", "Lcom/tencent/mobileqq/apollo/api/handler/impl/ApolloExtensionObserverImpl;", "onApolloDressChange", "", "result", "", "data", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class CMSBornPlayer$CMSActionContext$dressChangeListener$2$1
  extends ApolloExtensionObserverImpl
{
  public void e(boolean paramBoolean, @Nullable Object paramObject)
  {
    super.e(paramBoolean, paramObject);
    QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayer", 1, "onApolloDressChange, result:" + paramBoolean + ", data:" + paramObject + ", cacheUins:" + this.a.this$0.a());
    if ((!paramBoolean) || (paramObject == null)) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = (ArrayList)paramObject;
        if (((ArrayList)localObject).size() != 0)
        {
          paramObject = this.a.this$0.a().getSpriteCreator().a(0);
          if (paramObject != null)
          {
            localObject = ((Iterable)localObject).iterator();
            for (;;)
            {
              if (!((Iterator)localObject).hasNext()) {
                break label225;
              }
              String str = (String)((Iterator)localObject).next();
              if (this.a.this$0.a().contains(str))
              {
                QQAppInterface localQQAppInterface = CMSHelper.a.a();
                if (localQQAppInterface == null) {
                  break;
                }
                if (((IApolloManagerService)localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getCmShowStatus(localQQAppInterface, str) == 1)
                {
                  QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayer", 1, "onApolloDressChange, checkDressRec for " + str);
                  paramObject.a(str, true);
                }
              }
            }
            label225:
            return;
          }
        }
      }
      catch (Exception paramObject) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.manager.CMSBornPlayer.CMSActionContext.dressChangeListener.2.1
 * JD-Core Version:    0.7.0.1
 */