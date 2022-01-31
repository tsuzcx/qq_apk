import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity;

class bjxn
  extends SimpleObserver<bkkm>
{
  bjxn(bjxm parambjxm, bkkm parambkkm) {}
  
  public void a(bkkm parambkkm)
  {
    super.onNext(parambkkm);
    this.jdField_a_of_type_Bjxm.a(5);
    parambkkm = this.jdField_a_of_type_Bkkm.a;
    veg.b("EditVideoSave", "publishParam = " + parambkkm);
    Intent localIntent;
    int j;
    int i;
    if (this.jdField_a_of_type_Bjxm.jdField_a_of_type_Bjye.getActivity() != null)
    {
      localIntent = this.jdField_a_of_type_Bjxm.jdField_a_of_type_Bjye.getActivity().getIntent();
      if (localIntent == null) {
        break label292;
      }
      j = localIntent.getIntExtra("sv_total_frame_count", 0);
      i = localIntent.getIntExtra("sv_total_record_time", 0);
    }
    for (;;)
    {
      localIntent = SaveVideoActivity.a(this.jdField_a_of_type_Bjxm.jdField_a_of_type_Bjye.a(), parambkkm.b, i, j, this.jdField_a_of_type_Bjxm.jdField_a_of_type_Bjww.a.a());
      boolean bool;
      if (parambkkm.e != 0)
      {
        bool = true;
        localIntent.putExtra("video_edit_flag", bool);
        bjxm.a(this.jdField_a_of_type_Bjxm, parambkkm.b);
        if (this.jdField_a_of_type_Bjxm.jdField_a_of_type_Int != 47) {
          break label260;
        }
        localIntent.putExtra("requestCode", 222);
        this.jdField_a_of_type_Bjxm.jdField_a_of_type_Bjye.getActivity().startActivityForResult(localIntent, 222);
      }
      for (;;)
      {
        this.jdField_a_of_type_Bjxm.jdField_a_of_type_Float = 5.0F;
        this.jdField_a_of_type_Bjxm.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Bjxm.b = (7000.0F / (float)parambkkm.a * 4.0F);
        this.jdField_a_of_type_Bjxm.d();
        return;
        bool = false;
        break;
        label260:
        localIntent.putExtra("requestCode", 111);
        this.jdField_a_of_type_Bjxm.jdField_a_of_type_Bjye.getActivity().startActivityForResult(localIntent, 111);
      }
      label292:
      i = 0;
      j = 0;
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    veg.d("EditVideoSave", "saveVideo cancel !");
    this.jdField_a_of_type_Bjxm.jdField_a_of_type_Bjww.a(0);
    this.jdField_a_of_type_Bjxm.j();
    bcpw.a(this.jdField_a_of_type_Bjxm.jdField_a_of_type_Bjye.a(), ajyc.a(2131703778), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    veg.e("EditVideoSave", "saveVideo error ：" + paramError);
    this.jdField_a_of_type_Bjxm.jdField_a_of_type_Bjww.a(0);
    bcpw.a(this.jdField_a_of_type_Bjxm.jdField_a_of_type_Bjye.a(), 1, ajyc.a(2131703741) + paramError, 0).a();
    this.jdField_a_of_type_Bjxm.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjxn
 * JD-Core Version:    0.7.0.1
 */