import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity;

class bmjp
  extends SimpleObserver<bmwn>
{
  bmjp(bmjn parambmjn, bmwn parambmwn) {}
  
  public void a(bmwn parambmwn)
  {
    super.onNext(parambmwn);
    this.jdField_a_of_type_Bmjn.a(5);
    parambmwn = this.jdField_a_of_type_Bmwn.a;
    wsv.b("EditVideoSave", "publishParam = " + parambmwn);
    Intent localIntent1;
    int j;
    int i;
    if (this.jdField_a_of_type_Bmjn.jdField_a_of_type_Bmkf.getActivity() != null)
    {
      localIntent1 = this.jdField_a_of_type_Bmjn.jdField_a_of_type_Bmkf.getActivity().getIntent();
      if (localIntent1 == null) {
        break label318;
      }
      j = localIntent1.getIntExtra("sv_total_frame_count", 0);
      i = localIntent1.getIntExtra("sv_total_record_time", 0);
    }
    for (;;)
    {
      Intent localIntent2 = SaveVideoActivity.a(this.jdField_a_of_type_Bmjn.jdField_a_of_type_Bmkf.a(), parambmwn.b, i, j, this.jdField_a_of_type_Bmjn.jdField_a_of_type_Bmix.a.a());
      bmjn.a(this.jdField_a_of_type_Bmjn, parambmwn.b);
      localIntent2.putExtra("mediacodec_encode_enable", true);
      boolean bool;
      if (parambmwn.e != 0)
      {
        bool = true;
        localIntent2.putExtra("video_edit_flag", bool);
        if (localIntent1 != null) {
          localIntent2.putExtra("qqstory_slide_show_scene", localIntent1.getIntExtra("qqstory_slide_show_scene", -1));
        }
        if (this.jdField_a_of_type_Bmjn.jdField_a_of_type_Int != 47) {
          break label296;
        }
        this.jdField_a_of_type_Bmjn.jdField_a_of_type_Bmkf.getActivity().startActivityForResult(localIntent2, 222);
      }
      for (;;)
      {
        this.jdField_a_of_type_Bmjn.jdField_a_of_type_Float = 5.0F;
        this.jdField_a_of_type_Bmjn.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Bmjn.b = (50000.0F / (float)parambmwn.a);
        if (this.jdField_a_of_type_Bmjn.b == 0.0F) {
          this.jdField_a_of_type_Bmjn.b = 1.0F;
        }
        this.jdField_a_of_type_Bmjn.d();
        return;
        bool = false;
        break;
        label296:
        this.jdField_a_of_type_Bmjn.jdField_a_of_type_Bmkf.getActivity().startActivityForResult(localIntent2, 111);
      }
      label318:
      i = 0;
      j = 0;
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    wsv.d("EditVideoSave", "saveVideo cancel !");
    this.jdField_a_of_type_Bmjn.jdField_a_of_type_Bmix.a(0);
    this.jdField_a_of_type_Bmjn.j();
    QQToast.a(this.jdField_a_of_type_Bmjn.jdField_a_of_type_Bmkf.a(), alpo.a(2131704207), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    wsv.e("EditVideoSave", "saveVideo error ：" + paramError);
    this.jdField_a_of_type_Bmjn.jdField_a_of_type_Bmix.a(0);
    QQToast.a(this.jdField_a_of_type_Bmjn.jdField_a_of_type_Bmkf.a(), 1, alpo.a(2131704116) + paramError, 0).a();
    this.jdField_a_of_type_Bmjn.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmjp
 * JD-Core Version:    0.7.0.1
 */