package com.tencent.biz.qqstory.playvideo;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playvideo.watcherlist.QQStoryWatcherListAdapter;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.ChildViewClickListener;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.CaughtExceptionReport;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.List;

public class QQStoryWatcherListActivity
  extends QQStoryBaseActivity
  implements View.OnClickListener
{
  private static final String jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131711101);
  int jdField_a_of_type_Int;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  QQStoryWatcherListActivity.GetWatcherHelper jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity$GetWatcherHelper;
  QQStoryWatcherListAdapter jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListAdapter;
  VideoListFeedItem jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem;
  protected ChildViewClickListener a;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = true;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  boolean jdField_b_of_type_Boolean = false;
  View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  
  public QQStoryWatcherListActivity()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonChildViewClickListener = new QQStoryWatcherListActivity.3(this);
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Intent localIntent = new Intent(paramActivity, QQStoryWatcherListActivity.class);
    localIntent.putExtra("feed_id", paramString);
    localIntent.putExtra("source", paramInt);
    paramActivity.startActivity(localIntent);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, List<QQUserUIItem> paramList)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new QQStoryWatcherListActivity.2(this, paramBoolean1, paramBoolean2, paramList));
      return;
    }
    b(paramBoolean1, paramBoolean2, paramList);
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2, List<QQUserUIItem> paramList)
  {
    if (!paramBoolean1)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      return;
    }
    if (paramList != null)
    {
      this.jdField_b_of_type_Boolean = paramBoolean2;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        if (paramList.size() == 0)
        {
          this.jdField_c_of_type_AndroidViewView.setVisibility(0);
          this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
          this.jdField_a_of_type_Boolean = false;
        }
      }
      for (;;)
      {
        if (!paramBoolean2) {
          break label153;
        }
        a(3);
        return;
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListAdapter.a(paramList);
        break;
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListAdapter.b(paramList);
      }
      label153:
      a(1);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.jdField_b_of_type_Boolean = paramBoolean2;
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.qqstory.player.watcherlist.activity", 2, "setFooterText: footerMode = " + paramInt);
      }
      return;
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(null);
      continue;
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131711100));
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(null);
      continue;
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity$GetWatcherHelper.a >= 2000L)
      {
        a(0);
      }
      else
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        String str = String.format("%s人累计浏览%s次", new Object[] { UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity$GetWatcherHelper.a), UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity$GetWatcherHelper.b) });
        this.jdField_c_of_type_AndroidWidgetTextView.setText(str);
        this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
        this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(null);
        continue;
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131711106));
        this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
        this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      }
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131562001);
    super.setTitle(jdField_b_of_type_JavaLangString);
    this.leftView.setText(2131690778);
    super.findViewById(2131377356).setBackgroundColor(getResources().getColor(2131167093));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131374932);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131375108));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131381802));
    this.jdField_c_of_type_AndroidViewView = super.findViewById(2131366355);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131377014));
    try
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130846977, 0, 0);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2131561999, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.jdField_b_of_type_AndroidViewView);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370468));
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListAdapter = new QQStoryWatcherListAdapter(this, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListAdapter);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new QQStoryWatcherListActivity.1(this));
      this.jdField_a_of_type_JavaLangString = super.getIntent().getStringExtra("feed_id");
      this.jdField_a_of_type_Int = super.getIntent().getIntExtra("source", 0);
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        if (QLog.isDevelopLevel()) {
          QLog.w("Q.qqstory.player.watcherlist.activity", 2, "doOnCreate: feedid is null!!!!");
        }
        return true;
      }
    }
    catch (OutOfMemoryError paramBundle)
    {
      for (;;)
      {
        CaughtExceptionReport.a(paramBundle);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = ((VideoListFeedItem)((FeedManager)SuperManager.a(11)).a(this.jdField_a_of_type_JavaLangString));
      if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem != null) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.mViewTotalTime > 0L)) {
        super.setTitle(jdField_b_of_type_JavaLangString + UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.mViewTotalTime));
      }
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonChildViewClickListener);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839545);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getMinimumWidth(), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getMinimumHeight());
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity$GetWatcherHelper = new QQStoryWatcherListActivity.GetWatcherHelper(this, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity$GetWatcherHelper.a();
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof Animatable)) {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131377014) {
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity$GetWatcherHelper != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity$GetWatcherHelper.a();
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (i == 2131370468)
      {
        a(1);
        QQStoryWatcherListActivity.GetWatcherHelper.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity$GetWatcherHelper);
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.QQStoryWatcherListActivity
 * JD-Core Version:    0.7.0.1
 */