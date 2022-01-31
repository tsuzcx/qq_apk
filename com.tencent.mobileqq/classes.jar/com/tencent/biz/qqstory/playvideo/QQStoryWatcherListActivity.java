package com.tencent.biz.qqstory.playvideo;

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
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.playvideo.watcherlist.QQStoryWatcherListAdapter;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.ChildViewClickListener;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.List;
import nnw;
import nnx;
import nny;
import nnz;

public class QQStoryWatcherListActivity
  extends QQStoryBaseActivity
  implements View.OnClickListener
{
  public int a;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  QQStoryWatcherListAdapter jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListAdapter;
  public VideoListFeedItem a;
  protected ChildViewClickListener a;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  public String a;
  public nnz a;
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
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonChildViewClickListener = new nny(this);
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
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, List paramList)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new nnx(this, paramBoolean1, paramBoolean2, paramList));
      return;
    }
    b(paramBoolean1, paramBoolean2, paramList);
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2, List paramList)
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
      this.jdField_c_of_type_AndroidWidgetTextView.setText("加载中，请稍候");
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(null);
      continue;
      if (this.jdField_a_of_type_Nnz.a >= 2000L)
      {
        a(0);
      }
      else
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        String str = String.format("%s人累计浏览%s次", new Object[] { UIUtils.a(this.jdField_a_of_type_Nnz.a), UIUtils.a(this.jdField_a_of_type_Nnz.b) });
        this.jdField_c_of_type_AndroidWidgetTextView.setText(str);
        this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
        this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(null);
        continue;
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setText("网络异常，请稍后重试");
        this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
        this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130970902);
    super.setTitle("浏览数");
    this.leftView.setText(2131433698);
    super.findViewById(2131362840).setBackgroundColor(getResources().getColor(2131494255));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131372161);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131372162));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131372164));
    this.jdField_c_of_type_AndroidViewView = super.findViewById(2131372163);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131368875));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2130970900, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.jdField_b_of_type_AndroidViewView);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131372160));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListAdapter = new QQStoryWatcherListAdapter(this, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new nnw(this));
    this.jdField_a_of_type_JavaLangString = super.getIntent().getStringExtra("feed_id");
    this.jdField_a_of_type_Int = super.getIntent().getIntExtra("source", 0);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("Q.qqstory.player.watcherlist.activity", 2, "doOnCreate: feedid is null!!!!");
      }
      return true;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = ((VideoListFeedItem)((FeedManager)SuperManager.a(11)).a(this.jdField_a_of_type_JavaLangString));
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem != null) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.mViewTotalTime > 0L)) {
      super.setTitle("浏览数" + UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.mViewTotalTime));
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonChildViewClickListener);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130838596);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getMinimumWidth(), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getMinimumHeight());
    this.jdField_a_of_type_Nnz = new nnz(this, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Nnz.a();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof Animatable)) {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131368875) {
      if (this.jdField_a_of_type_Nnz != null)
      {
        this.jdField_a_of_type_Nnz.a();
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    while (i != 2131372160) {
      return;
    }
    a(1);
    nnz.a(this.jdField_a_of_type_Nnz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.QQStoryWatcherListActivity
 * JD-Core Version:    0.7.0.1
 */