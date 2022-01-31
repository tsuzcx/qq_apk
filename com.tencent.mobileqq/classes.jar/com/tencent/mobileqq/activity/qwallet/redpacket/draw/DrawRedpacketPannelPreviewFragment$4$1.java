package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import ahes;
import ajyc;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import vzo;

public class DrawRedpacketPannelPreviewFragment$4$1
  implements Runnable
{
  public DrawRedpacketPannelPreviewFragment$4$1(ahes paramahes, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Ahes.a.getActivity() == null) || (this.jdField_a_of_type_Ahes.a.getActivity().isFinishing())) {}
    for (;;)
    {
      return;
      DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_Ahes.a, this.jdField_a_of_type_Boolean);
      DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_Ahes.a);
      if (QLog.isColorLevel()) {
        QLog.d(DrawRedpacketPannelPreviewFragment.a, 2, "---onRecog---" + this.jdField_a_of_type_Boolean);
      }
      if (DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_Ahes.a))
      {
        DrawRedpacketPannelPreviewFragment.c(this.jdField_a_of_type_Ahes.a).setTextColor(Color.parseColor("#00D9B5"));
        DrawRedpacketPannelPreviewFragment.c(this.jdField_a_of_type_Ahes.a).setCompoundDrawablesWithIntrinsicBounds(2130846347, 0, 0, 0);
        DrawRedpacketPannelPreviewFragment.c(this.jdField_a_of_type_Ahes.a).setCompoundDrawablePadding(vzo.a(this.jdField_a_of_type_Ahes.a.getActivity(), 5.0F));
        DrawRedpacketPannelPreviewFragment.c(this.jdField_a_of_type_Ahes.a).setText(ajyc.a(2131703545));
      }
      while (DrawRedpacketPannelPreviewFragment.b(this.jdField_a_of_type_Ahes.a))
      {
        DrawRedpacketPannelPreviewFragment.b(this.jdField_a_of_type_Ahes.a);
        return;
        DrawRedpacketPannelPreviewFragment.c(this.jdField_a_of_type_Ahes.a).setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        if ((DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_Ahes.a) != null) && (DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_Ahes.a).a(false, false) == 0)) {
          DrawRedpacketPannelPreviewFragment.c(this.jdField_a_of_type_Ahes.a).setText("......");
        } else {
          DrawRedpacketPannelPreviewFragment.c(this.jdField_a_of_type_Ahes.a).setText(ajyc.a(2131703535));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawRedpacketPannelPreviewFragment.4.1
 * JD-Core Version:    0.7.0.1
 */