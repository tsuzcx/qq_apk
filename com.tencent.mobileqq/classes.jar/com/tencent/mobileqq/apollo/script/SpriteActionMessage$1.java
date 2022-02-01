package com.tencent.mobileqq.apollo.script;

import amsx;
import amtq;
import anfq;
import anga;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.concurrent.atomic.AtomicInteger;

public class SpriteActionMessage$1
  implements Runnable
{
  public SpriteActionMessage$1(anfq paramanfq, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    if ((anfq.a(this.this$0) != null) && (anfq.a(this.this$0).a() != null))
    {
      amtq localamtq = ((amsx)anfq.a(this.this$0).a().getManager(153)).a();
      if (localamtq != null)
      {
        localamtq.a.set(this.jdField_a_of_type_Int);
        localamtq.a(this.jdField_a_of_type_Int, true, this.jdField_a_of_type_Boolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteActionMessage.1
 * JD-Core Version:    0.7.0.1
 */