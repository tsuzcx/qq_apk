import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class bags
  implements baxz
{
  bags(bagq parambagq) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (bagq.a(this.a) != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, String.format("onDecodeTaskCompleted uin=%s", new Object[] { paramString }));
      }
      if (!TextUtils.isEmpty(paramString)) {
        bagq.a(this.a).b(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bags
 * JD-Core Version:    0.7.0.1
 */