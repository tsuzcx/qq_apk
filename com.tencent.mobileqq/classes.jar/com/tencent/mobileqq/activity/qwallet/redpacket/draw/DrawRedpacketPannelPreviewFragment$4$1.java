package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import algt;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
import anzj;
import com.tencent.qphone.base.util.QLog;
import zps;

public class DrawRedpacketPannelPreviewFragment$4$1
  implements Runnable
{
  public DrawRedpacketPannelPreviewFragment$4$1(algt paramalgt, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Algt.a.getActivity() == null) || (this.jdField_a_of_type_Algt.a.getActivity().isFinishing())) {}
    for (;;)
    {
      return;
      DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_Algt.a, this.jdField_a_of_type_Boolean);
      DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_Algt.a);
      if (QLog.isColorLevel()) {
        QLog.d(DrawRedpacketPannelPreviewFragment.a, 2, "---onRecog---" + this.jdField_a_of_type_Boolean);
      }
      if (DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_Algt.a))
      {
        DrawRedpacketPannelPreviewFragment.d(this.jdField_a_of_type_Algt.a).setTextColor(Color.parseColor("#00D9B5"));
        DrawRedpacketPannelPreviewFragment.d(this.jdField_a_of_type_Algt.a).setCompoundDrawablesWithIntrinsicBounds(2130847272, 0, 0, 0);
        DrawRedpacketPannelPreviewFragment.d(this.jdField_a_of_type_Algt.a).setCompoundDrawablePadding(zps.a(this.jdField_a_of_type_Algt.a.getActivity(), 5.0F));
        DrawRedpacketPannelPreviewFragment.d(this.jdField_a_of_type_Algt.a).setText(anzj.a(2131702444));
      }
      while (DrawRedpacketPannelPreviewFragment.b(this.jdField_a_of_type_Algt.a))
      {
        DrawRedpacketPannelPreviewFragment.b(this.jdField_a_of_type_Algt.a);
        return;
        DrawRedpacketPannelPreviewFragment.d(this.jdField_a_of_type_Algt.a).setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        if ((DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_Algt.a) != null) && (DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_Algt.a).a(false, false) == 0)) {
          DrawRedpacketPannelPreviewFragment.d(this.jdField_a_of_type_Algt.a).setText("......");
        } else {
          DrawRedpacketPannelPreviewFragment.d(this.jdField_a_of_type_Algt.a).setText(anzj.a(2131702434));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawRedpacketPannelPreviewFragment.4.1
 * JD-Core Version:    0.7.0.1
 */