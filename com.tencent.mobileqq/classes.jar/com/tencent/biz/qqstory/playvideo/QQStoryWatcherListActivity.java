package com.tencent.biz.qqstory.playvideo;

import ajjy;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import awpu;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.List;
import sqg;
import tho;
import thp;
import thq;
import tww;
import uje;
import ulp;
import vms;

public class QQStoryWatcherListActivity
  extends QQStoryBaseActivity
  implements View.OnClickListener
{
  private static final String jdField_b_of_type_JavaLangString = ajjy.a(2131645338);
  public int a;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public VideoListFeedItem a;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  public String a;
  public thq a;
  tww jdField_a_of_type_Tww;
  protected ulp a;
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
    this.jdField_a_of_type_Ulp = new thp(this);
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
        this.jdField_a_of_type_Tww.a(paramList);
        break;
        this.jdField_a_of_type_Tww.b(paramList);
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
      this.jdField_c_of_type_AndroidWidgetTextView.setText(ajjy.a(2131645337));
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(null);
      continue;
      if (this.jdField_a_of_type_Thq.a >= 2000L)
      {
        a(0);
      }
      else
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        String str = String.format("%s人累计浏览%s次", new Object[] { vms.a(this.jdField_a_of_type_Thq.a), vms.a(this.jdField_a_of_type_Thq.b) });
        this.jdField_c_of_type_AndroidWidgetTextView.setText(str);
        this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
        this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(null);
        continue;
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(ajjy.a(2131645343));
        this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
        this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131495851);
    super.setTitle(jdField_b_of_type_JavaLangString);
    this.leftView.setText(2131625011);
    super.findViewById(2131309736).setBackgroundColor(getResources().getColor(2131101317));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131307500);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131307677));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131313520));
    this.jdField_c_of_type_AndroidViewView = super.findViewById(2131300084);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131309455));
    try
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130845533, 0, 0);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2131495849, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.jdField_b_of_type_AndroidViewView);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131303611));
      this.jdField_a_of_type_Tww = new tww(this, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Tww);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new tho(this));
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
        awpu.a(paramBundle);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = ((VideoListFeedItem)((uje)sqg.a(11)).a(this.jdField_a_of_type_JavaLangString));
      if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem != null) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.mViewTotalTime > 0L)) {
        super.setTitle(jdField_b_of_type_JavaLangString + vms.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.mViewTotalTime));
      }
      this.jdField_a_of_type_Tww.a(this.jdField_a_of_type_Ulp);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839113);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getMinimumWidth(), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getMinimumHeight());
      this.jdField_a_of_type_Thq = new thq(this, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Thq.a();
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
    if (i == 2131309455) {
      if (this.jdField_a_of_type_Thq != null)
      {
        this.jdField_a_of_type_Thq.a();
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    while (i != 2131303611) {
      return;
    }
    a(1);
    thq.a(this.jdField_a_of_type_Thq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.QQStoryWatcherListActivity
 * JD-Core Version:    0.7.0.1
 */