package com.tencent.mobileqq.activity.shortvideo;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.multimsg.MultiMsgUtil;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.shortvideo.SVUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

class ShortVideoPlayActivity$22
  implements ActionSheet.OnButtonClickListener
{
  ShortVideoPlayActivity$22(ShortVideoPlayActivity paramShortVideoPlayActivity, ActionSheet paramActionSheet, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, String paramString5, String paramString6) {}
  
  public void onClick(View paramView, int paramInt)
  {
    this.a.dismiss();
    paramView = this.a.getContent(paramInt);
    if (paramView != null)
    {
      Object localObject1;
      Object localObject2;
      if (paramView.equals(this.b))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "click menu to forward shortVideo......");
        }
        paramView = this.i;
        localObject1 = ShortVideoPlayActivity.access$1801(paramView).getExtras();
        ((Bundle)localObject1).putInt("forward_type", 21);
        ((Bundle)localObject1).putBoolean("forward_need_sendmsg", true);
        ((Bundle)localObject1).putString("forward_thumb", SVUtils.a(this.i.mThumbMd5, "jpg"));
        ((Bundle)localObject1).putString("file_send_path", this.c);
        if (FileUtils.fileExistsAndNotEmpty(this.c))
        {
          ((Bundle)localObject1).putBoolean("k_dataline", true);
          ((Bundle)localObject1).putString("forward_extra", this.c);
          ((Bundle)localObject1).putBoolean("direct_send_if_dataline_forward", true);
        }
        localObject2 = new Intent();
        ((Intent)localObject2).putExtras((Bundle)localObject1);
        ForwardBaseOption.a(paramView, (Intent)localObject2);
        ShortVideoPlayActivity.access$1901(this.i);
        if (this.i.isFromMultiMsg) {
          MultiMsgUtil.a("0X8009ABC");
        }
        ReportController.b(this.i.app, "CliOper", "", "", "0X80052CC", "0X80052CC", 0, 0, "", "2", "", "");
        return;
      }
      if (paramView.equals(this.d))
      {
        if (QLog.isColorLevel())
        {
          paramView = new StringBuilder();
          paramView.append("click menu to share to qzone, finalVideoExists=");
          paramView.append(this.e);
          QLog.d("ShortVideoPlayActivity", 2, paramView.toString());
        }
        if (this.e)
        {
          ShortVideoPlayActivity.access$2000(this.i);
          return;
        }
        QQToast.makeText(this.i.mContext, 0, 2131916603, 0).show(this.i.mContext.getResources().getDimensionPixelSize(2131299920));
        return;
      }
      if (paramView.equals(this.f))
      {
        if (!this.e)
        {
          QQToast.makeText(this.i.mContext, 0, 2131916603, 0).show(this.i.mContext.getResources().getDimensionPixelSize(2131299920));
          return;
        }
        if (this.i.mHandler.get() != null)
        {
          paramView = ThreadManager.getFileThreadHandler();
          localObject1 = this.g;
          localObject2 = (MqqHandler)this.i.mHandler.get();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.i.mMd5);
          localStringBuilder.append(".mp4");
          paramView.post(new ShortVideoUtils.VideoFileSaveRunnable((String)localObject1, (MqqHandler)localObject2, localStringBuilder.toString(), false));
        }
        if (this.i.mUinType == 0)
        {
          ReportController.b(this.i.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "1", "", "");
          this.i.mPlaySucReported = true;
        }
        else if (this.i.mUinType == 3000)
        {
          ReportController.b(this.i.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "2", "", "");
          this.i.mPlaySucReported = true;
        }
        else if (this.i.mUinType == 1)
        {
          ReportController.b(this.i.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "3", "", "");
          this.i.mPlaySucReported = true;
        }
        else
        {
          ReportController.b(this.i.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "4", "", "");
          this.i.mPlaySucReported = true;
        }
        new DCShortVideo(BaseApplication.getContext()).a(this.i.app, 2002, this.i.mCurSessionType, this.i.mCurSessionUin);
        if (this.i.isFromMultiMsg) {
          MultiMsgUtil.a("0X8009ABD");
        }
      }
      else if (paramView.equals(this.h))
      {
        if (!this.e)
        {
          QQToast.makeText(this.i.mContext, 0, 2131916603, 0).show(this.i.mContext.getResources().getDimensionPixelSize(2131299920));
          return;
        }
        paramView = new Intent("android.intent.action.VIEW");
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("file://");
        ((StringBuilder)localObject1).append(this.g);
        paramView.setDataAndType(Uri.parse(((StringBuilder)localObject1).toString()), "video/*");
        this.i.startActivity(paramView);
        if (this.i.mUinType == 0)
        {
          ReportController.b(this.i.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "1", "", "");
          this.i.mPlaySucReported = true;
          return;
        }
        if (this.i.mUinType == 3000)
        {
          ReportController.b(this.i.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "2", "", "");
          this.i.mPlaySucReported = true;
          return;
        }
        if (this.i.mUinType == 1)
        {
          ReportController.b(this.i.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "3", "", "");
          this.i.mPlaySucReported = true;
          return;
        }
        ReportController.b(this.i.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "4", "", "");
        this.i.mPlaySucReported = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity.22
 * JD-Core Version:    0.7.0.1
 */