package com.tencent.av.service;

import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.utils.SensorReport;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.nearby.NearbyFlowerMessage;
import com.tencent.mobileqq.nearby.business.NearbyCardObserver;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcall.QCallCardHandler.OnGetQCallCardListener;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import jnm;
import jno;
import jnq;
import jns;
import jnt;
import jnu;
import jnv;
import jnw;
import jnx;
import jny;
import jnz;
import mqq.app.AppRuntime;
import mqq.app.AppService;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.json.JSONObject;

public class QQServiceForAV
  extends AppService
  implements Observer
{
  public static IBinder a;
  public int a;
  long jdField_a_of_type_Long = -1L;
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new jnt(this);
  public final RemoteCallbackList a;
  final IQQServiceForAV.Stub jdField_a_of_type_ComTencentAvServiceIQQServiceForAV$Stub = new jnz(this);
  public FriendListObserver a;
  private final MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new jnq(this);
  public TroopObserver a;
  public NearbyCardObserver a;
  public QCallCardHandler.OnGetQCallCardListener a;
  public FaceDecoder.DecodeTaskCompletionListener a;
  public FaceDecoder a;
  public String a;
  public ArrayList a;
  private jnx jdField_a_of_type_Jnx;
  private jny jdField_a_of_type_Jny;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public ArrayList b;
  public boolean b;
  public String c;
  private boolean c;
  public String d = null;
  
  public QQServiceForAV()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_b_of_type_Long = 9223372036854775807L;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder$DecodeTaskCompletionListener = new jnm(this);
    this.jdField_a_of_type_ComTencentMobileqqQcallQCallCardHandler$OnGetQCallCardListener = new jno(this);
    this.jdField_a_of_type_AndroidOsRemoteCallbackList = new RemoteCallbackList();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver = new jnu(this);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new jnv(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new jnw(this);
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_AndroidOsIBinder != null;
  }
  
  private boolean a(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      switch (i)
      {
      case 6: 
      default: 
        return false;
      }
      return true;
    }
    catch (Exception localException)
    {
      AVLog.e("QQServiceForAV", "isTroopGiftGrayMsg: serviceType(" + paramString + ") cannot be parse to int");
    }
    return false;
  }
  
  public Bundle a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    int i = 0;
    Object localObject1;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("getDataFromVideoProcess, mainCmd = ").append(paramInt1).append(",subCmd = ").append(paramInt2).append(",bundle = ").append(paramBundle).append(",mCallbacks =");
      if (this.jdField_a_of_type_AndroidOsRemoteCallbackList != null)
      {
        bool = true;
        QLog.w("QQServiceForAV", 1, bool);
      }
    }
    else
    {
      localObject1 = null;
      if (this.jdField_a_of_type_AndroidOsRemoteCallbackList == null) {
        break label211;
      }
    }
    label208:
    for (;;)
    {
      synchronized (this.jdField_a_of_type_AndroidOsRemoteCallbackList)
      {
        int j = this.jdField_a_of_type_AndroidOsRemoteCallbackList.beginBroadcast();
        if (i < j)
        {
          try
          {
            Object localObject2 = this.jdField_a_of_type_AndroidOsRemoteCallbackList.getBroadcastCookie(i);
            if ((localObject2 == null) || (!(localObject2 instanceof String)) || (!localObject2.equals("video_process_cookie"))) {
              break label208;
            }
            localObject2 = ((IQQServiceCallback)this.jdField_a_of_type_AndroidOsRemoteCallbackList.getBroadcastItem(i)).a("video_process_cookie", paramInt1, paramInt2, paramBundle);
            localObject1 = localObject2;
            i += 1;
          }
          catch (RemoteException paramBundle) {}
          bool = false;
          break;
        }
        this.jdField_a_of_type_AndroidOsRemoteCallbackList.finishBroadcast();
        return localObject1;
      }
    }
    label211:
    return null;
  }
  
  public AppRuntime a()
  {
    return this.app;
  }
  
  void a(int paramInt, String paramString1, String paramString2, MessageRecord paramMessageRecord)
  {
    synchronized (this.jdField_a_of_type_AndroidOsRemoteCallbackList)
    {
      int j = this.jdField_a_of_type_AndroidOsRemoteCallbackList.beginBroadcast();
      try
      {
        RecvMsg localRecvMsg = new RecvMsg();
        int i = 0;
        if (i < j)
        {
          localRecvMsg.a(paramInt);
          localRecvMsg.a(this.jdField_c_of_type_JavaLangString);
          localRecvMsg.d(this.jdField_b_of_type_JavaLangString);
          localRecvMsg.b(paramString2);
          localRecvMsg.e(paramString1);
          localRecvMsg.c = paramMessageRecord.longMsgCount;
          localRecvMsg.d = paramMessageRecord.longMsgId;
          localRecvMsg.jdField_b_of_type_Int = paramMessageRecord.longMsgIndex;
          localRecvMsg.jdField_a_of_type_Long = paramMessageRecord.msgUid;
          String str1;
          label139:
          String str2;
          if (this.jdField_a_of_type_Int == 1) {
            if (AnonymousChatHelper.a(paramMessageRecord))
            {
              str1 = AnonymousChatHelper.a(paramMessageRecord).jdField_b_of_type_JavaLangString;
              str2 = str1;
              if (paramMessageRecord.msgtype == 2024)
              {
                str2 = str1;
                if (a(paramMessageRecord.getExtInfoFromExtStr("gray_tips_serviceType")))
                {
                  localRecvMsg.f = 3;
                  str2 = str1;
                }
              }
            }
          }
          for (;;)
          {
            localRecvMsg.c(str2);
            localRecvMsg.e = paramMessageRecord.msgtype;
            ((IQQServiceCallback)this.jdField_a_of_type_AndroidOsRemoteCallbackList.getBroadcastItem(i)).a(localRecvMsg);
            i += 1;
            break;
            str1 = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV$Stub.a(this.jdField_a_of_type_Int, paramString2, this.d);
            break label139;
            if (this.jdField_a_of_type_Int == 3000) {
              str2 = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV$Stub.a(1004, paramString2, this.jdField_b_of_type_JavaLangString);
            } else {
              str2 = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV$Stub.a(this.jdField_a_of_type_Int, paramString2, this.d);
            }
          }
        }
        paramString1 = finally;
      }
      catch (RemoteException paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQServiceForAV", 2, "callBack RemoteException", paramString1);
        }
        this.jdField_a_of_type_AndroidOsRemoteCallbackList.finishBroadcast();
        return;
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    Object localObject2 = (QQAppInterface)a();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (QQAppInterface)a();
    }
    if (localObject1 != null)
    {
      localObject2 = new Intent();
      ((Intent)localObject2).setAction("tencent.video.q2v.GroupSystemMsg");
      ((Intent)localObject2).putExtra("type", 3);
      ((Intent)localObject2).putExtra("relationType", 1);
      ((Intent)localObject2).putExtra("relationId", paramLong1);
      ((Intent)localObject2).putExtra("userUin", paramLong2);
      ((Intent)localObject2).putExtra("needSendCmd", false);
      QLog.w("QQServiceForAV", 1, "sendAdminToVideo, troopUin[" + paramLong1 + "], userUin[" + paramLong2 + "], Action[" + "tencent.video.q2v.GroupSystemMsg" + "], type[" + 3 + "]");
      ((QQAppInterface)localObject1).getApp().sendBroadcast((Intent)localObject2);
    }
  }
  
  public void a(String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)a();
    TroopHandler localTroopHandler = (TroopHandler)localQQAppInterface.a(20);
    if (localTroopHandler != null) {}
    while (!QLog.isColorLevel()) {
      try
      {
        localQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
        localTroopHandler.p(paramString);
        return;
      }
      catch (Exception paramString)
      {
        localQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
        AVLog.e("nearby.video.follow", "QQServiceForAV, getFollowStatus exp:" + paramString.getMessage());
        return;
      }
    }
    QLog.e("QQServiceForAV", 2, "QQServiceForAV, getFollowStatus, troopHandler==null");
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)a();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("client_ver", "7.6.0");
      localJSONObject.put("from", paramString2);
      if ("1".equals(paramString2))
      {
        paramString2 = localQQAppInterface.a().k(paramString1);
        if (paramString2 != null) {
          localJSONObject.put("chat_sig", new String(Base64Util.encode(paramString2, 0)));
        }
      }
      localJSONObject.put("targetuin", paramString1);
      localJSONObject.put("operation", paramString3);
      localJSONObject.put("sourceid", 3088);
      localJSONObject.put("sub_sourceid", paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("nearby.video.follow", 2, "QQServiceForAV, followUser:" + localJSONObject);
      }
      paramString2 = new NewIntent(localQQAppInterface.getApplication().getApplicationContext(), ProtoServlet.class);
      paramString2.putExtra("cmd", "MQUpdateSvc_com_qq_buluo.web.follow_user");
      WebSsoBody.WebSsoRequestBody localWebSsoRequestBody = new WebSsoBody.WebSsoRequestBody();
      localWebSsoRequestBody.type.set(0);
      localWebSsoRequestBody.data.set(localJSONObject.toString());
      paramString2.putExtra("data", localWebSsoRequestBody.toByteArray());
      paramString2.setObserver(new jns(this, paramString1, paramString3));
      localQQAppInterface.startServlet(paramString2);
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("nearby.video.follow", 2, "QQServiceForAV, followUser 1:" + paramString1.toString());
    }
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_JavaUtilArrayList.size() + this.jdField_a_of_type_JavaUtilArrayList.size() == 0;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "onBind");
    }
    this.jdField_b_of_type_Boolean = true;
    QLog.i("QQServiceForAV", 1, "mBindVideoProcessConn intent=" + paramIntent);
    if (!this.jdField_c_of_type_Boolean) {
      paramIntent = new Intent(BaseApplicationImpl.getContext(), AVServiceForQQ.class);
    }
    try
    {
      boolean bool = BaseApplicationImpl.getContext().bindService(paramIntent, this.jdField_a_of_type_AndroidContentServiceConnection, 1);
      QLog.i("QQServiceForAV", 1, "mBindVideoProcessConn bind service return " + bool);
      return this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV$Stub;
    }
    catch (Throwable paramIntent)
    {
      for (;;)
      {
        QLog.e("QQServiceForAV", 1, "mHasBindToVideoProcess exception:" + paramIntent, paramIntent);
      }
    }
  }
  
  public void onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "onCreate");
    }
    if ((a() instanceof QQAppInterface))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)a();
      if (localQQAppInterface != null) {
        this.jdField_c_of_type_JavaLangString = localQQAppInterface.getCurrentAccountUin();
      }
    }
    super.onCreate();
    SensorReport.a(this);
  }
  
  public void onDestroy()
  {
    AVLog.d("QQServiceForAV", "onDestroy");
    QQAppInterface localQQAppInterface = (QQAppInterface)a();
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = null;
    }
    this.jdField_b_of_type_Boolean = false;
    localQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    jdField_a_of_type_AndroidOsIBinder = null;
    super.onDestroy();
    SensorReport.b(this);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "onStartCommand flags: " + paramInt1 + ", startId: " + paramInt2);
    }
    if ((a() instanceof QQAppInterface))
    {
      paramIntent = (QQAppInterface)a();
      if (paramIntent != null) {
        this.jdField_c_of_type_JavaLangString = paramIntent.getCurrentAccountUin();
      }
    }
    return 3;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    AVLog.d("QQServiceForAV", "onUnbind");
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    return super.onUnbind(paramIntent);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (paramObject == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "update invalid data!");
      }
    }
    Object localObject;
    MessageRecord localMessageRecord;
    long l1;
    long l2;
    label332:
    String str;
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                localObject = (QQAppInterface)a();
                if (QLog.isColorLevel()) {
                  QLog.d("QQServiceForAV", 2, "update data: " + paramObject + ", mLastUniseq: " + this.jdField_a_of_type_Long + ",mStartTime:" + this.jdField_b_of_type_Long);
                }
              } while (!(paramObject instanceof MessageRecord));
              localMessageRecord = (MessageRecord)paramObject;
            } while ((localMessageRecord == null) || (localMessageRecord.isSendFromLocal()));
            if ((this.jdField_c_of_type_JavaLangString != null) && (localObject != null))
            {
              paramObservable = (Observable)localObject;
              if (((QQAppInterface)localObject).a() != null) {}
            }
            else
            {
              paramObject = (QQAppInterface)a();
              paramObservable = paramObject;
              if (paramObject != null)
              {
                this.jdField_c_of_type_JavaLangString = paramObject.getCurrentAccountUin();
                paramObservable = paramObject;
              }
            }
          } while ((TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)));
          if ((this.jdField_c_of_type_JavaLangString.equals(localMessageRecord.senderuin)) || ((!localMessageRecord.isSend()) && (!localMessageRecord.isread)) || (localMessageRecord.msgtype == -2035) || (localMessageRecord.msgtype == -2038) || ((localMessageRecord.msgtype == 2024) && (a(localMessageRecord.getExtInfoFromExtStr("gray_tips_serviceType"))))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("QQServiceForAV", 2, "update  continue 1");
        return;
        l1 = localMessageRecord.time;
        l2 = localMessageRecord.uniseq;
        if (this.jdField_a_of_type_Long != -1L) {
          break label332;
        }
        if (l1 >= this.jdField_b_of_type_Long) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQServiceForAV", 2, "update  continue 2");
      return;
      this.jdField_a_of_type_Long = l2;
      paramObject = localMessageRecord.selfuin;
      str = localMessageRecord.frienduin;
      localObject = localMessageRecord.senderuin;
      i = (int)localMessageRecord.vipBubbleID;
    } while ((l2 < this.jdField_a_of_type_Long) || (paramObject == null) || (str == null) || (localObject == null) || (!this.jdField_c_of_type_JavaLangString.equals(paramObject)) || (!this.jdField_b_of_type_JavaLangString.equals(str)));
    int j = localMessageRecord.msgtype;
    switch (j)
    {
    default: 
      paramObservable = null;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, ", vipBubbleId: " + i + ", senderUin: " + (String)localObject + ", msgtype: " + j + ", msg: " + paramObservable + ", time: " + l1 + ", uinseq: " + l2 + ", mLastUniseq: " + this.jdField_a_of_type_Long);
      }
      if (paramObservable != null) {
        a(i, paramObservable, (String)localObject, localMessageRecord);
      }
      this.jdField_a_of_type_Long = (1L + l2);
      return;
      paramObject = localMessageRecord.msg;
      paramObservable = paramObject;
      if (paramObject != null)
      {
        paramObservable = paramObject;
        if (paramObject.indexOf("http://maps.google.com/maps?q=") != -1)
        {
          paramObservable = getResources().getString(2131428851);
          continue;
          paramObservable = getResources().getString(2131428848);
          continue;
          paramObservable = "[秀图]";
          continue;
          paramObservable = getResources().getString(2131428849);
          continue;
          paramObservable = getResources().getString(2131428850);
          continue;
          paramObservable = getResources().getString(2131428852);
          continue;
          paramObservable = getResources().getString(2131428853);
          continue;
          paramObservable = getResources().getString(2131428854);
          continue;
          if ((localMessageRecord instanceof MessageForMixedMsg))
          {
            paramObservable = (String)MessageForMixedMsg.getTextFromMixedMsg((MessageForMixedMsg)localMessageRecord);
            continue;
            try
            {
              if ((MsgProxyUtils.r(localMessageRecord.istroop)) && ((localMessageRecord instanceof MessageForStructing)))
              {
                paramObject = (MessageForStructing)localMessageRecord;
                if (paramObject.structingMsg.mMsgServiceID != 52) {
                  break label1018;
                }
                paramObservable = new NearbyFlowerMessage(paramObservable, paramObject);
                if (!QLog.isColorLevel()) {
                  break label1018;
                }
                QLog.d("QQServiceForAV", 2, "flower message version: " + paramObservable.version);
                break label1018;
              }
              paramObservable = StructMsgFactory.a(localMessageRecord.msgData);
              if (paramObservable == null)
              {
                if (!QLog.isColorLevel()) {
                  break label1023;
                }
                QLog.d("QQServiceForAV", 2, "QQServiceForAV:getStructMsg is null");
                break label1023;
              }
              paramObservable = paramObservable.mMsgBrief;
            }
            catch (Exception paramObservable)
            {
              if (QLog.isColorLevel()) {
                QLog.d("StructMsg", 2, "QQServiceForAV:getStructMsg error", paramObservable);
              }
              paramObservable = null;
            }
            continue;
            paramObservable = getResources().getString(2131428855);
            continue;
            if ((localMessageRecord instanceof MessageForGrayTips))
            {
              paramObservable = MessageForGrayTips.getOrginMsg(((MessageForGrayTips)localMessageRecord).getSummaryMsg());
              continue;
            }
          }
          paramObservable = null;
          continue;
          label1018:
          paramObservable = null;
          continue;
          label1023:
          paramObservable = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.service.QQServiceForAV
 * JD-Core Version:    0.7.0.1
 */