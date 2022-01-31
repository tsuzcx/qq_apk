package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import ahew;
import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class DrawRedpacketPannelPreviewFragment$11
  implements Runnable
{
  DrawRedpacketPannelPreviewFragment$11(DrawRedpacketPannelPreviewFragment paramDrawRedpacketPannelPreviewFragment, String paramString1, int paramInt1, String paramString2, int paramInt2) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i(DrawRedpacketPannelPreviewFragment.jdField_a_of_type_JavaLangString, 2, "---sendImageToAio---");
      }
      String str = DrawRedpacketPannelPreviewFragment.a(DrawRedpacketPannelPreviewFragment.a(this.this$0), File.separator + System.currentTimeMillis() + ".png", DrawRedpacketPannelPreviewFragment.a(this.this$0));
      Message localMessage = Message.obtain();
      ahew localahew = new ahew(null);
      localahew.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      localahew.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      localahew.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localahew.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
      localahew.c = str;
      localMessage.obj = localahew;
      localMessage.what = 1001;
      DrawRedpacketPannelPreviewFragment.a(this.this$0).sendMessage(localMessage);
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawRedpacketPannelPreviewFragment.11
 * JD-Core Version:    0.7.0.1
 */