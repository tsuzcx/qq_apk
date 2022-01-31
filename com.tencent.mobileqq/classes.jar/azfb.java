import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class azfb
  implements azwh
{
  azfb(azez paramazez) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (azez.a(this.a) != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, String.format("onDecodeTaskCompleted uin=%s", new Object[] { paramString }));
      }
      if (!TextUtils.isEmpty(paramString)) {
        azez.a(this.a).b(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azfb
 * JD-Core Version:    0.7.0.1
 */