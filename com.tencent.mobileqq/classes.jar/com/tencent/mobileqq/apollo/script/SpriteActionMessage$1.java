package com.tencent.mobileqq.apollo.script;

import aifg;
import aify;
import airt;
import aisd;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.concurrent.atomic.AtomicInteger;

public class SpriteActionMessage$1
  implements Runnable
{
  public SpriteActionMessage$1(airt paramairt, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    if ((airt.a(this.this$0) != null) && (airt.a(this.this$0).a() != null))
    {
      aify localaify = ((aifg)airt.a(this.this$0).a().getManager(153)).a();
      if (localaify != null)
      {
        localaify.a.set(this.jdField_a_of_type_Int);
        localaify.a(this.jdField_a_of_type_Int, true, this.jdField_a_of_type_Boolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteActionMessage.1
 * JD-Core Version:    0.7.0.1
 */