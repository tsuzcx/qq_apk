package com.tencent.mobileqq.ark;

import alri;
import alrk;
import com.tencent.common.app.AppInterface;
import com.tencent.wordsegment.WordSegment;

public final class ArkAiDictMgr$3
  implements Runnable
{
  public ArkAiDictMgr$3(AppInterface paramAppInterface, alrk paramalrk, String paramString) {}
  
  public void run()
  {
    alri.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    if (alri.a())
    {
      this.jdField_a_of_type_Alrk.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Alrk.jdField_a_of_type_ArrayOfJavaLangString = WordSegment.segment(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiDictMgr.3
 * JD-Core Version:    0.7.0.1
 */