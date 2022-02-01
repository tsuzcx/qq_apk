package com.tencent.biz.subscribe.utils;

import android.content.Context;
import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

final class SubscribeFollowUserUtil$3
  implements ActionSheet.OnButtonClickListener
{
  SubscribeFollowUserUtil$3(Context paramContext, String paramString, SubscribeFollowUserUtil.ResultListener paramResultListener, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (SubscribeFollowUserUtil.a()) {
      return;
    }
    SubscribeFollowUserUtil.a(true);
    if (paramInt == 0) {
      SubscribeFollowUserUtil.c(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizSubscribeUtilsSubscribeFollowUserUtil$ResultListener);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeFollowUserUtil.3
 * JD-Core Version:    0.7.0.1
 */