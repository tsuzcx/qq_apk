package com.tencent.mobileqq.activity.recent;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;

class RecentAdapter$5
  implements DialogInterface.OnClickListener
{
  RecentAdapter$5(RecentAdapter paramRecentAdapter) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((CardHandler)this.a.a.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).m(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentAdapter.5
 * JD-Core Version:    0.7.0.1
 */