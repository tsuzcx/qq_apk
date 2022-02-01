import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.miniapp.MiniAppOptions;
import com.tencent.mobileqq.miniapp.ui.MiniAppActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Map;

class axep
  extends QQUIEventReceiver<axem, axeg>
{
  public axep(@NonNull axem paramaxem)
  {
    super(paramaxem);
  }
  
  public void a(@NonNull axem paramaxem, @NonNull axeg paramaxeg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, "receive event:" + paramaxeg.toString());
    }
    switch (paramaxeg.jdField_a_of_type_Int)
    {
    }
    do
    {
      do
      {
        return;
      } while ((!"MiniAppLauncher".equals(paramaxeg.jdField_a_of_type_JavaLangString)) || (axef.a((String)paramaxeg.jdField_a_of_type_ArrayOfJavaLangObject[0]) != 1) || (((Integer)paramaxeg.jdField_a_of_type_ArrayOfJavaLangObject[2]).intValue() == 2));
      String str = (String)paramaxeg.jdField_a_of_type_ArrayOfJavaLangObject[1];
      if (paramaxeg.jdField_a_of_type_Boolean)
      {
        QQToast.a(BaseApplicationImpl.getApplication(), anzj.a(2131705716), 0).a();
        axeh localaxeh = axem.a(paramaxem).a(str, 2, 0, false);
        if (localaxeh != null)
        {
          localaxeh.jdField_a_of_type_AndroidOsBundle.putString("unzipped_path", (String)paramaxeg.jdField_a_of_type_ArrayOfJavaLangObject[3]);
          axem.b(paramaxem, (axee)axem.a(paramaxem).get(localaxeh.h));
          return;
        }
      }
      paramaxeg = axeh.a(str);
      axem.a(paramaxem, paramaxeg[1], Integer.parseInt(paramaxeg[0]), 1003);
      return;
      axem.a(paramaxem, (MiniAppActivity)paramaxeg.jdField_a_of_type_ArrayOfJavaLangObject[0], (String)paramaxeg.jdField_a_of_type_ArrayOfJavaLangObject[1], ((Integer)paramaxeg.jdField_a_of_type_ArrayOfJavaLangObject[2]).intValue(), (MiniAppOptions)paramaxeg.jdField_a_of_type_ArrayOfJavaLangObject[3]);
      return;
      axem.a(paramaxem, axeh.a((String)paramaxeg.jdField_a_of_type_ArrayOfJavaLangObject[0], ((Integer)paramaxeg.jdField_a_of_type_ArrayOfJavaLangObject[1]).intValue()));
      return;
    } while (paramaxeg.jdField_a_of_type_Boolean);
    axem.a(paramaxem, paramaxeg.jdField_a_of_type_Axeh.jdField_a_of_type_JavaLangString, paramaxeg.jdField_a_of_type_Axeh.jdField_a_of_type_Int, 1004);
  }
  
  public Class acceptEventClass()
  {
    return axeg.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axep
 * JD-Core Version:    0.7.0.1
 */