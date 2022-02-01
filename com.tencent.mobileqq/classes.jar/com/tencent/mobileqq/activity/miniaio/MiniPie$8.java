package com.tencent.mobileqq.activity.miniaio;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel.DispatchKeyEventListener;

class MiniPie$8
  implements IEmoticonMainPanel.DispatchKeyEventListener
{
  MiniPie$8(MiniPie paramMiniPie) {}
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1) && (this.a.z))
    {
      this.a.A.removeView(this.a.y.getView());
      paramKeyEvent = this.a;
      paramKeyEvent.z = false;
      paramKeyEvent = ((Activity)paramKeyEvent.b).getWindow().getAttributes();
      paramKeyEvent.y = 0;
      ((Activity)this.a.b).getWindow().setAttributes(paramKeyEvent);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniPie.8
 * JD-Core Version:    0.7.0.1
 */