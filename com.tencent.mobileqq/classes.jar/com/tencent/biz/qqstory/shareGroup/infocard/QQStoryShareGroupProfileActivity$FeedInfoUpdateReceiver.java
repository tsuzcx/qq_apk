package com.tencent.biz.qqstory.shareGroup.infocard;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.comment.FeedInfoChangeEvent;
import com.tencent.biz.qqstory.database.HotSortVideoEntry;
import com.tencent.biz.qqstory.model.HotSortVideoManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListAdapter;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QQStoryShareGroupProfileActivity$FeedInfoUpdateReceiver
  extends UIBaseEventReceiver<QQStoryShareGroupProfileActivity, FeedInfoChangeEvent>
{
  public QQStoryShareGroupProfileActivity$FeedInfoUpdateReceiver(QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull FeedInfoChangeEvent paramFeedInfoChangeEvent)
  {
    if (paramFeedInfoChangeEvent.d == 3)
    {
      if (paramFeedInfoChangeEvent.c == null) {
        return;
      }
      int i;
      if (paramFeedInfoChangeEvent.c.mHadLike == 1) {
        i = 1;
      } else {
        i = 0;
      }
      ShareGroupsListAdapter localShareGroupsListAdapter = paramQQStoryShareGroupProfileActivity.d.f;
      Object localObject = paramQQStoryShareGroupProfileActivity.d.f.i;
      ArrayList localArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        HotSortVideoEntry localHotSortVideoEntry = (HotSortVideoEntry)((Iterator)localObject).next();
        if (localHotSortVideoEntry.feedId.equals(paramFeedInfoChangeEvent.b))
        {
          int j;
          if (i != 0) {
            j = localHotSortVideoEntry.likeCount + 1;
          } else {
            j = localHotSortVideoEntry.likeCount - 1;
          }
          localHotSortVideoEntry.likeCount = j;
          if (localHotSortVideoEntry.likeCount < 0) {
            localHotSortVideoEntry.likeCount = 0;
          }
          localShareGroupsListAdapter.a(localHotSortVideoEntry);
          localArrayList.add(localHotSortVideoEntry);
        }
      }
      if (localArrayList.size() > 0)
      {
        ((HotSortVideoManager)SuperManager.a(25)).a(localArrayList);
        paramQQStoryShareGroupProfileActivity.D = true;
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return FeedInfoChangeEvent.class;
  }
  
  public void b(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull FeedInfoChangeEvent paramFeedInfoChangeEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity.FeedInfoUpdateReceiver
 * JD-Core Version:    0.7.0.1
 */