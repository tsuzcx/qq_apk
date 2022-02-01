package com.tencent.biz.pubaccount.readinjoy.comment;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

final class ReadInJoyCommentUtils$4
  implements ActionSheet.OnButtonClickListener
{
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfInt.length)) {
      return;
    }
    paramView = this.jdField_a_of_type_AndroidContentContext.getString(this.jdField_a_of_type_ArrayOfInt[paramInt]);
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(this.jdField_a_of_type_AndroidContentContext, 2131755842);
    localQQCustomDialog.setContentView(2131559060);
    localQQCustomDialog.setMessage(String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131718134), new Object[] { paramView }));
    localQQCustomDialog.setTitle(2131718135);
    ViewGroup.LayoutParams localLayoutParams = localQQCustomDialog.getMessageTextView().getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
    {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).leftMargin = ViewUtils.a(12.0F);
      ((ViewGroup.MarginLayoutParams)localLayoutParams).rightMargin = ViewUtils.a(12.0F);
      localQQCustomDialog.getMessageTextView().setLayoutParams(localLayoutParams);
    }
    localQQCustomDialog.setTag(paramView);
    localQQCustomDialog.setPositiveButton(2131718137, new ReadInJoyCommentUtils.4.1(this, paramView, paramInt + 1));
    localQQCustomDialog.setNegativeButton(2131718136, new ReadInJoyCommentUtils.4.2(this));
    localQQCustomDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils.4
 * JD-Core Version:    0.7.0.1
 */