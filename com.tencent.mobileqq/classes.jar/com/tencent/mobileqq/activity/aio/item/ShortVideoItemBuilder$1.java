package com.tencent.mobileqq.activity.aio.item;

import android.text.TextUtils;
import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.widget.MessageProgressView.AnimRunnableListener;

class ShortVideoItemBuilder$1
  implements MessageProgressView.AnimRunnableListener
{
  ShortVideoItemBuilder$1(ShortVideoItemBuilder paramShortVideoItemBuilder, ShortVideoItemBuilder.Holder paramHolder) {}
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a.q.frienduin);
      localStringBuilder.append(this.a.q.uniseq);
      if (paramString.equals(localStringBuilder.toString())) {
        this.a.c.setDrawStatus(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */