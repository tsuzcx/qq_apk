import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.capture.data.GifDecoder;
import com.tencent.qphone.base.util.QLog;

public class bluv
  implements GifDecoder
{
  private int jdField_a_of_type_Int;
  private bmxt jdField_a_of_type_Bmxt;
  private String jdField_a_of_type_JavaLangString;
  
  public bluv(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public Bitmap getNextGifFrame(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AnimationDecodeWrapper", 2, "timestamp:" + paramLong);
    }
    paramLong = paramLong / 1000L / 1000L;
    if (QLog.isColorLevel()) {
      QLog.d("AnimationDecodeWrapper", 2, "timestampMs:" + paramLong);
    }
    if (this.jdField_a_of_type_Bmxt != null) {
      return this.jdField_a_of_type_Bmxt.a(paramLong);
    }
    return null;
  }
  
  public void init()
  {
    this.jdField_a_of_type_Bmxt = bmwa.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_JavaLangString);
  }
  
  public void release()
  {
    this.jdField_a_of_type_Bmxt = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bluv
 * JD-Core Version:    0.7.0.1
 */