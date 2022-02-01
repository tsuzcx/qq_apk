package com.tencent.mobileqq.avatar.api.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;

class QQAvatarBroadcastServiceImpl$1
  extends Handler
{
  QQAvatarBroadcastServiceImpl$1(QQAvatarBroadcastServiceImpl paramQQAvatarBroadcastServiceImpl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ArrayList localArrayList;
    int i;
    if (paramMessage.what == 990)
    {
      paramMessage = new ArrayList();
      synchronized (QQAvatarBroadcastServiceImpl.access$000(this.a))
      {
        paramMessage.addAll(QQAvatarBroadcastServiceImpl.access$000(this.a));
        QQAvatarBroadcastServiceImpl.access$000(this.a).clear();
        QQAvatarBroadcastServiceImpl.access$100(this.a).removeMessages(990);
        ??? = (IQQAvatarDataService)this.a.mApp.getRuntimeService(IQQAvatarDataService.class, "");
        localArrayList = new ArrayList();
        if ((paramMessage == null) || (paramMessage.size() <= 0)) {
          break label158;
        }
        i = 0;
        if (i < paramMessage.size())
        {
          localArrayList.add(((IQQAvatarDataService)???).getCustomFaceFilePath(1, (String)paramMessage.get(i), 0));
          i += 1;
        }
      }
      QQAvatarBroadcastServiceImpl.access$200(this.a, 1, paramMessage, localArrayList);
      label158:
      if (QLog.isColorLevel()) {
        QQAvatarBroadcastServiceImpl.logD("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, user getQQHead resp uinList: ", paramMessage);
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramMessage.what != 991) {
              break;
            }
            paramMessage = new ArrayList();
            synchronized (QQAvatarBroadcastServiceImpl.access$300(this.a))
            {
              paramMessage.addAll(QQAvatarBroadcastServiceImpl.access$300(this.a));
              QQAvatarBroadcastServiceImpl.access$300(this.a).clear();
              QQAvatarBroadcastServiceImpl.access$100(this.a).removeMessages(991);
              ??? = (IQQAvatarDataService)this.a.mApp.getRuntimeService(IQQAvatarDataService.class, "");
              localArrayList = new ArrayList();
              if ((paramMessage == null) || (paramMessage.size() <= 0)) {
                continue;
              }
              i = 0;
              if (i < paramMessage.size())
              {
                localArrayList.add(((IQQAvatarDataService)???).getCustomFaceFilePath(4, (String)paramMessage.get(i), 0));
                i += 1;
              }
            }
            QQAvatarBroadcastServiceImpl.access$200(this.a, 4, paramMessage, localArrayList);
          } while (!QLog.isColorLevel());
          QQAvatarBroadcastServiceImpl.logD("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, group getQQHead resp uinList: ", paramMessage);
          return;
          if (paramMessage.what != 993) {
            break;
          }
          paramMessage = new ArrayList();
          synchronized (QQAvatarBroadcastServiceImpl.access$400(this.a))
          {
            paramMessage.addAll(QQAvatarBroadcastServiceImpl.access$400(this.a));
            QQAvatarBroadcastServiceImpl.access$400(this.a).clear();
            QQAvatarBroadcastServiceImpl.access$100(this.a).removeMessages(993);
            ??? = (IQQAvatarDataService)this.a.mApp.getRuntimeService(IQQAvatarDataService.class, "");
            localArrayList = new ArrayList();
            if ((paramMessage == null) || (paramMessage.size() <= 0)) {
              continue;
            }
            i = 0;
            if (i < paramMessage.size())
            {
              localArrayList.add(((IQQAvatarDataService)???).getCustomFaceFilePath(101, (String)paramMessage.get(i), 0));
              i += 1;
            }
          }
          QQAvatarBroadcastServiceImpl.access$200(this.a, 101, paramMessage, localArrayList);
        } while (!QLog.isColorLevel());
        QQAvatarBroadcastServiceImpl.logD("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, dis getQQHead resp uinList: ", paramMessage);
        return;
      } while (paramMessage.what != 992);
      paramMessage = new ArrayList();
      synchronized (QQAvatarBroadcastServiceImpl.access$500(this.a))
      {
        paramMessage.addAll(QQAvatarBroadcastServiceImpl.access$500(this.a));
        QQAvatarBroadcastServiceImpl.access$500(this.a).clear();
        QQAvatarBroadcastServiceImpl.access$100(this.a).removeMessages(992);
        ??? = (IQQAvatarDataService)this.a.mApp.getRuntimeService(IQQAvatarDataService.class, "");
        localArrayList = new ArrayList();
        if ((paramMessage == null) || (paramMessage.size() <= 0)) {
          continue;
        }
        i = 0;
        if (i < paramMessage.size())
        {
          localArrayList.add(((IQQAvatarDataService)???).getCustomFaceFilePath(113, (String)paramMessage.get(i), 0));
          i += 1;
        }
      }
      QQAvatarBroadcastServiceImpl.access$200(this.a, 113, paramMessage, localArrayList);
    } while (!QLog.isColorLevel());
    QQAvatarBroadcastServiceImpl.logD("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, newGroup getQQHead resp uinList: ", paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.api.impl.QQAvatarBroadcastServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */