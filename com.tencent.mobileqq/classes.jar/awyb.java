import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.miniapp.MiniAppOptions;
import com.tencent.mobileqq.miniapp.ui.MiniAppActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Map;

class awyb
  extends QQUIEventReceiver<awxy, awxs>
{
  public awyb(@NonNull awxy paramawxy)
  {
    super(paramawxy);
  }
  
  public void a(@NonNull awxy paramawxy, @NonNull awxs paramawxs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, "receive event:" + paramawxs.toString());
    }
    switch (paramawxs.jdField_a_of_type_Int)
    {
    }
    do
    {
      do
      {
        return;
      } while ((!"MiniAppLauncher".equals(paramawxs.jdField_a_of_type_JavaLangString)) || (awxr.a((String)paramawxs.jdField_a_of_type_ArrayOfJavaLangObject[0]) != 1) || (((Integer)paramawxs.jdField_a_of_type_ArrayOfJavaLangObject[2]).intValue() == 2));
      String str = (String)paramawxs.jdField_a_of_type_ArrayOfJavaLangObject[1];
      if (paramawxs.jdField_a_of_type_Boolean)
      {
        QQToast.a(BaseApplicationImpl.getApplication(), anvx.a(2131706297), 0).a();
        awxt localawxt = awxy.a(paramawxy).a(str, 2, 0, false);
        if (localawxt != null)
        {
          localawxt.jdField_a_of_type_AndroidOsBundle.putString("unzipped_path", (String)paramawxs.jdField_a_of_type_ArrayOfJavaLangObject[3]);
          awxy.b(paramawxy, (awxq)awxy.a(paramawxy).get(localawxt.h));
          return;
        }
      }
      paramawxs = awxt.a(str);
      awxy.a(paramawxy, paramawxs[1], Integer.parseInt(paramawxs[0]), 1003);
      return;
      awxy.a(paramawxy, (MiniAppActivity)paramawxs.jdField_a_of_type_ArrayOfJavaLangObject[0], (String)paramawxs.jdField_a_of_type_ArrayOfJavaLangObject[1], ((Integer)paramawxs.jdField_a_of_type_ArrayOfJavaLangObject[2]).intValue(), (MiniAppOptions)paramawxs.jdField_a_of_type_ArrayOfJavaLangObject[3]);
      return;
      awxy.a(paramawxy, awxt.a((String)paramawxs.jdField_a_of_type_ArrayOfJavaLangObject[0], ((Integer)paramawxs.jdField_a_of_type_ArrayOfJavaLangObject[1]).intValue()));
      return;
    } while (paramawxs.jdField_a_of_type_Boolean);
    awxy.a(paramawxy, paramawxs.jdField_a_of_type_Awxt.jdField_a_of_type_JavaLangString, paramawxs.jdField_a_of_type_Awxt.jdField_a_of_type_Int, 1004);
  }
  
  public Class acceptEventClass()
  {
    return awxs.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awyb
 * JD-Core Version:    0.7.0.1
 */