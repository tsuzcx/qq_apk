import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;

class bjsy
  extends SimpleObserver<bkkm>
{
  bjsy(bjsx parambjsx) {}
  
  public void a(bkkm parambkkm)
  {
    super.onNext(parambkkm);
    this.a.jdField_a_of_type_Bjye.b();
    Activity localActivity = this.a.jdField_a_of_type_Bjye.getActivity();
    Intent localIntent;
    boolean bool;
    if ((localActivity != null) && (!localActivity.isFinishing()))
    {
      veg.b("EditPicActivity.EditPicPartManager", "picDestPath = " + parambkkm.a.b);
      localIntent = this.a.jdField_a_of_type_Bjye.a(parambkkm);
      if (!parambkkm.a.c)
      {
        if (parambkkm.a.c) {
          break label280;
        }
        bool = true;
        localIntent.putExtra("extra_is_edited_pic", bool);
      }
      this.a.b();
      veg.b("EditPicActivity.EditPicPartManager", "subBussinessId = " + this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b());
      if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a == 2) {
        switch (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b())
        {
        default: 
          if (parambkkm.a()) {
            bfmj.b(true, parambkkm.a.b);
          }
          break;
        }
      }
    }
    Object localObject;
    for (;;)
    {
      bjsx.a(this.a);
      localObject = localIntent.getStringExtra("PhotoConst.PLUGIN_APK");
      bool = localIntent.getBooleanExtra("DirectBackToQzone", false);
      if ((!"qzone_plugin.apk".equals(localObject)) || (!bool)) {
        break label320;
      }
      this.a.jdField_a_of_type_Bjye.a(-1, localIntent, 2130772028, 0);
      return;
      label280:
      bool = false;
      break;
      bfmj.b(true, parambkkm.a.b);
      continue;
      if (parambkkm.a()) {
        bfmj.a(parambkkm.a.b, true);
      }
    }
    label320:
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a == 1)
    {
      this.a.jdField_a_of_type_Bjye.a().sendBroadcast(new Intent("action_fire_create_story"));
      this.a.jdField_a_of_type_Bjye.a(-1, localIntent, 2130772028, 0, true);
      return;
    }
    if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a == 2) && ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c() == 122) || (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c() == 133)))
    {
      parambkkm = localIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      bjsx.a(this.a, localIntent);
      AIOLongShotHelper.a(localActivity, parambkkm, new bjsz(this));
      return;
    }
    if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a == 2) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c() == 125))
    {
      this.a.jdField_a_of_type_Bjye.a(-1, localIntent, 2130772028, 0, false);
      axqw.b(null, "dc00898", "", "", "0X800A188", "0X800A188", 0, 0, "", "", "", "");
      return;
    }
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a == 2)
    {
      localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams;
      if (EditVideoParams.a(this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c()))
      {
        bjsx.a(this.a, localIntent);
        axqw.b(null, "dc00898", "", "", "0X800A183", "0X800A183", 0, 0, "", "", "", "");
        return;
      }
    }
    if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a == 2) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.j()))
    {
      if (!parambkkm.a()) {}
      for (bool = true;; bool = false)
      {
        localIntent.putExtra("PhotoConst.SEND_ORIGIN", bool);
        this.a.jdField_a_of_type_Bjye.a(-1, localIntent, 2130772028, 0, false);
        return;
      }
    }
    this.a.a(localActivity, this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a(), localIntent);
  }
  
  public void onCancel()
  {
    super.onCancel();
    veg.d("EditPicActivity.EditPicPartManager", "PIC PUBLISH cancel !");
    this.a.jdField_a_of_type_Bjye.b();
    bcpw.a(this.a.jdField_a_of_type_Bjye.a(), ajyc.a(2131703676), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    this.a.a(paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjsy
 * JD-Core Version:    0.7.0.1
 */