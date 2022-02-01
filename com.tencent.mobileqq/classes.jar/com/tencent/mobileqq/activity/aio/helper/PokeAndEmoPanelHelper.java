package com.tencent.mobileqq.activity.aio.helper;

import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.PokePanel;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider;
import com.tencent.mobileqq.activity.aio.core.helper.OnFinishListener;
import com.tencent.mobileqq.activity.aio.core.msglist.IMsgUpdateCallback;
import com.tencent.mobileqq.activity.aio.item.PokeItemAnimationManager;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.panel.PokeAndEmoPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.widget.FitSystemWindowsRelativeLayout;
import java.util.HashMap;

public class PokeAndEmoPanelHelper
  implements OnFinishListener, IMsgUpdateCallback, ILifeCycleHelper
{
  private final AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  private PanelManager jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public PokeAndEmoPanelHelper(AIOContext paramAIOContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramAIOContext.a();
    paramAIOContext.a().a(this);
  }
  
  private PokeAndEmoPanel a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
    }
    return (PokeAndEmoPanel)this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.b(23);
  }
  
  private void a()
  {
    ViewGroup localViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
    PokeItemAnimationManager.a().a((FitSystemWindowsRelativeLayout)localViewGroup);
  }
  
  private void b()
  {
    PokeAndEmoPanel localPokeAndEmoPanel = a();
    if (localPokeAndEmoPanel != null) {
      localPokeAndEmoPanel.a();
    }
  }
  
  private void c()
  {
    PokePanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (!PokeItemHelper.b) {
      ThreadManager.executeOnSubThread(new PokeAndEmoPanelHelper.1(this));
    }
  }
  
  private void d()
  {
    PokeAndEmoPanel localPokeAndEmoPanel = a();
    if (localPokeAndEmoPanel != null) {
      localPokeAndEmoPanel.c();
    }
  }
  
  private void e()
  {
    PokeAndEmoPanel localPokeAndEmoPanel = a();
    if (localPokeAndEmoPanel != null)
    {
      localPokeAndEmoPanel.b();
      PokeItemHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), PokeItemHelper.a);
    }
    PokeItemHelper.a();
    PokeItemHelper.b();
    f();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a.clear();
  }
  
  private void f()
  {
    PokeItemAnimationManager.a().a(3);
    PokeItemAnimationManager.a().a(6);
    PokeItemAnimationManager.a().a(12);
    PokeItemAnimationManager.a().a(15);
    PokeItemAnimationManager.a().a(18);
    PokeItemAnimationManager.a().a(9);
  }
  
  public int a()
  {
    return 0;
  }
  
  public void a(AIOContext paramAIOContext, ChatMessage paramChatMessage)
  {
    if ((!paramChatMessage.isread) && ((paramChatMessage instanceof MessageForPoke)) && (!paramChatMessage.isSend()))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a.put(Long.valueOf(paramChatMessage.uniseq), paramChatMessage);
      ((MessageForPoke)paramChatMessage).isPlayed = false;
    }
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public boolean a(AIOContext paramAIOContext, ChatMessage paramChatMessage)
  {
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    return false;
  }
  
  public void b(AIOContext paramAIOContext, ChatMessage paramChatMessage) {}
  
  public boolean b(AIOContext paramAIOContext, ChatMessage paramChatMessage)
  {
    return false;
  }
  
  public void c(AIOContext paramAIOContext, ChatMessage paramChatMessage) {}
  
  public void d(int paramInt) {}
  
  public String getTag()
  {
    return "PokeAndEmoPanelHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 0, 9, 10, 12, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 12)
      {
        if (paramInt != 15)
        {
          if (paramInt != 9)
          {
            if (paramInt != 10) {
              return;
            }
            b();
            return;
          }
          c();
          return;
        }
        e();
        return;
      }
      d();
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.PokeAndEmoPanelHelper
 * JD-Core Version:    0.7.0.1
 */