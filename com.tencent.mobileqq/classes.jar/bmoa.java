import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity;

class bmoa
  extends SimpleObserver<bnaz>
{
  bmoa(bmnz parambmnz, bnaz parambnaz) {}
  
  public void a(bnaz parambnaz)
  {
    super.onNext(parambnaz);
    this.jdField_a_of_type_Bmnz.a(5);
    parambnaz = this.jdField_a_of_type_Bnaz.a;
    wxe.b("EditVideoSave", "publishParam = " + parambnaz);
    Intent localIntent;
    int j;
    int i;
    if (this.jdField_a_of_type_Bmnz.jdField_a_of_type_Bmor.getActivity() != null)
    {
      localIntent = this.jdField_a_of_type_Bmnz.jdField_a_of_type_Bmor.getActivity().getIntent();
      if (localIntent == null) {
        break label292;
      }
      j = localIntent.getIntExtra("sv_total_frame_count", 0);
      i = localIntent.getIntExtra("sv_total_record_time", 0);
    }
    for (;;)
    {
      localIntent = SaveVideoActivity.a(this.jdField_a_of_type_Bmnz.jdField_a_of_type_Bmor.a(), parambnaz.b, i, j, this.jdField_a_of_type_Bmnz.jdField_a_of_type_Bmnj.a.a());
      boolean bool;
      if (parambnaz.e != 0)
      {
        bool = true;
        localIntent.putExtra("video_edit_flag", bool);
        bmnz.a(this.jdField_a_of_type_Bmnz, parambnaz.b);
        if (this.jdField_a_of_type_Bmnz.jdField_a_of_type_Int != 47) {
          break label260;
        }
        localIntent.putExtra("requestCode", 222);
        this.jdField_a_of_type_Bmnz.jdField_a_of_type_Bmor.getActivity().startActivityForResult(localIntent, 222);
      }
      for (;;)
      {
        this.jdField_a_of_type_Bmnz.jdField_a_of_type_Float = 5.0F;
        this.jdField_a_of_type_Bmnz.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Bmnz.b = (7000.0F / (float)parambnaz.a * 4.0F);
        this.jdField_a_of_type_Bmnz.d();
        return;
        bool = false;
        break;
        label260:
        localIntent.putExtra("requestCode", 111);
        this.jdField_a_of_type_Bmnz.jdField_a_of_type_Bmor.getActivity().startActivityForResult(localIntent, 111);
      }
      label292:
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
    QQToast.a(this.jdField_a_of_type_Bmnz.jdField_a_of_type_Bmor.a(), alud.a(2131704173), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    wxe.e("EditVideoSave", "saveVideo error ：" + paramError);
    this.jdField_a_of_type_Bmnz.jdField_a_of_type_Bmnj.a(0);
    QQToast.a(this.jdField_a_of_type_Bmnz.jdField_a_of_type_Bmor.a(), 1, alud.a(2131704136) + paramError, 0).a();
    this.jdField_a_of_type_Bmnz.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmoa
 * JD-Core Version:    0.7.0.1
 */