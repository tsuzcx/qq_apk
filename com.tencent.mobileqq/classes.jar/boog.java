import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.MusicProviderView;

public class boog
  implements boiz
{
  public boog(MusicProviderView paramMusicProviderView) {}
  
  public void a()
  {
    this.a.jdField_a_of_type_Bkys.sendEmptyMessage(2);
  }
  
  public void a(int paramInt, MusicItemInfo paramMusicItemInfo) {}
  
  public void a(MusicItemInfo paramMusicItemInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MusicProviderView", 2, "requestMusicSuccess mListener= " + this.a.jdField_a_of_type_Boop);
    }
    if (this.a.jdField_a_of_type_Boop != null)
    {
      if (paramMusicItemInfo.mType == 2) {
        this.a.jdField_a_of_type_Boop.a(true);
      }
    }
    else {
      return;
    }
    this.a.jdField_a_of_type_Boop.a(false);
  }
  
  public void b(int paramInt, MusicItemInfo paramMusicItemInfo)
  {
    if ((paramInt != -1) && (MusicProviderView.a(this.a) != null)) {
      MusicProviderView.a(this.a).d();
    }
  }
  
  public void b(MusicItemInfo paramMusicItemInfo) {}
  
  public void c(int paramInt, MusicItemInfo paramMusicItemInfo) {}
  
  public void d(int paramInt, MusicItemInfo paramMusicItemInfo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boog
 * JD-Core Version:    0.7.0.1
 */