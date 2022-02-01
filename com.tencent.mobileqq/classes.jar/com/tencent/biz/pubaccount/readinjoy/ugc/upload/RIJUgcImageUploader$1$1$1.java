package com.tencent.biz.pubaccount.readinjoy.ugc.upload;

import com.tencent.qphone.base.util.QLog;

class RIJUgcImageUploader$1$1$1
  implements Runnable
{
  RIJUgcImageUploader$1$1$1(RIJUgcImageUploader.1.1 param1, int paramInt, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      QLog.i(RIJUgcImageUploader.jdField_a_of_type_JavaLangString, 1, "uploadImage success");
      RIJUgcImageUploader.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcUploadRIJUgcImageUploader$1$1.a.this$0).a(this.jdField_a_of_type_JavaLangString);
      return;
    }
    QLog.i(RIJUgcImageUploader.jdField_a_of_type_JavaLangString, 1, "uploadImage failed, errCode=" + this.jdField_a_of_type_Int);
    RIJUgcImageUploader.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcUploadRIJUgcImageUploader$1$1.a.this$0).a(this.jdField_a_of_type_Int, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.upload.RIJUgcImageUploader.1.1.1
 * JD-Core Version:    0.7.0.1
 */