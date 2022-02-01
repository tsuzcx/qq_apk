package com.tencent.mobileqq.apollo.script;

import alnr;
import alok;
import amak;
import amau;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.concurrent.atomic.AtomicInteger;

public class SpriteActionMessage$1
  implements Runnable
{
  public SpriteActionMessage$1(amak paramamak, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    if ((amak.a(this.this$0) != null) && (amak.a(this.this$0).a() != null))
    {
      alok localalok = ((alnr)amak.a(this.this$0).a().getManager(153)).a();
      if (localalok != null)
      {
        localalok.a.set(this.jdField_a_of_type_Int);
        localalok.a(this.jdField_a_of_type_Int, true, this.jdField_a_of_type_Boolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteActionMessage.1
 * JD-Core Version:    0.7.0.1
 */