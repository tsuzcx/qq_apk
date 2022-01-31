import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditWebVideoActivity;
import java.util.Iterator;
import java.util.List;

class bmpb
  extends SimpleObserver<bnaz>
{
  bmpb(bmpa parambmpa) {}
  
  public void a(bnaz parambnaz)
  {
    super.onNext(parambnaz);
    this.a.jdField_a_of_type_Bmor.b();
    this.a.jdField_a_of_type_Bmor.getActivity().overridePendingTransition(0, 0);
    this.a.p();
    this.a.jdField_b_of_type_Boolean = false;
    Object localObject = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((bmnh)((Iterator)localObject).next()).b(parambnaz);
    }
    this.a.jdField_b_of_type_Boolean = false;
    this.a.jdField_a_of_type_Bmor.b();
    localObject = (bmnt)this.a.a(bmnt.class);
    if (localObject != null) {
      ((bmnt)localObject).l();
    }
    if (this.a.jdField_b_of_type_JavaUtilList.isEmpty())
    {
      localObject = this.a.jdField_a_of_type_Bmor.getActivity();
      if (localObject != null)
      {
        ((EditWebVideoActivity)localObject).d(alud.a(2131704360));
        bmpa.a(this.a, (Activity)localObject, this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a, parambnaz.a);
      }
      return;
    }
    QQToast.a(this.a.jdField_a_of_type_Bmor.a(), alud.a(2131704356), 0).a();
    this.a.jdField_a_of_type_Bmor.getActivity().finish();
  }
  
  public void onCancel()
  {
    super.onCancel();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    this.a.jdField_b_of_type_JavaUtilList.add(paramError);
    if (QLog.isColorLevel()) {
      QLog.e("EditWebVideoActivity", 2, "publish error:", paramError);
    }
    QQToast.a(this.a.jdField_a_of_type_Bmor.a(), alud.a(2131704359), 0).a();
    this.a.jdField_a_of_type_Bmor.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmpb
 * JD-Core Version:    0.7.0.1
 */