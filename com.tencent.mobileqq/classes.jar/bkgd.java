import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class bkgd
  extends QQUIEventReceiver<bkgb, axeg>
{
  public bkgd(@NonNull bkgb parambkgb)
  {
    super(parambkgb);
  }
  
  public void a(@NonNull bkgb parambkgb, @NonNull axeg paramaxeg)
  {
    if (!TextUtils.equals(paramaxeg.jdField_a_of_type_JavaLangString, "QGameApp")) {}
    String str;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QGameApp", 2, "receive event:" + paramaxeg.toString());
      }
      str = (String)paramaxeg.jdField_a_of_type_ArrayOfJavaLangObject[0];
      switch (paramaxeg.jdField_a_of_type_Int)
      {
      default: 
        return;
      }
    } while (!TextUtils.equals(str, "ak:3214"));
    if (paramaxeg.jdField_a_of_type_Boolean)
    {
      str = (String)paramaxeg.jdField_a_of_type_ArrayOfJavaLangObject[3];
      if (TextUtils.isEmpty(str))
      {
        bkgb.a(parambkgb, 1002);
        return;
      }
      switch (((Integer)paramaxeg.jdField_a_of_type_ArrayOfJavaLangObject[2]).intValue())
      {
      default: 
        return;
      case 1: 
        bkgb.a(parambkgb, true, str);
        return;
      case 2: 
        bkgb.jdField_a_of_type_Boolean = false;
        return;
      }
      bkgb.a(parambkgb, false, str);
      return;
    }
    bkgb.a(parambkgb, 1002);
  }
  
  public Class acceptEventClass()
  {
    return axeg.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkgd
 * JD-Core Version:    0.7.0.1
 */