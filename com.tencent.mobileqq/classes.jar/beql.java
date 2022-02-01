import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.together.writetogether.view.WriteTogetherEditorView;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class beql
  implements ValueAnimator.AnimatorUpdateListener
{
  public beql(WriteTogetherEditorView paramWriteTogetherEditorView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if ((WriteTogetherEditorView.a(this.a) != null) && (WriteTogetherEditorView.a(this.a).size() != 0))
    {
      float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      paramValueAnimator = WriteTogetherEditorView.a(this.a).iterator();
      while (paramValueAnimator.hasNext())
      {
        beog localbeog = (beog)paramValueAnimator.next();
        if (localbeog.jdField_a_of_type_Float < 0.0F) {
          localbeog.jdField_a_of_type_Float = (1.0F - f1);
        }
        float f2 = localbeog.jdField_a_of_type_Float;
        WriteTogetherEditorView.a(this.a).put(localbeog.jdField_a_of_type_JavaLangString, Float.valueOf((f2 + f1) % 1.0F));
      }
      this.a.invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beql
 * JD-Core Version:    0.7.0.1
 */