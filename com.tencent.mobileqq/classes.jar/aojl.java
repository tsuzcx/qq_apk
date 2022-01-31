import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Comparator;

class aojl
  implements Comparator<Rect>
{
  aojl(aojk paramaojk) {}
  
  public int a(Rect paramRect1, Rect paramRect2)
  {
    if (this.a.g.contains(paramRect1)) {}
    do
    {
      do
      {
        return 1;
        if (this.a.g.contains(paramRect2)) {
          return -1;
        }
        if (paramRect1.height() * paramRect1.width() > paramRect2.height() * paramRect2.width()) {
          return -1;
        }
      } while (paramRect1.height() * paramRect1.width() < paramRect2.height() * paramRect2.width());
      if (paramRect1.width() > paramRect2.width()) {
        return -1;
      }
    } while (paramRect1.width() < paramRect2.width());
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aojl
 * JD-Core Version:    0.7.0.1
 */