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
    if ((paramFeedInfoChangeEvent.b != 3) || (paramFeedInfoChangeEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem == null)) {}
    ArrayList localArrayList;
    label68:
    do
    {
      return;
      int i;
      ShareGroupsListAdapter localShareGroupsListAdapter;
      HotSortVideoEntry localHotSortVideoEntry;
      if (paramFeedInfoChangeEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike == 1)
      {
        i = 1;
        localShareGroupsListAdapter = paramQQStoryShareGroupProfileActivity.a.a;
        Object localObject = paramQQStoryShareGroupProfileActivity.a.a.a;
        localArrayList = new ArrayList();
        localObject = ((List)localObject).iterator();
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localHotSortVideoEntry = (HotSortVideoEntry)((Iterator)localObject).next();
        } while (!localHotSortVideoEntry.feedId.equals(paramFeedInfoChangeEvent.jdField_a_of_type_JavaLangString));
        if (i == 0) {
          break label164;
        }
      }
      for (int j = localHotSortVideoEntry.likeCount + 1;; j = localHotSortVideoEntry.likeCount - 1)
      {
        localHotSortVideoEntry.likeCount = j;
        if (localHotSortVideoEntry.likeCount < 0) {
          localHotSortVideoEntry.likeCount = 0;
        }
        localShareGroupsListAdapter.a(localHotSortVideoEntry);
        localArrayList.add(localHotSortVideoEntry);
        break label68;
        i = 0;
        break;
      }
    } while (localArrayList.size() <= 0);
    label164:
    ((HotSortVideoManager)SuperManager.a(25)).a(localArrayList);
    paramQQStoryShareGroupProfileActivity.d = true;
  }
  
  public Class acceptEventClass()
  {
    return FeedInfoChangeEvent.class;
  }
  
  public void b(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull FeedInfoChangeEvent paramFeedInfoChangeEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity.FeedInfoUpdateReceiver
 * JD-Core Version:    0.7.0.1
 */