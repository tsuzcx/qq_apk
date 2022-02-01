import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class bmxs
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private int jdField_a_of_type_Int;
  
  bmxs(bmxa parambmxa) {}
  
  public void onGlobalLayout()
  {
    int i = this.jdField_a_of_type_Int + 1;
    this.jdField_a_of_type_Int = i;
    ViewTreeObserver localViewTreeObserver;
    if (i > 1)
    {
      localViewTreeObserver = this.jdField_a_of_type_Bmxa.b.getViewTreeObserver();
      if (localViewTreeObserver.isAlive())
      {
        if (Build.VERSION.SDK_INT < 16) {
          break label110;
        }
        localViewTreeObserver.removeOnGlobalLayoutListener(this);
      }
    }
    for (;;)
    {
      bnrg.a(new alsn(this.jdField_a_of_type_Bmxa.b.getMeasuredWidth(), this.jdField_a_of_type_Bmxa.b.getMeasuredHeight()));
      bnrh.b(this.jdField_a_of_type_Bmxa.a, "mMaxPreviewSize set: " + bnrg.a());
      return;
      label110:
      localViewTreeObserver.removeGlobalOnLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmxs
 * JD-Core Version:    0.7.0.1
 */