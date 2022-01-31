import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.miniapp.MiniAppOptions;
import com.tencent.mobileqq.miniapp.ui.MiniAppActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Map;

class auae
  extends QQUIEventReceiver<auab, atzv>
{
  public auae(@NonNull auab paramauab)
  {
    super(paramauab);
  }
  
  public void a(@NonNull auab paramauab, @NonNull atzv paramatzv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, "receive event:" + paramatzv.toString());
    }
    switch (paramatzv.jdField_a_of_type_Int)
    {
    }
    do
    {
      do
      {
        return;
      } while ((!"MiniAppLauncher".equals(paramatzv.jdField_a_of_type_JavaLangString)) || (atzu.a((String)paramatzv.jdField_a_of_type_ArrayOfJavaLangObject[0]) != 1) || (((Integer)paramatzv.jdField_a_of_type_ArrayOfJavaLangObject[2]).intValue() == 2));
      String str = (String)paramatzv.jdField_a_of_type_ArrayOfJavaLangObject[1];
      if (paramatzv.jdField_a_of_type_Boolean)
      {
        QQToast.a(BaseApplicationImpl.getApplication(), alpo.a(2131707206), 0).a();
        atzw localatzw = auab.a(paramauab).a(str, 2, 0, false);
        if (localatzw != null)
        {
          localatzw.jdField_a_of_type_AndroidOsBundle.putString("unzipped_path", (String)paramatzv.jdField_a_of_type_ArrayOfJavaLangObject[3]);
          auab.b(paramauab, (atzt)auab.a(paramauab).get(localatzw.h));
          return;
        }
      }
      paramatzv = atzw.a(str);
      auab.a(paramauab, paramatzv[1], Integer.parseInt(paramatzv[0]), 1003);
      return;
      auab.a(paramauab, (MiniAppActivity)paramatzv.jdField_a_of_type_ArrayOfJavaLangObject[0], (String)paramatzv.jdField_a_of_type_ArrayOfJavaLangObject[1], ((Integer)paramatzv.jdField_a_of_type_ArrayOfJavaLangObject[2]).intValue(), (MiniAppOptions)paramatzv.jdField_a_of_type_ArrayOfJavaLangObject[3]);
      return;
      auab.a(paramauab, atzw.a((String)paramatzv.jdField_a_of_type_ArrayOfJavaLangObject[0], ((Integer)paramatzv.jdField_a_of_type_ArrayOfJavaLangObject[1]).intValue()));
      return;
    } while (paramatzv.jdField_a_of_type_Boolean);
    auab.a(paramauab, paramatzv.jdField_a_of_type_Atzw.jdField_a_of_type_JavaLangString, paramatzv.jdField_a_of_type_Atzw.jdField_a_of_type_Int, 1004);
  }
  
  public Class acceptEventClass()
  {
    return atzv.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auae
 * JD-Core Version:    0.7.0.1
 */