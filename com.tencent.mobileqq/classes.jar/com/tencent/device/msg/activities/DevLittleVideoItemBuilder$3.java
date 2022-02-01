package com.tencent.device.msg.activities;

import android.view.View;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.Holder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import mqq.app.MobileQQ;

class DevLittleVideoItemBuilder$3
  implements ActionSheet.OnButtonClickListener
{
  DevLittleVideoItemBuilder$3(DevLittleVideoItemBuilder paramDevLittleVideoItemBuilder, MessageForDevLittleVideo paramMessageForDevLittleVideo, ShortVideoRealItemBuilder.Holder paramHolder, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      boolean bool = NetworkUtil.isNetworkAvailable(this.d.d.getApplication().getApplicationContext());
      paramView = this.a;
      if (bool) {
        paramInt = 1002;
      } else {
        paramInt = 1005;
      }
      paramView.videoFileStatus = paramInt;
      paramView = this.a;
      paramView.videoFileProgress = 0;
      paramView.serial();
      this.d.d.getMessageFacade().a(this.a.frienduin, this.a.istroop, this.a.uniseq, this.a.msgData);
      if (bool)
      {
        this.d.a(this.a);
        this.b.j.setFailedIconVisable(false, this.d);
        paramView = this.d;
        MessageForDevLittleVideo localMessageForDevLittleVideo = this.a;
        DevLittleVideoItemBuilder.a(paramView, localMessageForDevLittleVideo, this.b, localMessageForDevLittleVideo.videoFileProgress, false);
      }
    }
    this.c.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.msg.activities.DevLittleVideoItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */