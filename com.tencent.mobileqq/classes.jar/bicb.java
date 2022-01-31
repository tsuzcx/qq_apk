import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;

class bicb
  extends SimpleObserver<bitz>
{
  bicb(bica parambica) {}
  
  public void a(bitz parambitz)
  {
    super.onNext(parambitz);
    this.a.jdField_a_of_type_Bihj.b();
    Activity localActivity = this.a.jdField_a_of_type_Bihj.getActivity();
    Intent localIntent;
    boolean bool;
    if ((localActivity != null) && (!localActivity.isFinishing()))
    {
      urk.b("EditPicActivity.EditPicPartManager", "picDestPath = " + parambitz.a.b);
      localIntent = this.a.jdField_a_of_type_Bihj.a(parambitz);
      if (!parambitz.a.c)
      {
        if (parambitz.a.c) {
          break label278;
        }
        bool = true;
        localIntent.putExtra("extra_is_edited_pic", bool);
      }
      this.a.b();
      urk.b("EditPicActivity.EditPicPartManager", "subBussinessId = " + this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b());
      if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a == 2) {
        switch (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b())
        {
        default: 
          if (parambitz.a()) {
            beep.b(true, parambitz.a.b);
          }
          break;
        }
      }
    }
    for (;;)
    {
      bica.a(this.a);
      parambitz = localIntent.getStringExtra("PhotoConst.PLUGIN_APK");
      bool = localIntent.getBooleanExtra("DirectBackToQzone", false);
      if ((!"qzone_plugin.apk".equals(parambitz)) || (!bool)) {
        break label318;
      }
      this.a.jdField_a_of_type_Bihj.a(-1, localIntent, 2130772028, 0);
      return;
      label278:
      bool = false;
      break;
      beep.b(true, parambitz.a.b);
      continue;
      if (parambitz.a()) {
        beep.a(parambitz.a.b, true);
      }
    }
    label318:
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a == 1)
    {
      this.a.jdField_a_of_type_Bihj.a().sendBroadcast(new Intent("action_fire_create_story"));
      this.a.jdField_a_of_type_Bihj.a(-1, localIntent, 2130772028, 0, true);
      return;
    }
    if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a == 2) && ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c() == 122) || (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c() == 133)))
    {
      parambitz = localIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      bica.a(this.a, localIntent);
      AIOLongShotHelper.a(localActivity, parambitz, new bicc(this));
      return;
    }
    if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a == 2) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c() == 125))
    {
      this.a.jdField_a_of_type_Bihj.a(-1, localIntent, 2130772028, 0, false);
      awqx.b(null, "dc00898", "", "", "0X800A188", "0X800A188", 0, 0, "", "", "", "");
      return;
    }
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a == 2)
    {
      parambitz = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams;
      if (EditVideoParams.a(this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c()))
      {
        bica.a(this.a, localIntent);
        awqx.b(null, "dc00898", "", "", "0X800A183", "0X800A183", 0, 0, "", "", "", "");
        return;
      }
    }
    if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a == 2) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.j()))
    {
      this.a.jdField_a_of_type_Bihj.a(-1, localIntent, 2130772028, 0, false);
      return;
    }
    this.a.a(localActivity, this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a(), localIntent);
  }
  
  public void onCancel()
  {
    super.onCancel();
    urk.d("EditPicActivity.EditPicPartManager", "PIC PUBLISH cancel !");
    this.a.jdField_a_of_type_Bihj.b();
    bbmy.a(this.a.jdField_a_of_type_Bihj.a(), ajjy.a(2131637891), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    this.a.a(paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bicb
 * JD-Core Version:    0.7.0.1
 */