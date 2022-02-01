import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import com.tencent.mobileqq.ocr.OCRResultFragmentNew;

public class ayyt
  extends azcf
{
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public ayyt(OCRResultFragmentNew paramOCRResultFragmentNew) {}
  
  public void a(MotionEvent paramMotionEvent)
  {
    super.a(paramMotionEvent);
    if ((this.jdField_a_of_type_Boolean) || (this.b)) {
      ayyb.a("0X800AC97", 0);
    }
  }
  
  public void a(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    this.b = true;
    return super.a(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayyt
 * JD-Core Version:    0.7.0.1
 */