package com.tencent.mobileqq.activity.history;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.URLUtil;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.history.helper.ChatHistoryItemSelectHelper;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ChatHistoryC2CLinkAdapter$2
  implements View.OnClickListener
{
  ChatHistoryC2CLinkAdapter$2(ChatHistoryC2CLinkAdapter paramChatHistoryC2CLinkAdapter, String paramString, ChatHistoryC2CLinkAdapter.URLItemHolder paramURLItemHolder, MessageRecord paramMessageRecord) {}
  
  public void onClick(View paramView)
  {
    Object localObject2;
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkAdapter.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkFragment.c) {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        localObject1 = null;
        int i = this.jdField_a_of_type_JavaLangString.lastIndexOf("#");
        if (i > 0) {
          localObject1 = this.jdField_a_of_type_JavaLangString.substring(i);
        }
        localObject2 = URLUtil.guessUrl(this.jdField_a_of_type_JavaLangString);
        if (localObject1 == null) {
          break label188;
        }
      }
    }
    label188:
    for (Object localObject1 = (String)localObject2 + (String)localObject1;; localObject1 = localObject2)
    {
      localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkAdapter.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkAdapter.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      boolean bool = ChatHistoryC2CLinkAdapter.URLItemHolder.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkAdapter$URLItemHolder).isChecked();
      ChatHistoryC2CLinkAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkAdapter).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      localObject1 = ChatHistoryC2CLinkAdapter.URLItemHolder.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkAdapter$URLItemHolder);
      if (!bool) {}
      for (bool = true;; bool = false)
      {
        ((CheckBox)localObject1).setChecked(bool);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CLinkAdapter.2
 * JD-Core Version:    0.7.0.1
 */