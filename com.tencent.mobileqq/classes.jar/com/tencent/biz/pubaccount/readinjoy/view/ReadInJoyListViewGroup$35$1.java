package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import pfd;
import sek;
import sig;

public class ReadInJoyListViewGroup$35$1
  implements Runnable
{
  public ReadInJoyListViewGroup$35$1(sig paramsig, PBRepeatMessageField paramPBRepeatMessageField, PBStringField paramPBStringField) {}
  
  public void run()
  {
    ReadInJoyListViewGroup.a(this.jdField_a_of_type_Sig.a);
    int i = ReadInJoyListViewGroup.a(this.jdField_a_of_type_Sig.a).getCount();
    if (this.jdField_a_of_type_Sig.b < i)
    {
      Object localObject = ReadInJoyListViewGroup.a(this.jdField_a_of_type_Sig.a).getItem(this.jdField_a_of_type_Sig.b);
      if ((localObject instanceof ArticleInfo))
      {
        localObject = (ArticleInfo)localObject;
        ((ArticleInfo)localObject).setSearchWordInfo(this.jdField_a_of_type_Sig.a.getContext().getString(2131693173), this.jdField_a_of_type_ComTencentMobileqqPbPBRepeatMessageField, this.jdField_a_of_type_ComTencentMobileqqPbPBStringField);
        ((ArticleInfo)localObject).invalidateProteusTemplateBean();
      }
    }
    pfd.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup.35.1
 * JD-Core Version:    0.7.0.1
 */