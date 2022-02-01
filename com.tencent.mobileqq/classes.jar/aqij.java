import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

public class aqij
  extends aqgc<aqid>
{
  @NonNull
  public static aqid c()
  {
    aqid localaqid2 = (aqid)apub.a().a(628);
    aqid localaqid1 = localaqid2;
    if (localaqid2 == null) {
      localaqid1 = aqid.a();
    }
    return localaqid1;
  }
  
  @NonNull
  public aqid a()
  {
    return aqid.a();
  }
  
  @NonNull
  public aqid a(@NonNull aptx[] paramArrayOfaptx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QVIP.TROOP_FILE.ConfigProcessor", 1, paramArrayOfaptx[0].a);
    }
    return aqid.a(paramArrayOfaptx[0].a);
  }
  
  @NonNull
  public aqid b()
  {
    return aqid.a();
  }
  
  public Class<aqid> clazz()
  {
    return aqid.class;
  }
  
  public int type()
  {
    return 628;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqij
 * JD-Core Version:    0.7.0.1
 */