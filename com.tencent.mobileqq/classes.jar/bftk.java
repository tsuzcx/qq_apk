import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class bftk
  extends QQUIEventReceiver<bfti, atzv>
{
  public bftk(@NonNull bfti parambfti)
  {
    super(parambfti);
  }
  
  public void a(@NonNull bfti parambfti, @NonNull atzv paramatzv)
  {
    if (!TextUtils.equals(paramatzv.jdField_a_of_type_JavaLangString, "QGameApp")) {}
    String str;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QGameApp", 2, "receive event:" + paramatzv.toString());
      }
      str = (String)paramatzv.jdField_a_of_type_ArrayOfJavaLangObject[0];
      switch (paramatzv.jdField_a_of_type_Int)
      {
      default: 
        return;
      }
    } while (!TextUtils.equals(str, "ak:3214"));
    if (paramatzv.jdField_a_of_type_Boolean)
    {
      str = (String)paramatzv.jdField_a_of_type_ArrayOfJavaLangObject[3];
      if (TextUtils.isEmpty(str))
      {
        bfti.a(parambfti, 1002);
        return;
      }
      switch (((Integer)paramatzv.jdField_a_of_type_ArrayOfJavaLangObject[2]).intValue())
      {
      default: 
        return;
      case 1: 
        bfti.a(parambfti, true, str);
        return;
      case 2: 
        bfti.jdField_a_of_type_Boolean = false;
        return;
      }
      bfti.a(parambfti, false, str);
      return;
    }
    bfti.a(parambfti, 1002);
  }
  
  public Class acceptEventClass()
  {
    return atzv.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bftk
 * JD-Core Version:    0.7.0.1
 */