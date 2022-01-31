import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import dov.com.qq.im.aeeditor.AEEditorActivity;

public class blfq
{
  public static void a(Activity paramActivity, int paramInt1, Bundle paramBundle, int paramInt2)
  {
    int i;
    Intent localIntent;
    if (paramInt1 == 0)
    {
      i = 10000;
      localIntent = new Intent(paramActivity, AEEditorActivity.class);
      if (paramBundle == null) {
        break label87;
      }
    }
    label87:
    for (paramBundle = new Bundle(paramBundle);; paramBundle = new Bundle())
    {
      paramBundle.putInt("editorType", paramInt1);
      paramBundle.putInt("editorFrom", paramInt2);
      localIntent.putExtras(paramBundle);
      paramActivity.startActivityForResult(localIntent, i);
      return;
      if (paramInt1 == 1)
      {
        i = 10001;
        break;
      }
      throw new IllegalArgumentException("wrong editor type");
    }
  }
  
  public static boolean a(Intent paramIntent)
  {
    return a(paramIntent, 0);
  }
  
  private static boolean a(Intent paramIntent, int paramInt)
  {
    if (paramIntent == null) {}
    do
    {
      return false;
      paramIntent = paramIntent.getExtras();
    } while ((paramIntent == null) || (!paramIntent.containsKey("editorType")) || (paramIntent.getInt("editorType") != paramInt));
    return true;
  }
  
  public static boolean a(Bundle paramBundle)
  {
    return a(paramBundle, 0);
  }
  
  private static boolean a(Bundle paramBundle, int paramInt)
  {
    if (paramBundle == null) {}
    while ((!paramBundle.containsKey("editorType")) || (paramBundle.getInt("editorType") != paramInt)) {
      return false;
    }
    return true;
  }
  
  public static boolean b(Bundle paramBundle)
  {
    return a(paramBundle, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blfq
 * JD-Core Version:    0.7.0.1
 */