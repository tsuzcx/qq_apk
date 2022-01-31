package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ProfilePerformanceReport;
import java.io.File;

public abstract class ProfileActivity
  extends BaseActivity
  implements AppConstants
{
  public static final int[][] a = { { 2130846012, 2131493001 }, { 2130846015, 2131493002 }, { 2130846018, 2131493003 } };
  protected boolean q;
  
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
    long l2 = l1 | 0x4;
    l1 = l2;
    if (ProfileActivity.AllInOne.f(paramAllInOne)) {
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
    return l1 | 0x4000;
  }
  
  public static Intent a(Context paramContext, ProfileActivity.AllInOne paramAllInOne)
  {
    boolean bool2 = true;
    if ((paramAllInOne != null) && (BmqqSegmentUtil.b(paramAllInOne.jdField_a_of_type_JavaLangString))) {
      return new Intent(paramContext, QidianProfileCardActivity.class);
    }
    if ((paramAllInOne != null) && ((paramContext instanceof BaseActivity)) && (((BaseActivity)paramContext).app != null))
    {
      QQAppInterface localQQAppInterface = ((BaseActivity)paramContext).app;
      if ((CrmUtils.c(localQQAppInterface, paramAllInOne.jdField_a_of_type_JavaLangString)) || (QidianManager.b(localQQAppInterface, paramAllInOne.jdField_a_of_type_JavaLangString)) || (QidianManager.a(localQQAppInterface, paramAllInOne.jdField_a_of_type_JavaLangString)))
      {
        boolean bool1 = bool2;
        if (!(paramContext instanceof SplashActivity)) {
          if (!(paramContext instanceof ChatActivity)) {
            break label125;
          }
        }
        label125:
        for (bool1 = bool2;; bool1 = false) {
          return CrmUtils.a(paramContext, null, paramAllInOne.jdField_a_of_type_JavaLangString, bool1, -1, false, -1);
        }
      }
    }
    if ((paramAllInOne != null) && (Utils.b(paramAllInOne.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(Utils.jdField_a_of_type_JavaLangString)))
    {
      paramContext = new Intent(paramContext, QQBrowserActivity.class);
      paramContext.putExtra("url", Utils.jdField_a_of_type_JavaLangString);
      return paramContext;
    }
    paramContext = new Intent(paramContext, FriendProfileCardActivity.class);
    if (paramAllInOne != null)
    {
      if (au.equals(paramAllInOne.g)) {
        paramContext.putExtra("key_from_ark_babyq", true);
      }
      paramAllInOne = paramAllInOne.jdField_a_of_type_AndroidOsBundle;
      if (paramAllInOne != null) {
        paramContext.putExtra("param_wzry_data", paramAllInOne.getSerializable("param_wzry_data"));
      }
    }
    ProfilePerformanceReport.b();
    return paramContext;
  }
  
  public static Uri a(Activity paramActivity, int paramInt)
  {
    if (QavCameraUsage.b(BaseApplicationImpl.getContext())) {
      return null;
    }
    Object localObject = new File(AppConstants.aJ + "photo/");
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = Uri.fromFile(new File(AppConstants.aJ + "photo/" + System.currentTimeMillis() + ".jpg"));
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    localIntent.putExtra("output", (Parcelable)localObject);
    localIntent.putExtra("android.intent.extra.videoQuality", 100);
    paramActivity.startActivityForResult(localIntent, paramInt);
    return localObject;
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
  
  public static void a(Context paramContext, ProfileActivity.AllInOne paramAllInOne, Bundle paramBundle)
  {
    if (paramContext != null) {}
    try
    {
      Intent localIntent = a(paramContext, paramAllInOne);
      localIntent.putExtra("AllInOne", paramAllInOne);
      localIntent.addFlags(536870912);
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
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
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    return Math.abs(paramLong2 - paramLong1) > 1500L;
  }
  
  public static void b(Context paramContext, ProfileActivity.AllInOne paramAllInOne)
  {
    if (paramContext != null) {}
    try
    {
      Intent localIntent = a(paramContext, paramAllInOne);
      localIntent.putExtra("AllInOne", paramAllInOne);
      localIntent.addFlags(536870912);
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
    return (paramInt == 3082) || (paramInt == 2082);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ProfileActivity
 * JD-Core Version:    0.7.0.1
 */