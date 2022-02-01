package com.tencent.mobileqq.apollo.script;

import amme;
import amna;
import anbs;
import ancc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class SpriteActionMessage$1
  implements Runnable
{
  public SpriteActionMessage$1(anbs paramanbs, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    if ((anbs.a(this.this$0) != null) && (anbs.a(this.this$0).a() != null))
    {
      amna localamna = ((amme)anbs.a(this.this$0).a().getManager(QQManagerFactory.APOLLO_MANAGER)).a();
      if (localamna != null)
      {
        localamna.a.set(this.jdField_a_of_type_Int);
        localamna.a(this.jdField_a_of_type_Int, true, this.jdField_a_of_type_Boolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteActionMessage.1
 * JD-Core Version:    0.7.0.1
 */