package com.tencent.biz.richframework.eventbus;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.subscribe.event.PraisedUpdateEvents;
import com.tencent.biz.subscribe.event.SubDraftChangeEvent;
import com.tencent.qphone.base.util.QLog;

class SimpleEventBus$1$1
  implements Runnable
{
  SimpleEventBus$1$1(SimpleEventBus.1 param1, String paramString, Bundle paramBundle) {}
  
  public void run()
  {
    QLog.d("SimpleEventBus", 4, "onServerCall action" + this.val$action);
    if (SimpleEventBus.ACTION_PRAISED_UPDATE.equals(this.val$action)) {
      if (this.val$params != null)
      {
        localObject = this.val$params.getString("feed_id", "");
        i = this.val$params.getInt("feed_like_status", 0);
        j = this.val$params.getInt("feed_like_num", 0);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          this.this$1.this$0.dispatchEvent(new PraisedUpdateEvents((String)localObject, i, j));
        }
      }
    }
    while (!SimpleEventBus.ACTION_DRAFT_SYSTEM_CHANGE.equals(this.val$action))
    {
      int i;
      int j;
      return;
    }
    Object localObject = new SubDraftChangeEvent();
    if (this.val$params != null)
    {
      ((SubDraftChangeEvent)localObject).setDraftID(this.val$params.getString("draftId", ""));
      ((SubDraftChangeEvent)localObject).setIsSave(this.val$params.getBoolean("save_draft", false));
    }
    this.this$1.this$0.dispatchEvent((SimpleBaseEvent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.eventbus.SimpleEventBus.1.1
 * JD-Core Version:    0.7.0.1
 */