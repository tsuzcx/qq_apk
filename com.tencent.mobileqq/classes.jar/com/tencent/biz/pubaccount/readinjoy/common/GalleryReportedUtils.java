package com.tencent.biz.pubaccount.readinjoy.common;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil.NetInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import lmu;
import org.json.JSONObject;
import tencent.im.oidb.gallery.gallery_report.GalleryClickReported;
import tencent.im.oidb.gallery.gallery_report.GalleryExpReported;
import tencent.im.oidb.gallery.gallery_report.GallerySocialReported;

public class GalleryReportedUtils
{
  public static int a(int paramInt)
  {
    if ((paramInt == 48) || (paramInt == 51)) {
      return 1;
    }
    if ((paramInt == 49) || (paramInt == 52)) {
      return 2;
    }
    return 3;
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    int i = 0;
    if (paramInt1 == 0) {
      if ((paramInt2 == 48) || (paramInt2 == 49) || (paramInt2 == 50)) {
        i = 1;
      }
    }
    while (paramInt1 != 70)
    {
      return i;
      return 4;
    }
    if ((paramInt2 == 48) || (paramInt2 == 49) || (paramInt2 == 50)) {
      return 5;
    }
    return 6;
  }
  
  public static String a()
  {
    return (int)Math.ceil(Float.valueOf((float)DeviceInfoUtil.e()).floatValue() / 1024.0F / 1024.0F / 1024.0F) + "";
  }
  
  public static String a(Context paramContext)
  {
    paramContext = DeviceInfoUtil.a(paramContext).a;
    if (!TextUtils.isEmpty(paramContext))
    {
      if (paramContext.equals("WIFI")) {
        return "1";
      }
      if ((paramContext.equals("4G")) || (paramContext.equals("3G"))) {
        return "2";
      }
      return "0";
    }
    return "0";
  }
  
