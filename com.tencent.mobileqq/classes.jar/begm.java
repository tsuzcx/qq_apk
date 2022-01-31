import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.widget.EditText;
import com.tencent.qqconnect.wtlogin.Login;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class begm
  extends MqqHandler
{
  public begm(Login paramLogin) {}
  
  public void handleMessage(Message paramMessage)
  {
    Bundle localBundle = paramMessage.getData();
    this.a.d();
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      this.a.a(String.format(this.a.getResources().getString(2131696781), new Object[] { this.a.getResources().getString(2131694905), Integer.valueOf(3100) }));
      paramMessage = new HashMap();
      paramMessage.put("error", "3100");
      axrl.a(this.a).a("0", "connect_sso_authfail", false, 0L, 0L, paramMessage, "");
      return;
      localBundle.getInt("ret");
      int i = localBundle.getInt("code");
      paramMessage = localBundle.getString("OTHER_ERROR");
      if (localBundle.getBoolean("pwdblank", false)) {
        this.a.b.setText("");
      }
      this.a.a(String.format(this.a.getResources().getString(2131696781), new Object[] { paramMessage, Integer.valueOf(i) }));
      paramMessage = new HashMap();
      paramMessage.put("error", "3101");
      axrl.a(this.a).a("0", "connect_sso_authfail", false, 0L, 0L, paramMessage, "");
      return;
    } while (this.a.isFinishing());
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     begm
 * JD-Core Version:    0.7.0.1
 */