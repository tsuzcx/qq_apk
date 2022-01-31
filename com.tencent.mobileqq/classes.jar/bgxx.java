import android.os.Environment;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.initializer.FilamentInitializer;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.util.GsonUtils;
import dov.com.qq.im.AECamera.AEMaterialConfigParser;
import dov.com.qq.im.AECamera.AEMaterialConfigParser.AEMaterialConfigParseException;
import dov.com.qq.im.AECamera.AEMaterialManager.2;
import dov.com.qq.im.AECamera.AEMaterialManager.4;
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

public class bgxx
  extends bhgm
{
  private static bgya jdField_a_of_type_Bgya;
  private static VideoMaterial jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial;
  public static final Long a;
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  private static bgya jdField_b_of_type_Bgya;
  public static final String c;
  public static String d;
  private static String e;
  private static String f;
  private awhb jdField_a_of_type_Awhb;
  private bgxt jdField_a_of_type_Bgxt;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  public String a;
  private List<bgxt> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private final Object jdField_b_of_type_JavaLangObject = new Object();
  public String b;
  private List<bgxt> jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private final Object jdField_c_of_type_JavaLangObject = new Object();
  private List<bgxt> jdField_c_of_type_JavaUtilList = new ArrayList();
  private List<bgya> d;
  
  static
  {
    int i = 0;
    jdField_a_of_type_JavaLangLong = Long.valueOf(2000L);
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_d_of_type_JavaLangString = "ptv_template_usable";
    try
    {
      boolean bool = "mounted".equals(Environment.getExternalStorageState());
      i = bool;
    }
    catch (Exception localException)
    {
      label38:
      File localFile;
      break label38;
    }
    if (i != 0) {}
    for (localFile = new File(ajed.aU);; localFile = BaseApplicationImpl.getApplication().getCacheDir())
    {
      jdField_c_of_type_JavaLangString = localFile.getPath();
      e = new File(localFile, "dov_ptv_template_dov").getPath();
      jdField_d_of_type_JavaLangString = e + File.separator + jdField_d_of_type_JavaLangString + File.separator;
      f = jdField_d_of_type_JavaLangString;
      return;
    }
  }
  
  public bgxx()
  {
    this.jdField_a_of_type_JavaLangString = "recent_template_setting_new";
    this.jdField_b_of_type_JavaLangString = "recent_template_list_new";
    this.jdField_d_of_type_JavaUtilList = new LinkedList();
    if (this.jdField_a_of_type_Bgxt == null)
    {
      this.jdField_a_of_type_Bgxt = new bgxt(c());
      this.jdField_a_of_type_Bgxt.jdField_a_of_type_JavaUtilList = new ArrayList(100);
    }
  }
  
  private int a(List<bgya> paramList, String paramString)
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
      if (((bgya)paramList.get(i)).jdField_a_of_type_JavaLangString.equals(paramString)) {
        break;
      }
      i += 1;
    }
    label61:
    return -1;
  }
  
  public static bgya a()
  {
    return jdField_b_of_type_Bgya;
  }
  
  private bgya a(bgya parambgya)
  {
    Object localObject1 = null;
    Iterator localIterator1 = this.jdField_a_of_type_JavaUtilList.iterator();
    if (localIterator1.hasNext())
    {
      Object localObject2 = (bgxt)localIterator1.next();
      int i;
      if (((bgxt)localObject2).jdField_a_of_type_JavaUtilList != null)
      {
        Iterator localIterator2 = ((bgxt)localObject2).jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator2.hasNext())
        {
          localObject2 = (bgya)localIterator2.next();
          if (((bgya)localObject2).equals(parambgya))
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
    return new File(e, "camera_story_update_template.json").getPath();
  }
  
  @Nullable
  public static String a(@Nullable ArrayList<avzf> paramArrayList)
  {
    if (paramArrayList != null) {
      return GsonUtils.obj2Json(paramArrayList);
    }
    return null;
  }
  
  @Nullable
  public static ArrayList<avzf> a(@Nullable String paramString)
  {
    return (ArrayList)GsonUtils.json2Obj(paramString, new bgxy().getType());
  }
  
  private List<bgxt> a(File paramFile)
  {
    ArrayList localArrayList = new ArrayList();
    paramFile = bjin.a(paramFile);
    if (TextUtils.isEmpty(paramFile)) {}
    do
    {
      return localArrayList;
      paramFile = AEMaterialConfigParser.a(paramFile);
    } while ((paramFile == null) || (paramFile.isEmpty()));
    return paramFile;
  }
  
  private List<bgxt> a(File paramFile1, File paramFile2)
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
      paramFile2 = (bgxt)localIterator1.next();
      localIterator2 = localList.iterator();
      do
      {
        if (!localIterator2.hasNext()) {
          break;
        }
        paramFile1 = (bgxt)localIterator2.next();
      } while (!paramFile1.jdField_b_of_type_JavaLangString.equals(paramFile2.jdField_b_of_type_JavaLangString));
    }
    for (;;)
    {
      if (paramFile1 == null)
      {
        paramFile1 = paramFile2.jdField_a_of_type_JavaUtilList.iterator();
        while (paramFile1.hasNext()) {
          b((bgya)paramFile1.next());
        }
        break;
      }
      localIterator2 = paramFile2.jdField_a_of_type_JavaUtilList.iterator();
      label149:
      bgya localbgya;
      if (localIterator2.hasNext())
      {
        localbgya = (bgya)localIterator2.next();
        Iterator localIterator3 = paramFile1.jdField_a_of_type_JavaUtilList.iterator();
        do
        {
          if (!localIterator3.hasNext()) {
            break;
          }
          paramFile2 = (bgya)localIterator3.next();
        } while (!localbgya.jdField_a_of_type_JavaLangString.equals(paramFile2.jdField_a_of_type_JavaLangString));
      }
      for (;;)
      {
        if (paramFile2 == null)
        {
          b(localbgya);
          break label149;
        }
        if (localbgya.jdField_d_of_type_JavaLangString.equals(paramFile2.jdField_d_of_type_JavaLangString)) {
          break label149;
        }
        b(localbgya);
        break label149;
        break;
        return localList;
        paramFile2 = null;
      }
      paramFile1 = null;
    }
  }
  
  private List<bgya> a(List<bgxt> paramList, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        bgxt localbgxt = (bgxt)paramList.next();
        if (localbgxt.jdField_b_of_type_JavaLangString.equals(paramString))
        {
          localArrayList.addAll(localbgxt.jdField_a_of_type_JavaUtilList);
          if ((localArrayList.size() > 0) && (((bgya)localArrayList.get(0)).equals(bgya.jdField_a_of_type_Bgya))) {
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
  
  private boolean a(@Nullable bgxt parambgxt)
  {
    if (parambgxt == null) {}
    while ((TextUtils.isEmpty(parambgxt.jdField_b_of_type_JavaLangString)) || (!"贴纸玩法".equals(parambgxt.jdField_b_of_type_JavaLangString))) {
      return false;
    }
    return true;
  }
  
  /* Error */
  public static boolean a(bgya parambgya)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +15 -> 19
    //   7: aload_0
    //   8: getfield 287	bgya:e	Ljava/lang/String;
    //   11: invokestatic 235	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
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
    //   27: invokestatic 289	bgxx:b	(Lbgya;)Z
    //   30: istore_1
    //   31: goto -10 -> 21
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	parambgya	bgya
    //   14	17	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   7	15	34	finally
    //   26	31	34	finally
  }
  
  private bgya b(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      bgya localbgya;
      do
      {
        Iterator localIterator1 = this.jdField_b_of_type_JavaUtilList.iterator();
        Iterator localIterator2;
        while (!localIterator2.hasNext())
        {
          if (!localIterator1.hasNext()) {
            break;
          }
          localIterator2 = ((bgxt)localIterator1.next()).jdField_a_of_type_JavaUtilList.iterator();
        }
        localbgya = (bgya)localIterator2.next();
      } while (!localbgya.jdField_a_of_type_JavaLangString.equals(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("AEMaterialManager", 2, "existTemplateInfo id=" + paramString);
      }
      return localbgya;
      return null;
    }
  }
  
  public static String b()
  {
    return e;
  }
  
  private void b(bgya parambgya)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEMaterialManager", 2, "deleteMaterialFolder: " + parambgya.jdField_a_of_type_JavaLangString);
    }
    File localFile = new File(f, parambgya.jdField_a_of_type_JavaLangString);
    if (localFile.exists()) {
      bace.a(localFile.getPath());
    }
    parambgya = new File(e, parambgya.jdField_a_of_type_JavaLangString);
    if (parambgya.exists()) {
      bace.a(parambgya.getPath());
    }
  }
  
  private void b(AppInterface paramAppInterface, bgya parambgya, bgxw parambgxw)
  {
    parambgxw = new bgxz(this, parambgxw);
    bgxu.a(paramAppInterface, parambgya, e, parambgxw);
    parambgxw = new StringBuilder().append("【START】startDownloadMaterial :");
    if (parambgya == null) {}
    for (paramAppInterface = "null";; paramAppInterface = parambgya.jdField_a_of_type_JavaLangString)
    {
      bhcs.a("AEMaterialManager", 1, paramAppInterface);
      return;
    }
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Bgxt != null) && (this.jdField_a_of_type_Bgxt.jdField_a_of_type_JavaUtilList.size() >= 100);
  }
  
  private static boolean b(bgya parambgya)
  {
    boolean bool = false;
    Object localObject = parambgya.a();
    File localFile1 = new File((String)localObject, "params.json");
    localObject = new File((String)localObject, "params.dat");
    if ((!localFile1.exists()) && (!((File)localObject).exists()))
    {
      try
      {
        File localFile2 = new File(parambgya.c());
        if (!localFile2.exists()) {
          return false;
        }
        mpx.a(localFile2, parambgya.b());
        return true;
      }
      catch (Exception parambgya)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AEMaterialManager", 2, "judgeTemplateUsable unZipFile exp:", parambgya);
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
    return ajjy.a(2131644034);
  }
  
  private List<bgxt> c()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = avzk.b(a().getApp());
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
  
  private boolean c(@Nullable bgya parambgya)
  {
    if ((parambgya == null) || (TextUtils.isEmpty(parambgya.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(parambgya.jdField_d_of_type_JavaLangString))) {
      return false;
    }
    Iterator localIterator = this.jdField_d_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      bgya localbgya = (bgya)localIterator.next();
      if ((localbgya != null) && (!TextUtils.isEmpty(localbgya.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localbgya.jdField_d_of_type_JavaLangString)) && (localbgya.jdField_a_of_type_JavaLangString.equals(parambgya.jdField_a_of_type_JavaLangString)) && (localbgya.jdField_d_of_type_JavaLangString.equals(parambgya.jdField_d_of_type_JavaLangString))) {
        return true;
      }
    }
    return false;
  }
  
  private void h()
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("AEMaterialManager", 2, "initMaterialList enter");
    }
    j();
    for (;;)
    {
      Object localObject8;
      Object localObject7;
      synchronized (this.jdField_c_of_type_JavaLangObject)
      {
        localObject8 = new File(e, "camera_story_update_template.json");
        localObject7 = new File(e, "camera_story_default_template.json");
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
            bace.d(((File)localObject7).getPath());
            List localList2 = c();
            i();
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
          bace.b(((File)localObject8).getPath(), ((File)localObject7).getPath());
        }
        catch (AEMaterialConfigParser.AEMaterialConfigParseException localAEMaterialConfigParseException2)
        {
          bace.d(((File)localObject8).getPath());
          localList4 = c();
          i();
        }
        continue;
      }
      Object localObject2;
      try
      {
        localList4 = a((File)localObject7, (File)localObject8);
        bace.d(((File)localObject7).getPath());
        bace.b(((File)localObject8).getPath(), ((File)localObject7).getPath());
      }
      catch (AEMaterialConfigParser.AEMaterialConfigParseException localAEMaterialConfigParseException3)
      {
        localObject2 = c();
        i();
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
          localObject7 = (bgxt)((Iterator)localObject2).next();
          if (localObject7 == null) {
            continue;
          }
          if (a((bgxt)localObject7))
          {
            this.jdField_c_of_type_JavaUtilList.add(localObject7);
            localObject7 = ((bgxt)localObject7).jdField_a_of_type_JavaUtilList.iterator();
            if (!((Iterator)localObject7).hasNext()) {
              continue;
            }
            localObject8 = (bgya)((Iterator)localObject7).next();
            if (localObject8 == null) {
              continue;
            }
            ((bgya)localObject8).jdField_d_of_type_Boolean = a((bgya)localObject8);
          }
        }
        this.jdField_b_of_type_JavaUtilList.add(localObject7);
      }
      k();
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if ((this.jdField_b_of_type_JavaUtilList.size() > 0) && (!c().equals(((bgxt)this.jdField_b_of_type_JavaUtilList.get(0)).jdField_b_of_type_JavaLangString))) {
          this.jdField_b_of_type_JavaUtilList.add(0, this.jdField_a_of_type_Bgxt);
        }
        f();
        if (!QLog.isColorLevel()) {
          continue;
        }
        long l2 = System.currentTimeMillis();
        QLog.d("AEMaterialManager", 2, "initMaterialList exit, cost = " + (l2 - l1) + "ms");
        return;
      }
    }
  }
  
  private void i()
  {
    bgxb.a().a("CameraModuleSvc.GetCompressedCategoryMaterialMqStoryCamera", 4);
  }
  
  private void j()
  {
    bhcs.a("AEMaterialManager", 1, "filament isSupport: " + a());
  }
  
  private void k()
  {
    int i = 0;
    if (this.jdField_a_of_type_Bgxt == null) {}
    do
    {
      return;
      ??? = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      ??? = bgxb.a().a(this.jdField_b_of_type_JavaLangString + (String)???, null, 0);
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
        this.jdField_a_of_type_Bgxt.jdField_a_of_type_JavaUtilList.clear();
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
        if (this.jdField_a_of_type_Bgxt.jdField_a_of_type_JavaUtilList.size() >= 100) {
          return;
        }
      }
      if (this.jdField_a_of_type_Bgxt.jdField_a_of_type_JavaUtilList.contains(localObject3)) {
        return;
      }
      if (((bgya)localObject3).jdField_a_of_type_JavaLangString.equals("0")) {
        return;
      }
      this.jdField_a_of_type_Bgxt.jdField_a_of_type_JavaUtilList.add(localObject3);
      break label252;
      label249:
      return;
      label252:
      i += 1;
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_Awhb != null) {
      this.jdField_a_of_type_Awhb.a(111, new Object[] { this.jdField_a_of_type_Bgxt });
    }
  }
  
  public bgya a(String paramString)
  {
    bgya localbgya;
    do
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      Object localObject;
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (bgxt)localIterator.next();
        } while ((localObject == null) || (((bgxt)localObject).jdField_a_of_type_JavaUtilList == null));
        localObject = ((bgxt)localObject).jdField_a_of_type_JavaUtilList.iterator();
      }
      localbgya = (bgya)((Iterator)localObject).next();
    } while (!localbgya.jdField_a_of_type_JavaLangString.equals(paramString));
    if (QLog.isColorLevel()) {
      QLog.d("QIMRedDotConfig_PTV", 2, "selectPtvTemplateInfo= " + localbgya);
    }
    return localbgya;
    return null;
  }
  
  public List<bgxt> a()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public List<bgxt> a(boolean paramBoolean)
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public void a()
  {
    b();
  }
  
  public void a(int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_Awhb != null) {
        this.jdField_a_of_type_Awhb.a(paramInt);
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
    if (this.jdField_a_of_type_Awhb != null)
    {
      this.jdField_a_of_type_Awhb.a(paramInt, new Object[] { paramObject });
      if (QLog.isColorLevel()) {
        QLog.d("AEMaterialManager", 2, "notifyEventId eventId=" + paramInt);
      }
    }
  }
  
  public void a(awhd paramawhd)
  {
    try
    {
      if (this.jdField_a_of_type_Awhb != null) {
        this.jdField_a_of_type_Awhb.a(paramawhd);
      }
      return;
    }
    finally
    {
      paramawhd = finally;
      throw paramawhd;
    }
  }
  
  public void a(awhd paramawhd, int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_Awhb == null) {
        this.jdField_a_of_type_Awhb = new awhb();
      }
      this.jdField_a_of_type_Awhb.a(paramawhd, new int[] { paramInt });
      return;
    }
    finally {}
  }
  
  public void a(bgya parambgya)
  {
    if (parambgya == null) {}
    while (parambgya.c()) {
      return;
    }
    if (this.jdField_a_of_type_Bgxt == null)
    {
      k();
      return;
    }
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        i = a(this.jdField_a_of_type_Bgxt.jdField_a_of_type_JavaUtilList, parambgya.jdField_a_of_type_JavaLangString);
        if (i != -1) {
          break label186;
        }
        if (!b())
        {
          this.jdField_a_of_type_Bgxt.jdField_a_of_type_JavaUtilList.add(0, parambgya);
          l();
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
      this.jdField_a_of_type_Bgxt.jdField_a_of_type_JavaUtilList.remove(99);
      this.jdField_a_of_type_Bgxt.jdField_a_of_type_JavaUtilList.add(0, parambgya);
      l();
      continue;
      label186:
      if (i != 0)
      {
        this.jdField_a_of_type_Bgxt.jdField_a_of_type_JavaUtilList.remove(i);
        this.jdField_a_of_type_Bgxt.jdField_a_of_type_JavaUtilList.add(0, parambgya);
        l();
      }
    }
  }
  
  public void a(bgya parambgya, boolean paramBoolean)
  {
    b(parambgya, paramBoolean);
    a(113, null);
  }
  
  public void a(AppInterface paramAppInterface, bgya parambgya, bgxw parambgxw)
  {
    ThreadManager.excute(new AEMaterialManager.4(this, paramAppInterface, parambgya, parambgxw), 128, null, true);
  }
  
  public void a(String paramString)
  {
    try
    {
      paramString = a(new File(paramString));
      if ((paramString != null) && (paramString.size() != 0)) {
        break label113;
      }
      paramString = a(c(), ajjy.a(2131624245));
    }
    catch (AEMaterialConfigParser.AEMaterialConfigParseException paramString)
    {
      ArrayList localArrayList;
      for (;;)
      {
        paramString.printStackTrace();
        return;
        paramString = a(paramString, ajjy.a(2131624246));
      }
      bgxb.a().a("PhotoConst.ae_latest_material", a(localArrayList), 4);
      return;
    }
    catch (NullPointerException paramString)
    {
      label113:
      paramString.printStackTrace();
    }
    localArrayList = new ArrayList();
    paramString = paramString.iterator();
    while (paramString.hasNext())
    {
      bgya localbgya = (bgya)paramString.next();
      if (localArrayList.size() < 10) {
        localArrayList.add(new avzf(localbgya.jdField_a_of_type_JavaLangString, localbgya.jdField_b_of_type_JavaLangString));
      }
    }
  }
  
  public void a(@Nullable List<bgya> paramList)
  {
    if (paramList != null) {
      this.jdField_d_of_type_JavaUtilList = paramList;
    }
  }
  
  public List<bgya> b()
  {
    return a(this.jdField_b_of_type_JavaUtilList, ajjy.a(2131634214));
  }
  
  public void b()
  {
    h();
  }
  
  public void b(bgya parambgya, boolean paramBoolean)
  {
    jdField_a_of_type_Bgya = jdField_b_of_type_Bgya;
    jdField_b_of_type_Bgya = parambgya;
    if ((parambgya == null) || (parambgya.c())) {
      jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial = null;
    }
    if (paramBoolean) {
      a(parambgya);
    }
  }
  
  public void c()
  {
    ThreadManager.excute(new AEMaterialManager.2(this), 64, null, false);
  }
  
  public void d()
  {
    h();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Bgxt == null) {}
    while ((this.jdField_a_of_type_Bgxt.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_Bgxt.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localObject3 = this.jdField_a_of_type_Bgxt.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        bgya localbgya = (bgya)((Iterator)localObject3).next();
        if ((!TextUtils.isEmpty(localbgya.jdField_a_of_type_JavaLangString)) && (!localbgya.equals(bgya.jdField_a_of_type_Bgya)))
        {
          localStringBuilder.append(localbgya.jdField_a_of_type_JavaLangString).append("|");
          localStringBuilder.append(localbgya.jdField_a_of_type_Int).append("$");
        }
      }
    }
    if (TextUtils.isEmpty(localObject2.toString())) {
      return;
    }
    Object localObject3 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    bgxb.a().a(this.jdField_b_of_type_JavaLangString + (String)localObject3, localObject2.toString(), 0);
    if (QLog.isColorLevel()) {
      QLog.d("AEMaterialManager", 2, "saveRecentTemplate list=" + localObject2.toString());
    }
  }
  
  public void f()
  {
    if (!c(jdField_b_of_type_Bgya))
    {
      b(bgya.jdField_a_of_type_Bgya, false);
      a(null);
    }
    if (a() != null) {
      a().notifyObservers(bhik.class, 3, true, null);
    }
    if (this.jdField_a_of_type_Awhb != null) {
      this.jdField_a_of_type_Awhb.a(116, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bgxx
 * JD-Core Version:    0.7.0.1
 */