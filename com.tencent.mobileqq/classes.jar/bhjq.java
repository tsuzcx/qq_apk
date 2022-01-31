import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.image.NativeApngDecoder;
import com.tencent.mobileqq.richmedia.capture.data.GifDecoder;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class bhjq
  implements GifDecoder
{
  private NativeApngDecoder jdField_a_of_type_ComTencentImageNativeApngDecoder;
  private String jdField_a_of_type_JavaLangString;
  
  public bhjq(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public Bitmap getNextGifFrame(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentImageNativeApngDecoder != null) {
      return this.jdField_a_of_type_ComTencentImageNativeApngDecoder.getNextFrameBitmap(paramLong);
    }
    return null;
  }
  
  public void init()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    File localFile;
    do
    {
      do
      {
        return;
        if (baon.a().b()) {
          break;
        }
        baon.a().a();
      } while (!QLog.isColorLevel());
      QLog.d("ApngDecodeWrapper", 2, "so not loaded");
      return;
      localFile = new File(this.jdField_a_of_type_JavaLangString);
    } while ((!localFile.exists()) || (!localFile.isFile()));
    try
    {
      this.jdField_a_of_type_ComTencentImageNativeApngDecoder = new NativeApngDecoder(localFile);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void release()
  {
    this.jdField_a_of_type_ComTencentImageNativeApngDecoder = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhjq
 * JD-Core Version:    0.7.0.1
 */