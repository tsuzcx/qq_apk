import android.app.Activity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class aptf
  implements apac
{
  aptf(apsz paramapsz, Activity paramActivity, int paramInt) {}
  
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
      if (((apsz.a(this.jdField_a_of_type_Apsz).status == 0) || (apsz.a(this.jdField_a_of_type_Apsz).status == 3)) && (((this.jdField_a_of_type_AndroidAppActivity instanceof ChatActivity)) || ((this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity))) && (!apsz.a(this.jdField_a_of_type_Apsz).bSend))
      {
        localObject.a().a(apsz.a(this.jdField_a_of_type_Apsz).nSessionId);
        return;
      }
      apsz.a(this.jdField_a_of_type_Apsz, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, 10004);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aptf
 * JD-Core Version:    0.7.0.1
 */