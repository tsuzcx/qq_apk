import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class bjwn
  extends QQUIEventReceiver<bjwl, awxs>
{
  public bjwn(@NonNull bjwl parambjwl)
  {
    super(parambjwl);
  }
  
  public void a(@NonNull bjwl parambjwl, @NonNull awxs paramawxs)
  {
    if (!TextUtils.equals(paramawxs.jdField_a_of_type_JavaLangString, "QGameApp")) {}
    String str;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QGameApp", 2, "receive event:" + paramawxs.toString());
      }
      str = (String)paramawxs.jdField_a_of_type_ArrayOfJavaLangObject[0];
      switch (paramawxs.jdField_a_of_type_Int)
      {
      default: 
        return;
      }
    } while (!TextUtils.equals(str, "ak:3214"));
    if (paramawxs.jdField_a_of_type_Boolean)
    {
      str = (String)paramawxs.jdField_a_of_type_ArrayOfJavaLangObject[3];
      if (TextUtils.isEmpty(str))
      {
        bjwl.a(parambjwl, 1002);
        return;
      }
      switch (((Integer)paramawxs.jdField_a_of_type_ArrayOfJavaLangObject[2]).intValue())
      {
      default: 
        return;
      case 1: 
        bjwl.a(parambjwl, true, str);
        return;
      case 2: 
        bjwl.jdField_a_of_type_Boolean = false;
        return;
      }
      bjwl.a(parambjwl, false, str);
      return;
    }
    bjwl.a(parambjwl, 1002);
  }
  
  public Class acceptEventClass()
  {
    return awxs.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjwn
 * JD-Core Version:    0.7.0.1
 */