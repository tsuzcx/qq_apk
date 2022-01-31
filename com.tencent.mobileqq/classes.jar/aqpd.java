import android.content.Intent;
import android.os.Bundle;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity;
import cooperation.weiyun.AlbumBackupProxyActivity;

public class aqpd
  implements biab
{
  public aqpd(FileAssistantActivity paramFileAssistantActivity) {}
  
  public void a(biaa parambiaa)
  {
    switch (parambiaa.a)
    {
    default: 
      return;
    case 0: 
      parambiaa = new Intent(this.a.getApplicationContext(), LiteActivity.class);
      if (this.a.j) {
        arrp.a("0X8005534");
      }
      for (;;)
      {
        try
        {
          Bundle localBundle = new Bundle();
          localBundle.putLong("category", 12);
          parambiaa.putExtra("bundle", localBundle);
          parambiaa.putExtra("from", "FileAssistant");
          this.a.startActivityForResult(parambiaa, 101);
          return;
        }
        catch (Exception parambiaa)
        {
          parambiaa.printStackTrace();
          return;
        }
        arrp.a("0X800681A");
      }
    case 1: 
      if (this.a.j) {
        arrp.a("0X8005535");
      }
      for (;;)
      {
        FileAssistantActivity.b(this.a);
        return;
        arrp.a("0X800681B");
      }
    case 2: 
      if (this.a.j) {
        arrp.a("0X8005536");
      }
      for (;;)
      {
        AlbumBackupProxyActivity.a(this.a, this.a.app.getCurrentAccountUin(), "source_qfile_assistant", 10001);
        FileAssistantActivity.a(this.a, this.a.c, "100160.100162");
        return;
        arrp.a("0X800681C");
      }
    case 3: 
      arrp.a("0X800A15F");
      parambiaa = new Bundle();
      parambiaa.putString("url", "https://docs.qq.com/desktop/m/templates_list.html?padtype=0&_wv=2&_wwv=512");
      parambiaa.putString("tdsourcetag", "s_qq_myfile_menu_create");
      TeamWorkDocEditBrowserActivity.a(this.a, parambiaa, false);
      return;
    }
    arrp.a("0X8005532");
    arrr.a(this.a.app, this.a, "_is_from_qfile_shortcut", this.a.getString(2131692505), 2130843954);
    arri.b(2131692549);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqpd
 * JD-Core Version:    0.7.0.1
 */