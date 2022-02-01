import android.graphics.Bitmap;
import com.etrump.mixlayout.EMEmoticon;
import com.etrump.mixlayout.ETFont;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import java.lang.ref.WeakReference;

public class auzy
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private ETFont jdField_a_of_type_ComEtrumpMixlayoutETFont;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<HiBoomTextView> jdField_a_of_type_JavaLangRefWeakReference;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  
  public static auzy a(HiBoomTextView paramHiBoomTextView)
  {
    if (paramHiBoomTextView != null)
    {
      auzy localauzy = new auzy();
      localauzy.jdField_a_of_type_Long = HiBoomTextView.a(paramHiBoomTextView);
      localauzy.jdField_a_of_type_JavaLangString = HiBoomTextView.a(paramHiBoomTextView);
      localauzy.jdField_a_of_type_ComEtrumpMixlayoutETFont = new ETFont(0, null, 0.0F);
      localauzy.jdField_a_of_type_ComEtrumpMixlayoutETFont.copy(HiBoomTextView.a(paramHiBoomTextView));
      localauzy.jdField_a_of_type_AndroidGraphicsBitmap = paramHiBoomTextView.a.a();
      localauzy.jdField_a_of_type_Int = HiBoomTextView.a(paramHiBoomTextView);
      localauzy.jdField_b_of_type_Int = HiBoomTextView.a(paramHiBoomTextView).currentFrameIndex();
      localauzy.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramHiBoomTextView);
      localauzy.jdField_b_of_type_Long = System.currentTimeMillis();
      return localauzy;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auzy
 * JD-Core Version:    0.7.0.1
 */