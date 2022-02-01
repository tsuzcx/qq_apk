package com.tencent.biz.pubaccount.readinjoy.comment.data;

import com.tencent.qphone.base.util.QLog;
import java.util.List;
import ozw;
import pcq;
import pcs;
import pct;

public class ReadInJoyCommentPBModule$11
  implements Runnable
{
  public ReadInJoyCommentPBModule$11(pcq parampcq, int paramInt, pcs parampcs, String paramString, pct parampct) {}
  
  public void run()
  {
    if ("handleSubCommentList | retCode " + this.jdField_a_of_type_Int + " | hasNextPage " + this.jdField_a_of_type_Pcs.jdField_a_of_type_Boolean + " | pageCookie " + this.jdField_a_of_type_Pcs.jdField_a_of_type_JavaLangString + "| subCommentListSize " + this.jdField_a_of_type_Pcs.b != null) {}
    for (int i = this.jdField_a_of_type_Pcs.b.size();; i = 0)
    {
      QLog.d("ReadInJoyCommentPBModule", 2, new Object[] { Integer.valueOf(i) });
      if (pcq.a(this.this$0) != null) {
        pcq.a(this.this$0).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Pcs, this.jdField_a_of_type_Pct);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentPBModule.11
 * JD-Core Version:    0.7.0.1
 */