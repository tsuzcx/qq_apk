import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.StoryTransitionActivity;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import cooperation.qzone.QZoneHelper;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalGifSource;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditRecordVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakePhotoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPart;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPlayerExport;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoUi;
import dov.com.tencent.biz.qqstory.takevideo.EditWebVideoHallowenUpload;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class anul
  extends SimpleObserver
{
  public anul(EditVideoPartManager paramEditVideoPartManager, long paramLong) {}
  
  public void a(GenerateContext paramGenerateContext)
  {
    super.onNext(paramGenerateContext);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.o();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_b_of_type_Boolean = false;
    SLog.e("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH onNext");
    Object localObject1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((EditVideoPart)((Iterator)localObject1).next()).b(paramGenerateContext);
    }
    int i;
    if ((paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource))
    {
      i = 1;
      StoryReportor.b("edit_video", "publish_cost", 0, 0, new String[] { String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long), String.valueOf(i) });
      if (EditVideoPartManager.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager, paramGenerateContext)) {
        EditVideoPartManager.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager);
      }
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() <= 0) {
        break label219;
      }
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "waiting for another observer finish");
    }
    label219:
    do
    {
      return;
      if ((paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
      {
        i = 2;
        break;
      }
      if ((paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource))
      {
        i = 3;
        break;
      }
      if ((paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource))
      {
        i = 4;
        break;
      }
      if ((paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
      {
        i = 5;
        break;
      }
      i = 0;
      break;
      if ((EditVideoPartManager.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b, 262144)) && (EditVideoPartManager.b(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager) > 0))
      {
        i = EditVideoPartManager.b(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager);
        if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d()) {
          break label438;
        }
      }
      for (localObject1 = "0";; localObject1 = "1")
      {
        StoryReportor.a("video_edit", "pub_edit_one", 0, 0, new String[] { String.valueOf(i), localObject1 });
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.f();
        if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_b_of_type_JavaUtilList.isEmpty()) {
          break label657;
        }
        localObject1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity();
        if (localObject1 == null) {
          break;
        }
        if (!(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalGifSource)) {
          break label469;
        }
        paramGenerateContext = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(paramGenerateContext);
        localObject2 = paramGenerateContext.getStringExtra("PhotoConst.PLUGIN_APK");
        boolean bool = paramGenerateContext.getBooleanExtra("DirectBackToQzone", false);
        if ((!"qzone_plugin.apk".equals(localObject2)) || (!bool)) {
          break label445;
        }
        QZoneHelper.a((Activity)localObject1, "", paramGenerateContext, -1);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(-1, null, 2131034158, 0);
        return;
      }
      ((Activity)localObject1).startActivity(paramGenerateContext);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(-1, null, 2131034158, 0);
      return;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 1) {
        StoryTransitionActivity.a((Context)localObject1);
      }
      Object localObject2 = new anum(this, paramGenerateContext);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 6)
      {
        QQAppInterface localQQAppInterface = ((BaseActivity)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity()).app;
        localObject2 = new EditWebVideoHallowenUpload((EditVideoActivity)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity(), localQQAppInterface, true, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("WebSceneType", FlowCameraConstant.d), new anun(this, (Runnable)localObject2), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("succUrl"), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("failedUrl"));
        paramGenerateContext = paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam;
        ((EditWebVideoHallowenUpload)localObject2).a((Activity)localObject1, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource, paramGenerateContext);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a("上传中...");
        return;
      }
      ((Runnable)localObject2).run();
      return;
      paramGenerateContext = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_b_of_type_JavaUtilList.iterator();
      while (paramGenerateContext.hasNext()) {
        SLog.c("Q.qqstory.publish.edit.EditVideoPartManager", "publish error %s", (Error)paramGenerateContext.next());
      }
      QQToast.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_b_of_type_JavaUtilList.size() + "次发表失败，请重试", 0).a();
      paramGenerateContext = (EditVideoPlayerExport)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(EditVideoPlayerExport.class);
    } while (paramGenerateContext == null);
    label438:
    label445:
    label469:
    paramGenerateContext.m();
    label657:
  }
  
  public void onCancel()
  {
    super.onCancel();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anul
 * JD-Core Version:    0.7.0.1
 */