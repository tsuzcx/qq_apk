package com.tencent.mobileqq.ark.api;

import android.graphics.Rect;
import android.view.View;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HeaderViewListAdapter;

public class UIViewUtils
{
  public static Rect a(View paramView)
  {
    Rect localRect = new Rect();
    paramView.getGlobalVisibleRect(localRect);
    return localRect;
  }
  
  public static View a(ChatMessage paramChatMessage, ChatXListView paramChatXListView)
  {
    int i = ((ChatAdapter1)((HeaderViewListAdapter)paramChatXListView.getAdapter()).getWrappedAdapter()).a(paramChatMessage) + paramChatXListView.getHeaderViewsCount();
    if (QLog.isColorLevel())
    {
      paramChatMessage = new StringBuilder();
      paramChatMessage.append("pos is:");
      paramChatMessage.append(i);
      QLog.d("Q.msg.delmsg", 2, paramChatMessage.toString());
    }
    if (i < 0) {
      return null;
    }
    return paramChatXListView.getChildAt(i - paramChatXListView.getFirstVisiblePosition());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.UIViewUtils
 * JD-Core Version:    0.7.0.1
 */