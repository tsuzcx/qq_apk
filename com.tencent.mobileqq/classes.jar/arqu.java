import android.app.Activity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class arqu
  implements aqxn
{
  arqu(arqo paramarqo, Activity paramActivity, int paramInt) {}
  
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
      if (((arqo.a(this.jdField_a_of_type_Arqo).status == 0) || (arqo.a(this.jdField_a_of_type_Arqo).status == 3)) && (((this.jdField_a_of_type_AndroidAppActivity instanceof ChatActivity)) || ((this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity))) && (!arqo.a(this.jdField_a_of_type_Arqo).bSend))
      {
        localObject.a().a(arqo.a(this.jdField_a_of_type_Arqo).nSessionId);
        return;
      }
      arqo.a(this.jdField_a_of_type_Arqo, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, 10004);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arqu
 * JD-Core Version:    0.7.0.1
 */