import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.MusicProviderView;

public class bpvi
  implements bpou
{
  public bpvi(MusicProviderView paramMusicProviderView) {}
  
  public void a()
  {
    this.a.jdField_a_of_type_Blhq.sendEmptyMessage(2);
  }
  
  public void a(int paramInt, MusicItemInfo paramMusicItemInfo) {}
  
  public void a(MusicItemInfo paramMusicItemInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MusicProviderView", 2, "requestMusicSuccess mListener= " + this.a.jdField_a_of_type_Bpvt);
    }
    if (this.a.jdField_a_of_type_Bpvt != null)
    {
      if (paramMusicItemInfo.mType == 2) {
        this.a.jdField_a_of_type_Bpvt.a(true);
      }
    }
    else {
      return;
    }
    this.a.jdField_a_of_type_Bpvt.a(false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpvi
 * JD-Core Version:    0.7.0.1
 */