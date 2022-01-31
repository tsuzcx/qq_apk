package com.tencent.biz.qqstory.storyHome;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.model.QQStoryActivityManager;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.storyHome.proxy.TransitionCode;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo2.StoryPublishLauncher;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import nuc;

public class StoryTransitionActivity
  extends QQStoryBaseActivity
{
  private TransitionCode a;
  
  public static final Intent a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.w("zivonchen", 2, "getMainIntent() isNowTabAdded = " + NowLiveManager.c);
    }
    if (NowLiveManager.c)
    {
      ((QQStoryActivityManager)SuperManager.a(18)).a();
      paramContext = new Intent(paramContext, SplashActivity.class);
      paramContext.putExtra("fragment_id", 1);
      paramContext.putExtra("tab_index", MainFragment.f);
      paramContext.putExtra("open_now_tab_fragment", true);
      paramContext.putExtra("extra_from_share", true);
      paramContext.setFlags(335544320);
      return paramContext;
    }
    paramContext = new Intent(paramContext, QQStoryMainActivity.class);
    paramContext.setFlags(335544320);
    return paramContext;
  }
  
  private TransitionCode a(@NonNull String paramString)
  {
    try
    {
      paramString = getClassLoader().loadClass(paramString);
      if ((TransitionCode.class.isAssignableFrom(paramString)) && (TransitionCode.class != paramString))
      {
        paramString = (TransitionCode)paramString.newInstance();
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      SLog.c("StoryTransitionActivity", "createTargetObjectByName error", paramString);
    }
    return null;
  }
  
  public static final void a(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, StoryTransitionActivity.class);
    localIntent.setFlags(268435456);
    localIntent.putExtra("jump_action", 2);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, String paramString, Bundle paramBundle)
  {
    a(paramContext, paramString, paramBundle, -1);
  }
  
  public static void a(Context paramContext, String paramString, Bundle paramBundle, int paramInt)
  {
    a(paramContext, paramString, paramBundle, paramInt, false);
  }
  
  public static void a(Context paramContext, String paramString, Bundle paramBundle, int paramInt, boolean paramBoolean)
  {
    if ((paramContext == null) || (paramString == null)) {
      throw new NullPointerException("param should not be null");
    }
    if ((paramInt >= 0) && (!(paramContext instanceof Activity))) {
      throw new IllegalArgumentException("context should be an instance of Activity");
    }
    SLog.a("StoryTransitionActivity", "startAsProxy %s", paramString);
    Intent localIntent = new Intent(paramContext, StoryTransitionActivity.class);
    localIntent.putExtra("jump_action", 5);
    localIntent.putExtra("target_name", paramString);
    localIntent.putExtra("target_args", paramBundle);
    if ((paramBoolean) && (Build.VERSION.SDK_INT >= 21)) {
      localIntent.addFlags(524288);
    }
    if (paramInt >= 0)
    {
      ((Activity)paramContext).startActivityForResult(localIntent, paramInt);
      return;
    }
    paramContext.startActivity(localIntent);
  }
  
  public static boolean a(Context paramContext, long paramLong)
  {
    long l = ((StoryConfigManager)SuperManager.a(10)).b();
    if (Math.abs(System.currentTimeMillis() - l) > paramLong)
    {
      SLog.b("StoryTransitionActivity", "fireGetStoryConfig update story config from server.");
      Intent localIntent = new Intent(paramContext, StoryTransitionActivity.class);
      localIntent.setFlags(268435456);
      localIntent.putExtra("jump_action", 4);
      paramContext.startActivity(localIntent);
      return true;
    }
    SLog.b("StoryTransitionActivity", "fireGetStoryConfig do not need update story config from server.");
    return false;
  }
  
  public static final void b(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, StoryTransitionActivity.class);
    localIntent.putExtra("jump_action", 3);
    paramContext.startActivity(localIntent);
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString1, String paramString2)
  {
    StoryPublishLauncher localStoryPublishLauncher = StoryPublishLauncher.a();
    if (localStoryPublishLauncher.a())
    {
      paramString1 = new Bundle();
      paramString1.putInt("entrance_type", paramInt);
      paramString1.putString("story_default_label", getIntent().getStringExtra("story_default_label"));
      paramString1.putString("video_tag_info", paramString2);
      localStoryPublishLauncher.a(this, paramString1);
      overridePendingTransition(2131034327, 2131034167);
      return true;
    }
    long l = SystemClock.uptimeMillis();
    boolean bool;
    if ((!paramBoolean2) || (ShortVideoUtils.a(this.app)))
    {
      bool = true;
      paramString2 = new QQStoryTakeVideoActivityLauncher(this.app).a(this, paramBoolean1, bool);
      paramString2.putExtra("entrance_type", paramInt);
      if (paramString1 != null) {
        paramString2.putExtra("launch_take_video_view_extra_value_key", paramString1);
      }
      if (!bool) {
        break label216;
      }
      paramString2.putExtra("start_time", l);
      paramString2.putExtra("story_default_label", getIntent().getStringExtra("story_default_label"));
      startActivity(paramString2);
      if (!paramBoolean2) {
        break label207;
      }
      super.overridePendingTransition(2131034327, 2131034167);
    }
    for (;;)
    {
      SLog.b("StoryTransitionActivity", "launchNewVideoTakeActivity end");
      return true;
      bool = false;
      break;
      label207:
      super.overridePendingTransition(0, 0);
    }
    label216:
    startActivity(paramString2);
    return false;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    StoryPublishLauncher localStoryPublishLauncher = StoryPublishLauncher.a();
    if (localStoryPublishLauncher.a())
    {
      paramString1 = new Bundle();
      paramString1.putInt("entrance_type", paramInt1);
      paramString1.putString("story_default_label", getIntent().getStringExtra("story_default_label"));
      paramString1.putString("video_tag_info", paramString2);
      localStoryPublishLauncher.a(this, paramString1, paramInt2);
      overridePendingTransition(2131034327, 2131034167);
      return true;
    }
    long l = SystemClock.uptimeMillis();
    boolean bool;
    if ((!paramBoolean2) || (ShortVideoUtils.a(this.app)))
    {
      bool = true;
      paramString2 = new QQStoryTakeVideoActivityLauncher(this.app).a(this, paramBoolean1, bool);
      paramString2.putExtra("entrance_type", paramInt1);
      if (paramString1 != null) {
        paramString2.putExtra("launch_take_video_view_extra_value_key", paramString1);
      }
      if (!bool) {
        break label230;
      }
      paramString2.putExtra("start_time", l);
      paramString2.putExtra("story_default_label", getIntent().getStringExtra("story_default_label"));
      paramString1 = (StoryConfigManager)SuperManager.a(10);
      startActivityForResult(paramString2, paramInt2);
      if (!paramBoolean2) {
        break label221;
      }
      super.overridePendingTransition(2131034327, 2131034167);
    }
    for (;;)
    {
      SLog.b("StoryTransitionActivity", "launchNewVideoTakeActivity end");
      return true;
      bool = false;
      break;
      label221:
      super.overridePendingTransition(0, 0);
    }
    label230:
    startActivityForResult(paramString2, paramInt2);
    return false;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    TransitionCode localTransitionCode = this.a;
    if (localTransitionCode != null) {
      localTransitionCode.a(paramInt1, paramInt2, paramIntent);
    }
    switch (paramInt1)
    {
    default: 
      return;
    }
    if (paramInt2 == -1)
    {
      finish();
      startActivity(a(this));
      return;
    }
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (this.app == null)
    {
      SLog.b("StoryTransitionActivity", "StoryTransitionActivity app is null!!!!!!");
      finish();
      return false;
    }
    int i = getIntent().getIntExtra("jump_action", 0);
    if (1 == i) {
      if (!TextUtils.isEmpty(getIntent().getStringExtra("video_tag"))) {
        a(false, true, 15, null, getIntent().getStringExtra("video_tag"), 1882323);
      }
    }
    for (;;)
    {
      return true;
      a(false, true, 15, null, getIntent().getStringExtra("video_tag"));
      finish();
      continue;
      if (2 == i)
      {
        Bosses.get().postJob(new nuc(this));
        finish();
      }
      else if (3 == i)
      {
        finish();
        startActivity(a(this));
      }
      else if (4 == i)
      {
        SLog.b("StoryTransitionActivity", "update story config from server.");
        ((QQStoryHandler)((QQAppInterface)getAppInterface()).a(98)).d();
        finish();
      }
      else if (5 == i)
      {
        String str = getIntent().getStringExtra("target_name");
        SLog.a("StoryTransitionActivity", "ACTION_START_AS_PROXY  target = %s", str);
        if (str != null) {
          this.a = a(str);
        }
        if (this.a == null)
        {
          SLog.e("StoryTransitionActivity", "can not create TransitionCode object");
          finish();
        }
        else
        {
          this.a.a(this);
          this.a.a(paramBundle, getIntent().getBundleExtra("target_args"));
        }
      }
      else
      {
        SLog.b("StoryTransitionActivity", "StoryTransitionActivity unknow jumpAction is " + i);
        finish();
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    TransitionCode localTransitionCode = this.a;
    if (localTransitionCode != null)
    {
      localTransitionCode.c();
      localTransitionCode.d();
      this.a = null;
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    TransitionCode localTransitionCode = this.a;
    if (localTransitionCode != null) {
      localTransitionCode.b();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    TransitionCode localTransitionCode = this.a;
    if (localTransitionCode != null) {
      localTransitionCode.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.StoryTransitionActivity
 * JD-Core Version:    0.7.0.1
 */