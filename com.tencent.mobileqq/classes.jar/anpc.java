import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import dov.com.qq.im.capture.music.MusicPlayerSceneListener;
import dov.com.qq.im.capture.music.QimMusicPlayer;
import dov.com.qq.im.capture.view.MusicProviderView;
import dov.com.qq.im.capture.view.ProviderView.ProviderViewListener;

public class anpc
  implements MusicPlayerSceneListener
{
  public anpc(MusicProviderView paramMusicProviderView) {}
  
  public void a()
  {
    this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(2);
  }
  
  public void a(int paramInt, MusicItemInfo paramMusicItemInfo) {}
  
  public void a(MusicItemInfo paramMusicItemInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MusicProviderView", 2, "requestMusicSuccess mListener= " + this.a.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener);
    }
    if (this.a.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener != null)
    {
      if (paramMusicItemInfo.d == 2) {
        this.a.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener.c(true);
      }
    }
    else {
      return;
    }
    this.a.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener.c(false);
  }
  
  public void b(int paramInt, MusicItemInfo paramMusicItemInfo)
  {
    if ((paramInt != -1) && (MusicProviderView.a(this.a) != null)) {
      MusicProviderView.a(this.a).f();
    }
  }
  
  public void b(MusicItemInfo paramMusicItemInfo) {}
  
  public void c(int paramInt, MusicItemInfo paramMusicItemInfo) {}
  
  public void d(int paramInt, MusicItemInfo paramMusicItemInfo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anpc
 * JD-Core Version:    0.7.0.1
 */