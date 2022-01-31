import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class bcox
  extends QQUIEventReceiver<bcov, armq>
{
  public bcox(@NonNull bcov parambcov)
  {
    super(parambcov);
  }
  
  public void a(@NonNull bcov parambcov, @NonNull armq paramarmq)
  {
    if (!TextUtils.equals(paramarmq.jdField_a_of_type_JavaLangString, "QGameApp")) {}
    String str;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QGameApp", 2, "receive event:" + paramarmq.toString());
      }
      str = (String)paramarmq.jdField_a_of_type_ArrayOfJavaLangObject[0];
      switch (paramarmq.jdField_a_of_type_Int)
      {
      default: 
        return;
      }
    } while (!TextUtils.equals(str, "ak:3214"));
    if (paramarmq.jdField_a_of_type_Boolean)
    {
      str = (String)paramarmq.jdField_a_of_type_ArrayOfJavaLangObject[3];
      if (TextUtils.isEmpty(str))
      {
        bcov.a(parambcov, 1002);
        return;
      }
      switch (((Integer)paramarmq.jdField_a_of_type_ArrayOfJavaLangObject[2]).intValue())
      {
      default: 
        return;
      case 1: 
        bcov.a(parambcov, true, str);
        return;
      case 2: 
        bcov.jdField_a_of_type_Boolean = false;
        return;
      }
      bcov.a(parambcov, false, str);
      return;
    }
    bcov.a(parambcov, 1002);
  }
  
  public Class acceptEventClass()
  {
    return armq.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bcox
 * JD-Core Version:    0.7.0.1
 */