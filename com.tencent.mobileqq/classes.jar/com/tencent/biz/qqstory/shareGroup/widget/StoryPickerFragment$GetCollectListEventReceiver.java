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
    if (!TextUtils.equals(paramStoryPickerFragment.jdField_a_of_type_JavaLangString, paramGetCollectionListEvent.jdField_a_of_type_JavaLangString)) {
      return;
    }
    boolean bool = paramGetCollectionListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess();
    ArrayList localArrayList = new ArrayList(paramGetCollectionListEvent.jdField_a_of_type_JavaUtilList.size());
    List localList = paramGetCollectionListEvent.jdField_a_of_type_JavaUtilList;
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
          if (paramStoryPickerFragment.jdField_a_of_type_JavaUtilLinkedHashSet.contains(localFakeVideoUIItem.jdField_a_of_type_JavaLangString))
          {
            localFakeVideoUIItem.jdField_a_of_type_Boolean = true;
            if (paramStoryPickerFragment.jdField_a_of_type_JavaUtilLinkedHashSet.size() >= 20) {
              localFakeVideoUIItem.b = true;
            }
          }
          else
          {
            localFakeVideoUIItem.jdField_a_of_type_Boolean = false;
            if (paramStoryPickerFragment.jdField_a_of_type_JavaUtilLinkedHashSet.size() >= 20) {
              localFakeVideoUIItem.b = false;
            } else {
              localFakeVideoUIItem.b = true;
            }
          }
          j += 1;
        }
        localArrayList.add(localVideoCollectionItem);
      }
      i += 1;
    }
    if ((bool) && (paramGetCollectionListEvent.e))
    {
      if (localArrayList.isEmpty())
      {
        paramStoryPickerFragment.jdField_a_of_type_AndroidViewView.setVisibility(0);
        paramStoryPickerFragment.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setVisibility(8);
      }
      else
      {
        paramStoryPickerFragment.jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramStoryPickerFragment.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setVisibility(0);
      }
      if (paramGetCollectionListEvent.c) {
        paramStoryPickerFragment.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerListAdapter.a(localArrayList);
      } else {
        paramStoryPickerFragment.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerListAdapter.b(localArrayList);
      }
    }
    if (paramGetCollectionListEvent.c) {
      paramStoryPickerFragment.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.a(bool);
    }
    paramStoryPickerFragment.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.a.a(bool, paramGetCollectionListEvent.jdField_a_of_type_Boolean ^ true);
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