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
    paramStoryPickerFragment.jdField_a_of_type_JavaUtilLinkedHashSet.clear();
    paramStoryPickerFragment.jdField_a_of_type_JavaUtilLinkedHashSet.addAll(paramSelectedVideosEvent.jdField_a_of_type_JavaUtilArrayList);
    List localList = paramStoryPickerFragment.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerListAdapter.a();
    int i = 0;
    while (i < localList.size())
    {
      Iterator localIterator = ((VideoCollectionItem)localList.get(i)).collectionVideoUIItemList.iterator();
      while (localIterator.hasNext())
      {
        VideoCollectionItem.FakeVideoUIItem localFakeVideoUIItem = (VideoCollectionItem.FakeVideoUIItem)localIterator.next();
        if (paramSelectedVideosEvent.jdField_a_of_type_JavaUtilArrayList.contains(localFakeVideoUIItem.jdField_a_of_type_JavaLangString)) {
          localFakeVideoUIItem.jdField_a_of_type_Boolean = true;
        } else {
          localFakeVideoUIItem.jdField_a_of_type_Boolean = false;
        }
      }
      i += 1;
    }
    paramStoryPickerFragment.c();
    if (paramSelectedVideosEvent.jdField_a_of_type_Boolean) {
      paramStoryPickerFragment.rightViewText.performClick();
    }
  }
  
  public Class acceptEventClass()
  {
    return SelectVideoPlayerStrategy.SelectedVideosEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.widget.StoryPickerFragment.CheckedVideosEventReceiver
 * JD-Core Version:    0.7.0.1
 */