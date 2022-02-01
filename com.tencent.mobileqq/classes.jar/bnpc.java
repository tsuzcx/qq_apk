import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
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
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
import mqq.app.AppRuntime;

public class bnpc
  extends bokv
{
  private static bnpf jdField_a_of_type_Bnpf;
  private static VideoMaterial jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial;
  public static final Long a;
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private static bnpf jdField_b_of_type_Bnpf;
  private bcgy jdField_a_of_type_Bcgy;
  private bnpb jdField_a_of_type_Bnpb;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  public String a;
  private List<bnpb> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private bnpb jdField_b_of_type_Bnpb;
  private final Object jdField_b_of_type_JavaLangObject = new Object();
  public String b;
  private List<bnpb> jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private final Object jdField_c_of_type_JavaLangObject = new Object();
  public String c;
  private List<bnpb> jdField_c_of_type_JavaUtilList = new ArrayList();
  private final Object jdField_d_of_type_JavaLangObject = new Object();
  private List<bnpf> jdField_d_of_type_JavaUtilList = new LinkedList();
  
  static
  {
    jdField_a_of_type_JavaLangLong = Long.valueOf(2000L);
  }
  
  public bnpc()
  {
    this.jdField_a_of_type_JavaLangString = "recent_template_setting_new";
    this.jdField_b_of_type_JavaLangString = "recent_template_list_new";
    this.jdField_c_of_type_JavaLangString = "recent_circle_template_list_new";
    if (this.jdField_a_of_type_Bnpb == null)
    {
      this.jdField_a_of_type_Bnpb = new bnpb(c());
      this.jdField_a_of_type_Bnpb.jdField_a_of_type_JavaUtilList = new ArrayList(100);
    }
    if (this.jdField_b_of_type_Bnpb == null)
    {
      this.jdField_b_of_type_Bnpb = new bnpb(c());
      this.jdField_b_of_type_Bnpb.jdField_a_of_type_JavaUtilList = new ArrayList(100);
    }
  }
  
  private int a(List<bnpf> paramList, String paramString)
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
      if (((bnpf)paramList.get(i)).jdField_a_of_type_JavaLangString.equals(paramString)) {
        break;
      }
      i += 1;
    }
    label61:
    return -1;
  }
  
  public static bnpf a()
  {
    return jdField_b_of_type_Bnpf;
  }
  
  private bnpf a(bnpf parambnpf)
  {
    Object localObject1 = null;
    Iterator localIterator1 = this.jdField_a_of_type_JavaUtilList.iterator();
    if (localIterator1.hasNext())
    {
      Object localObject2 = (bnpb)localIterator1.next();
      int i;
      if (((bnpb)localObject2).jdField_a_of_type_JavaUtilList != null)
      {
        Iterator localIterator2 = ((bnpb)localObject2).jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator2.hasNext())
        {
          localObject2 = (bnpf)localIterator2.next();
          if (((bnpf)localObject2).equals(parambnpf))
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
  
  private bnpf a(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      bnpf localbnpf;
      do
      {
        Iterator localIterator1 = this.jdField_b_of_type_JavaUtilList.iterator();
        Iterator localIterator2;
        while (!localIterator2.hasNext())
        {
          if (!localIterator1.hasNext()) {
            break;
          }
          localIterator2 = ((bnpb)localIterator1.next()).jdField_a_of_type_JavaUtilList.iterator();
        }
        localbnpf = (bnpf)localIterator2.next();
      } while (!localbnpf.jdField_a_of_type_JavaLangString.equals(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("AEMaterialManager", 2, "existTemplateInfo id=" + paramString);
      }
      return localbnpf;
      return null;
    }
  }
  
  public static String a()
  {
    File localFile = new File(bndm.f);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return new File(localFile.getPath(), "camera_story_update_template.json").getPath();
  }
  
  @Nullable
  public static String a(@Nullable ArrayList<bnpj> paramArrayList)
  {
    if (paramArrayList != null) {
      return GsonUtils.obj2Json(paramArrayList);
    }
    return null;
  }
  
  @Nullable
  public static ArrayList<bnpj> a(@Nullable String paramString)
  {
    return (ArrayList)GsonUtils.json2Obj(paramString, new bnpd().getType());
  }
  
  private HashMap<String, bnpb> a(@Nullable bnpb parambnpb)
  {
    HashMap localHashMap = new HashMap();
    bnpb localbnpb1 = new bnpb();
    bnpb localbnpb2 = new bnpb();
    if ((parambnpb == null) || (parambnpb.jdField_a_of_type_JavaUtilList == null))
    {
      localHashMap.put("normal_material", localbnpb1);
      localHashMap.put("circle_material", localbnpb2);
      return localHashMap;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = parambnpb.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      bnpf localbnpf = (bnpf)localIterator.next();
      if ("circleCamera".equals(localbnpf.j)) {
        localArrayList2.add(localbnpf);
      } else {
        localArrayList1.add(localbnpf);
      }
    }
    localbnpb1.jdField_a_of_type_JavaUtilList = localArrayList1;
    localbnpb1.jdField_a_of_type_Int = parambnpb.jdField_a_of_type_Int;
    localbnpb1.jdField_b_of_type_JavaLangString = parambnpb.jdField_b_of_type_JavaLangString;
    localbnpb1.jdField_a_of_type_JavaLangString = parambnpb.jdField_a_of_type_JavaLangString;
    localbnpb1.jdField_a_of_type_Boolean = parambnpb.jdField_a_of_type_Boolean;
    localbnpb1.jdField_b_of_type_Int = parambnpb.jdField_b_of_type_Int;
    localbnpb2.jdField_a_of_type_JavaUtilList = localArrayList2;
    localbnpb2.jdField_a_of_type_Int = parambnpb.jdField_a_of_type_Int;
    localbnpb2.jdField_b_of_type_JavaLangString = parambnpb.jdField_b_of_type_JavaLangString;
    localbnpb2.jdField_a_of_type_JavaLangString = parambnpb.jdField_a_of_type_JavaLangString;
    localbnpb2.jdField_a_of_type_Boolean = parambnpb.jdField_a_of_type_Boolean;
    localbnpb2.jdField_b_of_type_Int = parambnpb.jdField_b_of_type_Int;
    localHashMap.put("normal_material", localbnpb1);
    localHashMap.put("circle_material", localbnpb2);
    return localHashMap;
  }
  
  private List<bnpb> a(File paramFile)
  {
    ArrayList localArrayList = new ArrayList();
    paramFile = bqgc.a(paramFile);
    if (TextUtils.isEmpty(paramFile)) {}
    do
    {
      return localArrayList;
      paramFile = AEMaterialConfigParser.a(paramFile);
    } while ((paramFile == null) || (paramFile.isEmpty()));
    return paramFile;
  }
  
  private List<bnpb> a(File paramFile1, File paramFile2)
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
      paramFile2 = (bnpb)localIterator1.next();
      localIterator2 = localList.iterator();
      do
      {
        if (!localIterator2.hasNext()) {
          break;
        }
        paramFile1 = (bnpb)localIterator2.next();
      } while (!paramFile1.jdField_b_of_type_JavaLangString.equals(paramFile2.jdField_b_of_type_JavaLangString));
    }
    for (;;)
    {
      if (paramFile1 == null)
      {
        paramFile1 = paramFile2.jdField_a_of_type_JavaUtilList.iterator();
        while (paramFile1.hasNext()) {
          c((bnpf)paramFile1.next());
        }
        break;
      }
      localIterator2 = paramFile2.jdField_a_of_type_JavaUtilList.iterator();
      label149:
      bnpf localbnpf;
      if (localIterator2.hasNext())
      {
        localbnpf = (bnpf)localIterator2.next();
        Iterator localIterator3 = paramFile1.jdField_a_of_type_JavaUtilList.iterator();
        do
        {
          if (!localIterator3.hasNext()) {
            break;
          }
          paramFile2 = (bnpf)localIterator3.next();
        } while (!localbnpf.jdField_a_of_type_JavaLangString.equals(paramFile2.jdField_a_of_type_JavaLangString));
      }
      for (;;)
      {
        if (paramFile2 == null)
        {
          c(localbnpf);
          break label149;
        }
        if (localbnpf.jdField_e_of_type_JavaLangString.equals(paramFile2.jdField_e_of_type_JavaLangString)) {
          break label149;
        }
        c(localbnpf);
        break label149;
        break;
        return localList;
        paramFile2 = null;
      }
      paramFile1 = null;
    }
  }
  
  private List<bnpf> a(List<bnpb> paramList, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        bnpb localbnpb = (bnpb)paramList.next();
        if (localbnpb.jdField_b_of_type_JavaLangString.equals(paramString))
        {
          localArrayList.addAll(localbnpb.jdField_a_of_type_JavaUtilList);
          if ((localArrayList.size() > 0) && (((bnpf)localArrayList.get(0)).equals(bnpf.jdField_a_of_type_Bnpf))) {
            localArrayList.remove(0);
          }
        }
      }
      return new ArrayList(localArrayList);
    }
  }
  
  public static void a(VideoMaterial paramVideoMaterial)
  {
    jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial = paramVideoMaterial;
  }
  
  public static boolean a()
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
  
  /* Error */
  public static boolean a(bnpf parambnpf)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +15 -> 19
    //   7: aload_0
    //   8: getfield 313	bnpf:f	Ljava/lang/String;
    //   11: invokestatic 255	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
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
    //   27: invokestatic 315	bnpc:b	(Lbnpf;)Z
    //   30: istore_1
    //   31: goto -10 -> 21
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	parambnpf	bnpf
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
  
  private bnpf b(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      bnpf localbnpf;
      do
      {
        Iterator localIterator1 = this.jdField_c_of_type_JavaUtilList.iterator();
        Iterator localIterator2;
        while (!localIterator2.hasNext())
        {
          if (!localIterator1.hasNext()) {
            break;
          }
          localIterator2 = ((bnpb)localIterator1.next()).jdField_a_of_type_JavaUtilList.iterator();
        }
        localbnpf = (bnpf)localIterator2.next();
      } while (!localbnpf.jdField_a_of_type_JavaLangString.equals(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("AEMaterialManager", 2, "existTemplateInfo id=" + paramString);
      }
      return localbnpf;
      return null;
    }
  }
  
  public static String b()
  {
    File localFile = new File(bndm.d);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile.getPath();
  }
  
  private void b(AppInterface paramAppInterface, String paramString, bnpf parambnpf, bnpq parambnpq)
  {
    bnpo.a(paramAppInterface, parambnpf, paramString, new bnpe(this, parambnpq));
    paramString = new StringBuilder().append("【START】startDownloadMaterial :");
    if (parambnpf == null) {}
    for (paramAppInterface = "null";; paramAppInterface = parambnpf.jdField_a_of_type_JavaLangString)
    {
      bnzb.b("AEMaterialManager", paramAppInterface);
      return;
    }
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Bnpb != null) && (this.jdField_a_of_type_Bnpb.jdField_a_of_type_JavaUtilList.size() >= 100);
  }
  
  private static boolean b(bnpf parambnpf)
  {
    boolean bool = false;
    Object localObject = parambnpf.a();
    File localFile1 = new File((String)localObject, "params.json");
    localObject = new File((String)localObject, "params.dat");
    if ((!localFile1.exists()) && (!((File)localObject).exists()))
    {
      try
      {
        File localFile2 = new File(parambnpf.c());
        if (!localFile2.exists()) {
          return false;
        }
        nmk.a(localFile2, parambnpf.b());
        return true;
      }
      catch (Exception parambnpf)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AEMaterialManager", 2, "judgeTemplateUsable unZipFile exp:", parambnpf);
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
  
  private String c()
  {
    return anni.a(2131708590);
  }
  
  private void c(bnpf parambnpf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEMaterialManager", 2, "deleteMaterialFolder: " + parambnpf.jdField_a_of_type_JavaLangString);
    }
    File localFile = new File(bndm.jdField_e_of_type_JavaLangString, parambnpf.jdField_a_of_type_JavaLangString);
    if (localFile.exists()) {
      bgmg.a(localFile.getPath());
    }
    parambnpf = new File(bndm.d, parambnpf.jdField_a_of_type_JavaLangString);
    if (parambnpf.exists()) {
      bgmg.a(parambnpf.getPath());
    }
  }
  
  private boolean c()
  {
    return (this.jdField_b_of_type_Bnpb != null) && (this.jdField_b_of_type_Bnpb.jdField_a_of_type_JavaUtilList != null) && (this.jdField_b_of_type_Bnpb.jdField_a_of_type_JavaUtilList.size() >= 100);
  }
  
  private boolean c(@Nullable bnpf parambnpf)
  {
    if ((parambnpf == null) || (TextUtils.isEmpty(parambnpf.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(parambnpf.jdField_e_of_type_JavaLangString))) {
      return false;
    }
    Iterator localIterator = this.jdField_d_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      bnpf localbnpf = (bnpf)localIterator.next();
      if ((localbnpf != null) && (!TextUtils.isEmpty(localbnpf.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localbnpf.jdField_e_of_type_JavaLangString)) && (localbnpf.jdField_a_of_type_JavaLangString.equals(parambnpf.jdField_a_of_type_JavaLangString)) && (localbnpf.jdField_e_of_type_JavaLangString.equals(parambnpf.jdField_e_of_type_JavaLangString))) {
        return true;
      }
    }
    return false;
  }
  
  private List<bnpb> d()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = bnov.b(a().getApp());
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
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("AEMaterialManager", 2, "initMaterialList enter");
    }
    m();
    for (;;)
    {
      Object localObject8;
      Object localObject7;
      synchronized (this.jdField_d_of_type_JavaLangObject)
      {
        localObject8 = new File(bndm.f, "camera_story_update_template.json");
        localObject7 = new File(bndm.f, "camera_story_default_template.json");
        if (!((File)localObject8).exists())
        {
          List localList1;
          if (!((File)localObject7).exists())
          {
            localList1 = d();
            if ((localList1 != null) && (!localList1.isEmpty())) {
              break label257;
            }
            return;
          }
          try
          {
            localList1 = a((File)localObject7);
          }
          catch (AEMaterialConfigParser.AEMaterialConfigParseException localAEMaterialConfigParseException1)
          {
            bgmg.d(((File)localObject7).getPath());
            List localList2 = d();
            l();
          }
        }
      }
      boolean bool = ((File)localObject7).exists();
      List localList4;
      if (!bool)
      {
        try
        {
          List localList3 = a((File)localObject8);
          bgmg.b(((File)localObject8).getPath(), ((File)localObject7).getPath());
        }
        catch (AEMaterialConfigParser.AEMaterialConfigParseException localAEMaterialConfigParseException2)
        {
          bgmg.d(((File)localObject8).getPath());
          localList4 = d();
          l();
        }
        continue;
      }
      Object localObject2;
      try
      {
        localList4 = a((File)localObject7, (File)localObject8);
        bgmg.d(((File)localObject7).getPath());
        bgmg.b(((File)localObject8).getPath(), ((File)localObject7).getPath());
      }
      catch (AEMaterialConfigParser.AEMaterialConfigParseException localAEMaterialConfigParseException3)
      {
        localObject2 = d();
        l();
      }
      continue;
      label257:
      synchronized (this.jdField_c_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_b_of_type_JavaUtilList.clear();
        this.jdField_c_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject2);
        localObject2 = ((List)localObject2).iterator();
        do
        {
          while (!((Iterator)localObject7).hasNext())
          {
            do
            {
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localObject7 = (bnpb)((Iterator)localObject2).next();
            } while (localObject7 == null);
            Object localObject9 = a((bnpb)localObject7);
            localObject8 = (bnpb)((HashMap)localObject9).get("normal_material");
            localObject9 = (bnpb)((HashMap)localObject9).get("circle_material");
            if ((localObject9 != null) && (((bnpb)localObject9).jdField_a_of_type_JavaUtilList != null) && (((bnpb)localObject9).jdField_a_of_type_JavaUtilList.size() > 0)) {
              this.jdField_c_of_type_JavaUtilList.add(localObject9);
            }
            if ((localObject8 != null) && (((bnpb)localObject8).jdField_a_of_type_JavaUtilList != null) && (((bnpb)localObject8).jdField_a_of_type_JavaUtilList.size() > 0)) {
              this.jdField_b_of_type_JavaUtilList.add(localObject8);
            }
            localObject7 = ((bnpb)localObject7).jdField_a_of_type_JavaUtilList.iterator();
          }
          localObject8 = (bnpf)((Iterator)localObject7).next();
        } while (localObject8 == null);
        ((bnpf)localObject8).jdField_e_of_type_Boolean = a((bnpf)localObject8);
      }
      n();
      o();
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      synchronized (this.jdField_c_of_type_JavaLangObject)
      {
        if ((this.jdField_b_of_type_JavaUtilList.size() > 0) && (!c().equals(((bnpb)this.jdField_b_of_type_JavaUtilList.get(0)).jdField_b_of_type_JavaLangString))) {
          this.jdField_b_of_type_JavaUtilList.add(0, this.jdField_a_of_type_Bnpb);
        }
        if ((this.jdField_c_of_type_JavaUtilList.size() > 0) && (!c().equals(((bnpb)this.jdField_c_of_type_JavaUtilList.get(0)).jdField_b_of_type_JavaLangString))) {
          this.jdField_c_of_type_JavaUtilList.add(0, this.jdField_b_of_type_Bnpb);
        }
        i();
        if (!QLog.isColorLevel()) {
          continue;
        }
        long l2 = System.currentTimeMillis();
        QLog.d("AEMaterialManager", 2, "initMaterialList exit, cost = " + (l2 - l1) + "ms");
        return;
      }
    }
  }
  
  private void l()
  {
    bnyp.a().a("CameraModuleSvc.GetCompressedCategoryMaterialMqStoryCamera", 4);
  }
  
  private void m()
  {
    bnzb.b("AEMaterialManager", "filament isSupport: " + a());
  }
  
  private void n()
  {
    int i = 0;
    if (this.jdField_a_of_type_Bnpb == null) {}
    do
    {
      return;
      ??? = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      ??? = bnyp.a().a(this.jdField_b_of_type_JavaLangString + (String)???, null, 0);
      if (QLog.isColorLevel()) {
        QLog.d("AEMaterialManager", 2, "getRecentTemplate list=" + (String)???);
      }
    } while (??? == null);
    String[] arrayOfString = ((String)???).split("\\$");
    for (;;)
    {
      Object localObject3;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_Bnpb.jdField_a_of_type_JavaUtilList.clear();
        if (i >= arrayOfString.length) {
          break label248;
        }
        localObject3 = arrayOfString[i].split("\\|");
        if ((localObject3 == null) || (localObject3.length != 2)) {
          break label251;
        }
        Integer.valueOf(localObject3[1]).intValue();
        localObject3 = a(localObject3[0]);
        if (localObject3 == null) {
          break label251;
        }
        if (this.jdField_a_of_type_Bnpb.jdField_a_of_type_JavaUtilList.size() >= 100) {
          return;
        }
      }
      if (this.jdField_a_of_type_Bnpb.jdField_a_of_type_JavaUtilList.contains(localObject3)) {
        return;
      }
      if (((bnpf)localObject3).jdField_a_of_type_JavaLangString.equals("0")) {
        return;
      }
      this.jdField_a_of_type_Bnpb.jdField_a_of_type_JavaUtilList.add(localObject3);
      break label251;
      label248:
      return;
      label251:
      i += 1;
    }
  }
  
  private void o()
  {
    int i = 0;
    if (this.jdField_b_of_type_Bnpb == null) {}
    do
    {
      return;
      ??? = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      ??? = bnyp.a().a(this.jdField_c_of_type_JavaLangString + (String)???, null, 0);
      if (QLog.isColorLevel()) {
        QLog.d("AEMaterialManager", 2, "getRecentTemplate list=" + (String)???);
      }
    } while (??? == null);
    String[] arrayOfString = ((String)???).split("\\$");
    for (;;)
    {
      Object localObject3;
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        this.jdField_b_of_type_Bnpb.jdField_a_of_type_JavaUtilList.clear();
        if (i >= arrayOfString.length) {
          break label245;
        }
        localObject3 = arrayOfString[i].split("\\|");
        if ((localObject3 == null) || (localObject3.length != 2)) {
          break label248;
        }
        Integer.valueOf(localObject3[1]).intValue();
        localObject3 = b(localObject3[0]);
        if (localObject3 == null) {
          break label248;
        }
        if (this.jdField_b_of_type_Bnpb.jdField_a_of_type_JavaUtilList.size() >= 100) {
          return;
        }
      }
      if ((!this.jdField_b_of_type_Bnpb.jdField_a_of_type_JavaUtilList.contains(localObject3)) && (!((bnpf)localObject3).jdField_a_of_type_JavaLangString.equals("0")))
      {
        this.jdField_b_of_type_Bnpb.jdField_a_of_type_JavaUtilList.add(localObject3);
        break label248;
        label245:
        return;
      }
      label248:
      i += 1;
    }
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_Bcgy != null) {
      this.jdField_a_of_type_Bcgy.a(111, new Object[] { this.jdField_a_of_type_Bnpb });
    }
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_Bcgy != null) {
      this.jdField_a_of_type_Bcgy.a(111, new Object[] { this.jdField_b_of_type_Bnpb });
    }
  }
  
  public bnpf a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Object localObject = this.jdField_c_of_type_JavaUtilList;; localObject = this.jdField_b_of_type_JavaUtilList)
    {
      if (((List)localObject).isEmpty()) {
        k();
      }
      localObject = ((List)localObject).iterator();
      bnpb localbnpb;
      bnpf localbnpf;
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
            localbnpb = (bnpb)((Iterator)localObject).next();
          } while ((localbnpb == null) || (localbnpb.jdField_a_of_type_JavaUtilList == null));
          localIterator = localbnpb.jdField_a_of_type_JavaUtilList.iterator();
          i = 0;
        }
        localbnpf = (bnpf)localIterator.next();
        j = i + 1;
        int i = j;
      } while (!localbnpf.jdField_a_of_type_JavaLangString.equals(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("QIMRedDotConfig_PTV", 2, "selectPtvTemplateInfo= " + localbnpf);
      }
      localbnpf.jdField_b_of_type_JavaLangString = localbnpb.jdField_b_of_type_JavaLangString;
      localbnpf.jdField_b_of_type_Int = j;
      return localbnpf;
    }
    return null;
  }
  
  public List<bnpb> a()
  {
    return this.jdField_c_of_type_JavaUtilList;
  }
  
  public List<bnpb> a(boolean paramBoolean)
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public void a(int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_Bcgy != null) {
        this.jdField_a_of_type_Bcgy.a(paramInt);
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
    if (this.jdField_a_of_type_Bcgy != null)
    {
      this.jdField_a_of_type_Bcgy.a(paramInt, new Object[] { paramObject });
      if (QLog.isColorLevel()) {
        QLog.d("AEMaterialManager", 2, "notifyEventId eventId=" + paramInt);
      }
    }
  }
  
  public void a(bcha parambcha)
  {
    try
    {
      if (this.jdField_a_of_type_Bcgy != null) {
        this.jdField_a_of_type_Bcgy.a(parambcha);
      }
      return;
    }
    finally
    {
      parambcha = finally;
      throw parambcha;
    }
  }
  
  public void a(bcha parambcha, int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_Bcgy == null) {
        this.jdField_a_of_type_Bcgy = new bcgy();
      }
      this.jdField_a_of_type_Bcgy.a(parambcha, new int[] { paramInt });
      return;
    }
    finally {}
  }
  
  public void a(bnpf parambnpf)
  {
    if (parambnpf == null) {}
    while (parambnpf.c()) {
      return;
    }
    if (this.jdField_a_of_type_Bnpb == null)
    {
      n();
      return;
    }
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        i = a(this.jdField_a_of_type_Bnpb.jdField_a_of_type_JavaUtilList, parambnpf.jdField_a_of_type_JavaLangString);
        if (i != -1) {
          break label183;
        }
        if (!b())
        {
          this.jdField_a_of_type_Bnpb.jdField_a_of_type_JavaUtilList.add(0, parambnpf);
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
      this.jdField_a_of_type_Bnpb.jdField_a_of_type_JavaUtilList.remove(99);
      this.jdField_a_of_type_Bnpb.jdField_a_of_type_JavaUtilList.add(0, parambnpf);
      p();
      continue;
      label183:
      if (i != 0)
      {
        this.jdField_a_of_type_Bnpb.jdField_a_of_type_JavaUtilList.remove(i);
        this.jdField_a_of_type_Bnpb.jdField_a_of_type_JavaUtilList.add(0, parambnpf);
        p();
      }
    }
  }
  
  public void a(bnpf parambnpf, boolean paramBoolean)
  {
    b(parambnpf, paramBoolean);
    a(113, null);
  }
  
  public void a(AppInterface paramAppInterface, bnpf parambnpf, bnpq parambnpq)
  {
    a(paramAppInterface, bndm.d, parambnpf, parambnpq);
  }
  
  public void a(AppInterface paramAppInterface, String paramString, bnpf parambnpf, bnpq parambnpq)
  {
    ThreadManager.excute(new AEMaterialManager.3(this, paramAppInterface, paramString, parambnpf, parambnpq), 128, null, true);
  }
  
  public void a(String paramString)
  {
    try
    {
      paramString = a(new File(paramString));
      if ((paramString != null) && (paramString.size() != 0)) {
        break label131;
      }
      paramString = a(d(), anni.a(2131689722));
    }
    catch (AEMaterialConfigParser.AEMaterialConfigParseException paramString)
    {
      ArrayList localArrayList;
      for (;;)
      {
        paramString.printStackTrace();
        return;
        paramString = a(paramString, anni.a(2131689723));
      }
      bnyp.a().a("PhotoConst.ae_latest_material", a(localArrayList), 4);
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
      bnpf localbnpf = (bnpf)paramString.next();
      if ((localArrayList.size() < 10) && (localbnpf != null) && (localbnpf.jdField_a_of_type_JavaLangString != null) && (localbnpf.jdField_c_of_type_JavaLangString != null)) {
        localArrayList.add(new bnpj(localbnpf.jdField_a_of_type_JavaLangString, localbnpf.jdField_c_of_type_JavaLangString));
      }
    }
  }
  
  public void a(@Nullable List<bnpf> paramList)
  {
    if (paramList != null) {
      this.jdField_d_of_type_JavaUtilList = paramList;
    }
  }
  
  public List<bnpb> b()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public void b(bnpf parambnpf)
  {
    if (parambnpf == null) {}
    while (parambnpf.c()) {
      return;
    }
    if (this.jdField_b_of_type_Bnpb == null)
    {
      o();
      return;
    }
    for (;;)
    {
      int i;
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        i = a(this.jdField_b_of_type_Bnpb.jdField_a_of_type_JavaUtilList, parambnpf.jdField_a_of_type_JavaLangString);
        if (i != -1) {
          break label183;
        }
        if (!c())
        {
          this.jdField_b_of_type_Bnpb.jdField_a_of_type_JavaUtilList.add(0, parambnpf);
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
      this.jdField_b_of_type_Bnpb.jdField_a_of_type_JavaUtilList.remove(99);
      this.jdField_b_of_type_Bnpb.jdField_a_of_type_JavaUtilList.add(0, parambnpf);
      q();
      continue;
      label183:
      if (i != 0)
      {
        this.jdField_b_of_type_Bnpb.jdField_a_of_type_JavaUtilList.remove(i);
        this.jdField_b_of_type_Bnpb.jdField_a_of_type_JavaUtilList.add(0, parambnpf);
        q();
      }
    }
  }
  
  public void b(bnpf parambnpf, boolean paramBoolean)
  {
    jdField_a_of_type_Bnpf = jdField_b_of_type_Bnpf;
    jdField_b_of_type_Bnpf = parambnpf;
    if ((parambnpf == null) || (parambnpf.c())) {
      jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial = null;
    }
    if (paramBoolean)
    {
      if ("circleCamera".equals(parambnpf.j)) {
        b(parambnpf);
      }
    }
    else {
      return;
    }
    a(parambnpf);
  }
  
  public List<bnpf> c()
  {
    return a(this.jdField_b_of_type_JavaUtilList, anni.a(2131698820));
  }
  
  public void c()
  {
    d();
  }
  
  public void d()
  {
    k();
  }
  
  public void e()
  {
    ThreadManager.excute(new AEMaterialManager.1(this), 64, null, false);
  }
  
  public void f()
  {
    k();
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Bnpb == null) {}
    while ((this.jdField_a_of_type_Bnpb.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_Bnpb.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localObject3 = this.jdField_a_of_type_Bnpb.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        bnpf localbnpf = (bnpf)((Iterator)localObject3).next();
        if ((!TextUtils.isEmpty(localbnpf.jdField_a_of_type_JavaLangString)) && (!localbnpf.equals(bnpf.jdField_a_of_type_Bnpf)))
        {
          localStringBuilder.append(localbnpf.jdField_a_of_type_JavaLangString).append("|");
          localStringBuilder.append(localbnpf.jdField_a_of_type_Int).append("$");
        }
      }
    }
    if (TextUtils.isEmpty(localObject2.toString())) {
      return;
    }
    Object localObject3 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    bnyp.a().a(this.jdField_b_of_type_JavaLangString + (String)localObject3, localObject2.toString(), 0);
    if (QLog.isColorLevel()) {
      QLog.d("AEMaterialManager", 2, "saveRecentTemplate list=" + localObject2.toString());
    }
  }
  
  public void h()
  {
    if ((this.jdField_b_of_type_Bnpb == null) || (this.jdField_b_of_type_Bnpb.jdField_a_of_type_JavaUtilList == null) || (this.jdField_b_of_type_Bnpb.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return;
    }
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localObject3 = this.jdField_b_of_type_Bnpb.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        bnpf localbnpf = (bnpf)((Iterator)localObject3).next();
        if ((!TextUtils.isEmpty(localbnpf.jdField_a_of_type_JavaLangString)) && (!localbnpf.equals(bnpf.jdField_a_of_type_Bnpf)))
        {
          localStringBuilder.append(localbnpf.jdField_a_of_type_JavaLangString).append("|");
          localStringBuilder.append(localbnpf.jdField_a_of_type_Int).append("$");
        }
      }
    }
    if (TextUtils.isEmpty(localObject2.toString())) {
      return;
    }
    Object localObject3 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    bnyp.a().a(this.jdField_c_of_type_JavaLangString + (String)localObject3, localObject2.toString(), 0);
    if (QLog.isColorLevel()) {
      QLog.d("AEMaterialManager", 2, "saveRecentTemplate list=" + localObject2.toString());
    }
  }
  
  public void i()
  {
    if ((!this.jdField_d_of_type_JavaUtilList.isEmpty()) && (!c(jdField_b_of_type_Bnpf)))
    {
      b(bnpf.jdField_a_of_type_Bnpf, false);
      a(null);
    }
    if (a() != null) {
      a().notifyObservers(bomu.class, 3, true, null);
    }
    if (this.jdField_a_of_type_Bcgy != null) {
      this.jdField_a_of_type_Bcgy.a(116, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnpc
 * JD-Core Version:    0.7.0.1
 */