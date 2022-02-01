package com.tencent.mobileqq.activity.aio.item;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.video.AioVideoTransFileController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.Map;

class ShortVideoRealItemBuilder$5
  implements ActionSheet.OnButtonClickListener
{
  ShortVideoRealItemBuilder$5(ShortVideoRealItemBuilder paramShortVideoRealItemBuilder, MessageForShortVideo paramMessageForShortVideo, ShortVideoRealItemBuilder.Holder paramHolder, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      if ((this.a.uiOperatorFlag == 1) && (this.a.videoFileStatus == 1004)) {
        ShortVideoUtils.reportCancelSendVideo("0X800A7F0", this.d.f.a);
      }
      if (this.a.uiOperatorFlag == 2)
      {
        this.d.b(this.a, this.b);
      }
      else if ((this.a.uiOperatorFlag == 1) && (this.a.md5 == null))
      {
        if (!ShortVideoRealItemBuilder.l())
        {
          ShortVideoRealItemBuilder.a(this.d, this.a, this.b, true, true);
        }
        else if (!ShortVideoRealItemBuilder.k().containsKey(Long.valueOf(this.a.uniseq)))
        {
          ShortVideoRealItemBuilder.k().put(Long.valueOf(this.a.uniseq), this.a);
          if (QLog.isColorLevel())
          {
            paramView = new StringBuilder();
            paramView.append("messageMap size:");
            paramView.append(ShortVideoRealItemBuilder.k().size());
            paramView.append(", [");
            paramView.append(this.a.uniseq);
            paramView.append("] added, mEncoding:");
            paramView.append(ShortVideoRealItemBuilder.l());
            QLog.i("ShortVideoRealItemBuilder", 2, paramView.toString());
          }
        }
      }
      else if ((!TextUtils.isEmpty(this.a.md5)) && (this.a.videoFileStatus == 1004) && (AioVideoTransFileController.c(this.d.d, this.a.frienduin, this.a.uniseq)))
      {
        ShortVideoRealItemBuilder.b(this.d);
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoRealItemBuilder", 2, "onErrorIconClick resumeSending!");
        }
      }
      else
      {
        this.d.a(this.a, this.b);
        ShortVideoRealItemBuilder.b(this.d);
      }
    }
    this.c.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.5
 * JD-Core Version:    0.7.0.1
 */