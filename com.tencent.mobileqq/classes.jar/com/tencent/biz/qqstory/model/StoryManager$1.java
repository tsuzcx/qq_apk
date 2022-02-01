package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.VidToBasicInfoHandler;
import com.tencent.biz.qqstory.network.handler.VidToBasicInfoHandler.GetVideoBasicInfoListEvent;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class StoryManager$1
  implements Runnable
{
  StoryManager$1(StoryManager paramStoryManager, String paramString) {}
  
  public void run()
  {
    Object localObject = this.this$0.a(this.a);
    if ((localObject != null) && (((StoryVideoItem)localObject).isBasicInfoOK()))
    {
      VidToBasicInfoHandler.GetVideoBasicInfoListEvent localGetVideoBasicInfoListEvent = new VidToBasicInfoHandler.GetVideoBasicInfoListEvent();
      localGetVideoBasicInfoListEvent.a = Collections.singletonList(localObject);
      StoryDispatcher.a().dispatch(localGetVideoBasicInfoListEvent);
      return;
    }
    localObject = new ArrayList(1);
    ((List)localObject).add(this.a);
    new VidToBasicInfoHandler((List)localObject, true).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.StoryManager.1
 * JD-Core Version:    0.7.0.1
 */