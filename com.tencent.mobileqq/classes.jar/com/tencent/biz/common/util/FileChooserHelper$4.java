package com.tencent.biz.common.util;

import android.app.Activity;
import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class FileChooserHelper$4
  implements ActionSheet.OnButtonClickListener
{
  FileChooserHelper$4(FileChooserHelper paramFileChooserHelper, Activity paramActivity, String paramString, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        FileChooserHelper.a(this.jdField_a_of_type_ComTencentBizCommonUtilFileChooserHelper, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString);
      }
    }
    else {
      FileChooserHelper.b(this.jdField_a_of_type_ComTencentBizCommonUtilFileChooserHelper, this.jdField_a_of_type_AndroidAppActivity);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.common.util.FileChooserHelper.4
 * JD-Core Version:    0.7.0.1
 */