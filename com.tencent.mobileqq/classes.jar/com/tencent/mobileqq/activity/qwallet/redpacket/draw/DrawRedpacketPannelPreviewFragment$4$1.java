package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import aheq;
import ajya;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import vzl;

public class DrawRedpacketPannelPreviewFragment$4$1
  implements Runnable
{
  public DrawRedpacketPannelPreviewFragment$4$1(aheq paramaheq, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Aheq.a.getActivity() == null) || (this.jdField_a_of_type_Aheq.a.getActivity().isFinishing())) {}
    for (;;)
    {
      return;
      DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_Aheq.a, this.jdField_a_of_type_Boolean);
      DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_Aheq.a);
      if (QLog.isColorLevel()) {
        QLog.d(DrawRedpacketPannelPreviewFragment.a, 2, "---onRecog---" + this.jdField_a_of_type_Boolean);
      }
      if (DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_Aheq.a))
      {
        DrawRedpacketPannelPreviewFragment.c(this.jdField_a_of_type_Aheq.a).setTextColor(Color.parseColor("#00D9B5"));
        DrawRedpacketPannelPreviewFragment.c(this.jdField_a_of_type_Aheq.a).setCompoundDrawablesWithIntrinsicBounds(2130846353, 0, 0, 0);
        DrawRedpacketPannelPreviewFragment.c(this.jdField_a_of_type_Aheq.a).setCompoundDrawablePadding(vzl.a(this.jdField_a_of_type_Aheq.a.getActivity(), 5.0F));
        DrawRedpacketPannelPreviewFragment.c(this.jdField_a_of_type_Aheq.a).setText(ajya.a(2131703556));
      }
      while (DrawRedpacketPannelPreviewFragment.b(this.jdField_a_of_type_Aheq.a))
      {
        DrawRedpacketPannelPreviewFragment.b(this.jdField_a_of_type_Aheq.a);
        return;
        DrawRedpacketPannelPreviewFragment.c(this.jdField_a_of_type_Aheq.a).setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        if ((DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_Aheq.a) != null) && (DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_Aheq.a).a(false, false) == 0)) {
          DrawRedpacketPannelPreviewFragment.c(this.jdField_a_of_type_Aheq.a).setText("......");
        } else {
          DrawRedpacketPannelPreviewFragment.c(this.jdField_a_of_type_Aheq.a).setText(ajya.a(2131703546));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawRedpacketPannelPreviewFragment.4.1
 * JD-Core Version:    0.7.0.1
 */