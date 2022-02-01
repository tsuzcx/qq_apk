import com.tencent.mobileqq.data.LebaPluginInfo;
import java.util.Comparator;

public class anxq
  implements Comparator<arpq>
{
  private boolean a(arpq paramarpq)
  {
    return (paramarpq != null) && (paramarpq.a != null);
  }
  
  public int a(arpq paramarpq1, arpq paramarpq2)
  {
    if ((a(paramarpq1)) && (a(paramarpq2))) {
      if (paramarpq1.a.sPriority <= paramarpq2.a.sPriority) {}
    }
    do
    {
      return 1;
      if (paramarpq1.a.sPriority < paramarpq2.a.sPriority) {
        return -1;
      }
      return 0;
      if (a(paramarpq1)) {
        return -1;
      }
    } while (a(paramarpq2));
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anxq
 * JD-Core Version:    0.7.0.1
 */