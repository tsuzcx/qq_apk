package com.tencent.mobileqq.Doraemon.impl;

import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.impl.commonModule.AppInfoError;
import com.tencent.mobileqq.miniapp.MiniAppInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import tencent.im.oidb.oidb_0xb60.ClientInfo;
import tencent.im.oidb.oidb_0xb60.GetPrivilegeReq;
import tencent.im.oidb.oidb_0xb60.ReqBody;

class DefaultDoraemonAppInfoHelper$GetAppAPIPermissionJobSegment
  extends JobSegment<MiniAppInfo, MiniAppInfo>
{
  protected void a(JobContext paramJobContext, MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo.a())
    {
      notifyResult(paramMiniAppInfo);
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.permissionHelper.jobApiPermission", 2, "cache is valid");
      }
    }
    do
    {
      do
      {
        return;
        paramJobContext = BaseApplicationImpl.getApplication().getRuntime();
        if (paramJobContext != null) {
          break;
        }
        notifyError(new AppInfoError(6, "jobApiPermission app is null"));
      } while (!QLog.isColorLevel());
      QLog.i("DoraemonOpenAPI.permissionHelper.jobApiPermission", 2, "app is null");
      return;
      try
      {
        int i = Integer.parseInt(paramMiniAppInfo.jdField_a_of_type_JavaLangString);
        oidb_0xb60.ReqBody localReqBody = new oidb_0xb60.ReqBody();
        localReqBody.get_privilege_req.setHasFlag(true);
        localReqBody.get_privilege_req.appid.set(i);
        localReqBody.get_privilege_req.app_type.set(paramMiniAppInfo.jdField_a_of_type_Int);
        if (paramMiniAppInfo.jdField_a_of_type_Int == 1)
        {
          oidb_0xb60.ClientInfo localClientInfo = new oidb_0xb60.ClientInfo();
          localClientInfo.platform.set(1);
          if (!TextUtils.isEmpty(paramMiniAppInfo.k)) {
            localClientInfo.sdk_version.set(paramMiniAppInfo.k);
          }
          if (!TextUtils.isEmpty(paramMiniAppInfo.i)) {
            localClientInfo.android_package_name.set(paramMiniAppInfo.i);
          }
          if (!TextUtils.isEmpty(paramMiniAppInfo.j)) {
            localClientInfo.android_signature.set(paramMiniAppInfo.j);
          }
          localReqBody.client_info.set(localClientInfo);
        }
        if (QLog.isColorLevel()) {
          QLog.i("DoraemonOpenAPI.permissionHelper.jobApiPermission", 2, "send type=" + paramMiniAppInfo.jdField_a_of_type_Int + ", appid=" + paramMiniAppInfo.jdField_a_of_type_JavaLangString);
        }
        ProtoUtils.a(paramJobContext, new DefaultDoraemonAppInfoHelper.GetAppAPIPermissionJobSegment.1(this, paramMiniAppInfo), localReqBody.toByteArray(), "OidbSvc.0xb60_1", 2912, 1, null, 0L);
        return;
      }
      catch (NumberFormatException paramJobContext)
      {
        notifyError(new AppInfoError(6, "jobApiPermission parse appid error"));
      }
    } while (!QLog.isColorLevel());
    QLog.i("DoraemonOpenAPI.permissionHelper.jobApiPermission", 2, "parse appid error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAppInfoHelper.GetAppAPIPermissionJobSegment
 * JD-Core Version:    0.7.0.1
 */