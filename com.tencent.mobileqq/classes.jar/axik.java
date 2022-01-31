import com.tencent.mobileqq.teamwork.PadInfo;
import com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity;
import java.util.Comparator;

public class axik
  implements Comparator<PadInfo>
{
  public axik(GroupTeamWorkListActivity paramGroupTeamWorkListActivity) {}
  
  public int a(PadInfo paramPadInfo1, PadInfo paramPadInfo2)
  {
    long l = paramPadInfo2.lastEditTime - paramPadInfo1.lastEditTime;
    if (l > 0L) {
      return 1;
    }
    if (l < 0L) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axik
 * JD-Core Version:    0.7.0.1
 */