import android.os.Environment;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;

public class avzg
{
  public static final String a;
  public static final String b;
  public static final String c;
  public static final String d;
  public static String e;
  public static String f;
  
  static
  {
    int i = 0;
    try
    {
      boolean bool = "mounted".equals(Environment.getExternalStorageState());
      i = bool;
    }
    catch (Exception localException)
    {
      label13:
      File localFile;
      break label13;
    }
    if (i != 0) {}
    for (localFile = new File(ajed.aU);; localFile = BaseApplicationImpl.getApplication().getCacheDir())
    {
      a = new File(localFile, "dov_ptv_template_dov").getPath() + File.separator + "camera_story_default_template.json";
      b = new File(localFile, "dov_ptv_template_dov").getPath() + File.separator + "camera_emo_default_template.json";
      c = new File(localFile, "dov_ptv_template_dov").getPath() + File.separator + "camera_play_show_default_template.json";
      d = new File(localFile, "dov_ptv_template_dov").getPath() + File.separator + "camera_play_show_updated_template.json";
      e = "";
      f = "";
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avzg
 * JD-Core Version:    0.7.0.1
 */