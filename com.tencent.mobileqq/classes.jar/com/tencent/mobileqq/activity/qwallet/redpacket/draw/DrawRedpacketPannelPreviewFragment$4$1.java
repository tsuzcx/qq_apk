package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import akem;
import amtj;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.qphone.base.util.QLog;

public class DrawRedpacketPannelPreviewFragment$4$1
  implements Runnable
{
  public DrawRedpacketPannelPreviewFragment$4$1(akem paramakem, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Akem.a.getActivity() == null) || (this.jdField_a_of_type_Akem.a.getActivity().isFinishing())) {}
    for (;;)
    {
      return;
      DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_Akem.a, this.jdField_a_of_type_Boolean);
      DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_Akem.a);
      if (QLog.isColorLevel()) {
        QLog.d(DrawRedpacketPannelPreviewFragment.a, 2, "---onRecog---" + this.jdField_a_of_type_Boolean);
      }
      if (DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_Akem.a))
      {
        DrawRedpacketPannelPreviewFragment.d(this.jdField_a_of_type_Akem.a).setTextColor(Color.parseColor("#00D9B5"));
        DrawRedpacketPannelPreviewFragment.d(this.jdField_a_of_type_Akem.a).setCompoundDrawablesWithIntrinsicBounds(2130847180, 0, 0, 0);
        DrawRedpacketPannelPreviewFragment.d(this.jdField_a_of_type_Akem.a).setCompoundDrawablePadding(UIUtils.dip2px(this.jdField_a_of_type_Akem.a.getActivity(), 5.0F));
        DrawRedpacketPannelPreviewFragment.d(this.jdField_a_of_type_Akem.a).setText(amtj.a(2131702679));
      }
      while (DrawRedpacketPannelPreviewFragment.b(this.jdField_a_of_type_Akem.a))
      {
        DrawRedpacketPannelPreviewFragment.b(this.jdField_a_of_type_Akem.a);
        return;
        DrawRedpacketPannelPreviewFragment.d(this.jdField_a_of_type_Akem.a).setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        if ((DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_Akem.a) != null) && (DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_Akem.a).a(false, false) == 0)) {
          DrawRedpacketPannelPreviewFragment.d(this.jdField_a_of_type_Akem.a).setText("......");
        } else {
          DrawRedpacketPannelPreviewFragment.d(this.jdField_a_of_type_Akem.a).setText(amtj.a(2131702669));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawRedpacketPannelPreviewFragment.4.1
 * JD-Core Version:    0.7.0.1
 */