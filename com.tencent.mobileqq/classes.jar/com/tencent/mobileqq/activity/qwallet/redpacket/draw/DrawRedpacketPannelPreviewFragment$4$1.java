package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import agsd;
import ajjy;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import vms;

public class DrawRedpacketPannelPreviewFragment$4$1
  implements Runnable
{
  public DrawRedpacketPannelPreviewFragment$4$1(agsd paramagsd, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Agsd.a.getActivity() == null) || (this.jdField_a_of_type_Agsd.a.getActivity().isFinishing())) {}
    for (;;)
    {
      return;
      DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_Agsd.a, this.jdField_a_of_type_Boolean);
      DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_Agsd.a);
      if (QLog.isColorLevel()) {
        QLog.d(DrawRedpacketPannelPreviewFragment.a, 2, "---onRecog---" + this.jdField_a_of_type_Boolean);
      }
      if (DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_Agsd.a))
      {
        DrawRedpacketPannelPreviewFragment.c(this.jdField_a_of_type_Agsd.a).setTextColor(Color.parseColor("#00D9B5"));
        DrawRedpacketPannelPreviewFragment.c(this.jdField_a_of_type_Agsd.a).setCompoundDrawablesWithIntrinsicBounds(2130846166, 0, 0, 0);
        DrawRedpacketPannelPreviewFragment.c(this.jdField_a_of_type_Agsd.a).setCompoundDrawablePadding(vms.a(this.jdField_a_of_type_Agsd.a.getActivity(), 5.0F));
        DrawRedpacketPannelPreviewFragment.c(this.jdField_a_of_type_Agsd.a).setText(ajjy.a(2131637760));
      }
      while (DrawRedpacketPannelPreviewFragment.b(this.jdField_a_of_type_Agsd.a))
      {
        DrawRedpacketPannelPreviewFragment.b(this.jdField_a_of_type_Agsd.a);
        return;
        DrawRedpacketPannelPreviewFragment.c(this.jdField_a_of_type_Agsd.a).setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        if ((DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_Agsd.a) != null) && (DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_Agsd.a).a(false, false) == 0)) {
          DrawRedpacketPannelPreviewFragment.c(this.jdField_a_of_type_Agsd.a).setText("......");
        } else {
          DrawRedpacketPannelPreviewFragment.c(this.jdField_a_of_type_Agsd.a).setText(ajjy.a(2131637750));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawRedpacketPannelPreviewFragment.4.1
 * JD-Core Version:    0.7.0.1
 */