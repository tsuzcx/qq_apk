import android.hardware.Camera.Size;
import java.util.Comparator;

class avwx
  implements Comparator<Camera.Size>
{
  avwx(avwv paramavwv) {}
  
  public int a(Camera.Size paramSize1, Camera.Size paramSize2)
  {
    int i = paramSize1.height * paramSize1.width;
    int j = paramSize2.height * paramSize2.width;
    if (j < i) {
      return 1;
    }
    if (j > i) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avwx
 * JD-Core Version:    0.7.0.1
 */