package com.tencent.mobileqq.activity.selectmember.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

@QAPI(process={"all"})
public abstract interface ISelectMemberRefatorHelperApi
  extends QRouteApi
{
  public abstract Object asyncGetGroupListForUI(AppInterface paramAppInterface);
  
  public abstract boolean batchAddFriendForTroopMembers(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, List<String> paramList, boolean paramBoolean, int paramInt1, int paramInt2);
  
  public abstract int changeMask(int paramInt);
  
  public abstract void enterTroopAio(Context paramContext, String paramString, boolean paramBoolean);
  
  public abstract String getAccountNickName(AppInterface paramAppInterface, String paramString);
  
  public abstract Bitmap getFaceBitmap(AppInterface paramAppInterface, int paramInt1, String paramString, boolean paramBoolean, int paramInt2);
  
  public abstract int getMemberType(AppInterface paramAppInterface, String paramString1, String paramString2);
  
  public abstract String getNickName(AppInterface paramAppInterface, String paramString, int paramInt);
  
  public abstract long getPublicAccountInfoCertifiedGrade(Object paramObject);
  
  public abstract String getPublicAccountInfoName(Object paramObject);
  
  public abstract String getPublicAccountInfoSummary(Object paramObject);
  
  public abstract long getPublicAccountInfoUin(Object paramObject);
  
  public abstract int getSCENE_TYPE_DEFAULT_Value();
  
  public abstract String getScene_SP_KEY_BAF_DATA_CHECK_FLAG_MEMBERS_KeyString();
  
  public abstract int getSubSourceId_multi(int paramInt);
  
  public abstract int getSubSourceId_single(int paramInt);
  
  public abstract String getUnitedVerifyMsgEditFragment_VERIFY_MSG_KeyString();
  
  public abstract boolean isPublicAccountInfoInstance(Object paramObject);
  
  public abstract boolean isPublicAccountInfoLooker(Object paramObject);
  
  public abstract void launchContactSearchComponentActivityForResult(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle);
  
  public abstract void notifyResultReceiver(Intent paramIntent, Object paramObject);
  
  public abstract Object showAsDropDown(View paramView, Object paramObject1, View.OnClickListener paramOnClickListener, Object paramObject2);
  
  public abstract void showResultForBatchAddFriendData(AppInterface paramAppInterface, Activity paramActivity, String paramString, Object paramObject);
  
  public abstract void startCreateCreateFaceToFaceInviteActivity(Activity paramActivity, String paramString);
  
  public abstract void startCreateFaceToFaceDiscussionActivity(Activity paramActivity);
  
  public abstract void startGroupManager(Activity paramActivity);
  
  public abstract void startUnitedVerifyMsgEditFragment(Activity paramActivity, String paramString, int paramInt);
  
  public abstract void updateSelectGradeIcon(ImageView paramImageView, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi
 * JD-Core Version:    0.7.0.1
 */