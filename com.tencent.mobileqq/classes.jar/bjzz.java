import android.content.Intent;
import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

public class bjzz
{
  public static void a(begz parambegz, String... paramVarArgs)
  {
    int i = 0;
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
      return;
    }
    try
    {
      paramVarArgs = new JSONObject(paramVarArgs[0]);
      int k = paramVarArgs.optInt("facade", -1);
      int m = paramVarArgs.optInt("feedskin", -1);
      int n = paramVarArgs.optInt("avatar", -1);
      int i1 = paramVarArgs.optInt("float", -1);
      int i2 = paramVarArgs.optInt("customvip", -1);
      int i3 = paramVarArgs.optInt("praise", -1);
      int i4 = paramVarArgs.optInt("player", -1);
      boolean bool = paramVarArgs.optBoolean("isAfter785", false);
      int j = paramVarArgs.optInt("diyHome", -1);
      paramVarArgs = new Intent("action_personalize_js2qzone");
      Bundle localBundle = new Bundle();
      localBundle.putString("cmd", "SetPersonalizeFinished");
      localBundle.putInt("facade", k);
      localBundle.putInt("feedskin", m);
      localBundle.putInt("avatar", n);
      localBundle.putInt("floatObject", i1);
      localBundle.putInt("customvip", i2);
      localBundle.putInt("praise", i3);
      localBundle.putInt("player", i4);
      if (bool) {
        i = 1;
      }
      localBundle.putInt("isAfter785", i);
      localBundle.putInt("diyHome", j);
      paramVarArgs.putExtras(localBundle);
      bjdt.a(parambegz.a(), bjea.a(), paramVarArgs);
      return;
    }
    catch (JSONException parambegz) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjzz
 * JD-Core Version:    0.7.0.1
 */