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
    if (paramView == null) {}
    do
    {
      return null;
      if ((paramView.getParent() instanceof SelectableComponent)) {
        return (SelectableComponent)paramView.getParent();
      }
    } while (!(paramView instanceof SelectableComponent));
    return (SelectableComponent)paramView;
  }
  
  public void a(View paramView, CommonMenuWrapper paramCommonMenuWrapper)
  {
    SelectableComponent localSelectableComponent = a(paramView);
    if (localSelectableComponent == null) {}
    SelectableDelegate localSelectableDelegate;
    ChatMessage localChatMessage;
    do
    {
      return;
      localSelectableDelegate = localSelectableComponent.delegate();
      localChatMessage = AIOUtils.a(paramView);
    } while ((localSelectableDelegate == null) || (!localSelectableDelegate.b()) || (localSelectableComponent.hasSelected()) || (localChatMessage == null));
    if (this.jdField_a_of_type_Int == 2) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localChatMessage.selfuin))
      {
        localSelectableDelegate.c(f);
        localSelectableDelegate.b(g);
      }
    }
    for (;;)
    {
      localSelectableDelegate.a(paramCommonMenuWrapper);
      localSelectableComponent.doSelecting(localChatMessage);
      return;
      localSelectableDelegate.c(f);
      localSelectableDelegate.b(h);
      continue;
      if (this.jdField_a_of_type_Int != 1) {
        break;
      }
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
    paramView = paramView.getResources();
    int j;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localChatMessage.selfuin)) {
      j = paramView.getColorStateList(2131167008).getDefaultColor();
    }
    for (int i = paramView.getColorStateList(2131167010).getDefaultColor();; i = paramView.getColorStateList(2131167009).getDefaultColor())
    {
      localSelectableDelegate.c(j);
      localSelectableDelegate.b(i);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ChatAdapterSelectableHelper", 0, "Load Select color, cursor=" + j + ", component=" + i);
      break;
      j = paramView.getColorStateList(2131167007).getDefaultColor();
    }
  }
  
  public boolean a(View paramView)
  {
    boolean bool2 = false;
    ChatMessage localChatMessage = AIOUtils.a(paramView);
    boolean bool1;
    if (AppSetting.d)
    {
      bool1 = false;
      if (!bool1) {
        break label186;
      }
      paramView = a(paramView);
      if (paramView == null) {
        break label167;
      }
      if (paramView.contentLength() <= 0) {
        break label148;
      }
      bool1 = true;
    }
    label148:
    label167:
    label186:
    do
    {
      do
      {
        do
        {
          return bool1;
          if ((localChatMessage instanceof MessageForText))
          {
            if ((!(localChatMessage instanceof MessageForWantGiftMsg)) && (!(localChatMessage instanceof MessageForFoldMsg)))
            {
              bool1 = true;
              break;
            }
            bool1 = false;
            break;
          }
          if ((localChatMessage instanceof MessageForMixedMsg))
          {
            bool1 = ((MessageForMixedMsg)localChatMessage).canSelectable();
            break;
          }
          if ((localChatMessage instanceof MessageForPtt))
          {
            bool1 = true;
            break;
          }
          if ((localChatMessage instanceof MessageForReplyText))
          {
            bool1 = true;
            break;
          }
          if ((localChatMessage instanceof MessageForLongMsg))
          {
            bool1 = ((MessageForLongMsg)localChatMessage).canSelectable();
            break;
          }
          bool1 = false;
          break;
          bool1 = bool2;
        } while (!AIOSelectableDelegateImpl.a().c());
        AIOSelectableDelegateImpl.a().d();
        return false;
        bool1 = bool2;
      } while (!AIOSelectableDelegateImpl.a().c());
      AIOSelectableDelegateImpl.a().d();
      return false;
      bool1 = bool2;
    } while (!AIOSelectableDelegateImpl.a().c());
    AIOSelectableDelegateImpl.a().d();
    return false;
  }
  
  public boolean a(View paramView, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    paramView = a(paramView);
    if (paramView == null) {}
    do
    {
      do
      {
        return false;
      } while ((!paramView.hasTouchSelectableArea((int)paramFloat1, (int)paramFloat2)) || (TextUtils.getNeoTextAfter(paramView.content().toString(), 0, paramInt2, false).length() < paramInt2));
      paramView = paramView.delegate();
    } while ((paramView == null) || (!paramView.f()) || (paramView.a(paramFloat1, paramFloat2, paramInt1, paramInt2) == -1));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.ChatAdapterSelectableHelper
 * JD-Core Version:    0.7.0.1
 */