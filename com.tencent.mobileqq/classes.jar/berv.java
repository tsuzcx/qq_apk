import android.view.View;
import android.widget.FrameLayout;

public class berv
{
  private static long jdField_a_of_type_Long = 400L;
  private static boolean jdField_a_of_type_Boolean;
  
  public static void a()
  {
    jdField_a_of_type_Boolean = false;
  }
  
  public static void a(FrameLayout paramFrameLayout)
  {
    if (jdField_a_of_type_Boolean) {
      return;
    }
    jdField_a_of_type_Boolean = true;
    paramFrameLayout.invalidate();
    View localView = paramFrameLayout.getChildAt(1);
    paramFrameLayout = paramFrameLayout.getChildAt(0);
    beke localbeke = new beke(localView);
    localbeke.setDuration(jdField_a_of_type_Long);
    localbeke.setFillAfter(true);
    bekf localbekf = new bekf(paramFrameLayout);
    localbekf.setDuration(jdField_a_of_type_Long);
    localbekf.setFillAfter(true);
    localView.startAnimation(localbeke);
    paramFrameLayout.startAnimation(localbekf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     berv
 * JD-Core Version:    0.7.0.1
 */