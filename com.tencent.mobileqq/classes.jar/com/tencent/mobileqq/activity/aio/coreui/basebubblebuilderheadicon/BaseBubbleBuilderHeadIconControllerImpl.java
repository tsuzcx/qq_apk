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
  private BaseBubbleBuilderHeadIconController jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiBasebubblebuilderheadiconBaseBubbleBuilderHeadIconController;
  private List<BaseBubbleBuilderHeadIconController> jdField_a_of_type_JavaUtilList = new ArrayList();
  private BaseBubbleBuilderHeadIconController b;
  
  public BaseBubbleBuilderHeadIconControllerImpl()
  {
    h();
  }
  
  private BaseBubbleBuilderHeadIconController a(ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, BaseChatItemLayout paramBaseChatItemLayout, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, IFaceDecoder paramIFaceDecoder)
  {
    if (this.b == null) {
      this.b = new DefaultHeadIconController();
    }
    this.b.a(paramChatMessage, paramQQAppInterface, paramContext, paramSessionInfo, paramBaseChatItemLayout, paramOnClickListener, paramOnLongClickListener, paramIFaceDecoder);
    return this.b;
  }
  
  private void h()
  {
    this.jdField_a_of_type_JavaUtilList.add(new FakeSelfHeadIconController());
    this.jdField_a_of_type_JavaUtilList.add(new CustomizeByBizHeadIconController());
    this.jdField_a_of_type_JavaUtilList.add(new AnonymousHeadIconController());
    this.jdField_a_of_type_JavaUtilList.add(new GameChatMessageHeadIconController());
    this.jdField_a_of_type_JavaUtilList.add(new FileAssistantHeadIconController());
    this.jdField_a_of_type_JavaUtilList.add(new AnonymousMsgHeadIconController());
    this.jdField_a_of_type_JavaUtilList.add(new TroopScriptMsgHeadIconController());
    this.jdField_a_of_type_JavaUtilList.add(new TroopBusinessMsgHeadIconController());
    this.jdField_a_of_type_JavaUtilList.add(new AioApolloHeadIconController());
    this.jdField_a_of_type_JavaUtilList.add(new NonFriendHeadIconController());
    this.jdField_a_of_type_JavaUtilList.add(new DeviceMsgHeadIconController());
  }
  
  public void a(ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, BaseChatItemLayout paramBaseChatItemLayout, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, IFaceDecoder paramIFaceDecoder)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiBasebubblebuilderheadiconBaseBubbleBuilderHeadIconController = a(paramChatMessage, paramQQAppInterface, paramContext, paramSessionInfo, paramBaseChatItemLayout, paramOnClickListener, paramOnLongClickListener, paramIFaceDecoder);
    super.a(paramChatMessage, paramQQAppInterface, paramContext, paramSessionInfo, paramBaseChatItemLayout, paramOnClickListener, paramOnLongClickListener, paramIFaceDecoder);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      BaseBubbleBuilderHeadIconController localBaseBubbleBuilderHeadIconController = (BaseBubbleBuilderHeadIconController)localIterator.next();
      if (localBaseBubbleBuilderHeadIconController != null)
      {
        localBaseBubbleBuilderHeadIconController.a(paramChatMessage, paramQQAppInterface, paramContext, paramSessionInfo, paramBaseChatItemLayout, paramOnClickListener, paramOnLongClickListener, paramIFaceDecoder);
        if (localBaseBubbleBuilderHeadIconController.a()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiBasebubblebuilderheadiconBaseBubbleBuilderHeadIconController = localBaseBubbleBuilderHeadIconController;
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiBasebubblebuilderheadiconBaseBubbleBuilderHeadIconController != null;
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiBasebubblebuilderheadiconBaseBubbleBuilderHeadIconController.b();
  }
  
  protected void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiBasebubblebuilderheadiconBaseBubbleBuilderHeadIconController.c();
  }
  
  protected void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiBasebubblebuilderheadiconBaseBubbleBuilderHeadIconController.d();
  }
  
  protected void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiBasebubblebuilderheadiconBaseBubbleBuilderHeadIconController.e();
  }
  
  protected void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiBasebubblebuilderheadiconBaseBubbleBuilderHeadIconController.f();
  }
  
  protected void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiBasebubblebuilderheadiconBaseBubbleBuilderHeadIconController.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.basebubblebuilderheadicon.BaseBubbleBuilderHeadIconControllerImpl
 * JD-Core Version:    0.7.0.1
 */