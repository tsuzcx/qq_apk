import android.graphics.Bitmap;
import com.qflutter.qqface.data.QQFaceNativeData;
import com.qflutter.qqface.loader.QQFaceLoader;

class atkk
  implements atko
{
  atkk(atkj paramatkj) {}
  
  public void a(atkh paramatkh, Bitmap paramBitmap, String paramString)
  {
    QQFaceNativeData localQQFaceNativeData = new QQFaceNativeData();
    localQQFaceNativeData.setBitmap(paramBitmap);
    localQQFaceNativeData.setPath(paramString);
    QQFaceLoader.instance().onUpdate(paramatkh.d, localQQFaceNativeData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atkk
 * JD-Core Version:    0.7.0.1
 */