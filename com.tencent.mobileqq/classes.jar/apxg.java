import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class apxg
  extends aptq<apxf>
{
  @NonNull
  public apxf a(int paramInt)
  {
    return new apxf();
  }
  
  @Nullable
  public apxf a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0) && (paramArrayOfaptx[0] != null))
    {
      apxf localapxf = apxf.a(paramArrayOfaptx[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("DeviceManageConfProcessor", 2, "onParsed " + paramArrayOfaptx[0].a);
      }
      return localapxf;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DeviceManageConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public void a(apxf paramapxf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DeviceManageConfProcessor", 2, "onUpdate " + paramapxf.toString());
    }
  }
  
  public Class<apxf> clazz()
  {
    return apxf.class;
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
    if (QLog.isColorLevel()) {
      QLog.d("DeviceManageConfProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DeviceManageConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 528;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apxg
 * JD-Core Version:    0.7.0.1
 */