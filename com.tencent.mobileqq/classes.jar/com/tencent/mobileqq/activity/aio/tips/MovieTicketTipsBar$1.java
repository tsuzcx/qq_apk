package com.tencent.mobileqq.activity.aio.tips;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MovieTicketTipsBar$1
  implements View.OnClickListener
{
  MovieTicketTipsBar$1(MovieTicketTipsBar paramMovieTicketTipsBar) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(MovieTicketTipsBar.a(this.a), QQBrowserActivity.class);
    localIntent.putExtra("url", MovieTicketTipsBar.b(this.a));
    MovieTicketTipsBar.a(this.a).startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.MovieTicketTipsBar.1
 * JD-Core Version:    0.7.0.1
 */