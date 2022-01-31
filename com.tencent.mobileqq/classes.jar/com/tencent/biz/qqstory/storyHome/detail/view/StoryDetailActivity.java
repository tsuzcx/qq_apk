package com.tencent.biz.qqstory.storyHome.detail.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import zzs;

public class StoryDetailActivity
  extends QQStoryBaseActivity
{
  private int jdField_a_of_type_Int;
  private StoryDetailFragment jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int c;
  private int d;
  
  private void a()
  {
    Intent localIntent = getIntent();
    this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("feed_id");
    this.jdField_a_of_type_Int = localIntent.getIntExtra("source", 210);
    this.jdField_a_of_type_Boolean = localIntent.getBooleanExtra("should_up_keyboard", false);
    this.jdField_b_of_type_Int = localIntent.getIntExtra("focus_comment_id", -1);
    this.jdField_b_of_type_JavaLangString = localIntent.getStringExtra("focus_video_id");
    this.d = localIntent.getIntExtra("play_source", 0);
    this.c = localIntent.getIntExtra("commentLike_category", 0);
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
    if (TextUtils.isEmpty(paramString1)) {
      throw new IllegalArgumentException("start detail activity failed because argument feedId is null. source is " + paramInt1);
    }
    paramActivity.startActivity(localIntent);
  }
  
  public static void a(Activity paramActivity, String paramString1, int paramInt1, boolean paramBoolean, String paramString2, int paramInt2)
  {
    a(paramActivity, paramString1, paramInt1, paramBoolean, -1, paramString2, paramInt2, 0);
  }
  
  private void d()
  {
    setContentView(2131561210);
    this.leftView.setText(2131690572);
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment = StoryDetailFragment.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Int, this.jdField_b_of_type_JavaLangString, this.d, this.c);
    localFragmentTransaction.replace(2131364657, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment);
    localFragmentTransaction.commitAllowingStateLoss();
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    a();
    d();
    return true;
  }
  
  public void doOnSaveInstanceState(Bundle paramBundle) {}
  
  public void finish()
  {
    super.finish();
    zzs.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailActivity
 * JD-Core Version:    0.7.0.1
 */