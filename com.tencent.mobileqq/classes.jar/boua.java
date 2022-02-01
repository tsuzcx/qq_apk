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

class boua
  extends SimpleObserver<bpel>
{
  boua(botw parambotw, long paramLong) {}
  
  public void a(bpel parambpel)
  {
    boolean bool = true;
    super.onNext(parambpel);
    this.jdField_a_of_type_Botw.n();
    this.jdField_a_of_type_Botw.jdField_b_of_type_Boolean = false;
    ykq.e("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH onNext");
    Object localObject1 = this.jdField_a_of_type_Botw.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((botu)((Iterator)localObject1).next()).b(parambpel);
    }
    int i;
    if ((parambpel.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource))
    {
      i = 1;
      ykv.b("edit_video", "publish_cost", 0, 0, new String[] { String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long), String.valueOf(i) });
      ykv.b("publish_story", "publish_saveToEntry", 0, 0, new String[] { "", String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) });
      if (this.jdField_a_of_type_Botw.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() <= 0) {
        break label235;
      }
      ykq.d("Q.qqstory.publish.edit.EditVideoPartManager", "waiting for another observer finish");
    }
    label235:
    do
    {
      return;
      if ((parambpel.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
      {
        i = 2;
        break;
      }
      if ((parambpel.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource))
      {
        i = 3;
        break;
      }
      if ((parambpel.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource))
      {
        i = 4;
        break;
      }
      if ((parambpel.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
      {
        i = 5;
        break;
      }
      i = 0;
      break;
      this.jdField_a_of_type_Botw.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Botw.jdField_a_of_type_Bouo.b();
      if (!this.jdField_a_of_type_Botw.jdField_b_of_type_JavaUtilList.isEmpty()) {
        break label857;
      }
    } while (this.jdField_a_of_type_Botw.jdField_a_of_type_Bouo.getActivity() == null);
    Object localObject2;
    if (this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 14)
    {
      ykq.b("Q.qqstory.publish.edit.EditVideoPartManager", "Q.videostory.publish.upload[peak process]  sendBroadcast notify publish start(to read info from db)");
      localObject2 = this.jdField_a_of_type_Botw.jdField_a_of_type_Bouo.getActivity().getIntent();
      if ((!bnlb.a((Intent)localObject2)) || (bnlb.e((Intent)localObject2)) || (bnlb.d((Intent)localObject2))) {
        break label444;
      }
      this.jdField_a_of_type_Botw.jdField_a_of_type_Bouo.a().sendBroadcast(new Intent("action_fire_create_video_story"));
    }
    label444:
    do
    {
      do
      {
        localObject1 = parambpel.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam;
        ykq.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishParam = " + localObject1);
        localObject2 = this.jdField_a_of_type_Botw.jdField_a_of_type_Bouo.a(parambpel);
        this.jdField_a_of_type_Botw.a((Intent)localObject2, this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a(), (PublishParam)localObject1, parambpel.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams);
        return;
      } while (this.jdField_a_of_type_Botw.jdField_a_of_type_Boul == null);
      this.jdField_a_of_type_Botw.jdField_a_of_type_Boul.a(anvx.a(2131703232), false, 0);
      this.jdField_a_of_type_Botw.jdField_a_of_type_Boul.a(2);
      this.jdField_a_of_type_Botw.jdField_a_of_type_Boul.a(5);
      localObject1 = parambpel.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam;
      ykq.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishParam = " + localObject1);
    } while (this.jdField_a_of_type_Botw.jdField_a_of_type_Bouo.getActivity() == null);
    parambpel = this.jdField_a_of_type_Botw.jdField_a_of_type_Bouo.getActivity().getIntent();
    int j;
    if (parambpel != null)
    {
      j = parambpel.getIntExtra("sv_total_frame_count", 0);
      i = parambpel.getIntExtra("sv_total_record_time", 0);
    }
    for (;;)
    {
      Intent localIntent = SaveVideoActivity.a(this.jdField_a_of_type_Botw.jdField_a_of_type_Bouo.a(), ((PublishParam)localObject1).b, i, j, this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a());
      this.jdField_a_of_type_Botw.jdField_a_of_type_Boul.a(((PublishParam)localObject1).b);
      i = ((Intent)localObject2).getIntExtra("VIDEO_STORY_FROM_TYPE", bnlb.a.a());
      localIntent.putExtra("mediacodec_encode_enable", true);
      if (((PublishParam)localObject1).e != 0)
      {
        localIntent.putExtra("video_edit_flag", bool);
        localIntent.putExtra("thumbfile_send_path", ((PublishParam)localObject1).c);
        localIntent.putExtra("VIDEO_STORY_FROM_TYPE", i);
        if (parambpel != null)
        {
          localIntent.putExtra("widgetinfo", parambpel.getStringExtra("widgetinfo"));
          localObject2 = parambpel.getStringExtra("key_camera_material_name");
          bnrh.b("Q.qqstory.publish.edit.EditVideoPartManager", "start SaveVideoActivity---takeSameName=" + (String)localObject2);
          localIntent.putExtra("key_camera_material_name", (String)localObject2);
          localIntent.putExtra("qqstory_slide_show_scene", parambpel.getIntExtra("qqstory_slide_show_scene", -1));
        }
        if ((!bnlb.l.a(i)) && (!bnlb.k.a(i))) {
          break label834;
        }
        this.jdField_a_of_type_Botw.jdField_a_of_type_Bouo.getActivity().startActivityForResult(localIntent, 21);
      }
      for (;;)
      {
        this.jdField_a_of_type_Botw.jdField_a_of_type_Boul.a(5, ((PublishParam)localObject1).jdField_a_of_type_Long);
        return;
        bool = false;
        break;
        label834:
        this.jdField_a_of_type_Botw.jdField_a_of_type_Bouo.getActivity().startActivityForResult(localIntent, 211);
      }
      label857:
      parambpel = this.jdField_a_of_type_Botw.jdField_b_of_type_JavaUtilList.iterator();
      while (parambpel.hasNext()) {
        ykq.c("Q.qqstory.publish.edit.EditVideoPartManager", "publish error %s", (Error)parambpel.next());
      }
      QQToast.a(this.jdField_a_of_type_Botw.jdField_a_of_type_Bouo.a(), this.jdField_a_of_type_Botw.jdField_b_of_type_JavaUtilList.size() + anvx.a(2131703345), 0).a();
      parambpel = (boud)this.jdField_a_of_type_Botw.a(boud.class);
      if (parambpel == null) {
        break;
      }
      parambpel.aG_();
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
    ykv.b("publish_story", "publish_saveToEntry", 0, -1, new String[] { paramError.getMessage() + "", String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) });
    this.jdField_a_of_type_Botw.a(paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boua
 * JD-Core Version:    0.7.0.1
 */