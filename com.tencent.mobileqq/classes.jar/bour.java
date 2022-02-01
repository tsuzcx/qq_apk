import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditWebVideoActivity;
import java.util.Iterator;
import java.util.List;

class bour
  extends SimpleObserver<bpel>
{
  bour(bouq parambouq) {}
  
  public void a(bpel parambpel)
  {
    super.onNext(parambpel);
    this.a.jdField_a_of_type_Bouo.b();
    this.a.jdField_a_of_type_Bouo.getActivity().overridePendingTransition(0, 0);
    this.a.n();
    this.a.jdField_b_of_type_Boolean = false;
    Object localObject = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((botu)((Iterator)localObject).next()).b(parambpel);
    }
    this.a.jdField_b_of_type_Boolean = false;
    this.a.jdField_a_of_type_Bouo.b();
    localObject = (boud)this.a.a(boud.class);
    if (localObject != null) {
      ((boud)localObject).aG_();
    }
    if (this.a.jdField_b_of_type_JavaUtilList.isEmpty())
    {
      localObject = this.a.jdField_a_of_type_Bouo.getActivity();
      if (localObject != null)
      {
        ((EditWebVideoActivity)localObject).a(anvx.a(2131703445));
        bouq.a(this.a, (Activity)localObject, this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a, parambpel.a);
      }
      return;
    }
    QQToast.a(this.a.jdField_a_of_type_Bouo.a(), anvx.a(2131703441), 0).a();
    this.a.jdField_a_of_type_Bouo.getActivity().finish();
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
    QQToast.a(this.a.jdField_a_of_type_Bouo.a(), anvx.a(2131703444), 0).a();
    this.a.jdField_a_of_type_Bouo.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bour
 * JD-Core Version:    0.7.0.1
 */