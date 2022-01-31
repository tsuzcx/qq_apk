package com.tencent.av.compat;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqo;

public class InviteUIChecker
{
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private final ConcurrentHashMap<String, InviteUIChecker.CheckTask> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(2);
  
  public long a(VideoAppInterface paramVideoAppInterface, Intent paramIntent, boolean paramBoolean)
  {
    long l1 = 0L;
    if ((paramIntent != null) && (paramIntent.getComponent() != null)) {}
    for (String str1 = paramIntent.getComponent().getClassName();; str1 = null)
    {
      long l2;
      if ((paramIntent == null) || (paramVideoAppInterface == null) || (TextUtils.isEmpty(str1)))
      {
        l2 = l1;
        if (QLog.isColorLevel())
        {
          QLog.d("InviteUIChecker", 2, "addInviteUITimeoutChecker className[" + str1 + "], app[" + paramVideoAppInterface + "], intent[" + paramIntent + "]");
          l2 = l1;
        }
      }
      String str2;
      do
      {
        return l2;
        str2 = paramIntent.getStringExtra("session_id");
        if (!TextUtils.isEmpty(str2)) {
          break;
        }
        l2 = l1;
      } while (!QLog.isColorLevel());
      QLog.d("InviteUIChecker", 2, "addInviteUITimeoutChecker session[" + str2 + "]");
      return 0L;
      a(str1);
      b(str2);
      l1 = 5000L;
      if (!paramBoolean) {
        l1 = 200L;
      }
      for (;;)
      {
        paramVideoAppInterface = new InviteUIChecker.CheckTask(str1, paramIntent, paramVideoAppInterface, null);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str2, paramVideoAppInterface);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(paramVideoAppInterface, l1);
        l2 = l1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("InviteUIChecker", 2, "addInviteUITimeoutChecker session[" + str2 + "], task[" + paramVideoAppInterface + "], timeout[" + l1 + "]");
        return l1;
        if (mqo.a()) {
          l1 = 1500L;
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("InviteUIChecker", 2, "removeCheckTaskByClass class[" + paramString + "]");
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      InviteUIChecker.CheckTask localCheckTask = (InviteUIChecker.CheckTask)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      if ((localCheckTask != null) && (InviteUIChecker.CheckTask.a(localCheckTask).equals(paramString))) {
        b(str);
      }
    }
  }
  
  public void b(String paramString)
  {
    Object localObject = null;
    if (!TextUtils.isEmpty(paramString))
    {
      InviteUIChecker.CheckTask localCheckTask = (InviteUIChecker.CheckTask)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      localObject = localCheckTask;
      if (localCheckTask != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(localCheckTask);
        localObject = localCheckTask;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("InviteUIChecker", 2, "removeCheckTaskBySession session[" + paramString + "], task[" + localObject + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.compat.InviteUIChecker
 * JD-Core Version:    0.7.0.1
 */