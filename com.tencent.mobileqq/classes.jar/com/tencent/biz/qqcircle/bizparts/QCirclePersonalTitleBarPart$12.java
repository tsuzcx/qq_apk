package com.tencent.biz.qqcircle.bizparts;

import android.view.View;
import com.tencent.biz.qqcircle.richframework.util.FastClickUtils;
import com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheet;
import com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheet.OnButtonClickListener;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;

class QCirclePersonalTitleBarPart$12
  implements ActionSheet.OnButtonClickListener
{
  QCirclePersonalTitleBarPart$12(QCirclePersonalTitleBarPart paramQCirclePersonalTitleBarPart, int[] paramArrayOfInt, ActionSheet paramActionSheet) {}
  
  public void a(View paramView, int paramInt)
  {
    if (!FastClickUtils.a("showMoreActionSheetClick"))
    {
      int i = this.a[paramInt];
      paramInt = 1;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i == 3) {
              QCirclePersonalTitleBarPart.n(this.c);
            }
          }
          else {
            QCirclePersonalTitleBarPart.m(this.c);
          }
        }
        else {
          this.c.l();
        }
      }
      else
      {
        QCirclePersonalTitleBarPart.k(this.c);
        paramInt = 0;
      }
      this.b.dismiss();
      if (paramInt != 0) {
        HostUIHelper.closeHostEnvironment();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePersonalTitleBarPart.12
 * JD-Core Version:    0.7.0.1
 */