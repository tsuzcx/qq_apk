import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.miniapp.MiniAppOptions;
import com.tencent.mobileqq.miniapp.ui.MiniAppActivity;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Map;

class armz
  extends QQUIEventReceiver<armw, armq>
{
  public armz(@NonNull armw paramarmw)
  {
    super(paramarmw);
  }
  
  public void a(@NonNull armw paramarmw, @NonNull armq paramarmq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, "receive event:" + paramarmq.toString());
    }
    switch (paramarmq.jdField_a_of_type_Int)
    {
    }
    do
    {
      do
      {
        return;
      } while ((!"MiniAppLauncher".equals(paramarmq.jdField_a_of_type_JavaLangString)) || (armp.a((String)paramarmq.jdField_a_of_type_ArrayOfJavaLangObject[0]) != 1) || (((Integer)paramarmq.jdField_a_of_type_ArrayOfJavaLangObject[2]).intValue() == 2));
      String str = (String)paramarmq.jdField_a_of_type_ArrayOfJavaLangObject[1];
      if (paramarmq.jdField_a_of_type_Boolean)
      {
        bbmy.a(BaseApplicationImpl.getApplication(), ajjy.a(2131641038), 0).a();
        armr localarmr = armw.a(paramarmw).a(str, 2, 0, false);
        if (localarmr != null)
        {
          localarmr.jdField_a_of_type_AndroidOsBundle.putString("unzipped_path", (String)paramarmq.jdField_a_of_type_ArrayOfJavaLangObject[3]);
          armw.b(paramarmw, (armo)armw.a(paramarmw).get(localarmr.h));
          return;
        }
      }
      paramarmq = armr.a(str);
      armw.a(paramarmw, paramarmq[1], Integer.parseInt(paramarmq[0]), 1003);
      return;
      armw.a(paramarmw, (MiniAppActivity)paramarmq.jdField_a_of_type_ArrayOfJavaLangObject[0], (String)paramarmq.jdField_a_of_type_ArrayOfJavaLangObject[1], ((Integer)paramarmq.jdField_a_of_type_ArrayOfJavaLangObject[2]).intValue(), (MiniAppOptions)paramarmq.jdField_a_of_type_ArrayOfJavaLangObject[3]);
      return;
      armw.a(paramarmw, armr.a((String)paramarmq.jdField_a_of_type_ArrayOfJavaLangObject[0], ((Integer)paramarmq.jdField_a_of_type_ArrayOfJavaLangObject[1]).intValue()));
      return;
    } while (paramarmq.jdField_a_of_type_Boolean);
    armw.a(paramarmw, paramarmq.jdField_a_of_type_Armr.jdField_a_of_type_JavaLangString, paramarmq.jdField_a_of_type_Armr.jdField_a_of_type_Int, 1004);
  }
  
  public Class acceptEventClass()
  {
    return armq.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     armz
 * JD-Core Version:    0.7.0.1
 */