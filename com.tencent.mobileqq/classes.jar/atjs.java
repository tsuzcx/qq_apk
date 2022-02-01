import android.graphics.Bitmap;
import com.qflutter.qflutter_network_image.LoadBitmapCallback;
import com.qflutter.qflutter_network_image.QFlutterNetworkImageInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.Option;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class atjs
  implements QFlutterNetworkImageInterface
{
  private static String jdField_a_of_type_JavaLangString;
  private Map<String, Bitmap> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  public static void a(String paramString)
  {
    jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String getLibPath()
  {
    QLog.d("QFlutterNetworkImageImpl", 2, "[getLibPath] libPath=" + jdField_a_of_type_JavaLangString);
    return jdField_a_of_type_JavaLangString;
  }
  
  public void loadBitmap(String paramString, int paramInt1, int paramInt2, LoadBitmapCallback paramLoadBitmapCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutterNetworkImageImpl", 2, "[loadBitmap] url=" + paramString + ", decodeWidth=" + paramInt1 + ", decodeHeight=" + paramInt2);
    }
    paramString = new Option().setUrl(paramString).setPredecode(true);
    if ((paramInt1 > 0) && (paramInt2 > 0)) {
      paramString.setRequestWidth(paramInt1).setRequestHeight(paramInt2);
    }
    QCircleFeedPicLoader.g().loadImage(paramString, new atjt(this, paramLoadBitmapCallback));
  }
  
  public void releaseBitmap(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutterNetworkImageImpl", 2, "[releaseBitmap] url=" + paramString);
    }
    paramString = (Bitmap)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
    if ((paramString == null) || (paramString.isRecycled())) {
      QLog.w("QFlutterNetworkImageImpl", 1, "[releaseBitmap] bitmap is not supposed to be recycled or null, some problems occurred");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atjs
 * JD-Core Version:    0.7.0.1
 */