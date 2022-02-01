package com.tencent.av.so;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class ResMgr$1
  extends BroadcastReceiver
{
  ResMgr$1(ResMgr paramResMgr) {}
  
  public void onReceive(Context arg1, Intent arg2)
  {
    if (??? != null)
    {
      if (???.getAction() == null) {
        return;
      }
      ??? = ???.getAction();
      if ("ACTION_QAV_RES_DOWNLOAD_STATE_NOTIFY".equals(???))
      {
        int i = ???.getIntExtra("ACTION_FIELD_DOWNLOAD_STATE", 0);
        int j = ???.getIntExtra("ACTION_FIELD_DOWNLOAD_PROGRESS", 0);
        ??? = ???.getStringExtra("ACTION_FIELD_RES_MD5");
        if (i == 2)
        {
          localArrayList = new ArrayList();
          synchronized (this.a.a)
          {
            localArrayList.addAll(this.a.a);
            ??? = localArrayList.iterator();
            if (!???.hasNext()) {
              return;
            }
            ((ResMgr.ResDownloadStateListener)???.next()).b(j, ???);
          }
        }
        ArrayList localArrayList = new ArrayList();
        synchronized (this.a.a)
        {
          localArrayList.addAll(this.a.a);
          ??? = localArrayList.iterator();
          if (!???.hasNext()) {
            return;
          }
          ((ResMgr.ResDownloadStateListener)???.next()).a(i, ???);
        }
      }
      if ("ACTION_QAV_RES_NEW_CONFIG_NOTIFY".equals(???))
      {
        QLog.i("AVResMgr", 1, "new config has been downloaded.");
        synchronized (ResMgr.a(this.a))
        {
          if (ResMgr.b(this.a) != null) {
            ResMgr.b(this.a).clear();
          }
          ??? = ResMgr.b();
          if (??? != null) {
            ResMgr.a(this.a, ???);
          }
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.so.ResMgr.1
 * JD-Core Version:    0.7.0.1
 */