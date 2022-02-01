import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class bofw
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private int jdField_a_of_type_Int;
  
  bofw(bofh parambofh) {}
  
  public void onGlobalLayout()
  {
    int i = this.jdField_a_of_type_Int + 1;
    this.jdField_a_of_type_Int = i;
    ViewTreeObserver localViewTreeObserver;
    if (i > 1)
    {
      localViewTreeObserver = bofh.a(this.jdField_a_of_type_Bofh).getViewTreeObserver();
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
      bpal.a(new alxc(bofh.a(this.jdField_a_of_type_Bofh).getMeasuredWidth(), bofh.a(this.jdField_a_of_type_Bofh).getMeasuredHeight()));
      bpam.b("AEPituCameraUnit", "mMaxPreviewSize set: " + bpal.a());
      return;
      label105:
      localViewTreeObserver.removeGlobalOnLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bofw
 * JD-Core Version:    0.7.0.1
 */