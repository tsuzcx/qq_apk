import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qphone.base.util.QLog;

public class atbj
  extends ayox
{
  private NearbyAppInterface a;
  
  public atbj(NearbyAppInterface paramNearbyAppInterface)
  {
    super(paramNearbyAppInterface);
    this.a = paramNearbyAppInterface;
  }
  
  public ayoz a(aywa paramaywa)
  {
    if (paramaywa == null) {}
    do
    {
      return null;
      if ((paramaywa.b == 8) || (paramaywa.b == 64) || (paramaywa.b == 21)) {
        return new ayst(this, paramaywa);
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.richmedia.TransFileController", 2, paramaywa.toString());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atbj
 * JD-Core Version:    0.7.0.1
 */