import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/studymode/StudyModeSwitchDialogConfigProcessor$Config;", "", "()V", "showStudyModeSwitchDialog", "", "getShowStudyModeSwitchDialog", "()Z", "setShowStudyModeSwitchDialog", "(Z)V", "parse", "", "configText", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class bdvy
{
  private boolean a;
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "configText");
    if (QLog.isColorLevel()) {
      QLog.d("StudyModeSwitchDialogConfigProcessor", 2, paramString);
    }
    if (!TextUtils.isEmpty((CharSequence)paramString)) {}
    try
    {
      if (new JSONObject(paramString).optInt("ConfigEnableStudyModeGuide", 0) == 1) {}
      for (boolean bool = true;; bool = false)
      {
        this.a = bool;
        return;
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("StudyModeSwitchDialogConfigProcessor", 1, paramString, new Object[0]);
    }
  }
  
  public final boolean a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdvy
 * JD-Core Version:    0.7.0.1
 */