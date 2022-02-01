package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import wjj;
import wte;
import xbp;
import xbq;

public class StoryManager$1
  implements Runnable
{
  public StoryManager$1(wte paramwte, String paramString) {}
  
  public void run()
  {
    Object localObject = this.this$0.a(this.a);
    if ((localObject == null) || (!((StoryVideoItem)localObject).isBasicInfoOK()))
    {
      localObject = new ArrayList(1);
      ((List)localObject).add(this.a);
      new xbp((List)localObject, true).a();
      return;
    }
    xbq localxbq = new xbq();
    localxbq.a = Collections.singletonList(localObject);
    wjj.a().dispatch(localxbq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.StoryManager.1
 * JD-Core Version:    0.7.0.1
 */