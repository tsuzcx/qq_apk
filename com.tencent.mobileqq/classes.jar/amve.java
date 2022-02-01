import com.tencent.mobileqq.data.LebaPluginInfo;
import java.util.Comparator;

public class amve
  implements Comparator<aqmf>
{
  public int a(aqmf paramaqmf1, aqmf paramaqmf2)
  {
    if (paramaqmf1.b > paramaqmf2.b) {}
    do
    {
      return 1;
      if (paramaqmf1.b < paramaqmf2.b) {
        return -1;
      }
    } while (paramaqmf1.a.sPriority > paramaqmf2.a.sPriority);
    if (paramaqmf1.a.sPriority < paramaqmf2.a.sPriority) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amve
 * JD-Core Version:    0.7.0.1
 */