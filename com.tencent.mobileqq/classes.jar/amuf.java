import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.apollo.lightGame.CmGameTempSessionHandler.1;
import com.tencent.mobileqq.apollo.lightGame.CmGameTempSessionHandler.2;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanel;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.pb.apollo.CmGameMsgTunnel.PushMsgInfo;
import com.tencent.pb.apollo.CmGameMsgTunnel.TunnelMsgStream;
import com.tencent.pb.apollo.LGSessionKey.MsgAuthReq;
import com.tencent.pb.apollo.LGSessionKey.MsgAuthRsp;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONObject;

public class amuf
  implements Handler.Callback, BusinessObserver
{
  private static SparseArray<amun> b;
  private amui jdField_a_of_type_Amui;
  private amuj jdField_a_of_type_Amuj;
  private SparseArray<Long> jdField_a_of_type_AndroidUtilSparseArray;
  private bkys jdField_a_of_type_Bkys = new bkys(ThreadManager.getSubThreadLooper(), this);
  public QQLruCache<String, String> a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<Integer> jdField_a_of_type_JavaUtilList = new ArrayList();
  private CopyOnWriteArrayList<amuh> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private boolean jdField_a_of_type_Boolean;
  public QQLruCache<String, String> b;
  
  static
  {
    jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  public amuf(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache = new QQLruCache(2016, 16, 32);
    this.jdField_b_of_type_ComTencentCommonsdkCacheQQLruCache = new QQLruCache(2017, 16, 64);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    d();
    c();
  }
  
  public static amun a(int paramInt)
  {
    return (amun)jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  private void a(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBundle == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    label257:
    label1543:
    label1824:
    label2977:
    label3107:
    for (;;)
    {
      return;
      paramInt = paramBundle.getInt("extra_result_code");
      String str = paramBundle.getString("key1");
      Object localObject1 = paramBundle.getString("cmd");
      QLog.i("CmGameTemp_CmGameTempSessionHandler", 2, "onReceive cmd" + (String)localObject1 + ",isSuccess:" + paramBoolean + ",svrRet:" + paramInt);
      Object localObject2;
      long l1;
      int i;
      label175:
      label334:
      label358:
      int j;
      label299:
      int k;
      if (paramBoolean)
      {
        Object localObject3;
        try
        {
          localObject3 = paramBundle.getByteArray("data");
          localObject2 = new WebSSOAgent.UniSsoServerRsp();
          ((WebSSOAgent.UniSsoServerRsp)localObject2).mergeFrom((byte[])localObject3);
          l1 = ((WebSSOAgent.UniSsoServerRsp)localObject2).ret.get();
          QLog.i("CmGameTemp_CmGameTempSessionHandler", 2, "onReceive cmd:" + (String)localObject1 + " retCode:" + l1);
          if ("apollo_router_game.apl_audio_linkcmd_save_audio_data".equals(localObject1))
          {
            i = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
            paramInt = 0;
            if (paramInt >= i) {
              continue;
            }
            paramBundle = (amuh)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(paramInt);
            if (paramBundle == null) {
              break label2958;
            }
            paramBundle.a((int)l1);
            break label2958;
          }
          if ("apollo_router_game.apl_audio_linkcmd_query_status".equals(localObject1))
          {
            if (l1 == 0L)
            {
              localObject1 = new JSONObject(((WebSSOAgent.UniSsoServerRsp)localObject2).rspdata.get()).optJSONArray("data");
              paramInt = 0;
              i = ((JSONArray)localObject1).length();
              if (paramInt >= i) {
                continue;
              }
              paramBundle = ((JSONArray)localObject1).getJSONObject(paramInt);
              if ((paramBundle == null) || (!str.equals(paramBundle.opt("playmate")))) {
                break label2977;
              }
              i = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
              paramInt = 0;
              if (paramInt >= i) {
                continue;
              }
              localObject1 = (amuh)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(paramInt);
              if (localObject1 == null) {
                break label2965;
              }
              if (paramBundle.optInt("status") != 0) {
                break label2972;
              }
              paramBoolean = false;
              ((amuh)localObject1).a(str, paramBoolean);
              break label2965;
            }
            i = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
            paramInt = 0;
            if (paramInt >= i) {
              continue;
            }
            paramBundle = (amuh)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(paramInt);
            if (paramBundle == null) {
              break label2984;
            }
            paramBundle.a(str, false);
            break label2984;
          }
          if ("apollo_router_game.apl_audio_linkcmd_get_id".equals(localObject1))
          {
            if (l1 != 0L) {
              continue;
            }
            i = new JSONObject(((WebSSOAgent.UniSsoServerRsp)localObject2).rspdata.get()).optInt("id");
            localObject1 = paramBundle.getString("key1");
            j = Integer.parseInt(paramBundle.getString("key2", "0"));
            k = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
            paramInt = 0;
            label463:
            if (paramInt >= k) {
              continue;
            }
            paramBundle = (amuh)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(paramInt);
            if (paramBundle == null) {
              break label2991;
            }
            paramBundle.b((String)localObject1, i, j);
            break label2991;
          }
          if ("ltgame_userstatus.query_status".equals(localObject1))
          {
            if (l1 != 0L) {
              continue;
            }
            paramBundle = new JSONObject(((WebSSOAgent.UniSsoServerRsp)localObject2).rspdata.get());
            if (QLog.isColorLevel()) {
              QLog.d("CmGameTemp_CmGameTempSessionHandler", 2, "[onReceive] cmd:" + (String)localObject1 + ",data:" + paramBundle.toString());
            }
            paramBundle = paramBundle.getJSONArray("statusDetail");
            if ((paramBundle != null) && (paramBundle.length() > 0))
            {
              paramBundle = paramBundle.getJSONObject(0);
              l1 = paramBundle.optLong("uin");
              i = paramBundle.optInt("status");
              j = paramBundle.getInt("lastTs");
              k = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
              paramInt = 0;
              label639:
              if (paramInt >= k) {
                continue;
              }
              paramBundle = (amuh)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(paramInt);
              if (paramBundle == null) {
                break label2998;
              }
              paramBundle.a(String.valueOf(l1), i, j);
              break label2998;
            }
            QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "onReceive cmd" + (String)localObject1 + " statuDetails is null or size < 1");
            return;
          }
        }
        catch (Exception paramBundle)
        {
          QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, paramBundle, new Object[0]);
          return;
        }
        if ("ltgame_playmate.invite_playmate".equals(localObject1))
        {
          if (l1 != 0L) {
            continue;
          }
          i = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
          paramInt = 0;
          label754:
          if (paramInt >= i) {
            break label3010;
          }
          paramBundle = (amuh)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(paramInt);
          if (paramBundle == null) {
            break label3005;
          }
          paramBundle.b(str);
          break label3005;
        }
        if ("ltgame_playmate.accept_playmate".equals(localObject1))
        {
          if (l1 != 0L) {
            continue;
          }
          i = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
          paramInt = 0;
          label816:
          if (paramInt >= i) {
            break label3017;
          }
          paramBundle = (amuh)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(paramInt);
          if (paramBundle == null) {
            break label3012;
          }
          paramBundle.c(str);
          break label3012;
        }
        JSONArray localJSONArray;
        ankc localankc;
        ArrayList localArrayList;
        label991:
        JSONObject localJSONObject;
        if ("ltgame_gamepanel.query_top_gamelist".equals(localObject1))
        {
          if (l1 != 0L) {
            continue;
          }
          this.jdField_a_of_type_Amuj = new amuj(this);
          this.jdField_a_of_type_Amuj.jdField_a_of_type_JavaLangString = str;
          localObject2 = new JSONObject(((WebSSOAgent.UniSsoServerRsp)localObject2).rspdata.get());
          localObject3 = new ArrayList();
          localJSONArray = ((JSONObject)localObject2).getJSONArray("topGameList");
          this.jdField_a_of_type_Amuj.jdField_b_of_type_JavaLangString = ((JSONObject)localObject2).optString("description", anvx.a(2131701619));
          if ((localJSONArray != null) && (localJSONArray.length() > 0))
          {
            localankc = (ankc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOOLO_DAO_MANAGER);
            localArrayList = new ArrayList();
            j = localJSONArray.length();
            paramInt = 0;
            if (paramInt < j)
            {
              localJSONObject = localJSONArray.getJSONObject(paramInt);
              if (localJSONObject == null) {
                break label3019;
              }
              k = localJSONObject.optInt("gameId", 0);
              localObject1 = localJSONObject.optString("description", "");
              this.jdField_a_of_type_Amuj.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(k));
              this.jdField_a_of_type_Amuj.c.add(localObject1);
              if (localJSONObject.optInt("isGameApp") != 1) {
                break label3026;
              }
              i = 1;
              label1082:
              localObject2 = localankc.a(k);
              localObject1 = localObject2;
              if (i != 0)
              {
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  localObject1 = new ApolloGameData();
                  ((ApolloGameData)localObject1).gameId = k;
                }
                ((ApolloGameData)localObject1).isGameApp = true;
                ((ApolloGameData)localObject1).name = localJSONObject.optString("gameName");
                ((ApolloGameData)localObject1).listCoverUrl = localJSONObject.optString("listCoverUrl");
                ((ApolloGameData)localObject1).gameAppid = localJSONObject.optString("gameAppId");
                ((ApolloGameData)localObject1).gameAppPkgName = localJSONObject.optString("packageName");
                ((List)localObject3).add(localObject1);
              }
              if (localObject1 != null)
              {
                this.jdField_a_of_type_Amuj.jdField_b_of_type_JavaUtilList.add(localObject1);
                break label3019;
              }
              localArrayList.add(Integer.valueOf(k));
              break label3019;
            }
            if (((List)localObject3).size() > 0) {
              ((ankc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOOLO_DAO_MANAGER)).e((List)localObject3);
            }
            if (localArrayList.size() > 0)
            {
              localObject1 = (VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER);
              localObject2 = new Bundle();
              ((Bundle)localObject2).putInt("key_get_game_detail_from", 1);
              ((Bundle)localObject2).putString("key_get_game_detail_friuin", str);
              ((VasExtensionHandler)localObject1).a(localArrayList, paramBundle);
              return;
            }
            i = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
            paramInt = 0;
            label1329:
            if (paramInt >= i) {
              break label3037;
            }
            paramBundle = (amuh)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(paramInt);
            if (paramBundle == null) {
              break label3032;
            }
            paramBundle.a(str, this.jdField_a_of_type_Amuj);
            break label3032;
          }
          QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, new Object[] { "[onReceive] cmd:", localObject1, ",gameList is null or size = 0" });
          return;
        }
        if ("ltgame_gamepanel.query_self_gamelist".equals(localObject1))
        {
          if (l1 != 0L) {
            continue;
          }
          localJSONArray = new JSONObject(((WebSSOAgent.UniSsoServerRsp)localObject2).rspdata.get()).getJSONArray("selfGameList");
          if (QLog.isColorLevel()) {
            QLog.d("CmGameTemp_CmGameTempSessionHandler", 2, "[onReceive] selfGameList:" + localJSONArray.toString());
          }
          localArrayList = new ArrayList();
          this.jdField_a_of_type_JavaUtilList.clear();
          if ((localJSONArray != null) && (localJSONArray.length() > 0))
          {
            localObject3 = new ArrayList();
            localObject2 = new ArrayList();
            localankc = (ankc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOOLO_DAO_MANAGER);
            j = localJSONArray.length();
            paramInt = 0;
            if (paramInt < j)
            {
              localJSONObject = localJSONArray.getJSONObject(paramInt);
              if (localJSONObject == null) {
                break label3039;
              }
              k = localJSONObject.optInt("gameId", 0);
              if (localJSONObject.optInt("isGameApp") != 1) {
                break label3046;
              }
              i = 1;
              label1588:
              localObject1 = localankc.a(k);
              paramBundle = (Bundle)localObject1;
              if (i != 0)
              {
                paramBundle = (Bundle)localObject1;
                if (localObject1 == null)
                {
                  paramBundle = new ApolloGameData();
                  paramBundle.gameId = k;
                }
                paramBundle.isGameApp = true;
                paramBundle.name = localJSONObject.optString("gameName");
                paramBundle.listCoverUrl = localJSONObject.optString("listCoverUrl");
                paramBundle.gameAppid = localJSONObject.optString("gameAppId");
                paramBundle.gameAppPkgName = localJSONObject.optString("packageName");
                localArrayList.add(paramBundle);
              }
              this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(k));
              if (paramBundle == null) {
                break label3039;
              }
              ((ArrayList)localObject2).add(paramBundle);
              break label3039;
            }
            if (localArrayList.size() > 0) {
              ((ankc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOOLO_DAO_MANAGER)).e(localArrayList);
            }
            if (((ArrayList)localObject3).size() > 0)
            {
              paramBundle = (VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER);
              localObject1 = new Bundle();
              ((Bundle)localObject1).putInt("key_get_game_detail_from", 2);
              ((Bundle)localObject1).putString("key_get_game_detail_friuin", str);
              paramBundle.a((List)localObject3, (Bundle)localObject1);
            }
            Collections.sort((List)localObject2, this.jdField_a_of_type_Amui);
            i = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
            paramInt = 0;
            if (paramInt >= i) {
              break label3057;
            }
            paramBundle = (amuh)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(paramInt);
            if (paramBundle == null) {
              break label3052;
            }
            paramBundle.a(str, (List)localObject2);
            break label3052;
          }
          QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, new Object[] { "[onReceive] cmd:", localObject1, ",gameList is null or size = 0" });
          return;
        }
        if ("ltgame_playmate.get_playmate_info".equals(localObject1))
        {
          if (l1 != 0L) {
            continue;
          }
          paramBundle = ((WebSSOAgent.UniSsoServerRsp)localObject2).rspdata.get();
          if (!android.text.TextUtils.isEmpty(paramBundle))
          {
            localObject1 = new JSONObject(paramBundle);
            paramBundle = new ahzp();
            paramBundle.jdField_a_of_type_Int = ((JSONObject)localObject1).optInt("age");
            paramBundle.jdField_b_of_type_Int = ((JSONObject)localObject1).optInt("sex");
            paramBundle.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).optString("nickname");
            paramBundle.jdField_c_of_type_JavaLangString = ((JSONObject)localObject1).optString("city");
            paramBundle.d = ((JSONObject)localObject1).optString("head");
            paramBundle.jdField_b_of_type_JavaLangString = ((JSONObject)localObject1).optString("province");
            paramBundle.e = ((JSONObject)localObject1).optString("mate_uin");
            paramBundle.jdField_c_of_type_Int = ((JSONObject)localObject1).optInt("relationship");
            if (!android.text.TextUtils.isEmpty(paramBundle.jdField_a_of_type_JavaLangString)) {
              this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(str, paramBundle.jdField_a_of_type_JavaLangString);
            }
            if (!android.text.TextUtils.isEmpty(paramBundle.d)) {
              this.jdField_b_of_type_ComTencentCommonsdkCacheQQLruCache.put(str, paramBundle.d);
            }
            i = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
            paramInt = 0;
            label2093:
            if (paramInt >= i) {
              break label3064;
            }
            localObject1 = (amuh)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(paramInt);
            if (localObject1 == null) {
              break label3059;
            }
            ((amuh)localObject1).a(str, paramBundle);
            break label3059;
          }
          QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "[onReceive] cmd:" + (String)localObject1 + ", resp is null");
          return;
        }
        if ("ltgame_msg_auth.get_sign".equals(localObject1))
        {
          if (l1 == 0L)
          {
            paramBundle = new LGSessionKey.MsgAuthRsp();
            paramBundle.mergeFrom(((WebSSOAgent.UniSsoServerRsp)localObject2).pbRsqData.get().toByteArray());
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("CmGameTemp_CmGameTempSessionHandler", 2, new Object[] { "onReceive msgAuthRsp.sign:", paramBundle.sign.get().toStringUtf8(), " expired_ts:", Long.valueOf(paramBundle.expired_ts.get()), " create_ts:", Long.valueOf(paramBundle.create_ts.get()) });
            return;
          }
          if (l1 == -10002L)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            ApolloItemBuilder.a(anvx.a(2131701618), 1, BaseApplicationImpl.getContext());
            return;
          }
          if (l1 == -10000L)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            ApolloItemBuilder.a("获取签名里面的src_uid和自己的uin不一致", 1, BaseApplicationImpl.getContext());
            return;
          }
          if (l1 == -10001L)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            ApolloItemBuilder.a(anvx.a(2131701624), 1, BaseApplicationImpl.getContext());
            return;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          ApolloItemBuilder.a(anvx.a(2131701620) + l1, 1, BaseApplicationImpl.getContext());
          return;
        }
        long l2;
        if ("ltgame_usermatch.create_roomid".equals(localObject1))
        {
          localObject1 = ((WebSSOAgent.UniSsoServerRsp)localObject2).rspdata.get();
          if (QLog.isColorLevel()) {
            QLog.d("CmGameTemp_CmGameTempSessionHandler", 2, new Object[] { "onReceive mRespStr:", localObject1 });
          }
          i = Integer.parseInt(paramBundle.getString("key2"));
          j = Integer.parseInt(str);
          l2 = ApolloUtil.a((String)localObject1, "roomId");
          k = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
          paramInt = 0;
          label2489:
          if (paramInt >= k) {
            break label3071;
          }
          paramBundle = (amuh)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(paramInt);
          if (paramBundle == null) {
            break label3066;
          }
          if (l1 != 0L) {
            break label3073;
          }
          paramBoolean = true;
          label2520:
          paramBundle.a(paramBoolean, i, l2, j);
          break label3066;
        }
        if ("ltgame_status_svr.one_more_req".equals(localObject1))
        {
          i = Integer.parseInt(paramBundle.getString("key2"));
          l2 = Long.parseLong(paramBundle.getString("key3"));
          j = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
          paramInt = 0;
          if (paramInt >= j) {
            break label3083;
          }
          paramBundle = (amuh)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(paramInt);
          if (paramBundle == null) {
            break label3078;
          }
          if (l1 != 0L) {
            break label3085;
          }
          paramBoolean = true;
          label2612:
          paramBundle.a(paramBoolean, str, i, l2);
          break label3078;
        }
        if ("ltgame_status_svr.one_more_rsp".equals(localObject1))
        {
          i = Integer.parseInt(paramBundle.getString("key2"));
          l2 = Long.parseLong(paramBundle.getString("key3"));
          boolean bool = Boolean.parseBoolean(paramBundle.getString("key4"));
          j = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
          paramInt = 0;
          label2685:
          if (paramInt >= j) {
            break label3095;
          }
          paramBundle = (amuh)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(paramInt);
          if (paramBundle == null) {
            break label3090;
          }
          if (l1 != 0L) {
            break label3097;
          }
          paramBoolean = true;
          paramBundle.a(bool, paramBoolean, str, i, l2);
          break label3090;
        }
        if ("ltgame_status_svr.game_over_pull".equals(localObject1))
        {
          if (l1 == 0L)
          {
            c(str, ((WebSSOAgent.UniSsoServerRsp)localObject2).rspdata.get());
            return;
          }
          QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "onReceive get gameStatus error, retCode:" + l1);
          return;
        }
        if ("ltgame_status_svr.create_sy_vteamid".equals(localObject1))
        {
          i = Integer.parseInt(paramBundle.getString("key2"));
          j = Integer.parseInt(paramBundle.getString("key3"));
          k = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
          paramInt = 0;
        }
      }
      for (;;)
      {
        if (paramInt >= k) {
          break label3107;
        }
        paramBundle = (amuh)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(paramInt);
        if (paramBundle != null)
        {
          paramBundle.a(i, str, l1, ((WebSSOAgent.UniSsoServerRsp)localObject2).rspdata.get(), j);
          break label3102;
          if (!"ltgame_robot_manage.send_arkmsg_to_rb".equals(localObject1)) {
            break;
          }
          paramBundle = ((WebSSOAgent.UniSsoServerRsp)localObject2).rspdata.get();
          if (l1 == 0L) {}
          for (paramBoolean = true;; paramBoolean = false)
          {
            a(paramBoolean, str, paramBundle);
            return;
          }
          QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "onReceive isSuccess: false, cmd:" + (String)localObject1);
          return;
          paramInt += 1;
          break label175;
          paramInt += 1;
          break label299;
          paramBoolean = true;
          break label334;
          paramInt += 1;
          break label257;
          label2984:
          paramInt += 1;
          break label358;
          label2991:
          paramInt += 1;
          break label463;
          label2998:
          paramInt += 1;
          break label639;
          label3005:
          paramInt += 1;
          break label754;
          label3010:
          break;
          label3012:
          paramInt += 1;
          break label816;
          label3017:
          break;
          label3019:
          paramInt += 1;
          break label991;
          label3026:
          i = 0;
          break label1082;
          label3032:
          paramInt += 1;
          break label1329;
          label3037:
          break;
          label3039:
          paramInt += 1;
          break label1543;
          label3046:
          i = 0;
          break label1588;
          label3052:
          paramInt += 1;
          break label1824;
          label3057:
          break;
          label3059:
          paramInt += 1;
          break label2093;
          label3064:
          break;
          label3066:
          paramInt += 1;
          break label2489;
          label3071:
          break;
          paramBoolean = false;
          break label2520;
          paramInt += 1;
          break label2581;
          break;
          paramBoolean = false;
          break label2612;
          paramInt += 1;
          break label2685;
          break;
          paramBoolean = false;
          break label2716;
        }
        paramInt += 1;
      }
    }
  }
  
  private void a(long paramLong)
  {
    int j = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
    int i = 0;
    while (i < j)
    {
      amuh localamuh = (amuh)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
      if (localamuh != null) {
        localamuh.d(String.valueOf(paramLong));
      }
      i += 1;
    }
  }
  
  private void a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    for (;;)
    {
      return;
      List localList = amub.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramInt2, paramInt1, paramLong);
      if ((localList == null) || (localList.isEmpty()))
      {
        QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "pushInviteMsg targMsgList is empty");
        return;
      }
      int i = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        amuh localamuh = (amuh)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(paramInt1);
        if (localamuh != null) {
          localamuh.a(paramString, paramInt2, localList);
        }
        paramInt1 += 1;
      }
    }
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    if (android.text.TextUtils.isEmpty(paramString1)) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    Intent localIntent = new Intent(BaseApplicationImpl.getApplication(), ChatActivity.class);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", 1036);
    localIntent.putExtra("troop_uin", paramString1);
    if (!android.text.TextUtils.isEmpty(paramString2)) {
      localIntent.putExtra("uinname", paramString2);
    }
    localIntent.putExtra("leftViewText", anvx.a(2131701621));
    localIntent.putExtra("key_show_one_more_page", paramBoolean);
    localIntent.putExtra("key_req_data", paramString3);
    paramString3 = BaseActivity.sTopActivity;
    paramString2 = paramString3;
    if (paramString3 == null)
    {
      paramString2 = paramString3;
      if (SplashActivity.a != null) {
        paramString2 = (Context)SplashActivity.a.get();
      }
    }
    if (paramString2 == null)
    {
      paramString2 = BaseApplicationImpl.getContext();
      localIntent.addFlags(268435456);
    }
    for (;;)
    {
      paramString2.startActivity(localIntent);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("CmGameTemp_CmGameTempSessionHandler", 2, new Object[] { "openAio friendUin:", paramString1 });
      return;
      localIntent.addFlags(4194304);
    }
  }
  
  public static void a(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null) {}
    for (;;)
    {
      int j;
      try
      {
        if (paramJSONArray.length() <= 0) {
          break label200;
        }
        jdField_b_of_type_AndroidUtilSparseArray.clear();
        k = paramJSONArray.length();
        i = AIOUtils.dp2px(7.0F, BaseApplicationImpl.getContext().getResources());
        if (DeviceInfoUtil.getDesity() > 2.0F) {
          break label201;
        }
        i = AIOUtils.dp2px(9.0F, BaseApplicationImpl.getContext().getResources());
      }
      catch (Exception paramJSONArray)
      {
        int k;
        int i;
        JSONObject localJSONObject;
        amun localamun;
        QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, paramJSONArray, new Object[0]);
      }
      if (j < k)
      {
        localJSONObject = paramJSONArray.optJSONObject(j);
        if (localJSONObject != null)
        {
          localamun = new amun();
          localamun.jdField_a_of_type_JavaLangCharSequence = localJSONObject.optString("tips");
          localamun.jdField_a_of_type_Int = localJSONObject.optInt("id");
          localamun.jdField_b_of_type_Int = localJSONObject.optInt("tipsType");
          if (!android.text.TextUtils.isEmpty(localamun.jdField_a_of_type_JavaLangCharSequence))
          {
            if (localamun.jdField_b_of_type_Int == 1) {
              localamun.jdField_a_of_type_JavaLangCharSequence = new QQText(com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(localJSONObject.optInt("tips")), 3, i);
            }
            jdField_b_of_type_AndroidUtilSparseArray.put(localamun.jdField_a_of_type_Int, localamun);
          }
        }
        j += 1;
      }
      else
      {
        label200:
        return;
        label201:
        j = 0;
      }
    }
  }
  
  private void b(long paramLong)
  {
    int j = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
    int i = 0;
    while (i < j)
    {
      amuh localamuh = (amuh)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
      if (localamuh != null) {
        localamuh.e(String.valueOf(paramLong));
      }
      i += 1;
    }
  }
  
  private void b(boolean paramBoolean, String paramString, int paramInt, long paramLong)
  {
    int j = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
    int i = 0;
    while (i < j)
    {
      amuh localamuh = (amuh)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
      if (localamuh != null) {
        localamuh.b(paramBoolean, paramString, paramInt, paramLong);
      }
      i += 1;
    }
  }
  
  private void c()
  {
    int i = 0;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    Object localObject = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0).getString("apollo_temp_aio_game_list" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "");
    QLog.i("CmGameTemp_CmGameTempSessionHandler", 1, "[initGameTimeStamp] game timestamp:" + ((String)localObject).toString());
    if (!android.text.TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split(",");
      int j = localObject.length;
      while (i + 1 < j)
      {
        this.jdField_a_of_type_AndroidUtilSparseArray.put(Integer.parseInt(localObject[i]), Long.valueOf(Long.parseLong(localObject[(i + 1)])));
        i += 2;
      }
    }
    this.jdField_a_of_type_Amui = new amui(this.jdField_a_of_type_AndroidUtilSparseArray);
  }
  
  private void c(String paramString, int paramInt, long paramLong)
  {
    int j = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
    int i = 0;
    while (i < j)
    {
      amuh localamuh = (amuh)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
      if (localamuh != null) {
        localamuh.a(paramString, paramInt, paramLong);
      }
      i += 1;
    }
  }
  
  private void c(String paramString1, String paramString2)
  {
    for (;;)
    {
      Object localObject2;
      int j;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("CmGameTemp_CmGameTempSessionHandler", 2, "onQueryTempGameStatusRsp gameStatusJson:" + paramString2);
        }
        paramString2 = new JSONObject(paramString2).optJSONArray("data");
        if ((paramString2 != null) && (paramString2.length() > 0))
        {
          paramString1 = amub.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, 1036);
          if ((paramString1 == null) || (paramString1.isEmpty()))
          {
            QLog.e("CmGameTemp_CmGameTempSessionHandler", 2, "onQueryTempGameStatusRsp msgList == null || msgList.isEmpty()");
            return;
          }
          amly localamly = ((amma)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOLLO_GAME_MANAGER)).a();
          int i = 0;
          if (i < paramString2.length())
          {
            localObject2 = paramString2.getJSONObject(i);
            if (localObject2 != null)
            {
              long l = ((JSONObject)localObject2).optLong("roomId");
              j = ((JSONObject)localObject2).optInt("gameId");
              int k = ((JSONObject)localObject2).optInt("state");
              Object localObject1 = ((JSONObject)localObject2).optJSONArray("result");
              localObject2 = ((JSONObject)localObject2).optJSONArray("winner");
              if ((k >= 4) && (l > 0L) && (j > 0))
              {
                MessageForApollo localMessageForApollo = amub.a(paramString1, j, l);
                if (localMessageForApollo != null)
                {
                  localMessageForApollo.gameStatus = 2;
                  if (localObject1 == null) {
                    break label321;
                  }
                  localMessageForApollo.commInfo = ((JSONArray)localObject1).toString();
                  break label321;
                  if (j < ((JSONArray)localObject2).length())
                  {
                    localObject1 = ((JSONArray)localObject2).optString(j);
                    localMessageForApollo.winnerList.add(Long.valueOf(ApolloUtil.a((String)localObject1)));
                    j += 1;
                    continue;
                  }
                  ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForApollo);
                  localamly.a(localMessageForApollo);
                }
              }
            }
            i += 1;
            continue;
          }
        }
        return;
      }
      catch (Exception paramString1)
      {
        QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "onQueryTempGameStatusRsp failed ", paramString1);
      }
      label321:
      if (localObject2 != null) {
        j = 0;
      }
    }
  }
  
  private void d()
  {
    ThreadManagerV2.excute(new CmGameTempSessionHandler.1(this), 16, null, false);
  }
  
  private void i(String paramString)
  {
    long l;
    int i;
    int j;
    Object localObject2;
    try
    {
      if (android.text.TextUtils.isEmpty(paramString)) {
        return;
      }
      localObject1 = new JSONObject(paramString);
      if (localObject1 == null) {
        break label253;
      }
      l = ((JSONObject)localObject1).optLong("roomId");
      i = ((JSONObject)localObject1).optInt("gameId");
      j = ((JSONObject)localObject1).optInt("state");
      paramString = ((JSONObject)localObject1).optString("playMate");
      localObject2 = amub.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, 1036);
      if ((localObject2 == null) || (((List)localObject2).isEmpty()))
      {
        QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "onPushTempGameStatus msgList == null || msgList.isEmpty()");
        return;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "onPushGameStatus failed ", paramString);
      return;
    }
    paramString = ((JSONObject)localObject1).optJSONArray("result");
    Object localObject1 = ((JSONObject)localObject1).optJSONArray("winner");
    if ((j >= 4) && (l > 0L) && (i > 0))
    {
      localObject2 = amub.a((List)localObject2, i, l);
      if (localObject2 != null)
      {
        ((MessageForApollo)localObject2).gameStatus = 2;
        if (paramString == null) {
          break label254;
        }
        ((MessageForApollo)localObject2).commInfo = paramString.toString();
        break label254;
      }
    }
    for (;;)
    {
      if (i < ((JSONArray)localObject1).length())
      {
        paramString = ((JSONArray)localObject1).optString(i);
        ((MessageForApollo)localObject2).winnerList.add(Long.valueOf(ApolloUtil.a(paramString)));
        i += 1;
      }
      else
      {
        label253:
        label254:
        do
        {
          ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForApollo)localObject2);
          ((amma)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOLLO_GAME_MANAGER)).a().a((MessageForApollo)localObject2);
          return;
        } while (localObject1 == null);
        i = 0;
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bkys.removeMessages(255);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameTempSessionHandler", 2, new Object[] { "[updateTempPanelGame] updateGameList:", Integer.valueOf(paramInt) });
    }
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, Long.valueOf(System.currentTimeMillis()));
    Object localObject1 = new StringBuilder();
    int i = this.jdField_a_of_type_AndroidUtilSparseArray.size();
    paramInt = 0;
    while (paramInt < i)
    {
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(paramInt));
      ((StringBuilder)localObject1).append(",");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(paramInt));
      if (paramInt != i - 1) {
        ((StringBuilder)localObject1).append(",");
      }
      paramInt += 1;
    }
    Object localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 0);
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameTempSessionHandler", 2, "[updateTempPanelGame] time list:" + ((StringBuilder)localObject1).toString());
    }
    ((SharedPreferences)localObject2).edit().putString("apollo_temp_aio_game_list" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), ((StringBuilder)localObject1).toString()).commit();
    if ((BaseActivity.sTopActivity instanceof FragmentActivity))
    {
      localObject1 = (ChatFragment)((FragmentActivity)BaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if (localObject1 != null)
      {
        localObject1 = ((ChatFragment)localObject1).a();
        if (!(localObject1 instanceof ahzc)) {}
      }
    }
    for (localObject1 = (ahzc)localObject1;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject2 = ((ahzc)localObject1).a();
        if (localObject2 != null) {
          break label285;
        }
      }
      label285:
      do
      {
        return;
        Collections.sort((List)localObject2, this.jdField_a_of_type_Amui);
        ((ahzc)localObject1).a((List)localObject2);
      } while (((ahzc)localObject1).mApolloPanel == null);
      ((ahzc)localObject1).mApolloPanel.m();
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "ltgame_usermatch.create_roomid");
      ((JSONObject)localObject).put("gameId", paramInt1);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), amrc.class);
      ((NewIntent)localObject).putExtra("timeout", 10000L);
      ((NewIntent)localObject).putExtra("cmd", "ltgame_usermatch.create_roomid");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      ((NewIntent)localObject).putExtra("key1", String.valueOf(paramInt2));
      ((NewIntent)localObject).putExtra("key2", String.valueOf(paramInt1));
      ((NewIntent)localObject).setObserver(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "createRoomIdAsync failed ", localException);
    }
  }
  
  public void a(int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameTempSessionHandler", 2, new Object[] { "[queryVirtualRoomInfo] gameId=", Integer.valueOf(paramInt1), ", appid=", paramString1, ", partition=", Integer.valueOf(paramInt2), ", playmateUin=", paramString2, ", reqCode=", Integer.valueOf(paramInt3) });
    }
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("appid", paramString1);
      ((JSONObject)localObject).put("partition", paramInt2);
      ((JSONObject)localObject).put("playmate", paramString2);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      paramString1 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), amrc.class);
      paramString1.putExtra("cmd", "ltgame_status_svr.create_sy_vteamid");
      paramString1.putExtra("key1", paramString2);
      paramString1.putExtra("key2", String.valueOf(paramInt1));
      paramString1.putExtra("key3", String.valueOf(paramInt3));
      paramString1.putExtra("data", localUniSsoServerReq.toByteArray());
      paramString1.setObserver(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramString1);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "[queryVirtualRoomInfo] failed, exception=", paramString1);
    }
  }
  
  public void a(amuh paramamuh)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramamuh);
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramamuh);
    QLog.i("CmGameTemp_CmGameTempSessionHandler", 1, "addMsgUIHandler size:" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() + " cmGameMsgUIHandler:" + paramamuh);
  }
  
  public void a(CmGameMsgTunnel.TunnelMsgStream paramTunnelMsgStream)
  {
    if (paramTunnelMsgStream == null) {
      QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "[handleCmGamePushMsg] stream null");
    }
    label248:
    label761:
    label764:
    for (;;)
    {
      return;
      String str = paramTunnelMsgStream.cmd.get();
      QLog.d("CmGameTemp_CmGameTempSessionHandler", 1, new Object[] { "[handleCmGamePushMsg] stream cmd=", str });
      int j;
      long l1;
      long l2;
      long l3;
      try
      {
        CmGameMsgTunnel.PushMsgInfo localPushMsgInfo = new CmGameMsgTunnel.PushMsgInfo();
        localPushMsgInfo.mergeFrom(paramTunnelMsgStream.busi_buff.get().toByteArray());
        j = localPushMsgInfo.gameid.get();
        l1 = localPushMsgInfo.accept_uid.get();
        l2 = localPushMsgInfo.invite_uid.get();
        l3 = localPushMsgInfo.roomid.get();
        i = localPushMsgInfo.ret.get();
        paramTunnelMsgStream = localPushMsgInfo.ext_info.get();
        if (QLog.isColorLevel()) {
          QLog.d("CmGameTemp_CmGameTempSessionHandler", 2, new Object[] { "[handleCmGamePushMsg] gameId=", Integer.valueOf(j), ", acceptUin=", Long.valueOf(l1), ", inviteUin=", Long.valueOf(l2), ", roomId=", Long.valueOf(l3), ", ret=", Integer.valueOf(i), ", extInfo=", paramTunnelMsgStream });
        }
        if ("close_aio".equals(str))
        {
          j = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
          i = 0;
          if (i >= j) {
            continue;
          }
          paramTunnelMsgStream = (amuh)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
          if (paramTunnelMsgStream == null) {
            break label741;
          }
          paramTunnelMsgStream.a(String.valueOf(l2));
          break label741;
        }
        if ("mphone_status".equals(str))
        {
          if (android.text.TextUtils.isEmpty(paramTunnelMsgStream)) {
            break label736;
          }
          i = new JSONObject(paramTunnelMsgStream).optInt("status", 0);
          int k = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
          j = 0;
          if (j >= k) {
            continue;
          }
          paramTunnelMsgStream = (amuh)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(j);
          if (paramTunnelMsgStream == null) {
            break label748;
          }
          paramTunnelMsgStream.a(String.valueOf(l2), i);
          break label748;
        }
        if ("accept_invite".equals(str))
        {
          i = 1036;
          if (!android.text.TextUtils.isEmpty(paramTunnelMsgStream)) {
            i = new JSONObject(paramTunnelMsgStream).optInt("aioType");
          }
          a(String.valueOf(l1), j, l3, i);
          return;
        }
      }
      catch (Exception paramTunnelMsgStream)
      {
        QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "[handleCmGamePushMsg] exception=", paramTunnelMsgStream);
        return;
      }
      boolean bool;
      if ("one_more_rsp".equals(str))
      {
        if (i == 1)
        {
          bool = true;
          b(bool, String.valueOf(l1), j, l3);
        }
      }
      else
      {
        if ("one_more_req".equals(str))
        {
          c(String.valueOf(l2), j, l3);
          return;
        }
        if ("match_complete".equals(str))
        {
          amub.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l1), l3, j);
          return;
        }
        if ("push_invite_msg".equals(str))
        {
          a(l2);
          return;
        }
        if ("push_accept_msg".equals(str))
        {
          b(l1);
          return;
        }
        if ("game_over".equals(str))
        {
          i(paramTunnelMsgStream);
          return;
        }
        if ("match_success".equals(str))
        {
          if (android.text.TextUtils.isEmpty(paramTunnelMsgStream)) {
            continue;
          }
          paramTunnelMsgStream = new JSONObject(paramTunnelMsgStream);
          l1 = paramTunnelMsgStream.optLong("matchedUin");
          if (paramTunnelMsgStream.optInt("isRobot") != 1) {
            break label761;
          }
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label764;
        }
        amuo.a(String.valueOf(l1));
        return;
        if ("robot_send_arkmsg".equals(str))
        {
          if (android.text.TextUtils.isEmpty(paramTunnelMsgStream)) {
            break;
          }
          paramTunnelMsgStream = new JSONObject(paramTunnelMsgStream);
          i = paramTunnelMsgStream.optInt("gameId");
          l1 = ApolloUtil.a(paramTunnelMsgStream.optString("roomId"));
          l2 = paramTunnelMsgStream.optLong("rbUin");
          paramTunnelMsgStream = paramTunnelMsgStream.optString("rbOpenId");
          amub.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l2), paramTunnelMsgStream, l1, i);
          return;
        }
        QLog.w("CmGameTemp_CmGameTempSessionHandler", 1, "[handleCmGamePushMsg] cmd not support, cmd=" + str);
        return;
        i = 0;
        break label316;
        i += 1;
        break label248;
        j += 1;
        break label327;
        bool = false;
        break label446;
      }
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("CmGameTemp_CmGameTempSessionHandler", 2, "queryTempGameStatus ");
      }
      localObject2 = amub.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, 1036, 1);
      if ((localObject2 == null) || (((List)localObject2).isEmpty()))
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("CmGameTemp_CmGameTempSessionHandler", 2, "queryTempGameStatus msgList == null || msgList.isEmpty()");
        return;
      }
      localObject1 = new JSONArray();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (MessageForApollo)((Iterator)localObject2).next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("roomId", String.valueOf(((MessageForApollo)localObject3).roomId));
        localJSONObject.put("gameId", ((MessageForApollo)localObject3).gameId);
        ((JSONArray)localObject1).put(localJSONObject);
      }
      localObject3 = new WebSSOAgent.UniSsoServerReqComm();
    }
    catch (Exception paramString)
    {
      QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "queryTopGameList failed ", paramString);
      return;
    }
    ((WebSSOAgent.UniSsoServerReqComm)localObject3).platform.set(109L);
    ((WebSSOAgent.UniSsoServerReqComm)localObject3).osver.set(Build.VERSION.RELEASE);
    ((WebSSOAgent.UniSsoServerReqComm)localObject3).mqqver.set("8.4.10");
    Object localObject2 = new WebSSOAgent.UniSsoServerReq();
    ((WebSSOAgent.UniSsoServerReq)localObject2).comm.set((MessageMicro)localObject3);
    Object localObject3 = new JSONObject();
    ((JSONObject)localObject3).put("cmd", "ltgame_status_svr.game_over_pull");
    ((JSONObject)localObject3).put("query", localObject1);
    ((JSONObject)localObject3).put("from", "android");
    ((JSONObject)localObject3).put("extendInfo", "");
    ((WebSSOAgent.UniSsoServerReq)localObject2).reqdata.set(((JSONObject)localObject3).toString());
    Object localObject1 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), amrc.class);
    ((NewIntent)localObject1).putExtra("timeout", 10000L);
    ((NewIntent)localObject1).putExtra("cmd", "ltgame_status_svr.game_over_pull");
    ((NewIntent)localObject1).putExtra("data", ((WebSSOAgent.UniSsoServerReq)localObject2).toByteArray());
    ((NewIntent)localObject1).putExtra("key1", paramString);
    ((NewIntent)localObject1).setObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject1);
  }
  
  public void a(String paramString, int paramInt)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "apollo_router_game.apl_audio_linkcmd_query_status");
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(paramString);
      ((JSONObject)localObject).put("playmate", localJSONArray);
      ((JSONObject)localObject).put("from", String.valueOf(paramInt));
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), amrc.class);
      ((NewIntent)localObject).putExtra("timeout", 10000L);
      ((NewIntent)localObject).putExtra("cmd", "apollo_router_game.apl_audio_linkcmd_query_status");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      ((NewIntent)localObject).putExtra("key1", paramString);
      ((NewIntent)localObject).setObserver(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "[queryUserAudioStatus] failed ", paramString);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "ltgame_playmate.get_playmate_info");
      ((JSONObject)localObject).put("oidb", paramInt2);
      ((JSONObject)localObject).put("mask", "11111111111");
      ((JSONObject)localObject).put("mate_uin", Long.parseLong(paramString));
      String str = ((TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((JSONObject)localObject).put("Cookie", "skey=" + str);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), amrc.class);
      ((NewIntent)localObject).putExtra("timeout", 10000L);
      ((NewIntent)localObject).putExtra("cmd", "ltgame_playmate.get_playmate_info");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      ((NewIntent)localObject).putExtra("key1", paramString);
      ((NewIntent)localObject).setObserver(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "queryUserTempInfoAsync failed ", paramString);
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "ltgame_status_svr.one_more_req");
      ((JSONObject)localObject).put("matchA", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((JSONObject)localObject).put("matchB", paramString);
      ((JSONObject)localObject).put("roomId", String.valueOf(paramLong));
      ((JSONObject)localObject).put("gameId", paramInt);
      ((JSONObject)localObject).put("from", "android");
      ((JSONObject)localObject).put("extendInfo", "");
      ((JSONObject)localObject).put("type", 0);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), amrc.class);
      ((NewIntent)localObject).putExtra("timeout", 10000L);
      ((NewIntent)localObject).putExtra("cmd", "ltgame_status_svr.one_more_req");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      ((NewIntent)localObject).putExtra("key1", paramString);
      ((NewIntent)localObject).putExtra("key2", String.valueOf(paramInt));
      ((NewIntent)localObject).putExtra("key3", String.valueOf(paramLong));
      ((NewIntent)localObject).setObserver(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "queryUserTempInfoAsync failed ", paramString);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "ltgame_userstatus.report_status");
      ((JSONObject)localObject).put("src", "AIO");
      ((JSONObject)localObject).put("motion", paramString2);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      paramString2 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), amrc.class);
      paramString2.putExtra("timeout", 10000L);
      paramString2.putExtra("cmd", "ltgame_userstatus.report_status");
      paramString2.putExtra("data", localUniSsoServerReq.toByteArray());
      paramString2.putExtra("key1", paramString1);
      paramString2.setObserver(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramString2);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "reportUserStatus failed ", paramString1);
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "apollo_router_game.apl_audio_linkcmd_save_audio_data");
      ((JSONObject)localObject).put("uin", paramString1);
      ((JSONObject)localObject).put("recordUrl", paramString2);
      ((JSONObject)localObject).put("totalTime", paramLong);
      ((JSONObject)localObject).put("extendInfo", "");
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      paramString2 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), amrc.class);
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
      QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "queryAllGameList failed ", paramString1);
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
        ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10");
        WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
        localUniSsoServerReq.comm.set((MessageMicro)localObject);
        localObject = new LGSessionKey.MsgAuthReq();
        ((LGSessionKey.MsgAuthReq)localObject).appid.set(2);
        ((LGSessionKey.MsgAuthReq)localObject).src_uid.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
        ((LGSessionKey.MsgAuthReq)localObject).dst_uid.set(Long.parseLong(paramString1));
        localUniSsoServerReq.pbReqData.set(ByteStringMicro.copyFrom(((LGSessionKey.MsgAuthReq)localObject).toByteArray()));
        localObject = new NewIntent(BaseApplicationImpl.getContext(), amrc.class);
        ((NewIntent)localObject).putExtra("timeout", 10000L);
        ((NewIntent)localObject).putExtra("cmd", "ltgame_msg_auth.get_sign");
        ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
        ((NewIntent)localObject).putExtra("key1", paramString1);
        ((NewIntent)localObject).putExtra("key2", paramString2);
        if (paramBoolean)
        {
          paramString2 = "1";
          ((NewIntent)localObject).putExtra("key3", paramString2);
          ((NewIntent)localObject).setObserver(this);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("CmGameTemp_CmGameTempSessionHandler", 2, new Object[] { "queryNewSessionKey friendUin:", paramString1 });
          return;
        }
      }
      catch (Exception paramString1)
      {
        QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, paramString1, new Object[0]);
        return;
      }
      paramString2 = "0";
    }
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "apollo_router_game.apl_audio_linkcmd_report_status");
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        ((JSONObject)localObject).put("status", i);
        JSONArray localJSONArray = new JSONArray();
        localJSONArray.put(paramString);
        ((JSONObject)localObject).put("playmate", localJSONArray);
        ((JSONObject)localObject).put("from", paramInt + "");
        localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
        localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), amrc.class);
        ((NewIntent)localObject).putExtra("timeout", 10000L);
        ((NewIntent)localObject).putExtra("cmd", "apollo_router_game.apl_audio_linkcmd_report_status");
        ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
        ((NewIntent)localObject).putExtra("key1", paramString);
        ((NewIntent)localObject).setObserver(this);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "addPlayMate failed ", paramString);
    }
  }
  
  public void a(List<ApolloGameData> paramList, Bundle paramBundle)
  {
    int j = 0;
    Object localObject = (ankc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOOLO_DAO_MANAGER);
    int i = paramBundle.getInt("key_get_game_detail_from");
    paramList = paramBundle.getString("key_get_game_detail_friuin");
    int k;
    if (i == 1)
    {
      this.jdField_a_of_type_Amuj.jdField_b_of_type_JavaUtilList.clear();
      k = this.jdField_a_of_type_Amuj.jdField_b_of_type_JavaUtilList.size();
      i = 0;
      while (i < k)
      {
        int m = ((Integer)this.jdField_a_of_type_Amuj.jdField_a_of_type_JavaUtilList.get(i)).intValue();
        paramBundle = ((ankc)localObject).a(m);
        if (paramBundle != null)
        {
          this.jdField_a_of_type_Amuj.jdField_b_of_type_JavaUtilList.add(paramBundle);
          i += 1;
        }
        else
        {
          QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, new Object[] { "[onGetGameConfigList] gameData is null,gameId:", Integer.valueOf(m) });
        }
      }
    }
    for (;;)
    {
      return;
      k = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
      i = j;
      while (i < k)
      {
        paramBundle = (amuh)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
        if (paramBundle != null) {
          paramBundle.a(paramList, this.jdField_a_of_type_Amuj);
        }
        i += 1;
      }
      continue;
      if (i == 2)
      {
        paramBundle = new ArrayList();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          i = ((Integer)localIterator.next()).intValue();
          ApolloGameData localApolloGameData = ((ankc)localObject).a(i);
          if (localApolloGameData != null) {
            paramBundle.add(localApolloGameData);
          } else {
            QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, new Object[] { "[onGetGameConfigList] gameData is null,gameId:", Integer.valueOf(i) });
          }
        }
        Collections.sort(paramBundle, this.jdField_a_of_type_Amui);
        j = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
        i = 0;
        while (i < j)
        {
          localObject = (amuh)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(0);
          if (localObject != null) {
            ((amuh)localObject).a(paramList, paramBundle);
          }
          i += 1;
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt, long paramLong)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "ltgame_status_svr.one_more_rsp");
      ((JSONObject)localObject).put("matchB", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((JSONObject)localObject).put("matchA", paramString);
      ((JSONObject)localObject).put("roomId", String.valueOf(paramLong));
      ((JSONObject)localObject).put("gameId", paramInt);
      ((JSONObject)localObject).put("from", "android");
      ((JSONObject)localObject).put("extendInfo", "");
      if (paramBoolean) {}
      for (int i = 1;; i = 2)
      {
        ((JSONObject)localObject).put("type", i);
        localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
        localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), amrc.class);
        ((NewIntent)localObject).putExtra("timeout", 10000L);
        ((NewIntent)localObject).putExtra("cmd", "ltgame_status_svr.one_more_rsp");
        ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
        ((NewIntent)localObject).putExtra("key1", paramString);
        ((NewIntent)localObject).putExtra("key2", String.valueOf(paramInt));
        ((NewIntent)localObject).putExtra("key3", String.valueOf(paramLong));
        ((NewIntent)localObject).putExtra("key4", String.valueOf(paramBoolean));
        ((NewIntent)localObject).setObserver(this);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "queryUserTempInfoAsync failed ", paramString);
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((android.text.TextUtils.isEmpty(paramString1)) || (android.text.TextUtils.isEmpty(paramString2))) {}
    for (;;)
    {
      return;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("CmGameTemp_CmGameTempSessionHandler", 2, "onCheckRobotGameModeRsp rspStr:" + paramString2);
        }
        paramString2 = new JSONObject(paramString2);
        if (paramString2 == null) {
          continue;
        }
        int j = paramString2.optInt("gameId");
        long l = Long.parseLong(paramString2.optString("roomId"));
        paramString2 = paramString2.optString("rbOpenId");
        int k = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
        int i = 0;
        while (i < k)
        {
          amuh localamuh = (amuh)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
          if (localamuh != null) {
            localamuh.a(paramBoolean, paramString1, j, l, paramString2);
          }
          i += 1;
        }
        return;
      }
      catch (Exception paramString1)
      {
        QLog.d("CmGameTemp_CmGameTempSessionHandler", 1, paramString1, new Object[0]);
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
  }
  
  public void b(amuh paramamuh)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramamuh);
    QLog.i("CmGameTemp_CmGameTempSessionHandler", 1, "removeMsgUIHandler size:" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() + " cmGameMsgUIHandler:" + paramamuh);
  }
  
  public void b(String paramString)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "ltgame_gamepanel.query_top_gamelist");
      ((JSONObject)localObject).put("playFrdUin", Long.parseLong(paramString));
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), amrc.class);
      ((NewIntent)localObject).putExtra("timeout", 10000L);
      ((NewIntent)localObject).putExtra("cmd", "ltgame_gamepanel.query_top_gamelist");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      ((NewIntent)localObject).putExtra("key1", paramString);
      ((NewIntent)localObject).setObserver(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "queryTopGameList failed ", paramString);
    }
  }
  
  public void b(String paramString, int paramInt)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "apollo_router_game.apl_audio_linkcmd_get_id");
      ((JSONObject)localObject).put("friendUin", paramString);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), amrc.class);
      ((NewIntent)localObject).putExtra("timeout", 10000L);
      ((NewIntent)localObject).putExtra("cmd", "apollo_router_game.apl_audio_linkcmd_get_id");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      ((NewIntent)localObject).putExtra("key1", paramString);
      ((NewIntent)localObject).putExtra("key2", String.valueOf(paramInt));
      ((NewIntent)localObject).setObserver(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "queryTopGameList failed ", paramString);
    }
  }
  
  public void b(String paramString, int paramInt, long paramLong)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "ltgame_robot_manage.send_arkmsg_to_rb");
      ((JSONObject)localObject).put("gameId", paramInt);
      ((JSONObject)localObject).put("rbUin", Long.parseLong(paramString));
      ((JSONObject)localObject).put("roomId", String.valueOf(paramLong));
      ((JSONObject)localObject).put("from", "android.aio");
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), amrc.class);
      ((NewIntent)localObject).putExtra("timeout", 10000L);
      ((NewIntent)localObject).putExtra("cmd", "ltgame_robot_manage.send_arkmsg_to_rb");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      ((NewIntent)localObject).putExtra("key1", paramString);
      ((NewIntent)localObject).setObserver(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "createRoomIdAsync failed ", paramString);
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (android.text.TextUtils.isEmpty(paramString1))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameTempSessionHandler", 2, new Object[] { "checkAndOpenCmGameAio friendUin:", paramString1 });
    }
    a(paramString1, paramString2, false, "");
  }
  
  public void c(String paramString)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "ltgame_gamepanel.query_self_gamelist");
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), amrc.class);
      ((NewIntent)localObject).putExtra("timeout", 10000L);
      ((NewIntent)localObject).putExtra("cmd", "ltgame_gamepanel.query_self_gamelist");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      ((NewIntent)localObject).putExtra("key1", paramString);
      ((NewIntent)localObject).setObserver(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "queryAllGameList failed ", paramString);
    }
  }
  
  public void d(String paramString)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "ltgame_status_svr.close_aio_push");
      ((JSONObject)localObject).put("playmate", paramString);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), amrc.class);
      ((NewIntent)localObject).putExtra("timeout", 10000L);
      ((NewIntent)localObject).putExtra("cmd", "ltgame_status_svr.close_aio_push");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      ((NewIntent)localObject).putExtra("key1", paramString);
      ((NewIntent)localObject).setObserver(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "reportUserExitAio failed ", paramString);
    }
  }
  
  public void e(String paramString)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "ltgame_userstatus.query_status");
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(Long.parseLong(paramString));
      ((JSONObject)localObject).putOpt("uinList", localJSONArray);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), amrc.class);
      ((NewIntent)localObject).putExtra("timeout", 10000L);
      ((NewIntent)localObject).putExtra("cmd", "ltgame_userstatus.query_status");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      ((NewIntent)localObject).putExtra("key1", paramString);
      ((NewIntent)localObject).setObserver(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "addPlayMate failed ", paramString);
    }
  }
  
  public void f(String paramString)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "ltgame_playmate.invite_playmate");
      ((JSONObject)localObject).put("add_uin", Long.parseLong(paramString));
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), amrc.class);
      ((NewIntent)localObject).putExtra("timeout", 10000L);
      ((NewIntent)localObject).putExtra("cmd", "ltgame_playmate.invite_playmate");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      ((NewIntent)localObject).putExtra("key1", paramString);
      ((NewIntent)localObject).setObserver(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "addPlayMate failed ", paramString);
    }
  }
  
  public void g(String paramString)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "ltgame_playmate.accept_playmate");
      ((JSONObject)localObject).put("accept_uin", Long.parseLong(paramString));
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), amrc.class);
      ((NewIntent)localObject).putExtra("timeout", 10000L);
      ((NewIntent)localObject).putExtra("cmd", "ltgame_playmate.accept_playmate");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      ((NewIntent)localObject).putExtra("key1", paramString);
      ((NewIntent)localObject).setObserver(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "acceptPlayMate failed ", paramString);
    }
  }
  
  public void h(String paramString)
  {
    for (;;)
    {
      try
      {
        if ((BaseActivity.sTopActivity instanceof FragmentActivity))
        {
          localObject1 = (ChatFragment)((FragmentActivity)BaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
          if (localObject1 != null)
          {
            localObject1 = ((ChatFragment)localObject1).a();
            if ((localObject1 instanceof ahzc))
            {
              localObject1 = (ahzc)localObject1;
              Object localObject2 = new JSONObject(paramString);
              int i = ((JSONObject)localObject2).optInt("scoreState");
              int j = ((JSONObject)localObject2).optInt("gameId");
              String str = ((JSONObject)localObject2).optString("friendUin");
              localObject2 = ((JSONObject)localObject2).optString("nickName");
              if ((localObject1 == null) || (!((ahzc)localObject1).a()))
              {
                a(str, (String)localObject2, true, paramString);
                return;
              }
              ahzc.c = true;
              ((ahzc)localObject1).a(j, i, paramString);
              return;
            }
          }
        }
      }
      catch (Exception paramString)
      {
        QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, paramString, new Object[0]);
        return;
      }
      Object localObject1 = null;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameTempSessionHandler", 2, new Object[] { "handleMessage msg.what:", Integer.valueOf(paramMessage.what) });
    }
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
    } while (!(paramMessage.obj instanceof String));
    a((String)paramMessage.obj, "", false);
    return false;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBundle == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    ThreadManagerV2.excute(new CmGameTempSessionHandler.2(this, paramInt, paramBoolean, paramBundle), 16, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amuf
 * JD-Core Version:    0.7.0.1
 */