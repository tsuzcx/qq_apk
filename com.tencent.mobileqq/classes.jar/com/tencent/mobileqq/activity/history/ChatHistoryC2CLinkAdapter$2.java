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
    if (!this.d.d.i)
    {
      if (!TextUtils.isEmpty(this.a))
      {
        Object localObject1 = null;
        int i = this.a.lastIndexOf("#");
        if (i > 0) {
          localObject1 = this.a.substring(i);
        }
        String str = URLUtil.guessUrl(this.a);
        Object localObject2 = str;
        if (localObject1 != null)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(str);
          ((StringBuilder)localObject2).append((String)localObject1);
          localObject2 = ((StringBuilder)localObject2).toString();
        }
        localObject1 = new Intent(this.d.c, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", (String)localObject2);
        this.d.c.startActivity((Intent)localObject1);
      }
    }
    else
    {
      boolean bool = ChatHistoryC2CLinkAdapter.URLItemHolder.e(this.b).isChecked();
      ChatHistoryC2CLinkAdapter.a(this.d).b(this.c);
      ChatHistoryC2CLinkAdapter.URLItemHolder.e(this.b).setChecked(bool ^ true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CLinkAdapter.2
 * JD-Core Version:    0.7.0.1
 */