package com.tencent.av.utils;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

final class AVEnterPopActionSheetUtil$2
  implements ActionSheet.OnButtonClickListener
{
  AVEnterPopActionSheetUtil$2(VideoActionSheet paramVideoActionSheet, int[] paramArrayOfInt, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, Context paramContext, int paramInt) {}
  
  public void onClick(View paramView, int paramInt)
  {
    this.a.dismiss();
    paramInt = this.b[paramInt];
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        paramInt = 0;
      }
      else if (this.c.a == 1)
      {
        AVEnterPopActionSheetUtil.a(this.d, this.e, this.c, false);
        paramInt = 4;
      }
      else
      {
        AVEnterPopActionSheetUtil.a(this.d, this.e, this.c, false, this.f, null);
        paramInt = 2;
      }
    }
    else if (this.c.a == 1)
    {
      AVEnterPopActionSheetUtil.a(this.d, this.e, this.c, true);
      paramInt = 3;
    }
    else
    {
      AVEnterPopActionSheetUtil.a(this.d, this.e, this.c, true, this.f, null);
      paramInt = 1;
    }
    if (paramInt > 0) {
      ReportController.b(this.d, "CliOper", "", "", "0X800A518", "0X800A518", 0, paramInt, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.AVEnterPopActionSheetUtil.2
 * JD-Core Version:    0.7.0.1
 */