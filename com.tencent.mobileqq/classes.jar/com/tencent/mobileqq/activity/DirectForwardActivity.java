package com.tencent.mobileqq.activity;

import aael;
import aaov;
import aciy;
import ajed;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import aphf;
import aphp;
import apjx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class DirectForwardActivity
  extends BaseActivity
{
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  aphp jdField_a_of_type_Aphp;
  public String a;
  
  private void a()
  {
    Intent localIntent = aciy.a(new Intent(this, SplashActivity.class), null);
    if (this.jdField_a_of_type_Aphp != null) {}
    for (Object localObject = new Bundle(this.jdField_a_of_type_Aphp.a());; localObject = new Bundle())
    {
      ((Bundle)localObject).putBoolean("PhotoConst.HANDLE_DEST_RESULT", true);
      ((Bundle)localObject).putBoolean("PhotoConst.IS_FORWARD", true);
      ((Bundle)localObject).putInt("PhotoConst.SEND_BUSINESS_TYPE", 1031);
      ((Bundle)localObject).putBoolean("PicContants.NEED_COMPRESS", false);
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("extra_image_sender_tag", "sessionInfo.aioAlbum");
      localIntent.putExtra("isBack2Root", false);
      localIntent.putExtras((Bundle)localObject);
      localObject = ((Bundle)localObject).getString("GALLERY.FORWORD_LOCAL_PATH");
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localObject);
      PhotoUtils.a(this, localIntent, localArrayList, 0, true);
      return;
    }
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_Aphp = apjx.a(getIntent(), this.app, this);
    int i = aphf.b.intValue();
    if (ajed.L.equals(paramString)) {
      i = aphf.g.intValue();
    }
    for (;;)
    {
      this.jdField_a_of_type_Aphp.a(i, getIntent().getExtras());
      return;
      if (ajed.z.equals(paramString)) {
        i = aphf.f.intValue();
      } else if (ajed.A.equals(paramString)) {
        i = aphf.k.intValue();
      } else if ("-1010".equals(paramString)) {
        i = aphf.e.intValue();
      }
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 != -1) {}
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "forward form,DirectForwardActivity doOnCreate()");
    }
    Object localObject = getIntent();
    if ((localObject != null) && (this.app.isLogin()))
    {
      this.jdField_a_of_type_JavaLangString = ((Intent)localObject).getStringExtra("openerProc");
      String str1 = ((Intent)localObject).getStringExtra("toUin");
      String str2 = ((Intent)localObject).getStringExtra("troopUin");
      String str3 = ((Intent)localObject).getStringExtra("nickName");
      int i = ((Intent)localObject).getIntExtra("uinType", 0);
      int j = ((Intent)localObject).getIntExtra("isEncryptUin", 0);
      String str4 = ((Intent)localObject).getStringExtra("vfwebqq");
      String str5 = ((Intent)localObject).getStringExtra("tok");
      paramBundle = ((Intent)localObject).getExtras();
      if (paramBundle != null)
      {
        if (!paramBundle.containsKey("uin")) {
          ((Intent)localObject).putExtra("uin", str1);
        }
        if (!paramBundle.containsKey("troop_uin")) {
          ((Intent)localObject).putExtra("troop_uin", str2);
        }
        if (!paramBundle.containsKey("uintype")) {
          ((Intent)localObject).putExtra("uintype", i);
        }
        if (!paramBundle.containsKey("uinname")) {
          ((Intent)localObject).putExtra("uinname", str3);
        }
      }
      if ((((Intent)localObject).getBooleanExtra("qqfav_extra_from_sdk_share", false)) || (((Intent)localObject).getBooleanExtra("qqfav_extra_from_system_share", false))) {
        overridePendingTransition(0, 0);
      }
      if (((Intent)localObject).getIntExtra("forward_type", -1) == 30) {
        if ((paramBundle != null) && (paramBundle.containsKey("toUin")))
        {
          localObject = new SessionInfo();
          ((SessionInfo)localObject).jdField_a_of_type_JavaLangString = paramBundle.getString("toUin");
          ((SessionInfo)localObject).b = ((SessionInfo)localObject).jdField_a_of_type_JavaLangString;
          aael.c(this.app, getApplicationContext(), (SessionInfo)localObject);
          setResult(-1);
          finish();
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
        {
          paramBundle = new IntentFilter();
          paramBundle.addAction("com.tencent.process.exit");
          this.jdField_a_of_type_AndroidContentBroadcastReceiver = new aaov(this);
          registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
        }
        if (BaseApplicationImpl.appStartTime > 0L) {
          Log.d("AutoMonitor", "actStartFav, cost=" + (SystemClock.uptimeMillis() - BaseApplicationImpl.appStartTime));
        }
        return true;
        setResult(0);
        break;
        if ((j == 1) && (!TextUtils.isEmpty(str4)) && (!TextUtils.isEmpty(str5))) {
          ThreadManager.excute(new DirectForwardActivity.1(this, str1, str4, str5, i), 128, null, false);
        } else {
          a(str1);
        }
      }
    }
    finish();
    return false;
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_Aphp != null) {
      this.jdField_a_of_type_Aphp.w();
    }
    try
    {
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
      {
        unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      }
      super.doOnDestroy();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        localIllegalArgumentException.printStackTrace();
      }
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "qqBaseActivity onNewIntent()");
    }
    boolean bool1 = paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false);
    boolean bool2 = paramIntent.getBooleanExtra("isFromFavorites", false);
    if ((bool1) && (bool2) && (this.jdField_a_of_type_Aphp != null))
    {
      paramIntent = (String)paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS").get(0);
      this.jdField_a_of_type_Aphp.a().putBoolean("FORWARD_IS_EDITED", true);
      this.jdField_a_of_type_Aphp.a().putString("forward_filepath", paramIntent);
      this.jdField_a_of_type_Aphp.a().putString("GALLERY.FORWORD_LOCAL_PATH", paramIntent);
      a();
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_Aphp != null) {
      this.jdField_a_of_type_Aphp.j();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_Aphp != null) {
      this.jdField_a_of_type_Aphp.k();
    }
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DirectForwardActivity
 * JD-Core Version:    0.7.0.1
 */