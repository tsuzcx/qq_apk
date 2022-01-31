package com.tencent.mobileqq.ark;

import anmj;
import anml;
import com.tencent.common.app.AppInterface;
import com.tencent.wordsegment.WordSegment;

public final class ArkAiDictMgr$3
  implements Runnable
{
  public ArkAiDictMgr$3(AppInterface paramAppInterface, anml paramanml, String paramString) {}
  
  public void run()
  {
    anmj.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    if (anmj.a())
    {
      this.jdField_a_of_type_Anml.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Anml.jdField_a_of_type_ArrayOfJavaLangString = WordSegment.segment(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiDictMgr.3
 * JD-Core Version:    0.7.0.1
 */