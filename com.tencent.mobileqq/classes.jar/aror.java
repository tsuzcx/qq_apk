import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public final class aror
  extends aqwt<aroq>
{
  public static aroq a()
  {
    QLog.d("TencentDocUrl2DocConfigProcessor", 1, "getConfig");
    return (aroq)aqxe.a().a(559);
  }
  
  public static boolean a(String paramString)
  {
    aroq localaroq = a();
    return (localaroq != null) && (localaroq.a()) && (localaroq.a(paramString));
  }
  
  @NonNull
  public aroq a(int paramInt)
  {
    QLog.w("TencentDocUrl2DocConfigProcessor", 1, "migrateOldOrDefaultContent type:" + paramInt);
    return new aroq();
  }
  
  @Nullable
  public aroq a(aqxa[] paramArrayOfaqxa)
  {
    return aroq.a(paramArrayOfaqxa);
  }
  
  public void a(aroq paramaroq)
  {
    QLog.w("TencentDocUrl2DocConfigProcessor", 1, "onUpdate");
  }
  
  public Class<aroq> clazz()
  {
    return aroq.class;
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
    QLog.e("TencentDocUrl2DocConfigProcessor", 1, "onReqFailed: " + paramInt);
  }
  
  public int type()
  {
    return 559;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aror
 * JD-Core Version:    0.7.0.1
 */