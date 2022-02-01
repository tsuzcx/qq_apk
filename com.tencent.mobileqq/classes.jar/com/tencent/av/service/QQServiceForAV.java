package com.tencent.av.service;

import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.utils.SensorReport;
import com.tencent.av.utils.api.IVideoProcessMonitor;
import com.tencent.av.wtogether.WTogetherRealNameMainProcessHelper;
import com.tencent.biz.ProtoServlet;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.GVideoHandler;
import com.tencent.mobileqq.app.GVideoObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.nearby.api.INearbyFlowerMessage;
import com.tencent.mobileqq.nearby.business.NearbyCardObserver;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcall.QCallCardHandler.OnGetQCallCardListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import mqq.app.AppRuntime;
import mqq.app.AppService;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.util.LogUtil;
import org.json.JSONObject;

public class QQServiceForAV
  extends AppService
  implements Observer
{
  private final MessageObserver A = new QQServiceForAV.3(this);
  private boolean B = false;
  private ServiceConnection C = new QQServiceForAV.5(this);
  int a = 0;
  int b = 0;
  String c = null;
  String d = null;
  String e = null;
  String f = null;
  long g = -1L;
  long h = 9223372036854775807L;
  IFaceDecoder i = null;
  boolean j = false;
  DecodeTaskCompletionListener k = new QQServiceForAV.1(this);
  QCallCardHandler.OnGetQCallCardListener l = new QQServiceForAV.2(this);
  final RemoteCallbackList<IQQServiceCallback> m = new RemoteCallbackList();
  final IQQServiceForAV.Stub n = new QQServiceForAV.QQServiceForAVBinder(this);
  boolean o = false;
  NearbyCardObserver p = new QQServiceForAV.6(this);
  TroopObserver q = new QQServiceForAV.7(this);
  GVideoObserver r = new QQServiceForAV.8(this);
  ArrayList<String> s = new ArrayList();
  ArrayList<String> t = new ArrayList();
  AvatarObserver u = new QQServiceForAV.9(this);
  FriendListObserver v = new QQServiceForAV.10(this);
  private boolean w;
  private WTogetherRealNameMainProcessHelper x;
  private QQServiceForAV.CMSConfigUpdateListener y = null;
  private QQServiceForAV.LocationListener z = null;
  
  private static void b(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    try
    {
      Object localObject = paramBundle.getString("uin");
      int i1 = paramBundle.getInt("uinType");
      paramBundle = paramBundle.getString("wording");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("writeGrayMsg_in_QQ, peerUin[");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("], wording[");
      localStringBuilder.append(paramBundle);
      localStringBuilder.append("]");
      QLog.w("QQServiceForAV", 1, localStringBuilder.toString());
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        paramBundle = new UniteGrayTipParam((String)localObject, paramQQAppInterface.getCurrentAccountUin(), paramBundle, i1, -5040, 65560, 0L);
        localObject = new MessageForUniteGrayTip();
        ((MessageForUniteGrayTip)localObject).initGrayTipMsg(paramQQAppInterface, paramBundle);
        UniteGrayTipMsgUtil.a(paramQQAppInterface, (MessageForUniteGrayTip)localObject);
        return;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("writeGrayMsg_in_QQ, Exception[");
      paramBundle.append(paramQQAppInterface.getClass().getName());
      paramBundle.append("]");
      QLog.w("QQServiceForAV", 1, paramBundle.toString(), paramQQAppInterface);
    }
  }
  
  private boolean b(String paramString)
  {
    try
    {
      int i1 = Integer.parseInt(paramString);
      return (i1 == 5) || (i1 == 7);
    }
    catch (Exception localException)
    {
      label20:
      StringBuilder localStringBuilder;
      break label20;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("isTroopGiftGrayMsg: serviceType(");
    localStringBuilder.append(paramString);
    localStringBuilder.append(") cannot be parse to int");
    AVLog.printErrorLog("QQServiceForAV", localStringBuilder.toString());
    return false;
  }
  
  /* Error */
  public Bundle a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    // Byte code:
    //   0: invokestatic 289	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: istore 6
    //   5: iconst_0
    //   6: istore 4
    //   8: iload 6
    //   10: ifeq +104 -> 114
    //   13: new 191	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   20: astore 7
    //   22: aload 7
    //   24: ldc_w 291
    //   27: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload 7
    //   33: iload_1
    //   34: invokevirtual 294	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload 7
    //   40: ldc_w 296
    //   43: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload 7
    //   49: iload_2
    //   50: invokevirtual 294	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload 7
    //   56: ldc_w 298
    //   59: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload 7
    //   65: aload_3
    //   66: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload 7
    //   72: ldc_w 303
    //   75: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload_0
    //   80: getfield 102	com/tencent/av/service/QQServiceForAV:m	Landroid/os/RemoteCallbackList;
    //   83: ifnull +9 -> 92
    //   86: iconst_1
    //   87: istore 6
    //   89: goto +6 -> 95
    //   92: iconst_0
    //   93: istore 6
    //   95: aload 7
    //   97: iload 6
    //   99: invokevirtual 306	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: ldc 204
    //   105: iconst_1
    //   106: aload 7
    //   108: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 213	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: aconst_null
    //   115: astore 7
    //   117: aload_0
    //   118: getfield 102	com/tencent/av/service/QQServiceForAV:m	Landroid/os/RemoteCallbackList;
    //   121: astore 9
    //   123: aload 9
    //   125: ifnull +126 -> 251
    //   128: aload 9
    //   130: monitorenter
    //   131: aload_0
    //   132: getfield 102	com/tencent/av/service/QQServiceForAV:m	Landroid/os/RemoteCallbackList;
    //   135: invokevirtual 310	android/os/RemoteCallbackList:beginBroadcast	()I
    //   138: istore 5
    //   140: iload 4
    //   142: iload 5
    //   144: if_icmpge +88 -> 232
    //   147: aload_0
    //   148: getfield 102	com/tencent/av/service/QQServiceForAV:m	Landroid/os/RemoteCallbackList;
    //   151: iload 4
    //   153: invokevirtual 314	android/os/RemoteCallbackList:getBroadcastCookie	(I)Ljava/lang/Object;
    //   156: astore 10
    //   158: aload 7
    //   160: astore 8
    //   162: aload 10
    //   164: ifnull +55 -> 219
    //   167: aload 7
    //   169: astore 8
    //   171: aload 10
    //   173: instanceof 316
    //   176: ifeq +43 -> 219
    //   179: aload 7
    //   181: astore 8
    //   183: aload 10
    //   185: ldc_w 318
    //   188: invokevirtual 322	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   191: ifeq +28 -> 219
    //   194: aload_0
    //   195: getfield 102	com/tencent/av/service/QQServiceForAV:m	Landroid/os/RemoteCallbackList;
    //   198: iload 4
    //   200: invokevirtual 326	android/os/RemoteCallbackList:getBroadcastItem	(I)Landroid/os/IInterface;
    //   203: checkcast 328	com/tencent/av/service/IQQServiceCallback
    //   206: ldc_w 318
    //   209: iload_1
    //   210: iload_2
    //   211: aload_3
    //   212: invokeinterface 331 5 0
    //   217: astore 8
    //   219: iload 4
    //   221: iconst_1
    //   222: iadd
    //   223: istore 4
    //   225: aload 8
    //   227: astore 7
    //   229: goto -89 -> 140
    //   232: aload_0
    //   233: getfield 102	com/tencent/av/service/QQServiceForAV:m	Landroid/os/RemoteCallbackList;
    //   236: invokevirtual 334	android/os/RemoteCallbackList:finishBroadcast	()V
    //   239: aload 9
    //   241: monitorexit
    //   242: aload 7
    //   244: areturn
    //   245: astore_3
    //   246: aload 9
    //   248: monitorexit
    //   249: aload_3
    //   250: athrow
    //   251: aconst_null
    //   252: areturn
    //   253: astore_3
    //   254: goto -22 -> 232
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	this	QQServiceForAV
    //   0	257	1	paramInt1	int
    //   0	257	2	paramInt2	int
    //   0	257	3	paramBundle	Bundle
    //   6	218	4	i1	int
    //   138	7	5	i2	int
    //   3	95	6	bool	boolean
    //   20	223	7	localObject1	Object
    //   160	66	8	localObject2	Object
    //   121	126	9	localRemoteCallbackList	RemoteCallbackList
    //   156	28	10	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   131	140	245	finally
    //   147	158	245	finally
    //   171	179	245	finally
    //   183	219	245	finally
    //   232	242	245	finally
    //   246	249	245	finally
    //   147	158	253	android/os/RemoteException
    //   171	179	253	android/os/RemoteException
    //   183	219	253	android/os/RemoteException
  }
  
  AppRuntime a()
  {
    return this.app;
  }
  
  void a(long paramLong1, long paramLong2)
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendAdminToVideo, troopUin[");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("], userUin[");
      localStringBuilder.append(LogUtil.getSafePrintUin(String.valueOf(paramLong2)));
      localStringBuilder.append("], Action[");
      localStringBuilder.append("tencent.video.q2v.GroupSystemMsg");
      localStringBuilder.append("], type[");
      localStringBuilder.append(3);
      localStringBuilder.append("]");
      QLog.w("QQServiceForAV", 1, localStringBuilder.toString());
      ((QQAppInterface)localObject1).getApp().sendBroadcast((Intent)localObject2);
    }
  }
  
  public void a(String paramString)
  {
    Object localObject = (QQAppInterface)a();
    GVideoHandler localGVideoHandler = (GVideoHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.GVIDEO_HANDLER);
    if (localGVideoHandler != null) {
      try
      {
        ((QQAppInterface)localObject).addObserver(this.r);
        localGVideoHandler.a(paramString);
        return;
      }
      catch (Exception paramString)
      {
        ((QQAppInterface)localObject).removeObserver(this.r);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("QQServiceForAV, getFollowStatus exp:");
        ((StringBuilder)localObject).append(paramString.getMessage());
        AVLog.printErrorLog("nearby.video.follow", ((StringBuilder)localObject).toString());
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("QQServiceForAV", 2, "QQServiceForAV, getFollowStatus, troopHandler==null");
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)a();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("client_ver", "8.8.17");
      localJSONObject.put("from", paramString2);
      if ("1".equals(paramString2))
      {
        paramString2 = localQQAppInterface.getMsgCache().o(paramString1);
        if (paramString2 != null) {
          localJSONObject.put("chat_sig", new String(Base64Util.encode(paramString2, 0)));
        }
      }
      localJSONObject.put("targetuin", paramString1);
      localJSONObject.put("operation", paramString3);
      localJSONObject.put("sourceid", 3088);
      localJSONObject.put("sub_sourceid", paramInt);
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("QQServiceForAV, followUser:");
        paramString2.append(localJSONObject);
        QLog.d("nearby.video.follow", 2, paramString2.toString());
      }
      paramString2 = new NewIntent(localQQAppInterface.getApplication().getApplicationContext(), ProtoServlet.class);
      paramString2.putExtra("cmd", "MQUpdateSvc_com_qq_buluo.web.follow_user");
      WebSsoBody.WebSsoRequestBody localWebSsoRequestBody = new WebSsoBody.WebSsoRequestBody();
      localWebSsoRequestBody.type.set(0);
      localWebSsoRequestBody.data.set(localJSONObject.toString());
      paramString2.putExtra("data", localWebSsoRequestBody.toByteArray());
      paramString2.setObserver(new QQServiceForAV.4(this, paramString1, paramString3));
      localQQAppInterface.startServlet(paramString2);
      return;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("QQServiceForAV, followUser 1:");
        paramString2.append(paramString1.toString());
        QLog.e("nearby.video.follow", 2, paramString2.toString());
      }
    }
  }
  
  public boolean a(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    boolean bool2;
    label132:
    label244:
    synchronized (this.m)
    {
      int i3 = this.m.beginBroadcast();
      int i2 = 0;
      int i1 = 0;
      boolean bool1 = false;
      for (;;)
      {
        bool2 = bool1;
        if (i1 >= i3) {
          break label132;
        }
        try
        {
          Object localObject = this.m.getBroadcastCookie(i1);
          bool2 = bool1;
          if ((localObject instanceof String))
          {
            bool2 = bool1;
            if (localObject.equals("video_process_cookie"))
            {
              ((IQQServiceCallback)this.m.getBroadcastItem(i1)).a(paramString, paramInt, paramArrayOfByte);
              bool2 = true;
            }
          }
          i1 += 1;
          bool1 = bool2;
        }
        catch (Throwable paramString)
        {
          if (!QLog.isColorLevel()) {
            break label244;
          }
        }
      }
      QLog.i("QQServiceForAV", 2, "onReceiveChatRoomPushMsg", paramString);
      break label244;
      this.m.finishBroadcast();
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("onReceiveChatRoomPushMsg, msgType[");
        paramString.append(paramInt);
        paramString.append("], bytes[");
        if (paramArrayOfByte == null) {
          paramInt = i2;
        } else {
          paramInt = paramArrayOfByte.length;
        }
        paramString.append(paramInt);
        paramString.append("], ret[");
        paramString.append(bool2);
        paramString.append("]");
        QLog.w("QQServiceForAV", 1, paramString.toString());
      }
      return bool2;
    }
  }
  
  boolean b()
  {
    return this.s.size() == 0;
  }
  
  boolean c()
  {
    return this.t.size() == 0;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "onBind");
    }
    this.o = true;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mBindVideoProcessConn intent=");
    localStringBuilder.append(paramIntent);
    QLog.i("QQServiceForAV", 1, localStringBuilder.toString());
    if (!this.B)
    {
      paramIntent = new Intent(BaseApplicationImpl.getContext(), AVServiceForQQ.class);
      try
      {
        boolean bool = BaseApplicationImpl.getContext().bindService(paramIntent, this.C, 1);
        paramIntent = new StringBuilder();
        paramIntent.append("mBindVideoProcessConn bind service return ");
        paramIntent.append(bool);
        QLog.i("QQServiceForAV", 1, paramIntent.toString());
      }
      catch (Throwable paramIntent)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("mHasBindToVideoProcess exception:");
        localStringBuilder.append(paramIntent);
        QLog.e("QQServiceForAV", 1, localStringBuilder.toString(), paramIntent);
      }
    }
    return this.n;
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
        this.e = localQQAppInterface.getCurrentAccountUin();
      }
    }
    super.onCreate();
    SensorReport.a(this);
  }
  
  public void onDestroy()
  {
    AVLog.printAllUserLog("QQServiceForAV", "onDestroy");
    Object localObject = (QQAppInterface)a();
    IFaceDecoder localIFaceDecoder = this.i;
    if (localIFaceDecoder != null)
    {
      localIFaceDecoder.destory();
      this.i = null;
    }
    this.o = false;
    ((QQAppInterface)localObject).removeObserver(this.v);
    ((QQAppInterface)localObject).removeObserver(this.u);
    ((IVideoProcessMonitor)QRoute.api(IVideoProcessMonitor.class)).clearMonitorBinder();
    localObject = this.x;
    if (localObject != null)
    {
      ((WTogetherRealNameMainProcessHelper)localObject).b();
      this.x = null;
    }
    super.onDestroy();
    SensorReport.b(this);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("onStartCommand flags: ");
      paramIntent.append(paramInt1);
      paramIntent.append(", startId: ");
      paramIntent.append(paramInt2);
      QLog.d("QQServiceForAV", 2, paramIntent.toString());
    }
    if ((a() instanceof QQAppInterface))
    {
      paramIntent = (QQAppInterface)a();
      if (paramIntent != null) {
        this.e = paramIntent.getCurrentAccountUin();
      }
    }
    return 3;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    AVLog.printAllUserLog("QQServiceForAV", "onUnbind");
    this.o = false;
    this.B = false;
    return super.onUnbind(paramIntent);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (paramObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "update invalid data!");
      }
      return;
    }
    paramObservable = (QQAppInterface)a();
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("update data: ");
      ((StringBuilder)localObject1).append(paramObject);
      ((StringBuilder)localObject1).append(", mLastUniseq: ");
      ((StringBuilder)localObject1).append(this.g);
      ((StringBuilder)localObject1).append(",mStartTime:");
      ((StringBuilder)localObject1).append(this.h);
      QLog.d("QQServiceForAV", 2, ((StringBuilder)localObject1).toString());
    }
    if (!(paramObject instanceof MessageRecord)) {
      return;
    }
    Object localObject2 = (MessageRecord)paramObject;
    if ((localObject2 != null) && (!((MessageRecord)localObject2).isSendFromLocal()))
    {
      if ((this.e != null) && (paramObservable != null))
      {
        paramObject = paramObservable;
        if (paramObservable.getMessageFacade() != null) {}
      }
      else
      {
        paramObservable = (QQAppInterface)a();
        paramObject = paramObservable;
        if (paramObservable != null)
        {
          this.e = paramObservable.getCurrentAccountUin();
          paramObject = paramObservable;
        }
      }
      if (!TextUtils.isEmpty(this.e))
      {
        if (TextUtils.isEmpty(this.d)) {
          return;
        }
        if ((!this.e.equals(((MessageRecord)localObject2).senderuin)) && ((((MessageRecord)localObject2).isSend()) || (((MessageRecord)localObject2).isread)) && (((MessageRecord)localObject2).msgtype != -2035) && (((MessageRecord)localObject2).msgtype != -2038) && ((((MessageRecord)localObject2).msgtype != 2024) || (!b(((MessageRecord)localObject2).getExtInfoFromExtStr("gray_tips_serviceType")))))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQServiceForAV", 2, "update  continue 1");
          }
          return;
        }
        long l1 = ((MessageRecord)localObject2).time;
        long l2 = ((MessageRecord)localObject2).uniseq;
        if (this.g == -1L)
        {
          if (l1 < this.h)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQServiceForAV", 2, "update  continue 2");
            }
            return;
          }
          this.g = l2;
        }
        paramObservable = ((MessageRecord)localObject2).selfuin;
        localObject1 = ((MessageRecord)localObject2).frienduin;
        String str = ((MessageRecord)localObject2).senderuin;
        int i1 = (int)((MessageRecord)localObject2).vipBubbleID;
        if ((l2 >= this.g) && (paramObservable != null) && (localObject1 != null) && (str != null) && (this.e.equals(paramObservable)) && (this.d.equals(localObject1)))
        {
          int i2 = ((MessageRecord)localObject2).msgtype;
          localObject1 = null;
          switch (i2)
          {
          default: 
            paramObservable = (Observable)localObject1;
            break;
          case 2024: 
            paramObservable = (Observable)localObject1;
            if ((localObject2 instanceof MessageForGrayTips)) {
              paramObservable = MessageForGrayTips.getOrginMsg(((MessageForGrayTips)localObject2).getSummaryMsg());
            }
            break;
          case -1000: 
            paramObject = ((MessageRecord)localObject2).msg;
            paramObservable = paramObject;
            if (paramObject != null)
            {
              paramObservable = paramObject;
              if (paramObject.indexOf("http://maps.google.com/maps?q=") != -1) {
                paramObservable = getResources().getString(2131917923);
              }
            }
            break;
          case -1035: 
            paramObservable = (Observable)localObject1;
            if ((localObject2 instanceof MessageForMixedMsg)) {
              paramObservable = (String)MessageForMixedMsg.getTextFromMixedMsg((MessageForMixedMsg)localObject2);
            }
            break;
          case -2000: 
            paramObservable = getResources().getString(2131917924);
            break;
          case -2002: 
          case -1031: 
            paramObservable = getResources().getString(2131917925);
            break;
          case -2007: 
          case -2001: 
            paramObservable = getResources().getString(2131917921);
            break;
          case -2011: 
            try
            {
              if ((UinTypeUtil.j(((MessageRecord)localObject2).istroop)) && ((localObject2 instanceof MessageForStructing)))
              {
                MessageForStructing localMessageForStructing = (MessageForStructing)localObject2;
                paramObservable = (Observable)localObject1;
                if (localMessageForStructing.structingMsg.mMsgServiceID == 52)
                {
                  localObject2 = (INearbyFlowerMessage)QRoute.api(INearbyFlowerMessage.class);
                  ((INearbyFlowerMessage)localObject2).init(paramObject, localMessageForStructing);
                  paramObservable = (Observable)localObject1;
                  if (QLog.isColorLevel())
                  {
                    paramObservable = new StringBuilder();
                    paramObservable.append("flower message version: ");
                    paramObservable.append(((INearbyFlowerMessage)localObject2).getVersion());
                    QLog.d("QQServiceForAV", 2, paramObservable.toString());
                    paramObservable = (Observable)localObject1;
                  }
                }
              }
              else
              {
                paramObservable = StructMsgFactory.a(((MessageRecord)localObject2).msgData);
                if (paramObservable == null)
                {
                  paramObservable = (Observable)localObject1;
                  if (QLog.isColorLevel())
                  {
                    QLog.d("QQServiceForAV", 2, "QQServiceForAV:getStructMsg is null");
                    paramObservable = (Observable)localObject1;
                  }
                }
                else
                {
                  paramObservable = paramObservable.mMsgBrief;
                }
              }
            }
            catch (Exception paramObject)
            {
              paramObservable = (Observable)localObject1;
              if (!QLog.isColorLevel()) {
                break;
              }
            }
            QLog.d("StructMsg", 2, "QQServiceForAV:getStructMsg error", paramObject);
            paramObservable = (Observable)localObject1;
            break;
          case -2022: 
            paramObservable = getResources().getString(2131917927);
            break;
          case -2058: 
            paramObservable = getResources().getString(2131917928);
            break;
          case -3005: 
            paramObservable = getResources().getString(2131917926);
            break;
          case -3007: 
          case -2017: 
          case -2005: 
            paramObservable = getResources().getString(2131917922);
            break;
          case -5015: 
            paramObservable = HardCodeUtil.a(2131908358);
          }
          if (QLog.isColorLevel())
          {
            paramObject = new StringBuilder();
            paramObject.append(", vipBubbleId: ");
            paramObject.append(i1);
            paramObject.append(", senderUin: ");
            paramObject.append(str);
            paramObject.append(", msgtype: ");
            paramObject.append(i2);
            paramObject.append(", msg: ");
            paramObject.append(paramObservable);
            paramObject.append(", time: ");
            paramObject.append(l1);
            paramObject.append(", uinseq: ");
            paramObject.append(l2);
            paramObject.append(", mLastUniseq: ");
            paramObject.append(this.g);
            QLog.d("QQServiceForAV", 2, paramObject.toString());
          }
          this.g = (l2 + 1L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.service.QQServiceForAV
 * JD-Core Version:    0.7.0.1
 */