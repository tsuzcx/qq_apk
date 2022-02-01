import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class blkl
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private int jdField_a_of_type_Int;
  
  blkl(bljy parambljy) {}
  
  public void onGlobalLayout()
  {
    int i = this.jdField_a_of_type_Int + 1;
    this.jdField_a_of_type_Int = i;
    ViewTreeObserver localViewTreeObserver;
    if (i > 1)
    {
      localViewTreeObserver = this.jdField_a_of_type_Bljy.b.getViewTreeObserver();
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
      bmbw.a(new akur(this.jdField_a_of_type_Bljy.b.getMeasuredWidth(), this.jdField_a_of_type_Bljy.b.getMeasuredHeight()));
      bmbx.b(this.jdField_a_of_type_Bljy.a, "mMaxPreviewSize set: " + bmbw.a());
      return;
      label110:
      localViewTreeObserver.removeGlobalOnLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blkl
 * JD-Core Version:    0.7.0.1
 */