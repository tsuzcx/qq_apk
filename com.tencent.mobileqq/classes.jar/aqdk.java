import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqdk
  extends aptq<aqdj>
{
  public static aqdj a()
  {
    return (aqdj)apub.a().a(635);
  }
  
  @NonNull
  public aqdj a(int paramInt)
  {
    return new aqdj();
  }
  
  @Nullable
  public aqdj a(aptx[] paramArrayOfaptx)
  {
    QLog.i("TroopFoldMsgConfProcessor", 1, "[onParsed] config");
    aqdj localaqdj2 = null;
    aqdj localaqdj1;
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0) && (paramArrayOfaptx[0] != null))
    {
      localaqdj2 = aqdj.a(paramArrayOfaptx[0].a);
      localaqdj1 = localaqdj2;
      if (QLog.isColorLevel())
      {
        QLog.d("TroopFoldMsgConfProcessor", 2, "onParsed " + paramArrayOfaptx[0].a);
        localaqdj1 = localaqdj2;
      }
    }
    for (;;)
    {
      paramArrayOfaptx = localaqdj1;
      if (localaqdj1 == null) {
        paramArrayOfaptx = new aqdj();
      }
      return paramArrayOfaptx;
      localaqdj1 = localaqdj2;
      if (QLog.isColorLevel())
      {
        QLog.d("TroopFoldMsgConfProcessor", 2, "onParsed is null");
        localaqdj1 = localaqdj2;
      }
    }
  }
  
  public void a(aqdj paramaqdj)
  {
    QLog.i("TroopFoldMsgConfProcessor", 1, "[onUpdate]");
  }
  
  public Class<aqdj> clazz()
  {
    return aqdj.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
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
    QLog.i("TroopFoldMsgConfProcessor", 1, "[onReqFailed] failCode=" + paramInt);
  }
  
  public int type()
  {
    return 635;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqdk
 * JD-Core Version:    0.7.0.1
 */