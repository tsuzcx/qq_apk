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
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 3) {
          return true;
        }
        QQStoryFeedItemBuilder.a(this.a).f.setVisibility(4);
        QQStoryFeedItemBuilder.a(this.a).e.setPressed(false);
        return true;
      }
      QQStoryFeedItemBuilder.a(this.a).f.setVisibility(4);
      QQStoryFeedItemBuilder.a(this.a).e.setPressed(false);
      paramView.performClick();
      QQStoryFeedItemBuilder.a(this.a, paramView);
      return true;
    }
    QQStoryFeedItemBuilder.a(this.a).f.setVisibility(0);
    QQStoryFeedItemBuilder.a(this.a).e.setPressed(true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQStoryFeedItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */