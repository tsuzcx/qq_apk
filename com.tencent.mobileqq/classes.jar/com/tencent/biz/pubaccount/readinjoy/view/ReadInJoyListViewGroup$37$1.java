package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import osm;
import rao;
import rdv;

public class ReadInJoyListViewGroup$37$1
  implements Runnable
{
  public ReadInJoyListViewGroup$37$1(rdv paramrdv, PBRepeatMessageField paramPBRepeatMessageField, PBStringField paramPBStringField) {}
  
  public void run()
  {
    ReadInJoyListViewGroup.a(this.jdField_a_of_type_Rdv.a);
    int i = ReadInJoyListViewGroup.a(this.jdField_a_of_type_Rdv.a).getCount();
    if (this.jdField_a_of_type_Rdv.b < i)
    {
      Object localObject = ReadInJoyListViewGroup.a(this.jdField_a_of_type_Rdv.a).getItem(this.jdField_a_of_type_Rdv.b);
      if ((localObject instanceof ArticleInfo))
      {
        localObject = (ArticleInfo)localObject;
        ((ArticleInfo)localObject).setSearchWordInfo(this.jdField_a_of_type_Rdv.a.getContext().getString(2131693699), this.jdField_a_of_type_ComTencentMobileqqPbPBRepeatMessageField, this.jdField_a_of_type_ComTencentMobileqqPbPBStringField);
        ((ArticleInfo)localObject).invalidateProteusTemplateBean();
      }
    }
    osm.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup.37.1
 * JD-Core Version:    0.7.0.1
 */