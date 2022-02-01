import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditWebVideoActivity;
import java.util.Iterator;
import java.util.List;

class bpgh
  extends SimpleObserver<bpsf>
{
  bpgh(bpgg parambpgg) {}
  
  public void a(bpsf parambpsf)
  {
    super.onNext(parambpsf);
    this.a.jdField_a_of_type_Bpfx.b();
    this.a.jdField_a_of_type_Bpfx.getActivity().overridePendingTransition(0, 0);
    this.a.p();
    this.a.jdField_b_of_type_Boolean = false;
    Object localObject = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((bpen)((Iterator)localObject).next()).b(parambpsf);
    }
    this.a.jdField_b_of_type_Boolean = false;
    this.a.jdField_a_of_type_Bpfx.b();
    localObject = (bpez)this.a.a(bpez.class);
    if (localObject != null) {
      ((bpez)localObject).l();
    }
    if (this.a.jdField_b_of_type_JavaUtilList.isEmpty())
    {
      localObject = this.a.jdField_a_of_type_Bpfx.getActivity();
      if (localObject != null)
      {
        ((EditWebVideoActivity)localObject).d(anni.a(2131702757));
        bpgg.a(this.a, (Activity)localObject, this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a, parambpsf.a);
      }
      return;
    }
    QQToast.a(this.a.jdField_a_of_type_Bpfx.a(), anni.a(2131702753), 0).a();
    this.a.jdField_a_of_type_Bpfx.getActivity().finish();
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
    QQToast.a(this.a.jdField_a_of_type_Bpfx.a(), anni.a(2131702756), 0).a();
    this.a.jdField_a_of_type_Bpfx.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpgh
 * JD-Core Version:    0.7.0.1
 */