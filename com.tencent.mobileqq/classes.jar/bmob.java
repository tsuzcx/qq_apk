import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity;

class bmob
  extends SimpleObserver<bnaz>
{
  bmob(bmnz parambmnz, bnaz parambnaz) {}
  
  public void a(bnaz parambnaz)
  {
    super.onNext(parambnaz);
    this.jdField_a_of_type_Bmnz.a(5);
    parambnaz = this.jdField_a_of_type_Bnaz.a;
    wxe.b("EditVideoSave", "publishParam = " + parambnaz);
    Intent localIntent1;
    int j;
    int i;
    if (this.jdField_a_of_type_Bmnz.jdField_a_of_type_Bmor.getActivity() != null)
    {
      localIntent1 = this.jdField_a_of_type_Bmnz.jdField_a_of_type_Bmor.getActivity().getIntent();
      if (localIntent1 == null) {
        break label318;
      }
      j = localIntent1.getIntExtra("sv_total_frame_count", 0);
      i = localIntent1.getIntExtra("sv_total_record_time", 0);
    }
    for (;;)
    {
      Intent localIntent2 = SaveVideoActivity.a(this.jdField_a_of_type_Bmnz.jdField_a_of_type_Bmor.a(), parambnaz.b, i, j, this.jdField_a_of_type_Bmnz.jdField_a_of_type_Bmnj.a.a());
      bmnz.a(this.jdField_a_of_type_Bmnz, parambnaz.b);
      localIntent2.putExtra("mediacodec_encode_enable", true);
      boolean bool;
      if (parambnaz.e != 0)
      {
        bool = true;
        localIntent2.putExtra("video_edit_flag", bool);
        if (localIntent1 != null) {
          localIntent2.putExtra("qqstory_slide_show_scene", localIntent1.getIntExtra("qqstory_slide_show_scene", -1));
        }
        if (this.jdField_a_of_type_Bmnz.jdField_a_of_type_Int != 47) {
          break label296;
        }
        this.jdField_a_of_type_Bmnz.jdField_a_of_type_Bmor.getActivity().startActivityForResult(localIntent2, 222);
      }
      for (;;)
      {
        this.jdField_a_of_type_Bmnz.jdField_a_of_type_Float = 5.0F;
        this.jdField_a_of_type_Bmnz.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Bmnz.b = (50000.0F / (float)parambnaz.a);
        if (this.jdField_a_of_type_Bmnz.b == 0.0F) {
          this.jdField_a_of_type_Bmnz.b = 1.0F;
        }
        this.jdField_a_of_type_Bmnz.d();
        return;
        bool = false;
        break;
        label296:
        this.jdField_a_of_type_Bmnz.jdField_a_of_type_Bmor.getActivity().startActivityForResult(localIntent2, 111);
      }
      label318:
      i = 0;
      j = 0;
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    wxe.d("EditVideoSave", "saveVideo cancel !");
    this.jdField_a_of_type_Bmnz.jdField_a_of_type_Bmnj.a(0);
    this.jdField_a_of_type_Bmnz.j();
    QQToast.a(this.jdField_a_of_type_Bmnz.jdField_a_of_type_Bmor.a(), alud.a(2131704219), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    wxe.e("EditVideoSave", "saveVideo error ：" + paramError);
    this.jdField_a_of_type_Bmnz.jdField_a_of_type_Bmnj.a(0);
    QQToast.a(this.jdField_a_of_type_Bmnz.jdField_a_of_type_Bmor.a(), 1, alud.a(2131704128) + paramError, 0).a();
    this.jdField_a_of_type_Bmnz.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmob
 * JD-Core Version:    0.7.0.1
 */