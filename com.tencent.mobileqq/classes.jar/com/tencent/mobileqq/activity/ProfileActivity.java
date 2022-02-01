package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qqexpand.bean.profile.ExpandUserInfo;
import com.tencent.mobileqq.qqexpand.chat.IExpandChatUtils;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Locale;

@Deprecated
public abstract class ProfileActivity
  extends BaseActivity
  implements AppConstants
{
  public static void a(Activity paramActivity, Intent paramIntent, ProfileCardInfo paramProfileCardInfo)
  {
    if ((paramActivity != null) && (paramIntent != null) && (paramProfileCardInfo != null))
    {
      if (paramProfileCardInfo.allInOne == null) {
        return;
      }
      paramActivity = paramActivity.getIntent();
      if (paramActivity == null) {
        return;
      }
      paramIntent.putExtra("param_return_profilecard_pa", paramProfileCardInfo.allInOne.pa);
      paramIntent.putExtra("param_return_profilecard_subsourceid", paramProfileCardInfo.allInOne.subSourceId);
      if (ProfilePAUtils.isFromDiscussion(paramProfileCardInfo.allInOne.pa)) {
        paramIntent.putExtra("param_return_profilecard_discuss_uin", paramProfileCardInfo.allInOne.discussUin);
      }
      if (ProfilePAUtils.isFromTroopMemberCard(paramProfileCardInfo.allInOne.pa)) {
        paramIntent.putExtra("param_return_profilecard_group_uin", paramProfileCardInfo.allInOne.troopUin);
      }
      if (paramProfileCardInfo.isTroopMemberCard) {
        paramIntent.putExtra("param_return_profilecard_troop_uin", paramProfileCardInfo.troopUin);
      }
      paramIntent.putExtra("flc_extra_param", paramActivity.getBundleExtra("flc_extra_param"));
      if (QLog.isColorLevel()) {
        QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "updateIntent  [pa: %s, uin:%s, troopUin:%s, discussUin:%s, troop:%s,  subSourceId:%s, extra:%s]", new Object[] { Integer.valueOf(paramProfileCardInfo.allInOne.pa), Utils.i(paramProfileCardInfo.allInOne.uin), paramProfileCardInfo.allInOne.troopUin, paramProfileCardInfo.allInOne.discussUin, paramProfileCardInfo.troopUin, Integer.valueOf(paramProfileCardInfo.allInOne.subSourceId), paramActivity.getBundleExtra("flc_extra_param") }));
      }
    }
  }
  
  public static void a(Activity paramActivity, AllInOne paramAllInOne, int paramInt)
  {
    if (paramActivity != null) {
      try
      {
        paramAllInOne = ProfileUtils.getIntent(paramActivity, paramAllInOne);
        paramAllInOne.putExtra("key_from_extends_friend", true);
        paramAllInOne.putExtra("key_from_extends_friend_limit_chat", false);
        paramAllInOne.addFlags(536870912);
        paramActivity.startActivityForResult(paramAllInOne, paramInt);
        return;
      }
      catch (Exception paramActivity)
      {
        QLog.e("ProfileActivity", 1, "openProfileCardForResultFromExtendFriend fail.", paramActivity);
      }
    }
  }
  
  public static void a(Activity paramActivity, String paramString, Intent paramIntent)
  {
    if ((paramActivity != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (paramIntent == null) {
        return;
      }
      paramActivity = paramActivity.getIntent();
      if (paramActivity == null) {
        return;
      }
      int i = paramActivity.getIntExtra("param_return_profilecard_pa", 19);
      AllInOne localAllInOne = new AllInOne(paramString, i);
      if (ProfilePAUtils.isFromDiscussion(i)) {
        localAllInOne.discussUin = paramActivity.getStringExtra("param_return_profilecard_discuss_uin");
      }
      if (ProfilePAUtils.isFromTroopMemberCard(i))
      {
        localAllInOne.troopUin = paramActivity.getStringExtra("param_return_profilecard_group_uin");
        paramIntent.putExtra("troopUin", paramActivity.getStringExtra("param_return_profilecard_troop_uin"));
      }
      localAllInOne.subSourceId = paramActivity.getIntExtra("param_return_profilecard_subsourceid", 0);
      paramIntent.putExtra("flc_extra_param", paramActivity.getBundleExtra("flc_extra_param"));
      paramIntent.putExtra("AllInOne", localAllInOne);
      if (QLog.isColorLevel()) {
        QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "initProfileIntent  [pa: %s, uin:%s, troopUin:%s, discussUin:%s, troop:%s, subSourceId:%s, extra:%s]", new Object[] { Integer.valueOf(i), Utils.i(paramString), localAllInOne.troopUin, localAllInOne.discussUin, paramActivity.getStringExtra("param_return_profilecard_troop_uin"), Integer.valueOf(localAllInOne.subSourceId), paramActivity.getBundleExtra("flc_extra_param") }));
      }
    }
  }
  
  public static void a(Context paramContext, AppInterface paramAppInterface, String paramString)
  {
    int i;
    if (((FriendsManager)paramAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).n(paramString)) {
      i = 1;
    } else {
      i = 114;
    }
    ProfileUtils.openProfileCard(paramContext, new AllInOne(paramString, i), false);
  }
  
  public static void a(Context paramContext, AllInOne paramAllInOne, int paramInt1, int paramInt2)
  {
    if (paramContext != null)
    {
      if (paramAllInOne != null) {}
      try
      {
        Object localObject = ((IExpandManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a(paramAllInOne.uin, false);
        int i = 8;
        if (localObject != null) {
          i = ExpandUserInfo.fromTypeToSubID(((ExpandUserInfo)localObject).fromType);
        }
        paramAllInOne.subSourceId = i;
        localObject = ProfileUtils.getIntent(paramContext, paramAllInOne);
        if (paramInt1 == 1) {
          ((Intent)localObject).putExtra("key_from_limit_chat_plus", true);
        } else {
          ((Intent)localObject).putExtra("key_from_limit_chat_plus", false);
        }
        ((Intent)localObject).putExtra("entrance", paramInt2);
        ((Intent)localObject).putExtra("key_from_extends_friend", true);
        ((Intent)localObject).putExtra("ExtendFriendLimitChatFromeType", paramInt1);
        ((Intent)localObject).putExtra("key_from_extends_friend_limit_chat", true);
        ((Intent)localObject).addFlags(536870912);
        paramContext.startActivity((Intent)localObject);
        if (paramAllInOne != null)
        {
          ((IExpandChatUtils)QRoute.api(IExpandChatUtils.class)).reportInSubThread(paramAllInOne.uin);
          return;
        }
      }
      catch (Exception paramContext)
      {
        QLog.e("ProfileActivity", 1, "openProfileCardFromLimitChat fail.", paramContext);
      }
    }
  }
  
  public static void a(Context paramContext, AllInOne paramAllInOne, Bundle paramBundle)
  {
    if (paramContext != null) {
      try
      {
        paramAllInOne = ProfileUtils.getIntent(paramContext, paramAllInOne);
        if ((paramBundle != null) && (paramBundle.getBoolean("single_top", false))) {
          paramAllInOne.addFlags(67108864);
        } else {
          paramAllInOne.addFlags(536870912);
        }
        if (!(paramContext instanceof Activity)) {
          paramAllInOne.addFlags(268435456);
        }
        if ((paramBundle != null) && (paramBundle.getBoolean("key_need_track_back", false))) {
          paramAllInOne.putExtra("key_need_track_back", true);
        }
        if (paramBundle != null) {
          paramAllInOne.putExtra("profile_extra", paramBundle);
        }
        paramContext.startActivity(paramAllInOne);
        return;
      }
      catch (Exception paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ProfileActivity", 2, paramContext.toString());
        }
      }
    }
  }
  
  public static void b(Context paramContext, AllInOne paramAllInOne, Bundle paramBundle)
  {
    if (paramContext != null) {
      try
      {
        paramAllInOne = ProfileUtils.getIntent(paramContext, paramAllInOne);
        paramAllInOne.addFlags(536870912);
        paramAllInOne.addFlags(268435456);
        if (paramBundle != null) {
          paramAllInOne.putExtra("profile_extra", paramBundle);
        }
        paramContext.startActivity(paramAllInOne);
        return;
      }
      catch (Exception paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ProfileActivity", 2, paramContext.toString());
        }
      }
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ProfileActivity
 * JD-Core Version:    0.7.0.1
 */