import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class apxc
  extends aptq<apxb>
{
  @NonNull
  public apxb a(int paramInt)
  {
    return new apxb().b("0");
  }
  
  @Nullable
  public apxb a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      apxb localapxb = apxb.a(paramArrayOfaptx[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("C2CLovePushGrayProcessor", 2, "onParsed " + paramArrayOfaptx[0].a);
      }
      return localapxb;
    }
    return null;
  }
  
  public void a(apxb paramapxb) {}
  
  public Class<apxb> clazz()
  {
    return apxb.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CLovePushGrayProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 452;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apxc
 * JD-Core Version:    0.7.0.1
 */