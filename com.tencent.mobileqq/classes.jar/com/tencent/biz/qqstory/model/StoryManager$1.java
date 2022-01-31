package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import stb;
import tcw;
import tlh;
import tli;

public class StoryManager$1
  implements Runnable
{
  public StoryManager$1(tcw paramtcw, String paramString) {}
  
  public void run()
  {
    Object localObject = this.this$0.a(this.a);
    if ((localObject == null) || (!((StoryVideoItem)localObject).isBasicInfoOK()))
    {
      localObject = new ArrayList(1);
      ((List)localObject).add(this.a);
      new tlh((List)localObject, true).a();
      return;
    }
    tli localtli = new tli();
    localtli.a = Collections.singletonList(localObject);
    stb.a().dispatch(localtli);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.StoryManager.1
 * JD-Core Version:    0.7.0.1
 */