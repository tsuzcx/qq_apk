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
  public static final String f = String.valueOf(System.currentTimeMillis());
  QQAppInterface a;
  final String b = "TroopRedTouchManager2_";
  final String c = "TroopRedTouchManager2_All";
  final String d = TroopRedTouchManager.class.getSimpleName();
  oidb_0x791.GetRedDotRes e;
  boolean g = false;
  Map<Long, oidb_0x791.RedDotInfo> h = null;
  protected int i = 0;
  private BroadcastReceiver j = new TroopRedTouchManager.1(this);
  
  public TroopRedTouchManager(QQAppInterface paramQQAppInterface)
  {
    this(paramQQAppInterface, null);
  }
  
  public TroopRedTouchManager(QQAppInterface paramQQAppInterface, oidb_0x791.GetRedDotRes paramGetRedDotRes)
  {
    this.a = paramQQAppInterface;
    if (paramGetRedDotRes != null) {
      this.e = paramGetRedDotRes;
    }
    w();
  }
  
  private String A()
  {
    JSONArray localJSONArray = new JSONArray();
    int k = 0;
    while (k < this.e.rpt_msg_reddot_info.size())
    {
      Object localObject = (oidb_0x791.RedDotInfo)this.e.rpt_msg_reddot_info.get(k);
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
      k += 1;
    }
    return localException.toString();
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
  
  public static String b(oidb_0x791.RedDotInfo paramRedDotInfo)
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
  
  private void b(Map<Long, oidb_0x791.RedDotInfo> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    try
    {
      if (QLog.isColorLevel())
      {
        String str = this.d;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveLocalFileList, size =");
        localStringBuilder.append(paramMap.size());
        QLog.d(str, 2, localStringBuilder.toString());
      }
      ThreadManager.post(new TroopRedTouchManager.4(this, c(paramMap)), 5, null, false);
      return;
    }
    finally {}
  }
  
  private String c(Map<Long, oidb_0x791.RedDotInfo> paramMap)
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
      Object localObject1 = this.d;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("convertHashMapToJSONString: JSONException when convert HashMap data - ");
      ((StringBuilder)localObject2).append(paramMap.getMessage());
      PlayerUtils.log(6, (String)localObject1, ((StringBuilder)localObject2).toString());
    }
    return "";
  }
  
  private void c(oidb_0x791.RedDotInfo paramRedDotInfo)
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
          this.a.getApp().sendBroadcast((Intent)localObject);
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
  
  private void d(oidb_0x791.RedDotInfo paramRedDotInfo)
  {
    if ((paramRedDotInfo.msg_nearby_entrance_extend_config.has()) && (paramRedDotInfo.msg_nearby_entrance_extend_config.bool_has_hintWord.has()) && (paramRedDotInfo.msg_nearby_entrance_extend_config.bool_has_hintWord.get()) && (paramRedDotInfo.msg_nearby_entrance_extend_config.str_hintWord.has())) {
      ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(this.a.getCurrentAccountUin(), "key_nearby_red_dot_assist_text", paramRedDotInfo.msg_nearby_entrance_extend_config.str_hintWord.get().toStringUtf8());
    }
    if ((paramRedDotInfo.msg_word_corner_red_dot.has()) && (paramRedDotInfo.msg_word_corner_red_dot.bool_enable.has()) && (paramRedDotInfo.msg_word_corner_red_dot.bool_enable.get()) && (paramRedDotInfo.msg_word_corner_red_dot.bool_switch_to_word_corner.has()) && (paramRedDotInfo.msg_word_corner_red_dot.bool_switch_to_word_corner.get()) && (paramRedDotInfo.msg_word_corner_red_dot.str_hintText.has())) {
      ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(this.a.getCurrentAccountUin(), "key_nearby_red_dot_corner_text", paramRedDotInfo.msg_word_corner_red_dot.str_hintText.get().toStringUtf8());
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
        if (paramRedDotInfo.optInt("is_c2c") == 1)
        {
          ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(this.a.getCurrentAccountUin(), "key_nearby_msg_box_say_hello_msg_type", Integer.valueOf(paramRedDotInfo.optInt("say_hello_red_dot_type")));
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
  
  private void f(oidb_0x791.RedDotInfo paramRedDotInfo)
  {
    if ((paramRedDotInfo.uint32_appid.get() == 60) && (paramRedDotInfo.str_custom_buffer.has()))
    {
      paramRedDotInfo = paramRedDotInfo.str_custom_buffer.get().toStringUtf8();
      try
      {
        paramRedDotInfo = new JSONObject(paramRedDotInfo);
        if (paramRedDotInfo.optInt("is_comment") == 1)
        {
          ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(this.a.getCurrentAccountUin(), "key_nearby_msg_box_comment_zan_msg_type", Integer.valueOf(paramRedDotInfo.optInt("comment_red_dot_type")));
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
  
  private void w()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.biz.TroopRedpoint.TroopRedTouchManager");
    this.a.getApp().registerReceiver(this.j, localIntentFilter);
  }
  
  private void x()
  {
    this.a.getApp().unregisterReceiver(this.j);
  }
  
  /* Error */
  private oidb_0x791.GetRedDotRes y()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 79	com/tencent/biz/TroopRedpoint/TroopRedTouchManager:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6: invokevirtual 476	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   9: invokevirtual 482	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   12: astore_1
    //   13: new 149	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   20: astore_2
    //   21: aload_2
    //   22: ldc 50
    //   24: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_2
    //   29: aload_0
    //   30: getfield 79	com/tencent/biz/TroopRedpoint/TroopRedTouchManager:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   33: invokevirtual 404	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   36: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: new 484	java/io/File
    //   43: dup
    //   44: aload_1
    //   45: aload_2
    //   46: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokespecial 487	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   52: invokestatic 493	com/tencent/mobileqq/utils/FileUtils:fileToBytes	(Ljava/io/File;)[B
    //   55: astore_3
    //   56: new 92	tencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes
    //   59: dup
    //   60: invokespecial 494	tencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes:<init>	()V
    //   63: astore_1
    //   64: aload_1
    //   65: astore_2
    //   66: aload_3
    //   67: ifnull +44 -> 111
    //   70: aload_1
    //   71: aload_3
    //   72: invokevirtual 498	tencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
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
    //   97: invokevirtual 501	java/lang/NullPointerException:printStackTrace	()V
    //   100: aload_1
    //   101: astore_2
    //   102: goto +9 -> 111
    //   105: aload_2
    //   106: invokevirtual 502	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
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
  
  private Map<Long, oidb_0x791.RedDotInfo> z()
  {
    try
    {
      HashMap localHashMap = new HashMap();
      try
      {
        Object localObject2 = this.a.getApplication().getFilesDir();
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("TroopRedTouchManager2_All");
        ((StringBuilder)localObject3).append(this.a.getCurrentAccountUin());
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
          str1 = this.d;
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
  
  public int a()
  {
    if (this.e == null) {
      this.e = y();
    }
    Object localObject = this.e;
    int k = 0;
    if (localObject == null) {
      return 0;
    }
    int n;
    for (int m = 0; k < this.e.rpt_msg_reddot_info.size(); m = n)
    {
      localObject = (oidb_0x791.RedDotInfo)this.e.rpt_msg_reddot_info.get(k);
      if (!((oidb_0x791.RedDotInfo)localObject).bool_display_reddot.get())
      {
        n = m;
      }
      else
      {
        boolean bool = SharedPreUtils.aC(BaseApplicationImpl.getApplication(), this.a.getCurrentAccountUin());
        n = m;
        if (((oidb_0x791.RedDotInfo)localObject).uint32_number.get() > 0)
        {
          n = m;
          if (7 == ((oidb_0x791.RedDotInfo)localObject).uint32_appid.get())
          {
            n = m;
            if (bool) {
              n = m + ((oidb_0x791.RedDotInfo)localObject).uint32_number.get();
            }
          }
        }
      }
      k += 1;
    }
    return m;
  }
  
  public INearbyRedInfo a(boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      localObject2 = this.a;
      localObject5 = (TroopRedTouchManager)((QQAppInterface)localObject2).getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
      localRedTypeInfo1 = ((TroopRedTouchManager)localObject5).b();
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
      localObject3 = ((TroopRedTouchManager)localObject5).c();
      localObject4 = ((TroopRedTouchManager)localObject5).m();
      localRedTypeInfo2 = ((TroopRedTouchManager)localObject5).v();
      localRedTypeInfo3 = ((TroopRedTouchManager)localObject5).o();
      localObject6 = ((TroopRedTouchManager)localObject5).f();
      localArrayList = ((TroopRedTouchManager)localObject5).e();
      g();
      ((TroopRedTouchManager)localObject5).h();
      i();
      localRedTypeInfo4 = ((TroopRedTouchManager)localObject5).j();
      localRedTypeInfo5 = ((TroopRedTouchManager)localObject5).k();
      localObject5 = ((TroopRedTouchManager)localObject5).l();
      if ((localObject6 == null) || (((ArrayList)localObject6).size() <= 0)) {
        break label1176;
      }
      localINearbyRedInfo.setRedType(5);
      localINearbyRedInfo.addRedNum(((ArrayList)localObject6).size());
      m = 56;
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
        int m = 0;
        continue;
        label1182:
        int n = 2;
        int k = m;
        m = n;
        continue;
        m = 1;
        continue;
        label1201:
        int i1 = m;
        if (k == 0)
        {
          n = 38;
        }
        else
        {
          label1216:
          n = k;
          m = i1;
          continue;
          label1226:
          k = 0;
          m = n;
          break label1245;
          label1235:
          n = m;
          m = k;
          k = n;
          label1245:
          n = k;
          k = m;
          paramBoolean1 = true;
          m = n;
          continue;
          label1260:
          paramBoolean1 = false;
          m = 1;
          continue;
          label1268:
          m = 0;
          paramBoolean1 = false;
          k = 0;
        }
      }
    }
    k = m;
    if (localArrayList != null)
    {
      k = m;
      if (localArrayList.size() > 0)
      {
        k = m;
        if (((INearbyConfigUtil)QRoute.api(INearbyConfigUtil.class)).hasNearbyMsgTab((AppInterface)localObject2))
        {
          localINearbyRedInfo.setRedType(5);
          localINearbyRedInfo.addRedNum(localArrayList.size());
          k = 61;
        }
      }
    }
    if (((INearbyConfigUtil)QRoute.api(INearbyConfigUtil.class)).hasNearbyMsgTab((AppInterface)localObject2))
    {
      if (QLog.isColorLevel())
      {
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append("in memory nearbyMsgBoxUnReadNum=");
        ((StringBuilder)localObject6).append(this.i);
        QLog.d("nearby.redpoint", 2, ((StringBuilder)localObject6).toString());
      }
      if (paramBoolean2) {
        ThreadManager.post(new TroopRedTouchManager.2(this, (QQAppInterface)localObject2), 8, null, false);
      } else {
        this.i = MsgBoxListActivity.getNearbyMsgBoxUnReadNum((QQAppInterface)localObject2, AppConstants.NEARBY_LBS_HELLO_UIN, true);
      }
      m = this.i;
      if (m > 0)
      {
        localINearbyRedInfo.setRedType(5);
        localINearbyRedInfo.addRedNum(m);
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append("addRedNum:");
        ((StringBuilder)localObject6).append(m);
        ((StringBuilder)localObject6).append(", total=");
        ((StringBuilder)localObject6).append(localINearbyRedInfo.getRedNum());
        ((StringBuilder)localObject6).append(", type=");
        ((StringBuilder)localObject6).append(60);
        QLog.d("nearby.redpoint", 1, ((StringBuilder)localObject6).toString());
        m = k;
        if (k == 0)
        {
          m = 60;
          break label1182;
          i1 = m;
          if (localObject4 == null) {
            break label1216;
          }
          i1 = m;
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
          m = 2;
          break label1201;
          if ((localRedTypeInfo2 != null) && (localRedTypeInfo2.red_type.get() == 5))
          {
            localINearbyRedInfo.setRedType(5);
            localINearbyRedInfo.addRedNum(localRedTypeInfo2.red_content.get());
            SharedPreUtils.Z(this.a.getApp().getApplicationContext());
          }
          k = n;
          if (n != 0) {
            break label1235;
          }
          if (this.i == -1)
          {
            localINearbyRedInfo.setRedType(0);
            k = 2;
            m = 60;
            break label1245;
          }
          if ((localRedTypeInfo1 != null) && (((INearbyConfigUtil)QRoute.api(INearbyConfigUtil.class)).hasEnterItem((AppInterface)localObject2, 2)))
          {
            localINearbyRedInfo.setRedType(0);
            k = m;
            m = 25;
            break label1245;
          }
          if ((localObject3 != null) && (((INearbyConfigUtil)QRoute.api(INearbyConfigUtil.class)).hasEnterItem((AppInterface)localObject2, 3)))
          {
            k = 23;
            localINearbyRedInfo.setRedType(0);
            break label1235;
          }
          if (localRedTypeInfo3 != null)
          {
            localINearbyRedInfo.setRedType(0);
            k = 42;
            break label1235;
          }
          if (localRedTypeInfo4 != null)
          {
            localINearbyRedInfo.setRedType(0);
            k = 53;
            break label1235;
          }
          if (localRedTypeInfo5 != null)
          {
            localINearbyRedInfo.setRedType(0);
            k = 54;
            break label1235;
          }
          if (localObject5 == null) {
            break label1226;
          }
          localINearbyRedInfo.setRedType(0);
          k = 70;
          break label1235;
          localINearbyRedInfo.setRedType(11);
          localINearbyRedInfo.setCornerInfo((String)localObject3);
          localINearbyRedInfo.setTipTextInfo((String)localObject4);
          return localINearbyRedInfo;
          if (((TroopRedTouchManager)localObject5).d() != null)
          {
            localINearbyRedInfo.setRedType(0);
            k = 24;
            break label1260;
          }
          if ((localRedTypeInfo1 == null) || (!((INearbyConfigUtil)QRoute.api(INearbyConfigUtil.class)).isOldEnterHasItem(localObject2, 1001))) {
            break label1268;
          }
          localINearbyRedInfo.setRedType(0);
          k = 25;
          break label1260;
          localINearbyRedInfo.setRedPointReportType(m);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getNearbyRedPoint, needShow, isNewTab=");
          ((StringBuilder)localObject2).append(paramBoolean1);
          ((StringBuilder)localObject2).append(", redType=");
          ((StringBuilder)localObject2).append(k);
          ((StringBuilder)localObject2).append(", redInfo=");
          ((StringBuilder)localObject2).append(localINearbyRedInfo);
          QLog.d("nearby.redpoint", 1, ((StringBuilder)localObject2).toString());
          break label1150;
          k = 0;
          QLog.d("nearby.redpoint", 1, "getNearbyRedPoint, don't needShow");
          localINearbyRedInfo.setRedAppIdType(k);
          return localINearbyRedInfo;
        }
      }
    }
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
  
  public oidb_0x791.RedDotInfo a(int paramInt, boolean paramBoolean)
  {
    if (this.e == null) {
      this.e = y();
    }
    if (this.e == null) {
      return null;
    }
    int k = 0;
    while (k < this.e.rpt_msg_reddot_info.size())
    {
      oidb_0x791.RedDotInfo localRedDotInfo = (oidb_0x791.RedDotInfo)this.e.rpt_msg_reddot_info.get(k);
      if ((paramInt == localRedDotInfo.uint32_appid.get()) && ((!paramBoolean) || (localRedDotInfo.bool_display_reddot.get()))) {
        return localRedDotInfo;
      }
      k += 1;
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    try
    {
      if ((this.h != null) && (this.h.size() > 0))
      {
        Iterator localIterator = this.h.entrySet().iterator();
        while (localIterator.hasNext()) {
          if (((oidb_0x791.RedDotInfo)((Map.Entry)localIterator.next()).getValue()).uint32_appid.get() == paramInt) {
            localIterator.remove();
          }
        }
        b(this.h);
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
        localObject = this.d;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setAllRedDotMsgInfo: listRedDotInfo size = ");
        int k;
        if (paramMap == null) {
          k = 0;
        } else {
          k = paramMap.size();
        }
        localStringBuilder.append(k);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      if (this.h == null) {
        this.h = z();
      }
      if ((this.h != null) && (paramMap != null))
      {
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          localObject = (Map.Entry)paramMap.next();
          this.h.put(((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
        }
        b(this.h);
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
      if (this.e == null) {
        this.e = y();
      }
      if ((this.e == null) || (paramRedDotInfo == null)) {
        break label344;
      }
      n = paramRedDotInfo.uint32_appid.get();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("set：appId=");
        ((StringBuilder)localObject).append(n);
        ((StringBuilder)localObject).append(", uin=");
        ((StringBuilder)localObject).append(paramRedDotInfo.uint64_cmd_uin.get());
        ((StringBuilder)localObject).append(", hasRed=");
        ((StringBuilder)localObject).append(paramRedDotInfo.bool_display_reddot.get());
        QLog.d("nearby.redpoint", 2, ((StringBuilder)localObject).toString());
      }
      d(paramRedDotInfo);
      e(paramRedDotInfo);
      f(paramRedDotInfo);
      c(paramRedDotInfo);
      k = 0;
    }
    finally
    {
      for (;;)
      {
        int n;
        Object localObject;
        int i1;
        int m;
        for (;;)
        {
          label344:
          throw paramRedDotInfo;
        }
        label358:
        k += 1;
        continue;
        int k = 0;
      }
    }
    i1 = this.e.rpt_msg_reddot_info.size();
    m = 1;
    if (k < i1)
    {
      localObject = (oidb_0x791.RedDotInfo)this.e.rpt_msg_reddot_info.get(k);
      if (((oidb_0x791.RedDotInfo)localObject).uint32_appid.get() == n)
      {
        if ((n != 56) && (n != 61))
        {
          this.e.rpt_msg_reddot_info.set(k, paramRedDotInfo);
          k = m;
        }
        else
        {
          if (((oidb_0x791.RedDotInfo)localObject).uint64_cmd_uin.get() != paramRedDotInfo.uint64_cmd_uin.get()) {
            break label358;
          }
          this.e.rpt_msg_reddot_info.set(k, paramRedDotInfo);
          k = m;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("APPID_NEARBY_CONCERN_UPDATE, onPush：has same uin reddot, uin=");
            ((StringBuilder)localObject).append(paramRedDotInfo.uint64_cmd_uin.get());
            QLog.d("nearby.redpoint", 2, ((StringBuilder)localObject).toString());
            k = m;
          }
        }
        if (k == 0) {
          this.e.rpt_msg_reddot_info.add(paramRedDotInfo);
        }
        a(this.e);
        return;
        return;
      }
    }
  }
  
  public void a(oidb_0x791.RedDotInfo paramRedDotInfo1, oidb_0x791.RedDotInfo paramRedDotInfo2)
  {
    int k;
    if ((paramRedDotInfo1 != null) && (paramRedDotInfo1.uint32_last_time.has())) {
      k = paramRedDotInfo1.uint32_last_time.get();
    } else {
      k = 0;
    }
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.d;
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
        int m = k;
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
          m = k;
          localObject1 = paramRedDotInfo1;
          if (localJSONObject.has("lastTime"))
          {
            m = localJSONObject.getInt("lastTime");
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
        paramRedDotInfo1.put("lastTime", m);
        paramRedDotInfo1 = paramRedDotInfo1.toString();
        paramRedDotInfo2.str_custom_buffer.set(ByteStringMicro.copyFromUtf8(paramRedDotInfo1));
        return;
      }
      catch (Exception localException)
      {
        continue;
      }
      paramRedDotInfo1 = this.d;
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
    localObject = this.a.getCurrentAccountUin();
    if (!paramBoolean) {
      ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).clearCornerRedDot((String)localObject);
    }
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.a.getApp()).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("troop_nearby_red_point_state_");
    localStringBuilder.append((String)localObject);
    localEditor.putBoolean(localStringBuilder.toString(), paramBoolean);
    localEditor.commit();
  }
  
  public boolean a(List<Integer> paramList, oidb_0x791.GetRedDotRes paramGetRedDotRes)
  {
    try
    {
      i1 = paramGetRedDotRes.rpt_msg_reddot_info.size();
      m = 0;
      bool = false;
    }
    finally
    {
      for (;;)
      {
        int i1;
        int m;
        oidb_0x791.RedDotInfo localRedDotInfo;
        Object localObject1;
        int n;
        int k;
        Object localObject2;
        StringBuilder localStringBuilder;
        for (;;)
        {
          throw paramList;
        }
        label808:
        boolean bool = true;
        label814:
        if (n != 56) {
          if (n == 61)
          {
            continue;
            label831:
            k = 0;
            break label838;
            label836:
            k = 1;
            label838:
            n = 0;
            break label856;
            label844:
            k += 1;
            continue;
            label851:
            n = 1;
            k = 0;
            label856:
            if ((n == 0) && (k == 0))
            {
              label868:
              m += 1;
              continue;
              label877:
              k += 1;
            }
          }
        }
      }
    }
    if (m < i1)
    {
      localRedDotInfo = (oidb_0x791.RedDotInfo)paramGetRedDotRes.rpt_msg_reddot_info.get(m);
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
      n = this.e.rpt_msg_reddot_info.size();
      k = 0;
      if (k >= n) {
        break label851;
      }
      localObject1 = (oidb_0x791.RedDotInfo)this.e.rpt_msg_reddot_info.get(k);
      if (((oidb_0x791.RedDotInfo)localObject1).uint32_appid.get() != localRedDotInfo.uint32_appid.get()) {
        break label844;
      }
      n = localRedDotInfo.uint32_appid.get();
      if ((TroopRedTouchConfigure.b(n)) || (TroopRedTouchConfigure.c(n))) {
        break label814;
      }
      if (n == 46)
      {
        a((oidb_0x791.RedDotInfo)localObject1, localRedDotInfo);
        this.e.rpt_msg_reddot_info.set(k, localRedDotInfo);
      }
      else
      {
        this.e.rpt_msg_reddot_info.set(k, localRedDotInfo);
        break label808;
        if (localRedDotInfo.uint32_last_time.get() <= ((oidb_0x791.RedDotInfo)localObject1).uint32_last_time.get()) {
          break label831;
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.d);
          ((StringBuilder)localObject2).append("Q.qqstory.redPoint");
          localObject2 = ((StringBuilder)localObject2).toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("网络红点比本地红点新，netRedPoint：");
          localStringBuilder.append(b(localRedDotInfo));
          localStringBuilder.append("|localRedPoint:");
          localStringBuilder.append(b((oidb_0x791.RedDotInfo)localObject1));
          QLog.d((String)localObject2, 2, localStringBuilder.toString());
        }
        this.e.rpt_msg_reddot_info.set(k, localRedDotInfo);
        if (TroopRedTouchConfigure.c(n))
        {
          a(true);
          break label808;
          if (((oidb_0x791.RedDotInfo)localObject1).uint64_cmd_uin.get() != localRedDotInfo.uint64_cmd_uin.get()) {
            break label836;
          }
          if (localRedDotInfo.uint32_last_time.get() <= ((oidb_0x791.RedDotInfo)localObject1).uint32_last_time.get()) {
            break label831;
          }
          this.e.rpt_msg_reddot_info.set(k, localRedDotInfo);
          a(true);
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("APPID_NEARBY_CONCERN_UPDATE, setAllRedDot：has same uin reddot, uin=");
            ((StringBuilder)localObject1).append(localRedDotInfo.uint64_cmd_uin.get());
            QLog.d("nearby.redpoint", 2, ((StringBuilder)localObject1).toString());
            break label808;
            this.e.rpt_msg_reddot_info.add(localRedDotInfo);
            bool = true;
            break label868;
          }
        }
      }
    }
    else
    {
      m = this.e.rpt_msg_reddot_info.size();
      k = 0;
      if (k < m)
      {
        paramGetRedDotRes = (oidb_0x791.RedDotInfo)this.e.rpt_msg_reddot_info.get(k);
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
        a(this.e);
      }
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append(this.d);
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
      localObject2 = e(paramInt3);
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
          ((StringBuilder)localObject2).append(this.d);
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
        ((StringBuilder)localObject2).append(this.d);
        ((StringBuilder)localObject2).append("Q.qqstory.redPoint");
        localObject2 = ((StringBuilder)localObject2).toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateStoryMessageRedPoint==>");
        localStringBuilder.append(b(localRedDotInfo));
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
  
  public NearbyRedNum b(int paramInt)
  {
    try
    {
      NearbyRedNum localNearbyRedNum = new NearbyRedNum();
      if (this.h == null) {
        this.h = z();
      }
      int k = this.h.size();
      if (k <= 0) {
        return localNearbyRedNum;
      }
      k = 0;
      Iterator localIterator = this.h.entrySet().iterator();
      while (localIterator.hasNext())
      {
        oidb_0x791.RedDotInfo localRedDotInfo = (oidb_0x791.RedDotInfo)((Map.Entry)localIterator.next()).getValue();
        if (a(localRedDotInfo, paramInt)) {
          k += localRedDotInfo.uint32_number.get();
        }
      }
      localNearbyRedNum.a = k;
      return localNearbyRedNum;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo b()
  {
    if (e(25) != null)
    {
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(0);
      localRedTypeInfo.red_content.set("");
      localRedTypeInfo.red_desc.set("");
      return localRedTypeInfo;
    }
    return null;
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo c()
  {
    Object localObject = e(23);
    oidb_0x791.RedDotInfo localRedDotInfo = e(26);
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
  
  public String c(int paramInt)
  {
    if (this.h == null) {
      this.h = z();
    }
    int k = this.h.size();
    String str = "";
    if (k <= 0) {
      return "";
    }
    Object localObject1 = Long.valueOf(0L);
    Iterator localIterator = this.h.entrySet().iterator();
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
  
  public BusinessInfoCheckUpdate.RedTypeInfo d()
  {
    Object localObject = e(24);
    oidb_0x791.RedDotInfo localRedDotInfo = e(27);
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
  
  public void d(int paramInt)
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
      if (this.e == null) {
        this.e = y();
      }
      localObject1 = this.e;
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
        int k;
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
            k -= 1;
            continue;
            label380:
            k -= 1;
          }
        }
      }
    }
    k = this.e.rpt_msg_reddot_info.size() - 1;
    if (k >= 0)
    {
      localObject1 = (oidb_0x791.RedDotInfo)this.e.rpt_msg_reddot_info.get(k);
      if ((!((oidb_0x791.RedDotInfo)localObject1).bool_display_reddot.get()) || (((oidb_0x791.RedDotInfo)localObject1).uint32_appid.get() != paramInt)) {
        break label373;
      }
      this.e.rpt_msg_reddot_info.remove(k);
      TroopRedTouchHandler.a(this.a, (oidb_0x791.RedDotInfo)localObject1);
      localStringBuilder.append(b((oidb_0x791.RedDotInfo)localObject1));
      localStringBuilder.append("]");
      break label292;
      localObject1 = null;
      k = this.e.rpt_msg_reddot_info.size() - 1;
      if (k >= 0)
      {
        localRedDotInfo = (oidb_0x791.RedDotInfo)this.e.rpt_msg_reddot_info.get(k);
        if (localRedDotInfo.uint32_appid.get() != paramInt) {
          break label380;
        }
        this.e.rpt_msg_reddot_info.remove(k);
        localStringBuilder.append(b(localRedDotInfo));
        localStringBuilder.append("] [");
        localObject1 = localRedDotInfo;
        break label380;
      }
      if (localObject1 != null) {
        TroopRedTouchHandler.a(this.a, (oidb_0x791.RedDotInfo)localObject1);
      }
    }
    a(this.e);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.d);
      ((StringBuilder)localObject1).append("Q.qqstory.redPoint");
      QLog.d(((StringBuilder)localObject1).toString(), 2, localStringBuilder.toString());
    }
  }
  
  public ArrayList<oidb_0x791.RedDotInfo> e()
  {
    try
    {
      if (this.e == null) {
        this.e = y();
      }
      Object localObject1 = this.e;
      if (localObject1 == null) {
        return null;
      }
      localObject1 = new ArrayList();
      int k = 0;
      while (k < this.e.rpt_msg_reddot_info.size())
      {
        oidb_0x791.RedDotInfo localRedDotInfo = (oidb_0x791.RedDotInfo)this.e.rpt_msg_reddot_info.get(k);
        localRedDotInfo.uint32_number.get();
        boolean bool = localRedDotInfo.bool_display_reddot.get();
        localRedDotInfo.uint64_cmd_uin.get();
        String str = localRedDotInfo.str_face_url.get().toStringUtf8();
        if ((61 == localRedDotInfo.uint32_appid.get()) && (bool) && (!TextUtils.isEmpty(str))) {
          ((ArrayList)localObject1).add(localRedDotInfo);
        }
        k += 1;
      }
      return localObject1;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public oidb_0x791.RedDotInfo e(int paramInt)
  {
    try
    {
      if (this.e == null) {
        this.e = y();
      }
      Object localObject3 = null;
      Object localObject1 = this.e;
      if (localObject1 == null) {
        return null;
      }
      int k = 0;
      for (;;)
      {
        localObject1 = localObject3;
        if (k >= this.e.rpt_msg_reddot_info.size()) {
          break;
        }
        localObject1 = (oidb_0x791.RedDotInfo)this.e.rpt_msg_reddot_info.get(k);
        if (paramInt == ((oidb_0x791.RedDotInfo)localObject1).uint32_appid.get())
        {
          boolean bool = ((oidb_0x791.RedDotInfo)localObject1).bool_display_reddot.get();
          if (bool) {
            break;
          }
        }
        k += 1;
      }
      return localObject1;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public ArrayList<oidb_0x791.RedDotInfo> f()
  {
    try
    {
      if (this.e == null) {
        this.e = y();
      }
      Object localObject1 = this.e;
      if (localObject1 == null) {
        return null;
      }
      localObject1 = new ArrayList();
      int k = 0;
      while (k < this.e.rpt_msg_reddot_info.size())
      {
        oidb_0x791.RedDotInfo localRedDotInfo = (oidb_0x791.RedDotInfo)this.e.rpt_msg_reddot_info.get(k);
        localRedDotInfo.uint32_number.get();
        boolean bool = localRedDotInfo.bool_display_reddot.get();
        localRedDotInfo.uint64_cmd_uin.get();
        String str = localRedDotInfo.str_face_url.get().toStringUtf8();
        if ((56 == localRedDotInfo.uint32_appid.get()) && (bool) && (!TextUtils.isEmpty(str))) {
          ((ArrayList)localObject1).add(localRedDotInfo);
        }
        k += 1;
      }
      return localObject1;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo g()
  {
    oidb_0x791.RedDotInfo localRedDotInfo = e(59);
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
  
  public BusinessInfoCheckUpdate.RedTypeInfo h()
  {
    if (e(65) != null)
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
    if (e(60) != null)
    {
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(0);
      localRedTypeInfo.red_content.set("");
      localRedTypeInfo.red_desc.set("");
      return localRedTypeInfo;
    }
    return null;
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo j()
  {
    if (e(53) != null)
    {
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(0);
      localRedTypeInfo.red_content.set("");
      localRedTypeInfo.red_desc.set("");
      return localRedTypeInfo;
    }
    return null;
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo k()
  {
    if (e(54) != null)
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
    if (e(70) != null)
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
  public BusinessInfoCheckUpdate.RedTypeInfo m()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 81	com/tencent/biz/TroopRedpoint/TroopRedTouchManager:e	Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   6: ifnonnull +11 -> 17
    //   9: aload_0
    //   10: aload_0
    //   11: invokespecial 541	com/tencent/biz/TroopRedpoint/TroopRedTouchManager:y	()Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   14: putfield 81	com/tencent/biz/TroopRedpoint/TroopRedTouchManager:e	Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   17: aload_0
    //   18: getfield 81	com/tencent/biz/TroopRedpoint/TroopRedTouchManager:e	Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
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
    //   40: ldc 171
    //   42: astore 9
    //   44: iconst_0
    //   45: istore_2
    //   46: iload_2
    //   47: aload_0
    //   48: getfield 81	com/tencent/biz/TroopRedpoint/TroopRedTouchManager:e	Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   51: getfield 96	tencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes:rpt_msg_reddot_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   54: invokevirtual 102	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   57: if_icmpge +510 -> 567
    //   60: aload_0
    //   61: getfield 81	com/tencent/biz/TroopRedpoint/TroopRedTouchManager:e	Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   64: getfield 96	tencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes:rpt_msg_reddot_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   67: iload_2
    //   68: invokevirtual 106	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   71: checkcast 108	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo
    //   74: astore 9
    //   76: aload 9
    //   78: getfield 232	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:uint32_number	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   81: invokevirtual 196	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   84: istore_3
    //   85: aload 9
    //   87: getfield 200	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:bool_display_reddot	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   90: invokevirtual 204	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   93: istore 7
    //   95: aload 9
    //   97: getfield 248	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:uint64_cmd_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   100: invokevirtual 252	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   103: lstore 4
    //   105: aload 9
    //   107: getfield 265	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:str_face_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   110: invokevirtual 123	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   113: invokevirtual 128	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   116: astore 12
    //   118: bipush 38
    //   120: aload 9
    //   122: getfield 192	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:uint32_appid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   125: invokevirtual 196	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   128: if_icmpne +422 -> 550
    //   131: iload 7
    //   133: ifne +7 -> 140
    //   136: iload_3
    //   137: ifle +413 -> 550
    //   140: aload 9
    //   142: getfield 112	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:str_custom_buffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   145: invokevirtual 118	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   148: ifeq +379 -> 527
    //   151: aload 9
    //   153: getfield 112	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:str_custom_buffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   156: invokevirtual 123	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   159: invokevirtual 128	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   162: astore 10
    //   164: new 120	org/json/JSONObject
    //   167: dup
    //   168: aload 10
    //   170: invokespecial 131	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   173: ldc_w 961
    //   176: invokevirtual 137	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   179: istore_1
    //   180: iload_1
    //   181: iconst_1
    //   182: if_icmpne +345 -> 527
    //   185: aload 9
    //   187: getfield 232	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:uint32_number	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   190: invokevirtual 196	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   193: istore_1
    //   194: aload 9
    //   196: getfield 200	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:bool_display_reddot	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   199: invokevirtual 204	com/tencent/mobileqq/pb/PBBoolField:get	()Z
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
    //   250: invokevirtual 536	java/lang/Exception:printStackTrace	()V
    //   253: goto +279 -> 532
    //   256: aload 10
    //   258: ifnull +252 -> 510
    //   261: new 659	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo
    //   264: dup
    //   265: invokespecial 928	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo:<init>	()V
    //   268: astore 11
    //   270: ldc_w 720
    //   273: invokestatic 401	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   276: checkcast 720	com/tencent/mobileqq/nearby/redtouch/INearbyRedDotCustomInfo
    //   279: astore 13
    //   281: aload 13
    //   283: aload 10
    //   285: invokeinterface 965 2 0
    //   290: iload 7
    //   292: ifne +8 -> 300
    //   295: iload 6
    //   297: ifeq +208 -> 505
    //   300: iload_1
    //   301: ifle +93 -> 394
    //   304: aload 11
    //   306: getfield 662	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo:red_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   309: iconst_5
    //   310: invokevirtual 894	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   313: aload 11
    //   315: getfield 666	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo:red_content	Lcom/tencent/mobileqq/pb/PBStringField;
    //   318: iload_1
    //   319: invokestatic 967	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   322: invokevirtual 930	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   325: aload 10
    //   327: getfield 112	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:str_custom_buffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   330: invokevirtual 118	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   333: istore 6
    //   335: iload 6
    //   337: ifeq +32 -> 369
    //   340: aload 13
    //   342: invokeinterface 970 1 0
    //   347: ifne +22 -> 369
    //   350: aload 11
    //   352: getfield 662	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo:red_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   355: iconst_0
    //   356: invokevirtual 894	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   359: goto +10 -> 369
    //   362: astore 9
    //   364: aload 9
    //   366: invokevirtual 536	java/lang/Exception:printStackTrace	()V
    //   369: aload_0
    //   370: aload 12
    //   372: lload 4
    //   374: aload 13
    //   376: invokevirtual 972	com/tencent/biz/TroopRedpoint/TroopRedTouchManager:a	(Ljava/lang/String;JLcom/tencent/mobileqq/nearby/redtouch/INearbyRedDotCustomInfo;)Ljava/lang/String;
    //   379: astore 9
    //   381: aload 11
    //   383: getfield 933	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo:red_desc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   386: aload 9
    //   388: invokevirtual 930	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   391: goto +114 -> 505
    //   394: aload 9
    //   396: ifnull +80 -> 476
    //   399: aload 9
    //   401: getfield 112	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:str_custom_buffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   404: invokevirtual 123	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   407: invokevirtual 128	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   410: astore 9
    //   412: aload 11
    //   414: getfield 666	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo:red_content	Lcom/tencent/mobileqq/pb/PBStringField;
    //   417: iload_2
    //   418: invokestatic 967	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   421: invokevirtual 930	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   424: new 120	org/json/JSONObject
    //   427: dup
    //   428: aload 9
    //   430: invokespecial 131	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   433: ldc_w 973
    //   436: invokevirtual 137	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   439: ifeq +15 -> 454
    //   442: aload 11
    //   444: getfield 662	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo:red_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   447: iconst_0
    //   448: invokevirtual 894	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   451: goto +54 -> 505
    //   454: aload 11
    //   456: getfield 662	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo:red_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   459: iconst_5
    //   460: invokevirtual 894	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   463: goto +42 -> 505
    //   466: astore 9
    //   468: aload 9
    //   470: invokevirtual 536	java/lang/Exception:printStackTrace	()V
    //   473: goto +32 -> 505
    //   476: aload 11
    //   478: getfield 662	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo:red_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   481: iconst_0
    //   482: invokevirtual 894	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   485: aload 11
    //   487: getfield 666	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo:red_content	Lcom/tencent/mobileqq/pb/PBStringField;
    //   490: ldc 171
    //   492: invokevirtual 930	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   495: aload 11
    //   497: getfield 933	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo:red_desc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   500: ldc 171
    //   502: invokevirtual 930	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
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
    //   39	525	1	k	int
    //   45	527	2	m	int
    //   84	479	3	n	int
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
  
  public NearbyRedNum n()
  {
    for (;;)
    {
      try
      {
        localNearbyRedNum = new NearbyRedNum();
        if (this.h == null) {
          this.h = z();
        }
        k = this.h.size();
        if (k <= 0) {
          return localNearbyRedNum;
        }
        Iterator localIterator = this.h.entrySet().iterator();
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
        int k = 0;
        continue;
      }
      try
      {
        localNearbyRedNum.a = ((oidb_0x791.RedDotInfo)localObject2).uint32_number.get();
        localObject2 = new JSONObject(str);
        if (((JSONObject)localObject2).optInt("official_topic") != 1) {
          continue;
        }
        k = 1;
        if (k != 0) {
          localNearbyRedNum.b += 1;
        }
        k = ((JSONObject)localObject2).optInt("red_content_type");
        if (k == 1) {
          localNearbyRedNum.c += 1;
        } else if (k == 2) {
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
  
  public BusinessInfoCheckUpdate.RedTypeInfo o()
  {
    if (e(42) != null)
    {
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(0);
      localRedTypeInfo.red_content.set("");
      localRedTypeInfo.red_desc.set("");
      return localRedTypeInfo;
    }
    return null;
  }
  
  public void onDestroy()
  {
    a(this.e);
    x();
  }
  
  public boolean p()
  {
    String str = this.a.getCurrentAccountUin();
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.a.getApp());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("troop_nearby_red_point_state_");
    localStringBuilder.append(str);
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), true);
  }
  
  public oidb_0x791.RedDotInfo q()
  {
    for (;;)
    {
      try
      {
        if (this.e == null) {
          this.e = y();
        }
        localObject1 = this.e;
        if (localObject1 == null) {
          return null;
        }
        bool1 = ((MsgTabStoryNodeConfigManager)this.a.getManager(QQManagerFactory.MSG_TAB_STORY_CONFIG_MANAGER)).a;
        bool2 = this.a.getNowLiveManager().d;
        localIterator = this.e.rpt_msg_reddot_info.get().iterator();
        localObject1 = null;
      }
      finally
      {
        Object localObject1;
        boolean bool1;
        boolean bool2;
        Iterator localIterator;
        Object localObject3;
        int k;
        continue;
        throw localObject2;
        continue;
        if (((k == 37) && (bool2)) || (k == 48)) {
          continue;
        }
        if ((bool1) || (k != 28)) {
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
        k = ((oidb_0x791.RedDotInfo)localObject3).uint32_appid.get();
        if (TroopRedTouchConfigure.b(k))
        {
          if ((k != 37) || (((oidb_0x791.RedDotInfo)localObject3).uint32_expire_time.get() >= NetConnInfoCenter.getServerTime())) {
            continue;
          }
          SLog.d(this.d, "%d red dot time out", new Object[] { Integer.valueOf(k) });
          continue;
          if (((k != RedPointUtils.a(this.a)) || (((oidb_0x791.RedDotInfo)localObject3).uint32_number.get() > 0)) && (TroopRedTouchConfigure.a((oidb_0x791.RedDotInfo)localObject3, (oidb_0x791.RedDotInfo)localObject1) > 0)) {
            localObject1 = localObject3;
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("return:");
      ((StringBuilder)localObject3).append(b((oidb_0x791.RedDotInfo)localObject1));
      QLog.d("Q.qqstory.redPoint", 2, ((StringBuilder)localObject3).toString());
    }
    return null;
  }
  
  public int r()
  {
    oidb_0x791.RedDotInfo localRedDotInfo = q();
    if (localRedDotInfo == null) {
      return 0;
    }
    int k = localRedDotInfo.uint32_appid.get();
    if (k != 8)
    {
      if (k != 11)
      {
        if (k != 35)
        {
          if (k != 37)
          {
            if (k != 52) {
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
  
  public int s()
  {
    oidb_0x791.RedDotInfo localRedDotInfo = q();
    if (localRedDotInfo == null) {
      return 0;
    }
    return localRedDotInfo.uint32_report_type.get();
  }
  
  public void t()
  {
    try
    {
      if (this.e == null) {
        this.e = y();
      }
      localObject1 = this.e;
      if (localObject1 == null) {
        return;
      }
      localObject1 = new StringBuilder("clearStoryWeakRedPoint==>");
      k = this.e.rpt_msg_reddot_info.size() - 1;
    }
    finally
    {
      for (;;)
      {
        Object localObject1;
        int k;
        Object localObject3;
        for (;;)
        {
          throw localObject2;
        }
        k -= 1;
      }
    }
    if (k >= 0)
    {
      localObject3 = (oidb_0x791.RedDotInfo)this.e.rpt_msg_reddot_info.get(k);
      if ((((oidb_0x791.RedDotInfo)localObject3).bool_display_reddot.get()) && (TroopRedTouchConfigure.a(((oidb_0x791.RedDotInfo)localObject3).uint32_appid.get())))
      {
        this.e.rpt_msg_reddot_info.remove(k);
        TroopRedTouchHandler.a(this.a, (oidb_0x791.RedDotInfo)localObject3);
        ((StringBuilder)localObject1).append(b((oidb_0x791.RedDotInfo)localObject3));
        ((StringBuilder)localObject1).append("|");
      }
    }
    else
    {
      a(this.e);
      if (!this.a.getNowLiveManager().d)
      {
        localObject3 = (ILebaHelperService)this.a.getRuntimeService(ILebaHelperService.class, "");
        if (localObject3 != null) {
          ((ILebaHelperService)localObject3).setFlagUpdateOnPause();
        } else {
          QLog.d(this.d, 1, "clearStoryWeakRedPoint lebaHelperService == null");
        }
      }
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(this.d);
        ((StringBuilder)localObject3).append("Q.qqstory.redPoint");
        QLog.d(((StringBuilder)localObject3).toString(), 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
  }
  
  public int u()
  {
    if (this.e == null) {
      this.e = y();
    }
    Object localObject = this.e;
    int k = 0;
    if (localObject == null) {
      return 0;
    }
    int n;
    for (int m = 0; k < this.e.rpt_msg_reddot_info.size(); m = n)
    {
      localObject = (oidb_0x791.RedDotInfo)this.e.rpt_msg_reddot_info.get(k);
      if (!((oidb_0x791.RedDotInfo)localObject).bool_display_reddot.get())
      {
        n = m;
      }
      else
      {
        int i1 = ((oidb_0x791.RedDotInfo)localObject).uint32_appid.get();
        if (((6 != i1) || (m != 0)) && (2 != i1) && (3 != i1) && (4 != i1) && (5 != i1))
        {
          n = m;
          if (((oidb_0x791.RedDotInfo)localObject).uint32_number.get() > 0)
          {
            n = m;
            if (7 == ((oidb_0x791.RedDotInfo)localObject).uint32_appid.get()) {
              return i1;
            }
          }
        }
        else
        {
          n = i1;
        }
      }
      k += 1;
    }
    return m;
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo v()
  {
    try
    {
      if (this.e == null) {
        this.e = y();
      }
      localObject1 = this.e;
      if (localObject1 == null) {
        return null;
      }
      l1 = 0L;
      k = 0;
      bool1 = false;
      localObject1 = "";
      m = 0;
    }
    finally
    {
      for (;;)
      {
        Object localObject1;
        long l1;
        int k;
        boolean bool1;
        int m;
        oidb_0x791.RedDotInfo localRedDotInfo;
        Object localObject5;
        for (;;)
        {
          throw localObject2;
        }
        label345:
        m += 1;
        Object localObject3 = localObject5;
        continue;
        Object localObject4 = null;
        int n = k;
        long l2 = l1;
        boolean bool2 = bool1;
      }
    }
    if (m < this.e.rpt_msg_reddot_info.size())
    {
      localRedDotInfo = (oidb_0x791.RedDotInfo)this.e.rpt_msg_reddot_info.get(m);
      k = localRedDotInfo.uint32_number.get();
      bool1 = localRedDotInfo.bool_display_reddot.get();
      l1 = localRedDotInfo.uint64_cmd_uin.get();
      localObject5 = localRedDotInfo.str_face_url.get().toStringUtf8();
      if (63 == localRedDotInfo.uint32_appid.get())
      {
        localObject4 = localRedDotInfo;
        n = k;
        l2 = l1;
        bool2 = bool1;
        localObject1 = localObject5;
        if (!bool1)
        {
          if ((bool1) || (k <= 0)) {
            break label345;
          }
          localObject4 = localRedDotInfo;
          n = k;
          l2 = l1;
          bool2 = bool1;
          localObject1 = localObject5;
        }
        if (localObject4 != null)
        {
          localObject4 = new BusinessInfoCheckUpdate.RedTypeInfo();
          if (bool2) {
            if (n > 0)
            {
              if (n <= 99) {}
              ((BusinessInfoCheckUpdate.RedTypeInfo)localObject4).red_type.set(5);
              ((BusinessInfoCheckUpdate.RedTypeInfo)localObject4).red_content.set(String.valueOf(n));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.TroopRedpoint.TroopRedTouchManager
 * JD-Core Version:    0.7.0.1
 */