package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import aiyu;
import alpo;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import xod;

public class DrawRedpacketPannelPreviewFragment$4$1
  implements Runnable
{
  public DrawRedpacketPannelPreviewFragment$4$1(aiyu paramaiyu, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Aiyu.a.getActivity() == null) || (this.jdField_a_of_type_Aiyu.a.getActivity().isFinishing())) {}
    for (;;)
    {
      return;
      DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_Aiyu.a, this.jdField_a_of_type_Boolean);
      DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_Aiyu.a);
      if (QLog.isColorLevel()) {
        QLog.d(DrawRedpacketPannelPreviewFragment.a, 2, "---onRecog---" + this.jdField_a_of_type_Boolean);
      }
      if (DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_Aiyu.a))
      {
        DrawRedpacketPannelPreviewFragment.c(this.jdField_a_of_type_Aiyu.a).setTextColor(Color.parseColor("#00D9B5"));
        DrawRedpacketPannelPreviewFragment.c(this.jdField_a_of_type_Aiyu.a).setCompoundDrawablesWithIntrinsicBounds(2130846732, 0, 0, 0);
        DrawRedpacketPannelPreviewFragment.c(this.jdField_a_of_type_Aiyu.a).setCompoundDrawablePadding(xod.a(this.jdField_a_of_type_Aiyu.a.getActivity(), 5.0F));
        DrawRedpacketPannelPreviewFragment.c(this.jdField_a_of_type_Aiyu.a).setText(alpo.a(2131703928));
      }
      while (DrawRedpacketPannelPreviewFragment.b(this.jdField_a_of_type_Aiyu.a))
      {
        DrawRedpacketPannelPreviewFragment.b(this.jdField_a_of_type_Aiyu.a);
        return;
        DrawRedpacketPannelPreviewFragment.c(this.jdField_a_of_type_Aiyu.a).setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        if ((DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_Aiyu.a) != null) && (DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_Aiyu.a).a(false, false) == 0)) {
          DrawRedpacketPannelPreviewFragment.c(this.jdField_a_of_type_Aiyu.a).setText("......");
        } else {
          DrawRedpacketPannelPreviewFragment.c(this.jdField_a_of_type_Aiyu.a).setText(alpo.a(2131703918));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawRedpacketPannelPreviewFragment.4.1
 * JD-Core Version:    0.7.0.1
 */