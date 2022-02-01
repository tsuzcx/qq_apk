import android.view.View;
import android.widget.FrameLayout;

public class bidc
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
    bhvr localbhvr = new bhvr(localView);
    localbhvr.setDuration(jdField_a_of_type_Long);
    localbhvr.setFillAfter(true);
    bhvs localbhvs = new bhvs(paramFrameLayout);
    localbhvs.setDuration(jdField_a_of_type_Long);
    localbhvs.setFillAfter(true);
    localView.startAnimation(localbhvr);
    paramFrameLayout.startAnimation(localbhvs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bidc
 * JD-Core Version:    0.7.0.1
 */