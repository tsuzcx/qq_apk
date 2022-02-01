package com.tencent.mobileqq.activity.contact.troop;

import android.content.res.Resources;
import android.os.Message;
import com.tencent.mobileqq.activity.contact.recommendtroop.base.CommonAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

class TroopWithCommonFriendsFragment$8
  extends MqqHandler
{
  TroopWithCommonFriendsFragment$8(TroopWithCommonFriendsFragment paramTroopWithCommonFriendsFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 1013: 
    case 1015: 
    case 1017: 
    default: 
    case 1012: 
      do
      {
        return;
      } while (TroopWithCommonFriendsFragment.a(this.a) == null);
      TroopWithCommonFriendsFragment.a(this.a).notifyDataSetChanged();
      return;
    case 1014: 
      paramMessage = this.a.a.getResources().getString(2131719697);
      QQToast.a(this.a.a, 1, paramMessage, 0).b(this.a.a());
      return;
    case 1016: 
      QQToast.a(this.a.a, this.a.getString(2131719036), 0).b(this.a.a());
      return;
    }
    QQToast.a(this.a.a, this.a.getString(2131719023), 0).b(this.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment.8
 * JD-Core Version:    0.7.0.1
 */