package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok;

import android.content.Context;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.plugin.PluginBaseActivity;
import pne;
import pnh;
import pnz;
import poa;
import szd;

public class RIJDislikeAnimation$1$1
  implements Runnable
{
  public RIJDislikeAnimation$1$1(poa parampoa) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_Pnz.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    if ((this.a.jdField_a_of_type_Pnz.a.a().a() instanceof BaseActivity)) {
      QQToast.a(this.a.jdField_a_of_type_Pnz.a.a().a(), -1, this.a.jdField_a_of_type_Pnz.a.a().a().getString(2131699166), 0).b(((BaseActivity)this.a.jdField_a_of_type_Pnz.a.a().a()).getTitleBarHeight());
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Pnz.a.a().a().a(this.a.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.a.jdField_a_of_type_JavaUtilArrayList);
      return;
      if ((this.a.jdField_a_of_type_Pnz.a.a().a() instanceof PluginBaseActivity)) {
        QQToast.a(this.a.jdField_a_of_type_Pnz.a.a().a(), -1, this.a.jdField_a_of_type_Pnz.a.a().a().getString(2131699166), 0).b(((PluginBaseActivity)this.a.jdField_a_of_type_Pnz.a.a().a()).g());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJDislikeAnimation.1.1
 * JD-Core Version:    0.7.0.1
 */