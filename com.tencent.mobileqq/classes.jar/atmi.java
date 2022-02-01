import android.content.Intent;
import android.os.Bundle;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity;
import cooperation.weiyun.AlbumBackupProxyActivity;

public class atmi
  implements blop
{
  public atmi(FileAssistantActivity paramFileAssistantActivity) {}
  
  public void a(bloo parambloo)
  {
    switch (parambloo.a)
    {
    default: 
      return;
    case 0: 
      parambloo = new Intent(this.a.getApplicationContext(), LiteActivity.class);
      if (this.a.l) {
        aunh.a("0X8005534");
      }
      for (;;)
      {
        try
        {
          Bundle localBundle = new Bundle();
          localBundle.putLong("category", 12);
          parambloo.putExtra("bundle", localBundle);
          parambloo.putExtra("from", "FileAssistant");
          this.a.startActivityForResult(parambloo, 101);
          return;
        }
        catch (Exception parambloo)
        {
          parambloo.printStackTrace();
          return;
        }
        aunh.a("0X800681A");
      }
    case 1: 
      if (this.a.l) {
        aunh.a("0X8005535");
      }
      for (;;)
      {
        FileAssistantActivity.b(this.a);
        return;
        aunh.a("0X800681B");
      }
    case 2: 
      if (this.a.l) {
        aunh.a("0X8005536");
      }
      for (;;)
      {
        AlbumBackupProxyActivity.a(this.a, this.a.app.getCurrentAccountUin(), "source_qfile_assistant", 10001);
        FileAssistantActivity.a(this.a, this.a.c, "100160.100162");
        return;
        aunh.a("0X800681C");
      }
    case 3: 
      aunh.a("0X800A15F");
      parambloo = new Bundle();
      parambloo.putString("url", "https://docs.qq.com/desktop/m/templates_list.html?padtype=0&_wv=2&_wwv=512");
      parambloo.putString("tdsourcetag", "s_qq_myfile_menu_create");
      TeamWorkDocEditBrowserActivity.a(this.a, parambloo, false);
      return;
    }
    aunh.a("0X8005532");
    aunj.a(this.a.app, this.a, "_is_from_qfile_shortcut", this.a.getString(2131692095), 2130844361);
    auna.b(2131692140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atmi
 * JD-Core Version:    0.7.0.1
 */