package com.tencent.mobileqq.addfriend.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IAddFriendApi
  extends QRouteApi
{
  public abstract void addOpenId(String paramString, OpenID paramOpenID, AppRuntime paramAppRuntime);
  
  public abstract boolean couldAddFriendSuccessDirectly(int paramInt1, int paramInt2, boolean paramBoolean);
  
  public abstract int countByByte(String paramString);
  
  public abstract String getGroupName(AppInterface paramAppInterface, int paramInt);
  
  public abstract int getLocalSelfAddFriendSetting(AppRuntime paramAppRuntime);
  
  public abstract String getRemark(String paramString);
  
  public abstract void getSelfAddFriendSetting(AppRuntime paramAppRuntime);
  
  public abstract String getsOpenId();
  
  public abstract boolean isIfShowAFDlg();
  
  public abstract void launchAddFriend(Context paramContext, Intent paramIntent);
  
  public abstract void launchAddFriendForResult(Activity paramActivity, Intent paramIntent, int paramInt);
  
  public abstract void setIfShowAFDlg(boolean paramBoolean);
  
  public abstract void setsOpenId(String paramString);
  
  public abstract boolean shouldReqAutoInfo(int paramInt, String paramString);
  
  public abstract boolean shouldUseLocalRemark(int paramInt);
  
  public abstract Intent startAddFriend(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7);
  
  public abstract Intent startAddFriend(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, byte[] paramArrayOfByte);
  
  public abstract Intent startMultiAddContact(Context paramContext, List<PhoneContact> paramList, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.api.IAddFriendApi
 * JD-Core Version:    0.7.0.1
 */