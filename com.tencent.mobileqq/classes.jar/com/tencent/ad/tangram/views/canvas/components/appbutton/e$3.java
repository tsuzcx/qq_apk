package com.tencent.ad.tangram.views.canvas.components.appbutton;

class e$3
  implements Runnable
{
  e$3(e parame, AdAppBtnData paramAdAppBtnData) {}
  
  public void run()
  {
    if ((e.access$000(this.this$0) != null) && (this.val$cgdtAppBtnData != null))
    {
      e.access$000(this.this$0).setProgress(100);
      e.access$000(this.this$0).setText("安装");
      this.val$cgdtAppBtnData.cState = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.components.appbutton.e.3
 * JD-Core Version:    0.7.0.1
 */