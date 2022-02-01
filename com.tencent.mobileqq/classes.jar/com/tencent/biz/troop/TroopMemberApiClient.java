package com.tencent.biz.troop;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.biz.apiproxy.QQMusicClient;
import com.tencent.biz.apiproxy.WebPushClient;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.mobileqq.webview.WebSecurityPluginV2.URLCheckParams;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class TroopMemberApiClient
{
  protected static TroopMemberApiClient a;
  static int l;
  private static String o;
  final Messenger b = new Messenger(new TroopMemberApiClient.IncomingHandler(this));
  Messenger c = null;
  AtomicInteger d = new AtomicInteger(0);
  List<BusinessObserver> e = new ArrayList();
  List<Message> f = new ArrayList();
  AtomicInteger g = new AtomicInteger(0);
  Map<Integer, ITroopMemberApiClientApi.Callback> h = new ConcurrentHashMap();
  QQMusicClient i;
  WebPushClient j;
  protected ServiceConnection k = new TroopMemberApiClient.1(this);
  SparseArray<BusinessObserver> m = new SparseArray();
  BizTroopObserver n;
  private HashMap<String, Integer> p = new HashMap();
  private HashMap<String, Integer> q = new HashMap();
  private ITroopMemberApiClientApi.Callback r;
  
  public static TroopMemberApiClient a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new TroopMemberApiClient();
        }
      }
      finally {}
    }
    return a;
  }
  
  public static String d()
  {
    Object localObject = o;
    if (localObject != null) {
      return localObject;
    }
    int i1 = Process.myPid();
    localObject = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningAppProcesses();
    if (localObject != null)
    {
      if (((List)localObject).size() <= 0) {
        return null;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        if (localRunningAppProcessInfo.pid == i1)
        {
          localObject = localRunningAppProcessInfo.processName;
          o = (String)localObject;
          return localObject;
        }
      }
    }
    return null;
  }
  
  public int a(int paramInt, Bundle paramBundle, ITroopMemberApiClientApi.Callback paramCallback)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    int i1 = e(paramCallback);
    localBundle.putInt("seq", i1);
    localBundle.putString("processName", d());
    a(paramInt, localBundle);
    return i1;
  }
  
  public int a(WebSecurityPluginV2.URLCheckParams paramURLCheckParams, ITroopMemberApiClientApi.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("url", paramURLCheckParams.a);
    localBundle.putInt("type", paramURLCheckParams.b);
    localBundle.putInt("msgfrom", paramURLCheckParams.c);
    localBundle.putString("senderUin", paramURLCheckParams.d);
    localBundle.putString("chatId", paramURLCheckParams.e);
    localBundle.putString("source", paramURLCheckParams.f);
    localBundle.putString("originUrl", paramURLCheckParams.g);
    localBundle.putString("ark_business_name", paramURLCheckParams.h);
    localBundle.putBoolean("is_page_finish", paramURLCheckParams.i);
    localBundle.putStringArrayList("pre_jump_urls", paramURLCheckParams.j);
    return a(121, localBundle, paramCallback);
  }
  
  public ITroopMemberApiClientApi.Callback a(int paramInt)
  {
    return (ITroopMemberApiClientApi.Callback)this.h.remove(Integer.valueOf(paramInt));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("topicId", paramInt1);
    localBundle.putInt("followInfo", paramInt2);
    a(106, localBundle);
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
    localMessage.replyTo = this.b;
    localMessage.setData(paramBundle);
    paramBundle = this.c;
    if (paramBundle == null) {
      try
      {
        this.f.add(localMessage);
        return;
      }
      finally {}
    }
    try
    {
      paramBundle.send(localMessage);
      return;
    }
    catch (RemoteException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  public void a(int paramInt, Bundle paramBundle, BusinessObserver paramBusinessObserver)
  {
    SparseArray localSparseArray = this.m;
    int i1 = l + 1;
    l = i1;
    localSparseArray.append(i1, paramBusinessObserver);
    paramBundle.putString("processName", d());
    paramBundle.putInt("req_seq", l);
    a(paramInt, paramBundle);
  }
  
  public void a(int paramInt, ITroopMemberApiClientApi.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("appId", paramInt);
    localBundle.putInt("seq", e(paramCallback));
    a(44, localBundle);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("uploadType", paramInt);
    localBundle.putString("url", paramString1);
    localBundle.putString("originUrl", paramString2);
    a(142, localBundle);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, ITroopMemberApiClientApi.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("callback", paramString4);
    localBundle.putInt("seq", e(paramCallback));
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
    a(88, localBundle);
  }
  
  public void a(long paramLong, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("followUin", paramLong);
    localBundle.putInt("followInfo", paramInt);
    a(119, localBundle);
  }
  
  public void a(long paramLong1, String paramString1, String paramString2, long paramLong2, int paramInt, ITroopMemberApiClientApi.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopCode", paramLong1);
    localBundle.putString("filePath", paramString1);
    localBundle.putString("fileName", paramString2);
    localBundle.putLong("fileSize", paramLong2);
    localBundle.putInt("busid", paramInt);
    localBundle.putInt("seq", e(paramCallback));
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
    a(92, paramBundle);
  }
  
  public void a(BusinessObserver paramBusinessObserver)
  {
    if (paramBusinessObserver == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RegisterObserver key:");
      localStringBuilder.append(paramBusinessObserver.hashCode());
      QLog.i("com.tencent.biz.troop.TroopMemberApiClient", 2, localStringBuilder.toString());
    }
    if (!this.e.contains(paramBusinessObserver)) {
      this.e.add(paramBusinessObserver);
    }
  }
  
  public void a(ITroopMemberApiClientApi.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", e(paramCallback));
    localBundle.putString("processName", d());
    a(81, localBundle);
  }
  
  public void a(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, ITroopMemberApiClientApi.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", e(paramCallback));
    localBundle.putInt("start", paramInteger1.intValue());
    localBundle.putInt("msgType", paramInteger2.intValue());
    localBundle.putInt("count", paramInteger3.intValue());
    a(129, localBundle);
  }
  
  public void a(Integer paramInteger1, Integer paramInteger2, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("clearType", paramInteger1.intValue());
    localBundle.putInt("msgType", paramInteger2.intValue());
    localBundle.putString("uin", paramString);
    a(130, localBundle);
  }
  
  public void a(Integer paramInteger1, String paramString, Integer paramInteger2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("deleteType", paramInteger1.intValue());
    localBundle.putInt("msgType", paramInteger2.intValue());
    localBundle.putString("uin", paramString);
    a(131, localBundle);
  }
  
  public void a(Integer paramInteger, String paramString1, String paramString2, ITroopMemberApiClientApi.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", e(paramCallback));
    localBundle.putInt("appid", paramInteger.intValue());
    localBundle.putString("openId", paramString1);
    localBundle.putString("token", paramString2);
    a(60, localBundle);
  }
  
  public void a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString);
    localBundle.putString("processName", d());
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
    if (QLog.isDevelopLevel()) {
      QLog.i("TroopMngTest", 4, String.format("getGroupInfoReq [%s]", new Object[] { paramString }));
    }
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
    localBundle.putInt("opType", paramInt);
    localBundle.putString("startTroopUin", paramString2);
    a(157, localBundle);
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
    a(94, localBundle);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, boolean paramBoolean, ITroopMemberApiClientApi.Callback paramCallback1, ITroopMemberApiClientApi.Callback paramCallback2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("pic_local_path", paramString1);
    localBundle.putInt("is_showProgress_tips", paramInt);
    localBundle.putString("pic_puin", paramString2);
    localBundle.putInt("seq1", e(paramCallback2));
    localBundle.putInt("seq", e(paramCallback1));
    localBundle.putBoolean("is_pic_or_voice", paramBoolean);
    a(21, localBundle);
  }
  
  public void a(String paramString1, long paramLong, int paramInt1, String paramString2, int paramInt2, String paramString3, ITroopMemberApiClientApi.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString1);
    localBundle.putLong("bubbleId", paramLong);
    localBundle.putInt("headId", paramInt1);
    localBundle.putString("nickName", paramString2);
    localBundle.putInt("expireTime", paramInt2);
    localBundle.putString("rankColor", paramString3);
    localBundle.putInt("seq", e(paramCallback));
    a(13, localBundle);
  }
  
  public void a(String paramString1, long paramLong1, String paramString2, String paramString3, long paramLong2, long paramLong3, int paramInt, ITroopMemberApiClientApi.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("skinId", paramString1);
    localBundle.putString("skinUrl", paramString2);
    localBundle.putString("skinName", paramString3);
    localBundle.putLong("skinSeq", paramLong1);
    localBundle.putLong("startTime", paramLong2);
    localBundle.putLong("endTime", paramLong3);
    localBundle.putInt("volumeIsOn", paramInt);
    localBundle.putInt("seq", e(paramCallback));
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("TroopMemberApiClient setReadinjoySkin skinId = ");
      paramString2.append(paramString1);
      QLog.d("Readinjoy", 2, paramString2.toString());
    }
    a(109, localBundle);
  }
  
  public void a(String paramString1, long paramLong1, String paramString2, String paramString3, long paramLong2, long paramLong3, ITroopMemberApiClientApi.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("skinId", paramString1);
    localBundle.putString("skinUrl", paramString2);
    localBundle.putString("skinName", paramString3);
    localBundle.putLong("skinSeq", paramLong1);
    localBundle.putLong("startTime", paramLong2);
    localBundle.putLong("endTime", paramLong3);
    localBundle.putInt("seq", e(paramCallback));
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("TroopMemberApiClient startLoadReadinjoySkin skinId = ");
      paramString2.append(paramString1);
      QLog.d("Readinjoy", 2, paramString2.toString());
    }
    a(107, localBundle);
  }
  
  public void a(String paramString, AIOImageData paramAIOImageData, int paramInt, ITroopMemberApiClientApi.Callback paramCallback)
  {
    if (paramString == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString);
    localBundle.putString("filePath", paramAIOImageData.w);
    localBundle.putString("fileName", paramAIOImageData.v);
    localBundle.putInt("busId", paramAIOImageData.x);
    localBundle.putInt("size", paramInt);
    int i1 = e(paramCallback);
    localBundle.putInt("seq", i1);
    paramString = new StringBuilder();
    paramString.append(paramAIOImageData.w);
    paramString.append("/");
    paramString.append(paramInt);
    paramString = paramString.toString();
    this.q.put(paramString, Integer.valueOf(i1));
    a(58, localBundle);
  }
  
  public void a(String paramString, ITroopMemberApiClientApi.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", e(paramCallback));
    localBundle.putString("troopUin", paramString);
    localBundle.putString("processName", d());
    a(59, localBundle);
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
  
  public void a(String paramString1, String paramString2, int paramInt, ITroopMemberApiClientApi.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("path", paramString1);
    localBundle.putString("troopUin", paramString2);
    localBundle.putInt("msgTailType", paramInt);
    localBundle.putInt("seq", e(paramCallback));
    a(87, localBundle);
  }
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3, ITroopMemberApiClientApi.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("callback", paramString3);
    localBundle.putInt("seq", e(paramCallback));
    localBundle.putString("troopUin", paramString1);
    localBundle.putString("troopName", paramString2);
    localBundle.putInt("troopTypeId", paramInt);
    a(19, localBundle);
  }
  
  public void a(String paramString1, String paramString2, ITroopMemberApiClientApi.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("groupCode", paramString1);
    localBundle.putString("groupMemberUin", paramString2);
    localBundle.putInt("seq", e(paramCallback));
    a(72, localBundle);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopCode", paramString1);
    localBundle.putString("uin", paramString2);
    localBundle.putString("nick", paramString3);
    a(96, localBundle);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, ITroopMemberApiClientApi.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("appid", paramString1);
    localBundle.putString("openid", paramString2);
    localBundle.putString("troopuin", paramString3);
    a(146, localBundle, paramCallback);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("groupCode", paramString1);
    localBundle.putString("appID", paramString2);
    localBundle.putString("url", paramString3);
    localBundle.putString("source", paramString4);
    a(150, localBundle);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, ITroopMemberApiClientApi.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString1);
    localBundle.putString("chatType", paramString2);
    localBundle.putString("packageId", paramString3);
    localBundle.putString("callback", paramString4);
    localBundle.putInt("seq", e(paramCallback));
    a(111, localBundle);
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
    a(67, localBundle);
  }
  
  public void a(String paramString, HashMap<String, String> paramHashMap)
  {
    paramHashMap = new Bundle();
    paramHashMap.putString("from", paramString);
    a(127, paramHashMap);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString);
    localBundle.putBoolean("isChecked", paramBoolean);
    a(36, localBundle);
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("subCmd", 2);
    localBundle.putStringArrayList("statusList", paramArrayList);
    a(85, localBundle);
  }
  
  public void a(ArrayList<Integer> paramArrayList, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("subCmd", 1);
    localBundle.putIntegerArrayList("groupCodeList", paramArrayList);
    localBundle.putInt("effectId", paramInt1);
    localBundle.putInt("svipLevel", paramInt2);
    localBundle.putInt("svipType", paramInt3);
    localBundle.putString("effectName", paramString);
    a(85, localBundle);
  }
  
  public void a(ArrayList<String> paramArrayList, ITroopMemberApiClientApi.Callback paramCallback)
  {
    int i1 = this.g.addAndGet(1);
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("tinyIdList", paramArrayList);
    localBundle.putInt("seq", i1);
    this.h.put(Integer.valueOf(i1), paramCallback);
    a(102, localBundle);
  }
  
  public void a(JSONObject paramJSONObject, Parcelable paramParcelable, ITroopMemberApiClientApi.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", e(paramCallback));
    localBundle.putString("BUNDLE_KEY_JS_OBJ", paramJSONObject.toString());
    localBundle.putParcelable("BUNDLE_KEY_CREATE_COMMENT_DATA", paramParcelable);
    a(154, localBundle);
  }
  
  public void a(JSONObject paramJSONObject, ITroopMemberApiClientApi.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", e(paramCallback));
    localBundle.putString("processName", d());
    localBundle.putString("ALD_CONFIG_RESULT", paramJSONObject.toString());
    a(155, localBundle);
  }
  
  public void a(short paramShort, ITroopMemberApiClientApi.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", e(paramCallback));
    localBundle.putShort("tmpPushType", paramShort);
    a(151, localBundle);
  }
  
  public void a(short paramShort, boolean paramBoolean, ITroopMemberApiClientApi.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", e(paramCallback));
    localBundle.putShort("tmpPushType", paramShort);
    localBundle.putBoolean("enable", paramBoolean);
    a(152, localBundle);
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
    a(105, localBundle);
  }
  
  public void a(byte[] paramArrayOfByte, String paramString, int paramInt1, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("xmlData", paramArrayOfByte);
    localBundle.putString("friendUin", paramString);
    localBundle.putInt("directionFlag", paramInt1);
    localBundle.putInt("from", paramInt2);
    a(73, localBundle);
  }
  
  public QQMusicClient b()
  {
    if (this.i == null) {
      this.i = new QQMusicClient(this);
    }
    return this.i;
  }
  
  public void b(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("fontSize", paramInt);
    a(53, localBundle);
  }
  
  public void b(Bundle paramBundle)
  {
    a(114, paramBundle);
  }
  
  public void b(BusinessObserver paramBusinessObserver)
  {
    if (paramBusinessObserver == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unRegisterObserver key:");
      localStringBuilder.append(paramBusinessObserver.hashCode());
      QLog.i("com.tencent.biz.troop.TroopMemberApiClient", 2, localStringBuilder.toString());
    }
    if (this.e.contains(paramBusinessObserver)) {
      this.e.remove(paramBusinessObserver);
    }
  }
  
  public void b(ITroopMemberApiClientApi.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", e(paramCallback));
    a(84, localBundle);
  }
  
  public void b(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString);
    a(34, localBundle);
  }
  
  public void b(String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", paramString);
    localBundle.putInt("index", paramInt);
    a(95, localBundle);
  }
  
  public void b(String paramString1, int paramInt, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString1);
    localBundle.putInt("statOption", paramInt);
    localBundle.putString("authKey", paramString2);
    a(69, localBundle);
  }
  
  public void b(String paramString1, int paramInt, String paramString2, boolean paramBoolean, ITroopMemberApiClientApi.Callback paramCallback1, ITroopMemberApiClientApi.Callback paramCallback2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("pic_server_id", paramString1);
    localBundle.putInt("is_showProgress_tips", paramInt);
    localBundle.putString("pic_puin", paramString2);
    localBundle.putBoolean("is_pic_or_voice", paramBoolean);
    localBundle.putInt("seq1", e(paramCallback2));
    localBundle.putInt("seq", e(paramCallback1));
    a(22, localBundle);
  }
  
  public void b(String paramString, ITroopMemberApiClientApi.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", e(paramCallback));
    localBundle.putString("hashName", paramString);
    if (QLog.isColorLevel()) {
      QLog.d("allen", 2, "此时发送请求");
    }
    a(66, localBundle);
  }
  
  public void b(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("gcode", paramString1);
      localBundle.putString("anId", paramString2);
      a(7, localBundle);
    }
  }
  
  public void b(String paramString1, String paramString2, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString1);
    localBundle.putString("memUin", paramString2);
    localBundle.putInt("serviceType", paramInt);
    a(70, localBundle);
  }
  
  public void b(String paramString1, String paramString2, ITroopMemberApiClientApi.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString1);
    localBundle.putString("rewardId", paramString2);
    localBundle.putInt("seq", e(paramCallback));
    a(55, localBundle);
  }
  
  public void b(String paramString1, String paramString2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopCode", paramString1);
    localBundle.putString("uin", paramString2);
    localBundle.putString("nick", paramString3);
    a(99, localBundle);
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString);
    localBundle.putBoolean("isChecked", paramBoolean);
    a(120, localBundle);
  }
  
  public void b(ArrayList<String> paramArrayList)
  {
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("preloadList", paramArrayList);
    a(103, localBundle);
  }
  
  public void b(boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("force_install_new", paramBoolean);
    a(91, localBundle);
  }
  
  public WebPushClient c()
  {
    if (this.j == null) {
      this.j = new WebPushClient(this);
    }
    return this.j;
  }
  
  public void c(Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBundle("reportData", paramBundle);
    a(117, localBundle);
  }
  
  public void c(ITroopMemberApiClientApi.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", e(paramCallback));
    a(76, localBundle);
  }
  
  public void c(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString);
    a(35, localBundle);
  }
  
  public void c(String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("schoolName", paramString);
    localBundle.putInt("isValid", paramInt);
    a(74, localBundle);
  }
  
  public void c(String paramString, ITroopMemberApiClientApi.Callback paramCallback)
  {
    if (paramCallback == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    if (!TextUtils.isEmpty(paramString)) {
      localBundle.putString("callback", paramString);
    }
    localBundle.putInt("seq", e(paramCallback));
    a(15, localBundle);
  }
  
  public void c(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("pluginPackageName", paramString1);
    localBundle.putString("appType", paramString2);
    a(71, localBundle);
  }
  
  public void c(String paramString1, String paramString2, ITroopMemberApiClientApi.Callback paramCallback)
  {
    int i1 = this.g.addAndGet(1);
    Bundle localBundle = new Bundle();
    localBundle.putString("troopCode", paramString1);
    localBundle.putString("rid", paramString2);
    localBundle.putInt("seq", i1);
    this.h.put(Integer.valueOf(i1), paramCallback);
    a(101, localBundle);
  }
  
  public void c(String paramString, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString);
    localBundle.putBoolean("isChecked", paramBoolean);
    a(153, localBundle);
  }
  
  public void d(Bundle paramBundle)
  {
    a(148, paramBundle);
  }
  
  public void d(ITroopMemberApiClientApi.Callback paramCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("getReadinjoyShareToWxConfig", 2, "get config");
    }
    a(113, null, paramCallback);
  }
  
  public void d(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopCode", paramString);
    a(98, localBundle);
  }
  
  public void d(String paramString, ITroopMemberApiClientApi.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", e(paramCallback));
    localBundle.putString("content", paramString);
    if (QLog.isColorLevel()) {
      QLog.d("Readinjoy", 2, "TroopMemberApiClient sendToComputer");
    }
    a(122, localBundle);
  }
  
  public void d(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString1);
    localBundle.putString("troopCode", paramString2);
    a(41, localBundle);
  }
  
  public void d(String paramString1, String paramString2, ITroopMemberApiClientApi.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("skinId", paramString1);
    localBundle.putString("skinUrl", paramString2);
    localBundle.putInt("seq", e(paramCallback));
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("TroopMemberApiClient cancelLoadReadinjoySkin skinId = ");
      paramString2.append(paramString1);
      QLog.d("Readinjoy", 2, paramString2.toString());
    }
    a(108, localBundle);
  }
  
  public void d(String paramString, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString);
    localBundle.putBoolean("isChecked", paramBoolean);
    a(156, localBundle);
  }
  
  public int e(ITroopMemberApiClientApi.Callback paramCallback)
  {
    int i1 = this.g.addAndGet(1);
    this.h.put(Integer.valueOf(i1), paramCallback);
    return i1;
  }
  
  public void e()
  {
    if (this.d.getAndAdd(1) == 0)
    {
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      localBaseApplication.bindService(new Intent(localBaseApplication, TroopMemberApiService.class), this.k, 1);
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.troop.TroopMemberApiClient", 2, "Binding...");
      }
    }
  }
  
  public void e(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("fromId", paramString);
    a(149, localBundle);
  }
  
  public void e(String paramString, ITroopMemberApiClientApi.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("localPath", paramString);
    a(158, localBundle, paramCallback);
  }
  
  public void e(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("localFilePath", paramString1);
    localBundle.putString("fileDisPlayName", paramString2);
    a(47, localBundle);
  }
  
  public void e(String paramString, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString);
    localBundle.putBoolean("isOpen", paramBoolean);
    a(145, localBundle);
  }
  
  public void f()
  {
    if (this.d.get() == 0)
    {
      QLog.e("com.tencent.biz.troop.TroopMemberApiClient", 1, "call unbind but didn't bind", new Throwable());
      return;
    }
    BaseApplication localBaseApplication;
    if (this.d.addAndGet(-1) == 0)
    {
      localBaseApplication = BaseApplicationImpl.getContext();
      if (this.c == null) {}
    }
    try
    {
      Message localMessage = Message.obtain(null, 2);
      localMessage.replyTo = this.b;
      Bundle localBundle = new Bundle();
      localBundle.putString("processName", d());
      localMessage.obj = localBundle;
      this.c.send(localMessage);
      label94:
      localBaseApplication.unbindService(this.k);
      this.c = null;
      try
      {
        this.f.clear();
        this.h.clear();
        c().a();
        if (QLog.isColorLevel()) {
          QLog.i("com.tencent.biz.troop.TroopMemberApiClient", 2, "Unbinding...");
        }
      }
      finally {}
      if (this.d.get() < 0)
      {
        this.d.set(0);
        QLog.e("com.tencent.biz.troop.TroopMemberApiClient", 1, "call unbind but didn't bind", new Throwable());
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      break label94;
    }
  }
  
  public void f(ITroopMemberApiClientApi.Callback paramCallback)
  {
    a(128, new Bundle(), paramCallback);
  }
  
  public void f(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("from", paramString);
    a(144, localBundle);
  }
  
  public void f(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopCode", paramString1);
    localBundle.putString("uin", paramString2);
    a(97, localBundle);
  }
  
  public int g(ITroopMemberApiClientApi.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    int i1 = e(paramCallback);
    localBundle.putInt("seq", i1);
    a(52, localBundle);
    return i1;
  }
  
  public void g()
  {
    a(6, null);
  }
  
  public void g(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("localPath", paramString);
    a(159, localBundle);
  }
  
  public void g(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopCode", paramString1);
    localBundle.putString("uin", paramString2);
    a(100, localBundle);
  }
  
  public void h()
  {
    a(93, new Bundle());
  }
  
  public void h(ITroopMemberApiClientApi.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", e(paramCallback));
    a(80, localBundle);
  }
  
  public void h(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString1);
    localBundle.putString("type", paramString2);
    a(115, localBundle);
  }
  
  public void i()
  {
    a(77, new Bundle());
  }
  
  public void i(ITroopMemberApiClientApi.Callback paramCallback)
  {
    this.r = paramCallback;
  }
  
  public void i(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", paramString1);
    localBundle.putString("nick", paramString2);
    a(143, localBundle);
  }
  
  public void j()
  {
    a(27, new Bundle());
  }
  
  public void j(ITroopMemberApiClientApi.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", e(paramCallback));
    if (QLog.isColorLevel()) {
      QLog.d("Readinjoy", 2, "TroopMemberApiClient getReadinjoyCurrentSkin");
    }
    a(110, localBundle);
  }
  
  public void k()
  {
    this.r = null;
  }
  
  public void k(ITroopMemberApiClientApi.Callback paramCallback)
  {
    a(141, new Bundle(), paramCallback);
    AdAnalysisHelperForUtil.reportForAPIInvoked(BaseApplicationImpl.getApplication(), true, "com.tencent.biz.troop.TroopMemberApiClient#gdtGetCurrentUserInfo(Callback)", "");
  }
  
  public void l()
  {
    a(89, null);
  }
  
  public void l(ITroopMemberApiClientApi.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", e(paramCallback));
    a(164, localBundle);
  }
  
  public void m()
  {
    a(104, new Bundle());
  }
  
  public void n()
  {
    a(116, new Bundle());
  }
  
  public void o()
  {
    a(124, new Bundle());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiClient
 * JD-Core Version:    0.7.0.1
 */