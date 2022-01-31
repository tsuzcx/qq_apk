package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.AnimationParam;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;
import ste;
import tuq;
import vas;
import vbd;
import veg;

public class FeedSegment$18
  implements Runnable
{
  public FeedSegment$18(vbd paramvbd, StoryHomeHorizontalListView paramStoryHomeHorizontalListView, List paramList, String paramString) {}
  
  public void run()
  {
    int i = 0;
    for (;;)
    {
      if (i < this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.getChildCount())
      {
        View localView = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.getChildAt(i);
        Object localObject = localView.getTag();
        if ((localObject instanceof vas))
        {
          localObject = (vas)localObject;
          if (((vas)localObject).b < this.jdField_a_of_type_JavaUtilList.size())
          {
            localObject = (StoryVideoItem)this.jdField_a_of_type_JavaUtilList.get(((vas)localObject).b);
            if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, ((StoryVideoItem)localObject).mVid))
            {
              veg.a("Q.qqstory.home:FeedSegment", "broadcast close animation %s", this.jdField_a_of_type_JavaLangString);
              ste.a().dispatch(new tuq(new AnimationParam(localView), this.jdField_a_of_type_JavaLangString));
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