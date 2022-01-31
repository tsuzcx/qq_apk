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

class bmjc
  extends SimpleObserver<bmwn>
{
  bmjc(bmix parambmix, long paramLong) {}
  
  public void a(bmwn parambmwn)
  {
    boolean bool = true;
    super.onNext(parambmwn);
    this.jdField_a_of_type_Bmix.p();
    this.jdField_a_of_type_Bmix.jdField_b_of_type_Boolean = false;
    wsv.e("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH onNext");
    Object localObject1 = this.jdField_a_of_type_Bmix.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((bmiv)((Iterator)localObject1).next()).b(parambmwn);
    }
    int i;
    if ((parambmwn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource)) {
      i = 1;
    }
    for (;;)
    {
      wta.b("edit_video", "publish_cost", 0, 0, new String[] { String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long), String.valueOf(i) });
      wta.b("publish_story", "publish_saveToEntry", 0, 0, new String[] { "", String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) });
      if (bmix.a(this.jdField_a_of_type_Bmix, parambmwn)) {
        bmix.a(this.jdField_a_of_type_Bmix);
      }
      if (this.jdField_a_of_type_Bmix.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() <= 0) {
        break;
      }
      wsv.d("Q.qqstory.publish.edit.EditVideoPartManager", "waiting for another observer finish");
      return;
      if ((parambmwn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)) {
        i = 2;
      } else if ((parambmwn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) {
        i = 3;
      } else if ((parambmwn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource)) {
        i = 4;
      } else if ((parambmwn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) {
        i = 5;
      } else {
        i = 0;
      }
    }
    if ((bmix.a(this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Long, 262144)) && (bmix.b(this.jdField_a_of_type_Bmix) > 0))
    {
      i = bmix.b(this.jdField_a_of_type_Bmix);
      if (!this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d()) {
        break label475;
      }
    }
    Object localObject2;
    label475:
    for (localObject1 = "0";; localObject1 = "1")
    {
      wta.a("video_edit", "pub_edit_one", 0, 0, new String[] { String.valueOf(i), localObject1 });
      this.jdField_a_of_type_Bmix.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Bmix.jdField_a_of_type_Bmkf.b();
      if (!this.jdField_a_of_type_Bmix.jdField_b_of_type_JavaUtilList.isEmpty()) {
        break label1126;
      }
      localObject1 = this.jdField_a_of_type_Bmix.jdField_a_of_type_Bmkf.getActivity();
      if (localObject1 == null) {
        break;
      }
      if (!(this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalGifSource)) {
        break label506;
      }
      parambmwn = this.jdField_a_of_type_Bmix.jdField_a_of_type_Bmkf.a(parambmwn);
      localObject2 = parambmwn.getStringExtra("PhotoConst.PLUGIN_APK");
      bool = parambmwn.getBooleanExtra("DirectBackToQzone", false);
      if ((!"qzone_plugin.apk".equals(localObject2)) || (!bool)) {
        break label482;
      }
      bizm.a((Activity)localObject1, "", parambmwn, -1);
      this.jdField_a_of_type_Bmix.jdField_a_of_type_Bmkf.a(-1, null, 2130772028, 0);
      return;
    }
    label482:
    ((Activity)localObject1).startActivity(parambmwn);
    this.jdField_a_of_type_Bmix.jdField_a_of_type_Bmkf.a(-1, null, 2130772028, 0);
    return;
    label506:
    if (this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 1) {
      this.jdField_a_of_type_Bmix.jdField_a_of_type_Bmkf.a().sendBroadcast(new Intent("action_fire_create_story"));
    }
    do
    {
      do
      {
        for (;;)
        {
          localObject1 = parambmwn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam;
          wsv.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishParam = " + localObject1);
          localObject2 = this.jdField_a_of_type_Bmix.jdField_a_of_type_Bmkf.a(parambmwn);
          this.jdField_a_of_type_Bmix.a((Intent)localObject2, this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a(), (PublishParam)localObject1, parambmwn.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams);
          return;
          if (this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 14)
          {
            wsv.b("Q.qqstory.publish.edit.EditVideoPartManager", "Q.videostory.publish.upload[peak process]  sendBroadcast notify publish start(to read info from db)");
            localObject2 = this.jdField_a_of_type_Bmix.jdField_a_of_type_Bmkf.getActivity().getIntent();
            if ((!bkwm.a((Intent)localObject2)) || (bkwm.e((Intent)localObject2)) || (bkwm.d((Intent)localObject2))) {
              break;
            }
            this.jdField_a_of_type_Bmix.jdField_a_of_type_Bmkf.a().sendBroadcast(new Intent("action_fire_create_video_story"));
          }
        }
      } while (this.jdField_a_of_type_Bmix.jdField_a_of_type_Bmjv == null);
      this.jdField_a_of_type_Bmix.jdField_a_of_type_Bmjv.a(alpo.a(2131704130), false, 0);
      this.jdField_a_of_type_Bmix.jdField_a_of_type_Bmjv.a(2);
      this.jdField_a_of_type_Bmix.jdField_a_of_type_Bmjv.a(5);
      localObject1 = parambmwn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam;
      wsv.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishParam = " + localObject1);
    } while (this.jdField_a_of_type_Bmix.jdField_a_of_type_Bmkf.getActivity() == null);
    parambmwn = this.jdField_a_of_type_Bmix.jdField_a_of_type_Bmkf.getActivity().getIntent();
    int j;
    if (parambmwn != null)
    {
      j = parambmwn.getIntExtra("sv_total_frame_count", 0);
      i = parambmwn.getIntExtra("sv_total_record_time", 0);
    }
    for (;;)
    {
      Intent localIntent = SaveVideoActivity.a(this.jdField_a_of_type_Bmix.jdField_a_of_type_Bmkf.a(), ((PublishParam)localObject1).b, i, j, this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a());
      this.jdField_a_of_type_Bmix.jdField_a_of_type_Bmjv.a(((PublishParam)localObject1).b);
      i = ((Intent)localObject2).getIntExtra("VIDEO_STORY_FROM_TYPE", bkwm.a.a());
      localIntent.putExtra("mediacodec_encode_enable", true);
      if (((PublishParam)localObject1).e != 0)
      {
        localIntent.putExtra("video_edit_flag", bool);
        localIntent.putExtra("thumbfile_send_path", ((PublishParam)localObject1).c);
        localIntent.putExtra("VIDEO_STORY_FROM_TYPE", i);
        if (parambmwn != null)
        {
          localIntent.putExtra("widgetinfo", parambmwn.getStringExtra("widgetinfo"));
          localObject2 = parambmwn.getStringExtra("key_camera_material_name");
          blfg.b("Q.qqstory.publish.edit.EditVideoPartManager", "start SaveVideoActivity---takeSameName=" + (String)localObject2);
          localIntent.putExtra("key_camera_material_name", (String)localObject2);
          localIntent.putExtra("qqstory_slide_show_scene", parambmwn.getIntExtra("qqstory_slide_show_scene", -1));
        }
        if ((!bkwm.l.a(i)) && (!bkwm.k.a(i))) {
          break label1103;
        }
        this.jdField_a_of_type_Bmix.jdField_a_of_type_Bmkf.getActivity().startActivityForResult(localIntent, 21);
      }
      for (;;)
      {
        this.jdField_a_of_type_Bmix.jdField_a_of_type_Bmjv.a(5, ((PublishParam)localObject1).jdField_a_of_type_Long);
        return;
        bool = false;
        break;
        label1103:
        this.jdField_a_of_type_Bmix.jdField_a_of_type_Bmkf.getActivity().startActivityForResult(localIntent, 211);
      }
      label1126:
      parambmwn = this.jdField_a_of_type_Bmix.jdField_b_of_type_JavaUtilList.iterator();
      while (parambmwn.hasNext()) {
        wsv.c("Q.qqstory.publish.edit.EditVideoPartManager", "publish error %s", (Error)parambmwn.next());
      }
      QQToast.a(this.jdField_a_of_type_Bmix.jdField_a_of_type_Bmkf.a(), this.jdField_a_of_type_Bmix.jdField_b_of_type_JavaUtilList.size() + alpo.a(2131704246), 0).a();
      parambmwn = (bmjh)this.jdField_a_of_type_Bmix.a(bmjh.class);
      if (parambmwn == null) {
        break;
      }
      parambmwn.l();
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
    wta.b("publish_story", "publish_saveToEntry", 0, -1, new String[] { paramError.getMessage() + "", String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) });
    this.jdField_a_of_type_Bmix.a(paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmjc
 * JD-Core Version:    0.7.0.1
 */