package com.tencent.biz.pubaccount.util.api.impl;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsIPCClient;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsIPCClient.Observer;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class PublicAccountH5AbilityPluginImpl$7$2
  implements IVideoFeedsIPCClient.Observer
{
  PublicAccountH5AbilityPluginImpl$7$2(PublicAccountH5AbilityPluginImpl.7 param7, QQProgressDialog paramQQProgressDialog, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8) {}
  
  public void a(String paramString, Bundle paramBundle)
  {
    if ("CMD_CAMERA_CAPTURE_SO_DOWNLOAD".equals(paramString))
    {
      this.a.dismiss();
      int m = paramBundle.getInt("VALUE_CAMERA_CAPTURE_SO_DOWNLOAD_STATUS");
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("showUGCVideoRecordPage IVideoFeedsIPCClient.callback downloadResult=");
        paramString.append(m);
        QLog.i("Q.pubaccount.video.cameracapture", 2, paramString.toString());
      }
      if (m != 1)
      {
        if (m != 2)
        {
          if (m != 3) {
            return;
          }
          QQToast.makeText(BaseApplicationImpl.getContext(), 2131915837, 0).show();
          return;
        }
        DialogUtil.a(this.l.this$0.activity, 230).setMessage(HardCodeUtil.a(2131906554)).setNegativeButton(2131887648, new DialogUtil.DialogOnClickAdapter()).setPositiveButton(2131892267, new PublicAccountH5AbilityPluginImpl.7.2.1(this)).show();
        return;
      }
      boolean bool = this.l.this$0.mVideoIPCClient.callServer("CMD_CAMERA_CAPTURE_CHECK_SO_READY", null).getBoolean("VALUE_CAMERA_CAPTURE_IS_SO_READY");
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("showUGCVideoRecordPage() isSoReady:");
        paramString.append(bool);
        QLog.i("Q.pubaccount.video.cameracapture", 2, paramString.toString());
      }
      PublicAccountH5AbilityPluginImpl.access$000(this.l.this$0, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl.7.2
 * JD-Core Version:    0.7.0.1
 */