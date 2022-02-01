import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/troop/troopsettingconfig/TroopSettingConfigProcessor$Companion;", "", "()V", "CONFIG_ID", "", "TAG", "", "checkIsChatSettingNewGroupGrayTroop", "", "troopUin", "loadConfig", "Lcom/tencent/mobileqq/troop/troopsettingconfig/TroopSettingConfigBean;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class bggk
{
  @JvmStatic
  @Nullable
  public final bggh a()
  {
    return (bggh)aqxe.a().a(697);
  }
  
  @JvmStatic
  public final boolean a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "troopUin");
    bggh localbggh = ((bggk)this).a();
    if (localbggh != null) {}
    for (boolean bool = localbggh.a(paramString);; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopSettingConfigProcessor", 2, "checkIsChatSettingNewGroupGrayTroop troopUin = " + paramString + ",result = " + bool);
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bggk
 * JD-Core Version:    0.7.0.1
 */