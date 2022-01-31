import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.aioapp.data.FullListGroupAppEntity;
import com.tencent.mobileqq.troop.aioapp.data.GrayGroupAppEntity;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.im.oidb.GroupAppPb.AppInfo;
import tencent.im.oidb.GroupAppPb.AppList;
import tencent.im.oidb.GroupAppPb.ClientInfo;
import tencent.im.oidb.GroupAppPb.ReqBody;
import tencent.im.oidb.GroupAppPb.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class bbmo
  extends MSFServlet
{
  private QQAppInterface a;
  
  @Nullable
  private GroupAppPb.RspBody a(FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = paramFromServiceMsg.getWupBuffer();
    if ((localObject == null) || (localObject.length == 0)) {
      return null;
    }
    paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    localObject = ByteBuffer.wrap((byte[])localObject);
    byte[] arrayOfByte = new byte[((ByteBuffer)localObject).getInt() - 4];
    ((ByteBuffer)localObject).get(arrayOfByte);
    try
    {
      paramFromServiceMsg.mergeFrom(arrayOfByte);
      int i = paramFromServiceMsg.uint32_result.get();
      localObject = paramFromServiceMsg.str_error_msg.get();
      if (QLog.isColorLevel())
      {
        localObject = " oidbHeader: " + i + " errorMsg: " + (String)localObject;
        QLog.i("GroupAppsServlet", 2, "mergeFromPacket: invoked. " + (String)localObject);
      }
      paramFromServiceMsg = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
      localObject = new GroupAppPb.RspBody();
      try
      {
        ((GroupAppPb.RspBody)localObject).mergeFrom(paramFromServiceMsg);
        return localObject;
      }
      catch (Exception paramFromServiceMsg)
      {
        QLog.i("GroupAppsServlet", 1, "GroupAppPb mergeFromPacket: invoked.  e: " + paramFromServiceMsg);
        return null;
      }
      return null;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      QLog.i("GroupAppsServlet", 1, "oidb mergeFromPacket: invoked.  e: " + paramFromServiceMsg);
    }
  }
  
  private void a(long paramLong, GroupAppPb.RspBody paramRspBody)
  {
    Object localObject1 = (GroupAppPb.AppList)paramRspBody.red_point_list.get();
    HashSet localHashSet = new HashSet(20);
    localObject1 = ((GroupAppPb.AppList)localObject1).infos.get().iterator();
    while (((Iterator)localObject1).hasNext()) {
      localHashSet.add(Integer.valueOf(((GroupAppPb.AppInfo)((Iterator)localObject1).next()).appid.get()));
    }
    if (QLog.isColorLevel()) {
      QLog.i("GroupAppsServlet", 2, "redDotAppId: " + Arrays.toString(localHashSet.toArray()));
    }
    Object localObject2 = (GroupAppPb.AppList)paramRspBody.full_list.get();
    paramRspBody = ((GroupAppPb.AppList)localObject2).hash.get();
    localObject1 = new ArrayList(20);
    localObject2 = ((GroupAppPb.AppList)localObject2).infos.get().iterator();
    Object localObject3;
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (GroupAppPb.AppInfo)((Iterator)localObject2).next();
      TroopAIOAppInfo localTroopAIOAppInfo = new TroopAIOAppInfo();
      localTroopAIOAppInfo.appid = ((GroupAppPb.AppInfo)localObject3).appid.get();
      localTroopAIOAppInfo.name = ((GroupAppPb.AppInfo)localObject3).name.get();
      localTroopAIOAppInfo.url = ((GroupAppPb.AppInfo)localObject3).url.get();
      localTroopAIOAppInfo.iconUrl = ((GroupAppPb.AppInfo)localObject3).icon.get();
      if (((GroupAppPb.AppInfo)localObject3).is_gray.get() == 1) {}
      for (boolean bool = true;; bool = false)
      {
        localTroopAIOAppInfo.isGray = bool;
        localTroopAIOAppInfo.simpleDayUrl = ((GroupAppPb.AppInfo)localObject3).icon_simple_day.get();
        QLog.d("GroupAppsServlet", 1, "parseAndStoreFullAppInfos  simpleDayUrl is null?" + TextUtils.isEmpty(localTroopAIOAppInfo.simpleDayUrl));
        localTroopAIOAppInfo.simpleNightUrl = ((GroupAppPb.AppInfo)localObject3).icon_simple_night.get();
        QLog.d("GroupAppsServlet", 1, "parseAndStoreFullAppInfos  simpleNightUrl is null?" + TextUtils.isEmpty(localTroopAIOAppInfo.simpleNightUrl));
        if (localHashSet.contains(Integer.valueOf(localTroopAIOAppInfo.appid))) {
          localTroopAIOAppInfo.redPoint = true;
        }
        ((ArrayList)localObject1).add(localTroopAIOAppInfo);
        break;
      }
    }
    localObject2 = bbmk.a(this.a);
    ((bbmk)localObject2).jdField_a_of_type_JavaLangString = paramRspBody;
    ((bbmk)localObject2).b();
    if (!bbmp.a((Collection)localObject1))
    {
      ((bbmk)localObject2).jdField_a_of_type_JavaUtilList = ((List)localObject1);
      if (QLog.isColorLevel()) {
        QLog.i("GroupAppsServlet", 2, "net fullAppInfos" + bbmq.a(((bbmk)localObject2).jdField_a_of_type_JavaUtilList));
      }
    }
    for (;;)
    {
      paramRspBody = new FullListGroupAppEntity();
      paramRspBody.troopAIOAppInfos = ((bbmk)localObject2).jdField_a_of_type_JavaUtilList;
      ((bbmk)localObject2).a().a(paramRspBody);
      return;
      paramRspBody = new ArrayList(((bbmk)localObject2).jdField_a_of_type_JavaUtilList);
      localObject1 = paramRspBody.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (TroopAIOAppInfo)((Iterator)localObject1).next();
        if (localHashSet.contains(Integer.valueOf(((TroopAIOAppInfo)localObject3).appid))) {
          ((TroopAIOAppInfo)localObject3).redPoint = true;
        }
      }
      ((bbmk)localObject2).jdField_a_of_type_JavaUtilList = paramRspBody;
      if (QLog.isColorLevel()) {
        QLog.i("GroupAppsServlet", 2, "cache fullAppInfos" + bbmq.a(((bbmk)localObject2).jdField_a_of_type_JavaUtilList));
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("KEY_GROUP_UIN", paramLong);
    paramQQAppInterface.notifyObservers(bbmn.class, 1, true, localBundle);
  }
  
  static void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = "groupUin = [" + paramLong + "], groupType = [" + paramInt + "]";
      QLog.i("GroupAppsServlet", 2, "requestApps: invoked. " + (String)localObject1);
    }
    Object localObject1 = new GroupAppPb.ReqBody();
    ((GroupAppPb.ReqBody)localObject1).group_id.set(paramLong);
    ((GroupAppPb.ReqBody)localObject1).group_type.set(paramInt);
    Object localObject2 = bbmk.a(paramQQAppInterface);
    String str = ((bbmk)localObject2).a(paramLong);
    if (QLog.isColorLevel()) {
      QLog.i("GroupAppsServlet", 2, "requestApps: invoked.  full: " + ((bbmk)localObject2).jdField_a_of_type_JavaLangString + " gray: " + str + " version: " + "8.3.5" + "." + "4555");
    }
    ((GroupAppPb.ReqBody)localObject1).full_list_hash.set(((bbmk)localObject2).jdField_a_of_type_JavaLangString);
    ((GroupAppPb.ReqBody)localObject1).group_gray_list_hash.set(str);
    if (babd.a()) {}
    for (paramInt = 1;; paramInt = 0)
    {
      ((GroupAppPb.ReqBody)localObject1).mode.set(paramInt);
      localObject2 = new GroupAppPb.ClientInfo();
      ((GroupAppPb.ClientInfo)localObject2).platform.set(2);
      ((GroupAppPb.ClientInfo)localObject2).version.set("8.3.5.4555");
      ((GroupAppPb.ReqBody)localObject1).client.set((MessageMicro)localObject2);
      localObject2 = new NewIntent(paramQQAppInterface.getApp(), bbmo.class);
      ((NewIntent)localObject2).putExtra("KEY_REQ_DATA", ((GroupAppPb.ReqBody)localObject1).toByteArray());
      ((NewIntent)localObject2).putExtra("KEY_GROUP_UIN", paramLong);
      paramQQAppInterface.startServlet((NewIntent)localObject2);
      return;
    }
  }
  
  static boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    paramQQAppInterface = bbmk.a(paramQQAppInterface);
    GrayGroupAppEntity localGrayGroupAppEntity = (GrayGroupAppEntity)paramQQAppInterface.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    if (localGrayGroupAppEntity == null) {
      return true;
    }
    long l = NetConnInfoCenter.getServerTimeMillis();
    paramLong = paramQQAppInterface.a(paramLong);
    if (l - localGrayGroupAppEntity.updatedTimestamp > paramLong * 1000L) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void b(long paramLong, GroupAppPb.RspBody paramRspBody)
  {
    Object localObject3 = (GroupAppPb.AppList)paramRspBody.group_gray_list.get();
    Object localObject2 = ((GroupAppPb.AppList)localObject3).hash.get();
    Object localObject1 = new ArrayList(20);
    localObject3 = ((GroupAppPb.AppList)localObject3).infos.get().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      GroupAppPb.AppInfo localAppInfo = (GroupAppPb.AppInfo)((Iterator)localObject3).next();
      TroopAIOAppInfo localTroopAIOAppInfo = new TroopAIOAppInfo();
      localTroopAIOAppInfo.appid = localAppInfo.appid.get();
      localTroopAIOAppInfo.hashVal = ((String)localObject2);
      ((ArrayList)localObject1).add(localTroopAIOAppInfo);
    }
    localObject2 = new GrayGroupAppEntity();
    ((GrayGroupAppEntity)localObject2).groupUin = paramLong;
    ((GrayGroupAppEntity)localObject2).troopAIOAppInfos = ((List)localObject1);
    ((GrayGroupAppEntity)localObject2).updatedTimestamp = NetConnInfoCenter.getServerTimeMillis();
    ((GrayGroupAppEntity)localObject2).requestIntervalSecond = paramRspBody.cache_interval.get();
    paramRspBody = bbmk.a(this.a);
    paramRspBody.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong), localObject2);
    paramRspBody.a().a((GrayGroupAppEntity)localObject2);
    if (QLog.isColorLevel())
    {
      paramRspBody = "parseAndStoreGrayAppInfos of " + paramLong;
      localObject1 = bbmq.a((Collection)localObject1);
      QLog.i("GroupAppsServlet", 2, paramRspBody + " " + (String)localObject1);
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("KEY_GROUP_UIN", paramLong);
    paramQQAppInterface.notifyObservers(bbmn.class, 1, false, localBundle);
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.a = ((QQAppInterface)getAppRuntime());
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GroupAppsServlet", 2, "onReceive: invoked. " + paramFromServiceMsg);
    }
    int j = 0;
    long l = paramIntent.getLongExtra("KEY_GROUP_UIN", 0L);
    int i = j;
    if (paramFromServiceMsg != null)
    {
      if (paramFromServiceMsg.isSuccess()) {
        break label76;
      }
      i = j;
    }
    while (i != 0)
    {
      a(this.a, l);
      return;
      label76:
      paramIntent = a(paramFromServiceMsg);
      i = j;
      if (paramIntent != null)
      {
        a(l, paramIntent);
        b(l, paramIntent);
        i = 1;
      }
    }
    b(this.a, l);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    paramIntent = paramIntent.getByteArrayExtra("KEY_REQ_DATA");
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(3179);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramIntent));
    ((oidb_sso.OIDBSSOPkg)localObject).str_client_version.set(AppSetting.f());
    paramIntent = ((oidb_sso.OIDBSSOPkg)localObject).toByteArray();
    localObject = new byte[paramIntent.length + 4];
    bdqa.a((byte[])localObject, 0, paramIntent.length + 4);
    bdqa.a((byte[])localObject, 4, paramIntent, paramIntent.length);
    paramPacket.setSSOCommand("OidbSvc.0xc6b");
    paramPacket.putSendData((byte[])localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbmo
 * JD-Core Version:    0.7.0.1
 */