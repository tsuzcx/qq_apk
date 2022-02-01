package com.tencent.biz.qqstory.playvideo;

import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class QQStoryWatcherListActivity$1
  implements AbsListView.OnScrollListener
{
  int jdField_a_of_type_Int = 0;
  int b = 0;
  int c = 0;
  
  QQStoryWatcherListActivity$1(QQStoryWatcherListActivity paramQQStoryWatcherListActivity) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
    this.b = paramInt3;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.c + this.jdField_a_of_type_Int >= this.b))
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity.b) {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity.a(3);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity.a(1);
    QQStoryWatcherListActivity.GetWatcherHelper.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.QQStoryWatcherListActivity.1
 * JD-Core Version:    0.7.0.1
 */