package com.tencent.mobileqq.apollo.store;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.model.ApolloPandora;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.view.FrameGifView;
import com.tencent.mobileqq.apollo.view.QQFrameZipDecoder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.jsp.WebSSOAgentServlet;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public class ApolloBoxEnterView
  extends FrameGifView
  implements Handler.Callback, BusinessObserver
{
  Runnable a = new ApolloBoxEnterView.2(this);
  private WeakReference<QQAppInterface> d;
  private ApolloPandora e;
  private String f;
  private WeakReferenceHandler g = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private String h;
  private String i;
  private int j;
  
  public ApolloBoxEnterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ApolloBoxEnterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if (paramQQAppInterface == null)
    {
      QLog.d("[cmshow]ApolloBoxEnterView", 2, "[checkBoxStateAsync] 3D return. app is null!");
      return;
    }
    if (((IApolloManagerService)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getCmShowStatus(paramString2) == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloBoxEnterView", 2, "[checkBoxStateAsync] 3D return.");
      }
      return;
    }
    this.j = paramInt;
    this.d = new WeakReference(paramQQAppInterface);
    this.f = paramString2;
    this.i = paramQQAppInterface.getCurrentAccountUin();
    this.h = paramString1;
    ThreadManager.executeOnSubThread(new ApolloBoxEnterView.1(this, paramString1, paramString2));
  }
  
  protected void a(String paramString1, String paramString2)
  {
    Object localObject1 = this.d;
    if (localObject1 == null) {
      return;
    }
    localObject1 = (QQAppInterface)((WeakReference)localObject1).get();
    if (localObject1 != null) {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
    }
    boolean bool1;
    label797:
    label802:
    do
    {
      for (;;)
      {
        try
        {
          localObject2 = (ApolloManagerServiceImpl)((QQAppInterface)localObject1).getRuntimeService(IApolloManagerService.class, "all");
          this.e = ((ApolloDaoManagerServiceImpl)((QQAppInterface)localObject1).getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloPandora(this.f, true);
          localObject3 = ((ApolloManagerServiceImpl)localObject2).getUinForReload();
          boolean bool2 = TextUtils.isEmpty((CharSequence)localObject3);
          bool1 = false;
          if ((bool2) || (!((String)localObject3).equals(this.f))) {
            break label797;
          }
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("checkBoxState ApolloManager.sUinForReload:");
            localStringBuilder.append((String)localObject3);
            QLog.d("[cmshow]ApolloBoxEnterView", 2, localStringBuilder.toString());
          }
          ((ApolloManagerServiceImpl)localObject2).setUinForReload(null);
          k = 1;
          if ((k == 0) && (this.e != null) && (NetConnInfoCenter.getServerTime() <= this.e.checkPoint))
          {
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("checkBoxState mApolloPandora.canSteal:");
              ((StringBuilder)localObject2).append(this.e.canSteal);
              ((StringBuilder)localObject2).append(",mApolloPandora.hadStolen:");
              ((StringBuilder)localObject2).append(this.e.hadStolen);
              QLog.d("[cmshow]ApolloBoxEnterView", 2, ((StringBuilder)localObject2).toString());
            }
            if (this.e.needShow(this.j))
            {
              if (QLog.isColorLevel())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("checkBoxState needShow, mApolloPandora.queryInterval:");
                ((StringBuilder)localObject2).append(this.e.queryInterval);
                ((StringBuilder)localObject2).append(",mApolloPandora.updateTime:");
                ((StringBuilder)localObject2).append(this.e.updateTime);
                ((StringBuilder)localObject2).append(",current:");
                ((StringBuilder)localObject2).append(System.currentTimeMillis());
                QLog.d("[cmshow]ApolloBoxEnterView", 2, ((StringBuilder)localObject2).toString());
              }
              if (System.currentTimeMillis() < this.e.updateTime + this.e.queryInterval * 1000L)
              {
                this.g.sendEmptyMessage(257);
              }
              else
              {
                this.g.sendEmptyMessage(256);
                if (!QLog.isColorLevel()) {
                  break label802;
                }
                QLog.d("[cmshow]ApolloBoxEnterView", 2, "checkBoxState updateTime has past need update");
                break label802;
              }
            }
            else
            {
              this.g.sendEmptyMessage(256);
            }
          }
          else
          {
            this.g.sendEmptyMessage(256);
            if (!QLog.isColorLevel()) {
              break label802;
            }
            if (this.e != null)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("checkBoxState mApolloPandora.checkPoint:");
              ((StringBuilder)localObject2).append(this.e.checkPoint);
              QLog.d("[cmshow]ApolloBoxEnterView", 2, ((StringBuilder)localObject2).toString());
              break label802;
            }
            QLog.d("[cmshow]ApolloBoxEnterView", 2, "checkBoxState mApolloPandora == null");
            break label802;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("checkBoxState check->");
          ((StringBuilder)localObject2).append(bool1);
          QLog.d("[cmshow]ApolloBoxEnterView", 2, ((StringBuilder)localObject2).toString());
        }
        catch (Exception paramString1)
        {
          Object localObject2;
          Object localObject3;
          StringBuilder localStringBuilder;
          QLog.e("[cmshow]ApolloBoxEnterView", 1, "queryPandoraInfo failed ", paramString1);
        }
        localObject3 = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject3).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject3).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject3).mqqver.set("8.8.17");
        localObject2 = new WebSSOAgent.UniSsoServerReq();
        ((WebSSOAgent.UniSsoServerReq)localObject2).comm.set((MessageMicro)localObject3);
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("cmd", "apollo_interact.get_user_drawer_info");
        if (TextUtils.isEmpty(paramString1))
        {
          paramString1 = "android";
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("android.");
          localStringBuilder.append(paramString1);
          paramString1 = localStringBuilder.toString();
        }
        ((JSONObject)localObject3).put("from", paramString1);
        ((JSONObject)localObject3).put("toUin", Long.parseLong(paramString2));
        ((WebSSOAgent.UniSsoServerReq)localObject2).reqdata.set(((JSONObject)localObject3).toString());
        paramString1 = new NewIntent(((QQAppInterface)localObject1).getApp(), WebSSOAgentServlet.class);
        paramString1.putExtra("extra_cmd", "apollo_interact.get_user_drawer_info");
        paramString1.putExtra("extra_data", ((WebSSOAgent.UniSsoServerReq)localObject2).toByteArray());
        paramString1.putExtra("extra_callbackid", paramString2);
        paramString1.setObserver(this);
        ((QQAppInterface)localObject1).startServlet(paramString1);
        return;
        return;
        int k = 0;
        continue;
        bool1 = true;
      }
    } while (bool1);
  }
  
  public boolean a()
  {
    int k = super.getVisibility();
    boolean bool2 = false;
    if (k != 0) {
      return false;
    }
    ApolloPandora localApolloPandora = this.e;
    boolean bool1 = bool2;
    if (localApolloPandora != null)
    {
      bool1 = bool2;
      if (localApolloPandora.boxType == 1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int getBoxType()
  {
    ApolloPandora localApolloPandora = this.e;
    if (localApolloPandora != null) {
      return localApolloPandora.boxType;
    }
    return 0;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int m = paramMessage.what;
    int k = 8;
    switch (m)
    {
    default: 
      return false;
    case 257: 
      setVisibility(0);
      return false;
    case 256: 
      setVisibility(8);
      return false;
    }
    paramMessage = this.e;
    if (paramMessage != null)
    {
      if (paramMessage.needShow(this.j)) {
        k = 0;
      }
      setVisibility(k);
    }
    if (QLog.isColorLevel())
    {
      if (this.e != null)
      {
        paramMessage = new StringBuilder();
        paramMessage.append("checkBoxState mApolloPandora.checkPoint:");
        paramMessage.append(this.e.checkPoint);
        QLog.d("[cmshow]ApolloBoxEnterView", 2, paramMessage.toString());
        return false;
      }
      QLog.d("[cmshow]ApolloBoxEnterView", 2, "checkBoxState mApolloPandora == null");
    }
    return false;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    WeakReference localWeakReference = this.d;
    if (localWeakReference != null)
    {
      if (localWeakReference.get() == null) {
        return;
      }
      if (paramBoolean)
      {
        ThreadManager.executeOnSubThread(new ApolloBoxEnterView.3(this, paramBundle));
        return;
      }
      paramBundle = new StringBuilder();
      paramBundle.append("handleQueryPandora fail ret,isSuccess:");
      paramBundle.append(paramBoolean);
      QLog.e("[cmshow]ApolloBoxEnterView", 1, paramBundle.toString());
    }
  }
  
  public void setApolloHadStolen()
  {
    ApolloPandora localApolloPandora = this.e;
    if ((localApolloPandora != null) && (localApolloPandora.hadStolen != 1))
    {
      this.e.hadStolen = 1;
      ThreadManager.executeOnSubThread(this.a, true);
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setVisibility:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("[cmshow]ApolloBoxEnterView", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt == 0)
    {
      localObject = this.e;
      if ((localObject != null) && (!TextUtils.isEmpty(((ApolloPandora)localObject).mBoxTipUrl)))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("setVisibility mApolloPandora.mBoxTipUrl:");
          ((StringBuilder)localObject).append(this.e.mBoxTipUrl);
          QLog.d("[cmshow]ApolloBoxEnterView", 2, ((StringBuilder)localObject).toString());
        }
        super.setGifData(100, null, this.e.mBoxTipUrl, QQFrameZipDecoder.a(this.e.mBoxTipUrl), true);
        boolean bool = "drawer".equals(this.h);
        if ((!TextUtils.isEmpty(this.f)) && (this.f.equals(this.i))) {
          paramInt = 0;
        } else {
          paramInt = 1;
        }
        VipUtils.a(null, "cmshow", "Apollo", "0X80065BF", bool ^ true, 0, new String[] { String.valueOf(paramInt) });
        if (getState() == 3) {
          super.c();
        }
      }
    }
    else
    {
      super.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloBoxEnterView
 * JD-Core Version:    0.7.0.1
 */