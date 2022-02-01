package com.tencent.mobileqq.apollo.game;

import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.apollo.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.pb.apollo.LGSessionKey.MsgAuthReq;
import com.tencent.pb.apollo.LGSessionKey.MsgAuthRsp;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONObject;

public class CmGameTempSessionHandler
  implements Handler.Callback, BusinessObserver
{
  private SparseArray<Long> jdField_a_of_type_AndroidUtilSparseArray;
  public QQLruCache<String, String> a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), this);
  private CopyOnWriteArrayList<CmGameTempSessionHandler.ICmGameMsgUIHandler> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  public QQLruCache<String, String> b = new QQLruCache(2017, 16, 64);
  
  public CmGameTempSessionHandler(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache = new QQLruCache(2016, 16, 32);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    c();
    b();
  }
  
  private void a(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject1;
    Object localObject2;
    if (paramBundle != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        return;
      }
      paramInt = paramBundle.getInt("extra_result_code");
      paramBundle.getString("key1");
      localObject1 = paramBundle.getString("cmd");
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onReceive cmd");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(",isSuccess:");
      ((StringBuilder)localObject2).append(paramBoolean);
      ((StringBuilder)localObject2).append(",svrRet:");
      ((StringBuilder)localObject2).append(paramInt);
      QLog.i("[cmshow]CmGameTemp_CmGameTempSessionHandler", 2, ((StringBuilder)localObject2).toString());
      if (!paramBoolean)
      {
        paramBundle = new StringBuilder();
        paramBundle.append("onReceive isSuccess: false, cmd:");
        paramBundle.append((String)localObject1);
        QLog.e("[cmshow]CmGameTemp_CmGameTempSessionHandler", 1, paramBundle.toString());
        return;
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = paramBundle.getByteArray("data");
        paramBundle = new WebSSOAgent.UniSsoServerRsp();
        paramBundle.mergeFrom((byte[])localObject2);
        long l = paramBundle.ret.get();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onReceive cmd:");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" retCode:");
        ((StringBuilder)localObject2).append(l);
        QLog.i("[cmshow]CmGameTemp_CmGameTempSessionHandler", 2, ((StringBuilder)localObject2).toString());
        if ("apollo_router_game.apl_audio_linkcmd_save_audio_data".equals(localObject1))
        {
          int i = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
          paramInt = 0;
          if (paramInt < i)
          {
            paramBundle = (CmGameTempSessionHandler.ICmGameMsgUIHandler)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(paramInt);
            if (paramBundle == null) {
              break label530;
            }
            paramBundle.a((int)l);
            break label530;
          }
        }
        else if ("ltgame_msg_auth.get_sign".equals(localObject1))
        {
          if (l == 0L)
          {
            localObject1 = new LGSessionKey.MsgAuthRsp();
            ((LGSessionKey.MsgAuthRsp)localObject1).mergeFrom(paramBundle.pbRsqData.get().toByteArray());
            if (QLog.isColorLevel()) {
              QLog.d("[cmshow]CmGameTemp_CmGameTempSessionHandler", 2, new Object[] { "onReceive msgAuthRsp.sign:", ((LGSessionKey.MsgAuthRsp)localObject1).sign.get().toStringUtf8(), " expired_ts:", Long.valueOf(((LGSessionKey.MsgAuthRsp)localObject1).expired_ts.get()), " create_ts:", Long.valueOf(((LGSessionKey.MsgAuthRsp)localObject1).create_ts.get()) });
            }
          }
          else if (l == -10002L)
          {
            if (QLog.isColorLevel()) {
              ApolloItemBuilder.a(HardCodeUtil.a(2131702313), 1, BaseApplicationImpl.getContext());
            }
          }
          else if (l == -10000L)
          {
            if (QLog.isColorLevel()) {
              ApolloItemBuilder.a("获取签名里面的src_uid和自己的uin不一致", 1, BaseApplicationImpl.getContext());
            }
          }
          else if (l == -10001L)
          {
            if (QLog.isColorLevel()) {
              ApolloItemBuilder.a(HardCodeUtil.a(2131702319), 1, BaseApplicationImpl.getContext());
            }
          }
          else if (QLog.isColorLevel())
          {
            paramBundle = new StringBuilder();
            paramBundle.append(HardCodeUtil.a(2131702315));
            paramBundle.append(l);
            ApolloItemBuilder.a(paramBundle.toString(), 1, BaseApplicationImpl.getContext());
            return;
          }
        }
      }
      catch (Exception paramBundle)
      {
        QLog.e("[cmshow]CmGameTemp_CmGameTempSessionHandler", 1, paramBundle, new Object[0]);
      }
      return;
      label530:
      paramInt += 1;
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    Object localObject = SharedPreferencesProxyManager.getInstance();
    int i = 0;
    localObject = ((SharedPreferencesProxyManager)localObject).getProxy("apollo_sp", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("apollo_temp_aio_game_list");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localObject = ((SharedPreferences)localObject).getString(localStringBuilder.toString(), "");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[initGameTimeStamp] game timestamp:");
    localStringBuilder.append(((String)localObject).toString());
    QLog.i("[cmshow]CmGameTemp_CmGameTempSessionHandler", 1, localStringBuilder.toString());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split(",");
      int j = localObject.length;
      for (;;)
      {
        int k = i + 1;
        if (k >= j) {
          break;
        }
        this.jdField_a_of_type_AndroidUtilSparseArray.put(Integer.parseInt(localObject[i]), Long.valueOf(Long.parseLong(localObject[k])));
        i += 2;
      }
    }
  }
  
  private void c()
  {
    ThreadManagerV2.excute(new CmGameTempSessionHandler.1(this), 16, null, false);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
  }
  
  public void a(CmGameTempSessionHandler.ICmGameMsgUIHandler paramICmGameMsgUIHandler)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramICmGameMsgUIHandler);
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramICmGameMsgUIHandler);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("addMsgUIHandler size:");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    localStringBuilder.append(" cmGameMsgUIHandler:");
    localStringBuilder.append(paramICmGameMsgUIHandler);
    QLog.i("[cmshow]CmGameTemp_CmGameTempSessionHandler", 1, localStringBuilder.toString());
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.7.0");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "apollo_router_game.apl_audio_linkcmd_save_audio_data");
      ((JSONObject)localObject).put("uin", paramString1);
      ((JSONObject)localObject).put("recordUrl", paramString2);
      ((JSONObject)localObject).put("totalTime", paramLong);
      ((JSONObject)localObject).put("extendInfo", "");
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      paramString2 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), CmGameServlet.class);
      paramString2.putExtra("timeout", 5000L);
      paramString2.putExtra("cmd", "apollo_router_game.apl_audio_linkcmd_save_audio_data");
      paramString2.putExtra("data", localUniSsoServerReq.toByteArray());
      paramString2.putExtra("key1", paramString1);
      paramString2.setObserver(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramString2);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("[cmshow]CmGameTemp_CmGameTempSessionHandler", 1, "queryAllGameList failed ", paramString1);
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.7.0");
        WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
        localUniSsoServerReq.comm.set((MessageMicro)localObject);
        localObject = new LGSessionKey.MsgAuthReq();
        ((LGSessionKey.MsgAuthReq)localObject).appid.set(2);
        ((LGSessionKey.MsgAuthReq)localObject).src_uid.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
        ((LGSessionKey.MsgAuthReq)localObject).dst_uid.set(Long.parseLong(paramString1));
        localUniSsoServerReq.pbReqData.set(ByteStringMicro.copyFrom(((LGSessionKey.MsgAuthReq)localObject).toByteArray()));
        localObject = new NewIntent(BaseApplicationImpl.getContext(), CmGameServlet.class);
        ((NewIntent)localObject).putExtra("timeout", 10000L);
        ((NewIntent)localObject).putExtra("cmd", "ltgame_msg_auth.get_sign");
        ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
        ((NewIntent)localObject).putExtra("key1", paramString1);
        ((NewIntent)localObject).putExtra("key2", paramString2);
        if (!paramBoolean) {
          break label275;
        }
        paramString2 = "1";
        ((NewIntent)localObject).putExtra("key3", paramString2);
        ((NewIntent)localObject).setObserver(this);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
        if (QLog.isColorLevel())
        {
          QLog.d("[cmshow]CmGameTemp_CmGameTempSessionHandler", 2, new Object[] { "queryNewSessionKey friendUin:", paramString1 });
          return;
        }
      }
      catch (Exception paramString1)
      {
        QLog.e("[cmshow]CmGameTemp_CmGameTempSessionHandler", 1, paramString1, new Object[0]);
      }
      return;
      label275:
      paramString2 = "0";
    }
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject1).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject1).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject1).mqqver.set("8.7.0");
        WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
        localUniSsoServerReq.comm.set((MessageMicro)localObject1);
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("cmd", "apollo_router_game.apl_audio_linkcmd_report_status");
        if (paramBoolean)
        {
          i = 1;
          ((JSONObject)localObject1).put("status", i);
          Object localObject2 = new JSONArray();
          ((JSONArray)localObject2).put(paramString);
          ((JSONObject)localObject1).put("playmate", localObject2);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramInt);
          ((StringBuilder)localObject2).append("");
          ((JSONObject)localObject1).put("from", ((StringBuilder)localObject2).toString());
          localUniSsoServerReq.reqdata.set(((JSONObject)localObject1).toString());
          localObject1 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), CmGameServlet.class);
          ((NewIntent)localObject1).putExtra("timeout", 10000L);
          ((NewIntent)localObject1).putExtra("cmd", "apollo_router_game.apl_audio_linkcmd_report_status");
          ((NewIntent)localObject1).putExtra("data", localUniSsoServerReq.toByteArray());
          ((NewIntent)localObject1).putExtra("key1", paramString);
          ((NewIntent)localObject1).setObserver(this);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject1);
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("[cmshow]CmGameTemp_CmGameTempSessionHandler", 1, "addPlayMate failed ", paramString);
        return;
      }
      int i = 0;
    }
  }
  
  public void b(CmGameTempSessionHandler.ICmGameMsgUIHandler paramICmGameMsgUIHandler)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramICmGameMsgUIHandler);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("removeMsgUIHandler size:");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    localStringBuilder.append(" cmGameMsgUIHandler:");
    localStringBuilder.append(paramICmGameMsgUIHandler);
    QLog.i("[cmshow]CmGameTemp_CmGameTempSessionHandler", 1, localStringBuilder.toString());
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]CmGameTemp_CmGameTempSessionHandler", 2, new Object[] { "handleMessage msg.what:", Integer.valueOf(paramMessage.what) });
    }
    if (paramMessage.what != 255) {
      return false;
    }
    if ((paramMessage.obj instanceof String)) {
      a((String)paramMessage.obj, "", false);
    }
    return false;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        return;
      }
      ThreadManagerV2.excute(new CmGameTempSessionHandler.2(this, paramInt, paramBoolean, paramBundle), 16, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.CmGameTempSessionHandler
 * JD-Core Version:    0.7.0.1
 */