import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class bjfd
  extends QQUIEventReceiver<bjfb, awlo>
{
  public bjfd(@NonNull bjfb parambjfb)
  {
    super(parambjfb);
  }
  
  public void a(@NonNull bjfb parambjfb, @NonNull awlo paramawlo)
  {
    if (!TextUtils.equals(paramawlo.jdField_a_of_type_JavaLangString, "QGameApp")) {}
    String str;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QGameApp", 2, "receive event:" + paramawlo.toString());
      }
      str = (String)paramawlo.jdField_a_of_type_ArrayOfJavaLangObject[0];
      switch (paramawlo.jdField_a_of_type_Int)
      {
      default: 
        return;
      }
    } while (!TextUtils.equals(str, "ak:3214"));
    if (paramawlo.jdField_a_of_type_Boolean)
    {
      str = (String)paramawlo.jdField_a_of_type_ArrayOfJavaLangObject[3];
      if (TextUtils.isEmpty(str))
      {
        bjfb.a(parambjfb, 1002);
        return;
      }
      switch (((Integer)paramawlo.jdField_a_of_type_ArrayOfJavaLangObject[2]).intValue())
      {
      default: 
        return;
      case 1: 
        bjfb.a(parambjfb, true, str);
        return;
      case 2: 
        bjfb.jdField_a_of_type_Boolean = false;
        return;
      }
      bjfb.a(parambjfb, false, str);
      return;
    }
    bjfb.a(parambjfb, 1002);
  }
  
  public Class acceptEventClass()
  {
    return awlo.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjfd
 * JD-Core Version:    0.7.0.1
 */