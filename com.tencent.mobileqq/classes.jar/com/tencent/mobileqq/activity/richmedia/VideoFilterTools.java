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
import com.tencent.mobileqq.ar.ArConfigUtils;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.AudioHelper;
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

public class VideoFilterTools
{
  private static VideoFilterTools jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterTools;
  public static final String a;
  public static final String b;
  private static boolean jdField_b_of_type_Boolean = false;
  public static final String c;
  private static final String d = PathUtils.jdField_a_of_type_JavaLangString + "/qav" + File.separator + "beauty" + File.separator;
  private static final String e = d + "SKINCOLOR" + File.separator;
  private int jdField_a_of_type_Int = 0;
  private FilterRender jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender;
  private VideoFilterTools.OnResourceDownloadListener jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterTools$OnResourceDownloadListener;
  private FilterDesc jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc;
  private ArrayList<FilterDesc> jdField_a_of_type_JavaUtilArrayList;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private volatile boolean jdField_a_of_type_Boolean = false;
  private int[] jdField_a_of_type_ArrayOfInt = { -1 };
  private int jdField_b_of_type_Int = 0;
  private int c;
  
  static
  {
    jdField_a_of_type_JavaLangString = PathUtils.jdField_a_of_type_JavaLangString + "/qsvf" + File.separator;
    jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString + "res" + File.separator;
    jdField_c_of_type_JavaLangString = jdField_a_of_type_JavaLangString + "artfilter" + File.separator;
  }
  
  private VideoFilterTools()
  {
    this.jdField_c_of_type_Int = -1;
    GraphicRenderMgr.loadSo();
    String str = DeviceInfoUtil.h() + " " + DeviceInfoUtil.d();
    QLog.i("VideoFilterTools", 2, "DeviceInfo " + str);
  }
  
  public static int a(Context paramContext)
  {
    int i = 0;
    int j = PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("qq_video_filter_config_version", 0);
    if ((j > 0) && (!new File(jdField_a_of_type_JavaLangString + "filter_config.xml").exists())) {
      AVLog.printColorLog("VideoFilterTools", "getQQShortVideoFilterConfigVersion config file don't exist!");
    }
    for (;;)
    {
      AVLog.printColorLog("VideoFilterTools", "getQQShortVideoFilterConfigVersion:" + i);
      return i;
      i = j;
    }
  }
  
