import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/troop/troopsettingconfig/TroopSettingConfigBean$Companion;", "", "()V", "KEY_GRAY_TROOP_TAIL_CODES", "", "TAG", "parse", "Lcom/tencent/mobileqq/troop/troopsettingconfig/TroopSettingConfigBean;", "content", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class bggi
{
  @JvmStatic
  @Nullable
  public final bggh a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "content");
    if (QLog.isColorLevel()) {
      QLog.d("TroopSettingConfigBean", 2, "parse content = " + paramString);
    }
    if (TextUtils.isEmpty((CharSequence)paramString)) {
      return null;
    }
    List localList = (List)new ArrayList();
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("useNewGroupSettingTailCodes");
      if ((paramString != null) && (paramString.length() > 0))
      {
        int i = 0;
        int j = paramString.length();
        while (i < j)
        {
          localList.add(Integer.valueOf(paramString.getInt(i)));
          i += 1;
        }
      }
      return paramString;
    }
    catch (JSONException paramString)
    {
      QLog.d("TroopSettingConfigBean", 1, "parse JSONException", (Throwable)paramString);
      paramString = new bggh();
      bggh.a(paramString, localList);
      if (QLog.isColorLevel()) {
        QLog.d("TroopSettingConfigBean", 2, "parse tempGrayList : " + localList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bggi
 * JD-Core Version:    0.7.0.1
 */