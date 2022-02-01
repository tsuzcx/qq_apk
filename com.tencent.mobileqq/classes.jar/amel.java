import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/weather/config/WeatherConfigProcessor;", "Lcom/tencent/mobileqq/config/IQConfigProcessor;", "Lcom/tencent/mobileqq/activity/weather/config/WeatherConfigBean;", "()V", "clazz", "Ljava/lang/Class;", "isAccountRelated", "", "isNeedCompressed", "isNeedStoreLargeFile", "isNeedUpgradeReset", "migrateOldOrDefaultContent", "type", "", "migrateOldVersion", "onParsed", "confFiles", "", "Lcom/tencent/mobileqq/config/QConfItem;", "([Lcom/tencent/mobileqq/config/QConfItem;)Lcom/tencent/mobileqq/activity/weather/config/WeatherConfigBean;", "onReqFailed", "", "failCode", "onUpdate", "newConf", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class amel
  extends aqwt<amej>
{
  public static final amem a = new amem(null);
  
  @NotNull
  public amej a(int paramInt)
  {
    return new amej(false, 1, null);
  }
  
  @Nullable
  public amej a(@Nullable aqxa[] paramArrayOfaqxa)
  {
    if (paramArrayOfaqxa != null)
    {
      paramArrayOfaqxa = (aqxa)ArraysKt.firstOrNull(paramArrayOfaqxa);
      if (paramArrayOfaqxa != null)
      {
        paramArrayOfaqxa = paramArrayOfaqxa.a;
        if (paramArrayOfaqxa != null) {
          return amej.a.a(paramArrayOfaqxa);
        }
      }
    }
    return null;
  }
  
  public void a(@Nullable amej paramamej)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeatherConfigProcessor", 2, "onUpdate newConf:" + paramamej);
    }
  }
  
  @NotNull
  public Class<amej> clazz()
  {
    return amej.class;
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
  
  public boolean isNeedUpgradeReset()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    QLog.w("WeatherConfigProcessor", 2, "onReqFailed, failCode:" + paramInt);
  }
  
  public int type()
  {
    return 702;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amel
 * JD-Core Version:    0.7.0.1
 */