package com.tencent.biz.qqstory.shareGroup.widget;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.handler.VidToSimpleInfoHandler.GetSimpleInfoListEvent;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.FakeVideoUIItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

class StoryPickerFragment$GetSimpleInfoListEventReceiver
  extends QQUIEventReceiver<StoryPickerFragment, VidToSimpleInfoHandler.GetSimpleInfoListEvent>
{
  public StoryPickerFragment$GetSimpleInfoListEventReceiver(@NonNull StoryPickerFragment paramStoryPickerFragment)
  {
    super(paramStoryPickerFragment);
  }
  
  public void a(@NonNull StoryPickerFragment paramStoryPickerFragment, @NonNull VidToSimpleInfoHandler.GetSimpleInfoListEvent paramGetSimpleInfoListEvent)
  {
    SLog.b(this.TAG, "GetSimpleInfoListEventReceiver. event=%s", paramGetSimpleInfoListEvent.toString());
    if ((paramGetSimpleInfoListEvent.g.isSuccess()) && (paramGetSimpleInfoListEvent.b != null) && (!paramGetSimpleInfoListEvent.b.isEmpty()))
    {
      Iterator localIterator = paramGetSimpleInfoListEvent.b.iterator();
      while (localIterator.hasNext())
      {
        VideoCollectionItem.FakeVideoUIItem localFakeVideoUIItem = (VideoCollectionItem.FakeVideoUIItem)localIterator.next();
        if (paramStoryPickerFragment.f.contains(localFakeVideoUIItem.a)) {
          localFakeVideoUIItem.c = true;
        }
      }
      paramStoryPickerFragment.b.a(paramGetSimpleInfoListEvent.a, paramGetSimpleInfoListEvent.b);
    }
  }
  
  public Class acceptEventClass()
  {
    return VidToSimpleInfoHandler.GetSimpleInfoListEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.widget.StoryPickerFragment.GetSimpleInfoListEventReceiver
 * JD-Core Version:    0.7.0.1
 */