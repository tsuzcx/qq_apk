package com.tencent.avgame.business.handler;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.avgame.app.IAVGameAppInterface;
import com.tencent.avgame.business.observer.UserInfoObserver;
import com.tencent.avgame.ipc.AVGameClientQIPCModule;
import com.tencent.avgame.ipc.UserInfo;
import com.tencent.avgame.util.AVGameCmdUtil;
import com.tencent.avgame.util.AVGameUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseAVGameAppInterface;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;

public class UserInfoHandler
  extends AVGameBusinessHandler
{
  private static Byte[] jdField_a_of_type_ArrayOfJavaLangByte;
  private final MQLruCache<String, Object> jdField_a_of_type_AndroidSupportV4UtilMQLruCache = GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache;
  private final QQLruCache<String, UserInfo> jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache = new QQLruCache(10001, 50, 10);
  private final QQLruCache<String, String> b = new QQLruCache(10001, 50, 10);
  
  protected UserInfoHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public static Bitmap a()
  {
    Byte[] arrayOfByte = jdField_a_of_type_ArrayOfJavaLangByte;
    Byte localByte = Byte.valueOf((byte)0);
    if (arrayOfByte == null)
    {
      jdField_a_of_type_ArrayOfJavaLangByte = new Byte[50];
      Arrays.fill(jdField_a_of_type_ArrayOfJavaLangByte, localByte);
    }
    int k = new Random().nextInt(49) % 50 + 0;
    int i = k;
    int j;
    do
    {
      j = i;
      if (jdField_a_of_type_ArrayOfJavaLangByte[i].byteValue() == 0) {
        break;
      }
      j = (i + 1) % 50;
      i = j;
    } while (j != k);
    Arrays.fill(jdField_a_of_type_ArrayOfJavaLangByte, localByte);
    jdField_a_of_type_ArrayOfJavaLangByte[j] = Byte.valueOf(1);
    return AVGameUtil.a(String.format("pkAvatar/avgame_pk_avatar%d@2x.png", new Object[] { Integer.valueOf(j + 1) }));
  }
  
  private Bitmap a(boolean paramBoolean)
  {
    int i;
    Object localObject;
    if (!paramBoolean)
    {
      i = 2130840322;
      localObject = "static://DefaultFace_square";
    }
    else
    {
      localObject = "static://DefaultFace";
      i = 2130840321;
    }
    Bitmap localBitmap1;
    if (GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) {
      localBitmap1 = (Bitmap)GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(localObject);
    } else {
      localBitmap1 = null;
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = BitmapManager.b(MobileQQ.sMobileQQ.getResources(), i);
      if ((localBitmap1 != null) && (GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null)) {
        GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put(localObject, localBitmap1);
      }
      localBitmap2 = localBitmap1;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getDefaultFaceBitmap, bitmap=");
        ((StringBuilder)localObject).append(localBitmap1);
        QLog.d("UserInfoHandler", 2, ((StringBuilder)localObject).toString());
        localBitmap2 = localBitmap1;
      }
    }
    return localBitmap2;
  }
  
  private AVGameClientQIPCModule a()
  {
    if ((this.appRuntime instanceof IAVGameAppInterface)) {
      return ((IAVGameAppInterface)this.appRuntime).a();
    }
    return null;
  }
  
  private void a(int paramInt, List<String> paramList)
  {
    if (paramList.size() == 0) {
      return;
    }
    Object localObject = new oidb_0x5eb.ReqBody();
    ArrayList localArrayList = new ArrayList(paramList.size());
    try
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(Long.valueOf(Long.parseLong((String)localIterator.next())));
      }
    }
    catch (Exception localException)
    {
      label78:
      break label78;
    }
    if (localArrayList.size() == 0)
    {
      QLog.d("UserInfoHandler", 1, "getNicksFromSvr uins empty return.");
      return;
    }
    ((oidb_0x5eb.ReqBody)localObject).rpt_uint64_uins.set(localArrayList);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_nick.set(1);
    localObject = makeOIDBPkg("OidbSvc.0x5eb_20002", 1515, 22, ((oidb_0x5eb.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putStringArrayList("uins", (ArrayList)paramList);
    ((ToServiceMsg)localObject).extraData.putInt("uinType", paramInt);
    sendPbReq((ToServiceMsg)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getNicksFromSvr ");
      ((StringBuilder)localObject).append(paramList.size());
      QLog.i("UserInfoHandler", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void a(int paramInt, List<String> arg2, HashMap<String, String> paramHashMap)
  {
    Object localObject = a();
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("UserInfoHandler", 2, String.format("getNicksRemote uins.size=%d", new Object[] { Integer.valueOf(???.size()) }));
      }
      ((AVGameClientQIPCModule)localObject).a(paramInt, ???, paramHashMap);
      if (paramHashMap.size() > 0) {
        synchronized (this.b)
        {
          localObject = paramHashMap.keySet().iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            this.b.put(str, paramHashMap.get(str));
          }
          return;
        }
      }
    }
  }
  
  private void a(HashMap<String, String> paramHashMap, List<String> paramList1, List<String> paramList2)
  {
    HashMap localHashMap = new HashMap(paramList1.size());
    a(0, paramList1, localHashMap);
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      String str = (String)paramList1.next();
      if (localHashMap.containsKey(str)) {
        paramHashMap.put(str, localHashMap.get(str));
      } else {
        paramList2.add(str);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("UserInfoHandler", 2, String.format("getNicks from main = %s", new Object[] { paramHashMap }));
    }
  }
  
  private void a(List<String> paramList1, HashMap<String, String> paramHashMap, List<String> paramList2)
  {
    synchronized (this.b)
    {
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        String str1 = (String)paramList1.next();
        String str2 = (String)this.b.get(str1);
        if (str2 == null) {
          paramList2.add(str1);
        } else {
          paramHashMap.put(str1, str2);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("UserInfoHandler", 2, String.format("getNicks from cache = %s", new Object[] { paramHashMap }));
      }
      return;
    }
    for (;;)
    {
      throw paramList1;
    }
  }
  
  public static UserInfo b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localObject != null) && ((localObject instanceof BaseAVGameAppInterface)))
    {
      localObject = (UserInfoHandler)((BaseAVGameAppInterface)localObject).getBusinessHandler(HandlerFactory.b);
      if (localObject != null) {
        return ((UserInfoHandler)localObject).a(paramString);
      }
    }
    return null;
  }
  
  public Bitmap a(int paramInt1, String paramString, byte paramByte, int paramInt2)
  {
    MQLruCache localMQLruCache = this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localMQLruCache != null) {}
    try
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append("_");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("_");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append("_");
      ((StringBuilder)localObject1).append(paramByte);
      paramString = ((StringBuilder)localObject1).toString();
      paramString = this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(paramString);
    }
    catch (Throwable paramString)
    {
      label101:
      break label101;
    }
    paramString = null;
    localObject1 = localObject2;
    if ((paramString instanceof Bitmap)) {
      localObject1 = (Bitmap)paramString;
    }
    return localObject1;
  }
  
  public Bitmap a(String paramString, byte paramByte)
  {
    boolean bool = true;
    Bitmap localBitmap2 = a(1, paramString, paramByte, 200);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = b(1, paramString, paramByte, 200);
    }
    paramString = localBitmap1;
    if (localBitmap1 == null)
    {
      if (paramByte != 4) {
        bool = false;
      }
      paramString = BaseImageUtil.a(bool);
    }
    return paramString;
  }
  
  public Bitmap a(String paramString, byte paramByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    Bitmap localBitmap2 = a(1, paramString, paramByte, 200);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = b(1, paramString, paramByte, 200);
    }
    paramString = localBitmap1;
    if (localBitmap1 == null)
    {
      if (paramBoolean2) {
        localBitmap1 = a();
      }
      paramString = localBitmap1;
      if (localBitmap1 == null)
      {
        boolean bool = false;
        paramBoolean2 = false;
        if (paramBoolean1)
        {
          paramBoolean1 = paramBoolean2;
          if (paramByte == 4) {
            paramBoolean1 = true;
          }
          return a(paramBoolean1);
        }
        paramBoolean1 = bool;
        if (paramByte == 4) {
          paramBoolean1 = true;
        }
        paramString = BaseImageUtil.a(paramBoolean1);
      }
    }
    return paramString;
  }
  
  public UserInfo a(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString);
      paramString = localStringBuilder.toString();
      paramString = (UserInfo)this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      label54:
      break label54;
    }
    return null;
  }
  
  public UserInfo a(String paramString)
  {
    UserInfo localUserInfo2 = a(0, paramString);
    UserInfo localUserInfo1 = localUserInfo2;
    if (localUserInfo2 == null) {
      localUserInfo1 = b(0, paramString);
    }
    return localUserInfo1;
  }
  
  public HashMap<String, String> a(List<String> paramList)
  {
    HashMap localHashMap = new HashMap(paramList.size());
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (paramList.size() > 0) {
      a(paramList, localHashMap, localArrayList1);
    }
    if (localArrayList1.size() > 0) {
      ThreadManager.postImmediately(new UserInfoHandler.1(this, new HashMap(localArrayList1.size()), localArrayList1, localArrayList2), null, true);
    }
    return localHashMap;
  }
  
  public void a(int paramInt, String paramString, UserInfo paramUserInfo)
  {
    if (paramUserInfo != null) {
      try
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(paramString);
        localObject = ((StringBuilder)localObject).toString();
        this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(localObject, paramUserInfo);
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel())
        {
          localThrowable.printStackTrace();
          QLog.i("UserInfoHandler", 2, "updateUserInfo", localThrowable);
        }
      }
    }
    notifyUI(0, true, new Object[] { Integer.valueOf(paramInt), paramString, paramUserInfo });
  }
  
  /* Error */
  protected void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: new 380	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody
    //   3: dup
    //   4: invokespecial 381	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:<init>	()V
    //   7: astore 10
    //   9: aload_2
    //   10: aload_3
    //   11: aload 10
    //   13: invokestatic 385	com/tencent/avgame/business/handler/UserInfoHandler:parseOIDBPkg	(Lcom/tencent/qphone/base/remote/FromServiceMsg;Ljava/lang/Object;Lcom/tencent/mobileqq/pb/MessageMicro;)I
    //   16: istore 5
    //   18: aload_1
    //   19: getfield 230	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   22: ldc 240
    //   24: invokevirtual 389	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   27: istore 6
    //   29: aload_1
    //   30: getfield 230	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   33: ldc 232
    //   35: invokevirtual 393	android/os/Bundle:getStringArrayList	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   38: astore_2
    //   39: new 268	java/util/HashMap
    //   42: dup
    //   43: aload_2
    //   44: invokeinterface 160 1 0
    //   49: invokespecial 287	java/util/HashMap:<init>	(I)V
    //   52: astore_1
    //   53: iload 5
    //   55: ifne +172 -> 227
    //   58: aload 10
    //   60: getfield 397	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   63: invokevirtual 400	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   66: aload_2
    //   67: invokeinterface 160 1 0
    //   72: if_icmpne +155 -> 227
    //   75: aload 10
    //   77: getfield 397	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   80: invokevirtual 403	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   83: astore_3
    //   84: aload_0
    //   85: getfield 33	com/tencent/avgame/business/handler/UserInfoHandler:b	Lcom/tencent/commonsdk/cache/QQLruCache;
    //   88: astore_2
    //   89: aload_2
    //   90: monitorenter
    //   91: iconst_0
    //   92: istore 4
    //   94: iload 4
    //   96: aload_3
    //   97: invokeinterface 160 1 0
    //   102: if_icmpge +90 -> 192
    //   105: aload_3
    //   106: iload 4
    //   108: invokeinterface 406 2 0
    //   113: checkcast 408	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData
    //   116: getfield 412	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   119: invokevirtual 417	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   122: lstore 7
    //   124: aload_3
    //   125: iload 4
    //   127: invokeinterface 406 2 0
    //   132: checkcast 408	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData
    //   135: getfield 421	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:bytes_nick	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   138: invokevirtual 426	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   141: invokevirtual 431	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   144: astore 10
    //   146: lload 7
    //   148: lconst_0
    //   149: lcmp
    //   150: ifle +158 -> 308
    //   153: aload 10
    //   155: ifnonnull +6 -> 161
    //   158: goto +150 -> 308
    //   161: lload 7
    //   163: invokestatic 434	java/lang/Long:toString	(J)Ljava/lang/String;
    //   166: astore 11
    //   168: aload_1
    //   169: aload 11
    //   171: aload 10
    //   173: invokevirtual 292	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   176: pop
    //   177: aload_0
    //   178: getfield 33	com/tencent/avgame/business/handler/UserInfoHandler:b	Lcom/tencent/commonsdk/cache/QQLruCache;
    //   181: aload 11
    //   183: aload 10
    //   185: invokevirtual 278	com/tencent/commonsdk/cache/QQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   188: pop
    //   189: goto +119 -> 308
    //   192: aload_2
    //   193: monitorexit
    //   194: aload_0
    //   195: iconst_2
    //   196: iconst_1
    //   197: iconst_2
    //   198: anewarray 64	java/lang/Object
    //   201: dup
    //   202: iconst_0
    //   203: iload 6
    //   205: invokestatic 69	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   208: aastore
    //   209: dup
    //   210: iconst_1
    //   211: aload_1
    //   212: aastore
    //   213: invokevirtual 377	com/tencent/avgame/business/handler/UserInfoHandler:notifyUI	(IZLjava/lang/Object;)V
    //   216: iconst_1
    //   217: istore 9
    //   219: goto +11 -> 230
    //   222: astore_3
    //   223: aload_2
    //   224: monitorexit
    //   225: aload_3
    //   226: athrow
    //   227: iconst_0
    //   228: istore 9
    //   230: iload 9
    //   232: ifne +25 -> 257
    //   235: aload_0
    //   236: iconst_2
    //   237: iconst_0
    //   238: iconst_2
    //   239: anewarray 64	java/lang/Object
    //   242: dup
    //   243: iconst_0
    //   244: iload 6
    //   246: invokestatic 69	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   249: aastore
    //   250: dup
    //   251: iconst_1
    //   252: aconst_null
    //   253: aastore
    //   254: invokevirtual 377	com/tencent/avgame/business/handler/UserInfoHandler:notifyUI	(IZLjava/lang/Object;)V
    //   257: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   260: ifeq +39 -> 299
    //   263: ldc 134
    //   265: iconst_2
    //   266: ldc_w 436
    //   269: iconst_3
    //   270: anewarray 64	java/lang/Object
    //   273: dup
    //   274: iconst_0
    //   275: iload 9
    //   277: invokestatic 441	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   280: aastore
    //   281: dup
    //   282: iconst_1
    //   283: iload 5
    //   285: invokestatic 69	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   288: aastore
    //   289: dup
    //   290: iconst_2
    //   291: aload_1
    //   292: aastore
    //   293: invokestatic 75	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   296: invokestatic 256	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   299: return
    //   300: astore_2
    //   301: goto -74 -> 227
    //   304: astore_2
    //   305: goto -89 -> 216
    //   308: iload 4
    //   310: iconst_1
    //   311: iadd
    //   312: istore 4
    //   314: goto -220 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	317	0	this	UserInfoHandler
    //   0	317	1	paramToServiceMsg	ToServiceMsg
    //   0	317	2	paramFromServiceMsg	FromServiceMsg
    //   0	317	3	paramObject	Object
    //   92	221	4	i	int
    //   16	268	5	j	int
    //   27	218	6	k	int
    //   122	40	7	l	long
    //   217	59	9	bool	boolean
    //   7	177	10	localObject	Object
    //   166	16	11	str	String
    // Exception table:
    //   from	to	target	type
    //   94	146	222	finally
    //   161	189	222	finally
    //   192	194	222	finally
    //   223	225	222	finally
    //   58	91	300	java/lang/Exception
    //   225	227	300	java/lang/Exception
    //   194	216	304	java/lang/Exception
  }
  
  public Bitmap b(int paramInt1, String paramString, byte paramByte, int paramInt2)
  {
    Object localObject = a();
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((AVGameClientQIPCModule)localObject).a(paramInt1, paramString, paramByte, paramInt2);
    }
    if (localObject != null) {}
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString);
      localStringBuilder.append("_");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("_");
      localStringBuilder.append(paramByte);
      paramString = localStringBuilder.toString();
      this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put(paramString, localObject);
      return localObject;
    }
    catch (Throwable paramString) {}
    return localObject;
  }
  
  public UserInfo b(int paramInt, String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    UserInfo localUserInfo = null;
    if (bool) {
      return null;
    }
    Object localObject = a();
    if (localObject != null) {
      localUserInfo = ((AVGameClientQIPCModule)localObject).a(paramInt, paramString);
    }
    if (localUserInfo != null) {
      try
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(paramString);
        paramString = ((StringBuilder)localObject).toString();
        this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(paramString, localUserInfo);
        return localUserInfo;
      }
      catch (Throwable paramString)
      {
        if (QLog.isColorLevel())
        {
          paramString.printStackTrace();
          QLog.i("UserInfoHandler", 2, "getUserInfoFromRemote", paramString);
        }
      }
    }
    return localUserInfo;
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      String[] arrayOfString = AVGameCmdUtil.d;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if (!TextUtils.isEmpty(str)) {
          this.allowCmdSet.add(str);
        }
        i += 1;
      }
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return UserInfoObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("OidbSvc.0x5eb_20002".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.business.handler.UserInfoHandler
 * JD-Core Version:    0.7.0.1
 */