package com.tencent.mobileqq.activity.contact.troop;

import android.widget.TextView;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.utils.ContactUtils;

class ShowExternalTroopListActivity$3
  implements Runnable
{
  ShowExternalTroopListActivity$3(ShowExternalTroopListActivity paramShowExternalTroopListActivity, TextView paramTextView1, TextView paramTextView2) {}
  
  public void run()
  {
    String str = ContactUtils.a(this.this$0.app, this.this$0.n);
    Card localCard = ((FriendsManager)this.this$0.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).f(this.this$0.n);
    this.this$0.runOnUiThread(new ShowExternalTroopListActivity.3.1(this, str, localCard));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity.3
 * JD-Core Version:    0.7.0.1
 */