package com.tencent.mobileqq.activity.aio.item;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.qphone.base.util.QLog;

class QQStoryItemBuilder$4
  extends QQStoryItemBuilder.AIOStoryDownloadListener
{
  QQStoryItemBuilder$4(QQStoryItemBuilder paramQQStoryItemBuilder) {}
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("get video download finish,vid=");
      paramString2.append(paramString1);
      QLog.i("QQStoryItemBuilder", 2, paramString2.toString());
    }
    if (!paramString1.equals(this.d)) {
      return;
    }
    paramString1 = ((StoryManager)SuperManager.a(5)).a(paramString1);
    if (paramString1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQStoryItemBuilder", 2, "get video download finish, storyVideoItem == null");
      }
    }
    else {
      this.a.a(this.b, this.c, paramString1, false);
    }
  }
  
  public void a(String paramString1, String paramString2, ErrorMessage paramErrorMessage, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("Download video failed,vid=");
      paramString2.append(paramString1);
      QLog.e("QQStoryItemBuilder", 2, paramString2.toString());
    }
    this.a.a(this.b, this.c);
  }
  
  public void b(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("Download video onPause,vid=");
      paramString2.append(paramString1);
      QLog.e("QQStoryItemBuilder", 2, paramString2.toString());
    }
    this.a.a(this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder.4
 * JD-Core Version:    0.7.0.1
 */