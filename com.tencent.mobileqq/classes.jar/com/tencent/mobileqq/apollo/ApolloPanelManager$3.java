package com.tencent.mobileqq.apollo;

import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.api.impl.SpriteScriptManagerImpl;
import com.tencent.mobileqq.apollo.script.SpriteActionMessage;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.concurrent.atomic.AtomicInteger;

class ApolloPanelManager$3
  implements Runnable
{
  ApolloPanelManager$3(ApolloPanelManager paramApolloPanelManager) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    int i = this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo != null) {}
    for (boolean bool = true;; bool = false)
    {
      ((ApolloPanelManager)localObject).a(i, bool, ApolloPanelManager.a(this.this$0));
      if ((this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0) && (!ApolloPanelManager.a(this.this$0)) && (this.this$0.a() != null) && (this.this$0.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo != null))
      {
        localObject = ((SpriteScriptManagerImpl)this.this$0.a().getRuntimeService(ISpriteScriptManager.class, "all")).getSpriteActionMessage();
        if (localObject != null) {
          ((SpriteActionMessage)localObject).a(this.this$0.b);
        }
      }
      if (((ApolloPanelManager.a(this.this$0)) || (this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0)) && (this.this$0.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo != null)) {
        ApolloPanelManager.a(this.this$0, this.this$0.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloPanelManager.3
 * JD-Core Version:    0.7.0.1
 */