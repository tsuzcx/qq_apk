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
  public IApolloIceBreakShow a;
  
  public ApolloStickerRecView(IStickerPresenter paramIStickerPresenter, Activity paramActivity, BaseAIOContext paramBaseAIOContext, ViewGroup paramViewGroup, EditText paramEditText, AppInterface paramAppInterface)
  {
    super(paramIStickerPresenter, paramActivity, paramBaseAIOContext, paramViewGroup, paramEditText);
    this.jdField_a_of_type_ComTencentMobileqqApolloAioItemApiIApolloIceBreakShow = ((IApolloIceBreakShow)QRoute.api(IApolloIceBreakShow.class));
    this.jdField_a_of_type_ComTencentMobileqqApolloAioItemApiIApolloIceBreakShow.init(paramActivity.getApplicationContext(), this.b, this.jdField_a_of_type_Int, paramAppInterface);
    paramIStickerPresenter = this.jdField_a_of_type_ComTencentMobileqqApolloAioItemApiIApolloIceBreakShow.getView();
    paramIStickerPresenter.setId(2131377907);
    paramActivity = new RelativeLayout.LayoutParams(this.b, this.jdField_a_of_type_Int);
    paramActivity.addRule(13, -1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramIStickerPresenter, paramActivity);
  }
  
  public void a()
  {
    IApolloIceBreakShow localIApolloIceBreakShow = this.jdField_a_of_type_ComTencentMobileqqApolloAioItemApiIApolloIceBreakShow;
    if ((localIApolloIceBreakShow != null) && (localIApolloIceBreakShow.isPlaying())) {
      this.jdField_a_of_type_ComTencentMobileqqApolloAioItemApiIApolloIceBreakShow.pause();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(false);
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(4);
      IApolloIceBreakShow localIApolloIceBreakShow = this.jdField_a_of_type_ComTencentMobileqqApolloAioItemApiIApolloIceBreakShow;
      if (localIApolloIceBreakShow != null) {
        localIApolloIceBreakShow.getView().setVisibility(0);
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    }
  }
  
  public void b()
  {
    IApolloIceBreakShow localIApolloIceBreakShow = this.jdField_a_of_type_ComTencentMobileqqApolloAioItemApiIApolloIceBreakShow;
    if ((localIApolloIceBreakShow != null) && (localIApolloIceBreakShow.getView().getVisibility() == 0) && (this.jdField_a_of_type_ComTencentMobileqqApolloAioItemApiIApolloIceBreakShow.isReady())) {
      this.jdField_a_of_type_ComTencentMobileqqApolloAioItemApiIApolloIceBreakShow.play();
    }
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.mvp.ApolloStickerRecView
 * JD-Core Version:    0.7.0.1
 */