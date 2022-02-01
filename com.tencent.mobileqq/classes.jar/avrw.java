import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.miniapp.MiniAppOptions;
import com.tencent.mobileqq.miniapp.ui.MiniAppActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Map;

class avrw
  extends QQUIEventReceiver<avrt, avrn>
{
  public avrw(@NonNull avrt paramavrt)
  {
    super(paramavrt);
  }
  
  public void a(@NonNull avrt paramavrt, @NonNull avrn paramavrn)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, "receive event:" + paramavrn.toString());
    }
    switch (paramavrn.jdField_a_of_type_Int)
    {
    }
    do
    {
      do
      {
        return;
      } while ((!"MiniAppLauncher".equals(paramavrn.jdField_a_of_type_JavaLangString)) || (avrm.a((String)paramavrn.jdField_a_of_type_ArrayOfJavaLangObject[0]) != 1) || (((Integer)paramavrn.jdField_a_of_type_ArrayOfJavaLangObject[2]).intValue() == 2));
      String str = (String)paramavrn.jdField_a_of_type_ArrayOfJavaLangObject[1];
      if (paramavrn.jdField_a_of_type_Boolean)
      {
        QQToast.a(BaseApplicationImpl.getApplication(), amtj.a(2131705946), 0).a();
        avro localavro = avrt.a(paramavrt).a(str, 2, 0, false);
        if (localavro != null)
        {
          localavro.jdField_a_of_type_AndroidOsBundle.putString("unzipped_path", (String)paramavrn.jdField_a_of_type_ArrayOfJavaLangObject[3]);
          avrt.b(paramavrt, (avrl)avrt.a(paramavrt).get(localavro.h));
          return;
        }
      }
      paramavrn = avro.a(str);
      avrt.a(paramavrt, paramavrn[1], Integer.parseInt(paramavrn[0]), 1003);
      return;
      avrt.a(paramavrt, (MiniAppActivity)paramavrn.jdField_a_of_type_ArrayOfJavaLangObject[0], (String)paramavrn.jdField_a_of_type_ArrayOfJavaLangObject[1], ((Integer)paramavrn.jdField_a_of_type_ArrayOfJavaLangObject[2]).intValue(), (MiniAppOptions)paramavrn.jdField_a_of_type_ArrayOfJavaLangObject[3]);
      return;
      avrt.a(paramavrt, avro.a((String)paramavrn.jdField_a_of_type_ArrayOfJavaLangObject[0], ((Integer)paramavrn.jdField_a_of_type_ArrayOfJavaLangObject[1]).intValue()));
      return;
    } while (paramavrn.jdField_a_of_type_Boolean);
    avrt.a(paramavrt, paramavrn.jdField_a_of_type_Avro.jdField_a_of_type_JavaLangString, paramavrn.jdField_a_of_type_Avro.jdField_a_of_type_Int, 1004);
  }
  
  public Class acceptEventClass()
  {
    return avrn.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avrw
 * JD-Core Version:    0.7.0.1
 */