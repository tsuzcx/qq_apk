package com.tencent.biz.qqstory.playvideo;

import com.tencent.biz.qqstory.base.QQStoryBanInfo;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.qphone.base.util.QLog;

class MyVideoVisiblePersonPageView$4
  extends QQStoryObserver
{
  MyVideoVisiblePersonPageView$4(MyVideoVisiblePersonPageView paramMyVideoVisiblePersonPageView) {}
  
  public void a(boolean paramBoolean, QQStoryBanInfo paramQQStoryBanInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetVideoReaderConfig: isSuccess ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", QQStoryBanInfo = ");
      localStringBuilder.append(paramQQStoryBanInfo);
      QLog.d("MyVideoVisiblePersonPageView", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      if (paramQQStoryBanInfo != null) {
        this.a.a(paramQQStoryBanInfo.b);
      }
    }
    else {
      this.a.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.MyVideoVisiblePersonPageView.4
 * JD-Core Version:    0.7.0.1
 */