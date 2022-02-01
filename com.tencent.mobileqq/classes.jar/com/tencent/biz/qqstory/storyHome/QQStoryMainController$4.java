package com.tencent.biz.qqstory.storyHome;

import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.comment.StoryInputBarView;
import xur;
import xuz;

class QQStoryMainController$4
  implements Runnable
{
  QQStoryMainController$4(QQStoryMainController paramQQStoryMainController) {}
  
  public void run()
  {
    if (QQStoryMainController.a(this.this$0)) {
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView = this.this$0.a();
    this.this$0.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.setInputViewHideListener(this.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView);
    this.this$0.jdField_a_of_type_Xuz.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.a(), this.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView);
    QQStoryMainController.a(this.this$0, this.this$0.jdField_a_of_type_Xur.a());
    QQStoryMainController.a(this.this$0, this.this$0.jdField_a_of_type_Xur.a());
    QQStoryMainController.a(this.this$0).setVisibility(8);
    QQStoryMainController.a(this.this$0).setVisibility(8);
    QQStoryMainController.a(this.this$0.jdField_a_of_type_AndroidAppActivity, "mainHallConfig", QQStoryMainController.a(this.this$0), QQStoryMainController.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryMainController.4
 * JD-Core Version:    0.7.0.1
 */