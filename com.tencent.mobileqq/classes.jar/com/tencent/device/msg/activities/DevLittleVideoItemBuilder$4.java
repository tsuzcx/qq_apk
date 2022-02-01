package com.tencent.device.msg.activities;

import android.view.View;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.Holder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import mqq.app.MobileQQ;

class DevLittleVideoItemBuilder$4
  implements ActionSheet.OnButtonClickListener
{
  DevLittleVideoItemBuilder$4(DevLittleVideoItemBuilder paramDevLittleVideoItemBuilder, MessageForDevLittleVideo paramMessageForDevLittleVideo, ShortVideoRealItemBuilder.Holder paramHolder, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    int i = 1;
    if (paramInt == 0)
    {
      boolean bool = NetworkUtil.isNetworkAvailable(this.d.d.getApplication().getApplicationContext());
      paramView = this.a;
      if (bool) {
        paramInt = 2002;
      } else {
        paramInt = 2005;
      }
      paramView.videoFileStatus = paramInt;
      paramView = this.a;
      paramView.videoFileProgress = 0;
      paramView.serial();
      this.d.d.getMessageFacade().a(this.a.frienduin, this.a.istroop, this.a.uniseq, this.a.msgData);
      if (bool)
      {
        if (!FileUtils.fileExistsAndNotEmpty(this.a.mThumbFilePath))
        {
          this.d.c(this.a);
          paramInt = 1;
        }
        else
        {
          paramInt = 0;
        }
        if (!FileUtils.fileExistsAndNotEmpty(this.a.videoFileName))
        {
          this.d.b(this.a);
          paramInt = i;
        }
        if (paramInt != 0)
        {
          this.b.j.setFailedIconVisable(false, this.d);
          paramView = this.d;
          MessageForDevLittleVideo localMessageForDevLittleVideo = this.a;
          DevLittleVideoItemBuilder.b(paramView, localMessageForDevLittleVideo, this.b, localMessageForDevLittleVideo.videoFileProgress, false);
        }
      }
    }
    this.c.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.msg.activities.DevLittleVideoItemBuilder.4
 * JD-Core Version:    0.7.0.1
 */