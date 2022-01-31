package com.tencent.av.app;

import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.service.IAVRedPacketCallback;
import com.tencent.av.service.IQQServiceCallback.Stub;
import com.tencent.av.service.IQQServiceForAV;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import jfl;
import jfm;

public class QQServiceProxy
{
  int jdField_a_of_type_Int = -1;
  ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new jfm(this);
  private MQLruCache jdField_a_of_type_AndroidSupportV4UtilMQLruCache;
  public VideoAppInterface a;
  public IQQServiceCallback.Stub a;
  public IQQServiceForAV a;
  private QQLruCache jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache;
  public boolean a;
  public boolean b;
  
  public QQServiceProxy(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV = null;
    this.jdField_a_of_type_ComTencentAvServiceIQQServiceCallback$Stub = new jfl(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  /* Error */
  private BusinessInfoCheckUpdate.AppInfo b(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +28 -> 33
    //   8: ldc 51
    //   10: iconst_2
    //   11: new 53	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   18: ldc 56
    //   20: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_1
    //   24: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: new 70	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo
    //   36: dup
    //   37: invokespecial 71	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:<init>	()V
    //   40: astore 4
    //   42: new 73	org/json/JSONObject
    //   45: dup
    //   46: aload_1
    //   47: invokespecial 76	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   50: astore_1
    //   51: aload 4
    //   53: getfield 80	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:uiAppId	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   56: aload_1
    //   57: ldc 82
    //   59: invokevirtual 86	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   62: invokevirtual 92	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   65: aload 4
    //   67: getfield 96	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:iNewFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   70: aload_1
    //   71: ldc 97
    //   73: invokevirtual 86	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   76: invokevirtual 100	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   79: aload_1
    //   80: ldc 102
    //   82: invokevirtual 106	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   85: astore 5
    //   87: aload 5
    //   89: ifnull +173 -> 262
    //   92: iconst_0
    //   93: istore_2
    //   94: iload_2
    //   95: aload 5
    //   97: invokevirtual 112	org/json/JSONArray:length	()I
    //   100: if_icmpge +162 -> 262
    //   103: new 114	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo
    //   106: dup
    //   107: invokespecial 115	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:<init>	()V
    //   110: astore 6
    //   112: aload 5
    //   114: iload_2
    //   115: invokevirtual 119	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   118: astore 7
    //   120: aload 6
    //   122: getfield 122	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:red_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   125: aload 7
    //   127: ldc 123
    //   129: invokevirtual 86	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   132: invokevirtual 92	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   135: aload 6
    //   137: getfield 127	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:red_content	Lcom/tencent/mobileqq/pb/PBStringField;
    //   140: aload 7
    //   142: ldc 128
    //   144: invokevirtual 132	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   147: invokevirtual 136	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   150: aload 6
    //   152: getfield 139	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:red_desc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   155: aload 7
    //   157: ldc 140
    //   159: invokevirtual 132	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   162: invokevirtual 136	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   165: aload 4
    //   167: getfield 144	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:red_display_info	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedDisplayInfo;
    //   170: getfield 149	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedDisplayInfo:red_type_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   173: aload 6
    //   175: invokevirtual 155	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   178: iload_2
    //   179: iconst_1
    //   180: iadd
    //   181: istore_2
    //   182: goto -88 -> 94
    //   185: astore 5
    //   187: aload_1
    //   188: ldc 102
    //   190: invokevirtual 158	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   193: astore 5
    //   195: new 114	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo
    //   198: dup
    //   199: invokespecial 115	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:<init>	()V
    //   202: astore 6
    //   204: aload 6
    //   206: getfield 122	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:red_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   209: aload 5
    //   211: ldc 123
    //   213: invokevirtual 86	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   216: invokevirtual 92	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   219: aload 6
    //   221: getfield 127	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:red_content	Lcom/tencent/mobileqq/pb/PBStringField;
    //   224: aload 5
    //   226: ldc 128
    //   228: invokevirtual 132	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   231: invokevirtual 136	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   234: aload 6
    //   236: getfield 139	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:red_desc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   239: aload 5
    //   241: ldc 140
    //   243: invokevirtual 132	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   246: invokevirtual 136	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   249: aload 4
    //   251: getfield 144	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:red_display_info	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedDisplayInfo;
    //   254: getfield 149	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedDisplayInfo:red_type_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   257: aload 6
    //   259: invokevirtual 155	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   262: aload_1
    //   263: ldc 160
    //   265: invokevirtual 106	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   268: astore 5
    //   270: aload 5
    //   272: ifnull +90 -> 362
    //   275: new 162	java/util/ArrayList
    //   278: dup
    //   279: invokespecial 163	java/util/ArrayList:<init>	()V
    //   282: astore 6
    //   284: iload_3
    //   285: istore_2
    //   286: iload_2
    //   287: aload 5
    //   289: invokevirtual 112	org/json/JSONArray:length	()I
    //   292: if_icmpge +60 -> 352
    //   295: aload 6
    //   297: aload 5
    //   299: iload_2
    //   300: invokevirtual 166	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   303: invokeinterface 171 2 0
    //   308: pop
    //   309: iload_2
    //   310: iconst_1
    //   311: iadd
    //   312: istore_2
    //   313: goto -27 -> 286
    //   316: astore 5
    //   318: aload 4
    //   320: getfield 144	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:red_display_info	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedDisplayInfo;
    //   323: getfield 149	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedDisplayInfo:red_type_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   326: aconst_null
    //   327: invokevirtual 174	com/tencent/mobileqq/pb/PBRepeatMessageField:set	(Ljava/util/List;)V
    //   330: goto -68 -> 262
    //   333: astore_1
    //   334: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   337: ifeq +12 -> 349
    //   340: ldc 51
    //   342: iconst_2
    //   343: ldc 176
    //   345: aload_1
    //   346: invokestatic 180	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   349: aload 4
    //   351: areturn
    //   352: aload 4
    //   354: getfield 183	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   357: aload 6
    //   359: invokevirtual 189	com/tencent/mobileqq/pb/PBRepeatField:addAll	(Ljava/util/Collection;)V
    //   362: aload 4
    //   364: getfield 192	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   367: aload_1
    //   368: ldc 193
    //   370: invokevirtual 86	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   373: invokevirtual 92	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   376: aload 4
    //   378: getfield 196	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   381: aload_1
    //   382: ldc 197
    //   384: invokevirtual 132	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   387: invokevirtual 136	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   390: aload 4
    //   392: getfield 200	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:path	Lcom/tencent/mobileqq/pb/PBStringField;
    //   395: aload_1
    //   396: ldc 201
    //   398: invokevirtual 132	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   401: invokevirtual 136	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   404: aload 4
    //   406: getfield 204	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:appset	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   409: aload_1
    //   410: ldc 205
    //   412: invokevirtual 86	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   415: invokevirtual 100	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   418: aload 4
    //   420: getfield 208	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:modify_ts	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   423: aload_1
    //   424: ldc 209
    //   426: invokevirtual 86	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   429: invokevirtual 92	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   432: aload 4
    //   434: getfield 212	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:num	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   437: aload_1
    //   438: ldc 213
    //   440: invokevirtual 86	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   443: invokevirtual 100	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   446: aload 4
    //   448: getfield 216	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:push_red_ts	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   451: aload_1
    //   452: ldc 217
    //   454: invokevirtual 86	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   457: invokevirtual 92	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   460: aload 4
    //   462: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	463	0	this	QQServiceProxy
    //   0	463	1	paramString	String
    //   93	220	2	i	int
    //   1	284	3	j	int
    //   40	421	4	localAppInfo	BusinessInfoCheckUpdate.AppInfo
    //   85	28	5	localJSONArray	org.json.JSONArray
    //   185	1	5	localException1	Exception
    //   193	105	5	localObject1	Object
    //   316	1	5	localException2	Exception
    //   110	248	6	localObject2	Object
    //   118	38	7	localJSONObject	org.json.JSONObject
    // Exception table:
    //   from	to	target	type
    //   79	87	185	java/lang/Exception
    //   94	178	185	java/lang/Exception
    //   187	262	316	java/lang/Exception
    //   42	79	333	java/lang/Exception
    //   262	270	333	java/lang/Exception
    //   275	284	333	java/lang/Exception
    //   286	309	333	java/lang/Exception
    //   318	330	333	java/lang/Exception
    //   352	362	333	java/lang/Exception
    //   362	460	333	java/lang/Exception
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {
      try
      {
        int i = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.d();
        return i;
      }
      catch (RemoteException localRemoteException)
      {
        QLog.e("QQServiceProxy", 2, "getPstnState", localRemoteException);
      }
    }
    return -1;
  }
  
  public int a(int paramInt, String paramString)
  {
    int j = 0;
    int i = j;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      i = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramInt, paramString);
      return i;
    }
    catch (RemoteException paramString)
    {
      do
      {
        i = j;
      } while (!QLog.isColorLevel());
      QLog.e("QQServiceProxy", 2, "getDiscussMemberNum", paramString);
    }
    return 0;
  }
  
