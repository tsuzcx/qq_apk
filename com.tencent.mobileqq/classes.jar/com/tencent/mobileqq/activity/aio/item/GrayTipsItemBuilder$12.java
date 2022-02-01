package com.tencent.mobileqq.activity.aio.item;

import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil.TipsClickedInterface;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vip.AioVipKeywordHelper;

class GrayTipsItemBuilder$12
  implements QQFileManagerUtil.TipsClickedInterface
{
  GrayTipsItemBuilder$12(GrayTipsItemBuilder paramGrayTipsItemBuilder, String paramString1, String paramString2, MessageRecord paramMessageRecord, String paramString3, AioVipKeywordHelper paramAioVipKeywordHelper) {}
  
  public void onClick(View paramView)
  {
    paramView = new Bundle();
    paramView.putString(VasH5PayUtil.i, this.jdField_a_of_type_JavaLangString);
    paramView.putString(VasH5PayUtil.c, this.b);
    if (!this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend()) {
      paramView.putString(VasH5PayUtil.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin);
    }
    VasH5PayUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, paramView);
    String str = this.c;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend()) {
      paramView = "0";
    } else {
      paramView = "1";
    }
    VasWebviewUtil.a(str, paramView, "1", this.jdField_a_of_type_ComTencentMobileqqVipAioVipKeywordHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.12
 * JD-Core Version:    0.7.0.1
 */