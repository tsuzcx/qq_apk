package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import ozo;
import qau;

public class ArticleInfoModule$11
  implements Runnable
{
  public ArticleInfoModule$11(ozo paramozo, int paramInt, List paramList) {}
  
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
        qau localqau = (qau)((Iterator)localObject).next();
        if (localqau.jdField_a_of_type_Int != 0) {
          QLog.e("ArticleInfoModule", 2, "dislike fail ,articleID : " + localqau.jdField_a_of_type_Long + ", failCode : " + localqau.jdField_a_of_type_Int + ",fialMessage : " + localqau.jdField_a_of_type_JavaLangString);
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
      QLog.d("ArticleInfoModule", 2, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.11
 * JD-Core Version:    0.7.0.1
 */