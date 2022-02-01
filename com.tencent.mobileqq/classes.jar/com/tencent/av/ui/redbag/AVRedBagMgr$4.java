package com.tencent.av.ui.redbag;

class AVRedBagMgr$4
  implements Runnable
{
  AVRedBagMgr$4(AVRedBagMgr paramAVRedBagMgr, ResultData paramResultData) {}
  
  public void run()
  {
    if (this.a.b()) {
      this.this$0.a(this.this$0.a(), this.a);
    }
    do
    {
      return;
      AVRedBagMgr.a(AVRedBagMgr.c(this.this$0), this.a);
    } while (!this.a.a());
    RedBagReport.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.redbag.AVRedBagMgr.4
 * JD-Core Version:    0.7.0.1
 */