package com.tencent.mobileqq.app;

import MConch.Conch;
import MConch.ConchTask;
import MConch.NewCommonConchArgs;
import MConch.SCPullConchs;
import android.text.TextUtils;
import com.tencent.mobileqq.wifi.WifiSdkSharedPreUtils;
import com.tencent.mobileqq.wifi.WifiSecurityCheckInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.JceUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class WifiSdkObserver
  implements BusinessObserver
{
  private WifiSdkObserver.IWifiSdkListener a;
  private QQAppInterface b;
  
  public WifiSdkObserver(QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
  }
  
  private void a(SCPullConchs paramSCPullConchs)
  {
    if ((paramSCPullConchs != null) && (paramSCPullConchs.conchTaskList != null) && (paramSCPullConchs.conchTaskList.size() != 0)) {
      try
      {
        paramSCPullConchs = paramSCPullConchs.conchTaskList.iterator();
        Object localObject1;
        while (paramSCPullConchs.hasNext())
        {
          localObject1 = (ConchTask)paramSCPullConchs.next();
          Object localObject2;
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("WifiSdkObserver, handlePullConchs conchTask.taskId: ");
            ((StringBuilder)localObject2).append(((ConchTask)localObject1).taskId);
            ((StringBuilder)localObject2).append(" taskSeqno: ");
            ((StringBuilder)localObject2).append(((ConchTask)localObject1).taskSeqno);
            QLog.i("WifiSdk", 2, ((StringBuilder)localObject2).toString());
          }
          if ((((ConchTask)localObject1).conchList != null) && (((ConchTask)localObject1).conchList.size() != 0))
          {
            localObject1 = ((ConchTask)localObject1).conchList.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (Conch)((Iterator)localObject1).next();
              if (localObject2 != null)
              {
                int i = ((Conch)localObject2).cmdId;
                StringBuilder localStringBuilder;
                if (6129 == i)
                {
                  localObject2 = (NewCommonConchArgs)JceUtils.decodeWup(new NewCommonConchArgs(), ((Conch)localObject2).params);
                  if ((localObject2 != null) && (((NewCommonConchArgs)localObject2).newParam != null) && (((NewCommonConchArgs)localObject2).newParam.size() >= 3))
                  {
                    if (!TextUtils.equals("102769", (CharSequence)((NewCommonConchArgs)localObject2).newParam.get(0)))
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("WifiSdk", 2, "WifiSdkObserver, handlePullConchs channel is wrong");
                      }
                    }
                    else if (this.b == null)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("WifiSdk", 2, "WifiSdkObserver, handlePullConchs app is null");
                      }
                    }
                    else
                    {
                      i = Integer.valueOf((String)((NewCommonConchArgs)localObject2).newParam.get(1)).intValue();
                      localObject2 = String.valueOf(((NewCommonConchArgs)localObject2).newParam.get(2));
                      if (QLog.isColorLevel())
                      {
                        localStringBuilder = new StringBuilder();
                        localStringBuilder.append("WifiSdkObserver, handlePullConchs jumpType: ");
                        localStringBuilder.append(i);
                        localStringBuilder.append(" url: ");
                        localStringBuilder.append((String)localObject2);
                        QLog.d("WifiSdk", 2, localStringBuilder.toString());
                      }
                      WifiSdkSharedPreUtils.a(this.b.getApp(), this.b.getCurrentAccountUin(), i, (String)localObject2);
                      WifiSdkSharedPreUtils.b(this.b.getApp(), this.b.getCurrentAccountUin(), System.currentTimeMillis());
                    }
                  }
                  else if (QLog.isColorLevel()) {
                    QLog.d("WifiSdk", 2, "WifiSdkObserver, handlePullConchs conchArgs is invaild");
                  }
                }
                else if (6142 == ((Conch)localObject2).cmdId)
                {
                  localObject2 = (NewCommonConchArgs)JceUtils.decodeWup(new NewCommonConchArgs(), ((Conch)localObject2).params);
                  if ((localObject2 != null) && (((NewCommonConchArgs)localObject2).newParam != null) && (((NewCommonConchArgs)localObject2).newParam.size() >= 2))
                  {
                    if (!TextUtils.equals("102769", (CharSequence)((NewCommonConchArgs)localObject2).newParam.get(0)))
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("WifiSdk", 2, "WifiSdkObserver, handlePullConchs channel is wrong");
                      }
                    }
                    else if (this.b == null)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("WifiSdk", 2, "WifiSdkObserver, handlePullConchs app is null");
                      }
                    }
                    else
                    {
                      localObject2 = String.valueOf(((NewCommonConchArgs)localObject2).newParam.get(1));
                      if (QLog.isColorLevel())
                      {
                        localStringBuilder = new StringBuilder();
                        localStringBuilder.append("WifiSdkObserver, handlePullConchs wording: ");
                        localStringBuilder.append((String)localObject2);
                        QLog.d("WifiSdk", 2, localStringBuilder.toString());
                      }
                      WifiSdkSharedPreUtils.h(this.b.getApp(), (String)localObject2);
                      WifiSdkSharedPreUtils.b(this.b.getApp(), this.b.getCurrentAccountUin(), System.currentTimeMillis());
                    }
                  }
                  else if (QLog.isColorLevel()) {
                    QLog.d("WifiSdk", 2, "WifiSdkObserver, handlePullConchs conchArgs is invaild");
                  }
                }
              }
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("WifiSdk", 2, "WifiSdkObserver, handlePullConchs ER_Invalid");
          }
        }
        return;
      }
      catch (Exception paramSCPullConchs)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("WifiSdkObserver, handlePullConchs, exception: ");
          ((StringBuilder)localObject1).append(paramSCPullConchs.getMessage());
          QLog.d("WifiSdk", 2, ((StringBuilder)localObject1).toString());
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("WifiSdk", 2, "WifiSdkObserver, handlePullConchs scPullConchs is null");
    }
  }
  
  public void a(WifiSdkObserver.IWifiSdkListener paramIWifiSdkListener)
  {
    this.a = paramIWifiSdkListener;
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("WifiSdkObserver, onUpdate, type: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" isSuccess: ");
      localStringBuilder.append(paramBoolean);
      QLog.i("WifiSdk", 2, localStringBuilder.toString());
    }
    if ((paramBoolean) && (paramObject != null) && ((paramInt == 1) || ((paramInt == 2) || (paramInt == 3))))
    {
      try
      {
        a((SCPullConchs)paramObject);
      }
      catch (Exception paramObject)
      {
        if (!QLog.isColorLevel()) {
          break label248;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("WifiSdkObserver, onUpdate exception: ");
        localStringBuilder.append(paramObject.getMessage());
        QLog.i("WifiSdk", 2, localStringBuilder.toString());
      }
      paramObject = (String)paramObject;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("WifiSdkObserver, onUpdate, guid: ");
        localStringBuilder.append(paramObject);
        QLog.d("WifiSdk", 2, localStringBuilder.toString());
      }
      if (!TextUtils.isEmpty(paramObject))
      {
        WifiSdkSharedPreUtils.a(this.b.getApp(), this.b.getCurrentAccountUin(), paramObject);
        break label248;
        paramObject = (WifiSecurityCheckInfo)paramObject;
        a(paramObject.b);
        if (this.a != null) {
          this.a.a(paramObject.a);
        }
      }
    }
    label248:
    paramObject = this.a;
    if (paramObject != null) {
      paramObject.a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.WifiSdkObserver
 * JD-Core Version:    0.7.0.1
 */