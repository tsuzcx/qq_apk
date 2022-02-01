package com.tencent.biz.qqstory.storyHome.memory;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.storyHome.memory.model.StoryProfileUtils;
import com.tencent.biz.qqstory.storyHome.memory.model.StoryQQ2UidConverter;
import com.tencent.biz.qqstory.storyHome.memory.model.StoryQQ2UidConverter.StoryQQ2UidCallback;
import com.tencent.biz.qqstory.storyHome.memory.view.StoryMemoriesReloadListView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.view.widget.QQStoryPullToRefreshListView.PullToRefreshListener;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;

public class QQStoryMemoriesActivity
  extends QQStoryBaseActivity
  implements StoryQQ2UidConverter.StoryQQ2UidCallback, QQStoryPullToRefreshListView.PullToRefreshListener
{
  private int a;
  private long b;
  private String c;
  private StoryQQ2UidConverter d;
  private StoryMemoriesReloadListView e;
  private StoryMemoriesFragment f;
  
  public static Intent a(Context paramContext, int paramInt, String paramString)
  {
    return b(paramContext, paramInt, paramString, -1L, true);
  }
  
  private void a(long paramLong, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.d.a(paramString);
      return;
    }
    this.d.c(paramLong);
  }
  
  public static void a(Context paramContext, int paramInt, long paramLong)
  {
    a(paramContext, paramInt, null, paramLong, true);
  }
  
  private static void a(Context paramContext, int paramInt, String paramString, long paramLong, boolean paramBoolean)
  {
    paramContext.startActivity(b(paramContext, paramInt, paramString, paramLong, paramBoolean));
  }
  
  public static void a(Context paramContext, int paramInt, String paramString, boolean paramBoolean)
  {
    a(paramContext, paramInt, paramString, -1L, paramBoolean);
  }
  
  private void a(String paramString)
  {
    SLog.a("Q.qqstory.memories.QQStoryMemoriesActivity", "get valid uid. start creating fragment. uid = %s.", paramString);
    findViewById(2131437664).setVisibility(8);
    Object localObject = this.e;
    if (localObject != null) {
      ((StoryMemoriesReloadListView)localObject).setVisibility(8);
    }
    localObject = getSupportFragmentManager().beginTransaction();
    this.f = StoryMemoriesFragment.a(this.a, paramString);
    ((FragmentTransaction)localObject).replace(2131431280, this.f);
    ((FragmentTransaction)localObject).commitAllowingStateLoss();
  }
  
  public static Intent b(Context paramContext, int paramInt, long paramLong)
  {
    return b(paramContext, paramInt, null, paramLong, true);
  }
  
  private static Intent b(Context paramContext, int paramInt, String paramString, long paramLong, boolean paramBoolean)
  {
    if ((paramLong <= 0L) && (TextUtils.isEmpty(paramString)))
    {
      paramContext = new StringBuilder();
      paramContext.append("start MemoriesActivity with illegal argument: uid = ");
      paramContext.append(paramString);
      paramContext.append(", qq = ");
      paramContext.append(paramLong);
      throw new IllegalArgumentException(paramContext.toString());
    }
    if (paramBoolean)
    {
      if (((TextUtils.isEmpty(paramString)) && (QQStoryContext.a().c(String.valueOf(paramLong)))) || (QQStoryContext.a().b(paramString))) {
        i = 1;
      } else {
        i = 2;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("");
      StoryReportor.a("memory", "clk_entry", paramInt, 0, new String[] { ((StringBuilder)localObject).toString(), "", "", "" });
    }
    int i = paramInt;
    if ((paramContext instanceof SplashActivity)) {
      if (paramInt != 1)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            i = paramInt;
          } else {
            i = 1002;
          }
        }
        else {
          i = 1001;
        }
      }
      else {
        i = 1000;
      }
    }
    Object localObject = new Intent(paramContext, QQStoryMemoriesActivity.class);
    ((Intent)localObject).putExtra("source", i);
    ((Intent)localObject).putExtra("qq_number", paramLong);
    ((Intent)localObject).putExtra("union_id", paramString);
    if (!(paramContext instanceof Activity)) {
      ((Intent)localObject).addFlags(268435456);
    }
    return localObject;
  }
  
  private void c()
  {
    setContentViewNoTitle(2131628076);
  }
  
  private void d()
  {
    Intent localIntent = getIntent();
    this.a = localIntent.getIntExtra("source", 1);
    this.b = localIntent.getLongExtra("qq_number", -1L);
    this.c = localIntent.getStringExtra("union_id");
    SLog.d("Q.qqstory.memories.QQStoryMemoriesActivity", "get arguments. uid = %s, mQQ = %d, mFrom = %d.", new Object[] { this.c, Long.valueOf(this.b), Integer.valueOf(this.a) });
    this.d = new StoryQQ2UidConverter();
    this.d.a(this);
    if (TextUtils.isEmpty(this.c))
    {
      this.d.a(this.b);
      return;
    }
    if (!StoryProfileUtils.a(this.c))
    {
      a(this.b, this.c);
      return;
    }
    a(this.c);
  }
  
  private void e()
  {
    View localView1 = findViewById(2131437664);
    View localView2 = findViewById(2131442734);
    localView1.setVisibility(8);
    if (localView2 != null)
    {
      SLog.b("Q.qqstory.memories.QQStoryMemoriesActivity", "get invalid uid. inflate reload list.");
      ((ViewStub)localView2).inflate();
      this.e = ((StoryMemoriesReloadListView)findViewById(2131442733));
      this.e.a(this);
      this.e.k();
      this.e.setPullToRefreshListener(this);
    }
  }
  
  public void a()
  {
    SLog.a("Q.qqstory.memories.QQStoryMemoriesActivity", "pull to refresh. uid = %s, qq = %d.", this.c, Long.valueOf(this.b));
    a(this.b, this.c);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if ((!isFinishing()) && ((Build.VERSION.SDK_INT < 17) || (!isDestroyed())))
    {
      if (StoryProfileUtils.a(this.c))
      {
        SLog.e("Q.qqstory.memories.QQStoryMemoriesActivity", "uid is already valid on new uid back. current uid is %s, new uid is %s.", new Object[] { this.c, paramString });
        return;
      }
      SLog.a("Q.qqstory.memories.QQStoryMemoriesActivity", "on uid back. uid = %s, fromNet = %s.", paramString, Boolean.valueOf(paramBoolean));
      if (StoryProfileUtils.a(paramString))
      {
        this.c = paramString;
        a(this.c);
        return;
      }
      if (paramBoolean)
      {
        e();
        return;
      }
      a(this.b, this.c);
      return;
    }
    SLog.e("Q.qqstory.memories.QQStoryMemoriesActivity", "uid back when activity has destroyed.");
  }
  
  protected void b()
  {
    ImmersiveUtils.trySetImmersiveStatusBar(getActivity().getWindow());
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
    StoryMemoriesFragment localStoryMemoriesFragment = this.f;
    if (localStoryMemoriesFragment != null) {
      localStoryMemoriesFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void doOnBackPressed()
  {
    StoryMemoriesFragment localStoryMemoriesFragment = this.f;
    boolean bool;
    if (localStoryMemoriesFragment != null) {
      bool = localStoryMemoriesFragment.a();
    } else {
      bool = false;
    }
    if (!bool) {
      super.doOnBackPressed();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    this.mNeedStatusTrans = false;
    super.doOnCreate(paramBundle);
    c();
    d();
    return true;
  }
  
  protected void doOnDestroy()
  {
    StoryMemoriesReloadListView localStoryMemoriesReloadListView = this.e;
    if (localStoryMemoriesReloadListView != null) {
      localStoryMemoriesReloadListView.m();
    }
    super.doOnDestroy();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    ((StringBuilder)localObject).append(Build.MODEL);
    localObject = ((StringBuilder)localObject).toString();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MANUFACTURER = ");
      localStringBuilder.append(Build.MANUFACTURER);
      localStringBuilder.append(", MODEL = ");
      localStringBuilder.append(Build.MODEL);
      QLog.i("Q.qqstory.memories.QQStoryMemoriesActivity", 2, localStringBuilder.toString());
    }
    if ((localObject != null) && ((((String)localObject).equals("MeizuPRO 7-S")) || (((String)localObject).equalsIgnoreCase("MeizuM711C"))))
    {
      ImmersiveUtils.clearCoverForStatus(getWindow(), true);
      return;
    }
    b();
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle) {}
  
  public void finish()
  {
    super.finish();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.QQStoryMemoriesActivity
 * JD-Core Version:    0.7.0.1
 */