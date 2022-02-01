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
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport;
import com.tencent.widget.XListView;
import java.util.List;

public class QQStoryWatcherListActivity
  extends QQStoryBaseActivity
  implements View.OnClickListener
{
  private static final String jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131711076);
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
        }
        else
        {
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
          this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListAdapter.a(paramList);
        }
        this.jdField_a_of_type_Boolean = false;
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListAdapter.b(paramList);
      }
      if (paramBoolean2)
      {
        a(3);
        return;
      }
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
    Object localObject;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt == 3) {
            if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity$GetWatcherHelper.a >= 2000L)
            {
              a(0);
            }
            else
            {
              this.jdField_b_of_type_AndroidViewView.setVisibility(0);
              localObject = String.format("%s人累计浏览%s次", new Object[] { UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity$GetWatcherHelper.a), UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity$GetWatcherHelper.b) });
              this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
              this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
              ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
              this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(null);
            }
          }
        }
        else
        {
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
          this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131711081));
          this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
          ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
          this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
        }
      }
      else
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131711075));
        this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
        this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(null);
      }
    }
    else
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(null);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setFooterText: footerMode = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.w("Q.qqstory.player.watcherlist.activity", 2, ((StringBuilder)localObject).toString());
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131561835);
    super.setTitle(jdField_b_of_type_JavaLangString);
    this.leftView.setText(2131690706);
    super.findViewById(2131376809).setBackgroundColor(getResources().getColor(2131167116));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131374465);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131374624));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131381024));
    this.jdField_c_of_type_AndroidViewView = super.findViewById(2131366241);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131376496));
    try
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130846855, 0, 0);
    }
    catch (OutOfMemoryError paramBundle)
    {
      CaughtExceptionReport.a(paramBundle);
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2131561833, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.jdField_b_of_type_AndroidViewView);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370127));
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
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = ((VideoListFeedItem)((FeedManager)SuperManager.a(11)).a(this.jdField_a_of_type_JavaLangString));
    paramBundle = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem;
    if ((paramBundle != null) && (paramBundle.mViewTotalTime > 0L))
    {
      paramBundle = new StringBuilder();
      paramBundle.append(jdField_b_of_type_JavaLangString);
      paramBundle.append(UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.mViewTotalTime));
      super.setTitle(paramBundle.toString());
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonChildViewClickListener);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839401);
    paramBundle = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    paramBundle.setBounds(0, 0, paramBundle.getMinimumWidth(), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getMinimumHeight());
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity$GetWatcherHelper = new QQStoryWatcherListActivity.GetWatcherHelper(this, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity$GetWatcherHelper.a();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if ((localDrawable instanceof Animatable)) {
      ((Animatable)localDrawable).stop();
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131376496)
    {
      QQStoryWatcherListActivity.GetWatcherHelper localGetWatcherHelper = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity$GetWatcherHelper;
      if (localGetWatcherHelper != null)
      {
        localGetWatcherHelper.a();
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    else if (i == 2131370127)
    {
      a(1);
      QQStoryWatcherListActivity.GetWatcherHelper.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity$GetWatcherHelper);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.QQStoryWatcherListActivity
 * JD-Core Version:    0.7.0.1
 */