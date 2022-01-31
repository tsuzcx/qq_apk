package com.tencent.mobileqq.armap;

import android.app.Dialog;

class SupercellActivity$20
  implements Runnable
{
  SupercellActivity$20(SupercellActivity paramSupercellActivity) {}
  
  public void run()
  {
    try
    {
      if ((this.this$0.mCardDialog != null) && (this.this$0.mCardDialog.isShowing())) {
        return;
      }
      this.this$0.showSupercellCard();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.SupercellActivity.20
 * JD-Core Version:    0.7.0.1
 */