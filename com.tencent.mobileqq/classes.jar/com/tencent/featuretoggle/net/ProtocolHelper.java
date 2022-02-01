package com.tencent.featuretoggle.net;

import android.text.TextUtils;
import android.util.SparseArray;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.JceStruct;
import com.tencent.featuretoggle.SpManager;
import com.tencent.featuretoggle.ToggleSetting;
import com.tencent.featuretoggle.models.ClientContext;
import com.tencent.featuretoggle.models.ExtendInfo;
import com.tencent.featuretoggle.models.QueryFeatureReq;
import com.tencent.featuretoggle.utils.AppUtils;
import com.tencent.featuretoggle.utils.DeviceUtils;
import com.tencent.featuretoggle.utils.LogUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import org.json.JSONObject;

public class ProtocolHelper
{
  public static JceStruct a()
  {
    ClientContext localClientContext = new ClientContext();
    localClientContext.setUserId(ToggleSetting.i());
    localClientContext.setDeviceId(DeviceUtils.a());
    localClientContext.setHostname("");
    localClientContext.setRemoteAddress(AppUtils.c(ToggleSetting.a()));
    localClientContext.setSessionId("");
    localClientContext.setProperties(ToggleSetting.a());
    localClientContext.setQimei(ToggleSetting.a());
    ExtendInfo localExtendInfo = new ExtendInfo();
    localExtendInfo.setBundleId(AppUtils.b(ToggleSetting.a()));
    localExtendInfo.setChannel(ToggleSetting.e());
    localExtendInfo.setOs(ToggleSetting.j());
    localExtendInfo.setQua(ToggleSetting.l());
    localExtendInfo.setOsVersion(DeviceUtils.e());
    localExtendInfo.setSdkVersion(ToggleSetting.g());
    localExtendInfo.setProperties(new HashMap());
    QueryFeatureReq localQueryFeatureReq = new QueryFeatureReq();
    localQueryFeatureReq.setProductId(ToggleSetting.b());
    localQueryFeatureReq.setModuleId(ToggleSetting.d());
    localQueryFeatureReq.setModuleVersion(ToggleSetting.f());
    localQueryFeatureReq.setClientCtx(localClientContext);
    localQueryFeatureReq.setExtendInfo(localExtendInfo);
    long l = SpManager.a().a();
    localQueryFeatureReq.setTimestamp(l);
    localQueryFeatureReq.setLocalIdList(a(l));
    return localQueryFeatureReq;
  }
  
  public static <T extends JceStruct> T a(byte[] paramArrayOfByte, Class<T> paramClass)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    try
    {
      UniPacket localUniPacket = new UniPacket();
      localUniPacket.useVersion3();
      localUniPacket.setEncodeName("UTF-8");
      localUniPacket.decode(paramArrayOfByte);
      paramArrayOfByte = localUniPacket.getByClass("detail", paramClass.newInstance());
      if (paramClass.isInstance(paramArrayOfByte)) {
        return (JceStruct)paramClass.cast(paramArrayOfByte);
      }
      LogUtils.b("get jce from wup failed", new Object[0]);
      return null;
    }
    catch (Throwable paramArrayOfByte)
    {
      if (!LogUtils.a(paramArrayOfByte)) {
        paramArrayOfByte.printStackTrace();
      }
    }
    return null;
  }
  
  public static ArrayList<Integer> a(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramLong <= 0L) {
      return localArrayList;
    }
    Set localSet = a();
    if (!a(localArrayList, localSet)) {
      a(localArrayList, localSet);
    }
    return localArrayList;
  }
  
  private static Set<Integer> a()
  {
    Set localSet1;
    if (ToggleSetting.a()) {
      localSet1 = CacheManager.a().a();
    } else {
      localSet1 = null;
    }
    Set localSet2;
    if (localSet1 != null)
    {
      localSet2 = localSet1;
      if (!localSet1.isEmpty()) {}
    }
    else
    {
      CacheManager.a().a();
      localSet2 = CacheManager.a().a();
    }
    return localSet2;
  }
  
  private static void a(ArrayList<Integer> paramArrayList, Set<Integer> paramSet)
  {
    try
    {
      String[] arrayOfString = SpManager.a().a();
      if (arrayOfString != null)
      {
        if (arrayOfString.length == 0) {
          return;
        }
        SparseArray localSparseArray = CacheManager.a().a();
        if (localSparseArray != null) {
          localSparseArray.clear();
        }
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          Object localObject = arrayOfString[i];
          localObject = SpManager.a().a((String)localObject, "");
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = new JSONObject((String)localObject);
            int k = ((JSONObject)localObject).optInt("id");
            localObject = ((JSONObject)localObject).optString("name");
            if ((!TextUtils.isEmpty((CharSequence)localObject)) && (k > 0) && (localSparseArray != null)) {
              localSparseArray.put(k, localObject);
            }
            if ((paramSet != null) && (!paramSet.contains(Integer.valueOf(k)))) {
              paramArrayList.add(Integer.valueOf(k));
            }
          }
          i += 1;
        }
      }
      return;
    }
    catch (Throwable paramArrayList)
    {
      if (!LogUtils.a(paramArrayList)) {
        paramArrayList.printStackTrace();
      }
    }
  }
  
  private static boolean a(ArrayList<Integer> paramArrayList, Set<Integer> paramSet)
  {
    boolean bool = ToggleSetting.a();
    int i = 0;
    if (!bool) {
      return false;
    }
    SparseArray localSparseArray = CacheManager.a().a();
    if (localSparseArray != null)
    {
      if (paramSet == null) {
        return false;
      }
      int j = localSparseArray.size();
      if (j == 0) {
        return false;
      }
      while (i < j)
      {
        if (!paramSet.contains(Integer.valueOf(localSparseArray.keyAt(i)))) {
          paramArrayList.add(Integer.valueOf(localSparseArray.keyAt(i)));
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public static byte[] a(JceStruct paramJceStruct)
  {
    try
    {
      UniPacket localUniPacket = new UniPacket();
      localUniPacket.useVersion3();
      localUniPacket.setEncodeName("UTF-8");
      localUniPacket.put("detail", paramJceStruct);
      paramJceStruct = localUniPacket.encode();
      return paramJceStruct;
    }
    catch (Throwable paramJceStruct)
    {
      if (!LogUtils.a(paramJceStruct)) {
        paramJceStruct.printStackTrace();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.net.ProtocolHelper
 * JD-Core Version:    0.7.0.1
 */