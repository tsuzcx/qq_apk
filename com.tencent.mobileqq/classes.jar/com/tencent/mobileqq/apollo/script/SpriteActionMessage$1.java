package com.tencent.mobileqq.apollo.script;

import airx;
import aisp;
import ajep;
import ajez;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.concurrent.atomic.AtomicInteger;

public class SpriteActionMessage$1
  implements Runnable
{
  public SpriteActionMessage$1(ajep paramajep, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    if ((ajep.a(this.this$0) != null) && (ajep.a(this.this$0).a() != null))
    {
      aisp localaisp = ((airx)ajep.a(this.this$0).a().getManager(153)).a();
      if (localaisp != null)
      {
        localaisp.a.set(this.jdField_a_of_type_Int);
        localaisp.a(this.jdField_a_of_type_Int, true, this.jdField_a_of_type_Boolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteActionMessage.1
 * JD-Core Version:    0.7.0.1
 */