import android.content.Intent;
import android.os.AsyncTask;
import com.tencent.mobileqq.pluginsdk.IStatisticsUploader;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import java.io.File;
import mqq.app.MobileQQ;

public class blfu
  extends AsyncTask<String, String, String>
{
  private IStatisticsUploader jdField_a_of_type_ComTencentMobileqqPluginsdkIStatisticsUploader;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  
  public blfu(Intent paramIntent)
  {
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("pluginsdk_selfuin");
    this.b = paramIntent.getStringExtra("pluginsdk_pluginName");
    this.c = paramIntent.getStringExtra("pluginsdk_pluginLocation");
    this.d = paramIntent.getStringExtra("pluginsdk_pluginpath");
    this.e = paramIntent.getStringExtra("pluginsdk_launchActivity");
    this.f = paramIntent.getStringExtra("pluginsdk_extraInfo");
    paramIntent = paramIntent.getStringExtra("clsUploader");
    if (paramIntent != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqPluginsdkIStatisticsUploader = ((IStatisticsUploader)Class.forName(paramIntent).newInstance());
      return;
    }
    catch (Exception paramIntent)
    {
      this.jdField_a_of_type_ComTencentMobileqqPluginsdkIStatisticsUploader = null;
    }
  }
  
  protected String a(String... paramVarArgs)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPluginsdkIStatisticsUploader == null) || (this.f == null)) {
      return "";
    }
    for (;;)
    {
      try
      {
        if ((this.f.contains("Resources$NotFoundException")) || (this.f.contains("ResourcesNotFoundException")) || (this.f.contains("ClassNotFoundException")) || (this.f.contains("GetPackageInfoFailException")))
        {
          paramVarArgs = PluginStatic.encodeFile(this.d);
          if (this.d == null) {
            continue;
          }
          l = new File(this.d).length();
          this.f = ("ApkMd5:" + paramVarArgs + "__FileSize:" + l + "__" + this.f);
        }
        this.jdField_a_of_type_ComTencentMobileqqPluginsdkIStatisticsUploader.uploadStartupFailure(MobileQQ.getContext(), this.jdField_a_of_type_JavaLangString, this.b, this.c, this.e, this.f);
      }
      catch (Throwable paramVarArgs)
      {
        long l;
        continue;
      }
      return null;
      l = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blfu
 * JD-Core Version:    0.7.0.1
 */