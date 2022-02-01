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
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    paramView = this.jdField_a_of_type_ComTencentWidgetActionSheet.getContent(paramInt);
    if (paramView != null)
    {
      Object localObject1;
      Object localObject2;
      if (paramView.equals(this.jdField_a_of_type_JavaLangString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "click menu to forward shortVideo......");
        }
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity;
        localObject1 = ShortVideoPlayActivity.access$1801(paramView).getExtras();
        ((Bundle)localObject1).putInt("forward_type", 21);
        ((Bundle)localObject1).putBoolean("forward_need_sendmsg", true);
        ((Bundle)localObject1).putString("forward_thumb", SVUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.mThumbMd5, "jpg"));
        ((Bundle)localObject1).putString("file_send_path", this.b);
        if (FileUtils.fileExistsAndNotEmpty(this.b))
        {
          ((Bundle)localObject1).putBoolean("k_dataline", true);
          ((Bundle)localObject1).putString("forward_extra", this.b);
          ((Bundle)localObject1).putBoolean("direct_send_if_dataline_forward", true);
        }
        localObject2 = new Intent();
        ((Intent)localObject2).putExtras((Bundle)localObject1);
        ForwardBaseOption.a(paramView, (Intent)localObject2);
        ShortVideoPlayActivity.access$1901(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.isFromMultiMsg) {
          MultiMsgUtil.a("0X8009ABC");
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, "CliOper", "", "", "0X80052CC", "0X80052CC", 0, 0, "", "2", "", "");
        return;
      }
      if (paramView.equals(this.c))
      {
        if (QLog.isColorLevel())
        {
          paramView = new StringBuilder();
          paramView.append("click menu to share to qzone, finalVideoExists=");
          paramView.append(this.jdField_a_of_type_Boolean);
          QLog.d("ShortVideoPlayActivity", 2, paramView.toString());
        }
        if (this.jdField_a_of_type_Boolean)
        {
          ShortVideoPlayActivity.access$2000(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity);
          return;
        }
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.mContext, 0, 2131719067, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.mContext.getResources().getDimensionPixelSize(2131299168));
        return;
      }
      if (paramView.equals(this.d))
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.mContext, 0, 2131719067, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.mContext.getResources().getDimensionPixelSize(2131299168));
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.mHandler.get() != null)
        {
          paramView = ThreadManager.getFileThreadHandler();
          localObject1 = this.e;
          localObject2 = (MqqHandler)this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.mHandler.get();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.mMd5);
          localStringBuilder.append(".mp4");
          paramView.post(new ShortVideoUtils.VideoFileSaveRunnable((String)localObject1, (MqqHandler)localObject2, localStringBuilder.toString(), false));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.mUinType == 0)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "1", "", "");
          this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.mPlaySucReported = true;
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.mUinType == 3000)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "2", "", "");
          this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.mPlaySucReported = true;
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.mUinType == 1)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "3", "", "");
          this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.mPlaySucReported = true;
        }
        else
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "4", "", "");
          this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.mPlaySucReported = true;
        }
        new DCShortVideo(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, 2002, this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.mCurSessionType, this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.mCurSessionUin);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.isFromMultiMsg) {
          MultiMsgUtil.a("0X8009ABD");
        }
      }
      else if (paramView.equals(this.f))
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.mContext, 0, 2131719067, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.mContext.getResources().getDimensionPixelSize(2131299168));
          return;
        }
        paramView = new Intent("android.intent.action.VIEW");
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("file://");
        ((StringBuilder)localObject1).append(this.e);
        paramView.setDataAndType(Uri.parse(((StringBuilder)localObject1).toString()), "video/*");
        this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.startActivity(paramView);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.mUinType == 0)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "1", "", "");
          this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.mPlaySucReported = true;
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.mUinType == 3000)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "2", "", "");
          this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.mPlaySucReported = true;
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.mUinType == 1)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "3", "", "");
          this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.mPlaySucReported = true;
          return;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "4", "", "");
        this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.mPlaySucReported = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity.22
 * JD-Core Version:    0.7.0.1
 */