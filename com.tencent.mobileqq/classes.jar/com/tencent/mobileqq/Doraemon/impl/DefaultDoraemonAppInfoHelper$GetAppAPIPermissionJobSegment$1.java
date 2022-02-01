package com.tencent.mobileqq.Doraemon.impl;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.Doraemon.IDoraemonApi;
import com.tencent.mobileqq.Doraemon.impl.commonModule.AppInfoError;
import com.tencent.mobileqq.miniapp.MiniAppInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.oidb_0xb60.GetPrivilegeRsp;
import tencent.im.oidb.oidb_0xb60.RspBody;

class DefaultDoraemonAppInfoHelper$GetAppAPIPermissionJobSegment$1
  extends ProtoUtils.TroopProtocolObserver
{
  DefaultDoraemonAppInfoHelper$GetAppAPIPermissionJobSegment$1(DefaultDoraemonAppInfoHelper.GetAppAPIPermissionJobSegment paramGetAppAPIPermissionJobSegment, MiniAppInfo paramMiniAppInfo) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onResult type=");
      paramBundle.append(this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo.jdField_a_of_type_Int);
      paramBundle.append(", appid=");
      paramBundle.append(this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo.jdField_a_of_type_JavaLangString);
      paramBundle.append(", code=");
      paramBundle.append(paramInt);
      QLog.i("DoraemonOpenAPI.permissionHelper.jobApiPermission", 2, paramBundle.toString());
    }
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      paramBundle = new oidb_0xb60.RspBody();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        if ((paramBundle.get_privilege_rsp.api_groups.has()) && (paramBundle.get_privilege_rsp.next_req_duration.has()))
        {
          if (QLog.isColorLevel())
          {
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("receive api_groups:");
            paramArrayOfByte.append(paramBundle.get_privilege_rsp.api_groups.get());
            paramArrayOfByte.append(", api_names:");
            paramArrayOfByte.append(paramBundle.get_privilege_rsp.api_names.get());
            QLog.d("DoraemonOpenAPI.permissionHelper.jobApiPermission", 2, paramArrayOfByte.toString());
          }
          paramArrayOfByte = DefaultDoraemonAppInfoHelper.a();
          paramArrayOfByte.a(paramBundle.get_privilege_rsp.api_groups.get(), this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo.jdField_a_of_type_JavaUtilSet);
          if (paramBundle.get_privilege_rsp.api_names.size() > 0)
          {
            localObject = paramBundle.get_privilege_rsp.api_names.get().iterator();
            while (((Iterator)localObject).hasNext())
            {
              String str = (String)((Iterator)localObject).next();
              if (DefaultDoraemonAppInfoHelper.a(paramArrayOfByte, str)) {
                this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo.jdField_a_of_type_JavaUtilSet.add(str);
              }
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo.c = (NetConnInfoCenter.getServerTimeMillis() + Math.max(paramBundle.get_privilege_rsp.next_req_duration.get() * 1000L, 300000L));
          ((IDoraemonApi)QRoute.api(IDoraemonApi.class)).putAppInfo(this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo);
          DefaultDoraemonAppInfoHelper.GetAppAPIPermissionJobSegment.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplDefaultDoraemonAppInfoHelper$GetAppAPIPermissionJobSegment, this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo);
          return;
        }
        DefaultDoraemonAppInfoHelper.GetAppAPIPermissionJobSegment.b(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplDefaultDoraemonAppInfoHelper$GetAppAPIPermissionJobSegment, new AppInfoError(6, "jobApiPermission rsp invalid"));
        if (QLog.isColorLevel()) {
          QLog.i("DoraemonOpenAPI.permissionHelper.jobApiPermission", 2, "rsp invalid");
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        DefaultDoraemonAppInfoHelper.GetAppAPIPermissionJobSegment.c(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplDefaultDoraemonAppInfoHelper$GetAppAPIPermissionJobSegment, new AppInfoError(6, "jobApiPermission parse rsp error"));
        if (QLog.isColorLevel()) {
          QLog.i("DoraemonOpenAPI.permissionHelper.jobApiPermission", 2, "parse rsp error", paramArrayOfByte);
        }
        return;
      }
    }
    DefaultDoraemonAppInfoHelper.GetAppAPIPermissionJobSegment.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplDefaultDoraemonAppInfoHelper$GetAppAPIPermissionJobSegment, new AppInfoError(6, "jobApiPermission req error"));
    if ((!QLog.isColorLevel()) || (paramArrayOfByte != null)) {}
    try
    {
      paramBundle = ((oidb_0xb60.RspBody)new oidb_0xb60.RspBody().mergeFrom(paramArrayOfByte)).wording.get();
    }
    catch (InvalidProtocolBufferMicroException paramBundle)
    {
      label482:
      break label482;
    }
    paramBundle = "";
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("req error code=");
    ((StringBuilder)localObject).append(paramInt);
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = ", data=null";
    }
    else
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append(", msg=");
      paramArrayOfByte.append(paramBundle);
      paramArrayOfByte = paramArrayOfByte.toString();
    }
    ((StringBuilder)localObject).append(paramArrayOfByte);
    QLog.i("DoraemonOpenAPI.permissionHelper.jobApiPermission", 2, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAppInfoHelper.GetAppAPIPermissionJobSegment.1
 * JD-Core Version:    0.7.0.1
 */