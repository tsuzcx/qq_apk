package com.qq.im.poi;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import anf;
import ang;
import anh;
import ani;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.armap.ARGLSurfaceView;
import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.ARMapManager;
import com.tencent.mobileqq.armap.ArMapInterface;
import com.tencent.mobileqq.armap.ArMapUtil;
import com.tencent.mobileqq.armap.JNIPOIRequestParam;
import com.tencent.mobileqq.armap.NonMainAppHeadLoader;
import com.tencent.mobileqq.armap.config.ARMapConfig;
import com.tencent.mobileqq.nearby.NearbyURLSafeUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.manager.TicketManager;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.lbspack.MqqLbsPack.CFT_AR_INFO;
import tencent.im.oidb.lbspack.MqqLbsPack.LBSSig;
import tencent.im.oidb.lbspack.MqqLbsPack.PoiInfo;

public class LbsPackManager
  implements Manager
{
  private static LruCache b;
  public static double c;
  private static String e;
  public double a;
  public int a;
  private LruCache jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(32);
  public LbsPackConfig a;
  public LbsPackInfo a;
  public LbsPackMapInfo a;
  public ArMapInterface a;
  public JNIPOIRequestParam a;
  public String a;
  public SoftReference a;
  public ArrayList a;
  HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public double b;
  public int b;
  public String b;
  private String c;
  private String d;
  
  static
  {
    jdField_b_of_type_AndroidSupportV4UtilLruCache = new LruCache(128);
    e = null;
    jdField_c_of_type_Double = 6378137.0D;
  }
  
  public LbsPackManager(ArMapInterface paramArMapInterface)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_Int = 2;
    this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface = paramArMapInterface;
    a();
  }
  
  static double a(double paramDouble)
  {
    return 3.141592653589793D * paramDouble / 180.0D;
  }
  
  public static double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    if ((Math.abs(paramDouble1 - paramDouble3) > 1.0E-006D) || (Math.abs(paramDouble2 - paramDouble4) > 1.0E-006D))
    {
      paramDouble2 = a(paramDouble2);
      paramDouble4 = a(paramDouble4);
      paramDouble1 = a(paramDouble1);
      paramDouble3 = a(paramDouble3);
      double d1 = Math.pow(Math.sin((paramDouble2 - paramDouble4) / 2.0D), 2.0D);
      return Math.floor(Math.asin(Math.sqrt(Math.cos(paramDouble2) * Math.cos(paramDouble4) * Math.pow(Math.sin((paramDouble1 - paramDouble3) / 2.0D), 2.0D) + d1)) * 2.0D * jdField_c_of_type_Double * 10000.0D + 0.5D) / 10000.0D;
    }
    return 0.0D;
  }
  
  private static String e(String paramString)
  {
    Object localObject = MD5.toMD5(paramString);
    localObject = MD5.toMD5((String)localObject + paramString);
    String str = MD5.toMD5((String)localObject + paramString);
    if (e == null)
    {
      localObject = Environment.getExternalStorageDirectory().getPath();
      paramString = (String)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramString = "/sdcard/";
      }
      localObject = paramString;
      if (!paramString.endsWith("/")) {
        localObject = paramString + "/";
      }
      paramString = (String)localObject + "Tencent/MobileQQ/LBS_PACK/icons/";
      e = paramString;
    }
    try
    {
      localObject = new File(paramString);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      return e + str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LbsPack", 2, "", localException);
        }
        e = paramString;
      }
    }
  }
  
  public Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    Bitmap localBitmap;
    if (paramBitmap == null) {
      localBitmap = null;
    }
    int j;
    do
    {
      do
      {
        return localBitmap;
        i = paramBitmap.getWidth();
        j = paramBitmap.getHeight();
        localBitmap = paramBitmap;
      } while (i <= paramInt1);
      localBitmap = paramBitmap;
    } while (j <= paramInt1);
    int i = 0;
    for (;;)
    {
      localBitmap = paramBitmap;
      if (i >= paramInt1) {
        break;
      }
      j = 0;
      while (j < paramInt1)
      {
        paramBitmap.setPixel(i, j, paramInt2);
        j += 1;
      }
      i += 1;
    }
  }
  
  public Bundle a(List paramList)
  {
    Bundle localBundle = new Bundle();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = paramList.iterator();
    label126:
    while (localIterator.hasNext())
    {
      paramList = (oidb_0x5eb.UdcUinData)localIterator.next();
      String str = String.valueOf(paramList.uint64_uin.get());
      if (paramList.bytes_nick.has()) {}
      for (paramList = paramList.bytes_nick.get().toStringUtf8();; paramList = "")
      {
        if (TextUtils.isEmpty(paramList)) {
          break label126;
        }
        localArrayList1.add(str);
        localArrayList2.add(paramList);
        this.jdField_a_of_type_JavaUtilHashMap.put(str, paramList);
        break;
      }
    }
    localBundle.putStringArrayList("uinList", localArrayList1);
    localBundle.putStringArrayList("nickList", localArrayList2);
    return localBundle;
  }
  
  public LbsPackInfo a(long paramLong, String paramString)
  {
    if ((paramLong <= 0L) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    if (this.jdField_a_of_type_ComQqImPoiLbsPackMapInfo != null)
    {
      Object localObject = (LbsPackPoiInfo)this.jdField_a_of_type_ComQqImPoiLbsPackMapInfo.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      if (localObject != null)
      {
        localObject = ((LbsPackPoiInfo)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          LbsPackInfo localLbsPackInfo = (LbsPackInfo)((Iterator)localObject).next();
          if ((!TextUtils.isEmpty(localLbsPackInfo.jdField_b_of_type_JavaLangString)) && (localLbsPackInfo.jdField_b_of_type_JavaLangString.equals(paramString))) {
            return localLbsPackInfo;
          }
        }
      }
    }
    return null;
  }
  
  public LbsPackMapInfo a()
  {
    return this.jdField_a_of_type_ComQqImPoiLbsPackMapInfo;
  }
  
  public PoiInfo a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      return (PoiInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    }
    return null;
  }
  
  public String a()
  {
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      return this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.getAccount();
    }
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public String a(int paramInt)
  {
    return ARMapConfig.getLbsPoi(((ARMapManager)this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.getManager(209)).a(true), paramInt);
  }
  
  public String a(LbsPackInfo paramLbsPackInfo, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqArmapJNIPOIRequestParam;
    MqqLbsPack.LBSSig localLBSSig = new MqqLbsPack.LBSSig();
    localLBSSig.int32_lon.set((int)ArMapUtil.a(((JNIPOIRequestParam)localObject).lbsSig_lon, 1000000.0D));
    localLBSSig.int32_lat.set((int)ArMapUtil.a(((JNIPOIRequestParam)localObject).lbsSig_lat, 1000000.0D));
    localLBSSig.uint32_time.set((int)(((JNIPOIRequestParam)localObject).lbsSig_locationTime / 1000.0D));
    if (!StringUtil.a(((JNIPOIRequestParam)localObject).lbsSig_verifyKey)) {
      localLBSSig.bytes_verify_key.set(LbsPackMapPoiPackServlet.a(((JNIPOIRequestParam)localObject).lbsSig_verifyKey));
    }
    if (QLog.isColorLevel()) {
      QLog.d("LbsPack", 2, "getARLbsInfo lon=" + localLBSSig.int32_lon.get() + " lat=" + localLBSSig.int32_lat.get() + " time=" + localLBSSig.uint32_time.get() + " ver=" + localLBSSig.bytes_verify_key.get());
    }
    localObject = new MqqLbsPack.CFT_AR_INFO();
    ((MqqLbsPack.CFT_AR_INFO)localObject).msg_lbs_sig.set(localLBSSig);
    ((MqqLbsPack.CFT_AR_INFO)localObject).uint32_qa.set(paramLbsPackInfo.jdField_c_of_type_Int);
    ((MqqLbsPack.CFT_AR_INFO)localObject).uint32_attempt_num.set(paramInt);
    return Base64Util.encodeToString(((MqqLbsPack.CFT_AR_INFO)localObject).toByteArray(), 0);
  }
  
  public String a(PoiInfo paramPoiInfo)
  {
    int j;
    if (paramPoiInfo != null) {
      j = paramPoiInfo.jdField_b_of_type_Int;
    }
    for (int i = paramPoiInfo.jdField_a_of_type_Int;; i = (int)(this.jdField_b_of_type_Double * 1000000.0D))
    {
      long l = (j << 32) + i;
      if (QLog.isColorLevel()) {
        QLog.d("LbsPack", 2, "getCurPoiParam= " + j + "|" + i + "|||" + l);
      }
      return String.valueOf(l);
      j = (int)(this.jdField_a_of_type_Double * 1000000.0D);
    }
  }
  
  public String a(String paramString)
  {
    Object localObject2 = "https://wa.qq.com/lbs/index.html?_wv=1090528161&_wwv=4&adtag=aio";
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComQqImPoiLbsPackConfig != null)
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComQqImPoiLbsPackConfig.mStructUrl))
      {
        if (QLog.isColorLevel()) {
          QLog.d("LbsPack", 2, "getLbsHBshareUrl " + this.jdField_a_of_type_ComQqImPoiLbsPackConfig.mStructUrl);
        }
        localObject1 = this.jdField_a_of_type_ComQqImPoiLbsPackConfig.mStructUrl;
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1).append("&u=").append(NearbyURLSafeUtil.a(this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.getCurrentAccountUin())).append("&pid=").append(paramString);
    return ((StringBuilder)localObject2).toString();
  }
  
  public String a(boolean paramBoolean)
  {
    String str3 = a();
    String str1 = str3 + "在这里发了AR红包，速度来领！";
    if (paramBoolean) {
      str1 = str3 + "在QQ里发了AR红包。";
    }
    String str2 = str1;
    if (this.jdField_a_of_type_ComQqImPoiLbsPackConfig != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("LbsPack", 2, "getLbsHBshareTitle " + this.jdField_a_of_type_ComQqImPoiLbsPackConfig.mQQTitle + "|" + this.jdField_a_of_type_ComQqImPoiLbsPackConfig.mWXTitle);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComQqImPoiLbsPackConfig.mQQTitle)) {
        str1 = this.jdField_a_of_type_ComQqImPoiLbsPackConfig.mQQTitle.replace("$N", str3);
      }
      str2 = str1;
      if (paramBoolean)
      {
        str2 = str1;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComQqImPoiLbsPackConfig.mWXTitle)) {
          str2 = this.jdField_a_of_type_ComQqImPoiLbsPackConfig.mWXTitle.replace("$N", str3);
        }
      }
    }
    return str2;
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    ThreadManager.post(new anh(this), 5, null, false);
  }
  
  public void a(double paramDouble1, double paramDouble2, int paramInt)
  {
    this.jdField_a_of_type_Double = paramDouble1;
    this.jdField_b_of_type_Double = paramDouble2;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LbsPack", 2, "onUnpackResult poiId=" + paramLong + " pid=" + paramString + " uin" + this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.getCurrentAccountUin());
    }
    Object localObject;
    int i;
    LbsPackPoiInfo localLbsPackPoiInfo;
    LbsPackInfo localLbsPackInfo;
    if ((this.jdField_a_of_type_ComQqImPoiLbsPackMapInfo != null) && (this.jdField_a_of_type_ComQqImPoiLbsPackMapInfo.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_ComQqImPoiLbsPackMapInfo.jdField_a_of_type_JavaUtilHashMap.size() > 0))
    {
      localObject = this.jdField_a_of_type_ComQqImPoiLbsPackMapInfo.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      i = 0;
      if (((Iterator)localObject).hasNext())
      {
        localLbsPackPoiInfo = (LbsPackPoiInfo)((Iterator)localObject).next();
        if (QLog.isColorLevel()) {
          QLog.d("LbsPack", 2, "onUnpackResult for poiId=" + localLbsPackPoiInfo.jdField_a_of_type_Long + " num=" + localLbsPackPoiInfo.jdField_c_of_type_Int);
        }
        if ((localLbsPackPoiInfo == null) || (localLbsPackPoiInfo.jdField_a_of_type_JavaUtilArrayList == null)) {
          break label414;
        }
        Iterator localIterator = localLbsPackPoiInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localLbsPackInfo = (LbsPackInfo)localIterator.next();
            if (QLog.isColorLevel()) {
              QLog.d("LbsPack", 2, "onUnpackResult for pid=" + localLbsPackInfo.jdField_b_of_type_JavaLangString + " sta=" + localLbsPackInfo.jdField_a_of_type_Int + " uin=" + localLbsPackInfo.jdField_a_of_type_Long);
            }
            if (paramString.equals(localLbsPackInfo.jdField_b_of_type_JavaLangString)) {
              if (String.valueOf(localLbsPackInfo.jdField_a_of_type_Long).equals(this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.getCurrentAccountUin()))
              {
                localLbsPackInfo.jdField_a_of_type_Int = 2;
                label328:
                i = 1;
              }
            }
          }
        }
      }
    }
    label414:
    for (;;)
    {
      if (i != 0)
      {
        if (this.jdField_a_of_type_JavaLangRefSoftReference != null)
        {
          localObject = (ARMapActivity)this.jdField_a_of_type_JavaLangRefSoftReference.get();
          if ((localObject != null) && (((ARMapActivity)localObject).jdField_a_of_type_ComTencentMobileqqArmapMapARMapEngine != null) && (((ARMapActivity)localObject).jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView != null)) {
            ((ARMapActivity)localObject).jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView.queueEvent(new anf(this, (ARMapActivity)localObject, paramLong, paramString));
          }
        }
        return;
        localLbsPackPoiInfo.jdField_a_of_type_JavaUtilArrayList.remove(localLbsPackInfo);
        break label328;
      }
      break;
    }
  }
  
  public void a(long paramLong, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LbsPack", 2, "openLBSRPReportReq, poi_id:" + paramLong + ", pid:" + paramString + ", status:" + paramInt);
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.getApp(), LbsPackPoiListServlet.class);
    localNewIntent.putExtra("key_poi_id", paramLong);
    localNewIntent.putExtra("key_pid", paramString);
    localNewIntent.putExtra("key_pack_status", paramInt);
    localNewIntent.putExtra("k_cmd", 2);
    this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.startServlet(localNewIntent);
  }
  
  public void a(LbsPackMapInfo paramLbsPackMapInfo)
  {
    this.jdField_a_of_type_ComQqImPoiLbsPackMapInfo = paramLbsPackMapInfo;
  }
  
  public void a(BaseActivity paramBaseActivity, int paramInt1, LbsPackInfo paramLbsPackInfo, int paramInt2)
  {
    if (paramLbsPackInfo == null)
    {
      LbsPackStatsCollector.a("actLbsGetPackFailure", -10003);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LbsPack", 2, "CFT_HB_GRAP:getGrapHBInfo|poiInfo= " + paramLbsPackInfo.toString());
    }
    this.jdField_a_of_type_ComQqImPoiLbsPackInfo = paramLbsPackInfo;
    localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("feedsid", paramLbsPackInfo.jdField_b_of_type_JavaLangString);
      localJSONObject.put("listid", paramLbsPackInfo.jdField_a_of_type_JavaLangString);
      localJSONObject.put("authkey", paramLbsPackInfo.f);
      localJSONObject.put("channel", "4096");
      localJSONObject.put("name", a());
      localJSONObject.put("poi", a(null));
      localObject1 = "";
      localObject2 = String.valueOf(paramLbsPackInfo.jdField_c_of_type_Long);
      if (paramLbsPackInfo.d != 5) {
        break label396;
      }
      localObject1 = "0";
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          ((JSONObject)localObject1).put("userId", this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.getCurrentAccountUin());
          ((JSONObject)localObject1).put("nick_name", a());
          ((JSONObject)localObject1).put("viewTag", "graphb");
          ((JSONObject)localObject1).put("app_info", "appid#1344242394|bargainor_id#1000030201|channel#arctc@0006");
          ((JSONObject)localObject1).put("come_from", 2);
          ((JSONObject)localObject1).put("extra_data", localJSONObject);
          Object localObject2 = new Bundle();
          ((Bundle)localObject2).putString("json", ((JSONObject)localObject1).toString());
          ((Bundle)localObject2).putString("callbackSn", "0");
          Object localObject1 = new Intent(paramBaseActivity, PayBridgeActivity.class);
          ((Intent)localObject1).putExtras((Bundle)localObject2);
          ((Intent)localObject1).putExtra("pid", paramLbsPackInfo.jdField_b_of_type_JavaLangString);
          ((Intent)localObject1).putExtra("pay_requestcode", 5);
          paramBaseActivity.startActivityForResult((Intent)localObject1, paramInt1);
          return;
          if (paramLbsPackInfo.d == 3)
          {
            localObject1 = "1";
          }
          else if (paramLbsPackInfo.d == 4)
          {
            localObject1 = "2";
          }
          else if ((paramLbsPackInfo.d == 2) || (paramLbsPackInfo.d == 1))
          {
            localObject1 = "103";
            long l = paramLbsPackInfo.jdField_a_of_type_Long;
            localObject2 = String.valueOf(l);
          }
        }
        localException1 = localException1;
        localException1.printStackTrace();
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
      }
    }
    localJSONObject.put("grouptype", localObject1);
    localJSONObject.put("groupid", localObject2);
    localJSONObject.put("ar_info", a(paramLbsPackInfo, paramInt2));
    localJSONObject.put("skey", b());
    localJSONObject.put("skey_type", 2);
    localObject1 = new JSONObject();
  }
  
  public void a(ARMapActivity paramARMapActivity)
  {
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramARMapActivity);
  }
  
  public void a(JNIPOIRequestParam paramJNIPOIRequestParam)
  {
    if ((TextUtils.isEmpty(paramJNIPOIRequestParam.lbsSig_verifyKey)) && (this.jdField_a_of_type_ComTencentMobileqqArmapJNIPOIRequestParam != null))
    {
      paramJNIPOIRequestParam.lbsSig_verifyKey = this.jdField_a_of_type_ComTencentMobileqqArmapJNIPOIRequestParam.lbsSig_verifyKey;
      paramJNIPOIRequestParam.lbsSig_lon = this.jdField_a_of_type_ComTencentMobileqqArmapJNIPOIRequestParam.lbsSig_lon;
      paramJNIPOIRequestParam.lbsSig_lat = this.jdField_a_of_type_ComTencentMobileqqArmapJNIPOIRequestParam.lbsSig_lat;
      paramJNIPOIRequestParam.lbsSig_locationTime = this.jdField_a_of_type_ComTencentMobileqqArmapJNIPOIRequestParam.lbsSig_locationTime;
      paramJNIPOIRequestParam.accuracy = this.jdField_a_of_type_ComTencentMobileqqArmapJNIPOIRequestParam.accuracy;
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LbsPack", 2, "onSendPackFinished :" + paramString);
    }
    if (this.jdField_a_of_type_JavaLangRefSoftReference != null)
    {
      ARMapActivity localARMapActivity = (ARMapActivity)this.jdField_a_of_type_JavaLangRefSoftReference.get();
      if ((localARMapActivity != null) && (localARMapActivity.jdField_a_of_type_ComTencentMobileqqArmapMapARMapEngine != null) && (localARMapActivity.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView != null)) {
        localARMapActivity.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView.queueEvent(new ang(this, localARMapActivity, paramString));
      }
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    LruCache localLruCache = this.jdField_a_of_type_AndroidSupportV4UtilLruCache;
    if ((localLruCache != null) && (TextUtils.isEmpty((CharSequence)localLruCache.get(paramString)))) {}
    do
    {
      return;
      localLruCache = jdField_b_of_type_AndroidSupportV4UtilLruCache;
    } while ((localLruCache != null) && (!TextUtils.isEmpty((CharSequence)localLruCache.get(paramString))));
    ThreadManager.post(new ani(this, paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight(), paramString), 5, null, false);
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (paramArrayList.size() > 0) {
      LbsPackMapPoiPackServlet.a(this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface, paramArrayList);
    }
  }
  
  public void a(List paramList)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MqqLbsPack.PoiInfo localPoiInfo = (MqqLbsPack.PoiInfo)paramList.next();
        PoiInfo localPoiInfo1 = new PoiInfo();
        localPoiInfo1.jdField_a_of_type_Long = localPoiInfo.uint64_poi_id.get();
        localPoiInfo1.jdField_a_of_type_Int = localPoiInfo.int32_lat.get();
        localPoiInfo1.jdField_b_of_type_Int = localPoiInfo.int32_lon.get();
        localPoiInfo1.jdField_a_of_type_JavaLangString = localPoiInfo.bytes_name.get().toStringUtf8();
        localPoiInfo1.jdField_b_of_type_JavaLangString = localPoiInfo.bytes_addr.get().toStringUtf8();
        this.jdField_a_of_type_JavaUtilArrayList.add(localPoiInfo1);
      }
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArmapJNIPOIRequestParam != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqArmapJNIPOIRequestParam;
      double d1 = ((JNIPOIRequestParam)localObject).lbsSig_lat;
      double d2 = ((JNIPOIRequestParam)localObject).lbsSig_lon;
      int i = (int)(((JNIPOIRequestParam)localObject).lbsSig_locationTime / 1000.0D);
      String str = ((JNIPOIRequestParam)localObject).encrypt_sig;
      localObject = ((JNIPOIRequestParam)localObject).lbsSig_verifyKey;
      double d3 = this.jdField_b_of_type_Double;
      double d4 = this.jdField_a_of_type_Double;
      int j = this.jdField_a_of_type_Int;
      NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.getApp(), LbsPackPoiListServlet.class);
      localNewIntent.putExtra("key_latitude", (int)ArMapUtil.a(d1, 1000000.0D));
      localNewIntent.putExtra("key_longitude", (int)ArMapUtil.a(d2, 1000000.0D));
      localNewIntent.putExtra("key_time", i);
      localNewIntent.putExtra("key_encrypt_sig", str);
      localNewIntent.putExtra("key_verify_key", (String)localObject);
      localNewIntent.putExtra("k_cmd", 1);
      localNewIntent.putExtra("key_latitude_cur", (int)ArMapUtil.a(d3, 1000000.0D));
      localNewIntent.putExtra("key_longitude_cur", (int)ArMapUtil.a(d4, 1000000.0D));
      localNewIntent.putExtra("key_accuracy", j);
      if (QLog.isColorLevel()) {
        QLog.d("LbsPack", 2, "postGetSendPoiList : lat = " + d1 + ", lon = " + d2 + ", accuracy = " + j + ", time = " + i + ", encryptSig = " + str + ", verifyKey = " + (String)localObject + ", lat_cur = " + d3 + ", lon_cur = " + d4);
      }
      this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.startServlet(localNewIntent);
      return true;
    }
    LbsPackStatsCollector.a("actLbsSendPoiListFailure", -10002);
    if (QLog.isColorLevel()) {
      QLog.e("LbsPack", 2, "postGetSendPoiList,jniPoiRequestParam is null");
    }
    return false;
  }
  
  public boolean a(PoiInfo paramPoiInfo, int paramInt1, String paramString, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArmapJNIPOIRequestParam != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqArmapJNIPOIRequestParam;
      double d1 = ((JNIPOIRequestParam)localObject).lbsSig_lat;
      double d2 = ((JNIPOIRequestParam)localObject).lbsSig_lon;
      int j = (int)(((JNIPOIRequestParam)localObject).lbsSig_locationTime / 1000.0D);
      String str = ((JNIPOIRequestParam)localObject).encrypt_sig;
      localObject = ((JNIPOIRequestParam)localObject).lbsSig_verifyKey;
      double d3 = this.jdField_b_of_type_Double;
      double d4 = this.jdField_a_of_type_Double;
      int k = this.jdField_a_of_type_Int;
      NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.getApp(), LbsPackPoiListServlet.class);
      localNewIntent.putExtra("key_latitude", (int)ArMapUtil.a(d1, 1000000.0D));
      localNewIntent.putExtra("key_longitude", (int)ArMapUtil.a(d2, 1000000.0D));
      localNewIntent.putExtra("key_time", j);
      localNewIntent.putExtra("key_encrypt_sig", str);
      localNewIntent.putExtra("key_verify_key", (String)localObject);
      localNewIntent.putExtra("key_poi_id", paramPoiInfo.jdField_a_of_type_Long);
      localNewIntent.putExtra("key_poi_latitude", paramPoiInfo.jdField_a_of_type_Int);
      localNewIntent.putExtra("key_poi_longitude", paramPoiInfo.jdField_b_of_type_Int);
      localNewIntent.putExtra("key_poi_NAME", paramPoiInfo.jdField_a_of_type_JavaLangString);
      localNewIntent.putExtra("key_poi_address", paramPoiInfo.jdField_b_of_type_JavaLangString);
      localNewIntent.putExtra("key_latitude_cur", (int)ArMapUtil.a(d3, 1000000.0D));
      localNewIntent.putExtra("key_longitude_cur", (int)ArMapUtil.a(d4, 1000000.0D));
      localNewIntent.putExtra("key_accuracy", k);
      long l = Long.valueOf(paramString).longValue();
      if (paramInt1 == 1)
      {
        localNewIntent.putExtra("key_group_id", l);
        if (paramInt1 != -1) {
          break label537;
        }
      }
      label537:
      for (int i = 1;; i = 0)
      {
        localNewIntent.putExtra("key_all_friends_flag", i);
        localNewIntent.putExtra("key_posion_flag", paramInt2);
        localNewIntent.putExtra("k_cmd", 3);
        if (QLog.isColorLevel()) {
          QLog.d("LbsPack", 2, "postGetPId : lat = " + d1 + ", lon = " + d2 + ", accuracy = " + k + ", time = " + j + ", encryptSig = " + str + ", verifyKey = " + (String)localObject + ", poiInfo = " + paramPoiInfo + ", uinType = " + paramInt1 + ", uin" + paramString + ", pFlag = " + paramInt2 + ", lat_cur = " + d3 + ", lon_cur = " + d4);
        }
        this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.startServlet(localNewIntent);
        return true;
        if (paramInt1 == 3000)
        {
          localNewIntent.putExtra("key_dicuss_id", l);
          break;
        }
        if (paramInt1 != 0) {
          break;
        }
        localNewIntent.putExtra("key_friend_uin", l);
        break;
      }
    }
    LbsPackStatsCollector.a("actLbsSendGetPidFailure", -10002);
    if (QLog.isColorLevel()) {
      QLog.e("LbsPack", 2, "postGetPcakId, mJniPoiParamForSend is null");
    }
    return false;
  }
  
  public String b()
  {
    TicketManager localTicketManager = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.getManager(2);
    if (localTicketManager != null) {
      return localTicketManager.getSkey(this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.getCurrentAccountUin());
    }
    return "";
  }
  
  public String b(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) {
      return (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    }
    return null;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComQqImPoiLbsPackConfig = LbsPackConfig.readFromFile(this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.getCurrentAccountUin());
    if ((this.jdField_a_of_type_ComQqImPoiLbsPackConfig == null) && (QLog.isColorLevel())) {
      QLog.e("LbsPack", 2, "loadConfig failed!");
    }
  }
  
  public void b(String paramString)
  {
    this.d = paramString;
  }
  
  /* Error */
  public void b(List paramList)
  {
    // Byte code:
    //   0: invokestatic 875	java/lang/System:currentTimeMillis	()J
    //   3: lstore_2
    //   4: new 45	java/util/ArrayList
    //   7: dup
    //   8: invokespecial 46	java/util/ArrayList:<init>	()V
    //   11: astore 10
    //   13: aload_0
    //   14: getfield 59	com/qq/im/poi/LbsPackManager:jdField_a_of_type_ComTencentMobileqqArmapArMapInterface	Lcom/tencent/mobileqq/armap/ArMapInterface;
    //   17: invokevirtual 460	com/tencent/mobileqq/armap/ArMapInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   20: astore 11
    //   22: aload_1
    //   23: invokeinterface 203 1 0
    //   28: astore 12
    //   30: aload 12
    //   32: invokeinterface 208 1 0
    //   37: ifeq +1056 -> 1093
    //   40: aload 12
    //   42: invokeinterface 212 1 0
    //   47: checkcast 281	com/qq/im/poi/LbsPackInfo
    //   50: astore 14
    //   52: aload 14
    //   54: getfield 534	com/qq/im/poi/LbsPackInfo:jdField_a_of_type_Long	J
    //   57: invokestatic 228	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   60: astore 13
    //   62: new 119	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   69: ldc_w 877
    //   72: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload 11
    //   77: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 883	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   86: astore_1
    //   87: aload_0
    //   88: getfield 59	com/qq/im/poi/LbsPackManager:jdField_a_of_type_ComTencentMobileqqArmapArMapInterface	Lcom/tencent/mobileqq/armap/ArMapInterface;
    //   91: invokevirtual 578	com/tencent/mobileqq/armap/ArMapInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   94: invokevirtual 889	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   97: aload_1
    //   98: aconst_null
    //   99: ldc_w 891
    //   102: iconst_1
    //   103: anewarray 151	java/lang/String
    //   106: dup
    //   107: iconst_0
    //   108: aload 13
    //   110: aastore
    //   111: aconst_null
    //   112: invokevirtual 897	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   115: astore_1
    //   116: aload_1
    //   117: ifnull +1113 -> 1230
    //   120: aload_1
    //   121: invokeinterface 902 1 0
    //   126: ifle +1104 -> 1230
    //   129: aload_1
    //   130: invokeinterface 905 1 0
    //   135: pop
    //   136: aload_1
    //   137: aload_1
    //   138: ldc_w 907
    //   141: invokeinterface 911 2 0
    //   146: invokeinterface 914 2 0
    //   151: invokestatic 917	com/tencent/mobileqq/utils/SecurityUtile:a	(Ljava/lang/String;)Ljava/lang/String;
    //   154: astore 7
    //   156: aload 7
    //   158: astore 6
    //   160: aload 7
    //   162: invokestatic 145	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   165: ifeq +23 -> 188
    //   168: aload_1
    //   169: aload_1
    //   170: ldc_w 642
    //   173: invokeinterface 911 2 0
    //   178: invokeinterface 914 2 0
    //   183: invokestatic 917	com/tencent/mobileqq/utils/SecurityUtile:a	(Ljava/lang/String;)Ljava/lang/String;
    //   186: astore 6
    //   188: aload 6
    //   190: invokestatic 145	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   193: ifne +43 -> 236
    //   196: aload 14
    //   198: aload 6
    //   200: putfield 918	com/qq/im/poi/LbsPackInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   203: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   206: ifeq +30 -> 236
    //   209: ldc 174
    //   211: iconst_2
    //   212: new 119	java/lang/StringBuilder
    //   215: dup
    //   216: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   219: ldc_w 920
    //   222: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: aload 6
    //   227: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokestatic 399	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: aload 6
    //   238: astore 7
    //   240: aload_1
    //   241: ifnull +982 -> 1223
    //   244: aload_1
    //   245: invokeinterface 923 1 0
    //   250: aload 6
    //   252: astore_1
    //   253: aload 6
    //   255: invokestatic 145	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   258: ifeq +258 -> 516
    //   261: aload 14
    //   263: getfield 648	com/qq/im/poi/LbsPackInfo:jdField_c_of_type_Long	J
    //   266: lstore 4
    //   268: new 119	java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   275: ldc_w 925
    //   278: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: aload 11
    //   283: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: ldc 149
    //   288: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: lload 4
    //   293: invokestatic 228	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   296: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: ldc 149
    //   301: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: aload 13
    //   306: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokestatic 883	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   315: astore_1
    //   316: aload_0
    //   317: getfield 59	com/qq/im/poi/LbsPackManager:jdField_a_of_type_ComTencentMobileqqArmapArMapInterface	Lcom/tencent/mobileqq/armap/ArMapInterface;
    //   320: invokevirtual 578	com/tencent/mobileqq/armap/ArMapInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   323: invokevirtual 889	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   326: aload_1
    //   327: aconst_null
    //   328: aconst_null
    //   329: aconst_null
    //   330: aconst_null
    //   331: invokevirtual 897	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   334: astore 7
    //   336: aload 6
    //   338: astore 9
    //   340: aload 7
    //   342: ifnull +156 -> 498
    //   345: aload 6
    //   347: astore 9
    //   349: aload 7
    //   351: astore_1
    //   352: aload 6
    //   354: astore 8
    //   356: aload 7
    //   358: invokeinterface 902 1 0
    //   363: ifle +135 -> 498
    //   366: aload 7
    //   368: astore_1
    //   369: aload 6
    //   371: astore 8
    //   373: aload 7
    //   375: invokeinterface 905 1 0
    //   380: pop
    //   381: aload 7
    //   383: astore_1
    //   384: aload 6
    //   386: astore 8
    //   388: aload 7
    //   390: aload 7
    //   392: ldc_w 927
    //   395: invokeinterface 911 2 0
    //   400: invokeinterface 914 2 0
    //   405: invokestatic 917	com/tencent/mobileqq/utils/SecurityUtile:a	(Ljava/lang/String;)Ljava/lang/String;
    //   408: astore 6
    //   410: aload 6
    //   412: astore 9
    //   414: aload 7
    //   416: astore_1
    //   417: aload 6
    //   419: astore 8
    //   421: aload 6
    //   423: invokestatic 145	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   426: ifne +72 -> 498
    //   429: aload 7
    //   431: astore_1
    //   432: aload 6
    //   434: astore 8
    //   436: aload 14
    //   438: aload 6
    //   440: putfield 918	com/qq/im/poi/LbsPackInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   443: aload 6
    //   445: astore 9
    //   447: aload 7
    //   449: astore_1
    //   450: aload 6
    //   452: astore 8
    //   454: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   457: ifeq +41 -> 498
    //   460: aload 7
    //   462: astore_1
    //   463: aload 6
    //   465: astore 8
    //   467: ldc 174
    //   469: iconst_2
    //   470: new 119	java/lang/StringBuilder
    //   473: dup
    //   474: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   477: ldc_w 929
    //   480: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: aload 6
    //   485: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   491: invokestatic 399	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   494: aload 6
    //   496: astore 9
    //   498: aload 9
    //   500: astore_1
    //   501: aload 7
    //   503: ifnull +13 -> 516
    //   506: aload 7
    //   508: invokeinterface 923 1 0
    //   513: aload 9
    //   515: astore_1
    //   516: aload_1
    //   517: astore 6
    //   519: aload_1
    //   520: invokestatic 145	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   523: ifeq +253 -> 776
    //   526: aload 14
    //   528: getfield 648	com/qq/im/poi/LbsPackInfo:jdField_c_of_type_Long	J
    //   531: lstore 4
    //   533: new 119	java/lang/StringBuilder
    //   536: dup
    //   537: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   540: ldc_w 931
    //   543: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: aload 11
    //   548: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: ldc 149
    //   553: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: lload 4
    //   558: invokestatic 228	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   561: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: ldc 149
    //   566: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: aload 13
    //   571: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   577: invokestatic 883	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   580: astore 6
    //   582: aload_0
    //   583: getfield 59	com/qq/im/poi/LbsPackManager:jdField_a_of_type_ComTencentMobileqqArmapArMapInterface	Lcom/tencent/mobileqq/armap/ArMapInterface;
    //   586: invokevirtual 578	com/tencent/mobileqq/armap/ArMapInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   589: invokevirtual 889	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   592: aload 6
    //   594: aconst_null
    //   595: aconst_null
    //   596: aconst_null
    //   597: aconst_null
    //   598: invokevirtual 897	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   601: astore 7
    //   603: aload_1
    //   604: astore 9
    //   606: aload 7
    //   608: ifnull +148 -> 756
    //   611: aload_1
    //   612: astore 9
    //   614: aload 7
    //   616: astore 6
    //   618: aload_1
    //   619: astore 8
    //   621: aload 7
    //   623: invokeinterface 902 1 0
    //   628: ifle +128 -> 756
    //   631: aload 7
    //   633: astore 6
    //   635: aload_1
    //   636: astore 8
    //   638: aload 7
    //   640: invokeinterface 905 1 0
    //   645: pop
    //   646: aload 7
    //   648: astore 6
    //   650: aload_1
    //   651: astore 8
    //   653: aload 7
    //   655: aload 7
    //   657: ldc_w 933
    //   660: invokeinterface 911 2 0
    //   665: invokeinterface 914 2 0
    //   670: invokestatic 917	com/tencent/mobileqq/utils/SecurityUtile:a	(Ljava/lang/String;)Ljava/lang/String;
    //   673: astore_1
    //   674: aload_1
    //   675: astore 9
    //   677: aload 7
    //   679: astore 6
    //   681: aload_1
    //   682: astore 8
    //   684: aload_1
    //   685: invokestatic 145	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   688: ifne +68 -> 756
    //   691: aload 7
    //   693: astore 6
    //   695: aload_1
    //   696: astore 8
    //   698: aload 14
    //   700: aload_1
    //   701: putfield 918	com/qq/im/poi/LbsPackInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   704: aload_1
    //   705: astore 9
    //   707: aload 7
    //   709: astore 6
    //   711: aload_1
    //   712: astore 8
    //   714: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   717: ifeq +39 -> 756
    //   720: aload 7
    //   722: astore 6
    //   724: aload_1
    //   725: astore 8
    //   727: ldc 174
    //   729: iconst_2
    //   730: new 119	java/lang/StringBuilder
    //   733: dup
    //   734: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   737: ldc_w 935
    //   740: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: aload_1
    //   744: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   750: invokestatic 399	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   753: aload_1
    //   754: astore 9
    //   756: aload 9
    //   758: astore 6
    //   760: aload 7
    //   762: ifnull +14 -> 776
    //   765: aload 7
    //   767: invokeinterface 923 1 0
    //   772: aload 9
    //   774: astore 6
    //   776: aload 6
    //   778: astore_1
    //   779: aload 6
    //   781: invokestatic 145	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   784: ifeq +37 -> 821
    //   787: aload 6
    //   789: astore_1
    //   790: aload_0
    //   791: getfield 55	com/qq/im/poi/LbsPackManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   794: aload 13
    //   796: invokevirtual 862	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   799: ifeq +22 -> 821
    //   802: aload_0
    //   803: getfield 55	com/qq/im/poi/LbsPackManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   806: aload 13
    //   808: invokevirtual 275	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   811: checkcast 151	java/lang/String
    //   814: astore_1
    //   815: aload 14
    //   817: aload_1
    //   818: putfield 918	com/qq/im/poi/LbsPackInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   821: aload_1
    //   822: invokestatic 145	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   825: ifeq -795 -> 30
    //   828: aload 10
    //   830: aload 13
    //   832: invokevirtual 249	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   835: pop
    //   836: goto -806 -> 30
    //   839: astore 7
    //   841: aconst_null
    //   842: astore 6
    //   844: aconst_null
    //   845: astore_1
    //   846: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   849: ifeq +33 -> 882
    //   852: ldc 174
    //   854: iconst_2
    //   855: new 119	java/lang/StringBuilder
    //   858: dup
    //   859: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   862: ldc_w 937
    //   865: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   868: aload 7
    //   870: invokevirtual 938	java/lang/Exception:toString	()Ljava/lang/String;
    //   873: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   876: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   879: invokestatic 483	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   882: aload_1
    //   883: astore 7
    //   885: aload 6
    //   887: ifnull +336 -> 1223
    //   890: aload 6
    //   892: invokeinterface 923 1 0
    //   897: aload_1
    //   898: astore 6
    //   900: goto -650 -> 250
    //   903: astore 6
    //   905: aconst_null
    //   906: astore_1
    //   907: aload_1
    //   908: ifnull +9 -> 917
    //   911: aload_1
    //   912: invokeinterface 923 1 0
    //   917: aload 6
    //   919: athrow
    //   920: astore 9
    //   922: aconst_null
    //   923: astore 7
    //   925: aload 7
    //   927: astore_1
    //   928: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   931: ifeq +36 -> 967
    //   934: aload 7
    //   936: astore_1
    //   937: ldc 174
    //   939: iconst_2
    //   940: new 119	java/lang/StringBuilder
    //   943: dup
    //   944: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   947: ldc_w 940
    //   950: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   953: aload 9
    //   955: invokevirtual 938	java/lang/Exception:toString	()Ljava/lang/String;
    //   958: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   961: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   964: invokestatic 399	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   967: aload 6
    //   969: astore_1
    //   970: aload 7
    //   972: ifnull -456 -> 516
    //   975: aload 7
    //   977: invokeinterface 923 1 0
    //   982: aload 6
    //   984: astore_1
    //   985: goto -469 -> 516
    //   988: astore 6
    //   990: aconst_null
    //   991: astore_1
    //   992: aload_1
    //   993: ifnull +9 -> 1002
    //   996: aload_1
    //   997: invokeinterface 923 1 0
    //   1002: aload 6
    //   1004: athrow
    //   1005: astore 9
    //   1007: aconst_null
    //   1008: astore 7
    //   1010: aload 7
    //   1012: astore 6
    //   1014: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1017: ifeq +37 -> 1054
    //   1020: aload 7
    //   1022: astore 6
    //   1024: ldc 174
    //   1026: iconst_2
    //   1027: new 119	java/lang/StringBuilder
    //   1030: dup
    //   1031: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   1034: ldc_w 942
    //   1037: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1040: aload 9
    //   1042: invokevirtual 938	java/lang/Exception:toString	()Ljava/lang/String;
    //   1045: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1048: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1051: invokestatic 399	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1054: aload_1
    //   1055: astore 6
    //   1057: aload 7
    //   1059: ifnull -283 -> 776
    //   1062: aload 7
    //   1064: invokeinterface 923 1 0
    //   1069: aload_1
    //   1070: astore 6
    //   1072: goto -296 -> 776
    //   1075: astore_1
    //   1076: aconst_null
    //   1077: astore 6
    //   1079: aload 6
    //   1081: ifnull +10 -> 1091
    //   1084: aload 6
    //   1086: invokeinterface 923 1 0
    //   1091: aload_1
    //   1092: athrow
    //   1093: aload 10
    //   1095: invokevirtual 291	java/util/ArrayList:size	()I
    //   1098: ifle +12 -> 1110
    //   1101: aload_0
    //   1102: getfield 59	com/qq/im/poi/LbsPackManager:jdField_a_of_type_ComTencentMobileqqArmapArMapInterface	Lcom/tencent/mobileqq/armap/ArMapInterface;
    //   1105: aload 10
    //   1107: invokestatic 752	com/qq/im/poi/LbsPackMapPoiPackServlet:a	(Lcom/tencent/mobileqq/armap/ArMapInterface;Ljava/util/ArrayList;)V
    //   1110: invokestatic 875	java/lang/System:currentTimeMillis	()J
    //   1113: lstore 4
    //   1115: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1118: ifeq +32 -> 1150
    //   1121: ldc 174
    //   1123: iconst_2
    //   1124: new 119	java/lang/StringBuilder
    //   1127: dup
    //   1128: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   1131: ldc_w 944
    //   1134: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1137: lload 4
    //   1139: lload_2
    //   1140: lsub
    //   1141: invokevirtual 440	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1144: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1147: invokestatic 399	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1150: return
    //   1151: astore_1
    //   1152: goto -73 -> 1079
    //   1155: astore 9
    //   1157: aload 8
    //   1159: astore_1
    //   1160: goto -150 -> 1010
    //   1163: astore 6
    //   1165: goto -173 -> 992
    //   1168: astore 9
    //   1170: aload 8
    //   1172: astore 6
    //   1174: goto -249 -> 925
    //   1177: astore 6
    //   1179: goto -272 -> 907
    //   1182: astore 7
    //   1184: aload 6
    //   1186: astore_1
    //   1187: aload 7
    //   1189: astore 6
    //   1191: goto -284 -> 907
    //   1194: astore 7
    //   1196: aload_1
    //   1197: astore 6
    //   1199: aconst_null
    //   1200: astore_1
    //   1201: goto -355 -> 846
    //   1204: astore 8
    //   1206: aload 6
    //   1208: astore 7
    //   1210: aload_1
    //   1211: astore 6
    //   1213: aload 7
    //   1215: astore_1
    //   1216: aload 8
    //   1218: astore 7
    //   1220: goto -374 -> 846
    //   1223: aload 7
    //   1225: astore 6
    //   1227: goto -977 -> 250
    //   1230: aconst_null
    //   1231: astore 6
    //   1233: goto -997 -> 236
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1236	0	this	LbsPackManager
    //   0	1236	1	paramList	List
    //   3	1137	2	l1	long
    //   266	872	4	l2	long
    //   158	741	6	localObject1	Object
    //   903	80	6	localObject2	Object
    //   988	15	6	localObject3	Object
    //   1012	73	6	localList1	List
    //   1163	1	6	localObject4	Object
    //   1172	1	6	localObject5	Object
    //   1177	8	6	localObject6	Object
    //   1189	43	6	localObject7	Object
    //   154	612	7	localObject8	Object
    //   839	30	7	localException1	Exception
    //   883	180	7	localList2	List
    //   1182	6	7	localObject9	Object
    //   1194	1	7	localException2	Exception
    //   1208	16	7	localObject10	Object
    //   354	817	8	localObject11	Object
    //   1204	13	8	localException3	Exception
    //   338	435	9	localObject12	Object
    //   920	34	9	localException4	Exception
    //   1005	36	9	localException5	Exception
    //   1155	1	9	localException6	Exception
    //   1168	1	9	localException7	Exception
    //   11	1095	10	localArrayList	ArrayList
    //   20	527	11	str1	String
    //   28	13	12	localIterator	Iterator
    //   60	771	13	str2	String
    //   50	766	14	localLbsPackInfo	LbsPackInfo
    // Exception table:
    //   from	to	target	type
    //   87	116	839	java/lang/Exception
    //   87	116	903	finally
    //   316	336	920	java/lang/Exception
    //   316	336	988	finally
    //   582	603	1005	java/lang/Exception
    //   582	603	1075	finally
    //   621	631	1151	finally
    //   638	646	1151	finally
    //   653	674	1151	finally
    //   684	691	1151	finally
    //   698	704	1151	finally
    //   714	720	1151	finally
    //   727	753	1151	finally
    //   1014	1020	1151	finally
    //   1024	1054	1151	finally
    //   621	631	1155	java/lang/Exception
    //   638	646	1155	java/lang/Exception
    //   653	674	1155	java/lang/Exception
    //   684	691	1155	java/lang/Exception
    //   698	704	1155	java/lang/Exception
    //   714	720	1155	java/lang/Exception
    //   727	753	1155	java/lang/Exception
    //   356	366	1163	finally
    //   373	381	1163	finally
    //   388	410	1163	finally
    //   421	429	1163	finally
    //   436	443	1163	finally
    //   454	460	1163	finally
    //   467	494	1163	finally
    //   928	934	1163	finally
    //   937	967	1163	finally
    //   356	366	1168	java/lang/Exception
    //   373	381	1168	java/lang/Exception
    //   388	410	1168	java/lang/Exception
    //   421	429	1168	java/lang/Exception
    //   436	443	1168	java/lang/Exception
    //   454	460	1168	java/lang/Exception
    //   467	494	1168	java/lang/Exception
    //   120	156	1177	finally
    //   160	188	1177	finally
    //   188	236	1177	finally
    //   846	882	1182	finally
    //   120	156	1194	java/lang/Exception
    //   160	188	1194	java/lang/Exception
    //   188	236	1204	java/lang/Exception
  }
  
  public String c()
  {
    return this.d;
  }
  
  public String c(String paramString)
  {
    Object localObject = (String)jdField_b_of_type_AndroidSupportV4UtilLruCache.get(paramString);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramString = (String)localObject;
    }
    do
    {
      return paramString;
      if (!TextUtils.isEmpty((String)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString))) {
        return "";
      }
      localObject = e(paramString);
      try
      {
        if (!new File((String)localObject).exists())
        {
          this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString, localObject);
          localObject = this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.a.a(paramString, true, null);
          if (localObject == null) {
            break;
          }
          a(paramString, (Bitmap)localObject);
          break;
        }
        jdField_b_of_type_AndroidSupportV4UtilLruCache.put(paramString, localObject);
        return localObject;
      }
      catch (Exception localException)
      {
        paramString = "";
      }
    } while (!QLog.isColorLevel());
    QLog.d("LbsPack", 2, "", localException);
    return "";
    return "";
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qq.im.poi.LbsPackManager
 * JD-Core Version:    0.7.0.1
 */