package com.tencent.biz.qqstory.debug.activities;

import android.text.TextUtils;
import com.tencent.biz.qqstory.database.PromoteTaskEntry;
import com.tencent.biz.qqstory.model.StoryPromoteTaskManager;
import java.util.Collections;
import java.util.List;

class DebugPromoteTaskCode$4
  implements Runnable
{
  DebugPromoteTaskCode$4(DebugPromoteTaskCode paramDebugPromoteTaskCode, String paramString1, String paramString2) {}
  
  public void run()
  {
    List localList;
    if (!TextUtils.isEmpty(this.a))
    {
      localList = this.this$0.a.a(Collections.singletonList(this.a), 1);
      if (!localList.isEmpty())
      {
        this.this$0.a.b((PromoteTaskEntry)localList.get(0));
        return;
      }
    }
    if (!TextUtils.isEmpty(this.b))
    {
      localList = this.this$0.a.b(this.b, 1);
      if (!localList.isEmpty()) {
        this.this$0.a.b((PromoteTaskEntry)localList.get(0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.debug.activities.DebugPromoteTaskCode.4
 * JD-Core Version:    0.7.0.1
 */