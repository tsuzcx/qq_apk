package com.tencent.aelight.camera.aioeditor.share.impl;

import com.tencent.mobileqq.widget.QQProgressDialog;

class AIOShareHelperImpl$7
  implements Runnable
{
  AIOShareHelperImpl$7(AIOShareHelperImpl paramAIOShareHelperImpl) {}
  
  public void run()
  {
    if (AIOShareHelperImpl.access$000(this.this$0) != null)
    {
      if (AIOShareHelperImpl.access$000(this.this$0).isShowing()) {
        AIOShareHelperImpl.access$000(this.this$0).dismiss();
      }
      AIOShareHelperImpl.access$002(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.share.impl.AIOShareHelperImpl.7
 * JD-Core Version:    0.7.0.1
 */