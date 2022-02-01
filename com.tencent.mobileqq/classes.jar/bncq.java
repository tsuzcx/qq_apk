import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;

class bncq
  extends SimpleObserver<bnot>
{
  bncq(bncp parambncp) {}
  
  public void a(bnot parambnot)
  {
    super.onNext(parambnot);
    this.a.jdField_a_of_type_Bnew.b();
    Activity localActivity = this.a.jdField_a_of_type_Bnew.getActivity();
    Intent localIntent;
    boolean bool;
    if ((localActivity != null) && (!localActivity.isFinishing()))
    {
      xvv.b("EditPicActivity.EditPicPartManager", "picDestPath = " + parambnot.a.b);
      localIntent = this.a.jdField_a_of_type_Bnew.a(parambnot);
      if (!parambnot.a.c)
      {
        if (parambnot.a.c) {
          break label280;
        }
        bool = true;
        localIntent.putExtra("extra_is_edited_pic", bool);
      }
      this.a.b();
      xvv.b("EditPicActivity.EditPicPartManager", "subBussinessId = " + this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b());
      if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a == 2) {
        switch (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b())
        {
        default: 
          if (parambnot.a()) {
            bjme.b(true, parambnot.a.b);
          }
          break;
        }
      }
    }
    Object localObject;
    for (;;)
    {
      bncp.a(this.a);
      localObject = localIntent.getStringExtra("PhotoConst.PLUGIN_APK");
      bool = localIntent.getBooleanExtra("DirectBackToQzone", false);
      if ((!"qzone_plugin.apk".equals(localObject)) || (!bool)) {
        break label320;
      }
      this.a.jdField_a_of_type_Bnew.a(-1, localIntent, 2130772030, 0);
      return;
      label280:
      bool = false;
      break;
      bjme.b(true, parambnot.a.b);
      continue;
      if (parambnot.a()) {
        bjme.a(parambnot.a.b, true);
      }
    }
    label320:
    if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a == 2) && ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c() == 122) || (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c() == 133)))
    {
      parambnot = localIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      bncp.a(this.a, localIntent);
      AIOLongShotHelper.a(localActivity, parambnot, new bncr(this));
      return;
    }
    if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a == 2) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c() == 125))
    {
      this.a.jdField_a_of_type_Bnew.a(-1, localIntent, 2130772030, 0, false);
      bcef.b(null, "dc00898", "", "", "0X800A188", "0X800A188", 0, 0, "", "", "", "");
      return;
    }
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a == 2)
    {
      localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams;
      if (EditVideoParams.a(this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c()))
      {
        bncp.a(this.a, localIntent);
        bcef.b(null, "dc00898", "", "", "0X800A183", "0X800A183", 0, 0, "", "", "", "");
        return;
      }
    }
    if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a == 2) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.h()))
    {
      if (!parambnot.a()) {}
      for (bool = true;; bool = false)
      {
        localIntent.putExtra("PhotoConst.SEND_ORIGIN", bool);
        this.a.jdField_a_of_type_Bnew.a(-1, localIntent, 2130772030, 0, false);
        return;
      }
    }
    if (localIntent.getBooleanExtra("input_full_screen_mode", false))
    {
      this.a.jdField_a_of_type_Bnew.a(-1, localIntent, 2130772030, 0, false);
      return;
    }
    this.a.a(localActivity, this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a(), localIntent);
  }
  
  public void onCancel()
  {
    super.onCancel();
    xvv.d("EditPicActivity.EditPicPartManager", "PIC PUBLISH cancel !");
    this.a.jdField_a_of_type_Bnew.b();
    QQToast.a(this.a.jdField_a_of_type_Bnew.a(), amtj.a(2131702810), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    this.a.a(paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bncq
 * JD-Core Version:    0.7.0.1
 */