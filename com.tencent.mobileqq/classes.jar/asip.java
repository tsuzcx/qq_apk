import android.os.Bundle;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;

public class asip
  extends bebi
{
  public asip(MessengerService paramMessengerService) {}
  
  public void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    Bundle localBundle;
    int i;
    String str;
    if (this.a.a != null)
    {
      localBundle = new Bundle();
      localBundle.putString("url", null);
      if (paramTeamWorkFileImportInfo == null) {
        break label115;
      }
      i = paramTeamWorkFileImportInfo.f;
      localBundle.putInt("retCode", i);
      if (paramTeamWorkFileImportInfo == null) {
        break label120;
      }
      str = paramTeamWorkFileImportInfo.h;
      label53:
      localBundle.putString("errorStr", str);
      if (paramTeamWorkFileImportInfo == null) {
        break label126;
      }
    }
    label115:
    label120:
    label126:
    for (paramTeamWorkFileImportInfo = paramTeamWorkFileImportInfo.i;; paramTeamWorkFileImportInfo = "")
    {
      localBundle.putString("redirectUrl", paramTeamWorkFileImportInfo);
      this.a.a.putBundle("response", localBundle);
      this.a.a(this.a.a);
      this.a.a = null;
      return;
      i = 0;
      break;
      str = "";
      break label53;
    }
  }
  
  public void a(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.MessengerService", 2, "MessengerService onFileImportSuccess");
    }
    if (this.a.a != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("url", paramString);
      if ((paramTeamWorkFileImportInfo != null) && (paramTeamWorkFileImportInfo.d == 10)) {
        localBundle.putBoolean("needRefresh", true);
      }
      this.a.a.putBundle("response", localBundle);
      this.a.a(this.a.a);
      this.a.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asip
 * JD-Core Version:    0.7.0.1
 */