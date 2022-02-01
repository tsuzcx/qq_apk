import com.tencent.mobileqq.portal.PortalManager.TimerConfig;
import java.util.Comparator;

public final class aznp
  implements Comparator<PortalManager.TimerConfig>
{
  public int a(PortalManager.TimerConfig paramTimerConfig1, PortalManager.TimerConfig paramTimerConfig2)
  {
    long l = paramTimerConfig1.uiBegin - paramTimerConfig2.uiBegin;
    if (l > 0L) {
      return 1;
    }
    if (l < 0L) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aznp
 * JD-Core Version:    0.7.0.1
 */