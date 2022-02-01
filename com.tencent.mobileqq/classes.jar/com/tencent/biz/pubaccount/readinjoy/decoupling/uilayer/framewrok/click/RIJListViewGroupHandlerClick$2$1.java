package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.click;

import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import ppo;
import ppp;
import ppq;
import pvm;
import szd;

public class RIJListViewGroupHandlerClick$2$1
  implements Runnable
{
  public RIJListViewGroupHandlerClick$2$1(ppp paramppp, PBRepeatMessageField paramPBRepeatMessageField, PBStringField paramPBStringField) {}
  
  public void run()
  {
    ppo.a(this.jdField_a_of_type_Ppp.jdField_a_of_type_Ppo, this.jdField_a_of_type_Ppp.jdField_a_of_type_Ppq);
    int i = this.jdField_a_of_type_Ppp.jdField_a_of_type_Ppq.a().getCount();
    if (this.jdField_a_of_type_Ppp.b < i)
    {
      Object localObject = this.jdField_a_of_type_Ppp.jdField_a_of_type_Ppq.a().getItem(this.jdField_a_of_type_Ppp.b);
      if ((localObject instanceof ArticleInfo))
      {
        localObject = (ArticleInfo)localObject;
        ((ArticleInfo)localObject).setSearchWordInfo(this.jdField_a_of_type_Ppp.jdField_a_of_type_Ppq.a().getString(2131693416), this.jdField_a_of_type_ComTencentMobileqqPbPBRepeatMessageField, this.jdField_a_of_type_ComTencentMobileqqPbPBStringField);
        ((ArticleInfo)localObject).invalidateProteusTemplateBean();
      }
    }
    pvm.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.click.RIJListViewGroupHandlerClick.2.1
 * JD-Core Version:    0.7.0.1
 */