import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditRecordVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakePhotoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class bnei
  extends SimpleObserver<bnot>
{
  bnei(bnee parambnee, long paramLong) {}
  
  public void a(bnot parambnot)
  {
    boolean bool = true;
    super.onNext(parambnot);
    this.jdField_a_of_type_Bnee.n();
    this.jdField_a_of_type_Bnee.jdField_b_of_type_Boolean = false;
    xvv.e("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH onNext");
    Object localObject1 = this.jdField_a_of_type_Bnee.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((bnec)((Iterator)localObject1).next()).b(parambnot);
    }
    int i;
    if ((parambnot.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource))
    {
      i = 1;
      xwa.b("edit_video", "publish_cost", 0, 0, new String[] { String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long), String.valueOf(i) });
      xwa.b("publish_story", "publish_saveToEntry", 0, 0, new String[] { "", String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) });
      if (this.jdField_a_of_type_Bnee.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() <= 0) {
        break label235;
      }
      xvv.d("Q.qqstory.publish.edit.EditVideoPartManager", "waiting for another observer finish");
    }
    label235:
    do
    {
      return;
      if ((parambnot.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
      {
        i = 2;
        break;
      }
      if ((parambnot.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource))
      {
        i = 3;
        break;
      }
      if ((parambnot.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource))
      {
        i = 4;
        break;
      }
      if ((parambnot.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
      {
        i = 5;
        break;
      }
      i = 0;
      break;
      this.jdField_a_of_type_Bnee.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Bnee.jdField_a_of_type_Bnew.b();
      if (!this.jdField_a_of_type_Bnee.jdField_b_of_type_JavaUtilList.isEmpty()) {
        break label857;
      }
    } while (this.jdField_a_of_type_Bnee.jdField_a_of_type_Bnew.getActivity() == null);
    Object localObject2;
    if (this.jdField_a_of_type_Bnee.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 14)
    {
      xvv.b("Q.qqstory.publish.edit.EditVideoPartManager", "Q.videostory.publish.upload[peak process]  sendBroadcast notify publish start(to read info from db)");
      localObject2 = this.jdField_a_of_type_Bnee.jdField_a_of_type_Bnew.getActivity().getIntent();
      if ((!blvr.a((Intent)localObject2)) || (blvr.e((Intent)localObject2)) || (blvr.d((Intent)localObject2))) {
        break label444;
      }
      this.jdField_a_of_type_Bnee.jdField_a_of_type_Bnew.a().sendBroadcast(new Intent("action_fire_create_video_story"));
    }
    label444:
    do
    {
      do
      {
        localObject1 = parambnot.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam;
        xvv.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishParam = " + localObject1);
        localObject2 = this.jdField_a_of_type_Bnee.jdField_a_of_type_Bnew.a(parambnot);
        this.jdField_a_of_type_Bnee.a((Intent)localObject2, this.jdField_a_of_type_Bnee.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a(), (PublishParam)localObject1, parambnot.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams);
        return;
      } while (this.jdField_a_of_type_Bnee.jdField_a_of_type_Bnet == null);
      this.jdField_a_of_type_Bnee.jdField_a_of_type_Bnet.a(amtj.a(2131702881), false, 0);
      this.jdField_a_of_type_Bnee.jdField_a_of_type_Bnet.a(2);
      this.jdField_a_of_type_Bnee.jdField_a_of_type_Bnet.a(5);
      localObject1 = parambnot.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam;
      xvv.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishParam = " + localObject1);
    } while (this.jdField_a_of_type_Bnee.jdField_a_of_type_Bnew.getActivity() == null);
    parambnot = this.jdField_a_of_type_Bnee.jdField_a_of_type_Bnew.getActivity().getIntent();
    int j;
    if (parambnot != null)
    {
      j = parambnot.getIntExtra("sv_total_frame_count", 0);
      i = parambnot.getIntExtra("sv_total_record_time", 0);
    }
    for (;;)
    {
      Intent localIntent = SaveVideoActivity.a(this.jdField_a_of_type_Bnee.jdField_a_of_type_Bnew.a(), ((PublishParam)localObject1).b, i, j, this.jdField_a_of_type_Bnee.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a());
      this.jdField_a_of_type_Bnee.jdField_a_of_type_Bnet.a(((PublishParam)localObject1).b);
      i = ((Intent)localObject2).getIntExtra("VIDEO_STORY_FROM_TYPE", blvr.a.a());
      localIntent.putExtra("mediacodec_encode_enable", true);
      if (((PublishParam)localObject1).e != 0)
      {
        localIntent.putExtra("video_edit_flag", bool);
        localIntent.putExtra("thumbfile_send_path", ((PublishParam)localObject1).c);
        localIntent.putExtra("VIDEO_STORY_FROM_TYPE", i);
        if (parambnot != null)
        {
          localIntent.putExtra("widgetinfo", parambnot.getStringExtra("widgetinfo"));
          localObject2 = parambnot.getStringExtra("key_camera_material_name");
          bmbx.b("Q.qqstory.publish.edit.EditVideoPartManager", "start SaveVideoActivity---takeSameName=" + (String)localObject2);
          localIntent.putExtra("key_camera_material_name", (String)localObject2);
          localIntent.putExtra("qqstory_slide_show_scene", parambnot.getIntExtra("qqstory_slide_show_scene", -1));
        }
        if ((!blvr.l.a(i)) && (!blvr.k.a(i))) {
          break label834;
        }
        this.jdField_a_of_type_Bnee.jdField_a_of_type_Bnew.getActivity().startActivityForResult(localIntent, 21);
      }
      for (;;)
      {
        this.jdField_a_of_type_Bnee.jdField_a_of_type_Bnet.a(5, ((PublishParam)localObject1).jdField_a_of_type_Long);
        return;
        bool = false;
        break;
        label834:
        this.jdField_a_of_type_Bnee.jdField_a_of_type_Bnew.getActivity().startActivityForResult(localIntent, 211);
      }
      label857:
      parambnot = this.jdField_a_of_type_Bnee.jdField_b_of_type_JavaUtilList.iterator();
      while (parambnot.hasNext()) {
        xvv.c("Q.qqstory.publish.edit.EditVideoPartManager", "publish error %s", (Error)parambnot.next());
      }
      QQToast.a(this.jdField_a_of_type_Bnee.jdField_a_of_type_Bnew.a(), this.jdField_a_of_type_Bnee.jdField_b_of_type_JavaUtilList.size() + amtj.a(2131702994), 0).a();
      parambnot = (bnel)this.jdField_a_of_type_Bnee.a(bnel.class);
      if (parambnot == null) {
        break;
      }
      parambnot.aE_();
      return;
      i = 0;
      j = 0;
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    xwa.b("publish_story", "publish_saveToEntry", 0, -1, new String[] { paramError.getMessage() + "", String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) });
    this.jdField_a_of_type_Bnee.a(paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnei
 * JD-Core Version:    0.7.0.1
 */