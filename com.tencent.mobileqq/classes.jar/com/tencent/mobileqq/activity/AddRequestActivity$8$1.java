package com.tencent.mobileqq.activity;

import adlh;
import anmw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;

public class AddRequestActivity$8$1
  implements Runnable
{
  public AddRequestActivity$8$1(adlh paramadlh) {}
  
  public void run()
  {
    Card localCard = ((anmw)this.a.a.app.getManager(51)).b(this.a.a.a);
    if (localCard != null) {
      this.a.a.runOnUiThread(new AddRequestActivity.8.1.1(this, localCard));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddRequestActivity.8.1
 * JD-Core Version:    0.7.0.1
 */