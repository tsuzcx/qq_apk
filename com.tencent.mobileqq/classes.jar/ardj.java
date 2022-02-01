import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/config/business/BrowserOpenConfProcessor;", "Lcom/tencent/mobileqq/config/IQConfigProcessor;", "Lcom/tencent/mobileqq/config/business/BrowserOpenBean;", "()V", "clazz", "Ljava/lang/Class;", "isNeedCompressed", "", "isNeedStoreLargeFile", "migrateOldOrDefaultContent", "type", "", "migrateOldVersion", "onParsed", "confFiles", "", "Lcom/tencent/mobileqq/config/QConfItem;", "([Lcom/tencent/mobileqq/config/QConfItem;)Lcom/tencent/mobileqq/config/business/BrowserOpenBean;", "onReqFailed", "", "failCode", "onUpdate", "newConf", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ardj
  extends arac<ardi>
{
  @NotNull
  public ardi a(int paramInt)
  {
    return new ardi();
  }
  
  @Nullable
  public ardi a(@NotNull araj[] paramArrayOfaraj)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfaraj, "confFiles");
    if ((paramArrayOfaraj.length > 0) && (paramArrayOfaraj[0] != null))
    {
      ardi localardi = ardk.a(paramArrayOfaraj[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("[BrowserOpt] H5BrowserOpenConfProcessor", 2, "onParsed " + paramArrayOfaraj[0].a);
      }
      return localardi;
    }
    if (QLog.isColorLevel()) {
      QLog.d("[BrowserOpt] H5BrowserOpenConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public void a(@NotNull ardi paramardi)
  {
    Intrinsics.checkParameterIsNotNull(paramardi, "newConf");
    if (QLog.isColorLevel()) {
      QLog.d("[BrowserOpt] H5BrowserOpenConfProcessor", 2, "onUpdate " + paramardi);
    }
  }
  
  @NotNull
  public Class<ardi> clazz()
  {
    return ardi.class;
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
    return 627;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ardj
 * JD-Core Version:    0.7.0.1
 */