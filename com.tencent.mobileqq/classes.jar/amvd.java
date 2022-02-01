import com.tencent.mobileqq.data.LebaPluginInfo;
import java.util.Comparator;

public class amvd
  implements Comparator<aqmf>
{
  private boolean a(aqmf paramaqmf)
  {
    return (paramaqmf != null) && (paramaqmf.a != null);
  }
  
  public int a(aqmf paramaqmf1, aqmf paramaqmf2)
  {
    if ((a(paramaqmf1)) && (a(paramaqmf2))) {
      if (paramaqmf1.a.sPriority <= paramaqmf2.a.sPriority) {}
    }
    do
    {
      return 1;
      if (paramaqmf1.a.sPriority < paramaqmf2.a.sPriority) {
        return -1;
      }
      return 0;
      if (a(paramaqmf1)) {
        return -1;
      }
    } while (a(paramaqmf2));
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amvd
 * JD-Core Version:    0.7.0.1
 */