package com.tencent.mobileqq.activity.history;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;

public class ChatHistoryActivity
  extends BaseActivity
{
  ChatHistoryBaseViewController a;
  int b;
  boolean c;
  boolean d;
  boolean e;
  int f;
  
  public static int a(Context paramContext)
  {
    boolean bool = paramContext instanceof ChatHistoryActivity;
    int j = 0;
    int i;
    if (bool)
    {
      paramContext = (ChatHistoryActivity)paramContext;
      int k = paramContext.a();
      if (paramContext.b == 3013) {
        i = 3;
      } else if ((k != 2131430561) && (k != 2131430552))
      {
        if ((k != 2131430557) && (k != 2131430566))
        {
          if ((k != 2131430563) && (k != 2131430554))
          {
            i = j;
            if (k == 2131430555) {
              i = 7;
            }
          }
          else
          {
            i = 4;
          }
        }
        else {
          i = 2;
        }
      }
      else {
        i = 1;
      }
    }
    else
    {
      i = j;
      if ((paramContext instanceof PublicFragmentActivity))
      {
        i = j;
        if ((((PublicFragmentActivity)paramContext).a() instanceof ChatHistoryBubbleListForTroopFragment)) {
          i = 6;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("getTagType, result = ");
      paramContext.append(i);
      QLog.d("Q.history.ChatHistoryActivity", 2, paramContext.toString());
    }
    return i;
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, ChatHistoryActivity.class);
    localIntent.putExtra("FromType", 3015);
    localIntent.putExtra("SissionUin", paramString);
    localIntent.putExtra("uin", paramString);
    paramActivity.startActivity(localIntent);
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", paramInt1);
    localIntent.putExtra("FromType", paramInt2);
    QPublicFragmentActivity.start(paramActivity, localIntent, ChatHistoryMenuFragment.class);
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
  
  private void b()
  {
    this.b = getIntent().getIntExtra("FromType", 3011);
    this.c = getIntent().getBooleanExtra("extra.IS_FROM_CHAT_AIO_GALLERY", false);
    this.d = getIntent().getBooleanExtra("need_jump_to_msg", false);
    this.e = getIntent().getBooleanExtra("FromTroopAlbum", false);
    this.f = getIntent().getIntExtra("TargetTabPos", 0);
  }
  
  private ChatHistoryBaseViewController c()
  {
    if ((!this.c) && (!this.e))
    {
      int i = this.b;
      if (i == 3011) {
        return new ChatHistoryC2CViewController(this);
      }
      if (i == 3012) {
        return new ChatHistoryTroopViewController(this);
      }
      if (i == 3013) {
        return new ChatHistoryReadOnlyViewController(this);
      }
      if (i == 3014) {
        return new ChatHistoryEmotionViewController(this);
      }
      if (i == 3015) {
        return new ChatHistoryDatalineViewController(this);
      }
      return null;
    }
    return new ChatHistoryPicVideoViewController(this);
  }
  
  public int a()
  {
    ChatHistoryBaseViewController localChatHistoryBaseViewController = this.a;
    if (localChatHistoryBaseViewController != null) {
      return localChatHistoryBaseViewController.i();
    }
    return 0;
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
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnActivityResult, requestCode = ");
      ((StringBuilder)localObject).append(paramInt1);
      QLog.d("Q.history.ChatHistoryActivity", 2, ((StringBuilder)localObject).toString());
    }
    this.a.a(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if (paramInt1 != 37) {
        return;
      }
      localObject = new Intent(this, SendPhotoActivity.class);
      paramIntent = new Bundle(paramIntent.getExtras());
      if (QLog.isColorLevel()) {
        QLog.d("forward", 2, "AIOListGallerysence startChatAndSendMsg IS_WAIT_DEST_RESULT=true");
      }
      paramIntent.putBoolean("PhotoConst.HANDLE_DEST_RESULT", true);
      paramIntent.putInt("PhotoConst.SEND_BUSINESS_TYPE", 1031);
      ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
      localObject = AIOUtils.a((Intent)localObject, null);
      ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      paramIntent.putBoolean("PicContants.NEED_COMPRESS", false);
      paramIntent.putBoolean("send_in_background", false);
      ((Intent)localObject).putExtras(paramIntent);
      startActivity((Intent)localObject);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131624472);
    b();
    paramBundle = (TextView)findViewById(2131436227);
    FrameLayout localFrameLayout = (FrameLayout)findViewById(2131446095);
    if ((!this.c) && (!this.e))
    {
      int i = this.b;
      if (i == 3013)
      {
        if (paramBundle != null) {
          paramBundle.setText(2131891528);
        }
        if (localFrameLayout != null) {
          localFrameLayout.setVisibility(8);
        }
      }
      else if (i == 3014)
      {
        if (paramBundle != null) {
          paramBundle.setText(2131887740);
        }
        if (localFrameLayout != null) {
          localFrameLayout.setVisibility(8);
        }
      }
    }
    else
    {
      if (paramBundle != null) {
        paramBundle.setText(2131887743);
      }
      if (localFrameLayout != null) {
        localFrameLayout.setVisibility(8);
      }
    }
    this.a = c();
    this.a.c();
    paramBundle = this.a;
    if (((paramBundle instanceof ChatHistoryC2CViewController)) || ((paramBundle instanceof ChatHistoryTroopViewController)))
    {
      ((ChatHistoryCommonViewController)this.a).c(this.f);
      ((ChatHistoryCommonViewController)this.a).p();
    }
    paramBundle = super.findViewById(2131445137);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramBundle.setFitsSystemWindows(true);
      paramBundle.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.a.f();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.a.e();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.a.d();
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    if (paramBundle != null)
    {
      paramBundle.remove("android:support:fragments");
      QLog.d("Q.history.ChatHistoryActivity", 1, "doOnSaveInstanceState outState.remove");
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    this.a.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryActivity
 * JD-Core Version:    0.7.0.1
 */