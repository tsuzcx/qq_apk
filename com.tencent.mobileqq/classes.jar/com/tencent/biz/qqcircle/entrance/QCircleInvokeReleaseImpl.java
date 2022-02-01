package com.tencent.biz.qqcircle.entrance;

import android.content.Context;
import com.tencent.biz.qqcircle.QCircleGlobalBroadcastHelper;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.bizparts.QCirclePrivacySettingContentPart;
import com.tencent.biz.qqcircle.localphoto.scan.QCirclePhotoLocalClusterHelper;
import com.tencent.biz.qqcircle.manager.QcircleRewardAdManager;
import com.tencent.biz.qqcircle.utils.QCircleBindPhoneNumberHelper;
import com.tencent.biz.qqcircle.utils.QCircleTipsUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.proxy.QCircleInvokeModule;
import org.json.JSONObject;

public class QCircleInvokeReleaseImpl
  implements QCircleInvokeModule
{
  public void invoke(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    if (paramInt2 == 1)
    {
      QCirclePluginGlobalInfo.a();
      QCircleGlobalBroadcastHelper.a().c();
      QCirclePluginUtil.b();
      QCircleTipsUtil.a();
      return;
    }
    if (paramInt2 == 3)
    {
      QCircleBindPhoneNumberHelper.b();
      return;
    }
    if (paramInt2 == 4) {
      try
      {
        QcircleRewardAdManager.a().a((Context)paramVarArgs[0], (JSONObject)paramVarArgs[1]);
        return;
      }
      catch (Exception paramVarArgs)
      {
        QLog.e("QCircleInvokeReleaseImpl", 1, paramVarArgs, new Object[0]);
        return;
      }
    }
    if (paramInt2 == 5)
    {
      new QCirclePhotoLocalClusterHelper().a();
      return;
    }
    if (paramInt2 == 6) {
      QCirclePrivacySettingContentPart.a(true, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.entrance.QCircleInvokeReleaseImpl
 * JD-Core Version:    0.7.0.1
 */