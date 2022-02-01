package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.widget.TextView;
import nzj;
import tpp;
import tpx;
import tqt;
import tse;
import tsg;

public class ReadInJoyAdDownloadView$2$1
  implements Runnable
{
  public ReadInJoyAdDownloadView$2$1(tsg paramtsg, boolean paramBoolean) {}
  
  public void run()
  {
    tpx.a("ReadInJoyAdDownloadView", "updateAppStyle_0 -> isPkgExist : " + this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_Boolean)
    {
      if (tpp.a(tse.a(this.jdField_a_of_type_Tsg.a)))
      {
        this.jdField_a_of_type_Tsg.a.jdField_a_of_type_AndroidWidgetTextView.setText("安装");
        return;
      }
      this.jdField_a_of_type_Tsg.a.jdField_a_of_type_AndroidWidgetTextView.setText("立即安装");
      return;
    }
    nzj localnzj = this.jdField_a_of_type_Tsg.a.a();
    if ((tse.a(this.jdField_a_of_type_Tsg.a)) && (tse.b(this.jdField_a_of_type_Tsg.a)) && (tse.a(this.jdField_a_of_type_Tsg.a, localnzj)))
    {
      localnzj.b(this.jdField_a_of_type_Tsg.a.jdField_a_of_type_Tqt, this.jdField_a_of_type_Tsg.a.jdField_a_of_type_Tqt.a);
      return;
    }
    this.jdField_a_of_type_Tsg.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdDownloadView.2.1
 * JD-Core Version:    0.7.0.1
 */