package com.tencent.biz.qqstory.storyHome.memory.model;

import android.app.Activity;
import com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesFeedEmptySegment;
import com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesFeedSegment;
import com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesProfileSegment;
import com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesVideoListEmptySegment;
import com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesVideoListSegment;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.IMyStoryListView;
import java.util.ArrayList;
import java.util.List;

public class StoryProfileListViewConfig
{
  public static int a;
  public static int b = 2;
  public Activity a;
  public IMyStoryListView a;
  public String a;
  private List a;
  public int c;
  public int d;
  
  static
  {
    jdField_a_of_type_Int = 1;
  }
  
  public StoryProfileListViewConfig(Activity paramActivity, int paramInt1, String paramString, int paramInt2, IMyStoryListView paramIMyStoryListView)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.d = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.c = paramInt2;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView = paramIMyStoryListView;
    if (paramInt2 == jdField_a_of_type_Int)
    {
      a();
      return;
    }
    if (paramInt2 == b)
    {
      b();
      return;
    }
    throw new IllegalStateException("setup profile list error because unknown list type.");
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilList.add(new MemoriesProfileSegment(this.jdField_a_of_type_AndroidAppActivity, this.d, this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_JavaUtilList.add(new MemoriesFeedSegment(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), this.jdField_a_of_type_AndroidAppActivity, 12, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView, false));
    this.jdField_a_of_type_JavaUtilList.add(new MemoriesFeedEmptySegment(this.jdField_a_of_type_AndroidAppActivity, "FeedSegment", "暂无视频\n拍摄一段小视频，分享眼前的世界", 2130843585, 2130843586));
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilList.add(new MemoriesProfileSegment(this.jdField_a_of_type_AndroidAppActivity, this.d, this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_JavaUtilList.add(new MemoriesVideoListSegment(this.jdField_a_of_type_AndroidAppActivity, this.d, this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_JavaUtilList.add(new MemoriesVideoListEmptySegment(this.jdField_a_of_type_AndroidAppActivity, this.d, this.jdField_a_of_type_JavaLangString));
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.model.StoryProfileListViewConfig
 * JD-Core Version:    0.7.0.1
 */