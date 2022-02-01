import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ayat
  implements View.OnTouchListener
{
  private ayat(ayar paramayar) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool3 = true;
    boolean bool2 = false;
    int i = paramMotionEvent.getAction();
    Object localObject = this.a;
    boolean bool1 = bool3;
    if (i != 1) {
      if (i != 3) {
        break label105;
      }
    }
    label105:
    for (bool1 = bool3;; bool1 = false)
    {
      ((ayar)localObject).b = bool1;
      if ((this.a.b) && (this.a.jdField_a_of_type_Int != 2)) {
        this.a.a();
      }
      localObject = this.a.jdField_a_of_type_Ayaq.a();
      bool1 = bool2;
      if (localObject != null) {
        bool1 = ((View.OnTouchListener)localObject).onTouch(paramView, paramMotionEvent);
      }
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayat
 * JD-Core Version:    0.7.0.1
 */