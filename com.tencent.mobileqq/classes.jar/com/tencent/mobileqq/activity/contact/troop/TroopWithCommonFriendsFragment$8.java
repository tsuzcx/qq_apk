package com.tencent.mobileqq.activity.contact.troop;

import android.content.res.Resources;
import android.os.Message;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.troop.adapter.CommonAdapter;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

class TroopWithCommonFriendsFragment$8
  extends MqqHandler
{
  TroopWithCommonFriendsFragment$8(TroopWithCommonFriendsFragment paramTroopWithCommonFriendsFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1012)
    {
      if (i != 1014)
      {
        if (i != 1016)
        {
          if (i != 1018) {
            return;
          }
          QQToast.makeText(this.a.d, this.a.getString(2131916242), 0).show(this.a.a());
          return;
        }
        QQToast.makeText(this.a.d, this.a.getString(2131916258), 0).show(this.a.a());
        return;
      }
      paramMessage = this.a.d.getResources().getString(2131916977);
      QQToast.makeText(this.a.d, 1, paramMessage, 0).show(this.a.a());
      return;
    }
    if (TroopWithCommonFriendsFragment.c(this.a) != null) {
      TroopWithCommonFriendsFragment.c(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment.8
 * JD-Core Version:    0.7.0.1
 */