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
    if (QLog.isColorLevel()) {
      QLog.w("ShareChat", 1, "showChooseTypeActionSheet, which[" + paramInt + "], seq[" + this.jdField_a_of_type_Long + "], mIHandle[" + this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel.a + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel.a == null) {
      return;
    }
    paramView = paramView.getContext();
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel.b(this.jdField_a_of_type_Long, paramView, this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem);
      continue;
      this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel.a(this.jdField_a_of_type_Long, paramView, this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.share.ShareChat.SharePanel.4
 * JD-Core Version:    0.7.0.1
 */