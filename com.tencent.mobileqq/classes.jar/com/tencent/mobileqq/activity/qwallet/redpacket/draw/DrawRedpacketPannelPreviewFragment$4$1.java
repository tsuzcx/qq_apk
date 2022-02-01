package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import akve;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
import anni;
import com.tencent.qphone.base.util.QLog;
import zlx;

public class DrawRedpacketPannelPreviewFragment$4$1
  implements Runnable
{
  public DrawRedpacketPannelPreviewFragment$4$1(akve paramakve, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Akve.a.getActivity() == null) || (this.jdField_a_of_type_Akve.a.getActivity().isFinishing())) {}
    for (;;)
    {
      return;
      DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_Akve.a, this.jdField_a_of_type_Boolean);
      DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_Akve.a);
      if (QLog.isColorLevel()) {
        QLog.d(DrawRedpacketPannelPreviewFragment.a, 2, "---onRecog---" + this.jdField_a_of_type_Boolean);
      }
      if (DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_Akve.a))
      {
        DrawRedpacketPannelPreviewFragment.d(this.jdField_a_of_type_Akve.a).setTextColor(Color.parseColor("#00D9B5"));
        DrawRedpacketPannelPreviewFragment.d(this.jdField_a_of_type_Akve.a).setCompoundDrawablesWithIntrinsicBounds(2130847255, 0, 0, 0);
        DrawRedpacketPannelPreviewFragment.d(this.jdField_a_of_type_Akve.a).setCompoundDrawablePadding(zlx.a(this.jdField_a_of_type_Akve.a.getActivity(), 5.0F));
        DrawRedpacketPannelPreviewFragment.d(this.jdField_a_of_type_Akve.a).setText(anni.a(2131702337));
      }
      while (DrawRedpacketPannelPreviewFragment.b(this.jdField_a_of_type_Akve.a))
      {
        DrawRedpacketPannelPreviewFragment.b(this.jdField_a_of_type_Akve.a);
        return;
        DrawRedpacketPannelPreviewFragment.d(this.jdField_a_of_type_Akve.a).setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        if ((DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_Akve.a) != null) && (DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_Akve.a).a(false, false) == 0)) {
          DrawRedpacketPannelPreviewFragment.d(this.jdField_a_of_type_Akve.a).setText("......");
        } else {
          DrawRedpacketPannelPreviewFragment.d(this.jdField_a_of_type_Akve.a).setText(anni.a(2131702327));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawRedpacketPannelPreviewFragment.4.1
 * JD-Core Version:    0.7.0.1
 */