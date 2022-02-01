package com.tencent.mobileqq.activity.miniaio;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel.DispatchKeyEventListener;

class MiniPie$8
  implements EmoticonMainPanel.DispatchKeyEventListener
{
  MiniPie$8(MiniPie paramMiniPie) {}
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1) && (this.a.jdField_a_of_type_Boolean))
    {
      this.a.jdField_a_of_type_AndroidViewWindowManager.removeView(this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel);
      this.a.jdField_a_of_type_Boolean = false;
      paramKeyEvent = ((Activity)this.a.jdField_a_of_type_AndroidContentContext).getWindow().getAttributes();
      paramKeyEvent.y = 0;
      ((Activity)this.a.jdField_a_of_type_AndroidContentContext).getWindow().setAttributes(paramKeyEvent);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniPie.8
 * JD-Core Version:    0.7.0.1
 */