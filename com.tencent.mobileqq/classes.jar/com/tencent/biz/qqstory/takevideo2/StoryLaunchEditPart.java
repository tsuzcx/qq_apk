package com.tencent.biz.qqstory.takevideo2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.EditTakePhotoSource;
import com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.PhotoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.CaptureVideoFilterViewPager;

public class StoryLaunchEditPart
  extends StoryCapturePart
{
  private final int jdField_a_of_type_Int = a();
  CaptureVideoFilterViewPager jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager;
  
  public StoryLaunchEditPart(@NonNull StoryEffectsCameraCaptureFragment paramStoryEffectsCameraCaptureFragment)
  {
    super(paramStoryEffectsCameraCaptureFragment);
  }
  
  private void a(@NonNull EditVideoParams.EditSource paramEditSource)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager.a();
      if ((localObject != null) && (!TextUtils.isEmpty(((FilterDesc)localObject).e)) && (!TextUtils.equals(((FilterDesc)localObject).e, "EMPTY"))) {
        StoryReportor.a("video_shoot", "clk_swipe", 10002, 0, new String[] { ((FilterDesc)localObject).e });
      }
    }
    int j;
    boolean bool1;
    boolean bool2;
    if (a() != null)
    {
      localObject = a();
      if (!((Bundle)localObject).containsKey("enable_hw_encode")) {
        ((Bundle)localObject).putBoolean("enable_hw_encode", true);
      }
      boolean bool3 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideo2StoryEffectsCameraCaptureFragment.d();
      if (((paramEditSource instanceof EditTakeVideoSource)) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideo2StoryEffectsCameraCaptureFragment.b()) && (!bool3))
      {
        i = (int)Math.ceil((float)((EditTakeVideoSource)paramEditSource).a.mDuration * 1.0F / 10000.0F);
        if (i >= 1) {
          ((Bundle)localObject).putInt("expect_fragment_count", i);
        }
        SLog.b("story.publish.StoryLaunchEditPart", "launchEditActivity. video duration = %d, expectFragmentCount = %d.", Long.valueOf(((EditTakeVideoSource)paramEditSource).a.mDuration), Integer.valueOf(i));
      }
      j = 4374893;
      i = a().getInt("entrance_type", 99);
      if (i != 16) {
        break label452;
      }
      bool1 = true;
      if (i != 5) {
        break label458;
      }
      bool2 = true;
      label221:
      boolean bool4 = a().getBoolean("ignorePersonalPublish", false);
      boolean bool5 = a().getBoolean("enable_multi_fragment", false);
      SLog.a("story.publish.StoryLaunchEditPart", "isHotTopic:%b. isDiscover:%b. ignorePersonalPublish:%b", Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool4));
      if ((bool1) || (bool2) || (bool4)) {
        j = 4358509;
      }
      if (!(paramEditSource instanceof EditTakeVideoSource)) {
        break label464;
      }
      EditTakeVideoSource localEditTakeVideoSource = (EditTakeVideoSource)paramEditSource;
      if ((bool5) && (!bool3))
      {
        i = j;
        if (localEditTakeVideoSource.a.mDuration >= 11000L) {
          break label330;
        }
      }
    }
    label330:
    label464:
    for (int i = j & 0xFFFF7FFF;; i = j & 0xFFFF7FFF)
    {
      j = i;
      if (!TextUtils.isEmpty(((Bundle)localObject).getString("shareGroupId"))) {
        j = 0xFFBFFFFF & (0x200000 | i) & 0xFFFFBFFF;
      }
      i = j;
      if (((Bundle)localObject).getInt("shareGroupType") == 1) {
        i = j & 0xFFFDFFFF;
      }
      paramEditSource = new EditVideoParams(1, i, paramEditSource, (Bundle)localObject);
      SLog.d("story.publish.StoryLaunchEditPart", "launchEditActivity, %s", new Object[] { paramEditSource });
      localObject = new Intent(a(), EditVideoActivity.class);
      ((Intent)localObject).putExtra(EditVideoParams.class.getName(), paramEditSource);
      a((Intent)localObject, this.jdField_a_of_type_Int);
      a().overridePendingTransition(2131034128, 2131034139);
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label221;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == this.jdField_a_of_type_Int) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideo2StoryEffectsCameraCaptureFragment.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(View paramView, Bundle paramBundle)
  {
    super.a(paramView, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager = ((CaptureVideoFilterViewPager)paramView.findViewById(2131368995));
  }
  
  public void a(CameraCaptureView.PhotoCaptureResult paramPhotoCaptureResult)
  {
    a(new EditTakePhotoSource(paramPhotoCaptureResult.a));
  }
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    a(new EditTakeVideoSource(paramVideoCaptureResult.videoMp4FilePath, paramVideoCaptureResult.audioDataFilePath, paramLocalMediaInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo2.StoryLaunchEditPart
 * JD-Core Version:    0.7.0.1
 */