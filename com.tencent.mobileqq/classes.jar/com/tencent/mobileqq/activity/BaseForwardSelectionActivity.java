package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardOptionBuilder;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class BaseForwardSelectionActivity
  extends BaseActivity
{
  protected ForwardBaseOption a;
  protected boolean b;
  protected boolean c;
  protected Bundle d;
  
  private void a()
  {
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
    Object localObject = new Bundle(this.d);
    ((Bundle)localObject).putBoolean("PhotoConst.HANDLE_DEST_RESULT", false);
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
    PhotoUtils.sendPhoto(this, localIntent, localArrayList, 0, false);
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
    if (paramInt2 == -1)
    {
      if (paramInt1 != 20001)
      {
        if (paramInt1 != 20002) {
          return;
        }
        this.a.a(paramInt1, paramInt2, paramIntent);
        return;
      }
      setResult(-1, paramIntent);
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.c = getIntent().getBooleanExtra("call_by_forward", false);
      if (this.c)
      {
        this.a = ForwardOptionBuilder.a(paramBundle, this.app, this);
        this.d = this.a.al();
      }
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    ForwardBaseOption localForwardBaseOption = this.a;
    if (localForwardBaseOption != null) {
      localForwardBaseOption.ad();
    }
    super.doOnDestroy();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("BaseForwardSelectionActivity", 2, "BaseForwardSelectionActivity onNewIntent()");
    }
    if (paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false))
    {
      paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if (paramIntent != null)
      {
        if (paramIntent.isEmpty()) {
          return;
        }
        paramIntent = (String)paramIntent.get(0);
        this.d.putBoolean("FORWARD_IS_EDITED", true);
        int i = this.d.getInt("key_forward_ability_type", 0);
        if ((i != ForwardAbility.ForwardAbilityType.g.intValue()) && (i != ForwardAbility.ForwardAbilityType.l.intValue()))
        {
          this.d.putString("GALLERY.FORWORD_LOCAL_PATH", paramIntent);
          a();
          ReportController.b(this.app, "CliOper", "", "", "0X800514C", "0X800514C", 0, 0, "", "", "", "");
          return;
        }
        this.a.b(i);
      }
    }
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130772005, 2130772006);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseForwardSelectionActivity
 * JD-Core Version:    0.7.0.1
 */