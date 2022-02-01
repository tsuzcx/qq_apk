package com.tencent.avgame.business.handler;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.business.observer.UserInfoObserver;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.ipc.AVGameClientQIPCModule;
import com.tencent.avgame.ipc.UserInfo;
import com.tencent.avgame.util.AVGameCmdUtil;
import com.tencent.avgame.util.AVGameUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.ImageUtil;
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
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;

public class UserInfoHandler
  extends AVGameBusinessHandler
{
  private static Byte[] jdField_a_of_type_ArrayOfJavaLangByte = null;
  private final MQLruCache<String, Object> jdField_a_of_type_AndroidSupportV4UtilMQLruCache = GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache;
  private final QQLruCache<String, UserInfo> jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache = new QQLruCache(10001, 50, 10);
  private final QQLruCache<String, String> b = new QQLruCache(10001, 50, 10);
  
  protected UserInfoHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public static Bitmap a()
  {
    if (jdField_a_of_type_ArrayOfJavaLangByte == null)
    {
      jdField_a_of_type_ArrayOfJavaLangByte = new Byte[50];
      Arrays.fill(jdField_a_of_type_ArrayOfJavaLangByte, Byte.valueOf((byte)0));
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
    Arrays.fill(jdField_a_of_type_ArrayOfJavaLangByte, Byte.valueOf((byte)0));
    jdField_a_of_type_ArrayOfJavaLangByte[j] = Byte.valueOf(1);
    return AVGameUtils.a(String.format("pkAvatar/avgame_pk_avatar%d@2x.png", new Object[] { Integer.valueOf(j + 1) }));
  }
  
  private Bitmap a(boolean paramBoolean)
  {
    String str;
    if (!paramBoolean) {
      str = "static://DefaultFace_square";
    }
    for (int i = 2130840453;; i = 2130840452)
    {
      if (GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) {}
      for (Bitmap localBitmap1 = (Bitmap)GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(str);; localBitmap1 = null)
      {
        Bitmap localBitmap2 = localBitmap1;
        if (localBitmap1 == null)
        {
          localBitmap1 = BitmapManager.b(BaseApplicationImpl.getApplication().getResources(), i);
          if ((localBitmap1 != null) && (GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null)) {
            GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put(str, localBitmap1);
          }
          localBitmap2 = localBitmap1;
          if (QLog.isColorLevel())
          {
            QLog.d("UserInfoHandler", 2, "getDefaultFaceBitmap, bitmap=" + localBitmap1);
            localBitmap2 = localBitmap1;
          }
        }
        return localBitmap2;
      }
      str = "static://DefaultFace";
    }
  }
  
  private AVGameClientQIPCModule a()
  {
    AVGameClientQIPCModule localAVGameClientQIPCModule = null;
    if ((this.appRuntime instanceof AVGameAppInterface)) {
      localAVGameClientQIPCModule = ((AVGameAppInterface)this.appRuntime).a();
    }
    return localAVGameClientQIPCModule;
  }
  
  private void a(int paramInt, List<String> paramList)
  {
    if (paramList.size() == 0) {}
    for (;;)
    {
      return;
      Object localObject = new oidb_0x5eb.ReqBody();
      ArrayList localArrayList = new ArrayList(paramList.size());
      try
      {
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext()) {
          localArrayList.add(Long.valueOf(Long.parseLong((String)localIterator.next())));
        }
        if (!QLog.isColorLevel()) {}
      }
      catch (Exception localException)
      {
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
      }
    }
    QLog.i("UserInfoHandler", 2, "getNicksFromSvr " + paramList.size());
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
          if (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            this.b.put(str, paramHashMap.get(str));
          }
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
    for (;;)
    {
      String str1;
      String str2;
      synchronized (this.b)
      {
        paramList1 = paramList1.iterator();
        if (!paramList1.hasNext()) {
          break;
        }
        str1 = (String)paramList1.next();
        str2 = (String)this.b.get(str1);
        if (str2 == null) {
          paramList2.add(str1);
        }
      }
      paramHashMap.put(str1, str2);
    }
    if (QLog.isColorLevel()) {
      QLog.i("UserInfoHandler", 2, String.format("getNicks from cache = %s", new Object[] { paramHashMap }));
    }
  }
  
  public static UserInfo b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = GameEngine.a().a();
    if (localObject != null)
    {
      localObject = (UserInfoHandler)((AVGameAppInterface)localObject).getBusinessHandler(HandlerFactory.b);
      if (localObject != null) {
        return ((UserInfoHandler)localObject).a(paramString);
      }
    }
    return null;
  }
  
  public Bitmap a(int paramInt1, String paramString, byte paramByte, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) {}
    try
    {
      paramString = paramInt2 + "_" + paramString + "_" + paramInt1 + "_" + paramByte;
      paramString = this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(paramString);
      localObject1 = localObject2;
      if ((paramString instanceof Bitmap)) {
        localObject1 = (Bitmap)paramString;
      }
      return localObject1;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        paramString = null;
      }
    }
  }
  
  public Bitmap a(String paramString, byte paramByte)
  {
    boolean bool = true;
    Bitmap localBitmap2 = a(1, paramString, paramByte, 200);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = b(1, paramString, paramByte, 200);
    }
    if (localBitmap1 == null)
    {
      if (paramByte == 4) {}
      for (;;)
      {
        return ImageUtil.a(bool);
        bool = false;
      }
    }
    return localBitmap1;
  }
  
  public Bitmap a(String paramString, byte paramByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = true;
    boolean bool1 = true;
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
        if (paramBoolean1)
        {
          if (paramByte == 4) {}
          for (paramBoolean1 = bool1;; paramBoolean1 = false) {
            return a(paramBoolean1);
          }
        }
        if (paramByte == 4) {}
        for (paramBoolean1 = bool2;; paramBoolean1 = false) {
          return ImageUtil.a(paramBoolean1);
        }
      }
    }
    return paramString;
  }
  
  public UserInfo a(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = paramInt + "_" + paramString;
        paramString = (UserInfo)this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(paramString);
        return paramString;
      }
      catch (Throwable paramString)
      {
        return null;
      }
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
    if (paramUserInfo != null) {}
    try
    {
      String str = paramInt + "_" + paramString;
      this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(str, paramUserInfo);
      notifyUI(0, true, new Object[] { Integer.valueOf(paramInt), paramString, paramUserInfo });
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          localThrowable.printStackTrace();
          QLog.i("UserInfoHandler", 2, "updateUserInfo", localThrowable);
        }
      }
    }
  }
  
  protected void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = new oidb_0x5eb.RspBody();
    int j = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    int k = paramToServiceMsg.extraData.getInt("uinType");
    paramFromServiceMsg = paramToServiceMsg.extraData.getStringArrayList("uins");
    paramToServiceMsg = new HashMap(paramFromServiceMsg.size());
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (j == 0) {}
    for (;;)
    {
      int i;
      try
      {
        if (((oidb_0x5eb.RspBody)localObject).rpt_msg_uin_data.size() != paramFromServiceMsg.size()) {
          break label316;
        }
        paramObject = ((oidb_0x5eb.RspBody)localObject).rpt_msg_uin_data.get();
        paramFromServiceMsg = this.b;
        i = 0;
        try
        {
          if (i >= paramObject.size()) {
            break label279;
          }
          long l = ((oidb_0x5eb.UdcUinData)paramObject.get(i)).uint64_uin.get();
          localObject = ((oidb_0x5eb.UdcUinData)paramObject.get(i)).bytes_nick.get().toStringUtf8();
          if ((l <= 0L) || (localObject == null)) {
            break label322;
          }
          String str = Long.toString(l);
          paramToServiceMsg.put(str, localObject);
          this.b.put(str, localObject);
        }
        finally {}
        if (bool1) {
          break label236;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        bool1 = bool2;
      }
      notifyUI(2, false, new Object[] { Integer.valueOf(k), null });
      label236:
      if (QLog.isColorLevel()) {
        QLog.i("UserInfoHandler", 2, String.format("handleGetNicksFromSvr suc=%b result=%d nicks=%s", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(j), paramToServiceMsg }));
      }
      return;
      label279:
      label316:
      for (bool1 = true;; bool1 = false)
      {
        try
        {
          notifyUI(2, true, new Object[] { Integer.valueOf(k), paramToServiceMsg });
        }
        catch (Exception paramFromServiceMsg)
        {
          bool1 = true;
        }
        break;
      }
      label322:
      i += 1;
    }
  }
  
  public Bitmap b(int paramInt1, String paramString, byte paramByte, int paramInt2)
  {
    Object localObject = a();
    if (localObject == null) {}
    for (localObject = null;; localObject = ((AVGameClientQIPCModule)localObject).a(paramInt1, paramString, paramByte, paramInt2))
    {
      if (localObject != null) {}
      try
      {
        paramString = paramInt2 + "_" + paramString + "_" + paramInt1 + "_" + paramByte;
        this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put(paramString, localObject);
        return localObject;
      }
      catch (Throwable paramString) {}
    }
    return localObject;
  }
  
  public UserInfo b(int paramInt, String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (TextUtils.isEmpty(paramString)) {
      return localObject2;
    }
    localObject2 = a();
    if (localObject2 == null) {}
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        break;
      }
      try
      {
        paramString = paramInt + "_" + paramString;
        this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(paramString, localObject1);
        return localObject1;
      }
      catch (Throwable paramString)
      {
        localObject2 = localObject1;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      paramString.printStackTrace();
      QLog.i("UserInfoHandler", 2, "getUserInfoFromRemote", paramString);
      return localObject1;
      localObject1 = ((AVGameClientQIPCModule)localObject2).a(paramInt, paramString);
    }
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
  
  public Class<? extends BusinessObserver> observerClass()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.business.handler.UserInfoHandler
 * JD-Core Version:    0.7.0.1
 */