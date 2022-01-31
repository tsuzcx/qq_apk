import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.miniapp.MiniAppOptions;
import com.tencent.mobileqq.miniapp.ui.MiniAppActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Map;

class auen
  extends QQUIEventReceiver<auek, auee>
{
  public auen(@NonNull auek paramauek)
  {
    super(paramauek);
  }
  
  public void a(@NonNull auek paramauek, @NonNull auee paramauee)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, "receive event:" + paramauee.toString());
    }
    switch (paramauee.jdField_a_of_type_Int)
    {
    }
    do
    {
      do
      {
        return;
      } while ((!"MiniAppLauncher".equals(paramauee.jdField_a_of_type_JavaLangString)) || (aued.a((String)paramauee.jdField_a_of_type_ArrayOfJavaLangObject[0]) != 1) || (((Integer)paramauee.jdField_a_of_type_ArrayOfJavaLangObject[2]).intValue() == 2));
      String str = (String)paramauee.jdField_a_of_type_ArrayOfJavaLangObject[1];
      if (paramauee.jdField_a_of_type_Boolean)
      {
        QQToast.a(BaseApplicationImpl.getApplication(), alud.a(2131707218), 0).a();
        auef localauef = auek.a(paramauek).a(str, 2, 0, false);
        if (localauef != null)
        {
          localauef.jdField_a_of_type_AndroidOsBundle.putString("unzipped_path", (String)paramauee.jdField_a_of_type_ArrayOfJavaLangObject[3]);
          auek.b(paramauek, (auec)auek.a(paramauek).get(localauef.h));
          return;
        }
      }
      paramauee = auef.a(str);
      auek.a(paramauek, paramauee[1], Integer.parseInt(paramauee[0]), 1003);
      return;
      auek.a(paramauek, (MiniAppActivity)paramauee.jdField_a_of_type_ArrayOfJavaLangObject[0], (String)paramauee.jdField_a_of_type_ArrayOfJavaLangObject[1], ((Integer)paramauee.jdField_a_of_type_ArrayOfJavaLangObject[2]).intValue(), (MiniAppOptions)paramauee.jdField_a_of_type_ArrayOfJavaLangObject[3]);
      return;
      auek.a(paramauek, auef.a((String)paramauee.jdField_a_of_type_ArrayOfJavaLangObject[0], ((Integer)paramauee.jdField_a_of_type_ArrayOfJavaLangObject[1]).intValue()));
      return;
    } while (paramauee.jdField_a_of_type_Boolean);
    auek.a(paramauek, paramauee.jdField_a_of_type_Auef.jdField_a_of_type_JavaLangString, paramauee.jdField_a_of_type_Auef.jdField_a_of_type_Int, 1004);
  }
  
  public Class acceptEventClass()
  {
    return auee.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auen
 * JD-Core Version:    0.7.0.1
 */