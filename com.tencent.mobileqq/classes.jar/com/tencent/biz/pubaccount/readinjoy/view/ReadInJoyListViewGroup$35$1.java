package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import oxb;
import rqi;
import rtm;

public class ReadInJoyListViewGroup$35$1
  implements Runnable
{
  public ReadInJoyListViewGroup$35$1(rtm paramrtm, PBRepeatMessageField paramPBRepeatMessageField, PBStringField paramPBStringField) {}
  
  public void run()
  {
    ReadInJoyListViewGroup.a(this.jdField_a_of_type_Rtm.a);
    int i = ReadInJoyListViewGroup.a(this.jdField_a_of_type_Rtm.a).getCount();
    if (this.jdField_a_of_type_Rtm.b < i)
    {
      Object localObject = ReadInJoyListViewGroup.a(this.jdField_a_of_type_Rtm.a).getItem(this.jdField_a_of_type_Rtm.b);
      if ((localObject instanceof ArticleInfo))
      {
        localObject = (ArticleInfo)localObject;
        ((ArticleInfo)localObject).setSearchWordInfo(this.jdField_a_of_type_Rtm.a.getContext().getString(2131693818), this.jdField_a_of_type_ComTencentMobileqqPbPBRepeatMessageField, this.jdField_a_of_type_ComTencentMobileqqPbPBStringField);
        ((ArticleInfo)localObject).invalidateProteusTemplateBean();
      }
    }
    oxb.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup.35.1
 * JD-Core Version:    0.7.0.1
 */