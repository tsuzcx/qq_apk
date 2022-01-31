package com.tencent.mobileqq.app;

import ajtk;
import ajxn;
import com.tencent.mobileqq.data.Card;
import java.util.ArrayList;

public class CardHandler$1
  implements Runnable
{
  public CardHandler$1(ajtk paramajtk, int paramInt, ArrayList paramArrayList) {}
  
  public void run()
  {
    String str = this.this$0.app.getCurrentAccountUin();
    ajxn localajxn = (ajxn)this.this$0.app.getManager(51);
    Card localCard = localajxn.b(str);
    if (localCard != null)
    {
      localCard.iVoteIncrement = this.jdField_a_of_type_Int;
      localajxn.a(localCard);
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      ajtk.a(str, this.jdField_a_of_type_JavaUtilArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.CardHandler.1
 * JD-Core Version:    0.7.0.1
 */