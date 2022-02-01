package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class HotChatHelper$7
  implements AdapterView.OnItemClickListener
{
  HotChatHelper$7(ShareActionSheetBuilder paramShareActionSheetBuilder, int paramInt, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = paramView.getTag();
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
      int j = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject).a.action;
      int i = this.jdField_a_of_type_Int;
      localObject = "";
      if (1 == i) {
        localObject = "0X8005D50";
      }
      for (;;)
      {
        break;
        if (2 == i) {
          localObject = "0X8005D51";
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        if (j != 2)
        {
          if (j != 3)
          {
            if (j != 9)
            {
              if (j == 10) {
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, "4", "", "", "");
              }
            }
            else {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, "3", "", "", "");
            }
          }
          else {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, "2", "", "", "");
          }
        }
        else {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, "1", "", "", "");
        }
      }
      if ((j == 9) || (j == 10))
      {
        if (!WXShareHelper.a().a()) {
          i = 2131720478;
        } else if (!WXShareHelper.a().b()) {
          i = 2131720479;
        } else {
          i = -1;
        }
        if (i != -1)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
          QQToast.a((Context)localObject, ((BaseActivity)localObject).getString(i), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimensionPixelSize(2131299168));
          break label548;
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("邀请加入QQ热聊：");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      localObject = ((StringBuilder)localObject).toString();
      if (j != 2)
      {
        if (j != 3)
        {
          if (j != 9)
          {
            if (j == 10) {
              HotChatHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaLangString, (String)localObject, this.b, this.f, this.c, this.g);
            }
          }
          else {
            HotChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaLangString, (String)localObject, "立即加入，一起热聊！\nQQ热聊有上百个热门话题，与同兴趣的人一起群聊。", this.f, this.c, this.g);
          }
        }
        else {
          HotChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaLangString, (String)localObject, this.b, this.c, this.e);
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131705639));
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131705640));
        localObject = ((StringBuilder)localObject).toString();
        HotChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaLangString, (String)localObject, this.b, this.c, this.d, this.e, false);
      }
    }
    label548:
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.HotChatHelper.7
 * JD-Core Version:    0.7.0.1
 */