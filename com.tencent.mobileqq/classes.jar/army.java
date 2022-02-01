import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class army
  extends aqwt<armx>
{
  public static armx a()
  {
    return (armx)aqxe.a().a(521);
  }
  
  @NonNull
  public armx a(int paramInt)
  {
    return new armx();
  }
  
  @Nullable
  public armx a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return armx.a(paramArrayOfaqxa);
    }
    return null;
  }
  
  public void a(armx paramarmx) {}
  
  public Class<armx> clazz()
  {
    return armx.class;
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
    return 521;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     army
 * JD-Core Version:    0.7.0.1
 */