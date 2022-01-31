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

class bjxs
  extends SimpleObserver<bkld>
{
  bjxs(bjxn parambjxn, long paramLong) {}
  
  public void a(bkld parambkld)
  {
    boolean bool = true;
    super.onNext(parambkld);
    this.jdField_a_of_type_Bjxn.p();
    this.jdField_a_of_type_Bjxn.jdField_b_of_type_Boolean = false;
    ved.e("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH onNext");
    Object localObject1 = this.jdField_a_of_type_Bjxn.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((bjxl)((Iterator)localObject1).next()).b(parambkld);
    }
    int i;
    if ((parambkld.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource)) {
      i = 1;
    }
    for (;;)
    {
      vei.b("edit_video", "publish_cost", 0, 0, new String[] { String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long), String.valueOf(i) });
      vei.b("publish_story", "publish_saveToEntry", 0, 0, new String[] { "", String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) });
      if (bjxn.a(this.jdField_a_of_type_Bjxn, parambkld)) {
        bjxn.a(this.jdField_a_of_type_Bjxn);
      }
      if (this.jdField_a_of_type_Bjxn.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() <= 0) {
        break;
      }
      ved.d("Q.qqstory.publish.edit.EditVideoPartManager", "waiting for another observer finish");
      return;
      if ((parambkld.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)) {
        i = 2;
      } else if ((parambkld.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) {
        i = 3;
      } else if ((parambkld.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource)) {
        i = 4;
      } else if ((parambkld.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) {
        i = 5;
      } else {
        i = 0;
      }
    }
    if ((bjxn.a(this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Long, 262144)) && (bjxn.b(this.jdField_a_of_type_Bjxn) > 0))
    {
      i = bjxn.b(this.jdField_a_of_type_Bjxn);
      if (!this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d()) {
        break label475;
      }
    }
    Object localObject2;
    label475:
    for (localObject1 = "0";; localObject1 = "1")
    {
      vei.a("video_edit", "pub_edit_one", 0, 0, new String[] { String.valueOf(i), localObject1 });
      this.jdField_a_of_type_Bjxn.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Bjxn.jdField_a_of_type_Bjyv.b();
      if (!this.jdField_a_of_type_Bjxn.jdField_b_of_type_JavaUtilList.isEmpty()) {
        break label1080;
      }
      localObject1 = this.jdField_a_of_type_Bjxn.jdField_a_of_type_Bjyv.getActivity();
      if (localObject1 == null) {
        break;
      }
      if (!(this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalGifSource)) {
        break label506;
      }
      parambkld = this.jdField_a_of_type_Bjxn.jdField_a_of_type_Bjyv.a(parambkld);
      localObject2 = parambkld.getStringExtra("PhotoConst.PLUGIN_APK");
      bool = parambkld.getBooleanExtra("DirectBackToQzone", false);
      if ((!"qzone_plugin.apk".equals(localObject2)) || (!bool)) {
        break label482;
      }
      bgyp.a((Activity)localObject1, "", parambkld, -1);
      this.jdField_a_of_type_Bjxn.jdField_a_of_type_Bjyv.a(-1, null, 2130772028, 0);
      return;
    }
    label482:
    ((Activity)localObject1).startActivity(parambkld);
    this.jdField_a_of_type_Bjxn.jdField_a_of_type_Bjyv.a(-1, null, 2130772028, 0);
    return;
    label506:
    if (this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 1) {
      this.jdField_a_of_type_Bjxn.jdField_a_of_type_Bjyv.a().sendBroadcast(new Intent("action_fire_create_story"));
    }
    do
    {
      do
      {
        for (;;)
        {
          localObject1 = parambkld.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam;
          ved.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishParam = " + localObject1);
          localObject2 = this.jdField_a_of_type_Bjxn.jdField_a_of_type_Bjyv.a(parambkld);
          this.jdField_a_of_type_Bjxn.a((Intent)localObject2, this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a(), (PublishParam)localObject1, parambkld.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams);
          return;
          if (this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 14)
          {
            ved.b("Q.qqstory.publish.edit.EditVideoPartManager", "Q.videostory.publish.upload[peak process]  sendBroadcast notify publish start(to read info from db)");
            localObject1 = this.jdField_a_of_type_Bjxn.jdField_a_of_type_Bjyv.getActivity().getIntent();
            if ((!birt.a((Intent)localObject1)) || (birt.e((Intent)localObject1)) || (birt.d((Intent)localObject1))) {
              break;
            }
            this.jdField_a_of_type_Bjxn.jdField_a_of_type_Bjyv.a().sendBroadcast(new Intent("action_fire_create_video_story"));
          }
        }
      } while (this.jdField_a_of_type_Bjxn.jdField_a_of_type_Bjyl == null);
      this.jdField_a_of_type_Bjxn.jdField_a_of_type_Bjyl.a(ajya.a(2131703758), false, 0);
      this.jdField_a_of_type_Bjxn.jdField_a_of_type_Bjyl.a(2);
      this.jdField_a_of_type_Bjxn.jdField_a_of_type_Bjyl.a(5);
      localObject2 = parambkld.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam;
      ved.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishParam = " + localObject2);
    } while (this.jdField_a_of_type_Bjxn.jdField_a_of_type_Bjyv.getActivity() == null);
    parambkld = this.jdField_a_of_type_Bjxn.jdField_a_of_type_Bjyv.getActivity().getIntent();
    int j;
    if (parambkld != null)
    {
      j = parambkld.getIntExtra("sv_total_frame_count", 0);
      i = parambkld.getIntExtra("sv_total_record_time", 0);
    }
    for (;;)
    {
      Intent localIntent = SaveVideoActivity.a(this.jdField_a_of_type_Bjxn.jdField_a_of_type_Bjyv.a(), ((PublishParam)localObject2).b, i, j, this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a());
      this.jdField_a_of_type_Bjxn.jdField_a_of_type_Bjyl.a(((PublishParam)localObject2).b);
      i = ((Intent)localObject1).getIntExtra("VIDEO_STORY_FROM_TYPE", birt.a.a());
      localIntent.putExtra("mediacodec_encode_enable", true);
      if (((PublishParam)localObject2).e != 0)
      {
        localIntent.putExtra("video_edit_flag", bool);
        localIntent.putExtra("thumbfile_send_path", ((PublishParam)localObject2).c);
        localIntent.putExtra("VIDEO_STORY_FROM_TYPE", i);
        if (parambkld != null)
        {
          localIntent.putExtra("widgetinfo", parambkld.getStringExtra("widgetinfo"));
          localIntent.putExtra("qqstory_slide_show_scene", parambkld.getIntExtra("qqstory_slide_show_scene", -1));
        }
        if ((!birt.l.a(i)) && (!birt.k.a(i))) {
          break label1057;
        }
        this.jdField_a_of_type_Bjxn.jdField_a_of_type_Bjyv.getActivity().startActivityForResult(localIntent, 21);
      }
      for (;;)
      {
        this.jdField_a_of_type_Bjxn.jdField_a_of_type_Bjyl.a(5, ((PublishParam)localObject2).jdField_a_of_type_Long);
        return;
        bool = false;
        break;
        label1057:
        this.jdField_a_of_type_Bjxn.jdField_a_of_type_Bjyv.getActivity().startActivityForResult(localIntent, 211);
      }
      label1080:
      parambkld = this.jdField_a_of_type_Bjxn.jdField_b_of_type_JavaUtilList.iterator();
      while (parambkld.hasNext()) {
        ved.c("Q.qqstory.publish.edit.EditVideoPartManager", "publish error %s", (Error)parambkld.next());
      }
      bcql.a(this.jdField_a_of_type_Bjxn.jdField_a_of_type_Bjyv.a(), this.jdField_a_of_type_Bjxn.jdField_b_of_type_JavaUtilList.size() + ajya.a(2131703874), 0).a();
      parambkld = (bjxx)this.jdField_a_of_type_Bjxn.a(bjxx.class);
      if (parambkld == null) {
        break;
      }
      parambkld.l();
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
    vei.b("publish_story", "publish_saveToEntry", 0, -1, new String[] { paramError.getMessage() + "", String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) });
    this.jdField_a_of_type_Bjxn.a(paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjxs
 * JD-Core Version:    0.7.0.1
 */