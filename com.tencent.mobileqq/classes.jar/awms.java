import com.tencent.mobileqq.portal.PortalManager.ComboNumber;
import java.util.Comparator;

public class awms
  implements Comparator<PortalManager.ComboNumber>
{
  public int a(PortalManager.ComboNumber paramComboNumber1, PortalManager.ComboNumber paramComboNumber2)
  {
    if (paramComboNumber1.number > paramComboNumber2.number) {
      return 1;
    }
    if (paramComboNumber1.number < paramComboNumber2.number) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awms
 * JD-Core Version:    0.7.0.1
 */