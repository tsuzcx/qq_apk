package com.tencent.mobileqq.armap;

class SupercellActivity$1$1
  implements Runnable
{
  SupercellActivity$1$1(SupercellActivity.1 param1) {}
  
  public void run()
  {
    if (this.this$1.this$0.isStartPlayEnd) {
      SupercellActivity.access$000(this.this$1.this$0);
    }
    for (;;)
    {
      JniCommon.nativeSuperCellSwitchMode(12);
      return;
      SupercellActivity.access$100(this.this$1.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.SupercellActivity.1.1
 * JD-Core Version:    0.7.0.1
 */