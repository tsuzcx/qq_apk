package com.tencent.mobileqq.activity.miniaio;

import aijq;
import android.app.Activity;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import bdni;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.qphone.base.util.QLog;

public class MiniPie$4
  implements Runnable
{
  public MiniPie$4(aijq paramaijq) {}
  
  public void run()
  {
    int j = 300;
    int k = this.this$0.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.getHeight();
    int i = k;
    if (k <= 0)
    {
      QLog.e(this.this$0.jdField_a_of_type_JavaLangString, 1, "emoHeight <=0 reset to 196dp");
      i = bdni.a(0);
    }
    k = aijq.a(this.this$0, this.this$0.jdField_a_of_type_AndroidViewViewGroup);
    int m = this.this$0.jdField_a_of_type_AndroidViewViewGroup.getHeight();
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.jdField_a_of_type_JavaLangString, 2, "dialogHeight" + m + " emoh " + i + " dY " + k);
    }
    if (m + k + i > MiniChatConstants.SCREEN_HEIGHT)
    {
      i = MiniChatConstants.SCREEN_HEIGHT - k - i - 2;
      if (i >= 300) {
        break label231;
      }
      i = j;
    }
    label231:
    for (;;)
    {
      WindowManager.LayoutParams localLayoutParams = ((Activity)this.this$0.jdField_a_of_type_AndroidContentContext).getWindow().getAttributes();
      localLayoutParams.height = i;
      ((Activity)this.this$0.jdField_a_of_type_AndroidContentContext).getWindow().setAttributes(localLayoutParams);
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.jdField_a_of_type_JavaLangString, 2, "new dialogHeight" + i);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniPie.4
 * JD-Core Version:    0.7.0.1
 */