  public static String a(Context paramContext, long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2, String paramString1, String paramString2, int paramInt3)
  {
    String str = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("network", a(paramContext));
      localJSONObject.put("version", "7.6.8");
      localJSONObject.put("os", "1");
      localJSONObject.put("uin", paramLong1 + "");
      localJSONObject.put("source", paramInt1 + "");
      localJSONObject.put("mem_size", a());
      localJSONObject.put("article_id", paramLong2 + "");
      localJSONObject.put("city", b());
      localJSONObject.put("exptime", paramLong3 + "");
      localJSONObject.put("pos", paramInt2 + "");
      localJSONObject.put("rowkey", paramString1);
      localJSONObject.put("proxy_bytes", paramString2);
      localJSONObject.put("crad_type", paramInt3 + "");
      paramContext = localJSONObject.toString();
      return paramContext;
    }
    catch (Exception paramString1)
    {
      do
      {
        paramContext = str;
      } while (!QLog.isColorLevel());
      QLog.d("GalleryReportedUtils", 2, "galleryExpReport:" + paramString1.toString());
    }
    return "";
  }
  
  public static String a(Context paramContext, String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2, String paramString3, int paramInt3, int paramInt4)
  {
    String str = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("network", a(paramContext));
      localJSONObject.put("version", "7.6.8");
      localJSONObject.put("os", "1");
      localJSONObject.put("uin", paramString1);
      localJSONObject.put("source", paramInt1 + "");
      localJSONObject.put("mem_size", a());
      localJSONObject.put("article_id", paramLong + "");
      localJSONObject.put("city", b());
      localJSONObject.put("exptime", System.currentTimeMillis() + "");
      localJSONObject.put("pos", paramInt2 + "");
      localJSONObject.put("rowkey", paramString2);
      localJSONObject.put("proxy_bytes", paramString3);
      localJSONObject.put("crad_type", paramInt3);
      localJSONObject.put("pic_click", paramInt4 + "");
      paramContext = localJSONObject.toString();
      return paramContext;
    }
    catch (Exception paramString1)
    {
      do
      {
        paramContext = str;
      } while (!QLog.isColorLevel());
      QLog.d("GalleryReportedUtils", 2, "galleryClickReport:" + paramString1.toString());
    }
    return "";
  }
  
  public static String a(Context paramContext, String paramString1, int paramInt1, long paramLong1, long paramLong2, String paramString2, int paramInt2, int paramInt3, String paramString3)
  {
    return a(paramContext, paramString1, paramInt1, paramLong1, paramLong2, paramString2, paramInt2, paramInt3, paramString3, -1);
  }
  
  public static String a(Context paramContext, String paramString1, int paramInt1, long paramLong1, long paramLong2, String paramString2, int paramInt2, int paramInt3, String paramString3, int paramInt4)
  {
    String str = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("network", a(paramContext));
      localJSONObject.put("version", "7.6.8");
      localJSONObject.put("os", "1");
      localJSONObject.put("uin", paramString1 + "");
      localJSONObject.put("source", paramInt1 + "");
      localJSONObject.put("mem_size", a());
      localJSONObject.put("article_id", paramLong1 + "");
      localJSONObject.put("pics", paramLong2 + "");
      localJSONObject.put("rowkey", paramString2);
      localJSONObject.put("city", b() + "");
      localJSONObject.put("pos", paramInt2 + "");
      localJSONObject.put("is_read_end", paramInt3 + "");
      localJSONObject.put("proxy_bytes", paramString3);
      if (paramInt4 != -1) {
        localJSONObject.put("operation_type", paramInt4);
      }
      paramContext = localJSONObject.toString();
    }
    catch (Exception paramString1)
    {
      do
      {
        paramContext = str;
      } while (!QLog.isColorLevel());
      QLog.d("GalleryReportedUtils", 2, "operationReport:" + paramString1.toString());
    }
    return paramContext;
    return "";
  }
  
  public static String a(Context paramContext, String paramString1, int paramInt, long paramLong, String paramString2)
  {
    String str = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("network", a(paramContext));
      localJSONObject.put("version", "7.6.8");
      localJSONObject.put("os", "1");
      localJSONObject.put("uin", paramString1);
      localJSONObject.put("source", paramInt + "");
      localJSONObject.put("mem_size", a());
      localJSONObject.put("article_id", paramLong + "");
      localJSONObject.put("rowkey", paramString2);
      paramContext = localJSONObject.toString();
      return paramContext;
    }
    catch (Exception paramString1)
    {
      do
      {
        paramContext = str;
      } while (!QLog.isColorLevel());
      QLog.d("GalleryReportedUtils", 2, "shareClickReport:" + paramString1.toString());
    }
    return "";
  }
  
  public static String a(Context paramContext, String paramString1, int paramInt1, long paramLong, String paramString2, int paramInt2)
  {
    String str = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("network", a(paramContext));
      localJSONObject.put("version", "7.6.8");
      localJSONObject.put("os", "1");
      localJSONObject.put("uin", paramString1);
      localJSONObject.put("source", paramInt1 + "");
      localJSONObject.put("mem_size", a());
      localJSONObject.put("article_id", paramLong + "");
      localJSONObject.put("rowkey", paramString2);
      localJSONObject.put("click_account", paramInt2 + "");
      paramContext = localJSONObject.toString();
      return paramContext;
    }
    catch (Exception paramString1)
    {
      do
      {
        paramContext = str;
      } while (!QLog.isColorLevel());
      QLog.d("GalleryReportedUtils", 2, "accountClickReport:" + paramString1.toString());
    }
    return "";
  }
  
  public static String a(Context paramContext, String paramString1, int paramInt1, long paramLong, String paramString2, int paramInt2, int paramInt3)
  {
    String str = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("network", a(paramContext));
      localJSONObject.put("version", "7.6.8");
      localJSONObject.put("os", "1");
      localJSONObject.put("uin", paramString1);
      localJSONObject.put("source", paramInt1 + "");
      localJSONObject.put("mem_size", a());
      localJSONObject.put("article_id", paramLong + "");
      localJSONObject.put("rowkey", paramString2);
      localJSONObject.put("sourcefrom", paramInt2 + "");
      localJSONObject.put("share_unit", paramInt3 + "");
      paramContext = localJSONObject.toString();
      return paramContext;
    }
    catch (Exception paramString1)
    {
      do
      {
        paramContext = str;
      } while (!QLog.isColorLevel());
      QLog.d("GalleryReportedUtils", 2, "shareReport:" + paramString1.toString());
    }
    return "";
  }
  
  public static String a(Context paramContext, String paramString1, int paramInt1, long paramLong1, String paramString2, int paramInt2, long paramLong2, int paramInt3, long paramLong3, int paramInt4, int paramInt5, String paramString3, String paramString4, int paramInt6)
  {
    String str = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("network", a(paramContext));
      localJSONObject.put("version", "7.6.8");
      localJSONObject.put("os", "1");
      localJSONObject.put("uin", paramString1);
      localJSONObject.put("source", paramInt1 + "");
      localJSONObject.put("mem_size", a());
      localJSONObject.put("article_id", paramLong1 + "");
      localJSONObject.put("rowkey", paramString2);
      localJSONObject.put("index", paramInt2 + "");
      localJSONObject.put("pics", paramLong2 + "");
      localJSONObject.put("gesture", paramInt3 + "");
      localJSONObject.put("city", b());
      localJSONObject.put("clicktime", paramLong3 + "");
      localJSONObject.put("go_away_time", System.currentTimeMillis() + "");
      localJSONObject.put("pos", paramInt4);
      localJSONObject.put("is_read_end", paramInt5 + "");
      localJSONObject.put("proxy_bytes", paramString3);
      localJSONObject.put("one_pic_reported", paramString4);
      localJSONObject.put("is_read_repeaded", paramInt6 + "");
      paramContext = localJSONObject.toString();
      return paramContext;
    }
    catch (Exception paramString1)
    {
      do
      {
        paramContext = str;
      } while (!QLog.isColorLevel());
      QLog.d("GalleryReportedUtils", 2, "exitGalleryReport:" + paramString1.toString());
    }
    return "";
  }
  
  public static String a(String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return paramString;
      try
      {
        Object localObject = new JSONObject(paramString);
        ((JSONObject)localObject).put("exptime", paramLong + "");
        localObject = ((JSONObject)localObject).toString();
        return localObject;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.d("GalleryReportedUtils", 2, "galleryExpReport:" + localException.toString());
    return paramString;
  }
  
  public static void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mIsGallery = true;
    localReportInfo.mUin = paramLong;
    localReportInfo.mAlgorithmId = paramInt2;
    localReportInfo.mOperation = paramInt1;
    gallery_report.GallerySocialReported localGallerySocialReported = new gallery_report.GallerySocialReported();
    localGallerySocialReported.action.set(paramInt3);
    localGallerySocialReported.phone_type.set(1);
    localGallerySocialReported.client_ver.set(ByteStringMicro.copyFromUtf8("7.6.8"));
    localGallerySocialReported.source.set(paramInt4);
    if (!TextUtils.isEmpty(b())) {
      localGallerySocialReported.city.set(ByteStringMicro.copyFromUtf8(b()));
    }
    localGallerySocialReported.pos.set(paramInt5);
    localGallerySocialReported.is_read_end.set(paramInt6);
    if (!TextUtils.isEmpty(paramString1)) {
      localGallerySocialReported.rowkey.set(ByteStringMicro.copyFromUtf8(paramString1));
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localGallerySocialReported.proxy_bytes.set(ByteStringMicro.copyFromUtf8(paramString2));
    }
    localReportInfo.mGalleryReportInfo = localGallerySocialReported.toByteArray();
    localArrayList.add(localReportInfo);
    ReadInJoyLogicEngine.a().a(localArrayList);
  }
  
  public static void a(int paramInt1, long paramLong1, int paramInt2, int paramInt3, long paramLong2, int paramInt4, int paramInt5, int paramInt6, String paramString1, String paramString2, List paramList, int paramInt7)
  {
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mIsGallery = true;
    localReportInfo.mUin = paramLong1;
    localReportInfo.mAlgorithmId = paramInt2;
    localReportInfo.mOperation = paramInt1;
    gallery_report.GalleryClickReported localGalleryClickReported = new gallery_report.GalleryClickReported();
    localGalleryClickReported.phone_type.set(1);
    if (!TextUtils.isEmpty("7.6.8")) {
      localGalleryClickReported.client_ver.set(ByteStringMicro.copyFromUtf8("7.6.8"));
    }
    localGalleryClickReported.source.set(paramInt3);
    if (!TextUtils.isEmpty(a())) {
      localGalleryClickReported.mem_size.set(Float.valueOf(a()).floatValue());
    }
    if (!TextUtils.isEmpty(b())) {
      localGalleryClickReported.city.set(ByteStringMicro.copyFromUtf8(b()));
    }
    localGalleryClickReported.is_read_repeaded.set(paramInt7);
    localGalleryClickReported.clicktime.set(paramLong2);
    localGalleryClickReported.go_away_time.set(System.currentTimeMillis());
    localGalleryClickReported.pic_num.set(paramInt4);
    localGalleryClickReported.pos.set(paramInt5);
    localGalleryClickReported.is_read_end.set(paramInt6);
    if (!TextUtils.isEmpty(paramString1)) {
      localGalleryClickReported.rowkey.set(ByteStringMicro.copyFromUtf8(paramString1));
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localGalleryClickReported.proxy_bytes.set(ByteStringMicro.copyFromUtf8(paramString2));
    }
    if ((paramList != null) && (paramList.size() > 0)) {
      localGalleryClickReported.one_pic_reported.set(paramList);
    }
    localReportInfo.mGalleryReportInfo = localGalleryClickReported.toByteArray();
    localArrayList.add(localReportInfo);
    ReadInJoyLogicEngine.a().a(localArrayList);
  }
  
  public static void a(int paramInt1, long paramLong1, int paramInt2, int paramInt3, long paramLong2, int paramInt4, String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mIsGallery = true;
    localReportInfo.mUin = paramLong1;
    localReportInfo.mAlgorithmId = paramInt2;
    localReportInfo.mOperation = paramInt1;
    gallery_report.GalleryExpReported localGalleryExpReported = new gallery_report.GalleryExpReported();
    localGalleryExpReported.phone_type.set(1);
    if (!TextUtils.isEmpty("7.6.8")) {
      localGalleryExpReported.client_ver.set(ByteStringMicro.copyFromUtf8("7.6.8"));
    }
    localGalleryExpReported.source.set(paramInt3);
    if (!TextUtils.isEmpty(a())) {
      localGalleryExpReported.mem_size.set(Float.valueOf(a()).floatValue());
    }
    if (!TextUtils.isEmpty(b())) {
      localGalleryExpReported.city.set(ByteStringMicro.copyFromUtf8(b()));
    }
    localGalleryExpReported.exptime.set(paramLong2);
    localGalleryExpReported.pos.set(paramInt4);
    if (!TextUtils.isEmpty(paramString1)) {
      localGalleryExpReported.rowkey.set(ByteStringMicro.copyFromUtf8(paramString1));
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localGalleryExpReported.proxy_bytes.set(ByteStringMicro.copyFromUtf8(paramString2));
    }
    localReportInfo.mGalleryReportInfo = localGalleryExpReported.toByteArray();
    localArrayList.add(localReportInfo);
    ReadInJoyLogicEngine.a().a(localArrayList);
  }
  
  public static String b()
  {
    SosoInterface.SosoLbsInfo localSosoLbsInfo = SosoInterface.b();
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.a != null) && (!TextUtils.isEmpty(localSosoLbsInfo.a.e))) {
      return localSosoLbsInfo.a.e;
    }
    if (QLog.isColorLevel()) {
      QLog.e("GalleryReportedUtils", 2, "locationInfo is empty");
    }
    SosoInterface.a(new lmu(3, true, true, 60000L, false, false, "GalleryReportedUtils"));
    return "";
  }
  
  public static String b(Context paramContext, String paramString1, int paramInt, long paramLong, String paramString2)
  {
    String str = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("network", a(paramContext));
      localJSONObject.put("version", "7.6.8");
      localJSONObject.put("os", "1");
      localJSONObject.put("uin", paramString1 + "");
      localJSONObject.put("source", paramInt + "");
      localJSONObject.put("mem_size", a());
      localJSONObject.put("article_id", paramLong + "");
      localJSONObject.put("rowkey", paramString2);
      paramContext = localJSONObject.toString();
      return paramContext;
    }
    catch (Exception paramString1)
    {
      do
      {
        paramContext = str;
      } while (!QLog.isColorLevel());
      QLog.d("GalleryReportedUtils", 2, "sendCommentReport:" + paramString1.toString());
    }
    return "";
  }
  
  public static String b(Context paramContext, String paramString1, int paramInt1, long paramLong, String paramString2, int paramInt2)
  {
    String str = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("network", a(paramContext));
      localJSONObject.put("version", "7.6.8");
      localJSONObject.put("os", "1");
      localJSONObject.put("uin", paramString1 + "");
      localJSONObject.put("source", paramInt1 + "");
      localJSONObject.put("mem_size", a());
      localJSONObject.put("article_id", paramLong + "");
      localJSONObject.put("rowkey", paramString2);
      localJSONObject.put("hand_type", paramInt2);
      paramContext = localJSONObject.toString();
      return paramContext;
    }
    catch (Exception paramString1)
    {
      do
      {
        paramContext = str;
      } while (!QLog.isColorLevel());
      QLog.d("GalleryReportedUtils", 2, "gestureReport:" + paramString1.toString());
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.GalleryReportedUtils
 * JD-Core Version:    0.7.0.1
 */