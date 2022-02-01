package com.tencent.biz.qqcircle;

import android.view.View;
import com.tencent.biz.qqcircle.richframework.util.FastClickUtils;
import com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheet;
import com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheet.OnButtonClickListener;

class QCirclePopupWindowHelper$7
  implements ActionSheet.OnButtonClickListener
{
  public void a(View paramView, int paramInt)
  {
    if (!FastClickUtils.a("showUnFollowUserActionSheetClick"))
    {
      if (paramInt != 0)
      {
        if (paramInt == 1) {
          this.a.b();
        }
      }
      else {
        this.a.a();
      }
      this.b.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.QCirclePopupWindowHelper.7
 * JD-Core Version:    0.7.0.1
 */