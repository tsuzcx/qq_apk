import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditWebVideoActivity;
import java.util.Iterator;
import java.util.List;

class bnez
  extends SimpleObserver<bnot>
{
  bnez(bney parambney) {}
  
  public void a(bnot parambnot)
  {
    super.onNext(parambnot);
    this.a.jdField_a_of_type_Bnew.b();
    this.a.jdField_a_of_type_Bnew.getActivity().overridePendingTransition(0, 0);
    this.a.n();
    this.a.jdField_b_of_type_Boolean = false;
    Object localObject = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((bnec)((Iterator)localObject).next()).b(parambnot);
    }
    this.a.jdField_b_of_type_Boolean = false;
    this.a.jdField_a_of_type_Bnew.b();
    localObject = (bnel)this.a.a(bnel.class);
    if (localObject != null) {
      ((bnel)localObject).aE_();
    }
    if (this.a.jdField_b_of_type_JavaUtilList.isEmpty())
    {
      localObject = this.a.jdField_a_of_type_Bnew.getActivity();
      if (localObject != null)
      {
        ((EditWebVideoActivity)localObject).a(amtj.a(2131703094));
        bney.a(this.a, (Activity)localObject, this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a, parambnot.a);
      }
      return;
    }
    QQToast.a(this.a.jdField_a_of_type_Bnew.a(), amtj.a(2131703090), 0).a();
    this.a.jdField_a_of_type_Bnew.getActivity().finish();
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
    QQToast.a(this.a.jdField_a_of_type_Bnew.a(), amtj.a(2131703093), 0).a();
    this.a.jdField_a_of_type_Bnew.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnez
 * JD-Core Version:    0.7.0.1
 */