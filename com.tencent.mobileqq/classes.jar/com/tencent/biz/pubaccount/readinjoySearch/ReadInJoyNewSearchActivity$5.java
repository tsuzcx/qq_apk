package com.tencent.biz.pubaccount.readinjoySearch;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;

class ReadInJoyNewSearchActivity$5
  implements DialogInterface.OnClickListener
{
  ReadInJoyNewSearchActivity$5(ReadInJoyNewSearchActivity paramReadInJoyNewSearchActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      ThreadManager.post(new ReadInJoyNewSearchActivity.5.1(this), 10, null, true);
      return;
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoySearch.ReadInJoyNewSearchActivity.5
 * JD-Core Version:    0.7.0.1
 */