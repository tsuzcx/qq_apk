import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

public class bkac
{
  public static void a(begz parambegz, String... paramVarArgs)
  {
    paramVarArgs = new Intent("action_js2qzone");
    Bundle localBundle = new Bundle();
    localBundle.putString("cmd", "CleanZebraNum");
    paramVarArgs.putExtras(localBundle);
    if (QLog.isColorLevel()) {
      QLog.d("QZoneZebraAlbumJsHandleLogicQZonePersonalizePlugin", 2, "actionString: " + paramVarArgs.getAction());
    }
    bjdt.a(parambegz.a(), bjea.a(), paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bkac
 * JD-Core Version:    0.7.0.1
 */