package com.tencent.mobileqq.apollo.script;

import amhd;
import amhw;
import amtw;
import amug;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.concurrent.atomic.AtomicInteger;

public class SpriteActionMessage$1
  implements Runnable
{
  public SpriteActionMessage$1(amtw paramamtw, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    if ((amtw.a(this.this$0) != null) && (amtw.a(this.this$0).a() != null))
    {
      amhw localamhw = ((amhd)amtw.a(this.this$0).a().getManager(153)).a();
      if (localamhw != null)
      {
        localamhw.a.set(this.jdField_a_of_type_Int);
        localamhw.a(this.jdField_a_of_type_Int, true, this.jdField_a_of_type_Boolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteActionMessage.1
 * JD-Core Version:    0.7.0.1
 */