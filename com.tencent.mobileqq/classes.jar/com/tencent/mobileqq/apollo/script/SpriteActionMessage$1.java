package com.tencent.mobileqq.apollo.script;

import akji;
import akkb;
import akwb;
import akwl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.concurrent.atomic.AtomicInteger;

public class SpriteActionMessage$1
  implements Runnable
{
  public SpriteActionMessage$1(akwb paramakwb, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    if ((akwb.a(this.this$0) != null) && (akwb.a(this.this$0).a() != null))
    {
      akkb localakkb = ((akji)akwb.a(this.this$0).a().getManager(153)).a();
      if (localakkb != null)
      {
        localakkb.a.set(this.jdField_a_of_type_Int);
        localakkb.a(this.jdField_a_of_type_Int, true, this.jdField_a_of_type_Boolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteActionMessage.1
 * JD-Core Version:    0.7.0.1
 */