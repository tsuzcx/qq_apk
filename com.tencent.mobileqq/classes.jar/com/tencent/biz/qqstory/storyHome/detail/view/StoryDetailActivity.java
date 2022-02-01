package com.tencent.biz.qqstory.storyHome.detail.view;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class StoryDetailActivity
  extends QQStoryBaseActivity
{
  private String a;
  private int b;
  private boolean c;
  private int d;
  private String e;
  private int f;
  private int g;
  private StoryDetailFragment h;
  
  private void a()
  {
    Intent localIntent = getIntent();
    this.a = localIntent.getStringExtra("feed_id");
    this.b = localIntent.getIntExtra("source", 210);
    this.c = localIntent.getBooleanExtra("should_up_keyboard", false);
    this.d = localIntent.getIntExtra("focus_comment_id", -1);
    this.e = localIntent.getStringExtra("focus_video_id");
    this.g = localIntent.getIntExtra("play_source", 0);
    this.f = localIntent.getIntExtra("commentLike_category", 0);
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt1, int paramInt2)
  {
    a(paramActivity, paramString, paramInt1, false, -1, null, paramInt2, 0);
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramActivity, paramString, paramInt1, false, -1, null, paramInt2, paramInt3);
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramActivity, paramString, paramInt1, false, paramInt2, null, paramInt3, paramInt4);
  }
  
  public static void a(Activity paramActivity, String paramString1, int paramInt1, boolean paramBoolean, int paramInt2, String paramString2, int paramInt3, int paramInt4)
  {
    Intent localIntent = new Intent(paramActivity, StoryDetailActivity.class);
    localIntent.putExtra("feed_id", paramString1);
    localIntent.putExtra("source", paramInt1);
    localIntent.putExtra("should_up_keyboard", paramBoolean);
    localIntent.putExtra("focus_comment_id", paramInt2);
    localIntent.putExtra("focus_video_id", paramString2);
    localIntent.putExtra("play_source", paramInt3);
    localIntent.putExtra("commentLike_category", paramInt4);
    if (!TextUtils.isEmpty(paramString1))
    {
      paramActivity.startActivity(localIntent);
      return;
    }
    paramActivity = new StringBuilder();
    paramActivity.append("start detail activity failed because argument feedId is null. source is ");
    paramActivity.append(paramInt1);
    throw new IllegalArgumentException(paramActivity.toString());
  }
  
  public static void a(Activity paramActivity, String paramString1, int paramInt1, boolean paramBoolean, String paramString2, int paramInt2)
  {
    a(paramActivity, paramString1, paramInt1, paramBoolean, -1, paramString2, paramInt2, 0);
  }
  
  private void b()
  {
    setContentView(2131628015);
    this.leftView.setText(2131887625);
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    this.h = StoryDetailFragment.a(this.a, this.b, this.c, this.d, this.e, this.g, this.f);
    localFragmentTransaction.replace(2131431280, this.h);
    localFragmentTransaction.commitAllowingStateLoss();
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
    this.h.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    a();
    b();
    return true;
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
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailActivity
 * JD-Core Version:    0.7.0.1
 */