  private static VideoFilterTools.SkinColorFilterDesc a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      AVLog.printColorLog("VideoFilterTools", "parseConfig|content is empty.");
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
          AVLog.printColorLog("VideoFilterTools", "parseConfig:" + i + "|" + str1 + "|" + str2);
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
        AVLog.printColorLog("VideoFilterTools", "parseConfig failed. info = " + localJSONObject);
        return localSkinColorFilterDesc;
      }
      catch (JSONException localJSONException2)
      {
        localJSONException2.printStackTrace();
        AVLog.printColorLog("VideoFilterTools", "parseConfig|parse failed.context = " + paramString);
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
      AVLog.printColorLog("VideoFilterTools", "getQQShortVideoFilterConfig:" + jdField_a_of_type_JavaLangString + "filter_config.xml" + "|" + localFile.exists());
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
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("qq_video_filter_config_first_launch", 1);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    AVLog.printColorLog("VideoFilterTools", "setQQShortVideoFilterConfigVersion:" + paramInt);
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("qq_video_filter_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    if (paramString == null)
    {
      AVLog.printColorLog("VideoFilterTools", "updateQQShortVideoFilterConfig error ");
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
        AVLog.printColorLog("VideoFilterTools", "compareContent :" + (l2 - l1));
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
              if ((localFilterDesc.name != null) && (localFilterDesc.name.equals(paramString2.name)))
              {
                AVLog.printColorLog("VideoFilterTools", "compareContent res:" + localFilterDesc.name + "|" + localFilterDesc.resMD5 + "|" + paramString2.resMD5);
                if ((localFilterDesc.resMD5 != null) && (!localFilterDesc.resMD5.equals(paramString2.resMD5))) {
                  FileUtils.a(paramString2.getResFold(jdField_b_of_type_JavaLangString));
                }
                AVLog.printColorLog("VideoFilterTools", "compareContent iconMD5:" + localFilterDesc.name + "|" + localFilterDesc.iconMD5 + "|" + paramString2.iconMD5);
                if ((localFilterDesc.iconMD5 != null) && (!localFilterDesc.iconMD5.equals(paramString2.iconMD5))) {
                  FileUtils.e(paramString2.getIconFile(jdField_b_of_type_JavaLangString));
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
      AVLog.printColorLog("VideoFilterTools", "handleQQSvCommonConfig empty content!");
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
            QmcfManager.getInstance().updateQmcfMainSwitch(paramString.getJSONObject("SvArtFilter"));
            return;
          }
        }
        catch (Exception paramString) {}
      }
    } while (!QLog.isColorLevel());
    QLog.e("VideoFilterTools", 2, "handleQQSvCommonConfig error!", paramString);
  }
  
  static void a(String paramString, List<FilterDesc> paramList)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramList == null)) {
      AVLog.printColorLog("VideoFilterTools", "parseConfig|content is empty.");
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
            AVLog.printColorLog("VideoFilterTools", "parseConfig:" + k + "|" + m + "|" + n + "|" + str5 + "|" + str1 + "|" + str4 + "|" + str2 + "|" + str3);
            i += 1;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
              AVLog.printColorLog("VideoFilterTools", "parseConfig failed. info = " + localJSONObject);
            }
          }
        }
        return;
      }
      catch (JSONException paramList)
      {
        paramList.printStackTrace();
        AVLog.printColorLog("VideoFilterTools", "parseConfig|parse failed.context = " + paramString);
      }
    }
  }
  
  public static boolean a(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    int i = DeviceInfoUtil.a();
    if (i < paramInt2)
    {
      AVLog.printColorLog("VideoFilterTools", "isSupportOfDevice error OSversion: " + i);
      return false;
    }
    paramInt2 = VcSystemInfo.getNumCores();
    if (paramInt2 < paramInt1)
    {
      AVLog.printColorLog("VideoFilterTools", "isSupportOfDevice error cpucount: " + paramInt2);
      return false;
    }
    long l = VcSystemInfo.getMaxCpuFreq();
    if (l < paramLong1)
    {
      AVLog.printColorLog("VideoFilterTools", "isSupportOfDevice error cpuFrequency: " + l);
      return false;
    }
    paramLong1 = DeviceInfoUtil.a();
    if (paramLong1 < paramLong2)
    {
      AVLog.printColorLog("VideoFilterTools", "isSupportOfDevice error memory: " + paramLong1);
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
      File localFile = new File(d + "beauty_config.json");
      AVLog.printColorLog("VideoFilterTools", "getVideoEffectBeautyConfig:" + d + "beauty_config.json" + "|" + localFile.exists());
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
  
  public static void b(Context paramContext)
  {
    try
    {
      if (b(paramContext))
      {
        a(paramContext);
        if (new File(e).exists()) {
          FileUtils.a(e);
        }
      }
      paramContext = a(b(paramContext));
      if ((paramContext != null) && (!TextUtils.isEmpty(paramContext.jdField_a_of_type_JavaLangString)))
      {
        Object localObject = new File(e + "params.json");
        AVLog.printColorLog("VideoFilterTools", "preDownloadResource :" + ((File)localObject).exists());
        if (!((File)localObject).exists())
        {
          localObject = new HttpNetReq();
          ((HttpNetReq)localObject).mCallback = new VideoFilterTools.MyHttpListenerforBeauty();
          ((HttpNetReq)localObject).mReqUrl = paramContext.jdField_a_of_type_JavaLangString;
          ((HttpNetReq)localObject).mHttpMethod = 0;
          ((HttpNetReq)localObject).mOutPath = (d + "skin_color.zip");
          ((HttpNetReq)localObject).setUserData(paramContext);
          AVNetEngine.a().sendReq((NetReq)localObject);
        }
      }
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static void b(Context paramContext, int paramInt)
  {
    AVLog.printColorLog("VideoFilterTools", "setVideoEffectBeautyConfigVersion:" + paramInt);
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("qav_effect_beauty_config_version", paramInt);
    paramContext.commit();
  }
  
  public static boolean b()
  {
    return (new File(e + "params.json").exists()) && (new File(d + "beauty_config.json").exists());
  }
  
  public static boolean b(Context paramContext)
  {
    boolean bool = false;
    int i = PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("qq_video_filter_config_first_launch", 0);
    AVLog.printColorLog("VideoFilterTools", "getIsFirstLauncher:" + i);
    if (i == 0) {
      bool = true;
    }
    return bool;
  }
  
  public FilterRender a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Int != paramInt1) || (this.jdField_b_of_type_Int != paramInt2))
    {
      AVLog.printColorLog("VideoFilterTools", "getFilter|init texture.");
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt2;
      if (this.jdField_c_of_type_Int != -1) {
        this.jdField_c_of_type_Int = -1;
      }
      if (this.jdField_a_of_type_ArrayOfInt[0] != -1) {
        this.jdField_a_of_type_ArrayOfInt[0] = -1;
      }
      GLES20.glGenTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
      this.jdField_c_of_type_Int = AVGLUtils.initFrameBuffer(paramInt1, paramInt2, this.jdField_a_of_type_ArrayOfInt[0]);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      AVLog.printColorLog("VideoFilterTools", "getFilterRender|destroy current filterRender.");
      this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender = null;
      this.jdField_a_of_type_Boolean = false;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender == null) {
      this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender = new FilterRender(BaseApplicationImpl.getContext());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc != null) {
      this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender.setFilterPath(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc.getResFold(jdField_b_of_type_JavaLangString));
    }
    return this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender;
  }
  
  public List<FilterDesc> a()
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
        str1 = ((FilterDesc)localObject3).getIconFile(jdField_b_of_type_JavaLangString);
        bool = new File(str1).exists();
        AVLog.printColorLog("VideoFilterTools", "getFilterDescs " + str1 + " exist: " + bool);
        if (bool)
        {
          str1 = ((FilterDesc)localObject3).getResFold(jdField_b_of_type_JavaLangString);
          String str2 = str1 + "params.json";
          bool = new File(str2).exists();
          AVLog.printColorLog("VideoFilterTools", "getFilterDescs " + str2 + " exist: " + bool);
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
      localObject3 = ((FilterDesc)localObject2).getIconFile(jdField_b_of_type_JavaLangString);
      bool = new File((String)localObject3).exists();
      AVLog.printColorLog("VideoFilterTools", "getFilterDescs " + (String)localObject3 + " exist: " + bool);
      if (bool)
      {
        localObject3 = ((FilterDesc)localObject2).getResFold(jdField_b_of_type_JavaLangString);
        str1 = (String)localObject3 + "params.json";
        bool = new File(str1).exists();
        AVLog.printColorLog("VideoFilterTools", "getFilterDescs " + str1 + " exist: " + bool);
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
    AVLog.printColorLog("VideoFilterTools", "init");
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterTools$OnResourceDownloadListener = ???;
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      a(a(paramContext), this.jdField_a_of_type_JavaUtilArrayList);
      a(this.jdField_a_of_type_JavaUtilArrayList);
      AVLog.printColorLog("VideoFilterTools", "filter list size:" + this.jdField_a_of_type_JavaUtilArrayList.size());
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc = ((FilterDesc)this.jdField_a_of_type_JavaUtilArrayList.get(0));
      }
      return;
    }
  }
  
  public void a(FilterDesc paramFilterDesc)
  {
    Object localObject2 = null;
    if (paramFilterDesc != null) {
      new StringBuilder().append(paramFilterDesc.id).append("").toString();
    }
    StringBuilder localStringBuilder;
    if (AudioHelper.e())
    {
      localStringBuilder = new StringBuilder().append("setCurrentId, id[");
      if (paramFilterDesc != null) {
        break label107;
      }
      localObject1 = null;
      localStringBuilder = localStringBuilder.append(localObject1).append("->");
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc != null) {
        break label118;
      }
    }
    label107:
    label118:
    for (Object localObject1 = localObject2;; localObject1 = Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc.id))
    {
      QLog.w("VideoFilterTools", 1, localObject1 + "]");
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc = paramFilterDesc;
      return;
      localObject1 = Integer.valueOf(paramFilterDesc.id);
      break;
    }
  }
  
  public void a(ArrayList<FilterDesc> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      if (((FilterDesc)paramArrayList.next()).id == 9) {
        paramArrayList.remove();
      }
    }
  }
  
  void a(List<FilterDesc> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      AVLog.printColorLog("VideoFilterTools", "preDownloadResource list is empty!");
    }
    do
    {
      return;
      AVLog.printColorLog("VideoFilterTools", "preDownloadResource list size: " + paramList.size());
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FilterDesc localFilterDesc = (FilterDesc)paramList.next();
        AVLog.printColorLog("VideoFilterTools", "preDownloadResource predownload: " + localFilterDesc.predownload + ", iconurl: " + localFilterDesc.iconurl + ", resurl:" + localFilterDesc.resurl);
        if (localFilterDesc.predownload == 1)
        {
          Object localObject2;
          if (!TextUtils.isEmpty(localFilterDesc.iconurl))
          {
            localObject1 = localFilterDesc.getIconFile(jdField_b_of_type_JavaLangString);
            localObject2 = new File((String)localObject1);
            AVLog.printColorLog("VideoFilterTools", "preDownloadResource " + (String)localObject1 + " exist: " + ((File)localObject2).exists());
            if (!((File)localObject2).exists())
            {
              localObject2 = new HttpNetReq();
              ((HttpNetReq)localObject2).mCallback = new VideoFilterTools.MyIconHttpListener(this);
              ((HttpNetReq)localObject2).mReqUrl = localFilterDesc.iconurl;
              ((HttpNetReq)localObject2).mHttpMethod = 0;
              ((HttpNetReq)localObject2).mOutPath = ((String)localObject1);
              ((HttpNetReq)localObject2).setUserData(localFilterDesc);
              AVNetEngine.a().sendReq((NetReq)localObject2);
              this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
            }
          }
          Object localObject1 = localFilterDesc.getResFold(jdField_b_of_type_JavaLangString);
          if ((!TextUtils.isEmpty(localFilterDesc.resurl)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
          {
            localObject2 = new File((String)localObject1 + "params.json");
            AVLog.printColorLog("VideoFilterTools", "preDownloadResource " + (String)localObject1 + "params.json" + " exist: " + ((File)localObject2).exists());
            if (!((File)localObject2).exists())
            {
              localObject1 = new HttpNetReq();
              ((HttpNetReq)localObject1).mCallback = new VideoFilterTools.MyHttpListener(this);
              ((HttpNetReq)localObject1).mReqUrl = localFilterDesc.resurl;
              ((HttpNetReq)localObject1).mHttpMethod = 0;
              ((HttpNetReq)localObject1).mOutPath = (jdField_b_of_type_JavaLangString + localFilterDesc.name + ".zip");
              ((HttpNetReq)localObject1).setUserData(localFilterDesc);
              AVNetEngine.a().sendReq((NetReq)localObject1);
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
    return (i > 1) || ((i == 1) && (!((FilterDesc)this.jdField_a_of_type_JavaUtilArrayList.get(0)).isEmptyFilter()));
  }
  
  public void b()
  {
    AVLog.printColorLog("VideoFilterTools", "destroy");
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void c()
  {
    AVLog.printColorLog("VideoFilterTools", "destroy");
    if (this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender.destroy();
      this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender = null;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void c(Context paramContext)
  {
    if (new File(d + "beauty_config.json").exists())
    {
      if (!new File(e + "params.json").exists())
      {
        AVLog.printColorLog("VideoFilterTools", "!JasonFile.exists()");
        b(paramContext);
      }
      return;
    }
    AVLog.printColorLog("VideoFilterTools", "BEAUTY_CONFIG  is not exsit");
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc != null) {
      return this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc.type == 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.VideoFilterTools
 * JD-Core Version:    0.7.0.1
 */