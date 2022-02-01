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
    localObject = new CopyOnWriteArrayList(EmoticonGroupStoreFragment.j(this.this$0).b());
    if (!((List)localObject).isEmpty())
    {
      int i = ((List)localObject).size();
      if (i < 50)
      {
        EmoticonGroupStoreFragment.a(this.this$0, (List)localObject);
        localObject = this.this$0;
        EmoticonGroupStoreFragment.b((EmoticonGroupStoreFragment)localObject, EmoticonGroupStoreFragment.k((EmoticonGroupStoreFragment)localObject));
        EmoticonGroupStoreFragment.l(this.this$0);
        EmoticonGroupStoreFragment.m(this.this$0);
      }
      else
      {
        EmoticonGroupStoreFragment.a(this.this$0, ((List)localObject).subList(0, 50));
        int j = EmoticonGroupStoreFragment.k(this.this$0).size();
        EmoticonGroupStoreFragment localEmoticonGroupStoreFragment = this.this$0;
        EmoticonGroupStoreFragment.b(localEmoticonGroupStoreFragment, EmoticonGroupStoreFragment.k(localEmoticonGroupStoreFragment));
        EmoticonGroupStoreFragment.m(this.this$0);
        EmoticonGroupStoreFragment.a(this.this$0, ((List)localObject).subList(50, i));
        EmoticonGroupStoreFragment.l(this.this$0);
        localObject = this.this$0;
        EmoticonGroupStoreFragment.b((EmoticonGroupStoreFragment)localObject, EmoticonGroupStoreFragment.k((EmoticonGroupStoreFragment)localObject).subList(j, EmoticonGroupStoreFragment.k(this.this$0).size()));
        EmoticonGroupStoreFragment.m(this.this$0);
      }
      if (EmoticonGroupStoreFragment.f(this.this$0) != null) {
        EmoticonGroupStoreFragment.n(this.this$0);
      }
    }
    else
    {
      EmoticonGroupStoreFragment.o(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment.5
 * JD-Core Version:    0.7.0.1
 */