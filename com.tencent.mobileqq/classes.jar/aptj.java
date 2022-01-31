import android.app.Activity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class aptj
  implements apag
{
  aptj(aptd paramaptd, Activity paramActivity, int paramInt) {}
  
  public void a() {}
  
  public void b()
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface == null)
      {
        QLog.e("FileModel<FileAssistant>", 1, "Start VideoActivity is not in QQ!");
        return;
      }
    }
    catch (Exception localException)
    {
      Object localObject;
      for (;;)
      {
        localObject = null;
      }
      if (((aptd.a(this.jdField_a_of_type_Aptd).status == 0) || (aptd.a(this.jdField_a_of_type_Aptd).status == 3)) && (((this.jdField_a_of_type_AndroidAppActivity instanceof ChatActivity)) || ((this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity))) && (!aptd.a(this.jdField_a_of_type_Aptd).bSend))
      {
        localObject.a().a(aptd.a(this.jdField_a_of_type_Aptd).nSessionId);
        return;
      }
      aptd.a(this.jdField_a_of_type_Aptd, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, 10004);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aptj
 * JD-Core Version:    0.7.0.1
 */