import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.onlinestatus.OnlineStatusFriendsPermissionItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime.Status;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.im.oidb.cmd0xe62.ReqBody;
import tencent.im.oidb.cmd0xe63.oidb_cmd0xe63.ReqBody;
import tencent.im.oidb.cmd0xe63.oidb_cmd0xe63.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class ayps
  extends MSFServlet
{
  public static NewIntent a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt, List<Long> paramList, ArrayList<Integer> paramArrayList, @NonNull Bundle paramBundle)
  {
    int j = 0;
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), ayps.class);
    localNewIntent.putExtra("param_online_status_request", 2);
    localNewIntent.putExtra("param_online_status_type", paramLong);
    localNewIntent.putExtra("param_has_all_permission", paramInt);
    if (paramList != null)
    {
      long[] arrayOfLong = new long[paramList.size()];
      i = 0;
      while (i < arrayOfLong.length)
      {
        arrayOfLong[i] = ((Long)paramList.get(i)).longValue();
        i += 1;
      }
      localNewIntent.putExtra("param_part_permission_list", arrayOfLong);
    }
    if (QLog.isColorLevel()) {
      if (paramList != null) {
        break label190;
      }
    }
    label190:
    for (int i = j;; i = paramList.size())
    {
      QLog.d("OnlineStatusPermissionServlet", 2, new Object[] { "hasAllPermission flag=", Integer.valueOf(paramInt), " partPermissionList=", Integer.valueOf(i) });
      localNewIntent.putExtra("param_extra_bundle", paramBundle);
      localNewIntent.putIntegerArrayListExtra("param_smart_status_list", paramArrayList);
      paramQQAppInterface.startServlet(localNewIntent);
      return localNewIntent;
    }
  }
  
  public static NewIntent a(QQAppInterface paramQQAppInterface, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusPermissionServlet", 2, new Object[] { "requestOnlineStatusPermission | onlineStatusType = ", Long.valueOf(paramLong) });
    }
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), ayps.class);
    localNewIntent.putExtra("param_online_status_request", 1);
    localNewIntent.putExtra("param_online_status_type", paramLong);
    localNewIntent.putExtra("param_fetch_only_smart_devices", paramBoolean1);
    localNewIntent.putExtra("from_register", paramBoolean2);
    paramQQAppInterface.startServlet(localNewIntent);
    return localNewIntent;
  }
  
  public static NewIntent a(QQAppInterface paramQQAppInterface, OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem, ArrayList<Integer> paramArrayList, boolean paramBoolean)
  {
    int i = 0;
    if (paramOnlineStatusPermissionItem != null)
    {
      if (!paramOnlineStatusPermissionItem.isAllHasPermission()) {
        break label112;
      }
      i = 1;
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusPermissionServlet", 2, new Object[] { "modifySmartOnlineStatusPermission flag=", Integer.valueOf(i), " size=", Integer.valueOf(paramOnlineStatusPermissionItem.getPermissionUins().size()) });
      }
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("param_need_switch_online_status", paramBoolean);
    localBundle.putInt("StatusId", 40001);
    if (paramOnlineStatusPermissionItem == null) {}
    for (paramOnlineStatusPermissionItem = null;; paramOnlineStatusPermissionItem = paramOnlineStatusPermissionItem.getPermissionUins())
    {
      return a(paramQQAppInterface, 40001L, i, paramOnlineStatusPermissionItem, paramArrayList, localBundle);
      label112:
      i = 2;
      break;
    }
  }
  
  private void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool2 = false;
    long l = paramIntent.getLongExtra("param_online_status_type", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusPermissionServlet", 2, new Object[] { "handleModifyOnlineStatusPermission | onlineStatusType = ", Long.valueOf(l) });
    }
    Bundle localBundle = paramIntent.getBundleExtra("param_extra_bundle");
    if (paramFromServiceMsg.isSuccess()) {}
    for (;;)
    {
      try
      {
        localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg;
        int i;
        paramFromServiceMsg = null;
      }
      try
      {
        paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        localObject2 = new byte[paramFromServiceMsg.getInt() - 4];
        paramFromServiceMsg.get((byte[])localObject2);
        localOIDBSSOPkg.mergeFrom((byte[])localObject2);
        localObject2 = localOIDBSSOPkg;
        i = ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("OnlineStatusPermissionServlet", 2, new Object[] { "handleModifyOnlineStatusPermission | result = ", Integer.valueOf(i) });
        }
        if (i != 0) {
          break;
        }
        if ((getAppRuntime() instanceof QQAppInterface))
        {
          paramFromServiceMsg = (QQAppInterface)getAppRuntime();
          a(paramFromServiceMsg, paramIntent);
          bool1 = localBundle.getBoolean("param_need_switch_online_status", false);
          i = localBundle.getInt("StatusId", 0);
          if (bool1) {
            paramFromServiceMsg.a(AppRuntime.Status.online, i);
          }
        }
        bool1 = true;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
      {
        for (;;)
        {
          paramFromServiceMsg = localInvalidProtocolBufferMicroException1;
          Object localObject1 = localInvalidProtocolBufferMicroException2;
        }
        bool1 = false;
        continue;
      }
      notifyObserver(paramIntent, 2, bool1, localBundle, aypr.class);
      return;
      Object localObject2 = paramFromServiceMsg;
      if (QLog.isColorLevel())
      {
        QLog.d("OnlineStatusPermissionServlet", 2, "handleModifyOnlineStatusPermission parseFrom byte", localInvalidProtocolBufferMicroException1);
        localObject2 = paramFromServiceMsg;
        continue;
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("OnlineStatusPermissionServlet", 2, "handleModifyOnlineStatusPermission | response.result = " + paramFromServiceMsg.getResultCode());
          bool1 = bool2;
        }
      }
    }
  }
  
  private void a(Intent paramIntent, Packet paramPacket)
  {
    long l = paramIntent.getLongExtra("param_online_status_type", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusPermissionServlet", 2, new Object[] { "packModifyOnlineStatusPermission | onlineStatusType = ", Long.valueOf(l) });
    }
    int i = paramIntent.getIntExtra("param_has_all_permission", 0);
    Object localObject = paramIntent.getLongArrayExtra("param_part_permission_list");
    ArrayList localArrayList1 = paramIntent.getIntegerArrayListExtra("param_smart_status_list");
    paramIntent = new cmd0xe62.ReqBody();
    if ((i == 1) || (i == 2))
    {
      paramIntent.set_type.set(i);
      if (localObject != null)
      {
        ArrayList localArrayList2 = new ArrayList(localObject.length);
        i = 0;
        while (i < localObject.length)
        {
          localArrayList2.add(Long.valueOf(localObject[i]));
          i += 1;
        }
        paramIntent.rpt_uint64_uin.set(localArrayList2);
      }
    }
    if (localArrayList1 != null) {
      if (localArrayList1.size() > 0) {
        break label280;
      }
    }
    label280:
    for (boolean bool = true;; bool = false)
    {
      paramIntent.bool_clear_smart_status.set(bool);
      paramIntent.rpt_uint32_smart_status.set(localArrayList1);
      localObject = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(3682);
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(2);
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramIntent.toByteArray()));
      paramIntent = ((oidb_sso.OIDBSSOPkg)localObject).toByteArray();
      paramPacket.setSSOCommand("OidbSvc.0xe63_1");
      localObject = ByteBuffer.allocate(paramIntent.length + 4);
      ((ByteBuffer)localObject).putInt(paramIntent.length + 4);
      ((ByteBuffer)localObject).put(paramIntent);
      paramPacket.putSendData(((ByteBuffer)localObject).array());
      return;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    int i = 0;
    aypo localaypo = (aypo)paramQQAppInterface.getManager(370);
    int j = paramIntent.getIntExtra("param_has_all_permission", 0);
    long[] arrayOfLong = paramIntent.getLongArrayExtra("param_part_permission_list");
    paramIntent = paramIntent.getIntegerArrayListExtra("param_smart_status_list");
    boolean bool;
    if ((j == 1) || (j == 2))
    {
      if (j == 1) {}
      for (bool = true;; bool = false)
      {
        if (arrayOfLong == null) {
          break label134;
        }
        paramQQAppInterface = new ArrayList(arrayOfLong.length);
        while (i < arrayOfLong.length)
        {
          paramQQAppInterface.add(Long.valueOf(arrayOfLong[i]));
          i += 1;
        }
      }
    }
    for (;;)
    {
      localaypo.a(new OnlineStatusFriendsPermissionItem(bool, paramQQAppInterface));
      if (paramIntent != null) {
        localaypo.a(paramIntent);
      }
      return;
      label134:
      paramQQAppInterface = null;
    }
  }
  
  private void a(oidb_cmd0xe63.RspBody paramRspBody)
  {
    oidb_cmd0xe63.RspBody localRspBody = null;
    boolean bool;
    if (paramRspBody.bool_online_status_visible_to_all_frd.has())
    {
      bool = paramRspBody.bool_online_status_visible_to_all_frd.get();
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusPermissionServlet", 2, new Object[] { "handleOnlineStatusPermission | entity.allHasPermission = ", Boolean.valueOf(bool) });
      }
    }
    for (;;)
    {
      Object localObject;
      if (paramRspBody.rpt_uint64_uin_can_see_my_online_status.has()) {
        if (paramRspBody.rpt_uint64_uin_can_see_my_online_status.get() == null)
        {
          localObject = new ArrayList(0);
          if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusPermissionServlet", 2, new Object[] { "handleOnlineStatusPermission | entity.hasPermissionList.size=", Integer.valueOf(((List)localObject).size()) });
          }
        }
      }
      for (;;)
      {
        if (paramRspBody.rpt_uint32_smart_status.has())
        {
          if (paramRspBody.rpt_uint32_smart_status.get() == null)
          {
            paramRspBody = new ArrayList(0);
            label142:
            if (QLog.isColorLevel()) {
              QLog.d("OnlineStatusPermissionServlet", 2, new Object[] { "handleOnlineStatusPermission | entity.smartSelectedStatusList.size=", Integer.valueOf(paramRspBody.size()) });
            }
            localRspBody = paramRspBody;
          }
        }
        else
        {
          if ((bool) || (localRspBody.size() > 0)) {
            break label231;
          }
          if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusPermissionServlet", 2, "saveReceiveData | params is error");
          }
        }
        label231:
        while (!(getAppRuntime() instanceof QQAppInterface))
        {
          return;
          localObject = paramRspBody.rpt_uint64_uin_can_see_my_online_status.get();
          break;
          paramRspBody = paramRspBody.rpt_uint32_smart_status.get();
          break label142;
        }
        paramRspBody = (aypo)((QQAppInterface)getAppRuntime()).getManager(370);
        localObject = new OnlineStatusFriendsPermissionItem(bool, (List)localObject);
        paramRspBody.a(localRspBody);
        paramRspBody.a((OnlineStatusFriendsPermissionItem)localObject);
        return;
        localObject = null;
      }
      bool = true;
    }
  }
  
  /* Error */
  private void b(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 31
    //   3: lconst_0
    //   4: invokevirtual 156	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   7: lstore 4
    //   9: aload_1
    //   10: ldc 112
    //   12: iconst_0
    //   13: invokevirtual 410	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   16: istore 6
    //   18: new 128	android/os/Bundle
    //   21: dup
    //   22: invokespecial 129	android/os/Bundle:<init>	()V
    //   25: astore 9
    //   27: aload 9
    //   29: ldc 112
    //   31: iload 6
    //   33: invokevirtual 135	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   36: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   39: ifeq +27 -> 66
    //   42: ldc 65
    //   44: iconst_2
    //   45: iconst_2
    //   46: anewarray 67	java/lang/Object
    //   49: dup
    //   50: iconst_0
    //   51: ldc_w 412
    //   54: aastore
    //   55: dup
    //   56: iconst_1
    //   57: lload 4
    //   59: invokestatic 105	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   62: aastore
    //   63: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   66: aload_2
    //   67: invokevirtual 167	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   70: ifeq +216 -> 286
    //   73: new 169	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   76: dup
    //   77: invokespecial 170	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   80: astore 7
    //   82: aload_2
    //   83: invokevirtual 174	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   86: invokestatic 180	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   89: astore_2
    //   90: aload_2
    //   91: invokevirtual 183	java/nio/ByteBuffer:getInt	()I
    //   94: iconst_4
    //   95: isub
    //   96: newarray byte
    //   98: astore 8
    //   100: aload_2
    //   101: aload 8
    //   103: invokevirtual 185	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   106: pop
    //   107: aload 7
    //   109: aload 8
    //   111: invokevirtual 189	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   114: pop
    //   115: aload 7
    //   117: astore 8
    //   119: aload 8
    //   121: getfield 193	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   124: invokevirtual 197	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   127: istore_3
    //   128: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   131: ifeq +26 -> 157
    //   134: ldc 65
    //   136: iconst_2
    //   137: iconst_2
    //   138: anewarray 67	java/lang/Object
    //   141: dup
    //   142: iconst_0
    //   143: ldc_w 414
    //   146: aastore
    //   147: dup
    //   148: iconst_1
    //   149: iload_3
    //   150: invokestatic 75	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   153: aastore
    //   154: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   157: iload_3
    //   158: ifne +122 -> 280
    //   161: aload 8
    //   163: getfield 319	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   166: invokevirtual 415	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   169: ifeq +111 -> 280
    //   172: aload 8
    //   174: getfield 319	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   177: invokevirtual 418	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   180: ifnull +100 -> 280
    //   183: aload 8
    //   185: getfield 319	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   188: invokevirtual 418	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   191: invokevirtual 419	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   194: astore_2
    //   195: new 378	tencent/im/oidb/cmd0xe63/oidb_cmd0xe63$RspBody
    //   198: dup
    //   199: invokespecial 420	tencent/im/oidb/cmd0xe63/oidb_cmd0xe63$RspBody:<init>	()V
    //   202: astore 7
    //   204: aload 7
    //   206: aload_2
    //   207: invokevirtual 421	tencent/im/oidb/cmd0xe63/oidb_cmd0xe63$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   210: pop
    //   211: aload_0
    //   212: aload 7
    //   214: invokespecial 423	ayps:a	(Ltencent/im/oidb/cmd0xe63/oidb_cmd0xe63$RspBody;)V
    //   217: iconst_1
    //   218: istore 6
    //   220: aload_0
    //   221: aload_1
    //   222: iconst_1
    //   223: iload 6
    //   225: aload 9
    //   227: ldc 224
    //   229: invokevirtual 228	ayps:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   232: return
    //   233: astore 7
    //   235: aconst_null
    //   236: astore_2
    //   237: aload_2
    //   238: astore 8
    //   240: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   243: ifeq -124 -> 119
    //   246: ldc 65
    //   248: iconst_2
    //   249: ldc_w 425
    //   252: aload 7
    //   254: invokestatic 233	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   257: aload_2
    //   258: astore 8
    //   260: goto -141 -> 119
    //   263: astore_2
    //   264: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   267: ifeq +13 -> 280
    //   270: ldc 65
    //   272: iconst_2
    //   273: ldc_w 427
    //   276: aload_2
    //   277: invokestatic 233	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   280: iconst_0
    //   281: istore 6
    //   283: goto -63 -> 220
    //   286: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   289: ifeq +32 -> 321
    //   292: ldc 65
    //   294: iconst_2
    //   295: new 235	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   302: ldc_w 429
    //   305: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: aload_2
    //   309: invokevirtual 245	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   312: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   315: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokestatic 255	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   321: iconst_0
    //   322: istore 6
    //   324: goto -104 -> 220
    //   327: astore 8
    //   329: aload 7
    //   331: astore_2
    //   332: aload 8
    //   334: astore 7
    //   336: goto -99 -> 237
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	339	0	this	ayps
    //   0	339	1	paramIntent	Intent
    //   0	339	2	paramFromServiceMsg	FromServiceMsg
    //   127	31	3	i	int
    //   7	51	4	l	long
    //   16	307	6	bool	boolean
    //   80	133	7	localObject1	Object
    //   233	97	7	localInvalidProtocolBufferMicroException1	InvalidProtocolBufferMicroException
    //   334	1	7	localObject2	Object
    //   98	161	8	localObject3	Object
    //   327	6	8	localInvalidProtocolBufferMicroException2	InvalidProtocolBufferMicroException
    //   25	201	9	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   73	82	233	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   195	217	263	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   82	115	327	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  private void b(Intent paramIntent, Packet paramPacket)
  {
    long l = paramIntent.getLongExtra("param_online_status_type", 0L);
    boolean bool = paramIntent.getBooleanExtra("param_fetch_only_smart_devices", false);
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusPermissionServlet", 2, new Object[] { "packOnlineStatusPermission | onlineStatusType = ", Long.valueOf(l), "onlySmartDevices = ", Boolean.valueOf(bool) });
    }
    paramIntent = new oidb_cmd0xe63.ReqBody();
    paramIntent.uint32_req_type.set(1);
    paramIntent.bool_only_smart_status.set(bool);
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(3683);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramIntent.toByteArray()));
    paramIntent = ((oidb_sso.OIDBSSOPkg)localObject).toByteArray();
    paramPacket.setSSOCommand("OidbSvc.0xe63_1");
    localObject = ByteBuffer.allocate(paramIntent.length + 4);
    ((ByteBuffer)localObject).putInt(paramIntent.length + 4);
    ((ByteBuffer)localObject).put(paramIntent);
    paramPacket.putSendData(((ByteBuffer)localObject).array());
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    String str2 = paramFromServiceMsg.getServiceCmd();
    String str1;
    if (QLog.isColorLevel())
    {
      boolean bool = paramFromServiceMsg.isSuccess();
      StringBuilder localStringBuilder = new StringBuilder().append("OnlineStatusPermissionServlet onReceive:").append(str2).append(" is ");
      if (bool)
      {
        str1 = "";
        QLog.d("OnlineStatusPermissionServlet", 2, str1 + " success");
      }
    }
    else
    {
      if ((str2 != null) && (str2.equals("OidbSvc.0xe63_1"))) {
        break label101;
      }
    }
    label101:
    int i;
    do
    {
      return;
      str1 = "not";
      break;
      i = paramIntent.getIntExtra("param_online_status_request", 0);
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusPermissionServlet", 2, new Object[] { "OnlineStatusPermissionServlet onReceive reqType", Integer.valueOf(i) });
      }
      if (i == 1)
      {
        b(paramIntent, paramFromServiceMsg);
        return;
      }
    } while (i != 2);
    a(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("param_online_status_request", 0);
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusPermissionServlet", 2, new Object[] { "OnlineStatusPermissionServlet onSend reqType", Integer.valueOf(i) });
    }
    if (i == 1) {
      b(paramIntent, paramPacket);
    }
    while (i != 2) {
      return;
    }
    a(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayps
 * JD-Core Version:    0.7.0.1
 */