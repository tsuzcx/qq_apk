package com.tencent.biz.pubaccount.readinjoy.model.handler;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import qis;
import rpa;

public class RIJDislikeArticleHandler$1
  implements Runnable
{
  public RIJDislikeArticleHandler$1(qis paramqis, int paramInt, List paramList) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    this.this$0.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        rpa localrpa = (rpa)((Iterator)localObject).next();
        if (localrpa.jdField_a_of_type_Int != 0) {
          QLog.e("RIJDislikeArticleHandler", 2, "dislike fail ,articleID : " + localrpa.jdField_a_of_type_Long + ", failCode : " + localrpa.jdField_a_of_type_Int + ",fialMessage : " + localrpa.jdField_a_of_type_JavaLangString);
        }
      }
    }
    if (this.this$0.jdField_a_of_type_Int == 0)
    {
      localObject = new StringBuilder().append("dislike upload successful ! count : ");
      if (this.jdField_a_of_type_JavaUtilList == null) {
        break label175;
      }
    }
    label175:
    for (int i = this.jdField_a_of_type_JavaUtilList.size();; i = 0)
    {
      QLog.d("RIJDislikeArticleHandler", 2, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.handler.RIJDislikeArticleHandler.1
 * JD-Core Version:    0.7.0.1
 */