package com.tencent.biz.qqcircle.debug;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.richframework.util.FastClickUtils;
import com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheet;
import com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheet.OnButtonClickListener;

final class QCircleDebugActionSheet$1
  implements ActionSheet.OnButtonClickListener
{
  QCircleDebugActionSheet$1(ActionSheet paramActionSheet, QCircleShareInfo paramQCircleShareInfo) {}
  
  public void a(View paramView, int paramInt)
  {
    if (!FastClickUtils.a("showMoreActionSheetClick"))
    {
      String str = this.a.d(paramInt);
      if (TextUtils.isEmpty(str)) {
        return;
      }
      if (str.equals(paramView.getContext().getResources().getString(2131895681))) {
        QCircleDebugActionSheet.a(this.b.b);
      } else if (str.equals(paramView.getContext().getResources().getString(2131895680))) {
        QCircleDebugActionSheet.b(this.b.b);
      } else if (str.equals(paramView.getContext().getResources().getString(2131895663))) {
        QCircleDebugActionSheet.c(this.b.b);
      } else if (str.equals(paramView.getContext().getResources().getString(2131895662))) {
        QCircleDebugActionSheet.d(this.b.b);
      }
      this.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.debug.QCircleDebugActionSheet.1
 * JD-Core Version:    0.7.0.1
 */