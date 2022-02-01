package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.click;

import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import pgk;
import pgl;
import pgm;
import pkp;
import slt;

public class RIJListViewGroupHandlerClick$2$1
  implements Runnable
{
  public RIJListViewGroupHandlerClick$2$1(pgl parampgl, PBRepeatMessageField paramPBRepeatMessageField, PBStringField paramPBStringField) {}
  
  public void run()
  {
    pgk.a(this.jdField_a_of_type_Pgl.jdField_a_of_type_Pgk, this.jdField_a_of_type_Pgl.jdField_a_of_type_Pgm);
    int i = this.jdField_a_of_type_Pgl.jdField_a_of_type_Pgm.a().getCount();
    if (this.jdField_a_of_type_Pgl.b < i)
    {
      Object localObject = this.jdField_a_of_type_Pgl.jdField_a_of_type_Pgm.a().getItem(this.jdField_a_of_type_Pgl.b);
      if ((localObject instanceof ArticleInfo))
      {
        localObject = (ArticleInfo)localObject;
        ((ArticleInfo)localObject).setSearchWordInfo(this.jdField_a_of_type_Pgl.jdField_a_of_type_Pgm.a().getString(2131693236), this.jdField_a_of_type_ComTencentMobileqqPbPBRepeatMessageField, this.jdField_a_of_type_ComTencentMobileqqPbPBStringField);
        ((ArticleInfo)localObject).invalidateProteusTemplateBean();
      }
    }
    pkp.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.click.RIJListViewGroupHandlerClick.2.1
 * JD-Core Version:    0.7.0.1
 */