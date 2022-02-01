package com.tencent.biz.TroopRedpoint;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryNodeConfigManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.RedPointUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.api.INearbyConfigUtil;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearby.redtouch.INearbyRedDotCustomInfo;
import com.tencent.mobileqq.nearby.redtouch.INearbyRedInfo;
import com.tencent.mobileqq.nearby.redtouch.NearbyRedNum;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x791.oidb_0x791.DTNearbyEntranceExtendConfig;
import tencent.im.oidb.cmd0x791.oidb_0x791.DTNearbyEntranceWordCornerRedDot;
import tencent.im.oidb.cmd0x791.oidb_0x791.GetRedDotRes;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class TroopRedTouchManager
  implements Manager
{
  public static final String d = String.valueOf(System.currentTimeMillis());
  protected int a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new TroopRedTouchManager.1(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  final String jdField_a_of_type_JavaLangString = "TroopRedTouchManager2_";
  Map<Long, oidb_0x791.RedDotInfo> jdField_a_of_type_JavaUtilMap = null;
  oidb_0x791.GetRedDotRes jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes;
  boolean jdField_a_of_type_Boolean = false;
  final String b = "TroopRedTouchManager2_All";
  final String c = TroopRedTouchManager.class.getSimpleName();
  
  public TroopRedTouchManager(QQAppInterface paramQQAppInterface)
  {
    this(paramQQAppInterface, null);
  }
  
  public TroopRedTouchManager(QQAppInterface paramQQAppInterface, oidb_0x791.GetRedDotRes paramGetRedDotRes)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (paramGetRedDotRes != null) {
      this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = paramGetRedDotRes;
    }
    b();
  }
  
  private String a()
  {
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    while (i < this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size())
    {
      Object localObject = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(i);
      if (((oidb_0x791.RedDotInfo)localObject).str_custom_buffer.has()) {
        try
        {
          localObject = new JSONObject(((oidb_0x791.RedDotInfo)localObject).str_custom_buffer.get().toStringUtf8());
          if (((JSONObject)localObject).optInt("is_web_care") == 1) {
            localJSONArray.put(((JSONObject)localObject).optString("web_red_dot_data"));
          }
        }
        catch (Exception localException)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("get webCareRedDotInfo error: ");
          ((StringBuilder)localObject).append(localException.getMessage());
          QLog.e("nearby.redpoint", 1, ((StringBuilder)localObject).toString());
          return "";
        }
      }
      i += 1;
    }
    return localException.toString();
  }
  
  private String a(Map<Long, oidb_0x791.RedDotInfo> paramMap)
  {
    if (paramMap == null) {
      return "";
    }
    try
    {
      localObject1 = new JSONObject();
      localObject2 = paramMap.keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Long localLong = (Long)((Iterator)localObject2).next();
        if ((localLong != null) && (paramMap.get(localLong) != null))
        {
          byte[] arrayOfByte = ((oidb_0x791.RedDotInfo)paramMap.get(localLong)).toByteArray();
          ((JSONObject)localObject1).put(String.valueOf(localLong), Base64Util.encodeToString(arrayOfByte, 0));
        }
      }
      paramMap = ((JSONObject)localObject1).toString();
      return paramMap;
    }
    catch (JSONException paramMap)
    {
      Object localObject1 = this.c;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("convertHashMapToJSONString: JSONException when convert HashMap data - ");
      ((StringBuilder)localObject2).append(paramMap.getMessage());
      PlayerUtils.log(6, (String)localObject1, ((StringBuilder)localObject2).toString());
    }
    return "";
  }
  
  public static String a(oidb_0x791.RedDotInfo paramRedDotInfo)
  {
    if (paramRedDotInfo == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder("redDotInfo2String, oidb_0x791.RedDotInfo:");
    localStringBuilder.append("uint32_appid:");
    localStringBuilder.append(paramRedDotInfo.uint32_appid.get());
    localStringBuilder.append("|redDotInfo.bool_display_reddot:");
    localStringBuilder.append(paramRedDotInfo.bool_display_reddot.get());
    localStringBuilder.append("|uint32_number:");
    localStringBuilder.append(paramRedDotInfo.uint32_number.get());
    localStringBuilder.append("|uint32_reason:");
    localStringBuilder.append(paramRedDotInfo.uint32_reason.get());
    localStringBuilder.append("|uint32_last_time:");
    localStringBuilder.append(paramRedDotInfo.uint32_last_time.get());
    localStringBuilder.append("|uint64_cmd_uin:");
    localStringBuilder.append(paramRedDotInfo.uint64_cmd_uin.get());
    localStringBuilder.append("|uint32_cmd_uin_type:");
    localStringBuilder.append(paramRedDotInfo.uint32_cmd_uin_type.get());
    localStringBuilder.append("|str_face_url:");
    localStringBuilder.append(paramRedDotInfo.str_face_url.get().toStringUtf8());
    localStringBuilder.append("|str_custom_buffer:");
    localStringBuilder.append(paramRedDotInfo.str_custom_buffer.get().toStringUtf8());
    localStringBuilder.append("|uint32_expire_time:");
    localStringBuilder.append(paramRedDotInfo.uint32_expire_time.get());
    return localStringBuilder.toString();
  }
  
  private Map<Long, oidb_0x791.RedDotInfo> a()
  {
    try
    {
      HashMap localHashMap = new HashMap();
      try
      {
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir();
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("TroopRedTouchManager2_All");
        ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        localObject2 = new JSONObject(new String(Base64Util.decode(FileUtils.fileToBytes(new File((File)localObject2, ((StringBuilder)localObject3).toString())), 0)));
        localObject3 = ((JSONObject)localObject2).keys();
        while (((Iterator)localObject3).hasNext())
        {
          String str2 = (String)((Iterator)localObject3).next();
          oidb_0x791.RedDotInfo localRedDotInfo = new oidb_0x791.RedDotInfo();
          localRedDotInfo.mergeFrom(Base64Util.decode((String)((JSONObject)localObject2).get(str2), 0));
          localHashMap.put(Long.valueOf(Long.parseLong(str2)), localRedDotInfo);
        }
        String str1;
        localObject1 = finally;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (QLog.isColorLevel())
        {
          str1 = this.c;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("getLocalRedInfoMsgList, size =");
          ((StringBuilder)localObject3).append(localHashMap.size());
          QLog.d(str1, 2, ((StringBuilder)localObject3).toString());
        }
        return localHashMap;
      }
      throw localObject1;
    }
    finally {}
    for (;;) {}
  }
  
  /* Error */
  private oidb_0x791.GetRedDotRes a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 73	com/tencent/biz/TroopRedpoint/TroopRedTouchManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6: invokevirtual 311	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   9: invokevirtual 317	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   12: astore_1
    //   13: new 141	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   20: astore_2
    //   21: aload_2
    //   22: ldc 44
    //   24: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_2
    //   29: aload_0
    //   30: getfield 73	com/tencent/biz/TroopRedpoint/TroopRedTouchManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   33: invokevirtual 320	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   36: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: new 322	java/io/File
    //   43: dup
    //   44: aload_1
    //   45: aload_2
    //   46: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokespecial 325	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   52: invokestatic 331	com/tencent/mobileqq/utils/FileUtils:fileToBytes	(Ljava/io/File;)[B
    //   55: astore_3
    //   56: new 84	tencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes
    //   59: dup
    //   60: invokespecial 380	tencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes:<init>	()V
    //   63: astore_1
    //   64: aload_1
    //   65: astore_2
    //   66: aload_3
    //   67: ifnull +44 -> 111
    //   70: aload_1
    //   71: aload_3
    //   72: invokevirtual 381	tencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   75: pop
    //   76: aload_1
    //   77: astore_2
    //   78: goto +33 -> 111
    //   81: astore_2
    //   82: goto +14 -> 96
    //   85: astore_2
    //   86: goto +19 -> 105
    //   89: astore_1
    //   90: goto +25 -> 115
    //   93: astore_2
    //   94: aconst_null
    //   95: astore_1
    //   96: aload_2
    //   97: invokevirtual 382	java/lang/NullPointerException:printStackTrace	()V
    //   100: aload_1
    //   101: astore_2
    //   102: goto +9 -> 111
    //   105: aload_2
    //   106: invokevirtual 383	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   109: aload_1
    //   110: astore_2
    //   111: aload_0
    //   112: monitorexit
    //   113: aload_2
    //   114: areturn
    //   115: aload_0
    //   116: monitorexit
    //   117: aload_1
    //   118: athrow
    //   119: astore_2
    //   120: aconst_null
    //   121: astore_1
    //   122: goto -17 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	TroopRedTouchManager
    //   12	65	1	localObject1	Object
    //   89	1	1	localObject2	Object
    //   95	27	1	localObject3	Object
    //   20	58	2	localObject4	Object
    //   81	1	2	localNullPointerException1	java.lang.NullPointerException
    //   85	1	2	localInvalidProtocolBufferMicroException1	InvalidProtocolBufferMicroException
    //   93	4	2	localNullPointerException2	java.lang.NullPointerException
    //   101	13	2	localObject5	Object
    //   119	1	2	localInvalidProtocolBufferMicroException2	InvalidProtocolBufferMicroException
    //   55	17	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   70	76	81	java/lang/NullPointerException
    //   70	76	85	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2	64	89	finally
    //   70	76	89	finally
    //   96	100	89	finally
    //   105	109	89	finally
    //   2	64	93	java/lang/NullPointerException
    //   2	64	119	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  private void a(oidb_0x791.GetRedDotRes paramGetRedDotRes)
  {
    if (paramGetRedDotRes == null) {
      return;
    }
    try
    {
      ThreadManager.post(new TroopRedTouchManager.3(this, paramGetRedDotRes), 5, null, false);
      return;
    }
    finally
    {
      paramGetRedDotRes = finally;
      throw paramGetRedDotRes;
    }
  }
  
  private boolean a(oidb_0x791.RedDotInfo paramRedDotInfo, int paramInt)
  {
    return (paramRedDotInfo.uint32_appid.get() == paramInt) && (paramRedDotInfo.bool_display_reddot.get()) && ((!paramRedDotInfo.uint32_expire_time.has()) || (paramRedDotInfo.uint32_expire_time.get() == 0) || (paramRedDotInfo.uint32_expire_time.get() >= NetConnInfoCenter.getServerTime()));
  }
  
  private void b()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.biz.TroopRedpoint.TroopRedTouchManager");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  private void b(Map<Long, oidb_0x791.RedDotInfo> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    try
    {
      if (QLog.isColorLevel())
      {
        String str = this.c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveLocalFileList, size =");
        localStringBuilder.append(paramMap.size());
        QLog.d(str, 2, localStringBuilder.toString());
      }
      ThreadManager.post(new TroopRedTouchManager.4(this, a(paramMap)), 5, null, false);
      return;
    }
    finally {}
  }
  
  private void b(oidb_0x791.RedDotInfo paramRedDotInfo)
  {
    if (paramRedDotInfo.str_custom_buffer.has())
    {
      paramRedDotInfo = paramRedDotInfo.str_custom_buffer.get().toStringUtf8();
      try
      {
        paramRedDotInfo = new JSONObject(paramRedDotInfo);
        if (paramRedDotInfo.optInt("is_web_care") == 1)
        {
          localObject = new Intent();
          ((Intent)localObject).setAction("com.tencent.mobileqq.NearbyJsInterface");
          ((Intent)localObject).putExtra("command_type", 2);
          ((Intent)localObject).putExtra("data", paramRedDotInfo.optString("web_red_dot_data"));
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast((Intent)localObject);
          return;
        }
      }
      catch (Exception paramRedDotInfo)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("get push for web: ");
        ((StringBuilder)localObject).append(paramRedDotInfo.getMessage());
        QLog.e("nearby.redpoint", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  private void c(oidb_0x791.RedDotInfo paramRedDotInfo)
  {
    if ((paramRedDotInfo.msg_nearby_entrance_extend_config.has()) && (paramRedDotInfo.msg_nearby_entrance_extend_config.bool_has_hintWord.has()) && (paramRedDotInfo.msg_nearby_entrance_extend_config.bool_has_hintWord.get()) && (paramRedDotInfo.msg_nearby_entrance_extend_config.str_hintWord.has())) {
      ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "key_nearby_red_dot_assist_text", paramRedDotInfo.msg_nearby_entrance_extend_config.str_hintWord.get().toStringUtf8());
    }
    if ((paramRedDotInfo.msg_word_corner_red_dot.has()) && (paramRedDotInfo.msg_word_corner_red_dot.bool_enable.has()) && (paramRedDotInfo.msg_word_corner_red_dot.bool_enable.get()) && (paramRedDotInfo.msg_word_corner_red_dot.bool_switch_to_word_corner.has()) && (paramRedDotInfo.msg_word_corner_red_dot.bool_switch_to_word_corner.get()) && (paramRedDotInfo.msg_word_corner_red_dot.str_hintText.has())) {
      ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "key_nearby_red_dot_corner_text", paramRedDotInfo.msg_word_corner_red_dot.str_hintText.get().toStringUtf8());
    }
  }
  
  private void d(oidb_0x791.RedDotInfo paramRedDotInfo)
  {
    if ((paramRedDotInfo.uint32_appid.get() == 60) && (paramRedDotInfo.str_custom_buffer.has()))
    {
      paramRedDotInfo = paramRedDotInfo.str_custom_buffer.get().toStringUtf8();
      try
      {
        paramRedDotInfo = new JSONObject(paramRedDotInfo);
        if (paramRedDotInfo.optInt("is_c2c") == 1)
        {
          ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "key_nearby_msg_box_say_hello_msg_type", Integer.valueOf(paramRedDotInfo.optInt("say_hello_red_dot_type")));
          return;
        }
      }
      catch (Exception paramRedDotInfo)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("get msgBoxSayHelloType error: ");
        localStringBuilder.append(paramRedDotInfo.getMessage());
        QLog.e("nearby.redpoint", 1, localStringBuilder.toString());
      }
    }
  }
  
  private void e(oidb_0x791.RedDotInfo paramRedDotInfo)
  {
    if ((paramRedDotInfo.uint32_appid.get() == 60) && (paramRedDotInfo.str_custom_buffer.has()))
    {
      paramRedDotInfo = paramRedDotInfo.str_custom_buffer.get().toStringUtf8();
      try
      {
        paramRedDotInfo = new JSONObject(paramRedDotInfo);
        if (paramRedDotInfo.optInt("is_comment") == 1)
        {
          ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "key_nearby_msg_box_comment_zan_msg_type", Integer.valueOf(paramRedDotInfo.optInt("comment_red_dot_type")));
          return;
        }
      }
      catch (Exception paramRedDotInfo)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("get msgBoxCommentZan error: ");
        localStringBuilder.append(paramRedDotInfo.getMessage());
        QLog.e("nearby.redpoint", 1, localStringBuilder.toString());
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
      this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = a();
    }
    Object localObject = this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes;
    int i = 0;
    if (localObject == null) {
      return 0;
    }
    int k;
    for (int j = 0; i < this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size(); j = k)
    {
      localObject = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(i);
      if (!((oidb_0x791.RedDotInfo)localObject).bool_display_reddot.get())
      {
        k = j;
      }
      else
      {
        boolean bool = SharedPreUtils.f(BaseApplicationImpl.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        k = j;
        if (((oidb_0x791.RedDotInfo)localObject).uint32_number.get() > 0)
        {
          k = j;
          if (7 == ((oidb_0x791.RedDotInfo)localObject).uint32_appid.get())
          {
            k = j;
            if (bool) {
              k = j + ((oidb_0x791.RedDotInfo)localObject).uint32_number.get();
            }
          }
        }
      }
      i += 1;
    }
    return j;
  }
  
  public int a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
      this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = a();
    }
    Object localObject = this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes;
    int j = 0;
    if (localObject != null)
    {
      if (paramQQAppInterface == null) {
        return 0;
      }
      boolean bool2 = ((INearbyConfigUtil)QRoute.api(INearbyConfigUtil.class)).isNewNearbyTab(paramQQAppInterface);
      boolean bool3 = a();
      boolean bool4 = paramQQAppInterface.mIsShowNewLeba ^ true;
      boolean bool1;
      if ((bool4) && (bool3)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramQQAppInterface = a(bool1);
      int i;
      if (paramQQAppInterface.getRedType() != -1)
      {
        i = paramQQAppInterface.getRedAppIdType();
        bool1 = true;
      }
      else
      {
        i = 0;
        bool1 = false;
      }
      paramQQAppInterface = new StringBuilder();
      int m;
      for (int k = 0; j < this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size(); k = m)
      {
        localObject = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(j);
        if (!((oidb_0x791.RedDotInfo)localObject).bool_display_reddot.get())
        {
          m = k;
        }
        else
        {
          int n = ((oidb_0x791.RedDotInfo)localObject).uint32_appid.get();
          if ((2 != n) && (3 != n) && (4 != n) && (5 != n))
          {
            m = k;
            if (TroopRedTouchConfigure.a((oidb_0x791.RedDotInfo)localObject))
            {
              m = k;
              if (!b()) {}
            }
          }
          else
          {
            m = k + 1;
            paramQQAppInterface.append(n);
            paramQQAppInterface.append(",");
          }
        }
        j += 1;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getLebaRedPoint, needShow=");
      ((StringBuilder)localObject).append(bool3);
      ((StringBuilder)localObject).append(", isNewTab=");
      ((StringBuilder)localObject).append(bool2);
      ((StringBuilder)localObject).append(", redType=");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", isNearbyRedPoint=");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append(", isNearbyEntryShow=");
      ((StringBuilder)localObject).append(bool4);
      ((StringBuilder)localObject).append(", redPointNums=");
      ((StringBuilder)localObject).append(k);
      ((StringBuilder)localObject).append(", appId=");
      ((StringBuilder)localObject).append(paramQQAppInterface.toString());
      QLog.d("nearby.redpoint", 1, ((StringBuilder)localObject).toString());
      return k;
    }
    return 0;
  }
  
  public INearbyRedInfo a(boolean paramBoolean)
  {
    try
    {
      INearbyRedInfo localINearbyRedInfo = a(paramBoolean, true);
      return localINearbyRedInfo;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public INearbyRedInfo a(boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject5 = (TroopRedTouchManager)((QQAppInterface)localObject2).getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
      localRedTypeInfo1 = ((TroopRedTouchManager)localObject5).a();
      localINearbyRedInfo = (INearbyRedInfo)QRoute.api(INearbyRedInfo.class);
      if (!paramBoolean1) {
        break label1139;
      }
      if (!((INearbyConfigUtil)QRoute.api(INearbyConfigUtil.class)).isNewNearbyTab((AppInterface)localObject2)) {
        break label995;
      }
      localObject3 = (String)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(((QQAppInterface)localObject2).getCurrentAccountUin(), "key_nearby_red_dot_corner_text", "");
      localObject4 = (String)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(((QQAppInterface)localObject2).getCurrentAccountUin(), "key_nearby_red_dot_assist_text", "");
      if ((!TextUtils.isEmpty((CharSequence)localObject3)) || (!TextUtils.isEmpty((CharSequence)localObject4))) {
        break label963;
      }
      localObject3 = ((TroopRedTouchManager)localObject5).b();
      localObject4 = ((TroopRedTouchManager)localObject5).j();
      localRedTypeInfo2 = ((TroopRedTouchManager)localObject5).l();
      localRedTypeInfo3 = ((TroopRedTouchManager)localObject5).k();
      localObject6 = ((TroopRedTouchManager)localObject5).b();
      localArrayList = ((TroopRedTouchManager)localObject5).a();
      d();
      ((TroopRedTouchManager)localObject5).e();
      f();
      localRedTypeInfo4 = ((TroopRedTouchManager)localObject5).g();
      localRedTypeInfo5 = ((TroopRedTouchManager)localObject5).h();
      localObject5 = ((TroopRedTouchManager)localObject5).i();
      if ((localObject6 == null) || (((ArrayList)localObject6).size() <= 0)) {
        break label1176;
      }
      localINearbyRedInfo.setRedType(5);
      localINearbyRedInfo.addRedNum(((ArrayList)localObject6).size());
      j = 56;
    }
    finally
    {
      for (;;)
      {
        Object localObject2;
        Object localObject5;
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo1;
        INearbyRedInfo localINearbyRedInfo;
        Object localObject3;
        Object localObject4;
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo2;
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo3;
        Object localObject6;
        ArrayList localArrayList;
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo4;
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo5;
        for (;;)
        {
          label963:
          label995:
          label1139:
          label1150:
          throw localObject1;
        }
        label1176:
        int j = 0;
        continue;
        label1182:
        int k = 2;
        int i = j;
        j = k;
        continue;
        j = 1;
        continue;
        label1201:
        int m = j;
        if (i == 0)
        {
          k = 38;
        }
        else
        {
          label1216:
          k = i;
          j = m;
          continue;
          label1226:
          i = 0;
          j = k;
          break label1245;
          label1235:
          k = j;
          j = i;
          i = k;
          label1245:
          k = i;
          i = j;
          paramBoolean1 = true;
          j = k;
          continue;
          label1260:
          paramBoolean1 = false;
          j = 1;
          continue;
          label1268:
          j = 0;
          paramBoolean1 = false;
          i = 0;
        }
      }
    }
    i = j;
    if (localArrayList != null)
    {
      i = j;
      if (localArrayList.size() > 0)
      {
        i = j;
        if (((INearbyConfigUtil)QRoute.api(INearbyConfigUtil.class)).hasNearbyMsgTab((AppInterface)localObject2))
        {
          localINearbyRedInfo.setRedType(5);
          localINearbyRedInfo.addRedNum(localArrayList.size());
          i = 61;
        }
      }
    }
    if (((INearbyConfigUtil)QRoute.api(INearbyConfigUtil.class)).hasNearbyMsgTab((AppInterface)localObject2))
    {
      if (QLog.isColorLevel())
      {
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append("in memory nearbyMsgBoxUnReadNum=");
        ((StringBuilder)localObject6).append(this.jdField_a_of_type_Int);
        QLog.d("nearby.redpoint", 2, ((StringBuilder)localObject6).toString());
      }
      if (paramBoolean2) {
        ThreadManager.post(new TroopRedTouchManager.2(this, (QQAppInterface)localObject2), 8, null, false);
      } else {
        this.jdField_a_of_type_Int = MsgBoxListActivity.getNearbyMsgBoxUnReadNum((QQAppInterface)localObject2, AppConstants.NEARBY_LBS_HELLO_UIN, true);
      }
      j = this.jdField_a_of_type_Int;
      if (j > 0)
      {
        localINearbyRedInfo.setRedType(5);
        localINearbyRedInfo.addRedNum(j);
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append("addRedNum:");
        ((StringBuilder)localObject6).append(j);
        ((StringBuilder)localObject6).append(", total=");
        ((StringBuilder)localObject6).append(localINearbyRedInfo.getRedNum());
        ((StringBuilder)localObject6).append(", type=");
        ((StringBuilder)localObject6).append(60);
        QLog.d("nearby.redpoint", 1, ((StringBuilder)localObject6).toString());
        j = i;
        if (i == 0)
        {
          j = 60;
          break label1182;
          m = j;
          if (localObject4 == null) {
            break label1216;
          }
          m = j;
          if (!((INearbyConfigUtil)QRoute.api(INearbyConfigUtil.class)).hasEnterItem((AppInterface)localObject2, 1)) {
            break label1216;
          }
          if (((BusinessInfoCheckUpdate.RedTypeInfo)localObject4).red_type.get() == 0)
          {
            localINearbyRedInfo.setRedType(0);
            break label1201;
          }
          if (((BusinessInfoCheckUpdate.RedTypeInfo)localObject4).red_type.get() != 5) {
            break label1201;
          }
          localINearbyRedInfo.setRedType(5);
          localINearbyRedInfo.addRedNum(((BusinessInfoCheckUpdate.RedTypeInfo)localObject4).red_content.get());
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("addRedNum:");
          ((StringBuilder)localObject6).append(((BusinessInfoCheckUpdate.RedTypeInfo)localObject4).red_content.get());
          ((StringBuilder)localObject6).append(", total=");
          ((StringBuilder)localObject6).append(localINearbyRedInfo.getRedNum());
          ((StringBuilder)localObject6).append(", type=");
          ((StringBuilder)localObject6).append(38);
          QLog.d("nearby.redpoint", 1, ((StringBuilder)localObject6).toString());
          j = 2;
          break label1201;
          if ((localRedTypeInfo2 != null) && (localRedTypeInfo2.red_type.get() == 5))
          {
            localINearbyRedInfo.setRedType(5);
            localINearbyRedInfo.addRedNum(localRedTypeInfo2.red_content.get());
            SharedPreUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
          }
          i = k;
          if (k != 0) {
            break label1235;
          }
          if (this.jdField_a_of_type_Int == -1)
          {
            localINearbyRedInfo.setRedType(0);
            i = 2;
            j = 60;
            break label1245;
          }
          if ((localRedTypeInfo1 != null) && (((INearbyConfigUtil)QRoute.api(INearbyConfigUtil.class)).hasEnterItem((AppInterface)localObject2, 2)))
          {
            localINearbyRedInfo.setRedType(0);
            i = j;
            j = 25;
            break label1245;
          }
          if ((localObject3 != null) && (((INearbyConfigUtil)QRoute.api(INearbyConfigUtil.class)).hasEnterItem((AppInterface)localObject2, 3)))
          {
            i = 23;
            localINearbyRedInfo.setRedType(0);
            break label1235;
          }
          if (localRedTypeInfo3 != null)
          {
            localINearbyRedInfo.setRedType(0);
            i = 42;
            break label1235;
          }
          if (localRedTypeInfo4 != null)
          {
            localINearbyRedInfo.setRedType(0);
            i = 53;
            break label1235;
          }
          if (localRedTypeInfo5 != null)
          {
            localINearbyRedInfo.setRedType(0);
            i = 54;
            break label1235;
          }
          if (localObject5 == null) {
            break label1226;
          }
          localINearbyRedInfo.setRedType(0);
          i = 70;
          break label1235;
          localINearbyRedInfo.setRedType(11);
          localINearbyRedInfo.setCornerInfo((String)localObject3);
          localINearbyRedInfo.setTipTextInfo((String)localObject4);
          return localINearbyRedInfo;
          if (((TroopRedTouchManager)localObject5).c() != null)
          {
            localINearbyRedInfo.setRedType(0);
            i = 24;
            break label1260;
          }
          if ((localRedTypeInfo1 == null) || (!((INearbyConfigUtil)QRoute.api(INearbyConfigUtil.class)).isOldEnterHasItem(localObject2, 1001))) {
            break label1268;
          }
          localINearbyRedInfo.setRedType(0);
          i = 25;
          break label1260;
          localINearbyRedInfo.setRedPointReportType(j);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getNearbyRedPoint, needShow, isNewTab=");
          ((StringBuilder)localObject2).append(paramBoolean1);
          ((StringBuilder)localObject2).append(", redType=");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(", redInfo=");
          ((StringBuilder)localObject2).append(localINearbyRedInfo);
          QLog.d("nearby.redpoint", 1, ((StringBuilder)localObject2).toString());
          break label1150;
          i = 0;
          QLog.d("nearby.redpoint", 1, "getNearbyRedPoint, don't needShow");
          localINearbyRedInfo.setRedAppIdType(i);
          return localINearbyRedInfo;
        }
      }
    }
  }
  
  public NearbyRedNum a()
  {
    for (;;)
    {
      try
      {
        localNearbyRedNum = new NearbyRedNum();
        if (this.jdField_a_of_type_JavaUtilMap == null) {
          this.jdField_a_of_type_JavaUtilMap = a();
        }
        i = this.jdField_a_of_type_JavaUtilMap.size();
        if (i <= 0) {
          return localNearbyRedNum;
        }
        Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
        if (!localIterator.hasNext()) {
          continue;
        }
        localObject2 = (oidb_0x791.RedDotInfo)((Map.Entry)localIterator.next()).getValue();
        if (((oidb_0x791.RedDotInfo)localObject2).uint32_appid.get() != 38) {
          continue;
        }
        str = ((oidb_0x791.RedDotInfo)localObject2).str_custom_buffer.get().toStringUtf8();
      }
      finally
      {
        NearbyRedNum localNearbyRedNum;
        Object localObject2;
        String str;
        continue;
        throw localObject1;
        continue;
        int i = 0;
        continue;
      }
      try
      {
        localNearbyRedNum.jdField_a_of_type_Int = ((oidb_0x791.RedDotInfo)localObject2).uint32_number.get();
        localObject2 = new JSONObject(str);
        if (((JSONObject)localObject2).optInt("official_topic") != 1) {
          continue;
        }
        i = 1;
        if (i != 0) {
          localNearbyRedNum.b += 1;
        }
        i = ((JSONObject)localObject2).optInt("red_content_type");
        if (i == 1) {
          localNearbyRedNum.c += 1;
        } else if (i == 2) {
          localNearbyRedNum.d += 1;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return localNearbyRedNum;
  }
  
  public NearbyRedNum a(int paramInt)
  {
    try
    {
      NearbyRedNum localNearbyRedNum = new NearbyRedNum();
      if (this.jdField_a_of_type_JavaUtilMap == null) {
        this.jdField_a_of_type_JavaUtilMap = a();
      }
      int i = this.jdField_a_of_type_JavaUtilMap.size();
      if (i <= 0) {
        return localNearbyRedNum;
      }
      i = 0;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        oidb_0x791.RedDotInfo localRedDotInfo = (oidb_0x791.RedDotInfo)((Map.Entry)localIterator.next()).getValue();
        if (a(localRedDotInfo, paramInt)) {
          i += localRedDotInfo.uint32_number.get();
        }
      }
      localNearbyRedNum.jdField_a_of_type_Int = i;
      return localNearbyRedNum;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo a()
  {
    if (a(25) != null)
    {
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(0);
      localRedTypeInfo.red_content.set("");
      localRedTypeInfo.red_desc.set("");
      return localRedTypeInfo;
    }
    return null;
  }
  
  public String a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      this.jdField_a_of_type_JavaUtilMap = a();
    }
    int i = this.jdField_a_of_type_JavaUtilMap.size();
    String str = "";
    if (i <= 0) {
      return "";
    }
    Object localObject1 = Long.valueOf(0L);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      if (((Long)localObject1).longValue() <= ((Long)((Map.Entry)localObject2).getKey()).longValue())
      {
        oidb_0x791.RedDotInfo localRedDotInfo = (oidb_0x791.RedDotInfo)((Map.Entry)localObject2).getValue();
        if (a(localRedDotInfo, paramInt))
        {
          localObject2 = (Long)((Map.Entry)localObject2).getKey();
          localObject1 = localObject2;
          if (localRedDotInfo.has())
          {
            str = localRedDotInfo.str_custom_buffer.get().toStringUtf8();
            localObject1 = localObject2;
          }
        }
      }
    }
    return str;
  }
  
  public String a(String paramString, long paramLong, INearbyRedDotCustomInfo paramINearbyRedDotCustomInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("faceUrl", paramString);
      localJSONObject.put("uin", paramLong);
      localJSONObject.put("isOfficialNotify", paramINearbyRedDotCustomInfo.getIsOfficialNotify());
      localJSONObject.put("redContentType", paramINearbyRedDotCustomInfo.getContentType());
      localJSONObject.put("redContentMsg", paramINearbyRedDotCustomInfo.getContentMsg());
      localJSONObject.put("topicId", paramINearbyRedDotCustomInfo.getTopicId());
      localJSONObject.put("msgId", paramINearbyRedDotCustomInfo.getRecommendPeopleMsgId());
      localJSONObject.put("userType", paramINearbyRedDotCustomInfo.getUserType());
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return localJSONObject.toString();
  }
  
  public ArrayList<oidb_0x791.RedDotInfo> a()
  {
    try
    {
      if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
        this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = a();
      }
      Object localObject1 = this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes;
      if (localObject1 == null) {
        return null;
      }
      localObject1 = new ArrayList();
      int i = 0;
      while (i < this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size())
      {
        oidb_0x791.RedDotInfo localRedDotInfo = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(i);
        localRedDotInfo.uint32_number.get();
        boolean bool = localRedDotInfo.bool_display_reddot.get();
        localRedDotInfo.uint64_cmd_uin.get();
        String str = localRedDotInfo.str_face_url.get().toStringUtf8();
        if ((61 == localRedDotInfo.uint32_appid.get()) && (bool) && (!TextUtils.isEmpty(str))) {
          ((ArrayList)localObject1).add(localRedDotInfo);
        }
        i += 1;
      }
      return localObject1;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public oidb_0x791.RedDotInfo a()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
          this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = a();
        }
        localObject1 = this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes;
        if (localObject1 == null) {
          return null;
        }
        bool1 = ((MsgTabStoryNodeConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MSG_TAB_STORY_CONFIG_MANAGER)).jdField_a_of_type_Boolean;
        bool2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNowLiveManager().jdField_a_of_type_Boolean;
        localIterator = this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get().iterator();
        localObject1 = null;
      }
      finally
      {
        Object localObject1;
        boolean bool1;
        boolean bool2;
        Iterator localIterator;
        Object localObject3;
        int i;
        continue;
        throw localObject2;
        continue;
        if (((i == 37) && (bool2)) || (i == 48)) {
          continue;
        }
        if ((bool1) || (i != 28)) {
          continue;
        }
        continue;
      }
      if (!localIterator.hasNext()) {
        continue;
      }
      localObject3 = (oidb_0x791.RedDotInfo)localIterator.next();
      if (((oidb_0x791.RedDotInfo)localObject3).bool_display_reddot.get())
      {
        i = ((oidb_0x791.RedDotInfo)localObject3).uint32_appid.get();
        if (TroopRedTouchConfigure.b(i))
        {
          if ((i != 37) || (((oidb_0x791.RedDotInfo)localObject3).uint32_expire_time.get() >= NetConnInfoCenter.getServerTime())) {
            continue;
          }
          SLog.d(this.c, "%d red dot time out", new Object[] { Integer.valueOf(i) });
          continue;
          if (((i != RedPointUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (((oidb_0x791.RedDotInfo)localObject3).uint32_number.get() > 0)) && (TroopRedTouchConfigure.a((oidb_0x791.RedDotInfo)localObject3, (oidb_0x791.RedDotInfo)localObject1) > 0)) {
            localObject1 = localObject3;
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("return:");
      ((StringBuilder)localObject3).append(a((oidb_0x791.RedDotInfo)localObject1));
      QLog.d("Q.qqstory.redPoint", 2, ((StringBuilder)localObject3).toString());
    }
    return null;
  }
  
  public oidb_0x791.RedDotInfo a(int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
        this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = a();
      }
      Object localObject3 = null;
      Object localObject1 = this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes;
      if (localObject1 == null) {
        return null;
      }
      int i = 0;
      for (;;)
      {
        localObject1 = localObject3;
        if (i >= this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size()) {
          break;
        }
        localObject1 = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(i);
        if (paramInt == ((oidb_0x791.RedDotInfo)localObject1).uint32_appid.get())
        {
          boolean bool = ((oidb_0x791.RedDotInfo)localObject1).bool_display_reddot.get();
          if (bool) {
            break;
          }
        }
        i += 1;
      }
      return localObject1;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public oidb_0x791.RedDotInfo a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
      this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = a();
    }
    if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
      return null;
    }
    int i = 0;
    while (i < this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size())
    {
      oidb_0x791.RedDotInfo localRedDotInfo = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(i);
      if ((paramInt == localRedDotInfo.uint32_appid.get()) && ((!paramBoolean) || (localRedDotInfo.bool_display_reddot.get()))) {
        return localRedDotInfo;
      }
      i += 1;
    }
    return null;
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
        this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = a();
      }
      localObject1 = this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes;
      if (localObject1 == null) {
        return;
      }
      localObject1 = new StringBuilder("clearStoryWeakRedPoint==>");
      i = this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size() - 1;
    }
    finally
    {
      for (;;)
      {
        Object localObject1;
        int i;
        Object localObject3;
        for (;;)
        {
          throw localObject2;
        }
        i -= 1;
      }
    }
    if (i >= 0)
    {
      localObject3 = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(i);
      if ((((oidb_0x791.RedDotInfo)localObject3).bool_display_reddot.get()) && (TroopRedTouchConfigure.a(((oidb_0x791.RedDotInfo)localObject3).uint32_appid.get())))
      {
        this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.remove(i);
        TroopRedTouchHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (oidb_0x791.RedDotInfo)localObject3);
        ((StringBuilder)localObject1).append(a((oidb_0x791.RedDotInfo)localObject3));
        ((StringBuilder)localObject1).append("|");
      }
    }
    else
    {
      a(this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes);
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNowLiveManager().jdField_a_of_type_Boolean)
      {
        localObject3 = (ILebaHelperService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ILebaHelperService.class, "");
        if (localObject3 != null) {
          ((ILebaHelperService)localObject3).setFlagUpdateOnPause();
        } else {
          QLog.d(this.c, 1, "clearStoryWeakRedPoint lebaHelperService == null");
        }
      }
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(this.c);
        ((StringBuilder)localObject3).append("Q.qqstory.redPoint");
        QLog.d(((StringBuilder)localObject3).toString(), 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
  }
  
  public void a(int paramInt)
  {
    try
    {
      if ((this.jdField_a_of_type_JavaUtilMap != null) && (this.jdField_a_of_type_JavaUtilMap.size() > 0))
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
        while (localIterator.hasNext()) {
          if (((oidb_0x791.RedDotInfo)((Map.Entry)localIterator.next()).getValue()).uint32_appid.get() == paramInt) {
            localIterator.remove();
          }
        }
        b(this.jdField_a_of_type_JavaUtilMap);
        return;
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void a(Map<Long, oidb_0x791.RedDotInfo> paramMap)
  {
    try
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = this.c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setAllRedDotMsgInfo: listRedDotInfo size = ");
        int i;
        if (paramMap == null) {
          i = 0;
        } else {
          i = paramMap.size();
        }
        localStringBuilder.append(i);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      if (this.jdField_a_of_type_JavaUtilMap == null) {
        this.jdField_a_of_type_JavaUtilMap = a();
      }
      if ((this.jdField_a_of_type_JavaUtilMap != null) && (paramMap != null))
      {
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          localObject = (Map.Entry)paramMap.next();
          this.jdField_a_of_type_JavaUtilMap.put(((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
        }
        b(this.jdField_a_of_type_JavaUtilMap);
        return;
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramMap;
    }
  }
  
  public void a(oidb_0x791.RedDotInfo paramRedDotInfo)
  {
    try
    {
      if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
        this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = a();
      }
      if ((this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) || (paramRedDotInfo == null)) {
        break label344;
      }
      k = paramRedDotInfo.uint32_appid.get();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("set：appId=");
        ((StringBuilder)localObject).append(k);
        ((StringBuilder)localObject).append(", uin=");
        ((StringBuilder)localObject).append(paramRedDotInfo.uint64_cmd_uin.get());
        ((StringBuilder)localObject).append(", hasRed=");
        ((StringBuilder)localObject).append(paramRedDotInfo.bool_display_reddot.get());
        QLog.d("nearby.redpoint", 2, ((StringBuilder)localObject).toString());
      }
      c(paramRedDotInfo);
      d(paramRedDotInfo);
      e(paramRedDotInfo);
      b(paramRedDotInfo);
      i = 0;
    }
    finally
    {
      for (;;)
      {
        int k;
        Object localObject;
        int m;
        int j;
        for (;;)
        {
          label344:
          throw paramRedDotInfo;
        }
        label358:
        i += 1;
        continue;
        int i = 0;
      }
    }
    m = this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size();
    j = 1;
    if (i < m)
    {
      localObject = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(i);
      if (((oidb_0x791.RedDotInfo)localObject).uint32_appid.get() == k)
      {
        if ((k != 56) && (k != 61))
        {
          this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.set(i, paramRedDotInfo);
          i = j;
        }
        else
        {
          if (((oidb_0x791.RedDotInfo)localObject).uint64_cmd_uin.get() != paramRedDotInfo.uint64_cmd_uin.get()) {
            break label358;
          }
          this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.set(i, paramRedDotInfo);
          i = j;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("APPID_NEARBY_CONCERN_UPDATE, onPush：has same uin reddot, uin=");
            ((StringBuilder)localObject).append(paramRedDotInfo.uint64_cmd_uin.get());
            QLog.d("nearby.redpoint", 2, ((StringBuilder)localObject).toString());
            i = j;
          }
        }
        if (i == 0) {
          this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.add(paramRedDotInfo);
        }
        a(this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes);
        return;
        return;
      }
    }
  }
  
  public void a(oidb_0x791.RedDotInfo paramRedDotInfo1, oidb_0x791.RedDotInfo paramRedDotInfo2)
  {
    int i;
    if ((paramRedDotInfo1 != null) && (paramRedDotInfo1.uint32_last_time.has())) {
      i = paramRedDotInfo1.uint32_last_time.get();
    } else {
      i = 0;
    }
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.c;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("TENCENT_DOCS_ASSISTANT  show redDot");
      ((StringBuilder)localObject2).append(paramRedDotInfo2.bool_display_reddot.get());
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject3;
    if (!paramRedDotInfo2.bool_display_reddot.get())
    {
      localObject2 = "";
      localObject3 = null;
      if (paramRedDotInfo1 == null) {
        break label364;
      }
    }
    for (;;)
    {
      try
      {
        if (!paramRedDotInfo1.str_custom_buffer.has()) {
          break label364;
        }
        paramRedDotInfo1 = paramRedDotInfo1.str_custom_buffer.get().toStringUtf8();
        boolean bool = TextUtils.isEmpty(paramRedDotInfo1);
        int j = i;
        localObject1 = localObject2;
        if (!bool)
        {
          JSONObject localJSONObject = new JSONObject(paramRedDotInfo1);
          if (localJSONObject.has("lastMsg"))
          {
            paramRedDotInfo1 = localJSONObject.getString("lastMsg");
          }
          else
          {
            paramRedDotInfo1 = (oidb_0x791.RedDotInfo)localObject2;
            if (localJSONObject.has("msg")) {
              paramRedDotInfo1 = localJSONObject.getString("msg");
            }
          }
          j = i;
          localObject1 = paramRedDotInfo1;
          if (localJSONObject.has("lastTime"))
          {
            j = localJSONObject.getInt("lastTime");
            localObject1 = paramRedDotInfo1;
          }
        }
        paramRedDotInfo1 = localObject3;
        if (paramRedDotInfo2.str_custom_buffer.has()) {
          paramRedDotInfo1 = paramRedDotInfo2.str_custom_buffer.get().toStringUtf8();
        }
        if (!TextUtils.isEmpty(paramRedDotInfo1)) {
          paramRedDotInfo1 = new JSONObject(paramRedDotInfo1);
        } else {
          paramRedDotInfo1 = new JSONObject();
        }
        paramRedDotInfo1.put("lastMsg", localObject1);
        paramRedDotInfo1.put("lastTime", j);
        paramRedDotInfo1 = paramRedDotInfo1.toString();
        paramRedDotInfo2.str_custom_buffer.set(ByteStringMicro.copyFromUtf8(paramRedDotInfo1));
        return;
      }
      catch (Exception localException)
      {
        continue;
      }
      paramRedDotInfo1 = this.c;
      paramRedDotInfo2 = new StringBuilder();
      paramRedDotInfo2.append("parse tencentDocs redDot info error");
      paramRedDotInfo2.append(((Exception)localObject1).getMessage());
      QLog.e(paramRedDotInfo1, 1, paramRedDotInfo2.toString());
      return;
      label364:
      paramRedDotInfo1 = null;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setNearbyRedState, show=");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.d("nearby.redpoint", 1, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (!paramBoolean) {
      ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).clearCornerRedDot((String)localObject);
    }
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("troop_nearby_red_point_state_");
    localStringBuilder.append((String)localObject);
    localEditor.putBoolean(localStringBuilder.toString(), paramBoolean);
    localEditor.commit();
  }
  
  public boolean a()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("troop_nearby_red_point_state_");
    localStringBuilder.append(str);
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), true);
  }
  
  public boolean a(List<Integer> paramList, oidb_0x791.GetRedDotRes paramGetRedDotRes)
  {
    try
    {
      m = paramGetRedDotRes.rpt_msg_reddot_info.size();
      j = 0;
      bool = false;
    }
    finally
    {
      for (;;)
      {
        int m;
        int j;
        oidb_0x791.RedDotInfo localRedDotInfo;
        Object localObject1;
        int k;
        int i;
        Object localObject2;
        StringBuilder localStringBuilder;
        for (;;)
        {
          throw paramList;
        }
        label808:
        boolean bool = true;
        label814:
        if (k != 56) {
          if (k == 61)
          {
            continue;
            label831:
            i = 0;
            break label838;
            label836:
            i = 1;
            label838:
            k = 0;
            break label856;
            label844:
            i += 1;
            continue;
            label851:
            k = 1;
            i = 0;
            label856:
            if ((k == 0) && (i == 0))
            {
              label868:
              j += 1;
              continue;
              label877:
              i += 1;
            }
          }
        }
      }
    }
    if (j < m)
    {
      localRedDotInfo = (oidb_0x791.RedDotInfo)paramGetRedDotRes.rpt_msg_reddot_info.get(j);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("setAllRedDot：appId=");
        ((StringBuilder)localObject1).append(localRedDotInfo.uint32_appid.get());
        ((StringBuilder)localObject1).append(", uin=");
        ((StringBuilder)localObject1).append(localRedDotInfo.uint64_cmd_uin.get());
        ((StringBuilder)localObject1).append(", hasRed=");
        ((StringBuilder)localObject1).append(localRedDotInfo.bool_display_reddot.get());
        QLog.d("nearby.redpoint", 2, ((StringBuilder)localObject1).toString());
      }
      paramList.remove(Integer.valueOf(localRedDotInfo.uint32_appid.get()));
      if (TroopRedTouchConfigure.c(localRedDotInfo.uint32_appid.get())) {
        break label868;
      }
      k = this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size();
      i = 0;
      if (i >= k) {
        break label851;
      }
      localObject1 = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(i);
      if (((oidb_0x791.RedDotInfo)localObject1).uint32_appid.get() != localRedDotInfo.uint32_appid.get()) {
        break label844;
      }
      k = localRedDotInfo.uint32_appid.get();
      if ((TroopRedTouchConfigure.b(k)) || (TroopRedTouchConfigure.c(k))) {
        break label814;
      }
      if (k == 46)
      {
        a((oidb_0x791.RedDotInfo)localObject1, localRedDotInfo);
        this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.set(i, localRedDotInfo);
      }
      else
      {
        this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.set(i, localRedDotInfo);
        break label808;
        if (localRedDotInfo.uint32_last_time.get() <= ((oidb_0x791.RedDotInfo)localObject1).uint32_last_time.get()) {
          break label831;
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.c);
          ((StringBuilder)localObject2).append("Q.qqstory.redPoint");
          localObject2 = ((StringBuilder)localObject2).toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("网络红点比本地红点新，netRedPoint：");
          localStringBuilder.append(a(localRedDotInfo));
          localStringBuilder.append("|localRedPoint:");
          localStringBuilder.append(a((oidb_0x791.RedDotInfo)localObject1));
          QLog.d((String)localObject2, 2, localStringBuilder.toString());
        }
        this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.set(i, localRedDotInfo);
        if (TroopRedTouchConfigure.c(k))
        {
          a(true);
          break label808;
          if (((oidb_0x791.RedDotInfo)localObject1).uint64_cmd_uin.get() != localRedDotInfo.uint64_cmd_uin.get()) {
            break label836;
          }
          if (localRedDotInfo.uint32_last_time.get() <= ((oidb_0x791.RedDotInfo)localObject1).uint32_last_time.get()) {
            break label831;
          }
          this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.set(i, localRedDotInfo);
          a(true);
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("APPID_NEARBY_CONCERN_UPDATE, setAllRedDot：has same uin reddot, uin=");
            ((StringBuilder)localObject1).append(localRedDotInfo.uint64_cmd_uin.get());
            QLog.d("nearby.redpoint", 2, ((StringBuilder)localObject1).toString());
            break label808;
            this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.add(localRedDotInfo);
            bool = true;
            break label868;
          }
        }
      }
    }
    else
    {
      j = this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size();
      i = 0;
      if (i < j)
      {
        paramGetRedDotRes = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(i);
        if (!paramList.contains(Integer.valueOf(paramGetRedDotRes.uint32_appid.get()))) {
          break label877;
        }
        paramGetRedDotRes.bool_display_reddot.set(false);
        paramGetRedDotRes.uint32_number.set(0);
        paramGetRedDotRes.uint32_reason.set(0);
        paramGetRedDotRes.uint64_cmd_uin.set(0L);
        paramGetRedDotRes.str_face_url.set(ByteStringMicro.EMPTY);
        paramGetRedDotRes.str_custom_buffer.set(ByteStringMicro.EMPTY);
        paramGetRedDotRes.uint32_expire_time.set(0);
        paramGetRedDotRes.uint32_cmd_uin_type.set(0);
        paramGetRedDotRes.uint32_report_type.set(0);
        bool = true;
        break label877;
      }
      if (bool) {
        a(this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes);
      }
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append(this.c);
        paramList.append("Q.qqstory.redPoint");
        paramList = paramList.toString();
        paramGetRedDotRes = new StringBuilder();
        paramGetRedDotRes.append("setAll==>拉回来的红点数据与本地的做对比，对比uint32_last_time, reult:");
        paramGetRedDotRes.append(bool);
        QLog.d(paramList, 2, paramGetRedDotRes.toString());
      }
      return bool;
    }
  }
  
  public boolean a(boolean paramBoolean, int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    Object localObject2;
    oidb_0x791.RedDotInfo localRedDotInfo;
    StringBuilder localStringBuilder;
    label285:
    try
    {
      localObject2 = a(paramInt3);
      if (localObject2 == null) {
        return false;
      }
      localRedDotInfo = new oidb_0x791.RedDotInfo();
    }
    finally {}
    try
    {
      localRedDotInfo.mergeFrom(((oidb_0x791.RedDotInfo)localObject2).toByteArray());
      if (localRedDotInfo.uint32_last_time.get() > paramInt2)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.c);
          ((StringBuilder)localObject2).append("Q.qqstory.redPoint");
          localObject2 = ((StringBuilder)localObject2).toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("result is out of date, current:");
          localStringBuilder.append(paramInt2);
          localStringBuilder.append(", last:");
          localStringBuilder.append(localRedDotInfo.uint32_last_time.get());
          QLog.d((String)localObject2, 2, localStringBuilder.toString());
        }
        return false;
      }
      localRedDotInfo.bool_display_reddot.set(paramBoolean);
      localRedDotInfo.uint32_number.set(paramInt1);
      localRedDotInfo.uint64_cmd_uin.set(paramLong);
      localRedDotInfo.uint32_last_time.set(paramInt2);
      a(localRedDotInfo);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.c);
        ((StringBuilder)localObject2).append("Q.qqstory.redPoint");
        localObject2 = ((StringBuilder)localObject2).toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateStoryMessageRedPoint==>");
        localStringBuilder.append(a(localRedDotInfo));
        QLog.d((String)localObject2, 2, localStringBuilder.toString());
      }
      return true;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      break label285;
    }
    return false;
  }
  
  public int b()
  {
    oidb_0x791.RedDotInfo localRedDotInfo = a();
    if (localRedDotInfo == null) {
      return 0;
    }
    int i = localRedDotInfo.uint32_appid.get();
    if (i != 8)
    {
      if (i != 11)
      {
        if (i != 35)
        {
          if (i != 37)
          {
            if (i != 52) {
              return 0;
            }
            return 3;
          }
          return 8;
        }
        return 2;
      }
      return 4;
    }
    return 1;
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo b()
  {
    Object localObject = a(23);
    oidb_0x791.RedDotInfo localRedDotInfo = a(26);
    if (((localObject != null) && (((oidb_0x791.RedDotInfo)localObject).bool_display_reddot.get())) || ((localRedDotInfo != null) && (localRedDotInfo.bool_display_reddot.get())))
    {
      localObject = new BusinessInfoCheckUpdate.RedTypeInfo();
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_type.set(0);
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_content.set("");
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_desc.set("");
      return localObject;
    }
    return null;
  }
  
  public ArrayList<oidb_0x791.RedDotInfo> b()
  {
    try
    {
      if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
        this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = a();
      }
      Object localObject1 = this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes;
      if (localObject1 == null) {
        return null;
      }
      localObject1 = new ArrayList();
      int i = 0;
      while (i < this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size())
      {
        oidb_0x791.RedDotInfo localRedDotInfo = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(i);
        localRedDotInfo.uint32_number.get();
        boolean bool = localRedDotInfo.bool_display_reddot.get();
        localRedDotInfo.uint64_cmd_uin.get();
        String str = localRedDotInfo.str_face_url.get().toStringUtf8();
        if ((56 == localRedDotInfo.uint32_appid.get()) && (bool) && (!TextUtils.isEmpty(str))) {
          ((ArrayList)localObject1).add(localRedDotInfo);
        }
        i += 1;
      }
      return localObject1;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void b(int paramInt)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("clearStoryRedPointByAppId：appId=");
        ((StringBuilder)localObject1).append(paramInt);
        QLog.d("nearby.redpoint", 2, ((StringBuilder)localObject1).toString());
      }
      if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
        this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = a();
      }
      localObject1 = this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes;
      if (localObject1 == null) {
        return;
      }
      localStringBuilder = new StringBuilder("clearStoryRedPointByAppId==>[");
      if (paramInt != 38) {
        break label358;
      }
      a(paramInt);
    }
    finally
    {
      for (;;)
      {
        Object localObject1;
        StringBuilder localStringBuilder;
        int i;
        oidb_0x791.RedDotInfo localRedDotInfo;
        for (;;)
        {
          label292:
          throw localObject2;
        }
        label358:
        if (paramInt != 56) {
          if (paramInt == 61)
          {
            continue;
            label373:
            i -= 1;
            continue;
            label380:
            i -= 1;
          }
        }
      }
    }
    i = this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size() - 1;
    if (i >= 0)
    {
      localObject1 = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(i);
      if ((!((oidb_0x791.RedDotInfo)localObject1).bool_display_reddot.get()) || (((oidb_0x791.RedDotInfo)localObject1).uint32_appid.get() != paramInt)) {
        break label373;
      }
      this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.remove(i);
      TroopRedTouchHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (oidb_0x791.RedDotInfo)localObject1);
      localStringBuilder.append(a((oidb_0x791.RedDotInfo)localObject1));
      localStringBuilder.append("]");
      break label292;
      localObject1 = null;
      i = this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size() - 1;
      if (i >= 0)
      {
        localRedDotInfo = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(i);
        if (localRedDotInfo.uint32_appid.get() != paramInt) {
          break label380;
        }
        this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.remove(i);
        localStringBuilder.append(a(localRedDotInfo));
        localStringBuilder.append("] [");
        localObject1 = localRedDotInfo;
        break label380;
      }
      if (localObject1 != null) {
        TroopRedTouchHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (oidb_0x791.RedDotInfo)localObject1);
      }
    }
    a(this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.c);
      ((StringBuilder)localObject1).append("Q.qqstory.redPoint");
      QLog.d(((StringBuilder)localObject1).toString(), 2, localStringBuilder.toString());
    }
  }
  
  public boolean b()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNowLiveManager().jdField_a_of_type_Boolean)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNowLiveManager().b()) {
        return false;
      }
      oidb_0x791.RedDotInfo localRedDotInfo = a();
      if ((localRedDotInfo != null) && (localRedDotInfo.uint32_appid.get() != 37)) {
        return true;
      }
    }
    return false;
  }
  
  public int c()
  {
    oidb_0x791.RedDotInfo localRedDotInfo = a();
    if (localRedDotInfo == null) {
      return 0;
    }
    return localRedDotInfo.uint32_report_type.get();
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo c()
  {
    Object localObject = a(24);
    oidb_0x791.RedDotInfo localRedDotInfo = a(27);
    if (((localObject != null) && (((oidb_0x791.RedDotInfo)localObject).bool_display_reddot.get())) || ((localRedDotInfo != null) && (localRedDotInfo.bool_display_reddot.get())))
    {
      localObject = new BusinessInfoCheckUpdate.RedTypeInfo();
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_type.set(0);
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_content.set("");
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_desc.set("");
      return localObject;
    }
    return null;
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
      this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = a();
    }
    Object localObject = this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes;
    int i = 0;
    if (localObject == null) {
      return 0;
    }
    int k;
    for (int j = 0; i < this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size(); j = k)
    {
      localObject = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(i);
      if (!((oidb_0x791.RedDotInfo)localObject).bool_display_reddot.get())
      {
        k = j;
      }
      else
      {
        int m = ((oidb_0x791.RedDotInfo)localObject).uint32_appid.get();
        if (((6 != m) || (j != 0)) && (2 != m) && (3 != m) && (4 != m) && (5 != m))
        {
          k = j;
          if (((oidb_0x791.RedDotInfo)localObject).uint32_number.get() > 0)
          {
            k = j;
            if (7 == ((oidb_0x791.RedDotInfo)localObject).uint32_appid.get()) {
              return m;
            }
          }
        }
        else
        {
          k = m;
        }
      }
      i += 1;
    }
    return j;
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo d()
  {
    oidb_0x791.RedDotInfo localRedDotInfo = a(59);
    if (localRedDotInfo != null)
    {
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(0);
      localRedTypeInfo.red_content.set("");
      localRedTypeInfo.red_desc.set(localRedDotInfo.str_custom_buffer.get().toStringUtf8());
      return localRedTypeInfo;
    }
    return null;
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo e()
  {
    if (a(65) != null)
    {
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(0);
      localRedTypeInfo.red_content.set("");
      localRedTypeInfo.red_desc.set("");
      return localRedTypeInfo;
    }
    return null;
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo f()
  {
    if (a(60) != null)
    {
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(0);
      localRedTypeInfo.red_content.set("");
      localRedTypeInfo.red_desc.set("");
      return localRedTypeInfo;
    }
    return null;
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo g()
  {
    if (a(53) != null)
    {
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(0);
      localRedTypeInfo.red_content.set("");
      localRedTypeInfo.red_desc.set("");
      return localRedTypeInfo;
    }
    return null;
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo h()
  {
    if (a(54) != null)
    {
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(0);
      localRedTypeInfo.red_content.set("");
      localRedTypeInfo.red_desc.set("");
      return localRedTypeInfo;
    }
    return null;
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo i()
  {
    if (a(70) != null)
    {
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(0);
      localRedTypeInfo.red_content.set("");
      localRedTypeInfo.red_desc.set("");
      return localRedTypeInfo;
    }
    return null;
  }
  
  /* Error */
  public BusinessInfoCheckUpdate.RedTypeInfo j()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 75	com/tencent/biz/TroopRedpoint/TroopRedTouchManager:jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes	Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   6: ifnonnull +11 -> 17
    //   9: aload_0
    //   10: aload_0
    //   11: invokespecial 531	com/tencent/biz/TroopRedpoint/TroopRedTouchManager:a	()Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   14: putfield 75	com/tencent/biz/TroopRedpoint/TroopRedTouchManager:jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes	Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   17: aload_0
    //   18: getfield 75	com/tencent/biz/TroopRedpoint/TroopRedTouchManager:jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes	Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   21: astore 9
    //   23: aload 9
    //   25: ifnonnull +7 -> 32
    //   28: aload_0
    //   29: monitorexit
    //   30: aconst_null
    //   31: areturn
    //   32: lconst_0
    //   33: lstore 4
    //   35: iconst_0
    //   36: istore 6
    //   38: iconst_0
    //   39: istore_1
    //   40: ldc 164
    //   42: astore 9
    //   44: iconst_0
    //   45: istore_2
    //   46: iload_2
    //   47: aload_0
    //   48: getfield 75	com/tencent/biz/TroopRedpoint/TroopRedTouchManager:jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes	Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   51: getfield 88	tencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes:rpt_msg_reddot_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   54: invokevirtual 94	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   57: if_icmpge +510 -> 567
    //   60: aload_0
    //   61: getfield 75	com/tencent/biz/TroopRedpoint/TroopRedTouchManager:jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes	Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   64: getfield 88	tencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes:rpt_msg_reddot_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   67: iload_2
    //   68: invokevirtual 98	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   71: checkcast 100	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo
    //   74: astore 9
    //   76: aload 9
    //   78: getfield 261	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:uint32_number	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   81: invokevirtual 240	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   84: istore_3
    //   85: aload 9
    //   87: getfield 249	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:bool_display_reddot	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   90: invokevirtual 253	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   93: istore 7
    //   95: aload 9
    //   97: getfield 277	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:uint64_cmd_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   100: invokevirtual 281	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   103: lstore 4
    //   105: aload 9
    //   107: getfield 294	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:str_face_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   110: invokevirtual 115	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   113: invokevirtual 120	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   116: astore 12
    //   118: bipush 38
    //   120: aload 9
    //   122: getfield 236	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:uint32_appid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   125: invokevirtual 240	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   128: if_icmpne +422 -> 550
    //   131: iload 7
    //   133: ifne +7 -> 140
    //   136: iload_3
    //   137: ifle +413 -> 550
    //   140: aload 9
    //   142: getfield 104	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:str_custom_buffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   145: invokevirtual 110	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   148: ifeq +379 -> 527
    //   151: aload 9
    //   153: getfield 104	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:str_custom_buffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   156: invokevirtual 115	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   159: invokevirtual 120	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   162: astore 10
    //   164: new 112	org/json/JSONObject
    //   167: dup
    //   168: aload 10
    //   170: invokespecial 123	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   173: ldc_w 753
    //   176: invokevirtual 129	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   179: istore_1
    //   180: iload_1
    //   181: iconst_1
    //   182: if_icmpne +345 -> 527
    //   185: aload 9
    //   187: getfield 261	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:uint32_number	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   190: invokevirtual 240	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   193: istore_1
    //   194: aload 9
    //   196: getfield 249	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:bool_display_reddot	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   199: invokevirtual 253	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   202: istore 6
    //   204: aload 9
    //   206: astore 11
    //   208: iload_1
    //   209: istore_2
    //   210: aload 9
    //   212: astore 10
    //   214: iload_3
    //   215: istore_1
    //   216: aload 11
    //   218: astore 9
    //   220: goto +36 -> 256
    //   223: astore 10
    //   225: aload 9
    //   227: astore 11
    //   229: goto +19 -> 248
    //   232: astore 10
    //   234: aload 9
    //   236: astore 11
    //   238: goto +8 -> 246
    //   241: astore 10
    //   243: aconst_null
    //   244: astore 11
    //   246: iconst_0
    //   247: istore_1
    //   248: aload 10
    //   250: invokevirtual 365	java/lang/Exception:printStackTrace	()V
    //   253: goto +279 -> 532
    //   256: aload 10
    //   258: ifnull +252 -> 510
    //   261: new 690	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo
    //   264: dup
    //   265: invokespecial 768	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo:<init>	()V
    //   268: astore 11
    //   270: ldc_w 796
    //   273: invokestatic 484	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   276: checkcast 796	com/tencent/mobileqq/nearby/redtouch/INearbyRedDotCustomInfo
    //   279: astore 13
    //   281: aload 13
    //   283: aload 10
    //   285: invokeinterface 1058 2 0
    //   290: iload 7
    //   292: ifne +8 -> 300
    //   295: iload 6
    //   297: ifeq +208 -> 505
    //   300: iload_1
    //   301: ifle +93 -> 394
    //   304: aload 11
    //   306: getfield 693	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo:red_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   309: iconst_5
    //   310: invokevirtual 771	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   313: aload 11
    //   315: getfield 697	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo:red_content	Lcom/tencent/mobileqq/pb/PBStringField;
    //   318: iload_1
    //   319: invokestatic 1060	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   322: invokevirtual 773	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   325: aload 10
    //   327: getfield 104	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:str_custom_buffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   330: invokevirtual 110	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   333: istore 6
    //   335: iload 6
    //   337: ifeq +32 -> 369
    //   340: aload 13
    //   342: invokeinterface 1063 1 0
    //   347: ifne +22 -> 369
    //   350: aload 11
    //   352: getfield 693	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo:red_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   355: iconst_0
    //   356: invokevirtual 771	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   359: goto +10 -> 369
    //   362: astore 9
    //   364: aload 9
    //   366: invokevirtual 365	java/lang/Exception:printStackTrace	()V
    //   369: aload_0
    //   370: aload 12
    //   372: lload 4
    //   374: aload 13
    //   376: invokevirtual 1065	com/tencent/biz/TroopRedpoint/TroopRedTouchManager:a	(Ljava/lang/String;JLcom/tencent/mobileqq/nearby/redtouch/INearbyRedDotCustomInfo;)Ljava/lang/String;
    //   379: astore 9
    //   381: aload 11
    //   383: getfield 776	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo:red_desc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   386: aload 9
    //   388: invokevirtual 773	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   391: goto +114 -> 505
    //   394: aload 9
    //   396: ifnull +80 -> 476
    //   399: aload 9
    //   401: getfield 104	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:str_custom_buffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   404: invokevirtual 115	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   407: invokevirtual 120	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   410: astore 9
    //   412: aload 11
    //   414: getfield 697	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo:red_content	Lcom/tencent/mobileqq/pb/PBStringField;
    //   417: iload_2
    //   418: invokestatic 1060	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   421: invokevirtual 773	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   424: new 112	org/json/JSONObject
    //   427: dup
    //   428: aload 9
    //   430: invokespecial 123	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   433: ldc_w 1066
    //   436: invokevirtual 129	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   439: ifeq +15 -> 454
    //   442: aload 11
    //   444: getfield 693	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo:red_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   447: iconst_0
    //   448: invokevirtual 771	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   451: goto +54 -> 505
    //   454: aload 11
    //   456: getfield 693	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo:red_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   459: iconst_5
    //   460: invokevirtual 771	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   463: goto +42 -> 505
    //   466: astore 9
    //   468: aload 9
    //   470: invokevirtual 365	java/lang/Exception:printStackTrace	()V
    //   473: goto +32 -> 505
    //   476: aload 11
    //   478: getfield 693	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo:red_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   481: iconst_0
    //   482: invokevirtual 771	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   485: aload 11
    //   487: getfield 697	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo:red_content	Lcom/tencent/mobileqq/pb/PBStringField;
    //   490: ldc 164
    //   492: invokevirtual 773	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   495: aload 11
    //   497: getfield 776	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo:red_desc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   500: ldc 164
    //   502: invokevirtual 773	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   505: aload_0
    //   506: monitorexit
    //   507: aload 11
    //   509: areturn
    //   510: aload_0
    //   511: monitorexit
    //   512: aconst_null
    //   513: areturn
    //   514: astore 9
    //   516: aload_0
    //   517: monitorexit
    //   518: goto +6 -> 524
    //   521: aload 9
    //   523: athrow
    //   524: goto -3 -> 521
    //   527: aconst_null
    //   528: astore 11
    //   530: iconst_0
    //   531: istore_1
    //   532: iconst_0
    //   533: istore 6
    //   535: iload_1
    //   536: istore_2
    //   537: aload 9
    //   539: astore 10
    //   541: iload_3
    //   542: istore_1
    //   543: aload 11
    //   545: astore 9
    //   547: goto -291 -> 256
    //   550: iload_2
    //   551: iconst_1
    //   552: iadd
    //   553: istore_2
    //   554: iload 7
    //   556: istore 6
    //   558: aload 12
    //   560: astore 9
    //   562: iload_3
    //   563: istore_1
    //   564: goto -518 -> 46
    //   567: aconst_null
    //   568: astore 11
    //   570: iconst_0
    //   571: istore_2
    //   572: iconst_0
    //   573: istore 8
    //   575: aload 11
    //   577: astore 10
    //   579: iload 6
    //   581: istore 7
    //   583: aload 9
    //   585: astore 12
    //   587: iload 8
    //   589: istore 6
    //   591: aload 11
    //   593: astore 9
    //   595: goto -339 -> 256
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	598	0	this	TroopRedTouchManager
    //   39	525	1	i	int
    //   45	527	2	j	int
    //   84	479	3	k	int
    //   33	340	4	l	long
    //   36	554	6	bool1	boolean
    //   93	489	7	bool2	boolean
    //   573	15	8	bool3	boolean
    //   21	214	9	localObject1	Object
    //   362	3	9	localException1	Exception
    //   379	50	9	str	String
    //   466	3	9	localException2	Exception
    //   514	24	9	localObject2	Object
    //   545	49	9	localObject3	Object
    //   162	51	10	localObject4	Object
    //   223	1	10	localException3	Exception
    //   232	1	10	localException4	Exception
    //   241	85	10	localException5	Exception
    //   539	39	10	localObject5	Object
    //   206	386	11	localObject6	Object
    //   116	470	12	localObject7	Object
    //   279	96	13	localINearbyRedDotCustomInfo	INearbyRedDotCustomInfo
    // Exception table:
    //   from	to	target	type
    //   194	204	223	java/lang/Exception
    //   185	194	232	java/lang/Exception
    //   164	180	241	java/lang/Exception
    //   340	359	362	java/lang/Exception
    //   424	451	466	java/lang/Exception
    //   454	463	466	java/lang/Exception
    //   2	17	514	finally
    //   17	23	514	finally
    //   46	131	514	finally
    //   140	164	514	finally
    //   164	180	514	finally
    //   185	194	514	finally
    //   194	204	514	finally
    //   248	253	514	finally
    //   261	290	514	finally
    //   304	335	514	finally
    //   340	359	514	finally
    //   364	369	514	finally
    //   369	391	514	finally
    //   399	424	514	finally
    //   424	451	514	finally
    //   454	463	514	finally
    //   468	473	514	finally
    //   476	505	514	finally
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo k()
  {
    if (a(42) != null)
    {
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(0);
      localRedTypeInfo.red_content.set("");
      localRedTypeInfo.red_desc.set("");
      return localRedTypeInfo;
    }
    return null;
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo l()
  {
    try
    {
      if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
        this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = a();
      }
      localObject1 = this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes;
      if (localObject1 == null) {
        return null;
      }
      l1 = 0L;
      i = 0;
      bool1 = false;
      localObject1 = "";
      j = 0;
    }
    finally
    {
      for (;;)
      {
        Object localObject1;
        long l1;
        int i;
        boolean bool1;
        int j;
        oidb_0x791.RedDotInfo localRedDotInfo;
        Object localObject5;
        for (;;)
        {
          throw localObject2;
        }
        label345:
        j += 1;
        Object localObject3 = localObject5;
        continue;
        Object localObject4 = null;
        int k = i;
        long l2 = l1;
        boolean bool2 = bool1;
      }
    }
    if (j < this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size())
    {
      localRedDotInfo = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(j);
      i = localRedDotInfo.uint32_number.get();
      bool1 = localRedDotInfo.bool_display_reddot.get();
      l1 = localRedDotInfo.uint64_cmd_uin.get();
      localObject5 = localRedDotInfo.str_face_url.get().toStringUtf8();
      if (63 == localRedDotInfo.uint32_appid.get())
      {
        localObject4 = localRedDotInfo;
        k = i;
        l2 = l1;
        bool2 = bool1;
        localObject1 = localObject5;
        if (!bool1)
        {
          if ((bool1) || (i <= 0)) {
            break label345;
          }
          localObject4 = localRedDotInfo;
          k = i;
          l2 = l1;
          bool2 = bool1;
          localObject1 = localObject5;
        }
        if (localObject4 != null)
        {
          localObject4 = new BusinessInfoCheckUpdate.RedTypeInfo();
          if (bool2) {
            if (k > 0)
            {
              if (k <= 99) {}
              ((BusinessInfoCheckUpdate.RedTypeInfo)localObject4).red_type.set(5);
              ((BusinessInfoCheckUpdate.RedTypeInfo)localObject4).red_content.set(String.valueOf(k));
              try
              {
                localObject5 = new JSONObject();
                ((JSONObject)localObject5).put("faceUrl", localObject1);
                ((JSONObject)localObject5).put("uin", l2);
                ((BusinessInfoCheckUpdate.RedTypeInfo)localObject4).red_desc.set(((JSONObject)localObject5).toString());
              }
              catch (Exception localException)
              {
                localException.printStackTrace();
              }
            }
            else
            {
              ((BusinessInfoCheckUpdate.RedTypeInfo)localObject4).red_type.set(0);
              ((BusinessInfoCheckUpdate.RedTypeInfo)localObject4).red_content.set("");
              ((BusinessInfoCheckUpdate.RedTypeInfo)localObject4).red_desc.set("");
            }
          }
          return localObject4;
        }
        return null;
      }
    }
  }
  
  public void onDestroy()
  {
    a(this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes);
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.TroopRedpoint.TroopRedTouchManager
 * JD-Core Version:    0.7.0.1
 */