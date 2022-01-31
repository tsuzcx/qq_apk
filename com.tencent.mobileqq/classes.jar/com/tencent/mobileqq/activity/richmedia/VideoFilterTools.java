package com.tencent.mobileqq.activity.richmedia;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.opengl.GLES20;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.AVNetEngine;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.utils.AVGLUtils;
import com.tencent.av.video.effect.filter.FilterRender;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.ar.ArConfigUtils;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xue;
import xuf;
import xug;

public class VideoFilterTools
{
  private static VideoFilterTools jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterTools;
  public static final String a;
  public static final String b;
  private static boolean jdField_b_of_type_Boolean;
  public static final String c;
  public static final String d;
  private static final String e;
  private static final String f;
  private int jdField_a_of_type_Int;
  private FilterRender jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender;
  private VideoFilterTools.OnResourceDownloadListener jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterTools$OnResourceDownloadListener;
  private FilterDesc jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private volatile boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt = { -1 };
  private int jdField_b_of_type_Int;
  private int c;
  
  static
  {
    jdField_a_of_type_JavaLangString = AppConstants.aJ + "qsvf" + File.separator;
    jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString + "res" + File.separator;
    jdField_c_of_type_JavaLangString = jdField_a_of_type_JavaLangString + "artfilter" + File.separator;
    e = AppConstants.aJ + "qav" + File.separator + "beauty" + File.separator;
    f = e + "SKINCOLOR" + File.separator;
    jdField_d_of_type_JavaLangString = e;
  }
  
  private VideoFilterTools()
  {
    this.jdField_c_of_type_Int = -1;
    GraphicRenderMgr.loadSo();
    String str = DeviceInfoUtil.i() + " " + DeviceInfoUtil.e();
    QLog.i("VideoFilterTools", 2, "DeviceInfo " + str);
  }
  
  public static int a(Context paramContext)
  {
    int i = 0;
    int j = PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("qq_video_filter_config_version", 0);
    if ((j > 0) && (!new File(jdField_a_of_type_JavaLangString + "filter_config.xml").exists())) {
      AVLog.c("VideoFilterTools", "getQQShortVideoFilterConfigVersion config file don't exist!");
    }
    for (;;)
    {
      AVLog.c("VideoFilterTools", "getQQShortVideoFilterConfigVersion:" + i);
      return i;
      i = j;
    }
  }
  
