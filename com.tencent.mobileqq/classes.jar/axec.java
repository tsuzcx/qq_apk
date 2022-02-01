import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qphone.base.util.QLog;

public class axec
  extends bdsv
{
  private NearbyAppInterface a;
  
  public axec(NearbyAppInterface paramNearbyAppInterface)
  {
    super(paramNearbyAppInterface);
    this.a = paramNearbyAppInterface;
  }
  
  public bdsx a(bdzn parambdzn)
  {
    if (parambdzn == null) {}
    do
    {
      return null;
      if ((parambdzn.b == 8) || (parambdzn.b == 64) || (parambdzn.b == 21)) {
        return new bdwp(this, parambdzn);
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.richmedia.TransFileController", 2, parambdzn.toString());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axec
 * JD-Core Version:    0.7.0.1
 */