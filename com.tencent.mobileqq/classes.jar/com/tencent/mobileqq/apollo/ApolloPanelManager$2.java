package com.tencent.mobileqq.apollo;

import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.api.impl.SpriteScriptManagerImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloInfo;
import com.tencent.mobileqq.apollo.script.SpriteActionMessage;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.concurrent.atomic.AtomicInteger;

class ApolloPanelManager$2
  implements Runnable
{
  ApolloPanelManager$2(ApolloPanelManager paramApolloPanelManager, ApolloInfo paramApolloInfo) {}
  
  public void run()
  {
    this.this$0.a(this.this$0.a.get(), true, ApolloPanelManager.a(this.this$0));
    if ((this.this$0.a.get() == 0) && (!ApolloPanelManager.a(this.this$0)) && (this.this$0.a() != null))
    {
      SpriteActionMessage localSpriteActionMessage = ((SpriteScriptManagerImpl)this.this$0.a().getRuntimeService(ISpriteScriptManager.class, "all")).getSpriteActionMessage();
      if (localSpriteActionMessage != null) {
        localSpriteActionMessage.a(this.this$0.b);
      }
    }
    if ((ApolloPanelManager.a(this.this$0)) || (this.this$0.a.get() > 0)) {
      ApolloPanelManager.a(this.this$0, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloPanelManager.2
 * JD-Core Version:    0.7.0.1
 */