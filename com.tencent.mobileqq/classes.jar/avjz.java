import com.tencent.mobileqq.gamecenter.data.PadFaceAd;
import java.util.Comparator;

final class avjz
  implements Comparator<PadFaceAd>
{
  public int a(PadFaceAd paramPadFaceAd1, PadFaceAd paramPadFaceAd2)
  {
    if (paramPadFaceAd1.startTime < paramPadFaceAd2.startTime) {
      return -1;
    }
    if (paramPadFaceAd1.startTime == paramPadFaceAd2.startTime) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avjz
 * JD-Core Version:    0.7.0.1
 */