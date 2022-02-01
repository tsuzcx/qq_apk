import android.content.Context;
import android.text.TextUtils;
import android.view.Window;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class aoxm
  extends aoxg
{
  public aoxm(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean C()
  {
    bjbs localbjbs = new bjbs(this.jdField_a_of_type_AndroidContentContext, 0, 2131558698, 17);
    localbjbs.a(this.jdField_a_of_type_AndroidContentContext.getString(2131690133));
    localbjbs.getWindow().setDimAmount(0.0F);
    localbjbs.show();
    localbjbs.setCanceledOnTouchOutside(true);
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("app");
    if ((TextUtils.isEmpty(str1)) && (QLog.isColorLevel())) {
      QLog.e("LightAppOpenAction", 2, "Ark mqqapi://ligthapp/open goToLightAppOpen jumpAction. appName=null");
    }
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("meta");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("view");
    ArkAppCenter localArkAppCenter = (ArkAppCenter)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(121);
    ArkAppMgr.getInstance().getAppPathByName(str1, str3, "0.0.0.1", "", new aoxn(this, localbjbs, str3, str2, str1));
    return true;
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = C();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("LightAppOpenAction", 1, "doAction error: " + localException.getMessage());
      a("LightAppOpenAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoxm
 * JD-Core Version:    0.7.0.1
 */