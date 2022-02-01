package com.tencent.mobileqq.activity.selectmember.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;
import com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi;
import com.tencent.mobileqq.adapter.TroopListAdapter2;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.fragment.UnitedVerifyMsgEditFragment;
import com.tencent.mobileqq.gamecenter.util.QQGameTroopManager;
import com.tencent.mobileqq.relationx.batchAdd.BatchAddFriendData;
import com.tencent.mobileqq.search.activity.ContactSearchComponentActivity;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troopAddFrd.Scene;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.widget.BubblePopupWindow.OnDismissListener;
import java.util.List;

public class SelectMemberRefatorHelperApiImpl
  implements ISelectMemberRefatorHelperApi
{
  public Object asyncGetGroupListForUI(AppInterface paramAppInterface)
  {
    return ((FriendsManager)paramAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).h();
  }
  
  public boolean batchAddFriendForTroopMembers(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, List<String> paramList, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    return ((FriendListHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).batchAddFriendForTroopMembers(paramString1, paramString2, paramString3, paramList, paramBoolean, paramInt1, paramInt2);
  }
  
  public int changeMask(int paramInt)
  {
    return TroopListAdapter2.b(paramInt);
  }
  
  public void enterTroopAio(Context paramContext, String paramString, boolean paramBoolean)
  {
    TroopUtils.a(paramContext, paramString, paramBoolean);
  }
  
  public String getAccountNickName(AppInterface paramAppInterface, String paramString)
  {
    return ContactUtils.f(paramAppInterface, paramString);
  }
  
  public Bitmap getFaceBitmap(AppInterface paramAppInterface, int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    return ((QQAppInterface)paramAppInterface).getFaceBitmap(paramInt1, paramString, paramBoolean, paramInt2);
  }
  
  public int getMemberType(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    return TroopMemberUtil.a(paramAppInterface, paramString1, paramString2);
  }
  
  public String getNickName(AppInterface paramAppInterface, String paramString, int paramInt)
  {
    return ContactUtils.a((QQAppInterface)paramAppInterface, paramString, paramInt);
  }
  
  public long getPublicAccountInfoCertifiedGrade(Object paramObject)
  {
    return ((PublicAccountInfo)paramObject).certifiedGrade;
  }
  
  public String getPublicAccountInfoName(Object paramObject)
  {
    return ((PublicAccountInfo)paramObject).name;
  }
  
  public String getPublicAccountInfoSummary(Object paramObject)
  {
    return ((PublicAccountInfo)paramObject).summary;
  }
  
  public long getPublicAccountInfoUin(Object paramObject)
  {
    return ((PublicAccountInfo)paramObject).uin;
  }
  
  public int getSCENE_TYPE_DEFAULT_Value()
  {
    return 0;
  }
  
  public String getScene_SP_KEY_BAF_DATA_CHECK_FLAG_MEMBERS_KeyString()
  {
    return "sp_baf_data_check_flag_members";
  }
  
  public int getSubSourceId_multi(int paramInt)
  {
    return Scene.d(paramInt);
  }
  
  public int getSubSourceId_single(int paramInt)
  {
    return Scene.e(paramInt);
  }
  
  public String getUnitedVerifyMsgEditFragment_VERIFY_MSG_KeyString()
  {
    return "VERIFY_MSG";
  }
  
  public boolean isPublicAccountInfoInstance(Object paramObject)
  {
    return paramObject instanceof PublicAccountInfo;
  }
  
  public boolean isPublicAccountInfoLooker(Object paramObject)
  {
    return PublicAccountInfo.isLooker((PublicAccountInfo)paramObject);
  }
  
  public void launchContactSearchComponentActivityForResult(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle)
  {
    ContactSearchComponentActivity.a(paramActivity, paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramBundle);
  }
  
  public void notifyResultReceiver(Intent paramIntent, Object paramObject)
  {
    ForwardRecentActivity.notifyResultReceiver(paramIntent, paramObject);
  }
  
  public Object showAsDropDown(View paramView, Object paramObject1, View.OnClickListener paramOnClickListener, Object paramObject2)
  {
    return BubbleContextMenu.a(paramView, (QQCustomMenu)paramObject1, paramOnClickListener, (BubblePopupWindow.OnDismissListener)paramObject2);
  }
  
  public void showResultForBatchAddFriendData(AppInterface paramAppInterface, Activity paramActivity, String paramString, Object paramObject)
  {
    BatchAddFriendData.a((QQAppInterface)paramAppInterface, paramActivity, paramString, (List)paramObject);
  }
  
  public void startCreateCreateFaceToFaceInviteActivity(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, Face2FaceAddFriendActivity.class);
    localIntent.putExtra("activity_from_type", 1);
    localIntent.putExtra("activity_troop_uin", paramString);
    paramActivity.startActivityForResult(localIntent, 0);
  }
  
  public void startCreateFaceToFaceDiscussionActivity(Activity paramActivity)
  {
    paramActivity.startActivityForResult(new Intent(paramActivity, CreateFaceToFaceDiscussionActivity.class), 0);
  }
  
  public void startGroupManager(Activity paramActivity)
  {
    GroupManagerActivity.a(paramActivity);
  }
  
  public void startUnitedVerifyMsgEditFragment(Activity paramActivity, String paramString, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("TROOP_UIN", paramString);
    localIntent.putExtra("hide_title_left_arrow", true);
    PublicFragmentActivity.a(paramActivity, localIntent, UnitedVerifyMsgEditFragment.class, paramInt);
    paramActivity.overridePendingTransition(2130772014, 2130772007);
  }
  
  public void updateSelectGradeIcon(ImageView paramImageView, String paramString)
  {
    QQGameTroopManager.a(paramImageView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.api.impl.SelectMemberRefatorHelperApiImpl
 * JD-Core Version:    0.7.0.1
 */