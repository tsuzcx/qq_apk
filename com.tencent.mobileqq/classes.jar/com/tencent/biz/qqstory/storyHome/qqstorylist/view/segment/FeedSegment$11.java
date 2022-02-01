package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.view.View;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.StoryHomeFeed;
import com.tencent.biz.qqstory.storyHome.model.TagUserItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.VideoListLayout;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.List;

class FeedSegment$11
  implements ActionSheet.OnButtonClickListener
{
  FeedSegment$11(FeedSegment paramFeedSegment, ActionSheet paramActionSheet, int paramInt, StoryHomeFeed paramStoryHomeFeed) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.superDismiss();
    if (paramInt != 0) {
      return;
    }
    FeedSegment.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment, this.jdField_a_of_type_Int);
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelStoryHomeFeed.a().type == 3)
    {
      if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelStoryHomeFeed.a().getOwner() instanceof QQUserUIItem))
      {
        paramView = ((QQUserUIItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelStoryHomeFeed.a().getOwner()).qq;
        localObject1 = new StringBuilder();
        localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment.a(this.jdField_a_of_type_Int);
        if (localObject2 != null)
        {
          localObject2 = (VideoListLayout)((BaseViewHolder)localObject2).a(2131374522);
          if (localObject2 != null)
          {
            localObject2 = ((VideoListLayout)localObject2).a();
            if (localObject2 != null)
            {
              paramInt = ((StoryHomeHorizontalListView)localObject2).getFirstVisiblePosition();
              while (paramInt <= ((StoryHomeHorizontalListView)localObject2).getLastVisiblePosition())
              {
                List localList = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelStoryHomeFeed.d();
                if ((paramInt >= 0) && (paramInt < localList.size()))
                {
                  ((StringBuilder)localObject1).append(((StoryVideoItem)localList.get(paramInt)).mVid);
                  if (paramInt < ((StoryHomeHorizontalListView)localObject2).getLastVisiblePosition()) {
                    ((StringBuilder)localObject1).append(",");
                  }
                }
                paramInt += 1;
              }
            }
          }
        }
        StoryReportor.c("video_nenegative", "close_IDrecommend", 0, 0, new String[] { "", paramView, "", ((StringBuilder)localObject1).toString() });
      }
    }
    else if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelStoryHomeFeed.a().type == 6) && ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelStoryHomeFeed.a().getOwner() instanceof TagUserItem)))
    {
      long l = ((TagUserItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelStoryHomeFeed.a().getOwner()).tagId;
      paramView = new StringBuilder();
      localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment.a(this.jdField_a_of_type_Int);
      if (localObject1 != null)
      {
        localObject1 = (VideoListLayout)((BaseViewHolder)localObject1).a(2131374522);
        if (localObject1 != null)
        {
          localObject1 = ((VideoListLayout)localObject1).a();
          if (localObject1 != null)
          {
            paramInt = ((StoryHomeHorizontalListView)localObject1).getFirstVisiblePosition();
            while (paramInt <= ((StoryHomeHorizontalListView)localObject1).getLastVisiblePosition())
            {
              localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelStoryHomeFeed.d();
              if ((paramInt >= 0) && (paramInt < ((List)localObject2).size()))
              {
                paramView.append(((StoryVideoItem)((List)localObject2).get(paramInt)).mVid);
                if (paramInt < ((StoryHomeHorizontalListView)localObject1).getLastVisiblePosition()) {
                  paramView.append(",");
                }
              }
              paramInt += 1;
            }
          }
        }
      }
      StoryReportor.c("video_nenegative", "close_newsrecommend", 0, 0, new String[] { "", String.valueOf(l), "", paramView.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.11
 * JD-Core Version:    0.7.0.1
 */