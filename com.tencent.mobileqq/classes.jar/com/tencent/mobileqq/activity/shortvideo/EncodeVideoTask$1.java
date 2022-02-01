package com.tencent.mobileqq.activity.shortvideo;

import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper.VideoCompositeCallBack;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.qphone.base.util.QLog;

class EncodeVideoTask$1
  implements VideoCompositeHelper.VideoCompositeCallBack
{
  EncodeVideoTask$1(EncodeVideoTask paramEncodeVideoTask, PublishVideoEntry paramPublishVideoEntry, String paramString, long paramLong) {}
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (EncodeVideoTask.a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask)) {}
    for (int i = -24;; i = paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EncodeVideoTask", 2, "onVideoCompositeFinish isCancel:" + EncodeVideoTask.a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask) + ", errCode:" + paramInt);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask.a = true;
      EncodeVideoTask.a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask).a(i, paramString1, this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.1
 * JD-Core Version:    0.7.0.1
 */