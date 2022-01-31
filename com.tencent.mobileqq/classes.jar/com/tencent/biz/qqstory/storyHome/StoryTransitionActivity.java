package com.tencent.biz.qqstory.storyHome;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import nga;
import org.json.JSONException;
import org.json.JSONObject;
import ult;
import uvo;
import uvt;
import uwa;
import whg;
import whq;
import wqu;
import wxe;
import xpk;

public class StoryTransitionActivity
  extends QQStoryBaseActivity
{
  private int jdField_a_of_type_Int;
  private wqu jdField_a_of_type_Wqu;
  
  public static final Intent a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.w("zivonchen", 2, "getMainIntent() isNowTabAdded = " + nga.c);
    }
    if (nga.c)
    {
      ((uvo)uwa.a(18)).a();
      paramContext = new Intent(paramContext, SplashActivity.class);
      paramContext.putExtra("fragment_id", 1);
      paramContext.putExtra("tab_index", MainFragment.g);
      paramContext.putExtra("open_now_tab_fragment", true);
      paramContext.putExtra("extra_from_share", true);
      paramContext.setFlags(335544320);
      return paramContext;
    }
    paramContext = new Intent(paramContext, QQStoryMainActivity.class);
    paramContext.setFlags(335544320);
    return paramContext;
  }
  
  private wqu a(@NonNull String paramString)
  {
    try
    {
      paramString = getClassLoader().loadClass(paramString);
      if ((wqu.class.isAssignableFrom(paramString)) && (wqu.class != paramString))
      {
        paramString = (wqu)paramString.newInstance();
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      wxe.c("StoryTransitionActivity", "createTargetObjectByName error", paramString);
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
    wxe.a("StoryTransitionActivity", "startAsProxy %s", paramString);
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
  
  public static final void b(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, StoryTransitionActivity.class);
    localIntent.putExtra("jump_action", 3);
    paramContext.startActivity(localIntent);
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString1, String paramString2)
  {
    xpk localxpk = xpk.a();
    if (localxpk.a())
    {
      paramString1 = new Bundle();
      paramString1.putInt("entrance_type", paramInt);
      paramString1.putString("story_default_label", getIntent().getStringExtra("story_default_label"));
      paramString1.putString("video_tag_info", paramString2);
      localxpk.a(this, paramString1);
      overridePendingTransition(2130772233, 2130772038);
      return true;
    }
    long l = SystemClock.uptimeMillis();
    boolean bool;
    if ((!paramBoolean2) || (ShortVideoUtils.a(this.app)))
    {
      bool = true;
      paramString2 = new whg(this.app).a(this, paramBoolean1, bool);
      paramString2.putExtra("entrance_type", paramInt);
      if (paramString1 != null) {
        paramString2.putExtra("launch_take_video_view_extra_value_key", paramString1);
      }
      if (!bool) {
        break label214;
      }
      paramString2.putExtra("start_time", l);
      paramString2.putExtra("story_default_label", getIntent().getStringExtra("story_default_label"));
      startActivity(paramString2);
      if (!paramBoolean2) {
        break label205;
      }
      super.overridePendingTransition(2130772233, 2130772038);
    }
    for (;;)
    {
      wxe.b("StoryTransitionActivity", "launchNewVideoTakeActivity end");
      return true;
      bool = false;
      break;
      label205:
      super.overridePendingTransition(0, 0);
    }
    label214:
    startActivity(paramString2);
    return false;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    xpk localxpk = xpk.a();
    if (localxpk.a())
    {
      paramString1 = new Bundle();
      paramString1.putInt("entrance_type", paramInt1);
      paramString1.putString("story_default_label", getIntent().getStringExtra("story_default_label"));
      paramString1.putString("video_tag_info", paramString2);
      localxpk.a(this, paramString1, paramInt2);
      overridePendingTransition(2130772233, 2130772038);
      return true;
    }
    long l = SystemClock.uptimeMillis();
    boolean bool;
    if ((!paramBoolean2) || (ShortVideoUtils.a(this.app)))
    {
      bool = true;
      paramString2 = new whg(this.app).a(this, paramBoolean1, bool);
      paramString2.putExtra("entrance_type", paramInt1);
      if (paramString1 != null) {
        paramString2.putExtra("launch_take_video_view_extra_value_key", paramString1);
      }
      if (!bool) {
        break label228;
      }
      paramString2.putExtra("start_time", l);
      paramString2.putExtra("story_default_label", getIntent().getStringExtra("story_default_label"));
      paramString1 = (uvt)uwa.a(10);
      startActivityForResult(paramString2, paramInt2);
      if (!paramBoolean2) {
        break label219;
      }
      super.overridePendingTransition(2130772233, 2130772038);
    }
    for (;;)
    {
      wxe.b("StoryTransitionActivity", "launchNewVideoTakeActivity end");
      return true;
      bool = false;
      break;
      label219:
      super.overridePendingTransition(0, 0);
    }
    label228:
    startActivityForResult(paramString2, paramInt2);
    return false;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    wqu localwqu = this.jdField_a_of_type_Wqu;
    if (localwqu != null) {
      localwqu.a(paramInt1, paramInt2, paramIntent);
    }
    switch (paramInt1)
    {
    default: 
      return;
    case 1882323: 
      if (paramInt2 == -1)
      {
        finish();
        startActivity(a(this));
        return;
      }
      finish();
      return;
    }
    if ((paramInt2 == -1) && (this.jdField_a_of_type_Int == 1)) {
      startActivity(a(this));
    }
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    int i = 15;
    super.doOnCreate(paramBundle);
    if (this.app == null)
    {
      wxe.b("StoryTransitionActivity", "StoryTransitionActivity app is null!!!!!!");
      finish();
      return false;
    }
    int j = getIntent().getIntExtra("jump_action", 0);
    if (1 == j)
    {
      paramBundle = getIntent().getStringExtra("video_tag");
      if (!TextUtils.isEmpty(paramBundle))
      {
        try
        {
          boolean bool = "web_medal".equals(new JSONObject(paramBundle).optString("src_type"));
          if (bool) {
            i = 18;
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            wxe.a("StoryTransitionActivity", "parse tag json error, json:%s, error:%s", paramBundle, localJSONException);
          }
        }
        a(false, true, i, null, getIntent().getStringExtra("video_tag"), 1882323);
      }
    }
    for (;;)
    {
      return true;
      a(false, true, 15, null, getIntent().getStringExtra("video_tag"));
      finish();
      continue;
      if (2 == j)
      {
        Bosses.get().postJob(new whq(this, "StoryTransitionActivity"));
        finish();
      }
      else if (3 == j)
      {
        finish();
        startActivity(a(this));
      }
      else if (4 == j)
      {
        wxe.b("StoryTransitionActivity", "update story config from server.");
        ((ult)((QQAppInterface)getAppInterface()).a(98)).d();
        finish();
      }
      else
      {
        Object localObject;
        if (5 == j)
        {
          localObject = getIntent().getStringExtra("target_name");
          wxe.a("StoryTransitionActivity", "ACTION_START_AS_PROXY  target = %s", localObject);
          if (localObject != null) {
            this.jdField_a_of_type_Wqu = a((String)localObject);
          }
          if (this.jdField_a_of_type_Wqu == null)
          {
            wxe.e("StoryTransitionActivity", "can not create TransitionCode object");
            finish();
          }
          else
          {
            this.jdField_a_of_type_Wqu.a(this);
            this.jdField_a_of_type_Wqu.a(paramBundle, getIntent().getBundleExtra("target_args"));
          }
        }
        else if (6 == j)
        {
          this.jdField_a_of_type_Int = getIntent().getIntExtra("web_target_type", 0);
          paramBundle = xpk.a();
          localObject = new Bundle();
          ((Bundle)localObject).putBoolean("resource_need_all_wait", true);
          ((Bundle)localObject).putInt("entrance_type", 104);
          paramBundle.a(this, (Bundle)localObject, 100);
          overridePendingTransition(2130772233, 2130772038);
          wxe.c("StoryTransitionActivity", "web to story  dealType:" + this.jdField_a_of_type_Int);
        }
        else if (7 == j)
        {
          paramBundle = getIntent().getExtras();
          paramBundle.putBoolean("resource_need_all_wait", true);
          xpk.a().a(this, paramBundle, 11000);
          overridePendingTransition(2130772233, 2130772038);
          finish();
        }
        else
        {
          wxe.b("StoryTransitionActivity", "StoryTransitionActivity unknow jumpAction is " + j);
          finish();
        }
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    wqu localwqu = this.jdField_a_of_type_Wqu;
    if (localwqu != null)
    {
      localwqu.a();
      localwqu.d();
      this.jdField_a_of_type_Wqu = null;
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    wqu localwqu = this.jdField_a_of_type_Wqu;
    if (localwqu != null) {
      localwqu.c();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    wqu localwqu = this.jdField_a_of_type_Wqu;
    if (localwqu != null) {
      localwqu.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.StoryTransitionActivity
 * JD-Core Version:    0.7.0.1
 */