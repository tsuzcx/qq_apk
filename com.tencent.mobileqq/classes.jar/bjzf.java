import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditWebVideoActivity;
import java.util.Iterator;
import java.util.List;

class bjzf
  extends SimpleObserver<bkld>
{
  bjzf(bjze parambjze) {}
  
  public void a(bkld parambkld)
  {
    super.onNext(parambkld);
    this.a.jdField_a_of_type_Bjyv.b();
    this.a.jdField_a_of_type_Bjyv.getActivity().overridePendingTransition(0, 0);
    this.a.p();
    this.a.jdField_b_of_type_Boolean = false;
    Object localObject = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((bjxl)((Iterator)localObject).next()).b(parambkld);
    }
    this.a.jdField_b_of_type_Boolean = false;
    this.a.jdField_a_of_type_Bjyv.b();
    localObject = (bjxx)this.a.a(bjxx.class);
    if (localObject != null) {
      ((bjxx)localObject).l();
    }
    if (this.a.jdField_b_of_type_JavaUtilList.isEmpty())
    {
      localObject = this.a.jdField_a_of_type_Bjyv.getActivity();
      if (localObject != null)
      {
        ((EditWebVideoActivity)localObject).d(ajya.a(2131703976));
        bjze.a(this.a, (Activity)localObject, this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a, parambkld.a);
      }
      return;
    }
    bcql.a(this.a.jdField_a_of_type_Bjyv.a(), ajya.a(2131703972), 0).a();
    this.a.jdField_a_of_type_Bjyv.getActivity().finish();
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
    bcql.a(this.a.jdField_a_of_type_Bjyv.a(), ajya.a(2131703975), 0).a();
    this.a.jdField_a_of_type_Bjyv.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjzf
 * JD-Core Version:    0.7.0.1
 */