import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.tablequery.TReportData;
import com.tencent.mobileqq.tablequery.TableQueryController.2.1;
import com.tencent.mobileqq.tablequery.TableQueryViewer;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class bctd
  extends BroadcastReceiver
{
  bctd(bctc parambctc) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("action.query.data.viewer" == paramContext)
    {
      paramIntent = (TReportData)paramIntent.getSerializableExtra("queryData");
      if (paramIntent != null) {}
    }
    int i;
    do
    {
      do
      {
        return;
        bctb localbctb = new bctb();
        localbctb.k = "";
        localbctb.b = (paramIntent.actionName + "\n" + paramIntent.subAction + "\n" + paramIntent.mainAction + "\n");
        if (paramIntent.actionName == null) {}
        for (paramContext = paramIntent.mainAction;; paramContext = paramIntent.subAction)
        {
          localbctb.a = paramContext;
          if ((bctc.a) && (!bctc.b) && (bctc.a(this.a) != null)) {
            bctc.a(this.a).a(localbctb);
          }
          if ((bctc.a) && ((bctc.c) || (bctc.a()))) {
            bctc.a(this.a).a((QQAppInterface)bctc.a(this.a).get(), paramIntent.table, 2, paramIntent.mainAction, paramIntent.actionName, paramIntent.subAction);
          }
          QLog.d("TableQueryController", 1, paramIntent.actionName + "\n" + paramIntent.mainAction + "\n" + paramIntent.subAction + "\n" + paramIntent.table + "\n");
          return;
        }
      } while ("com.tencent.plugin.state.change" != paramContext);
      i = paramIntent.getIntExtra("key_plugin_state", -1);
      if (1 == i)
      {
        this.a.b();
        paramContext = new TableQueryController.2.1(this);
        ThreadManager.getSubThreadHandler().postDelayed(paramContext, 2000L);
        return;
      }
    } while (i != 0);
    this.a.c();
    bctc.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bctd
 * JD-Core Version:    0.7.0.1
 */