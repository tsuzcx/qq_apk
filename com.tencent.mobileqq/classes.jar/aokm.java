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

public class aokm
{
  private AudioManager.OnAudioFocusChangeListener jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new aokn(this);
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private aoko jdField_a_of_type_Aoko;
  private bblk jdField_a_of_type_Bblk;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  
  public aokm(aoko paramaoko, BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_Aoko = paramaoko;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("audio"));
  }
  
  public void a()
  {
    try
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_Bblk != null)
        {
          this.jdField_a_of_type_Bblk.f();
          this.jdField_a_of_type_Bblk = null;
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
        if (!apvb.a(???))
        {
          str = aypf.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getCurrentAccountUin(), MD5.toMD5(???), 23, null);
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
      if (this.jdField_a_of_type_Bblk != null)
      {
        this.jdField_a_of_type_Bblk.f();
        this.jdField_a_of_type_Bblk = null;
      }
      this.jdField_a_of_type_Bblk = new bblk(str, new Handler(), 1);
      this.jdField_a_of_type_Bblk.b();
      this.jdField_a_of_type_Bblk.a(this.jdField_a_of_type_Aoko);
      this.jdField_a_of_type_Bblk.c();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aokm
 * JD-Core Version:    0.7.0.1
 */