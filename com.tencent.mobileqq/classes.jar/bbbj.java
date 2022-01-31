import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import java.util.ArrayList;
import java.util.List;

public class bbbj
  implements acxj
{
  List<View.OnTouchListener> a = new ArrayList();
  List<View.OnLongClickListener> b = new ArrayList();
  List<acxj> c = new ArrayList();
  
  void a(acxj paramacxj)
  {
    this.c.add(paramacxj);
  }
  
  void a(View.OnTouchListener paramOnTouchListener)
  {
    this.a.add(paramOnTouchListener);
  }
  
  public boolean onLongClick(View paramView)
  {
    for (int i = 0;; i = 0) {
      try
      {
        while (i < this.b.size())
        {
          ((View.OnLongClickListener)this.b.get(i)).onLongClick(paramView);
          i += 1;
          continue;
          while (i < this.c.size())
          {
            ((View.OnLongClickListener)this.c.get(i)).onLongClick(paramView);
            i += 1;
          }
          return false;
        }
      }
      finally {}
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    for (int i = 0;; i = 0) {
      try
      {
        while (i < this.a.size())
        {
          ((View.OnTouchListener)this.a.get(i)).onTouch(paramView, paramMotionEvent);
          i += 1;
          continue;
          while (i < this.c.size())
          {
            ((acxj)this.c.get(i)).onTouch(paramView, paramMotionEvent);
            i += 1;
          }
          return false;
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbbj
 * JD-Core Version:    0.7.0.1
 */