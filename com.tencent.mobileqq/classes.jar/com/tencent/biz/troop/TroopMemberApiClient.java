package com.tencent.biz.troop;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.apiproxy.QQMusicClient;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.lightReply.LightReplyEmojs;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import ovu;
import ovv;

public class TroopMemberApiClient
{
  static int jdField_a_of_type_Int;
  protected static TroopMemberApiClient a;
  protected ServiceConnection a;
  public final Messenger a;
  public SparseArray a;
  QQMusicClient jdField_a_of_type_ComTencentBizApiproxyQQMusicClient;
  private TroopMemberApiClient.Callback jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient$Callback;
  public BizTroopObserver a;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public List a;
  public Map a;
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  public Messenger b;
  private HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap();
  public List b;
  AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  
  private TroopMemberApiClient()
  {
    this.jdField_a_of_type_AndroidOsMessenger = new Messenger(new ovv(this));
    this.jdField_b_of_type_AndroidOsMessenger = null;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_a_of_type_AndroidContentServiceConnection = new ovu(this);
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  public static TroopMemberApiClient a()
  {
    if (jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient == null) {
        jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = new TroopMemberApiClient();
      }
      return jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
    }
    finally {}
  }
  
  public static String a()
  {
    int i = Process.myPid();
    Object localObject = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningAppProcesses();
    if ((localObject == null) || (((List)localObject).size() <= 0)) {
      return null;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      if (localRunningAppProcessInfo.pid == i) {
        return localRunningAppProcessInfo.processName;
      }
    }
    return null;
  }
  
