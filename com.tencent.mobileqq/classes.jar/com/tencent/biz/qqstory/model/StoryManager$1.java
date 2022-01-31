package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import umc;
import uvx;
import vei;
import vej;

public class StoryManager$1
  implements Runnable
{
  public StoryManager$1(uvx paramuvx, String paramString) {}
  
  public void run()
  {
    Object localObject = this.this$0.a(this.a);
    if ((localObject == null) || (!((StoryVideoItem)localObject).isBasicInfoOK()))
    {
      localObject = new ArrayList(1);
      ((List)localObject).add(this.a);
      new vei((List)localObject, true).a();
      return;
    }
    vej localvej = new vej();
    localvej.a = Collections.singletonList(localObject);
    umc.a().dispatch(localvej);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.StoryManager.1
 * JD-Core Version:    0.7.0.1
 */