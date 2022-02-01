import android.content.Intent;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper.CommonJsPluginFactory;

public class bgvb
{
  public static final WebAccelerateHelper.CommonJsPluginFactory a = new bgvc();
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgvb
 * JD-Core Version:    0.7.0.1
 */