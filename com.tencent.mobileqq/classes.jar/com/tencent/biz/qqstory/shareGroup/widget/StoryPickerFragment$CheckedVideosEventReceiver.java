package com.tencent.biz.qqstory.shareGroup.widget;

import android.support.annotation.NonNull;
import android.widget.TextView;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.SelectVideoPlayerStrategy.SelectedVideosEvent;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.FakeVideoUIItem;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

class StoryPickerFragment$CheckedVideosEventReceiver
  extends QQUIEventReceiver<StoryPickerFragment, SelectVideoPlayerStrategy.SelectedVideosEvent>
{
  public StoryPickerFragment$CheckedVideosEventReceiver(@NonNull StoryPickerFragment paramStoryPickerFragment)
  {
    super(paramStoryPickerFragment);
  }
  
  public void a(@NonNull StoryPickerFragment paramStoryPickerFragment, @NonNull SelectVideoPlayerStrategy.SelectedVideosEvent paramSelectedVideosEvent)
  {
    paramStoryPickerFragment.f.clear();
    paramStoryPickerFragment.f.addAll(paramSelectedVideosEvent.b);
    List localList = paramStoryPickerFragment.b.a();
    int i = 0;
    while (i < localList.size())
    {
      Iterator localIterator = ((VideoCollectionItem)localList.get(i)).collectionVideoUIItemList.iterator();
      while (localIterator.hasNext())
      {
        VideoCollectionItem.FakeVideoUIItem localFakeVideoUIItem = (VideoCollectionItem.FakeVideoUIItem)localIterator.next();
        if (paramSelectedVideosEvent.b.contains(localFakeVideoUIItem.a)) {
          localFakeVideoUIItem.c = true;
        } else {
          localFakeVideoUIItem.c = false;
        }
      }
      i += 1;
    }
    paramStoryPickerFragment.c();
    if (paramSelectedVideosEvent.a) {
      paramStoryPickerFragment.rightViewText.performClick();
    }
  }
  
  public Class acceptEventClass()
  {
    return SelectVideoPlayerStrategy.SelectedVideosEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.widget.StoryPickerFragment.CheckedVideosEventReceiver
 * JD-Core Version:    0.7.0.1
 */