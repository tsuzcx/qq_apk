import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

public class bhuk
{
  public static void a(bcdp parambcdp, String... paramVarArgs)
  {
    paramVarArgs = new Intent("action_js2qzone");
    Bundle localBundle = new Bundle();
    localBundle.putString("cmd", "CleanZebraNum");
    paramVarArgs.putExtras(localBundle);
    if (QLog.isColorLevel()) {
      QLog.d("QZoneZebraAlbumJsHandleLogicQZonePersonalizePlugin", 2, "actionString: " + paramVarArgs.getAction());
    }
    bgyp.a(parambcdp.a(), bgyw.a(), paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhuk
 * JD-Core Version:    0.7.0.1
 */