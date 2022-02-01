package com.tencent.mobileqq.activity.contact.troop;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.StackBlur;

class ShowExternalTroopListActivity$2
  implements Runnable
{
  ShowExternalTroopListActivity$2(ShowExternalTroopListActivity paramShowExternalTroopListActivity) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    localObject = ((ShowExternalTroopListActivity)localObject).a(((ShowExternalTroopListActivity)localObject).app.getFaceBitmap(this.this$0.a, (byte)1, true));
    if (localObject != null)
    {
      try
      {
        StackBlur.a((Bitmap)localObject, 10);
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError.printStackTrace();
      }
      this.this$0.runOnUiThread(new ShowExternalTroopListActivity.2.1(this, (Bitmap)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity.2
 * JD-Core Version:    0.7.0.1
 */