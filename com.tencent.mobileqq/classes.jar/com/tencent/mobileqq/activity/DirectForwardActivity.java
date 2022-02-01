package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardOptionBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class DirectForwardActivity
  extends BaseActivity
{
  String a;
  BroadcastReceiver b = null;
  ForwardBaseOption c;
  
  private void a()
  {
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
    Object localObject = this.c;
    if (localObject != null) {
      localObject = new Bundle(((ForwardBaseOption)localObject).al());
    } else {
      localObject = new Bundle();
    }
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
    PhotoUtils.sendPhoto(this, localIntent, localArrayList, 0, true);
  }
  
  private void a(String paramString)
  {
    this.c = ForwardOptionBuilder.a(getIntent(), this.app, this);
    int i = ForwardAbility.ForwardAbilityType.c.intValue();
    if (AppConstants.FAVORITES_UIN.equals(paramString)) {
      i = ForwardAbility.ForwardAbilityType.h.intValue();
    } else if (AppConstants.DATALINE_PC_UIN.equals(paramString)) {
      i = ForwardAbility.ForwardAbilityType.g.intValue();
    } else if (AppConstants.DATALINE_IPAD_UIN.equals(paramString)) {
      i = ForwardAbility.ForwardAbilityType.l.intValue();
    } else if ("-1010".equals(paramString)) {
      i = ForwardAbility.ForwardAbilityType.f.intValue();
    }
    this.c.a(i, getIntent().getExtras());
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 != -1) {}
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "forward form,DirectForwardActivity doOnCreate()");
    }
    paramBundle = getIntent();
    if ((paramBundle != null) && (this.app.isLogin()))
    {
      Object localObject = paramBundle.getStringExtra("toUin");
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (AppConstants.DATALINE_PC_UIN.equals(localObject)))
      {
        paramBundle.putExtra("toUin", "3636666661");
        paramBundle.putExtra("uinType", 0);
        paramBundle.putExtra("nickName", getString(2131896189));
      }
      this.a = paramBundle.getStringExtra("openerProc");
      String str1 = paramBundle.getStringExtra("toUin");
      String str2 = paramBundle.getStringExtra("troopUin");
      String str3 = paramBundle.getStringExtra("nickName");
      int i = paramBundle.getIntExtra("uinType", 0);
      int j = paramBundle.getIntExtra("isEncryptUin", 0);
      String str4 = paramBundle.getStringExtra("vfwebqq");
      String str5 = paramBundle.getStringExtra("tok");
      localObject = paramBundle.getExtras();
      if (localObject != null)
      {
        if (!((Bundle)localObject).containsKey("uin")) {
          paramBundle.putExtra("uin", str1);
        }
        if (!((Bundle)localObject).containsKey("troop_uin")) {
          paramBundle.putExtra("troop_uin", str2);
        }
        if (!((Bundle)localObject).containsKey("uintype")) {
          paramBundle.putExtra("uintype", i);
        }
        if (!((Bundle)localObject).containsKey("uinname")) {
          paramBundle.putExtra("uinname", str3);
        }
      }
      if ((paramBundle.getBooleanExtra("qqfav_extra_from_sdk_share", false)) || (paramBundle.getBooleanExtra("qqfav_extra_from_system_share", false))) {
        overridePendingTransition(0, 0);
      }
      if (paramBundle.getIntExtra("forward_type", -1) == 30)
      {
        if ((localObject != null) && (((Bundle)localObject).containsKey("toUin")))
        {
          paramBundle = new SessionInfo();
          paramBundle.b = ((Bundle)localObject).getString("toUin");
          paramBundle.c = paramBundle.b;
          ChatActivityFacade.b(this.app, getApplicationContext(), paramBundle);
          setResult(-1);
        }
        else
        {
          setResult(0);
        }
        finish();
      }
      else if ((j == 1) && (!TextUtils.isEmpty(str4)) && (!TextUtils.isEmpty(str5)))
      {
        ThreadManager.excute(new DirectForwardActivity.1(this, str1, str4, str5, i), 128, null, false);
      }
      else
      {
        a(str1);
      }
      if (this.b == null)
      {
        paramBundle = new IntentFilter();
        paramBundle.addAction("com.tencent.process.exit");
        this.b = new DirectForwardActivity.2(this);
        registerReceiver(this.b, paramBundle);
      }
      if (BaseApplicationImpl.appStartTime > 0L)
      {
        paramBundle = new StringBuilder();
        paramBundle.append("actStartFav, cost=");
        paramBundle.append(SystemClock.uptimeMillis() - BaseApplicationImpl.appStartTime);
        Log.d("AutoMonitor", paramBundle.toString());
      }
      return true;
    }
    finish();
    return false;
  }
  
  protected void doOnDestroy()
  {
    ForwardBaseOption localForwardBaseOption = this.c;
    if (localForwardBaseOption != null) {
      localForwardBaseOption.ad();
    }
    try
    {
      if (this.b != null)
      {
        unregisterReceiver(this.b);
        this.b = null;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localIllegalArgumentException.printStackTrace();
    }
    super.doOnDestroy();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "qqBaseActivity onNewIntent()");
    }
    boolean bool1 = paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false);
    boolean bool2 = paramIntent.getBooleanExtra("isFromFavorites", false);
    if ((bool1) && (bool2) && (this.c != null))
    {
      paramIntent = (String)paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS").get(0);
      this.c.al().putBoolean("FORWARD_IS_EDITED", true);
      this.c.al().putString("forward_filepath", paramIntent);
      this.c.al().putString("GALLERY.FORWORD_LOCAL_PATH", paramIntent);
      a();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    ForwardBaseOption localForwardBaseOption = this.c;
    if (localForwardBaseOption != null) {
      localForwardBaseOption.j();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    ForwardBaseOption localForwardBaseOption = this.c;
    if (localForwardBaseOption != null) {
      localForwardBaseOption.i();
    }
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DirectForwardActivity
 * JD-Core Version:    0.7.0.1
 */