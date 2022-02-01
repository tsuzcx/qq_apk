package com.tencent.av.compat;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.av.SessionMgr;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.GaInviteLockActivity;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.BaseActivity;

public class AVCallCompactHelper
{
  private static final String a = VideoInviteActivity.class.getName();
  private static final String b = GaInviteLockActivity.class.getName();
  private static final String c = MultiIncomingCallsActivity.class.getName();
  private final ConcurrentHashMap<String, Intent> d = new ConcurrentHashMap(3);
  
  private Intent a(String paramString)
  {
    Iterator localIterator = null;
    localObject3 = null;
    Object localObject1 = null;
    Object localObject2 = localIterator;
    try
    {
      if (this.d.size() > 0)
      {
        localObject2 = localIterator;
        localIterator = this.d.keySet().iterator();
        for (;;)
        {
          localObject2 = localObject1;
          localObject3 = localObject1;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject2 = localObject1;
          localObject3 = (String)localIterator.next();
          localObject2 = localObject1;
          if (SessionMgr.a().d((String)localObject3) == null)
          {
            localObject2 = localObject1;
            this.d.remove(localObject3);
          }
          else
          {
            localObject2 = localObject1;
            localObject3 = (Intent)this.d.get(localObject3);
            if (localObject3 != null)
            {
              localObject2 = localObject1;
              if (((Intent)localObject3).getComponent() != null)
              {
                localObject2 = localObject1;
                boolean bool = ((Intent)localObject3).getComponent().getClassName().equals(paramString);
                if (bool) {
                  localObject1 = localObject3;
                }
              }
            }
          }
        }
      }
      return localObject3;
    }
    catch (Throwable paramString)
    {
      QLog.i("CompatModeTag", 1, "getIntentByComponentClassName", paramString);
      localObject3 = localObject2;
    }
  }
  
