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

class bpeu
  extends SimpleObserver<bpsf>
{
  bpeu(bpep parambpep, long paramLong) {}
  
  public void a(bpsf parambpsf)
  {
    boolean bool = true;
    super.onNext(parambpsf);
    this.jdField_a_of_type_Bpep.p();
    this.jdField_a_of_type_Bpep.jdField_b_of_type_Boolean = false;
    yqp.e("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH onNext");
    Object localObject1 = this.jdField_a_of_type_Bpep.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((bpen)((Iterator)localObject1).next()).b(parambpsf);
    }
    int i;
    if ((parambpsf.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource)) {
      i = 1;
    }
    for (;;)
    {
      yqu.b("edit_video", "publish_cost", 0, 0, new String[] { String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long), String.valueOf(i) });
      yqu.b("publish_story", "publish_saveToEntry", 0, 0, new String[] { "", String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) });
      if (bpep.a(this.jdField_a_of_type_Bpep, parambpsf)) {
        bpep.a(this.jdField_a_of_type_Bpep);
      }
      if (this.jdField_a_of_type_Bpep.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() <= 0) {
        break;
      }
      yqp.d("Q.qqstory.publish.edit.EditVideoPartManager", "waiting for another observer finish");
      return;
      if ((parambpsf.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)) {
        i = 2;
      } else if ((parambpsf.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) {
        i = 3;
      } else if ((parambpsf.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource)) {
        i = 4;
      } else if ((parambpsf.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) {
        i = 5;
      } else {
        i = 0;
      }
    }
    if ((bpep.a(this.jdField_a_of_type_Bpep.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Long, 262144)) && (bpep.b(this.jdField_a_of_type_Bpep) > 0))
    {
      i = bpep.b(this.jdField_a_of_type_Bpep);
      if (!this.jdField_a_of_type_Bpep.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d()) {
        break label475;
      }
    }
    Object localObject2;
    label475:
    for (localObject1 = "0";; localObject1 = "1")
    {
      yqu.a("video_edit", "pub_edit_one", 0, 0, new String[] { String.valueOf(i), localObject1 });
      this.jdField_a_of_type_Bpep.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Bpep.jdField_a_of_type_Bpfx.b();
      if (!this.jdField_a_of_type_Bpep.jdField_b_of_type_JavaUtilList.isEmpty()) {
        break label1126;
      }
      localObject1 = this.jdField_a_of_type_Bpep.jdField_a_of_type_Bpfx.getActivity();
      if (localObject1 == null) {
        break;
      }
      if (!(this.jdField_a_of_type_Bpep.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalGifSource)) {
        break label506;
      }
      parambpsf = this.jdField_a_of_type_Bpep.jdField_a_of_type_Bpfx.a(parambpsf);
      localObject2 = parambpsf.getStringExtra("PhotoConst.PLUGIN_APK");
      bool = parambpsf.getBooleanExtra("DirectBackToQzone", false);
      if ((!"qzone_plugin.apk".equals(localObject2)) || (!bool)) {
        break label482;
      }
      blsb.a((Activity)localObject1, "", parambpsf, -1);
      this.jdField_a_of_type_Bpep.jdField_a_of_type_Bpfx.a(-1, null, 2130772029, 0);
      return;
    }
    label482:
    ((Activity)localObject1).startActivity(parambpsf);
    this.jdField_a_of_type_Bpep.jdField_a_of_type_Bpfx.a(-1, null, 2130772029, 0);
    return;
    label506:
    if (this.jdField_a_of_type_Bpep.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 1) {
      this.jdField_a_of_type_Bpep.jdField_a_of_type_Bpfx.a().sendBroadcast(new Intent("action_fire_create_story"));
    }
    do
    {
      do
      {
        for (;;)
        {
          localObject1 = parambpsf.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam;
          yqp.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishParam = " + localObject1);
          localObject2 = this.jdField_a_of_type_Bpep.jdField_a_of_type_Bpfx.a(parambpsf);
          this.jdField_a_of_type_Bpep.a((Intent)localObject2, this.jdField_a_of_type_Bpep.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a(), (PublishParam)localObject1, parambpsf.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams);
          return;
          if (this.jdField_a_of_type_Bpep.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 14)
          {
            yqp.b("Q.qqstory.publish.edit.EditVideoPartManager", "Q.videostory.publish.upload[peak process]  sendBroadcast notify publish start(to read info from db)");
            localObject2 = this.jdField_a_of_type_Bpep.jdField_a_of_type_Bpfx.getActivity().getIntent();
            if ((!bnqb.a((Intent)localObject2)) || (bnqb.e((Intent)localObject2)) || (bnqb.d((Intent)localObject2))) {
              break;
            }
            this.jdField_a_of_type_Bpep.jdField_a_of_type_Bpfx.a().sendBroadcast(new Intent("action_fire_create_video_story"));
          }
        }
      } while (this.jdField_a_of_type_Bpep.jdField_a_of_type_Bpfn == null);
      this.jdField_a_of_type_Bpep.jdField_a_of_type_Bpfn.a(anni.a(2131702539), false, 0);
      this.jdField_a_of_type_Bpep.jdField_a_of_type_Bpfn.a(2);
      this.jdField_a_of_type_Bpep.jdField_a_of_type_Bpfn.a(5);
      localObject1 = parambpsf.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam;
      yqp.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishParam = " + localObject1);
    } while (this.jdField_a_of_type_Bpep.jdField_a_of_type_Bpfx.getActivity() == null);
    parambpsf = this.jdField_a_of_type_Bpep.jdField_a_of_type_Bpfx.getActivity().getIntent();
    int j;
    if (parambpsf != null)
    {
      j = parambpsf.getIntExtra("sv_total_frame_count", 0);
      i = parambpsf.getIntExtra("sv_total_record_time", 0);
    }
    for (;;)
    {
      Intent localIntent = SaveVideoActivity.a(this.jdField_a_of_type_Bpep.jdField_a_of_type_Bpfx.a(), ((PublishParam)localObject1).b, i, j, this.jdField_a_of_type_Bpep.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a());
      this.jdField_a_of_type_Bpep.jdField_a_of_type_Bpfn.a(((PublishParam)localObject1).b);
      i = ((Intent)localObject2).getIntExtra("VIDEO_STORY_FROM_TYPE", bnqb.a.a());
      localIntent.putExtra("mediacodec_encode_enable", true);
      if (((PublishParam)localObject1).e != 0)
      {
        localIntent.putExtra("video_edit_flag", bool);
        localIntent.putExtra("thumbfile_send_path", ((PublishParam)localObject1).c);
        localIntent.putExtra("VIDEO_STORY_FROM_TYPE", i);
        if (parambpsf != null)
        {
          localIntent.putExtra("widgetinfo", parambpsf.getStringExtra("widgetinfo"));
          localObject2 = parambpsf.getStringExtra("key_camera_material_name");
          bnzb.b("Q.qqstory.publish.edit.EditVideoPartManager", "start SaveVideoActivity---takeSameName=" + (String)localObject2);
          localIntent.putExtra("key_camera_material_name", (String)localObject2);
          localIntent.putExtra("qqstory_slide_show_scene", parambpsf.getIntExtra("qqstory_slide_show_scene", -1));
        }
        if ((!bnqb.l.a(i)) && (!bnqb.k.a(i))) {
          break label1103;
        }
        this.jdField_a_of_type_Bpep.jdField_a_of_type_Bpfx.getActivity().startActivityForResult(localIntent, 21);
      }
      for (;;)
      {
        this.jdField_a_of_type_Bpep.jdField_a_of_type_Bpfn.a(5, ((PublishParam)localObject1).jdField_a_of_type_Long);
        return;
        bool = false;
        break;
        label1103:
        this.jdField_a_of_type_Bpep.jdField_a_of_type_Bpfx.getActivity().startActivityForResult(localIntent, 211);
      }
      label1126:
      parambpsf = this.jdField_a_of_type_Bpep.jdField_b_of_type_JavaUtilList.iterator();
      while (parambpsf.hasNext()) {
        yqp.c("Q.qqstory.publish.edit.EditVideoPartManager", "publish error %s", (Error)parambpsf.next());
      }
      QQToast.a(this.jdField_a_of_type_Bpep.jdField_a_of_type_Bpfx.a(), this.jdField_a_of_type_Bpep.jdField_b_of_type_JavaUtilList.size() + anni.a(2131702655), 0).a();
      parambpsf = (bpez)this.jdField_a_of_type_Bpep.a(bpez.class);
      if (parambpsf == null) {
        break;
      }
      parambpsf.l();
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
    yqu.b("publish_story", "publish_saveToEntry", 0, -1, new String[] { paramError.getMessage() + "", String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) });
    this.jdField_a_of_type_Bpep.a(paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpeu
 * JD-Core Version:    0.7.0.1
 */