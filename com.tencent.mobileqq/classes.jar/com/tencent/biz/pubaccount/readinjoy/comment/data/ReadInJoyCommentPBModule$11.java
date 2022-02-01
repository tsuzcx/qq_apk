package com.tencent.biz.pubaccount.readinjoy.comment.data;

import com.tencent.qphone.base.util.QLog;
import java.util.List;
import osl;
import ovh;
import ovk;
import ovl;

public class ReadInJoyCommentPBModule$11
  implements Runnable
{
  public ReadInJoyCommentPBModule$11(ovh paramovh, int paramInt, ovk paramovk, String paramString, ovl paramovl) {}
  
  public void run()
  {
    if ("handleSubCommentList | retCode " + this.jdField_a_of_type_Int + " | hasNextPage " + this.jdField_a_of_type_Ovk.jdField_a_of_type_Boolean + " | pageCookie " + this.jdField_a_of_type_Ovk.jdField_a_of_type_JavaLangString + "| subCommentListSize " + this.jdField_a_of_type_Ovk.b != null) {}
    for (int i = this.jdField_a_of_type_Ovk.b.size();; i = 0)
    {
      QLog.d("ReadInJoyCommentPBModule", 2, new Object[] { Integer.valueOf(i) });
      if (ovh.a(this.this$0) != null) {
        ovh.a(this.this$0).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Ovk, this.jdField_a_of_type_Ovl);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentPBModule.11
 * JD-Core Version:    0.7.0.1
 */