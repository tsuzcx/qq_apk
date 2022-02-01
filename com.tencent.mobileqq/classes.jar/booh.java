import android.os.Message;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.MusicProviderView;

public class booh
  implements bojc
{
  public booh(MusicProviderView paramMusicProviderView) {}
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MusicProviderView", 2, "onStep:" + paramInt + " done:" + paramBoolean);
    }
    if ((paramInt == 6) || (paramInt == 5) || (paramInt == 4)) {
      this.a.a.sendEmptyMessage(3);
    }
  }
  
  public void a(MusicItemInfo paramMusicItemInfo)
  {
    Message localMessage = this.a.a.obtainMessage();
    localMessage.obj = paramMusicItemInfo;
    localMessage.what = 4;
    this.a.a.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     booh
 * JD-Core Version:    0.7.0.1
 */