import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class bfke
  extends RemoteCommand
{
  private SparseArray<List<bfkf>> a = new SparseArray();
  
  public bfke(AppRuntime paramAppRuntime)
  {
    super("com.tencent.individuality.individualityremotecommand");
    a(0, new bfkg());
  }
  
  public boolean a(int paramInt, bfkf parambfkf)
  {
    List localList = (List)this.a.get(paramInt);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.a.put(paramInt, localObject);
    }
    if (!((List)localObject).contains(parambfkf)) {
      return ((List)localObject).add(parambfkf);
    }
    return false;
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    int i = paramBundle.getInt("com.tencent.individuality.individualityremotecommand.id", -1);
    if (-1 != i)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("IndividualityRemoteCommand", 4, "invoke: dataInvoke=" + paramBundle.toString());
      }
      paramOnInvokeFinishLinstener = (List)this.a.get(i);
      if (paramOnInvokeFinishLinstener == null) {
        break label100;
      }
      paramOnInvokeFinishLinstener = paramOnInvokeFinishLinstener.iterator();
      do
      {
        if (!paramOnInvokeFinishLinstener.hasNext()) {
          break;
        }
      } while (!((bfkf)paramOnInvokeFinishLinstener.next()).a(i, paramBundle));
    }
    label100:
    do
    {
      while (!paramOnInvokeFinishLinstener.hasNext())
      {
        do
        {
          return paramBundle;
          paramOnInvokeFinishLinstener = (List)this.a.get(0);
        } while (paramOnInvokeFinishLinstener == null);
        paramOnInvokeFinishLinstener = paramOnInvokeFinishLinstener.iterator();
      }
    } while (!((bfkf)paramOnInvokeFinishLinstener.next()).a(i, paramBundle));
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfke
 * JD-Core Version:    0.7.0.1
 */