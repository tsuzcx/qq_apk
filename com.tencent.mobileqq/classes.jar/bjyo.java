import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditWebVideoActivity;
import java.util.Iterator;
import java.util.List;

class bjyo
  extends SimpleObserver<bkkm>
{
  bjyo(bjyn parambjyn) {}
  
  public void a(bkkm parambkkm)
  {
    super.onNext(parambkkm);
    this.a.jdField_a_of_type_Bjye.b();
    this.a.jdField_a_of_type_Bjye.getActivity().overridePendingTransition(0, 0);
    this.a.p();
    this.a.jdField_b_of_type_Boolean = false;
    Object localObject = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((bjwu)((Iterator)localObject).next()).b(parambkkm);
    }
    this.a.jdField_b_of_type_Boolean = false;
    this.a.jdField_a_of_type_Bjye.b();
    localObject = (bjxg)this.a.a(bjxg.class);
    if (localObject != null) {
      ((bjxg)localObject).l();
    }
    if (this.a.jdField_b_of_type_JavaUtilList.isEmpty())
    {
      localObject = this.a.jdField_a_of_type_Bjye.getActivity();
      if (localObject != null)
      {
        ((EditWebVideoActivity)localObject).d(ajyc.a(2131703965));
        bjyn.a(this.a, (Activity)localObject, this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a, parambkkm.a);
      }
      return;
    }
    bcpw.a(this.a.jdField_a_of_type_Bjye.a(), ajyc.a(2131703961), 0).a();
    this.a.jdField_a_of_type_Bjye.getActivity().finish();
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
    bcpw.a(this.a.jdField_a_of_type_Bjye.a(), ajyc.a(2131703964), 0).a();
    this.a.jdField_a_of_type_Bjye.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjyo
 * JD-Core Version:    0.7.0.1
 */