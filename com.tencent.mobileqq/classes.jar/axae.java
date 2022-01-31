import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.stt.SliceSttManager.SliceSttServet.1.1;
import com.tencent.mobileqq.stt.SliceSttManager.SliceSttServet.1.2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class axae
  implements acre
{
  axae(axad paramaxad) {}
  
  public void a() {}
  
  public void a(int paramInt)
  {
    if (this.a.b != null)
    {
      localObject = new File(this.a.b);
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
    }
    this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.sttAbility = 3;
    this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.sttText = ajjy.a(2131648397);
    this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.isReadPtt = true;
    Object localObject = new HashMap();
    ((HashMap)localObject).put("param_succ_flag", "0");
    ((HashMap)localObject).put("param_version", Build.VERSION.SDK_INT + "");
    ((HashMap)localObject).put("param_deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
    awrn.a(BaseApplication.getContext()).a(null, "ptttotextSuc", false, 0L, 0L, (HashMap)localObject, null);
    try
    {
      this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.serial();
      this.a.jdField_a_of_type_Axac.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.frienduin, this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.istroop, this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.uniseq, this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.msgData);
      this.a.jdField_a_of_type_Axac.jdField_a_of_type_AndroidOsHandler.post(new SliceSttManager.SliceSttServet.1.2(this));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SliceSttManager", 2, "updatedb", localException);
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SliceSttManager", 2, "updateText =" + paramString);
    }
    this.a.jdField_a_of_type_JavaLangString = paramString;
    this.a.jdField_a_of_type_Axac.jdField_a_of_type_AndroidOsHandler.post(new SliceSttManager.SliceSttServet.1.1(this));
  }
  
  public void b()
  {
    axad.a(this.a);
  }
  
  public void setSttNetFinish()
  {
    axad.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axae
 * JD-Core Version:    0.7.0.1
 */