package com.tencent.mobileqq.activity.selectable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForWantGiftMsg;
import com.tencent.mobileqq.text.TextUtils;

public class ChatAdapterSelectableHelper
{
  private static final int b = Color.rgb(123, 113, 30);
  private static final int c = Color.rgb(38, 87, 178);
  private static final int d = Color.argb(64, 125, 113, 30);
  private static final int e = Color.argb(64, 6, 59, 156);
  private static final int f = Color.rgb(162, 116, 4);
  private static final int g = Color.argb(64, 213, 185, 118);
  private static final int h = Color.argb(102, 213, 185, 118);
  public int a;
  private final ChatAdapter1 a;
  public QQAppInterface a;
  
  public ChatAdapterSelectableHelper(ChatAdapter1 paramChatAdapter1, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 = paramChatAdapter1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private SelectableComponent a(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    if ((paramView.getParent() instanceof SelectableComponent)) {
      return (SelectableComponent)paramView.getParent();
    }
    if ((paramView instanceof SelectableComponent)) {
      return (SelectableComponent)paramView;
    }
    return null;
  }
  
  public void a(View paramView, CommonMenuWrapper paramCommonMenuWrapper)
  {
    SelectableComponent localSelectableComponent = a(paramView);
    if (localSelectableComponent == null) {
      return;
    }
    SelectableDelegate localSelectableDelegate = localSelectableComponent.delegate();
    ChatMessage localChatMessage = AIOUtils.a(paramView);
    if ((localSelectableDelegate != null) && (localSelectableDelegate.b()) && (!localSelectableComponent.hasSelected()) && (localChatMessage != null))
    {
      int i = this.jdField_a_of_type_Int;
      if (i == 2)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localChatMessage.selfuin))
        {
          localSelectableDelegate.c(f);
          localSelectableDelegate.b(g);
        }
        else
        {
          localSelectableDelegate.c(f);
          localSelectableDelegate.b(h);
        }
      }
      else if (i == 1)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localChatMessage.selfuin))
        {
          localSelectableDelegate.c(b);
          localSelectableDelegate.b(d);
        }
        else
        {
          localSelectableDelegate.c(c);
          localSelectableDelegate.b(e);
        }
      }
      else
      {
        paramView = paramView.getResources();
        int j;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localChatMessage.selfuin))
        {
          i = paramView.getColorStateList(2131167031).getDefaultColor();
          j = paramView.getColorStateList(2131167033).getDefaultColor();
        }
        else
        {
          i = paramView.getColorStateList(2131167030).getDefaultColor();
          j = paramView.getColorStateList(2131167032).getDefaultColor();
        }
        localSelectableDelegate.c(i);
        localSelectableDelegate.b(j);
        if (QLog.isColorLevel())
        {
          paramView = new StringBuilder();
          paramView.append("Load Select color, cursor=");
          paramView.append(i);
          paramView.append(", component=");
          paramView.append(j);
          QLog.d("ChatAdapterSelectableHelper", 0, paramView.toString());
        }
      }
      localSelectableDelegate.a(paramCommonMenuWrapper);
      localSelectableComponent.doSelecting(localChatMessage);
    }
  }
  
  public boolean a(View paramView)
  {
    ChatMessage localChatMessage = AIOUtils.a(paramView);
    if (AppSetting.d) {}
    label65:
    do
    {
      do
      {
        bool = false;
        break label95;
        if (!(localChatMessage instanceof MessageForText)) {
          break;
        }
      } while (((localChatMessage instanceof MessageForWantGiftMsg)) || ((localChatMessage instanceof MessageForFoldMsg)));
      break label65;
      if ((localChatMessage instanceof MessageForMixedMsg))
      {
        bool = ((MessageForMixedMsg)localChatMessage).canSelectable();
        break;
      }
      if ((localChatMessage instanceof MessageForPtt)) {}
      while ((localChatMessage instanceof MessageForReplyText))
      {
        bool = true;
        break;
      }
    } while (!(localChatMessage instanceof MessageForLongMsg));
    boolean bool = ((MessageForLongMsg)localChatMessage).canSelectable();
    label95:
    if (bool)
    {
      paramView = a(paramView);
      if (paramView != null)
      {
        if (paramView.contentLength() > 0) {
          return true;
        }
        if (AIOSelectableDelegateImpl.a().c()) {
          AIOSelectableDelegateImpl.a().d();
        }
        return false;
      }
      if (AIOSelectableDelegateImpl.a().c()) {
        AIOSelectableDelegateImpl.a().d();
      }
      return false;
    }
    if (AIOSelectableDelegateImpl.a().c()) {
      AIOSelectableDelegateImpl.a().d();
    }
    return false;
  }
  
  public boolean a(View paramView, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    paramView = a(paramView);
    boolean bool2 = false;
    if (paramView == null) {
      return false;
    }
    if (!paramView.hasTouchSelectableArea((int)paramFloat1, (int)paramFloat2)) {
      return false;
    }
    if (TextUtils.getNeoTextAfter(paramView.content().toString(), 0, paramInt2, false).length() < paramInt2) {
      return false;
    }
    paramView = paramView.delegate();
    boolean bool1 = bool2;
    if (paramView != null)
    {
      bool1 = bool2;
      if (paramView.f())
      {
        bool1 = bool2;
        if (paramView.a(paramFloat1, paramFloat2, paramInt1, paramInt2) != -1) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.ChatAdapterSelectableHelper
 * JD-Core Version:    0.7.0.1
 */