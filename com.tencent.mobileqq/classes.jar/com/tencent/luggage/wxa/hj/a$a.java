package com.tencent.luggage.wxa.hj;

import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.tencent.luggage.wxa.ho.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class a$a
  implements e<Parcelable>, a
{
  com.tencent.luggage.wxa.hl.b a;
  final List<com.tencent.luggage.wxa.ho.b> b = new LinkedList();
  
  public a$a(com.tencent.luggage.wxa.hl.b paramb)
  {
    this.a = paramb;
    if (paramb != null)
    {
      com.tencent.luggage.wxa.hs.b.a("IPC.IPCInvokeCallbackProxy", "keep ref of callback(%s)", new Object[] { Integer.valueOf(paramb.hashCode()) });
      com.tencent.luggage.wxa.hq.b.a(paramb);
    }
  }
  
  public void a(Parcelable paramParcelable)
  {
    ??? = this.a;
    if (??? == null) {
      return;
    }
    com.tencent.luggage.wxa.hs.b.a("IPC.IPCInvokeCallbackProxy", "onCallback(%s)", new Object[] { Integer.valueOf(???.hashCode()) });
    try
    {
      ??? = new Bundle();
      ((Bundle)???).putParcelable("__remote_task_result_data", paramParcelable);
      this.a.a((Bundle)???);
      return;
    }
    catch (RemoteException paramParcelable)
    {
      com.tencent.luggage.wxa.hs.b.b("IPC.IPCInvokeCallbackProxy", "%s", new Object[] { Log.getStackTraceString(paramParcelable) });
      if (!this.b.isEmpty()) {
        synchronized (this.b)
        {
          LinkedList localLinkedList = new LinkedList(this.b);
          ??? = localLinkedList.iterator();
          if (((Iterator)???).hasNext()) {
            ((com.tencent.luggage.wxa.ho.b)((Iterator)???).next()).a(paramParcelable);
          }
        }
      }
    }
  }
  
  protected void finalize()
  {
    try
    {
      com.tencent.luggage.wxa.hs.b.a("IPC.IPCInvokeCallbackProxy", "finalize(%s)", new Object[] { Integer.valueOf(hashCode()) });
      if (this.a != null)
      {
        com.tencent.luggage.wxa.hs.b.a("IPC.IPCInvokeCallbackProxy", "finalize, release callback(%s)", new Object[] { Integer.valueOf(this.a.hashCode()) });
        l.a(new a.a.a(this.a), "finalize");
        this.a = null;
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hj.a.a
 * JD-Core Version:    0.7.0.1
 */