  private Intent b(String paramString)
  {
    try
    {
      paramString = (Intent)this.d.get(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      QLog.i("CompatModeTag", 1, "getIntentByKey", paramString);
    }
    return null;
  }
  
  public static String b(String paramString, Intent paramIntent)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramIntent != null))
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder(200);
        localStringBuilder.append("getSessionIdFromIntent");
        localStringBuilder.append(", class[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("]");
        localStringBuilder.append(", intent[");
        localStringBuilder.append(paramIntent);
        localStringBuilder.append("]");
      }
      else
      {
        localStringBuilder = null;
      }
      String str1;
      boolean bool;
      int i;
      long l;
      if (c.equals(paramString))
      {
        str1 = paramIntent.getStringExtra("peerUin");
        bool = paramIntent.getBooleanExtra("isDoubleVideoMeeting", false);
        int j = paramIntent.getIntExtra("uinType", 0);
        if ((j != 1) && (j != 3000))
        {
          if (bool)
          {
            paramIntent = str1;
            i = 100;
          }
          else
          {
            paramIntent = str1;
            i = 3;
          }
        }
        else
        {
          l = paramIntent.getLongExtra("discussId", 0L);
          i = paramIntent.getIntExtra("relationType", 3);
          paramIntent = String.valueOf(l);
        }
        String str2 = SessionMgr.a(i, paramIntent, new int[0]);
        paramString = str2;
        if (localStringBuilder != null)
        {
          localStringBuilder.append(", uinType[");
          localStringBuilder.append(j);
          localStringBuilder.append("]");
          localStringBuilder.append(", relationType[");
          localStringBuilder.append(i);
          localStringBuilder.append("]");
          localStringBuilder.append(", relationId[");
          localStringBuilder.append(paramIntent);
          localStringBuilder.append("]");
          localStringBuilder.append(", isDoubleVideoMeeting[");
          localStringBuilder.append(bool);
          localStringBuilder.append("]");
          localStringBuilder.append(", peerUin[");
          localStringBuilder.append(str1);
          localStringBuilder.append("]");
          localStringBuilder.append(", session[");
          localStringBuilder.append(str2);
          localStringBuilder.append("]");
          paramString = str2;
        }
      }
      else if (b.equals(paramString))
      {
        l = paramIntent.getLongExtra("discussId", 0L);
        i = paramIntent.getIntExtra("relationType", 0);
        paramIntent = SessionMgr.a(i, String.valueOf(l), new int[0]);
        paramString = paramIntent;
        if (localStringBuilder != null)
        {
          localStringBuilder.append(", relationType[");
          localStringBuilder.append(i);
          localStringBuilder.append("]");
          localStringBuilder.append(", groupId[");
          localStringBuilder.append(l);
          localStringBuilder.append("]");
          localStringBuilder.append(", session[");
          localStringBuilder.append(paramIntent);
          localStringBuilder.append("]");
          paramString = paramIntent;
        }
      }
      else if (a.equals(paramString))
      {
        str1 = paramIntent.getStringExtra("peerUin");
        bool = paramIntent.getBooleanExtra("isDoubleVideoMeeting", false);
        if (bool) {
          i = 100;
        } else {
          i = 3;
        }
        paramIntent = SessionMgr.a(i, str1, new int[0]);
        paramString = paramIntent;
        if (localStringBuilder != null)
        {
          localStringBuilder.append(", peerUin[");
          localStringBuilder.append(str1);
          localStringBuilder.append("]");
          localStringBuilder.append(", isDoubleVideoMeeting[");
          localStringBuilder.append(bool);
          localStringBuilder.append("]");
          localStringBuilder.append(", relationType[");
          localStringBuilder.append(i);
          localStringBuilder.append("]");
          localStringBuilder.append(", session[");
          localStringBuilder.append(paramIntent);
          localStringBuilder.append("]");
          paramString = paramIntent;
        }
      }
      else
      {
        paramString = null;
      }
      if ((QLog.isColorLevel()) && (localStringBuilder != null)) {
        QLog.i("CompatModeTag", 2, localStringBuilder.toString());
      }
      return paramString;
    }
    return null;
  }
  
  private void b()
  {
    try
    {
      this.d.clear();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("CompatModeTag", 1, "clearIntents", localThrowable);
    }
  }
  
  private Intent c(String paramString)
  {
    try
    {
      paramString = (Intent)this.d.remove(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      QLog.i("CompatModeTag", 1, "removeIntent", paramString);
    }
    return null;
  }
  
  private void c(String paramString, Intent paramIntent)
  {
    try
    {
      this.d.put(paramString, paramIntent);
      return;
    }
    catch (Throwable paramString)
    {
      QLog.i("CompatModeTag", 1, "addIntent", paramString);
    }
  }
  
  public Runnable a(BaseActivity paramBaseActivity, VideoAppInterface paramVideoAppInterface)
  {
    Object localObject = SessionMgr.a().b();
    if (localObject != null) {
      c(((SessionInfo)localObject).f);
    }
    Intent localIntent = a(c);
    if ((localIntent != null) && (paramBaseActivity != null) && (paramVideoAppInterface != null))
    {
      localObject = new AVCallCompactHelper.1(this, paramBaseActivity);
      paramVideoAppInterface.a().postDelayed((Runnable)localObject, 1000L);
    }
    else
    {
      localObject = null;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkThirdCallIntent , activity[");
      localStringBuilder.append(paramBaseActivity);
      localStringBuilder.append("], app[");
      localStringBuilder.append(paramVideoAppInterface);
      localStringBuilder.append("], multiCallIntent[");
      localStringBuilder.append(localIntent);
      localStringBuilder.append("]");
      QLog.i("CompatModeTag", 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  public void a(Intent paramIntent)
  {
    String str1;
    if ((paramIntent != null) && (paramIntent.getComponent() != null)) {
      str1 = paramIntent.getComponent().getClassName();
    } else {
      str1 = null;
    }
    if ((a.equals(str1)) || (b.equals(str1))) {
      b();
    }
    String str2 = b(str1, paramIntent);
    if (!TextUtils.isEmpty(str2)) {
      c(str2, paramIntent);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveCallIntent , class[");
      localStringBuilder.append(str1);
      localStringBuilder.append("], session[");
      localStringBuilder.append(str2);
      localStringBuilder.append("], intent[");
      localStringBuilder.append(paramIntent);
      localStringBuilder.append("]");
      QLog.i("CompatModeTag", 2, localStringBuilder.toString());
    }
  }
  
  public void a(Runnable paramRunnable, VideoAppInterface paramVideoAppInterface)
  {
    if ((paramRunnable != null) && (paramVideoAppInterface != null)) {
      paramVideoAppInterface.a().removeCallbacks(paramRunnable);
    }
    if (QLog.isColorLevel()) {
      QLog.i("CompatModeTag", 2, "clearCallIntent");
    }
  }
  
  public void a(String paramString, Intent paramIntent)
  {
    String str = b(paramString, paramIntent);
    if (!TextUtils.isEmpty(str))
    {
      paramIntent = c(str);
    }
    else
    {
      if (a.equals(paramString))
      {
        paramIntent = SessionMgr.a().b();
        if (paramIntent != null)
        {
          str = paramIntent.f;
          paramIntent = c(str);
          break label59;
        }
      }
      paramIntent = null;
    }
    label59:
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clearCallIntent , class[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], session[");
      localStringBuilder.append(str);
      localStringBuilder.append(", intent[");
      localStringBuilder.append(paramIntent);
      localStringBuilder.append("]");
      QLog.i("CompatModeTag", 2, localStringBuilder.toString());
    }
  }
  
  public boolean a(BaseActivity paramBaseActivity)
  {
    boolean bool2 = false;
    if (paramBaseActivity == null) {
      return false;
    }
    SessionInfo localSessionInfo = SessionMgr.a().b();
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1;
    if (localSessionInfo != null) {
      localObject1 = localSessionInfo.f;
    } else {
      localObject1 = null;
    }
    Intent localIntent;
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      localIntent = b(localSessionInfo.f);
    } else {
      localIntent = null;
    }
    boolean bool1 = bool2;
    if (localIntent != null)
    {
      localObject1 = localIntent.getComponent();
      if (localObject1 == null) {
        localObject1 = localObject3;
      } else {
        localObject1 = ((ComponentName)localObject1).getClassName();
      }
      if ((!a.equals(localObject1)) && (!b.equals(localObject1)))
      {
        bool1 = bool2;
        localObject2 = localObject1;
        if (c.equals(localObject1))
        {
          c(localSessionInfo.f);
          bool1 = bool2;
          localObject2 = localObject1;
        }
      }
      else
      {
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    if (bool1)
    {
      paramBaseActivity.startActivity(localIntent);
      paramBaseActivity.finish();
    }
    if (QLog.isColorLevel())
    {
      paramBaseActivity = new StringBuilder();
      paramBaseActivity.append("checkMainCallIntent, hasMainCallIntent[");
      paramBaseActivity.append(bool1);
      paramBaseActivity.append("], mainCallIntent[");
      paramBaseActivity.append(localIntent);
      paramBaseActivity.append("], class[");
      paramBaseActivity.append(localObject2);
      paramBaseActivity.append("]");
      QLog.i("CompatModeTag", 2, paramBaseActivity.toString());
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.compat.AVCallCompactHelper
 * JD-Core Version:    0.7.0.1
 */