package com.tencent.av.ui.chatroom;

import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import com.tencent.mobileqq.text.TextUtils;

class ChatRoomAdapter$1
  extends AccessibilityDelegateCompat
{
  ChatRoomAdapter$1(ChatRoomAdapter paramChatRoomAdapter, VideoChatMessage paramVideoChatMessage) {}
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    if (this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatMessage.a() != null)
    {
      paramView = TextUtils.emoticonToTextForTalkBack(this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatMessage.a().toString());
      paramAccessibilityNodeInfoCompat.setText(paramView);
      paramAccessibilityNodeInfoCompat.setContentDescription(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.chatroom.ChatRoomAdapter.1
 * JD-Core Version:    0.7.0.1
 */