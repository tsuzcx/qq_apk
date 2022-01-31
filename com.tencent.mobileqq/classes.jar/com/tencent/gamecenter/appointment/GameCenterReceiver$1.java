package com.tencent.gamecenter.appointment;

import android.text.TextUtils;
import bdpe;
import bicp;
import bicq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.util.Iterator;
import java.util.List;
import ynz;

class GameCenterReceiver$1
  implements Runnable
{
  GameCenterReceiver$1(GameCenterReceiver paramGameCenterReceiver, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject1 = bdpe.a(this.a);
    Iterator localIterator;
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      try
      {
        bicp.a();
        if (TextUtils.equals(this.b, "android.intent.action.PACKAGE_REMOVED"))
        {
          synchronized (this.this$0.a)
          {
            localObject1 = new WadlResult(new WadlParams((String)localObject1, this.a));
            ((WadlResult)localObject1).b = 11;
            localIterator = this.this$0.a.iterator();
            if (!localIterator.hasNext()) {
              break label147;
            }
            ((ynz)localIterator.next()).b((WadlResult)localObject1);
          }
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("GameCenterReceiver", 2, "receiveSystemInstallAction exception:" + localException.getMessage());
        }
      }
    }
    label147:
    do
    {
      do
      {
        do {}while (BaseApplicationImpl.sProcessId != 1);
        bicp.a().a("doUninstallAppCompleted", this.a);
        return;
      } while (!TextUtils.equals(this.b, "android.intent.action.PACKAGE_ADDED"));
      synchronized (this.this$0.a)
      {
        WadlResult localWadlResult = new WadlResult(new WadlParams(str, this.a));
        localWadlResult.b = 9;
        localIterator = this.this$0.a.iterator();
        if (localIterator.hasNext()) {
          ((ynz)localIterator.next()).a(localWadlResult);
        }
      }
    } while (BaseApplicationImpl.sProcessId != 1);
    bicp.a().a("doInstallAppCompleted", this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.appointment.GameCenterReceiver.1
 * JD-Core Version:    0.7.0.1
 */