package com.tencent.biz.qqcircle.immersive.personal.part;

import android.view.View;
import com.tencent.biz.qqcircle.richframework.util.FastClickUtils;
import com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheet;
import com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheet.OnButtonClickListener;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;

class QFSPersonalTitleBarPart$13
  implements ActionSheet.OnButtonClickListener
{
  QFSPersonalTitleBarPart$13(QFSPersonalTitleBarPart paramQFSPersonalTitleBarPart, int[] paramArrayOfInt, ActionSheet paramActionSheet) {}
  
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
              QFSPersonalTitleBarPart.j(this.c);
            }
          }
          else {
            QFSPersonalTitleBarPart.i(this.c);
          }
        }
        else {
          this.c.d();
        }
      }
      else
      {
        QFSPersonalTitleBarPart.h(this.c);
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
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.part.QFSPersonalTitleBarPart.13
 * JD-Core Version:    0.7.0.1
 */