import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qphone.base.util.QLog;

public class asff
  extends axos
{
  private NearbyAppInterface a;
  
  public asff(NearbyAppInterface paramNearbyAppInterface)
  {
    super(paramNearbyAppInterface);
    this.a = paramNearbyAppInterface;
  }
  
  public axou a(axvt paramaxvt)
  {
    if (paramaxvt == null) {}
    do
    {
      return null;
      if ((paramaxvt.b == 8) || (paramaxvt.b == 64) || (paramaxvt.b == 21)) {
        return new axsm(this, paramaxvt);
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.richmedia.TransFileController", 2, paramaxvt.toString());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     asff
 * JD-Core Version:    0.7.0.1
 */