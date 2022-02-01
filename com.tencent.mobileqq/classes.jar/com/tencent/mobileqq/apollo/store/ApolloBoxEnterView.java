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
import com.tencent.mobileqq.apollo.api.model.ApolloPandora;
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
  private ApolloPandora jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloPandora;
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
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloPandora != null) {
      return this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloPandora.boxType;
    }
    return 0;
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if (paramQQAppInterface == null) {
      QLog.d("ApolloBoxEnterView", 2, "[checkBoxStateAsync] 3D return. app is null!");
    }
    do
    {
      return;
      if (((IApolloManagerService)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getCmShowStatus(paramQQAppInterface, paramString2) != 2) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloBoxEnterView", 2, "[checkBoxStateAsync] 3D return.");
    return;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.c = paramQQAppInterface.getCurrentAccountUin();
    this.b = paramString1;
    ThreadManager.executeOnSubThread(new ApolloBoxEnterView.1(this, paramString1, paramString2));
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while ((localQQAppInterface == null) || (TextUtils.isEmpty(paramString2)));
    for (;;)
    {
      try
      {
        Object localObject1 = (ApolloManagerServiceImpl)localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
        this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloPandora = ((ApolloManagerServiceImpl)localObject1).getApolloPandora(this.jdField_a_of_type_JavaLangString, true);
        Object localObject2 = ((ApolloManagerServiceImpl)localObject1).getUinForReload();
        if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject2).equals(this.jdField_a_of_type_JavaLangString))) {
          break label719;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloBoxEnterView", 2, "checkBoxState ApolloManager.sUinForReload:" + (String)localObject2);
        }
        ((ApolloManagerServiceImpl)localObject1).setUinForReload(null);
        i = 1;
        if ((i == 0) && (this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloPandora != null) && (NetConnInfoCenter.getServerTime() <= this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloPandora.checkPoint)) {
          break label463;
        }
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(256);
        if (!QLog.isColorLevel()) {
          break label713;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloPandora == null) {
          break label448;
        }
        QLog.d("ApolloBoxEnterView", 2, "checkBoxState mApolloPandora.checkPoint:" + this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloPandora.checkPoint);
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloBoxEnterView", 2, "checkBoxState check->" + bool);
        }
        if (!bool) {
          break;
        }
        localObject2 = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject2).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject2).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject2).mqqver.set("8.5.5");
        localObject1 = new WebSSOAgent.UniSsoServerReq();
        ((WebSSOAgent.UniSsoServerReq)localObject1).comm.set((MessageMicro)localObject2);
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("cmd", "apollo_interact.get_user_drawer_info");
        if (!TextUtils.isEmpty(paramString1)) {
          break label689;
        }
        paramString1 = "android";
        ((JSONObject)localObject2).put("from", paramString1);
        ((JSONObject)localObject2).put("toUin", Long.parseLong(paramString2));
        ((WebSSOAgent.UniSsoServerReq)localObject1).reqdata.set(((JSONObject)localObject2).toString());
        paramString1 = new NewIntent(localQQAppInterface.getApp(), WebSSOAgentServlet.class);
        paramString1.putExtra("extra_cmd", "apollo_interact.get_user_drawer_info");
        paramString1.putExtra("extra_data", ((WebSSOAgent.UniSsoServerReq)localObject1).toByteArray());
        paramString1.putExtra("extra_callbackid", paramString2);
        paramString1.setObserver(this);
        localQQAppInterface.startServlet(paramString1);
        return;
      }
      catch (Exception paramString1) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("ApolloBoxEnterView", 2, "queryPandoraInfo failed ", paramString1);
      return;
      label448:
      QLog.d("ApolloBoxEnterView", 2, "checkBoxState mApolloPandora == null");
      boolean bool = true;
      continue;
      label463:
      if (QLog.isColorLevel()) {
        QLog.d("ApolloBoxEnterView", 2, "checkBoxState mApolloPandora.canSteal:" + this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloPandora.canSteal + ",mApolloPandora.hadStolen:" + this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloPandora.hadStolen);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloPandora.needShow(this.jdField_a_of_type_Int))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloBoxEnterView", 2, "checkBoxState needShow, mApolloPandora.queryInterval:" + this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloPandora.queryInterval + ",mApolloPandora.updateTime:" + this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloPandora.updateTime + ",current:" + System.currentTimeMillis());
        }
        if (System.currentTimeMillis() < this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloPandora.updateTime + this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloPandora.queryInterval * 1000L)
        {
          this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(257);
          bool = false;
          continue;
        }
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(256);
        if (QLog.isColorLevel())
        {
          QLog.d("ApolloBoxEnterView", 2, "checkBoxState updateTime has past need update");
          bool = true;
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(256);
        bool = false;
        continue;
        label689:
        paramString1 = "android." + paramString1;
        continue;
      }
      label713:
      bool = true;
      continue;
      label719:
      int i = 0;
    }
  }
  
  public boolean a()
  {
    boolean bool = true;
    if (super.getVisibility() != 0) {}
    while (this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloPandora == null) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloPandora.boxType == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = 8;
    switch (paramMessage.what)
    {
    default: 
    case 255: 
      do
      {
        return false;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloPandora != null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloPandora.needShow(this.jdField_a_of_type_Int)) {
            i = 0;
          }
          setVisibility(i);
        }
      } while (!QLog.isColorLevel());
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloPandora != null)
      {
        QLog.d("ApolloBoxEnterView", 2, "checkBoxState mApolloPandora.checkPoint:" + this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloPandora.checkPoint);
        return false;
      }
      QLog.d("ApolloBoxEnterView", 2, "checkBoxState mApolloPandora == null");
      return false;
    case 257: 
      setVisibility(0);
      return false;
    }
    setVisibility(8);
    return false;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {}
    do
    {
      return;
      if (paramBoolean)
      {
        ThreadManager.executeOnSubThread(new ApolloBoxEnterView.3(this, paramBundle));
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ApolloBoxEnterView", 2, "handleQueryPandora fail ret,isSuccess:" + paramBoolean);
  }
  
  public void setApolloHadStolen()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloPandora != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloPandora.hadStolen != 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloPandora.hadStolen = 1;
      ThreadManager.executeOnSubThread(this.jdField_a_of_type_JavaLangRunnable, true);
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloBoxEnterView", 2, "setVisibility:" + paramInt);
    }
    if (paramInt == 0)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloPandora != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloPandora.mBoxTipUrl)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloBoxEnterView", 2, "setVisibility mApolloPandora.mBoxTipUrl:" + this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloPandora.mBoxTipUrl);
        }
        super.setGifData(100, null, this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloPandora.mBoxTipUrl, QQFrameZipDecoder.a(this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloPandora.mBoxTipUrl), true);
        if (!"drawer".equals(this.b)) {
          break label204;
        }
        paramInt = 0;
        if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!this.jdField_a_of_type_JavaLangString.equals(this.c))) {
          break label209;
        }
      }
      label204:
      label209:
      for (int i = 0;; i = 1)
      {
        VipUtils.a(null, "cmshow", "Apollo", "0X80065BF", paramInt, 0, new String[] { String.valueOf(i) });
        if (b() == 3) {
          super.b();
        }
        return;
        paramInt = 1;
        break;
      }
    }
    super.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloBoxEnterView
 * JD-Core Version:    0.7.0.1
 */