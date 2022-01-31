package com.tencent.biz.TroopRedpoint;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryNodeConfigManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.RedPointUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.NearbyConfigUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import kkv;
import mqq.manager.Manager;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x791.oidb_0x791.GetRedDotRes;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class TroopRedTouchManager
  implements Manager
{
  public static final String c = String.valueOf(System.currentTimeMillis());
  public QQAppInterface a;
  final String jdField_a_of_type_JavaLangString = "TroopRedTouchManager2_";
  oidb_0x791.GetRedDotRes jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes;
  boolean jdField_a_of_type_Boolean = false;
  public final String b = TroopRedTouchManager.class.getSimpleName();
  
  public TroopRedTouchManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static String a(oidb_0x791.RedDotInfo paramRedDotInfo)
  {
    if (paramRedDotInfo == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder("redDotInfo2String, oidb_0x791.RedDotInfo:");
    localStringBuilder.append("uint32_appid:").append(paramRedDotInfo.uint32_appid.get()).append("|redDotInfo.bool_display_reddot:").append(paramRedDotInfo.bool_display_reddot.get()).append("|uint32_number:").append(paramRedDotInfo.uint32_number.get()).append("|uint32_reason:").append(paramRedDotInfo.uint32_reason.get()).append("|uint32_last_time:").append(paramRedDotInfo.uint32_last_time.get()).append("|uint64_cmd_uin:").append(paramRedDotInfo.uint64_cmd_uin.get()).append("|uint32_cmd_uin_type:").append(paramRedDotInfo.uint32_cmd_uin_type.get()).append("|str_face_url:").append(paramRedDotInfo.str_face_url.get().toStringUtf8()).append("|str_custom_buffer:").append(paramRedDotInfo.str_custom_buffer.get().toStringUtf8()).append("|uint32_expire_time:").append(paramRedDotInfo.uint32_expire_time.get());
    return localStringBuilder.toString();
  }
  
  /* Error */
  private oidb_0x791.GetRedDotRes a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 164	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: getfield 50	com/tencent/biz/TroopRedpoint/TroopRedTouchManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10: invokevirtual 170	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   13: invokevirtual 176	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   16: new 55	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   23: ldc 36
    //   25: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_0
    //   29: getfield 50	com/tencent/biz/TroopRedpoint/TroopRedTouchManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   32: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   35: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokespecial 183	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   44: invokestatic 188	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;)[B
    //   47: astore_3
    //   48: new 190	tencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes
    //   51: dup
    //   52: invokespecial 191	tencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes:<init>	()V
    //   55: astore_1
    //   56: aload_1
    //   57: astore_2
    //   58: aload_3
    //   59: ifnull +11 -> 70
    //   62: aload_1
    //   63: aload_3
    //   64: invokevirtual 195	tencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   67: pop
    //   68: aload_1
    //   69: astore_2
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_2
    //   73: areturn
    //   74: astore_2
    //   75: aconst_null
    //   76: astore_1
    //   77: aload_2
    //   78: invokevirtual 198	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   81: aload_1
    //   82: astore_2
    //   83: goto -13 -> 70
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    //   91: astore_2
    //   92: aconst_null
    //   93: astore_1
    //   94: aload_2
    //   95: invokevirtual 199	java/lang/NullPointerException:printStackTrace	()V
    //   98: aload_1
    //   99: astore_2
    //   100: goto -30 -> 70
    //   103: astore_2
    //   104: goto -10 -> 94
    //   107: astore_2
    //   108: goto -31 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	TroopRedTouchManager
    //   55	27	1	localGetRedDotRes1	oidb_0x791.GetRedDotRes
    //   86	4	1	localObject1	Object
    //   93	6	1	localObject2	Object
    //   57	16	2	localGetRedDotRes2	oidb_0x791.GetRedDotRes
    //   74	4	2	localInvalidProtocolBufferMicroException1	InvalidProtocolBufferMicroException
    //   82	1	2	localGetRedDotRes3	oidb_0x791.GetRedDotRes
    //   91	4	2	localNullPointerException1	java.lang.NullPointerException
    //   99	1	2	localObject3	Object
    //   103	1	2	localNullPointerException2	java.lang.NullPointerException
    //   107	1	2	localInvalidProtocolBufferMicroException2	InvalidProtocolBufferMicroException
    //   47	17	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   2	56	74	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2	56	86	finally
    //   62	68	86	finally
    //   77	81	86	finally
    //   94	98	86	finally
    //   2	56	91	java/lang/NullPointerException
    //   62	68	103	java/lang/NullPointerException
    //   62	68	107	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  private void a(oidb_0x791.GetRedDotRes paramGetRedDotRes)
  {
    if (paramGetRedDotRes == null) {}
    for (;;)
    {
      return;
      try
      {
        ThreadManager.post(new kkv(this, paramGetRedDotRes), 5, null, false);
      }
      finally {}
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
      this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = a();
    }
    if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
      return 0;
    }
    int i = 0;
    int j = 0;
    if (i < this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size())
    {
      oidb_0x791.RedDotInfo localRedDotInfo = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(i);
      int k;
      if (!localRedDotInfo.bool_display_reddot.get()) {
        k = j;
      }
      for (;;)
      {
        i += 1;
        j = k;
        break;
        boolean bool = SharedPreUtils.k(BaseApplicationImpl.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        k = j;
        if (localRedDotInfo.uint32_number.get() > 0)
        {
          k = j;
          if (7 == localRedDotInfo.uint32_appid.get())
          {
            k = j;
            if (bool) {
              k = j + localRedDotInfo.uint32_number.get();
            }
          }
        }
      }
    }
    return j;
  }
  
  public int a(QQAppInterface paramQQAppInterface)
  {
    int j = 0;
    int k = 0;
    if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
      this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = a();
    }
    if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
      return k;
    }
    boolean bool2 = false;
    int i = 0;
    boolean bool1 = false;
    boolean bool3 = a();
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo1;
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo2;
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo3;
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo5;
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo6;
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo7;
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo8;
    if ((bool3) && (paramQQAppInterface != null))
    {
      localRedTypeInfo1 = a();
      if (NearbyConfigUtil.a(paramQQAppInterface))
      {
        bool2 = true;
        localRedTypeInfo2 = b();
        localRedTypeInfo3 = d();
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo4 = e();
        localRedTypeInfo5 = h();
        localRedTypeInfo6 = i();
        localRedTypeInfo7 = g();
        localRedTypeInfo8 = j();
        if ((localRedTypeInfo4 != null) && (NearbyConfigUtil.a(paramQQAppInterface, 1)))
        {
          bool1 = true;
          i = 1;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("nearby.redpoint", 2, "TroopRedTouchMgr->getLebaRedPoint, needShow=" + bool3 + ", isNewTab=" + bool2 + ", redType=" + i + ", isNearbyRedPoint=" + bool1);
      }
      k = 0;
      i = j;
      j = k;
      label203:
      k = i;
      if (j >= this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size()) {
        break;
      }
      paramQQAppInterface = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(j);
      if (!paramQQAppInterface.bool_display_reddot.get()) {
        k = i;
      }
      for (;;)
      {
        j += 1;
        i = k;
        break label203;
        if ((localRedTypeInfo1 != null) && (NearbyConfigUtil.a(paramQQAppInterface, 2)))
        {
          bool1 = true;
          i = 2;
          break;
        }
        if ((localRedTypeInfo2 != null) && (NearbyConfigUtil.a(paramQQAppInterface, 3)))
        {
          bool1 = true;
          i = 3;
          break;
        }
        if ((localRedTypeInfo3 != null) && (NearbyConfigUtil.a(paramQQAppInterface, 5)))
        {
          bool1 = true;
          i = 4;
          break;
        }
        if ((localRedTypeInfo5 != null) && (NearbyConfigUtil.a(paramQQAppInterface, 4)))
        {
          bool1 = true;
          i = 5;
          break;
        }
        if ((localRedTypeInfo6 != null) && (NearbyConfigUtil.a(paramQQAppInterface, 6)))
        {
          bool1 = true;
          i = 6;
          break;
        }
        if ((localRedTypeInfo7 != null) && (NearbyConfigUtil.a(paramQQAppInterface, 1)))
        {
          bool1 = true;
          i = 7;
          break;
        }
        if (localRedTypeInfo8 == null) {
          break;
        }
        bool1 = true;
        i = 8;
        break;
        if (c() != null)
        {
          i = 11;
          bool1 = true;
          break;
        }
        if ((localRedTypeInfo1 == null) || (!NearbyConfigUtil.a(paramQQAppInterface, 1001))) {
          break label629;
        }
        i = 12;
        bool1 = true;
        break;
        int m = paramQQAppInterface.uint32_appid.get();
        if ((1 != m) && (6 != m) && (2 != m) && (3 != m) && (4 != m) && (5 != m) && ((!TroopRedTouchConfigure.d(m)) || (!bool1)) && ((!TroopRedTouchConfigure.e(m)) || (!bool1)) && ((!TroopRedTouchConfigure.f(m)) || (!bool1)) && ((!TroopRedTouchConfigure.g(m)) || (!bool1)) && ((!TroopRedTouchConfigure.h(m)) || (!bool1)) && ((m != 39) || (!bool1)) && ((m != 40) || (!bool1)) && ((m != 41) || (!bool1)) && ((m != 42) || (!bool1)))
        {
          k = i;
          if (TroopRedTouchConfigure.b(m))
          {
            k = i;
            if (!b()) {}
          }
        }
        else
        {
          k = i + 1;
        }
      }
      label629:
      i = 0;
      bool1 = false;
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
  
  public oidb_0x791.RedDotInfo a()
  {
    Object localObject1 = null;
    Object localObject3 = null;
    label308:
    label356:
    for (;;)
    {
      boolean bool1;
      boolean bool2;
      int i;
      try
      {
        if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
          this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = a();
        }
        Object localObject4 = this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes;
        if (localObject4 == null) {
          return localObject3;
        }
        bool1 = ((MsgTabStoryNodeConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(251)).jdField_a_of_type_Boolean;
        bool2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_Boolean;
        localObject4 = this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get().iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break label308;
        }
        localObject3 = (oidb_0x791.RedDotInfo)((Iterator)localObject4).next();
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.redPoint", 2, "for:" + a((oidb_0x791.RedDotInfo)localObject3));
        }
        if (!((oidb_0x791.RedDotInfo)localObject3).bool_display_reddot.get()) {
          continue;
        }
        i = ((oidb_0x791.RedDotInfo)localObject3).uint32_appid.get();
        if (!TroopRedTouchConfigure.b(i)) {
          continue;
        }
        if ((i == 37) && (((oidb_0x791.RedDotInfo)localObject3).uint32_expire_time.get() < NetConnInfoCenter.getServerTime()))
        {
          SLog.d(this.b, "%d red dot time out", new Object[] { Integer.valueOf(i) });
          continue;
        }
        if (i != 37) {}
      }
      finally {}
      if ((!bool2) && (i != 48) && ((bool1) || (i != 28)) && ((!bool1) || (i != 49)) && ((i != 35) || (!bool1)) && ((i != RedPointUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (((oidb_0x791.RedDotInfo)localObject3).uint32_number.get() > 0))) {
        if (TroopRedTouchConfigure.a((oidb_0x791.RedDotInfo)localObject3, localRedDotInfo) > 0)
        {
          Object localObject2 = localObject3;
          break label356;
          localObject3 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.qqstory.redPoint", 2, "return:" + a(localObject2));
            localObject3 = localObject2;
          }
        }
      }
    }
  }
  
  public oidb_0x791.RedDotInfo a(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
          this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = a();
        }
        oidb_0x791.RedDotInfo localRedDotInfo = null;
        oidb_0x791.GetRedDotRes localGetRedDotRes = this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes;
        if (localGetRedDotRes == null) {
          return localRedDotInfo;
        }
        int i = 0;
        if (i < this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size())
        {
          localRedDotInfo = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(i);
          if (paramInt == localRedDotInfo.uint32_appid.get())
          {
            boolean bool = localRedDotInfo.bool_display_reddot.get();
            if (bool) {}
          }
          else
          {
            i += 1;
          }
        }
        else
        {
          Object localObject2 = null;
        }
      }
      finally {}
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
    oidb_0x791.RedDotInfo localRedDotInfo2;
    if (i < this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size())
    {
      localRedDotInfo2 = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(i);
      if (paramInt == localRedDotInfo2.uint32_appid.get())
      {
        localRedDotInfo1 = localRedDotInfo2;
        if (paramBoolean) {
          if (!localRedDotInfo2.bool_display_reddot.get()) {
            break label94;
          }
        }
      }
    }
    for (oidb_0x791.RedDotInfo localRedDotInfo1 = localRedDotInfo2;; localRedDotInfo1 = null)
    {
      return localRedDotInfo1;
      label94:
      i += 1;
      break;
    }
  }
  
  public void a()
  {
    for (;;)
    {
      int i;
      try
      {
        if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
          this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = a();
        }
        Object localObject1 = this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes;
        if (localObject1 == null) {
          return;
        }
        localObject1 = new StringBuilder("clearStoryWeakRedPoint==>");
        i = this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size() - 1;
        if (i >= 0)
        {
          oidb_0x791.RedDotInfo localRedDotInfo = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(i);
          if ((!localRedDotInfo.bool_display_reddot.get()) || (!TroopRedTouchConfigure.a(localRedDotInfo.uint32_appid.get()))) {
            break label209;
          }
          this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.remove(i);
          TroopRedTouchHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRedDotInfo);
          ((StringBuilder)localObject1).append(a(localRedDotInfo)).append("|");
        }
      }
      finally {}
      a(this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes);
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_Boolean) {
        LebaShowListManager.a |= 0x2;
      }
      if (QLog.isColorLevel())
      {
        QLog.d(this.b + "Q.qqstory.redPoint", 2, localObject2.toString());
        continue;
        label209:
        i -= 1;
      }
    }
  }
  
  public void a(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
          this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = a();
        }
        Object localObject1 = this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes;
        if (localObject1 == null) {
          return;
        }
        localObject1 = new StringBuilder("clearStoryRedPointByAppId==>");
        int i = this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size() - 1;
        if (i >= 0)
        {
          oidb_0x791.RedDotInfo localRedDotInfo = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(i);
          if ((localRedDotInfo.bool_display_reddot.get()) && (localRedDotInfo.uint32_appid.get() == paramInt))
          {
            this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.remove(i);
            TroopRedTouchHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRedDotInfo);
            ((StringBuilder)localObject1).append(a(localRedDotInfo)).append("|");
          }
        }
        else
        {
          a(this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(this.b + "Q.qqstory.redPoint", 2, ((StringBuilder)localObject1).toString());
          continue;
        }
        i -= 1;
      }
      finally {}
    }
  }
  
  public void a(oidb_0x791.RedDotInfo paramRedDotInfo)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
          this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = a();
        }
        oidb_0x791.GetRedDotRes localGetRedDotRes = this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes;
        if ((localGetRedDotRes == null) || (paramRedDotInfo == null)) {
          return;
        }
        i = 0;
        if (i >= this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size()) {
          break label131;
        }
        if (((oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(i)).uint32_appid.get() == paramRedDotInfo.uint32_appid.get())
        {
          this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.set(i, paramRedDotInfo);
          i = 1;
          if (i == 0) {
            this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.add(paramRedDotInfo);
          }
          a(this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes);
          continue;
        }
        i += 1;
      }
      finally {}
      continue;
      label131:
      int i = 0;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).edit();
    localEditor.putBoolean("troop_nearby_red_point_state_" + str, paramBoolean);
    localEditor.commit();
  }
  
  public boolean a()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    return PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).getBoolean("troop_nearby_red_point_state_" + str, true);
  }
  
  public boolean a(int paramInt)
  {
    if (paramInt == 0) {}
    do
    {
      return false;
      if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
        this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = a();
      }
    } while (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null);
    int i = 0;
    label30:
    oidb_0x791.RedDotInfo localRedDotInfo;
    if (i < this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size())
    {
      localRedDotInfo = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(i);
      if (localRedDotInfo.bool_display_reddot.get()) {
        break label76;
      }
    }
    label76:
    do
    {
      do
      {
        i += 1;
        break label30;
        break;
      } while (localRedDotInfo.uint32_appid.get() != paramInt);
      if (paramInt != 7) {
        return true;
      }
    } while (localRedDotInfo.uint32_number.get() <= 0);
    return true;
  }
  
  public boolean a(List paramList, oidb_0x791.GetRedDotRes paramGetRedDotRes)
  {
    for (;;)
    {
      int i;
      try
      {
        int k = paramGetRedDotRes.rpt_msg_reddot_info.size();
        i = 0;
        bool = false;
        if (i < k)
        {
          oidb_0x791.RedDotInfo localRedDotInfo1 = (oidb_0x791.RedDotInfo)paramGetRedDotRes.rpt_msg_reddot_info.get(i);
          paramList.remove(Integer.valueOf(localRedDotInfo1.uint32_appid.get()));
          int m = this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size();
          j = 0;
          if (j >= m) {
            break label531;
          }
          oidb_0x791.RedDotInfo localRedDotInfo2 = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(j);
          if (localRedDotInfo2.uint32_appid.get() != localRedDotInfo1.uint32_appid.get()) {
            break label550;
          }
          m = localRedDotInfo1.uint32_appid.get();
          if ((TroopRedTouchConfigure.b(m)) || (TroopRedTouchConfigure.c(m)))
          {
            if (localRedDotInfo1.uint32_last_time.get() <= localRedDotInfo2.uint32_last_time.get()) {
              break label528;
            }
            if (QLog.isColorLevel()) {
              QLog.d(this.b + "Q.qqstory.redPoint", 2, "网络红点比本地红点新，netRedPoint：" + a(localRedDotInfo1) + "|localRedPoint:" + a(localRedDotInfo2));
            }
            this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.set(j, localRedDotInfo1);
            if (!TroopRedTouchConfigure.c(m)) {
              break label522;
            }
            a(true);
            bool = true;
            break label537;
            if (j == 0) {
              break label519;
            }
            this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.add(localRedDotInfo1);
            bool = true;
            break label543;
          }
          this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.set(j, localRedDotInfo1);
          bool = true;
          break label537;
        }
        j = this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size();
        i = 0;
        if (i < j)
        {
          paramGetRedDotRes = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(i);
          if (paramList.contains(Integer.valueOf(paramGetRedDotRes.uint32_appid.get())))
          {
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
            break label559;
          }
        }
        else
        {
          if (bool) {
            a(this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes);
          }
          if (QLog.isColorLevel()) {
            QLog.d(this.b + "Q.qqstory.redPoint", 2, "setAll==>拉回来的红点数据与本地的做对比，对比uint32_last_time, reult:" + bool);
          }
          return bool;
        }
      }
      finally {}
      break label559;
      label519:
      break label543;
      label522:
      boolean bool = true;
      break label537;
      label528:
      break label537;
      label531:
      int j = 1;
      continue;
      label537:
      j = 0;
      continue;
      label543:
      i += 1;
      continue;
      label550:
      j += 1;
      continue;
      label559:
      i += 1;
    }
  }
  
  public boolean a(boolean paramBoolean, int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        localRedDotInfo1 = a(paramInt3);
        if (localRedDotInfo1 != null) {
          continue;
        }
        paramBoolean = bool;
      }
      finally
      {
        try
        {
          oidb_0x791.RedDotInfo localRedDotInfo1;
          oidb_0x791.RedDotInfo localRedDotInfo2;
          localRedDotInfo2.mergeFrom(localRedDotInfo1.toByteArray());
          if (localRedDotInfo2.uint32_last_time.get() > paramInt2)
          {
            paramBoolean = bool;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d(this.b + "Q.qqstory.redPoint", 2, "result is out of date, current:" + paramInt2 + ", last:" + localRedDotInfo2.uint32_last_time.get());
            paramBoolean = bool;
            continue;
          }
          localRedDotInfo2.bool_display_reddot.set(paramBoolean);
          localRedDotInfo2.uint32_number.set(paramInt1);
          localRedDotInfo2.uint64_cmd_uin.set(paramLong);
          localRedDotInfo2.uint32_last_time.set(paramInt2);
          a(localRedDotInfo2);
          if (QLog.isColorLevel()) {
            QLog.d(this.b + "Q.qqstory.redPoint", 2, "updateStoryMessageRedPoint==>" + a(localRedDotInfo2));
          }
          paramBoolean = true;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          paramBoolean = bool;
        }
        localObject = finally;
      }
      return paramBoolean;
      localRedDotInfo2 = new oidb_0x791.RedDotInfo();
    }
  }
  
  public int b()
  {
    oidb_0x791.RedDotInfo localRedDotInfo = a();
    if (localRedDotInfo == null) {
      return 0;
    }
    switch (localRedDotInfo.uint32_appid.get())
    {
    default: 
      return 0;
    case 8: 
      return 1;
    case 35: 
      return 2;
    case 28: 
    case 49: 
      return 3;
    case 11: 
      return 4;
    }
    return 8;
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
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b())) {}
    oidb_0x791.RedDotInfo localRedDotInfo;
    do
    {
      return false;
      localRedDotInfo = a();
    } while ((localRedDotInfo == null) || (localRedDotInfo.uint32_appid.get() == 37));
    return true;
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
    if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
      return 0;
    }
    int m = 0;
    int i = 0;
    int k;
    if (m < this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size())
    {
      oidb_0x791.RedDotInfo localRedDotInfo = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(m);
      int j;
      if (!localRedDotInfo.bool_display_reddot.get()) {
        j = i;
      }
      label139:
      do
      {
        do
        {
          for (;;)
          {
            m += 1;
            i = j;
            break;
            k = localRedDotInfo.uint32_appid.get();
            if ((6 == k) && (i == 0))
            {
              j = k;
            }
            else
            {
              if ((1 != k) && (2 != k) && (3 != k) && (4 != k) && (5 != k)) {
                break label139;
              }
              j = k;
            }
          }
          j = i;
        } while (localRedDotInfo.uint32_number.get() <= 0);
        j = i;
      } while (7 != localRedDotInfo.uint32_appid.get());
    }
    for (;;)
    {
      return k;
      k = i;
    }
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo d()
  {
    Object localObject = a(29);
    oidb_0x791.RedDotInfo localRedDotInfo = a(30);
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
  
  public BusinessInfoCheckUpdate.RedTypeInfo e()
  {
    if (a(38) != null)
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
    if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
      this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = a();
    }
    if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
      return null;
    }
    long l1 = 0L;
    int i = 0;
    Object localObject1 = "";
    int j = 0;
    boolean bool1 = false;
    Object localObject3;
    Object localObject2;
    long l2;
    boolean bool2;
    int k;
    if (j < this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size())
    {
      oidb_0x791.RedDotInfo localRedDotInfo = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(j);
      i = localRedDotInfo.uint32_number.get();
      bool1 = localRedDotInfo.bool_display_reddot.get();
      l1 = localRedDotInfo.uint64_cmd_uin.get();
      localObject3 = localRedDotInfo.str_face_url.get().toStringUtf8();
      if (38 == localRedDotInfo.uint32_appid.get())
      {
        localObject2 = localRedDotInfo;
        localObject1 = localObject3;
        l2 = l1;
        bool2 = bool1;
        k = i;
        if (!bool1)
        {
          if ((bool1) || (i <= 0)) {
            break label273;
          }
          k = i;
          bool2 = bool1;
          l2 = l1;
          localObject1 = localObject3;
          localObject2 = localRedDotInfo;
        }
      }
    }
    for (;;)
    {
      if (localObject2 != null)
      {
        localObject3 = new BusinessInfoCheckUpdate.RedTypeInfo();
        if (bool2)
        {
          if (k <= 0) {
            break label303;
          }
          if (k <= 99) {
            break label284;
          }
          localObject2 = "99+";
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_type.set(5);
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_content.set((String)localObject2);
        }
        for (;;)
        {
          try
          {
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("faceUrl", localObject1);
            ((JSONObject)localObject2).put("uin", l2);
            ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_desc.set(((JSONObject)localObject2).toString());
            return localObject3;
            label273:
            j += 1;
            localObject1 = localObject3;
            break;
            label284:
            localObject2 = String.valueOf(k);
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            continue;
          }
          label303:
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_type.set(0);
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_content.set("");
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_desc.set("");
        }
      }
      return null;
      localObject2 = null;
      l2 = l1;
      bool2 = bool1;
      k = i;
    }
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo g()
  {
    if (a(39) != null)
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
    if (a(40) != null)
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
    if (a(41) != null)
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
  
  public void onDestroy()
  {
    a(this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.TroopRedpoint.TroopRedTouchManager
 * JD-Core Version:    0.7.0.1
 */