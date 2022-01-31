import android.content.Intent;
import android.os.Bundle;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity;
import cooperation.weiyun.AlbumBackupProxyActivity;

public class aoax
  implements bemm
{
  public aoax(FileAssistantActivity paramFileAssistantActivity) {}
  
  public void a(beml parambeml)
  {
    switch (parambeml.a)
    {
    default: 
      return;
    case 0: 
      parambeml = new Intent(this.a.getApplicationContext(), LiteActivity.class);
      if (this.a.j) {
        apci.a("0X8005534");
      }
      for (;;)
      {
        try
        {
          Bundle localBundle = new Bundle();
          localBundle.putLong("category", 12);
          parambeml.putExtra("bundle", localBundle);
          parambeml.putExtra("from", "FileAssistant");
          this.a.startActivityForResult(parambeml, 101);
          return;
        }
        catch (Exception parambeml)
        {
          parambeml.printStackTrace();
          return;
        }
        apci.a("0X800681A");
      }
    case 1: 
      if (this.a.j) {
        apci.a("0X8005535");
      }
      for (;;)
      {
        FileAssistantActivity.a(this.a);
        return;
        apci.a("0X800681B");
      }
    case 2: 
      if (this.a.j) {
        apci.a("0X8005536");
      }
      for (;;)
      {
        AlbumBackupProxyActivity.a(this.a, this.a.app.getCurrentAccountUin(), "source_qfile_assistant", 10001);
        FileAssistantActivity.a(this.a, this.a.c, "100160.100162");
        return;
        apci.a("0X800681C");
      }
    case 3: 
      apci.a("0X800A15F");
      parambeml = new Bundle();
      parambeml.putString("url", "https://docs.qq.com/desktop/m/templates_list.html?padtype=0&_wv=2&_wwv=512");
      parambeml.putString("tdsourcetag", "s_qq_myfile_menu_create");
      TeamWorkDocEditBrowserActivity.a(this.a, parambeml, false);
      return;
    }
    apci.a("0X8005532");
    apck.a(this.a.app, this.a, "_is_from_qfile_shortcut", this.a.getString(2131626826), 2130843438);
    apcb.b(2131626858);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoax
 * JD-Core Version:    0.7.0.1
 */