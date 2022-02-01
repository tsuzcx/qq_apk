package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.utils.UITools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GrayTipsItemBuilder$14
  implements View.OnClickListener
{
  GrayTipsItemBuilder$14(GrayTipsItemBuilder paramGrayTipsItemBuilder, MessageRecord paramMessageRecord, int paramInt) {}
  
  public void onClick(View paramView)
  {
    Object localObject = UITools.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.a, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin);
    ReportController.b(null, "CliOper", "", "", "0X800A8D8", "0X800A8D8", this.jdField_a_of_type_Int, 0, "", "", "", "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + (String)localObject));
      paramView.getContext().startActivity((Intent)localObject);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QQToast.a(BaseApplicationImpl.getContext(), 2131695696, 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.14
 * JD-Core Version:    0.7.0.1
 */