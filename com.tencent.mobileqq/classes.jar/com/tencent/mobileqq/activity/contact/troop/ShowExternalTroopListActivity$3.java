package com.tencent.mobileqq.activity.contact.troop;

import aloz;
import android.widget.TextView;
import bdbt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;

class ShowExternalTroopListActivity$3
  implements Runnable
{
  ShowExternalTroopListActivity$3(ShowExternalTroopListActivity paramShowExternalTroopListActivity, TextView paramTextView1, TextView paramTextView2) {}
  
  public void run()
  {
    String str = bdbt.a(this.this$0.app, this.this$0.a);
    Card localCard = ((aloz)this.this$0.app.getManager(51)).b(this.this$0.a);
    this.this$0.runOnUiThread(new ShowExternalTroopListActivity.3.1(this, str, localCard));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity.3
 * JD-Core Version:    0.7.0.1
 */