import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditWebVideoActivity;
import java.util.Iterator;
import java.util.List;

class bmkp
  extends SimpleObserver<bmwn>
{
  bmkp(bmko parambmko) {}
  
  public void a(bmwn parambmwn)
  {
    super.onNext(parambmwn);
    this.a.jdField_a_of_type_Bmkf.b();
    this.a.jdField_a_of_type_Bmkf.getActivity().overridePendingTransition(0, 0);
    this.a.p();
    this.a.jdField_b_of_type_Boolean = false;
    Object localObject = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((bmiv)((Iterator)localObject).next()).b(parambmwn);
    }
    this.a.jdField_b_of_type_Boolean = false;
    this.a.jdField_a_of_type_Bmkf.b();
    localObject = (bmjh)this.a.a(bmjh.class);
    if (localObject != null) {
      ((bmjh)localObject).l();
    }
    if (this.a.jdField_b_of_type_JavaUtilList.isEmpty())
    {
      localObject = this.a.jdField_a_of_type_Bmkf.getActivity();
      if (localObject != null)
      {
        ((EditWebVideoActivity)localObject).d(alpo.a(2131704348));
        bmko.a(this.a, (Activity)localObject, this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a, parambmwn.a);
      }
      return;
    }
    QQToast.a(this.a.jdField_a_of_type_Bmkf.a(), alpo.a(2131704344), 0).a();
    this.a.jdField_a_of_type_Bmkf.getActivity().finish();
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
    QQToast.a(this.a.jdField_a_of_type_Bmkf.a(), alpo.a(2131704347), 0).a();
    this.a.jdField_a_of_type_Bmkf.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmkp
 * JD-Core Version:    0.7.0.1
 */