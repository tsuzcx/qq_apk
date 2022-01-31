import android.os.AsyncTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar.10;
import cooperation.troop.TroopFileProxyActivity;
import java.util.ArrayList;
import java.util.Iterator;

public class apfu
  extends AsyncTask<Void, Void, Void>
{
  public apfu(SendBottomBar.10 param10) {}
  
  protected Void a(Void... paramVarArgs)
  {
    paramVarArgs = SendBottomBar.a(this.a.this$0).a();
    int i = SendBottomBar.a(this.a.this$0).a();
    Object localObject = SendBottomBar.a(this.a.this$0).b();
    if (i == 5)
    {
      TroopFileProxyActivity.a.addAll(aonm.a());
      return null;
    }
    if (paramVarArgs.equals(ajed.z))
    {
      paramVarArgs = new ArrayList();
      paramVarArgs.addAll(aonm.a());
      ((ajgm)SendBottomBar.a(this.a.this$0).a(8)).a(paramVarArgs);
    }
    label411:
    for (;;)
    {
      return null;
      if (i == 6002)
      {
        localObject = new ArrayList();
        ((ArrayList)localObject).addAll(aonm.a());
        ((RouterHandler)SendBottomBar.a(this.a.this$0).a(48)).a((ArrayList)localObject, null, null, Long.parseLong(paramVarArgs));
      }
      else if (i == 9501)
      {
        localObject = (xvq)SendBottomBar.a(this.a.this$0).a(49);
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll(aonm.a());
        ((xvq)localObject).a().a(paramVarArgs, localArrayList);
      }
      else
      {
        boolean bool = SendBottomBar.a(this.a.this$0).i();
        SendBottomBar.a(this.a.this$0).a().a(bool, (String)localObject, paramVarArgs, i);
        paramVarArgs = aonm.b().iterator();
        do
        {
          if (!paramVarArgs.hasNext()) {
            break;
          }
        } while (((FileManagerEntity)paramVarArgs.next()).nFileType != 13);
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label411;
          }
          if (SendBottomBar.a(this.a.this$0) == 3)
          {
            awqx.b(SendBottomBar.a(this.a.this$0).app, "dc00898", "", "", "0X800A088", "0X800A088", 0, 0, "", "", "", "");
            break;
          }
          if (SendBottomBar.a(this.a.this$0) != 21) {
            break;
          }
          awqx.b(SendBottomBar.a(this.a.this$0).app, "dc00898", "", "", "0X800A08D", "0X800A08D", 0, 0, "", "", "", "");
          break;
        }
      }
    }
  }
  
  protected void a(Void paramVoid)
  {
    super.onPostExecute(paramVoid);
    this.a.this$0.d();
    aonm.b();
    SendBottomBar.d(this.a.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apfu
 * JD-Core Version:    0.7.0.1
 */