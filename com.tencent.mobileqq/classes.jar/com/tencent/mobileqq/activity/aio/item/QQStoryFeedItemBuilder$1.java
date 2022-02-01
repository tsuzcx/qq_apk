package com.tencent.mobileqq.activity.aio.item;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;

class QQStoryFeedItemBuilder$1
  implements View.OnTouchListener
{
  QQStoryFeedItemBuilder$1(QQStoryFeedItemBuilder paramQQStoryFeedItemBuilder) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      return true;
    case 0: 
      QQStoryFeedItemBuilder.a(this.a).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      QQStoryFeedItemBuilder.a(this.a).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setPressed(true);
      return true;
    case 3: 
      QQStoryFeedItemBuilder.a(this.a).jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      QQStoryFeedItemBuilder.a(this.a).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setPressed(false);
      return true;
    }
    QQStoryFeedItemBuilder.a(this.a).jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    QQStoryFeedItemBuilder.a(this.a).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setPressed(false);
    paramView.performClick();
    QQStoryFeedItemBuilder.a(this.a, paramView);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQStoryFeedItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */