package com.tencent.mobileqq.activity.history;

import Override;
import agej;
import akal;
import akby;
import akch;
import akcq;
import akcr;
import akfl;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;

public class ChatHistoryActivity
  extends FragmentActivity
{
  int jdField_a_of_type_Int;
  akal jdField_a_of_type_Akal;
  boolean jdField_a_of_type_Boolean;
  boolean b;
  public boolean c;
  
  public static int a(Context paramContext)
  {
    int j = 0;
    int i;
    if ((paramContext instanceof ChatHistoryActivity))
    {
      i = ((ChatHistoryActivity)paramContext).a();
      if (((ChatHistoryActivity)paramContext).jdField_a_of_type_Int == 3013) {
        i = 3;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.ChatHistoryActivity", 2, "getTagType, result = " + i);
      }
      return i;
      if ((i == 2131364406) || (i == 2131364399))
      {
        i = 1;
      }
      else if ((i == 2131364404) || (i == 2131364411))
      {
        i = 2;
      }
      else if ((i == 2131364408) || (i == 2131364401))
      {
        i = 4;
        continue;
        i = j;
        if ((paramContext instanceof PublicFragmentActivity))
        {
          i = j;
          if ((((PublicFragmentActivity)paramContext).a() instanceof ChatHistoryBubbleListForTroopFragment)) {
            i = 6;
          }
        }
      }
      else
      {
        i = 0;
      }
    }
  }
  
  private akal a()
  {
    if ((this.jdField_a_of_type_Boolean) || (this.c)) {
      return new akcq(this);
    }
    if (this.jdField_a_of_type_Int == 3011) {
      return new akby(this);
    }
    if (this.jdField_a_of_type_Int == 3012) {
      return new akfl(this);
    }
    if (this.jdField_a_of_type_Int == 3013) {
      return new akcr(this);
    }
    if (this.jdField_a_of_type_Int == 3014) {
      return new akch(this);
    }
    return null;
  }
  
  private void a()
  {
    this.jdField_a_of_type_Int = getIntent().getIntExtra("FromType", 3011);
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("extra.IS_FROM_CHAT_AIO_GALLERY", false);
    this.b = getIntent().getBooleanExtra("need_jump_to_msg", false);
    this.c = getIntent().getBooleanExtra("FromTroopAlbum", false);
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, ChatHistoryActivity.class);
    localIntent.putExtra("FromType", 3012);
    localIntent.putExtra("SissionUin", paramString);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", 1);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    Intent localIntent = new Intent(paramActivity, ChatHistoryActivity.class);
    localIntent.putExtra("FromType", 3011);
    localIntent.putExtra("SissionUin", paramString1);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", paramInt1);
    localIntent.putExtra("uinname", paramString2);
    paramActivity.startActivityForResult(localIntent, paramInt2);
  }
  
  public static void a(Activity paramActivity, String paramString1, int paramInt, String paramString2, long paramLong)
  {
    Intent localIntent = new Intent(paramActivity, ChatHistoryActivity.class);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", paramInt);
    localIntent.putExtra("uinname", paramString2);
    localIntent.putExtra("FromType", 3014);
    localIntent.putExtra("msg_revoke_uniseq", paramLong);
    paramActivity.startActivity(localIntent);
  }
  
  public static void a(Activity paramActivity, String paramString1, int paramInt1, String paramString2, long paramLong1, long paramLong2, int paramInt2)
  {
    Intent localIntent = new Intent(paramActivity, ChatHistoryActivity.class);
    localIntent.putExtra("FromType", 3013);
    localIntent.putExtra("SissionUin", paramString1);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", paramInt1);
    localIntent.putExtra("uinname", paramString2);
    localIntent.putExtra("need_jump_to_msg", true);
    localIntent.putExtra("searched_time", paramLong1);
    localIntent.putExtra("target_shmsgseq", paramLong2);
    paramActivity.startActivityForResult(localIntent, paramInt2);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent(paramActivity, ChatHistoryActivity.class);
    localIntent.putExtra("FromType", 3012);
    localIntent.putExtra("SissionUin", paramString1);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("FromTroopAlbum", true);
    localIntent.setFlags(402653184);
    localIntent.putExtra("UploadPhoto.key_album_id", paramString2);
    localIntent.putExtra("UploadPhoto.key_album_name", paramString3);
    paramActivity.startActivity(localIntent);
  }
  
  public static boolean a(Context paramContext, Intent paramIntent)
  {
    paramIntent.putExtra("FromChatHistoryTab", a(paramContext));
    return a(paramContext) != 0;
  }
  
  public static boolean a(Context paramContext, Bundle paramBundle)
  {
    paramBundle.putInt("FromChatHistoryTab", a(paramContext));
    return a(paramContext) != 0;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Akal != null) {
      return this.jdField_a_of_type_Akal.a();
    }
    return 0;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.ChatHistoryActivity", 2, "doOnActivityResult, requestCode = " + paramInt1);
    }
    this.jdField_a_of_type_Akal.a(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
      return;
    }
    Intent localIntent = new Intent(this, SendPhotoActivity.class);
    paramIntent = new Bundle(paramIntent.getExtras());
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "AIOListGallerysence startChatAndSendMsg IS_WAIT_DEST_RESULT=true");
    }
    paramIntent.putBoolean("PhotoConst.HANDLE_DEST_RESULT", true);
    paramIntent.putInt("PhotoConst.SEND_BUSINESS_TYPE", 1031);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
    localIntent = agej.a(localIntent, null);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    paramIntent.putBoolean("PicContants.NEED_COMPRESS", false);
    paramIntent.putBoolean("send_in_background", false);
    localIntent.putExtras(paramIntent);
    startActivity(localIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131558878);
    a();
    paramBundle = (TextView)findViewById(2131369088);
    FrameLayout localFrameLayout = (FrameLayout)findViewById(2131377802);
    if ((this.jdField_a_of_type_Boolean) || (this.c))
    {
      if (paramBundle != null) {
        paramBundle.setText(2131690662);
      }
      if (localFrameLayout != null) {
        localFrameLayout.setVisibility(8);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Akal = a();
      this.jdField_a_of_type_Akal.a();
      paramBundle = super.findViewById(2131376925);
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        paramBundle.setFitsSystemWindows(true);
        paramBundle.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
      }
      return true;
      if (this.jdField_a_of_type_Int == 3013)
      {
        if (paramBundle != null) {
          paramBundle.setText(2131693498);
        }
        if (localFrameLayout != null) {
          localFrameLayout.setVisibility(8);
        }
      }
      else if (this.jdField_a_of_type_Int == 3014)
      {
        if (paramBundle != null) {
          paramBundle.setText(2131690659);
        }
        if (localFrameLayout != null) {
          localFrameLayout.setVisibility(8);
        }
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_Akal.d();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_Akal.c();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_Akal.b();
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryActivity
 * JD-Core Version:    0.7.0.1
 */