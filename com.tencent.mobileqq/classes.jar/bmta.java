import android.app.Activity;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.music.QimMusicDownloader;
import dov.com.qq.im.capture.view.MusicProviderView;
import dov.com.qq.im.capture.view.QIMProviderContainerView;

public class bmta
  extends bmrm
{
  bmte a;
  public MusicItemInfo a;
  int d;
  
  public bmta(int paramInt)
  {
    super(null);
    this.jdField_a_of_type_Bmte = new bmtb(this);
    this.d = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = ((QIMMusicConfigManager)bmql.a(2)).b(paramInt);
  }
  
  public float a()
  {
    try
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mProgress;
      float f = 1.0F * i / 100.0F;
      return f;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int a()
  {
    int i = 3;
    for (;;)
    {
      boolean bool;
      try
      {
        MusicItemInfo localMusicItemInfo = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
        if (localMusicItemInfo == null) {
          return i;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mProgress > -1)
        {
          int j = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mProgress;
          if (j == 100) {
            continue;
          }
          i = 1;
          continue;
        }
      }
      finally {}
      try
      {
        bool = FileUtils.fileExists(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.getLocalPath());
        if (bool) {
          continue;
        }
      }
      catch (Exception localException)
      {
        continue;
      }
      i = 2;
    }
  }
  
  public int a(Activity paramActivity, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCombo.Music", 2, "applyMusic" + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo == null) {
      return 0;
    }
    MusicProviderView localMusicProviderView2 = (MusicProviderView)paramActivity.findViewById(2131364216);
    MusicProviderView localMusicProviderView1 = localMusicProviderView2;
    if (localMusicProviderView2 == null)
    {
      ((QIMProviderContainerView)paramActivity.findViewById(2131373060)).a(104);
      localMusicProviderView1 = (MusicProviderView)paramActivity.findViewById(2131364216);
      localMusicProviderView1.g();
    }
    localMusicProviderView1.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
    return 0;
  }
  
  public void a(Activity paramActivity, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo == null) {}
    while ((paramInt == 1) || (paramInt == 3)) {
      return;
    }
    ((bmtm)bmql.a().c(8)).a(paramInt);
  }
  
  public int b()
  {
    int j = 3;
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo == null)
        {
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.i("MusicProviderView.Downloader", 2, "download STATE_DOWNLOADED" + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
            i = j;
          }
          return i;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mProgress > -1)
        {
          if (QLog.isColorLevel()) {
            QLog.i("MusicProviderView.Downloader", 2, "download mMusic.mProgress" + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mProgress);
          }
        }
        else
        {
          if (!FileUtils.fileExists(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.getLocalPath()))
          {
            if (QLog.isColorLevel()) {
              QLog.i("MusicProviderView.Downloader", 2, "download ." + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mProgress);
            }
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mProgress = 1;
            QimMusicDownloader.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mUrl, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.getLocalPath(), this.jdField_a_of_type_Bmte);
            a();
            i = 2;
            continue;
          }
          i = j;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("MusicProviderView.Downloader", 2, "STATE_DOWNLOADED ." + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mProgress);
          i = j;
          continue;
        }
        int i = 1;
      }
      finally {}
    }
  }
  
  public void c(Activity paramActivity, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo == null) {}
    while ((paramInt == 1) || (paramInt == 3)) {
      return;
    }
    ((bmtm)bmql.a().c(8)).b();
  }
  
  public String toString()
  {
    return "Music@" + this.d + "@" + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo + hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmta
 * JD-Core Version:    0.7.0.1
 */