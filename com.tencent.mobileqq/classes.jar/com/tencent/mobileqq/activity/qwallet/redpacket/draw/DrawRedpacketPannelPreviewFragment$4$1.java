package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import ajdj;
import alud;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import xsm;

public class DrawRedpacketPannelPreviewFragment$4$1
  implements Runnable
{
  public DrawRedpacketPannelPreviewFragment$4$1(ajdj paramajdj, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Ajdj.a.getActivity() == null) || (this.jdField_a_of_type_Ajdj.a.getActivity().isFinishing())) {}
    for (;;)
    {
      return;
      DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_Ajdj.a, this.jdField_a_of_type_Boolean);
      DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_Ajdj.a);
      if (QLog.isColorLevel()) {
        QLog.d(DrawRedpacketPannelPreviewFragment.a, 2, "---onRecog---" + this.jdField_a_of_type_Boolean);
      }
      if (DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_Ajdj.a))
      {
        DrawRedpacketPannelPreviewFragment.c(this.jdField_a_of_type_Ajdj.a).setTextColor(Color.parseColor("#00D9B5"));
        DrawRedpacketPannelPreviewFragment.c(this.jdField_a_of_type_Ajdj.a).setCompoundDrawablesWithIntrinsicBounds(2130846805, 0, 0, 0);
        DrawRedpacketPannelPreviewFragment.c(this.jdField_a_of_type_Ajdj.a).setCompoundDrawablePadding(xsm.a(this.jdField_a_of_type_Ajdj.a.getActivity(), 5.0F));
        DrawRedpacketPannelPreviewFragment.c(this.jdField_a_of_type_Ajdj.a).setText(alud.a(2131703940));
      }
      while (DrawRedpacketPannelPreviewFragment.b(this.jdField_a_of_type_Ajdj.a))
      {
        DrawRedpacketPannelPreviewFragment.b(this.jdField_a_of_type_Ajdj.a);
        return;
        DrawRedpacketPannelPreviewFragment.c(this.jdField_a_of_type_Ajdj.a).setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        if ((DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_Ajdj.a) != null) && (DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_Ajdj.a).a(false, false) == 0)) {
          DrawRedpacketPannelPreviewFragment.c(this.jdField_a_of_type_Ajdj.a).setText("......");
        } else {
          DrawRedpacketPannelPreviewFragment.c(this.jdField_a_of_type_Ajdj.a).setText(alud.a(2131703930));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawRedpacketPannelPreviewFragment.4.1
 * JD-Core Version:    0.7.0.1
 */