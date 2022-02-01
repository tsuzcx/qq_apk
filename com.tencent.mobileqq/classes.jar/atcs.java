import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.os.Handler;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendVoicePlayer.2;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class atcs
{
  private AudioManager.OnAudioFocusChangeListener jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new atct(this);
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private atcu jdField_a_of_type_Atcu;
  private bhud jdField_a_of_type_Bhud;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  
  public atcs(atcu paramatcu, BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_Atcu = paramatcu;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("audio"));
  }
  
  public void a()
  {
    try
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_Bhud != null)
        {
          this.jdField_a_of_type_Bhud.e();
          this.jdField_a_of_type_Bhud = null;
        }
        b();
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ExtendFriendVoicePlayer", 1, "stop e=" + localException);
    }
  }
  
  public void a(String paramString)
  {
    if (!a(paramString)) {
      ThreadManager.executeOnFileThread(new ExtendFriendVoicePlayer.2(this, paramString));
    }
  }
  
  public boolean a(String arg1)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())) {
      QLog.e("ExtendFriendVoicePlayer", 2, "playLocal file but activity isFinish");
    }
    String str;
    for (;;)
    {
      return false;
      str = ???;
      try
      {
        if (!auog.a(???))
        {
          str = berv.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getCurrentAccountUin(), MD5.toMD5(???), 23, null);
          File localFile = new File(str);
          if ((!localFile.exists()) || (localFile.length() <= 0L))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("ExtendFriendVoicePlayer", 2, String.format("playLocal file not exist : %s", new Object[] { ??? }));
            return false;
          }
        }
      }
      catch (Exception ???)
      {
        QLog.e("ExtendFriendVoicePlayer", 1, "playLocal", ???);
        return false;
      }
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Bhud != null)
      {
        this.jdField_a_of_type_Bhud.e();
        this.jdField_a_of_type_Bhud = null;
      }
      this.jdField_a_of_type_Bhud = new bhud(str, new Handler(), 1);
      this.jdField_a_of_type_Bhud.b();
      this.jdField_a_of_type_Bhud.a(this.jdField_a_of_type_Atcu);
      this.jdField_a_of_type_Bhud.b();
      if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
        this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, 3, 2);
      }
      return true;
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendVoicePlayer", 2, "abandonAudioFocus");
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
      this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atcs
 * JD-Core Version:    0.7.0.1
 */