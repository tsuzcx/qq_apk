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

public class birb
  extends bjbv
{
  private static bire jdField_a_of_type_Bire;
  private static VideoMaterial jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial;
  public static final Long a;
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private static bire jdField_b_of_type_Bire;
  private axgj jdField_a_of_type_Axgj;
  private bira jdField_a_of_type_Bira;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  public String a;
  private List<bira> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private final Object jdField_b_of_type_JavaLangObject = new Object();
  public String b;
  private List<bira> jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private final Object jdField_c_of_type_JavaLangObject = new Object();
  private List<bira> jdField_c_of_type_JavaUtilList = new ArrayList();
  private List<bire> d = new LinkedList();
  
  static
  {
    jdField_a_of_type_JavaLangLong = Long.valueOf(2000L);
  }
  
  public birb()
  {
    this.jdField_a_of_type_JavaLangString = "recent_template_setting_new";
    this.jdField_b_of_type_JavaLangString = "recent_template_list_new";
    if (this.jdField_a_of_type_Bira == null)
    {
      this.jdField_a_of_type_Bira = new bira(c());
      this.jdField_a_of_type_Bira.jdField_a_of_type_JavaUtilList = new ArrayList(100);
    }
  }
  
  private int a(List<bire> paramList, String paramString)
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
      if (((bire)paramList.get(i)).jdField_a_of_type_JavaLangString.equals(paramString)) {
        break;
      }
      i += 1;
    }
    label61:
    return -1;
  }
  
  public static bire a()
  {
    return jdField_b_of_type_Bire;
  }
  
  private bire a(bire parambire)
  {
    Object localObject1 = null;
    Iterator localIterator1 = this.jdField_a_of_type_JavaUtilList.iterator();
    if (localIterator1.hasNext())
    {
      Object localObject2 = (bira)localIterator1.next();
      int i;
      if (((bira)localObject2).jdField_a_of_type_JavaUtilList != null)
      {
        Iterator localIterator2 = ((bira)localObject2).jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator2.hasNext())
        {
          localObject2 = (bire)localIterator2.next();
          if (((bire)localObject2).equals(parambire))
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
    File localFile = new File(biiu.f);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return new File(localFile.getPath(), "camera_story_update_template.json").getPath();
  }
  
  @Nullable
  public static String a(@Nullable ArrayList<biri> paramArrayList)
  {
    if (paramArrayList != null) {
      return GsonUtils.obj2Json(paramArrayList);
    }
    return null;
  }
  
  @Nullable
  public static ArrayList<biri> a(@Nullable String paramString)
  {
    return (ArrayList)GsonUtils.json2Obj(paramString, new birc().getType());
  }
  
  private List<bira> a(File paramFile)
  {
    ArrayList localArrayList = new ArrayList();
    paramFile = bkzp.a(paramFile);
    if (TextUtils.isEmpty(paramFile)) {}
    do
    {
      return localArrayList;
      paramFile = AEMaterialConfigParser.a(paramFile);
    } while ((paramFile == null) || (paramFile.isEmpty()));
    return paramFile;
  }
  
  private List<bira> a(File paramFile1, File paramFile2)
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
      paramFile2 = (bira)localIterator1.next();
      localIterator2 = localList.iterator();
      do
      {
        if (!localIterator2.hasNext()) {
          break;
        }
        paramFile1 = (bira)localIterator2.next();
      } while (!paramFile1.jdField_b_of_type_JavaLangString.equals(paramFile2.jdField_b_of_type_JavaLangString));
    }
    for (;;)
    {
      if (paramFile1 == null)
      {
        paramFile1 = paramFile2.jdField_a_of_type_JavaUtilList.iterator();
        while (paramFile1.hasNext()) {
          b((bire)paramFile1.next());
        }
        break;
      }
      localIterator2 = paramFile2.jdField_a_of_type_JavaUtilList.iterator();
      label149:
      bire localbire;
      if (localIterator2.hasNext())
      {
        localbire = (bire)localIterator2.next();
        Iterator localIterator3 = paramFile1.jdField_a_of_type_JavaUtilList.iterator();
        do
        {
          if (!localIterator3.hasNext()) {
            break;
          }
          paramFile2 = (bire)localIterator3.next();
        } while (!localbire.jdField_a_of_type_JavaLangString.equals(paramFile2.jdField_a_of_type_JavaLangString));
      }
      for (;;)
      {
        if (paramFile2 == null)
        {
          b(localbire);
          break label149;
        }
        if (localbire.e.equals(paramFile2.e)) {
          break label149;
        }
        b(localbire);
        break label149;
        break;
        return localList;
        paramFile2 = null;
      }
      paramFile1 = null;
    }
  }
  
  private List<bire> a(List<bira> paramList, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        bira localbira = (bira)paramList.next();
        if (localbira.jdField_b_of_type_JavaLangString.equals(paramString))
        {
          localArrayList.addAll(localbira.jdField_a_of_type_JavaUtilList);
          if ((localArrayList.size() > 0) && (((bire)localArrayList.get(0)).equals(bire.jdField_a_of_type_Bire))) {
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
  
  private boolean a(@Nullable bira parambira)
  {
    if (parambira == null) {}
    while ((TextUtils.isEmpty(parambira.jdField_b_of_type_JavaLangString)) || (!"贴纸玩法".equals(parambira.jdField_b_of_type_JavaLangString))) {
      return false;
    }
    return true;
  }
  
  /* Error */
  public static boolean a(bire parambire)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +15 -> 19
    //   7: aload_0
    //   8: getfield 248	bire:f	Ljava/lang/String;
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
    //   27: invokestatic 250	birb:b	(Lbire;)Z
    //   30: istore_1
    //   31: goto -10 -> 21
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	parambire	bire
    //   14	17	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   7	15	34	finally
    //   26	31	34	finally
  }
  
  private bire b(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      bire localbire;
      do
      {
        Iterator localIterator1 = this.jdField_b_of_type_JavaUtilList.iterator();
        Iterator localIterator2;
        while (!localIterator2.hasNext())
        {
          if (!localIterator1.hasNext()) {
            break;
          }
          localIterator2 = ((bira)localIterator1.next()).jdField_a_of_type_JavaUtilList.iterator();
        }
        localbire = (bire)localIterator2.next();
      } while (!localbire.jdField_a_of_type_JavaLangString.equals(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("AEMaterialManager", 2, "existTemplateInfo id=" + paramString);
      }
      return localbire;
      return null;
    }
  }
  
  public static String b()
  {
    File localFile = new File(biiu.d);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile.getPath();
  }
  
  private void b(bire parambire)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEMaterialManager", 2, "deleteMaterialFolder: " + parambire.jdField_a_of_type_JavaLangString);
    }
    File localFile = new File(biiu.e, parambire.jdField_a_of_type_JavaLangString);
    if (localFile.exists()) {
      bbdx.a(localFile.getPath());
    }
    parambire = new File(biiu.d, parambire.jdField_a_of_type_JavaLangString);
    if (parambire.exists()) {
      bbdx.a(parambire.getPath());
    }
  }
  
  private void b(AppInterface paramAppInterface, String paramString, bire parambire, birp parambirp)
  {
    birn.a(paramAppInterface, parambire, paramString, new bird(this, parambirp));
    paramString = new StringBuilder().append("【START】startDownloadMaterial :");
    if (parambire == null) {}
    for (paramAppInterface = "null";; paramAppInterface = parambire.jdField_a_of_type_JavaLangString)
    {
      bjah.b("AEMaterialManager", paramAppInterface);
      return;
    }
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Bira != null) && (this.jdField_a_of_type_Bira.jdField_a_of_type_JavaUtilList.size() >= 100);
  }
  
  private static boolean b(bire parambire)
  {
    boolean bool = false;
    Object localObject = parambire.a();
    File localFile1 = new File((String)localObject, "params.json");
    localObject = new File((String)localObject, "params.dat");
    if ((!localFile1.exists()) && (!((File)localObject).exists()))
    {
      try
      {
        File localFile2 = new File(parambire.c());
        if (!localFile2.exists()) {
          return false;
        }
        nav.a(localFile2, parambire.b());
        return true;
      }
      catch (Exception parambire)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AEMaterialManager", 2, "judgeTemplateUsable unZipFile exp:", parambire);
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
    return ajya.a(2131709830);
  }
  
  private List<bira> c()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = biqu.b(a().getApp());
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
  
  private boolean c(@Nullable bire parambire)
  {
    if ((parambire == null) || (TextUtils.isEmpty(parambire.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(parambire.e))) {
      return false;
    }
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      bire localbire = (bire)localIterator.next();
      if ((localbire != null) && (!TextUtils.isEmpty(localbire.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localbire.e)) && (localbire.jdField_a_of_type_JavaLangString.equals(parambire.jdField_a_of_type_JavaLangString)) && (localbire.e.equals(parambire.e))) {
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
        localObject8 = new File(biiu.f, "camera_story_update_template.json");
        localObject7 = new File(biiu.f, "camera_story_default_template.json");
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
            bbdx.d(((File)localObject7).getPath());
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
          bbdx.b(((File)localObject8).getPath(), ((File)localObject7).getPath());
        }
        catch (AEMaterialConfigParser.AEMaterialConfigParseException localAEMaterialConfigParseException2)
        {
          bbdx.d(((File)localObject8).getPath());
          localList4 = c();
          k();
        }
        continue;
      }
      Object localObject2;
      try
      {
        localList4 = a((File)localObject7, (File)localObject8);
        bbdx.d(((File)localObject7).getPath());
        bbdx.b(((File)localObject8).getPath(), ((File)localObject7).getPath());
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
          localObject7 = (bira)((Iterator)localObject2).next();
          if (localObject7 == null) {
            continue;
          }
          if (a((bira)localObject7))
          {
            this.jdField_c_of_type_JavaUtilList.add(localObject7);
            localObject7 = ((bira)localObject7).jdField_a_of_type_JavaUtilList.iterator();
            if (!((Iterator)localObject7).hasNext()) {
              continue;
            }
            localObject8 = (bire)((Iterator)localObject7).next();
            if (localObject8 == null) {
              continue;
            }
            ((bire)localObject8).d = a((bire)localObject8);
          }
        }
        this.jdField_b_of_type_JavaUtilList.add(localObject7);
      }
      m();
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if ((this.jdField_b_of_type_JavaUtilList.size() > 0) && (!c().equals(((bira)this.jdField_b_of_type_JavaUtilList.get(0)).jdField_b_of_type_JavaLangString))) {
          this.jdField_b_of_type_JavaUtilList.add(0, this.jdField_a_of_type_Bira);
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
    bjaa.a().a("CameraModuleSvc.GetCompressedCategoryMaterialMqStoryCamera", 4);
  }
  
  private void l()
  {
    bjah.b("AEMaterialManager", "filament isSupport: " + a());
  }
  
  private void m()
  {
    int i = 0;
    if (this.jdField_a_of_type_Bira == null) {}
    do
    {
      return;
      ??? = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      ??? = bjaa.a().a(this.jdField_b_of_type_JavaLangString + (String)???, null, 0);
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
        this.jdField_a_of_type_Bira.jdField_a_of_type_JavaUtilList.clear();
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
        if (this.jdField_a_of_type_Bira.jdField_a_of_type_JavaUtilList.size() >= 100) {
          return;
        }
      }
      if (this.jdField_a_of_type_Bira.jdField_a_of_type_JavaUtilList.contains(localObject3)) {
        return;
      }
      if (((bire)localObject3).jdField_a_of_type_JavaLangString.equals("0")) {
        return;
      }
      this.jdField_a_of_type_Bira.jdField_a_of_type_JavaUtilList.add(localObject3);
      break label252;
      label249:
      return;
      label252:
      i += 1;
    }
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_Axgj != null) {
      this.jdField_a_of_type_Axgj.a(111, new Object[] { this.jdField_a_of_type_Bira });
    }
  }
  
  public bire a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilList.isEmpty()) {
      j();
    }
    Iterator localIterator1 = this.jdField_b_of_type_JavaUtilList.iterator();
    bira localbira;
    bire localbire;
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
          localbira = (bira)localIterator1.next();
        } while ((localbira == null) || (localbira.jdField_a_of_type_JavaUtilList == null));
        localIterator2 = localbira.jdField_a_of_type_JavaUtilList.iterator();
        i = 0;
      }
      localbire = (bire)localIterator2.next();
      j = i + 1;
      int i = j;
    } while (!localbire.jdField_a_of_type_JavaLangString.equals(paramString));
    if (QLog.isColorLevel()) {
      QLog.d("QIMRedDotConfig_PTV", 2, "selectPtvTemplateInfo= " + localbire);
    }
    localbire.jdField_b_of_type_JavaLangString = localbira.jdField_b_of_type_JavaLangString;
    localbire.jdField_b_of_type_Int = j;
    return localbire;
    return null;
  }
  
  public List<bira> a()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public List<bira> a(boolean paramBoolean)
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public void a(int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_Axgj != null) {
        this.jdField_a_of_type_Axgj.a(paramInt);
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
    if (this.jdField_a_of_type_Axgj != null)
    {
      this.jdField_a_of_type_Axgj.a(paramInt, new Object[] { paramObject });
      if (QLog.isColorLevel()) {
        QLog.d("AEMaterialManager", 2, "notifyEventId eventId=" + paramInt);
      }
    }
  }
  
  public void a(axgl paramaxgl)
  {
    try
    {
      if (this.jdField_a_of_type_Axgj != null) {
        this.jdField_a_of_type_Axgj.a(paramaxgl);
      }
      return;
    }
    finally
    {
      paramaxgl = finally;
      throw paramaxgl;
    }
  }
  
  public void a(axgl paramaxgl, int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_Axgj == null) {
        this.jdField_a_of_type_Axgj = new axgj();
      }
      this.jdField_a_of_type_Axgj.a(paramaxgl, new int[] { paramInt });
      return;
    }
    finally {}
  }
  
  public void a(bire parambire)
  {
    if (parambire == null) {}
    while (parambire.c()) {
      return;
    }
    if (this.jdField_a_of_type_Bira == null)
    {
      m();
      return;
    }
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        i = a(this.jdField_a_of_type_Bira.jdField_a_of_type_JavaUtilList, parambire.jdField_a_of_type_JavaLangString);
        if (i != -1) {
          break label186;
        }
        if (!b())
        {
          this.jdField_a_of_type_Bira.jdField_a_of_type_JavaUtilList.add(0, parambire);
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
      this.jdField_a_of_type_Bira.jdField_a_of_type_JavaUtilList.remove(99);
      this.jdField_a_of_type_Bira.jdField_a_of_type_JavaUtilList.add(0, parambire);
      n();
      continue;
      label186:
      if (i != 0)
      {
        this.jdField_a_of_type_Bira.jdField_a_of_type_JavaUtilList.remove(i);
        this.jdField_a_of_type_Bira.jdField_a_of_type_JavaUtilList.add(0, parambire);
        n();
      }
    }
  }
  
  public void a(bire parambire, boolean paramBoolean)
  {
    b(parambire, paramBoolean);
    a(113, null);
  }
  
  public void a(AppInterface paramAppInterface, bire parambire, birp parambirp)
  {
    a(paramAppInterface, biiu.d, parambire, parambirp);
  }
  
  public void a(AppInterface paramAppInterface, String paramString, bire parambire, birp parambirp)
  {
    ThreadManager.excute(new AEMaterialManager.3(this, paramAppInterface, paramString, parambire, parambirp), 128, null, true);
  }
  
  public void a(String paramString)
  {
    try
    {
      paramString = a(new File(paramString));
      if ((paramString != null) && (paramString.size() != 0)) {
        break label131;
      }
      paramString = a(c(), ajya.a(2131689787));
    }
    catch (AEMaterialConfigParser.AEMaterialConfigParseException paramString)
    {
      ArrayList localArrayList;
      for (;;)
      {
        paramString.printStackTrace();
        return;
        paramString = a(paramString, ajya.a(2131689788));
      }
      bjaa.a().a("PhotoConst.ae_latest_material", a(localArrayList), 4);
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
      bire localbire = (bire)paramString.next();
      if ((localArrayList.size() < 10) && (localbire != null) && (localbire.jdField_a_of_type_JavaLangString != null) && (localbire.c != null)) {
        localArrayList.add(new biri(localbire.jdField_a_of_type_JavaLangString, localbire.c));
      }
    }
  }
  
  public void a(@Nullable List<bire> paramList)
  {
    if (paramList != null) {
      this.d = paramList;
    }
  }
  
  public List<bire> b()
  {
    return a(this.jdField_b_of_type_JavaUtilList, ajya.a(2131700013));
  }
  
  public void b(bire parambire, boolean paramBoolean)
  {
    jdField_a_of_type_Bire = jdField_b_of_type_Bire;
    jdField_b_of_type_Bire = parambire;
    if ((parambire == null) || (parambire.c())) {
      jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial = null;
    }
    if (paramBoolean) {
      a(parambire);
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
    if (this.jdField_a_of_type_Bira == null) {}
    while ((this.jdField_a_of_type_Bira.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_Bira.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localObject3 = this.jdField_a_of_type_Bira.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        bire localbire = (bire)((Iterator)localObject3).next();
        if ((!TextUtils.isEmpty(localbire.jdField_a_of_type_JavaLangString)) && (!localbire.equals(bire.jdField_a_of_type_Bire)))
        {
          localStringBuilder.append(localbire.jdField_a_of_type_JavaLangString).append("|");
          localStringBuilder.append(localbire.jdField_a_of_type_Int).append("$");
        }
      }
    }
    if (TextUtils.isEmpty(localObject2.toString())) {
      return;
    }
    Object localObject3 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    bjaa.a().a(this.jdField_b_of_type_JavaLangString + (String)localObject3, localObject2.toString(), 0);
    if (QLog.isColorLevel()) {
      QLog.d("AEMaterialManager", 2, "saveRecentTemplate list=" + localObject2.toString());
    }
  }
  
  public void h()
  {
    if ((!this.d.isEmpty()) && (!c(jdField_b_of_type_Bire)))
    {
      b(bire.jdField_a_of_type_Bire, false);
      a(null);
    }
    if (a() != null) {
      a().notifyObservers(bjdt.class, 3, true, null);
    }
    if (this.jdField_a_of_type_Axgj != null) {
      this.jdField_a_of_type_Axgj.a(116, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     birb
 * JD-Core Version:    0.7.0.1
 */