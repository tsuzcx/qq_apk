package com.tencent.mobileqq.apollo.web.jsmodule;

import android.app.Activity;
import com.tencent.mobileqq.apollo.store.IApolloActivityJsCallBack;

class StoreJsModule$2
  implements Runnable
{
  StoreJsModule$2(StoreJsModule paramStoreJsModule, Activity paramActivity, String paramString) {}
  
  public void run()
  {
    Activity localActivity = this.a;
    if (!(localActivity instanceof IApolloActivityJsCallBack)) {
      return;
    }
    ((IApolloActivityJsCallBack)localActivity).e(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.StoreJsModule.2
 * JD-Core Version:    0.7.0.1
 */