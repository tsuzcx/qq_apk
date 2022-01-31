import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vas.VasResEngine.VasResController.2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public class bdqu
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  bdvu jdField_a_of_type_Bdvu = new bdqv(this);
  private bdwa jdField_a_of_type_Bdwa;
  AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  
  public bdqu(int paramInt, AppRuntime paramAppRuntime, Handler paramHandler)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Handler a()
  {
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    ThreadManager.post(new VasResController.2(this, paramString, paramInt1, paramInt2), 5, null, true);
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_Bdwa == null) && (this.jdField_a_of_type_MqqAppAppRuntime != null))
    {
      Manager localManager = this.jdField_a_of_type_MqqAppAppRuntime.getManager(47);
      if ((localManager != null) && ((localManager instanceof bdvx))) {
        this.jdField_a_of_type_Bdwa = ((bdvx)localManager).a(1);
      }
    }
    if (TextUtils.isEmpty(paramString1)) {
      QLog.e("VasResController", 1, "downLoad error url is empty dst =" + paramString2);
    }
    if ((this.jdField_a_of_type_Bdwa != null) && (this.jdField_a_of_type_Bdwa.a(paramString1) == null))
    {
      paramString1 = new bdvv(paramString1, new File(paramString2));
      this.jdField_a_of_type_Bdwa.a(paramString1, this.jdField_a_of_type_Bdvu, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdqu
 * JD-Core Version:    0.7.0.1
 */