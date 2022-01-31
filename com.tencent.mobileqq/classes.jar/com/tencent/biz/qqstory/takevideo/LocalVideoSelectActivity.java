package com.tencent.biz.qqstory.takevideo;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
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
import com.tencent.mobileqq.tribe.TribeFlowComponentInterface;
import omd;
import omf;

public class LocalVideoSelectActivity
  extends QQStoryBaseActivity
  implements View.OnClickListener, ScrollFrameSelectBar.OnRangeValueChangeListener
{
  private int jdField_a_of_type_Int;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TrimTextureVideoView jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView;
  private ScrollFrameSelectBar jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar;
  private LocalMediaInfo jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean;
  private int d = -1;
  
  private void a()
  {
    finish();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    c(paramInt1, paramInt2);
    if ((this.jdField_c_of_type_Int < 0) || (this.d < 0))
    {
      this.jdField_c_of_type_Int = paramInt1;
      this.d = paramInt2;
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
    if (this.jdField_c_of_type_Boolean) {}
    for (String str = String.format("已选中%d秒，拆分为%d个小视频", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });; str = String.format("已截取%d秒", new Object[] { Integer.valueOf(paramInt1) }))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      return;
    }
  }
  
  public void doOnBackPressed()
  {
    a();
  }
  
  @TargetApi(11)
  protected boolean doOnCreate(@Nullable Bundle paramBundle)
  {
    int j = 1;
    getWindow().addFlags(1024);
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    if (paramBundle == null) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.jdField_b_of_type_Boolean = QQStoryFlowCallback.a(this, getIntent());
      if (!this.jdField_b_of_type_Boolean) {
        break label97;
      }
      SLog.c("Q.qqstory.publish.edit.LocalVideoSelectActivity", "activity on-create, go through, start edit video activity directly");
      return false;
    }
    this.jdField_b_of_type_Boolean = paramBundle.getBoolean("mGoThrough");
    if (this.jdField_b_of_type_Boolean)
    {
      SLog.c("Q.qqstory.publish.edit.LocalVideoSelectActivity", "activity re-create, do nothing");
      return false;
    }
    label97:
    SLog.c("Q.qqstory.publish.edit.LocalVideoSelectActivity", "activity on-create, init ui");
    setContentViewC(2130970776);
    SLog.d("Q.qqstory.publish.edit.LocalVideoSelectActivity", "onCreate");
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371844));
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = ((LocalMediaInfo)getIntent().getParcelableExtra("media_info"));
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path;
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371845));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131371848));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371847));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar = ((ScrollFrameSelectBar)findViewById(2131371846));
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView = ((TrimTextureVideoView)findViewById(2131371843));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.setOnRangeValueChangeListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setVideoPath(this.jdField_a_of_type_JavaLangString);
    paramBundle = getIntent().getStringExtra("video_refer");
    if ((!"tribe".equals(paramBundle)) && (!"READINJOY_VIDEO".equals(paramBundle)))
    {
      this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight);
      this.jdField_a_of_type_Int = Math.min(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth);
      this.jdField_b_of_type_Int = Math.max(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth);
      if (QQStoryFlowCallback.a != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(QQStoryFlowCallback.a);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        SLog.b("Q.qqstory.publish.edit.LocalVideoSelectActivity", "onCreate mCoverView.setImageBitmap()");
      }
      paramBundle = getIntent().getBundleExtra("bundle_extra");
      if (paramBundle != null) {
        this.jdField_c_of_type_Boolean = paramBundle.getBoolean("enable_multi_fragment", false);
      }
      if (!getIntent().getBooleanExtra("readinjoy_video", false)) {
        break label548;
      }
    }
    label548:
    for (i = j;; i = 0)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.a(this.jdField_a_of_type_JavaLangString, (int)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_c_of_type_Boolean, i);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.setLocalVideoView(this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView);
      this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setOnPreparedListener(new omd(this));
      this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setOnErrorListener(new omf(this));
      StoryReportor.a("video_edit", "exp_cut", 0, 0, new String[0]);
      return false;
      this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setCenterInside(true);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      break;
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (!this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.e();
    }
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    paramBundle.putBoolean("mGoThrough", this.jdField_b_of_type_Boolean);
  }
  
  public void finish()
  {
    super.finish();
    if (!this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    while (this.jdField_b_of_type_Boolean)
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
      if ((paramInt2 == 0) && (this.jdField_b_of_type_Boolean))
      {
        a();
        return;
      }
    }
    SLog.b("Q.qqstory.publish.edit.LocalVideoSelectActivity", "onActivityResult, requestCode=%d, resultCode=%d", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      SLog.d("Q.qqstory.publish.edit.LocalVideoSelectActivity", "publish the local video path=%s,start=%s,end=%s", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.b()), Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.c()) });
      str2 = getIntent().getStringExtra("video_refer");
      if ("tribe".equals(str2))
      {
        i = TribeFlowComponentInterface.jdField_a_of_type_Int;
        m = this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.b();
        n = this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.c();
        if (n - m > i) {
          StoryReportor.a("video_edit", "edit_split", 0, 0, new String[] { String.valueOf(Math.ceil((n - m) / 1000.0F)) });
        }
        paramView = getIntent().getBundleExtra("bundle_extra");
        if (paramView == null) {
          break label247;
        }
        SLog.b("Q.qqstory.publish.edit.LocalVideoSelectActivity", "LocalVideoSelectActivity start edit video activity");
        StoryPublishParams.a("Q.qqstory.publish.edit.LocalVideoSelectActivity", paramView);
        QQStoryFlowCallback.a(this, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, m, n, paramView);
        i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.a();
        j = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.b();
        if ((i != this.jdField_c_of_type_Int) || (j != this.d)) {
          StoryReportor.a("video_edit", "num_cut", 0, 0, new String[0]);
        }
        this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.a();
      }
    }
    label247:
    while (paramView != this.jdField_b_of_type_AndroidWidgetTextView)
    {
      String str2;
      int i;
      int m;
      int n;
      for (;;)
      {
        return;
        i = 10000;
      }
      int i1 = getIntent().getIntExtra("entrance_type", 99);
      int j = 0;
      paramView = null;
      String str1 = null;
      long l = 0L;
      boolean bool = false;
      int k = 0;
      Intent localIntent = getIntent();
      if (localIntent != null)
      {
        j = localIntent.getIntExtra("shareGroupType", 0);
        paramView = localIntent.getStringExtra("shareGroupId");
        str1 = localIntent.getStringExtra("shareGroupName");
        l = localIntent.getLongExtra("groupUin", -1L);
        bool = localIntent.getBooleanExtra("ignorePersonalPublish", false);
        k = localIntent.getIntExtra("add_video_source", 0);
      }
      if ("tribe".equals(str2)) {
        i = 10;
      }
      for (;;)
      {
        QQStoryFlowCallback.a(this, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, m, n, i1, j, paramView, str1, l, bool, k, i);
        break;
        if ("READINJOY_VIDEO".equals(str2)) {
          i = 12;
        } else {
          i = 1;
        }
      }
    }
    a();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity
 * JD-Core Version:    0.7.0.1
 */