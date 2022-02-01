import android.os.AsyncTask;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.QFileSendBarManager.5;
import cooperation.troop.TroopFileProxyActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aufz
  extends AsyncTask<Void, Void, Void>
{
  public aufz(QFileSendBarManager.5 param5) {}
  
  protected Void a(Void... paramVarArgs)
  {
    paramVarArgs = aufu.a(this.a.this$0);
    Object localObject1 = aufu.b(this.a.this$0);
    int i = aufu.a(this.a.this$0);
    if (i == 5)
    {
      TroopFileProxyActivity.a.addAll(atpm.a());
      return null;
    }
    label115:
    Object localObject2;
    if (paramVarArgs.equals(AppConstants.DATALINE_PC_UIN))
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(atpm.a());
      paramVarArgs = (ansr)this.a.this$0.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
      paramVarArgs.a((ArrayList)localObject1);
      localObject1 = atpm.b().iterator();
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
      break label115;
      if ((((FileManagerEntity)localObject2).getCloudType() == 2) && (((FileManagerEntity)localObject2).WeiYunFileId != null))
      {
        paramVarArgs.a((FileManagerEntity)localObject2);
      }
      else if (!paramVarArgs.a().a((FileManagerEntity)localObject2))
      {
        i |= 0x4;
        continue;
        if (atpm.e().size() > 0) {
          this.a.this$0.a.getFileManagerEngine().a().a(atpm.e(), AppConstants.DATALINE_PC_UIN, 6000, null);
        }
        if ((i & 0x2) == 0) {
          break;
        }
        return null;
        if (i == 6002)
        {
          localObject1 = new ArrayList();
          ((ArrayList)localObject1).addAll(atpm.a());
          ((RouterHandler)this.a.this$0.a.getBusinessHandler(BusinessHandlerFactory.ROUTER_HANDLER)).a((ArrayList)localObject1, null, null, Long.parseLong(paramVarArgs));
          return null;
        }
        if (i == 9501)
        {
          localObject1 = (abkw)this.a.this$0.a.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
          localObject2 = new ArrayList();
          ((ArrayList)localObject2).addAll(atpm.a());
          ((abkw)localObject1).a().a(paramVarArgs, (List)localObject2);
          return null;
        }
        this.a.this$0.a.getFileManagerEngine().a(false, (String)localObject1, paramVarArgs, i);
        return null;
      }
    }
  }
  
  protected void a(Void paramVoid)
  {
    super.onPostExecute(paramVoid);
    aufu.c(this.a.this$0);
    atpm.b();
    this.a.this$0.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aufz
 * JD-Core Version:    0.7.0.1
 */