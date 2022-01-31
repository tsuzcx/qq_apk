package com.tencent.mobileqq.apollo.script;

import airz;
import aisr;
import ajer;
import ajfb;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.concurrent.atomic.AtomicInteger;

public class SpriteActionMessage$1
  implements Runnable
{
  public SpriteActionMessage$1(ajer paramajer, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    if ((ajer.a(this.this$0) != null) && (ajer.a(this.this$0).a() != null))
    {
      aisr localaisr = ((airz)ajer.a(this.this$0).a().getManager(153)).a();
      if (localaisr != null)
      {
        localaisr.a.set(this.jdField_a_of_type_Int);
        localaisr.a(this.jdField_a_of_type_Int, true, this.jdField_a_of_type_Boolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteActionMessage.1
 * JD-Core Version:    0.7.0.1
 */