import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity;

class bjye
  extends SimpleObserver<bkld>
{
  bjye(bjyd parambjyd, bkld parambkld) {}
  
  public void a(bkld parambkld)
  {
    super.onNext(parambkld);
    this.jdField_a_of_type_Bjyd.a(5);
    parambkld = this.jdField_a_of_type_Bkld.a;
    ved.b("EditVideoSave", "publishParam = " + parambkld);
    Intent localIntent;
    int j;
    int i;
    if (this.jdField_a_of_type_Bjyd.jdField_a_of_type_Bjyv.getActivity() != null)
    {
      localIntent = this.jdField_a_of_type_Bjyd.jdField_a_of_type_Bjyv.getActivity().getIntent();
      if (localIntent == null) {
        break label292;
      }
      j = localIntent.getIntExtra("sv_total_frame_count", 0);
      i = localIntent.getIntExtra("sv_total_record_time", 0);
    }
    for (;;)
    {
      localIntent = SaveVideoActivity.a(this.jdField_a_of_type_Bjyd.jdField_a_of_type_Bjyv.a(), parambkld.b, i, j, this.jdField_a_of_type_Bjyd.jdField_a_of_type_Bjxn.a.a());
      boolean bool;
      if (parambkld.e != 0)
      {
        bool = true;
        localIntent.putExtra("video_edit_flag", bool);
        bjyd.a(this.jdField_a_of_type_Bjyd, parambkld.b);
        if (this.jdField_a_of_type_Bjyd.jdField_a_of_type_Int != 47) {
          break label260;
        }
        localIntent.putExtra("requestCode", 222);
        this.jdField_a_of_type_Bjyd.jdField_a_of_type_Bjyv.getActivity().startActivityForResult(localIntent, 222);
      }
      for (;;)
      {
        this.jdField_a_of_type_Bjyd.jdField_a_of_type_Float = 5.0F;
        this.jdField_a_of_type_Bjyd.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Bjyd.b = (7000.0F / (float)parambkld.a * 4.0F);
        this.jdField_a_of_type_Bjyd.d();
        return;
        bool = false;
        break;
        label260:
        localIntent.putExtra("requestCode", 111);
        this.jdField_a_of_type_Bjyd.jdField_a_of_type_Bjyv.getActivity().startActivityForResult(localIntent, 111);
      }
      label292:
      i = 0;
      j = 0;
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    ved.d("EditVideoSave", "saveVideo cancel !");
    this.jdField_a_of_type_Bjyd.jdField_a_of_type_Bjxn.a(0);
    this.jdField_a_of_type_Bjyd.j();
    bcql.a(this.jdField_a_of_type_Bjyd.jdField_a_of_type_Bjyv.a(), ajya.a(2131703789), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    ved.e("EditVideoSave", "saveVideo error ：" + paramError);
    this.jdField_a_of_type_Bjyd.jdField_a_of_type_Bjxn.a(0);
    bcql.a(this.jdField_a_of_type_Bjyd.jdField_a_of_type_Bjyv.a(), 1, ajya.a(2131703752) + paramError, 0).a();
    this.jdField_a_of_type_Bjyd.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjye
 * JD-Core Version:    0.7.0.1
 */