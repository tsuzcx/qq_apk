import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vas.VasResEngine.VasResController.2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class bapp
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  batl jdField_a_of_type_Batl = new bapq(this);
  private batr jdField_a_of_type_Batr;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  
  public bapp(int paramInt, AppInterface paramAppInterface, Handler paramHandler)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
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
    if (this.jdField_a_of_type_Batr == null) {
      this.jdField_a_of_type_Batr = ((bato)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(47)).a(1);
    }
    if (TextUtils.isEmpty(paramString1)) {
      QLog.e("VasResController", 1, "downLoad error url is empty dst =" + paramString2);
    }
    if (this.jdField_a_of_type_Batr.a(paramString1) == null)
    {
      paramString1 = new batm(paramString1, new File(paramString2));
      this.jdField_a_of_type_Batr.a(paramString1, this.jdField_a_of_type_Batl, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bapp
 * JD-Core Version:    0.7.0.1
 */