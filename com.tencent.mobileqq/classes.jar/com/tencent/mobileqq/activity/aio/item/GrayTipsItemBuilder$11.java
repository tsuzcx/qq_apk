package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.TipsClickedInterface;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;

class GrayTipsItemBuilder$11
  implements FileManagerUtil.TipsClickedInterface
{
  GrayTipsItemBuilder$11(GrayTipsItemBuilder paramGrayTipsItemBuilder, int paramInt1, int paramInt2, String paramString, int paramInt3) {}
  
  public void onClick(View paramView)
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      QLog.e("GrayTipsItemBuilder", 1, "handle renewal gray tips click, action not support yet, action=" + this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      FileManagerDataCenter.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -4020);
      do
      {
        return;
        GrayTipsItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder);
        break;
        GrayTipsItemBuilder.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder);
        break;
        paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        paramView.putExtra("individuation_url_type", 40306);
        VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, IndividuationUrlHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, "bubble", "mvip.gongneng.android.bubble.index_dynamic_tab"), 64L, paramView, false, -1);
        VasWebviewUtil.reportCommercialDrainage("", "aio_pay", "aio_bubble", "", 1, 0, 0, "", "", "");
        break;
        GrayTipsItemBuilder.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder);
        break;
        GrayTipsItemBuilder.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder);
        break;
        GrayTipsItemBuilder.e(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder);
        break;
        paramView = new Intent();
        paramView.putExtra("vasUsePreWebview", true);
        paramView.putExtra("bg_replace_entrance", 8);
        paramView.putExtra("hide_left_button", false);
        paramView.putExtra("show_right_close_button", false);
        paramView.putExtra("individuation_url_type", 40306);
        VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, IndividuationUrlHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, "background", ""), 33554432L, paramView, false, -1);
        VasWebviewUtil.reportCommercialDrainage("", "aio_pay", "aio_background", "", 1, 0, 0, "", "", "");
        break;
        ProfileCardUtil.a((Activity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "inside.myIndividuation", 1, 2, 1, "", false, false, "");
        VasWebviewUtil.reportCommercialDrainage("", "aio_pay", "aio_card", "", 1, 0, 0, "", "", "");
        break;
        paramView = IndividualRedPacketManager.a(2, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      } while (TextUtils.isEmpty(paramView));
      Object localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("individuation_url_type", 40100);
      VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, paramView, 134217728L, (Intent)localObject, true, -1);
      VasWebviewUtil.reportCommercialDrainage("", "aio_pay", "aio_redbag", "", 1, 0, 0, "", "", "");
      continue;
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramView.putExtra("individuation_url_type", 40302);
      VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, IndividuationUrlHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, "bubbleDetailDialog", String.valueOf(this.b), "mvip.gongneng.android.bubble.index_dynamic_tab"), 64L, paramView, false, -1);
      VasWebviewUtil.reportCommercialDrainage("", "aio_pay", "aio_detail", "", 1, 0, 0, "", "", "");
      continue;
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramView.putExtra("individuation_url_type", 40302);
      VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, IndividuationUrlHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, "fontDetailDialog", String.valueOf(this.b), "mvip.gexinghua.mobile.font.client_tab_store"), 4096L, paramView, false, -1);
      VasWebviewUtil.reportCommercialDrainage("", "aio_pay", "aio_detail", "", 1, 0, 0, "", "", "");
      continue;
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
      paramView.putExtra("hide_left_button", false);
      paramView.putExtra("show_right_close_button", false);
      paramView.putExtra("url", IndividuationUrlHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, "pendantDetailDialog", String.valueOf(this.b), "mvip.gexinghua.mobile.faceaddon.client_tab_store"));
      paramView.putExtra("business", 512L);
      paramView.putExtra("individuation_url_type", 40100);
      VasWebviewUtil.insertVasWbPluginToIntent(512L, paramView);
      paramView.putExtra("isShowAd", false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      VasWebviewUtil.reportCommercialDrainage("", "aio_pay", "aio_detail", "", 1, 0, 0, "", "", "");
      continue;
      paramView = new Intent();
      paramView.putExtra("individuation_url_type", 40100);
      localObject = IndividuationUrlHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, "backgroundDetail", String.valueOf(this.b), "");
      VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, (String)localObject, 33554432L, paramView, false, -1);
      VasWebviewUtil.reportCommercialDrainage("", "aio_pay", "aio_detail", "", 1, 0, 0, "", "", "");
      continue;
      GrayTipsItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder, this.jdField_a_of_type_JavaLangString);
      continue;
      VasH5PayUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, "mvip.gexinghua.android.aio_pay", "LTMCLUB", 3, false, false);
      VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "aio_pay", "aio_payclk", "", 1, 0, 0, "", String.valueOf(this.c), "");
      continue;
      VasH5PayUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, "mvip.gexinghua.android.aio_pay", "CJCLUBT", 3, false, false);
      VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "aio_pay", "aio_payclk", "", 1, 0, 0, "", String.valueOf(this.c), "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.11
 * JD-Core Version:    0.7.0.1
 */