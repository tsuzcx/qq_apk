package com.tencent.ilinkservice;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mars.ilink.xlog.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

final class IlinkService$d
  extends Handler
{
  public IlinkService$d(IlinkService paramIlinkService, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int k = paramMessage.what;
    if (k != 1)
    {
      int j = 0;
      int i = 0;
      if (k != 2)
      {
        StringBuilder localStringBuilder1;
        if (k != 3)
        {
          if (k != 4)
          {
            localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("Not supported task type yet:");
            localStringBuilder1.append(paramMessage.what);
            Log.d("IlinkService", localStringBuilder1.toString());
            return;
          }
          paramMessage = (IlinkService.c)paramMessage.obj;
          try
          {
            paramMessage.b.getMethod(paramMessage.c, paramMessage.d).invoke(paramMessage.a, paramMessage.e);
            return;
          }
          catch (InvocationTargetException paramMessage)
          {
            paramMessage.printStackTrace();
            return;
          }
          catch (IllegalAccessException paramMessage)
          {
            paramMessage.printStackTrace();
            return;
          }
          catch (NoSuchMethodException paramMessage)
          {
            paramMessage.printStackTrace();
            return;
          }
        }
        paramMessage = (IlinkService.a)paramMessage.obj;
        j = IlinkService.access$200(this.a).beginBroadcast();
        boolean bool = paramMessage.a.equals("");
        while (i < j)
        {
          if (bool) {}
          try
          {
            Log.i("IlinkService", "device callback all");
            IIlinkServiceCallback.class.getMethod(paramMessage.b, paramMessage.c).invoke(IlinkService.access$200(this.a).getBroadcastItem(i), paramMessage.d);
          }
          catch (InvocationTargetException localInvocationTargetException1)
          {
            localInvocationTargetException1.printStackTrace();
          }
          catch (IllegalAccessException localIllegalAccessException1)
          {
            localIllegalAccessException1.printStackTrace();
          }
          catch (NoSuchMethodException localNoSuchMethodException1)
          {
            localNoSuchMethodException1.printStackTrace();
          }
          if (IlinkService.access$200(this.a).getBroadcastCookie(i).equals(paramMessage.a))
          {
            localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("device callback one:");
            localStringBuilder1.append(paramMessage.a);
            Log.i("IlinkService", localStringBuilder1.toString());
            IIlinkServiceCallback.class.getMethod(paramMessage.b, paramMessage.c).invoke(IlinkService.access$200(this.a).getBroadcastItem(i), paramMessage.d);
            break;
          }
          i += 1;
        }
        IlinkService.access$200(this.a).finishBroadcast();
        return;
      }
      Log.d("IlinkService", "This is a confirm tdi callback only the correct appid can receive this callback");
      localObject = (IlinkService.e)paramMessage.obj;
      if (!IlinkService.access$100(this.a).containsKey(((IlinkService.e)localObject).a))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("appid:");
        ((StringBuilder)localObject).append(paramMessage.obj);
        ((StringBuilder)localObject).append(" not exit anymore");
        Log.e("IlinkService", ((StringBuilder)localObject).toString());
        return;
      }
      k = IlinkService.access$200(this.a).beginBroadcast();
      paramMessage = ((IlinkService.f)IlinkService.access$100(this.a).get(((IlinkService.e)localObject).a)).a;
      i = j;
      while (i < k)
      {
        try
        {
          if (IlinkService.access$200(this.a).getBroadcastCookie(i).equals(paramMessage))
          {
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("find the right callback:");
            localStringBuilder2.append(paramMessage);
            Log.d("IlinkService", localStringBuilder2.toString());
            IIlinkServiceCallback.class.getMethod(((IlinkService.e)localObject).b, ((IlinkService.e)localObject).c).invoke(IlinkService.access$200(this.a).getBroadcastItem(i), ((IlinkService.e)localObject).d);
          }
        }
        catch (InvocationTargetException localInvocationTargetException2)
        {
          localInvocationTargetException2.printStackTrace();
        }
        catch (IllegalAccessException localIllegalAccessException2)
        {
          localIllegalAccessException2.printStackTrace();
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          localNoSuchMethodException2.printStackTrace();
        }
        i += 1;
      }
      IlinkService.access$200(this.a).finishBroadcast();
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("It is a timer alive task:");
    ((StringBuilder)localObject).append(paramMessage.arg1);
    ((StringBuilder)localObject).append(" and version is:");
    ((StringBuilder)localObject).append(33554959);
    Log.d("IlinkService", ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilinkservice.IlinkService.d
 * JD-Core Version:    0.7.0.1
 */