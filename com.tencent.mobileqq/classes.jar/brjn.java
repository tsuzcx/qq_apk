import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.musicwavesupport.MusicWaveformManager.2;

public class brjn
{
  private int jdField_a_of_type_Int;
  private brjl jdField_a_of_type_Brjl;
  private brjm jdField_a_of_type_Brjm = new brjo(this);
  private MusicItemInfo jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
  private Runnable jdField_a_of_type_JavaLangRunnable = new MusicWaveformManager.2(this);
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public static boolean a()
  {
    return ("Meizu".equals(Build.MANUFACTURER)) && (Build.VERSION.SDK_INT <= 22);
  }
  
  private void b()
  {
    this.jdField_a_of_type_Brjl = new brjl();
    this.jdField_a_of_type_Boolean = true;
    ThreadManager.postImmediately(this.jdField_a_of_type_JavaLangRunnable, null, true);
  }
  
  public float a(int paramInt)
  {
    if ((this.b) && (this.c)) {
      return 0.5F;
    }
    if ((this.b) && (this.jdField_a_of_type_Brjl != null) && (this.jdField_a_of_type_Brjl.jdField_a_of_type_Boolean) && (paramInt >= this.jdField_a_of_type_Int)) {
      return this.jdField_a_of_type_Brjl.a(paramInt - this.jdField_a_of_type_Int);
    }
    return -1.0F;
  }
  
  public void a()
  {
    if (!this.b) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Brjl != null) {
      this.jdField_a_of_type_Brjl = null;
    }
    this.b = false;
  }
  
  public void a(MusicItemInfo paramMusicItemInfo, int paramInt)
  {
    if (paramMusicItemInfo == null) {
      a();
    }
    do
    {
      do
      {
        return;
        if (!this.b) {
          break;
        }
      } while ((paramMusicItemInfo.equals(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo)) && (this.jdField_a_of_type_Int <= paramInt) && (paramMusicItemInfo.musicStart == this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart) && (paramMusicItemInfo.musicEnd == this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd));
      a();
      this.b = true;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = paramMusicItemInfo.copy();
      this.jdField_a_of_type_Brjl = null;
      this.jdField_a_of_type_Int = paramInt;
      if (!a()) {
        break;
      }
      this.c = true;
    } while (!QLog.isColorLevel());
    QLog.e("MusicWaveformManager", 2, "musicSoundFile create give up, is rubbish Meizu");
    return;
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     brjn
 * JD-Core Version:    0.7.0.1
 */