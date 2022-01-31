import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.MusicPlayerScene.1;
import java.util.Iterator;
import java.util.List;

public class bhio
  implements acjg
{
  protected int a;
  private long a;
  public AudioPlayer a;
  protected MusicItemInfo a;
  protected List<bhip> a;
  
  public bhio()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = new AudioPlayer(BaseApplicationImpl.getApplication(), this);
  }
  
  public int a()
  {
    int i = -1;
    if (a()) {
      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b();
    }
    return i;
  }
  
  public void a()
  {
    int j = -1;
    try
    {
      this.jdField_a_of_type_Int = -1;
      StringBuilder localStringBuilder = new StringBuilder("startMusic");
      String str2 = "";
      String str1 = str2;
      int i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null)
      {
        str1 = str2;
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null)
        {
          str1 = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mMusicName;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b(3);
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart < 0)
          {
            localStringBuilder.append(" musicStart=").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart);
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart = 0;
          }
          i = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart;
          a(i, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
          a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.getLocalPath(), this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart + (int)this.jdField_a_of_type_Long);
        }
      }
      localStringBuilder.append(" musicName=").append(str1);
      localStringBuilder.append(" position=").append(i);
      if (QLog.isColorLevel()) {
        QLog.d("MusicPlayerScene", 2, localStringBuilder.toString());
      }
      return;
    }
    finally {}
  }
  
  protected void a(int paramInt, MusicItemInfo paramMusicItemInfo)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      paramMusicItemInfo = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramMusicItemInfo.hasNext()) {
        ((bhip)paramMusicItemInfo.next()).a(paramInt, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
      }
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null) {
      this.jdField_a_of_type_Int = (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart + (int)this.jdField_a_of_type_Long);
    }
  }
  
  public void a(AudioPlayer paramAudioPlayer)
  {
    b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
    d();
    if (QLog.isColorLevel()) {
      QLog.d("MusicPlayerScene", 2, "MusicPlayerScene onCompletion");
    }
  }
  
  public void a(AudioPlayer paramAudioPlayer, int paramInt) {}
  
  public void a(MusicItemInfo paramMusicItemInfo)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = paramMusicItemInfo;
      this.jdField_a_of_type_Int = paramMusicItemInfo.musicStart;
      return;
    }
    finally
    {
      paramMusicItemInfo = finally;
      throw paramMusicItemInfo;
    }
  }
  
  protected void a(String paramString, int paramInt)
  {
    ThreadManager.postImmediately(new MusicPlayerScene.1(this, paramString, paramInt), null, true);
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void a(List<bhip> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public boolean a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null)
      {
        boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a();
        if (bool) {
          return true;
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public void b()
  {
    int j = -1;
    String str2 = "";
    try
    {
      StringBuilder localStringBuilder = new StringBuilder("resumeMusic");
      String str1 = str2;
      int i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null)
      {
        str1 = str2;
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null)
        {
          str1 = str2;
          i = j;
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a())
          {
            str1 = str2;
            i = j;
            if (this.jdField_a_of_type_Int != -1)
            {
              str1 = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mMusicName;
              a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.getLocalPath(), this.jdField_a_of_type_Int);
              i = this.jdField_a_of_type_Int;
            }
          }
        }
      }
      b(i, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
      localStringBuilder.append(" musicName=").append(str1);
      localStringBuilder.append(" position=").append(i);
      if (QLog.isColorLevel()) {
        QLog.d("MusicPlayerScene", 2, localStringBuilder.toString());
      }
      return;
    }
    finally {}
  }
  
  protected void b(int paramInt, MusicItemInfo paramMusicItemInfo)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      paramMusicItemInfo = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramMusicItemInfo.hasNext()) {
        ((bhip)paramMusicItemInfo.next()).c(paramInt, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
      }
    }
  }
  
  public void b(AudioPlayer paramAudioPlayer, int paramInt) {}
  
  protected void b(MusicItemInfo paramMusicItemInfo)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      paramMusicItemInfo = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramMusicItemInfo.hasNext()) {
        ((bhip)paramMusicItemInfo.next()).b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
      }
    }
  }
  
  public void c()
  {
    int i = -1;
    try
    {
      StringBuilder localStringBuilder = new StringBuilder("pauseMusic");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a())
      {
        this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b();
        i = this.jdField_a_of_type_Int;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.c();
      c(i, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
      localStringBuilder.append(" musicName=").append("");
      localStringBuilder.append(" position=").append(i);
      if (QLog.isColorLevel()) {
        QLog.d("MusicPlayerScene", 2, localStringBuilder.toString());
      }
      return;
    }
    finally {}
  }
  
  protected void c(int paramInt, MusicItemInfo paramMusicItemInfo)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      paramMusicItemInfo = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramMusicItemInfo.hasNext()) {
        ((bhip)paramMusicItemInfo.next()).d(paramInt, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
      }
    }
  }
  
  public void c(AudioPlayer paramAudioPlayer, int paramInt) {}
  
  public void d()
  {
    int j = -1;
    try
    {
      this.jdField_a_of_type_Int = -1;
      StringBuilder localStringBuilder = new StringBuilder("startMusic");
      String str2 = "";
      String str1 = str2;
      int i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null)
      {
        str1 = str2;
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null)
        {
          str1 = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mMusicName;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b(3);
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart < 0)
          {
            localStringBuilder.append(" musicStart=").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart);
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart = 0;
          }
          if (a()) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.c();
          }
          i = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart;
          d(i, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
          a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.getLocalPath(), this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart);
        }
      }
      localStringBuilder.append(" musicName=").append(str1);
      localStringBuilder.append(" position=").append(i);
      if (QLog.isColorLevel()) {
        QLog.d("MusicPlayerScene", 2, localStringBuilder.toString());
      }
      return;
    }
    finally {}
  }
  
  protected void d(int paramInt, MusicItemInfo paramMusicItemInfo)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      paramMusicItemInfo = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramMusicItemInfo.hasNext()) {
        ((bhip)paramMusicItemInfo.next()).b(paramInt, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
      }
    }
  }
  
  public void d(AudioPlayer paramAudioPlayer, int paramInt)
  {
    wzj.a().a(paramInt);
  }
  
  public void e()
  {
    try
    {
      this.jdField_a_of_type_Int = -1;
      String str = "";
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.c();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null)
      {
        str = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mMusicName;
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = null;
      }
      g();
      if (QLog.isColorLevel()) {
        QLog.d("MusicPlayerScene", 2, "MusicPlayerScene stopMusic musicName=" + str);
      }
      return;
    }
    finally {}
  }
  
  public void f()
  {
    try
    {
      this.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = null;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.c();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = null;
      this.jdField_a_of_type_JavaUtilList = null;
      if (QLog.isColorLevel()) {
        QLog.d("MusicPlayerScene", 2, "MusicPlayerScene destroy");
      }
      return;
    }
    finally {}
  }
  
  protected void g()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((bhip)localIterator.next()).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhio
 * JD-Core Version:    0.7.0.1
 */