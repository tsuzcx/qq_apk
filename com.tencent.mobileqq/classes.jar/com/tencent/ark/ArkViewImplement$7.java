package com.tencent.ark;

class ArkViewImplement$7
  implements Runnable
{
  ArkViewImplement$7(ArkViewImplement paramArkViewImplement, int paramInt, String paramString) {}
  
  public void run()
  {
    if (ArkViewImplement.access$000(this.this$0) == null) {
      return;
    }
    int i = this.val$inputComand;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return;
            }
            str = ArkViewImplement.access$000(this.this$0).InputGetSelectText();
            ArkDispatchTask.getInstance().postToMainThread(new ArkViewImplement.7.2(this, str));
            ArkViewImplement.access$000(this.this$0).InputDeleteBackward();
            return;
          }
          String str = ArkViewImplement.access$000(this.this$0).InputGetSelectText();
          ArkDispatchTask.getInstance().postToMainThread(new ArkViewImplement.7.1(this, str));
          return;
        }
        ArkViewImplement.access$000(this.this$0).InputInsertText(this.val$arkPasteData);
        return;
      }
      ArkViewImplement.access$000(this.this$0).InputSelectAll();
      return;
    }
    ArkViewImplement.access$000(this.this$0).InputSelect();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.ArkViewImplement.7
 * JD-Core Version:    0.7.0.1
 */