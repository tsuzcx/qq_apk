import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;

class bmjl
  extends SimpleObserver<bnaz>
{
  bmjl(bmjk parambmjk) {}
  
  public void a(bnaz parambnaz)
  {
    super.onNext(parambnaz);
    this.a.jdField_a_of_type_Bmor.b();
    Activity localActivity = this.a.jdField_a_of_type_Bmor.getActivity();
    Intent localIntent;
    boolean bool;
    if ((localActivity != null) && (!localActivity.isFinishing()))
    {
      wxe.b("EditPicActivity.EditPicPartManager", "picDestPath = " + parambnaz.a.b);
      localIntent = this.a.jdField_a_of_type_Bmor.a(parambnaz);
      if (!parambnaz.a.c)
      {
        if (parambnaz.a.c) {
          break label280;
        }
        bool = true;
        localIntent.putExtra("extra_is_edited_pic", bool);
      }
      this.a.b();
      wxe.b("EditPicActivity.EditPicPartManager", "subBussinessId = " + this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b());
      if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a == 2) {
        switch (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b())
        {
        default: 
          if (parambnaz.a()) {
            bhsb.b(true, parambnaz.a.b);
          }
          break;
        }
      }
    }
    Object localObject;
    for (;;)
    {
      bmjk.a(this.a);
      localObject = localIntent.getStringExtra("PhotoConst.PLUGIN_APK");
      bool = localIntent.getBooleanExtra("DirectBackToQzone", false);
      if ((!"qzone_plugin.apk".equals(localObject)) || (!bool)) {
        break label320;
      }
      this.a.jdField_a_of_type_Bmor.a(-1, localIntent, 2130772028, 0);
      return;
      label280:
      bool = false;
      break;
      bhsb.b(true, parambnaz.a.b);
      continue;
      if (parambnaz.a()) {
        bhsb.a(parambnaz.a.b, true);
      }
    }
    label320:
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a == 1)
    {
      this.a.jdField_a_of_type_Bmor.a().sendBroadcast(new Intent("action_fire_create_story"));
      this.a.jdField_a_of_type_Bmor.a(-1, localIntent, 2130772028, 0, true);
      return;
    }
    if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a == 2) && ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c() == 122) || (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c() == 133)))
    {
      parambnaz = localIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      bmjk.a(this.a, localIntent);
      AIOLongShotHelper.a(localActivity, parambnaz, new bmjm(this));
      return;
    }
    if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a == 2) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c() == 125))
    {
      this.a.jdField_a_of_type_Bmor.a(-1, localIntent, 2130772028, 0, false);
      azqs.b(null, "dc00898", "", "", "0X800A188", "0X800A188", 0, 0, "", "", "", "");
      return;
    }
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a == 2)
    {
      localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams;
      if (EditVideoParams.a(this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c()))
      {
        bmjk.a(this.a, localIntent);
        azqs.b(null, "dc00898", "", "", "0X800A183", "0X800A183", 0, 0, "", "", "", "");
        return;
      }
    }
    if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a == 2) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.j()))
    {
      if (!parambnaz.a()) {}
      for (bool = true;; bool = false)
      {
        localIntent.putExtra("PhotoConst.SEND_ORIGIN", bool);
        this.a.jdField_a_of_type_Bmor.a(-1, localIntent, 2130772028, 0, false);
        return;
      }
    }
    this.a.a(localActivity, this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a(), localIntent);
  }
  
  public void onCancel()
  {
    super.onCancel();
    wxe.d("EditPicActivity.EditPicPartManager", "PIC PUBLISH cancel !");
    this.a.jdField_a_of_type_Bmor.b();
    QQToast.a(this.a.jdField_a_of_type_Bmor.a(), alud.a(2131704071), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    this.a.a(paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmjl
 * JD-Core Version:    0.7.0.1
 */