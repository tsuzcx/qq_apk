import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.miniapp.MiniAppOptions;
import com.tencent.mobileqq.miniapp.ui.MiniAppActivity;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Map;

class asjc
  extends QQUIEventReceiver<asiz, asit>
{
  public asjc(@NonNull asiz paramasiz)
  {
    super(paramasiz);
  }
  
  public void a(@NonNull asiz paramasiz, @NonNull asit paramasit)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, "receive event:" + paramasit.toString());
    }
    switch (paramasit.jdField_a_of_type_Int)
    {
    }
    do
    {
      do
      {
        return;
      } while ((!"MiniAppLauncher".equals(paramasit.jdField_a_of_type_JavaLangString)) || (asis.a((String)paramasit.jdField_a_of_type_ArrayOfJavaLangObject[0]) != 1) || (((Integer)paramasit.jdField_a_of_type_ArrayOfJavaLangObject[2]).intValue() == 2));
      String str = (String)paramasit.jdField_a_of_type_ArrayOfJavaLangObject[1];
      if (paramasit.jdField_a_of_type_Boolean)
      {
        bcpw.a(BaseApplicationImpl.getApplication(), ajyc.a(2131706823), 0).a();
        asiu localasiu = asiz.a(paramasiz).a(str, 2, 0, false);
        if (localasiu != null)
        {
          localasiu.jdField_a_of_type_AndroidOsBundle.putString("unzipped_path", (String)paramasit.jdField_a_of_type_ArrayOfJavaLangObject[3]);
          asiz.b(paramasiz, (asir)asiz.a(paramasiz).get(localasiu.h));
          return;
        }
      }
      paramasit = asiu.a(str);
      asiz.a(paramasiz, paramasit[1], Integer.parseInt(paramasit[0]), 1003);
      return;
      asiz.a(paramasiz, (MiniAppActivity)paramasit.jdField_a_of_type_ArrayOfJavaLangObject[0], (String)paramasit.jdField_a_of_type_ArrayOfJavaLangObject[1], ((Integer)paramasit.jdField_a_of_type_ArrayOfJavaLangObject[2]).intValue(), (MiniAppOptions)paramasit.jdField_a_of_type_ArrayOfJavaLangObject[3]);
      return;
      asiz.a(paramasiz, asiu.a((String)paramasit.jdField_a_of_type_ArrayOfJavaLangObject[0], ((Integer)paramasit.jdField_a_of_type_ArrayOfJavaLangObject[1]).intValue()));
      return;
    } while (paramasit.jdField_a_of_type_Boolean);
    asiz.a(paramasiz, paramasit.jdField_a_of_type_Asiu.jdField_a_of_type_JavaLangString, paramasit.jdField_a_of_type_Asiu.jdField_a_of_type_Int, 1004);
  }
  
  public Class acceptEventClass()
  {
    return asit.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     asjc
 * JD-Core Version:    0.7.0.1
 */