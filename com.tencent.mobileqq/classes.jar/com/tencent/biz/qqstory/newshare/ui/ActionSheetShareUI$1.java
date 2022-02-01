package com.tencent.biz.qqstory.newshare.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;

class ActionSheetShareUI$1
  implements AdapterView.OnItemClickListener
{
  ActionSheetShareUI$1(ActionSheetShareUI paramActionSheetShareUI) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (ActionSheetShareUI.a(this.a).getActionSheet().isShowing()) {
      ActionSheetShareUI.a(this.a).getActionSheet().dismiss();
    }
    int j = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)paramView.getTag()).a.action;
    int i;
    if ((j == 9) || (j == 10)) {
      if (!WXShareHelper.a().a()) {
        i = 2131720753;
      }
    }
    for (;;)
    {
      if (i != -1) {
        QRUtils.a(1, i);
      }
      for (;;)
      {
        EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
        return;
        if (WXShareHelper.a().b()) {
          break label123;
        }
        i = 2131720754;
        break;
        this.a.a(j);
      }
      label123:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.ui.ActionSheetShareUI.1
 * JD-Core Version:    0.7.0.1
 */