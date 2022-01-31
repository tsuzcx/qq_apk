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

class bjxb
  extends SimpleObserver<bkkm>
{
  bjxb(bjww parambjww, long paramLong) {}
  
  public void a(bkkm parambkkm)
  {
    boolean bool = true;
    super.onNext(parambkkm);
    this.jdField_a_of_type_Bjww.p();
    this.jdField_a_of_type_Bjww.jdField_b_of_type_Boolean = false;
    veg.e("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH onNext");
    Object localObject1 = this.jdField_a_of_type_Bjww.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((bjwu)((Iterator)localObject1).next()).b(parambkkm);
    }
    int i;
    if ((parambkkm.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource)) {
      i = 1;
    }
    for (;;)
    {
      vel.b("edit_video", "publish_cost", 0, 0, new String[] { String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long), String.valueOf(i) });
      vel.b("publish_story", "publish_saveToEntry", 0, 0, new String[] { "", String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) });
      if (bjww.a(this.jdField_a_of_type_Bjww, parambkkm)) {
        bjww.a(this.jdField_a_of_type_Bjww);
      }
      if (this.jdField_a_of_type_Bjww.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() <= 0) {
        break;
      }
      veg.d("Q.qqstory.publish.edit.EditVideoPartManager", "waiting for another observer finish");
      return;
      if ((parambkkm.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)) {
        i = 2;
      } else if ((parambkkm.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) {
        i = 3;
      } else if ((parambkkm.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource)) {
        i = 4;
      } else if ((parambkkm.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) {
        i = 5;
      } else {
        i = 0;
      }
    }
    if ((bjww.a(this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Long, 262144)) && (bjww.b(this.jdField_a_of_type_Bjww) > 0))
    {
      i = bjww.b(this.jdField_a_of_type_Bjww);
      if (!this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d()) {
        break label475;
      }
    }
    Object localObject2;
    label475:
    for (localObject1 = "0";; localObject1 = "1")
    {
      vel.a("video_edit", "pub_edit_one", 0, 0, new String[] { String.valueOf(i), localObject1 });
      this.jdField_a_of_type_Bjww.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Bjww.jdField_a_of_type_Bjye.b();
      if (!this.jdField_a_of_type_Bjww.jdField_b_of_type_JavaUtilList.isEmpty()) {
        break label1080;
      }
      localObject1 = this.jdField_a_of_type_Bjww.jdField_a_of_type_Bjye.getActivity();
      if (localObject1 == null) {
        break;
      }
      if (!(this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalGifSource)) {
        break label506;
      }
      parambkkm = this.jdField_a_of_type_Bjww.jdField_a_of_type_Bjye.a(parambkkm);
      localObject2 = parambkkm.getStringExtra("PhotoConst.PLUGIN_APK");
      bool = parambkkm.getBooleanExtra("DirectBackToQzone", false);
      if ((!"qzone_plugin.apk".equals(localObject2)) || (!bool)) {
        break label482;
      }
      bgxy.a((Activity)localObject1, "", parambkkm, -1);
      this.jdField_a_of_type_Bjww.jdField_a_of_type_Bjye.a(-1, null, 2130772028, 0);
      return;
    }
    label482:
    ((Activity)localObject1).startActivity(parambkkm);
    this.jdField_a_of_type_Bjww.jdField_a_of_type_Bjye.a(-1, null, 2130772028, 0);
    return;
    label506:
    if (this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 1) {
      this.jdField_a_of_type_Bjww.jdField_a_of_type_Bjye.a().sendBroadcast(new Intent("action_fire_create_story"));
    }
    do
    {
      do
      {
        for (;;)
        {
          localObject1 = parambkkm.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam;
          veg.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishParam = " + localObject1);
          localObject2 = this.jdField_a_of_type_Bjww.jdField_a_of_type_Bjye.a(parambkkm);
          this.jdField_a_of_type_Bjww.a((Intent)localObject2, this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a(), (PublishParam)localObject1, parambkkm.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams);
          return;
          if (this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 14)
          {
            veg.b("Q.qqstory.publish.edit.EditVideoPartManager", "Q.videostory.publish.upload[peak process]  sendBroadcast notify publish start(to read info from db)");
            localObject1 = this.jdField_a_of_type_Bjww.jdField_a_of_type_Bjye.getActivity().getIntent();
            if ((!birc.a((Intent)localObject1)) || (birc.e((Intent)localObject1)) || (birc.d((Intent)localObject1))) {
              break;
            }
            this.jdField_a_of_type_Bjww.jdField_a_of_type_Bjye.a().sendBroadcast(new Intent("action_fire_create_video_story"));
          }
        }
      } while (this.jdField_a_of_type_Bjww.jdField_a_of_type_Bjxu == null);
      this.jdField_a_of_type_Bjww.jdField_a_of_type_Bjxu.a(ajyc.a(2131703747), false, 0);
      this.jdField_a_of_type_Bjww.jdField_a_of_type_Bjxu.a(2);
      this.jdField_a_of_type_Bjww.jdField_a_of_type_Bjxu.a(5);
      localObject2 = parambkkm.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam;
      veg.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishParam = " + localObject2);
    } while (this.jdField_a_of_type_Bjww.jdField_a_of_type_Bjye.getActivity() == null);
    parambkkm = this.jdField_a_of_type_Bjww.jdField_a_of_type_Bjye.getActivity().getIntent();
    int j;
    if (parambkkm != null)
    {
      j = parambkkm.getIntExtra("sv_total_frame_count", 0);
      i = parambkkm.getIntExtra("sv_total_record_time", 0);
    }
    for (;;)
    {
      Intent localIntent = SaveVideoActivity.a(this.jdField_a_of_type_Bjww.jdField_a_of_type_Bjye.a(), ((PublishParam)localObject2).b, i, j, this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a());
      this.jdField_a_of_type_Bjww.jdField_a_of_type_Bjxu.a(((PublishParam)localObject2).b);
      i = ((Intent)localObject1).getIntExtra("VIDEO_STORY_FROM_TYPE", birc.a.a());
      localIntent.putExtra("mediacodec_encode_enable", true);
      if (((PublishParam)localObject2).e != 0)
      {
        localIntent.putExtra("video_edit_flag", bool);
        localIntent.putExtra("thumbfile_send_path", ((PublishParam)localObject2).c);
        localIntent.putExtra("VIDEO_STORY_FROM_TYPE", i);
        if (parambkkm != null)
        {
          localIntent.putExtra("widgetinfo", parambkkm.getStringExtra("widgetinfo"));
          localIntent.putExtra("qqstory_slide_show_scene", parambkkm.getIntExtra("qqstory_slide_show_scene", -1));
        }
        if ((!birc.l.a(i)) && (!birc.k.a(i))) {
          break label1057;
        }
        this.jdField_a_of_type_Bjww.jdField_a_of_type_Bjye.getActivity().startActivityForResult(localIntent, 21);
      }
      for (;;)
      {
        this.jdField_a_of_type_Bjww.jdField_a_of_type_Bjxu.a(5, ((PublishParam)localObject2).jdField_a_of_type_Long);
        return;
        bool = false;
        break;
        label1057:
        this.jdField_a_of_type_Bjww.jdField_a_of_type_Bjye.getActivity().startActivityForResult(localIntent, 211);
      }
      label1080:
      parambkkm = this.jdField_a_of_type_Bjww.jdField_b_of_type_JavaUtilList.iterator();
      while (parambkkm.hasNext()) {
        veg.c("Q.qqstory.publish.edit.EditVideoPartManager", "publish error %s", (Error)parambkkm.next());
      }
      bcpw.a(this.jdField_a_of_type_Bjww.jdField_a_of_type_Bjye.a(), this.jdField_a_of_type_Bjww.jdField_b_of_type_JavaUtilList.size() + ajyc.a(2131703863), 0).a();
      parambkkm = (bjxg)this.jdField_a_of_type_Bjww.a(bjxg.class);
      if (parambkkm == null) {
        break;
      }
      parambkkm.l();
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
    vel.b("publish_story", "publish_saveToEntry", 0, -1, new String[] { paramError.getMessage() + "", String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) });
    this.jdField_a_of_type_Bjww.a(paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjxb
 * JD-Core Version:    0.7.0.1
 */