  public int a(TroopMemberApiClient.Callback paramCallback)
  {
    int i = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), paramCallback);
    return i;
  }
  
  public QQMusicClient a()
  {
    if (this.jdField_a_of_type_ComTencentBizApiproxyQQMusicClient == null) {
      this.jdField_a_of_type_ComTencentBizApiproxyQQMusicClient = new QQMusicClient(this);
    }
    return this.jdField_a_of_type_ComTencentBizApiproxyQQMusicClient;
  }
  
  public TroopMemberApiClient.Callback a(int paramInt)
  {
    return (TroopMemberApiClient.Callback)this.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(paramInt));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndAdd(1) == 0)
    {
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      localBaseApplication.bindService(new Intent(localBaseApplication, TroopMemberApiService.class), this.jdField_a_of_type_AndroidContentServiceConnection, 1);
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.troop.TroopMemberApiClient", 2, "Binding...");
      }
    }
  }
  
  public void a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("fontSize", paramInt);
    a(53, localBundle);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("topicId", paramInt1);
    localBundle.putInt("followInfo", paramInt2);
    a(109, localBundle);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("subCmd", 1);
    localBundle.putInt("effectId", paramInt1);
    localBundle.putInt("svipLevel", paramInt2);
    localBundle.putInt("svipType", paramInt3);
    localBundle.putString("effectName", paramString);
    a(86, localBundle);
  }
  
  public void a(int paramInt1, long paramLong, String paramString1, String paramString2, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("roomid", paramLong);
    localBundle.putInt("roomType", paramInt1);
    localBundle.putString("vasname", paramString1);
    localBundle.putString("userdata", paramString2);
    localBundle.putInt("fromid", paramInt2);
    a(32, localBundle);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    Message localMessage = Message.obtain(null, paramInt);
    localMessage.replyTo = this.jdField_a_of_type_AndroidOsMessenger;
    localMessage.setData(paramBundle);
    if (this.jdField_b_of_type_AndroidOsMessenger == null) {
      try
      {
        this.jdField_b_of_type_JavaUtilList.add(localMessage);
        return;
      }
      finally {}
    }
    try
    {
      this.jdField_b_of_type_AndroidOsMessenger.send(localMessage);
      return;
    }
    catch (RemoteException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  public void a(int paramInt, Bundle paramBundle, TroopMemberApiClient.Callback paramCallback)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("seq", a(paramCallback));
    localBundle.putString("processName", a());
    a(paramInt, localBundle);
  }
  
  public void a(int paramInt, Bundle paramBundle, BusinessObserver paramBusinessObserver)
  {
    SparseArray localSparseArray = this.jdField_a_of_type_AndroidUtilSparseArray;
    int i = jdField_a_of_type_Int + 1;
    jdField_a_of_type_Int = i;
    localSparseArray.append(i, paramBusinessObserver);
    paramBundle.putString("processName", a());
    paramBundle.putInt("req_seq", jdField_a_of_type_Int);
    a(paramInt, paramBundle);
  }
  
  public void a(int paramInt, TroopMemberApiClient.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("appId", paramInt);
    localBundle.putInt("seq", a(paramCallback));
    a(44, localBundle);
  }
  
  public void a(int paramInt1, String paramString, long paramLong, int paramInt2, LightReplyEmojs paramLightReplyEmojs)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("istroop", paramInt1);
    localBundle.putString("frienduin", paramString);
    localBundle.putLong("shmsgseq", paramLong);
    localBundle.putInt("subMsgId", paramInt2);
    localBundle.putSerializable("clickData", paramLightReplyEmojs);
    a(106, localBundle);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, TroopMemberApiClient.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("from", paramString1);
    localBundle.putString("pluginId", paramString2);
    localBundle.putString("startParam", paramString3);
    localBundle.putInt("action", paramInt);
    localBundle.putInt("seq", a(paramCallback));
    a(80, localBundle);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, TroopMemberApiClient.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("callback", paramString4);
    localBundle.putInt("seq", a(paramCallback));
    localBundle.putInt("appid", paramInt);
    localBundle.putString("openGroupId", paramString1);
    localBundle.putString("token", paramString2);
    localBundle.putString("url", paramString3);
    a(28, localBundle);
  }
  
  public void a(long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("roomId", paramLong);
    a(89, localBundle);
  }
  
  public void a(long paramLong1, String paramString1, String paramString2, long paramLong2, int paramInt, TroopMemberApiClient.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopCode", paramLong1);
    localBundle.putString("filePath", paramString1);
    localBundle.putString("fileName", paramString2);
    localBundle.putLong("fileSize", paramLong2);
    localBundle.putInt("busid", paramInt);
    localBundle.putInt("seq", a(paramCallback));
    a(20, localBundle);
  }
  
  public void a(long paramLong, long[] paramArrayOfLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLongArray("troopUinList", paramArrayOfLong);
    localBundle.putLong("troopPubAccountUin", paramLong);
    a(45, localBundle);
  }
  
  public void a(Bundle paramBundle)
  {
    a(117, paramBundle);
  }
  
  public void a(TroopMemberApiClient.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", a(paramCallback));
    localBundle.putString("processName", a());
    a(82, localBundle);
  }
  
  public void a(BusinessObserver paramBusinessObserver)
  {
    if (paramBusinessObserver == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("com.tencent.biz.troop.TroopMemberApiClient", 2, "RegisterObserver key:" + paramBusinessObserver.hashCode());
      }
    } while (this.jdField_a_of_type_JavaUtilList.contains(paramBusinessObserver));
    this.jdField_a_of_type_JavaUtilList.add(paramBusinessObserver);
  }
  
  public void a(Integer paramInteger, String paramString1, String paramString2, TroopMemberApiClient.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", a(paramCallback));
    localBundle.putInt("appid", paramInteger.intValue());
    localBundle.putString("openId", paramString1);
    localBundle.putString("token", paramString2);
    a(61, localBundle);
  }
  
  public void a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString);
    localBundle.putString("processName", a());
    a(39, localBundle);
  }
  
  public void a(String paramString, byte paramByte, long paramLong, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString);
    localBundle.putByte("cIsGetGroupAlbum", paramByte);
    localBundle.putLong("dwTimeStamp", paramLong);
    localBundle.putInt("cStatOption", paramInt);
    a(37, localBundle);
  }
  
  public void a(String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopUin", Long.parseLong(paramString));
    localBundle.putInt("flag", paramInt);
    a(51, localBundle);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString1);
    localBundle.putInt("statOption", paramInt);
    localBundle.putString("authKey", paramString2);
    a(70, localBundle);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("roomId", paramString1);
    localBundle.putInt("isGroupCode", paramInt);
    localBundle.putString("action", paramString2);
    localBundle.putString("fromId", paramString3);
    localBundle.putString("backType", paramString4);
    localBundle.putString("openType", paramString5);
    localBundle.putString("extra", paramString6);
    a(95, localBundle);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, boolean paramBoolean, TroopMemberApiClient.Callback paramCallback1, TroopMemberApiClient.Callback paramCallback2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("pic_local_path", paramString1);
    localBundle.putInt("is_showProgress_tips", paramInt);
    localBundle.putString("pic_puin", paramString2);
    localBundle.putInt("seq1", a(paramCallback2));
    localBundle.putInt("seq", a(paramCallback1));
    localBundle.putBoolean("is_pic_or_voice", paramBoolean);
    a(21, localBundle);
  }
  
  public void a(String paramString1, long paramLong, int paramInt1, String paramString2, int paramInt2, String paramString3, TroopMemberApiClient.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString1);
    localBundle.putLong("bubbleId", paramLong);
    localBundle.putInt("headId", paramInt1);
    localBundle.putString("nickName", paramString2);
    localBundle.putInt("expireTime", paramInt2);
    localBundle.putString("rankColor", paramString3);
    localBundle.putInt("seq", a(paramCallback));
    a(13, localBundle);
  }
  
  public void a(String paramString1, long paramLong1, String paramString2, String paramString3, long paramLong2, long paramLong3, int paramInt, TroopMemberApiClient.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("skinId", paramString1);
    localBundle.putString("skinUrl", paramString2);
    localBundle.putString("skinName", paramString3);
    localBundle.putLong("skinSeq", paramLong1);
    localBundle.putLong("startTime", paramLong2);
    localBundle.putLong("endTime", paramLong3);
    localBundle.putInt("volumeIsOn", paramInt);
    localBundle.putInt("seq", a(paramCallback));
    if (QLog.isColorLevel()) {
      QLog.d("Readinjoy", 2, "TroopMemberApiClient setReadinjoySkin skinId = " + paramString1);
    }
    a(112, localBundle);
  }
  
  public void a(String paramString1, long paramLong1, String paramString2, String paramString3, long paramLong2, long paramLong3, TroopMemberApiClient.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("skinId", paramString1);
    localBundle.putString("skinUrl", paramString2);
    localBundle.putString("skinName", paramString3);
    localBundle.putLong("skinSeq", paramLong1);
    localBundle.putLong("startTime", paramLong2);
    localBundle.putLong("endTime", paramLong3);
    localBundle.putInt("seq", a(paramCallback));
    if (QLog.isColorLevel()) {
      QLog.d("Readinjoy", 2, "TroopMemberApiClient startLoadReadinjoySkin skinId = " + paramString1);
    }
    a(110, localBundle);
  }
  
  public void a(String paramString, TroopMemberApiClient.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", a(paramCallback));
    localBundle.putString("troopUin", paramString);
    localBundle.putString("processName", a());
    a(59, localBundle);
  }
  
  public void a(String paramString, AIOImageData paramAIOImageData, int paramInt, TroopMemberApiClient.Callback paramCallback)
  {
    if (paramString == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString);
    localBundle.putString("filePath", paramAIOImageData.j);
    localBundle.putString("fileName", paramAIOImageData.i);
    localBundle.putInt("busId", paramAIOImageData.d);
    localBundle.putInt("size", paramInt);
    int i = a(paramCallback);
    localBundle.putInt("seq", i);
    paramString = paramAIOImageData.j + "/" + paramInt;
    this.jdField_b_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(i));
    a(58, localBundle);
  }
  
  public void a(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString1);
    localBundle.putString("opn", paramString2);
    a(31, localBundle);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString1);
    localBundle.putString("memberUin", paramString2);
    localBundle.putInt("titleId", paramInt);
    a(29, localBundle);
  }
  
  public void a(String paramString1, String paramString2, int paramInt, TroopMemberApiClient.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("path", paramString1);
    localBundle.putString("troopUin", paramString2);
    localBundle.putInt("msgTailType", paramInt);
    localBundle.putInt("seq", a(paramCallback));
    a(88, localBundle);
  }
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3, TroopMemberApiClient.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("callback", paramString3);
    localBundle.putInt("seq", a(paramCallback));
    localBundle.putString("troopUin", paramString1);
    localBundle.putString("troopName", paramString2);
    localBundle.putInt("troopTypeId", paramInt);
    a(19, localBundle);
  }
  
  public void a(String paramString1, String paramString2, TroopMemberApiClient.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("groupCode", paramString1);
    localBundle.putString("groupMemberUin", paramString2);
    localBundle.putInt("seq", a(paramCallback));
    a(73, localBundle);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopCode", paramString1);
    localBundle.putString("uin", paramString2);
    localBundle.putString("nick", paramString3);
    a(97, localBundle);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, TroopMemberApiClient.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("packageName", paramString1);
    localBundle.putString("pluginId", paramString2);
    localBundle.putString("versionCode", paramString3);
    localBundle.putInt("seq", a(paramCallback));
    a(79, localBundle);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("appType", paramString1);
    localBundle.putString("openType", paramString2);
    localBundle.putString("uri", paramString3);
    localBundle.putString("action", paramString4);
    localBundle.putString("pluginPackageName", paramString5);
    localBundle.putString("pluginParams", paramString6);
    a(68, localBundle);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString);
    localBundle.putBoolean("isChecked", paramBoolean);
    a(36, localBundle);
  }
  
  public void a(ArrayList paramArrayList)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("subCmd", 2);
    localBundle.putStringArrayList("statusList", paramArrayList);
    a(86, localBundle);
  }
  
  public void a(ArrayList paramArrayList, TroopMemberApiClient.Callback paramCallback)
  {
    int i = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("tinyIdList", paramArrayList);
    localBundle.putInt("seq", i);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), paramCallback);
    a(103, localBundle);
  }
  
  public void a(boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isTroopAppListChanged", paramBoolean);
    a(30, localBundle);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isTroopProfileAppListChanged", paramBoolean);
    localBundle.putString("profileAppListChangedTroopUin", paramString);
    a(108, localBundle);
  }
  
  public void a(byte[] paramArrayOfByte, String paramString, int paramInt1, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("xmlData", paramArrayOfByte);
    localBundle.putString("friendUin", paramString);
    localBundle.putInt("directionFlag", paramInt1);
    localBundle.putInt("from", paramInt2);
    a(74, localBundle);
  }
  
  public void b()
  {
    BaseApplication localBaseApplication;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(-1) == 0)
    {
      localBaseApplication = BaseApplicationImpl.getContext();
      if (this.jdField_b_of_type_AndroidOsMessenger == null) {}
    }
    try
    {
      Message localMessage = Message.obtain(null, 2);
      localMessage.replyTo = this.jdField_a_of_type_AndroidOsMessenger;
      Bundle localBundle = new Bundle();
      localBundle.putString("processName", a());
      localMessage.obj = localBundle;
      this.jdField_b_of_type_AndroidOsMessenger.send(localMessage);
      label67:
      localBaseApplication.unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
      this.jdField_b_of_type_AndroidOsMessenger = null;
      try
      {
        this.jdField_b_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilMap.clear();
        if (QLog.isColorLevel()) {
          QLog.i("com.tencent.biz.troop.TroopMemberApiClient", 2, "Unbinding...");
        }
        return;
      }
      finally {}
    }
    catch (RemoteException localRemoteException)
    {
      break label67;
    }
  }
  
  public void b(TroopMemberApiClient.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", a(paramCallback));
    a(85, localBundle);
  }
  
  public void b(BusinessObserver paramBusinessObserver)
  {
    if (paramBusinessObserver == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("com.tencent.biz.troop.TroopMemberApiClient", 2, "unRegisterObserver key:" + paramBusinessObserver.hashCode());
      }
    } while (!this.jdField_a_of_type_JavaUtilList.contains(paramBusinessObserver));
    this.jdField_a_of_type_JavaUtilList.remove(paramBusinessObserver);
  }
  
  public void b(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("pluginPackageName", paramString);
    localBundle.putString("appType", "hy_sixgod");
    a(72, localBundle);
  }
  
  public void b(String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", paramString);
    localBundle.putInt("index", paramInt);
    a(96, localBundle);
  }
  
  public void b(String paramString1, int paramInt, String paramString2, boolean paramBoolean, TroopMemberApiClient.Callback paramCallback1, TroopMemberApiClient.Callback paramCallback2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("pic_server_id", paramString1);
    localBundle.putInt("is_showProgress_tips", paramInt);
    localBundle.putString("pic_puin", paramString2);
    localBundle.putBoolean("is_pic_or_voice", paramBoolean);
    localBundle.putInt("seq1", a(paramCallback2));
    localBundle.putInt("seq", a(paramCallback1));
    a(22, localBundle);
  }
  
  public void b(String paramString, TroopMemberApiClient.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", a(paramCallback));
    localBundle.putString("hashName", paramString);
    if (QLog.isColorLevel()) {
      QLog.d("allen", 2, "此时发送请求");
    }
    a(67, localBundle);
  }
  
  public void b(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("gcode", paramString1);
    localBundle.putString("anId", paramString2);
    a(7, localBundle);
  }
  
  public void b(String paramString1, String paramString2, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString1);
    localBundle.putString("memUin", paramString2);
    localBundle.putInt("serviceType", paramInt);
    a(71, localBundle);
  }
  
  public void b(String paramString1, String paramString2, TroopMemberApiClient.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString1);
    localBundle.putString("rewardId", paramString2);
    localBundle.putInt("seq", a(paramCallback));
    a(55, localBundle);
  }
  
  public void b(String paramString1, String paramString2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopCode", paramString1);
    localBundle.putString("uin", paramString2);
    localBundle.putString("nick", paramString3);
    a(100, localBundle);
  }
  
  public void b(String paramString1, String paramString2, String paramString3, TroopMemberApiClient.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString1);
    localBundle.putString("chatType", paramString2);
    localBundle.putString("callback", paramString3);
    localBundle.putInt("seq", a(paramCallback));
    a(114, localBundle);
  }
  
  public void b(ArrayList paramArrayList)
  {
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("preloadList", paramArrayList);
    a(104, localBundle);
  }
  
  public void b(boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("force_install_new", paramBoolean);
    a(92, localBundle);
  }
  
  public void c()
  {
    a(6, null);
  }
  
  public void c(TroopMemberApiClient.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", a(paramCallback));
    a(77, localBundle);
  }
  
  public void c(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString);
    a(34, localBundle);
  }
  
  public void c(String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("schoolName", paramString);
    localBundle.putInt("isValid", paramInt);
    a(75, localBundle);
  }
  
  public void c(String paramString, TroopMemberApiClient.Callback paramCallback)
  {
    if (paramCallback == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    if (!TextUtils.isEmpty(paramString)) {
      localBundle.putString("callback", paramString);
    }
    localBundle.putInt("seq", a(paramCallback));
    a(15, localBundle);
  }
  
  public void c(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString1);
    localBundle.putString("troopCode", paramString2);
    a(41, localBundle);
  }
  
  public void c(String paramString1, String paramString2, TroopMemberApiClient.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("path", paramString1);
    localBundle.putString("photoPath", paramString2);
    localBundle.putInt("seq", a(paramCallback));
    a(76, localBundle);
  }
  
  public void d()
  {
    a(94, new Bundle());
  }
  
  public void d(TroopMemberApiClient.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", a(paramCallback));
    if (QLog.isColorLevel()) {
      QLog.d("allen", 2, "get config");
    }
    a(116, localBundle);
  }
  
  public void d(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString);
    a(35, localBundle);
  }
  
  public void d(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("localFilePath", paramString1);
    localBundle.putString("fileDisPlayName", paramString2);
    a(47, localBundle);
  }
  
  public void d(String paramString1, String paramString2, TroopMemberApiClient.Callback paramCallback)
  {
    int i = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
    Bundle localBundle = new Bundle();
    localBundle.putString("troopCode", paramString1);
    localBundle.putString("rid", paramString2);
    localBundle.putInt("seq", i);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), paramCallback);
    a(102, localBundle);
  }
  
  public void e()
  {
    a(78, new Bundle());
  }
  
  public void e(TroopMemberApiClient.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", a(paramCallback));
    a(52, localBundle);
  }
  
  public void e(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopCode", paramString);
    a(99, localBundle);
  }
  
  public void e(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopCode", paramString1);
    localBundle.putString("uin", paramString2);
    a(98, localBundle);
  }
  
  public void e(String paramString1, String paramString2, TroopMemberApiClient.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("skinId", paramString1);
    localBundle.putString("skinUrl", paramString2);
    localBundle.putInt("seq", a(paramCallback));
    if (QLog.isColorLevel()) {
      QLog.d("Readinjoy", 2, "TroopMemberApiClient cancelLoadReadinjoySkin skinId = " + paramString1);
    }
    a(111, localBundle);
  }
  
  public void f()
  {
    a(27, new Bundle());
  }
  
  public void f(TroopMemberApiClient.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", a(paramCallback));
    a(81, localBundle);
  }
  
  public void f(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopCode", paramString1);
    localBundle.putString("uin", paramString2);
    a(101, localBundle);
  }
  
  public void g()
  {
    a(93, null);
  }
  
  public void g(TroopMemberApiClient.Callback paramCallback)
  {
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient$Callback = paramCallback;
  }
  
  public void g(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString1);
    localBundle.putString("type", paramString2);
    a(118, localBundle);
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient$Callback = null;
  }
  
  public void h(TroopMemberApiClient.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", a(paramCallback));
    if (QLog.isColorLevel()) {
      QLog.d("Readinjoy", 2, "TroopMemberApiClient getReadinjoyCurrentSkin");
    }
    a(113, localBundle);
  }
  
  public void i()
  {
    a(90, null);
  }
  
  public void j()
  {
    a(105, new Bundle());
  }
  
  public void k()
  {
    a(107, new Bundle());
  }
  
  public void l()
  {
    a(119, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiClient
 * JD-Core Version:    0.7.0.1
 */