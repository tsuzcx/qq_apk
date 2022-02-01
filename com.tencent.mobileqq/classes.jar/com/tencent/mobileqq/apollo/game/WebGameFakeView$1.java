package com.tencent.mobileqq.apollo.game;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WebGameFakeView$1
  implements View.OnClickListener
{
  WebGameFakeView$1(WebGameFakeView paramWebGameFakeView, ImageView paramImageView) {}
  
  public void onClick(View paramView)
  {
    ApolloFragmentManager.a().a(null);
    if (ApolloFragmentManager.a().a() <= 1) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.WebGameFakeView.1
 * JD-Core Version:    0.7.0.1
 */