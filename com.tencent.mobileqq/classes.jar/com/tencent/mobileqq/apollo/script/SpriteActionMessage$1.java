package com.tencent.mobileqq.apollo.script;

import aknx;
import akoq;
import alaq;
import alba;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.concurrent.atomic.AtomicInteger;

public class SpriteActionMessage$1
  implements Runnable
{
  public SpriteActionMessage$1(alaq paramalaq, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    if ((alaq.a(this.this$0) != null) && (alaq.a(this.this$0).a() != null))
    {
      akoq localakoq = ((aknx)alaq.a(this.this$0).a().getManager(153)).a();
      if (localakoq != null)
      {
        localakoq.a.set(this.jdField_a_of_type_Int);
        localakoq.a(this.jdField_a_of_type_Int, true, this.jdField_a_of_type_Boolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteActionMessage.1
 * JD-Core Version:    0.7.0.1
 */