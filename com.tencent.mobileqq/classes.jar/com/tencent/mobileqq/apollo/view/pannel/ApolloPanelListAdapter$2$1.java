package com.tencent.mobileqq.apollo.view.pannel;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import annl;
import anoa;
import anpk;
import anpn;
import com.tencent.qphone.base.util.QLog;

public class ApolloPanelListAdapter$2$1
  implements Runnable
{
  public ApolloPanelListAdapter$2$1(anpn paramanpn) {}
  
  public void run()
  {
    QLog.i("ApolloPanelListAdapter", 4, "setBackgroundDrawable GetFrameCallback ");
    this.a.jdField_a_of_type_Anoa.a.setBackgroundDrawable(this.a.jdField_a_of_type_Annl.a(anpk.a(this.a.jdField_a_of_type_Anpk), anpk.a(this.a.jdField_a_of_type_Anpk).getResources().getDisplayMetrics().density));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanelListAdapter.2.1
 * JD-Core Version:    0.7.0.1
 */