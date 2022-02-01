package com.tencent.av.compat;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.AVUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class InviteUIChecker
{
  private final ConcurrentHashMap<String, InviteUIChecker.CheckTask> a = new ConcurrentHashMap(2);
  private final Handler b = new Handler(Looper.getMainLooper());
  
  public long a(VideoAppInterface paramVideoAppInterface, Intent paramIntent, boolean paramBoolean)
  {
    String str;
    if ((paramIntent != null) && (paramIntent.getComponent() != null)) {
      str = paramIntent.getComponent().getClassName();
    } else {
      str = null;
    }
    Object localObject;
    if ((paramIntent != null) && (paramVideoAppInterface != null) && (!TextUtils.isEmpty(str)))
    {
      localObject = paramIntent.getStringExtra("session_id");
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        if (QLog.isColorLevel())
        {
          paramVideoAppInterface = new StringBuilder();
          paramVideoAppInterface.append("addInviteUITimeoutChecker session[");
          paramVideoAppInterface.append((String)localObject);
          paramVideoAppInterface.append("]");
          QLog.d("InviteUIChecker", 2, paramVideoAppInterface.toString());
        }
        return 0L;
      }
      a(str);
      b((String)localObject);
      long l = 5000L;
      if (!paramBoolean) {
        l = 200L;
      } else if (AVUtil.b()) {
        l = 1500L;
      }
      paramVideoAppInterface = new InviteUIChecker.CheckTask(str, paramIntent, paramVideoAppInterface, null);
      this.a.put(localObject, paramVideoAppInterface);
      this.b.postDelayed(paramVideoAppInterface, l);
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("addInviteUITimeoutChecker session[");
        paramIntent.append((String)localObject);
        paramIntent.append("], task[");
        paramIntent.append(paramVideoAppInterface);
        paramIntent.append("], timeout[");
        paramIntent.append(l);
        paramIntent.append("]");
        QLog.i("InviteUIChecker", 2, paramIntent.toString());
      }
      return l;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addInviteUITimeoutChecker className[");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("], app[");
      ((StringBuilder)localObject).append(paramVideoAppInterface);
      ((StringBuilder)localObject).append("], intent[");
      ((StringBuilder)localObject).append(paramIntent);
      ((StringBuilder)localObject).append("]");
      QLog.d("InviteUIChecker", 2, ((StringBuilder)localObject).toString());
    }
    return 0L;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("removeCheckTaskByClass class[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("]");
      QLog.d("InviteUIChecker", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      InviteUIChecker.CheckTask localCheckTask = (InviteUIChecker.CheckTask)this.a.get(str);
      if ((localCheckTask != null) && (InviteUIChecker.CheckTask.a(localCheckTask).equals(paramString))) {
        b(str);
      }
    }
  }
  
  public void b(String paramString)
  {
    Object localObject2;
    Object localObject1;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject2 = (InviteUIChecker.CheckTask)this.a.remove(paramString);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        this.b.removeCallbacks((Runnable)localObject2);
        localObject1 = localObject2;
      }
    }
    else
    {
      localObject1 = null;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("removeCheckTaskBySession session[");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("], task[");
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append("]");
      QLog.d("InviteUIChecker", 2, ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.compat.InviteUIChecker
 * JD-Core Version:    0.7.0.1
 */