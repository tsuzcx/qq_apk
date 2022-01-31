import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

public class bjvv
{
  public static void a(becq parambecq, String... paramVarArgs)
  {
    paramVarArgs = new Intent("action_js2qzone");
    Bundle localBundle = new Bundle();
    localBundle.putString("cmd", "CleanZebraNum");
    paramVarArgs.putExtras(localBundle);
    if (QLog.isColorLevel()) {
      QLog.d("QZoneZebraAlbumJsHandleLogicQZonePersonalizePlugin", 2, "actionString: " + paramVarArgs.getAction());
    }
    bizm.a(parambecq.a(), bizt.a(), paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjvv
 * JD-Core Version:    0.7.0.1
 */