package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import wad;
import wjp;
import wsa;
import wsb;

public class StoryManager$1
  implements Runnable
{
  public StoryManager$1(wjp paramwjp, String paramString) {}
  
  public void run()
  {
    Object localObject = this.this$0.a(this.a);
    if ((localObject == null) || (!((StoryVideoItem)localObject).isBasicInfoOK()))
    {
      localObject = new ArrayList(1);
      ((List)localObject).add(this.a);
      new wsa((List)localObject, true).a();
      return;
    }
    wsb localwsb = new wsb();
    localwsb.a = Collections.singletonList(localObject);
    wad.a().dispatch(localwsb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.StoryManager.1
 * JD-Core Version:    0.7.0.1
 */