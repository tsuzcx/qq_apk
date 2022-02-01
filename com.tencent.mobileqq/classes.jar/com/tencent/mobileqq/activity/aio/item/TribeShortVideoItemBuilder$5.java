package com.tencent.mobileqq.activity.aio.item;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;

class TribeShortVideoItemBuilder$5
  extends TribeShortVideoItemBuilder.AIOShortVideoDownloadListener
{
  TribeShortVideoItemBuilder$5(TribeShortVideoItemBuilder paramTribeShortVideoItemBuilder) {}
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("get video download finish,vid=");
      paramString2.append(paramString1);
      QLog.i("TribeShortVideoItemBuilder", 2, paramString2.toString());
    }
    if (!paramString1.equals(this.jdField_a_of_type_JavaLangString)) {}
  }
  
  public void a(String paramString1, String paramString2, ErrorMessage paramErrorMessage, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("Download video failed,vid=");
      paramString2.append(paramString1);
      QLog.e("TribeShortVideoItemBuilder", 2, paramString2.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoMsgHolder, this.jdField_a_of_type_Long);
  }
  
  public void b(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("Download video onPause,vid=");
      paramString2.append(paramString1);
      QLog.e("TribeShortVideoItemBuilder", 2, paramString2.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoMsgHolder, this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TribeShortVideoItemBuilder.5
 * JD-Core Version:    0.7.0.1
 */