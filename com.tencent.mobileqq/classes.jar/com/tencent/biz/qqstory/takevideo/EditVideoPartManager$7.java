package com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.StoryTransitionActivity;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import cooperation.qzone.QZoneHelper;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class EditVideoPartManager$7
  extends SimpleObserver<GenerateContext>
{
  EditVideoPartManager$7(EditVideoPartManager paramEditVideoPartManager, GenerateContext paramGenerateContext, long paramLong) {}
  
  public void a(GenerateContext paramGenerateContext)
  {
    super.onNext(paramGenerateContext);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.o();
    SLog.e("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH onNext");
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((EditVideoPart)((Iterator)localObject).next()).b(paramGenerateContext);
    }
    String str;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource))
    {
      i = 1;
      StoryReportor.b("edit_video", "publish_cost", 0, 0, new String[] { String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long), String.valueOf(i) });
      Intent localIntent = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getIntent();
      i = localIntent.getIntExtra("uintype", -1);
      str = "";
      localObject = str;
      if (i != -1)
      {
        localObject = str;
        if (i != 1)
        {
          localObject = str;
          if (i != 3000) {
            localObject = localIntent.getStringExtra("uin");
          }
        }
      }
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
      {
        if (CameraControl.a().a != 1) {
          break label356;
        }
        i = 1;
        label202:
        CaptureReportUtil.b(i, (String)localObject);
      }
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) {
        if (CameraControl.a().a != 1) {
          break label361;
        }
      }
    }
    label356:
    label361:
    for (int i = 1;; i = 2)
    {
      CaptureReportUtil.a(i, (String)localObject);
      if (EditVideoPartManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager, paramGenerateContext)) {
        EditVideoPartManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager);
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() <= 0) {
        break label366;
      }
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "waiting for another observer finish");
      return;
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
      {
        i = 2;
        break;
      }
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource))
      {
        i = 3;
        break;
      }
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource))
      {
        i = 4;
        break;
      }
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
      {
        i = 5;
        break;
      }
      i = 0;
      break;
      i = 2;
      break label202;
    }
    label366:
    if ((EditVideoPartManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.b, 32768)) && (EditVideoPartManager.b(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager) > 0))
    {
      i = EditVideoPartManager.b(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager);
      if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.d()) {
        break label579;
      }
    }
    label579:
    for (paramGenerateContext = "0";; paramGenerateContext = "1")
    {
      StoryReportor.a("video_edit", "pub_edit_one", 0, 0, new String[] { String.valueOf(i), paramGenerateContext });
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.b();
      if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_b_of_type_JavaUtilList.isEmpty()) {
        break label730;
      }
      paramGenerateContext = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.getActivity();
      if (paramGenerateContext == null) {
        break;
      }
      if (!(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalGifSource)) {
        break label609;
      }
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateContext);
      str = ((Intent)localObject).getStringExtra("PhotoConst.PLUGIN_APK");
      boolean bool = ((Intent)localObject).getBooleanExtra("DirectBackToQzone", false);
      if ((!"qzone_plugin.apk".equals(str)) || (!bool)) {
        break label585;
      }
      QZoneHelper.launchQZone(paramGenerateContext, "", (Intent)localObject, -1);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a(-1, null, 2130772034, 0);
      return;
    }
    label585:
    paramGenerateContext.startActivity((Intent)localObject);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a(-1, null, 2130772034, 0);
    return;
    label609:
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a() == 1) {
      StoryTransitionActivity.a(paramGenerateContext);
    }
    localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam;
    SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishParam = " + localObject);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidContentIntent == null) {}
    for (paramGenerateContext = new Intent();; paramGenerateContext = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidContentIntent)
    {
      paramGenerateContext.putExtra(PublishParam.a, (Parcelable)localObject);
      paramGenerateContext.putExtra("PUBLISH_STORY", true);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(paramGenerateContext, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a(), (PublishParam)localObject);
      return;
    }
    label730:
    paramGenerateContext = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_b_of_type_JavaUtilList.iterator();
    while (paramGenerateContext.hasNext()) {
      SLog.c("Q.qqstory.publish.edit.EditVideoPartManager", "publish error %s", (Error)paramGenerateContext.next());
    }
    QQToast.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a(), this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_b_of_type_JavaUtilList.size() + HardCodeUtil.a(2131703779), 0).a();
    paramGenerateContext = (EditVideoPlayerExport)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(EditVideoPlayerExport.class);
    if (paramGenerateContext != null) {
      paramGenerateContext.i();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_b_of_type_Boolean = false;
  }
  
  public void onCancel()
  {
    super.onCancel();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    SLog.e("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH error ：" + paramError);
    Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).a(paramError);
    }
    StoryReportor.b("video_edit", "pub_error", 0, 0, new String[] { paramError.toString() });
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_b_of_type_JavaUtilList.add(paramError);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() > 0) {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "waiting for another observer finish");
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.b();
      QQToast.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a(), HardCodeUtil.a(2131703810), 0).a();
      paramError = (EditVideoPlayerExport)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(EditVideoPlayerExport.class);
    } while (paramError == null);
    paramError.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoPartManager.7
 * JD-Core Version:    0.7.0.1
 */