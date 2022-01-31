import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.miniapp.MiniAppOptions;
import com.tencent.mobileqq.miniapp.ui.MiniAppActivity;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Map;

class asje
  extends QQUIEventReceiver<asjb, asiv>
{
  public asje(@NonNull asjb paramasjb)
  {
    super(paramasjb);
  }
  
  public void a(@NonNull asjb paramasjb, @NonNull asiv paramasiv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, "receive event:" + paramasiv.toString());
    }
    switch (paramasiv.jdField_a_of_type_Int)
    {
    }
    do
    {
      do
      {
        return;
      } while ((!"MiniAppLauncher".equals(paramasiv.jdField_a_of_type_JavaLangString)) || (asiu.a((String)paramasiv.jdField_a_of_type_ArrayOfJavaLangObject[0]) != 1) || (((Integer)paramasiv.jdField_a_of_type_ArrayOfJavaLangObject[2]).intValue() == 2));
      String str = (String)paramasiv.jdField_a_of_type_ArrayOfJavaLangObject[1];
      if (paramasiv.jdField_a_of_type_Boolean)
      {
        bcql.a(BaseApplicationImpl.getApplication(), ajya.a(2131706834), 0).a();
        asiw localasiw = asjb.a(paramasjb).a(str, 2, 0, false);
        if (localasiw != null)
        {
          localasiw.jdField_a_of_type_AndroidOsBundle.putString("unzipped_path", (String)paramasiv.jdField_a_of_type_ArrayOfJavaLangObject[3]);
          asjb.b(paramasjb, (asit)asjb.a(paramasjb).get(localasiw.h));
          return;
        }
      }
      paramasiv = asiw.a(str);
      asjb.a(paramasjb, paramasiv[1], Integer.parseInt(paramasiv[0]), 1003);
      return;
      asjb.a(paramasjb, (MiniAppActivity)paramasiv.jdField_a_of_type_ArrayOfJavaLangObject[0], (String)paramasiv.jdField_a_of_type_ArrayOfJavaLangObject[1], ((Integer)paramasiv.jdField_a_of_type_ArrayOfJavaLangObject[2]).intValue(), (MiniAppOptions)paramasiv.jdField_a_of_type_ArrayOfJavaLangObject[3]);
      return;
      asjb.a(paramasjb, asiw.a((String)paramasiv.jdField_a_of_type_ArrayOfJavaLangObject[0], ((Integer)paramasiv.jdField_a_of_type_ArrayOfJavaLangObject[1]).intValue()));
      return;
    } while (paramasiv.jdField_a_of_type_Boolean);
    asjb.a(paramasjb, paramasiv.jdField_a_of_type_Asiw.jdField_a_of_type_JavaLangString, paramasiv.jdField_a_of_type_Asiw.jdField_a_of_type_Int, 1004);
  }
  
  public Class acceptEventClass()
  {
    return asiv.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     asje
 * JD-Core Version:    0.7.0.1
 */