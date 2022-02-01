package com.tencent.biz.qqcircle.manager;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.events.QCircleSpecialFollowListLoadEvent;
import com.tencent.biz.qqcircle.events.QCircleSpecialFollowUpdateEvent;
import com.tencent.biz.qqcircle.requests.QCircleGetFollowListRequest;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StRelationInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class QCircleSpecialFollowManager
  implements Handler.Callback
{
  private final Handler a = new Handler(Looper.getMainLooper(), this);
  private final SimpleEventBus b = SimpleEventBus.getInstance();
  private final QCircleSpecialFollowManager.FollowEventReceiver c = new QCircleSpecialFollowManager.FollowEventReceiver(this.a, null);
  private String d;
  private final Set<String> e = new HashSet();
  private QCircleSpecialFollowManager.MoreInfo f;
  private int g = 0;
  private boolean h = false;
  
  private QCircleSpecialFollowManager()
  {
    this.b.registerReceiver(this.c);
  }
  
  public static QCircleSpecialFollowManager a()
  {
    return QCircleSpecialFollowManager.Holder.a();
  }
  
  private void a(QCircleSpecialFollowManager.SpecialFollowListResp paramSpecialFollowListResp, boolean paramBoolean)
  {
    this.b.dispatchEvent(new QCircleSpecialFollowListLoadEvent(paramSpecialFollowListResp, paramBoolean));
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    this.b.dispatchEvent(new QCircleSpecialFollowUpdateEvent(paramString, paramBoolean));
  }
  
  private void b(String paramString, boolean paramBoolean)
  {
    this.a.post(new QCircleSpecialFollowManager.2(this, paramBoolean, paramString));
  }
  
  public void a(FeedCloudMeta.StUser paramStUser, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void b()
  {
    String str = HostDataTransUtils.getAccount();
    if (str.equals(this.d)) {
      return;
    }
    this.d = str;
    try
    {
      this.g = 0;
      this.h = false;
      this.e.clear();
      return;
    }
    finally {}
  }
  
  public int c()
  {
    int j = this.e.size();
    int i = j;
    if (this.f != null) {
      i = j + 1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getSpecialFollowCnt: ");
    localStringBuilder.append(i);
    QLog.d("QCircleSpecialFollowMgr", 4, localStringBuilder.toString());
    return i;
  }
  
  public void d()
  {
    try
    {
      if (this.h) {
        return;
      }
      this.h = true;
      this.g += 1;
      int i = this.g;
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateSpecialFollowList: ");
      ((StringBuilder)localObject1).append(i);
      QLog.d("QCircleSpecialFollowMgr", 4, ((StringBuilder)localObject1).toString());
      localObject1 = new QCircleGetFollowListRequest(null, 0L, true);
      VSNetworkHelper.getInstance().sendRequest((BaseRequest)localObject1, new QCircleSpecialFollowManager.3(this, i));
      return;
    }
    finally {}
  }
  
  public void e()
  {
    QCircleSpecialFollowManager.MoreInfo localMoreInfo = this.f;
    if (localMoreInfo == null)
    {
      QLog.w("QCircleSpecialFollowMgr", 1, "loadMoreSpecialFollowList: wrong");
      d();
      return;
    }
    QCircleGetFollowListRequest localQCircleGetFollowListRequest = new QCircleGetFollowListRequest(QCircleSpecialFollowManager.MoreInfo.b(localMoreInfo), QCircleSpecialFollowManager.MoreInfo.c(localMoreInfo), true);
    VSNetworkHelper.getInstance().sendRequest(localQCircleGetFollowListRequest, new QCircleSpecialFollowManager.4(this, localMoreInfo));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    FeedCloudMeta.StRelationInfo localStRelationInfo;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1005: 
      a(null, true);
      return true;
    case 1004: 
      paramMessage = (QCircleSpecialFollowManager.SpecialFollowListResp)paramMessage.obj;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleMessage: more ");
      ((StringBuilder)localObject).append(QCircleSpecialFollowManager.SpecialFollowListResp.a(paramMessage));
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramMessage.a.size());
      QLog.d("QCircleSpecialFollowMgr", 1, ((StringBuilder)localObject).toString());
      localObject = this.f;
      if (localObject != null)
      {
        if (QCircleSpecialFollowManager.MoreInfo.a((QCircleSpecialFollowManager.MoreInfo)localObject) != QCircleSpecialFollowManager.SpecialFollowListResp.a(paramMessage)) {
          return true;
        }
        localObject = paramMessage.a.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localStRelationInfo = (FeedCloudMeta.StRelationInfo)((Iterator)localObject).next();
          this.e.add(localStRelationInfo.id.get());
        }
        this.f = paramMessage.b;
        a(paramMessage, false);
      }
      return true;
    case 1003: 
      this.e.clear();
      paramMessage = (QCircleSpecialFollowManager.SpecialFollowListResp)paramMessage.obj;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleMessage: update ");
      ((StringBuilder)localObject).append(QCircleSpecialFollowManager.SpecialFollowListResp.a(paramMessage));
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramMessage.a.size());
      QLog.d("QCircleSpecialFollowMgr", 1, ((StringBuilder)localObject).toString());
      localObject = paramMessage.a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localStRelationInfo = (FeedCloudMeta.StRelationInfo)((Iterator)localObject).next();
        this.e.add(localStRelationInfo.id.get());
      }
      this.f = paramMessage.b;
      a(paramMessage, true);
      return true;
    case 1002: 
      paramMessage = (String)paramMessage.obj;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleMessage: cancel ");
      ((StringBuilder)localObject).append(paramMessage);
      QLog.d("QCircleSpecialFollowMgr", 1, ((StringBuilder)localObject).toString());
      this.e.remove(paramMessage);
      a(paramMessage, false);
      if ((this.e.size() < 99) && (this.f != null)) {
        e();
      }
      return true;
    }
    paramMessage = (String)paramMessage.obj;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleMessage: follow ");
    ((StringBuilder)localObject).append(paramMessage);
    QLog.d("QCircleSpecialFollowMgr", 1, ((StringBuilder)localObject).toString());
    this.e.add(paramMessage);
    a(paramMessage, true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.manager.QCircleSpecialFollowManager
 * JD-Core Version:    0.7.0.1
 */