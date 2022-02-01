package com.tencent.biz.pubaccount.readinjoy.ugc.upload;

import com.tencent.qphone.base.util.QLog;
import sdm;
import sdq;
import sdr;

public class RIJUgcImageUploader$1$1$1
  implements Runnable
{
  public RIJUgcImageUploader$1$1$1(sdr paramsdr, int paramInt, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      QLog.i(sdq.jdField_a_of_type_JavaLangString, 1, "uploadImage success");
      sdq.a(this.jdField_a_of_type_Sdr.a.this$0).a(this.jdField_a_of_type_JavaLangString);
      return;
    }
    QLog.i(sdq.jdField_a_of_type_JavaLangString, 1, "uploadImage failed, errCode=" + this.jdField_a_of_type_Int);
    sdq.a(this.jdField_a_of_type_Sdr.a.this$0).a(this.jdField_a_of_type_Int, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.upload.RIJUgcImageUploader.1.1.1
 * JD-Core Version:    0.7.0.1
 */