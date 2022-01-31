import android.content.Intent;
import android.os.Bundle;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity;
import cooperation.weiyun.AlbumBackupProxyActivity;

public class aorr
  implements bfug
{
  public aorr(FileAssistantActivity paramFileAssistantActivity) {}
  
  public void a(bfuf parambfuf)
  {
    switch (parambfuf.a)
    {
    default: 
      return;
    case 0: 
      parambfuf = new Intent(this.a.getApplicationContext(), LiteActivity.class);
      if (this.a.j) {
        apuc.a("0X8005534");
      }
      for (;;)
      {
        try
        {
          Bundle localBundle = new Bundle();
          localBundle.putLong("category", 12);
          parambfuf.putExtra("bundle", localBundle);
          parambfuf.putExtra("from", "FileAssistant");
          this.a.startActivityForResult(parambfuf, 101);
          return;
        }
        catch (Exception parambfuf)
        {
          parambfuf.printStackTrace();
          return;
        }
        apuc.a("0X800681A");
      }
    case 1: 
      if (this.a.j) {
        apuc.a("0X8005535");
      }
      for (;;)
      {
        FileAssistantActivity.a(this.a);
        return;
        apuc.a("0X800681B");
      }
    case 2: 
      if (this.a.j) {
        apuc.a("0X8005536");
      }
      for (;;)
      {
        AlbumBackupProxyActivity.a(this.a, this.a.app.getCurrentAccountUin(), "source_qfile_assistant", 10001);
        FileAssistantActivity.a(this.a, this.a.c, "100160.100162");
        return;
        apuc.a("0X800681C");
      }
    case 3: 
      apuc.a("0X800A15F");
      parambfuf = new Bundle();
      parambfuf.putString("url", "https://docs.qq.com/desktop/m/templates_list.html?padtype=0&_wv=2&_wwv=512");
      parambfuf.putString("tdsourcetag", "s_qq_myfile_menu_create");
      TeamWorkDocEditBrowserActivity.a(this.a, parambfuf, false);
      return;
    }
    apuc.a("0X8005532");
    apue.a(this.a.app, this.a, "_is_from_qfile_shortcut", this.a.getString(2131692427), 2130843522);
    aptv.b(2131692471);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aorr
 * JD-Core Version:    0.7.0.1
 */