import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class bill
  extends QQUIEventReceiver<bilj, avrn>
{
  public bill(@NonNull bilj parambilj)
  {
    super(parambilj);
  }
  
  public void a(@NonNull bilj parambilj, @NonNull avrn paramavrn)
  {
    if (!TextUtils.equals(paramavrn.jdField_a_of_type_JavaLangString, "QGameApp")) {}
    String str;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QGameApp", 2, "receive event:" + paramavrn.toString());
      }
      str = (String)paramavrn.jdField_a_of_type_ArrayOfJavaLangObject[0];
      switch (paramavrn.jdField_a_of_type_Int)
      {
      default: 
        return;
      }
    } while (!TextUtils.equals(str, "ak:3214"));
    if (paramavrn.jdField_a_of_type_Boolean)
    {
      str = (String)paramavrn.jdField_a_of_type_ArrayOfJavaLangObject[3];
      if (TextUtils.isEmpty(str))
      {
        bilj.a(parambilj, 1002);
        return;
      }
      switch (((Integer)paramavrn.jdField_a_of_type_ArrayOfJavaLangObject[2]).intValue())
      {
      default: 
        return;
      case 1: 
        bilj.a(parambilj, true, str);
        return;
      case 2: 
        bilj.jdField_a_of_type_Boolean = false;
        return;
      }
      bilj.a(parambilj, false, str);
      return;
    }
    bilj.a(parambilj, 1002);
  }
  
  public Class acceptEventClass()
  {
    return avrn.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bill
 * JD-Core Version:    0.7.0.1
 */