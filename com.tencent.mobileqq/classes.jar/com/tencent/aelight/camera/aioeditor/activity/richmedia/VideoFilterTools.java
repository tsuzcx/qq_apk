package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.api.standard.AEModuleConfig;
import com.tencent.aekit.api.standard.AEModuleConfig.Builder;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager;
import com.tencent.aelight.camera.aioeditor.capture.data.ComboSet;
import com.tencent.aelight.camera.aioeditor.capture.data.FilterCategory;
import com.tencent.aelight.camera.aioeditor.capture.data.FilterSet;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMRedDotConfig;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMRedDotConfig.RedDotItemConfig;
import com.tencent.aelight.camera.aioeditor.capture.data.TransitionCategoryItem;
import com.tencent.aelight.camera.aioeditor.capture.util.QIMFileUtils;
import com.tencent.aelight.camera.aioeditor.richmedia.capture.data.CaptureVideoFilterManager;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicActivity;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;
import com.tencent.aelight.camera.api.IAEPhotoAIManager;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.av.opengl.filter.qqavimage.QQAVImageFilterConstants;
import com.tencent.av.utils.UITools;
import com.tencent.av.video.effect.lowlight.LowLightTools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.richmedia.PathUtils;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.filter.QQFilterRenderManagerHolder;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.qmcf.QmcfDevicesStrategy;
import com.tencent.mobileqq.shortvideo.resource.PtuFilterResource;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.openapi.filter.LightNode;
import com.tencent.ttpic.openapi.initializer.ImageAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.LightSdkInitializer;
import com.tencent.ttpic.openapi.initializer.PtuAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.PtuToolsInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArrayList<Lcom.tencent.aelight.camera.aioeditor.capture.data.FilterCategory;>;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoFilterTools
{
  private static int A = -1;
  private static int B = 0;
  public static final String a;
  public static HashMap<String, FilterDesc> c;
  public static QIMRedDotConfig h;
  public static Object i;
  public static String j;
  public static String k;
  public static int l;
  private static final String m;
  private static VideoFilterTools t;
  private static boolean v;
  private static boolean w;
  private static boolean x;
  private static int y;
  private static int z;
  public FilterDesc b;
  public QIMFilterCategoryItem[] d = new QIMFilterCategoryItem[5];
  public ComboSet[] e = new ComboSet[5];
  public QIMFilterCategoryItem[] f = new QIMFilterCategoryItem[5];
  public QIMFilterCategoryItem[] g = new QIMFilterCategoryItem[5];
  private int[] n = { -1 };
  private int o = -1;
  private int p = -1;
  private EditVideoPartManager q;
  private Bitmap r;
  private boolean s = true;
  private TransitionCategoryItem u;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(CaptureVideoFilterManager.a);
    localStringBuilder.append("artfilter");
    localStringBuilder.append(File.separator);
    a = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(PathUtils.d);
    localStringBuilder.append("dov_capture_qsvf");
    localStringBuilder.append(File.separator);
    m = localStringBuilder.toString();
    c = new HashMap();
    v = false;
    w = false;
    i = new Object();
    x = false;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(CaptureVideoFilterManager.a);
    localStringBuilder.append("lowlight");
    j = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(j);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("LowLight.png");
    k = localStringBuilder.toString();
    l = 0;
    y = 2;
    z = 1;
  }
  
  public static VideoFilterTools.DataSet a(CopyOnWriteArrayList<FilterCategory> paramCopyOnWriteArrayList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    VideoFilterTools.DataSet localDataSet = new VideoFilterTools.DataSet();
    paramBoolean1 = l();
    Object localObject1 = a(paramCopyOnWriteArrayList, 1, paramBoolean1);
    Object localObject3 = a(paramCopyOnWriteArrayList, 2, paramBoolean1);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    Object localObject4 = ((ArrayList)localObject1).iterator();
    paramCopyOnWriteArrayList = null;
    Object localObject6;
    Object localObject2;
    while (((Iterator)localObject4).hasNext())
    {
      localObject1 = (FilterCategory)((Iterator)localObject4).next();
      localObject5 = new FilterCategory(((FilterCategory)localObject1).a, ((FilterCategory)localObject1).b, ((FilterCategory)localObject1).d, ((FilterCategory)localObject1).e, ((FilterCategory)localObject1).f, ((FilterCategory)localObject1).g);
      localObject6 = ((FilterCategory)localObject1).c.iterator();
      while (((Iterator)localObject6).hasNext())
      {
        localObject2 = (QIMFilterCategoryItem)((Iterator)localObject6).next();
        localObject1 = paramCopyOnWriteArrayList;
        if (((QIMFilterCategoryItem)localObject2).c())
        {
          localObject1 = paramCopyOnWriteArrayList;
          if (paramCopyOnWriteArrayList == null) {
            localObject1 = localObject2;
          }
        }
        localObject2 = ((QIMFilterCategoryItem)localObject2).a();
        if (paramBoolean2)
        {
          paramCopyOnWriteArrayList = (CopyOnWriteArrayList<FilterCategory>)localObject1;
          if (!((QIMFilterCategoryItem)localObject2).b()) {}
        }
        else
        {
          ((FilterCategory)localObject5).c.add(localObject2);
          localArrayList1.add(localObject2);
          paramCopyOnWriteArrayList = (CopyOnWriteArrayList<FilterCategory>)localObject1;
        }
      }
      localArrayList3.add(localObject5);
    }
    localObject4 = new ArrayList();
    Object localObject5 = ((ArrayList)localObject3).iterator();
    localObject1 = null;
    while (((Iterator)localObject5).hasNext())
    {
      localObject2 = (FilterCategory)((Iterator)localObject5).next();
      if (((!paramBoolean3) || (((FilterCategory)localObject2).a != 103)) && ((paramBoolean3) || (((FilterCategory)localObject2).a != 104)))
      {
        localObject6 = new FilterCategory(((FilterCategory)localObject2).a, ((FilterCategory)localObject2).b, ((FilterCategory)localObject2).d, ((FilterCategory)localObject2).e, ((FilterCategory)localObject2).f, ((FilterCategory)localObject2).g);
        Iterator localIterator = ((FilterCategory)localObject2).c.iterator();
        while (localIterator.hasNext())
        {
          localObject3 = (QIMFilterCategoryItem)localIterator.next();
          localObject2 = localObject1;
          if (((QIMFilterCategoryItem)localObject3).c())
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = localObject3;
            }
          }
          localObject3 = ((QIMFilterCategoryItem)localObject3).a();
          if (paramBoolean2)
          {
            localObject1 = localObject2;
            if (!((QIMFilterCategoryItem)localObject3).b()) {}
          }
          else
          {
            ((FilterCategory)localObject6).c.add(localObject3);
            localArrayList1.add(localObject3);
            localArrayList2.add(localObject3);
            localObject1 = localObject2;
          }
        }
        ((ArrayList)localObject4).add(localObject6);
      }
    }
    localDataSet.a = localArrayList3;
    localDataSet.b = ((ArrayList)localObject4);
    localDataSet.d = localArrayList1;
    localDataSet.c = localArrayList2;
    localDataSet.e = paramCopyOnWriteArrayList;
    localDataSet.f = ((QIMFilterCategoryItem)localObject1);
    return localDataSet;
  }
  
  public static VideoFilterTools a()
  {
    if (t == null) {
      t = new VideoFilterTools();
    }
    return t;
  }
  
  public static ArrayList<FilterCategory> a(CopyOnWriteArrayList<FilterCategory> paramCopyOnWriteArrayList, int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    int i1;
    if ((l()) && (paramBoolean)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    paramCopyOnWriteArrayList = paramCopyOnWriteArrayList.iterator();
    while (paramCopyOnWriteArrayList.hasNext())
    {
      Object localObject = (FilterCategory)paramCopyOnWriteArrayList.next();
      FilterCategory localFilterCategory;
      QIMFilterCategoryItem localQIMFilterCategoryItem;
      int i2;
      if ((paramInt == 1) && (((FilterCategory)localObject).d))
      {
        localFilterCategory = new FilterCategory(((FilterCategory)localObject).a, ((FilterCategory)localObject).b, ((FilterCategory)localObject).d, ((FilterCategory)localObject).e, ((FilterCategory)localObject).f, ((FilterCategory)localObject).g);
        localFilterCategory.d = true;
        localObject = ((FilterCategory)localObject).c.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localQIMFilterCategoryItem = (QIMFilterCategoryItem)((Iterator)localObject).next();
          if (((i1 != 0) || (!QIMFilterCategoryItem.a(localQIMFilterCategoryItem))) && (!QIMFilterCategoryItem.b(localQIMFilterCategoryItem))) {
            localFilterCategory.c.add(localQIMFilterCategoryItem);
          }
        }
        if (localFilterCategory.c.size() > 0)
        {
          localObject = localFilterCategory.c.iterator();
          while (((Iterator)localObject).hasNext()) {
            if (!((QIMFilterCategoryItem)((Iterator)localObject).next()).c())
            {
              i2 = 0;
              break label239;
            }
          }
          i2 = 1;
          label239:
          if (i2 == 0) {
            localArrayList.add(localFilterCategory);
          }
        }
      }
      else if ((paramInt == 2) && (!((FilterCategory)localObject).d))
      {
        localFilterCategory = new FilterCategory(((FilterCategory)localObject).a, ((FilterCategory)localObject).b, ((FilterCategory)localObject).d, ((FilterCategory)localObject).e, ((FilterCategory)localObject).f, ((FilterCategory)localObject).g);
        localFilterCategory.d = false;
        localObject = ((FilterCategory)localObject).c.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localQIMFilterCategoryItem = (QIMFilterCategoryItem)((Iterator)localObject).next();
          if (((i1 != 0) || (!QIMFilterCategoryItem.a(localQIMFilterCategoryItem))) && (!QIMFilterCategoryItem.b(localQIMFilterCategoryItem))) {
            localFilterCategory.c.add(localQIMFilterCategoryItem);
          }
        }
        if (localFilterCategory.c.size() > 0)
        {
          localObject = localFilterCategory.c.iterator();
          while (((Iterator)localObject).hasNext()) {
            if (!((QIMFilterCategoryItem)((Iterator)localObject).next()).c())
            {
              i2 = 0;
              break label443;
            }
          }
          i2 = 1;
          label443:
          if (i2 == 0) {
            localArrayList.add(localFilterCategory);
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramCopyOnWriteArrayList = new StringBuilder(20);
      paramCopyOnWriteArrayList.append("getFilterCategory categoryType:");
      paramCopyOnWriteArrayList.append(paramInt);
      paramCopyOnWriteArrayList.append(" filter:");
      paramCopyOnWriteArrayList.append(localArrayList.size());
      QLog.d("VideoFilterTools", 2, paramCopyOnWriteArrayList.toString());
    }
    return localArrayList;
  }
  
  public static JSONArray a(List<FilterDesc> paramList)
  {
    localJSONArray = new JSONArray();
    try
    {
      paramList = paramList.iterator();
      Object localObject;
      while (paramList.hasNext())
      {
        localObject = (FilterDesc)paramList.next();
        JSONObject localJSONObject = new JSONObject();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((FilterDesc)localObject).id);
        localStringBuilder.append("");
        localJSONObject.put("filterid", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(((FilterDesc)localObject).type);
        localStringBuilder.append("");
        localJSONObject.put("type", localStringBuilder.toString());
        localJSONObject.put("name", ((FilterDesc)localObject).name);
        localJSONObject.put("respicname", ((FilterDesc)localObject).respicname);
        localJSONObject.put("version", ((FilterDesc)localObject).version);
        localJSONObject.put("md5", ((FilterDesc)localObject).resMD5);
        localJSONObject.put("resurl", ((FilterDesc)localObject).resurl);
        localJSONArray.put(localJSONObject);
      }
      return localJSONArray;
    }
    catch (Exception paramList)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("convertFilterDesc");
      ((StringBuilder)localObject).append(paramList.toString());
      QLog.w("VideoFilterTools", 2, ((StringBuilder)localObject).toString());
      paramList = new StringBuilder();
      paramList.append("convertFilterDesc json");
      paramList.append(localJSONArray.toString());
      QLog.w("VideoFilterTools", 2, paramList.toString());
    }
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    paramContext = new StringBuilder();
    paramContext.append("setQQShortVideoFilterConfigVersion:");
    paramContext.append(paramInt);
    UITools.a("VideoFilterTools", paramContext.toString());
    paramContext = BaseApplicationImpl.getApplication().getSharedPreferences("short_video_filter_config_sp", 4).edit();
    paramContext.putInt("dov_video_filter_config_version_775", paramInt);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (paramString == null)
    {
      UITools.a("VideoFilterTools", "updateQQShortVideoFilterConfig error ");
      return;
    }
    AEQLog.b("VideoFilterTools", "updateQQShortVideoFilterConfig");
    if (e(BaseApplicationImpl.getContext()))
    {
      f(BaseApplicationImpl.getContext());
      if (new File(m).exists()) {
        FileUtils.deleteDirectory(m);
      }
    }
    a(paramContext, paramString, c(paramContext));
    if (b(paramString)) {
      FileUtils.writeFile(CaptureVideoFilterManager.a, "filter_config_new.xml", paramString);
    }
  }
  
  static void a(Context paramContext, String paramString1, String paramString2)
  {
    long l1 = System.currentTimeMillis();
    Iterator localIterator = null;
    if ((paramString1 != null) && (!paramString1.equals(""))) {
      paramContext = c(paramString1);
    } else {
      paramContext = null;
    }
    paramString1 = localIterator;
    if (paramString2 != null)
    {
      paramString1 = localIterator;
      if (!paramString2.equals("")) {
        paramString1 = c(paramString2);
      }
    }
    if (paramContext == null)
    {
      FileUtils.deleteDirectory(CaptureVideoFilterManager.b);
    }
    else if (paramString1 != null)
    {
      paramString1 = paramString1.iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (FilterDesc)paramString1.next();
        localIterator = paramContext.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (FilterDesc)localIterator.next();
          if ((((FilterDesc)localObject).name != null) && (((FilterDesc)localObject).name.equals(paramString2.name)))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("compareContent res:");
            localStringBuilder.append(((FilterDesc)localObject).name);
            localStringBuilder.append("|");
            localStringBuilder.append(((FilterDesc)localObject).resMD5);
            localStringBuilder.append("|");
            localStringBuilder.append(paramString2.resMD5);
            UITools.a("VideoFilterTools", localStringBuilder.toString());
            if ((!TextUtils.isEmpty(((FilterDesc)localObject).resMD5)) && (!((FilterDesc)localObject).resMD5.equals(paramString2.resMD5)))
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("compareContentDelete res:");
              localStringBuilder.append(paramString2.getResFold(CaptureVideoFilterManager.b));
              UITools.a("VideoFilterTools", localStringBuilder.toString());
              FileUtils.deleteDirectory(paramString2.getResFold(CaptureVideoFilterManager.b));
            }
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("compareContent iconMD5:");
            localStringBuilder.append(((FilterDesc)localObject).name);
            localStringBuilder.append("|");
            localStringBuilder.append(((FilterDesc)localObject).iconMD5);
            localStringBuilder.append("|");
            localStringBuilder.append(paramString2.iconMD5);
            UITools.a("VideoFilterTools", localStringBuilder.toString());
            if ((!TextUtils.isEmpty(((FilterDesc)localObject).iconMD5)) && (!((FilterDesc)localObject).iconMD5.equals(paramString2.iconMD5)))
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("compareContentDelete iconMD5:");
              ((StringBuilder)localObject).append(paramString2.getIconFile(CaptureVideoFilterManager.b));
              UITools.a("VideoFilterTools", ((StringBuilder)localObject).toString());
              FileUtils.deleteFile(paramString2.getIconFile(CaptureVideoFilterManager.b));
            }
          }
        }
      }
    }
    long l2 = System.currentTimeMillis();
    paramContext = new StringBuilder();
    paramContext.append("compareContent :");
    paramContext.append(l2 - l1);
    UITools.a("VideoFilterTools", paramContext.toString());
  }
  
  public static void a(Context paramContext, List<QIMFilterCategoryItem> paramList)
  {
    if (!(paramContext instanceof EditPicActivity)) {
      return;
    }
    if (b(paramContext))
    {
      LightNode.initResourcePath(((IAEResUtil)QRoute.api(IAEResUtil.class)).getLightAssetsDir(), ((IAEResUtil)QRoute.api(IAEResUtil.class)).getLightEmptyMaterialConfigPath());
      QIMFilterCategoryItem localQIMFilterCategoryItem = new QIMFilterCategoryItem();
      localQIMFilterCategoryItem.j.add("AIFilter");
      localQIMFilterCategoryItem.a = "AIFilter";
      localQIMFilterCategoryItem.d = "https://downv6.qq.com/shadow_qqcamera/aio/editor/ai_thumb.jpg";
      localQIMFilterCategoryItem.b = paramContext.getResources().getString(2131886326);
      if (paramList.size() > 0) {
        paramList.add(1, localQIMFilterCategoryItem);
      }
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QIMRedDotConfig localQIMRedDotConfig = h;
      if ((localQIMRedDotConfig != null) && (localQIMRedDotConfig.update))
      {
        localQIMRedDotConfig = h;
        localQIMRedDotConfig.update = false;
        QIMRedDotConfig.saveRedDotConfig(localQIMRedDotConfig, CaptureVideoFilterManager.a);
      }
    }
    else
    {
      QIMRedDotConfig.saveRedDotConfig(h, CaptureVideoFilterManager.a);
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2, String paramString)
  {
    synchronized (i)
    {
      if (h == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QIMRedDotConfig_Filter", 2, "needShowRedDot|mQIMRedDotConfig is null");
        }
        return false;
      }
      boolean bool = h.needShowRedDot(paramInt1, paramInt2, paramString);
      if ((bool) && (QLog.isColorLevel()))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ShowRedDot==> type=");
        localStringBuilder.append(paramInt1);
        if (paramInt1 == 2)
        {
          localStringBuilder.append(",categoryId=");
          localStringBuilder.append(paramInt2);
        }
        else if (paramInt1 == 3)
        {
          localStringBuilder.append(",id=");
          localStringBuilder.append(paramString);
        }
        else if (paramInt1 == 4)
        {
          localStringBuilder.append(",defaultId=");
          localStringBuilder.append(h.defaultUseId);
        }
        else if (paramInt1 == 5)
        {
          localStringBuilder.append(",defaultCategoryId=");
          localStringBuilder.append(h.defaultCategoryId);
        }
        else if (paramInt1 == 7)
        {
          localStringBuilder.append(",comboDefaultCategoryId=");
          localStringBuilder.append(h.comboDefaultCategoryId);
        }
        QLog.d("QIMRedDotConfig_Filter", 2, localStringBuilder.toString());
      }
      return bool;
    }
  }
  
  public static void b(List<QIMFilterCategoryItem> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject1 = (QIMFilterCategoryItem)paramList.next();
        if (((QIMFilterCategoryItem)localObject1).j != null)
        {
          localObject1 = ((QIMFilterCategoryItem)localObject1).j.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (String)((Iterator)localObject1).next();
            localObject2 = a().a((String)localObject2);
            if ((localObject2 != null) && (QQAVImageFilterConstants.isMusicSpecialFilter(((FilterDesc)localObject2).id))) {
              paramList.remove();
            }
          }
        }
      }
    }
  }
  
  public static boolean b(Context paramContext)
  {
    Object localObject1 = new ArrayList();
    ((List)localObject1).add(AEResInfo.AE_RES_BASE_PACKAGE);
    ((List)localObject1).add(AEResInfo.LIGHT_RES_BASE_PACKAGE);
    ((List)localObject1).add(AEResInfo.LIGHT_RES_BUNDLE_GENDER);
    ((List)localObject1).add(AEResInfo.LIGHT_RES_BUNDLE_SCENE);
    localObject1 = ((List)localObject1).iterator();
    boolean bool1 = true;
    Object localObject2;
    StringBuilder localStringBuilder;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (AEResInfo)((Iterator)localObject1).next();
      if (((IAEResUtil)QRoute.api(IAEResUtil.class)).isAEResExist((AEResInfo)localObject2))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[handleDownloadAERes], resInfo=");
        localStringBuilder.append(localObject2);
        localStringBuilder.append(" local file exists");
        AEQLog.b("VideoFilterTools", localStringBuilder.toString());
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[handleDownloadAERes], resInfo=");
        localStringBuilder.append(localObject2);
        localStringBuilder.append(" start download");
        AEQLog.b("VideoFilterTools", localStringBuilder.toString());
        ((IAEResUtil)QRoute.api(IAEResUtil.class)).tryDownloadLightAdditionBundle(paramContext, ((AEResInfo)localObject2).resPrefix);
        bool1 = false;
      }
    }
    if (!((IAEPhotoAIManager)QRoute.api(IAEPhotoAIManager.class)).isPhotoAIResExist())
    {
      ((IAEPhotoAIManager)QRoute.api(IAEPhotoAIManager.class)).downloadPhotoAIRes();
      AEQLog.b("VideoFilterTools", "photo ai res not exist.");
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (bool1)
    {
      localObject1 = ShortVideoUtils.getPtvTemplateSDKPref();
      localObject2 = SdkContext.getInstance().getResources().getPtuFilterResource().getSoPathDir();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("initAEKit modelPath = ");
      localStringBuilder.append((String)localObject2);
      AEQLog.a("VideoFilterTools", localStringBuilder.toString());
      AEModule.initialize(paramContext, AEModuleConfig.newBuilder().setLoadSo(false).setModelDir((String)localObject2).setSoDir((String)localObject2).setAuthMode(1).setPreferences((SharedPreferences)localObject1).setEnableDebug(false).setFramebufferFetchEnable(false).setEnableResourceCheck(false).setEnableProfiler(false).setEnableDefaultBasic3(false).build());
      if (!FeatureManager.Features.LIGHT_SDK.isFunctionReady())
      {
        bool2 = FeatureManager.Features.LIGHT_SDK.init();
        paramContext = new StringBuilder();
        paramContext.append("load status: ");
        paramContext.append(bool2);
        AEQLog.b("VideoFilterTools", paramContext.toString());
        if (!bool2) {
          bool1 = false;
        }
      }
      else
      {
        AEQLog.d("VideoFilterTools", "init ready.");
      }
      if ((FeatureManager.Features.PTU_TOOLS.init()) && (FeatureManager.Features.PTU_ALGO.init()))
      {
        bool2 = bool1;
        if (FeatureManager.Features.IMAGE_ALGO.init()) {}
      }
      else
      {
        AEQLog.d("VideoFilterTools", "init failed.");
        bool2 = false;
      }
    }
    return bool2;
  }
  
  public static boolean b(String paramString)
  {
    label934:
    for (;;)
    {
      try
      {
        int i1;
        synchronized (i)
        {
          paramString = new JSONObject(paramString);
          if (h == null)
          {
            h = new QIMRedDotConfig(1);
            if (QLog.isColorLevel()) {
              QLog.d("QIMRedDotConfig_Filter", 2, "updateFromServer config is null");
            }
          }
          i1 = paramString.optInt("iconRedDotVersion");
          boolean bool = paramString.optBoolean("needRedDot");
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("updateFromServer oldVer=");
            ((StringBuilder)localObject2).append(h.iconVersion);
            ((StringBuilder)localObject2).append(",ver=");
            ((StringBuilder)localObject2).append(i1);
            ((StringBuilder)localObject2).append(",showRed ");
            ((StringBuilder)localObject2).append(bool);
            QLog.d("QIMRedDotConfig_Filter", 2, ((StringBuilder)localObject2).toString());
          }
          if (h.iconVersion != i1)
          {
            h.iconVersion = i1;
            h.showRedDot = bool;
            h.hasShow = false;
            h.firstShowTime = 0L;
          }
          i1 = paramString.optInt("combo_iconRedDotVersion");
          bool = paramString.optBoolean("combo_needRedDot");
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("updateFromServer combo oldVer=");
            ((StringBuilder)localObject2).append(h.comboIconVersion);
            ((StringBuilder)localObject2).append(",ver=");
            ((StringBuilder)localObject2).append(i1);
            ((StringBuilder)localObject2).append(",showRed ");
            ((StringBuilder)localObject2).append(bool);
            QLog.d("QIMRedDotConfig_Filter", 2, ((StringBuilder)localObject2).toString());
          }
          if (h.comboIconVersion != i1)
          {
            h.comboIconVersion = i1;
            h.comboShowRedDot = bool;
            h.comboHasShow = false;
            h.comboFirstShowTime = 0L;
          }
          i1 = paramString.optInt("combo_defaultCategoryVersion");
          int i2 = paramString.optInt("combo_defaultCategoryId", -1);
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("updateFromServer oldVer=");
            ((StringBuilder)localObject2).append(h.comboDefaultCategoryVer);
            ((StringBuilder)localObject2).append(",ver=");
            ((StringBuilder)localObject2).append(i1);
            ((StringBuilder)localObject2).append(",comboDefaultCategoryId ");
            ((StringBuilder)localObject2).append(i2);
            QLog.d("QIMRedDotConfig_Filter", 2, ((StringBuilder)localObject2).toString());
          }
          if (h.comboDefaultCategoryVer != i1)
          {
            h.comboDefaultCategoryVer = i1;
            h.comboDefaultCategoryId = i2;
            h.comboHasChoose = false;
          }
          i1 = paramString.optInt("defaultCategoryVersion");
          i2 = paramString.optInt("defaultCategoryId", -1);
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("updateFromServer oldVer=");
            ((StringBuilder)localObject2).append(h.defaultCategoryVer);
            ((StringBuilder)localObject2).append(",ver=");
            ((StringBuilder)localObject2).append(i1);
            ((StringBuilder)localObject2).append(",defaultCategoryId ");
            ((StringBuilder)localObject2).append(i2);
            QLog.d("QIMRedDotConfig_Filter", 2, ((StringBuilder)localObject2).toString());
          }
          if (h.defaultCategoryVer != i1)
          {
            h.defaultCategoryVer = i1;
            h.defaultCategoryId = i2;
            h.hasChoose = false;
          }
          i1 = paramString.optInt("defaultUseVersion");
          Object localObject2 = paramString.optString("defaultUseId");
          Object localObject3;
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("updateFromServer oldVer=");
            ((StringBuilder)localObject3).append(h.defaultUseVer);
            ((StringBuilder)localObject3).append(",ver=");
            ((StringBuilder)localObject3).append(i1);
            ((StringBuilder)localObject3).append(",defaultUseId ");
            ((StringBuilder)localObject3).append((String)localObject2);
            QLog.d("QIMRedDotConfig_Filter", 2, ((StringBuilder)localObject3).toString());
          }
          if (h.defaultUseVer != i1)
          {
            h.defaultUseVer = i1;
            h.defaultUseId = ((String)localObject2);
            h.hasUse = false;
          }
          i1 = paramString.optInt("itemRedDotVersion");
          if (h.redDotVersion != i1)
          {
            h.redDotVersion = i1;
            h.redDotItems.clear();
            if (paramString.has("itemNeedRedDot"))
            {
              paramString = paramString.getJSONArray("itemNeedRedDot");
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("updateFromServer redDotList: ");
              i1 = 0;
              if (i1 < paramString.length())
              {
                localObject3 = paramString.optString(i1);
                if (TextUtils.isEmpty((CharSequence)localObject3)) {
                  break label934;
                }
                QIMRedDotConfig.RedDotItemConfig localRedDotItemConfig = new QIMRedDotConfig.RedDotItemConfig();
                localRedDotItemConfig.filterId = ((String)localObject3);
                ((StringBuilder)localObject2).append((String)localObject3);
                ((StringBuilder)localObject2).append(",");
                h.redDotItems.put(localObject3, localRedDotItemConfig);
                break label934;
              }
              if (QLog.isColorLevel()) {
                QLog.d("QIMRedDotConfig_Filter", 2, ((StringBuilder)localObject2).toString());
              }
            }
          }
          a(false);
          if (QLog.isColorLevel()) {
            QLog.d("QCombo", 2, "updateComboConfig accept");
          }
          return true;
        }
        i1 += 1;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QIMRedDotConfig_Filter", 2, "updateRedDotConfigFromServer null", paramString);
        }
        if (QLog.isColorLevel()) {
          QLog.d("QCombo", 2, "updateRedDotConfigFromServer fail");
        }
        return false;
      }
    }
  }
  
  public static String c(Context paramContext)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(CaptureVideoFilterManager.a);
      ((StringBuilder)localObject).append("filter_config_new.xml");
      localObject = new File(((StringBuilder)localObject).toString());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getQQShortVideoFilterConfig:");
      localStringBuilder.append(CaptureVideoFilterManager.a);
      localStringBuilder.append("filter_config_new.xml");
      localStringBuilder.append("|");
      localStringBuilder.append(((File)localObject).exists());
      UITools.a("VideoFilterTools", localStringBuilder.toString());
      if (((File)localObject).exists()) {
        return FileUtils.readFileToString((File)localObject);
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
  
  static ArrayList<FilterDesc> c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      UITools.a("VideoFilterTools", "parseConfig|content is empty.");
      try
      {
        ArrayList localArrayList = FilterDesc.parse(new JSONObject(paramString).getJSONArray("filters"));
        paramString = localArrayList;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("parseConfig|parse failed.context = ");
        ((StringBuilder)localObject).append(paramString);
        UITools.a("VideoFilterTools", ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      paramString = null;
    }
    Object localObject = paramString;
    if (paramString == null) {
      localObject = new ArrayList();
    }
    return localObject;
  }
  
  public static int d(Context paramContext)
  {
    int i2 = BaseApplicationImpl.getApplication().getSharedPreferences("short_video_filter_config_sp", 4).getInt("dov_video_filter_config_version_775", 0);
    int i1 = i2;
    if (i2 > 0)
    {
      paramContext = new StringBuilder();
      paramContext.append(CaptureVideoFilterManager.a);
      paramContext.append("filter_config_new.xml");
      i1 = i2;
      if (!new File(paramContext.toString()).exists())
      {
        UITools.a("VideoFilterTools", "getQQShortVideoFilterConfigVersion config file don't exist!");
        i1 = 0;
      }
    }
    paramContext = new StringBuilder();
    paramContext.append("getQQShortVideoFilterConfigVersion:");
    paramContext.append(i1);
    UITools.a("VideoFilterTools", paramContext.toString());
    return i1;
  }
  
  public static String d(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      if (paramString.equals("")) {
        return paramString;
      }
      int i1 = paramString.lastIndexOf(".");
      int i2 = paramString.lastIndexOf(File.separator);
      if (i2 == -1)
      {
        if (i1 == -1) {
          return paramString;
        }
        return paramString.substring(0, i1);
      }
      if (i1 == -1) {
        return paramString.substring(i2 + 1);
      }
      if (i2 < i1) {
        return paramString.substring(i2 + 1, i1);
      }
      str = paramString.substring(i2 + 1);
    }
    return str;
  }
  
  public static boolean d()
  {
    if (w) {
      return v;
    }
    w = true;
    v = false;
    String str = Build.MODEL;
    if ((str.equals("ZTE BA610C")) || (str.equals("ZTE BA610T")) || (str.equals("vivo Y51A")) || (str.equals("vivo Y51")) || (str.equals("vivo Y37")) || (str.equals("OPPO A37t")) || (str.equals("OPPO A37m")) || (str.equals("SLA-TL10")) || (str.equals("SM-A5000")) || (str.equals("SM-A8000")) || (str.equals("HUAWEI GRA-TL00")) || (str.equals("OPPO A33m")) || (str.equals("OPPO A33")) || (str.equals("vivo X6A")) || (str.equals("CUN-AL00")) || (str.equals("Redmi 3")) || (str.equals("CAM-TL00")) || (str.equals("vivo Y35A")) || (str.equals("KIW-AL10")) || (str.equals("vivo Y31A")) || (str.equals("OPPO A53m")) || (str.equals("OPPO A53")) || (str.equals("OPPO R7sm")) || (str.equals("M6 Note")) || (str.equals("HUAWEI TIT-AL00")) || (str.equals("CUN-TL00")) || (str.equals("HUAWEI TIT-TL00")) || (str.equals("m2")))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("in TransitionBlackModel:");
        localStringBuilder.append(str);
        QLog.d("VideoFilterTools", 2, localStringBuilder.toString());
      }
      v = true;
    }
    return v;
  }
  
  public static void e()
  {
    if (h == null)
    {
      QIMRedDotConfig localQIMRedDotConfig = QIMRedDotConfig.getRedDotConfigFromFile(CaptureVideoFilterManager.a);
      if (localQIMRedDotConfig != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QIMRedDotConfig_Filter", 2, "VideoFilterTools reddot config init");
        }
        synchronized (i)
        {
          h = localQIMRedDotConfig;
          return;
        }
      }
    }
  }
  
  public static void e(String paramString)
  {
    if (paramString == null)
    {
      UITools.a("VideoFilterTools", "handleQQSvCommonConfig empty content!");
      return;
    }
    try
    {
      paramString = new JSONObject(paramString).getJSONObject("CommonConfig");
      if (paramString.getJSONObject("SvArtFilter") != null)
      {
        QmcfManager.getInstance().updateQmcfMainSwitch(paramString.getJSONObject("SvArtFilter"));
        return;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("VideoFilterTools", 2, "handleQQSvCommonConfig error!", paramString);
      }
    }
  }
  
  private static boolean e(Context paramContext)
  {
    paramContext = BaseApplicationImpl.getApplication().getSharedPreferences("short_video_filter_config_sp", 4);
    boolean bool = false;
    int i1 = paramContext.getInt("dov_video_filter_first_change_path", 0);
    paramContext = new StringBuilder();
    paramContext.append("getIsfisrtChangePath:");
    paramContext.append(i1);
    UITools.a("VideoFilterTools", paramContext.toString());
    if (i1 == 0) {
      bool = true;
    }
    return bool;
  }
  
  private static void f(Context paramContext)
  {
    paramContext = BaseApplicationImpl.getApplication().getSharedPreferences("short_video_filter_config_sp", 4).edit();
    paramContext.putInt("dov_video_filter_first_change_path", 1);
    paramContext.commit();
  }
  
  public static boolean l()
  {
    boolean bool2 = QmcfManager.getInstance().hasQmcfEntrance(1);
    boolean bool1 = bool2;
    if (bool2)
    {
      int i1 = QmcfDevicesStrategy.a();
      if (i1 > 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (!bool1)
      {
        QmcfManager.getInstance().setQmcfMobileNotSupport(QmcfDevicesStrategy.a);
        QLog.d("VideoFilterTools", 1, String.format("isArtFilterSupport supportFrameType[%d], gpuinfo[%s], model[%s]", new Object[] { Integer.valueOf(i1), QmcfDevicesStrategy.a, Build.MODEL }));
      }
    }
    return bool1;
  }
  
  private void m()
  {
    File localFile = new File(k);
    if (localFile.exists())
    {
      localFile.delete();
    }
    else
    {
      localObject1 = localFile.getParentFile();
      if (!((File)localObject1).exists()) {
        ((File)localObject1).mkdirs();
      }
    }
    Object localObject1 = LowLightTools.getLowLightImage(3.0F, 0.88F, 0.96F, 1.22F, false);
    try
    {
      localObject2 = new FileOutputStream(localFile);
      ((Bitmap)localObject1).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject2);
      ((FileOutputStream)localObject2).flush();
      ((FileOutputStream)localObject2).close();
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("LowLightTools saveBitmap:");
      ((StringBuilder)localObject2).append(localException);
      QLog.w("VideoFilterTools", 2, ((StringBuilder)localObject2).toString());
    }
    if (!localFile.exists())
    {
      l = A;
      return;
    }
    l = y;
  }
  
  public QIMFilterCategoryItem a(int paramInt)
  {
    return this.d[paramInt];
  }
  
  public FilterDesc a(String paramString)
  {
    return (FilterDesc)c.get(paramString);
  }
  
  public void a(Context paramContext, VideoFilterTools.OnResourceDownloadListener paramOnResourceDownloadListener, boolean paramBoolean)
  {
    try
    {
      CaptureComboManager localCaptureComboManager = (CaptureComboManager)QIMManager.a(5);
      paramContext = localCaptureComboManager.l;
      if (paramContext != null)
      {
        UITools.a("VideoFilterTools", "already inited");
      }
      else
      {
        UITools.a("VideoFilterTools", "initCaptureComboManager");
        if (!a(BaseApplicationImpl.sApplication)) {
          b();
        }
        paramContext = localCaptureComboManager.l;
      }
      if (paramContext != null) {
        paramContext = paramContext.b;
      } else {
        paramContext = new CopyOnWriteArrayList();
      }
      if (paramOnResourceDownloadListener != null) {
        paramOnResourceDownloadListener.h(false);
      }
      if (paramBoolean) {
        a(paramContext);
      }
      return;
    }
    finally {}
  }
  
  public void a(Bitmap paramBitmap)
  {
    Bitmap localBitmap = this.r;
    if (localBitmap != null)
    {
      localBitmap.recycle();
      this.r = null;
    }
    try
    {
      this.r = paramBitmap.copy(paramBitmap.getConfig(), true);
      return;
    }
    catch (Error paramBitmap)
    {
      if (QLog.isColorLevel())
      {
        QLog.e("VideoFilterTools", 2, new Object[] { "setRawBitmap error!", paramBitmap.toString() });
        return;
      }
    }
    catch (Exception paramBitmap)
    {
      if (QLog.isColorLevel()) {
        QLog.e("VideoFilterTools", 2, new Object[] { "setRawBitmap exception!", paramBitmap.toString() });
      }
    }
  }
  
  public void a(ComboSet paramComboSet, Activity paramActivity, int paramInt)
  {
    if (paramInt == 0)
    {
      paramActivity = this.e;
      paramActivity[2] = paramComboSet;
      paramActivity[1] = paramComboSet;
    }
    else if (paramInt == -1)
    {
      return;
    }
    this.e[paramInt] = paramComboSet;
  }
  
  public void a(QIMFilterCategoryItem paramQIMFilterCategoryItem, int paramInt)
  {
    this.g[paramInt] = paramQIMFilterCategoryItem;
  }
  
  public void a(QIMFilterCategoryItem paramQIMFilterCategoryItem, Activity paramActivity, int paramInt)
  {
    if (paramInt == 0)
    {
      paramActivity = this.d;
      paramActivity[2] = paramQIMFilterCategoryItem;
      paramActivity[1] = paramQIMFilterCategoryItem;
    }
    else if (paramInt == -1)
    {
      return;
    }
    QIMFilterCategoryItem localQIMFilterCategoryItem = this.d[paramInt];
    paramActivity = paramQIMFilterCategoryItem;
    if (localQIMFilterCategoryItem != null)
    {
      paramActivity = paramQIMFilterCategoryItem;
      if (paramQIMFilterCategoryItem != null)
      {
        paramActivity = paramQIMFilterCategoryItem;
        if (TextUtils.equals(localQIMFilterCategoryItem.a, paramQIMFilterCategoryItem.a)) {
          paramActivity = localQIMFilterCategoryItem;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramQIMFilterCategoryItem = new StringBuilder();
      paramQIMFilterCategoryItem.append("setSelectedCombo last:");
      paramQIMFilterCategoryItem.append(localQIMFilterCategoryItem);
      paramQIMFilterCategoryItem.append(" new:");
      paramQIMFilterCategoryItem.append(paramActivity);
      paramQIMFilterCategoryItem.append(", ");
      paramQIMFilterCategoryItem.append(paramInt);
      QLog.i("QCombo", 2, paramQIMFilterCategoryItem.toString());
    }
    this.d[paramInt] = paramActivity;
    if ((paramActivity != null) && (!paramActivity.c())) {
      b(3, paramActivity.e, paramActivity.a);
    }
  }
  
  public void a(TransitionCategoryItem paramTransitionCategoryItem)
  {
    this.u = paramTransitionCategoryItem;
  }
  
  public void a(EditVideoPartManager paramEditVideoPartManager)
  {
    this.q = paramEditVideoPartManager;
  }
  
  public void a(PublishVideoEntry paramPublishVideoEntry)
  {
    QLog.w("VideoFilterTools", 2, "saveRenderManagerData begin");
    if (paramPublishVideoEntry != null)
    {
      Object localObject = QQFilterRenderManagerHolder.a(QQFilterRenderManagerHolder.c);
      if (localObject != null)
      {
        List localList = ((QQFilterRenderManager)localObject).getBusinessOperation().getCurrentAVFilterIdList();
        if ((localList != null) && (localList.size() > 0))
        {
          paramPublishVideoEntry.putExtra("hasAVFilter", Boolean.valueOf(true));
          paramPublishVideoEntry.putExtra("jsonAVFilterData", a(localList));
          localObject = ((QQFilterRenderManager)localObject).getBusinessOperation().getMusicItemInfo();
          if (localObject != null) {
            paramPublishVideoEntry.putExtra("jsonMusicData", ((MusicItemInfo)localObject).convertToJSON());
          }
        }
      }
    }
  }
  
  public void a(FilterDesc paramFilterDesc)
  {
    if (paramFilterDesc != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setCurrentId id: ");
      localStringBuilder.append(paramFilterDesc.id);
      UITools.a("VideoFilterTools", localStringBuilder.toString());
    }
    else
    {
      UITools.a("VideoFilterTools", "setCurrentId null");
    }
    this.b = paramFilterDesc;
  }
  
  void a(CopyOnWriteArrayList<FilterCategory> paramCopyOnWriteArrayList)
  {
    if ((paramCopyOnWriteArrayList != null) && (paramCopyOnWriteArrayList.size() != 0))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(" preDownloadResource Categorylist size: ");
      ((StringBuilder)localObject1).append(paramCopyOnWriteArrayList.size());
      UITools.a("VideoFilterTools", ((StringBuilder)localObject1).toString());
      localObject1 = (CaptureComboManager)QIMManager.a(5);
      paramCopyOnWriteArrayList = paramCopyOnWriteArrayList.iterator();
      while (paramCopyOnWriteArrayList.hasNext())
      {
        Object localObject2 = (FilterCategory)paramCopyOnWriteArrayList.next();
        if (!((FilterCategory)localObject2).d)
        {
          localObject2 = ((FilterCategory)localObject2).c.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            FilterSet localFilterSet = ((CaptureComboManager)localObject1).b((QIMFilterCategoryItem)((Iterator)localObject2).next());
            if ((localFilterSet.i()) && (localFilterSet.c() == 2)) {
              localFilterSet.d();
            }
          }
        }
      }
      return;
    }
    UITools.a("VideoFilterTools", "preDownloadResource list is empty!");
  }
  
  public boolean a(Context paramContext)
  {
    e();
    paramContext = c(paramContext);
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (!TextUtils.isEmpty(paramContext))
      {
        paramContext = new VideoFilterTools.ComboFilterData(paramContext);
        ((CaptureComboManager)QIMManager.a(5)).a(paramContext);
        bool1 = paramContext.b.isEmpty();
        bool1 ^= true;
      }
    }
    catch (Exception paramContext)
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.i("VideoFilterTools", 2, "initFromCache", paramContext);
        bool1 = bool2;
      }
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("initFromCache ");
      paramContext.append(bool1);
      QLog.i("VideoFilterTools", 2, paramContext.toString());
    }
    return bool1;
  }
  
  public QIMFilterCategoryItem b(int paramInt)
  {
    return this.f[paramInt];
  }
  
  public void b(int paramInt1, int paramInt2, String paramString)
  {
    synchronized (i)
    {
      if (h == null) {
        return;
      }
      if ((h.updateRedDotInfo(paramInt1, paramInt2, paramString)) && (QLog.isColorLevel()))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateRedDotInfo==> type=");
        localStringBuilder.append(paramInt1);
        if (paramInt1 == 2)
        {
          localStringBuilder.append(",categoryId=");
          localStringBuilder.append(paramInt2);
        }
        else if (paramInt1 == 3)
        {
          localStringBuilder.append(",id=");
          localStringBuilder.append(paramString);
        }
        else if (paramInt1 == 4)
        {
          localStringBuilder.append(",defaultId=");
          localStringBuilder.append(h.defaultUseId);
        }
        else if (paramInt1 == 5)
        {
          localStringBuilder.append(",defaultCategoryId=");
          localStringBuilder.append(h.defaultCategoryId);
        }
        else if (paramInt1 == 7)
        {
          localStringBuilder.append(",comboDefaultCategoryId=");
          localStringBuilder.append(h.comboDefaultCategoryId);
        }
        QLog.d("QIMRedDotConfig_Filter", 2, localStringBuilder.toString());
      }
      return;
    }
  }
  
  public void b(QIMFilterCategoryItem paramQIMFilterCategoryItem, Activity paramActivity, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("setSelectedFilter ");
      paramActivity.append(paramQIMFilterCategoryItem);
      paramActivity.append(" scene ");
      paramActivity.append(paramInt);
      QLog.d("QCombo", 2, paramActivity.toString());
    }
    if (paramInt == -1) {
      return;
    }
    Object localObject = this.f;
    paramActivity = localObject[paramInt];
    localObject[paramInt] = paramQIMFilterCategoryItem;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setSelectedFilter last:");
      ((StringBuilder)localObject).append(paramActivity);
      QLog.i("QCombo", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramQIMFilterCategoryItem != null) && (!paramQIMFilterCategoryItem.c())) {
      b(3, paramQIMFilterCategoryItem.e, paramQIMFilterCategoryItem.a);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }
  
  public boolean b()
  {
    e();
    Object localObject = QIMFileUtils.a("filter_template.cfg");
    boolean bool;
    try
    {
      localObject = new VideoFilterTools.ComboFilterData((String)localObject);
      ((CaptureComboManager)QIMManager.a(5)).a((VideoFilterTools.ComboFilterData)localObject);
      bool = true;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("initFromAsset ");
        localStringBuilder2.append(false);
        QLog.i("VideoFilterTools", 2, localStringBuilder2.toString(), localException);
      }
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("initFromAsset ");
      localStringBuilder1.append(bool);
      QLog.i("VideoFilterTools", 2, localStringBuilder1.toString());
    }
    return bool;
  }
  
  public QIMFilterCategoryItem c(int paramInt)
  {
    return this.g[paramInt];
  }
  
  public TransitionCategoryItem c()
  {
    return this.u;
  }
  
  public void d(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setFrontCaptureScene ");
      localStringBuilder.append(paramInt);
      QLog.d("QCombo", 2, localStringBuilder.toString());
    }
    this.p = paramInt;
  }
  
  public int f()
  {
    synchronized (i)
    {
      if ((h != null) && (!h.hasChoose))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getDefaultCategoryId=");
          localStringBuilder.append(h.defaultCategoryId);
          QLog.d("QIMRedDotConfig_Filter", 2, localStringBuilder.toString());
        }
        int i1 = h.defaultCategoryId;
        return i1;
      }
      return -1;
    }
  }
  
  public int g()
  {
    synchronized (i)
    {
      if ((h != null) && (!h.comboHasChoose))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getDefaultComboCategoryId=");
          localStringBuilder.append(h.comboDefaultCategoryId);
          QLog.d("QIMRedDotConfig_Filter", 2, localStringBuilder.toString());
        }
        int i1 = h.comboDefaultCategoryId;
        return i1;
      }
      return -1;
    }
  }
  
  public void h()
  {
    this.q = null;
    Bitmap localBitmap = this.r;
    if (localBitmap != null)
    {
      localBitmap.recycle();
      this.r = null;
    }
  }
  
  public EditVideoPartManager i()
  {
    return this.q;
  }
  
  public Bitmap j()
  {
    Bitmap localBitmap = this.r;
    if ((localBitmap == null) || (localBitmap.isRecycled()))
    {
      localBitmap = null;
      EditVideoPartManager localEditVideoPartManager = this.q;
      if (localEditVideoPartManager != null) {
        localBitmap = localEditVideoPartManager.H();
      }
      if (localBitmap != null) {
        this.r = localBitmap.copy(localBitmap.getConfig(), true);
      }
    }
    return this.r;
  }
  
  public boolean k()
  {
    return this.s;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools
 * JD-Core Version:    0.7.0.1
 */