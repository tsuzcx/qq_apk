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

public class bkzy
  extends blrr
{
  private static blab jdField_a_of_type_Blab;
  private static VideoMaterial jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial;
  public static final Long a;
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private static blab jdField_b_of_type_Blab;
  private azfy jdField_a_of_type_Azfy;
  private bkzx jdField_a_of_type_Bkzx;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  public String a;
  private List<bkzx> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private final Object jdField_b_of_type_JavaLangObject = new Object();
  public String b;
  private List<bkzx> jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private final Object jdField_c_of_type_JavaLangObject = new Object();
  private List<bkzx> jdField_c_of_type_JavaUtilList = new ArrayList();
  private List<blab> d = new LinkedList();
  
  static
  {
    jdField_a_of_type_JavaLangLong = Long.valueOf(2000L);
  }
  
  public bkzy()
  {
    this.jdField_a_of_type_JavaLangString = "recent_template_setting_new";
    this.jdField_b_of_type_JavaLangString = "recent_template_list_new";
    if (this.jdField_a_of_type_Bkzx == null)
    {
      this.jdField_a_of_type_Bkzx = new bkzx(c());
      this.jdField_a_of_type_Bkzx.jdField_a_of_type_JavaUtilList = new ArrayList(100);
    }
  }
  
  private int a(List<blab> paramList, String paramString)
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
      if (((blab)paramList.get(i)).jdField_a_of_type_JavaLangString.equals(paramString)) {
        break;
      }
      i += 1;
    }
    label61:
    return -1;
  }
  
  public static blab a()
  {
    return jdField_b_of_type_Blab;
  }
  
  private blab a(blab paramblab)
  {
    Object localObject1 = null;
    Iterator localIterator1 = this.jdField_a_of_type_JavaUtilList.iterator();
    if (localIterator1.hasNext())
    {
      Object localObject2 = (bkzx)localIterator1.next();
      int i;
      if (((bkzx)localObject2).jdField_a_of_type_JavaUtilList != null)
      {
        Iterator localIterator2 = ((bkzx)localObject2).jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator2.hasNext())
        {
          localObject2 = (blab)localIterator2.next();
          if (((blab)localObject2).equals(paramblab))
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
    File localFile = new File(bkoz.f);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return new File(localFile.getPath(), "camera_story_update_template.json").getPath();
  }
  
  @Nullable
  public static String a(@Nullable ArrayList<blaf> paramArrayList)
  {
    if (paramArrayList != null) {
      return GsonUtils.obj2Json(paramArrayList);
    }
    return null;
  }
  
  @Nullable
  public static ArrayList<blaf> a(@Nullable String paramString)
  {
    return (ArrayList)GsonUtils.json2Obj(paramString, new bkzz().getType());
  }
  
  private List<bkzx> a(File paramFile)
  {
    ArrayList localArrayList = new ArrayList();
    paramFile = bnpl.a(paramFile);
    if (TextUtils.isEmpty(paramFile)) {}
    do
    {
      return localArrayList;
      paramFile = AEMaterialConfigParser.a(paramFile);
    } while ((paramFile == null) || (paramFile.isEmpty()));
    return paramFile;
  }
  
  private List<bkzx> a(File paramFile1, File paramFile2)
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
      paramFile2 = (bkzx)localIterator1.next();
      localIterator2 = localList.iterator();
      do
      {
        if (!localIterator2.hasNext()) {
          break;
        }
        paramFile1 = (bkzx)localIterator2.next();
      } while (!paramFile1.jdField_b_of_type_JavaLangString.equals(paramFile2.jdField_b_of_type_JavaLangString));
    }
    for (;;)
    {
      if (paramFile1 == null)
      {
        paramFile1 = paramFile2.jdField_a_of_type_JavaUtilList.iterator();
        while (paramFile1.hasNext()) {
          b((blab)paramFile1.next());
        }
        break;
      }
      localIterator2 = paramFile2.jdField_a_of_type_JavaUtilList.iterator();
      label149:
      blab localblab;
      if (localIterator2.hasNext())
      {
        localblab = (blab)localIterator2.next();
        Iterator localIterator3 = paramFile1.jdField_a_of_type_JavaUtilList.iterator();
        do
        {
          if (!localIterator3.hasNext()) {
            break;
          }
          paramFile2 = (blab)localIterator3.next();
        } while (!localblab.jdField_a_of_type_JavaLangString.equals(paramFile2.jdField_a_of_type_JavaLangString));
      }
      for (;;)
      {
        if (paramFile2 == null)
        {
          b(localblab);
          break label149;
        }
        if (localblab.e.equals(paramFile2.e)) {
          break label149;
        }
        b(localblab);
        break label149;
        break;
        return localList;
        paramFile2 = null;
      }
      paramFile1 = null;
    }
  }
  
  private List<blab> a(List<bkzx> paramList, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        bkzx localbkzx = (bkzx)paramList.next();
        if (localbkzx.jdField_b_of_type_JavaLangString.equals(paramString))
        {
          localArrayList.addAll(localbkzx.jdField_a_of_type_JavaUtilList);
          if ((localArrayList.size() > 0) && (((blab)localArrayList.get(0)).equals(blab.jdField_a_of_type_Blab))) {
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
  
  private boolean a(@Nullable bkzx parambkzx)
  {
    if (parambkzx == null) {}
    while ((TextUtils.isEmpty(parambkzx.jdField_b_of_type_JavaLangString)) || (!"贴纸玩法".equals(parambkzx.jdField_b_of_type_JavaLangString))) {
      return false;
    }
    return true;
  }
  
  /* Error */
  public static boolean a(blab paramblab)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +15 -> 19
    //   7: aload_0
    //   8: getfield 248	blab:f	Ljava/lang/String;
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
    //   27: invokestatic 250	bkzy:b	(Lblab;)Z
    //   30: istore_1
    //   31: goto -10 -> 21
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	paramblab	blab
    //   14	17	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   7	15	34	finally
    //   26	31	34	finally
  }
  
  private blab b(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      blab localblab;
      do
      {
        Iterator localIterator1 = this.jdField_b_of_type_JavaUtilList.iterator();
        Iterator localIterator2;
        while (!localIterator2.hasNext())
        {
          if (!localIterator1.hasNext()) {
            break;
          }
          localIterator2 = ((bkzx)localIterator1.next()).jdField_a_of_type_JavaUtilList.iterator();
        }
        localblab = (blab)localIterator2.next();
      } while (!localblab.jdField_a_of_type_JavaLangString.equals(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("AEMaterialManager", 2, "existTemplateInfo id=" + paramString);
      }
      return localblab;
      return null;
    }
  }
  
  public static String b()
  {
    File localFile = new File(bkoz.d);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile.getPath();
  }
  
  private void b(blab paramblab)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEMaterialManager", 2, "deleteMaterialFolder: " + paramblab.jdField_a_of_type_JavaLangString);
    }
    File localFile = new File(bkoz.e, paramblab.jdField_a_of_type_JavaLangString);
    if (localFile.exists()) {
      bdhb.a(localFile.getPath());
    }
    paramblab = new File(bkoz.d, paramblab.jdField_a_of_type_JavaLangString);
    if (paramblab.exists()) {
      bdhb.a(paramblab.getPath());
    }
  }
  
  private void b(AppInterface paramAppInterface, String paramString, blab paramblab, blan paramblan)
  {
    blal.a(paramAppInterface, paramblab, paramString, new blaa(this, paramblan));
    paramString = new StringBuilder().append("【START】startDownloadMaterial :");
    if (paramblab == null) {}
    for (paramAppInterface = "null";; paramAppInterface = paramblab.jdField_a_of_type_JavaLangString)
    {
      bljn.b("AEMaterialManager", paramAppInterface);
      return;
    }
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Bkzx != null) && (this.jdField_a_of_type_Bkzx.jdField_a_of_type_JavaUtilList.size() >= 100);
  }
  
  private static boolean b(blab paramblab)
  {
    boolean bool = false;
    Object localObject = paramblab.a();
    File localFile1 = new File((String)localObject, "params.json");
    localObject = new File((String)localObject, "params.dat");
    if ((!localFile1.exists()) && (!((File)localObject).exists()))
    {
      try
      {
        File localFile2 = new File(paramblab.c());
        if (!localFile2.exists()) {
          return false;
        }
        ndr.a(localFile2, paramblab.b());
        return true;
      }
      catch (Exception paramblab)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AEMaterialManager", 2, "judgeTemplateUsable unZipFile exp:", paramblab);
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
    return alud.a(2131710214);
  }
  
  private List<bkzx> c()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = bkzr.b(a().getApp());
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
  
  private boolean c(@Nullable blab paramblab)
  {
    if ((paramblab == null) || (TextUtils.isEmpty(paramblab.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramblab.e))) {
      return false;
    }
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      blab localblab = (blab)localIterator.next();
      if ((localblab != null) && (!TextUtils.isEmpty(localblab.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localblab.e)) && (localblab.jdField_a_of_type_JavaLangString.equals(paramblab.jdField_a_of_type_JavaLangString)) && (localblab.e.equals(paramblab.e))) {
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
        localObject8 = new File(bkoz.f, "camera_story_update_template.json");
        localObject7 = new File(bkoz.f, "camera_story_default_template.json");
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
            bdhb.d(((File)localObject7).getPath());
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
          bdhb.b(((File)localObject8).getPath(), ((File)localObject7).getPath());
        }
        catch (AEMaterialConfigParser.AEMaterialConfigParseException localAEMaterialConfigParseException2)
        {
          bdhb.d(((File)localObject8).getPath());
          localList4 = c();
          k();
        }
        continue;
      }
      Object localObject2;
      try
      {
        localList4 = a((File)localObject7, (File)localObject8);
        bdhb.d(((File)localObject7).getPath());
        bdhb.b(((File)localObject8).getPath(), ((File)localObject7).getPath());
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
          localObject7 = (bkzx)((Iterator)localObject2).next();
          if (localObject7 == null) {
            continue;
          }
          if (a((bkzx)localObject7))
          {
            this.jdField_c_of_type_JavaUtilList.add(localObject7);
            localObject7 = ((bkzx)localObject7).jdField_a_of_type_JavaUtilList.iterator();
            if (!((Iterator)localObject7).hasNext()) {
              continue;
            }
            localObject8 = (blab)((Iterator)localObject7).next();
            if (localObject8 == null) {
              continue;
            }
            ((blab)localObject8).d = a((blab)localObject8);
          }
        }
        this.jdField_b_of_type_JavaUtilList.add(localObject7);
      }
      m();
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if ((this.jdField_b_of_type_JavaUtilList.size() > 0) && (!c().equals(((bkzx)this.jdField_b_of_type_JavaUtilList.get(0)).jdField_b_of_type_JavaLangString))) {
          this.jdField_b_of_type_JavaUtilList.add(0, this.jdField_a_of_type_Bkzx);
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
    bljc.a().a("CameraModuleSvc.GetCompressedCategoryMaterialMqStoryCamera", 4);
  }
  
  private void l()
  {
    bljn.b("AEMaterialManager", "filament isSupport: " + a());
  }
  
  private void m()
  {
    int i = 0;
    if (this.jdField_a_of_type_Bkzx == null) {}
    do
    {
      return;
      ??? = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      ??? = bljc.a().a(this.jdField_b_of_type_JavaLangString + (String)???, null, 0);
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
        this.jdField_a_of_type_Bkzx.jdField_a_of_type_JavaUtilList.clear();
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
        if (this.jdField_a_of_type_Bkzx.jdField_a_of_type_JavaUtilList.size() >= 100) {
          return;
        }
      }
      if (this.jdField_a_of_type_Bkzx.jdField_a_of_type_JavaUtilList.contains(localObject3)) {
        return;
      }
      if (((blab)localObject3).jdField_a_of_type_JavaLangString.equals("0")) {
        return;
      }
      this.jdField_a_of_type_Bkzx.jdField_a_of_type_JavaUtilList.add(localObject3);
      break label252;
      label249:
      return;
      label252:
      i += 1;
    }
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_Azfy != null) {
      this.jdField_a_of_type_Azfy.a(111, new Object[] { this.jdField_a_of_type_Bkzx });
    }
  }
  
  public blab a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilList.isEmpty()) {
      j();
    }
    Iterator localIterator1 = this.jdField_b_of_type_JavaUtilList.iterator();
    bkzx localbkzx;
    blab localblab;
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
          localbkzx = (bkzx)localIterator1.next();
        } while ((localbkzx == null) || (localbkzx.jdField_a_of_type_JavaUtilList == null));
        localIterator2 = localbkzx.jdField_a_of_type_JavaUtilList.iterator();
        i = 0;
      }
      localblab = (blab)localIterator2.next();
      j = i + 1;
      int i = j;
    } while (!localblab.jdField_a_of_type_JavaLangString.equals(paramString));
    if (QLog.isColorLevel()) {
      QLog.d("QIMRedDotConfig_PTV", 2, "selectPtvTemplateInfo= " + localblab);
    }
    localblab.jdField_b_of_type_JavaLangString = localbkzx.jdField_b_of_type_JavaLangString;
    localblab.jdField_b_of_type_Int = j;
    return localblab;
    return null;
  }
  
  public List<bkzx> a()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public List<bkzx> a(boolean paramBoolean)
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public void a(int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_Azfy != null) {
        this.jdField_a_of_type_Azfy.a(paramInt);
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
    if (this.jdField_a_of_type_Azfy != null)
    {
      this.jdField_a_of_type_Azfy.a(paramInt, new Object[] { paramObject });
      if (QLog.isColorLevel()) {
        QLog.d("AEMaterialManager", 2, "notifyEventId eventId=" + paramInt);
      }
    }
  }
  
  public void a(azga paramazga)
  {
    try
    {
      if (this.jdField_a_of_type_Azfy != null) {
        this.jdField_a_of_type_Azfy.a(paramazga);
      }
      return;
    }
    finally
    {
      paramazga = finally;
      throw paramazga;
    }
  }
  
  public void a(azga paramazga, int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_Azfy == null) {
        this.jdField_a_of_type_Azfy = new azfy();
      }
      this.jdField_a_of_type_Azfy.a(paramazga, new int[] { paramInt });
      return;
    }
    finally {}
  }
  
  public void a(blab paramblab)
  {
    if (paramblab == null) {}
    while (paramblab.c()) {
      return;
    }
    if (this.jdField_a_of_type_Bkzx == null)
    {
      m();
      return;
    }
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        i = a(this.jdField_a_of_type_Bkzx.jdField_a_of_type_JavaUtilList, paramblab.jdField_a_of_type_JavaLangString);
        if (i != -1) {
          break label186;
        }
        if (!b())
        {
          this.jdField_a_of_type_Bkzx.jdField_a_of_type_JavaUtilList.add(0, paramblab);
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
      this.jdField_a_of_type_Bkzx.jdField_a_of_type_JavaUtilList.remove(99);
      this.jdField_a_of_type_Bkzx.jdField_a_of_type_JavaUtilList.add(0, paramblab);
      n();
      continue;
      label186:
      if (i != 0)
      {
        this.jdField_a_of_type_Bkzx.jdField_a_of_type_JavaUtilList.remove(i);
        this.jdField_a_of_type_Bkzx.jdField_a_of_type_JavaUtilList.add(0, paramblab);
        n();
      }
    }
  }
  
  public void a(blab paramblab, boolean paramBoolean)
  {
    b(paramblab, paramBoolean);
    a(113, null);
  }
  
  public void a(AppInterface paramAppInterface, blab paramblab, blan paramblan)
  {
    a(paramAppInterface, bkoz.d, paramblab, paramblan);
  }
  
  public void a(AppInterface paramAppInterface, String paramString, blab paramblab, blan paramblan)
  {
    ThreadManager.excute(new AEMaterialManager.3(this, paramAppInterface, paramString, paramblab, paramblan), 128, null, true);
  }
  
  public void a(String paramString)
  {
    try
    {
      paramString = a(new File(paramString));
      if ((paramString != null) && (paramString.size() != 0)) {
        break label131;
      }
      paramString = a(c(), alud.a(2131689817));
    }
    catch (AEMaterialConfigParser.AEMaterialConfigParseException paramString)
    {
      ArrayList localArrayList;
      for (;;)
      {
        paramString.printStackTrace();
        return;
        paramString = a(paramString, alud.a(2131689818));
      }
      bljc.a().a("PhotoConst.ae_latest_material", a(localArrayList), 4);
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
      blab localblab = (blab)paramString.next();
      if ((localArrayList.size() < 10) && (localblab != null) && (localblab.jdField_a_of_type_JavaLangString != null) && (localblab.c != null)) {
        localArrayList.add(new blaf(localblab.jdField_a_of_type_JavaLangString, localblab.c));
      }
    }
  }
  
  public void a(@Nullable List<blab> paramList)
  {
    if (paramList != null) {
      this.d = paramList;
    }
  }
  
  public List<blab> b()
  {
    return a(this.jdField_b_of_type_JavaUtilList, alud.a(2131700394));
  }
  
  public void b(blab paramblab, boolean paramBoolean)
  {
    jdField_a_of_type_Blab = jdField_b_of_type_Blab;
    jdField_b_of_type_Blab = paramblab;
    if ((paramblab == null) || (paramblab.c())) {
      jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial = null;
    }
    if (paramBoolean) {
      a(paramblab);
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
    if (this.jdField_a_of_type_Bkzx == null) {}
    while ((this.jdField_a_of_type_Bkzx.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_Bkzx.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localObject3 = this.jdField_a_of_type_Bkzx.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        blab localblab = (blab)((Iterator)localObject3).next();
        if ((!TextUtils.isEmpty(localblab.jdField_a_of_type_JavaLangString)) && (!localblab.equals(blab.jdField_a_of_type_Blab)))
        {
          localStringBuilder.append(localblab.jdField_a_of_type_JavaLangString).append("|");
          localStringBuilder.append(localblab.jdField_a_of_type_Int).append("$");
        }
      }
    }
    if (TextUtils.isEmpty(localObject2.toString())) {
      return;
    }
    Object localObject3 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    bljc.a().a(this.jdField_b_of_type_JavaLangString + (String)localObject3, localObject2.toString(), 0);
    if (QLog.isColorLevel()) {
      QLog.d("AEMaterialManager", 2, "saveRecentTemplate list=" + localObject2.toString());
    }
  }
  
  public void h()
  {
    if ((!this.d.isEmpty()) && (!c(jdField_b_of_type_Blab)))
    {
      b(blab.jdField_a_of_type_Blab, false);
      a(null);
    }
    if (a() != null) {
      a().notifyObservers(bltq.class, 3, true, null);
    }
    if (this.jdField_a_of_type_Azfy != null) {
      this.jdField_a_of_type_Azfy.a(116, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkzy
 * JD-Core Version:    0.7.0.1
 */