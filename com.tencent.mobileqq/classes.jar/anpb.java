import android.os.SystemClock;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.util.WeakReferenceHandler;
import dov.com.qq.im.capture.music.MusicDownloadListener;
import dov.com.qq.im.capture.view.MusicProviderView;

public class anpb
  extends MusicDownloadListener
{
  public anpb(MusicProviderView paramMusicProviderView) {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, int paramInt)
  {
    long l = SystemClock.uptimeMillis();
    if ((this.a.jdField_a_of_type_Long == 0L) || (l - this.a.jdField_a_of_type_Long > 16L))
    {
      this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(2);
      this.a.jdField_a_of_type_Long = l;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(2);
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(2);
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.a().equals(paramString))) {
      this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(1);
    }
    if ((!paramBoolean) && (paramInt == -104)) {
      this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anpb
 * JD-Core Version:    0.7.0.1
 */