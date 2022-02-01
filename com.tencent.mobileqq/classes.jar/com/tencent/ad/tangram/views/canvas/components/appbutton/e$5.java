package com.tencent.ad.tangram.views.canvas.components.appbutton;

class e$5
  implements Runnable
{
  e$5(e parame, AdAppBtnData paramAdAppBtnData) {}
  
  public void run()
  {
    if ((e.access$000(this.this$0) != null) && (this.val$cgdtAppBtnData != null))
    {
      e.access$000(this.this$0).setText(e.access$100(this.this$0));
      e.access$000(this.this$0).setProgress(100);
      AdAppBtnData localAdAppBtnData = this.val$cgdtAppBtnData;
      localAdAppBtnData.cState = 0;
      localAdAppBtnData.cProgerss = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.components.appbutton.e.5
 * JD-Core Version:    0.7.0.1
 */