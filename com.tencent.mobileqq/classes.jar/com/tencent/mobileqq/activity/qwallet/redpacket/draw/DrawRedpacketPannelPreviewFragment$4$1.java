package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import alaf;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
import anvx;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.qphone.base.util.QLog;

public class DrawRedpacketPannelPreviewFragment$4$1
  implements Runnable
{
  public DrawRedpacketPannelPreviewFragment$4$1(alaf paramalaf, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Alaf.a.getActivity() == null) || (this.jdField_a_of_type_Alaf.a.getActivity().isFinishing())) {}
    for (;;)
    {
      return;
      DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_Alaf.a, this.jdField_a_of_type_Boolean);
      DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_Alaf.a);
      if (QLog.isColorLevel()) {
        QLog.d(DrawRedpacketPannelPreviewFragment.a, 2, "---onRecog---" + this.jdField_a_of_type_Boolean);
      }
      if (DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_Alaf.a))
      {
        DrawRedpacketPannelPreviewFragment.d(this.jdField_a_of_type_Alaf.a).setTextColor(Color.parseColor("#00D9B5"));
        DrawRedpacketPannelPreviewFragment.d(this.jdField_a_of_type_Alaf.a).setCompoundDrawablesWithIntrinsicBounds(2130847278, 0, 0, 0);
        DrawRedpacketPannelPreviewFragment.d(this.jdField_a_of_type_Alaf.a).setCompoundDrawablePadding(UIUtils.dip2px(this.jdField_a_of_type_Alaf.a.getActivity(), 5.0F));
        DrawRedpacketPannelPreviewFragment.d(this.jdField_a_of_type_Alaf.a).setText(anvx.a(2131703030));
      }
      while (DrawRedpacketPannelPreviewFragment.b(this.jdField_a_of_type_Alaf.a))
      {
        DrawRedpacketPannelPreviewFragment.b(this.jdField_a_of_type_Alaf.a);
        return;
        DrawRedpacketPannelPreviewFragment.d(this.jdField_a_of_type_Alaf.a).setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        if ((DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_Alaf.a) != null) && (DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_Alaf.a).a(false, false) == 0)) {
          DrawRedpacketPannelPreviewFragment.d(this.jdField_a_of_type_Alaf.a).setText("......");
        } else {
          DrawRedpacketPannelPreviewFragment.d(this.jdField_a_of_type_Alaf.a).setText(anvx.a(2131703020));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawRedpacketPannelPreviewFragment.4.1
 * JD-Core Version:    0.7.0.1
 */