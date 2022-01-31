package com.tencent.mobileqq.app;

import ajfi;
import ajjj;
import com.tencent.mobileqq.data.Card;
import java.util.ArrayList;

public class CardHandler$1
  implements Runnable
{
  public CardHandler$1(ajfi paramajfi, int paramInt, ArrayList paramArrayList) {}
  
  public void run()
  {
    String str = this.this$0.app.getCurrentAccountUin();
    ajjj localajjj = (ajjj)this.this$0.app.getManager(51);
    Card localCard = localajjj.b(str);
    if (localCard != null)
    {
      localCard.iVoteIncrement = this.jdField_a_of_type_Int;
      localajjj.a(localCard);
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      ajfi.a(str, this.jdField_a_of_type_JavaUtilArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.CardHandler.1
 * JD-Core Version:    0.7.0.1
 */