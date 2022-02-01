import android.graphics.Bitmap;
import com.qflutter.qqface.data.QQFaceNativeData;
import com.qflutter.qqface.loader.QQFaceLoader;

class aupe
  implements aupj
{
  aupe(aupd paramaupd) {}
  
  public void a(aupb paramaupb, Bitmap paramBitmap, String paramString)
  {
    QQFaceNativeData localQQFaceNativeData = new QQFaceNativeData();
    localQQFaceNativeData.setBitmap(paramBitmap);
    localQQFaceNativeData.setPath(paramString);
    QQFaceLoader.instance().onUpdate(paramaupb.d, localQQFaceNativeData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aupe
 * JD-Core Version:    0.7.0.1
 */