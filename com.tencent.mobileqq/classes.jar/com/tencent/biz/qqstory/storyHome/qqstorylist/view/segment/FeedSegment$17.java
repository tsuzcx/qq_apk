package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.AnimationParam;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.VideoListLayout;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;
import vli;
import wmf;
import xsh;
import xss;
import xvv;

public class FeedSegment$17
  implements Runnable
{
  public FeedSegment$17(xss paramxss, List paramList, VideoListLayout paramVideoListLayout, String paramString) {}
  
  public void run()
  {
    Object localObject1;
    if (this.jdField_a_of_type_JavaUtilList.size() == 1)
    {
      localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewVideoListLayout.a();
      xvv.a("Q.qqstory.home:FeedSegment", "broadcast close animation %s", this.jdField_a_of_type_JavaLangString);
      vli.a().dispatch(new wmf(new AnimationParam((View)localObject1), this.jdField_a_of_type_JavaLangString));
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_JavaUtilList.size() == 2)
      {
        localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewVideoListLayout.a();
        int i = 0;
        while (i < ((StoryHomeHorizontalListView)localObject1).getChildCount())
        {
          View localView = ((StoryHomeHorizontalListView)localObject1).getChildAt(i);
          Object localObject2 = localView.getTag();
          if ((localObject2 instanceof xsh))
          {
            localObject2 = (xsh)localObject2;
            if (((xsh)localObject2).b < this.jdField_a_of_type_JavaUtilList.size())
            {
              localObject2 = (StoryVideoItem)this.jdField_a_of_type_JavaUtilList.get(((xsh)localObject2).b);
              if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, ((StoryVideoItem)localObject2).mVid))
              {
                xvv.a("Q.qqstory.home:FeedSegment", "broadcast close animation %s", this.jdField_a_of_type_JavaLangString);
                vli.a().dispatch(new wmf(new AnimationParam(localView), this.jdField_a_of_type_JavaLangString));
                return;
              }
            }
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.17
 * JD-Core Version:    0.7.0.1
 */