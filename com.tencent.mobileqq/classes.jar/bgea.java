import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.qphone.base.util.QLog;

class bgea
  implements FaceDecoder.DecodeTaskCompletionListener
{
  bgea(bgdy parambgdy) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (bgdy.a(this.a) != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, String.format("onDecodeTaskCompleted uin=%s", new Object[] { paramString }));
      }
      if (!TextUtils.isEmpty(paramString)) {
        bgdy.a(this.a).b(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgea
 * JD-Core Version:    0.7.0.1
 */