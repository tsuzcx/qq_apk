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
      this.a.setText(MoveFileActivity.a(this.b));
      return;
    }
    String str1 = MoveFileActivity.a(this.b).substring(0, paramInt1);
    String str2 = MoveFileActivity.a(this.b).substring(paramInt2, MoveFileActivity.a(this.b).length());
    TextView localTextView = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str1);
    localStringBuilder.append("...");
    localStringBuilder.append(str2);
    localTextView.setText(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.file.MoveFileActivity.1
 * JD-Core Version:    0.7.0.1
 */