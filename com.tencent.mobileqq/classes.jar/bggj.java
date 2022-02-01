import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/troop/troopsettingconfig/TroopSettingConfigProcessor;", "Lcom/tencent/mobileqq/config/IQConfigProcessor;", "Lcom/tencent/mobileqq/troop/troopsettingconfig/TroopSettingConfigBean;", "()V", "clazz", "Ljava/lang/Class;", "isNeedCompressed", "", "isNeedStoreLargeFile", "migrateOldOrDefaultContent", "type", "", "migrateOldVersion", "onParsed", "confFiles", "", "Lcom/tencent/mobileqq/config/QConfItem;", "([Lcom/tencent/mobileqq/config/QConfItem;)Lcom/tencent/mobileqq/troop/troopsettingconfig/TroopSettingConfigBean;", "onReqFailed", "", "failCode", "onUpdate", "newConf", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class bggj
  extends aqwt<bggh>
{
  public static final bggk a = new bggk(null);
  
  @JvmStatic
  public static final boolean a(@NotNull String paramString)
  {
    return a.a(paramString);
  }
  
  @NotNull
  public bggh a(int paramInt)
  {
    return new bggh();
  }
  
  @Nullable
  public bggh a(@Nullable aqxa[] paramArrayOfaqxa)
  {
    int j = 1;
    if (paramArrayOfaqxa != null)
    {
      if (paramArrayOfaqxa.length == 0)
      {
        i = 1;
        if (i != 0) {
          break label53;
        }
      }
      label53:
      for (int i = j;; i = 0)
      {
        if (i == 0) {
          break label58;
        }
        bggi localbggi = bggh.a;
        paramArrayOfaqxa = paramArrayOfaqxa[0].a;
        Intrinsics.checkExpressionValueIsNotNull(paramArrayOfaqxa, "confFiles[0].content");
        return localbggi.a(paramArrayOfaqxa);
        i = 0;
        break;
      }
    }
    label58:
    return null;
  }
  
  public void a(@Nullable bggh parambggh) {}
  
  @NotNull
  public Class<bggh> clazz()
  {
    return bggh.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    QLog.d("TroopSettingConfigProcessor", 1, "onReqFailed, failCode = " + paramInt);
  }
  
  public int type()
  {
    return 697;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bggj
 * JD-Core Version:    0.7.0.1
 */