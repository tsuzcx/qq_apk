import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditWebVideoActivity;
import java.util.Iterator;
import java.util.List;

class bqic
  extends SimpleObserver<bqua>
{
  bqic(bqib parambqib) {}
  
  public void a(bqua parambqua)
  {
    super.onNext(parambqua);
    this.a.jdField_a_of_type_Bqhs.b();
    this.a.jdField_a_of_type_Bqhs.getActivity().overridePendingTransition(0, 0);
    this.a.p();
    this.a.jdField_b_of_type_Boolean = false;
    Object localObject = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((bqgi)((Iterator)localObject).next()).b(parambqua);
    }
    this.a.jdField_b_of_type_Boolean = false;
    this.a.jdField_a_of_type_Bqhs.b();
    localObject = (bqgu)this.a.a(bqgu.class);
    if (localObject != null) {
      ((bqgu)localObject).l();
    }
    if (this.a.jdField_b_of_type_JavaUtilList.isEmpty())
    {
      localObject = this.a.jdField_a_of_type_Bqhs.getActivity();
      if (localObject != null)
      {
        ((EditWebVideoActivity)localObject).d(anzj.a(2131702864));
        bqib.a(this.a, (Activity)localObject, this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a, parambqua.a);
      }
      return;
    }
    QQToast.a(this.a.jdField_a_of_type_Bqhs.a(), anzj.a(2131702860), 0).a();
    this.a.jdField_a_of_type_Bqhs.getActivity().finish();
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
    QQToast.a(this.a.jdField_a_of_type_Bqhs.a(), anzj.a(2131702863), 0).a();
    this.a.jdField_a_of_type_Bqhs.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqic
 * JD-Core Version:    0.7.0.1
 */