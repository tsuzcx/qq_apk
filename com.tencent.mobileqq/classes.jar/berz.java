import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.togetherui.writetogether.WriteTogetherEditorView;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class berz
  implements ValueAnimator.AnimatorUpdateListener
{
  public berz(WriteTogetherEditorView paramWriteTogetherEditorView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if ((WriteTogetherEditorView.a(this.a) != null) && (WriteTogetherEditorView.a(this.a).size() != 0))
    {
      float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      paramValueAnimator = WriteTogetherEditorView.a(this.a).iterator();
      while (paramValueAnimator.hasNext())
      {
        bepb localbepb = (bepb)paramValueAnimator.next();
        if (localbepb.jdField_a_of_type_Float < 0.0F) {
          localbepb.jdField_a_of_type_Float = (1.0F - f1);
        }
        float f2 = localbepb.jdField_a_of_type_Float;
        WriteTogetherEditorView.a(this.a).put(localbepb.jdField_a_of_type_JavaLangString, Float.valueOf((f2 + f1) % 1.0F));
      }
      this.a.invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     berz
 * JD-Core Version:    0.7.0.1
 */