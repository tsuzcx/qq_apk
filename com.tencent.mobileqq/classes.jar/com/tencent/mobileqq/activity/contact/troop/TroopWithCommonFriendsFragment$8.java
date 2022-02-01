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
          QQToast.a(this.a.a, this.a.getString(2131718739), 0).b(this.a.a());
          return;
        }
        QQToast.a(this.a.a, this.a.getString(2131718752), 0).b(this.a.a());
        return;
      }
      paramMessage = this.a.a.getResources().getString(2131719418);
      QQToast.a(this.a.a, 1, paramMessage, 0).b(this.a.a());
      return;
    }
    if (TroopWithCommonFriendsFragment.a(this.a) != null) {
      TroopWithCommonFriendsFragment.a(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment.8
 * JD-Core Version:    0.7.0.1
 */