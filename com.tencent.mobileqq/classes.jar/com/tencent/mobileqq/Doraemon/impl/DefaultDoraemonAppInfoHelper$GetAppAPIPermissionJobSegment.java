package com.tencent.mobileqq.Doraemon.impl;

import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.Doraemon.impl.commonModule.AppInfoError;
import com.tencent.mobileqq.miniapp.MiniAppInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import mqq.app.MobileQQ;
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
      return;
    }
    paramJobContext = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (paramJobContext == null)
    {
      notifyError(new AppInfoError(6, "jobApiPermission app is null"));
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.permissionHelper.jobApiPermission", 2, "app is null");
      }
      return;
    }
    try
    {
      int i = Integer.parseInt(paramMiniAppInfo.jdField_a_of_type_JavaLangString);
      oidb_0xb60.ReqBody localReqBody = new oidb_0xb60.ReqBody();
      localReqBody.get_privilege_req.setHasFlag(true);
      localReqBody.get_privilege_req.appid.set(i);
      localReqBody.get_privilege_req.app_type.set(paramMiniAppInfo.jdField_a_of_type_Int);
      Object localObject;
      if (paramMiniAppInfo.jdField_a_of_type_Int == 1)
      {
        localObject = new oidb_0xb60.ClientInfo();
        ((oidb_0xb60.ClientInfo)localObject).platform.set(1);
        if (!TextUtils.isEmpty(paramMiniAppInfo.k)) {
          ((oidb_0xb60.ClientInfo)localObject).sdk_version.set(paramMiniAppInfo.k);
        }
        if (!TextUtils.isEmpty(paramMiniAppInfo.i)) {
          ((oidb_0xb60.ClientInfo)localObject).android_package_name.set(paramMiniAppInfo.i);
        }
        if (!TextUtils.isEmpty(paramMiniAppInfo.j)) {
          ((oidb_0xb60.ClientInfo)localObject).android_signature.set(paramMiniAppInfo.j);
        }
        localReqBody.client_info.set((MessageMicro)localObject);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("send type=");
        ((StringBuilder)localObject).append(paramMiniAppInfo.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append(", appid=");
        ((StringBuilder)localObject).append(paramMiniAppInfo.jdField_a_of_type_JavaLangString);
        QLog.i("DoraemonOpenAPI.permissionHelper.jobApiPermission", 2, ((StringBuilder)localObject).toString());
      }
      ProtoUtils.a(paramJobContext, new DefaultDoraemonAppInfoHelper.GetAppAPIPermissionJobSegment.1(this, paramMiniAppInfo), localReqBody.toByteArray(), "OidbSvc.0xb60_1", 2912, 1, null, 0L);
      return;
    }
    catch (NumberFormatException paramJobContext)
    {
      label313:
      break label313;
    }
    notifyError(new AppInfoError(6, "jobApiPermission parse appid error"));
    if (QLog.isColorLevel()) {
      QLog.i("DoraemonOpenAPI.permissionHelper.jobApiPermission", 2, "parse appid error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAppInfoHelper.GetAppAPIPermissionJobSegment
 * JD-Core Version:    0.7.0.1
 */