import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalGifSource;
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

class bmno
  extends SimpleObserver<bnaz>
{
  bmno(bmnj parambmnj, long paramLong) {}
  
  public void a(bnaz parambnaz)
  {
    boolean bool = true;
    super.onNext(parambnaz);
    this.jdField_a_of_type_Bmnj.p();
    this.jdField_a_of_type_Bmnj.jdField_b_of_type_Boolean = false;
    wxe.e("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH onNext");
    Object localObject1 = this.jdField_a_of_type_Bmnj.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((bmnh)((Iterator)localObject1).next()).b(parambnaz);
    }
    int i;
    if ((parambnaz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource)) {
      i = 1;
    }
    for (;;)
    {
      wxj.b("edit_video", "publish_cost", 0, 0, new String[] { String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long), String.valueOf(i) });
      wxj.b("publish_story", "publish_saveToEntry", 0, 0, new String[] { "", String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) });
      if (bmnj.a(this.jdField_a_of_type_Bmnj, parambnaz)) {
        bmnj.a(this.jdField_a_of_type_Bmnj);
      }
      if (this.jdField_a_of_type_Bmnj.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() <= 0) {
        break;
      }
      wxe.d("Q.qqstory.publish.edit.EditVideoPartManager", "waiting for another observer finish");
      return;
      if ((parambnaz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)) {
        i = 2;
      } else if ((parambnaz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) {
        i = 3;
      } else if ((parambnaz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource)) {
        i = 4;
      } else if ((parambnaz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) {
        i = 5;
      } else {
        i = 0;
      }
    }
    if ((bmnj.a(this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Long, 262144)) && (bmnj.b(this.jdField_a_of_type_Bmnj) > 0))
    {
      i = bmnj.b(this.jdField_a_of_type_Bmnj);
      if (!this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d()) {
        break label475;
      }
    }
    Object localObject2;
    label475:
    for (localObject1 = "0";; localObject1 = "1")
    {
      wxj.a("video_edit", "pub_edit_one", 0, 0, new String[] { String.valueOf(i), localObject1 });
      this.jdField_a_of_type_Bmnj.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Bmnj.jdField_a_of_type_Bmor.b();
      if (!this.jdField_a_of_type_Bmnj.jdField_b_of_type_JavaUtilList.isEmpty()) {
        break label1126;
      }
      localObject1 = this.jdField_a_of_type_Bmnj.jdField_a_of_type_Bmor.getActivity();
      if (localObject1 == null) {
        break;
      }
      if (!(this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalGifSource)) {
        break label506;
      }
      parambnaz = this.jdField_a_of_type_Bmnj.jdField_a_of_type_Bmor.a(parambnaz);
      localObject2 = parambnaz.getStringExtra("PhotoConst.PLUGIN_APK");
      bool = parambnaz.getBooleanExtra("DirectBackToQzone", false);
      if ((!"qzone_plugin.apk".equals(localObject2)) || (!bool)) {
        break label482;
      }
      bjdt.a((Activity)localObject1, "", parambnaz, -1);
      this.jdField_a_of_type_Bmnj.jdField_a_of_type_Bmor.a(-1, null, 2130772028, 0);
      return;
    }
    label482:
    ((Activity)localObject1).startActivity(parambnaz);
    this.jdField_a_of_type_Bmnj.jdField_a_of_type_Bmor.a(-1, null, 2130772028, 0);
    return;
    label506:
    if (this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 1) {
      this.jdField_a_of_type_Bmnj.jdField_a_of_type_Bmor.a().sendBroadcast(new Intent("action_fire_create_story"));
    }
    do
    {
      do
      {
        for (;;)
        {
          localObject1 = parambnaz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam;
          wxe.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishParam = " + localObject1);
          localObject2 = this.jdField_a_of_type_Bmnj.jdField_a_of_type_Bmor.a(parambnaz);
          this.jdField_a_of_type_Bmnj.a((Intent)localObject2, this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a(), (PublishParam)localObject1, parambnaz.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams);
          return;
          if (this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 14)
          {
            wxe.b("Q.qqstory.publish.edit.EditVideoPartManager", "Q.videostory.publish.upload[peak process]  sendBroadcast notify publish start(to read info from db)");
            localObject2 = this.jdField_a_of_type_Bmnj.jdField_a_of_type_Bmor.getActivity().getIntent();
            if ((!blat.a((Intent)localObject2)) || (blat.e((Intent)localObject2)) || (blat.d((Intent)localObject2))) {
              break;
            }
            this.jdField_a_of_type_Bmnj.jdField_a_of_type_Bmor.a().sendBroadcast(new Intent("action_fire_create_video_story"));
          }
        }
      } while (this.jdField_a_of_type_Bmnj.jdField_a_of_type_Bmoh == null);
      this.jdField_a_of_type_Bmnj.jdField_a_of_type_Bmoh.a(alud.a(2131704142), false, 0);
      this.jdField_a_of_type_Bmnj.jdField_a_of_type_Bmoh.a(2);
      this.jdField_a_of_type_Bmnj.jdField_a_of_type_Bmoh.a(5);
      localObject1 = parambnaz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam;
      wxe.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishParam = " + localObject1);
    } while (this.jdField_a_of_type_Bmnj.jdField_a_of_type_Bmor.getActivity() == null);
    parambnaz = this.jdField_a_of_type_Bmnj.jdField_a_of_type_Bmor.getActivity().getIntent();
    int j;
    if (parambnaz != null)
    {
      j = parambnaz.getIntExtra("sv_total_frame_count", 0);
      i = parambnaz.getIntExtra("sv_total_record_time", 0);
    }
    for (;;)
    {
      Intent localIntent = SaveVideoActivity.a(this.jdField_a_of_type_Bmnj.jdField_a_of_type_Bmor.a(), ((PublishParam)localObject1).b, i, j, this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a());
      this.jdField_a_of_type_Bmnj.jdField_a_of_type_Bmoh.a(((PublishParam)localObject1).b);
      i = ((Intent)localObject2).getIntExtra("VIDEO_STORY_FROM_TYPE", blat.a.a());
      localIntent.putExtra("mediacodec_encode_enable", true);
      if (((PublishParam)localObject1).e != 0)
      {
        localIntent.putExtra("video_edit_flag", bool);
        localIntent.putExtra("thumbfile_send_path", ((PublishParam)localObject1).c);
        localIntent.putExtra("VIDEO_STORY_FROM_TYPE", i);
        if (parambnaz != null)
        {
          localIntent.putExtra("widgetinfo", parambnaz.getStringExtra("widgetinfo"));
          localObject2 = parambnaz.getStringExtra("key_camera_material_name");
          bljn.b("Q.qqstory.publish.edit.EditVideoPartManager", "start SaveVideoActivity---takeSameName=" + (String)localObject2);
          localIntent.putExtra("key_camera_material_name", (String)localObject2);
          localIntent.putExtra("qqstory_slide_show_scene", parambnaz.getIntExtra("qqstory_slide_show_scene", -1));
        }
        if ((!blat.l.a(i)) && (!blat.k.a(i))) {
          break label1103;
        }
        this.jdField_a_of_type_Bmnj.jdField_a_of_type_Bmor.getActivity().startActivityForResult(localIntent, 21);
      }
      for (;;)
      {
        this.jdField_a_of_type_Bmnj.jdField_a_of_type_Bmoh.a(5, ((PublishParam)localObject1).jdField_a_of_type_Long);
        return;
        bool = false;
        break;
        label1103:
        this.jdField_a_of_type_Bmnj.jdField_a_of_type_Bmor.getActivity().startActivityForResult(localIntent, 211);
      }
      label1126:
      parambnaz = this.jdField_a_of_type_Bmnj.jdField_b_of_type_JavaUtilList.iterator();
      while (parambnaz.hasNext()) {
        wxe.c("Q.qqstory.publish.edit.EditVideoPartManager", "publish error %s", (Error)parambnaz.next());
      }
      QQToast.a(this.jdField_a_of_type_Bmnj.jdField_a_of_type_Bmor.a(), this.jdField_a_of_type_Bmnj.jdField_b_of_type_JavaUtilList.size() + alud.a(2131704258), 0).a();
      parambnaz = (bmnt)this.jdField_a_of_type_Bmnj.a(bmnt.class);
      if (parambnaz == null) {
        break;
      }
      parambnaz.l();
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
    wxj.b("publish_story", "publish_saveToEntry", 0, -1, new String[] { paramError.getMessage() + "", String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) });
    this.jdField_a_of_type_Bmnj.a(paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmno
 * JD-Core Version:    0.7.0.1
 */