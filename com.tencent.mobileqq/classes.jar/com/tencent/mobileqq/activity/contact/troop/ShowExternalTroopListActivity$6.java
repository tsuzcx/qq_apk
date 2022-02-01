package com.tencent.mobileqq.activity.contact.troop;

import android.os.Handler;
import android.os.Message;
import com.tencent.widget.XListView;

class ShowExternalTroopListActivity$6
  extends Handler
{
  ShowExternalTroopListActivity$6(ShowExternalTroopListActivity paramShowExternalTroopListActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 100)
    {
      if (i == 101) {
        this.a.a.springBackOverScrollHeaderView();
      }
    }
    else {
      this.a.a.springBackOverScrollHeaderView();
    }
    super.handleMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity.6
 * JD-Core Version:    0.7.0.1
 */