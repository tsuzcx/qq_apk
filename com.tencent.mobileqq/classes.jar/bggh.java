import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/troop/troopsettingconfig/TroopSettingConfigBean;", "", "()V", "grayTroopTailCodes", "", "", "isGrayTroop", "", "troopUin", "", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class bggh
{
  public static final bggi a;
  private List<Integer> a;
  
  static
  {
    jdField_a_of_type_Bggi = new bggi(null);
  }
  
  public bggh()
  {
    this.jdField_a_of_type_JavaUtilList = ((List)new ArrayList());
  }
  
  public final boolean a(@NotNull String paramString)
  {
    boolean bool1 = true;
    Intrinsics.checkParameterIsNotNull(paramString, "troopUin");
    if (QLog.isColorLevel()) {
      QLog.d("TroopSettingConfigBean", 2, "isGrayTroop troopUin = " + paramString);
    }
    boolean bool2;
    if ((TextUtils.isEmpty((CharSequence)paramString)) || (this.jdField_a_of_type_JavaUtilList == null))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder().append("isGrayTroop grayTroopTailCodes isNull:  ");
        if (this.jdField_a_of_type_JavaUtilList != null) {
          break label107;
        }
      }
      label107:
      for (bool1 = true;; bool1 = false)
      {
        QLog.d("TroopSettingConfigBean", 2, bool1);
        bool2 = false;
        return bool2;
      }
    }
    paramString = paramString.substring(paramString.length() - 1);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).substring(startIndex)");
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      Intrinsics.throwNpe();
    }
    int j = ((Collection)localList).size();
    int i = 0;
    label157:
    if (i < j)
    {
      localList = this.jdField_a_of_type_JavaUtilList;
      if (localList == null) {
        Intrinsics.throwNpe();
      }
      if (!Intrinsics.areEqual(String.valueOf(((Number)localList.get(i)).intValue()), paramString)) {}
    }
    for (;;)
    {
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopSettingConfigBean", 2, "isGrayTroop grayTroopTailCodes = " + this.jdField_a_of_type_JavaUtilList + ", isGrayTroop = " + bool1);
      return bool1;
      i += 1;
      break label157;
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bggh
 * JD-Core Version:    0.7.0.1
 */