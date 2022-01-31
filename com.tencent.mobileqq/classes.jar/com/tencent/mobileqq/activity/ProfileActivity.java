package com.tencent.mobileqq.activity;

import absc;
import absd;
import ajsf;
import ajxn;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import aojo;
import auuw;
import bahx;
import bbbd;
import bbcv;
import bbuv;
import bdto;
import bfmv;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Locale;
import lko;
import myy;
import nbc;

public abstract class ProfileActivity
  extends BaseActivity
  implements ajsf
{
  public static final int[][] a = { { 2130849397, 2131167035 }, { 2130849400, 2131167036 }, { 2130849403, 2131167037 } };
  
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
    if ((paramAllInOne != null) && (myy.b(paramAllInOne.jdField_a_of_type_JavaLangString))) {
      return new Intent(paramContext, QidianProfileCardActivity.class);
    }
    Object localObject;
    if ((paramAllInOne != null) && ((paramContext instanceof BaseActivity)) && (((BaseActivity)paramContext).app != null))
    {
      localObject = ((BaseActivity)paramContext).app;
      if ((nbc.c((QQAppInterface)localObject, paramAllInOne.jdField_a_of_type_JavaLangString)) || (bdto.b((QQAppInterface)localObject, paramAllInOne.jdField_a_of_type_JavaLangString)) || (bdto.a((QQAppInterface)localObject, paramAllInOne.jdField_a_of_type_JavaLangString)))
      {
        boolean bool1 = bool2;
        if (!(paramContext instanceof SplashActivity)) {
          if (!(paramContext instanceof ChatActivity)) {
            break label125;
          }
        }
        label125:
        for (bool1 = bool2;; bool1 = false) {
          return nbc.a(paramContext, null, paramAllInOne.jdField_a_of_type_JavaLangString, bool1, -1, false, -1);
        }
      }
    }
    if ((paramAllInOne != null) && (bbbd.b(paramAllInOne.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(bbbd.jdField_a_of_type_JavaLangString)))
    {
      paramContext = new Intent(paramContext, QQBrowserActivity.class);
      paramContext.putExtra("url", bbbd.jdField_a_of_type_JavaLangString);
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
    bfmv.b();
    return paramContext;
  }
  
  public static Uri a(Activity paramActivity, int paramInt)
  {
    if (lko.b(BaseApplicationImpl.getContext())) {
      return null;
    }
    if (AudioHelper.b(0))
    {
      bbcv.a(paramActivity, 230, paramActivity.getString(2131698453), paramActivity.getString(2131698454), new absc(), null).show();
      return null;
    }
    if (AudioHelper.a(0))
    {
      bbcv.a(paramActivity, 230, paramActivity.getString(2131698453), paramActivity.getString(2131698455), new absd(), null).show();
      return null;
    }
    Object localObject1 = new File(bbuv.a(ajsf.aW + "photo/"));
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    Object localObject2 = bbuv.a(ajsf.aW + "photo/" + System.currentTimeMillis() + ".jpg");
    localObject1 = new Intent();
    localObject2 = FileProvider7Helper.setSystemCapture(paramActivity, new File((String)localObject2), (Intent)localObject1);
    ((Intent)localObject1).putExtra("android.intent.extra.videoQuality", 100);
    paramActivity.startActivityForResult((Intent)localObject1, paramInt);
    return localObject2;
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, auuw paramauuw)
  {
    if ((paramActivity == null) || (paramIntent == null) || (paramauuw == null) || (paramauuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null)) {}
    do
    {
      do
      {
        return;
        paramActivity = paramActivity.getIntent();
      } while (paramActivity == null);
      paramIntent.putExtra("param_return_profilecard_pa", paramauuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int);
      paramIntent.putExtra("param_return_profilecard_subsourceid", paramauuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.l);
      if (e(paramauuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)) {
        paramIntent.putExtra("param_return_profilecard_discuss_uin", paramauuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.e);
      }
      if (f(paramauuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)) {
        paramIntent.putExtra("param_return_profilecard_group_uin", paramauuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d);
      }
      if (paramauuw.b) {
        paramIntent.putExtra("param_return_profilecard_troop_uin", paramauuw.jdField_a_of_type_JavaLangString);
      }
      paramIntent.putExtra("flc_extra_param", paramActivity.getBundleExtra("flc_extra_param"));
    } while (!QLog.isColorLevel());
    QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "updateIntent  [pa: %s, uin:%s, troopUin:%s, discussUin:%s, troop:%s,  subSourceId:%s, extra:%s]", new Object[] { Integer.valueOf(paramauuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int), bbbd.b(paramauuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString), paramauuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d, paramauuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.e, paramauuw.jdField_a_of_type_JavaLangString, Integer.valueOf(paramauuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.l), paramActivity.getBundleExtra("flc_extra_param") }));
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
    QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "initProfileIntent  [pa: %s, uin:%s, troopUin:%s, discussUin:%s, troop:%s, subSourceId:%s, extra:%s]", new Object[] { Integer.valueOf(i), bbbd.b(paramString), localAllInOne.d, localAllInOne.e, paramActivity.getStringExtra("param_return_profilecard_troop_uin"), Integer.valueOf(localAllInOne.l), paramActivity.getBundleExtra("flc_extra_param") }));
  }
  
  public static void a(Context paramContext, AppInterface paramAppInterface, String paramString)
  {
    if (((ajxn)paramAppInterface.getManager(51)).b(paramString)) {}
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
      if ((paramAllInOne == null) || (paramInt1 == 1)) {}
      for (;;)
      {
        Intent localIntent;
        try
        {
          paramAllInOne.l = 9;
          localIntent = a(paramContext, paramAllInOne);
          localIntent.putExtra("AllInOne", paramAllInOne);
          if (paramInt1 != 1) {
            break label136;
          }
          localIntent.putExtra("key_from_limit_chat_plus", true);
          localIntent.putExtra("entrance", paramInt2);
          localIntent.putExtra("key_from_extends_friend", true);
          localIntent.putExtra("ExtendFriendLimitChatFromeType", paramInt1);
          localIntent.putExtra("key_from_extends_friend_limit_chat", true);
          localIntent.addFlags(536870912);
          paramContext.startActivity(localIntent);
          aojo.a(paramAllInOne.jdField_a_of_type_JavaLangString);
          return;
        }
        catch (Exception paramContext)
        {
          QLog.e("Q.profilecard.FrdProfileCard", 1, "openProfileCardFromLimitChat fail.", paramContext);
          return;
        }
        paramAllInOne.l = 8;
        continue;
        label136:
        localIntent.putExtra("key_from_limit_chat_plus", false);
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
        if ((paramAllInOne != null) && ((localObject instanceof QQAppInterface)) && (bahx.b((QQAppInterface)localObject, paramAllInOne.jdField_a_of_type_JavaLangString)))
        {
          bahx.a(paramContext, null, paramAllInOne.jdField_a_of_type_JavaLangString);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ProfileActivity
 * JD-Core Version:    0.7.0.1
 */