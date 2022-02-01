package com.tencent.aelight.camera.ae.data;

import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.tencent.aelight.camera.ae.AEPath.CAMERA.FILES;
import com.tencent.aelight.camera.ae.config.CameraOperationHelper;
import com.tencent.aelight.camera.ae.control.AEQIMAsyncManager;
import com.tencent.aelight.camera.ae.download.AEDownloadMaterialRunnable;
import com.tencent.aelight.camera.ae.download.AEMaterialDownloader;
import com.tencent.aelight.camera.ae.download.AEMaterialDownloader.MaterialDownloadListener;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.aioeditor.capture.music.CaptureConfigUpdateObserver;
import com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.struct.camera.AEMaterialOnShow;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.common.Observable;
import com.tencent.mobileqq.shortvideo.common.Observer;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.device.GpuScopeAttrs;
import com.tencent.ttpic.baseutils.device.GpuScopeAttrs.GpuBean.DeviceModel;
import com.tencent.ttpic.device.DeviceUtils;
import com.tencent.ttpic.openapi.initializer.Ace3DEngineInitializer;
import com.tencent.ttpic.openapi.initializer.LightSdkInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.util.GsonUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class AEMaterialManager
  extends AEQIMAsyncManager
{
  public static volatile boolean a = false;
  public static volatile boolean b = false;
  private static AEMaterialMetaData s;
  private static AEMaterialMetaData t;
  private Observable c;
  private AEMaterialCategory d = new AEMaterialCategory(r());
  private AEMaterialCategory e;
  private volatile boolean f = false;
  private final List<AEMaterialCategory> g = new CopyOnWriteArrayList();
  private final List<AEMaterialCategory> h = new CopyOnWriteArrayList();
  private final List<AEMaterialCategory> i = new ArrayList();
  private final List<AEMaterialCategory> j = new ArrayList();
  private final List<AEMaterialMetaData> k = new ArrayList();
  private final List<AEMaterialMetaData> l = new ArrayList();
  private final Object m = new Object();
  private final Object n = new Object();
  private final Object o = new Object();
  private final Object p = new Object();
  private String q = "";
  private final AtomicBoolean r = new AtomicBoolean(false);
  
  public AEMaterialManager()
  {
    this.d.a = new ArrayList(100);
    this.e = new AEMaterialCategory(r());
    this.e.a = new ArrayList(100);
  }
  
  private void A()
  {
    if (getApp() != null) {
      getApp().notifyObservers(CaptureConfigUpdateObserver.class, 3, true, null);
    }
    Observable localObservable = this.c;
    if (localObservable != null) {
      localObservable.a(116, new Object[0]);
    }
  }
  
  private void B()
  {
    Observable localObservable = this.c;
    if (localObservable != null) {
      localObservable.a(111, new Object[] { this.d });
    }
  }
  
  private void C()
  {
    Observable localObservable = this.c;
    if (localObservable != null) {
      localObservable.a(111, new Object[] { this.e });
    }
  }
  
  private boolean D()
  {
    AEMaterialCategory localAEMaterialCategory = this.d;
    return (localAEMaterialCategory != null) && (localAEMaterialCategory.a.size() >= 100);
  }
  
  private boolean E()
  {
    AEMaterialCategory localAEMaterialCategory = this.e;
    return (localAEMaterialCategory != null) && (localAEMaterialCategory.a != null) && (this.e.a.size() >= 100);
  }
  
  @Nullable
  public static String a(@Nullable ArrayList<AEMaterialOnShow> paramArrayList)
  {
    if (paramArrayList != null) {
      return GsonUtils.obj2Json(paramArrayList);
    }
    return null;
  }
  
  private List<AEMaterialCategory> a(File paramFile)
  {
    ArrayList localArrayList = new ArrayList();
    paramFile = QIMPtvTemplateManager.a(paramFile);
    if (TextUtils.isEmpty(paramFile)) {
      return localArrayList;
    }
    paramFile = AEMaterialConfigParser.a(paramFile);
    if (paramFile != null)
    {
      if (paramFile.isEmpty()) {
        return localArrayList;
      }
      return paramFile;
    }
    return localArrayList;
  }
  
  private List<AEMaterialCategory> a(File paramFile1, File paramFile2)
  {
    paramFile1 = a(paramFile1);
    List localList = a(paramFile2);
    if (localList != null)
    {
      if (localList.isEmpty()) {
        return paramFile1;
      }
      Iterator localIterator1 = paramFile1.iterator();
      label228:
      while (localIterator1.hasNext())
      {
        paramFile2 = (AEMaterialCategory)localIterator1.next();
        Iterator localIterator2 = localList.iterator();
        while (localIterator2.hasNext())
        {
          paramFile1 = (AEMaterialCategory)localIterator2.next();
          if (paramFile1.d.equals(paramFile2.d)) {
            break label104;
          }
        }
        paramFile1 = null;
        label104:
        if (paramFile1 == null)
        {
          paramFile1 = paramFile2.a.iterator();
          while (paramFile1.hasNext()) {
            e((AEMaterialMetaData)paramFile1.next());
          }
        }
        else
        {
          localIterator2 = paramFile2.a.iterator();
          while (localIterator2.hasNext())
          {
            AEMaterialMetaData localAEMaterialMetaData = (AEMaterialMetaData)localIterator2.next();
            Iterator localIterator3 = paramFile1.a.iterator();
            while (localIterator3.hasNext())
            {
              paramFile2 = (AEMaterialMetaData)localIterator3.next();
              if (localAEMaterialMetaData.m.equals(paramFile2.m)) {
                break label228;
              }
            }
            paramFile2 = null;
            if (paramFile2 == null) {
              e(localAEMaterialMetaData);
            } else if (!localAEMaterialMetaData.s.equals(paramFile2.s)) {
              e(localAEMaterialMetaData);
            }
          }
        }
      }
      return localList;
    }
    return paramFile1;
  }
  
  private List<AEMaterialMetaData> a(List<AEMaterialMetaData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    int i1 = 0;
    while (paramList.hasNext())
    {
      AEMaterialMetaData localAEMaterialMetaData = (AEMaterialMetaData)paramList.next();
      if (((!localAEMaterialMetaData.m.contains("_3DFaceFila")) || (Ace3DEngineInitializer.supportAceEngine())) && ((!localAEMaterialMetaData.m.contains("_haircolor")) || ((DeviceUtils.hasDeviceNormal(BaseApplicationImpl.getContext())) && ((GpuScopeAttrs.getInstance().getDeviceModel() == null) || (GpuScopeAttrs.getInstance().getDeviceModel().hairColor)))))
      {
        if (i1 >= 10) {
          break;
        }
        localArrayList.add(localAEMaterialMetaData);
        i1 += 1;
      }
    }
    return localArrayList;
  }
  
  private List<AEMaterialMetaData> a(List<AEMaterialCategory> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.n;
    if (paramList != null) {}
    try
    {
      if (paramList.size() > paramInt)
      {
        paramList = (AEMaterialCategory)paramList.get(paramInt);
        if (paramList != null)
        {
          localArrayList.addAll(paramList.a);
          if ((localArrayList.size() > 0) && (((AEMaterialMetaData)localArrayList.get(0)).equals(AEMaterialMetaData.l))) {
            localArrayList.remove(0);
          }
        }
      }
      return new ArrayList(localArrayList);
    }
    finally {}
  }
  
  private List<AEMaterialMetaData> a(List<AEMaterialCategory> paramList, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.o)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        AEMaterialCategory localAEMaterialCategory = (AEMaterialCategory)paramList.next();
        if (localAEMaterialCategory.d.equals(paramString))
        {
          localArrayList.addAll(localAEMaterialCategory.a);
          if ((localArrayList.size() > 0) && (((AEMaterialMetaData)localArrayList.get(0)).equals(AEMaterialMetaData.l))) {
            localArrayList.remove(0);
          }
        }
      }
      return new ArrayList(localArrayList);
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  private boolean a(AEMaterialCategory paramAEMaterialCategory)
  {
    if (paramAEMaterialCategory == null) {
      return false;
    }
    if (paramAEMaterialCategory.b == 30000) {
      return true;
    }
    return paramAEMaterialCategory.g ^ true;
  }
  
  public static boolean a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (paramAEMaterialMetaData != null) {
      try
      {
        if (!TextUtils.isEmpty(paramAEMaterialMetaData.t))
        {
          boolean bool = g(paramAEMaterialMetaData);
          return bool;
        }
      }
      finally {}
    }
    return false;
  }
  
  public static boolean a(VideoMaterial paramVideoMaterial)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    if ((paramVideoMaterial != null) && (paramVideoMaterial.getLightAsset() != null))
    {
      bool1 = bool2;
      if (!paramVideoMaterial.needHandDetect())
      {
        bool1 = bool2;
        if (!paramVideoMaterial.needDetectGender())
        {
          bool1 = bool2;
          if (!paramVideoMaterial.needDetectCat())
          {
            bool1 = bool2;
            if (!paramVideoMaterial.needRGBDepth())
            {
              bool1 = bool2;
              if (!paramVideoMaterial.needHairSegment())
              {
                bool1 = bool2;
                if (!paramVideoMaterial.needSkySegment())
                {
                  bool1 = bool2;
                  if (!paramVideoMaterial.needAce3D())
                  {
                    bool1 = bool2;
                    if (!paramVideoMaterial.need3DMM())
                    {
                      bool1 = bool2;
                      if (!paramVideoMaterial.needHeadSegment())
                      {
                        bool1 = bool2;
                        if (!paramVideoMaterial.needBodyDetect())
                        {
                          bool1 = bool2;
                          if (!paramVideoMaterial.needGazeDetect())
                          {
                            if (paramVideoMaterial.needBodySegment()) {
                              return true;
                            }
                            bool1 = false;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      return bool1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("material is null: ");
    if (paramVideoMaterial != null) {
      bool1 = false;
    }
    localStringBuilder.append(bool1);
    AEQLog.d("AEMaterialManager", localStringBuilder.toString());
    return false;
  }
  
  private int b(List<AEMaterialMetaData> paramList, String paramString)
  {
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        return -1;
      }
      int i1 = 0;
      while (i1 < paramList.size())
      {
        if (((AEMaterialMetaData)paramList.get(i1)).m.equals(paramString)) {
          return i1;
        }
        i1 += 1;
      }
    }
    return -1;
  }
  
  private HashMap<String, AEMaterialCategory> b(@Nullable AEMaterialCategory paramAEMaterialCategory)
  {
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getSpecificCategory: item.name = ");
    if (paramAEMaterialCategory == null) {
      localObject1 = "null";
    } else {
      localObject1 = paramAEMaterialCategory.d;
    }
    ((StringBuilder)localObject2).append((String)localObject1);
    AEQLog.a("AEMaterialManager", ((StringBuilder)localObject2).toString());
    Object localObject1 = new HashMap();
    localObject2 = new AEMaterialCategory();
    AEMaterialCategory localAEMaterialCategory = new AEMaterialCategory();
    if ((paramAEMaterialCategory != null) && (paramAEMaterialCategory.a != null))
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = paramAEMaterialCategory.a.iterator();
      while (localIterator.hasNext())
      {
        AEMaterialMetaData localAEMaterialMetaData = (AEMaterialMetaData)localIterator.next();
        if ("circleCamera".equals(localAEMaterialMetaData.O)) {
          localArrayList2.add(localAEMaterialMetaData);
        } else {
          localArrayList1.add(localAEMaterialMetaData);
        }
      }
      ((AEMaterialCategory)localObject2).a = localArrayList1;
      ((AEMaterialCategory)localObject2).b = paramAEMaterialCategory.b;
      ((AEMaterialCategory)localObject2).d = paramAEMaterialCategory.d;
      ((AEMaterialCategory)localObject2).c = paramAEMaterialCategory.c;
      ((AEMaterialCategory)localObject2).f = paramAEMaterialCategory.f;
      ((AEMaterialCategory)localObject2).e = paramAEMaterialCategory.e;
      localAEMaterialCategory.a = localArrayList2;
      localAEMaterialCategory.b = paramAEMaterialCategory.b;
      localAEMaterialCategory.d = paramAEMaterialCategory.d;
      localAEMaterialCategory.c = paramAEMaterialCategory.c;
      localAEMaterialCategory.f = paramAEMaterialCategory.f;
      localAEMaterialCategory.e = paramAEMaterialCategory.e;
      ((HashMap)localObject1).put("normal_material", localObject2);
      ((HashMap)localObject1).put("circle_material", localAEMaterialCategory);
      return localObject1;
    }
    AEQLog.d("AEMaterialManager", "getSpecificCategory: item.materialList == null!");
    ((HashMap)localObject1).put("normal_material", localObject2);
    ((HashMap)localObject1).put("circle_material", localAEMaterialCategory);
    return localObject1;
  }
  
  private void b(AppInterface paramAppInterface, String paramString, AEMaterialMetaData paramAEMaterialMetaData, AEMaterialDownloader.MaterialDownloadListener paramMaterialDownloadListener)
  {
    AEMaterialDownloader.a(paramAppInterface, paramAEMaterialMetaData, paramString, new AEMaterialManager.4(this, paramMaterialDownloadListener));
    paramString = new StringBuilder();
    paramString.append("【START】startDownloadMaterial :");
    if (paramAEMaterialMetaData == null) {
      paramAppInterface = "null";
    } else {
      paramAppInterface = paramAEMaterialMetaData.m;
    }
    paramString.append(paramAppInterface);
    AEQLog.b("AEMaterialManager", paramString.toString());
  }
  
  @Nullable
  public static ArrayList<AEMaterialOnShow> c(@Nullable String paramString)
  {
    return (ArrayList)GsonUtils.json2Obj(paramString, new AEMaterialManager.2().getType());
  }
  
  private AEMaterialMetaData d(String paramString)
  {
    synchronized (this.g)
    {
      Object localObject = this.h.iterator();
      AEMaterialMetaData localAEMaterialMetaData;
      do
      {
        Iterator localIterator;
        while (!localIterator.hasNext())
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localIterator = ((AEMaterialCategory)((Iterator)localObject).next()).a.iterator();
        }
        localAEMaterialMetaData = (AEMaterialMetaData)localIterator.next();
      } while (!localAEMaterialMetaData.m.equals(paramString));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getNormalStickerMaterial---found id=");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("AEMaterialManager", 2, ((StringBuilder)localObject).toString());
      }
      return localAEMaterialMetaData;
      return null;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  private AEMaterialMetaData e(String paramString)
  {
    synchronized (this.g)
    {
      Object localObject = this.i.iterator();
      AEMaterialMetaData localAEMaterialMetaData;
      do
      {
        Iterator localIterator;
        while (!localIterator.hasNext())
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localIterator = ((AEMaterialCategory)((Iterator)localObject).next()).a.iterator();
        }
        localAEMaterialMetaData = (AEMaterialMetaData)localIterator.next();
      } while (!localAEMaterialMetaData.m.equals(paramString));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getCircleStickerMaterial---found id=");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("AEMaterialManager", 2, ((StringBuilder)localObject).toString());
      }
      return localAEMaterialMetaData;
      return null;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  private void e(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("deleteMaterialFolder: ");
      ((StringBuilder)localObject).append(paramAEMaterialMetaData.m);
      QLog.d("AEMaterialManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new File(AEPath.CAMERA.FILES.i, paramAEMaterialMetaData.m);
    if (((File)localObject).exists()) {
      FileUtils.deleteDirectory(((File)localObject).getPath());
    }
    paramAEMaterialMetaData = new File(AEPath.CAMERA.FILES.h, paramAEMaterialMetaData.m);
    if (paramAEMaterialMetaData.exists()) {
      FileUtils.deleteDirectory(paramAEMaterialMetaData.getPath());
    }
  }
  
  @WorkerThread
  private void e(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("initMaterialList enter---forceRefresh=");
      ((StringBuilder)???).append(paramBoolean);
      QLog.d("AEMaterialManager", 2, ((StringBuilder)???).toString());
    }
    try
    {
      if ((this.f) && (!paramBoolean))
      {
        AEQLog.b("AEMaterialManager", "initMaterialList---has inited, fast return");
        return;
      }
      this.f = true;
      ??? = new StringBuilder();
      ((StringBuilder)???).append("filament isSupport: ");
      ((StringBuilder)???).append(m());
      AEQLog.b("AEMaterialManager", ((StringBuilder)???).toString());
      synchronized (this.p)
      {
        Object localObject3 = s();
        if ((localObject3 != null) && (!((List)localObject3).isEmpty())) {
          synchronized (this.o)
          {
            this.g.clear();
            this.h.clear();
            this.i.clear();
            this.j.clear();
            this.g.addAll((Collection)localObject3);
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              AEMaterialCategory localAEMaterialCategory = (AEMaterialCategory)((Iterator)localObject3).next();
              if ((localAEMaterialCategory != null) && (localAEMaterialCategory.a != null) && (!localAEMaterialCategory.a.isEmpty()))
              {
                Object localObject7 = localAEMaterialCategory.a.iterator();
                Object localObject8;
                while (((Iterator)localObject7).hasNext())
                {
                  localObject8 = (AEMaterialMetaData)((Iterator)localObject7).next();
                  if (localObject8 != null) {
                    ((AEMaterialMetaData)localObject8).A = a((AEMaterialMetaData)localObject8);
                  }
                }
                if (a(localAEMaterialCategory))
                {
                  this.j.add(localAEMaterialCategory);
                }
                else
                {
                  localObject7 = b(localAEMaterialCategory);
                  localAEMaterialCategory = (AEMaterialCategory)((HashMap)localObject7).get("normal_material");
                  localObject7 = (AEMaterialCategory)((HashMap)localObject7).get("circle_material");
                  if ((localObject7 != null) && (((AEMaterialCategory)localObject7).a != null) && (((AEMaterialCategory)localObject7).a.size() > 0))
                  {
                    localObject8 = new StringBuilder();
                    ((StringBuilder)localObject8).append("initMaterialList: circleCategory = ");
                    ((StringBuilder)localObject8).append(localObject7.toString());
                    AEQLog.a("AEMaterialManager", ((StringBuilder)localObject8).toString());
                    this.i.add(localObject7);
                  }
                  if ((localAEMaterialCategory != null) && (localAEMaterialCategory.a != null) && (localAEMaterialCategory.a.size() > 0)) {
                    this.h.add(localAEMaterialCategory);
                  }
                }
              }
            }
            x();
            y();
            synchronized (this.o)
            {
              if ((this.h.size() > 0) && (!r().equals(((AEMaterialCategory)this.h.get(0)).d))) {
                this.h.add(0, this.d);
              }
              if ((this.i.size() > 0) && (!r().equals(((AEMaterialCategory)this.i.get(0)).d))) {
                this.i.add(0, this.e);
              }
              w();
              if (QLog.isColorLevel())
              {
                long l2 = System.currentTimeMillis();
                ??? = new StringBuilder();
                ((StringBuilder)???).append("initMaterialList exit, cost = ");
                ((StringBuilder)???).append(l2 - l1);
                ((StringBuilder)???).append("ms");
                QLog.d("AEMaterialManager", 2, ((StringBuilder)???).toString());
              }
              A();
              return;
            }
          }
        }
        AEQLog.d("AEMaterialManager", "initMaterialList: materials is empty !");
        return;
      }
      throw localObject2;
    }
    finally {}
    for (;;) {}
  }
  
  private AEMaterialMetaData f(AEMaterialMetaData paramAEMaterialMetaData)
  {
    Iterator localIterator1 = this.g.iterator();
    Object localObject1 = null;
    Object localObject2;
    int i1;
    do
    {
      do
      {
        localObject2 = localObject1;
        if (!localIterator1.hasNext()) {
          break;
        }
        localObject2 = (AEMaterialCategory)localIterator1.next();
      } while (((AEMaterialCategory)localObject2).a == null);
      int i2 = 0;
      Iterator localIterator2 = ((AEMaterialCategory)localObject2).a.iterator();
      do
      {
        localObject2 = localObject1;
        i1 = i2;
        if (!localIterator2.hasNext()) {
          break;
        }
        localObject2 = (AEMaterialMetaData)localIterator2.next();
      } while (!((AEMaterialMetaData)localObject2).equals(paramAEMaterialMetaData));
      i1 = 1;
      localObject1 = localObject2;
    } while (i1 == 0);
    return localObject2;
  }
  
  private static boolean g(AEMaterialMetaData paramAEMaterialMetaData)
  {
    Object localObject = paramAEMaterialMetaData.e();
    File localFile1 = new File((String)localObject, "params.json");
    localObject = new File((String)localObject, "params.dat");
    if ((!localFile1.exists()) && (!((File)localObject).exists())) {
      try
      {
        File localFile2 = new File(paramAEMaterialMetaData.g());
        if (!localFile2.exists()) {
          return false;
        }
        ZipUtils.unZipFile(localFile2, paramAEMaterialMetaData.f());
        return true;
      }
      catch (Exception paramAEMaterialMetaData)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AEMaterialManager", 2, "judgeTemplateUsable unZipFile exp:", paramAEMaterialMetaData);
        }
        if (!localFile1.exists()) {
          return ((File)localObject).exists();
        }
      }
    }
    return true;
  }
  
  public static boolean j()
  {
    AEMaterialMetaData localAEMaterialMetaData = n();
    return (localAEMaterialMetaData != null) && (!localAEMaterialMetaData.equals(AEMaterialMetaData.l)) && (localAEMaterialMetaData.M != 0);
  }
  
  public static boolean m()
  {
    try
    {
      boolean bool = FeatureManager.Features.LIGHT_SDK.supportAceEngine();
      return bool;
    }
    catch (Exception localException)
    {
      label9:
      break label9;
    }
    return false;
  }
  
  public static AEMaterialMetaData n()
  {
    return s;
  }
  
  public static AEMaterialMetaData o()
  {
    return t;
  }
  
  public static String p()
  {
    File localFile = new File(AEPath.CAMERA.FILES.j);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return new File(localFile.getPath(), "camera_story_update_template.json").getPath();
  }
  
  public static String q()
  {
    File localFile = new File(AEPath.CAMERA.FILES.h);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile.getPath();
  }
  
  private String r()
  {
    return HardCodeUtil.a(2131907501);
  }
  
  private List<AEMaterialCategory> s()
  {
    File localFile = new File(AEPath.CAMERA.FILES.j, "camera_story_update_template.json");
    Object localObject = new File(AEPath.CAMERA.FILES.j, "camera_story_default_template.json");
    List localList1;
    List localList2;
    if (!localFile.exists())
    {
      if (!((File)localObject).exists())
      {
        localList1 = z();
        AEQLog.a("AEMaterialManager", "readAndParseConfigFile -> oldJson not exist, newJson not exist, use Json from assets ");
        t();
        return localList1;
      }
      try
      {
        localList1 = a((File)localObject);
        AEQLog.a("AEMaterialManager", "readAndParseConfigFile -> oldJson exists, newJson not exist, use oldJson");
        return localList1;
      }
      catch (AEMaterialConfigParser.AEMaterialConfigParseException localAEMaterialConfigParseException3)
      {
        FileUtils.deleteFile(((File)localObject).getPath());
        localList1 = z();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("readAndParseConfigFile -> oldJson exists, newJson not exist, exception:");
        ((StringBuilder)localObject).append(localAEMaterialConfigParseException3.toString());
        AEQLog.d("AEMaterialManager", ((StringBuilder)localObject).toString());
        t();
      }
    }
    else
    {
      if (!((File)localObject).exists()) {}
      for (;;)
      {
        StringBuilder localStringBuilder;
        try
        {
          localList1 = a(localAEMaterialConfigParseException3);
          FileUtils.moveFile(localAEMaterialConfigParseException3.getPath(), ((File)localObject).getPath());
          AEQLog.a("AEMaterialManager", "readAndParseConfigFile -> oldJson not exist, use newJson ");
          return localList1;
        }
        catch (AEMaterialConfigParser.AEMaterialConfigParseException localAEMaterialConfigParseException1)
        {
          FileUtils.deleteFile(localAEMaterialConfigParseException3.getPath());
          localObject = z();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("readAndParseConfigFile -> oldJson not exists: exception:");
          localStringBuilder.append(localAEMaterialConfigParseException1.toString());
          AEQLog.d("AEMaterialManager", localStringBuilder.toString());
          t();
          return localObject;
        }
        try
        {
          localList2 = a((File)localObject, localStringBuilder);
          FileUtils.deleteFile(((File)localObject).getPath());
          FileUtils.moveFile(localStringBuilder.getPath(), ((File)localObject).getPath());
          AEQLog.a("AEMaterialManager", "readAndParseConfigFile -> try check update ");
        }
        catch (AEMaterialConfigParser.AEMaterialConfigParseException localAEMaterialConfigParseException2)
        {
          localList2 = z();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("loadMaterialListFromAssets  -> oldJson exists: exception:");
          localStringBuilder.append(localAEMaterialConfigParseException2.toString());
          AEQLog.d("AEMaterialManager", localStringBuilder.toString());
          t();
        }
      }
    }
    return localList2;
  }
  
  private void t()
  {
    AECameraPrefsUtil.a().a("ShadowBackendSvc.GetCategoryMaterialMqStoryCamera", 4);
    try
    {
      this.f = false;
      return;
    }
    finally {}
  }
  
  private List<AEMaterialMetaData> u()
  {
    return a(this.h, HardCodeUtil.a(2131898275));
  }
  
  private List<AEMaterialMetaData> v()
  {
    return a(this.i, 1);
  }
  
  private void w()
  {
    List localList1 = u();
    List localList2 = v();
    this.k.clear();
    this.k.addAll(a(localList1));
    this.l.clear();
    this.l.addAll(a(localList2));
  }
  
  private void x()
  {
    if (this.d == null) {
      return;
    }
    ??? = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    Object localObject2 = AECameraPrefsUtil.a();
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("recent_template_list_new");
    ((StringBuilder)localObject4).append((String)???);
    ??? = ((AECameraPrefsUtil)localObject2).b(((StringBuilder)localObject4).toString(), null, 0);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("loadRecentMaterial list=");
      ((StringBuilder)localObject2).append((String)???);
      QLog.d("AEMaterialManager", 2, ((StringBuilder)localObject2).toString());
    }
    if (??? == null) {
      return;
    }
    localObject2 = ((String)???).split("\\$");
    int i1;
    synchronized (this.m)
    {
      this.d.a.clear();
      i1 = 0;
      if (i1 < localObject2.length)
      {
        localObject4 = localObject2[i1].split("\\|");
        if ((localObject4 != null) && (localObject4.length == 2))
        {
          localObject4 = d(localObject4[0]);
          if (localObject4 != null)
          {
            if (this.d.a.size() >= 100) {
              return;
            }
            if ((!this.d.a.contains(localObject4)) && (!((AEMaterialMetaData)localObject4).m.equals("0"))) {
              this.d.a.add(localObject4);
            }
          }
        }
      }
      else
      {
        return;
      }
    }
  }
  
  private void y()
  {
    if (this.e == null) {
      return;
    }
    ??? = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    Object localObject2 = AECameraPrefsUtil.a();
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("recent_circle_template_list_new");
    ((StringBuilder)localObject4).append((String)???);
    ??? = ((AECameraPrefsUtil)localObject2).b(((StringBuilder)localObject4).toString(), null, 0);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("loadCircleRecentMaterial list=");
      ((StringBuilder)localObject2).append((String)???);
      QLog.d("AEMaterialManager", 2, ((StringBuilder)localObject2).toString());
    }
    if (??? == null) {
      return;
    }
    localObject2 = ((String)???).split("\\$");
    int i1;
    synchronized (this.n)
    {
      this.e.a.clear();
      i1 = 0;
      if (i1 < localObject2.length)
      {
        localObject4 = localObject2[i1].split("\\|");
        if ((localObject4 != null) && (localObject4.length == 2))
        {
          localObject4 = e(localObject4[0]);
          if (localObject4 != null)
          {
            if (this.e.a.size() >= 100) {
              return;
            }
            if ((!this.e.a.contains(localObject4)) && (!((AEMaterialMetaData)localObject4).m.equals("0"))) {
              this.e.a.add(localObject4);
            }
          }
        }
      }
      else
      {
        return;
      }
    }
  }
  
  private List<AEMaterialCategory> z()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = CameraOperationHelper.a(getApp().getApp());
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return localArrayList;
    }
    try
    {
      localObject = AEMaterialConfigParser.a((String)localObject);
      if (localObject != null)
      {
        if (((List)localObject).isEmpty()) {
          return localArrayList;
        }
        return localObject;
      }
      return localArrayList;
    }
    catch (AEMaterialConfigParser.AEMaterialConfigParseException localAEMaterialConfigParseException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadMaterialListFromAssets err=");
      localStringBuilder.append(localAEMaterialConfigParseException.getMessage());
      QLog.d("AEMaterialManager", 4, localStringBuilder.toString());
    }
    return localArrayList;
  }
  
  public AEMaterialMetaData a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      localObject = this.i;
    } else {
      localObject = this.h;
    }
    Iterator localIterator1 = ((List)localObject).iterator();
    Object localObject = "";
    for (int i1 = 0; localIterator1.hasNext(); i1 = 1)
    {
      label35:
      AEMaterialCategory localAEMaterialCategory = (AEMaterialCategory)localIterator1.next();
      if ((localAEMaterialCategory == null) || (localAEMaterialCategory.a == null) || (localAEMaterialCategory.b != paramInt)) {
        break label35;
      }
      localObject = localAEMaterialCategory.d;
      Iterator localIterator2 = localAEMaterialCategory.a.iterator();
      i1 = 0;
      while (localIterator2.hasNext())
      {
        AEMaterialMetaData localAEMaterialMetaData = (AEMaterialMetaData)localIterator2.next();
        int i2 = i1 + 1;
        i1 = i2;
        if (localAEMaterialMetaData.m.equals(paramString))
        {
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("selectPtvTemplateInfo= ");
            paramString.append(localAEMaterialMetaData);
            QLog.d("QIMRedDotConfig_PTV", 2, paramString.toString());
          }
          localAEMaterialMetaData.o = localAEMaterialCategory.d;
          localAEMaterialMetaData.p = i2;
          return localAEMaterialMetaData;
        }
      }
    }
    if (i1 != 0)
    {
      paramString = new AEMaterialMetaData();
      paramString.o = ((String)localObject);
      paramString.n = paramInt;
      paramString.m = "";
      return paramString;
    }
    return null;
  }
  
  public AEMaterialMetaData a(String paramString, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean) {
      localObject = this.i;
    } else {
      localObject = this.h;
    }
    Iterator localIterator1 = ((List)localObject).iterator();
    AEMaterialMetaData localAEMaterialMetaData;
    int i2;
    do
    {
      Iterator localIterator2;
      while (!localIterator2.hasNext())
      {
        do
        {
          if (!localIterator1.hasNext()) {
            break;
          }
          localObject = (AEMaterialCategory)localIterator1.next();
        } while ((localObject == null) || (((AEMaterialCategory)localObject).a == null));
        i1 = 0;
        localIterator2 = ((AEMaterialCategory)localObject).a.iterator();
      }
      localAEMaterialMetaData = (AEMaterialMetaData)localIterator2.next();
      i2 = i1 + 1;
      int i1 = i2;
    } while (!localAEMaterialMetaData.m.equals(paramString));
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("selectPtvTemplateInfo= ");
      paramString.append(localAEMaterialMetaData);
      QLog.d("QIMRedDotConfig_PTV", 2, paramString.toString());
    }
    localAEMaterialMetaData.o = ((AEMaterialCategory)localObject).d;
    localAEMaterialMetaData.p = i2;
    return localAEMaterialMetaData;
    return null;
  }
  
  @WorkerThread
  @NotNull
  public List<AEMaterialMetaData> a(boolean paramBoolean1, boolean paramBoolean2)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("loadDisplayHotList---requireServerData=");
    ((StringBuilder)???).append(paramBoolean1);
    AEQLog.b("AEMaterialManager", ((StringBuilder)???).toString());
    if (paramBoolean1) {
      synchronized (this.r)
      {
        if (!this.r.get()) {
          if (NetworkUtil.isNetworkAvailable())
          {
            ThreadManager.getSubThreadHandler().post(new AEDownloadMaterialRunnable());
            try
            {
              AEQLog.b("AEMaterialManager", "loadDisplayHotList---issue the request and wait");
              this.r.wait(90000L);
              AEQLog.b("AEMaterialManager", "loadDisplayHotList---awake from waiting");
            }
            catch (InterruptedException localInterruptedException)
            {
              localInterruptedException.printStackTrace();
            }
          }
          else
          {
            AEQLog.b("AEMaterialManager", "loadDisplayHotList---no network, skip request");
          }
        }
      }
    }
    e(false);
    if (paramBoolean2) {
      ??? = this.l;
    } else {
      ??? = this.k;
    }
    return new ArrayList((Collection)???);
  }
  
  public void a()
  {
    this.r.set(false);
  }
  
  public void a(int paramInt)
  {
    try
    {
      if (this.c != null) {
        this.c.a(paramInt);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    Observable localObservable = this.c;
    if (localObservable != null)
    {
      localObservable.a(paramInt, new Object[] { paramObject });
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("notifyEventId eventId=");
        paramObject.append(paramInt);
        QLog.d("AEMaterialManager", 2, paramObject.toString());
      }
    }
  }
  
  public void a(AEMaterialMetaData paramAEMaterialMetaData, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setSelectedMaterialAndNotify---info=");
    String str;
    if (paramAEMaterialMetaData == null) {
      str = "null";
    } else {
      str = paramAEMaterialMetaData.m;
    }
    localStringBuilder.append(str);
    localStringBuilder.append(", addToRecent=");
    localStringBuilder.append(paramBoolean);
    AEQLog.b("AEMaterialManager", localStringBuilder.toString());
    s = paramAEMaterialMetaData;
    t = null;
    if (paramBoolean) {
      if ((paramAEMaterialMetaData != null) && ("circleCamera".equals(paramAEMaterialMetaData.O))) {
        c(paramAEMaterialMetaData);
      } else {
        b(paramAEMaterialMetaData);
      }
    }
    d(paramAEMaterialMetaData);
    a(113, null);
  }
  
  public void a(AppInterface paramAppInterface, AEMaterialMetaData paramAEMaterialMetaData, AEMaterialDownloader.MaterialDownloadListener paramMaterialDownloadListener)
  {
    a(paramAppInterface, AEPath.CAMERA.FILES.h, paramAEMaterialMetaData, paramMaterialDownloadListener);
  }
  
  public void a(AppInterface paramAppInterface, String paramString, AEMaterialMetaData paramAEMaterialMetaData, AEMaterialDownloader.MaterialDownloadListener paramMaterialDownloadListener)
  {
    ThreadManager.excute(new AEMaterialManager.3(this, paramAppInterface, paramString, paramAEMaterialMetaData, paramMaterialDownloadListener), 128, null, true);
  }
  
  public void a(Observer paramObserver)
  {
    try
    {
      if (this.c != null) {
        this.c.a(paramObserver);
      }
      return;
    }
    finally
    {
      paramObserver = finally;
      throw paramObserver;
    }
  }
  
  public void a(Observer paramObserver, int paramInt)
  {
    try
    {
      if (this.c == null) {
        this.c = new Observable();
      }
      this.c.a(paramObserver, new int[] { paramInt });
      return;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    this.q = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    e(paramBoolean);
  }
  
  public String b()
  {
    return this.q;
  }
  
  public void b(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (paramAEMaterialMetaData == null) {
      return;
    }
    if (paramAEMaterialMetaData.d()) {
      return;
    }
    if (this.d == null)
    {
      x();
      return;
    }
    synchronized (this.m)
    {
      int i1 = b(this.d.a, paramAEMaterialMetaData.m);
      if (i1 == -1)
      {
        if (!D())
        {
          this.d.a.add(0, paramAEMaterialMetaData);
          B();
          if (QLog.isColorLevel()) {
            QLog.d("AEMaterialManager", 2, "setCurrentTemplateInfoToRecent not full");
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("AEMaterialManager", 2, "setCurrentTemplateInfoToRecent full");
          }
          this.d.a.remove(99);
          this.d.a.add(0, paramAEMaterialMetaData);
          B();
        }
      }
      else if (i1 != 0)
      {
        this.d.a.remove(i1);
        this.d.a.add(0, paramAEMaterialMetaData);
        B();
      }
      if (QLog.isColorLevel())
      {
        paramAEMaterialMetaData = new StringBuilder();
        paramAEMaterialMetaData.append("setCurrentTemplateInfoToRecent index=");
        paramAEMaterialMetaData.append(i1);
        QLog.d("AEMaterialManager", 2, paramAEMaterialMetaData.toString());
      }
      return;
    }
  }
  
  public void b(AEMaterialMetaData paramAEMaterialMetaData, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setSelectedWatermarkAndNotify---info=");
    String str;
    if (paramAEMaterialMetaData == null) {
      str = "null";
    } else {
      str = paramAEMaterialMetaData.m;
    }
    localStringBuilder.append(str);
    AEQLog.b("AEMaterialManager", localStringBuilder.toString());
    t = paramAEMaterialMetaData;
    s = null;
    d(paramAEMaterialMetaData);
    int i1;
    if (paramBoolean) {
      i1 = 1024;
    } else {
      i1 = 1025;
    }
    a(i1, null);
  }
  
  public void b(String paramString)
  {
    try
    {
      paramString = a(new File(paramString));
      if ((paramString != null) && (paramString.size() != 0)) {
        paramString = a(paramString, HardCodeUtil.a(2064187558));
      } else {
        paramString = a(z(), HardCodeUtil.a(2064187557));
      }
      ArrayList localArrayList = new ArrayList();
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        AEMaterialMetaData localAEMaterialMetaData = (AEMaterialMetaData)paramString.next();
        if ((localArrayList.size() < 10) && (localAEMaterialMetaData != null) && (localAEMaterialMetaData.m != null) && (localAEMaterialMetaData.q != null)) {
          localArrayList.add(new AEMaterialOnShow(localAEMaterialMetaData.m, localAEMaterialMetaData.q));
        }
      }
      AECameraPrefsUtil.a().a("PhotoConst.ae_latest_material", a(localArrayList), 4);
      return;
    }
    catch (NullPointerException paramString)
    {
      paramString.printStackTrace();
      return;
    }
    catch (AEMaterialConfigParser.AEMaterialConfigParseException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    ThreadManager.excute(new AEMaterialManager.1(this, paramBoolean), 64, null, false);
  }
  
  public List<AEMaterialCategory> c()
  {
    return this.i;
  }
  
  public List<AEMaterialCategory> c(boolean paramBoolean)
  {
    return this.h;
  }
  
  public void c(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (paramAEMaterialMetaData == null) {
      return;
    }
    if (paramAEMaterialMetaData.d()) {
      return;
    }
    if (this.e == null)
    {
      y();
      return;
    }
    synchronized (this.n)
    {
      int i1 = b(this.e.a, paramAEMaterialMetaData.m);
      if (i1 == -1)
      {
        if (!E())
        {
          this.e.a.add(0, paramAEMaterialMetaData);
          C();
          if (QLog.isColorLevel()) {
            QLog.d("AEMaterialManager", 2, "setCurrentTemplateInfoToRecent not full");
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("AEMaterialManager", 2, "setCurrentTemplateInfoToRecent full");
          }
          this.e.a.remove(99);
          this.e.a.add(0, paramAEMaterialMetaData);
          C();
        }
      }
      else if (i1 != 0)
      {
        this.e.a.remove(i1);
        this.e.a.add(0, paramAEMaterialMetaData);
        C();
      }
      if (QLog.isColorLevel())
      {
        paramAEMaterialMetaData = new StringBuilder();
        paramAEMaterialMetaData.append("setCurrentTemplateInfoToRecent index=");
        paramAEMaterialMetaData.append(i1);
        QLog.d("AEMaterialManager", 2, paramAEMaterialMetaData.toString());
      }
      return;
    }
  }
  
  public List<AEMaterialCategory> d()
  {
    return this.j;
  }
  
  public List<AEMaterialMetaData> d(boolean paramBoolean)
  {
    List localList;
    if (paramBoolean) {
      localList = this.l;
    } else {
      localList = this.k;
    }
    return new ArrayList(localList);
  }
  
  public void d(AEMaterialMetaData paramAEMaterialMetaData)
  {
    AEBaseReportParam localAEBaseReportParam = AEBaseReportParam.a();
    String str = "";
    if (paramAEMaterialMetaData == null) {
      localObject = "";
    } else {
      localObject = paramAEMaterialMetaData.aa;
    }
    localAEBaseReportParam.g((String)localObject);
    Object localObject = AEBaseReportParam.a();
    if (paramAEMaterialMetaData == null) {
      paramAEMaterialMetaData = str;
    } else {
      paramAEMaterialMetaData = paramAEMaterialMetaData.ab;
    }
    ((AEBaseReportParam)localObject).h(paramAEMaterialMetaData);
  }
  
  public List<AEMaterialCategory> e()
  {
    return this.h;
  }
  
  public void f()
  {
    AEQLog.b("AEMaterialManager", "onConfigRequestDone---notify all wait thread");
    synchronized (this.r)
    {
      this.r.set(true);
      this.r.notifyAll();
      return;
    }
  }
  
  @Deprecated
  public void forceInit() {}
  
  public void g()
  {
    AEQLog.b("AEMaterialManager", "onConfigRequestCancel---notify all wait thread");
    synchronized (this.r)
    {
      this.r.notifyAll();
      return;
    }
  }
  
  public void h()
  {
    ??? = this.d;
    if (??? == null) {
      return;
    }
    if ((((AEMaterialCategory)???).a != null) && (this.d.a.isEmpty())) {
      return;
    }
    synchronized (this.m)
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      Object localObject3 = this.d.a.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (AEMaterialMetaData)((Iterator)localObject3).next();
        if ((!TextUtils.isEmpty(((AEMaterialMetaData)localObject4).m)) && (!((AEMaterialMetaData)localObject4).equals(AEMaterialMetaData.l)))
        {
          localStringBuilder1.append(((AEMaterialMetaData)localObject4).m);
          localStringBuilder1.append("|");
          localStringBuilder1.append(((AEMaterialMetaData)localObject4).n);
          localStringBuilder1.append("$");
        }
      }
      if (TextUtils.isEmpty(localStringBuilder1.toString())) {
        return;
      }
      localObject3 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      Object localObject4 = AECameraPrefsUtil.a();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("recent_template_list_new");
      localStringBuilder2.append((String)localObject3);
      ((AECameraPrefsUtil)localObject4).a(localStringBuilder2.toString(), localStringBuilder1.toString(), 0);
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("saveRecentTemplate list=");
        ((StringBuilder)localObject3).append(localStringBuilder1.toString());
        QLog.d("AEMaterialManager", 2, ((StringBuilder)localObject3).toString());
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void i()
  {
    ??? = this.e;
    if ((??? != null) && (((AEMaterialCategory)???).a != null))
    {
      if (this.e.a.isEmpty()) {
        return;
      }
      synchronized (this.n)
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        Object localObject3 = this.e.a.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (AEMaterialMetaData)((Iterator)localObject3).next();
          if ((!TextUtils.isEmpty(((AEMaterialMetaData)localObject4).m)) && (!((AEMaterialMetaData)localObject4).equals(AEMaterialMetaData.l)))
          {
            localStringBuilder1.append(((AEMaterialMetaData)localObject4).m);
            localStringBuilder1.append("|");
            localStringBuilder1.append(((AEMaterialMetaData)localObject4).n);
            localStringBuilder1.append("$");
          }
        }
        if (TextUtils.isEmpty(localStringBuilder1.toString())) {
          return;
        }
        localObject3 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        Object localObject4 = AECameraPrefsUtil.a();
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("recent_circle_template_list_new");
        localStringBuilder2.append((String)localObject3);
        ((AECameraPrefsUtil)localObject4).a(localStringBuilder2.toString(), localStringBuilder1.toString(), 0);
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("saveRecentTemplate list=");
          ((StringBuilder)localObject3).append(localStringBuilder1.toString());
          QLog.d("AEMaterialManager", 2, ((StringBuilder)localObject3).toString());
        }
        return;
      }
    }
  }
  
  @Deprecated
  protected void initIndeed() {}
  
  public void k()
  {
    s = null;
  }
  
  public void l()
  {
    t = null;
  }
  
  @Deprecated
  public void onInit() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.data.AEMaterialManager
 * JD-Core Version:    0.7.0.1
 */