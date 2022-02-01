package com.tencent.ad.tangram.views.canvas.components.appbutton;

class e$4
  implements Runnable
{
  e$4(e parame, AdAppBtnData paramAdAppBtnData) {}
  
  public void run()
  {
    if ((e.access$000(this.this$0) != null) && (this.val$cgdtAppBtnData != null))
    {
      e.access$000(this.this$0).setProgress(100);
      e.access$000(this.this$0).setText("打开");
      this.val$cgdtAppBtnData.cState = 6;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.components.appbutton.e.4
 * JD-Core Version:    0.7.0.1
 */