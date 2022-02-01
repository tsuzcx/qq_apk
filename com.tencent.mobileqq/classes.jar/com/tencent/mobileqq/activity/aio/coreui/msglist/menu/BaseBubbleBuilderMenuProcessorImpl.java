package com.tencent.mobileqq.activity.aio.coreui.msglist.menu;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.menu.BaseBubbleBuilderMenuCancelChatTodoProcessor;
import com.tencent.mobileqq.activity.aio.rebuild.menu.BaseBubbleBuilderMenuChatTodoProcessor;
import com.tencent.mobileqq.activity.aio.rebuild.menu.BaseBubbleBuilderMenuDeleteProcessor;
import com.tencent.mobileqq.activity.aio.rebuild.menu.BaseBubbleBuilderMenuEssenceAddProcessor;
import com.tencent.mobileqq.activity.aio.rebuild.menu.BaseBubbleBuilderMenuEssenceCancelProcessor;
import com.tencent.mobileqq.activity.aio.rebuild.menu.BaseBubbleBuilderMenuFavoriteProcessor;
import com.tencent.mobileqq.activity.aio.rebuild.menu.BaseBubbleBuilderMenuMutePlayProcessor;
import com.tencent.mobileqq.activity.aio.rebuild.menu.BaseBubbleBuilderMenuReplyOnlyProcessor;
import com.tencent.mobileqq.activity.aio.rebuild.menu.BaseBubbleBuilderMenuReplyProcessor;
import com.tencent.mobileqq.activity.aio.rebuild.menu.BaseBubbleBuilderMenuRevokeProcessor;
import com.tencent.mobileqq.activity.aio.rebuild.menu.BaseBubbleBuilderMenuScreenShotProcessor;
import com.tencent.mobileqq.activity.aio.rebuild.menu.BaseBubbleBuilderMenuSelectMoreProcessor;
import com.tencent.mobileqq.activity.aio.rebuild.menu.BaseBubbleBuilderMenuUpcomingEventProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BaseBubbleBuilderMenuProcessorImpl
  extends BaseBubbleBuilderMenuProcessor
  implements IBaseBubbleBuilderMenuAddProcessor, IBaseBubbleBuilderMenuClickProcessor
{
  private BaseBubbleBuilderMenuProcessor c;
  private List<BaseBubbleBuilderMenuProcessor> d;
  
  public BaseBubbleBuilderMenuProcessorImpl(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramSessionInfo);
  }
  
  public static IBaseBubbleBuilderMenuClickProcessor a(BaseBubbleBuilderMenuProcessor paramBaseBubbleBuilderMenuProcessor)
  {
    if ((paramBaseBubbleBuilderMenuProcessor instanceof IBaseBubbleBuilderMenuClickProcessor)) {
      return (IBaseBubbleBuilderMenuClickProcessor)paramBaseBubbleBuilderMenuProcessor;
    }
    return null;
  }
  
  public static IBaseBubbleBuilderMenuAddProcessor b(BaseBubbleBuilderMenuProcessor paramBaseBubbleBuilderMenuProcessor)
  {
    if ((paramBaseBubbleBuilderMenuProcessor instanceof IBaseBubbleBuilderMenuAddProcessor)) {
      return (IBaseBubbleBuilderMenuAddProcessor)paramBaseBubbleBuilderMenuProcessor;
    }
    return null;
  }
  
  private void b(int paramInt)
  {
    if (this.d == null)
    {
      this.d = new ArrayList();
      this.d.add(new BaseBubbleBuilderMenuReplyProcessor(this.a, this.b));
      this.d.add(new BaseBubbleBuilderMenuScreenShotProcessor(this.a, this.b));
      this.d.add(new BaseBubbleBuilderMenuReplyOnlyProcessor(this.a, this.b));
      this.d.add(new BaseBubbleBuilderMenuUpcomingEventProcessor(this.a, this.b));
      this.d.add(new BaseBubbleBuilderMenuEssenceAddProcessor(this.a, this.b));
      this.d.add(new BaseBubbleBuilderMenuEssenceCancelProcessor(this.a, this.b));
      this.d.add(new BaseBubbleBuilderMenuSelectMoreProcessor(this.a, this.b));
      this.d.add(new BaseBubbleBuilderMenuRevokeProcessor(this.a, this.b));
      this.d.add(new BaseBubbleBuilderMenuFavoriteProcessor(this.a, this.b));
      this.d.add(new BaseBubbleBuilderMenuMutePlayProcessor(this.a, this.b));
      this.d.add(new BaseBubbleBuilderMenuDeleteProcessor(this.a, this.b));
      this.d.add(new BaseBubbleBuilderMenuChatTodoProcessor(this.a, this.b));
      this.d.add(new BaseBubbleBuilderMenuCancelChatTodoProcessor(this.a, this.b));
    }
    this.c = null;
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      BaseBubbleBuilderMenuProcessor localBaseBubbleBuilderMenuProcessor = (BaseBubbleBuilderMenuProcessor)localIterator.next();
      if ((localBaseBubbleBuilderMenuProcessor != null) && (localBaseBubbleBuilderMenuProcessor.a(paramInt))) {
        this.c = localBaseBubbleBuilderMenuProcessor;
      }
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    b(paramInt);
    BaseBubbleBuilderMenuProcessor localBaseBubbleBuilderMenuProcessor = this.c;
    if ((localBaseBubbleBuilderMenuProcessor instanceof IBaseBubbleBuilderMenuClickProcessor)) {
      ((IBaseBubbleBuilderMenuClickProcessor)localBaseBubbleBuilderMenuProcessor).a(paramInt, paramContext, paramChatMessage);
    }
  }
  
  public void a(QQCustomMenu paramQQCustomMenu, Context paramContext, int paramInt, ChatMessage paramChatMessage, Bundle paramBundle)
  {
    b(paramInt);
    BaseBubbleBuilderMenuProcessor localBaseBubbleBuilderMenuProcessor = this.c;
    if ((localBaseBubbleBuilderMenuProcessor instanceof IBaseBubbleBuilderMenuAddProcessor)) {
      ((IBaseBubbleBuilderMenuAddProcessor)localBaseBubbleBuilderMenuProcessor).a(paramQQCustomMenu, paramContext, paramInt, paramChatMessage, paramBundle);
    }
  }
  
  public boolean a(int paramInt)
  {
    return this.c != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.menu.BaseBubbleBuilderMenuProcessorImpl
 * JD-Core Version:    0.7.0.1
 */