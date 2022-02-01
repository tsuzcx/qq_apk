import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import com.tencent.ttpic.baseutils.device.GpuScopeAttrs;
import com.tencent.ttpic.baseutils.device.GpuScopeAttrs.GpuBean.DeviceModel;
import com.tencent.ttpic.openapi.initializer.Ace3DEngineInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.openapi.model.FaceStyleItem.STYLE_CHANGE_TYPE;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.util.GsonUtils;
import dov.com.qq.im.ae.data.AEMaterialConfigParser;
import dov.com.qq.im.ae.data.AEMaterialConfigParser.AEMaterialConfigParseException;
import dov.com.qq.im.ae.data.AEMaterialManager.1;
import dov.com.qq.im.ae.data.AEMaterialManager.3;
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
import org.jetbrains.annotations.NotNull;

public class boqr
  extends bpmq
{
  private static boqu jdField_a_of_type_Boqu;
  private bczq jdField_a_of_type_Bczq;
  private boqq jdField_a_of_type_Boqq = new boqq(d());
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString = "";
  private final List<boqq> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private volatile boolean jdField_a_of_type_Boolean;
  private boqq jdField_b_of_type_Boqq;
  private final Object jdField_b_of_type_JavaLangObject = new Object();
  private final List<boqq> jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private final Object jdField_c_of_type_JavaLangObject = new Object();
  private final List<boqq> jdField_c_of_type_JavaUtilList = new ArrayList();
  private final Object jdField_d_of_type_JavaLangObject = new Object();
  private final List<boqu> jdField_d_of_type_JavaUtilList = new ArrayList();
  private final List<boqu> e = new ArrayList();
  
  public boqr()
  {
    this.jdField_a_of_type_Boqq.jdField_a_of_type_JavaUtilList = new ArrayList(100);
    this.jdField_b_of_type_Boqq = new boqq(d());
    this.jdField_b_of_type_Boqq.jdField_a_of_type_JavaUtilList = new ArrayList(100);
  }
  
  private int a(List<boqu> paramList, String paramString)
  {
    int j;
    if ((paramList == null) || (paramList.size() <= 0))
    {
      j = -1;
      return j;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramList.size()) {
        break label61;
      }
      j = i;
      if (((boqu)paramList.get(i)).jdField_a_of_type_JavaLangString.equals(paramString)) {
        break;
      }
      i += 1;
    }
    label61:
    return -1;
  }
  
  public static boqu a()
  {
    return jdField_a_of_type_Boqu;
  }
  
  private boqu a(boqu paramboqu)
  {
    Object localObject1 = null;
    Iterator localIterator1 = this.jdField_a_of_type_JavaUtilList.iterator();
    if (localIterator1.hasNext())
    {
      Object localObject2 = (boqq)localIterator1.next();
      int i;
      if (((boqq)localObject2).jdField_a_of_type_JavaUtilList != null)
      {
        Iterator localIterator2 = ((boqq)localObject2).jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator2.hasNext())
        {
          localObject2 = (boqu)localIterator2.next();
          if (((boqu)localObject2).equals(paramboqu))
          {
            i = 1;
            localObject1 = localObject2;
          }
        }
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (i != 0)
        {
          return localObject1;
          localObject2 = localObject1;
        }
        localObject1 = localObject2;
        break;
        i = 0;
      }
    }
    return localObject1;
  }
  
  private boqu a(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      boqu localboqu;
      do
      {
        Iterator localIterator1 = this.jdField_b_of_type_JavaUtilList.iterator();
        Iterator localIterator2;
        while (!localIterator2.hasNext())
        {
          if (!localIterator1.hasNext()) {
            break;
          }
          localIterator2 = ((boqq)localIterator1.next()).jdField_a_of_type_JavaUtilList.iterator();
        }
        localboqu = (boqu)localIterator2.next();
      } while (!localboqu.jdField_a_of_type_JavaLangString.equals(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("AEMaterialManager", 2, "getNormalStickerMaterial---found id=" + paramString);
      }
      return localboqu;
      return null;
    }
  }
  
  @Nullable
  public static String a(@Nullable ArrayList<boqv> paramArrayList)
  {
    if (paramArrayList != null) {
      return GsonUtils.obj2Json(paramArrayList);
    }
    return null;
  }
  
  @Nullable
  public static ArrayList<boqv> a(@Nullable String paramString)
  {
    return (ArrayList)GsonUtils.json2Obj(paramString, new boqs().getType());
  }
  
  private HashMap<String, boqq> a(@Nullable boqq paramboqq)
  {
    Object localObject2 = new StringBuilder().append("getSpecificCategory: item.name = ");
    if (paramboqq == null) {}
    boqq localboqq;
    for (Object localObject1 = "null";; localObject1 = paramboqq.jdField_b_of_type_JavaLangString)
    {
      bpam.a("AEMaterialManager", (String)localObject1);
      localObject1 = new HashMap();
      localObject2 = new boqq();
      localboqq = new boqq();
      if ((paramboqq != null) && (paramboqq.jdField_a_of_type_JavaUtilList != null)) {
        break;
      }
      bpam.d("AEMaterialManager", "getSpecificCategory: item.materialList == null!");
      ((HashMap)localObject1).put("normal_material", localObject2);
      ((HashMap)localObject1).put("circle_material", localboqq);
      return localObject1;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = paramboqq.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      boqu localboqu = (boqu)localIterator.next();
      if ("circleCamera".equals(localboqu.j)) {
        localArrayList2.add(localboqu);
      } else {
        localArrayList1.add(localboqu);
      }
    }
    ((boqq)localObject2).jdField_a_of_type_JavaUtilList = localArrayList1;
    ((boqq)localObject2).jdField_a_of_type_Int = paramboqq.jdField_a_of_type_Int;
    ((boqq)localObject2).jdField_b_of_type_JavaLangString = paramboqq.jdField_b_of_type_JavaLangString;
    ((boqq)localObject2).jdField_a_of_type_JavaLangString = paramboqq.jdField_a_of_type_JavaLangString;
    ((boqq)localObject2).jdField_a_of_type_Boolean = paramboqq.jdField_a_of_type_Boolean;
    ((boqq)localObject2).jdField_b_of_type_Int = paramboqq.jdField_b_of_type_Int;
    localboqq.jdField_a_of_type_JavaUtilList = localArrayList2;
    localboqq.jdField_a_of_type_Int = paramboqq.jdField_a_of_type_Int;
    localboqq.jdField_b_of_type_JavaLangString = paramboqq.jdField_b_of_type_JavaLangString;
    localboqq.jdField_a_of_type_JavaLangString = paramboqq.jdField_a_of_type_JavaLangString;
    localboqq.jdField_a_of_type_Boolean = paramboqq.jdField_a_of_type_Boolean;
    localboqq.jdField_b_of_type_Int = paramboqq.jdField_b_of_type_Int;
    ((HashMap)localObject1).put("normal_material", localObject2);
    ((HashMap)localObject1).put("circle_material", localboqq);
    return localObject1;
  }
  
  private List<boqq> a(File paramFile)
  {
    ArrayList localArrayList = new ArrayList();
    paramFile = brhn.a(paramFile);
    if (TextUtils.isEmpty(paramFile)) {}
    do
    {
      return localArrayList;
      paramFile = AEMaterialConfigParser.a(paramFile);
    } while ((paramFile == null) || (paramFile.isEmpty()));
    return paramFile;
  }
  
  private List<boqq> a(File paramFile1, File paramFile2)
  {
    paramFile1 = a(paramFile1);
    List localList = a(paramFile2);
    if ((localList == null) || (localList.isEmpty())) {
      return paramFile1;
    }
    Iterator localIterator1 = paramFile1.iterator();
    Iterator localIterator2;
    if (localIterator1.hasNext())
    {
      paramFile2 = (boqq)localIterator1.next();
      localIterator2 = localList.iterator();
      do
      {
        if (!localIterator2.hasNext()) {
          break;
        }
        paramFile1 = (boqq)localIterator2.next();
      } while (!paramFile1.jdField_b_of_type_JavaLangString.equals(paramFile2.jdField_b_of_type_JavaLangString));
    }
    for (;;)
    {
      if (paramFile1 == null)
      {
        paramFile1 = paramFile2.jdField_a_of_type_JavaUtilList.iterator();
        while (paramFile1.hasNext()) {
          c((boqu)paramFile1.next());
        }
        break;
      }
      localIterator2 = paramFile2.jdField_a_of_type_JavaUtilList.iterator();
      label149:
      boqu localboqu;
      if (localIterator2.hasNext())
      {
        localboqu = (boqu)localIterator2.next();
        Iterator localIterator3 = paramFile1.jdField_a_of_type_JavaUtilList.iterator();
        do
        {
          if (!localIterator3.hasNext()) {
            break;
          }
          paramFile2 = (boqu)localIterator3.next();
        } while (!localboqu.jdField_a_of_type_JavaLangString.equals(paramFile2.jdField_a_of_type_JavaLangString));
      }
      for (;;)
      {
        if (paramFile2 == null)
        {
          c(localboqu);
          break label149;
        }
        if (localboqu.jdField_e_of_type_JavaLangString.equals(paramFile2.jdField_e_of_type_JavaLangString)) {
          break label149;
        }
        c(localboqu);
        break label149;
        break;
        return localList;
        paramFile2 = null;
      }
      paramFile1 = null;
    }
  }
  
  private List<boqu> a(List<boqu> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      boqu localboqu = (boqu)paramList.next();
      if (localboqu.jdField_a_of_type_JavaLangString.contains("_3DFaceFila"))
      {
        Ace3DEngineInitializer localAce3DEngineInitializer = FeatureManager.Features.ACE_3D_ENGINE;
        if (!Ace3DEngineInitializer.supportAceEngine()) {}
      }
      else if ((!localboqu.jdField_a_of_type_JavaLangString.contains("_haircolor")) || ((DeviceUtils.hasDeviceNormal(BaseApplicationImpl.getContext())) && ((GpuScopeAttrs.getInstance().getDeviceModel() == null) || (GpuScopeAttrs.getInstance().getDeviceModel().hairColor))))
      {
        if (i >= 10) {
          break;
        }
        localArrayList.add(localboqu);
        i += 1;
      }
    }
    return localArrayList;
  }
  
  private List<boqu> a(List<boqq> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.jdField_b_of_type_JavaLangObject;
    if (paramList != null) {}
    try
    {
      if (paramList.size() > paramInt)
      {
        paramList = (boqq)paramList.get(paramInt);
        if (paramList != null)
        {
          localArrayList.addAll(paramList.jdField_a_of_type_JavaUtilList);
          if ((localArrayList.size() > 0) && (((boqu)localArrayList.get(0)).equals(boqu.jdField_a_of_type_Boqu))) {
            localArrayList.remove(0);
          }
        }
      }
      return new ArrayList(localArrayList);
    }
    finally {}
  }
  
  private List<boqu> a(List<boqq> paramList, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        boqq localboqq = (boqq)paramList.next();
        if (localboqq.jdField_b_of_type_JavaLangString.equals(paramString))
        {
          localArrayList.addAll(localboqq.jdField_a_of_type_JavaUtilList);
          if ((localArrayList.size() > 0) && (((boqu)localArrayList.get(0)).equals(boqu.jdField_a_of_type_Boqu))) {
            localArrayList.remove(0);
          }
        }
      }
      return new ArrayList(localArrayList);
    }
  }
  
  public static boolean a()
  {
    boqu localboqu = a();
    return (localboqu != null) && (!localboqu.equals(boqu.jdField_a_of_type_Boqu)) && (localboqu.jdField_f_of_type_Int != 0);
  }
  
  /* Error */
  public static boolean a(boqu paramboqu)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +15 -> 19
    //   7: aload_0
    //   8: getfield 320	boqu:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   11: invokestatic 226	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: istore_1
    //   15: iload_1
    //   16: ifeq +10 -> 26
    //   19: iconst_0
    //   20: istore_1
    //   21: ldc 2
    //   23: monitorexit
    //   24: iload_1
    //   25: ireturn
    //   26: aload_0
    //   27: invokestatic 322	boqr:b	(Lboqu;)Z
    //   30: istore_1
    //   31: goto -10 -> 21
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	paramboqu	boqu
    //   14	17	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   7	15	34	finally
    //   26	31	34	finally
  }
  
  public static boolean a(VideoMaterial paramVideoMaterial)
  {
    return (VideoMaterialUtil.isAnimojiMaterial(paramVideoMaterial)) || (VideoMaterialUtil.isSegmentMaterial(paramVideoMaterial)) || (VideoMaterialUtil.isGestureDetectMaterial(paramVideoMaterial)) || (VideoMaterialUtil.isAudio2textMaterial(paramVideoMaterial)) || (VideoMaterialUtil.needVoiceChange(paramVideoMaterial)) || (VideoMaterialUtil.isParticleMaterial(paramVideoMaterial)) || (VideoMaterialUtil.isRapidNetMaterial(paramVideoMaterial)) || (VideoMaterialUtil.isGenderDetect(paramVideoMaterial)) || (VideoMaterialUtil.isGenderSwitchMaterial(paramVideoMaterial)) || (VideoMaterialUtil.isEmotionDectectMaterial(paramVideoMaterial)) || (VideoMaterialUtil.isPagMaterial(paramVideoMaterial)) || (VideoMaterialUtil.isHairSegMaterial(paramVideoMaterial)) || (VideoMaterialUtil.is3DMaterial(paramVideoMaterial)) || (VideoMaterialUtil.isTNNMaterial(paramVideoMaterial, FaceStyleItem.STYLE_CHANGE_TYPE.CHILD_STYLE)) || (VideoMaterialUtil.isTNNMaterial(paramVideoMaterial, FaceStyleItem.STYLE_CHANGE_TYPE.GENDER_SWITCH)) || (VideoMaterialUtil.isTNNMaterial(paramVideoMaterial, FaceStyleItem.STYLE_CHANGE_TYPE.CARTOON_STYLE)) || (VideoMaterialUtil.isTNNMaterial(paramVideoMaterial, FaceStyleItem.STYLE_CHANGE_TYPE.FACE_CHANGE)) || (VideoMaterialUtil.isCatMaterial(paramVideoMaterial)) || (VideoMaterialUtil.needVoiceChange(paramVideoMaterial)) || (VideoMaterialUtil.isFilamentMaterial(paramVideoMaterial));
  }
  
  private boqu b(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      boqu localboqu;
      do
      {
        Iterator localIterator1 = this.jdField_c_of_type_JavaUtilList.iterator();
        Iterator localIterator2;
        while (!localIterator2.hasNext())
        {
          if (!localIterator1.hasNext()) {
            break;
          }
          localIterator2 = ((boqq)localIterator1.next()).jdField_a_of_type_JavaUtilList.iterator();
        }
        localboqu = (boqu)localIterator2.next();
      } while (!localboqu.jdField_a_of_type_JavaLangString.equals(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("AEMaterialManager", 2, "getCircleStickerMaterial---found id=" + paramString);
      }
      return localboqu;
      return null;
    }
  }
  
  public static String b()
  {
    File localFile = new File(boev.jdField_f_of_type_JavaLangString);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return new File(localFile.getPath(), "camera_story_update_template.json").getPath();
  }
  
  private void b(AppInterface paramAppInterface, String paramString, boqu paramboqu, borc paramborc)
  {
    bora.a(paramAppInterface, paramboqu, paramString, new boqt(this, paramborc));
    paramString = new StringBuilder().append("【START】startDownloadMaterial :");
    if (paramboqu == null) {}
    for (paramAppInterface = "null";; paramAppInterface = paramboqu.jdField_a_of_type_JavaLangString)
    {
      bpam.b("AEMaterialManager", paramAppInterface);
      return;
    }
  }
  
  public static boolean b()
  {
    try
    {
      Ace3DEngineInitializer localAce3DEngineInitializer = FeatureManager.Features.ACE_3D_ENGINE;
      boolean bool = Ace3DEngineInitializer.supportAceEngine();
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  private static boolean b(boqu paramboqu)
  {
    boolean bool = false;
    Object localObject = paramboqu.a();
    File localFile1 = new File((String)localObject, "params.json");
    localObject = new File((String)localObject, "params.dat");
    if ((!localFile1.exists()) && (!((File)localObject).exists()))
    {
      try
      {
        File localFile2 = new File(paramboqu.c());
        if (!localFile2.exists()) {
          return false;
        }
        nof.a(localFile2, paramboqu.b());
        return true;
      }
      catch (Exception paramboqu)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AEMaterialManager", 2, "judgeTemplateUsable unZipFile exp:", paramboqu);
        }
        if (localFile1.exists()) {
          break label110;
        }
      }
      if (((File)localObject).exists()) {
        label110:
        return true;
      }
    }
    else
    {
      bool = true;
    }
    return bool;
  }
  
  public static String c()
  {
    File localFile = new File(boev.d);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile.getPath();
  }
  
  private List<boqq> c()
  {
    Object localObject2 = new File(boev.jdField_f_of_type_JavaLangString, "camera_story_update_template.json");
    Object localObject1 = new File(boev.jdField_f_of_type_JavaLangString, "camera_story_default_template.json");
    if (!((File)localObject2).exists())
    {
      if (!((File)localObject1).exists())
      {
        localObject1 = f();
        bpam.a("AEMaterialManager", "readAndParseConfigFile -> oldJson not exist, newJson not exist, use Json from assets ");
        k();
        return localObject1;
      }
      try
      {
        localObject2 = a((File)localObject1);
        bpam.a("AEMaterialManager", "readAndParseConfigFile -> oldJson exists, newJson not exist, use oldJson");
        return localObject2;
      }
      catch (AEMaterialConfigParser.AEMaterialConfigParseException localAEMaterialConfigParseException3)
      {
        bhmi.d(((File)localObject1).getPath());
        localObject1 = f();
        bpam.d("AEMaterialManager", "readAndParseConfigFile -> oldJson exists, newJson not exist, exception:" + localAEMaterialConfigParseException3.toString());
        k();
        return localObject1;
      }
    }
    List localList2;
    List localList1;
    if (!((File)localObject1).exists()) {
      try
      {
        localList2 = a(localAEMaterialConfigParseException3);
        bhmi.b(localAEMaterialConfigParseException3.getPath(), ((File)localObject1).getPath());
        bpam.a("AEMaterialManager", "readAndParseConfigFile -> oldJson not exist, use newJson ");
        return localList2;
      }
      catch (AEMaterialConfigParser.AEMaterialConfigParseException localAEMaterialConfigParseException1)
      {
        bhmi.d(localAEMaterialConfigParseException3.getPath());
        localList1 = f();
        bpam.d("AEMaterialManager", "readAndParseConfigFile -> oldJson not exists: exception:" + localAEMaterialConfigParseException1.toString());
        k();
        return localList1;
      }
    }
    try
    {
      localList2 = a(localAEMaterialConfigParseException1, localList1);
      bhmi.d(localAEMaterialConfigParseException1.getPath());
      bhmi.b(localList1.getPath(), localAEMaterialConfigParseException1.getPath());
      bpam.a("AEMaterialManager", "readAndParseConfigFile -> try check update ");
      return localList2;
    }
    catch (AEMaterialConfigParser.AEMaterialConfigParseException localAEMaterialConfigParseException2)
    {
      localList1 = f();
      bpam.d("AEMaterialManager", "loadMaterialListFromAssets  -> oldJson exists: exception:" + localAEMaterialConfigParseException2.toString());
      k();
    }
    return localList1;
  }
  
  private void c(boqu paramboqu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEMaterialManager", 2, "deleteMaterialFolder: " + paramboqu.jdField_a_of_type_JavaLangString);
    }
    File localFile = new File(boev.jdField_e_of_type_JavaLangString, paramboqu.jdField_a_of_type_JavaLangString);
    if (localFile.exists()) {
      bhmi.a(localFile.getPath());
    }
    paramboqu = new File(boev.d, paramboqu.jdField_a_of_type_JavaLangString);
    if (paramboqu.exists()) {
      bhmi.a(paramboqu.getPath());
    }
  }
  
  /* Error */
  @WorkerThread
  private void c(boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 496	java/lang/System:currentTimeMillis	()J
    //   3: lstore_2
    //   4: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +29 -> 36
    //   10: ldc 130
    //   12: iconst_2
    //   13: new 132	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   20: ldc_w 498
    //   23: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: iload_1
    //   27: invokevirtual 501	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   30: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: aload_0
    //   37: monitorenter
    //   38: aload_0
    //   39: getfield 502	boqr:jdField_a_of_type_Boolean	Z
    //   42: ifeq +18 -> 60
    //   45: iload_1
    //   46: ifne +14 -> 60
    //   49: ldc 130
    //   51: ldc_w 504
    //   54: invokestatic 424	bpam:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: aload_0
    //   61: iconst_1
    //   62: putfield 502	boqr:jdField_a_of_type_Boolean	Z
    //   65: aload_0
    //   66: monitorexit
    //   67: ldc 130
    //   69: new 132	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   76: ldc_w 506
    //   79: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokestatic 508	boqr:b	()Z
    //   85: invokevirtual 501	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   88: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokestatic 424	bpam:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: aload_0
    //   95: getfield 50	boqr:jdField_d_of_type_JavaLangObject	Ljava/lang/Object;
    //   98: astore 6
    //   100: aload 6
    //   102: monitorenter
    //   103: aload_0
    //   104: invokespecial 510	boqr:c	()Ljava/util/List;
    //   107: astore 7
    //   109: aload 6
    //   111: monitorexit
    //   112: aload 7
    //   114: ifnull +13 -> 127
    //   117: aload 7
    //   119: invokeinterface 237 1 0
    //   124: ifeq +27 -> 151
    //   127: ldc 130
    //   129: ldc_w 512
    //   132: invokestatic 187	bpam:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: return
    //   136: astore 6
    //   138: aload_0
    //   139: monitorexit
    //   140: aload 6
    //   142: athrow
    //   143: astore 7
    //   145: aload 6
    //   147: monitorexit
    //   148: aload 7
    //   150: athrow
    //   151: aload_0
    //   152: getfield 48	boqr:jdField_c_of_type_JavaLangObject	Ljava/lang/Object;
    //   155: astore 6
    //   157: aload 6
    //   159: monitorenter
    //   160: aload_0
    //   161: getfield 28	boqr:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   164: invokeinterface 515 1 0
    //   169: aload_0
    //   170: getfield 30	boqr:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   173: invokeinterface 515 1 0
    //   178: aload_0
    //   179: getfield 35	boqr:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   182: invokeinterface 515 1 0
    //   187: aload_0
    //   188: getfield 28	boqr:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   191: aload 7
    //   193: invokeinterface 295 2 0
    //   198: pop
    //   199: aload 7
    //   201: invokeinterface 111 1 0
    //   206: astore 7
    //   208: aload 7
    //   210: invokeinterface 117 1 0
    //   215: ifeq +217 -> 432
    //   218: aload 7
    //   220: invokeinterface 121 1 0
    //   225: checkcast 63	boqq
    //   228: astore 8
    //   230: aload 8
    //   232: ifnull -24 -> 208
    //   235: aload_0
    //   236: aload 8
    //   238: invokespecial 517	boqr:a	(Lboqq;)Ljava/util/HashMap;
    //   241: astore 10
    //   243: aload 10
    //   245: ldc 189
    //   247: invokevirtual 520	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   250: checkcast 63	boqq
    //   253: astore 9
    //   255: aload 10
    //   257: ldc 195
    //   259: invokevirtual 520	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   262: checkcast 63	boqq
    //   265: astore 10
    //   267: ldc 130
    //   269: new 132	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   276: ldc_w 522
    //   279: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: aload 10
    //   284: invokevirtual 523	java/lang/Object:toString	()Ljava/lang/String;
    //   287: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokestatic 179	bpam:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   296: aload 10
    //   298: ifnull +36 -> 334
    //   301: aload 10
    //   303: getfield 75	boqq:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   306: ifnull +28 -> 334
    //   309: aload 10
    //   311: getfield 75	boqq:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   314: invokeinterface 85 1 0
    //   319: ifle +15 -> 334
    //   322: aload_0
    //   323: getfield 35	boqr:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   326: aload 10
    //   328: invokeinterface 205 2 0
    //   333: pop
    //   334: aload 9
    //   336: ifnull +36 -> 372
    //   339: aload 9
    //   341: getfield 75	boqq:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   344: ifnull +28 -> 372
    //   347: aload 9
    //   349: getfield 75	boqq:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   352: invokeinterface 85 1 0
    //   357: ifle +15 -> 372
    //   360: aload_0
    //   361: getfield 30	boqr:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   364: aload 9
    //   366: invokeinterface 205 2 0
    //   371: pop
    //   372: aload 8
    //   374: getfield 75	boqq:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   377: invokeinterface 111 1 0
    //   382: astore 8
    //   384: aload 8
    //   386: invokeinterface 117 1 0
    //   391: ifeq -183 -> 208
    //   394: aload 8
    //   396: invokeinterface 121 1 0
    //   401: checkcast 91	boqu
    //   404: astore 9
    //   406: aload 9
    //   408: ifnull -24 -> 384
    //   411: aload 9
    //   413: aload 9
    //   415: invokestatic 525	boqr:a	(Lboqu;)Z
    //   418: putfield 527	boqu:jdField_e_of_type_Boolean	Z
    //   421: goto -37 -> 384
    //   424: astore 7
    //   426: aload 6
    //   428: monitorexit
    //   429: aload 7
    //   431: athrow
    //   432: aload 6
    //   434: monitorexit
    //   435: aload_0
    //   436: invokespecial 530	boqr:m	()V
    //   439: aload_0
    //   440: invokespecial 533	boqr:n	()V
    //   443: aload_0
    //   444: getfield 48	boqr:jdField_c_of_type_JavaLangObject	Ljava/lang/Object;
    //   447: astore 6
    //   449: aload 6
    //   451: monitorenter
    //   452: aload_0
    //   453: getfield 30	boqr:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   456: invokeinterface 85 1 0
    //   461: ifle +43 -> 504
    //   464: aload_0
    //   465: invokespecial 66	boqr:d	()Ljava/lang/String;
    //   468: aload_0
    //   469: getfield 30	boqr:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   472: iconst_0
    //   473: invokeinterface 89 2 0
    //   478: checkcast 63	boqq
    //   481: getfield 197	boqq:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   484: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   487: ifne +17 -> 504
    //   490: aload_0
    //   491: getfield 30	boqr:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   494: iconst_0
    //   495: aload_0
    //   496: getfield 71	boqr:jdField_a_of_type_Boqq	Lboqq;
    //   499: invokeinterface 536 3 0
    //   504: aload_0
    //   505: getfield 35	boqr:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   508: invokeinterface 85 1 0
    //   513: ifle +43 -> 556
    //   516: aload_0
    //   517: invokespecial 66	boqr:d	()Ljava/lang/String;
    //   520: aload_0
    //   521: getfield 35	boqr:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   524: iconst_0
    //   525: invokeinterface 89 2 0
    //   530: checkcast 63	boqq
    //   533: getfield 197	boqq:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   536: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   539: ifne +17 -> 556
    //   542: aload_0
    //   543: getfield 35	boqr:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   546: iconst_0
    //   547: aload_0
    //   548: getfield 77	boqr:jdField_b_of_type_Boqq	Lboqq;
    //   551: invokeinterface 536 3 0
    //   556: aload_0
    //   557: invokespecial 539	boqr:l	()V
    //   560: aload 6
    //   562: monitorexit
    //   563: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   566: ifeq +43 -> 609
    //   569: invokestatic 496	java/lang/System:currentTimeMillis	()J
    //   572: lstore 4
    //   574: ldc 130
    //   576: iconst_2
    //   577: new 132	java/lang/StringBuilder
    //   580: dup
    //   581: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   584: ldc_w 541
    //   587: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: lload 4
    //   592: lload_2
    //   593: lsub
    //   594: invokevirtual 544	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   597: ldc_w 546
    //   600: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   606: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   609: aload_0
    //   610: invokespecial 549	boqr:o	()V
    //   613: return
    //   614: astore 7
    //   616: aload 6
    //   618: monitorexit
    //   619: aload 7
    //   621: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	622	0	this	boqr
    //   0	622	1	paramBoolean	boolean
    //   3	590	2	l1	long
    //   572	19	4	l2	long
    //   136	10	6	localObject2	Object
    //   107	11	7	localList	List
    //   143	57	7	localCollection	Collection
    //   206	13	7	localIterator	Iterator
    //   424	6	7	localObject4	Object
    //   614	6	7	localObject5	Object
    //   228	167	8	localObject6	Object
    //   253	161	9	localObject7	Object
    //   241	86	10	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   38	45	136	finally
    //   49	59	136	finally
    //   60	67	136	finally
    //   138	140	136	finally
    //   103	112	143	finally
    //   145	148	143	finally
    //   160	208	424	finally
    //   208	230	424	finally
    //   235	296	424	finally
    //   301	334	424	finally
    //   339	372	424	finally
    //   372	384	424	finally
    //   384	406	424	finally
    //   411	421	424	finally
    //   426	429	424	finally
    //   432	435	424	finally
    //   452	504	614	finally
    //   504	556	614	finally
    //   556	563	614	finally
    //   616	619	614	finally
  }
  
  private boolean c()
  {
    return (this.jdField_a_of_type_Boqq != null) && (this.jdField_a_of_type_Boqq.jdField_a_of_type_JavaUtilList.size() >= 100);
  }
  
  private String d()
  {
    return anzj.a(2131708699);
  }
  
  private List<boqu> d()
  {
    return a(this.jdField_b_of_type_JavaUtilList, anzj.a(2131698927));
  }
  
  private boolean d()
  {
    return (this.jdField_b_of_type_Boqq != null) && (this.jdField_b_of_type_Boqq.jdField_a_of_type_JavaUtilList != null) && (this.jdField_b_of_type_Boqq.jdField_a_of_type_JavaUtilList.size() >= 100);
  }
  
  private List<boqu> e()
  {
    return a(this.jdField_c_of_type_JavaUtilList, 1);
  }
  
  private List<boqq> f()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = boqg.b(a().getApp());
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      return localArrayList;
      try
      {
        localObject = AEMaterialConfigParser.a((String)localObject);
        if ((localObject != null) && (!((List)localObject).isEmpty())) {
          return localObject;
        }
      }
      catch (AEMaterialConfigParser.AEMaterialConfigParseException localAEMaterialConfigParseException)
      {
        QLog.d("AEMaterialManager", 4, "loadMaterialListFromAssets err=" + localAEMaterialConfigParseException.getMessage());
      }
    }
    return localArrayList;
  }
  
  private void k()
  {
    bozz.a().a("CameraModuleSvc.GetCompressedCategoryMaterialMqStoryCamera", 4);
  }
  
  private void l()
  {
    List localList1 = d();
    List localList2 = e();
    this.jdField_d_of_type_JavaUtilList.clear();
    this.jdField_d_of_type_JavaUtilList.addAll(a(localList1));
    this.e.clear();
    this.e.addAll(a(localList2));
  }
  
  private void m()
  {
    int i = 0;
    if (this.jdField_a_of_type_Boqq == null) {}
    do
    {
      return;
      ??? = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      ??? = bozz.a().a("recent_template_list_new" + (String)???, null, 0);
      if (QLog.isColorLevel()) {
        QLog.d("AEMaterialManager", 2, "loadRecentMaterial list=" + (String)???);
      }
    } while (??? == null);
    String[] arrayOfString = ((String)???).split("\\$");
    for (;;)
    {
      Object localObject3;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_Boqq.jdField_a_of_type_JavaUtilList.clear();
        if (i >= arrayOfString.length) {
          break label233;
        }
        localObject3 = arrayOfString[i].split("\\|");
        if ((localObject3 == null) || (localObject3.length != 2)) {
          break label236;
        }
        localObject3 = a(localObject3[0]);
        if (localObject3 == null) {
          break label236;
        }
        if (this.jdField_a_of_type_Boqq.jdField_a_of_type_JavaUtilList.size() >= 100) {
          return;
        }
      }
      if ((!this.jdField_a_of_type_Boqq.jdField_a_of_type_JavaUtilList.contains(localObject3)) && (!((boqu)localObject3).jdField_a_of_type_JavaLangString.equals("0")))
      {
        this.jdField_a_of_type_Boqq.jdField_a_of_type_JavaUtilList.add(localObject3);
        break label236;
        label233:
        return;
      }
      label236:
      i += 1;
    }
  }
  
  private void n()
  {
    int i = 0;
    if (this.jdField_b_of_type_Boqq == null) {}
    do
    {
      return;
      ??? = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      ??? = bozz.a().a("recent_circle_template_list_new" + (String)???, null, 0);
      if (QLog.isColorLevel()) {
        QLog.d("AEMaterialManager", 2, "loadCircleRecentMaterial list=" + (String)???);
      }
    } while (??? == null);
    String[] arrayOfString = ((String)???).split("\\$");
    for (;;)
    {
      Object localObject3;
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        this.jdField_b_of_type_Boqq.jdField_a_of_type_JavaUtilList.clear();
        if (i >= arrayOfString.length) {
          break label233;
        }
        localObject3 = arrayOfString[i].split("\\|");
        if ((localObject3 == null) || (localObject3.length != 2)) {
          break label236;
        }
        localObject3 = b(localObject3[0]);
        if (localObject3 == null) {
          break label236;
        }
        if (this.jdField_b_of_type_Boqq.jdField_a_of_type_JavaUtilList.size() >= 100) {
          return;
        }
      }
      if ((!this.jdField_b_of_type_Boqq.jdField_a_of_type_JavaUtilList.contains(localObject3)) && (!((boqu)localObject3).jdField_a_of_type_JavaLangString.equals("0")))
      {
        this.jdField_b_of_type_Boqq.jdField_a_of_type_JavaUtilList.add(localObject3);
        break label236;
        label233:
        return;
      }
      label236:
      i += 1;
    }
  }
  
  private void o()
  {
    if (a() != null) {
      a().notifyObservers(bpop.class, 3, true, null);
    }
    if (this.jdField_a_of_type_Bczq != null) {
      this.jdField_a_of_type_Bczq.a(116, null);
    }
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_Bczq != null) {
      this.jdField_a_of_type_Bczq.a(111, new Object[] { this.jdField_a_of_type_Boqq });
    }
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_Bczq != null) {
      this.jdField_a_of_type_Bczq.a(111, new Object[] { this.jdField_b_of_type_Boqq });
    }
  }
  
  public boqu a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Object localObject = this.jdField_c_of_type_JavaUtilList;; localObject = this.jdField_b_of_type_JavaUtilList)
    {
      localObject = ((List)localObject).iterator();
      boqq localboqq;
      boqu localboqu;
      int j;
      do
      {
        Iterator localIterator;
        while (!localIterator.hasNext())
        {
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localboqq = (boqq)((Iterator)localObject).next();
          } while ((localboqq == null) || (localboqq.jdField_a_of_type_JavaUtilList == null));
          localIterator = localboqq.jdField_a_of_type_JavaUtilList.iterator();
          i = 0;
        }
        localboqu = (boqu)localIterator.next();
        j = i + 1;
        int i = j;
      } while (!localboqu.jdField_a_of_type_JavaLangString.equals(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("QIMRedDotConfig_PTV", 2, "selectPtvTemplateInfo= " + localboqu);
      }
      localboqu.jdField_b_of_type_JavaLangString = localboqq.jdField_b_of_type_JavaLangString;
      localboqu.jdField_b_of_type_Int = j;
      return localboqu;
    }
    return null;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List<boqq> a()
  {
    return this.jdField_c_of_type_JavaUtilList;
  }
  
  public List<boqq> a(boolean paramBoolean)
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  @WorkerThread
  @NotNull
  public List<boqu> a(boolean paramBoolean1, boolean paramBoolean2)
  {
    bpam.b("AEMaterialManager", "loadDisplayHotList---requireServerData=" + paramBoolean1);
    if (paramBoolean1) {}
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
      {
        if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
        {
          if (bhnv.a()) {
            PeakAppInterface.a.a(1010);
          }
        }
        else {
          try
          {
            bpam.b("AEMaterialManager", "loadDisplayHotList---issue the request and wait");
            this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.wait(90000L);
            bpam.b("AEMaterialManager", "loadDisplayHotList---awake from waiting");
            c(false);
            if (!paramBoolean2) {
              break label140;
            }
            ??? = this.e;
            return new ArrayList((Collection)???);
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
            continue;
          }
        }
      }
      bpam.b("AEMaterialManager", "loadDisplayHotList---no network, skip request");
      continue;
      label140:
      ??? = this.jdField_d_of_type_JavaUtilList;
    }
  }
  
  @Deprecated
  public void a() {}
  
  public void a(int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_Bczq != null) {
        this.jdField_a_of_type_Bczq.a(paramInt);
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
    if (this.jdField_a_of_type_Bczq != null)
    {
      this.jdField_a_of_type_Bczq.a(paramInt, new Object[] { paramObject });
      if (QLog.isColorLevel()) {
        QLog.d("AEMaterialManager", 2, "notifyEventId eventId=" + paramInt);
      }
    }
  }
  
  public void a(bczs parambczs)
  {
    try
    {
      if (this.jdField_a_of_type_Bczq != null) {
        this.jdField_a_of_type_Bczq.a(parambczs);
      }
      return;
    }
    finally
    {
      parambczs = finally;
      throw parambczs;
    }
  }
  
  public void a(bczs parambczs, int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_Bczq == null) {
        this.jdField_a_of_type_Bczq = new bczq();
      }
      this.jdField_a_of_type_Bczq.a(parambczs, new int[] { paramInt });
      return;
    }
    finally {}
  }
  
  public void a(boqu paramboqu)
  {
    if (paramboqu == null) {}
    while (paramboqu.c()) {
      return;
    }
    if (this.jdField_a_of_type_Boqq == null)
    {
      m();
      return;
    }
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        i = a(this.jdField_a_of_type_Boqq.jdField_a_of_type_JavaUtilList, paramboqu.jdField_a_of_type_JavaLangString);
        if (i != -1) {
          break label183;
        }
        if (!c())
        {
          this.jdField_a_of_type_Boqq.jdField_a_of_type_JavaUtilList.add(0, paramboqu);
          p();
          if (QLog.isColorLevel()) {
            QLog.d("AEMaterialManager", 2, "setCurrentTemplateInfoToRecent not full");
          }
          if (QLog.isColorLevel()) {
            QLog.d("AEMaterialManager", 2, "setCurrentTemplateInfoToRecent index=" + i);
          }
          return;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("AEMaterialManager", 2, "setCurrentTemplateInfoToRecent full");
      }
      this.jdField_a_of_type_Boqq.jdField_a_of_type_JavaUtilList.remove(99);
      this.jdField_a_of_type_Boqq.jdField_a_of_type_JavaUtilList.add(0, paramboqu);
      p();
      continue;
      label183:
      if (i != 0)
      {
        this.jdField_a_of_type_Boqq.jdField_a_of_type_JavaUtilList.remove(i);
        this.jdField_a_of_type_Boqq.jdField_a_of_type_JavaUtilList.add(0, paramboqu);
        p();
      }
    }
  }
  
  public void a(boqu paramboqu, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("setSelectedMaterialAndNotify---info=");
    String str;
    if (paramboqu == null)
    {
      str = "null";
      bpam.b("AEMaterialManager", str + ", addToRecent=" + paramBoolean);
      jdField_a_of_type_Boqu = paramboqu;
      if (paramBoolean)
      {
        if (!"circleCamera".equals(paramboqu.j)) {
          break label87;
        }
        b(paramboqu);
      }
    }
    for (;;)
    {
      a(113, null);
      return;
      str = paramboqu.jdField_a_of_type_JavaLangString;
      break;
      label87:
      a(paramboqu);
    }
  }
  
  public void a(AppInterface paramAppInterface, boqu paramboqu, borc paramborc)
  {
    a(paramAppInterface, boev.d, paramboqu, paramborc);
  }
  
  public void a(AppInterface paramAppInterface, String paramString, boqu paramboqu, borc paramborc)
  {
    ThreadManager.excute(new AEMaterialManager.3(this, paramAppInterface, paramString, paramboqu, paramborc), 128, null, true);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    c(paramBoolean);
  }
  
  public List<boqq> b()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public List<boqu> b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (List localList = this.e;; localList = this.jdField_d_of_type_JavaUtilList) {
      return new ArrayList(localList);
    }
  }
  
  public void b(boqu paramboqu)
  {
    if (paramboqu == null) {}
    while (paramboqu.c()) {
      return;
    }
    if (this.jdField_b_of_type_Boqq == null)
    {
      n();
      return;
    }
    for (;;)
    {
      int i;
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        i = a(this.jdField_b_of_type_Boqq.jdField_a_of_type_JavaUtilList, paramboqu.jdField_a_of_type_JavaLangString);
        if (i != -1) {
          break label183;
        }
        if (!d())
        {
          this.jdField_b_of_type_Boqq.jdField_a_of_type_JavaUtilList.add(0, paramboqu);
          q();
          if (QLog.isColorLevel()) {
            QLog.d("AEMaterialManager", 2, "setCurrentTemplateInfoToRecent not full");
          }
          if (QLog.isColorLevel()) {
            QLog.d("AEMaterialManager", 2, "setCurrentTemplateInfoToRecent index=" + i);
          }
          return;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("AEMaterialManager", 2, "setCurrentTemplateInfoToRecent full");
      }
      this.jdField_b_of_type_Boqq.jdField_a_of_type_JavaUtilList.remove(99);
      this.jdField_b_of_type_Boqq.jdField_a_of_type_JavaUtilList.add(0, paramboqu);
      q();
      continue;
      label183:
      if (i != 0)
      {
        this.jdField_b_of_type_Boqq.jdField_a_of_type_JavaUtilList.remove(i);
        this.jdField_b_of_type_Boqq.jdField_a_of_type_JavaUtilList.add(0, paramboqu);
        q();
      }
    }
  }
  
  public void b(String paramString)
  {
    try
    {
      paramString = a(new File(paramString));
      if ((paramString != null) && (paramString.size() != 0)) {
        break label131;
      }
      paramString = a(f(), anzj.a(2131689727));
    }
    catch (AEMaterialConfigParser.AEMaterialConfigParseException paramString)
    {
      ArrayList localArrayList;
      for (;;)
      {
        paramString.printStackTrace();
        return;
        paramString = a(paramString, anzj.a(2131689728));
      }
      bozz.a().a("PhotoConst.ae_latest_material", a(localArrayList), 4);
      return;
    }
    catch (NullPointerException paramString)
    {
      label131:
      paramString.printStackTrace();
    }
    localArrayList = new ArrayList();
    paramString = paramString.iterator();
    while (paramString.hasNext())
    {
      boqu localboqu = (boqu)paramString.next();
      if ((localArrayList.size() < 10) && (localboqu != null) && (localboqu.jdField_a_of_type_JavaLangString != null) && (localboqu.c != null)) {
        localArrayList.add(new boqv(localboqu.jdField_a_of_type_JavaLangString, localboqu.c));
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    ThreadManager.excute(new AEMaterialManager.1(this, paramBoolean), 64, null, false);
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
  
  @Deprecated
  protected void d() {}
  
  @Deprecated
  public void e() {}
  
  public void f()
  {
    bpam.b("AEMaterialManager", "onConfigRequestDone---notify all wait thread");
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.notifyAll();
      return;
    }
  }
  
  public void g()
  {
    bpam.b("AEMaterialManager", "onConfigRequestCancel---notify all wait thread");
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.notifyAll();
      return;
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Boqq == null) {}
    while ((this.jdField_a_of_type_Boqq.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_Boqq.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localObject3 = this.jdField_a_of_type_Boqq.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        boqu localboqu = (boqu)((Iterator)localObject3).next();
        if ((!TextUtils.isEmpty(localboqu.jdField_a_of_type_JavaLangString)) && (!localboqu.equals(boqu.jdField_a_of_type_Boqu)))
        {
          localStringBuilder.append(localboqu.jdField_a_of_type_JavaLangString).append("|");
          localStringBuilder.append(localboqu.jdField_a_of_type_Int).append("$");
        }
      }
    }
    if (TextUtils.isEmpty(localObject2.toString())) {
      return;
    }
    Object localObject3 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    bozz.a().a("recent_template_list_new" + (String)localObject3, localObject2.toString(), 0);
    if (QLog.isColorLevel()) {
      QLog.d("AEMaterialManager", 2, "saveRecentTemplate list=" + localObject2.toString());
    }
  }
  
  public void i()
  {
    if ((this.jdField_b_of_type_Boqq == null) || (this.jdField_b_of_type_Boqq.jdField_a_of_type_JavaUtilList == null) || (this.jdField_b_of_type_Boqq.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return;
    }
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localObject3 = this.jdField_b_of_type_Boqq.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        boqu localboqu = (boqu)((Iterator)localObject3).next();
        if ((!TextUtils.isEmpty(localboqu.jdField_a_of_type_JavaLangString)) && (!localboqu.equals(boqu.jdField_a_of_type_Boqu)))
        {
          localStringBuilder.append(localboqu.jdField_a_of_type_JavaLangString).append("|");
          localStringBuilder.append(localboqu.jdField_a_of_type_Int).append("$");
        }
      }
    }
    if (TextUtils.isEmpty(localObject2.toString())) {
      return;
    }
    Object localObject3 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    bozz.a().a("recent_circle_template_list_new" + (String)localObject3, localObject2.toString(), 0);
    if (QLog.isColorLevel()) {
      QLog.d("AEMaterialManager", 2, "saveRecentTemplate list=" + localObject2.toString());
    }
  }
  
  public void j()
  {
    jdField_a_of_type_Boqu = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boqr
 * JD-Core Version:    0.7.0.1
 */