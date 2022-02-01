package com.tencent.mobileqq.activity.emogroupstore;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupDBManager;
import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class EmoticonGroupStoreFragment$5
  implements Runnable
{
  EmoticonGroupStoreFragment$5(EmoticonGroupStoreFragment paramEmoticonGroupStoreFragment) {}
  
  public void run()
  {
    Object localObject = (EmoticonFromGroupDBManager)EmoticonGroupStoreFragment.a(this.this$0).getManager(QQManagerFactory.EMOFROMGROUP_DB_MANAGER);
    if (localObject != null) {
      ((EmoticonFromGroupDBManager)localObject).b();
    }
    localObject = new CopyOnWriteArrayList(EmoticonGroupStoreFragment.a(this.this$0).a());
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      int i = ((List)localObject).size();
      if (i < 50)
      {
        EmoticonGroupStoreFragment.a(this.this$0, (List)localObject);
        EmoticonGroupStoreFragment.b(this.this$0, EmoticonGroupStoreFragment.c(this.this$0));
        EmoticonGroupStoreFragment.a(this.this$0);
        EmoticonGroupStoreFragment.b(this.this$0);
      }
      for (;;)
      {
        if (EmoticonGroupStoreFragment.b(this.this$0) != null) {
          EmoticonGroupStoreFragment.c(this.this$0);
        }
        return;
        EmoticonGroupStoreFragment.a(this.this$0, ((List)localObject).subList(0, 50));
        int j = EmoticonGroupStoreFragment.c(this.this$0).size();
        EmoticonGroupStoreFragment.b(this.this$0, EmoticonGroupStoreFragment.c(this.this$0));
        EmoticonGroupStoreFragment.b(this.this$0);
        EmoticonGroupStoreFragment.a(this.this$0, ((List)localObject).subList(50, i));
        EmoticonGroupStoreFragment.a(this.this$0);
        EmoticonGroupStoreFragment.b(this.this$0, EmoticonGroupStoreFragment.c(this.this$0).subList(j, EmoticonGroupStoreFragment.c(this.this$0).size()));
        EmoticonGroupStoreFragment.b(this.this$0);
      }
    }
    EmoticonGroupStoreFragment.d(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment.5
 * JD-Core Version:    0.7.0.1
 */