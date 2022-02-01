package com.tencent.mobileqq.activity.aio.item;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.preload.PlayingListPreloader.OnVideoDownloadListener;

public class QQStoryItemBuilder$AIOStoryDownloadListener
  implements PlayingListPreloader.OnVideoDownloadListener
{
  QQStoryItemBuilder.QQStoryMsgHolder b;
  long c;
  String d;
  
  public void a(QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder, String paramString, long paramLong)
  {
    this.b = paramQQStoryMsgHolder;
    this.c = paramLong;
    this.d = paramString;
  }
  
  public void a(String paramString1, String paramString2, int paramInt) {}
  
  public void a(String paramString1, String paramString2, ErrorMessage paramErrorMessage, int paramInt) {}
  
  public void b(String paramString1, String paramString2, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder.AIOStoryDownloadListener
 * JD-Core Version:    0.7.0.1
 */