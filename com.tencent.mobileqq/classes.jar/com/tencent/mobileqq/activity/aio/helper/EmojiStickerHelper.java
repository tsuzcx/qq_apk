package com.tencent.mobileqq.activity.aio.helper;

import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollListener;

public class EmojiStickerHelper
  implements Handler.Callback, ILifeCycleHelper, AbsListView.OnScrollListener
{
  public View a;
  private final BaseChatPie a;
  
  public EmojiStickerHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  private void c()
  {
    EmojiStickerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
  }
  
  private void d()
  {
    EmojiStickerManager localEmojiStickerManager = EmojiStickerManager.a();
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    localEmojiStickerManager.a(localBaseChatPie, localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.r);
  }
  
  public void a()
  {
    ChatXListView localChatXListView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
    ChatAdapter1 localChatAdapter1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1;
    if (localChatXListView != null)
    {
      Object localObject;
      if (localChatXListView.getChildCount() > 0)
      {
        int j = localChatXListView.getFirstVisiblePosition();
        localObject = localChatXListView.getChildAt(0);
        int i;
        if (localObject == null) {
          i = 0;
        } else {
          i = ((View)localObject).getTop();
        }
        localChatXListView.setSelectionFromTop(j, i);
      }
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        this.jdField_a_of_type_AndroidViewView = new View(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_AndroidViewView.setId(2131374108);
        localObject = new AbsListView.LayoutParams(-1, 80);
        this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (this.jdField_a_of_type_AndroidViewView.getParent() == null)
      {
        localChatXListView.setAdapter(null);
        localChatXListView.addFooterView(this.jdField_a_of_type_AndroidViewView, null, false);
        localChatXListView.setAdapter(localChatAdapter1);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.e(196608);
      }
    }
  }
  
  public void b()
  {
    ChatXListView localChatXListView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
    if ((this.jdField_a_of_type_AndroidViewView != null) && (localChatXListView != null))
    {
      if (localChatXListView.getChildCount() > 0)
      {
        int j = localChatXListView.getFirstVisiblePosition();
        int i = 0;
        localView = localChatXListView.getChildAt(0);
        if (localView != null) {
          i = localView.getTop();
        }
        localChatXListView.setSelectionFromTop(j, i);
      }
      View localView = this.jdField_a_of_type_AndroidViewView;
      if (localView != null) {
        localChatXListView.removeFooterView(localView);
      }
      this.jdField_a_of_type_AndroidViewView = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.e(196608);
    }
  }
  
  @NonNull
  public String getTag()
  {
    return "EmojiStickerHelper";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public int[] interestedIn()
  {
    return new int[] { 10, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 10)
    {
      if (paramInt != 15) {
        return;
      }
      d();
      return;
    }
    c();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {
      EmojiStickerManager.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.EmojiStickerHelper
 * JD-Core Version:    0.7.0.1
 */