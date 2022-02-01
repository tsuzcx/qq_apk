import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class bewi
  implements Callable<List<bbgl>>
{
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public bewi(bewh parambewh, Context paramContext, QQAppInterface paramQQAppInterface, long paramLong, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public List<bbgl> a()
  {
    long l = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    if (bbgl.E == this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Bewh.a = this.jdField_a_of_type_Bewh.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, true);
      localArrayList.addAll(this.jdField_a_of_type_Bewh.a);
      this.jdField_a_of_type_Bewh.b = this.jdField_a_of_type_Bewh.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
    }
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "CallableForSearchData time = " + (System.currentTimeMillis() - l));
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bewi
 * JD-Core Version:    0.7.0.1
 */