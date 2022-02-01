import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity;

class bneq
  extends SimpleObserver<bnot>
{
  bneq(bneo parambneo, bnot parambnot) {}
  
  public void a(bnot parambnot)
  {
    super.onNext(parambnot);
    this.jdField_a_of_type_Bneo.a(5);
    parambnot = this.jdField_a_of_type_Bnot.a;
    xvv.b("EditVideoSave", "publishParam = " + parambnot);
    Intent localIntent1;
    int j;
    int i;
    if (this.jdField_a_of_type_Bneo.jdField_a_of_type_Bnew.getActivity() != null)
    {
      localIntent1 = this.jdField_a_of_type_Bneo.jdField_a_of_type_Bnew.getActivity().getIntent();
      if (localIntent1 == null) {
        break label318;
      }
      j = localIntent1.getIntExtra("sv_total_frame_count", 0);
      i = localIntent1.getIntExtra("sv_total_record_time", 0);
    }
    for (;;)
    {
      Intent localIntent2 = SaveVideoActivity.a(this.jdField_a_of_type_Bneo.jdField_a_of_type_Bnew.a(), parambnot.b, i, j, this.jdField_a_of_type_Bneo.jdField_a_of_type_Bnee.a.a());
      bneo.a(this.jdField_a_of_type_Bneo, parambnot.b);
      localIntent2.putExtra("mediacodec_encode_enable", true);
      boolean bool;
      if (parambnot.e != 0)
      {
        bool = true;
        localIntent2.putExtra("video_edit_flag", bool);
        if (localIntent1 != null) {
          localIntent2.putExtra("qqstory_slide_show_scene", localIntent1.getIntExtra("qqstory_slide_show_scene", -1));
        }
        if (this.jdField_a_of_type_Bneo.jdField_a_of_type_Int != 19) {
          break label296;
        }
        this.jdField_a_of_type_Bneo.jdField_a_of_type_Bnew.getActivity().startActivityForResult(localIntent2, 222);
      }
      for (;;)
      {
        this.jdField_a_of_type_Bneo.jdField_a_of_type_Float = 5.0F;
        this.jdField_a_of_type_Bneo.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Bneo.b = (50000.0F / (float)parambnot.a);
        if (this.jdField_a_of_type_Bneo.b == 0.0F) {
          this.jdField_a_of_type_Bneo.b = 1.0F;
        }
        this.jdField_a_of_type_Bneo.b();
        return;
        bool = false;
        break;
        label296:
        this.jdField_a_of_type_Bneo.jdField_a_of_type_Bnew.getActivity().startActivityForResult(localIntent2, 111);
      }
      label318:
      i = 0;
      j = 0;
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    xvv.d("EditVideoSave", "saveVideo cancel !");
    this.jdField_a_of_type_Bneo.jdField_a_of_type_Bnee.a(0);
    this.jdField_a_of_type_Bneo.c();
    QQToast.a(this.jdField_a_of_type_Bneo.jdField_a_of_type_Bnew.a(), amtj.a(2131702955), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    xvv.e("EditVideoSave", "saveVideo error ：" + paramError);
    this.jdField_a_of_type_Bneo.jdField_a_of_type_Bnee.a(0);
    QQToast.a(this.jdField_a_of_type_Bneo.jdField_a_of_type_Bnew.a(), 1, amtj.a(2131702867) + paramError, 0).a();
    this.jdField_a_of_type_Bneo.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bneq
 * JD-Core Version:    0.7.0.1
 */