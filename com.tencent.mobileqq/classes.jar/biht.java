import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditWebVideoActivity;
import java.util.Iterator;
import java.util.List;

class biht
  extends SimpleObserver<bitz>
{
  biht(bihs parambihs) {}
  
  public void a(bitz parambitz)
  {
    super.onNext(parambitz);
    this.a.jdField_a_of_type_Bihj.b();
    this.a.jdField_a_of_type_Bihj.getActivity().overridePendingTransition(0, 0);
    this.a.p();
    this.a.jdField_b_of_type_Boolean = false;
    Object localObject = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((bifz)((Iterator)localObject).next()).b(parambitz);
    }
    this.a.jdField_b_of_type_Boolean = false;
    this.a.jdField_a_of_type_Bihj.b();
    localObject = (bigl)this.a.a(bigl.class);
    if (localObject != null) {
      ((bigl)localObject).l();
    }
    if (this.a.jdField_b_of_type_JavaUtilList.isEmpty())
    {
      localObject = this.a.jdField_a_of_type_Bihj.getActivity();
      if (localObject != null)
      {
        ((EditWebVideoActivity)localObject).d(ajjy.a(2131638180));
        bihs.a(this.a, (Activity)localObject, this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a, parambitz.a);
      }
      return;
    }
    bbmy.a(this.a.jdField_a_of_type_Bihj.a(), ajjy.a(2131638176), 0).a();
    this.a.jdField_a_of_type_Bihj.getActivity().finish();
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
    bbmy.a(this.a.jdField_a_of_type_Bihj.a(), ajjy.a(2131638179), 0).a();
    this.a.jdField_a_of_type_Bihj.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biht
 * JD-Core Version:    0.7.0.1
 */