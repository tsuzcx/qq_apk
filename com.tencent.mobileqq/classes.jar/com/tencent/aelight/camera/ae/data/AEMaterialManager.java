package com.tencent.aelight.camera.ae.data;

import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.tencent.aelight.camera.ae.AEPath.CAMERA.FILES;
import com.tencent.aelight.camera.ae.config.CameraOperationHelper;
import com.tencent.aelight.camera.ae.control.AEQIMAsyncManager;
import com.tencent.aelight.camera.ae.download.AEDownloadMaterialRunnable;
import com.tencent.aelight.camera.ae.download.AEMaterialDownloader;
import com.tencent.aelight.camera.ae.download.AEMaterialDownloader.MaterialDownloadListener;
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
  private static AEMaterialMetaData jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData;
  public static volatile boolean a = false;
  private static AEMaterialMetaData jdField_b_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData;
  public static volatile boolean b = false;
  private AEMaterialCategory jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialCategory = new AEMaterialCategory(d());
  private Observable jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString = "";
  private final List<AEMaterialCategory> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AEMaterialCategory jdField_b_of_type_ComTencentAelightCameraAeDataAEMaterialCategory;
  private final Object jdField_b_of_type_JavaLangObject = new Object();
  private final List<AEMaterialCategory> jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private final Object jdField_c_of_type_JavaLangObject = new Object();
  private final List<AEMaterialCategory> jdField_c_of_type_JavaUtilList = new ArrayList();
  private volatile boolean jdField_c_of_type_Boolean = false;
  private final Object jdField_d_of_type_JavaLangObject = new Object();
  private final List<AEMaterialMetaData> jdField_d_of_type_JavaUtilList = new ArrayList();
  private final List<AEMaterialMetaData> e = new ArrayList();
  
  public AEMaterialManager()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList = new ArrayList(100);
    this.jdField_b_of_type_ComTencentAelightCameraAeDataAEMaterialCategory = new AEMaterialCategory(d());
    this.jdField_b_of_type_ComTencentAelightCameraAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList = new ArrayList(100);
  }
  
  private int a(List<AEMaterialMetaData> paramList, String paramString)
  {
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        return -1;
      }
      int i = 0;
      while (i < paramList.size())
      {
        if (((AEMaterialMetaData)paramList.get(i)).k.equals(paramString)) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public static AEMaterialMetaData a()
  {
    return jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData;
  }
  
  private AEMaterialMetaData a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    Iterator localIterator1 = this.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject1 = null;
    Object localObject2;
    int i;
    do
    {
      do
      {
        localObject2 = localObject1;
        if (!localIterator1.hasNext()) {
          break;
        }
        localObject2 = (AEMaterialCategory)localIterator1.next();
      } while (((AEMaterialCategory)localObject2).jdField_a_of_type_JavaUtilList == null);
      int j = 0;
      Iterator localIterator2 = ((AEMaterialCategory)localObject2).jdField_a_of_type_JavaUtilList.iterator();
      do
      {
        localObject2 = localObject1;
        i = j;
        if (!localIterator2.hasNext()) {
          break;
        }
        localObject2 = (AEMaterialMetaData)localIterator2.next();
      } while (!((AEMaterialMetaData)localObject2).equals(paramAEMaterialMetaData));
      i = 1;
      localObject1 = localObject2;
    } while (i == 0);
    return localObject2;
  }
  
  private AEMaterialMetaData a(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Object localObject = this.jdField_b_of_type_JavaUtilList.iterator();
      AEMaterialMetaData localAEMaterialMetaData;
      do
      {
        Iterator localIterator;
        while (!localIterator.hasNext())
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localIterator = ((AEMaterialCategory)((Iterator)localObject).next()).jdField_a_of_type_JavaUtilList.iterator();
        }
        localAEMaterialMetaData = (AEMaterialMetaData)localIterator.next();
      } while (!localAEMaterialMetaData.k.equals(paramString));
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
  
  @Nullable
  public static String a(@Nullable ArrayList<AEMaterialOnShow> paramArrayList)
  {
    if (paramArrayList != null) {
      return GsonUtils.obj2Json(paramArrayList);
    }
    return null;
  }
  
  @Nullable
  public static ArrayList<AEMaterialOnShow> a(@Nullable String paramString)
  {
    return (ArrayList)GsonUtils.json2Obj(paramString, new AEMaterialManager.2().getType());
  }
  
  private HashMap<String, AEMaterialCategory> a(@Nullable AEMaterialCategory paramAEMaterialCategory)
  {
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getSpecificCategory: item.name = ");
    if (paramAEMaterialCategory == null) {
      localObject1 = "null";
    } else {
      localObject1 = paramAEMaterialCategory.jdField_b_of_type_JavaLangString;
    }
    ((StringBuilder)localObject2).append((String)localObject1);
    AEQLog.a("AEMaterialManager", ((StringBuilder)localObject2).toString());
    Object localObject1 = new HashMap();
    localObject2 = new AEMaterialCategory();
    AEMaterialCategory localAEMaterialCategory = new AEMaterialCategory();
    if ((paramAEMaterialCategory != null) && (paramAEMaterialCategory.jdField_a_of_type_JavaUtilList != null))
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = paramAEMaterialCategory.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        AEMaterialMetaData localAEMaterialMetaData = (AEMaterialMetaData)localIterator.next();
        if ("circleCamera".equals(localAEMaterialMetaData.w)) {
          localArrayList2.add(localAEMaterialMetaData);
        } else {
          localArrayList1.add(localAEMaterialMetaData);
        }
      }
      ((AEMaterialCategory)localObject2).jdField_a_of_type_JavaUtilList = localArrayList1;
      ((AEMaterialCategory)localObject2).jdField_a_of_type_Int = paramAEMaterialCategory.jdField_a_of_type_Int;
      ((AEMaterialCategory)localObject2).jdField_b_of_type_JavaLangString = paramAEMaterialCategory.jdField_b_of_type_JavaLangString;
      ((AEMaterialCategory)localObject2).jdField_a_of_type_JavaLangString = paramAEMaterialCategory.jdField_a_of_type_JavaLangString;
      ((AEMaterialCategory)localObject2).jdField_a_of_type_Boolean = paramAEMaterialCategory.jdField_a_of_type_Boolean;
      ((AEMaterialCategory)localObject2).jdField_b_of_type_Int = paramAEMaterialCategory.jdField_b_of_type_Int;
      localAEMaterialCategory.jdField_a_of_type_JavaUtilList = localArrayList2;
      localAEMaterialCategory.jdField_a_of_type_Int = paramAEMaterialCategory.jdField_a_of_type_Int;
      localAEMaterialCategory.jdField_b_of_type_JavaLangString = paramAEMaterialCategory.jdField_b_of_type_JavaLangString;
      localAEMaterialCategory.jdField_a_of_type_JavaLangString = paramAEMaterialCategory.jdField_a_of_type_JavaLangString;
      localAEMaterialCategory.jdField_a_of_type_Boolean = paramAEMaterialCategory.jdField_a_of_type_Boolean;
      localAEMaterialCategory.jdField_b_of_type_Int = paramAEMaterialCategory.jdField_b_of_type_Int;
      ((HashMap)localObject1).put("normal_material", localObject2);
      ((HashMap)localObject1).put("circle_material", localAEMaterialCategory);
      return localObject1;
    }
    AEQLog.d("AEMaterialManager", "getSpecificCategory: item.materialList == null!");
    ((HashMap)localObject1).put("normal_material", localObject2);
    ((HashMap)localObject1).put("circle_material", localAEMaterialCategory);
    return localObject1;
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
          if (paramFile1.jdField_b_of_type_JavaLangString.equals(paramFile2.jdField_b_of_type_JavaLangString)) {
            break label104;
          }
        }
        paramFile1 = null;
        label104:
        if (paramFile1 == null)
        {
          paramFile1 = paramFile2.jdField_a_of_type_JavaUtilList.iterator();
          while (paramFile1.hasNext()) {
            c((AEMaterialMetaData)paramFile1.next());
          }
        }
        else
        {
          localIterator2 = paramFile2.jdField_a_of_type_JavaUtilList.iterator();
          while (localIterator2.hasNext())
          {
            AEMaterialMetaData localAEMaterialMetaData = (AEMaterialMetaData)localIterator2.next();
            Iterator localIterator3 = paramFile1.jdField_a_of_type_JavaUtilList.iterator();
            while (localIterator3.hasNext())
            {
              paramFile2 = (AEMaterialMetaData)localIterator3.next();
              if (localAEMaterialMetaData.k.equals(paramFile2.k)) {
                break label228;
              }
            }
            paramFile2 = null;
            if (paramFile2 == null) {
              c(localAEMaterialMetaData);
            } else if (!localAEMaterialMetaData.o.equals(paramFile2.o)) {
              c(localAEMaterialMetaData);
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
    int i = 0;
    while (paramList.hasNext())
    {
      AEMaterialMetaData localAEMaterialMetaData = (AEMaterialMetaData)paramList.next();
      if (((!localAEMaterialMetaData.k.contains("_3DFaceFila")) || (Ace3DEngineInitializer.supportAceEngine())) && ((!localAEMaterialMetaData.k.contains("_haircolor")) || ((DeviceUtils.hasDeviceNormal(BaseApplicationImpl.getContext())) && ((GpuScopeAttrs.getInstance().getDeviceModel() == null) || (GpuScopeAttrs.getInstance().getDeviceModel().hairColor)))))
      {
        if (i >= 10) {
          break;
        }
        localArrayList.add(localAEMaterialMetaData);
        i += 1;
      }
    }
    return localArrayList;
  }
  
  private List<AEMaterialMetaData> a(List<AEMaterialCategory> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.jdField_b_of_type_JavaLangObject;
    if (paramList != null) {}
    try
    {
      if (paramList.size() > paramInt)
      {
        paramList = (AEMaterialCategory)paramList.get(paramInt);
        if (paramList != null)
        {
          localArrayList.addAll(paramList.jdField_a_of_type_JavaUtilList);
          if ((localArrayList.size() > 0) && (((AEMaterialMetaData)localArrayList.get(0)).equals(AEMaterialMetaData.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData))) {
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
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        AEMaterialCategory localAEMaterialCategory = (AEMaterialCategory)paramList.next();
        if (localAEMaterialCategory.jdField_b_of_type_JavaLangString.equals(paramString))
        {
          localArrayList.addAll(localAEMaterialCategory.jdField_a_of_type_JavaUtilList);
          if ((localArrayList.size() > 0) && (((AEMaterialMetaData)localArrayList.get(0)).equals(AEMaterialMetaData.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData))) {
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
  
  public static boolean a()
  {
    AEMaterialMetaData localAEMaterialMetaData = a();
    return (localAEMaterialMetaData != null) && (!localAEMaterialMetaData.equals(AEMaterialMetaData.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData)) && (localAEMaterialMetaData.g != 0);
  }
  
  public static boolean a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (paramAEMaterialMetaData != null) {
      try
      {
        if (!TextUtils.isEmpty(paramAEMaterialMetaData.p))
        {
          boolean bool = b(paramAEMaterialMetaData);
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
                      if (paramVideoMaterial.needHeadSegment()) {
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
  
  public static AEMaterialMetaData b()
  {
    return jdField_b_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData;
  }
  
  private AEMaterialMetaData b(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Object localObject = this.jdField_c_of_type_JavaUtilList.iterator();
      AEMaterialMetaData localAEMaterialMetaData;
      do
      {
        Iterator localIterator;
        while (!localIterator.hasNext())
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localIterator = ((AEMaterialCategory)((Iterator)localObject).next()).jdField_a_of_type_JavaUtilList.iterator();
        }
        localAEMaterialMetaData = (AEMaterialMetaData)localIterator.next();
      } while (!localAEMaterialMetaData.k.equals(paramString));
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
  
  public static String b()
  {
    File localFile = new File(AEPath.CAMERA.FILES.j);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return new File(localFile.getPath(), "camera_story_update_template.json").getPath();
  }
  
  private void b(AppInterface paramAppInterface, String paramString, AEMaterialMetaData paramAEMaterialMetaData, AEMaterialDownloader.MaterialDownloadListener paramMaterialDownloadListener)
  {
    AEMaterialDownloader.a(paramAppInterface, paramAEMaterialMetaData, paramString, new AEMaterialManager.4(this, paramMaterialDownloadListener));
    paramString = new StringBuilder();
    paramString.append("【START】startDownloadMaterial :");
    if (paramAEMaterialMetaData == null) {
      paramAppInterface = "null";
    } else {
      paramAppInterface = paramAEMaterialMetaData.k;
    }
    paramString.append(paramAppInterface);
    AEQLog.b("AEMaterialManager", paramString.toString());
  }
  
  public static boolean b()
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
  
  private static boolean b(AEMaterialMetaData paramAEMaterialMetaData)
  {
    Object localObject = paramAEMaterialMetaData.a();
    File localFile1 = new File((String)localObject, "params.json");
    localObject = new File((String)localObject, "params.dat");
    if ((!localFile1.exists()) && (!((File)localObject).exists())) {
      try
      {
        File localFile2 = new File(paramAEMaterialMetaData.c());
        if (!localFile2.exists()) {
          return false;
        }
        ZipUtils.unZipFile(localFile2, paramAEMaterialMetaData.b());
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
  
  public static String c()
  {
    File localFile = new File(AEPath.CAMERA.FILES.h);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile.getPath();
  }
  
  private List<AEMaterialCategory> c()
  {
    File localFile = new File(AEPath.CAMERA.FILES.j, "camera_story_update_template.json");
    Object localObject = new File(AEPath.CAMERA.FILES.j, "camera_story_default_template.json");
    List localList1;
    List localList2;
    if (!localFile.exists())
    {
      if (!((File)localObject).exists())
      {
        localList1 = f();
        AEQLog.a("AEMaterialManager", "readAndParseConfigFile -> oldJson not exist, newJson not exist, use Json from assets ");
        h();
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
        localList1 = f();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("readAndParseConfigFile -> oldJson exists, newJson not exist, exception:");
        ((StringBuilder)localObject).append(localAEMaterialConfigParseException3.toString());
        AEQLog.d("AEMaterialManager", ((StringBuilder)localObject).toString());
        h();
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
          localObject = f();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("readAndParseConfigFile -> oldJson not exists: exception:");
          localStringBuilder.append(localAEMaterialConfigParseException1.toString());
          AEQLog.d("AEMaterialManager", localStringBuilder.toString());
          h();
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
          localList2 = f();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("loadMaterialListFromAssets  -> oldJson exists: exception:");
          localStringBuilder.append(localAEMaterialConfigParseException2.toString());
          AEQLog.d("AEMaterialManager", localStringBuilder.toString());
          h();
        }
      }
    }
    return localList2;
  }
  
  private void c(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("deleteMaterialFolder: ");
      ((StringBuilder)localObject).append(paramAEMaterialMetaData.k);
      QLog.d("AEMaterialManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new File(AEPath.CAMERA.FILES.i, paramAEMaterialMetaData.k);
    if (((File)localObject).exists()) {
      FileUtils.deleteDirectory(((File)localObject).getPath());
    }
    paramAEMaterialMetaData = new File(AEPath.CAMERA.FILES.h, paramAEMaterialMetaData.k);
    if (paramAEMaterialMetaData.exists()) {
      FileUtils.deleteDirectory(paramAEMaterialMetaData.getPath());
    }
  }
  
  @WorkerThread
  private void c(boolean paramBoolean)
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
      if ((this.jdField_c_of_type_Boolean) && (!paramBoolean))
      {
        AEQLog.b("AEMaterialManager", "initMaterialList---has inited, fast return");
        return;
      }
      this.jdField_c_of_type_Boolean = true;
      ??? = new StringBuilder();
      ((StringBuilder)???).append("filament isSupport: ");
      ((StringBuilder)???).append(b());
      AEQLog.b("AEMaterialManager", ((StringBuilder)???).toString());
      synchronized (this.jdField_d_of_type_JavaLangObject)
      {
        Object localObject3 = c();
        if ((localObject3 != null) && (!((List)localObject3).isEmpty())) {
          synchronized (this.jdField_c_of_type_JavaLangObject)
          {
            this.jdField_a_of_type_JavaUtilList.clear();
            this.jdField_b_of_type_JavaUtilList.clear();
            this.jdField_c_of_type_JavaUtilList.clear();
            this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject3);
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              Object localObject7 = (AEMaterialCategory)((Iterator)localObject3).next();
              if (localObject7 != null)
              {
                Object localObject9 = a((AEMaterialCategory)localObject7);
                Object localObject8 = (AEMaterialCategory)((HashMap)localObject9).get("normal_material");
                localObject9 = (AEMaterialCategory)((HashMap)localObject9).get("circle_material");
                if ((localObject9 != null) && (((AEMaterialCategory)localObject9).jdField_a_of_type_JavaUtilList != null) && (((AEMaterialCategory)localObject9).jdField_a_of_type_JavaUtilList.size() > 0))
                {
                  StringBuilder localStringBuilder = new StringBuilder();
                  localStringBuilder.append("initMaterialList: circleCategory = ");
                  localStringBuilder.append(localObject9.toString());
                  AEQLog.a("AEMaterialManager", localStringBuilder.toString());
                  this.jdField_c_of_type_JavaUtilList.add(localObject9);
                }
                if ((localObject8 != null) && (((AEMaterialCategory)localObject8).jdField_a_of_type_JavaUtilList != null) && (((AEMaterialCategory)localObject8).jdField_a_of_type_JavaUtilList.size() > 0)) {
                  this.jdField_b_of_type_JavaUtilList.add(localObject8);
                }
                localObject7 = ((AEMaterialCategory)localObject7).jdField_a_of_type_JavaUtilList.iterator();
                while (((Iterator)localObject7).hasNext())
                {
                  localObject8 = (AEMaterialMetaData)((Iterator)localObject7).next();
                  if (localObject8 != null) {
                    ((AEMaterialMetaData)localObject8).e = a((AEMaterialMetaData)localObject8);
                  }
                }
              }
            }
            j();
            k();
            synchronized (this.jdField_c_of_type_JavaLangObject)
            {
              if ((this.jdField_b_of_type_JavaUtilList.size() > 0) && (!d().equals(((AEMaterialCategory)this.jdField_b_of_type_JavaUtilList.get(0)).jdField_b_of_type_JavaLangString))) {
                this.jdField_b_of_type_JavaUtilList.add(0, this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialCategory);
              }
              if ((this.jdField_c_of_type_JavaUtilList.size() > 0) && (!d().equals(((AEMaterialCategory)this.jdField_c_of_type_JavaUtilList.get(0)).jdField_b_of_type_JavaLangString))) {
                this.jdField_c_of_type_JavaUtilList.add(0, this.jdField_b_of_type_ComTencentAelightCameraAeDataAEMaterialCategory);
              }
              i();
              if (QLog.isColorLevel())
              {
                long l2 = System.currentTimeMillis();
                ??? = new StringBuilder();
                ((StringBuilder)???).append("initMaterialList exit, cost = ");
                ((StringBuilder)???).append(l2 - l1);
                ((StringBuilder)???).append("ms");
                QLog.d("AEMaterialManager", 2, ((StringBuilder)???).toString());
              }
              l();
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
  
  private boolean c()
  {
    AEMaterialCategory localAEMaterialCategory = this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialCategory;
    return (localAEMaterialCategory != null) && (localAEMaterialCategory.jdField_a_of_type_JavaUtilList.size() >= 100);
  }
  
  private String d()
  {
    return HardCodeUtil.a(2131709781);
  }
  
  private List<AEMaterialMetaData> d()
  {
    return a(this.jdField_b_of_type_JavaUtilList, HardCodeUtil.a(2131700232));
  }
  
  private boolean d()
  {
    AEMaterialCategory localAEMaterialCategory = this.jdField_b_of_type_ComTencentAelightCameraAeDataAEMaterialCategory;
    return (localAEMaterialCategory != null) && (localAEMaterialCategory.jdField_a_of_type_JavaUtilList != null) && (this.jdField_b_of_type_ComTencentAelightCameraAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.size() >= 100);
  }
  
  private List<AEMaterialMetaData> e()
  {
    return a(this.jdField_c_of_type_JavaUtilList, 1);
  }
  
  private List<AEMaterialCategory> f()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = CameraOperationHelper.b(getApp().getApp());
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
  
  private void h()
  {
    AECameraPrefsUtil.a().a("ShadowBackendSvc.GetCategoryMaterialMqStoryCamera", 4);
    try
    {
      this.jdField_c_of_type_Boolean = false;
      return;
    }
    finally {}
  }
  
  private void i()
  {
    List localList1 = d();
    List localList2 = e();
    this.jdField_d_of_type_JavaUtilList.clear();
    this.jdField_d_of_type_JavaUtilList.addAll(a(localList1));
    this.e.clear();
    this.e.addAll(a(localList2));
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialCategory == null) {
      return;
    }
    ??? = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    Object localObject2 = AECameraPrefsUtil.a();
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("recent_template_list_new");
    ((StringBuilder)localObject4).append((String)???);
    ??? = ((AECameraPrefsUtil)localObject2).a(((StringBuilder)localObject4).toString(), null, 0);
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
    int i;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.clear();
      i = 0;
      if (i < localObject2.length)
      {
        localObject4 = localObject2[i].split("\\|");
        if ((localObject4 != null) && (localObject4.length == 2))
        {
          localObject4 = a(localObject4[0]);
          if (localObject4 != null)
          {
            if (this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.size() >= 100) {
              return;
            }
            if ((!this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.contains(localObject4)) && (!((AEMaterialMetaData)localObject4).k.equals("0"))) {
              this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.add(localObject4);
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
  
  private void k()
  {
    if (this.jdField_b_of_type_ComTencentAelightCameraAeDataAEMaterialCategory == null) {
      return;
    }
    ??? = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    Object localObject2 = AECameraPrefsUtil.a();
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("recent_circle_template_list_new");
    ((StringBuilder)localObject4).append((String)???);
    ??? = ((AECameraPrefsUtil)localObject2).a(((StringBuilder)localObject4).toString(), null, 0);
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
    int i;
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      this.jdField_b_of_type_ComTencentAelightCameraAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.clear();
      i = 0;
      if (i < localObject2.length)
      {
        localObject4 = localObject2[i].split("\\|");
        if ((localObject4 != null) && (localObject4.length == 2))
        {
          localObject4 = b(localObject4[0]);
          if (localObject4 != null)
          {
            if (this.jdField_b_of_type_ComTencentAelightCameraAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.size() >= 100) {
              return;
            }
            if ((!this.jdField_b_of_type_ComTencentAelightCameraAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.contains(localObject4)) && (!((AEMaterialMetaData)localObject4).k.equals("0"))) {
              this.jdField_b_of_type_ComTencentAelightCameraAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.add(localObject4);
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
  
  private void l()
  {
    if (getApp() != null) {
      getApp().notifyObservers(CaptureConfigUpdateObserver.class, 3, true, null);
    }
    Observable localObservable = this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable;
    if (localObservable != null) {
      localObservable.a(116, null);
    }
  }
  
  private void m()
  {
    Observable localObservable = this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable;
    if (localObservable != null) {
      localObservable.a(111, new Object[] { this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialCategory });
    }
  }
  
  private void n()
  {
    Observable localObservable = this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable;
    if (localObservable != null) {
      localObservable.a(111, new Object[] { this.jdField_b_of_type_ComTencentAelightCameraAeDataAEMaterialCategory });
    }
  }
  
  public AEMaterialMetaData a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      localObject = this.jdField_c_of_type_JavaUtilList;
    } else {
      localObject = this.jdField_b_of_type_JavaUtilList;
    }
    Iterator localIterator1 = ((List)localObject).iterator();
    Object localObject = "";
    for (int i = 0; localIterator1.hasNext(); i = 1)
    {
      label35:
      AEMaterialCategory localAEMaterialCategory = (AEMaterialCategory)localIterator1.next();
      if ((localAEMaterialCategory == null) || (localAEMaterialCategory.jdField_a_of_type_JavaUtilList == null) || (localAEMaterialCategory.jdField_a_of_type_Int != paramInt)) {
        break label35;
      }
      localObject = localAEMaterialCategory.jdField_b_of_type_JavaLangString;
      Iterator localIterator2 = localAEMaterialCategory.jdField_a_of_type_JavaUtilList.iterator();
      i = 0;
      while (localIterator2.hasNext())
      {
        AEMaterialMetaData localAEMaterialMetaData = (AEMaterialMetaData)localIterator2.next();
        int j = i + 1;
        i = j;
        if (localAEMaterialMetaData.k.equals(paramString))
        {
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("selectPtvTemplateInfo= ");
            paramString.append(localAEMaterialMetaData);
            QLog.d("QIMRedDotConfig_PTV", 2, paramString.toString());
          }
          localAEMaterialMetaData.l = localAEMaterialCategory.jdField_b_of_type_JavaLangString;
          localAEMaterialMetaData.c = j;
          return localAEMaterialMetaData;
        }
      }
    }
    if (i != 0)
    {
      paramString = new AEMaterialMetaData();
      paramString.l = ((String)localObject);
      paramString.jdField_b_of_type_Int = paramInt;
      paramString.k = "";
      return paramString;
    }
    return null;
  }
  
  public AEMaterialMetaData a(String paramString, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean) {
      localObject = this.jdField_c_of_type_JavaUtilList;
    } else {
      localObject = this.jdField_b_of_type_JavaUtilList;
    }
    Iterator localIterator1 = ((List)localObject).iterator();
    AEMaterialMetaData localAEMaterialMetaData;
    int j;
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
        } while ((localObject == null) || (((AEMaterialCategory)localObject).jdField_a_of_type_JavaUtilList == null));
        i = 0;
        localIterator2 = ((AEMaterialCategory)localObject).jdField_a_of_type_JavaUtilList.iterator();
      }
      localAEMaterialMetaData = (AEMaterialMetaData)localIterator2.next();
      j = i + 1;
      int i = j;
    } while (!localAEMaterialMetaData.k.equals(paramString));
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("selectPtvTemplateInfo= ");
      paramString.append(localAEMaterialMetaData);
      QLog.d("QIMRedDotConfig_PTV", 2, paramString.toString());
    }
    localAEMaterialMetaData.l = ((AEMaterialCategory)localObject).jdField_b_of_type_JavaLangString;
    localAEMaterialMetaData.c = j;
    return localAEMaterialMetaData;
    return null;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List<AEMaterialCategory> a()
  {
    return this.jdField_c_of_type_JavaUtilList;
  }
  
  public List<AEMaterialCategory> a(boolean paramBoolean)
  {
    return this.jdField_b_of_type_JavaUtilList;
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
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
      {
        if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          if (NetworkUtil.isNetworkAvailable())
          {
            ThreadManager.getSubThreadHandler().post(new AEDownloadMaterialRunnable());
            try
            {
              AEQLog.b("AEMaterialManager", "loadDisplayHotList---issue the request and wait");
              this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.wait(90000L);
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
    c(false);
    if (paramBoolean2) {
      ??? = this.e;
    } else {
      ??? = this.jdField_d_of_type_JavaUtilList;
    }
    return new ArrayList((Collection)???);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
  
  public void a(int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable.a(paramInt);
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
    Observable localObservable = this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable;
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
  
  public void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (paramAEMaterialMetaData == null) {
      return;
    }
    if (paramAEMaterialMetaData.c()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialCategory == null)
    {
      j();
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      int i = a(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList, paramAEMaterialMetaData.k);
      if (i == -1)
      {
        if (!c())
        {
          this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.add(0, paramAEMaterialMetaData);
          m();
          if (QLog.isColorLevel()) {
            QLog.d("AEMaterialManager", 2, "setCurrentTemplateInfoToRecent not full");
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("AEMaterialManager", 2, "setCurrentTemplateInfoToRecent full");
          }
          this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.remove(99);
          this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.add(0, paramAEMaterialMetaData);
          m();
        }
      }
      else if (i != 0)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.remove(i);
        this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.add(0, paramAEMaterialMetaData);
        m();
      }
      if (QLog.isColorLevel())
      {
        paramAEMaterialMetaData = new StringBuilder();
        paramAEMaterialMetaData.append("setCurrentTemplateInfoToRecent index=");
        paramAEMaterialMetaData.append(i);
        QLog.d("AEMaterialManager", 2, paramAEMaterialMetaData.toString());
      }
      return;
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
      str = paramAEMaterialMetaData.k;
    }
    localStringBuilder.append(str);
    localStringBuilder.append(", addToRecent=");
    localStringBuilder.append(paramBoolean);
    AEQLog.b("AEMaterialManager", localStringBuilder.toString());
    jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData = paramAEMaterialMetaData;
    jdField_b_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData = null;
    if (paramBoolean) {
      if ((paramAEMaterialMetaData != null) && ("circleCamera".equals(paramAEMaterialMetaData.w))) {
        b(paramAEMaterialMetaData);
      } else {
        a(paramAEMaterialMetaData);
      }
    }
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
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable.a(paramObserver);
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
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable == null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable = new Observable();
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable.a(paramObserver, new int[] { paramInt });
      return;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    c(paramBoolean);
  }
  
  public List<AEMaterialCategory> b()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public List<AEMaterialMetaData> b(boolean paramBoolean)
  {
    List localList;
    if (paramBoolean) {
      localList = this.e;
    } else {
      localList = this.jdField_d_of_type_JavaUtilList;
    }
    return new ArrayList(localList);
  }
  
  public void b()
  {
    AEQLog.b("AEMaterialManager", "onConfigRequestDone---notify all wait thread");
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.notifyAll();
      return;
    }
  }
  
  public void b(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (paramAEMaterialMetaData == null) {
      return;
    }
    if (paramAEMaterialMetaData.c()) {
      return;
    }
    if (this.jdField_b_of_type_ComTencentAelightCameraAeDataAEMaterialCategory == null)
    {
      k();
      return;
    }
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      int i = a(this.jdField_b_of_type_ComTencentAelightCameraAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList, paramAEMaterialMetaData.k);
      if (i == -1)
      {
        if (!d())
        {
          this.jdField_b_of_type_ComTencentAelightCameraAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.add(0, paramAEMaterialMetaData);
          n();
          if (QLog.isColorLevel()) {
            QLog.d("AEMaterialManager", 2, "setCurrentTemplateInfoToRecent not full");
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("AEMaterialManager", 2, "setCurrentTemplateInfoToRecent full");
          }
          this.jdField_b_of_type_ComTencentAelightCameraAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.remove(99);
          this.jdField_b_of_type_ComTencentAelightCameraAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.add(0, paramAEMaterialMetaData);
          n();
        }
      }
      else if (i != 0)
      {
        this.jdField_b_of_type_ComTencentAelightCameraAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.remove(i);
        this.jdField_b_of_type_ComTencentAelightCameraAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.add(0, paramAEMaterialMetaData);
        n();
      }
      if (QLog.isColorLevel())
      {
        paramAEMaterialMetaData = new StringBuilder();
        paramAEMaterialMetaData.append("setCurrentTemplateInfoToRecent index=");
        paramAEMaterialMetaData.append(i);
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
      str = paramAEMaterialMetaData.k;
    }
    localStringBuilder.append(str);
    AEQLog.b("AEMaterialManager", localStringBuilder.toString());
    jdField_b_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData = paramAEMaterialMetaData;
    jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData = null;
    int i;
    if (paramBoolean) {
      i = 1024;
    } else {
      i = 1025;
    }
    a(i, null);
  }
  
  public void b(String paramString)
  {
    try
    {
      paramString = a(new File(paramString));
      if ((paramString != null) && (paramString.size() != 0)) {
        paramString = a(paramString, HardCodeUtil.a(2064515212));
      } else {
        paramString = a(f(), HardCodeUtil.a(2064515211));
      }
      ArrayList localArrayList = new ArrayList();
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        AEMaterialMetaData localAEMaterialMetaData = (AEMaterialMetaData)paramString.next();
        if ((localArrayList.size() < 10) && (localAEMaterialMetaData != null) && (localAEMaterialMetaData.k != null) && (localAEMaterialMetaData.m != null)) {
          localArrayList.add(new AEMaterialOnShow(localAEMaterialMetaData.k, localAEMaterialMetaData.m));
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
  
  public void c()
  {
    AEQLog.b("AEMaterialManager", "onConfigRequestCancel---notify all wait thread");
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.notifyAll();
      return;
    }
  }
  
  public void d()
  {
    ??? = this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialCategory;
    if (??? == null) {
      return;
    }
    if ((((AEMaterialCategory)???).jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      Object localObject3 = this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (AEMaterialMetaData)((Iterator)localObject3).next();
        if ((!TextUtils.isEmpty(((AEMaterialMetaData)localObject4).k)) && (!((AEMaterialMetaData)localObject4).equals(AEMaterialMetaData.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData)))
        {
          localStringBuilder1.append(((AEMaterialMetaData)localObject4).k);
          localStringBuilder1.append("|");
          localStringBuilder1.append(((AEMaterialMetaData)localObject4).jdField_b_of_type_Int);
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
  
  public void e()
  {
    ??? = this.jdField_b_of_type_ComTencentAelightCameraAeDataAEMaterialCategory;
    if ((??? != null) && (((AEMaterialCategory)???).jdField_a_of_type_JavaUtilList != null))
    {
      if (this.jdField_b_of_type_ComTencentAelightCameraAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.isEmpty()) {
        return;
      }
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        Object localObject3 = this.jdField_b_of_type_ComTencentAelightCameraAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (AEMaterialMetaData)((Iterator)localObject3).next();
          if ((!TextUtils.isEmpty(((AEMaterialMetaData)localObject4).k)) && (!((AEMaterialMetaData)localObject4).equals(AEMaterialMetaData.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData)))
          {
            localStringBuilder1.append(((AEMaterialMetaData)localObject4).k);
            localStringBuilder1.append("|");
            localStringBuilder1.append(((AEMaterialMetaData)localObject4).jdField_b_of_type_Int);
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
  
  public void f()
  {
    jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData = null;
  }
  
  @Deprecated
  public void forceInit() {}
  
  public void g()
  {
    jdField_b_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData = null;
  }
  
  @Deprecated
  protected void initIndeed() {}
  
  @Deprecated
  public void onInit() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.data.AEMaterialManager
 * JD-Core Version:    0.7.0.1
 */