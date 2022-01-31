import android.os.AsyncTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.QFileSendBarManager.5;
import cooperation.troop.TroopFileProxyActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class apxn
  extends AsyncTask<Void, Void, Void>
{
  public apxn(QFileSendBarManager.5 param5) {}
  
  protected Void a(Void... paramVarArgs)
  {
    paramVarArgs = apxi.a(this.a.this$0);
    Object localObject1 = apxi.b(this.a.this$0);
    int i = apxi.a(this.a.this$0);
    if (i == 5)
    {
      TroopFileProxyActivity.a.addAll(apel.a());
      return null;
    }
    label114:
    Object localObject2;
    if (paramVarArgs.equals(ajsd.z))
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(apel.a());
      paramVarArgs = (ajum)this.a.this$0.a.a(8);
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
      break label114;
      if ((((FileManagerEntity)localObject2).getCloudType() == 2) && (((FileManagerEntity)localObject2).WeiYunFileId != null))
      {
        paramVarArgs.a((FileManagerEntity)localObject2);
      }
      else if (!paramVarArgs.a().a((FileManagerEntity)localObject2))
      {
        i |= 0x4;
        continue;
        if ((i & 0x2) == 0) {
          break;
        }
        return null;
        if (i == 6002)
        {
          localObject1 = new ArrayList();
          ((ArrayList)localObject1).addAll(apel.a());
          ((RouterHandler)this.a.this$0.a.a(48)).a((ArrayList)localObject1, null, null, Long.parseLong(paramVarArgs));
          return null;
        }
        if (i == 9501)
        {
          localObject1 = (yer)this.a.this$0.a.a(49);
          localObject2 = new ArrayList();
          ((ArrayList)localObject2).addAll(apel.a());
          ((yer)localObject1).a().a(paramVarArgs, (List)localObject2);
          return null;
        }
        this.a.this$0.a.a().a(false, (String)localObject1, paramVarArgs, i);
        return null;
      }
    }
  }
  
  protected void a(Void paramVoid)
  {
    super.onPostExecute(paramVoid);
    apxi.c(this.a.this$0);
    apel.b();
    this.a.this$0.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apxn
 * JD-Core Version:    0.7.0.1
 */