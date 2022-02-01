import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import rx.functions.Action0;

class bbdx
  implements Action0
{
  bbdx(bbdu parambbdu, HashSet paramHashSet) {}
  
  public void call()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ResourceGrabViewModel", 2, "ResourceNameOnClickListener subscribe onComplete");
    }
    bbdu.a(this.jdField_a_of_type_Bbdu, this.jdField_a_of_type_JavaUtilHashSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbdx
 * JD-Core Version:    0.7.0.1
 */