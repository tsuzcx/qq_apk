import android.content.Intent;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper.CommonJsPluginFactory;

public class becn
{
  public static final WebAccelerateHelper.CommonJsPluginFactory a = new beco();
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     becn
 * JD-Core Version:    0.7.0.1
 */