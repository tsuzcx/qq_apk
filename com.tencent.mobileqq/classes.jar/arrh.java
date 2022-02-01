import com.tencent.mobileqq.extendfriend.wiget.SignalBombAnimationView;
import java.io.File;
import java.util.Comparator;

public class arrh
  implements Comparator<File>
{
  public arrh(SignalBombAnimationView paramSignalBombAnimationView) {}
  
  public int a(File paramFile1, File paramFile2)
  {
    return paramFile1.getName().compareToIgnoreCase(paramFile2.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arrh
 * JD-Core Version:    0.7.0.1
 */