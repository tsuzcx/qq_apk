package com.tencent.mobileqq.activity.phone;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class PhoneFrameActivity
  extends IphoneTitleBarActivity
{
  PhoneFrame a = null;
  View b;
  View c;
  TextView d;
  ImageView e;
  Bundle f;
  private int g = 0;
  
  private void a()
  {
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
    Object localObject = new Bundle(this.f);
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
    localIntent.putExtra("uin", getIntent().getStringExtra("uin"));
    localIntent.putExtra("uinname", getIntent().getStringExtra("uinname"));
    localIntent.putExtra("uintype", getIntent().getIntExtra("uintype", 0));
    localIntent.putExtra("troop_uin", getIntent().getStringExtra("uin"));
    localObject = ((Bundle)localObject).getString("GALLERY.FORWORD_LOCAL_PATH");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    PhotoUtils.sendPhoto(this, localIntent, localArrayList, 0, false);
  }
  
  private void b()
  {
    this.b = findViewById(2131444897);
    this.c = ((View)this.b.getParent());
    this.d = ((TextView)this.b.findViewById(2131436180));
    this.leftView = ((TextView)this.b.findViewById(2131436182));
    this.rightViewText = ((TextView)this.b.findViewById(2131436211));
    this.rightViewText.setText(2131892520);
    this.rightViewText.setOnClickListener(new PhoneFrameActivity.1(this));
    this.e = ((ImageView)this.b.findViewById(2131436194));
    if (AppSetting.e) {
      this.e.setContentDescription(HardCodeUtil.a(2131905813));
    }
    IphoneTitleBarActivity.setLayerType(this.b);
    IphoneTitleBarActivity.setLayerType(this.d);
    IphoneTitleBarActivity.setLayerType(this.leftView);
    IphoneTitleBarActivity.setLayerType(this.rightViewText);
    IphoneTitleBarActivity.setLayerType(this.e);
    this.a = ((PhoneFrame)findViewById(2131440034));
    this.a.setActivity(this);
    this.a.setPhoneContext(new PhoneFrameActivity.2(this));
    this.a.a(null);
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_req_type", this.g);
    this.a.b(localBundle);
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
    if (paramInt1 == 20001)
    {
      if (paramInt2 == -1)
      {
        setResult(-1, paramIntent);
        finish();
      }
    }
    else {
      this.a.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawable(null);
    setContentView(2131625569);
    this.g = getIntent().getIntExtra("key_req_type", 0);
    b();
    this.f = getIntent().getExtras();
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.a.c();
    this.a.d();
    super.doOnDestroy();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false))
    {
      paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if (paramIntent != null)
      {
        if (paramIntent.isEmpty()) {
          return;
        }
        paramIntent = (String)paramIntent.get(0);
        this.f.putString("GALLERY.FORWORD_LOCAL_PATH", paramIntent);
        this.f.putBoolean("FORWARD_IS_EDITED", true);
        a();
        ReportController.b(this.app, "CliOper", "", "", "0X800514C", "0X800514C", 0, 0, "", "", "", "");
      }
    }
  }
  
  protected void doOnPause()
  {
    this.a.b();
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.a.a();
  }
  
  public void finish()
  {
    if ((this.app.isLogin()) && (this.g == 0))
    {
      Intent localIntent = new Intent(this, SplashActivity.class);
      localIntent.setFlags(67108864);
      localIntent.putExtra("tab_index", FrameControllerUtil.c);
      startActivity(localIntent);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneFrameActivity
 * JD-Core Version:    0.7.0.1
 */