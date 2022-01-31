package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.AnimationParam;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;
import sgi;
import thu;
import unw;
import uoh;
import urk;

public class FeedSegment$18
  implements Runnable
{
  public FeedSegment$18(uoh paramuoh, StoryHomeHorizontalListView paramStoryHomeHorizontalListView, List paramList, String paramString) {}
  
  public void run()
  {
    int i = 0;
    for (;;)
    {
      if (i < this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.getChildCount())
      {
        View localView = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.getChildAt(i);
        Object localObject = localView.getTag();
        if ((localObject instanceof unw))
        {
          localObject = (unw)localObject;
          if (((unw)localObject).b < this.jdField_a_of_type_JavaUtilList.size())
          {
            localObject = (StoryVideoItem)this.jdField_a_of_type_JavaUtilList.get(((unw)localObject).b);
            if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, ((StoryVideoItem)localObject).mVid))
            {
              urk.a("Q.qqstory.home:FeedSegment", "broadcast close animation %s", this.jdField_a_of_type_JavaLangString);
              sgi.a().dispatch(new thu(new AnimationParam(localView), this.jdField_a_of_type_JavaLangString));
            }
          }
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.18
 * JD-Core Version:    0.7.0.1
 */