package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import ohb;
import qod;
import qrj;

public class ReadInJoyListViewGroup$36$1
  implements Runnable
{
  public ReadInJoyListViewGroup$36$1(qrj paramqrj, PBRepeatMessageField paramPBRepeatMessageField, PBStringField paramPBStringField) {}
  
  public void run()
  {
    ReadInJoyListViewGroup.a(this.jdField_a_of_type_Qrj.a);
    int i = ReadInJoyListViewGroup.a(this.jdField_a_of_type_Qrj.a).getCount();
    if (this.jdField_a_of_type_Qrj.b < i)
    {
      Object localObject = ReadInJoyListViewGroup.a(this.jdField_a_of_type_Qrj.a).getItem(this.jdField_a_of_type_Qrj.b);
      if ((localObject instanceof ArticleInfo))
      {
        localObject = (ArticleInfo)localObject;
        ((ArticleInfo)localObject).setSearchWordInfo(this.jdField_a_of_type_Qrj.a.getContext().getString(2131628058), this.jdField_a_of_type_ComTencentMobileqqPbPBRepeatMessageField, this.jdField_a_of_type_ComTencentMobileqqPbPBStringField);
        ((ArticleInfo)localObject).invalidateProteusTemplateBean();
      }
    }
    ohb.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup.36.1
 * JD-Core Version:    0.7.0.1
 */