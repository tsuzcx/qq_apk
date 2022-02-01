import android.content.Intent;
import android.os.Bundle;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity;
import cooperation.weiyun.AlbumBackupProxyActivity;

public class aryr
  implements bjsz
{
  public aryr(FileAssistantActivity paramFileAssistantActivity) {}
  
  public void a(bjsy parambjsy)
  {
    switch (parambjsy.a)
    {
    default: 
      return;
    case 0: 
      parambjsy = new Intent(this.a.getApplicationContext(), LiteActivity.class);
      if (this.a.l) {
        aszr.a("0X8005534");
      }
      for (;;)
      {
        try
        {
          Bundle localBundle = new Bundle();
          localBundle.putLong("category", 12);
          parambjsy.putExtra("bundle", localBundle);
          parambjsy.putExtra("from", "FileAssistant");
          this.a.startActivityForResult(parambjsy, 101);
          return;
        }
        catch (Exception parambjsy)
        {
          parambjsy.printStackTrace();
          return;
        }
        aszr.a("0X800681A");
      }
    case 1: 
      if (this.a.l) {
        aszr.a("0X8005535");
      }
      for (;;)
      {
        FileAssistantActivity.b(this.a);
        return;
        aszr.a("0X800681B");
      }
    case 2: 
      if (this.a.l) {
        aszr.a("0X8005536");
      }
      for (;;)
      {
        AlbumBackupProxyActivity.a(this.a, this.a.app.getCurrentAccountUin(), "source_qfile_assistant", 10001);
        FileAssistantActivity.a(this.a, this.a.c, "100160.100162");
        return;
        aszr.a("0X800681C");
      }
    case 3: 
      aszr.a("0X800A15F");
      parambjsy = new Bundle();
      parambjsy.putString("url", "https://docs.qq.com/desktop/m/templates_list.html?padtype=0&_wv=2&_wwv=512");
      parambjsy.putString("tdsourcetag", "s_qq_myfile_menu_create");
      TeamWorkDocEditBrowserActivity.a(this.a, parambjsy, false);
      return;
    }
    aszr.a("0X8005532");
    aszt.a(this.a.app, this.a, "_is_from_qfile_shortcut", this.a.getString(2131692143), 2130844246);
    aszk.b(2131692188);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aryr
 * JD-Core Version:    0.7.0.1
 */