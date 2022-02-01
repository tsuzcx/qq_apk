import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;

class bosi
  extends SimpleObserver<bpel>
{
  bosi(bosh parambosh) {}
  
  public void a(bpel parambpel)
  {
    super.onNext(parambpel);
    this.a.jdField_a_of_type_Bouo.b();
    Activity localActivity = this.a.jdField_a_of_type_Bouo.getActivity();
    Intent localIntent;
    boolean bool;
    if ((localActivity != null) && (!localActivity.isFinishing()))
    {
      ykq.b("EditPicActivity.EditPicPartManager", "picDestPath = " + parambpel.a.b);
      localIntent = this.a.jdField_a_of_type_Bouo.a(parambpel);
      if (!parambpel.a.c)
      {
        if (parambpel.a.c) {
          break label280;
        }
        bool = true;
        localIntent.putExtra("extra_is_edited_pic", bool);
      }
      this.a.b();
      ykq.b("EditPicActivity.EditPicPartManager", "subBussinessId = " + this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b());
      if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a == 2) {
        switch (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b())
        {
        default: 
          if (parambpel.a()) {
            bkxr.b(true, parambpel.a.b);
          }
          break;
        }
      }
    }
    Object localObject;
    for (;;)
    {
      bosh.a(this.a);
      localObject = localIntent.getStringExtra("PhotoConst.PLUGIN_APK");
      bool = localIntent.getBooleanExtra("DirectBackToQzone", false);
      if ((!"qzone_plugin.apk".equals(localObject)) || (!bool)) {
        break label320;
      }
      this.a.jdField_a_of_type_Bouo.a(-1, localIntent, 2130772030, 0);
      return;
      label280:
      bool = false;
      break;
      bkxr.b(true, parambpel.a.b);
      continue;
      if (parambpel.a()) {
        bkxr.a(parambpel.a.b, true);
      }
    }
    label320:
    if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a == 2) && ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c() == 122) || (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c() == 133)))
    {
      parambpel = localIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      bosh.a(this.a, localIntent);
      AIOLongShotHelper.a(localActivity, parambpel, new bosj(this));
      return;
    }
    if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a == 2) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c() == 125))
    {
      this.a.jdField_a_of_type_Bouo.a(-1, localIntent, 2130772030, 0, false);
      bdla.b(null, "dc00898", "", "", "0X800A188", "0X800A188", 0, 0, "", "", "", "");
      return;
    }
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a == 2)
    {
      localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams;
      if (EditVideoParams.a(this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c()))
      {
        bosh.a(this.a, localIntent);
        bdla.b(null, "dc00898", "", "", "0X800A183", "0X800A183", 0, 0, "", "", "", "");
        return;
      }
    }
    if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a == 2) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.h()))
    {
      if (!parambpel.a()) {}
      for (bool = true;; bool = false)
      {
        localIntent.putExtra("PhotoConst.SEND_ORIGIN", bool);
        this.a.jdField_a_of_type_Bouo.a(-1, localIntent, 2130772030, 0, false);
        return;
      }
    }
    if (localIntent.getBooleanExtra("input_full_screen_mode", false))
    {
      this.a.jdField_a_of_type_Bouo.a(-1, localIntent, 2130772030, 0, false);
      return;
    }
    this.a.a(localActivity, this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a(), localIntent);
  }
  
  public void onCancel()
  {
    super.onCancel();
    ykq.d("EditPicActivity.EditPicPartManager", "PIC PUBLISH cancel !");
    this.a.jdField_a_of_type_Bouo.b();
    QQToast.a(this.a.jdField_a_of_type_Bouo.a(), anvx.a(2131703161), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    this.a.a(paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bosi
 * JD-Core Version:    0.7.0.1
 */