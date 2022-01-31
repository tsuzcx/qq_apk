package com.tencent.biz.qqstory.storyHome.memory;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.storyHome.memory.model.StoryProfileUtils;
import com.tencent.biz.qqstory.storyHome.memory.model.StoryQQ2UidConverter;
import com.tencent.biz.qqstory.storyHome.memory.model.StoryQQ2UidConverter.StoryQQ2UidCallback;
import com.tencent.biz.qqstory.storyHome.memory.view.StoryMemoriesReloadListView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.view.widget.QQStoryPullToRefreshListView.PullToRefreshListener;
import com.tencent.mfsdk.LeakInspector.ActivityLeakSolution;
import com.tencent.mobileqq.activity.SplashActivity;

public class QQStoryMemoriesActivity
  extends QQStoryBaseActivity
  implements StoryQQ2UidConverter.StoryQQ2UidCallback, QQStoryPullToRefreshListView.PullToRefreshListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private StoryMemoriesFragment jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment;
  private StoryQQ2UidConverter jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelStoryQQ2UidConverter;
  private StoryMemoriesReloadListView jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesReloadListView;
  private String jdField_a_of_type_JavaLangString;
  
  public static Intent a(Context paramContext, int paramInt, long paramLong)
  {
    return a(paramContext, paramInt, null, paramLong, true);
  }
  
  public static Intent a(Context paramContext, int paramInt, String paramString)
  {
    return a(paramContext, paramInt, paramString, -1L, true);
  }
  
  private static Intent a(Context paramContext, int paramInt, String paramString, long paramLong, boolean paramBoolean)
  {
    if ((paramLong <= 0L) && (TextUtils.isEmpty(paramString))) {
      throw new IllegalArgumentException("start MemoriesActivity with illegal argument: uid = " + paramString + ", qq = " + paramLong);
    }
    int i;
    if (paramBoolean)
    {
      if ((!TextUtils.isEmpty(paramString)) || (!QQStoryContext.a().b(String.valueOf(paramLong)))) {
        break label233;
      }
      i = 1;
    }
    for (;;)
    {
      StoryReportor.a("memory", "clk_entry", paramInt, 0, new String[] { i + "", "", "", "" });
      i = paramInt;
      if ((paramContext instanceof SplashActivity))
      {
        i = paramInt;
        switch (paramInt)
        {
        default: 
          i = paramInt;
        }
      }
      for (;;)
      {
        Intent localIntent = new Intent(paramContext, QQStoryMemoriesActivity.class);
        localIntent.putExtra("source", i);
        localIntent.putExtra("qq_number", paramLong);
        localIntent.putExtra("union_id", paramString);
        if (!(paramContext instanceof Activity)) {
          localIntent.addFlags(268435456);
        }
        return localIntent;
        label233:
        if (!QQStoryContext.a().a(paramString)) {
          break label273;
        }
        i = 1;
        break;
        i = 1000;
        continue;
        i = 1001;
        continue;
        i = 1002;
      }
      label273:
      i = 2;
    }
  }
  
  private void a(long paramLong, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelStoryQQ2UidConverter.a(paramString);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelStoryQQ2UidConverter.b(paramLong);
  }
  
  public static void a(Context paramContext, int paramInt, long paramLong)
  {
    a(paramContext, paramInt, null, paramLong, true);
  }
  
  private static void a(Context paramContext, int paramInt, String paramString, long paramLong, boolean paramBoolean)
  {
    paramContext.startActivity(a(paramContext, paramInt, paramString, paramLong, paramBoolean));
  }
  
  public static void a(Context paramContext, int paramInt, String paramString, boolean paramBoolean)
  {
    a(paramContext, paramInt, paramString, -1L, paramBoolean);
  }
  
  private void b()
  {
    setContentViewNoTitle(2130970717);
  }
  
  private void c()
  {
    Intent localIntent = getIntent();
    this.jdField_a_of_type_Int = localIntent.getIntExtra("source", 1);
    this.jdField_a_of_type_Long = localIntent.getLongExtra("qq_number", -1L);
    this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("union_id");
    SLog.d("Q.qqstory.memories.QQStoryMemoriesActivity", "get arguments. uid = %s, mQQ = %d, mFrom = %d.", new Object[] { this.jdField_a_of_type_JavaLangString, Long.valueOf(this.jdField_a_of_type_Long), Integer.valueOf(this.jdField_a_of_type_Int) });
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelStoryQQ2UidConverter = new StoryQQ2UidConverter();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelStoryQQ2UidConverter.a(this);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelStoryQQ2UidConverter.a(this.jdField_a_of_type_Long);
      return;
    }
    if (!StoryProfileUtils.a(this.jdField_a_of_type_JavaLangString))
    {
      a(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString);
      return;
    }
    c(this.jdField_a_of_type_JavaLangString);
  }
  
  private void c(String paramString)
  {
    SLog.a("Q.qqstory.memories.QQStoryMemoriesActivity", "get valid uid. start creating fragment. uid = %s.", paramString);
    findViewById(2131362933).setVisibility(8);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesReloadListView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesReloadListView.setVisibility(8);
    }
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment = StoryMemoriesFragment.a(this.jdField_a_of_type_Int, paramString);
    localFragmentTransaction.replace(2131362823, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment);
    localFragmentTransaction.commitAllowingStateLoss();
  }
  
  private void d()
  {
    View localView1 = findViewById(2131362933);
    View localView2 = findViewById(2131371690);
    localView1.setVisibility(8);
    if (localView2 != null)
    {
      SLog.b("Q.qqstory.memories.QQStoryMemoriesActivity", "get invalid uid. inflate reload list.");
      ((ViewStub)localView2).inflate();
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesReloadListView = ((StoryMemoriesReloadListView)findViewById(2131371729));
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesReloadListView.a(this);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesReloadListView.k();
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesReloadListView.setPullToRefreshListener(this);
    }
  }
  
  public void a()
  {
    SLog.a("Q.qqstory.memories.QQStoryMemoriesActivity", "pull to refresh. uid = %s, qq = %d.", this.jdField_a_of_type_JavaLangString, Long.valueOf(this.jdField_a_of_type_Long));
    a(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if ((isFinishing()) || ((Build.VERSION.SDK_INT >= 17) && (isDestroyed())))
    {
      SLog.e("Q.qqstory.memories.QQStoryMemoriesActivity", "uid back when activity has destroyed.");
      return;
    }
    if (StoryProfileUtils.a(this.jdField_a_of_type_JavaLangString))
    {
      SLog.e("Q.qqstory.memories.QQStoryMemoriesActivity", "uid is already valid on new uid back. current uid is %s, new uid is %s.", new Object[] { this.jdField_a_of_type_JavaLangString, paramString });
      return;
    }
    SLog.a("Q.qqstory.memories.QQStoryMemoriesActivity", "on uid back. uid = %s, fromNet = %s.", paramString, Boolean.valueOf(paramBoolean));
    if (StoryProfileUtils.a(paramString))
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      c(this.jdField_a_of_type_JavaLangString);
      return;
    }
    if (paramBoolean)
    {
      d();
      return;
    }
    a(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void doOnBackPressed()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment != null) {
      bool = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment.a();
    }
    if (!bool) {
      super.doOnBackPressed();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    this.mNeedStatusTrans = false;
    b();
    c();
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesReloadListView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesReloadListView.m();
    }
    super.doOnDestroy();
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle) {}
  
  public void finish()
  {
    super.finish();
    ActivityLeakSolution.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.QQStoryMemoriesActivity
 * JD-Core Version:    0.7.0.1
 */