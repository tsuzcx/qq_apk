import android.view.View;
import android.widget.FrameLayout;

public class bium
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
    binj localbinj = new binj(localView);
    localbinj.setDuration(jdField_a_of_type_Long);
    localbinj.setFillAfter(true);
    bink localbink = new bink(paramFrameLayout);
    localbink.setDuration(jdField_a_of_type_Long);
    localbink.setFillAfter(true);
    localView.startAnimation(localbinj);
    paramFrameLayout.startAnimation(localbink);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bium
 * JD-Core Version:    0.7.0.1
 */