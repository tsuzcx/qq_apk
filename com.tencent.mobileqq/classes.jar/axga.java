import android.util.Size;
import java.util.Comparator;

public class axga
  implements Comparator<Size>
{
  public int a(Size paramSize1, Size paramSize2)
  {
    return Long.signum(paramSize1.getWidth() * paramSize1.getHeight() - paramSize2.getWidth() * paramSize2.getHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axga
 * JD-Core Version:    0.7.0.1
 */