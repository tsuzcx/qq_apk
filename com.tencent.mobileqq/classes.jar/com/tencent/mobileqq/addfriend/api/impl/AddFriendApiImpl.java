package com.tencent.mobileqq.addfriend.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.addfriend.processor.switchprocessor.AddFriendSettingProcessor;
import com.tencent.mobileqq.addfriend.ui.AddFriendCheckFragment;
import com.tencent.mobileqq.addfriend.utils.AddFriendUtil;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.im.s2c.frdsysmsg.FrdSysMsg.FriendSysMsg;

public class AddFriendApiImpl
  implements IAddFriendApi
{
  public boolean couldAddFriendSuccessDirectly(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return AddFriendUtil.a(paramInt1, paramInt2, paramBoolean);
  }
  
  public int countByByte(String paramString)
  {
    return AddFriendUtil.a(paramString);
  }
  
  public String getGroupName(AppInterface paramAppInterface, int paramInt)
  {
    return AddFriendUtil.a(paramAppInterface, paramInt);
  }
  
  public int getLocalSelfAddFriendSetting(AppRuntime paramAppRuntime)
  {
    return AddFriendSettingProcessor.a(paramAppRuntime);
  }
  
  public String getRemark(String paramString)
  {
    return AddFriendUtil.a(paramString);
  }
  
  public void getSelfAddFriendSetting(AppRuntime paramAppRuntime)
  {
    AddFriendSettingProcessor.a(paramAppRuntime);
  }
  
  public String getsOpenId()
  {
    return AddFriendCheckFragment.a();
  }
  
  public boolean isIfShowAFDlg()
  {
    return AddFriendCheckFragment.a();
  }
  
  public void launchAddFriend(Context paramContext, Intent paramIntent)
  {
    AddFriendCheckFragment.a(paramContext, paramIntent);
  }
  
  public void launchAddFriendForResult(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    AddFriendCheckFragment.a(paramActivity, paramIntent, paramInt);
  }
  
  public void setIfShowAFDlg(boolean paramBoolean)
  {
    AddFriendCheckFragment.a(paramBoolean);
  }
  
  public void setsOpenId(String paramString)
  {
    AddFriendCheckFragment.a(paramString);
  }
  
  public boolean shouldReqAutoInfo(int paramInt, String paramString)
  {
    return AddFriendUtil.a(paramInt, paramString);
  }
  
  public boolean shouldUseLocalRemark(int paramInt)
  {
    return AddFriendUtil.a(paramInt);
  }
  
  public Intent startAddFriend(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    return AddFriendCheckFragment.a(paramContext, paramInt1, paramString1, paramString2, paramInt2, paramInt3, paramString3, paramString4, paramString5, paramString6, paramString7);
  }
  
  public Intent startAddFriend(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, byte[] paramArrayOfByte)
  {
    paramString2 = startAddFriend(paramContext, paramInt1, paramString1, paramString2, paramInt2, paramInt3, paramString3, null, null, null, null);
    paramString1 = paramString2.getBundleExtra("flc_extra_param");
    paramContext = paramString1;
    if (paramString1 == null) {
      paramContext = new Bundle();
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramString1 = new FrdSysMsg.FriendSysMsg();
      paramString1.bytes_paster_info.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      paramContext.putByteArray("friend_src_desc", paramString1.toByteArray());
    }
    paramString2.putExtra("flc_extra_param", paramContext);
    return paramString2;
  }
  
  public Intent startMultiAddContact(Context paramContext, List<PhoneContact> paramList, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    return AddFriendCheckFragment.a(paramContext, paramList, paramInt1, paramString1, paramString2, paramString3, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.api.impl.AddFriendApiImpl
 * JD-Core Version:    0.7.0.1
 */