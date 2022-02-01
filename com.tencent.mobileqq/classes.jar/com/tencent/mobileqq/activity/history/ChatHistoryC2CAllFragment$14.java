package com.tencent.mobileqq.activity.history;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.ChatHistoryAdapterForC2C;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.ThumbnailInfo;
import com.tencent.qphone.base.util.QLog;

class ChatHistoryC2CAllFragment$14
  extends FMObserver
{
  ChatHistoryC2CAllFragment$14(ChatHistoryC2CAllFragment paramChatHistoryC2CAllFragment) {}
  
  protected void a(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (this.a.a != null) {
      this.a.a.notifyDataSetChanged();
    }
  }
  
  protected void a(ThumbnailInfo paramThumbnailInfo)
  {
    if ((!TextUtils.isEmpty(paramThumbnailInfo.a)) && (!TextUtils.isEmpty(paramThumbnailInfo.b)))
    {
      if (this.a.a != null) {
        this.a.a.notifyDataSetChanged();
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OnThumbDownLoad error : [fileId] = ");
      localStringBuilder.append(paramThumbnailInfo.a);
      localStringBuilder.append(" [path] = ");
      localStringBuilder.append(paramThumbnailInfo.b);
      QLog.i("Q.history.C2CAllFragment", 2, localStringBuilder.toString());
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (this.a.a != null) {
      this.a.a.notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (this.a.a != null) {
      this.a.a.notifyDataSetChanged();
    }
  }
  
  protected void b()
  {
    if (this.a.a != null) {
      this.a.a.notifyDataSetChanged();
    }
  }
  
  protected void d()
  {
    if (this.a.a != null) {
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment.14
 * JD-Core Version:    0.7.0.1
 */