package com.tencent.mobileqq.activity;

import android.os.SystemClock;
import android.view.View;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListModel;
import com.tencent.mobileqq.activity.aio.photo.AIOPhotoListAdapter;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.qphone.base.util.QLog;

class ChatHistoryImageView$2
  implements Runnable
{
  ChatHistoryImageView$2(ChatHistoryImageView paramChatHistoryImageView, AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt) {}
  
  public void run()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onImageListLoad]: ");
      localObject = this.a;
      if (localObject == null) {
        localObject = "null";
      } else {
        localObject = Integer.valueOf(localObject.length);
      }
      localStringBuilder.append(localObject);
      QLog.d("ChatHistoryImageView", 2, localStringBuilder.toString());
    }
    long l = SystemClock.uptimeMillis();
    if ((this.a != null) && (!this.this$0.d.a(this.a, this.b))) {
      this.this$0.d.h();
    }
    if (this.this$0.d.a() == 0) {
      this.this$0.i.setVisibility(0);
    } else {
      this.this$0.i.setVisibility(4);
    }
    if (!this.this$0.l.b(false)) {
      this.this$0.l.notifyDataSetChanged();
    }
    if (this.this$0.e != null)
    {
      localObject = this.this$0;
      ((ChatHistoryImageView)localObject).a(((ChatHistoryImageView)localObject).e, false);
    }
    if (this.this$0.B != null) {
      this.this$0.B.b();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[onImageListLoad] cost: ");
      ((StringBuilder)localObject).append(SystemClock.uptimeMillis() - l);
      QLog.d("ChatHistoryImageView", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryImageView.2
 * JD-Core Version:    0.7.0.1
 */