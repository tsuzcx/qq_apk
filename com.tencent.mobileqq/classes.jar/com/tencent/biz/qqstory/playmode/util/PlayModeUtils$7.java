package com.tencent.biz.qqstory.playmode.util;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.handler.ReportEvilToXinanHandler;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

final class PlayModeUtils$7
  implements ActionSheet.OnButtonClickListener
{
  PlayModeUtils$7(QQUserUIItem paramQQUserUIItem, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          paramView = "16384";
        } else {
          paramView = "4";
        }
      }
      else {
        paramView = "1";
      }
    }
    else {
      paramView = "2";
    }
    QQUserUIItem localQQUserUIItem = this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
    if ((localQQUserUIItem != null) && (!TextUtils.isEmpty(localQQUserUIItem.qq))) {
      new ReportEvilToXinanHandler().a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.qq, this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isFriend(), paramView);
    } else {
      SLog.d("Q.qqstory.player.PlayModeUtils", "report user error because evil uin is empty.");
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.PlayModeUtils.7
 * JD-Core Version:    0.7.0.1
 */