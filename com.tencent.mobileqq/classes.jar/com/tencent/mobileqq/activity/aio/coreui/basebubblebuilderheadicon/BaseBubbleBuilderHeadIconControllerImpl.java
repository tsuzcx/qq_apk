package com.tencent.mobileqq.activity.aio.coreui.basebubblebuilderheadicon;

import android.content.Context;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon.AioApolloHeadIconController;
import com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon.AnonymousHeadIconController;
import com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon.AnonymousMsgHeadIconController;
import com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon.CustomizeByBizHeadIconController;
import com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon.DefaultHeadIconController;
import com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon.DeviceMsgHeadIconController;
import com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon.FakeSelfHeadIconController;
import com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon.FileAssistantHeadIconController;
import com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon.NonFriendHeadIconController;
import com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon.RIJPrivateChatHeadIconController;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.gamecenter.view.GameChatMessageHeadIconController;
import com.tencent.mobileqq.troop.aiobubbleheadicon.TroopBusinessMsgHeadIconController;
import com.tencent.mobileqq.troop.aiobubbleheadicon.TroopScriptMsgHeadIconController;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BaseBubbleBuilderHeadIconControllerImpl
  extends BaseBubbleBuilderHeadIconController
{
  private List<BaseBubbleBuilderHeadIconController> i = new ArrayList();
  private BaseBubbleBuilderHeadIconController j;
  private BaseBubbleBuilderHeadIconController k;
  
  public BaseBubbleBuilderHeadIconControllerImpl()
  {
    k();
  }
  
  private BaseBubbleBuilderHeadIconController b(ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, BaseChatItemLayout paramBaseChatItemLayout, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, IFaceDecoder paramIFaceDecoder)
  {
    if (this.k == null) {
      this.k = new DefaultHeadIconController();
    }
    this.k.a(paramChatMessage, paramQQAppInterface, paramContext, paramSessionInfo, paramBaseChatItemLayout, paramOnClickListener, paramOnLongClickListener, paramIFaceDecoder);
    return this.k;
  }
  
  private void k()
  {
    this.i.add(new FakeSelfHeadIconController());
    this.i.add(new CustomizeByBizHeadIconController());
    this.i.add(new AnonymousHeadIconController());
    this.i.add(new GameChatMessageHeadIconController());
    this.i.add(new FileAssistantHeadIconController());
    this.i.add(new AnonymousMsgHeadIconController());
    this.i.add(new TroopScriptMsgHeadIconController());
    this.i.add(new TroopBusinessMsgHeadIconController());
    this.i.add(new AioApolloHeadIconController());
    this.i.add(new NonFriendHeadIconController());
    this.i.add(new DeviceMsgHeadIconController());
    this.i.add(new RIJPrivateChatHeadIconController());
  }
  
  public void a(ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, BaseChatItemLayout paramBaseChatItemLayout, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, IFaceDecoder paramIFaceDecoder)
  {
    this.j = b(paramChatMessage, paramQQAppInterface, paramContext, paramSessionInfo, paramBaseChatItemLayout, paramOnClickListener, paramOnLongClickListener, paramIFaceDecoder);
    super.a(paramChatMessage, paramQQAppInterface, paramContext, paramSessionInfo, paramBaseChatItemLayout, paramOnClickListener, paramOnLongClickListener, paramIFaceDecoder);
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext())
    {
      BaseBubbleBuilderHeadIconController localBaseBubbleBuilderHeadIconController = (BaseBubbleBuilderHeadIconController)localIterator.next();
      if (localBaseBubbleBuilderHeadIconController != null)
      {
        localBaseBubbleBuilderHeadIconController.a(paramChatMessage, paramQQAppInterface, paramContext, paramSessionInfo, paramBaseChatItemLayout, paramOnClickListener, paramOnLongClickListener, paramIFaceDecoder);
        if (localBaseBubbleBuilderHeadIconController.h()) {
          this.j = localBaseBubbleBuilderHeadIconController;
        }
      }
    }
  }
  
  protected void b()
  {
    this.j.b();
  }
  
  protected void c()
  {
    this.j.c();
  }
  
  protected void d()
  {
    this.j.d();
  }
  
  protected void e()
  {
    this.j.e();
  }
  
  protected void f()
  {
    this.j.f();
  }
  
  protected void g()
  {
    this.j.g();
  }
  
  public boolean h()
  {
    return this.j != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.basebubblebuilderheadicon.BaseBubbleBuilderHeadIconControllerImpl
 * JD-Core Version:    0.7.0.1
 */