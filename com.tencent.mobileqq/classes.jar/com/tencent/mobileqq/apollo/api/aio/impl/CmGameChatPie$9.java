package com.tencent.mobileqq.apollo.api.aio.impl;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.drawable.RoundRectColorDrawable;

class CmGameChatPie$9
  implements ViewTreeObserver.OnPreDrawListener
{
  CmGameChatPie$9(CmGameChatPie paramCmGameChatPie, CmGameChatPie.UserInfo paramUserInfo) {}
  
  public boolean onPreDraw()
  {
    CmGameChatPie.a(this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie).getViewTreeObserver().removeOnPreDrawListener(this);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie$UserInfo.b == 1)
    {
      CmGameChatPie.a(this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie).setBackgroundDrawable(new RoundRectColorDrawable(Color.parseColor("#1fa4fc"), 5.0F, AIOUtils.a(14.0F, this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie.a.getResources()), AIOUtils.a(14.0F, this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie.a.getResources())));
      CmGameChatPie.b(this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie).setBackgroundDrawable(new RoundRectColorDrawable(Color.parseColor("#1fa4fc"), 5.0F, CmGameChatPie.b(this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie).getMeasuredWidth(), CmGameChatPie.b(this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie).getMeasuredHeight()));
      CmGameChatPie.a(this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie).setImageResource(2130839342);
    }
    for (;;)
    {
      CmGameChatPie.a(this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie).setBackgroundDrawable(new RoundRectColorDrawable(Color.parseColor("#b2b5bd"), 5.0F, CmGameChatPie.a(this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie).getMeasuredWidth(), CmGameChatPie.a(this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie).getMeasuredHeight()));
      CmGameChatPie.c(this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie).setBackgroundDrawable(new RoundRectColorDrawable(Color.parseColor("#b2b5bd"), 5.0F, CmGameChatPie.c(this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie).getMeasuredWidth(), CmGameChatPie.c(this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie).getMeasuredHeight()));
      return true;
      CmGameChatPie.a(this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie).setBackgroundDrawable(new RoundRectColorDrawable(Color.parseColor("#ff5fb5"), 5.0F, AIOUtils.a(14.0F, this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie.a.getResources()), AIOUtils.a(14.0F, this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie.a.getResources())));
      CmGameChatPie.b(this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie).setBackgroundDrawable(new RoundRectColorDrawable(Color.parseColor("#ff5fb5"), 5.0F, CmGameChatPie.b(this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie).getMeasuredWidth(), CmGameChatPie.b(this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie).getMeasuredHeight()));
      CmGameChatPie.a(this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie).setImageResource(2130839341);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.aio.impl.CmGameChatPie.9
 * JD-Core Version:    0.7.0.1
 */