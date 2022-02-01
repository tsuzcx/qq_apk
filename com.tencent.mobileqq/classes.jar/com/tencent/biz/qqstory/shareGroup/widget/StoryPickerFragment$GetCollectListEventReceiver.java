package com.tencent.biz.qqstory.shareGroup.widget;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.handler.DateCollectionListPageLoader.GetCollectionListEvent;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.FakeVideoUIItem;
import com.tencent.biz.qqstory.view.widget.LoadingMoreHelper;
import com.tencent.biz.qqstory.view.widget.QQStoryPullToRefreshListView;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

class StoryPickerFragment$GetCollectListEventReceiver
  extends QQUIEventReceiver<StoryPickerFragment, DateCollectionListPageLoader.GetCollectionListEvent>
{
  public StoryPickerFragment$GetCollectListEventReceiver(@NonNull StoryPickerFragment paramStoryPickerFragment)
  {
    super(paramStoryPickerFragment);
  }
  
  public void a(@NonNull StoryPickerFragment paramStoryPickerFragment, @NonNull DateCollectionListPageLoader.GetCollectionListEvent paramGetCollectionListEvent)
  {
    if (!TextUtils.equals(paramStoryPickerFragment.d, paramGetCollectionListEvent.i)) {
      return;
    }
    boolean bool = paramGetCollectionListEvent.g.isSuccess();
    ArrayList localArrayList = new ArrayList(paramGetCollectionListEvent.e.size());
    List localList = paramGetCollectionListEvent.e;
    int i = 0;
    while (i < localList.size())
    {
      VideoCollectionItem localVideoCollectionItem = (VideoCollectionItem)localList.get(i);
      if (localVideoCollectionItem.collectionType == 1)
      {
        int j = 0;
        while (j < localVideoCollectionItem.collectionVideoUIItemList.size())
        {
          VideoCollectionItem.FakeVideoUIItem localFakeVideoUIItem = (VideoCollectionItem.FakeVideoUIItem)localVideoCollectionItem.collectionVideoUIItemList.get(j);
          if (paramStoryPickerFragment.f.contains(localFakeVideoUIItem.a))
          {
            localFakeVideoUIItem.c = true;
            if (paramStoryPickerFragment.f.size() >= 20) {
              localFakeVideoUIItem.d = true;
            }
          }
          else
          {
            localFakeVideoUIItem.c = false;
            if (paramStoryPickerFragment.f.size() >= 20) {
              localFakeVideoUIItem.d = false;
            } else {
              localFakeVideoUIItem.d = true;
            }
          }
          j += 1;
        }
        localArrayList.add(localVideoCollectionItem);
      }
      i += 1;
    }
    if ((bool) && (paramGetCollectionListEvent.h))
    {
      if (localArrayList.isEmpty())
      {
        paramStoryPickerFragment.c.setVisibility(0);
        paramStoryPickerFragment.a.setVisibility(8);
      }
      else
      {
        paramStoryPickerFragment.c.setVisibility(8);
        paramStoryPickerFragment.a.setVisibility(0);
      }
      if (paramGetCollectionListEvent.c) {
        paramStoryPickerFragment.b.a(localArrayList);
      } else {
        paramStoryPickerFragment.b.b(localArrayList);
      }
    }
    if (paramGetCollectionListEvent.c) {
      paramStoryPickerFragment.a.a(bool);
    }
    paramStoryPickerFragment.a.j.a(bool, paramGetCollectionListEvent.a ^ true);
    paramStoryPickerFragment.stopTitleProgress();
  }
  
  public Class acceptEventClass()
  {
    return DateCollectionListPageLoader.GetCollectionListEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.widget.StoryPickerFragment.GetCollectListEventReceiver
 * JD-Core Version:    0.7.0.1
 */