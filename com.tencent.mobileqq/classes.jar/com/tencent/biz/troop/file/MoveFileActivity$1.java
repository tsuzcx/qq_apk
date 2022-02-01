package com.tencent.biz.troop.file;

import android.text.TextUtils.EllipsizeCallback;
import android.widget.TextView;

class MoveFileActivity$1
  implements TextUtils.EllipsizeCallback
{
  MoveFileActivity$1(MoveFileActivity paramMoveFileActivity, TextView paramTextView) {}
  
  public void ellipsized(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(MoveFileActivity.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity));
      return;
    }
    String str1 = MoveFileActivity.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity).substring(0, paramInt1);
    String str2 = MoveFileActivity.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity).substring(paramInt2, MoveFileActivity.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity).length());
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str1);
    localStringBuilder.append("...");
    localStringBuilder.append(str2);
    localTextView.setText(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.file.MoveFileActivity.1
 * JD-Core Version:    0.7.0.1
 */