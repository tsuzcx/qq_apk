package com.tencent.mobileqq.activity;

import Override;
import aeum;
import aeun;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.ImageView;
import anhk;
import anmw;
import asfu;
import asli;
import azfe;
import bfpx;
import bgjw;
import bglp;
import bhgg;
import bjft;
import bkfx;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtendFriendUserInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.Locale;
import ljj;
import nki;
import nmp;

public abstract class ProfileActivity
  extends BaseActivity
  implements anhk
{
  public static final int[][] a = { { 2130850510, 2131167172 }, { 2130850513, 2131167173 }, { 2130850516, 2131167174 } };
  
  public static int a(int paramInt)
  {
    if (paramInt == 1) {}
    while (((paramInt >= 4) && (paramInt <= 21)) || ((paramInt >= 30) && (paramInt <= 37)) || (paramInt == 57) || (paramInt == 59) || ((paramInt >= 60) && (paramInt <= 61)) || ((paramInt >= 64) && (paramInt <= 68)) || (paramInt == 84) || ((paramInt >= 87) && (paramInt <= 88)) || (paramInt == 98)) {
      return paramInt;
    }
    return 999;
  }
  
  public static int a(ProfileActivity.AllInOne paramAllInOne)
  {
    if (paramAllInOne.jdField_a_of_type_Int == 0) {
      return 2;
    }
    if (ProfileActivity.AllInOne.b(paramAllInOne)) {
      return 0;
    }
    return 1;
  }
  
  public static long a(ProfileActivity.AllInOne paramAllInOne, boolean paramBoolean)
  {
    long l1 = 0L;
    if (ProfileActivity.AllInOne.a(paramAllInOne)) {
      l1 = 0L | 1L;
    }
    long l2 = l1 | 0x4 | 0x10000;
    l1 = l2;
    if (ProfileActivity.AllInOne.g(paramAllInOne)) {
      l1 = l2 | 0x8;
    }
    l2 = l1 | 0x200 | 0x10 | 0x20 | 0x400 | 0x800;
    l1 = l2;
    if (paramBoolean)
    {
      l1 = l2;
      if (ProfileActivity.AllInOne.b(paramAllInOne)) {
        l1 = l2 | 0x2000;
      }
    }
    return l1;
  }
  
  public static Intent a(Context paramContext, ProfileActivity.AllInOne paramAllInOne)
  {
    boolean bool2 = true;
    if ((paramAllInOne != null) && (nki.b(paramAllInOne.jdField_a_of_type_JavaLangString))) {
      return new Intent(paramContext, QidianProfileCardActivity.class);
    }
    Object localObject;
    if ((paramAllInOne != null) && ((paramContext instanceof BaseActivity)) && (((BaseActivity)paramContext).app != null))
    {
      localObject = ((BaseActivity)paramContext).app;
      if ((nmp.c((QQAppInterface)localObject, paramAllInOne.jdField_a_of_type_JavaLangString)) || (bjft.b((QQAppInterface)localObject, paramAllInOne.jdField_a_of_type_JavaLangString)) || (bjft.a((QQAppInterface)localObject, paramAllInOne.jdField_a_of_type_JavaLangString)))
      {
        boolean bool1 = bool2;
        if (!(paramContext instanceof SplashActivity)) {
          if (!(paramContext instanceof ChatActivity)) {
            break label125;
          }
        }
        label125:
        for (bool1 = bool2;; bool1 = false) {
          return nmp.a(paramContext, null, paramAllInOne.jdField_a_of_type_JavaLangString, bool1, -1, false, -1);
        }
      }
    }
    if ((paramAllInOne != null) && (bgjw.b(paramAllInOne.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(bgjw.jdField_a_of_type_JavaLangString)))
    {
      paramContext = new Intent(paramContext, QQBrowserActivity.class);
      paramContext.putExtra("url", bgjw.jdField_a_of_type_JavaLangString);
      return paramContext;
    }
    paramContext = new Intent(paramContext, FriendProfileCardActivity.class);
    if (paramAllInOne != null)
    {
      if (aC.equals(paramAllInOne.g)) {
        paramContext.putExtra("key_from_ark_babyq", true);
      }
      localObject = paramAllInOne.b;
      if (localObject != null) {
        paramContext.putExtra("param_wzry_data", ((Bundle)localObject).getSerializable("param_wzry_data"));
      }
    }
    if ((paramAllInOne != null) && (paramAllInOne.b != null))
    {
      paramAllInOne = paramAllInOne.b.getBundle("flc_extra_param");
      if (paramAllInOne != null) {
        paramContext.putExtra("flc_extra_param", paramAllInOne);
      }
    }
    bkfx.b();
    return paramContext;
  }
  
  public static Uri a(Activity paramActivity, int paramInt)
  {
    if (ljj.b(BaseApplicationImpl.getContext())) {
      return null;
    }
    if (AudioHelper.b(0))
    {
      bglp.a(paramActivity, 230, paramActivity.getString(2131697656), paramActivity.getString(2131697657), new aeum(), null).show();
      return null;
    }
    if (AudioHelper.a(0))
    {
      bglp.a(paramActivity, 230, paramActivity.getString(2131697656), paramActivity.getString(2131697658), new aeun(), null).show();
      return null;
    }
    Object localObject1 = new File(bhgg.a(anhk.ba + "photo/"));
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    Object localObject2 = bhgg.a(anhk.ba + "photo/" + System.currentTimeMillis() + ".jpg");
    localObject1 = new Intent();
    localObject2 = FileProvider7Helper.setSystemCapture(paramActivity, new File((String)localObject2), (Intent)localObject1);
    ((Intent)localObject1).putExtra("android.intent.extra.videoQuality", 100);
    paramActivity.startActivityForResult((Intent)localObject1, paramInt);
    return localObject2;
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, azfe paramazfe)
  {
    if ((paramActivity == null) || (paramIntent == null) || (paramazfe == null) || (paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null)) {}
    do
    {
      do
      {
        return;
        paramActivity = paramActivity.getIntent();
      } while (paramActivity == null);
      paramIntent.putExtra("param_return_profilecard_pa", paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int);
      paramIntent.putExtra("param_return_profilecard_subsourceid", paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.l);
      if (e(paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)) {
        paramIntent.putExtra("param_return_profilecard_discuss_uin", paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.e);
      }
      if (f(paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)) {
        paramIntent.putExtra("param_return_profilecard_group_uin", paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d);
      }
      if (paramazfe.b) {
        paramIntent.putExtra("param_return_profilecard_troop_uin", paramazfe.jdField_a_of_type_JavaLangString);
      }
      paramIntent.putExtra("flc_extra_param", paramActivity.getBundleExtra("flc_extra_param"));
    } while (!QLog.isColorLevel());
    QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "updateIntent  [pa: %s, uin:%s, troopUin:%s, discussUin:%s, troop:%s,  subSourceId:%s, extra:%s]", new Object[] { Integer.valueOf(paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int), bgjw.b(paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString), paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d, paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.e, paramazfe.jdField_a_of_type_JavaLangString, Integer.valueOf(paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.l), paramActivity.getBundleExtra("flc_extra_param") }));
  }
  
  public static void a(Activity paramActivity, ProfileActivity.AllInOne paramAllInOne, int paramInt)
  {
    if (paramActivity != null) {}
    try
    {
      Intent localIntent = a(paramActivity, paramAllInOne);
      localIntent.putExtra("AllInOne", paramAllInOne);
      localIntent.putExtra("requestCode", paramInt);
      localIntent.addFlags(536870912);
      paramActivity.startActivityForResult(localIntent, paramInt);
      return;
    }
    catch (Exception paramActivity)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.FrdProfileCard", 2, paramActivity.toString());
    }
  }
  
  public static void a(Activity paramActivity, ProfileActivity.AllInOne paramAllInOne, int paramInt, Bundle paramBundle)
  {
    if (paramActivity != null) {}
    try
    {
      Intent localIntent = a(paramActivity, paramAllInOne);
      localIntent.putExtra("AllInOne", paramAllInOne);
      localIntent.putExtra("requestCode", paramInt);
      localIntent.addFlags(536870912);
      if (paramBundle != null) {
        localIntent.putExtra("profile_extres", paramBundle);
      }
      paramActivity.startActivityForResult(localIntent, paramInt);
      return;
    }
    catch (Exception paramActivity)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.FrdProfileCard", 2, paramActivity.toString());
    }
  }
  
  public static void a(Activity paramActivity, String paramString, Intent paramIntent)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString)) || (paramIntent == null)) {}
    int i;
    ProfileActivity.AllInOne localAllInOne;
    do
    {
      do
      {
        return;
        paramActivity = paramActivity.getIntent();
      } while (paramActivity == null);
      i = paramActivity.getIntExtra("param_return_profilecard_pa", 19);
      localAllInOne = new ProfileActivity.AllInOne(paramString, i);
      if (e(i)) {
        localAllInOne.e = paramActivity.getStringExtra("param_return_profilecard_discuss_uin");
      }
      if (f(i))
      {
        localAllInOne.d = paramActivity.getStringExtra("param_return_profilecard_group_uin");
        paramIntent.putExtra("troopUin", paramActivity.getStringExtra("param_return_profilecard_troop_uin"));
      }
      localAllInOne.l = paramActivity.getIntExtra("param_return_profilecard_subsourceid", 0);
      paramIntent.putExtra("flc_extra_param", paramActivity.getBundleExtra("flc_extra_param"));
      paramIntent.putExtra("AllInOne", localAllInOne);
    } while (!QLog.isColorLevel());
    QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "initProfileIntent  [pa: %s, uin:%s, troopUin:%s, discussUin:%s, troop:%s, subSourceId:%s, extra:%s]", new Object[] { Integer.valueOf(i), bgjw.b(paramString), localAllInOne.d, localAllInOne.e, paramActivity.getStringExtra("param_return_profilecard_troop_uin"), Integer.valueOf(localAllInOne.l), paramActivity.getBundleExtra("flc_extra_param") }));
  }
  
  public static void a(Context paramContext, AppInterface paramAppInterface, String paramString)
  {
    if (((anmw)paramAppInterface.getManager(51)).b(paramString)) {}
    for (int i = 1;; i = 114)
    {
      a(paramContext, new ProfileActivity.AllInOne(paramString, i), false);
      return;
    }
  }
  
  public static void a(Context paramContext, ProfileActivity.AllInOne paramAllInOne)
  {
    if (paramContext != null) {}
    try
    {
      Intent localIntent = a(paramContext, paramAllInOne);
      localIntent.putExtra("AllInOne", paramAllInOne);
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.FrdProfileCard", 2, paramContext.toString());
    }
  }
  
  public static void a(Context paramContext, ProfileActivity.AllInOne paramAllInOne, int paramInt1, int paramInt2)
  {
    if (paramContext != null)
    {
      if (paramAllInOne != null) {}
      try
      {
        Object localObject = ((asfu)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(264)).a(paramAllInOne.jdField_a_of_type_JavaLangString, false);
        int i = 8;
        if (localObject != null) {
          i = ExtendFriendUserInfo.fromTypeToSubID(((ExtendFriendUserInfo)localObject).fromType);
        }
        paramAllInOne.l = i;
        localObject = a(paramContext, paramAllInOne);
        ((Intent)localObject).putExtra("AllInOne", paramAllInOne);
        if (paramInt1 == 1) {
          ((Intent)localObject).putExtra("key_from_limit_chat_plus", true);
        }
        for (;;)
        {
          ((Intent)localObject).putExtra("entrance", paramInt2);
          ((Intent)localObject).putExtra("key_from_extends_friend", true);
          ((Intent)localObject).putExtra("ExtendFriendLimitChatFromeType", paramInt1);
          ((Intent)localObject).putExtra("key_from_extends_friend_limit_chat", true);
          ((Intent)localObject).addFlags(536870912);
          paramContext.startActivity((Intent)localObject);
          asli.a(paramAllInOne.jdField_a_of_type_JavaLangString);
          return;
          ((Intent)localObject).putExtra("key_from_limit_chat_plus", false);
        }
        return;
      }
      catch (Exception paramContext)
      {
        QLog.e("Q.profilecard.FrdProfileCard", 1, "openProfileCardFromLimitChat fail.", paramContext);
      }
    }
  }
  
  public static void a(Context paramContext, ProfileActivity.AllInOne paramAllInOne, Bundle paramBundle)
  {
    if (paramContext != null) {
      try
      {
        Intent localIntent = a(paramContext, paramAllInOne);
        localIntent.putExtra("AllInOne", paramAllInOne);
        if ((paramBundle != null) && (paramBundle.getBoolean("single_top", false))) {
          localIntent.addFlags(67108864);
        }
        for (;;)
        {
          if (!(paramContext instanceof Activity)) {
            localIntent.addFlags(268435456);
          }
          if ((paramBundle != null) && (paramBundle.getBoolean("key_need_track_back", false))) {
            localIntent.putExtra("key_need_track_back", true);
          }
          if (paramBundle != null) {
            localIntent.putExtra("profile_extres", paramBundle);
          }
          paramContext.startActivity(localIntent);
          return;
          localIntent.addFlags(536870912);
        }
        return;
      }
      catch (Exception paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, paramContext.toString());
        }
      }
    }
  }
  
  public static void a(Context paramContext, ProfileActivity.AllInOne paramAllInOne, boolean paramBoolean)
  {
    if (paramContext != null) {
      try
      {
        Object localObject = BaseApplicationImpl.getApplication().getRuntime();
        if ((paramAllInOne != null) && ((localObject instanceof QQAppInterface)) && (bfpx.b((QQAppInterface)localObject, paramAllInOne.jdField_a_of_type_JavaLangString)))
        {
          bfpx.a(paramContext, null, paramAllInOne.jdField_a_of_type_JavaLangString);
          return;
        }
        localObject = a(paramContext, paramAllInOne);
        ((Intent)localObject).putExtra("AllInOne", paramAllInOne);
        if (paramBoolean) {
          ((Intent)localObject).addFlags(536870912);
        }
        if (!(paramContext instanceof Activity)) {
          ((Intent)localObject).addFlags(268435456);
        }
        paramContext.startActivity((Intent)localObject);
        return;
      }
      catch (Exception paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, paramContext.toString());
        }
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface, Drawable paramDrawable)
  {
    if ((paramAppInterface != null) && (paramDrawable != null))
    {
      if (ThemeUtil.isInNightMode(paramAppInterface)) {
        paramDrawable.setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
      }
    }
    else {
      return;
    }
    paramDrawable.clearColorFilter();
  }
  
  public static void a(AppInterface paramAppInterface, ImageView paramImageView)
  {
    if ((paramAppInterface != null) && (paramImageView != null))
    {
      if (ThemeUtil.isInNightMode(paramAppInterface)) {
        paramImageView.setColorFilter(1996488704);
      }
    }
    else {
      return;
    }
    paramImageView.setColorFilter(0);
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    return Math.abs(paramLong2 - paramLong1) > 1500L;
  }
  
  public static void b(Activity paramActivity, ProfileActivity.AllInOne paramAllInOne, int paramInt)
  {
    if (paramActivity != null) {}
    try
    {
      Intent localIntent = a(paramActivity, paramAllInOne);
      localIntent.putExtra("AllInOne", paramAllInOne);
      localIntent.putExtra("requestCode", paramInt);
      localIntent.putExtra("key_from_extends_friend", true);
      localIntent.putExtra("key_from_extends_friend_limit_chat", false);
      localIntent.addFlags(536870912);
      paramActivity.startActivityForResult(localIntent, paramInt);
      return;
    }
    catch (Exception paramActivity)
    {
      QLog.e("Q.profilecard.FrdProfileCard", 1, "openProfileCardForResultFromExtendFriend fail.", paramActivity);
    }
  }
  
  public static void b(Context paramContext, ProfileActivity.AllInOne paramAllInOne)
  {
    a(paramContext, paramAllInOne, true);
  }
  
  public static void b(Context paramContext, ProfileActivity.AllInOne paramAllInOne, Bundle paramBundle)
  {
    if (paramContext != null) {}
    try
    {
      Intent localIntent = a(paramContext, paramAllInOne);
      localIntent.putExtra("AllInOne", paramAllInOne);
      localIntent.addFlags(536870912);
      localIntent.addFlags(268435456);
      if (paramBundle != null) {
        localIntent.putExtra("profile_extres", paramBundle);
      }
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.FrdProfileCard", 2, paramContext.toString());
    }
  }
  
  public static boolean b(int paramInt)
  {
    switch (paramInt)
    {
    case 12: 
    case 14: 
    case 16: 
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean d(int paramInt)
  {
    switch (paramInt)
    {
    case 33: 
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean e(int paramInt)
  {
    return (paramInt == 45) || (paramInt == 46) || (paramInt == 47);
  }
  
  public static boolean f(int paramInt)
  {
    return (paramInt == 20) || (paramInt == 21) || (paramInt == 22);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ProfileActivity
 * JD-Core Version:    0.7.0.1
 */