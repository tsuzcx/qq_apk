import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

public class bnpq
{
  public static void a(bioy parambioy, String... paramVarArgs)
  {
    paramVarArgs = new Intent("action_js2qzone");
    Bundle localBundle = new Bundle();
    localBundle.putString("cmd", "CleanZebraNum");
    paramVarArgs.putExtras(localBundle);
    if (QLog.isColorLevel()) {
      QLog.d("QZoneZebraAlbumJsHandleLogicQZonePersonalizePlugin", 2, "actionString: " + paramVarArgs.getAction());
    }
    bmtd.a(parambioy.a(), bmtk.a(), paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnpq
 * JD-Core Version:    0.7.0.1
 */