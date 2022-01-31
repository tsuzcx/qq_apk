import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qphone.base.util.QLog;

public class atbl
  extends ayoz
{
  private NearbyAppInterface a;
  
  public atbl(NearbyAppInterface paramNearbyAppInterface)
  {
    super(paramNearbyAppInterface);
    this.a = paramNearbyAppInterface;
  }
  
  public aypb a(aywc paramaywc)
  {
    if (paramaywc == null) {}
    do
    {
      return null;
      if ((paramaywc.b == 8) || (paramaywc.b == 64) || (paramaywc.b == 21)) {
        return new aysv(this, paramaywc);
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.richmedia.TransFileController", 2, paramaywc.toString());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atbl
 * JD-Core Version:    0.7.0.1
 */