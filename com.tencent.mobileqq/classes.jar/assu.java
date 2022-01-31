import android.graphics.Bitmap;
import com.etrump.mixlayout.EMEmoticon;
import com.etrump.mixlayout.ETFont;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import java.lang.ref.WeakReference;

public class assu
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private ETFont jdField_a_of_type_ComEtrumpMixlayoutETFont;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<HiBoomTextView> jdField_a_of_type_JavaLangRefWeakReference;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  
  public static assu a(HiBoomTextView paramHiBoomTextView)
  {
    if (paramHiBoomTextView != null)
    {
      assu localassu = new assu();
      localassu.jdField_a_of_type_Long = HiBoomTextView.a(paramHiBoomTextView);
      localassu.jdField_a_of_type_JavaLangString = HiBoomTextView.a(paramHiBoomTextView);
      localassu.jdField_a_of_type_ComEtrumpMixlayoutETFont = new ETFont(0, null, 0.0F);
      localassu.jdField_a_of_type_ComEtrumpMixlayoutETFont.copy(HiBoomTextView.a(paramHiBoomTextView));
      localassu.jdField_a_of_type_AndroidGraphicsBitmap = paramHiBoomTextView.a.a();
      localassu.jdField_a_of_type_Int = HiBoomTextView.a(paramHiBoomTextView);
      localassu.jdField_b_of_type_Int = HiBoomTextView.a(paramHiBoomTextView).currentFrameIndex();
      localassu.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramHiBoomTextView);
      localassu.jdField_b_of_type_Long = System.currentTimeMillis();
      return localassu;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     assu
 * JD-Core Version:    0.7.0.1
 */