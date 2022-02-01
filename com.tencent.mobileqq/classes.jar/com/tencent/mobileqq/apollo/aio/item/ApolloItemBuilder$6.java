package com.tencent.mobileqq.apollo.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloMessageUtilImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import cooperation.vip.manager.QZoneVipInfoManager;

class ApolloItemBuilder$6
  implements ActionSheet.OnButtonClickListener
{
  ApolloItemBuilder$6(ApolloItemBuilder paramApolloItemBuilder, ApolloItemBuilder.Holder paramHolder, ApolloActionData paramApolloActionData, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt == 0) {
      if ((1 != this.jdField_a_of_type_ComTencentMobileqqApolloAioItemApolloItemBuilder$Holder.f) && (this.jdField_a_of_type_ComTencentMobileqqApolloAioItemApolloItemBuilder$Holder.f != 2))
      {
        if (3 == this.jdField_a_of_type_ComTencentMobileqqApolloAioItemApolloItemBuilder$Holder.f)
        {
          paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqApolloAioItemApolloItemBuilder.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloActionData.url))
          {
            paramView.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloActionData.url);
          }
          else
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(ApolloConstant.l);
            localStringBuilder.append("&id=");
            localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloActionData.actionId);
            paramView.putExtra("url", localStringBuilder.toString());
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloAioItemApolloItemBuilder.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
        }
        else if (4 != this.jdField_a_of_type_ComTencentMobileqqApolloAioItemApolloItemBuilder$Holder.f)
        {
          ApolloMessageUtilImpl.resendApolloMessage(this.jdField_a_of_type_ComTencentMobileqqApolloAioItemApolloItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqApolloAioItemApolloItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqApolloAioItemApolloItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqApolloAioItemApolloItemBuilder$Holder.a.uniseq);
        }
      }
      else
      {
        if (!(this.jdField_a_of_type_ComTencentMobileqqApolloAioItemApolloItemBuilder.jdField_a_of_type_AndroidContentContext instanceof Activity))
        {
          QLog.e("[cmshow]ApolloItemBuilder", 1, "mContext is not activity");
          return;
        }
        QZoneVipInfoManager.a((Activity)this.jdField_a_of_type_ComTencentMobileqqApolloAioItemApolloItemBuilder.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqApolloAioItemApolloItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "lmx_actchat");
      }
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.item.ApolloItemBuilder.6
 * JD-Core Version:    0.7.0.1
 */