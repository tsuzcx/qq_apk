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

public class aydf
  extends BroadcastReceiver
{
  aydf(ayde paramayde) {}
  
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
        aydd localaydd = new aydd();
        localaydd.k = "";
        localaydd.b = (paramIntent.actionName + "\n" + paramIntent.subAction + "\n" + paramIntent.mainAction + "\n");
        if (paramIntent.actionName == null) {}
        for (paramContext = paramIntent.mainAction;; paramContext = paramIntent.subAction)
        {
          localaydd.a = paramContext;
          if ((ayde.a) && (!ayde.b) && (ayde.a(this.a) != null)) {
            ayde.a(this.a).a(localaydd);
          }
          if ((ayde.a) && ((ayde.c) || (ayde.a()))) {
            ayde.a(this.a).a((QQAppInterface)ayde.a(this.a).get(), paramIntent.table, 2, paramIntent.mainAction, paramIntent.actionName, paramIntent.subAction);
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
    ayde.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aydf
 * JD-Core Version:    0.7.0.1
 */