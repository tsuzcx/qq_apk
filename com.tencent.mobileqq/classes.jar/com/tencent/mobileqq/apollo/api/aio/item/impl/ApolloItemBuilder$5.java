package com.tencent.mobileqq.apollo.api.aio.item.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.uitls.ApolloConstant;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import cooperation.qzone.QZoneVipInfoManager;

class ApolloItemBuilder$5
  implements ActionSheet.OnButtonClickListener
{
  ApolloItemBuilder$5(ApolloItemBuilder paramApolloItemBuilder, ApolloItemBuilder.Holder paramHolder, ApolloActionData paramApolloActionData, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
      return;
      if ((1 == this.jdField_a_of_type_ComTencentMobileqqApolloApiAioItemImplApolloItemBuilder$Holder.f) || (this.jdField_a_of_type_ComTencentMobileqqApolloApiAioItemImplApolloItemBuilder$Holder.f == 2))
      {
        if (!(this.jdField_a_of_type_ComTencentMobileqqApolloApiAioItemImplApolloItemBuilder.jdField_a_of_type_AndroidContentContext instanceof Activity))
        {
          QLog.e("ApolloItemBuilder", 1, "mContext is not activity");
          return;
        }
        QZoneVipInfoManager.cmJumpToYellowPlayDialog((Activity)this.jdField_a_of_type_ComTencentMobileqqApolloApiAioItemImplApolloItemBuilder.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqApolloApiAioItemImplApolloItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "lmx_actchat");
      }
      else
      {
        if (3 == this.jdField_a_of_type_ComTencentMobileqqApolloApiAioItemImplApolloItemBuilder$Holder.f)
        {
          paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqApolloApiAioItemImplApolloItemBuilder.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloActionData.url)) {
            paramView.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloActionData.url);
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentMobileqqApolloApiAioItemImplApolloItemBuilder.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
            break;
            paramView.putExtra("url", ApolloConstant.g + "&id=" + this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloActionData.actionId);
          }
        }
        if (4 != this.jdField_a_of_type_ComTencentMobileqqApolloApiAioItemImplApolloItemBuilder$Holder.f) {
          ChatActivityFacade.c(this.jdField_a_of_type_ComTencentMobileqqApolloApiAioItemImplApolloItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqApolloApiAioItemImplApolloItemBuilder.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqApolloApiAioItemImplApolloItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqApolloApiAioItemImplApolloItemBuilder$Holder.a.uniseq);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.aio.item.impl.ApolloItemBuilder.5
 * JD-Core Version:    0.7.0.1
 */