package com.tencent.mobileqq.addfriend.processor.switchprocessor;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profilecommon.handler.ProfileCommonHandler;
import com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor;
import com.tencent.mobileqq.profilecommon.utils.ProfileCommonUtils;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;

@KeepClassConstructor
public class AddFriendSettingProcessor
  extends AbsProfileCommonProcessor
{
  public AddFriendSettingProcessor(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  public static int a(AppRuntime paramAppRuntime)
  {
    int i = MobileQQ.sMobileQQ.getSharedPreferences(paramAppRuntime.getCurrentAccountUin(), 0).getInt("e_add_friend_setting", 101);
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("getSelfAddFriendSettingValue  settingValue:");
      paramAppRuntime.append(i);
      QLog.i("AddFriendSettingProcessor", 2, paramAppRuntime.toString());
    }
    return i;
  }
  
  public static void a(int paramInt, AppRuntime paramAppRuntime)
  {
    paramAppRuntime = MobileQQ.sMobileQQ.getSharedPreferences(paramAppRuntime.getCurrentAccountUin(), 0);
    int i = paramAppRuntime.getInt("e_add_friend_setting", 101);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleGetSelfAddFriendSetting settingValue=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("  oldValue:");
      localStringBuilder.append(i);
      QLog.d("AddFriendSettingProcessor", 2, localStringBuilder.toString());
    }
    if (i != paramInt)
    {
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("e_add_friend_setting", paramInt);
      paramAppRuntime.commit();
    }
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    try
    {
      paramAppRuntime = (AddFriendSettingProcessor)ProfileCommonUtils.a(AddFriendSettingProcessor.class, paramAppRuntime);
      if (paramAppRuntime != null)
      {
        paramAppRuntime.a();
        return;
      }
    }
    catch (Exception paramAppRuntime)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSelfAddFriendSetting error ");
      localStringBuilder.append(paramAppRuntime.getMessage());
      QLog.e("AddFriendSettingProcessor", 1, localStringBuilder.toString());
    }
  }
  
  void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddFriendSettingProcessor", 2, "getSelfAddFriendSetting");
    }
    try
    {
      oidb_0x5eb.ReqBody localReqBody = new oidb_0x5eb.ReqBody();
      long l = Long.parseLong(this.appRuntime.getCurrentAccountUin());
      localReqBody.rpt_uint64_uins.add(Long.valueOf(l));
      localReqBody.uint32_req_allow.set(1);
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("uint32_req_allow", true);
      localBundle.putString("reqUin", this.appRuntime.getCurrentAccountUin());
      getProfileDetail(localReqBody, localBundle);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AddFriendSettingProcessor", 2, "getSelfAddFriendSetting ex", localException);
      }
    }
  }
  
  public String getProcessorKey()
  {
    return "AddFriendSettingProcessor";
  }
  
  public boolean onGetProfileDetailRequestForLogin(oidb_0x5eb.ReqBody paramReqBody)
  {
    paramReqBody.uint32_req_allow.set(1);
    return true;
  }
  
  public void onGetProfileDetailResponse(Bundle paramBundle, boolean paramBoolean, oidb_0x5eb.UdcUinData paramUdcUinData)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetProfileDetailResponse success: ");
      localStringBuilder.append(paramBoolean);
      QLog.i("AddFriendSettingProcessor", 2, localStringBuilder.toString());
    }
    if (!paramBundle.getBoolean("uint32_req_allow", false)) {
      return;
    }
    if (paramBoolean)
    {
      int i = paramUdcUinData.uint32_allow.get();
      this.handler.notifyUI(3, paramBoolean, Integer.valueOf(i));
      if (i != 101) {
        a(i, this.appRuntime);
      }
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("onGetProfileDetailResponse settingValue: ");
        paramBundle.append(i);
        QLog.i("AddFriendSettingProcessor", 2, paramBundle.toString());
      }
    }
    else
    {
      this.handler.notifyUI(3, false, Integer.valueOf(a(this.appRuntime)));
    }
  }
  
  public void onProcessProfileModifyPush(int paramInt, ByteStringMicro paramByteStringMicro)
  {
    if (paramInt == 20014)
    {
      int j = paramByteStringMicro.size();
      paramInt = -1;
      if (paramByteStringMicro.size() > 0)
      {
        int i = paramByteStringMicro.byteAt(0);
        paramInt = i;
        if (i != 101)
        {
          a(i, this.appRuntime);
          paramInt = i;
        }
      }
      if (QLog.isColorLevel())
      {
        paramByteStringMicro = new StringBuilder();
        paramByteStringMicro.append("20014 push a ProfileInfo size = ");
        paramByteStringMicro.append(j);
        paramByteStringMicro.append("  settingValue = ");
        paramByteStringMicro.append(paramInt);
        QLog.i("AddFriendSettingProcessor", 2, paramByteStringMicro.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.processor.switchprocessor.AddFriendSettingProcessor
 * JD-Core Version:    0.7.0.1
 */