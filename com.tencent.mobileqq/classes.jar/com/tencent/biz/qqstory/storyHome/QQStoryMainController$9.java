package com.tencent.biz.qqstory.storyHome;

import android.view.View;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;

class QQStoryMainController$9
  implements OnItemSelectListener
{
  QQStoryMainController$9(QQStoryMainController paramQQStoryMainController) {}
  
  public void onItemSelect(View paramView, int paramInt)
  {
    if (paramInt == 1)
    {
      this.a.i.b();
      return;
    }
    if (paramInt == 7) {
      this.a.b.n();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryMainController.9
 * JD-Core Version:    0.7.0.1
 */