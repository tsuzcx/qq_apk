package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.activity.aio.photo.AIOGalleryMsgRevokeMgr;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListModel;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.AIOPhotoListAdapter;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;

class ChatHistoryImageView$1
  implements Runnable
{
  ChatHistoryImageView$1(ChatHistoryImageView paramChatHistoryImageView, long paramLong) {}
  
  public void run()
  {
    if (this.this$0.A) {
      return;
    }
    Object localObject = this.this$0.c.i(this.a);
    if ((localObject != null) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRevokeMsg, seq:");
      localStringBuilder.append(((ChatMessage)localObject).uniseq);
      QLog.i("ChatHistoryImageView", 2, localStringBuilder.toString());
    }
    localObject = this.this$0.d.a(this.a);
    if (localObject != null)
    {
      this.this$0.d.b((AIORichMediaInfo)localObject);
      this.this$0.l.notifyDataSetChanged();
    }
    if ((this.this$0.z) && (this.this$0.e != null) && (this.this$0.e.L == this.a)) {
      AIOGalleryMsgRevokeMgr.a(this.this$0.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryImageView.1
 * JD-Core Version:    0.7.0.1
 */