  public int a(String paramString)
  {
    int j = 0;
    int i = j;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      i = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.b(paramString);
      return i;
    }
    catch (RemoteException paramString)
    {
      do
      {
        i = j;
      } while (!QLog.isColorLevel());
      QLog.e("QQServiceProxy", 2, "getNearbyProfileData", paramString);
    }
    return 0;
  }
  
  public long a(String paramString)
  {
    long l2 = 0L;
    long l1 = l2;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      l1 = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramString);
      return l1;
    }
    catch (RemoteException paramString)
    {
      do
      {
        l1 = l2;
      } while (!QLog.isColorLevel());
      QLog.e("QQServiceProxy", 2, "getDiscussMemberNum", paramString);
    }
    return 0L;
  }
  
  public Bitmap a()
  {
    return ImageUtil.a();
  }
  
  public Bitmap a(int paramInt, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str = a(paramInt, paramString1, paramString2, paramBoolean1);
    Object localObject = a(str);
    if (localObject == null) {
      if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV == null) {}
    }
    for (;;)
    {
      try
      {
        Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramInt, paramString1, paramString2, paramBoolean1, paramBoolean2);
        localObject = localBitmap;
        if (localObject == null) {}
      }
      catch (RemoteException localRemoteException1)
      {
        if (paramBoolean2) {
          localObject = a();
        }
        i = 2;
        continue;
      }
      catch (NullPointerException localNullPointerException1) {}
      try
      {
        a(str, (Bitmap)localObject);
        i = 0;
      }
      catch (NullPointerException localNullPointerException2)
      {
        break label179;
      }
      catch (RemoteException localRemoteException2)
      {
        continue;
        continue;
      }
      if (AudioHelper.e()) {
        QLog.w("QQServiceProxy", 1, "getFaceBitmap, uinType[" + paramInt + "], uin[" + paramString1 + "], extraUin[" + paramString2 + "], isNeedReturnDefaultValue[" + paramBoolean2 + "], ret[" + i + "]");
      }
      return localObject;
      int i = 1;
      continue;
      label179:
      if (paramBoolean2) {
        localObject = a();
      }
      i = 3;
      continue;
      i = 4;
      if (!paramBoolean2) {
        break;
      }
      localObject = a();
      continue;
      i = -3;
    }
  }
  
  public Bitmap a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) {
      return (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(paramString);
    }
    return null;
  }
  
  public Bundle a(int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {
      try
      {
        paramBundle = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramInt1, paramInt2, paramInt3, null, paramBundle, paramResultReceiver);
        return paramBundle;
      }
      catch (RemoteException paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQServiceProxy", 2, "requestEvent, mainCmd[" + paramInt1 + "], subType[" + paramInt2 + "]");
        }
      }
    }
    for (;;)
    {
      return null;
      if (QLog.isColorLevel()) {
        QLog.e("QQServiceProxy", 2, "requestEvent mQQServiceForAV == null");
      }
    }
  }
  
  public BusinessInfoCheckUpdate.AppInfo a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      localObject1 = b(this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.e(paramString));
      return localObject1;
    }
    catch (RemoteException paramString)
    {
      do
      {
        localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.e("QQServiceProxy", 2, "[red dot] getVideoEffectAppInfo", paramString);
    }
    return null;
  }
  
  public String a()
  {
    Object localObject = null;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceProxy", 2, "We will get current user skey");
      }
    }
    while (!QLog.isColorLevel())
    {
      try
      {
        String str = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a();
        localObject = str;
      }
      catch (RemoteException localRemoteException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.w("QQServiceProxy", 2, "getSKey fail", localRemoteException);
        return null;
      }
      return localObject;
    }
    QLog.d("QQServiceProxy", 2, "getSKey-->mQQServiceForAV is null");
    return null;
  }
  
  public String a(int paramInt, String paramString1, String paramString2)
  {
    return "" + paramInt + "_" + paramString1 + "_" + paramString2;
  }
  
  public String a(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString2 = new StringBuilder().append("").append(paramInt).append("_").append(paramString1).append("_").append(paramString2).append("_");
    if (paramBoolean) {}
    for (paramString1 = "0";; paramString1 = "1") {
      return paramString1;
    }
  }
  
  public String a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache != null) {
      return (String)this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(paramString);
    }
    return "";
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache = BaseApplicationImpl.sImageCache;
    this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache = new QQLruCache(10001, 50, 10);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQServiceProxy", 2, "startDownloadAVResource", localRemoteException);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramInt, paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQServiceProxy", 2, "startPumpMessage", paramString);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramInt, paramString1, paramString2);
      return;
    }
    catch (RemoteException paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQServiceProxy", 2, "setPeerInfo", paramString1);
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramLong);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQServiceProxy", 2, "syncChatingTime", localRemoteException);
    }
  }
  
  public void a(long paramLong1, String paramString, long paramLong2)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    while (!QLog.isColorLevel()) {
      try
      {
        this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramLong1, paramString, paramLong2);
        return;
      }
      catch (RemoteException paramString)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("QQServiceProxy", 2, "addSharpMsgRecordList e = ", paramString);
        return;
      }
    }
    QLog.e("QQServiceProxy", 2, "addSharpMsgRecordList mQQServiceForAV==null");
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      QLog.w("QQServiceProxy", 1, "stopPumpMessage[" + paramString + "]");
      this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a();
      return;
    }
    catch (RemoteException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQServiceProxy", 2, "stopPumpMessage", paramString);
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) && (paramBitmap != null)) {
      this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put(paramString, paramBitmap);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache != null) && (!TextUtils.isEmpty(paramString2))) {
      this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(paramString1, paramString2);
    }
  }
  
  public boolean a()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("isQQServiceBind ");
      if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV == null) {
        break label52;
      }
    }
    label52:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("QQServiceProxy", 2, bool);
      if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV == null) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      bool1 = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramInt, paramLong);
      return bool1;
    }
    catch (RemoteException localRemoteException)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.e("QQServiceProxy", 2, "curGAInviteIsRight", localRemoteException);
    }
    return true;
  }
  
  public boolean a(long paramLong)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      bool = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramLong);
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      QLog.e("QQServiceProxy", 2, "getTroopAdmins-->troopUin=" + paramLong, localRemoteException);
    }
    return false;
  }
  
  public boolean a(IAVRedPacketCallback paramIAVRedPacketCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceProxy", 2, "getAVRedPacketConfig start mQQServiceForAV = " + this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV);
    }
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {
      try
      {
        this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramIAVRedPacketCallback);
        return true;
      }
      catch (RemoteException paramIAVRedPacketCallback)
      {
        paramIAVRedPacketCallback.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("QQServiceProxy", 2, "getAVRedPacketConfig error", paramIAVRedPacketCallback);
        }
      }
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      bool = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramString);
      return bool;
    }
    catch (RemoteException paramString)
    {
      QLog.e("QQServiceProxy", 2, "isFriend", paramString);
    }
    return false;
  }
  
  public boolean a(String paramString, int paramInt)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      bool = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.b(paramString, paramInt);
      return bool;
    }
    catch (RemoteException paramString)
    {
      QLog.e("QQServiceProxy", 2, "requestDecodeStrangeFace-->false", paramString);
    }
    return false;
  }
  
  public int[] a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      localObject1 = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a();
      return localObject1;
    }
    catch (RemoteException localRemoteException)
    {
      do
      {
        localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.e("QQServiceProxy", 2, "getMultiPstnConfig", localRemoteException);
    }
    return null;
  }
  
  public long[] a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      localObject1 = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramString);
      return localObject1;
    }
    catch (RemoteException paramString)
    {
      do
      {
        localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.e("QQServiceProxy", 2, "getDiscussMemberList", paramString);
    }
    return null;
  }
  
  public int b()
  {
    int j = 0;
    int i = j;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      i = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.b();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      do
      {
        i = j;
      } while (!QLog.isColorLevel());
      QLog.e("QQServiceProxy", 2, "getMultiPstnGraySwitch", localRemoteException);
    }
    return 0;
  }
  
  public int b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {
      try
      {
        int i = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.c(paramString);
        return i;
      }
      catch (RemoteException paramString)
      {
        QLog.e("QQServiceProxy", 2, "convertUinTypeEx e = ", paramString);
      }
    }
    for (;;)
    {
      return -1;
      QLog.e("QQServiceProxy", 2, "convertUinTypeEx mQQServiceForAV == null");
    }
  }
  
  public String b(int paramInt, String paramString1, String paramString2)
  {
    String str2 = a(paramInt, paramString1, paramString2);
    Object localObject2 = null;
    Object localObject1 = null;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      String str1 = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramInt, paramString1, paramString2);
      localObject2 = str1;
      if (!TextUtils.isEmpty(str1))
      {
        localObject2 = str1;
        a(str2, str1);
      }
      localObject1 = str1;
      localObject2 = str1;
      if (AudioHelper.e())
      {
        localObject2 = str1;
        QLog.w("QQServiceProxy", 1, "getDisplayName, uinType[" + paramInt + "], uin[" + paramString1 + "], extraUin[" + paramString2 + "], name[" + str1 + "]");
        localObject1 = str1;
      }
    }
    catch (RemoteException paramString2)
    {
      for (;;)
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.w("QQServiceProxy", 2, "getDisplayName", paramString2);
          localObject1 = localObject2;
        }
      }
    }
    paramString2 = (String)localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = a(str2);
      paramString2 = (String)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return paramString1;
      }
    }
    return paramString2;
  }
  
  public String b(String paramString)
  {
    Object localObject2 = a(paramString);
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject2 = null;
      localObject1 = null;
      if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV == null) {}
    }
    try
    {
      localObject1 = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramString);
      localObject2 = localObject1;
      a(paramString, (String)localObject1);
      localObject2 = localObject1;
      QLog.w("QQServiceProxy", 1, "getPhoneUserNameByPhoneNum, number[" + paramString + "], name[" + (String)localObject1 + "]");
    }
    catch (RemoteException paramString)
    {
      do
      {
        localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.w("QQServiceProxy", 2, "getPhoneUserNameByPhoneNum", paramString);
    }
    return localObject1;
    return localObject2;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) {
      this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.evictAll();
    }
    if (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache != null) {
      this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.evictAll();
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.b(paramInt, paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQServiceProxy", 2, "setBindInfo", paramString);
    }
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.b(paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQServiceProxy", 2, "acceptAddFriend", paramString);
    }
  }
  
  public boolean b()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      bool1 = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a();
      return bool1;
    }
    catch (RemoteException localRemoteException)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.e("QQServiceProxy", 2, "isQQpaused", localRemoteException);
    }
    return false;
  }
  
  public boolean b(IAVRedPacketCallback paramIAVRedPacketCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceProxy", 2, "startDownloadAVRedPacketRes start");
    }
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {
      try
      {
        this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.b(paramIAVRedPacketCallback);
        return true;
      }
      catch (RemoteException paramIAVRedPacketCallback)
      {
        paramIAVRedPacketCallback.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("QQServiceProxy", 2, "startDownloadAVRedPacketRes error", paramIAVRedPacketCallback);
        }
      }
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramString);
      bool1 = true;
    }
    catch (RemoteException paramString)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.e("QQServiceProxy", 2, "getNearbyProfileData", paramString);
    }
    return bool1;
    return false;
  }
  
  public boolean b(String paramString, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      bool1 = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.c(paramString, paramInt);
      return bool1;
    }
    catch (RemoteException paramString)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.e("QQServiceProxy", 2, "avAddFriend", paramString);
    }
    return false;
  }
  
  public int c()
  {
    int j = 5;
    int i = j;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      i = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.c();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      do
      {
        i = j;
      } while (!QLog.isColorLevel());
      QLog.e("QQServiceProxy", 2, "getMultiPstnMembership", localRemoteException);
    }
    return 5;
  }
  
  public String c(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      localObject1 = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.c(paramString);
      return localObject1;
    }
    catch (RemoteException paramString)
    {
      do
      {
        localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.e("QQServiceProxy", 2, "getUinByPhoneNum", paramString);
    }
    return null;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceProxy", 2, "bindQQService");
    }
    if ((this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV == null) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp(), QQServiceForAV.class);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().bindService(localIntent, this.jdField_a_of_type_AndroidContentServiceConnection, 1);
    }
  }
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.c(paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQServiceProxy", 2, "acceptAddFriend", paramString);
    }
  }
  
  public boolean c()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      bool1 = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.b();
      return bool1;
    }
    catch (RemoteException localRemoteException)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.e("QQServiceProxy", 2, "isPhoneCalling", localRemoteException);
    }
    return false;
  }
  
  public boolean c(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {
      try
      {
        boolean bool = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramString, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
        return bool;
      }
      catch (RemoteException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return true;
  }
  
  public int d()
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      i = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a();
      return i;
    }
    catch (RemoteException localRemoteException) {}
    return 0;
  }
  
  public String d(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      localObject1 = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.d(paramString);
      return localObject1;
    }
    catch (RemoteException paramString)
    {
      do
      {
        localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.e("QQServiceProxy", 2, "getPhoneNumByUin", paramString);
    }
    return null;
  }
  
  void d()
  {
    AVLog.d("QQServiceProxy", "unbindQQService");
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a();
      this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(this.jdField_a_of_type_ComTencentAvServiceIQQServiceCallback$Stub);
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
          return;
        }
        catch (Exception localException2)
        {
          QLog.e("QQServiceProxy", 2, "unbindService3 ", localException2);
        }
        localRemoteException = localRemoteException;
        QLog.e("QQServiceProxy", 2, "unbindQQService1 ", localRemoteException);
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        QLog.e("QQServiceProxy", 2, "unbindQQService2 ", localException1);
      }
    }
  }
  
  public void d(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {
        this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.d(paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQServiceProxy", 2, "[red dot] getVideoEffectAppInfo", paramString);
    }
  }
  
  public boolean d()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      bool1 = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.c();
      return bool1;
    }
    catch (RemoteException localRemoteException)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.e("QQServiceProxy", 2, "getNearbyProfileData", localRemoteException);
    }
    return false;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {
      try
      {
        this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.b();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("QQServiceProxy", 2, "avStartAddFriendService", localRemoteException);
        return;
      }
    }
    this.b = true;
  }
  
  public boolean e()
  {
    if ((this.jdField_a_of_type_Int == -1) && (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null)) {}
    for (;;)
    {
      try
      {
        if (!this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.d()) {
          continue;
        }
        i = 1;
        this.jdField_a_of_type_Int = i;
      }
      catch (Exception localException)
      {
        int i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("QQServiceProxy", 2, "getTalkBack", localException);
        continue;
      }
      if (this.jdField_a_of_type_Int != 1) {
        break label69;
      }
      return true;
      i = 0;
    }
    label69:
    return false;
  }
  
  public boolean f()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      bool1 = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.e();
      if (QLog.isColorLevel()) {
        QLog.e("EffectEnable", 2, "getEffectsSoLoadIsOk  result " + this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV + "   " + bool1);
      }
      return bool1;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        QLog.e("EffectEnable", 1, "getEffectsSoLoadIsOk", localRemoteException);
        bool1 = bool2;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        AVLog.e("EffectEnable", localNullPointerException.getMessage());
        bool1 = bool2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.app.QQServiceProxy
 * JD-Core Version:    0.7.0.1
 */