package com.tencent.luggage.wxa.hj;

import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.tencent.luggage.wxa.hl.a;
import com.tencent.luggage.wxa.hs.b;

public class h
{
  @WorkerThread
  public static <T extends k<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> ResultType a(String paramString, InputType paramInputType, @NonNull Class<T> paramClass)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      if (paramClass == null)
      {
        b.b("IPC.IPCInvoker", "invokeSync failed, taskClass is null(process : %s).", new Object[] { paramString });
        return null;
      }
      if (g.a(paramString))
      {
        paramString = ((k)p.a(paramClass, k.class)).invoke(paramInputType);
        if (paramString == null) {
          return null;
        }
        return (Parcelable)paramString;
      }
      a locala = d.a().a(paramString);
      if (locala == null)
      {
        b.b("IPC.IPCInvoker", "invokeSync failed, get bridge is null by process(%s).", new Object[] { paramString });
        return null;
      }
      try
      {
        paramString = locala.a(b(paramInputType, paramClass), paramClass.getName());
        if (paramString == null) {
          return null;
        }
        paramString.setClassLoader(h.class.getClassLoader());
        paramString = paramString.getParcelable("__remote_task_result_data");
        return paramString;
      }
      catch (RemoteException paramString)
      {
        b.d("IPC.IPCInvoker", "invokeSync failed, ipc invoke error : %s", new Object[] { paramString });
        return null;
      }
    }
    b.b("IPC.IPCInvoker", "invokeSync failed, process is null or nil.", new Object[0]);
    return null;
  }
  
  public static void a(String paramString, m paramm)
  {
    d.a().a(paramString, paramm);
  }
  
  public static <T extends c<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> boolean a(String paramString, InputType paramInputType, @NonNull Class<T> paramClass, e<ResultType> parame)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      if (paramClass == null)
      {
        b.b("IPC.IPCInvoker", "invokeAsync failed, taskClass is null(process : %s).", new Object[] { paramString });
        return false;
      }
      return q.a(new h.1(paramString, paramClass, paramInputType, parame), paramClass.toString());
    }
    b.b("IPC.IPCInvoker", "invokeAsync failed, process is null or nil.", new Object[0]);
    return false;
  }
  
  private static Bundle b(Parcelable paramParcelable, Class<?> paramClass)
  {
    paramClass = new Bundle();
    paramClass.putParcelable("__remote_task_data", paramParcelable);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hj.h
 * JD-Core Version:    0.7.0.1
 */