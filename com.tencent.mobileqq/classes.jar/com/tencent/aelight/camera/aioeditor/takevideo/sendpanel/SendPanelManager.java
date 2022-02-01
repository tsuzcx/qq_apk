package com.tencent.aelight.camera.aioeditor.takevideo.sendpanel;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.CaptureReportUtil;
import com.tencent.aelight.camera.aioeditor.editipc.PeakIpcController;
import com.tencent.aelight.camera.aioeditor.editipc.PeakIpcModuleClient;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.report.api.IAEBaseDataReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.messageclean.MessageDataManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class SendPanelManager
  implements Manager
{
  public volatile boolean a = false;
  public volatile String b = null;
  private MessageDataManager c;
  private List<RecentUser> d = new ArrayList();
  private HashMap<String, String> e;
  private volatile boolean f = false;
  private volatile boolean g = false;
  private CopyOnWriteArrayList<SendPanelItemInfo> h = new CopyOnWriteArrayList();
  private IPanelDataListener i;
  private int j = 0;
  private Handler k;
  private volatile String l;
  
  private SendPanelManager()
  {
    d();
  }
  
  public static SendPanelManager a()
  {
    return SendPanelManager.SingletonPatternHolder.a();
  }
  
  private String a(RecentUser paramRecentUser)
  {
    Object localObject1 = "";
    Object localObject2 = localObject1;
    if (paramRecentUser != null)
    {
      HashMap localHashMap = this.e;
      localObject2 = localObject1;
      if (localHashMap != null)
      {
        if (localHashMap.isEmpty()) {
          return "";
        }
        int m = paramRecentUser.getType();
        if (m != 0)
        {
          if (m != 1)
          {
            if (m != 1000)
            {
              if (m != 1004)
              {
                if (m == 3000) {
                  localObject1 = this.c.a(paramRecentUser.uin);
                }
              }
              else {
                localObject1 = this.c.a(paramRecentUser.troopUin, paramRecentUser.uin);
              }
            }
            else {
              PeakIpcController.b(paramRecentUser.troopUin, paramRecentUser.uin);
            }
          }
          else
          {
            localObject1 = this.e;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(paramRecentUser.uin);
            ((StringBuilder)localObject2).append(1);
            localObject1 = (String)((HashMap)localObject1).get(((StringBuilder)localObject2).toString());
          }
        }
        else
        {
          localObject1 = this.e;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramRecentUser.uin);
          ((StringBuilder)localObject2).append(0);
          localObject1 = (String)((HashMap)localObject1).get(((StringBuilder)localObject2).toString());
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = paramRecentUser.displayName;
        }
      }
    }
    return localObject2;
  }
  
  private void a(SendPanelItemInfo paramSendPanelItemInfo, int paramInt1, int paramInt2)
  {
    int m = paramSendPanelItemInfo.e;
    if (m == 1)
    {
      if ((paramInt1 != 1003) && (paramInt1 != 1007))
      {
        if ((paramInt1 != 1004) && (paramInt1 != 1005) && (paramInt1 != 1006))
        {
          paramSendPanelItemInfo.f = paramInt2;
          return;
        }
        paramSendPanelItemInfo.e = 2;
        return;
      }
      paramSendPanelItemInfo.e = 3;
      paramSendPanelItemInfo.f = 100;
      return;
    }
    if ((m == 0) && ((paramInt1 == 1003) || (paramInt1 == 1007)))
    {
      paramSendPanelItemInfo.e = 3;
      paramSendPanelItemInfo.f = 100;
    }
  }
  
  private void a(List<RecentUser> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        RecentUser localRecentUser = (RecentUser)paramList.next();
        if (a(localRecentUser.getType())) {
          this.d.add(localRecentUser);
        }
      }
    }
  }
  
  private boolean a(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 0)
    {
      bool1 = bool2;
      if (paramInt != 1)
      {
        if (paramInt == 3000) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  private void d()
  {
    this.c = new MessageDataManager();
    this.c.a();
    this.k = new Handler(Looper.getMainLooper());
    PeakIpcModuleClient.b();
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.e("SendPanelManager", 2, "loadPanelData");
    }
    IPanelDataListener localIPanelDataListener = this.i;
    if (localIPanelDataListener != null) {
      localIPanelDataListener.c();
    }
    m();
    g();
    this.j = 1;
    try
    {
      ThreadManager.getFileThreadHandler().post(new SendPanelManager.1(this));
      ThreadManager.getSubThreadHandler().post(new SendPanelManager.2(this));
      ThreadManager.getFileThreadHandler().post(new SendPanelManager.3(this));
      return;
    }
    catch (Exception localException)
    {
      if (this.i == null) {
        break label176;
      }
      if (!QLog.isColorLevel()) {
        break label167;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadPanelData exception = ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("SendPanelManager", 2, localStringBuilder.toString());
      this.j = 3;
      l();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label88:
      break label88;
    }
    if (this.i != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SendPanelManager", 2, "loadPanelData OutOfMemoryError");
      }
      this.j = 3;
      l();
      return;
    }
  }
  
  private void f()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("file_short_send_panel", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("send_panel_animation_");
    localStringBuilder.append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    this.a = localSharedPreferences.getBoolean(localStringBuilder.toString(), true);
  }
  
  private void g()
  {
    this.e = new HashMap();
  }
  
  private void h()
  {
    a(this.c.a(RecentUser.class, "select * from recent order by lastmsgtime desc", null));
    i();
    this.f = true;
    if (QLog.isColorLevel()) {
      QLog.e("SendPanelManager", 2, "loadRecentUserList finish");
    }
    k();
  }
  
  private void i()
  {
    Object localObject1 = this.d;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      Object localObject2 = new ArrayList();
      localObject1 = new ArrayList();
      Object localObject3 = this.d.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        RecentUser localRecentUser = (RecentUser)((Iterator)localObject3).next();
        if (localRecentUser.showUpTime > 0L) {
          ((List)localObject2).add(localRecentUser);
        } else {
          ((List)localObject1).add(localRecentUser);
        }
      }
      this.d.clear();
      if (((List)localObject2).size() > 0)
      {
        Collections.sort((List)localObject2, new RecentUserComparator());
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (RecentUser)((Iterator)localObject2).next();
          this.d.add(localObject3);
        }
      }
      if (((List)localObject1).size() > 0)
      {
        Collections.sort((List)localObject1, new RecentUserComparator());
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (RecentUser)((Iterator)localObject1).next();
          this.d.add(localObject2);
        }
      }
    }
  }
  
  private void j()
  {
    this.c.a(0, this.e);
    this.c.b(1, this.e);
    this.g = true;
    if (QLog.isColorLevel()) {
      QLog.e("SendPanelManager", 2, "loadNameList finish");
    }
    k();
  }
  
  private void k()
  {
    if ((this.f) && (this.g))
    {
      if (QLog.isColorLevel()) {
        QLog.e("SendPanelManager", 2, "conformAllData");
      }
      Object localObject = this.d;
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = new ArrayList();
        Iterator localIterator = this.d.iterator();
        while (localIterator.hasNext())
        {
          RecentUser localRecentUser = (RecentUser)localIterator.next();
          SendPanelItemInfo localSendPanelItemInfo = new SendPanelItemInfo();
          localSendPanelItemInfo.a = localRecentUser.uin;
          localSendPanelItemInfo.b = localRecentUser.troopUin;
          if (localRecentUser.getType() == 1000)
          {
            localSendPanelItemInfo.c = localRecentUser.displayName;
            ((List)localObject).add(localRecentUser);
          }
          else
          {
            localSendPanelItemInfo.c = a(localRecentUser);
          }
          if (localRecentUser.getType() == 1)
          {
            Pair localPair = PeakIpcController.a(localRecentUser.uin);
            if (localPair != null)
            {
              if (((Boolean)localPair.first).booleanValue())
              {
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.e("SendPanelManager", 2, "conformAllData troop is disband");
                continue;
              }
              localSendPanelItemInfo.k = ((Boolean)localPair.second).booleanValue();
            }
          }
          localSendPanelItemInfo.d = localRecentUser.getType();
          if ((localRecentUser.getType() == 0) && (!TextUtils.isEmpty(localSendPanelItemInfo.a)) && ((TextUtils.isEmpty(localSendPanelItemInfo.c)) || (localSendPanelItemInfo.a.equals(localSendPanelItemInfo.c)))) {
            localSendPanelItemInfo.c = PeakIpcController.b(localSendPanelItemInfo.a);
          }
          this.h.add(localSendPanelItemInfo);
        }
        if (((List)localObject).size() > 0)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            a((RecentUser)((Iterator)localObject).next());
          }
        }
        localObject = this.d;
        if (localObject != null) {
          ((List)localObject).clear();
        }
        localObject = this.e;
        if (localObject != null) {
          ((HashMap)localObject).clear();
        }
        if (this.i != null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("SendPanelManager", 2, "conformAllData onLoadFinish");
          }
          this.j = 2;
          l();
        }
      }
      else if (this.i != null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SendPanelManager", 2, "conformAllData onLoadFinish recentUserList is empty");
        }
        this.j = 2;
        l();
      }
    }
  }
  
  private void l()
  {
    if (this.i != null) {
      this.k.post(new SendPanelManager.4(this));
    }
  }
  
  private void m()
  {
    this.d.clear();
    this.j = 0;
    this.f = false;
    this.g = false;
    Object localObject = this.e;
    if (localObject != null)
    {
      ((HashMap)localObject).clear();
      this.e = null;
    }
    localObject = this.h;
    if (localObject != null) {
      ((CopyOnWriteArrayList)localObject).clear();
    }
  }
  
  public void a(IPanelDataListener paramIPanelDataListener)
  {
    this.i = paramIPanelDataListener;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("SendPanelManager", 2, "updateOperateStatus uin is null");
      }
      return;
    }
    if (this.i != null)
    {
      Object localObject = this.h;
      if ((localObject != null) && (((CopyOnWriteArrayList)localObject).size() > 0))
      {
        int n = this.h.size();
        int m = 0;
        while (m < n)
        {
          localObject = (SendPanelItemInfo)this.h.get(m);
          if ((!TextUtils.isEmpty(((SendPanelItemInfo)localObject).a)) && (((SendPanelItemInfo)localObject).a.equals(paramString)) && (((SendPanelItemInfo)localObject).d == paramInt1) && (((SendPanelItemInfo)localObject).j))
          {
            a((SendPanelItemInfo)localObject, paramInt2, paramInt3);
            if (((SendPanelItemInfo)localObject).o <= 0L) {
              ((SendPanelItemInfo)localObject).o = paramLong;
            }
            if (QLog.isColorLevel())
            {
              paramString = new StringBuilder();
              paramString.append("updateOperateStatus operateStatus = ");
              paramString.append(((SendPanelItemInfo)localObject).e);
              paramString.append(" ,progress = ");
              paramString.append(((SendPanelItemInfo)localObject).f);
              paramString.append(" ,position = ");
              paramString.append(m);
              paramString.append(", uinseq:");
              paramString.append(((SendPanelItemInfo)localObject).o);
              QLog.i("SendPanelManager", 2, paramString.toString());
            }
            this.k.post(new SendPanelManager.6(this, m, (SendPanelItemInfo)localObject));
            return;
          }
          m += 1;
        }
      }
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      if (QLog.isColorLevel()) {
        QLog.e("SendPanelManager", 2, "updateFilePath fileMd5 is null");
      }
      return;
    }
    paramString1 = this.h;
    if ((paramString1 != null) && (paramString1.size() > 0))
    {
      paramString1 = this.h.iterator();
      while (paramString1.hasNext()) {
        ((SendPanelItemInfo)paramString1.next()).n = paramString2;
      }
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, boolean paramBoolean)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString1)))
    {
      SendPanelItemInfo localSendPanelItemInfo = null;
      Object localObject1 = null;
      int n = -1;
      CopyOnWriteArrayList localCopyOnWriteArrayList = this.h;
      Object localObject2 = localSendPanelItemInfo;
      int i1 = n;
      if (localCopyOnWriteArrayList != null)
      {
        localObject2 = localSendPanelItemInfo;
        i1 = n;
        if (localCopyOnWriteArrayList.size() > 0)
        {
          int i2 = this.h.size();
          int m = 0;
          for (;;)
          {
            localObject2 = localObject1;
            i1 = n;
            if (m >= i2) {
              break;
            }
            localSendPanelItemInfo = (SendPanelItemInfo)this.h.get(m);
            localSendPanelItemInfo.l = paramString2;
            localSendPanelItemInfo.m = paramString3;
            localSendPanelItemInfo.i = paramBoolean;
            localObject2 = localObject1;
            i1 = n;
            if (!TextUtils.isEmpty(localSendPanelItemInfo.a))
            {
              localObject2 = localObject1;
              i1 = n;
              if (localSendPanelItemInfo.a.equals(paramString1))
              {
                localObject2 = localObject1;
                i1 = n;
                if (paramInt == localSendPanelItemInfo.d)
                {
                  i1 = m;
                  localObject2 = localSendPanelItemInfo;
                }
              }
            }
            m += 1;
            localObject1 = localObject2;
            n = i1;
          }
        }
      }
      if (localObject2 != null)
      {
        ((SendPanelItemInfo)localObject2).e = 1;
        if (this.i != null) {
          this.k.post(new SendPanelManager.7(this, i1, (SendPanelItemInfo)localObject2));
        }
        if (paramBoolean) {
          PeakIpcController.a(((SendPanelItemInfo)localObject2).l, paramString3, (SendPanelItemInfo)localObject2, this.b, this.l);
        } else {
          PeakIpcController.a(paramString2, (SendPanelItemInfo)localObject2, this.b, this.l);
        }
        ((SendPanelItemInfo)localObject2).j = true;
        CaptureReportUtil.a((SendPanelItemInfo)localObject2);
        ((IAEBaseDataReporter)QRoute.api(IAEBaseDataReporter.class)).reportPostBtn(((SendPanelItemInfo)localObject2).n, ((SendPanelItemInfo)localObject2).d);
        paramString2 = new StringBuilder();
        paramString2.append("【updateFilePath】messageType:");
        paramString2.append(((SendPanelItemInfo)localObject2).d);
        AEQLog.b("SendPanelManager", paramString2.toString());
        a(paramString1, paramInt, ((SendPanelItemInfo)localObject2).n);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("SendPanelManager", 2, "updateFilePath can not find sendItemInfo");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString3 = new StringBuilder();
      paramString3.append("updateFilePath fail uin = ");
      paramString3.append(paramString1);
      paramString3.append(" ,filePath = ");
      paramString3.append(paramString2);
      QLog.e("SendPanelManager", 2, paramString3.toString());
    }
    paramString1 = this.i;
    if (paramString1 != null) {
      paramString1.e();
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    Object localObject;
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (this.i != null)
      {
        localObject = this.h;
        if ((localObject != null) && (((CopyOnWriteArrayList)localObject).size() > 0))
        {
          int n = this.h.size();
          int m = 0;
          while (m < n)
          {
            localObject = (SendPanelItemInfo)this.h.get(m);
            if ((!TextUtils.isEmpty(((SendPanelItemInfo)localObject).a)) && (((SendPanelItemInfo)localObject).a.equals(paramString1)) && (((SendPanelItemInfo)localObject).d == 1000))
            {
              ((SendPanelItemInfo)localObject).c = paramString2;
              if (QLog.isColorLevel()) {
                QLog.e("SendPanelManager", 2, "updateTroopMemberName");
              }
              this.k.post(new SendPanelManager.5(this, m, (SendPanelItemInfo)localObject));
              return;
            }
            m += 1;
          }
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateTroopMemberName exception uin = ");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(" ,name = ");
        ((StringBuilder)localObject).append(paramString2);
        QLog.e("SendPanelManager", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateTroopMemberName uin = ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" ,name = ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.e("SendPanelManager", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("file_short_send_panel", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("send_panel_animation_");
    localStringBuilder.append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    localEditor.putBoolean(localStringBuilder.toString(), paramBoolean).apply();
  }
  
  public List<SendPanelItemInfo> b()
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = this.h;
    if ((localCopyOnWriteArrayList != null) && (localCopyOnWriteArrayList.size() > 0)) {
      return this.h;
    }
    e();
    return null;
  }
  
  public void b(String paramString)
  {
    this.l = paramString;
  }
  
  public String c()
  {
    return this.l;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.e("SendPanelManager", 2, "onDestroy()");
    }
    m();
    IPanelDataListener localIPanelDataListener = this.i;
    if (localIPanelDataListener != null)
    {
      localIPanelDataListener.d();
      this.i = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.SendPanelManager
 * JD-Core Version:    0.7.0.1
 */