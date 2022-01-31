import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class bdtp
  extends QQUIEventReceiver<bdtn, asiv>
{
  public bdtp(@NonNull bdtn parambdtn)
  {
    super(parambdtn);
  }
  
  public void a(@NonNull bdtn parambdtn, @NonNull asiv paramasiv)
  {
    if (!TextUtils.equals(paramasiv.jdField_a_of_type_JavaLangString, "QGameApp")) {}
    String str;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QGameApp", 2, "receive event:" + paramasiv.toString());
      }
      str = (String)paramasiv.jdField_a_of_type_ArrayOfJavaLangObject[0];
      switch (paramasiv.jdField_a_of_type_Int)
      {
      default: 
        return;
      }
    } while (!TextUtils.equals(str, "ak:3214"));
    if (paramasiv.jdField_a_of_type_Boolean)
    {
      str = (String)paramasiv.jdField_a_of_type_ArrayOfJavaLangObject[3];
      if (TextUtils.isEmpty(str))
      {
        bdtn.a(parambdtn, 1002);
        return;
      }
      switch (((Integer)paramasiv.jdField_a_of_type_ArrayOfJavaLangObject[2]).intValue())
      {
      default: 
        return;
      case 1: 
        bdtn.a(parambdtn, true, str);
        return;
      case 2: 
        bdtn.jdField_a_of_type_Boolean = false;
        return;
      }
      bdtn.a(parambdtn, false, str);
      return;
    }
    bdtn.a(parambdtn, 1002);
  }
  
  public Class acceptEventClass()
  {
    return asiv.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bdtp
 * JD-Core Version:    0.7.0.1
 */