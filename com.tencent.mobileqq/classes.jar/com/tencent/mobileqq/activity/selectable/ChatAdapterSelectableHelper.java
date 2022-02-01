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
  private static final int c = Color.rgb(123, 113, 30);
  private static final int d = Color.rgb(38, 87, 178);
  private static final int e = Color.argb(64, 125, 113, 30);
  private static final int f = Color.argb(64, 6, 59, 156);
  private static final int g = Color.rgb(162, 116, 4);
  private static final int h = Color.argb(64, 213, 185, 118);
  private static final int i = Color.argb(102, 213, 185, 118);
  public QQAppInterface a;
  public int b = 0;
  private final ChatAdapter1 j;
  
  public ChatAdapterSelectableHelper(ChatAdapter1 paramChatAdapter1, QQAppInterface paramQQAppInterface)
  {
    this.j = paramChatAdapter1;
    this.a = paramQQAppInterface;
  }
  
  private SelectableComponent b(View paramView)
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
    SelectableComponent localSelectableComponent = b(paramView);
    if (localSelectableComponent == null) {
      return;
    }
    SelectableDelegate localSelectableDelegate = localSelectableComponent.delegate();
    ChatMessage localChatMessage = AIOUtils.a(paramView);
    if ((localSelectableDelegate != null) && (localSelectableDelegate.k()) && (!localSelectableComponent.hasSelected()) && (localChatMessage != null))
    {
      int k = this.b;
      if (k == 2)
      {
        if (this.a.getCurrentAccountUin().equals(localChatMessage.selfuin))
        {
          localSelectableDelegate.c(g);
          localSelectableDelegate.b(h);
        }
        else
        {
          localSelectableDelegate.c(g);
          localSelectableDelegate.b(i);
        }
      }
      else if (k == 1)
      {
        if (this.a.getCurrentAccountUin().equals(localChatMessage.selfuin))
        {
          localSelectableDelegate.c(c);
          localSelectableDelegate.b(e);
        }
        else
        {
          localSelectableDelegate.c(d);
          localSelectableDelegate.b(f);
        }
      }
      else
      {
        paramView = paramView.getResources();
        int m;
        if (this.a.getCurrentAccountUin().equals(localChatMessage.selfuin))
        {
          k = paramView.getColorStateList(2131167967).getDefaultColor();
          m = paramView.getColorStateList(2131167969).getDefaultColor();
        }
        else
        {
          k = paramView.getColorStateList(2131167966).getDefaultColor();
          m = paramView.getColorStateList(2131167968).getDefaultColor();
        }
        localSelectableDelegate.c(k);
        localSelectableDelegate.b(m);
        if (QLog.isColorLevel())
        {
          paramView = new StringBuilder();
          paramView.append("Load Select color, cursor=");
          paramView.append(k);
          paramView.append(", component=");
          paramView.append(m);
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
    if (AppSetting.e) {}
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
      paramView = b(paramView);
      if (paramView != null)
      {
        if (paramView.contentLength() > 0) {
          return true;
        }
        if (AIOSelectableDelegateImpl.a().l()) {
          AIOSelectableDelegateImpl.a().n();
        }
        return false;
      }
      if (AIOSelectableDelegateImpl.a().l()) {
        AIOSelectableDelegateImpl.a().n();
      }
      return false;
    }
    if (AIOSelectableDelegateImpl.a().l()) {
      AIOSelectableDelegateImpl.a().n();
    }
    return false;
  }
  
  public boolean a(View paramView, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    paramView = b(paramView);
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
      if (paramView.q())
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.ChatAdapterSelectableHelper
 * JD-Core Version:    0.7.0.1
 */