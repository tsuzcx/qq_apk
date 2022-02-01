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

class bqgp
  extends SimpleObserver<bqua>
{
  bqgp(bqgk parambqgk, long paramLong) {}
  
  public void a(bqua parambqua)
  {
    boolean bool = true;
    super.onNext(parambqua);
    this.jdField_a_of_type_Bqgk.p();
    this.jdField_a_of_type_Bqgk.jdField_b_of_type_Boolean = false;
    yuk.e("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH onNext");
    Object localObject1 = this.jdField_a_of_type_Bqgk.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((bqgi)((Iterator)localObject1).next()).b(parambqua);
    }
    int i;
    if ((parambqua.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource)) {
      i = 1;
    }
    for (;;)
    {
      yup.b("edit_video", "publish_cost", 0, 0, new String[] { String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long), String.valueOf(i) });
      yup.b("publish_story", "publish_saveToEntry", 0, 0, new String[] { "", String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) });
      if (bqgk.a(this.jdField_a_of_type_Bqgk, parambqua)) {
        bqgk.a(this.jdField_a_of_type_Bqgk);
      }
      if (this.jdField_a_of_type_Bqgk.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() <= 0) {
        break;
      }
      yuk.d("Q.qqstory.publish.edit.EditVideoPartManager", "waiting for another observer finish");
      return;
      if ((parambqua.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)) {
        i = 2;
      } else if ((parambqua.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) {
        i = 3;
      } else if ((parambqua.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource)) {
        i = 4;
      } else if ((parambqua.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) {
        i = 5;
      } else {
        i = 0;
      }
    }
    if ((bqgk.a(this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Long, 262144)) && (bqgk.b(this.jdField_a_of_type_Bqgk) > 0))
    {
      i = bqgk.b(this.jdField_a_of_type_Bqgk);
      if (!this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d()) {
        break label475;
      }
    }
    Object localObject2;
    label475:
    for (localObject1 = "0";; localObject1 = "1")
    {
      yup.a("video_edit", "pub_edit_one", 0, 0, new String[] { String.valueOf(i), localObject1 });
      this.jdField_a_of_type_Bqgk.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Bqgk.jdField_a_of_type_Bqhs.b();
      if (!this.jdField_a_of_type_Bqgk.jdField_b_of_type_JavaUtilList.isEmpty()) {
        break label1126;
      }
      localObject1 = this.jdField_a_of_type_Bqgk.jdField_a_of_type_Bqhs.getActivity();
      if (localObject1 == null) {
        break;
      }
      if (!(this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalGifSource)) {
        break label506;
      }
      parambqua = this.jdField_a_of_type_Bqgk.jdField_a_of_type_Bqhs.a(parambqua);
      localObject2 = parambqua.getStringExtra("PhotoConst.PLUGIN_APK");
      bool = parambqua.getBooleanExtra("DirectBackToQzone", false);
      if ((!"qzone_plugin.apk".equals(localObject2)) || (!bool)) {
        break label482;
      }
      bmtd.a((Activity)localObject1, "", parambqua, -1);
      this.jdField_a_of_type_Bqgk.jdField_a_of_type_Bqhs.a(-1, null, 2130772029, 0);
      return;
    }
    label482:
    ((Activity)localObject1).startActivity(parambqua);
    this.jdField_a_of_type_Bqgk.jdField_a_of_type_Bqhs.a(-1, null, 2130772029, 0);
    return;
    label506:
    if (this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 1) {
      this.jdField_a_of_type_Bqgk.jdField_a_of_type_Bqhs.a().sendBroadcast(new Intent("action_fire_create_story"));
    }
    do
    {
      do
      {
        for (;;)
        {
          localObject1 = parambqua.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam;
          yuk.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishParam = " + localObject1);
          localObject2 = this.jdField_a_of_type_Bqgk.jdField_a_of_type_Bqhs.a(parambqua);
          this.jdField_a_of_type_Bqgk.a((Intent)localObject2, this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a(), (PublishParam)localObject1, parambqua.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams);
          return;
          if (this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 14)
          {
            yuk.b("Q.qqstory.publish.edit.EditVideoPartManager", "Q.videostory.publish.upload[peak process]  sendBroadcast notify publish start(to read info from db)");
            localObject2 = this.jdField_a_of_type_Bqgk.jdField_a_of_type_Bqhs.getActivity().getIntent();
            if ((!born.a((Intent)localObject2)) || (born.e((Intent)localObject2)) || (born.d((Intent)localObject2))) {
              break;
            }
            this.jdField_a_of_type_Bqgk.jdField_a_of_type_Bqhs.a().sendBroadcast(new Intent("action_fire_create_video_story"));
          }
        }
      } while (this.jdField_a_of_type_Bqgk.jdField_a_of_type_Bqhi == null);
      this.jdField_a_of_type_Bqgk.jdField_a_of_type_Bqhi.a(anzj.a(2131702646), false, 0);
      this.jdField_a_of_type_Bqgk.jdField_a_of_type_Bqhi.a(2);
      this.jdField_a_of_type_Bqgk.jdField_a_of_type_Bqhi.a(5);
      localObject1 = parambqua.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam;
      yuk.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishParam = " + localObject1);
    } while (this.jdField_a_of_type_Bqgk.jdField_a_of_type_Bqhs.getActivity() == null);
    parambqua = this.jdField_a_of_type_Bqgk.jdField_a_of_type_Bqhs.getActivity().getIntent();
    int j;
    if (parambqua != null)
    {
      j = parambqua.getIntExtra("sv_total_frame_count", 0);
      i = parambqua.getIntExtra("sv_total_record_time", 0);
    }
    for (;;)
    {
      Intent localIntent = SaveVideoActivity.a(this.jdField_a_of_type_Bqgk.jdField_a_of_type_Bqhs.a(), ((PublishParam)localObject1).b, i, j, this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a());
      this.jdField_a_of_type_Bqgk.jdField_a_of_type_Bqhi.a(((PublishParam)localObject1).b);
      i = ((Intent)localObject2).getIntExtra("VIDEO_STORY_FROM_TYPE", born.a.a());
      localIntent.putExtra("mediacodec_encode_enable", true);
      if (((PublishParam)localObject1).e != 0)
      {
        localIntent.putExtra("video_edit_flag", bool);
        localIntent.putExtra("thumbfile_send_path", ((PublishParam)localObject1).c);
        localIntent.putExtra("VIDEO_STORY_FROM_TYPE", i);
        if (parambqua != null)
        {
          localIntent.putExtra("widgetinfo", parambqua.getStringExtra("widgetinfo"));
          localObject2 = parambqua.getStringExtra("key_camera_material_name");
          bpam.b("Q.qqstory.publish.edit.EditVideoPartManager", "start SaveVideoActivity---takeSameName=" + (String)localObject2);
          localIntent.putExtra("key_camera_material_name", (String)localObject2);
          localIntent.putExtra("qqstory_slide_show_scene", parambqua.getIntExtra("qqstory_slide_show_scene", -1));
        }
        if ((!born.l.a(i)) && (!born.k.a(i))) {
          break label1103;
        }
        this.jdField_a_of_type_Bqgk.jdField_a_of_type_Bqhs.getActivity().startActivityForResult(localIntent, 21);
      }
      for (;;)
      {
        this.jdField_a_of_type_Bqgk.jdField_a_of_type_Bqhi.a(5, ((PublishParam)localObject1).jdField_a_of_type_Long);
        return;
        bool = false;
        break;
        label1103:
        this.jdField_a_of_type_Bqgk.jdField_a_of_type_Bqhs.getActivity().startActivityForResult(localIntent, 211);
      }
      label1126:
      parambqua = this.jdField_a_of_type_Bqgk.jdField_b_of_type_JavaUtilList.iterator();
      while (parambqua.hasNext()) {
        yuk.c("Q.qqstory.publish.edit.EditVideoPartManager", "publish error %s", (Error)parambqua.next());
      }
      QQToast.a(this.jdField_a_of_type_Bqgk.jdField_a_of_type_Bqhs.a(), this.jdField_a_of_type_Bqgk.jdField_b_of_type_JavaUtilList.size() + anzj.a(2131702762), 0).a();
      parambqua = (bqgu)this.jdField_a_of_type_Bqgk.a(bqgu.class);
      if (parambqua == null) {
        break;
      }
      parambqua.l();
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
    yup.b("publish_story", "publish_saveToEntry", 0, -1, new String[] { paramError.getMessage() + "", String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) });
    this.jdField_a_of_type_Bqgk.a(paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqgp
 * JD-Core Version:    0.7.0.1
 */