package com.tencent.mobileqq.app;

import anum;
import anyw;
import com.tencent.mobileqq.data.Card;
import java.util.ArrayList;

public class CardHandler$1
  implements Runnable
{
  public CardHandler$1(anum paramanum, int paramInt, ArrayList paramArrayList) {}
  
  public void run()
  {
    String str = this.this$0.app.getCurrentAccountUin();
    anyw localanyw = (anyw)this.this$0.app.getManager(51);
    Card localCard = localanyw.b(str);
    if (localCard != null)
    {
      localCard.iVoteIncrement = this.jdField_a_of_type_Int;
      localanyw.a(localCard);
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      anum.a(str, this.jdField_a_of_type_JavaUtilArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.CardHandler.1
 * JD-Core Version:    0.7.0.1
 */