package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import com.tencent.av.utils.VideoActionSheet;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

final class VideoItemBuilder$3
  implements ActionSheet.OnButtonClickListener
{
  public void onClick(View paramView, int paramInt)
  {
    this.a.dismiss();
    if (paramInt != 0) {
      return;
    }
    boolean bool = this.b.isVideo;
    paramInt = this.b.type;
    VideoItemBuilder.a(this.c, this.d, bool, paramInt);
    if (this.b.isVideo)
    {
      ReportController.b(this.c, "CliOper", "", "", "0X8005642", "0X8005642", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(this.c, "CliOper", "", "", "0X8005243", "0X8005243", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.VideoItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */