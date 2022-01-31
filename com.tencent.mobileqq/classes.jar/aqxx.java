import android.graphics.Bitmap;
import com.etrump.mixlayout.EMEmoticon;
import com.etrump.mixlayout.ETFont;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import java.lang.ref.WeakReference;

public class aqxx
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private ETFont jdField_a_of_type_ComEtrumpMixlayoutETFont;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<HiBoomTextView> jdField_a_of_type_JavaLangRefWeakReference;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  
  public static aqxx a(HiBoomTextView paramHiBoomTextView)
  {
    if (paramHiBoomTextView != null)
    {
      aqxx localaqxx = new aqxx();
      localaqxx.jdField_a_of_type_Long = HiBoomTextView.a(paramHiBoomTextView);
      localaqxx.jdField_a_of_type_JavaLangString = HiBoomTextView.a(paramHiBoomTextView);
      localaqxx.jdField_a_of_type_ComEtrumpMixlayoutETFont = new ETFont(0, null, 0.0F);
      localaqxx.jdField_a_of_type_ComEtrumpMixlayoutETFont.copy(HiBoomTextView.a(paramHiBoomTextView));
      localaqxx.jdField_a_of_type_AndroidGraphicsBitmap = paramHiBoomTextView.a.a();
      localaqxx.jdField_a_of_type_Int = HiBoomTextView.a(paramHiBoomTextView);
      localaqxx.jdField_b_of_type_Int = HiBoomTextView.a(paramHiBoomTextView).currentFrameIndex();
      localaqxx.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramHiBoomTextView);
      localaqxx.jdField_b_of_type_Long = System.currentTimeMillis();
      return localaqxx;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqxx
 * JD-Core Version:    0.7.0.1
 */