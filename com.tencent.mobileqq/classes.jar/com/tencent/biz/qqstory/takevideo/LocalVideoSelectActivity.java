package com.tencent.biz.qqstory.takevideo;

import Override;
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
import anni;
import bgtn;
import bqcd;
import com.tencent.biz.qqstory.boundaries.extension.widgets.TrimTextureVideoView;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.ScrollFrameSelectBar;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.richmedia.QQStoryFlowCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import yqp;
import yqu;
import yvr;
import yvs;
import zip;
import zix;

public class LocalVideoSelectActivity
  extends QQStoryBaseActivity
  implements View.OnClickListener, zip
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
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private int f;
  private int g;
  private int h = -1;
  private int i = -1;
  
  private void a()
  {
    this.jdField_e_of_type_Boolean = false;
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131363524));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131363522));
    this.jdField_e_of_type_Boolean = bqcd.a(this.jdField_b_of_type_AndroidWidgetLinearLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout, 0);
  }
  
  private void d()
  {
    finish();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    c(paramInt1, paramInt2);
    if ((this.h < 0) || (this.i < 0))
    {
      this.h = paramInt1;
      this.i = paramInt2;
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
    for (String str = String.format(anni.a(2131705095), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });; str = String.format(anni.a(2131705096), new Object[] { Integer.valueOf(paramInt1) }))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      return;
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void doOnBackPressed()
  {
    d();
  }
  
  @TargetApi(11)
  public boolean doOnCreate(@Nullable Bundle paramBundle)
  {
    bqcd.a(this);
    getWindow().addFlags(1024);
    if (bqcd.c()) {
      bqcd.b(this);
    }
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    this.isClearCoverLayer = false;
    super.doOnCreate(paramBundle);
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("from_slideshow_to_share", false);
    this.g = getIntent().getIntExtra("video_index", 0);
    this.jdField_b_of_type_Int = getIntent().getIntExtra("start_index", 0);
    this.jdField_c_of_type_Int = getIntent().getIntExtra("end_index", 0);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("scroll_x", 0);
    this.jdField_d_of_type_Int = getIntent().getIntExtra("entrance_type", 0);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("op_entrance_type");
    this.jdField_a_of_type_Long = getIntent().getLongExtra("start_time", 0L);
    this.jdField_b_of_type_Long = getIntent().getLongExtra("end_time", 0L);
    int j;
    if (paramBundle == null)
    {
      j = 1;
      if (j == 0) {
        break label230;
      }
      paramBundle = getIntent();
      if (this.jdField_b_of_type_Boolean) {
        break label225;
      }
    }
    label225:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_c_of_type_Boolean = QQStoryFlowCallback.a(this, paramBundle, bool);
      if (!this.jdField_c_of_type_Boolean) {
        break label258;
      }
      yqp.c("Q.qqstory.publish.edit.LocalVideoSelectActivity", "activity on-create, go through, start edit video activity directly");
      return false;
      j = 0;
      break;
    }
    label230:
    this.jdField_c_of_type_Boolean = paramBundle.getBoolean("mGoThrough");
    if (this.jdField_c_of_type_Boolean)
    {
      yqp.c("Q.qqstory.publish.edit.LocalVideoSelectActivity", "activity re-create, do nothing");
      return false;
    }
    label258:
    yqp.c("Q.qqstory.publish.edit.LocalVideoSelectActivity", "activity on-create, init ui");
    setContentViewC(2131561722);
    yqp.d("Q.qqstory.publish.edit.LocalVideoSelectActivity", "onCreate");
    a();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374505));
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
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131374504));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131374507));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374506));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar = ((ScrollFrameSelectBar)findViewById(2131374480));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.setMinDuration(2000);
    if (this.jdField_e_of_type_Boolean)
    {
      paramBundle = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.getLayoutParams();
      paramBundle.bottomMargin = 0;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.setLayoutParams(paramBundle);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView = ((TrimTextureVideoView)findViewById(2131370244));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.setOnRangeValueChangeListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.post(new LocalVideoSelectActivity.1(this));
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setVideoPath(this.jdField_b_of_type_JavaLangString);
    if (this.jdField_e_of_type_Boolean)
    {
      paramBundle = (RelativeLayout)findViewById(2131363292);
      ((ViewGroup)paramBundle.getParent()).removeView(paramBundle);
      localObject1 = paramBundle.getLayoutParams();
      localObject1 = new RelativeLayout.LayoutParams(((ViewGroup.LayoutParams)localObject1).width, ((ViewGroup.LayoutParams)localObject1).height);
      ((RelativeLayout.LayoutParams)localObject1).topMargin = bgtn.a(14.0F);
      ((RelativeLayout.LayoutParams)localObject1).leftMargin = bgtn.a(12.0F);
      ((RelativeLayout.LayoutParams)localObject1).rightMargin = bgtn.a(12.0F);
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
      this.jdField_e_of_type_Int = Math.min(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth);
      this.f = Math.max(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth);
      if (QQStoryFlowCallback.a != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(QQStoryFlowCallback.a);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        yqp.b("Q.qqstory.publish.edit.LocalVideoSelectActivity", "onCreate mCoverView.setImageBitmap()");
      }
      paramBundle = getIntent().getBundleExtra("bundle_extra");
      if (paramBundle != null) {
        this.jdField_d_of_type_Boolean = paramBundle.getBoolean("enable_multi_fragment", false);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.setLocalVideoView(this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView);
      this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setOnPreparedListener(new yvr(this));
      this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setOnErrorListener(new yvs(this));
      yqu.a("video_edit", "exp_cut", 0, 0, new String[0]);
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
    if (!this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.isPlaying()) {
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
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.c();
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
      yqp.b("Q.qqstory.publish.edit.LocalVideoSelectActivity", "onActivityResult go through, requestCode=%d, resultCode=%d", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      setResult(paramInt2, paramIntent);
      finish();
      return;
      if (paramInt2 == -1)
      {
        yqp.b("Q.qqstory.publish.edit.LocalVideoSelectActivity", "onActivityResult from edit video activity, requestCode=%d, resultCode=%d", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
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
    yqp.b("Q.qqstory.publish.edit.LocalVideoSelectActivity", "onActivityResult, requestCode=%d, resultCode=%d", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  public void onClick(View paramView)
  {
    int j;
    int k;
    int m;
    int n;
    int i1;
    Object localObject;
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton) {
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.a();
        j = this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.b();
        k = this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.c();
        m = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.e();
        n = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.c();
        i1 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.d();
        localObject = new Intent();
        ((Intent)localObject).putExtra("start_time", j);
        ((Intent)localObject).putExtra("end_time", k);
        ((Intent)localObject).putExtra("video_index", this.g);
        ((Intent)localObject).putExtra("start_index", n);
        ((Intent)localObject).putExtra("end_index", i1);
        ((Intent)localObject).putExtra("scroll_x", m);
        setResult(-1, (Intent)localObject);
        yqu.a("pic_choose", "done_cutVideo", this.jdField_d_of_type_Int, 0, new String[] { this.jdField_a_of_type_JavaLangString, j + "-" + k });
        finish();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      yqp.d("Q.qqstory.publish.edit.LocalVideoSelectActivity", "publish the local video path=%s,start=%s,end=%s", new Object[] { this.jdField_b_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.b()), Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.c()) });
      String str2 = getIntent().getStringExtra("video_refer");
      n = this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.b();
      i1 = this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.c();
      if (i1 - n > 10000) {
        yqu.a("video_edit", "edit_split", 0, 0, new String[] { String.valueOf(Math.ceil((i1 - n) / 1000.0F)) });
      }
      localObject = getIntent().getBundleExtra("bundle_extra");
      if (localObject != null)
      {
        yqp.b("Q.qqstory.publish.edit.LocalVideoSelectActivity", "LocalVideoSelectActivity start edit video activity");
        zix.a("Q.qqstory.publish.edit.LocalVideoSelectActivity", (Bundle)localObject);
        QQStoryFlowCallback.a(this, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, n, i1, (Bundle)localObject);
        j = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.a();
        k = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.b();
        if ((j != this.h) || (k != this.i)) {
          yqu.a("video_edit", "num_cut", 0, 0, new String[0]);
        }
        this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.a();
      }
      else
      {
        int i2 = getIntent().getIntExtra("entrance_type", 99);
        k = 0;
        localObject = null;
        String str1 = null;
        long l = 0L;
        boolean bool = false;
        m = 0;
        Intent localIntent = getIntent();
        if (localIntent != null)
        {
          k = localIntent.getIntExtra("shareGroupType", 0);
          localObject = localIntent.getStringExtra("shareGroupId");
          str1 = localIntent.getStringExtra("shareGroupName");
          l = localIntent.getLongExtra("groupUin", -1L);
          bool = localIntent.getBooleanExtra("ignorePersonalPublish", false);
          m = localIntent.getIntExtra("add_video_source", 0);
        }
        if ("tribe".equals(str2)) {
          j = 10;
        }
        for (;;)
        {
          QQStoryFlowCallback.a(this, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, n, i1, i2, k, (String)localObject, str1, l, bool, m, j);
          break;
          if ("READINJOY_VIDEO".equals(str2)) {
            j = 12;
          } else {
            j = 1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity
 * JD-Core Version:    0.7.0.1
 */