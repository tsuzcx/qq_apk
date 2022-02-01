import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.miniapp.MiniAppOptions;
import com.tencent.mobileqq.miniapp.ui.MiniAppActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Map;

class awlx
  extends QQUIEventReceiver<awlu, awlo>
{
  public awlx(@NonNull awlu paramawlu)
  {
    super(paramawlu);
  }
  
  public void a(@NonNull awlu paramawlu, @NonNull awlo paramawlo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, "receive event:" + paramawlo.toString());
    }
    switch (paramawlo.jdField_a_of_type_Int)
    {
    }
    do
    {
      do
      {
        return;
      } while ((!"MiniAppLauncher".equals(paramawlo.jdField_a_of_type_JavaLangString)) || (awln.a((String)paramawlo.jdField_a_of_type_ArrayOfJavaLangObject[0]) != 1) || (((Integer)paramawlo.jdField_a_of_type_ArrayOfJavaLangObject[2]).intValue() == 2));
      String str = (String)paramawlo.jdField_a_of_type_ArrayOfJavaLangObject[1];
      if (paramawlo.jdField_a_of_type_Boolean)
      {
        QQToast.a(BaseApplicationImpl.getApplication(), anni.a(2131705609), 0).a();
        awlp localawlp = awlu.a(paramawlu).a(str, 2, 0, false);
        if (localawlp != null)
        {
          localawlp.jdField_a_of_type_AndroidOsBundle.putString("unzipped_path", (String)paramawlo.jdField_a_of_type_ArrayOfJavaLangObject[3]);
          awlu.b(paramawlu, (awlm)awlu.a(paramawlu).get(localawlp.h));
          return;
        }
      }
      paramawlo = awlp.a(str);
      awlu.a(paramawlu, paramawlo[1], Integer.parseInt(paramawlo[0]), 1003);
      return;
      awlu.a(paramawlu, (MiniAppActivity)paramawlo.jdField_a_of_type_ArrayOfJavaLangObject[0], (String)paramawlo.jdField_a_of_type_ArrayOfJavaLangObject[1], ((Integer)paramawlo.jdField_a_of_type_ArrayOfJavaLangObject[2]).intValue(), (MiniAppOptions)paramawlo.jdField_a_of_type_ArrayOfJavaLangObject[3]);
      return;
      awlu.a(paramawlu, awlp.a((String)paramawlo.jdField_a_of_type_ArrayOfJavaLangObject[0], ((Integer)paramawlo.jdField_a_of_type_ArrayOfJavaLangObject[1]).intValue()));
      return;
    } while (paramawlo.jdField_a_of_type_Boolean);
    awlu.a(paramawlu, paramawlo.jdField_a_of_type_Awlp.jdField_a_of_type_JavaLangString, paramawlo.jdField_a_of_type_Awlp.jdField_a_of_type_Int, 1004);
  }
  
  public Class acceptEventClass()
  {
    return awlo.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awlx
 * JD-Core Version:    0.7.0.1
 */