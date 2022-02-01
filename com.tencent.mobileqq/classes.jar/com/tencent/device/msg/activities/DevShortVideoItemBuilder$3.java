package com.tencent.device.msg.activities;

import android.view.View;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.Holder;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class DevShortVideoItemBuilder$3
  implements ActionSheet.OnButtonClickListener
{
  DevShortVideoItemBuilder$3(DevShortVideoItemBuilder paramDevShortVideoItemBuilder, MessageForShortVideo paramMessageForShortVideo, ShortVideoItemBuilder.Holder paramHolder, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      this.d.a(this.a);
      if (NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        paramView = this.b;
        if ((paramView != null) && (paramView.j != null))
        {
          this.b.j.setFailedIconVisable(false, this.d);
          DevShortVideoItemBuilder.a(this.d, this.b, ShortVideoUtils.getDisplayProgress(this.a.videoFileProgress, 10), true);
        }
      }
    }
    this.c.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.msg.activities.DevShortVideoItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */