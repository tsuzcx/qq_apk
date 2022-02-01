package com.tencent.mobileqq.app;

import anri;
import anvk;
import com.tencent.mobileqq.data.Card;
import java.util.ArrayList;

public class CardHandler$1
  implements Runnable
{
  public CardHandler$1(anri paramanri, int paramInt, ArrayList paramArrayList) {}
  
  public void run()
  {
    String str = this.this$0.app.getCurrentAccountUin();
    anvk localanvk = (anvk)this.this$0.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Card localCard = localanvk.b(str);
    if (localCard != null)
    {
      localCard.iVoteIncrement = this.jdField_a_of_type_Int;
      localanvk.a(localCard);
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      anri.a(str, this.jdField_a_of_type_JavaUtilArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.CardHandler.1
 * JD-Core Version:    0.7.0.1
 */