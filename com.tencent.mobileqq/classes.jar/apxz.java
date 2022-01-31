import android.os.AsyncTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar.10;
import cooperation.troop.TroopFileProxyActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class apxz
  extends AsyncTask<Void, Void, Void>
{
  public apxz(SendBottomBar.10 param10) {}
  
  protected Void a(Void... paramVarArgs)
  {
    paramVarArgs = SendBottomBar.a(this.a.this$0).a();
    int i = SendBottomBar.a(this.a.this$0).a();
    Object localObject1 = SendBottomBar.a(this.a.this$0).b();
    if (i == 5)
    {
      TroopFileProxyActivity.a.addAll(apel.a());
      return null;
    }
    Object localObject2;
    if (paramVarArgs.equals(ajsd.z))
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(apel.a());
      paramVarArgs = (ajum)SendBottomBar.a(this.a.this$0).a(8);
      paramVarArgs.a((ArrayList)localObject1);
      localObject1 = apel.b().iterator();
      i = 0;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FileManagerEntity)((Iterator)localObject1).next();
        if (((FileManagerEntity)localObject2).nFileType == 13)
        {
          int j = i;
          if (paramVarArgs.a((FileManagerEntity)localObject2) == 0L) {
            j = i | 0x1;
          }
          i = j;
        }
      }
    }
    for (;;)
    {
      break;
      if ((((FileManagerEntity)localObject2).getCloudType() == 2) && (((FileManagerEntity)localObject2).WeiYunFileId != null))
      {
        paramVarArgs.a((FileManagerEntity)localObject2);
      }
      else if (!paramVarArgs.a().a((FileManagerEntity)localObject2))
      {
        i |= 0x4;
        continue;
        localObject1 = apel.d().iterator();
        while (((Iterator)localObject1).hasNext()) {
          paramVarArgs.a((WeiYunFileInfo)((Iterator)localObject1).next());
        }
        if ((i & 0x2) != 0) {}
        label568:
        for (;;)
        {
          return null;
          if (i == 6002)
          {
            localObject1 = new ArrayList();
            ((ArrayList)localObject1).addAll(apel.a());
            ((RouterHandler)SendBottomBar.a(this.a.this$0).a(48)).a((ArrayList)localObject1, null, null, Long.parseLong(paramVarArgs));
          }
          else if (i == 9501)
          {
            localObject1 = (yer)SendBottomBar.a(this.a.this$0).a(49);
            localObject2 = new ArrayList();
            ((ArrayList)localObject2).addAll(apel.a());
            ((yer)localObject1).a().a(paramVarArgs, (List)localObject2);
          }
          else
          {
            boolean bool = SendBottomBar.a(this.a.this$0).i();
            SendBottomBar.a(this.a.this$0).a().a(bool, (String)localObject1, paramVarArgs, i);
            paramVarArgs = apel.b().iterator();
            do
            {
              if (!paramVarArgs.hasNext()) {
                break;
              }
            } while (((FileManagerEntity)paramVarArgs.next()).nFileType != 13);
            for (i = 1;; i = 0)
            {
              if (i == 0) {
                break label568;
              }
              if (SendBottomBar.a(this.a.this$0) == 3)
              {
                axqy.b(SendBottomBar.a(this.a.this$0).app, "dc00898", "", "", "0X800A088", "0X800A088", 0, 0, "", "", "", "");
                break;
              }
              if (SendBottomBar.a(this.a.this$0) != 21) {
                break;
              }
              axqy.b(SendBottomBar.a(this.a.this$0).app, "dc00898", "", "", "0X800A08D", "0X800A08D", 0, 0, "", "", "", "");
              break;
            }
          }
        }
      }
    }
  }
  
  protected void a(Void paramVoid)
  {
    super.onPostExecute(paramVoid);
    this.a.this$0.d();
    apel.b();
    SendBottomBar.d(this.a.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apxz
 * JD-Core Version:    0.7.0.1
 */