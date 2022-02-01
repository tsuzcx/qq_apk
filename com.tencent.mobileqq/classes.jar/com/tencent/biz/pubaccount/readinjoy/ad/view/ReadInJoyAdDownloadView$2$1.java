package com.tencent.biz.pubaccount.readinjoy.ad.view;

import android.widget.TextView;
import nxp;
import opz;
import oqh;
import orb;
import osm;
import oso;

public class ReadInJoyAdDownloadView$2$1
  implements Runnable
{
  public ReadInJoyAdDownloadView$2$1(oso paramoso, boolean paramBoolean) {}
  
  public void run()
  {
    oqh.a("ReadInJoyAdDownloadView", "updateAppStyle_0 -> isPkgExist : " + this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_Boolean)
    {
      if (opz.a(osm.a(this.jdField_a_of_type_Oso.a)))
      {
        this.jdField_a_of_type_Oso.a.jdField_a_of_type_AndroidWidgetTextView.setText("安装");
        return;
      }
      this.jdField_a_of_type_Oso.a.jdField_a_of_type_AndroidWidgetTextView.setText("立即安装");
      return;
    }
    nxp localnxp = this.jdField_a_of_type_Oso.a.a();
    if ((osm.a(this.jdField_a_of_type_Oso.a)) && (osm.b(this.jdField_a_of_type_Oso.a)) && (osm.a(this.jdField_a_of_type_Oso.a, localnxp)))
    {
      localnxp.b(this.jdField_a_of_type_Oso.a.jdField_a_of_type_Orb, this.jdField_a_of_type_Oso.a.jdField_a_of_type_Orb.a);
      return;
    }
    this.jdField_a_of_type_Oso.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyAdDownloadView.2.1
 * JD-Core Version:    0.7.0.1
 */