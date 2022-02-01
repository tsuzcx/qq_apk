package com.tencent.biz.qqstory.takevideo;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.boundaries.extension.widgets.TrimTextureVideoView;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.ScrollFrameSelectBar;
import com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.ScrollFrameSelectBar.OnRangeValueChangeListener;
import com.tencent.biz.qqstory.takevideo2.StoryPublishParams;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.richmedia.QQStoryFlowCallback;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;

public class LocalVideoSelectActivity
  extends QQStoryBaseActivity
  implements View.OnClickListener, ScrollFrameSelectBar.OnRangeValueChangeListener
{
  public int a;
  public long a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TrimTextureVideoView jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView;
  private ScrollFrameSelectBar jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar;
  private LocalMediaInfo jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
  public String a;
  private boolean jdField_a_of_type_Boolean;
  public int b;
  public long b;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  public int c;
  private boolean c;
  public int d;
  private boolean d;
  private boolean e = false;
  private int g;
  private int h;
  private int i = 0;
  private int j = -1;
  private int k = -1;
  
  public LocalVideoSelectActivity()
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
  }
  
  private void a()
  {
    this.e = false;
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131363738));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131363736));
    this.e = LiuHaiUtils.a(this.jdField_b_of_type_AndroidWidgetLinearLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout, 0);
  }
  
  private void d()
  {
    finish();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    c(paramInt1, paramInt2);
    if ((this.j < 0) || (this.k < 0))
    {
      this.j = paramInt1;
      this.k = paramInt2;
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    c(paramInt1, paramInt2);
  }
  
  protected void c(int paramInt1, int paramInt2)
  {
    paramInt1 = (int)Math.floor((paramInt2 - paramInt1) / 1000.0F);
    paramInt2 = (int)Math.ceil(paramInt1 / 10.0F);
    if (this.jdField_d_of_type_Boolean) {}
    for (String str = String.format(HardCodeUtil.a(2131706325), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });; str = String.format(HardCodeUtil.a(2131706326), new Object[] { Integer.valueOf(paramInt1) }))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      return;
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
  
  public void doOnBackPressed()
  {
    d();
  }
  
  @TargetApi(11)
  public boolean doOnCreate(@Nullable Bundle paramBundle)
  {
    LiuHaiUtils.a(this);
    getWindow().addFlags(1024);
    if (LiuHaiUtils.c()) {
      LiuHaiUtils.b(this);
    }
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    this.isClearCoverLayer = false;
    super.doOnCreate(paramBundle);
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("from_slideshow_to_share", false);
    this.i = getIntent().getIntExtra("video_index", 0);
    this.jdField_b_of_type_Int = getIntent().getIntExtra("start_index", 0);
    this.jdField_c_of_type_Int = getIntent().getIntExtra("end_index", 0);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("scroll_x", 0);
    this.jdField_d_of_type_Int = getIntent().getIntExtra("entrance_type", 0);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("op_entrance_type");
    this.jdField_a_of_type_Long = getIntent().getLongExtra("start_time", 0L);
    this.jdField_b_of_type_Long = getIntent().getLongExtra("end_time", 0L);
    int m;
    if (paramBundle == null)
    {
      m = 1;
      if (m == 0) {
        break label231;
      }
      paramBundle = getIntent();
      if (this.jdField_b_of_type_Boolean) {
        break label226;
      }
    }
    label226:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_c_of_type_Boolean = QQStoryFlowCallback.a(this, paramBundle, bool);
      if (!this.jdField_c_of_type_Boolean) {
        break label259;
      }
      SLog.c("Q.qqstory.publish.edit.LocalVideoSelectActivity", "activity on-create, go through, start edit video activity directly");
      return false;
      m = 0;
      break;
    }
    label231:
    this.jdField_c_of_type_Boolean = paramBundle.getBoolean("mGoThrough");
    if (this.jdField_c_of_type_Boolean)
    {
      SLog.c("Q.qqstory.publish.edit.LocalVideoSelectActivity", "activity re-create, do nothing");
      return false;
    }
    label259:
    SLog.c("Q.qqstory.publish.edit.LocalVideoSelectActivity", "activity on-create, init ui");
    setContentViewC(2131561841);
    SLog.d("Q.qqstory.publish.edit.LocalVideoSelectActivity", "onCreate");
    a();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131375019));
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = ((LocalMediaInfo)getIntent().getParcelableExtra("media_info"));
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path;
    paramBundle = new MediaMetadataRetriever();
    try
    {
      paramBundle.setDataSource(this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight = Integer.parseInt(paramBundle.extractMetadata(19));
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth = Integer.parseInt(paramBundle.extractMetadata(18));
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation = Integer.parseInt(paramBundle.extractMetadata(24));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
        paramBundle.release();
      }
    }
    finally
    {
      paramBundle.release();
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131375018));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131375021));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375020));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar = ((ScrollFrameSelectBar)findViewById(2131374994));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.setMinDuration(2000);
    if (this.e)
    {
      paramBundle = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.getLayoutParams();
      paramBundle.bottomMargin = 0;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.setLayoutParams(paramBundle);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView = ((TrimTextureVideoView)findViewById(2131370776));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.setOnRangeValueChangeListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.post(new LocalVideoSelectActivity.1(this));
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setVideoPath(this.jdField_b_of_type_JavaLangString);
    if (this.e)
    {
      paramBundle = (RelativeLayout)findViewById(2131363496);
      ((ViewGroup)paramBundle.getParent()).removeView(paramBundle);
      localObject1 = paramBundle.getLayoutParams();
      localObject1 = new RelativeLayout.LayoutParams(((ViewGroup.LayoutParams)localObject1).width, ((ViewGroup.LayoutParams)localObject1).height);
      ((RelativeLayout.LayoutParams)localObject1).topMargin = ViewUtils.a(14.0F);
      ((RelativeLayout.LayoutParams)localObject1).leftMargin = ViewUtils.a(12.0F);
      ((RelativeLayout.LayoutParams)localObject1).rightMargin = ViewUtils.a(12.0F);
      ((RelativeLayout.LayoutParams)localObject1).addRule(10, -1);
      ((RelativeLayout.LayoutParams)localObject1).addRule(12, 0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramBundle, (ViewGroup.LayoutParams)localObject1);
    }
    paramBundle = getIntent().getStringExtra("video_refer");
    if ((!"tribe".equals(paramBundle)) && (!"READINJOY_VIDEO".equals(paramBundle))) {
      this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      this.g = Math.min(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth);
      this.h = Math.max(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth);
      if (QQStoryFlowCallback.a != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(QQStoryFlowCallback.a);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        SLog.b("Q.qqstory.publish.edit.LocalVideoSelectActivity", "onCreate mCoverView.setImageBitmap()");
      }
      paramBundle = getIntent().getBundleExtra("bundle_extra");
      if (paramBundle != null) {
        this.jdField_d_of_type_Boolean = paramBundle.getBoolean("enable_multi_fragment", false);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.setLocalVideoView(this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView);
      this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setOnPreparedListener(new LocalVideoSelectActivity.2(this));
      this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setOnErrorListener(new LocalVideoSelectActivity.3(this));
      StoryReportor.a("video_edit", "exp_cut", 0, 0, new String[0]);
      return false;
      this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setCenterInside(true);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (!this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.e();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if ((this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView != null) && (!this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.isPlaying())) {
      this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.a(false);
    }
  }
  
  public void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    paramBundle.putBoolean("mGoThrough", this.jdField_c_of_type_Boolean);
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if (this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.c();
    }
  }
  
  public void finish()
  {
    super.finish();
    if (!this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    while (this.jdField_c_of_type_Boolean)
    {
      SLog.b("Q.qqstory.publish.edit.LocalVideoSelectActivity", "onActivityResult go through, requestCode=%d, resultCode=%d", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      setResult(paramInt2, paramIntent);
      finish();
      return;
      if (paramInt2 == -1)
      {
        SLog.b("Q.qqstory.publish.edit.LocalVideoSelectActivity", "onActivityResult from edit video activity, requestCode=%d, resultCode=%d", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
        setResult(paramInt2, paramIntent);
        finish();
        return;
      }
      if ((paramInt2 == 0) && (this.jdField_c_of_type_Boolean))
      {
        d();
        return;
      }
    }
    SLog.b("Q.qqstory.publish.edit.LocalVideoSelectActivity", "onActivityResult, requestCode=%d, resultCode=%d", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  public void onClick(View paramView)
  {
    int m;
    int n;
    int i1;
    int i2;
    int i3;
    Object localObject;
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton) {
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.a();
        m = this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.b();
        n = this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.c();
        i1 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.e();
        i2 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.c();
        i3 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.d();
        localObject = new Intent();
        ((Intent)localObject).putExtra("start_time", m);
        ((Intent)localObject).putExtra("end_time", n);
        ((Intent)localObject).putExtra("video_index", this.i);
        ((Intent)localObject).putExtra("start_index", i2);
        ((Intent)localObject).putExtra("end_index", i3);
        ((Intent)localObject).putExtra("scroll_x", i1);
        setResult(-1, (Intent)localObject);
        StoryReportor.a("pic_choose", "done_cutVideo", this.jdField_d_of_type_Int, 0, new String[] { this.jdField_a_of_type_JavaLangString, m + "-" + n });
        finish();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      SLog.d("Q.qqstory.publish.edit.LocalVideoSelectActivity", "publish the local video path=%s,start=%s,end=%s", new Object[] { this.jdField_b_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.b()), Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.c()) });
      String str2 = getIntent().getStringExtra("video_refer");
      i2 = this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.b();
      i3 = this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.c();
      if (i3 - i2 > 10000) {
        StoryReportor.a("video_edit", "edit_split", 0, 0, new String[] { String.valueOf(Math.ceil((i3 - i2) / 1000.0F)) });
      }
      localObject = getIntent().getBundleExtra("bundle_extra");
      if (localObject != null)
      {
        SLog.b("Q.qqstory.publish.edit.LocalVideoSelectActivity", "LocalVideoSelectActivity start edit video activity");
        StoryPublishParams.a("Q.qqstory.publish.edit.LocalVideoSelectActivity", (Bundle)localObject);
        QQStoryFlowCallback.a(this, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, i2, i3, (Bundle)localObject);
        m = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.a();
        n = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.b();
        if ((m != this.j) || (n != this.k)) {
          StoryReportor.a("video_edit", "num_cut", 0, 0, new String[0]);
        }
        this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.a();
      }
      else
      {
        int i4 = getIntent().getIntExtra("entrance_type", 99);
        n = 0;
        localObject = null;
        String str1 = null;
        long l = 0L;
        boolean bool = false;
        i1 = 0;
        Intent localIntent = getIntent();
        if (localIntent != null)
        {
          n = localIntent.getIntExtra("shareGroupType", 0);
          localObject = localIntent.getStringExtra("shareGroupId");
          str1 = localIntent.getStringExtra("shareGroupName");
          l = localIntent.getLongExtra("groupUin", -1L);
          bool = localIntent.getBooleanExtra("ignorePersonalPublish", false);
          i1 = localIntent.getIntExtra("add_video_source", 0);
        }
        if ("tribe".equals(str2)) {
          m = 10;
        }
        for (;;)
        {
          QQStoryFlowCallback.a(this, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, i2, i3, i4, n, (String)localObject, str1, l, bool, i1, m);
          break;
          if ("READINJOY_VIDEO".equals(str2)) {
            m = 12;
          } else {
            m = 1;
          }
        }
        if (paramView == this.jdField_a_of_type_AndroidWidgetLinearLayout) {
          d();
        }
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity
 * JD-Core Version:    0.7.0.1
 */