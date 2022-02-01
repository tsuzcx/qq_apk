package com.tencent.biz.qqstory.playvideo;

import Override;
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
import anzj;
import bdkh;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.List;
import wth;
import xko;
import xkp;
import xkq;
import xzw;
import yme;
import yop;
import zps;

public class QQStoryWatcherListActivity
  extends QQStoryBaseActivity
  implements View.OnClickListener
{
  private static final String jdField_b_of_type_JavaLangString = anzj.a(2131710006);
  public int a;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public VideoListFeedItem a;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  public String a;
  public xkq a;
  xzw jdField_a_of_type_Xzw;
  protected yop a;
  public boolean a;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public boolean b;
  View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  
  public QQStoryWatcherListActivity()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Yop = new xkp(this);
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
        this.jdField_a_of_type_Xzw.a(paramList);
        break;
        this.jdField_a_of_type_Xzw.b(paramList);
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
      this.jdField_c_of_type_AndroidWidgetTextView.setText(anzj.a(2131710005));
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(null);
      continue;
      if (this.jdField_a_of_type_Xkq.a >= 2000L)
      {
        a(0);
      }
      else
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        String str = String.format("%s人累计浏览%s次", new Object[] { zps.a(this.jdField_a_of_type_Xkq.a), zps.a(this.jdField_a_of_type_Xkq.b) });
        this.jdField_c_of_type_AndroidWidgetTextView.setText(str);
        this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
        this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(null);
        continue;
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(anzj.a(2131710011));
        this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
        this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      }
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131561924);
    super.setTitle(jdField_b_of_type_JavaLangString);
    this.leftView.setText(2131690559);
    super.findViewById(2131376925).setBackgroundColor(getResources().getColor(2131167050));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131374555);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131374731));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131381268));
    this.jdField_c_of_type_AndroidViewView = super.findViewById(2131366053);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131376597));
    try
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130846630, 0, 0);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2131561922, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.jdField_b_of_type_AndroidViewView);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370027));
      this.jdField_a_of_type_Xzw = new xzw(this, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Xzw);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new xko(this));
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
        bdkh.a(paramBundle);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = ((VideoListFeedItem)((yme)wth.a(11)).a(this.jdField_a_of_type_JavaLangString));
      if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem != null) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.mViewTotalTime > 0L)) {
        super.setTitle(jdField_b_of_type_JavaLangString + zps.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.mViewTotalTime));
      }
      this.jdField_a_of_type_Xzw.a(this.jdField_a_of_type_Yop);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839410);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getMinimumWidth(), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getMinimumHeight());
      this.jdField_a_of_type_Xkq = new xkq(this, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Xkq.a();
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
    if (i == 2131376597) {
      if (this.jdField_a_of_type_Xkq != null)
      {
        this.jdField_a_of_type_Xkq.a();
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (i == 2131370027)
      {
        a(1);
        xkq.a(this.jdField_a_of_type_Xkq);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.QQStoryWatcherListActivity
 * JD-Core Version:    0.7.0.1
 */