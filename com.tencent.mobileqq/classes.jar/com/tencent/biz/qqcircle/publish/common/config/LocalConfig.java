package com.tencent.biz.qqcircle.publish.common.config;

import FileUpload.MarkUinInfoBeforeUpload;
import NS_MOBILE_OPERATION.PicInfo;
import android.annotation.SuppressLint;
import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.biz.qqcircle.publish.model.ShuoshuoContent;
import com.tencent.biz.qqcircle.publish.model.ShuoshuoVideoInfo;
import com.tencent.biz.qqcircle.publish.queue.util.ParcelableWrapper;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LbsDataV2.PoiInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LocalConfig
{
  public static int a(String paramString, int paramInt)
  {
    return a("QC_setting", paramString, paramInt);
  }
  
  public static int a(String paramString, int paramInt, long paramLong)
  {
    return a(paramLong).getInt(paramString, paramInt);
  }
  
  public static int a(String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("shuoshuo_sync_bits");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    return a(localStringBuilder.toString(), 0);
  }
  
  public static int a(String paramString1, String paramString2, int paramInt)
  {
    return a(paramString1).getInt(paramString2, paramInt);
  }
  
  public static long a(String paramString, long paramLong1, long paramLong2)
  {
    return a(paramLong2).getLong(paramString, paramLong1);
  }
  
  private static SharedPreferences.Editor a()
  {
    return c("QC_setting");
  }
  
  public static SharedPreferences a(long paramLong)
  {
    Object localObject;
    if (paramLong == 0L)
    {
      localObject = "QC_setting";
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append("preference");
      localObject = ((StringBuilder)localObject).toString();
    }
    return a((String)localObject);
  }
  
  @SuppressLint({"InlinedApi"})
  public static SharedPreferences a(String paramString)
  {
    return QCircleApplication.APP.getSharedPreferences(paramString, 0);
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return a("QC_setting", paramString1, paramString2);
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    return a(paramString1).getString(paramString2, paramString3);
  }
  
  public static void a(long paramLong, String paramString)
  {
    SharedPreferences.Editor localEditor1 = a();
    SharedPreferences.Editor localEditor2 = b(paramLong);
    f(localEditor1, paramString, paramLong);
    g(localEditor1, paramString, paramLong);
    h(localEditor1, paramString, paramLong);
    q(localEditor1, paramString, paramLong);
    e(localEditor2, paramString, paramLong);
    n(localEditor2, paramString, paramLong);
    r(localEditor1, paramString, paramLong);
    a(localEditor1, paramString, paramLong);
    o(localEditor2, paramString, paramLong);
    s(localEditor2, paramString, paramLong);
    t(localEditor2, paramString, paramLong);
    u(localEditor2, paramString, paramLong);
    m(localEditor1, paramString, paramLong);
    p(localEditor2, paramString, paramLong);
    i(localEditor1, paramString, paramLong);
    j(localEditor1, paramString, paramLong);
    k(localEditor1, paramString, paramLong);
    l(localEditor1, paramString, paramLong);
    d(localEditor1, paramString, paramLong);
    c(localEditor1, paramString, paramLong);
    b(localEditor1, paramString, paramLong);
    localEditor1.commit();
    localEditor2.commit();
  }
  
  public static void a(long paramLong1, boolean paramBoolean, String paramString, long paramLong2)
  {
    SharedPreferences.Editor localEditor = b(paramLong2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_qcircle_kol_max_video_limit");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong2);
    localEditor.putLong(localStringBuilder.toString(), paramLong1);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_qcircle_kol_allow_long_video_switch");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong2);
    localEditor.putBoolean(localStringBuilder.toString(), paramBoolean);
    localEditor.commit();
  }
  
  private static void a(SharedPreferences.Editor paramEditor, String paramString, int paramInt, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PhotoConst.KEY_SHOW_TYPE");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.putInt(localStringBuilder.toString(), paramInt);
  }
  
  public static void a(SharedPreferences.Editor paramEditor, String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mood_status");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.remove(localStringBuilder.toString());
  }
  
  private static void a(SharedPreferences.Editor paramEditor, String paramString, ShuoshuoVideoInfo paramShuoshuoVideoInfo, long paramLong)
  {
    if (paramShuoshuoVideoInfo == null)
    {
      r(paramEditor, paramString, paramLong);
      return;
    }
    Object localObject = Parcel.obtain();
    ((Parcel)localObject).setDataPosition(0);
    ParcelableWrapper.a((Parcel)localObject, 0, paramShuoshuoVideoInfo);
    paramShuoshuoVideoInfo = ((Parcel)localObject).marshall();
    ((Parcel)localObject).recycle();
    paramShuoshuoVideoInfo = Base64.encodeToString(paramShuoshuoVideoInfo, 0);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("key_shuoshuo_selected_video");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramLong);
    paramEditor.putString(((StringBuilder)localObject).toString(), paramShuoshuoVideoInfo);
  }
  
  private static void a(SharedPreferences.Editor paramEditor, String paramString1, String paramString2, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_shuoshuo_title_draft");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.putString(localStringBuilder.toString(), paramString2);
  }
  
  private static void a(SharedPreferences.Editor paramEditor, String paramString, HashMap<String, MarkUinInfoBeforeUpload> paramHashMap, long paramLong)
  {
    if (paramHashMap != null)
    {
      if (paramHashMap.size() == 0) {
        return;
      }
      Object localObject = new HashMap(paramHashMap);
      paramHashMap = Parcel.obtain();
      paramHashMap.setDataPosition(0);
      ParcelableWrapper.a(paramHashMap, (Map)localObject);
      localObject = paramHashMap.marshall();
      paramHashMap.recycle();
      paramHashMap = Base64.encodeToString((byte[])localObject, 0);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("key_shuoshuo_upload_map");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramLong);
      paramEditor.putString(((StringBuilder)localObject).toString(), paramHashMap);
    }
  }
  
  private static void a(SharedPreferences.Editor paramEditor, String paramString, List<String> paramList, long paramLong, HashMap<String, PicInfo> paramHashMap)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).startsWith("http://")) && (!((String)localObject).startsWith("https://")))
        {
          localStringBuilder1.append((String)localObject);
          localStringBuilder1.append("|");
        }
        else if ((!TextUtils.isEmpty((CharSequence)localObject)) && ((((String)localObject).startsWith("http://")) || (((String)localObject).startsWith("https://"))))
        {
          if ((paramHashMap != null) && (paramHashMap.get(localObject) != null))
          {
            paramList = (PicInfo)paramHashMap.get(localObject);
            if (paramList.sourceType == 2)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(paramList.sourceType);
              ((StringBuilder)localObject).append("<");
              ((StringBuilder)localObject).append(paramList.pic_url);
              ((StringBuilder)localObject).append("<");
              ((StringBuilder)localObject).append(paramList.imageId);
              ((StringBuilder)localObject).append("<");
              ((StringBuilder)localObject).append(paramList.picwidth);
              ((StringBuilder)localObject).append("<");
              ((StringBuilder)localObject).append(paramList.picheight);
              paramList = ((StringBuilder)localObject).toString();
            }
            else if (paramList.sourceType == 1)
            {
              StringBuilder localStringBuilder2 = new StringBuilder();
              localStringBuilder2.append(paramList.sourceType);
              localStringBuilder2.append("<");
              localStringBuilder2.append((String)localObject);
              localStringBuilder2.append("<");
              localStringBuilder2.append(paramList.imageId);
              paramList = localStringBuilder2.toString();
            }
            else
            {
              paramList = "";
            }
            localStringBuilder1.append(paramList);
            localStringBuilder1.append("|");
          }
          else
          {
            localStringBuilder1.append((String)localObject);
            localStringBuilder1.append("|");
          }
        }
      }
      int i = localStringBuilder1.lastIndexOf("|");
      if (i != -1)
      {
        paramList = localStringBuilder1.substring(0, i);
        paramHashMap = new StringBuilder();
        paramHashMap.append("key_shuoshuo_selected_images");
        paramHashMap.append(paramString);
        paramHashMap.append("_");
        paramHashMap.append(paramLong);
        paramEditor.putString(paramHashMap.toString(), paramList);
      }
    }
    else
    {
      q(paramEditor, paramString, paramLong);
    }
  }
  
  private static void a(SharedPreferences.Editor paramEditor, String paramString, Map<String, PicInfo> paramMap, long paramLong)
  {
    if (paramMap != null)
    {
      if (paramMap.size() == 0) {
        return;
      }
      Object localObject = new HashMap(paramMap);
      paramMap = Parcel.obtain();
      paramMap.setDataPosition(0);
      ParcelableWrapper.a(paramMap, (Map)localObject);
      localObject = paramMap.marshall();
      paramMap.recycle();
      paramMap = Base64.encodeToString((byte[])localObject, 0);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("key_shuoshuo_selected_qzone_photo");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramLong);
      paramEditor.putString(((StringBuilder)localObject).toString(), paramMap);
    }
  }
  
  public static void a(ShuoshuoContent paramShuoshuoContent, long paramLong, String paramString)
  {
    SharedPreferences.Editor localEditor1 = a();
    SharedPreferences.Editor localEditor2 = b(paramLong);
    b(localEditor1, paramString, paramShuoshuoContent.k(), paramLong);
    a(localEditor1, paramString, paramShuoshuoContent.l(), paramLong);
    b(localEditor1, paramString, paramShuoshuoContent.m(), paramLong);
    a(localEditor1, paramString, paramShuoshuoContent.f(), paramLong, paramShuoshuoContent.b());
    a(localEditor1, paramString, paramShuoshuoContent.i(), paramLong);
    a(localEditor1, paramString, paramShuoshuoContent.g(), paramLong);
    b(localEditor1, paramString, paramShuoshuoContent.h(), paramLong);
    c(localEditor1, paramString, paramShuoshuoContent.o(), paramLong);
    d(localEditor1, paramString, paramShuoshuoContent.p(), paramLong);
    Object localObject = paramShuoshuoContent.d();
    if (localObject != null) {
      c(localEditor1, paramString, (String)localObject, paramLong);
    }
    localObject = paramShuoshuoContent.c();
    if (localObject != null) {
      d(localEditor1, paramString, (String)localObject, paramLong);
    }
    localObject = paramShuoshuoContent.e();
    LbsDataV2.PoiInfo localPoiInfo = paramShuoshuoContent.a();
    if (localObject != null)
    {
      e(localEditor1, paramString, ((LbsDataV2.PoiInfo)localObject).poiId, paramLong);
      f(localEditor1, paramString, ((LbsDataV2.PoiInfo)localObject).dianPingId, paramLong);
    }
    else if (localPoiInfo != null)
    {
      e(localEditor1, paramString, localPoiInfo.poiId, paramLong);
      f(localEditor1, paramString, localPoiInfo.dianPingId, paramLong);
    }
    c(localEditor2, paramString, paramShuoshuoContent.n(), paramLong);
    localObject = paramShuoshuoContent.s();
    if (localObject != null) {
      b(localEditor1, paramString, (HashMap)localObject, paramLong);
    }
    localObject = paramShuoshuoContent.r();
    if (localObject != null) {
      a(localEditor1, paramString, (HashMap)localObject, paramLong);
    }
    localObject = paramShuoshuoContent.q();
    if (localObject != null) {
      c(localEditor1, paramString, (HashMap)localObject, paramLong);
    }
    a(localEditor1, paramString, paramShuoshuoContent.j(), paramLong);
    localEditor1.commit();
    localEditor2.commit();
  }
  
  public static void a(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = c(paramString1);
    paramString1.putLong(paramString2, paramLong);
    paramString1.commit();
  }
  
  public static void a(String paramString, boolean paramBoolean, long paramLong)
  {
    SharedPreferences.Editor localEditor = b(paramLong);
    localEditor.putBoolean(paramString, paramBoolean);
    localEditor.commit();
  }
  
  public static boolean a(String paramString, long paramLong, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_qcircle_kol_allow_long_video_switch");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    return b(localStringBuilder.toString(), paramBoolean, paramLong);
  }
  
  public static boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    return a(paramString1).getBoolean(paramString2, paramBoolean);
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    return a("QC_setting", paramString, paramBoolean);
  }
  
  public static long b(String paramString, long paramLong1, long paramLong2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_qcircle_kol_max_video_limit");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong1);
    return a(localStringBuilder.toString(), paramLong2, paramLong1);
  }
  
  public static long b(String paramString1, String paramString2, long paramLong)
  {
    return a(paramString1).getLong(paramString2, paramLong);
  }
  
  private static SharedPreferences.Editor b(long paramLong)
  {
    return new LocalConfig.ConfigEditor(a(paramLong).edit());
  }
  
  public static String b(String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_shuoshuo_draft");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    return a(localStringBuilder.toString(), "");
  }
  
  private static void b(SharedPreferences.Editor paramEditor, String paramString, int paramInt, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("shuoshuo_sync_bits");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.putInt(localStringBuilder.toString(), paramInt);
  }
  
  private static void b(SharedPreferences.Editor paramEditor, String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PhotoConst.KEY_SHOW_TYPE");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.remove(localStringBuilder.toString());
  }
  
  private static void b(SharedPreferences.Editor paramEditor, String paramString1, String paramString2, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_shuoshuo_draft");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.putString(localStringBuilder.toString(), paramString2);
  }
  
  private static void b(SharedPreferences.Editor paramEditor, String paramString, HashMap<String, Boolean> paramHashMap, long paramLong)
  {
    if (paramHashMap != null)
    {
      if (paramHashMap.size() == 0) {
        return;
      }
      Object localObject = new HashMap(paramHashMap);
      paramHashMap = Parcel.obtain();
      paramHashMap.setDataPosition(0);
      ParcelableWrapper.a(paramHashMap, (Map)localObject);
      localObject = paramHashMap.marshall();
      paramHashMap.recycle();
      paramHashMap = Base64.encodeToString((byte[])localObject, 0);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("key_shuoshuo_markhascheckfacesmap");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramLong);
      paramEditor.putString(((StringBuilder)localObject).toString(), paramHashMap);
    }
  }
  
  private static void b(SharedPreferences.Editor paramEditor, String paramString, Map<String, LocalMediaInfo> paramMap, long paramLong)
  {
    if (paramMap != null)
    {
      if (paramMap.size() == 0) {
        return;
      }
      Object localObject = new HashMap(paramMap);
      paramMap = Parcel.obtain();
      paramMap.setDataPosition(0);
      ParcelableWrapper.a(paramMap, (Map)localObject);
      localObject = paramMap.marshall();
      paramMap.recycle();
      paramMap = Base64.encodeToString((byte[])localObject, 0);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("key_shuoshuo_selected_media");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramLong);
      paramEditor.putString(((StringBuilder)localObject).toString(), paramMap);
    }
  }
  
  public static void b(String paramString)
  {
    SharedPreferences.Editor localEditor = a();
    localEditor.remove(paramString);
    localEditor.commit();
  }
  
  public static boolean b(String paramString, boolean paramBoolean, long paramLong)
  {
    return a(paramLong).getBoolean(paramString, paramBoolean);
  }
  
  private static SharedPreferences.Editor c(String paramString)
  {
    return new LocalConfig.ConfigEditor(a(paramString).edit());
  }
  
  public static String c(String paramString1, String paramString2, long paramLong)
  {
    return a(paramLong).getString(paramString1, paramString2);
  }
  
  public static List<String> c(String paramString, long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("key_shuoshuo_selected_images");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramLong);
    localObject = a(((StringBuilder)localObject).toString(), "");
    paramString = new ArrayList();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("\\|");
      if (localObject != null)
      {
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          paramString.add(localObject[i]);
          i += 1;
        }
      }
    }
    return paramString;
  }
  
  private static void c(SharedPreferences.Editor paramEditor, String paramString, int paramInt, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("shuoshuo_uistate");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.putInt(localStringBuilder.toString(), paramInt);
  }
  
  private static void c(SharedPreferences.Editor paramEditor, String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_shuoshuo_markhascheckfacesmap");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.remove(localStringBuilder.toString());
  }
  
  private static void c(SharedPreferences.Editor paramEditor, String paramString1, String paramString2, long paramLong)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_shuoshuo_shootinf_lbs");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.putString(localStringBuilder.toString(), paramString2);
  }
  
  private static void c(SharedPreferences.Editor paramEditor, String paramString, HashMap<String, Boolean> paramHashMap, long paramLong)
  {
    if (paramHashMap != null)
    {
      if (paramHashMap.size() == 0) {
        return;
      }
      Object localObject = new HashMap(paramHashMap);
      paramHashMap = Parcel.obtain();
      paramHashMap.setDataPosition(0);
      ParcelableWrapper.a(paramHashMap, (Map)localObject);
      localObject = paramHashMap.marshall();
      paramHashMap.recycle();
      paramHashMap = Base64.encodeToString((byte[])localObject, 0);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("key_shuoshuo_markNeedShowFaceIconMap");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramLong);
      paramEditor.putString(((StringBuilder)localObject).toString(), paramHashMap);
    }
  }
  
  private static void c(SharedPreferences.Editor paramEditor, String paramString, Map<String, ShuoshuoVideoInfo> paramMap, long paramLong)
  {
    if (paramMap != null)
    {
      if (paramMap.size() == 0) {
        return;
      }
      Object localObject = new HashMap(paramMap);
      paramMap = Parcel.obtain();
      paramMap.setDataPosition(0);
      ParcelableWrapper.a(paramMap, (Map)localObject);
      localObject = paramMap.marshall();
      paramMap.recycle();
      paramMap = Base64.encodeToString((byte[])localObject, 0);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("key_shuoshuo_record_media");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramLong);
      paramEditor.putString(((StringBuilder)localObject).toString(), paramMap);
    }
  }
  
  public static Map<String, LocalMediaInfo> d(String paramString, long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("key_shuoshuo_selected_media");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramLong);
    paramString = a(((StringBuilder)localObject).toString(), "");
    boolean bool = TextUtils.isEmpty(paramString);
    localObject = null;
    if (bool) {
      return null;
    }
    byte[] arrayOfByte = Base64.decode(paramString, 0);
    paramString = (String)localObject;
    try
    {
      Parcel localParcel = Parcel.obtain();
      paramString = (String)localObject;
      localParcel.unmarshall(arrayOfByte, 0, arrayOfByte.length);
      paramString = (String)localObject;
      localParcel.setDataPosition(0);
      paramString = (String)localObject;
      localObject = ParcelableWrapper.b(localParcel, ParcelableWrapper.class.getClassLoader());
      paramString = (String)localObject;
      localParcel.recycle();
      return localObject;
    }
    catch (Exception localException)
    {
      QLog.w("LocalConfig", 1, localException.getMessage());
    }
    return paramString;
  }
  
  private static void d(SharedPreferences.Editor paramEditor, String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_shuoshuo_upload_map");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.remove(localStringBuilder.toString());
  }
  
  private static void d(SharedPreferences.Editor paramEditor, String paramString1, String paramString2, long paramLong)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_shuoshuo_shootinfo_time_and_weather");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.putString(localStringBuilder.toString(), paramString2);
  }
  
  private static void d(SharedPreferences.Editor paramEditor, String paramString, Map<String, ShuoshuoVideoInfo> paramMap, long paramLong)
  {
    if (paramMap != null)
    {
      if (paramMap.size() == 0) {
        return;
      }
      Object localObject = new HashMap(paramMap);
      paramMap = Parcel.obtain();
      paramMap.setDataPosition(0);
      ParcelableWrapper.a(paramMap, (Map)localObject);
      localObject = paramMap.marshall();
      paramMap.recycle();
      paramMap = Base64.encodeToString((byte[])localObject, 0);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("key_shuoshuo_select_list_media");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramLong);
      paramEditor.putString(((StringBuilder)localObject).toString(), paramMap);
    }
  }
  
  private static void e(SharedPreferences.Editor paramEditor, String paramString, long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("key_at_friends_size");
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    int i = 0;
    int j = a((String)localObject, 0, paramLong);
    if (j > 0) {
      while (i < j)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("key_at_friends_uin");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(i);
        paramEditor.remove(((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("key_at_friends_name");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(i);
        paramEditor.remove(((StringBuilder)localObject).toString());
        i += 1;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("key_at_friends_size");
    ((StringBuilder)localObject).append(paramString);
    paramEditor.remove(((StringBuilder)localObject).toString());
  }
  
  private static void e(SharedPreferences.Editor paramEditor, String paramString1, String paramString2, long paramLong)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_shuoshuo_shootinfo_poi_id");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.putString(localStringBuilder.toString(), paramString2);
  }
  
  private static void f(SharedPreferences.Editor paramEditor, String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("shuoshuo_sync_bits");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.remove(localStringBuilder.toString());
  }
  
  private static void f(SharedPreferences.Editor paramEditor, String paramString1, String paramString2, long paramLong)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_shuoshuo_shootinfo_dianping_id");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.putString(localStringBuilder.toString(), paramString2);
  }
  
  private static void g(SharedPreferences.Editor paramEditor, String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_shuoshuo_title_draft");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.remove(localStringBuilder.toString());
  }
  
  private static void h(SharedPreferences.Editor paramEditor, String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_shuoshuo_draft");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.remove(localStringBuilder.toString());
  }
  
  private static void i(SharedPreferences.Editor paramEditor, String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_shuoshuo_shootinf_lbs");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.remove(localStringBuilder.toString());
  }
  
  private static void j(SharedPreferences.Editor paramEditor, String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_shuoshuo_shootinfo_time_and_weather");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.remove(localStringBuilder.toString());
  }
  
  private static void k(SharedPreferences.Editor paramEditor, String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_shuoshuo_shootinfo_poi_id");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.remove(localStringBuilder.toString());
  }
  
  private static void l(SharedPreferences.Editor paramEditor, String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_shuoshuo_shootinfo_dianping_id");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.remove(localStringBuilder.toString());
  }
  
  private static void m(SharedPreferences.Editor paramEditor, String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_shuoshuo_right");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.remove(localStringBuilder.toString());
  }
  
  private static void n(SharedPreferences.Editor paramEditor, String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("shuoshuo_uistate");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.remove(localStringBuilder.toString());
  }
  
  private static void o(SharedPreferences.Editor paramEditor, String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("shuoshuo_event_tag_title");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.remove(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("shuoshuo_event_tag_desc");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.remove(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("shuoshuo_event_tag_desc_truncate_num");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.remove(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("shuoshuo_event_tag_protocol");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.remove(localStringBuilder.toString());
  }
  
  private static void p(SharedPreferences.Editor paramEditor, String paramString, long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("key_shuoshuo_right_uin_list_size");
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    int i = 0;
    int j = a((String)localObject, 0, paramLong);
    if (j > 0) {
      while (i < j)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("key_shuoshuo_right_uin_list");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(i);
        paramEditor.remove(((StringBuilder)localObject).toString());
        i += 1;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("key_shuoshuo_right_uin_list_size");
    ((StringBuilder)localObject).append(paramString);
    paramEditor.remove(((StringBuilder)localObject).toString());
  }
  
  private static void q(SharedPreferences.Editor paramEditor, String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_shuoshuo_selected_images");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.remove(localStringBuilder.toString());
  }
  
  private static void r(SharedPreferences.Editor paramEditor, String paramString, long paramLong)
  {
    paramEditor = new StringBuilder();
    paramEditor.append("key_shuoshuo_selected_video");
    paramEditor.append(paramString);
    paramEditor.append("_");
    paramEditor.append(paramLong);
    b(paramEditor.toString());
  }
  
  private static void s(SharedPreferences.Editor paramEditor, String paramString, long paramLong)
  {
    paramEditor = new StringBuilder();
    paramEditor.append("key_shuoshuo_record_media");
    paramEditor.append(paramString);
    paramEditor.append("_");
    paramEditor.append(paramLong);
    b(paramEditor.toString());
  }
  
  private static void t(SharedPreferences.Editor paramEditor, String paramString, long paramLong)
  {
    paramEditor = new StringBuilder();
    paramEditor.append("key_shuoshuo_select_list_media");
    paramEditor.append(paramString);
    paramEditor.append("_");
    paramEditor.append(paramLong);
    b(paramEditor.toString());
  }
  
  private static void u(SharedPreferences.Editor paramEditor, String paramString, long paramLong)
  {
    paramEditor = new StringBuilder();
    paramEditor.append("key_shuoshuo_selected_media");
    paramEditor.append(paramString);
    paramEditor.append("_");
    paramEditor.append(paramLong);
    b(paramEditor.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.common.config.LocalConfig
 * JD-Core Version:    0.7.0.1
 */