  private static VideoFilterTools.SkinColorFilterDesc a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      AVLog.c("VideoFilterTools", "parseConfig|content is empty.");
      return null;
    }
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(paramString).getJSONObject("skinColorFilter");
      }
      catch (JSONException localJSONException3)
      {
        JSONObject localJSONObject;
        int i;
        String str1;
        String str2;
        localSkinColorFilterDesc = null;
        continue;
      }
      try
      {
        i = Integer.valueOf(localJSONObject.getString("filterid")).intValue();
        str1 = localJSONObject.getString("resurl");
        str2 = localJSONObject.getString("md5");
        localSkinColorFilterDesc = new VideoFilterTools.SkinColorFilterDesc(i, str1, str2);
        try
        {
          AVLog.c("VideoFilterTools", "parseConfig:" + i + "|" + str1 + "|" + str2);
          return localSkinColorFilterDesc;
        }
        catch (JSONException localJSONException1) {}
      }
      catch (JSONException localJSONException4)
      {
        localSkinColorFilterDesc = null;
        continue;
      }
      try
      {
        localJSONException1.printStackTrace();
        AVLog.c("VideoFilterTools", "parseConfig failed. info = " + localJSONObject);
        return localSkinColorFilterDesc;
      }
      catch (JSONException localJSONException2)
      {
        localJSONException2.printStackTrace();
        AVLog.c("VideoFilterTools", "parseConfig|parse failed.context = " + paramString);
        return localSkinColorFilterDesc;
      }
    }
  }
  
  public static VideoFilterTools a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterTools == null) {
      jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterTools = new VideoFilterTools();
    }
    return jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterTools;
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      File localFile = new File(jdField_a_of_type_JavaLangString + "filter_config.xml");
      AVLog.c("VideoFilterTools", "getQQShortVideoFilterConfig:" + jdField_a_of_type_JavaLangString + "filter_config.xml" + "|" + localFile.exists());
      if (localFile.exists()) {
        return FileUtils.b(localFile);
      }
      a(paramContext, 0);
      return null;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static void a(Context paramContext)
  {
    try
    {
      if (b(paramContext))
      {
        c(paramContext);
        if (new File(f).exists()) {
          FileUtils.a(f);
        }
      }
      paramContext = a(b(paramContext));
      if ((paramContext != null) && (!TextUtils.isEmpty(paramContext.jdField_a_of_type_JavaLangString)))
      {
        Object localObject = new File(f + "params.json");
        AVLog.c("VideoFilterTools", "preDownloadResource :" + ((File)localObject).exists());
        if (!((File)localObject).exists())
        {
          localObject = new HttpNetReq();
          ((HttpNetReq)localObject).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new xuf();
          ((HttpNetReq)localObject).jdField_a_of_type_JavaLangString = paramContext.jdField_a_of_type_JavaLangString;
          ((HttpNetReq)localObject).jdField_a_of_type_Int = 0;
          ((HttpNetReq)localObject).jdField_c_of_type_JavaLangString = (e + "skin_color.zip");
          ((HttpNetReq)localObject).a(paramContext);
          AVNetEngine.a().a((NetReq)localObject);
        }
      }
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    AVLog.c("VideoFilterTools", "setQQShortVideoFilterConfigVersion:" + paramInt);
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("qq_video_filter_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    if (paramString == null)
    {
      AVLog.c("VideoFilterTools", "updateQQShortVideoFilterConfig error ");
      return;
    }
    a(paramContext, paramString, a(paramContext));
    FileUtils.a(jdField_a_of_type_JavaLangString, "filter_config.xml", paramString);
    a(paramContext, paramInt);
  }
  
  static void a(Context paramContext, String paramString1, String paramString2)
  {
    Iterator localIterator = null;
    long l1 = System.currentTimeMillis();
    if ((paramString1 != null) && (!paramString1.equals("")))
    {
      paramContext = new ArrayList();
      a(paramString1, paramContext);
    }
    for (;;)
    {
      if ((paramString2 != null) && (!paramString2.equals("")))
      {
        paramString1 = new ArrayList();
        a(paramString2, paramString1);
        if (paramContext != null) {
          break label136;
        }
        FileUtils.a(jdField_b_of_type_JavaLangString);
      }
      for (;;)
      {
        long l2 = System.currentTimeMillis();
        AVLog.c("VideoFilterTools", "compareContent :" + (l2 - l1));
        return;
        paramString1 = localIterator;
        if (!new File(jdField_b_of_type_JavaLangString).exists()) {
          break;
        }
        FileUtils.a(jdField_b_of_type_JavaLangString);
        paramString1 = localIterator;
        break;
        label136:
        if (paramString1 != null)
        {
          paramString1 = paramString1.iterator();
          while (paramString1.hasNext())
          {
            paramString2 = (FilterDesc)paramString1.next();
            localIterator = paramContext.iterator();
            while (localIterator.hasNext())
            {
              FilterDesc localFilterDesc = (FilterDesc)localIterator.next();
              if ((localFilterDesc.e != null) && (localFilterDesc.e.equals(paramString2.e)))
              {
                AVLog.c("VideoFilterTools", "compareContent res:" + localFilterDesc.e + "|" + localFilterDesc.jdField_b_of_type_JavaLangString + "|" + paramString2.jdField_b_of_type_JavaLangString);
                if ((localFilterDesc.jdField_b_of_type_JavaLangString != null) && (!localFilterDesc.jdField_b_of_type_JavaLangString.equals(paramString2.jdField_b_of_type_JavaLangString))) {
                  FileUtils.a(paramString2.b(jdField_b_of_type_JavaLangString));
                }
                AVLog.c("VideoFilterTools", "compareContent iconMD5:" + localFilterDesc.e + "|" + localFilterDesc.jdField_d_of_type_JavaLangString + "|" + paramString2.jdField_d_of_type_JavaLangString);
                if ((localFilterDesc.jdField_d_of_type_JavaLangString != null) && (!localFilterDesc.jdField_d_of_type_JavaLangString.equals(paramString2.jdField_d_of_type_JavaLangString))) {
                  FileUtils.d(paramString2.a(jdField_b_of_type_JavaLangString));
                }
              }
            }
          }
        }
      }
      paramContext = null;
    }
  }
  
  public static void a(String paramString)
  {
    if (paramString == null) {
      AVLog.c("VideoFilterTools", "handleQQSvCommonConfig empty content!");
    }
    do
    {
      for (;;)
      {
        return;
        try
        {
          paramString = new JSONObject(paramString).getJSONObject("CommonConfig");
          if (paramString.getJSONObject("SvArtFilter") != null)
          {
            QmcfManager.a().a(paramString.getJSONObject("SvArtFilter"));
            return;
          }
        }
        catch (Exception paramString) {}
      }
    } while (!QLog.isColorLevel());
    QLog.e("VideoFilterTools", 2, "handleQQSvCommonConfig error!", paramString);
  }
  
  static void a(String paramString, List paramList)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramList == null)) {
      AVLog.c("VideoFilterTools", "parseConfig|content is empty.");
    }
    for (;;)
    {
      return;
      paramList.clear();
      try
      {
        JSONArray localJSONArray = new JSONObject(paramString).getJSONArray("content");
        int i = 0;
        while (i < localJSONArray.length())
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          try
          {
            int j = Integer.valueOf(localJSONObject.getString("type")).intValue();
            int k = Integer.valueOf(localJSONObject.getString("filterid")).intValue();
            int m = Integer.valueOf(localJSONObject.getString("subid")).intValue();
            int n = Integer.valueOf(localJSONObject.getString("predownload")).intValue();
            String str5 = localJSONObject.getString("resurl");
            String str1 = localJSONObject.getString("md5");
            String str4 = localJSONObject.getString("iconurl");
            String str2 = localJSONObject.getString("iconmd5");
            String str3 = localJSONObject.getString("name");
            str5 = ArConfigUtils.a(str5);
            str4 = ArConfigUtils.a(str4);
            paramList.add(new FilterDesc(k, m, n, str5, str1, str4, str2, str3, j));
            AVLog.c("VideoFilterTools", "parseConfig:" + k + "|" + m + "|" + n + "|" + str5 + "|" + str1 + "|" + str4 + "|" + str2 + "|" + str3);
            i += 1;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
              AVLog.c("VideoFilterTools", "parseConfig failed. info = " + localJSONObject);
            }
          }
        }
        return;
      }
      catch (JSONException paramList)
      {
        paramList.printStackTrace();
        AVLog.c("VideoFilterTools", "parseConfig|parse failed.context = " + paramString);
      }
    }
  }
  
  public static boolean a(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    int i = DeviceInfoUtil.a();
    if (i < paramInt2)
    {
      AVLog.c("VideoFilterTools", "isSupportOfDevice error OSversion: " + i);
      return false;
    }
    paramInt2 = VcSystemInfo.e();
    if (paramInt2 < paramInt1)
    {
      AVLog.c("VideoFilterTools", "isSupportOfDevice error cpucount: " + paramInt2);
      return false;
    }
    long l = VcSystemInfo.c();
    if (l < paramLong1)
    {
      AVLog.c("VideoFilterTools", "isSupportOfDevice error cpuFrequency: " + l);
      return false;
    }
    paramLong1 = DeviceInfoUtil.e();
    if (paramLong1 < paramLong2)
    {
      AVLog.c("VideoFilterTools", "isSupportOfDevice error memory: " + paramLong1);
      return false;
    }
    return true;
  }
  
  public static boolean a(Context paramContext)
  {
    if (jdField_b_of_type_Boolean) {
      return true;
    }
    if (!a(4, 1350000L, 1073741824L, 17)) {
      return false;
    }
    if ((paramContext != null) && (TextUtils.isEmpty(a(paramContext)))) {
      return false;
    }
    jdField_b_of_type_Boolean = true;
    return jdField_b_of_type_Boolean;
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      File localFile = new File(e + "beauty_config.json");
      AVLog.c("VideoFilterTools", "getVideoEffectBeautyConfig:" + e + "beauty_config.json" + "|" + localFile.exists());
      if (localFile.exists()) {
        return FileUtils.b(localFile);
      }
      b(paramContext, 0);
      return null;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static void b(Context paramContext, int paramInt)
  {
    AVLog.c("VideoFilterTools", "setVideoEffectBeautyConfigVersion:" + paramInt);
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("qav_effect_beauty_config_version", paramInt);
    paramContext.commit();
  }
  
  public static boolean b()
  {
    return (new File(f + "params.json").exists()) && (new File(e + "beauty_config.json").exists());
  }
  
  private static boolean b(Context paramContext)
  {
    boolean bool = false;
    int i = PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("qq_video_filter_config_first_launch", 0);
    AVLog.c("VideoFilterTools", "getIsFirstLauncher:" + i);
    if (i == 0) {
      bool = true;
    }
    return bool;
  }
  
  private static void c(Context paramContext)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("qq_video_filter_config_first_launch", 1);
    paramContext.commit();
  }
  
  public FilterRender a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Int != paramInt1) || (this.jdField_b_of_type_Int != paramInt2))
    {
      AVLog.c("VideoFilterTools", "getFilter|init texture.");
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt2;
      if (this.jdField_c_of_type_Int != -1) {
        this.jdField_c_of_type_Int = -1;
      }
      if (this.jdField_a_of_type_ArrayOfInt[0] != -1) {
        this.jdField_a_of_type_ArrayOfInt[0] = -1;
      }
      GLES20.glGenTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
      this.jdField_c_of_type_Int = AVGLUtils.a(paramInt1, paramInt2, this.jdField_a_of_type_ArrayOfInt[0]);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      AVLog.c("VideoFilterTools", "getFilterRender|destroy current filterRender.");
      this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender = null;
      this.jdField_a_of_type_Boolean = false;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender == null) {
      this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender = new FilterRender(BaseApplicationImpl.getContext());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc != null) {
      this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender.setFilterPath(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc.b(jdField_b_of_type_JavaLangString));
    }
    return this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender;
  }
  
  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    Object localObject3;
    String str1;
    boolean bool;
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      a(this.jdField_a_of_type_JavaUtilArrayList);
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (FilterDesc)((Iterator)localObject2).next();
        str1 = ((FilterDesc)localObject3).a(jdField_b_of_type_JavaLangString);
        bool = new File(str1).exists();
        AVLog.c("VideoFilterTools", "getFilterDescs " + str1 + " exist: " + bool);
        if (bool)
        {
          str1 = ((FilterDesc)localObject3).b(jdField_b_of_type_JavaLangString);
          String str2 = str1 + "params.json";
          bool = new File(str2).exists();
          AVLog.c("VideoFilterTools", "getFilterDescs " + str2 + " exist: " + bool);
          if ((TextUtils.isEmpty(str1)) || ((str1 != null) && (bool))) {
            localArrayList.add(localObject3);
          }
        }
      }
    }
    ??? = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)???).hasNext())
    {
      localObject2 = (FilterDesc)((Iterator)???).next();
      localObject3 = ((FilterDesc)localObject2).a(jdField_b_of_type_JavaLangString);
      bool = new File((String)localObject3).exists();
      AVLog.c("VideoFilterTools", "getFilterDescs " + (String)localObject3 + " exist: " + bool);
      if (bool)
      {
        localObject3 = ((FilterDesc)localObject2).b(jdField_b_of_type_JavaLangString);
        str1 = (String)localObject3 + "params.json";
        bool = new File(str1).exists();
        AVLog.c("VideoFilterTools", "getFilterDescs " + str1 + " exist: " + bool);
        if ((TextUtils.isEmpty((CharSequence)localObject3)) || ((localObject3 != null) && (bool))) {
          localList.add(localObject2);
        }
      }
    }
    return localList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterTools$OnResourceDownloadListener = null;
    if (this.jdField_c_of_type_Int != -1) {
      this.jdField_c_of_type_Int = -1;
    }
    if (this.jdField_a_of_type_ArrayOfInt[0] != -1) {
      this.jdField_a_of_type_ArrayOfInt[0] = -1;
    }
  }
  
  public void a(Context paramContext, VideoFilterTools.OnResourceDownloadListener arg2)
  {
    if (QLog.isColorLevel()) {
      com.tencent.av.video.effect.QavVideoEffect.DEBUG_MODE = true;
    }
    AVLog.c("VideoFilterTools", "init");
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterTools$OnResourceDownloadListener = ???;
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      a(a(paramContext), this.jdField_a_of_type_JavaUtilArrayList);
      a(this.jdField_a_of_type_JavaUtilArrayList);
      AVLog.c("VideoFilterTools", "filter list size:" + this.jdField_a_of_type_JavaUtilArrayList.size());
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc = ((FilterDesc)this.jdField_a_of_type_JavaUtilArrayList.get(0));
      }
      return;
    }
  }
  
  public void a(FilterDesc paramFilterDesc)
  {
    if (paramFilterDesc != null) {
      AVLog.c("VideoFilterTools", "setCurrentId id: " + paramFilterDesc.jdField_b_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc = paramFilterDesc;
      return;
      AVLog.c("VideoFilterTools", "setCurrentId null");
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      if (((FilterDesc)paramArrayList.next()).jdField_b_of_type_Int == 9) {
        paramArrayList.remove();
      }
    }
  }
  
  void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      AVLog.c("VideoFilterTools", "preDownloadResource list is empty!");
    }
    do
    {
      return;
      AVLog.c("VideoFilterTools", "preDownloadResource list size: " + paramList.size());
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FilterDesc localFilterDesc = (FilterDesc)paramList.next();
        AVLog.c("VideoFilterTools", "preDownloadResource predownload: " + localFilterDesc.jdField_d_of_type_Int + ", iconurl: " + localFilterDesc.jdField_c_of_type_JavaLangString + ", resurl:" + localFilterDesc.jdField_a_of_type_JavaLangString);
        if (localFilterDesc.jdField_d_of_type_Int == 1)
        {
          Object localObject2;
          if (!TextUtils.isEmpty(localFilterDesc.jdField_c_of_type_JavaLangString))
          {
            localObject1 = localFilterDesc.a(jdField_b_of_type_JavaLangString);
            localObject2 = new File((String)localObject1);
            AVLog.c("VideoFilterTools", "preDownloadResource " + (String)localObject1 + " exist: " + ((File)localObject2).exists());
            if (!((File)localObject2).exists())
            {
              localObject2 = new HttpNetReq();
              ((HttpNetReq)localObject2).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new xug(this);
              ((HttpNetReq)localObject2).jdField_a_of_type_JavaLangString = localFilterDesc.jdField_c_of_type_JavaLangString;
              ((HttpNetReq)localObject2).jdField_a_of_type_Int = 0;
              ((HttpNetReq)localObject2).jdField_c_of_type_JavaLangString = ((String)localObject1);
              ((HttpNetReq)localObject2).a(localFilterDesc);
              AVNetEngine.a().a((NetReq)localObject2);
              this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
            }
          }
          Object localObject1 = localFilterDesc.b(jdField_b_of_type_JavaLangString);
          if ((!TextUtils.isEmpty(localFilterDesc.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
          {
            localObject2 = new File((String)localObject1 + "params.json");
            AVLog.c("VideoFilterTools", "preDownloadResource " + (String)localObject1 + "params.json" + " exist: " + ((File)localObject2).exists());
            if (!((File)localObject2).exists())
            {
              localObject1 = new HttpNetReq();
              ((HttpNetReq)localObject1).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new xue(this);
              ((HttpNetReq)localObject1).jdField_a_of_type_JavaLangString = localFilterDesc.jdField_a_of_type_JavaLangString;
              ((HttpNetReq)localObject1).jdField_a_of_type_Int = 0;
              ((HttpNetReq)localObject1).jdField_c_of_type_JavaLangString = (jdField_b_of_type_JavaLangString + localFilterDesc.e + ".zip");
              ((HttpNetReq)localObject1).a(localFilterDesc);
              AVNetEngine.a().a((NetReq)localObject1);
              this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
            }
          }
        }
      }
    } while ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterTools$OnResourceDownloadListener == null));
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterTools$OnResourceDownloadListener.a(false);
  }
  
  public boolean a()
  {
    int i = this.jdField_a_of_type_JavaUtilArrayList.size();
    return (i > 1) || ((i == 1) && (!((FilterDesc)this.jdField_a_of_type_JavaUtilArrayList.get(0)).a()));
  }
  
  public void b()
  {
    AVLog.c("VideoFilterTools", "destroy");
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void b(Context paramContext)
  {
    if (new File(e + "beauty_config.json").exists())
    {
      if (!new File(f + "params.json").exists())
      {
        AVLog.c("VideoFilterTools", "!JasonFile.exists()");
        a(paramContext);
      }
      return;
    }
    AVLog.c("VideoFilterTools", "BEAUTY_CONFIG  is not exsit");
  }
  
  public void c()
  {
    AVLog.c("VideoFilterTools", "destroy");
    if (this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender.destroy();
      this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender = null;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc != null) {
      return this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc.jdField_a_of_type_Int == 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.VideoFilterTools
 * JD-Core Version:    0.7.0.1
 */