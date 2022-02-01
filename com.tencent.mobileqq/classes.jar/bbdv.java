import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import rx.functions.Action1;

class bbdv
  implements Action1<bbdr>
{
  bbdv(bbdu parambbdu, HashSet paramHashSet) {}
  
  public void a(bbdr parambbdr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ResourceGrabViewModel", 2, "ResourceNameOnClickListener subscribe call :" + parambbdr);
    }
    if (TextUtils.equals(parambbdr.a, "text_color"))
    {
      bbdu.a(this.jdField_a_of_type_Bbdu, parambbdr, this.jdField_a_of_type_JavaUtilHashSet);
      return;
    }
    bbdu.b(this.jdField_a_of_type_Bbdu, parambbdr, this.jdField_a_of_type_JavaUtilHashSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbdv
 * JD-Core Version:    0.7.0.1
 */