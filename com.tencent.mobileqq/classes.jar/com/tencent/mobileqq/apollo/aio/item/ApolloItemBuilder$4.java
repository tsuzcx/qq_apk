package com.tencent.mobileqq.apollo.aio.item;

import android.content.Context;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloFavActionData;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.statistics.product.ApolloAioBubbleReportUtil;
import com.tencent.mobileqq.apollo.view.ApolloMainInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cmshow.engine.resource.ApolloResManagerFacade;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

final class ApolloItemBuilder$4
  implements Runnable
{
  ApolloItemBuilder$4(QQAppInterface paramQQAppInterface, Context paramContext, ApolloFavActionData paramApolloFavActionData, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    Object localObject1 = this.a;
    if (localObject1 == null) {
      return;
    }
    localObject1 = (IApolloDaoManagerService)((QQAppInterface)localObject1).getRuntimeService(IApolloDaoManagerService.class, "all");
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = ((IApolloDaoManagerService)localObject1).getFavPackageActionList();
    if ((localObject2 != null) && (((List)localObject2).size() >= 143))
    {
      ApolloItemBuilder.a(this.b.getString(2131886670), 1, this.b);
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloItemBuilder", 2, "fav number is 144");
      }
      return;
    }
    if (ApolloActionData.isAction3DModel(this.c.actionId))
    {
      ApolloItemBuilder.a(this.b.getString(2131886677), 1, this.b);
      return;
    }
    if (((IApolloDaoManagerService)localObject1).findActionById(this.c.actionId) == null)
    {
      ApolloItemBuilder.a(this.b.getString(2131886673), 1, this.b);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("cant find the add aciton id=");
        ((StringBuilder)localObject1).append(this.c.actionId);
        QLog.d("[cmshow]ApolloItemBuilder", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    localObject2 = ((IApolloDaoManagerService)localObject1).getFavPackageActionList();
    int j = 0;
    int i = j;
    if (localObject2 != null)
    {
      i = j;
      if (((List)localObject2).size() > 0)
      {
        localObject2 = ((List)localObject2).iterator();
        do
        {
          i = j;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject3 = (ApolloFavActionData)((Iterator)localObject2).next();
        } while (this.c.actionId != ((ApolloFavActionData)localObject3).actionId);
        i = 1;
      }
    }
    if (i != 0)
    {
      ApolloItemBuilder.a(this.b.getString(2131886669), 1, this.b);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("the add aciton is exist id=");
        ((StringBuilder)localObject1).append(this.c.actionId);
        QLog.d("[cmshow]ApolloItemBuilder", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    long l = System.currentTimeMillis();
    localObject2 = this.c;
    ((ApolloFavActionData)localObject2).favId = l;
    ((IApolloDaoManagerService)localObject1).insertFavActionPackageData((ApolloFavActionData)localObject2);
    ApolloItemBuilder.a(this.b.getString(2131886674), 2, this.b);
    ApolloAioBubbleReportUtil.a.a(this.a, this.d, this.c);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(" add aciton success id=");
      ((StringBuilder)localObject2).append(this.c.actionId);
      QLog.d("[cmshow]ApolloItemBuilder", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject3 = this.a.getHandler(ChatActivity.class);
    if (localObject3 != null)
    {
      localObject2 = new ApolloMainInfo(this.a.getCurrentUin());
      ((ApolloInfo)localObject2).mAction = ((IApolloDaoManagerService)localObject1).findActionById(this.c.actionId);
      ((ApolloInfo)localObject2).mActionText = this.c.text;
      ((ApolloInfo)localObject2).mTextType = this.c.textType;
      ((ApolloInfo)localObject2).mAudioId = this.c.audioId;
      ((ApolloInfo)localObject2).mPlayOriginalAudio = this.c.playOriginalAudio;
      ((ApolloInfo)localObject2).mAudioStartTime = this.c.audioStartTime;
      localObject1 = ((MqqHandler)localObject3).obtainMessage(66);
      ((Message)localObject1).obj = localObject2;
      ((Message)localObject1).sendToTarget();
      if (((ApolloInfo)localObject2).mAction.status == 0)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("add action download res ");
          ((StringBuilder)localObject1).append(((ApolloInfo)localObject2).toString());
          QLog.d("[cmshow]ApolloItemBuilder", 2, ((StringBuilder)localObject1).toString());
        }
        if (this.a != null)
        {
          localObject1 = new ArrayList();
          ((List)localObject1).add(((ApolloInfo)localObject2).mAction);
          ApolloResManagerFacade.a.a(Scene.AIO).a((List)localObject1, "apollo_key");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.item.ApolloItemBuilder.4
 * JD-Core Version:    0.7.0.1
 */