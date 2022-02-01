import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class bneo
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private int jdField_a_of_type_Int;
  
  bneo(bndy parambndy) {}
  
  public void onGlobalLayout()
  {
    int i = this.jdField_a_of_type_Int + 1;
    this.jdField_a_of_type_Int = i;
    ViewTreeObserver localViewTreeObserver;
    if (i > 1)
    {
      localViewTreeObserver = bndy.a(this.jdField_a_of_type_Bndy).getViewTreeObserver();
      if (localViewTreeObserver.isAlive())
      {
        if (Build.VERSION.SDK_INT < 16) {
          break label105;
        }
        localViewTreeObserver.removeOnGlobalLayoutListener(this);
      }
    }
    for (;;)
    {
      bnza.a(new allk(bndy.a(this.jdField_a_of_type_Bndy).getMeasuredWidth(), bndy.a(this.jdField_a_of_type_Bndy).getMeasuredHeight()));
      bnzb.b("AEPituCameraUnit", "mMaxPreviewSize set: " + bnza.a());
      return;
      label105:
      localViewTreeObserver.removeGlobalOnLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bneo
 * JD-Core Version:    0.7.0.1
 */