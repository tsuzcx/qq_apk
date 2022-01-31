import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class bdsy
  extends QQUIEventReceiver<bdsw, asit>
{
  public bdsy(@NonNull bdsw parambdsw)
  {
    super(parambdsw);
  }
  
  public void a(@NonNull bdsw parambdsw, @NonNull asit paramasit)
  {
    if (!TextUtils.equals(paramasit.jdField_a_of_type_JavaLangString, "QGameApp")) {}
    String str;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QGameApp", 2, "receive event:" + paramasit.toString());
      }
      str = (String)paramasit.jdField_a_of_type_ArrayOfJavaLangObject[0];
      switch (paramasit.jdField_a_of_type_Int)
      {
      default: 
        return;
      }
    } while (!TextUtils.equals(str, "ak:3214"));
    if (paramasit.jdField_a_of_type_Boolean)
    {
      str = (String)paramasit.jdField_a_of_type_ArrayOfJavaLangObject[3];
      if (TextUtils.isEmpty(str))
      {
        bdsw.a(parambdsw, 1002);
        return;
      }
      switch (((Integer)paramasit.jdField_a_of_type_ArrayOfJavaLangObject[2]).intValue())
      {
      default: 
        return;
      case 1: 
        bdsw.a(parambdsw, true, str);
        return;
      case 2: 
        bdsw.jdField_a_of_type_Boolean = false;
        return;
      }
      bdsw.a(parambdsw, false, str);
      return;
    }
    bdsw.a(parambdsw, 1002);
  }
  
  public Class acceptEventClass()
  {
    return asit.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bdsy
 * JD-Core Version:    0.7.0.1
 */