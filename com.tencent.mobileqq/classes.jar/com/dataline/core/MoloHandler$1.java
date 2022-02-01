package com.dataline.core;

import com.dataline.util.DataLineReportUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.open.pcpush.PCPushProxy;
import com.tencent.open.pcpush.PCPushProxy.OnDownloadListener;
import com.tencent.open.pcpush.PCPushProxy.PkgEntry;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class MoloHandler$1
  implements PCPushProxy.OnDownloadListener
{
  MoloHandler$1(MoloHandler paramMoloHandler) {}
  
  public void a(int paramInt, String paramString)
  {
    Object localObject2 = this.a.a.a.getDataLineMsgProxy(0).a(paramString);
    Object localObject1 = Long.valueOf(0L);
    StringBuilder localStringBuilder;
    switch (paramInt)
    {
    default: 
      return;
    case 6: 
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("OnDownloadListener.INSTALLED(");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(")");
        QLog.d("dataline.MoloHandler", 2, ((StringBuilder)localObject1).toString());
      }
      DataLineReportUtil.i(this.a.a.a);
      this.a.a.a(9, true, new Object[] { paramString });
      return;
    case 5: 
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("OnDownloadListener.CANCEL(");
        localStringBuilder.append(paramString);
        localStringBuilder.append(")");
        QLog.d("dataline.MoloHandler", 2, localStringBuilder.toString());
      }
      if (localObject2 == null) {
        return;
      }
      paramString = ((List)localObject2).iterator();
    }
    while (paramString.hasNext())
    {
      localObject2 = (DataLineMsgRecord)paramString.next();
      if ((!((DataLineMsgRecord)localObject2).issuc) || (((DataLineMsgRecord)localObject2).progress != 1.0F))
      {
        ((DataLineMsgRecord)localObject2).issuc = false;
        this.a.a.a.getMessageFacade().a(0).c();
        this.a.a.a(3, false, new Object[] { localObject1, Long.valueOf(((DataLineMsgRecord)localObject2).sessionid), ((DataLineMsgRecord)localObject2).path });
        continue;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("OnDownloadListener.FINISH(");
          localStringBuilder.append(paramString);
          localStringBuilder.append(")");
          QLog.d("dataline.MoloHandler", 2, localStringBuilder.toString());
        }
        if (localObject2 == null) {
          return;
        }
        paramString = ((List)localObject2).iterator();
        while (paramString.hasNext())
        {
          localObject2 = (DataLineMsgRecord)paramString.next();
          DataLineReportUtil.g(this.a.a.a);
          ((DataLineMsgRecord)localObject2).issuc = true;
          ((DataLineMsgRecord)localObject2).progress = 1.0F;
          ((DataLineMsgRecord)localObject2).path = PCPushProxy.a().a(((DataLineMsgRecord)localObject2).strMoloKey);
          if (QLog.isColorLevel()) {
            if (((DataLineMsgRecord)localObject2).path != null)
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("PCPushProxy.getDownloadPath(");
              localStringBuilder.append(((DataLineMsgRecord)localObject2).strMoloKey);
              localStringBuilder.append(") \"");
              localStringBuilder.append(((DataLineMsgRecord)localObject2).path);
              localStringBuilder.append("'");
              QLog.d("dataline.MoloHandler", 2, localStringBuilder.toString());
            }
            else
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("PCPushProxy.getDownloadPath(");
              localStringBuilder.append(((DataLineMsgRecord)localObject2).strMoloKey);
              localStringBuilder.append(") NULL");
              QLog.d("dataline.MoloHandler", 2, localStringBuilder.toString());
            }
          }
          this.a.a.a.getDataLineMsgProxy(0).a(((DataLineMsgRecord)localObject2).msgId, ((DataLineMsgRecord)localObject2).path);
          this.a.a.a.getMessageFacade().a(0).c();
          this.a.a.a(3, true, new Object[] { localObject1, Long.valueOf(((DataLineMsgRecord)localObject2).sessionid), ((DataLineMsgRecord)localObject2).path });
          this.a.a.a().getMessageFacade().a(0).b(((DataLineMsgRecord)localObject2).msgId);
          continue;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("OnDownloadListener.WAIT(");
            ((StringBuilder)localObject1).append(paramString);
            ((StringBuilder)localObject1).append(")");
            QLog.d("dataline.MoloHandler", 2, ((StringBuilder)localObject1).toString());
            return;
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("OnDownloadListener.PAUSE(");
              localStringBuilder.append(paramString);
              localStringBuilder.append(")");
              QLog.d("dataline.MoloHandler", 2, localStringBuilder.toString());
            }
            if (localObject2 == null) {
              return;
            }
            paramString = ((List)localObject2).iterator();
            while (paramString.hasNext())
            {
              localObject2 = (DataLineMsgRecord)paramString.next();
              if ((!((DataLineMsgRecord)localObject2).issuc) || (((DataLineMsgRecord)localObject2).progress != 1.0F))
              {
                ((DataLineMsgRecord)localObject2).issuc = false;
                ((DataLineMsgRecord)localObject2).fileMsgStatus = 2L;
                this.a.a.a.getMessageFacade().a(0).d(((DataLineMsgRecord)localObject2).msgId);
                this.a.a.a.getMessageFacade().a(0).c();
                this.a.a.a(3, false, new Object[] { localObject1, Long.valueOf(((DataLineMsgRecord)localObject2).sessionid), ((DataLineMsgRecord)localObject2).path });
                continue;
                if (QLog.isColorLevel())
                {
                  localStringBuilder = new StringBuilder();
                  localStringBuilder.append("OnDownloadListener.START(");
                  localStringBuilder.append(paramString);
                  localStringBuilder.append(")");
                  QLog.d("dataline.MoloHandler", 2, localStringBuilder.toString());
                }
                if (localObject2 == null) {
                  return;
                }
                paramString = ((List)localObject2).iterator();
                while (paramString.hasNext())
                {
                  localObject2 = (DataLineMsgRecord)paramString.next();
                  ((DataLineMsgRecord)localObject2).issuc = true;
                  ((DataLineMsgRecord)localObject2).fileMsgStatus = 0L;
                  this.a.a.a.getMessageFacade().a(0).d(((DataLineMsgRecord)localObject2).msgId);
                  this.a.a.a(6, true, new Object[] { localObject1, Long.valueOf(((DataLineMsgRecord)localObject2).sessionid), ((DataLineMsgRecord)localObject2).path, Byte.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(true), Long.valueOf(((DataLineMsgRecord)localObject2).filesize) });
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void a(PCPushProxy.PkgEntry paramPkgEntry, int paramInt1, String paramString, int paramInt2)
  {
    paramString = Long.valueOf(0L);
    if ((paramPkgEntry != null) && (paramInt1 != -25))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onDownloadError(");
        ((StringBuilder)localObject1).append(paramPkgEntry.toString());
        ((StringBuilder)localObject1).append("), key[");
        ((StringBuilder)localObject1).append(paramPkgEntry.a);
        ((StringBuilder)localObject1).append("], errorCode");
        ((StringBuilder)localObject1).append(paramInt1);
        ((StringBuilder)localObject1).append("], state[");
        ((StringBuilder)localObject1).append(paramInt2);
        QLog.d("dataline.MoloHandler", 2, ((StringBuilder)localObject1).toString());
      }
      paramPkgEntry = this.a.a.a.getDataLineMsgProxy(0).a(paramPkgEntry.a);
      if (paramPkgEntry == null) {
        return;
      }
      paramPkgEntry = paramPkgEntry.iterator();
      while (paramPkgEntry.hasNext())
      {
        localObject1 = (DataLineMsgRecord)paramPkgEntry.next();
        DataLineReportUtil.l(this.a.a.a);
        ((DataLineMsgRecord)localObject1).issuc = false;
        this.a.a.a.getMessageFacade().a(0).c();
        this.a.a.a(3, false, new Object[] { paramString, Long.valueOf(((DataLineMsgRecord)localObject1).sessionid), ((DataLineMsgRecord)localObject1).path });
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("dataline.MoloHandler", 2, "onDownloadError( tm exit)");
    }
    Object localObject1 = this.a.a.a().getProxyManager().a(0).a();
    paramPkgEntry = this.a.a.a().getProxyManager().a(0).a(true);
    localObject1 = ((DataLineMsgSetList)localObject1).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((DataLineMsgSet)((Iterator)localObject1).next()).values().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)((Iterator)localObject2).next();
        if ((localDataLineMsgRecord.strMoloKey != null) && ((!localDataLineMsgRecord.issuc) || (localDataLineMsgRecord.progress != 1.0F)))
        {
          localDataLineMsgRecord.issuc = false;
          this.a.a.a.getMessageFacade().a(0).c();
          this.a.a.a(3, false, new Object[] { paramString, Long.valueOf(localDataLineMsgRecord.sessionid), localDataLineMsgRecord.path });
        }
      }
    }
    if (paramPkgEntry != null)
    {
      paramPkgEntry = paramPkgEntry.iterator();
      while (paramPkgEntry.hasNext())
      {
        localObject1 = ((DataLineMsgSet)paramPkgEntry.next()).values().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (DataLineMsgRecord)((Iterator)localObject1).next();
          if ((((DataLineMsgRecord)localObject2).strMoloKey != null) && ((!((DataLineMsgRecord)localObject2).issuc) || (((DataLineMsgRecord)localObject2).progress != 1.0F)))
          {
            ((DataLineMsgRecord)localObject2).issuc = false;
            this.a.a.a.getMessageFacade().a(0).c();
            this.a.a.a(3, false, new Object[] { paramString, Long.valueOf(((DataLineMsgRecord)localObject2).sessionid), ((DataLineMsgRecord)localObject2).path });
          }
        }
      }
    }
  }
  
  public void a(List<PCPushProxy.PkgEntry> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      PCPushProxy.PkgEntry localPkgEntry = (PCPushProxy.PkgEntry)paramList.next();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onDownloadUpdatem key[");
        ((StringBuilder)localObject).append(localPkgEntry.a);
        ((StringBuilder)localObject).append("], appName[");
        ((StringBuilder)localObject).append(localPkgEntry.e);
        ((StringBuilder)localObject).append("], progress[");
        ((StringBuilder)localObject).append(localPkgEntry.f);
        QLog.d("dataline.MoloHandler", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.a.a.a.getDataLineMsgProxy(0).a(localPkgEntry.a);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)((Iterator)localObject).next();
          float f = localPkgEntry.f / 100.0F;
          if (localDataLineMsgRecord.progress < f) {
            localDataLineMsgRecord.progress = f;
          }
          this.a.a.a(4, true, new Object[] { Long.valueOf(0L), Long.valueOf(localDataLineMsgRecord.sessionid), Float.valueOf(f) });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.core.MoloHandler.1
 * JD-Core Version:    0.7.0.1
 */