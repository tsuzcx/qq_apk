package com.tencent.mobileqq.apollo.web.jsmodule;

import com.tencent.mobileqq.apollo.store.ApolloStoreViewController;
import com.tencent.mobileqq.apollo.store.ApolloStoreViewController.PlayActionData;
import com.tencent.mobileqq.apollo.store.IApolloActivityJsCallBack;
import com.tencent.qphone.base.util.QLog;

class Makeup2DJsModule$2$1
  implements Runnable
{
  Makeup2DJsModule$2$1(Makeup2DJsModule.2 param2, ApolloStoreViewController.PlayActionData paramPlayActionData) {}
  
  public void run()
  {
    String str = ApolloStoreViewController.b("ApolloViewController is null or Activity not instanceof IApolloActivityJsCallBack");
    Object localObject;
    StringBuilder localStringBuilder;
    if (this.b.c.c() != null)
    {
      str = this.b.c.c().a(this.a);
      localObject = this.b.c;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b.a);
      localStringBuilder.append("&&");
      localStringBuilder.append(this.b.a);
      localStringBuilder.append("(");
      localStringBuilder.append(str);
      localStringBuilder.append(");");
      ((Makeup2DJsModule)localObject).d(localStringBuilder.toString());
    }
    else if ((this.b.b instanceof IApolloActivityJsCallBack))
    {
      str = ((IApolloActivityJsCallBack)this.b.b).a(this.a);
      localObject = this.b.c;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b.a);
      localStringBuilder.append("&&");
      localStringBuilder.append(this.b.a);
      localStringBuilder.append("(");
      localStringBuilder.append(str);
      localStringBuilder.append(");");
      ((Makeup2DJsModule)localObject).d(localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("IPC_APOLLO_PREVIEW_AUDIO_ACTION callbackId->");
      ((StringBuilder)localObject).append(this.b.a);
      ((StringBuilder)localObject).append(" callbackOk");
      ((StringBuilder)localObject).append(str);
      QLog.e("Makeup2DJsModule", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.Makeup2DJsModule.2.1
 * JD-Core Version:    0.7.0.1
 */