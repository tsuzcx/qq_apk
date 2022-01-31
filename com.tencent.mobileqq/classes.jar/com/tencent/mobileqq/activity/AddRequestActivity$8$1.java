package com.tencent.mobileqq.activity;

import aaik;
import ajxn;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;

public class AddRequestActivity$8$1
  implements Runnable
{
  public AddRequestActivity$8$1(aaik paramaaik) {}
  
  public void run()
  {
    Card localCard = ((ajxn)this.a.a.app.getManager(51)).b(this.a.a.a);
    if (localCard != null) {
      this.a.a.runOnUiThread(new AddRequestActivity.8.1.1(this, localCard));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddRequestActivity.8.1
 * JD-Core Version:    0.7.0.1
 */