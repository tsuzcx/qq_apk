package com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.mvp;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.apollo.aio.item.api.IApolloIceBreakShow;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ApolloStickerRecView
  extends CommonStickerRecView
{
  public IApolloIceBreakShow a = (IApolloIceBreakShow)QRoute.api(IApolloIceBreakShow.class);
  
  public ApolloStickerRecView(IStickerPresenter paramIStickerPresenter, Activity paramActivity, BaseAIOContext paramBaseAIOContext, ViewGroup paramViewGroup, EditText paramEditText, AppInterface paramAppInterface)
  {
    super(paramIStickerPresenter, paramActivity, paramBaseAIOContext, paramViewGroup, paramEditText);
    this.a.init(paramActivity.getApplicationContext(), this.c, this.b, paramAppInterface);
    paramIStickerPresenter = this.a.getView();
    paramIStickerPresenter.setId(2131446390);
    paramActivity = new RelativeLayout.LayoutParams(this.c, this.b);
    paramActivity.addRule(13, -1);
    this.g.addView(paramIStickerPresenter, paramActivity);
  }
  
  public void a()
  {
    IApolloIceBreakShow localIApolloIceBreakShow = this.a;
    if ((localIApolloIceBreakShow != null) && (localIApolloIceBreakShow.isPlaying())) {
      this.a.pause();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(false);
    if (paramBoolean)
    {
      this.e.setVisibility(4);
      IApolloIceBreakShow localIApolloIceBreakShow = this.a;
      if (localIApolloIceBreakShow != null) {
        localIApolloIceBreakShow.getView().setVisibility(0);
      }
      this.g.setOnClickListener(this);
    }
  }
  
  public void b()
  {
    IApolloIceBreakShow localIApolloIceBreakShow = this.a;
    if ((localIApolloIceBreakShow != null) && (localIApolloIceBreakShow.getView().getVisibility() == 0) && (this.a.isReady())) {
      this.a.play();
    }
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.mvp.ApolloStickerRecView
 * JD-Core Version:    0.7.0.1
 */