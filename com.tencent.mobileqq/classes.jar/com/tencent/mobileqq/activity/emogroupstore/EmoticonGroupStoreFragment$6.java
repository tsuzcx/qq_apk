package com.tencent.mobileqq.activity.emogroupstore;

import com.tencent.mobileqq.emosm.favroaming.IEmoticonFromGroupManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class EmoticonGroupStoreFragment$6
  implements Runnable
{
  EmoticonGroupStoreFragment$6(EmoticonGroupStoreFragment paramEmoticonGroupStoreFragment) {}
  
  public void run()
  {
    if (!EmoticonGroupStoreFragment.c(this.this$0).isEmpty())
    {
      ArrayList localArrayList = new ArrayList(EmoticonGroupStoreFragment.c(this.this$0));
      Map localMap = EmoticonGroupStoreFragment.a(this.this$0).a(localArrayList);
      if (localMap != null) {
        EmoticonGroupStoreFragment.a(this.this$0).a(localMap, localArrayList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment.6
 * JD-Core Version:    0.7.0.1
 */