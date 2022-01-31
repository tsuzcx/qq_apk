import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import java.lang.reflect.Field;

public class bejm
  extends LinkMovementMethod
{
  private static MovementMethod jdField_a_of_type_AndroidTextMethodMovementMethod;
  private static Field jdField_a_of_type_JavaLangReflectField;
  
  public static MovementMethod a()
  {
    if (jdField_a_of_type_AndroidTextMethodMovementMethod == null) {
      jdField_a_of_type_AndroidTextMethodMovementMethod = new bejm();
    }
    return jdField_a_of_type_AndroidTextMethodMovementMethod;
  }
  
  public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getActionMasked() == 1) {}
    try
    {
      if (jdField_a_of_type_JavaLangReflectField == null) {
        jdField_a_of_type_JavaLangReflectField = View.class.getDeclaredField("mHasPerformedLongPress");
      }
      jdField_a_of_type_JavaLangReflectField.setAccessible(true);
      boolean bool = jdField_a_of_type_JavaLangReflectField.getBoolean(paramTextView);
      if (bool) {
        return true;
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      localNoSuchFieldException.printStackTrace();
      return super.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        localIllegalAccessException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bejm
 * JD-Core Version:    0.7.0.1
 */