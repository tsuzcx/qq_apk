import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.initializer.FilamentInitializer;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.util.GsonUtils;
import dov.com.qq.im.ae.data.AEMaterialConfigParser;
import dov.com.qq.im.ae.data.AEMaterialConfigParser.AEMaterialConfigParseException;
import dov.com.qq.im.ae.data.AEMaterialManager.1;
import dov.com.qq.im.ae.data.AEMaterialManager.3;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
import mqq.app.AppRuntime;

public class bkvr
  extends blnf
{
  private static bkvu jdField_a_of_type_Bkvu;
  private static VideoMaterial jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial;
  public static final Long a;
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private static bkvu jdField_b_of_type_Bkvu;
  private azbp jdField_a_of_type_Azbp;
  private bkvq jdField_a_of_type_Bkvq;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  public String a;
  private List<bkvq> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private final Object jdField_b_of_type_JavaLangObject = new Object();
  public String b;
  private List<bkvq> jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private final Object jdField_c_of_type_JavaLangObject = new Object();
  private List<bkvq> jdField_c_of_type_JavaUtilList = new ArrayList();
  private List<bkvu> d = new LinkedList();
  
  static
  {
    jdField_a_of_type_JavaLangLong = Long.valueOf(2000L);
  }
  
  public bkvr()
  {
    this.jdField_a_of_type_JavaLangString = "recent_template_setting_new";
    this.jdField_b_of_type_JavaLangString = "recent_template_list_new";
    if (this.jdField_a_of_type_Bkvq == null)
    {
      this.jdField_a_of_type_Bkvq = new bkvq(c());
      this.jdField_a_of_type_Bkvq.jdField_a_of_type_JavaUtilList = new ArrayList(100);
    }
  }
  
  private int a(List<bkvu> paramList, String paramString)
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
      if (((bkvu)paramList.get(i)).jdField_a_of_type_JavaLangString.equals(paramString)) {
        break;
      }
      i += 1;
    }
    label61:
    return -1;
  }
  
  public static bkvu a()
  {
    return jdField_b_of_type_Bkvu;
  }
  
  private bkvu a(bkvu parambkvu)
  {
    Object localObject1 = null;
    Iterator localIterator1 = this.jdField_a_of_type_JavaUtilList.iterator();
    if (localIterator1.hasNext())
    {
      Object localObject2 = (bkvq)localIterator1.next();
      int i;
      if (((bkvq)localObject2).jdField_a_of_type_JavaUtilList != null)
      {
        Iterator localIterator2 = ((bkvq)localObject2).jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator2.hasNext())
        {
          localObject2 = (bkvu)localIterator2.next();
          if (((bkvu)localObject2).equals(parambkvu))
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
  
  public static String a()
  {
    File localFile = new File(bkks.f);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return new File(localFile.getPath(), "camera_story_update_template.json").getPath();
  }
  
  @Nullable
  public static String a(@Nullable ArrayList<bkvy> paramArrayList)
  {
    if (paramArrayList != null) {
      return GsonUtils.obj2Json(paramArrayList);
    }
    return null;
  }
  
  @Nullable
  public static ArrayList<bkvy> a(@Nullable String paramString)
  {
    return (ArrayList)GsonUtils.json2Obj(paramString, new bkvs().getType());
  }
  
  private List<bkvq> a(File paramFile)
  {
    ArrayList localArrayList = new ArrayList();
    paramFile = bnkz.a(paramFile);
    if (TextUtils.isEmpty(paramFile)) {}
    do
    {
      return localArrayList;
      paramFile = AEMaterialConfigParser.a(paramFile);
    } while ((paramFile == null) || (paramFile.isEmpty()));
    return paramFile;
  }
  
  private List<bkvq> a(File paramFile1, File paramFile2)
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
      paramFile2 = (bkvq)localIterator1.next();
      localIterator2 = localList.iterator();
      do
      {
        if (!localIterator2.hasNext()) {
          break;
        }
        paramFile1 = (bkvq)localIterator2.next();
      } while (!paramFile1.jdField_b_of_type_JavaLangString.equals(paramFile2.jdField_b_of_type_JavaLangString));
    }
    for (;;)
    {
      if (paramFile1 == null)
      {
        paramFile1 = paramFile2.jdField_a_of_type_JavaUtilList.iterator();
        while (paramFile1.hasNext()) {
          b((bkvu)paramFile1.next());
        }
        break;
      }
      localIterator2 = paramFile2.jdField_a_of_type_JavaUtilList.iterator();
      label149:
      bkvu localbkvu;
      if (localIterator2.hasNext())
      {
        localbkvu = (bkvu)localIterator2.next();
        Iterator localIterator3 = paramFile1.jdField_a_of_type_JavaUtilList.iterator();
        do
        {
          if (!localIterator3.hasNext()) {
            break;
          }
          paramFile2 = (bkvu)localIterator3.next();
        } while (!localbkvu.jdField_a_of_type_JavaLangString.equals(paramFile2.jdField_a_of_type_JavaLangString));
      }
      for (;;)
      {
        if (paramFile2 == null)
        {
          b(localbkvu);
          break label149;
        }
        if (localbkvu.e.equals(paramFile2.e)) {
          break label149;
        }
        b(localbkvu);
        break label149;
        break;
        return localList;
        paramFile2 = null;
      }
      paramFile1 = null;
    }
  }
  
  private List<bkvu> a(List<bkvq> paramList, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        bkvq localbkvq = (bkvq)paramList.next();
        if (localbkvq.jdField_b_of_type_JavaLangString.equals(paramString))
        {
          localArrayList.addAll(localbkvq.jdField_a_of_type_JavaUtilList);
          if ((localArrayList.size() > 0) && (((bkvu)localArrayList.get(0)).equals(bkvu.jdField_a_of_type_Bkvu))) {
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
      boolean bool = FilamentInitializer.supportFilament();
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  private boolean a(@Nullable bkvq parambkvq)
  {
    if (parambkvq == null) {}
    while ((TextUtils.isEmpty(parambkvq.jdField_b_of_type_JavaLangString)) || (!"贴纸玩法".equals(parambkvq.jdField_b_of_type_JavaLangString))) {
      return false;
    }
    return true;
  }
  
  /* Error */
  public static boolean a(bkvu parambkvu)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +15 -> 19
    //   7: aload_0
    //   8: getfield 248	bkvu:f	Ljava/lang/String;
    //   11: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
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
    //   27: invokestatic 250	bkvr:b	(Lbkvu;)Z
    //   30: istore_1
    //   31: goto -10 -> 21
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	parambkvu	bkvu
    //   14	17	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   7	15	34	finally
    //   26	31	34	finally
  }
  
  private bkvu b(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      bkvu localbkvu;
      do
      {
        Iterator localIterator1 = this.jdField_b_of_type_JavaUtilList.iterator();
        Iterator localIterator2;
        while (!localIterator2.hasNext())
        {
          if (!localIterator1.hasNext()) {
            break;
          }
          localIterator2 = ((bkvq)localIterator1.next()).jdField_a_of_type_JavaUtilList.iterator();
        }
        localbkvu = (bkvu)localIterator2.next();
      } while (!localbkvu.jdField_a_of_type_JavaLangString.equals(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("AEMaterialManager", 2, "existTemplateInfo id=" + paramString);
      }
      return localbkvu;
      return null;
    }
  }
  
  public static String b()
  {
    File localFile = new File(bkks.d);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile.getPath();
  }
  
  private void b(bkvu parambkvu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEMaterialManager", 2, "deleteMaterialFolder: " + parambkvu.jdField_a_of_type_JavaLangString);
    }
    File localFile = new File(bkks.e, parambkvu.jdField_a_of_type_JavaLangString);
    if (localFile.exists()) {
      bdcs.a(localFile.getPath());
    }
    parambkvu = new File(bkks.d, parambkvu.jdField_a_of_type_JavaLangString);
    if (parambkvu.exists()) {
      bdcs.a(parambkvu.getPath());
    }
  }
  
  private void b(AppInterface paramAppInterface, String paramString, bkvu parambkvu, bkwg parambkwg)
  {
    bkwe.a(paramAppInterface, parambkvu, paramString, new bkvt(this, parambkwg));
    paramString = new StringBuilder().append("【START】startDownloadMaterial :");
    if (parambkvu == null) {}
    for (paramAppInterface = "null";; paramAppInterface = parambkvu.jdField_a_of_type_JavaLangString)
    {
      blfg.b("AEMaterialManager", paramAppInterface);
      return;
    }
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Bkvq != null) && (this.jdField_a_of_type_Bkvq.jdField_a_of_type_JavaUtilList.size() >= 100);
  }
  
  private static boolean b(bkvu parambkvu)
  {
    boolean bool = false;
    Object localObject = parambkvu.a();
    File localFile1 = new File((String)localObject, "params.json");
    localObject = new File((String)localObject, "params.dat");
    if ((!localFile1.exists()) && (!((File)localObject).exists()))
    {
      try
      {
        File localFile2 = new File(parambkvu.c());
        if (!localFile2.exists()) {
          return false;
        }
        ndr.a(localFile2, parambkvu.b());
        return true;
      }
      catch (Exception parambkvu)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AEMaterialManager", 2, "judgeTemplateUsable unZipFile exp:", parambkvu);
        }
        if (localFile1.exists()) {
          break label111;
        }
      }
      if (((File)localObject).exists()) {
        label111:
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
    return alpo.a(2131710202);
  }
  
  private List<bkvq> c()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = bkvk.b(a().getApp());
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
  
  private boolean c(@Nullable bkvu parambkvu)
  {
    if ((parambkvu == null) || (TextUtils.isEmpty(parambkvu.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(parambkvu.e))) {
      return false;
    }
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      bkvu localbkvu = (bkvu)localIterator.next();
      if ((localbkvu != null) && (!TextUtils.isEmpty(localbkvu.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localbkvu.e)) && (localbkvu.jdField_a_of_type_JavaLangString.equals(parambkvu.jdField_a_of_type_JavaLangString)) && (localbkvu.e.equals(parambkvu.e))) {
        return true;
      }
    }
    return false;
  }
  
  private void j()
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("AEMaterialManager", 2, "initMaterialList enter");
    }
    l();
    for (;;)
    {
      Object localObject8;
      Object localObject7;
      synchronized (this.jdField_c_of_type_JavaLangObject)
      {
        localObject8 = new File(bkks.f, "camera_story_update_template.json");
        localObject7 = new File(bkks.f, "camera_story_default_template.json");
        if (!((File)localObject8).exists())
        {
          List localList1;
          if (!((File)localObject7).exists())
          {
            localList1 = c();
            if ((localList1 != null) && (!localList1.isEmpty())) {
              break label258;
            }
            return;
          }
          try
          {
            localList1 = a((File)localObject7);
          }
          catch (AEMaterialConfigParser.AEMaterialConfigParseException localAEMaterialConfigParseException1)
          {
            bdcs.d(((File)localObject7).getPath());
            List localList2 = c();
            k();
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
          bdcs.b(((File)localObject8).getPath(), ((File)localObject7).getPath());
        }
        catch (AEMaterialConfigParser.AEMaterialConfigParseException localAEMaterialConfigParseException2)
        {
          bdcs.d(((File)localObject8).getPath());
          localList4 = c();
          k();
        }
        continue;
      }
      Object localObject2;
      try
      {
        localList4 = a((File)localObject7, (File)localObject8);
        bdcs.d(((File)localObject7).getPath());
        bdcs.b(((File)localObject8).getPath(), ((File)localObject7).getPath());
      }
      catch (AEMaterialConfigParser.AEMaterialConfigParseException localAEMaterialConfigParseException3)
      {
        localObject2 = c();
        k();
      }
      continue;
      for (;;)
      {
        label258:
        synchronized (this.jdField_b_of_type_JavaLangObject)
        {
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_b_of_type_JavaUtilList.clear();
          this.jdField_c_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject2);
          localObject2 = ((List)localObject2).iterator();
          continue;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject7 = (bkvq)((Iterator)localObject2).next();
          if (localObject7 == null) {
            continue;
          }
          if (a((bkvq)localObject7))
          {
            this.jdField_c_of_type_JavaUtilList.add(localObject7);
            localObject7 = ((bkvq)localObject7).jdField_a_of_type_JavaUtilList.iterator();
            if (!((Iterator)localObject7).hasNext()) {
              continue;
            }
            localObject8 = (bkvu)((Iterator)localObject7).next();
            if (localObject8 == null) {
              continue;
            }
            ((bkvu)localObject8).d = a((bkvu)localObject8);
          }
        }
        this.jdField_b_of_type_JavaUtilList.add(localObject7);
      }
      m();
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if ((this.jdField_b_of_type_JavaUtilList.size() > 0) && (!c().equals(((bkvq)this.jdField_b_of_type_JavaUtilList.get(0)).jdField_b_of_type_JavaLangString))) {
          this.jdField_b_of_type_JavaUtilList.add(0, this.jdField_a_of_type_Bkvq);
        }
        h();
        if (!QLog.isColorLevel()) {
          continue;
        }
        long l2 = System.currentTimeMillis();
        QLog.d("AEMaterialManager", 2, "initMaterialList exit, cost = " + (l2 - l1) + "ms");
        return;
      }
    }
  }
  
  private void k()
  {
    blev.a().a("CameraModuleSvc.GetCompressedCategoryMaterialMqStoryCamera", 4);
  }
  
  private void l()
  {
    blfg.b("AEMaterialManager", "filament isSupport: " + a());
  }
  
  private void m()
  {
    int i = 0;
    if (this.jdField_a_of_type_Bkvq == null) {}
    do
    {
      return;
      ??? = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      ??? = blev.a().a(this.jdField_b_of_type_JavaLangString + (String)???, null, 0);
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
        this.jdField_a_of_type_Bkvq.jdField_a_of_type_JavaUtilList.clear();
        if (i >= arrayOfString.length) {
          break label249;
        }
        localObject3 = arrayOfString[i].split("\\|");
        if ((localObject3 == null) || (localObject3.length != 2)) {
          break label252;
        }
        Integer.valueOf(localObject3[1]).intValue();
        localObject3 = b(localObject3[0]);
        if (localObject3 == null) {
          break label252;
        }
        if (this.jdField_a_of_type_Bkvq.jdField_a_of_type_JavaUtilList.size() >= 100) {
          return;
        }
      }
      if (this.jdField_a_of_type_Bkvq.jdField_a_of_type_JavaUtilList.contains(localObject3)) {
        return;
      }
      if (((bkvu)localObject3).jdField_a_of_type_JavaLangString.equals("0")) {
        return;
      }
      this.jdField_a_of_type_Bkvq.jdField_a_of_type_JavaUtilList.add(localObject3);
      break label252;
      label249:
      return;
      label252:
      i += 1;
    }
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_Azbp != null) {
      this.jdField_a_of_type_Azbp.a(111, new Object[] { this.jdField_a_of_type_Bkvq });
    }
  }
  
  public bkvu a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilList.isEmpty()) {
      j();
    }
    Iterator localIterator1 = this.jdField_b_of_type_JavaUtilList.iterator();
    bkvq localbkvq;
    bkvu localbkvu;
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
          localbkvq = (bkvq)localIterator1.next();
        } while ((localbkvq == null) || (localbkvq.jdField_a_of_type_JavaUtilList == null));
        localIterator2 = localbkvq.jdField_a_of_type_JavaUtilList.iterator();
        i = 0;
      }
      localbkvu = (bkvu)localIterator2.next();
      j = i + 1;
      int i = j;
    } while (!localbkvu.jdField_a_of_type_JavaLangString.equals(paramString));
    if (QLog.isColorLevel()) {
      QLog.d("QIMRedDotConfig_PTV", 2, "selectPtvTemplateInfo= " + localbkvu);
    }
    localbkvu.jdField_b_of_type_JavaLangString = localbkvq.jdField_b_of_type_JavaLangString;
    localbkvu.jdField_b_of_type_Int = j;
    return localbkvu;
    return null;
  }
  
  public List<bkvq> a()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public List<bkvq> a(boolean paramBoolean)
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public void a(int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_Azbp != null) {
        this.jdField_a_of_type_Azbp.a(paramInt);
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
    if (this.jdField_a_of_type_Azbp != null)
    {
      this.jdField_a_of_type_Azbp.a(paramInt, new Object[] { paramObject });
      if (QLog.isColorLevel()) {
        QLog.d("AEMaterialManager", 2, "notifyEventId eventId=" + paramInt);
      }
    }
  }
  
  public void a(azbr paramazbr)
  {
    try
    {
      if (this.jdField_a_of_type_Azbp != null) {
        this.jdField_a_of_type_Azbp.a(paramazbr);
      }
      return;
    }
    finally
    {
      paramazbr = finally;
      throw paramazbr;
    }
  }
  
  public void a(azbr paramazbr, int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_Azbp == null) {
        this.jdField_a_of_type_Azbp = new azbp();
      }
      this.jdField_a_of_type_Azbp.a(paramazbr, new int[] { paramInt });
      return;
    }
    finally {}
  }
  
  public void a(bkvu parambkvu)
  {
    if (parambkvu == null) {}
    while (parambkvu.c()) {
      return;
    }
    if (this.jdField_a_of_type_Bkvq == null)
    {
      m();
      return;
    }
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        i = a(this.jdField_a_of_type_Bkvq.jdField_a_of_type_JavaUtilList, parambkvu.jdField_a_of_type_JavaLangString);
        if (i != -1) {
          break label186;
        }
        if (!b())
        {
          this.jdField_a_of_type_Bkvq.jdField_a_of_type_JavaUtilList.add(0, parambkvu);
          n();
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
      this.jdField_a_of_type_Bkvq.jdField_a_of_type_JavaUtilList.remove(99);
      this.jdField_a_of_type_Bkvq.jdField_a_of_type_JavaUtilList.add(0, parambkvu);
      n();
      continue;
      label186:
      if (i != 0)
      {
        this.jdField_a_of_type_Bkvq.jdField_a_of_type_JavaUtilList.remove(i);
        this.jdField_a_of_type_Bkvq.jdField_a_of_type_JavaUtilList.add(0, parambkvu);
        n();
      }
    }
  }
  
  public void a(bkvu parambkvu, boolean paramBoolean)
  {
    b(parambkvu, paramBoolean);
    a(113, null);
  }
  
  public void a(AppInterface paramAppInterface, bkvu parambkvu, bkwg parambkwg)
  {
    a(paramAppInterface, bkks.d, parambkvu, parambkwg);
  }
  
  public void a(AppInterface paramAppInterface, String paramString, bkvu parambkvu, bkwg parambkwg)
  {
    ThreadManager.excute(new AEMaterialManager.3(this, paramAppInterface, paramString, parambkvu, parambkwg), 128, null, true);
  }
  
  public void a(String paramString)
  {
    try
    {
      paramString = a(new File(paramString));
      if ((paramString != null) && (paramString.size() != 0)) {
        break label131;
      }
      paramString = a(c(), alpo.a(2131689817));
    }
    catch (AEMaterialConfigParser.AEMaterialConfigParseException paramString)
    {
      ArrayList localArrayList;
      for (;;)
      {
        paramString.printStackTrace();
        return;
        paramString = a(paramString, alpo.a(2131689818));
      }
      blev.a().a("PhotoConst.ae_latest_material", a(localArrayList), 4);
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
      bkvu localbkvu = (bkvu)paramString.next();
      if ((localArrayList.size() < 10) && (localbkvu != null) && (localbkvu.jdField_a_of_type_JavaLangString != null) && (localbkvu.c != null)) {
        localArrayList.add(new bkvy(localbkvu.jdField_a_of_type_JavaLangString, localbkvu.c));
      }
    }
  }
  
  public void a(@Nullable List<bkvu> paramList)
  {
    if (paramList != null) {
      this.d = paramList;
    }
  }
  
  public List<bkvu> b()
  {
    return a(this.jdField_b_of_type_JavaUtilList, alpo.a(2131700382));
  }
  
  public void b(bkvu parambkvu, boolean paramBoolean)
  {
    jdField_a_of_type_Bkvu = jdField_b_of_type_Bkvu;
    jdField_b_of_type_Bkvu = parambkvu;
    if ((parambkvu == null) || (parambkvu.c())) {
      jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial = null;
    }
    if (paramBoolean) {
      a(parambkvu);
    }
  }
  
  public void c()
  {
    d();
  }
  
  public void d()
  {
    j();
  }
  
  public void e()
  {
    ThreadManager.excute(new AEMaterialManager.1(this), 64, null, false);
  }
  
  public void f()
  {
    j();
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Bkvq == null) {}
    while ((this.jdField_a_of_type_Bkvq.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_Bkvq.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localObject3 = this.jdField_a_of_type_Bkvq.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        bkvu localbkvu = (bkvu)((Iterator)localObject3).next();
        if ((!TextUtils.isEmpty(localbkvu.jdField_a_of_type_JavaLangString)) && (!localbkvu.equals(bkvu.jdField_a_of_type_Bkvu)))
        {
          localStringBuilder.append(localbkvu.jdField_a_of_type_JavaLangString).append("|");
          localStringBuilder.append(localbkvu.jdField_a_of_type_Int).append("$");
        }
      }
    }
    if (TextUtils.isEmpty(localObject2.toString())) {
      return;
    }
    Object localObject3 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    blev.a().a(this.jdField_b_of_type_JavaLangString + (String)localObject3, localObject2.toString(), 0);
    if (QLog.isColorLevel()) {
      QLog.d("AEMaterialManager", 2, "saveRecentTemplate list=" + localObject2.toString());
    }
  }
  
  public void h()
  {
    if ((!this.d.isEmpty()) && (!c(jdField_b_of_type_Bkvu)))
    {
      b(bkvu.jdField_a_of_type_Bkvu, false);
      a(null);
    }
    if (a() != null) {
      a().notifyObservers(blpe.class, 3, true, null);
    }
    if (this.jdField_a_of_type_Azbp != null) {
      this.jdField_a_of_type_Azbp.a(116, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkvr
 * JD-Core Version:    0.7.0.1
 */