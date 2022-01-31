import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class bfxr
  extends QQUIEventReceiver<bfxp, auee>
{
  public bfxr(@NonNull bfxp parambfxp)
  {
    super(parambfxp);
  }
  
  public void a(@NonNull bfxp parambfxp, @NonNull auee paramauee)
  {
    if (!TextUtils.equals(paramauee.jdField_a_of_type_JavaLangString, "QGameApp")) {}
    String str;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QGameApp", 2, "receive event:" + paramauee.toString());
      }
      str = (String)paramauee.jdField_a_of_type_ArrayOfJavaLangObject[0];
      switch (paramauee.jdField_a_of_type_Int)
      {
      default: 
        return;
      }
    } while (!TextUtils.equals(str, "ak:3214"));
    if (paramauee.jdField_a_of_type_Boolean)
    {
      str = (String)paramauee.jdField_a_of_type_ArrayOfJavaLangObject[3];
      if (TextUtils.isEmpty(str))
      {
        bfxp.a(parambfxp, 1002);
        return;
      }
      switch (((Integer)paramauee.jdField_a_of_type_ArrayOfJavaLangObject[2]).intValue())
      {
      default: 
        return;
      case 1: 
        bfxp.a(parambfxp, true, str);
        return;
      case 2: 
        bfxp.jdField_a_of_type_Boolean = false;
        return;
      }
      bfxp.a(parambfxp, false, str);
      return;
    }
    bfxp.a(parambfxp, 1002);
  }
  
  public Class acceptEventClass()
  {
    return auee.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfxr
 * JD-Core Version:    0.7.0.1
 */