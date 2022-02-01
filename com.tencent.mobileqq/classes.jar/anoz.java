import com.tencent.mobileqq.data.LebaPluginInfo;
import java.util.Comparator;

public class anoz
  implements Comparator<arcs>
{
  private boolean a(arcs paramarcs)
  {
    return (paramarcs != null) && (paramarcs.a != null);
  }
  
  public int a(arcs paramarcs1, arcs paramarcs2)
  {
    if ((a(paramarcs1)) && (a(paramarcs2))) {
      if (paramarcs1.a.sPriority <= paramarcs2.a.sPriority) {}
    }
    do
    {
      return 1;
      if (paramarcs1.a.sPriority < paramarcs2.a.sPriority) {
        return -1;
      }
      return 0;
      if (a(paramarcs1)) {
        return -1;
      }
    } while (a(paramarcs2));
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anoz
 * JD-Core Version:    0.7.0.1
 */