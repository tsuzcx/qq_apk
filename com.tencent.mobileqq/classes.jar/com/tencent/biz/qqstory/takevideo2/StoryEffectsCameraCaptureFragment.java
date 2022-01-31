package com.tencent.biz.qqstory.takevideo2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.music.GetMusicInfoListHandler;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.richmedia.capture.fragment.EffectsCameraCaptureFragment;
import com.tencent.mobileqq.richmedia.capture.util.SVParamManager;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureButtonLayout;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.CaptureParam;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.PhotoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView;
import com.tencent.mobileqq.shortvideo.util.storage.StorageManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.util.ThrowablesUtils;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import omk;
import oml;

public class StoryEffectsCameraCaptureFragment
  extends EffectsCameraCaptureFragment
{
  private StoryLaunchEditPart jdField_a_of_type_ComTencentBizQqstoryTakevideo2StoryLaunchEditPart = new StoryLaunchEditPart(this);
  private StoryLocalPublishPart jdField_a_of_type_ComTencentBizQqstoryTakevideo2StoryLocalPublishPart = new StoryLocalPublishPart(this);
  private StoryMultiFragmentPart jdField_a_of_type_ComTencentBizQqstoryTakevideo2StoryMultiFragmentPart = new StoryMultiFragmentPart(this);
  private HashSet jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(4096);
  
  public StoryEffectsCameraCaptureFragment()
  {
    this.jdField_a_of_type_JavaUtilHashSet.add(this.jdField_a_of_type_ComTencentBizQqstoryTakevideo2StoryMultiFragmentPart);
    this.jdField_a_of_type_JavaUtilHashSet.add(this.jdField_a_of_type_ComTencentBizQqstoryTakevideo2StoryLocalPublishPart);
    this.jdField_a_of_type_JavaUtilHashSet.add(this.jdField_a_of_type_ComTencentBizQqstoryTakevideo2StoryLaunchEditPart);
  }
  
  public static boolean a()
  {
    String str = StorageManager.a().b;
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    long l = StorageManager.a(str);
    if (l <= 20971520L)
    {
      SLog.e("story.publish.CaptureFragment", "checkDiskSpaceIsOK,freeSpace <= FREESPACE_LIMIT_EXIT freeSpace=" + l + " StorageManager.FREESPACE_LIMIT_EXIT=" + StorageManager.a + " 手机剩余存储空间不足");
      return false;
    }
    return true;
  }
  
  public void B_()
  {
    super.B_();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
    while (localIterator.hasNext()) {
      ((StoryCapturePart)localIterator.next()).b();
    }
    StoryReportor.a("video_edit", "clk_shoot", 0, 0, new String[] { "2" });
  }
  
  public int a()
  {
    return 10002;
  }
  
  Bundle a()
  {
    Bundle localBundle = getArguments();
    if (localBundle != null) {
      return localBundle;
    }
    return new Bundle();
  }
  
  public CameraCaptureButtonLayout a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout;
  }
  
  protected CameraCaptureView.CaptureParam a()
  {
    StoryConfigManager localStoryConfigManager = (StoryConfigManager)SuperManager.a(10);
    int j = ((Integer)localStoryConfigManager.b("NewStoryVideoWidth", Integer.valueOf(-1))).intValue();
    int k = ((Integer)localStoryConfigManager.b("NewStoryVideoHeight", Integer.valueOf(-1))).intValue();
    int i = ((Integer)localStoryConfigManager.b("NewStoryBitRate", Integer.valueOf(-1))).intValue();
    Size localSize = SVParamManager.a().a(2);
    CameraCaptureView.CaptureParam localCaptureParam = new CameraCaptureView.CaptureParam();
    localCaptureParam.a(localSize.a());
    localCaptureParam.b(localSize.b());
    float f1 = SVParamManager.a().a(2);
    if ((j > 0) && (k > 0))
    {
      float f2 = j / localSize.a();
      float f3 = k / localSize.b();
      localCaptureParam.a(Math.max(f2, f3));
      SLog.d("story.publish.CaptureFragment", "setVideoSizeRate=%s, defaultRatio=%s, storyVideoWidth=%d, storyVideoHeight=%d, previewWidth=%d, previewHeight=%d", new Object[] { Float.valueOf(Math.max(f2, f3)), Float.valueOf(f1), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(localSize.a()), Integer.valueOf(localSize.b()) });
      j = SVParamManager.a().a(2) * 1000;
      if (i <= 0) {
        break label474;
      }
      i *= 1000;
      localCaptureParam.d(i);
      com.tencent.mobileqq.shortvideo.mediadevice.CodecParam.r = i;
      SLog.d("story.publish.CaptureFragment", "setVideoBitRate=%d, defaultBitRate=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      label288:
      if (StoryConfigManager.b())
      {
        localCaptureParam.g(0);
        SLog.b("story.publish.CaptureFragment", "CQ bitrate mode is enable when story record");
      }
      if (StoryConfigManager.c())
      {
        localCaptureParam.h(8);
        SLog.b("story.publish.CaptureFragment", "codec high profile is enable when story record");
      }
      if (StoryConfigManager.d())
      {
        SLog.d("story.publish.CaptureFragment", "story debug mode is enable");
        i = ((Integer)localStoryConfigManager.b("int_story_debug_bitrate", Integer.valueOf(2000))).intValue();
        j = ((Integer)localStoryConfigManager.b("int_story_debug_bitrate_mode", Integer.valueOf(-1))).intValue();
        boolean bool = ((Boolean)localStoryConfigManager.b("boolean_story_debug_use_high_profile", Boolean.valueOf(false))).booleanValue();
        localCaptureParam.d(i * 1000);
        localCaptureParam.g(j);
        if (!bool) {
          break label509;
        }
        localCaptureParam.h(8);
      }
    }
    for (;;)
    {
      localCaptureParam.e(1);
      localCaptureParam.c(2);
      return localCaptureParam;
      localCaptureParam.a(f1);
      SLog.d("story.publish.CaptureFragment", "setVideoSizeRate=%s as default", new Object[] { Float.valueOf(f1) });
      break;
      label474:
      localCaptureParam.d(j);
      com.tencent.mobileqq.shortvideo.mediadevice.CodecParam.r = j;
      SLog.d("story.publish.CaptureFragment", "setVideoBitRate=%d as default", new Object[] { Integer.valueOf(j) });
      break label288;
      label509:
      localCaptureParam.h(-1);
    }
  }
  
  public ProviderContainerView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    SLog.d("story.publish.CaptureFragment", "onCaptureError, errorCode=%d", new Object[] { Integer.valueOf(paramInt) });
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
    while (localIterator.hasNext()) {
      ((StoryCapturePart)localIterator.next()).a(paramInt);
    }
    if (paramInt == 102)
    {
      StoryReportor.a("video_shoot", "exp_time_float", 0, 0, new String[0]);
      StoryReportor.a("video_edit", "clk_shoot", 0, 0, new String[] { "1" });
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    SLog.a("story.publish.CaptureFragment", "onEditActivityResult, EDIT_ACTIVITY_REQUEST_CODE, result=%d, data=%s", Integer.valueOf(paramInt2), paramIntent);
    if (paramInt2 == -1)
    {
      FragmentActivity localFragmentActivity = getActivity();
      if (localFragmentActivity != null)
      {
        PublishParam localPublishParam = (PublishParam)paramIntent.getParcelableExtra(PublishParam.a);
        if (localPublishParam != null) {
          paramIntent.putExtra("new_video_extra_info", localPublishParam.c);
        }
        localFragmentActivity.setResult(paramInt2, paramIntent);
        localFragmentActivity.finish();
        return;
      }
      SLog.e("story.publish.CaptureFragment", "onActivityResult, can not find activity instance");
      throw new AndroidRuntimeException("onActivityResult, can not find activity instance");
    }
    SLog.b("story.publish.CaptureFragment", "use quit editing");
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideo2StoryMultiFragmentPart.c();
  }
  
  public void a(StoryEffectsCameraCaptureView.CaptureRequest paramCaptureRequest)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView instanceof StoryEffectsCameraCaptureView))
    {
      ((StoryEffectsCameraCaptureView)this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView).setCaptureRequest(paramCaptureRequest);
      return;
    }
    paramCaptureRequest = new Throwable(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.getClass().getName());
    CrashReport.handleCatchException(Thread.currentThread(), paramCaptureRequest, ThrowablesUtils.a(paramCaptureRequest), null);
  }
  
  public void a(CameraCaptureView.PhotoCaptureResult paramPhotoCaptureResult)
  {
    SLog.d("story.publish.CaptureFragment", "onPhotoCaptured, file=%s", new Object[] { paramPhotoCaptureResult.a });
    if ((TextUtils.isEmpty(paramPhotoCaptureResult.a)) || (!new File(paramPhotoCaptureResult.a).exists())) {
      a(1000);
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
      while (localIterator.hasNext()) {
        ((StoryCapturePart)localIterator.next()).a(paramPhotoCaptureResult);
      }
    }
  }
  
  protected void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    SLog.d("story.publish.CaptureFragment", "onVideoCaptured, videoMp4FilePath=%s, audioDataFilePath=%s, localMediaInfo=%s", new Object[] { paramVideoCaptureResult.videoMp4FilePath, paramVideoCaptureResult.audioDataFilePath, paramLocalMediaInfo });
    if ((TextUtils.isEmpty(paramVideoCaptureResult.videoMp4FilePath)) || (!new File(paramVideoCaptureResult.videoMp4FilePath).exists()))
    {
      SLog.d("story.publish.CaptureFragment", "mp4 file invalid ! path = %s, exist=%s", new Object[] { paramVideoCaptureResult.videoMp4FilePath, Boolean.valueOf(new File(paramVideoCaptureResult.videoMp4FilePath).exists()) });
      a(1000);
    }
    for (;;)
    {
      return;
      if ((TextUtils.isEmpty(paramVideoCaptureResult.audioDataFilePath)) || (!new File(paramVideoCaptureResult.audioDataFilePath).exists()))
      {
        SLog.d("story.publish.CaptureFragment", "audio file invalid ! path = %s, exist=%s", new Object[] { paramVideoCaptureResult.audioDataFilePath, Boolean.valueOf(new File(paramVideoCaptureResult.audioDataFilePath).exists()) });
        a(1000);
        return;
      }
      if (paramLocalMediaInfo == null)
      {
        SLog.d("story.publish.CaptureFragment", "local media info is null !");
        a(1001);
        return;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
      while (localIterator.hasNext()) {
        ((StoryCapturePart)localIterator.next()).a(paramVideoCaptureResult, paramLocalMediaInfo);
      }
    }
  }
  
  public void aj_()
  {
    super.aj_();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
    while (localIterator.hasNext()) {
      ((StoryCapturePart)localIterator.next()).a();
    }
    StoryReportor.a("video_edit", "press_shoot", 0, 0, new String[] { "1" });
  }
  
  protected int b()
  {
    return 2130970716;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideo2StoryMultiFragmentPart.a(a());
  }
  
  public int c()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    SLog.a("story.publish.CaptureFragment", "onActivityResult %d, %d, %s", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
    while (localIterator.hasNext()) {
      ((StoryCapturePart)localIterator.next()).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      super.onClick(paramView);
      return;
      StoryReportor.a("video_shoot", "clk_left", 0, 0, new String[0]);
      continue;
      if (!this.d.isSelected()) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label103;
        }
        StoryReportor.a("video_shoot", "open_flash", 0, 0, new String[0]);
        break;
      }
      label103:
      StoryReportor.a("video_shoot", "close_flash", 0, 0, new String[0]);
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a() == 2) {
        StoryReportor.a("video_shoot", "camera_front", 0, 0, new String[0]);
      } else {
        StoryReportor.a("video_shoot", "camera_back", 0, 0, new String[0]);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    StoryPublishParams.a("story.publish.CaptureFragment", a());
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
    while (localIterator.hasNext()) {
      ((StoryCapturePart)localIterator.next()).a(paramBundle);
    }
    StoryReportor.a("video_shoot", "exp_findview", 0, 0, new String[] { "", "", "", String.valueOf(a().getInt("entrance_type", 99)) });
    this.g = false;
    if (!a())
    {
      QQToast.a(getActivity(), "手机内存空间不足。", 1).a();
      getActivity().finish();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    LayoutModifier.a(paramLayoutInflater, new omk(this, paramLayoutInflater));
    paramViewGroup = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramViewGroup.setFocusable(true);
    paramViewGroup.setFocusableInTouchMode(true);
    paramViewGroup.requestFocus();
    paramViewGroup.setOnKeyListener(new oml(this, null));
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
    while (localIterator.hasNext()) {
      ((StoryCapturePart)localIterator.next()).a(paramLayoutInflater, paramViewGroup, paramBundle);
    }
    return paramViewGroup;
  }
  
  public void onPause()
  {
    super.onPause();
    SLog.b("story.publish.CaptureFragment", "onPause");
  }
  
  public void onResume()
  {
    super.onResume();
    SLog.b("story.publish.CaptureFragment", "onResume");
    if ((a().getString("video_tag_info", null) != null) && (!GetMusicInfoListHandler.a(getActivity())))
    {
      SLog.b("story.publish.CaptureFragment", "fireGetMusicInfoList because use take video with video tag");
      GetMusicInfoListHandler.a(getActivity());
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    Object localObject = a();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout.setMaxDuration(10000.0F);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout.setFunctionFlag(((Bundle)localObject).getInt("ability_flag", 1));
    localObject = this.jdField_a_of_type_JavaUtilHashSet.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((StoryCapturePart)((Iterator)localObject).next()).a(paramView, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo2.StoryEffectsCameraCaptureFragment
 * JD-Core Version:    0.7.0.1
 */