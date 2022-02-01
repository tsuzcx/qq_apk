package com.tencent.av.share;

import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ShareChat$SharePanel$4
  implements ActionSheet.OnButtonClickListener
{
  public void OnClick(View paramView, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showChooseTypeActionSheet, which[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append("], mIHandle[");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel.a);
      localStringBuilder.append("]");
      QLog.w("ShareChat", 1, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel.a == null) {
      return;
    }
    paramView = paramView.getContext();
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel.a(this.jdField_a_of_type_Long, paramView, this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem);
      }
    }
    else {
      this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel.b(this.jdField_a_of_type_Long, paramView, this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.share.ShareChat.SharePanel.4
 * JD-Core Version:    0.7.0.1
 */