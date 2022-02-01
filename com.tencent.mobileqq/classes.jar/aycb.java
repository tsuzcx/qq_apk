import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/notification/modularize/PushUtil;", "", "()V", "INVALID_MAIN_BUSINESS_ID", "", "KEY_MAIN_BUSINESS_ID", "", "KEY_PUSH_ID", "KEY_SUB_BUSINESS_ID", "addBrowserIntent", "", "intent", "Landroid/content/Intent;", "pushComponent", "Lcom/tencent/mobileqq/notification/modularize/PushComponent;", "getBitmapFromUrl", "Landroid/graphics/Bitmap;", "iconUrl", "reportPushClick", "mainBusinessId", "subBusinessId", "pushId", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class aycb
{
  public static final aycb a = new aycb();
  
  @JvmStatic
  public static final void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 != -1) {
      bcst.b(null, "dc00898", "", "", "0X800AE74", "0X800AE74", paramInt1, 0, String.valueOf(paramInt2), String.valueOf(paramInt3), "", "");
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("PushUtil", 2, new Object[] { "reportPushClick: called. ", "no need report mainBusinessId: " + paramInt1 });
  }
  
  @JvmStatic
  public static final void a(@NotNull Intent paramIntent, @NotNull ayca paramayca)
  {
    Intrinsics.checkParameterIsNotNull(paramIntent, "intent");
    Intrinsics.checkParameterIsNotNull(paramayca, "pushComponent");
    paramIntent.putExtra("KEY_MAIN_BUSINESS_ID", paramayca.a);
    paramIntent.putExtra("KEY_SUB_BUSINESS_ID", paramayca.b);
    paramIntent.putExtra("KEY_PUSH_ID", paramayca.c);
  }
  
  @Nullable
  public final Bitmap a(@Nullable String paramString)
  {
    return awlf.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aycb
 * JD-Core Version:    0.7.0.1
 */