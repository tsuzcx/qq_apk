package com.tencent.mobileqq.activity.history;

import aepi;
import ahyo;
import aiab;
import aiak;
import aiat;
import aiau;
import aido;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class ChatHistoryActivity
  extends FragmentActivity
{
  int jdField_a_of_type_Int;
  ahyo jdField_a_of_type_Ahyo;
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
      if ((i == 2131364156) || (i == 2131364149))
      {
        i = 1;
      }
      else if ((i == 2131364154) || (i == 2131364161))
      {
        i = 2;
      }
      else if ((i == 2131364158) || (i == 2131364151))
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
  
  private ahyo a()
  {
    if ((this.jdField_a_of_type_Boolean) || (this.c)) {
      return new aiat(this);
    }
    if (this.jdField_a_of_type_Int == 3011) {
      return new aiab(this);
    }
    if (this.jdField_a_of_type_Int == 3012) {
      return new aido(this);
    }
    if (this.jdField_a_of_type_Int == 3013) {
      return new aiau(this);
    }
    if (this.jdField_a_of_type_Int == 3014) {
      return new aiak(this);
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
    if (this.jdField_a_of_type_Ahyo != null) {
      return this.jdField_a_of_type_Ahyo.a();
    }
    return 0;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.ChatHistoryActivity", 2, "doOnActivityResult, requestCode = " + paramInt1);
    }
    this.jdField_a_of_type_Ahyo.a(paramInt1, paramInt2, paramIntent);
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
    localIntent = aepi.a(localIntent, null);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    paramIntent.putBoolean("PicContants.NEED_COMPRESS", false);
    paramIntent.putBoolean("send_in_background", false);
    localIntent.putExtras(paramIntent);
    startActivity(localIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131558807);
    a();
    paramBundle = (TextView)findViewById(2131368670);
    FrameLayout localFrameLayout = (FrameLayout)findViewById(2131376841);
    if ((this.jdField_a_of_type_Boolean) || (this.c))
    {
      if (paramBundle != null) {
        paramBundle.setText(2131690787);
      }
      if (localFrameLayout != null) {
        localFrameLayout.setVisibility(8);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Ahyo = a();
      this.jdField_a_of_type_Ahyo.a();
      paramBundle = super.findViewById(2131376034);
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        paramBundle.setFitsSystemWindows(true);
        paramBundle.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
      }
      return true;
      if (this.jdField_a_of_type_Int == 3013)
      {
        if (paramBundle != null) {
          paramBundle.setText(2131694227);
        }
        if (localFrameLayout != null) {
          localFrameLayout.setVisibility(8);
        }
      }
      else if (this.jdField_a_of_type_Int == 3014)
      {
        if (paramBundle != null) {
          paramBundle.setText(2131690784);
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
    this.jdField_a_of_type_Ahyo.d();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_Ahyo.c();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_Ahyo.b();
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryActivity
 * JD-Core Version:    0.7.0.1
 */