import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqck
  extends aptq<aqcj>
{
  @NonNull
  public aqcj a(int paramInt)
  {
    return new aqcj();
  }
  
  @Nullable
  public aqcj a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      aqcj localaqcj = aqcj.a(paramArrayOfaptx[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("RelationVipGrayProcessor", 2, "onParsed " + paramArrayOfaptx[0].a);
      }
      return localaqcj;
    }
    return new aqcj();
  }
  
  public void a(aqcj paramaqcj) {}
  
  public Class<aqcj> clazz()
  {
    return aqcj.class;
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
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 490;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqck
 * JD-Core Version:    0.7.0.1
 */