import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import rx.functions.Action1;

class balc
  implements Action1<baky>
{
  balc(balb parambalb, HashSet paramHashSet) {}
  
  public void a(baky parambaky)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ResourceGrabViewModel", 2, "ResourceNameOnClickListener subscribe call :" + parambaky);
    }
    if (TextUtils.equals(parambaky.a, "text_color"))
    {
      balb.a(this.jdField_a_of_type_Balb, parambaky, this.jdField_a_of_type_JavaUtilHashSet);
      return;
    }
    balb.b(this.jdField_a_of_type_Balb, parambaky, this.jdField_a_of_type_JavaUtilHashSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     balc
 * JD-Core Version:    0.7.0.1
 */