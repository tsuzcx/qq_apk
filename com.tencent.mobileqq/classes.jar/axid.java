import android.app.PendingIntent;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/notification/modularize/business/AudioRoomScheme;", "Lcom/tencent/mobileqq/notification/modularize/BaseJumpScheme;", "()V", "customJumpIntent", "Landroid/app/PendingIntent;", "pushComponent", "Lcom/tencent/mobileqq/notification/modularize/PushComponent;", "modifyAudioRoomScheme", "", "scheme", "needCustomJump", "", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class axid
  extends axhx
{
  public static final axie a = new axie(null);
  
  private final String a(String paramString)
  {
    QLog.d("AudioRoomScheme", 2, "before modify scheme: " + paramString);
    String str = StringsKt.replace$default(paramString, "mqqapi://now/audioroom", "mqqapi://now/openroom", false, 4, null);
    paramString = str;
    if (!StringsKt.contains$default((CharSequence)str, (CharSequence)"src_type", false, 2, null)) {
      paramString = str + "&src_type=app";
    }
    str = paramString;
    if (!StringsKt.contains$default((CharSequence)paramString, (CharSequence)"version", false, 2, null)) {
      str = paramString + "&version=1";
    }
    paramString = str;
    if (!StringsKt.contains$default((CharSequence)str, (CharSequence)"fromid", false, 2, null)) {
      paramString = str + "&fromid=10026";
    }
    str = paramString;
    if (!StringsKt.contains$default((CharSequence)paramString, (CharSequence)"roomtype", false, 2, null)) {
      str = paramString + "&roomtype=10001";
    }
    QLog.d("AudioRoomScheme", 2, "after modify: " + str);
    return str;
  }
  
  @NotNull
  protected PendingIntent a(@NotNull axib paramaxib)
  {
    Intrinsics.checkParameterIsNotNull(paramaxib, "pushComponent");
    if (StringsKt.startsWith$default(paramaxib.d, "mqqapi://now/audioroom", false, 2, null)) {
      paramaxib.d = a(paramaxib.d);
    }
    return d(paramaxib);
  }
  
  protected boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axid
 * JD-Core Version:    0.7.0.1
 */