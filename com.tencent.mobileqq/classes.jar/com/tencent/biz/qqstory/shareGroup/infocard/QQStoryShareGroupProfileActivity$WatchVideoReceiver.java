package com.tencent.biz.qqstory.shareGroup.infocard;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.database.HotSortVideoEntry;
import com.tencent.biz.qqstory.model.HotSortVideoManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.handler.WatchVideoHandler.WatchVideoEvent;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListAdapter;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public class QQStoryShareGroupProfileActivity$WatchVideoReceiver
  extends QQUIEventReceiver
{
  public QQStoryShareGroupProfileActivity$WatchVideoReceiver(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull WatchVideoHandler.WatchVideoEvent paramWatchVideoEvent)
  {
    if (!paramQQStoryShareGroupProfileActivity.g) {}
    ShareGroupsListAdapter localShareGroupsListAdapter;
    Object localObject1;
    do
    {
      return;
      Object localObject2 = null;
      localShareGroupsListAdapter = paramQQStoryShareGroupProfileActivity.a.a;
      Iterator localIterator = paramQQStoryShareGroupProfileActivity.a.a.a.iterator();
      do
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (HotSortVideoEntry)localIterator.next();
      } while (!((HotSortVideoEntry)localObject1).storyId.equals(paramWatchVideoEvent.a));
    } while (localObject1 == null);
    ((HotSortVideoEntry)localObject1).viewCount += 1;
    ((HotSortVideoManager)SuperManager.a(25)).a((HotSortVideoEntry)localObject1);
    localShareGroupsListAdapter.a((HotSortVideoEntry)localObject1);
    paramQQStoryShareGroupProfileActivity.d = true;
  }
  
  public Class acceptEventClass()
  {
    return WatchVideoHandler.WatchVideoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity.WatchVideoReceiver
 * JD-Core Version:    0.7.0.1
 */