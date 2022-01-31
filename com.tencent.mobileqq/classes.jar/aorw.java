import android.content.Intent;
import android.os.Bundle;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity;
import cooperation.weiyun.AlbumBackupProxyActivity;

public class aorw
  implements bfux
{
  public aorw(FileAssistantActivity paramFileAssistantActivity) {}
  
  public void a(bfuw parambfuw)
  {
    switch (parambfuw.a)
    {
    default: 
      return;
    case 0: 
      parambfuw = new Intent(this.a.getApplicationContext(), LiteActivity.class);
      if (this.a.j) {
        apue.a("0X8005534");
      }
      for (;;)
      {
        try
        {
          Bundle localBundle = new Bundle();
          localBundle.putLong("category", 12);
          parambfuw.putExtra("bundle", localBundle);
          parambfuw.putExtra("from", "FileAssistant");
          this.a.startActivityForResult(parambfuw, 101);
          return;
        }
        catch (Exception parambfuw)
        {
          parambfuw.printStackTrace();
          return;
        }
        apue.a("0X800681A");
      }
    case 1: 
      if (this.a.j) {
        apue.a("0X8005535");
      }
      for (;;)
      {
        FileAssistantActivity.b(this.a);
        return;
        apue.a("0X800681B");
      }
    case 2: 
      if (this.a.j) {
        apue.a("0X8005536");
      }
      for (;;)
      {
        AlbumBackupProxyActivity.a(this.a, this.a.app.getCurrentAccountUin(), "source_qfile_assistant", 10001);
        FileAssistantActivity.a(this.a, this.a.c, "100160.100162");
        return;
        apue.a("0X800681C");
      }
    case 3: 
      apue.a("0X800A15F");
      parambfuw = new Bundle();
      parambfuw.putString("url", "https://docs.qq.com/desktop/m/templates_list.html?padtype=0&_wv=2&_wwv=512");
      parambfuw.putString("tdsourcetag", "s_qq_myfile_menu_create");
      TeamWorkDocEditBrowserActivity.a(this.a, parambfuw, false);
      return;
    }
    apue.a("0X8005532");
    apug.a(this.a.app, this.a, "_is_from_qfile_shortcut", this.a.getString(2131692428), 2130843523);
    aptx.b(2131692472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aorw
 * JD-Core Version:    0.7.0.1
 */