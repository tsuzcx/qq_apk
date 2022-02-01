package com.tencent.mobileqq.activity.emogroupstore;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.api.IEmoticonFromGroupDBManagerService;
import com.tencent.mobileqq.emosm.favroaming.IEmoticonFromGroupManager;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class EmoticonGroupStoreFragment$5
  implements Runnable
{
  EmoticonGroupStoreFragment$5(EmoticonGroupStoreFragment paramEmoticonGroupStoreFragment) {}
  
  public void run()
  {
    Object localObject = (IEmoticonFromGroupDBManagerService)EmoticonGroupStoreFragment.a(this.this$0).getRuntimeService(IEmoticonFromGroupDBManagerService.class);
    if (localObject != null) {
      ((IEmoticonFromGroupDBManagerService)localObject).loadDB();
    }
    localObject = new CopyOnWriteArrayList(EmoticonGroupStoreFragment.a(this.this$0).a());
    if (!((List)localObject).isEmpty())
    {
      int i = ((List)localObject).size();
      if (i < 50)
      {
        EmoticonGroupStoreFragment.a(this.this$0, (List)localObject);
        localObject = this.this$0;
        EmoticonGroupStoreFragment.b((EmoticonGroupStoreFragment)localObject, EmoticonGroupStoreFragment.c((EmoticonGroupStoreFragment)localObject));
        EmoticonGroupStoreFragment.a(this.this$0);
        EmoticonGroupStoreFragment.b(this.this$0);
      }
      else
      {
        EmoticonGroupStoreFragment.a(this.this$0, ((List)localObject).subList(0, 50));
        int j = EmoticonGroupStoreFragment.c(this.this$0).size();
        EmoticonGroupStoreFragment localEmoticonGroupStoreFragment = this.this$0;
        EmoticonGroupStoreFragment.b(localEmoticonGroupStoreFragment, EmoticonGroupStoreFragment.c(localEmoticonGroupStoreFragment));
        EmoticonGroupStoreFragment.b(this.this$0);
        EmoticonGroupStoreFragment.a(this.this$0, ((List)localObject).subList(50, i));
        EmoticonGroupStoreFragment.a(this.this$0);
        localObject = this.this$0;
        EmoticonGroupStoreFragment.b((EmoticonGroupStoreFragment)localObject, EmoticonGroupStoreFragment.c((EmoticonGroupStoreFragment)localObject).subList(j, EmoticonGroupStoreFragment.c(this.this$0).size()));
        EmoticonGroupStoreFragment.b(this.this$0);
      }
      if (EmoticonGroupStoreFragment.b(this.this$0) != null) {
        EmoticonGroupStoreFragment.c(this.this$0);
      }
    }
    else
    {
      EmoticonGroupStoreFragment.d(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment.5
 * JD-Core Version:    0.7.0.1
 */