package com.tencent.ark.open;

class ArkModel$2
  implements Runnable
{
  ArkModel$2(ArkModel paramArkModel, String paramString) {}
  
  public void run()
  {
    this.this$0.mExtraTimerRecord.getAppFromLocal = true;
    this.this$0.mExtraTimerRecord.endOfGetApp = System.currentTimeMillis();
    ArkModel localArkModel = this.this$0;
    ArkModel.access$100(localArkModel, this.val$appPath, ArkModel.access$000(localArkModel), 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.ArkModel.2
 * JD-Core Version:    0.7.0.1
 */