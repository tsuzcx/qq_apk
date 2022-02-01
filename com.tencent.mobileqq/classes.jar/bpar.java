import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;

class bpar
  extends SimpleObserver<bpsf>
{
  bpar(bpaq parambpaq) {}
  
  public void a(bpsf parambpsf)
  {
    super.onNext(parambpsf);
    this.a.jdField_a_of_type_Bpfx.b();
    Activity localActivity = this.a.jdField_a_of_type_Bpfx.getActivity();
    Intent localIntent;
    boolean bool;
    if ((localActivity != null) && (!localActivity.isFinishing()))
    {
      yqp.b("EditPicActivity.EditPicPartManager", "picDestPath = " + parambpsf.a.b);
      localIntent = this.a.jdField_a_of_type_Bpfx.a(parambpsf);
      if (!parambpsf.a.c)
      {
        if (parambpsf.a.c) {
          break label280;
        }
        bool = true;
        localIntent.putExtra("extra_is_edited_pic", bool);
      }
      this.a.b();
      yqp.b("EditPicActivity.EditPicPartManager", "subBussinessId = " + this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b());
      if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a == 2) {
        switch (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b())
        {
        default: 
          if (parambpsf.a()) {
            bkfl.b(true, parambpsf.a.b);
          }
          break;
        }
      }
    }
    Object localObject;
    for (;;)
    {
      bpaq.a(this.a);
      localObject = localIntent.getStringExtra("PhotoConst.PLUGIN_APK");
      bool = localIntent.getBooleanExtra("DirectBackToQzone", false);
      if ((!"qzone_plugin.apk".equals(localObject)) || (!bool)) {
        break label320;
      }
      this.a.jdField_a_of_type_Bpfx.a(-1, localIntent, 2130772029, 0);
      return;
      label280:
      bool = false;
      break;
      bkfl.b(true, parambpsf.a.b);
      continue;
      if (parambpsf.a()) {
        bkfl.a(parambpsf.a.b, true);
      }
    }
    label320:
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a == 1)
    {
      this.a.jdField_a_of_type_Bpfx.a().sendBroadcast(new Intent("action_fire_create_story"));
      this.a.jdField_a_of_type_Bpfx.a(-1, localIntent, 2130772029, 0, true);
      return;
    }
    if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a == 2) && ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c() == 122) || (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c() == 133)))
    {
      parambpsf = localIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      bpaq.a(this.a, localIntent);
      AIOLongShotHelper.a(localActivity, parambpsf, new bpas(this));
      return;
    }
    if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a == 2) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c() == 125))
    {
      this.a.jdField_a_of_type_Bpfx.a(-1, localIntent, 2130772029, 0, false);
      bcst.b(null, "dc00898", "", "", "0X800A188", "0X800A188", 0, 0, "", "", "", "");
      return;
    }
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a == 2)
    {
      localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams;
      if (EditVideoParams.a(this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c()))
      {
        bpaq.a(this.a, localIntent);
        bcst.b(null, "dc00898", "", "", "0X800A183", "0X800A183", 0, 0, "", "", "", "");
        return;
      }
    }
    if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a == 2) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.j()))
    {
      if (!parambpsf.a()) {}
      for (bool = true;; bool = false)
      {
        localIntent.putExtra("PhotoConst.SEND_ORIGIN", bool);
        this.a.jdField_a_of_type_Bpfx.a(-1, localIntent, 2130772029, 0, false);
        return;
      }
    }
    if (localIntent.getBooleanExtra("input_full_screen_mode", false))
    {
      this.a.jdField_a_of_type_Bpfx.a(-1, localIntent, 2130772029, 0, false);
      return;
    }
    this.a.a(localActivity, this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a(), localIntent);
  }
  
  public void onCancel()
  {
    super.onCancel();
    yqp.d("EditPicActivity.EditPicPartManager", "PIC PUBLISH cancel !");
    this.a.jdField_a_of_type_Bpfx.b();
    QQToast.a(this.a.jdField_a_of_type_Bpfx.a(), anni.a(2131702468), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    this.a.a(paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpar
 * JD-Core Version:    0.7.0.1
 */