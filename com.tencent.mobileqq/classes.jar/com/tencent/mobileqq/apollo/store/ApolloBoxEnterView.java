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
  private int jdField_a_of_type_Int;
  private ApolloPandora jdField_a_of_type_ComTencentMobileqqApolloModelApolloPandora;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  Runnable jdField_a_of_type_JavaLangRunnable = new ApolloBoxEnterView.2(this);
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private String b;
  private String c;
  
  public ApolloBoxEnterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ApolloBoxEnterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public int a()
  {
    ApolloPandora localApolloPandora = this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloPandora;
    if (localApolloPandora != null) {
      return localApolloPandora.boxType;
    }
    return 0;
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
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.c = paramQQAppInterface.getCurrentAccountUin();
    this.b = paramString1;
    ThreadManager.executeOnSubThread(new ApolloBoxEnterView.1(this, paramString1, paramString2));
  }
  
  protected void a(String paramString1, String paramString2)
  {
    Object localObject1 = this.jdField_a_of_type_JavaLangRefWeakReference;
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
    label823:
    label824:
    label829:
    do
    {
      for (;;)
      {
        try
        {
          localObject2 = (ApolloManagerServiceImpl)((QQAppInterface)localObject1).getRuntimeService(IApolloManagerService.class, "all");
          localObject3 = (ApolloDaoManagerServiceImpl)((QQAppInterface)localObject1).getRuntimeService(IApolloDaoManagerService.class, "all");
          localObject4 = this.jdField_a_of_type_JavaLangString;
          boolean bool2 = true;
          this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloPandora = ((ApolloDaoManagerServiceImpl)localObject3).getApolloPandora((String)localObject4, true);
          localObject3 = ((ApolloManagerServiceImpl)localObject2).getUinForReload();
          if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!((String)localObject3).equals(this.jdField_a_of_type_JavaLangString))) {
            break label824;
          }
          if (QLog.isColorLevel())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("checkBoxState ApolloManager.sUinForReload:");
            ((StringBuilder)localObject4).append((String)localObject3);
            QLog.d("[cmshow]ApolloBoxEnterView", 2, ((StringBuilder)localObject4).toString());
          }
          ((ApolloManagerServiceImpl)localObject2).setUinForReload(null);
          i = 1;
          if ((i == 0) && (this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloPandora != null) && (NetConnInfoCenter.getServerTime() <= this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloPandora.checkPoint))
          {
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("checkBoxState mApolloPandora.canSteal:");
              ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloPandora.canSteal);
              ((StringBuilder)localObject2).append(",mApolloPandora.hadStolen:");
              ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloPandora.hadStolen);
              QLog.d("[cmshow]ApolloBoxEnterView", 2, ((StringBuilder)localObject2).toString());
            }
            if (this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloPandora.needShow(this.jdField_a_of_type_Int))
            {
              if (QLog.isColorLevel())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("checkBoxState needShow, mApolloPandora.queryInterval:");
                ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloPandora.queryInterval);
                ((StringBuilder)localObject2).append(",mApolloPandora.updateTime:");
                ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloPandora.updateTime);
                ((StringBuilder)localObject2).append(",current:");
                ((StringBuilder)localObject2).append(System.currentTimeMillis());
                QLog.d("[cmshow]ApolloBoxEnterView", 2, ((StringBuilder)localObject2).toString());
              }
              if (System.currentTimeMillis() < this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloPandora.updateTime + this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloPandora.queryInterval * 1000L)
              {
                this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(257);
                break label829;
              }
              this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(256);
              bool1 = bool2;
              if (QLog.isColorLevel())
              {
                QLog.d("[cmshow]ApolloBoxEnterView", 2, "checkBoxState updateTime has past need update");
                bool1 = bool2;
              }
            }
            else
            {
              this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(256);
              break label829;
            }
          }
          else
          {
            this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(256);
            bool1 = bool2;
            if (QLog.isColorLevel()) {
              if (this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloPandora != null)
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("checkBoxState mApolloPandora.checkPoint:");
                ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloPandora.checkPoint);
                QLog.d("[cmshow]ApolloBoxEnterView", 2, ((StringBuilder)localObject2).toString());
                bool1 = bool2;
              }
              else
              {
                QLog.d("[cmshow]ApolloBoxEnterView", 2, "checkBoxState mApolloPandora == null");
                bool1 = bool2;
              }
            }
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
          Object localObject4;
          if (!QLog.isColorLevel()) {
            break label823;
          }
          QLog.e("[cmshow]ApolloBoxEnterView", 2, "queryPandoraInfo failed ", paramString1);
        }
        localObject3 = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject3).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject3).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject3).mqqver.set("8.7.0");
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
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("android.");
          ((StringBuilder)localObject4).append(paramString1);
          paramString1 = ((StringBuilder)localObject4).toString();
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
        int i = 0;
        continue;
        bool1 = false;
      }
    } while (bool1);
  }
  
  public boolean a()
  {
    int i = super.getVisibility();
    boolean bool2 = false;
    if (i != 0) {
      return false;
    }
    ApolloPandora localApolloPandora = this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloPandora;
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
  
  public boolean handleMessage(Message paramMessage)
  {
    int j = paramMessage.what;
    int i = 8;
    switch (j)
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
    paramMessage = this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloPandora;
    if (paramMessage != null)
    {
      if (paramMessage.needShow(this.jdField_a_of_type_Int)) {
        i = 0;
      }
      setVisibility(i);
    }
    if (QLog.isColorLevel())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloPandora != null)
      {
        paramMessage = new StringBuilder();
        paramMessage.append("checkBoxState mApolloPandora.checkPoint:");
        paramMessage.append(this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloPandora.checkPoint);
        QLog.d("[cmshow]ApolloBoxEnterView", 2, paramMessage.toString());
        return false;
      }
      QLog.d("[cmshow]ApolloBoxEnterView", 2, "checkBoxState mApolloPandora == null");
    }
    return false;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
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
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("handleQueryPandora fail ret,isSuccess:");
        paramBundle.append(paramBoolean);
        QLog.e("[cmshow]ApolloBoxEnterView", 2, paramBundle.toString());
      }
    }
  }
  
  public void setApolloHadStolen()
  {
    ApolloPandora localApolloPandora = this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloPandora;
    if ((localApolloPandora != null) && (localApolloPandora.hadStolen != 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloPandora.hadStolen = 1;
      ThreadManager.executeOnSubThread(this.jdField_a_of_type_JavaLangRunnable, true);
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
      localObject = this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloPandora;
      if ((localObject != null) && (!TextUtils.isEmpty(((ApolloPandora)localObject).mBoxTipUrl)))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("setVisibility mApolloPandora.mBoxTipUrl:");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloPandora.mBoxTipUrl);
          QLog.d("[cmshow]ApolloBoxEnterView", 2, ((StringBuilder)localObject).toString());
        }
        super.setGifData(100, null, this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloPandora.mBoxTipUrl, QQFrameZipDecoder.a(this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloPandora.mBoxTipUrl), true);
        boolean bool = "drawer".equals(this.b);
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(this.c))) {
          paramInt = 0;
        } else {
          paramInt = 1;
        }
        VipUtils.a(null, "cmshow", "Apollo", "0X80065BF", bool ^ true, 0, new String[] { String.valueOf(paramInt) });
        if (b() == 3) {
          super.b();
        }
      }
    }
    else
    {
      super.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloBoxEnterView
 * JD-Core Version:    0.7.0.1
 */