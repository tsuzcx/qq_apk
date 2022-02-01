import android.content.Intent;
import android.os.Bundle;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity;
import cooperation.weiyun.AlbumBackupProxyActivity;

public class aswe
  implements bknm
{
  public aswe(FileAssistantActivity paramFileAssistantActivity) {}
  
  public void a(bknl parambknl)
  {
    switch (parambknl.a)
    {
    default: 
      return;
    case 0: 
      parambknl = new Intent(this.a.getApplicationContext(), LiteActivity.class);
      if (this.a.l) {
        atvm.a("0X8005534");
      }
      for (;;)
      {
        try
        {
          Bundle localBundle = new Bundle();
          localBundle.putLong("category", 12);
          parambknl.putExtra("bundle", localBundle);
          parambknl.putExtra("from", "FileAssistant");
          this.a.startActivityForResult(parambknl, 101);
          return;
        }
        catch (Exception parambknl)
        {
          parambknl.printStackTrace();
          return;
        }
        atvm.a("0X800681A");
      }
    case 1: 
      if (this.a.l) {
        atvm.a("0X8005535");
      }
      for (;;)
      {
        FileAssistantActivity.b(this.a);
        return;
        atvm.a("0X800681B");
      }
    case 2: 
      if (this.a.l) {
        atvm.a("0X8005536");
      }
      for (;;)
      {
        AlbumBackupProxyActivity.a(this.a, this.a.app.getCurrentAccountUin(), "source_qfile_assistant", 10001);
        FileAssistantActivity.a(this.a, this.a.c, "100160.100162");
        return;
        atvm.a("0X800681C");
      }
    case 3: 
      atvm.a("0X800A15F");
      parambknl = new Bundle();
      parambknl.putString("url", "https://docs.qq.com/desktop/m/templates_list.html?padtype=0&_wv=2&_wwv=512");
      parambknl.putString("tdsourcetag", "s_qq_myfile_menu_create");
      TeamWorkDocEditBrowserActivity.a(this.a, parambknl, false);
      return;
    }
    atvm.a("0X8005532");
    atvo.a(this.a.app, this.a, "_is_from_qfile_shortcut", this.a.getString(2131692090), 2130844347);
    atvf.b(2131692135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aswe
 * JD-Core Version:    0.7.0.1
 */