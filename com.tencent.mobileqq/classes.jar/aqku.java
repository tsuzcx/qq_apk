import android.content.Intent;
import android.os.Bundle;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity;
import cooperation.weiyun.AlbumBackupProxyActivity;

public class aqku
  implements bhvu
{
  public aqku(FileAssistantActivity paramFileAssistantActivity) {}
  
  public void a(bhvt parambhvt)
  {
    switch (parambhvt.a)
    {
    default: 
      return;
    case 0: 
      parambhvt = new Intent(this.a.getApplicationContext(), LiteActivity.class);
      if (this.a.j) {
        arng.a("0X8005534");
      }
      for (;;)
      {
        try
        {
          Bundle localBundle = new Bundle();
          localBundle.putLong("category", 12);
          parambhvt.putExtra("bundle", localBundle);
          parambhvt.putExtra("from", "FileAssistant");
          this.a.startActivityForResult(parambhvt, 101);
          return;
        }
        catch (Exception parambhvt)
        {
          parambhvt.printStackTrace();
          return;
        }
        arng.a("0X800681A");
      }
    case 1: 
      if (this.a.j) {
        arng.a("0X8005535");
      }
      for (;;)
      {
        FileAssistantActivity.b(this.a);
        return;
        arng.a("0X800681B");
      }
    case 2: 
      if (this.a.j) {
        arng.a("0X8005536");
      }
      for (;;)
      {
        AlbumBackupProxyActivity.a(this.a, this.a.app.getCurrentAccountUin(), "source_qfile_assistant", 10001);
        FileAssistantActivity.a(this.a, this.a.c, "100160.100162");
        return;
        arng.a("0X800681C");
      }
    case 3: 
      arng.a("0X800A15F");
      parambhvt = new Bundle();
      parambhvt.putString("url", "https://docs.qq.com/desktop/m/templates_list.html?padtype=0&_wv=2&_wwv=512");
      parambhvt.putString("tdsourcetag", "s_qq_myfile_menu_create");
      TeamWorkDocEditBrowserActivity.a(this.a, parambhvt, false);
      return;
    }
    arng.a("0X8005532");
    arni.a(this.a.app, this.a, "_is_from_qfile_shortcut", this.a.getString(2131692504), 2130843882);
    armz.b(2131692548);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqku
 * JD-Core Version:    0.7.0.1
 */