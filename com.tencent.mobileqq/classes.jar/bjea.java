import android.view.View;
import android.widget.FrameLayout;

public class bjea
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
    biwp localbiwp = new biwp(localView);
    localbiwp.setDuration(jdField_a_of_type_Long);
    localbiwp.setFillAfter(true);
    biwq localbiwq = new biwq(paramFrameLayout);
    localbiwq.setDuration(jdField_a_of_type_Long);
    localbiwq.setFillAfter(true);
    localView.startAnimation(localbiwp);
    paramFrameLayout.startAnimation(localbiwq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjea
 * JD-Core Version:    0.7.0.1
 */