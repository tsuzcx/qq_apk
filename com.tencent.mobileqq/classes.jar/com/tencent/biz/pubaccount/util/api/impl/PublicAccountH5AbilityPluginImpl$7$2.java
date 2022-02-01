package com.tencent.biz.pubaccount.util.api.impl;

import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsIPCClient;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsIPCClient.Observer;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class PublicAccountH5AbilityPluginImpl$7$2
  implements VideoFeedsIPCClient.Observer
{
  PublicAccountH5AbilityPluginImpl$7$2(PublicAccountH5AbilityPluginImpl.7 param7, QQProgressDialog paramQQProgressDialog, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8) {}
  
  public void a(String paramString, Bundle paramBundle)
  {
    int i;
    if ("CMD_CAMERA_CAPTURE_SO_DOWNLOAD".equals(paramString))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      i = paramBundle.getInt("VALUE_CAMERA_CAPTURE_SO_DOWNLOAD_STATUS");
      if (QLog.isColorLevel()) {
        QLog.i("Q.pubaccount.video.cameracapture", 2, "showUGCVideoRecordPage VideoFeedsIPCClient.callback downloadResult=" + i);
      }
    }
    switch (i)
    {
    default: 
      return;
    case 3: 
      QQToast.a(BaseApplicationImpl.getContext(), 2131718627, 0).a();
      return;
    case 1: 
      boolean bool = this.jdField_a_of_type_ComTencentBizPubaccountUtilApiImplPublicAccountH5AbilityPluginImpl$7.this$0.mVideoIPCClient.a("CMD_CAMERA_CAPTURE_CHECK_SO_READY", null).getBoolean("VALUE_CAMERA_CAPTURE_IS_SO_READY");
      if (QLog.isColorLevel()) {
        QLog.i("Q.pubaccount.video.cameracapture", 2, "showUGCVideoRecordPage() isSoReady:" + bool);
      }
      PublicAccountH5AbilityPluginImpl.access$000(this.jdField_a_of_type_ComTencentBizPubaccountUtilApiImplPublicAccountH5AbilityPluginImpl$7.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.c, this.d, this.e, this.f, this.g, this.h);
      return;
    }
    DialogUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilApiImplPublicAccountH5AbilityPluginImpl$7.this$0.activity, 230).setMessage(HardCodeUtil.a(2131708770)).setNegativeButton(2131690800, new DialogUtil.DialogOnClickAdapter()).setPositiveButton(2131694615, new PublicAccountH5AbilityPluginImpl.7.2.1(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl.7.2
 * JD-Core Version:    0.7.0.1
 */