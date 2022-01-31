package com.tencent.mobileqq.activity.aio.item;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.preload.PlayingListPreloader.OnVideoDownloadListener;

public class QQStoryItemBuilder$AIOStoryDownloadListener
  implements PlayingListPreloader.OnVideoDownloadListener
{
  public long a;
  public QQStoryItemBuilder.QQStoryMsgHolder a;
  public String a;
  
  public void a(QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder, String paramString, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$QQStoryMsgHolder = paramQQStoryMsgHolder;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString1, String paramString2, int paramInt) {}
  
  public void a(String paramString1, String paramString2, ErrorMessage paramErrorMessage, int paramInt) {}
  
  public void b(String paramString1, String paramString2, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder.AIOStoryDownloadListener
 * JD-Core Version:    0.7.0.1
 */