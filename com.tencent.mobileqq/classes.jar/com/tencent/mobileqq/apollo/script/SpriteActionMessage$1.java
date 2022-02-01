package com.tencent.mobileqq.apollo.script;

import com.tencent.mobileqq.apollo.ApolloPanelManager;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.concurrent.atomic.AtomicInteger;

class SpriteActionMessage$1
  implements Runnable
{
  SpriteActionMessage$1(SpriteActionMessage paramSpriteActionMessage, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    if ((SpriteActionMessage.a(this.this$0) != null) && (SpriteActionMessage.a(this.this$0).a() != null))
    {
      ApolloPanelManager localApolloPanelManager = ((ApolloManagerServiceImpl)SpriteActionMessage.a(this.this$0).a().getRuntimeService(IApolloManagerService.class, "all")).getApolloPanelManager();
      if (localApolloPanelManager != null)
      {
        localApolloPanelManager.a.set(this.jdField_a_of_type_Int);
        localApolloPanelManager.a(this.jdField_a_of_type_Int, true, this.jdField_a_of_type_Boolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteActionMessage.1
 * JD-Core Version:    0.7.0.1
 */