import android.graphics.Bitmap;
import com.etrump.mixlayout.EMEmoticon;
import com.etrump.mixlayout.ETFont;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import java.lang.ref.WeakReference;

public class aqdt
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private ETFont jdField_a_of_type_ComEtrumpMixlayoutETFont;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<HiBoomTextView> jdField_a_of_type_JavaLangRefWeakReference;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  
  public static aqdt a(HiBoomTextView paramHiBoomTextView)
  {
    if (paramHiBoomTextView != null)
    {
      aqdt localaqdt = new aqdt();
      localaqdt.jdField_a_of_type_Long = HiBoomTextView.a(paramHiBoomTextView);
      localaqdt.jdField_a_of_type_JavaLangString = HiBoomTextView.a(paramHiBoomTextView);
      localaqdt.jdField_a_of_type_ComEtrumpMixlayoutETFont = new ETFont(0, null, 0.0F);
      localaqdt.jdField_a_of_type_ComEtrumpMixlayoutETFont.copy(HiBoomTextView.a(paramHiBoomTextView));
      localaqdt.jdField_a_of_type_AndroidGraphicsBitmap = paramHiBoomTextView.a.a();
      localaqdt.jdField_a_of_type_Int = HiBoomTextView.a(paramHiBoomTextView);
      localaqdt.jdField_b_of_type_Int = HiBoomTextView.a(paramHiBoomTextView).currentFrameIndex();
      localaqdt.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramHiBoomTextView);
      localaqdt.jdField_b_of_type_Long = System.currentTimeMillis();
      return localaqdt;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqdt
 * JD-Core Version:    0.7.0.1
 */