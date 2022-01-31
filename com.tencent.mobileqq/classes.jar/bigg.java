import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.annotation.NonNull;
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

class bigg
  extends SimpleObserver<bitz>
{
  bigg(bigb parambigb, long paramLong) {}
  
  public void a(bitz parambitz)
  {
    boolean bool = true;
    super.onNext(parambitz);
    this.jdField_a_of_type_Bigb.p();
    this.jdField_a_of_type_Bigb.jdField_b_of_type_Boolean = false;
    urk.e("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH onNext");
    Object localObject1 = this.jdField_a_of_type_Bigb.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((bifz)((Iterator)localObject1).next()).b(parambitz);
    }
    int i;
    if ((parambitz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource)) {
      i = 1;
    }
    for (;;)
    {
      urp.b("edit_video", "publish_cost", 0, 0, new String[] { String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long), String.valueOf(i) });
      urp.b("publish_story", "publish_saveToEntry", 0, 0, new String[] { "", String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) });
      if (bigb.a(this.jdField_a_of_type_Bigb, parambitz)) {
        bigb.a(this.jdField_a_of_type_Bigb);
      }
      if (this.jdField_a_of_type_Bigb.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() <= 0) {
        break;
      }
      urk.d("Q.qqstory.publish.edit.EditVideoPartManager", "waiting for another observer finish");
      return;
      if ((parambitz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)) {
        i = 2;
      } else if ((parambitz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) {
        i = 3;
      } else if ((parambitz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource)) {
        i = 4;
      } else if ((parambitz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) {
        i = 5;
      } else {
        i = 0;
      }
    }
    if ((bigb.a(this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Long, 262144)) && (bigb.b(this.jdField_a_of_type_Bigb) > 0))
    {
      i = bigb.b(this.jdField_a_of_type_Bigb);
      if (!this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d()) {
        break label475;
      }
    }
    Object localObject2;
    label475:
    for (localObject1 = "0";; localObject1 = "1")
    {
      urp.a("video_edit", "pub_edit_one", 0, 0, new String[] { String.valueOf(i), localObject1 });
      this.jdField_a_of_type_Bigb.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Bigb.jdField_a_of_type_Bihj.b();
      if (!this.jdField_a_of_type_Bigb.jdField_b_of_type_JavaUtilList.isEmpty()) {
        break label1080;
      }
      localObject1 = this.jdField_a_of_type_Bigb.jdField_a_of_type_Bihj.getActivity();
      if (localObject1 == null) {
        break;
      }
      if (!(this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalGifSource)) {
        break label506;
      }
      parambitz = this.jdField_a_of_type_Bigb.jdField_a_of_type_Bihj.a(parambitz);
      localObject2 = parambitz.getStringExtra("PhotoConst.PLUGIN_APK");
      bool = parambitz.getBooleanExtra("DirectBackToQzone", false);
      if ((!"qzone_plugin.apk".equals(localObject2)) || (!bool)) {
        break label482;
      }
      bfpr.a((Activity)localObject1, "", parambitz, -1);
      this.jdField_a_of_type_Bigb.jdField_a_of_type_Bihj.a(-1, null, 2130772028, 0);
      return;
    }
    label482:
    ((Activity)localObject1).startActivity(parambitz);
    this.jdField_a_of_type_Bigb.jdField_a_of_type_Bihj.a(-1, null, 2130772028, 0);
    return;
    label506:
    if (this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 1) {
      this.jdField_a_of_type_Bigb.jdField_a_of_type_Bihj.a().sendBroadcast(new Intent("action_fire_create_story"));
    }
    do
    {
      do
      {
        for (;;)
        {
          localObject1 = parambitz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam;
          urk.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishParam = " + localObject1);
          localObject2 = this.jdField_a_of_type_Bigb.jdField_a_of_type_Bihj.a(parambitz);
          this.jdField_a_of_type_Bigb.a((Intent)localObject2, this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a(), (PublishParam)localObject1, parambitz.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams);
          return;
          if (this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 14)
          {
            urk.b("Q.qqstory.publish.edit.EditVideoPartManager", "Q.videostory.publish.upload[peak process]  sendBroadcast notify publish start(to read info from db)");
            localObject1 = this.jdField_a_of_type_Bigb.jdField_a_of_type_Bihj.getActivity().getIntent();
            if ((!bjeg.c((Intent)localObject1)) || (bjeg.j((Intent)localObject1)) || (bjeg.i((Intent)localObject1))) {
              break;
            }
            this.jdField_a_of_type_Bigb.jdField_a_of_type_Bihj.a().sendBroadcast(new Intent("action_fire_create_video_story"));
          }
        }
      } while (this.jdField_a_of_type_Bigb.jdField_a_of_type_Bigz == null);
      this.jdField_a_of_type_Bigb.jdField_a_of_type_Bigz.a(ajjy.a(2131637962), false, 0);
      this.jdField_a_of_type_Bigb.jdField_a_of_type_Bigz.a(2);
      this.jdField_a_of_type_Bigb.jdField_a_of_type_Bigz.a(5);
      localObject2 = parambitz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam;
      urk.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishParam = " + localObject2);
    } while (this.jdField_a_of_type_Bigb.jdField_a_of_type_Bihj.getActivity() == null);
    parambitz = this.jdField_a_of_type_Bigb.jdField_a_of_type_Bihj.getActivity().getIntent();
    int j;
    if (parambitz != null)
    {
      j = parambitz.getIntExtra("sv_total_frame_count", 0);
      i = parambitz.getIntExtra("sv_total_record_time", 0);
    }
    for (;;)
    {
      Intent localIntent = SaveVideoActivity.a(this.jdField_a_of_type_Bigb.jdField_a_of_type_Bihj.a(), ((PublishParam)localObject2).b, i, j, this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a());
      this.jdField_a_of_type_Bigb.jdField_a_of_type_Bigz.a(((PublishParam)localObject2).b);
      i = ((Intent)localObject1).getIntExtra("VIDEO_STORY_FROM_TYPE", bgww.a.a());
      localIntent.putExtra("mediacodec_encode_enable", true);
      if (((PublishParam)localObject2).e != 0)
      {
        localIntent.putExtra("video_edit_flag", bool);
        localIntent.putExtra("thumbfile_send_path", ((PublishParam)localObject2).c);
        localIntent.putExtra("VIDEO_STORY_FROM_TYPE", i);
        if (parambitz != null)
        {
          localIntent.putExtra("widgetinfo", parambitz.getStringExtra("widgetinfo"));
          localIntent.putExtra("qqstory_slide_show_scene", parambitz.getIntExtra("qqstory_slide_show_scene", -1));
        }
        if ((!bgww.k.a(i)) && (!bgww.j.a(i))) {
          break label1057;
        }
        this.jdField_a_of_type_Bigb.jdField_a_of_type_Bihj.getActivity().startActivityForResult(localIntent, 21);
      }
      for (;;)
      {
        this.jdField_a_of_type_Bigb.jdField_a_of_type_Bigz.a(5, ((PublishParam)localObject2).jdField_a_of_type_Long);
        return;
        bool = false;
        break;
        label1057:
        this.jdField_a_of_type_Bigb.jdField_a_of_type_Bihj.getActivity().startActivityForResult(localIntent, 211);
      }
      label1080:
      parambitz = this.jdField_a_of_type_Bigb.jdField_b_of_type_JavaUtilList.iterator();
      while (parambitz.hasNext()) {
        urk.c("Q.qqstory.publish.edit.EditVideoPartManager", "publish error %s", (Error)parambitz.next());
      }
      bbmy.a(this.jdField_a_of_type_Bigb.jdField_a_of_type_Bihj.a(), this.jdField_a_of_type_Bigb.jdField_b_of_type_JavaUtilList.size() + ajjy.a(2131638078), 0).a();
      parambitz = (bigl)this.jdField_a_of_type_Bigb.a(bigl.class);
      if (parambitz == null) {
        break;
      }
      parambitz.l();
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
    urp.b("publish_story", "publish_saveToEntry", 0, -1, new String[] { paramError.getMessage() + "", String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) });
    this.jdField_a_of_type_Bigb.a(paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bigg
 * JD-Core Version:    0.7.0.1
 */