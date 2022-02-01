import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class arnw
  extends aqwt<arnv>
{
  public static arnv a()
  {
    return (arnv)aqxe.a().a(377);
  }
  
  @NonNull
  public arnv a(int paramInt)
  {
    return new arnv();
  }
  
  @Nullable
  public arnv a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return arnv.a(paramArrayOfaqxa);
    }
    return null;
  }
  
  public void a(arnv paramarnv) {}
  
  public Class<arnv> clazz()
  {
    return arnv.class;
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
    return 377;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arnw
 * JD-Core Version:    0.7.0.1
 */