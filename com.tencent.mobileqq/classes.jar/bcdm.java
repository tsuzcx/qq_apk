import android.content.Intent;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper.CommonJsPluginFactory;

public class bcdm
{
  public static final WebAccelerateHelper.CommonJsPluginFactory a = new bcdn();
  
  public static WebAccelerateHelper.CommonJsPluginFactory a(Intent paramIntent)
  {
    switch (paramIntent.getIntExtra("web_view_module_from", -1))
    {
    default: 
      return null;
    }
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bcdm
 * JD-Core Version:    0.7.0.1
 */