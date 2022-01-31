import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.MovieMaterial;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager.1;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager.2;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager.3;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager.4;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager.5;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bnpl
  extends blrr
{
  public static int a;
  public static File a;
  public static final Long a;
  public static String a;
  public static AtomicBoolean a;
  private static File jdField_b_of_type_JavaIoFile;
  public static String b;
  public static String c;
  private static final String h;
  private azfy jdField_a_of_type_Azfy;
  private blsw jdField_a_of_type_Blsw;
  private MovieMaterial jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterMaterialMovieMaterial;
  public final Object a;
  HashMap<Integer, Object> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public List<blsw> a;
  private blsw jdField_b_of_type_Blsw;
  protected Object b;
  String d;
  String e;
  public String f = "recent_template_setting";
  public String g = "recent_template_list";
  private String i;
  
  static
  {
    jdField_a_of_type_JavaLangLong = Long.valueOf(2000L);
    jdField_a_of_type_JavaLangString = "ptv_template_usable";
    jdField_b_of_type_JavaLangString = "ptv_debug";
    jdField_c_of_type_JavaLangString = "ptv_template_usable_doodle";
    File localFile = new File(ajrx.d);
    h = localFile.getPath();
    jdField_b_of_type_JavaIoFile = new File(localFile, "dov_ptv_template_dov");
    jdField_a_of_type_JavaLangString = jdField_b_of_type_JavaIoFile.getPath() + File.separator + jdField_a_of_type_JavaLangString + File.separator;
    jdField_b_of_type_JavaLangString = jdField_b_of_type_JavaIoFile.getPath() + File.separator + jdField_b_of_type_JavaLangString;
    jdField_a_of_type_JavaIoFile = new File(localFile, "doodle_template");
    jdField_c_of_type_JavaLangString = jdField_a_of_type_JavaIoFile.getPath() + File.separator + jdField_c_of_type_JavaLangString + File.separator;
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public bnpl()
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_b_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  }
  
  private int a(List<PtvTemplateManager.PtvTemplateInfo> paramList, String paramString)
  {
    int k;
    if ((paramList == null) || (paramList.size() <= 0))
    {
      k = -1;
      return k;
    }
    int j = 0;
    for (;;)
    {
      if (j >= paramList.size()) {
        break label61;
      }
      k = j;
      if (((PtvTemplateManager.PtvTemplateInfo)paramList.get(j)).id.equals(paramString)) {
        break;
      }
      j += 1;
    }
    label61:
    return -1;
  }
  
  public static String a(File paramFile)
  {
    paramFile = bdhb.a(paramFile);
    if ((paramFile == null) || (paramFile.length <= 0)) {
      return null;
    }
    if (Build.VERSION.SDK_INT <= 8) {
      return new String(paramFile);
    }
    try
    {
      paramFile = new String(paramFile, "UTF-8");
      return paramFile;
    }
    catch (UnsupportedEncodingException paramFile)
    {
      QLog.e("QIMPtvTemplateManager_PTV", 1, "loadFileContent error, ", paramFile);
    }
    return null;
  }
  
  private ArrayList<blsw> a(ArrayList<blsw> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      blsw localblsw = b((blsw)paramArrayList.next());
      if ((localblsw != null) && (localblsw.jdField_a_of_type_JavaUtilList.size() > 0)) {
        localArrayList.add(localblsw);
      } else if (QLog.isColorLevel()) {
        QLog.d("QIMPtvTemplateManager", 2, "templateInfoList.size() == 0 all not support segment should hide tab!");
      }
    }
    return localArrayList;
  }
  
  public static List<blsw> a(bnpl parambnpl, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString);
        if (parambnpl != null)
        {
          if (((JSONObject)localObject).has("guide_video_url")) {
            parambnpl.d = ((JSONObject)localObject).getString("guide_video_url");
          }
          if (((JSONObject)localObject).has("guide_video_md5")) {
            parambnpl.e = ((JSONObject)localObject).getString("guide_video_md5");
          }
        }
        if (!((JSONObject)localObject).has("bigheadCommonRes")) {
          break label152;
        }
        paramString = ((JSONObject)localObject).getJSONObject("bigheadCommonRes");
        if (paramString == null) {
          break label152;
        }
        str = paramString.optString("bighead_model_name", "");
        parambnpl = paramString.optString("bighead_model_resurl", "");
        paramString = paramString.optString("bighead_model_resmd5", "");
        if (!((JSONObject)localObject).has("category")) {
          break;
        }
        localObject = a(((JSONObject)localObject).getJSONArray("category"));
        a((List)localObject, str, parambnpl, paramString);
        return localObject;
      }
      catch (JSONException parambnpl) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      parambnpl.printStackTrace();
      return null;
      label152:
      String str = "";
      paramString = "";
      parambnpl = "";
    }
  }
  
  static List<blsw> a(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {}
    int k;
    do
    {
      return null;
      k = paramJSONArray.length();
    } while (k <= 0);
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    for (;;)
    {
      blsw localblsw;
      if (j < k) {
        try
        {
          localblsw = new blsw();
          Object localObject = paramJSONArray.getJSONObject(j);
          if (((JSONObject)localObject).has("content")) {
            localblsw.jdField_a_of_type_JavaUtilList = PtvTemplateManager.PtvTemplateInfo.convertFrom(((JSONObject)localObject).getJSONArray("content"));
          }
          if (((JSONObject)localObject).has("categoryName")) {
            localblsw.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).getString("categoryName");
          }
          if ((((JSONObject)localObject).has("TipsVer")) && (((JSONObject)localObject).has("Tips")))
          {
            localblsw.jdField_b_of_type_Int = ((JSONObject)localObject).getInt("TipsVer");
            localblsw.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).getString("Tips");
          }
          localblsw.jdField_b_of_type_Boolean = "1".equals(((JSONObject)localObject).optString("random_position"));
          if (((JSONObject)localObject).has("categoryId"))
          {
            localblsw.jdField_a_of_type_Int = ((JSONObject)localObject).getInt("categoryId");
            if ((localblsw.jdField_a_of_type_JavaUtilList != null) && (!localblsw.jdField_a_of_type_JavaUtilList.isEmpty()))
            {
              localObject = localblsw.jdField_a_of_type_JavaUtilList.iterator();
              while (((Iterator)localObject).hasNext())
              {
                ((PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject).next()).categoryId = localblsw.jdField_a_of_type_Int;
                continue;
                return localArrayList;
              }
            }
          }
        }
        catch (JSONException paramJSONArray)
        {
          if (QLog.isColorLevel()) {
            paramJSONArray.printStackTrace();
          }
        }
      }
      localArrayList.add(localblsw);
      j += 1;
    }
  }
  
  static void a(String paramString1, String paramString2)
  {
    ThreadManager.getFileThreadHandler().post(new QIMPtvTemplateManager.2(paramString2, paramString1));
  }
  
  private static void a(List<blsw> paramList, String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return;
    }
    while ((paramList == null) || (paramList.size() <= 0)) {}
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (blsw)paramList.next();
      if ((((blsw)localObject).jdField_a_of_type_JavaUtilList == null) || (((blsw)localObject).jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break;
      }
      localObject = ((blsw)localObject).jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject).next();
        if ((localPtvTemplateInfo != null) && (localPtvTemplateInfo.kind == 20))
        {
          localPtvTemplateInfo.bigHeadName = paramString1;
          localPtvTemplateInfo.bigHeadUrl = paramString2;
          localPtvTemplateInfo.bigHeadMd5 = paramString3;
        }
      }
    }
  }
  
  public static boolean a()
  {
    boolean bool = new File(jdField_b_of_type_JavaIoFile, "ptv_template_new.cfg").exists();
    if (QLog.isColorLevel()) {
      QLog.i("QIMPtvTemplateManager", 2, "QIMPtvTemplateManager isStickerConfigFileExist" + bool);
    }
    return bool;
  }
  
  private boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    Object localObject;
    label186:
    label207:
    label209:
    do
    {
      do
      {
        for (;;)
        {
          return false;
          localObject = new File(jdField_b_of_type_JavaIoFile, paramString1);
          if (((File)localObject).exists()) {
            try
            {
              localObject = bdhb.c(((File)localObject).getPath());
              if ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).equalsIgnoreCase(paramString2))) {
                break label209;
              }
              localObject = jdField_a_of_type_JavaLangString + paramString1 + File.separator;
              paramString2 = new File((String)localObject, "params.json");
              localObject = new File((String)localObject, "params.dat");
              if ((paramString2.exists()) || ((paramBoolean) && (((File)localObject).exists()))) {
                break label207;
              }
              if (!QLog.isColorLevel()) {}
            }
            catch (UnsatisfiedLinkError paramString1)
            {
              try
              {
                ndr.a(new File(jdField_b_of_type_JavaIoFile, paramString1), jdField_a_of_type_JavaLangString);
                return true;
              }
              catch (Exception paramString1)
              {
                if (!QLog.isColorLevel()) {
                  break label186;
                }
                QLog.e("QIMPtvTemplateManager", 2, "judgeTemplateUsable unZipFile exp:", paramString1);
              }
              paramString1 = paramString1;
            }
          }
        }
        QLog.e("QIMPtvTemplateManager", 2, "judgeTemplateUsable calcMd5 error:", paramString1);
        return false;
      } while ((!paramString2.exists()) || ((!paramBoolean) && (!((File)localObject).exists())));
      return true;
      return true;
    } while (!QLog.isColorLevel());
    QLog.e("QIMPtvTemplateManager", 2, "judgeTemplateUsable md5 exp, fileMd5:" + (String)localObject + ", tempMd5:" + paramString2 + ", name:" + paramString1);
    return false;
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Blsw != null) && (this.jdField_a_of_type_Blsw.jdField_a_of_type_JavaUtilList.size() >= 100);
  }
  
  public int a()
  {
    return -1;
  }
  
  public blsw a(blsw paramblsw)
  {
    int j = 0;
    ??? = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    ??? = BaseApplicationImpl.getApplication().getSharedPreferences(this.f, 0).getString(this.g + (String)???, null);
    if (QLog.isColorLevel()) {
      QLog.d("QIMPtvTemplateManager", 2, "getRecentTemplate list=" + (String)???);
    }
    if (TextUtils.isEmpty((CharSequence)???)) {
      return paramblsw;
    }
    String[] arrayOfString = ((String)???).split("\\$");
    for (;;)
    {
      Object localObject2;
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        paramblsw.jdField_a_of_type_JavaUtilList.clear();
        if (j >= arrayOfString.length) {
          break label212;
        }
        localObject2 = arrayOfString[j].split("\\|");
        if ((localObject2 == null) || (localObject2.length != 2)) {
          break label216;
        }
        Integer.valueOf(localObject2[1]).intValue();
        localObject2 = a(localObject2[0]);
        if (localObject2 == null) {
          break label216;
        }
        if (paramblsw.jdField_a_of_type_JavaUtilList.size() >= 100) {
          return paramblsw;
        }
      }
      paramblsw.jdField_a_of_type_JavaUtilList.add(localObject2);
      break label216;
      label212:
      return paramblsw;
      label216:
      j += 1;
    }
  }
  
  public MovieMaterial a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterMaterialMovieMaterial;
  }
  
  public PtvTemplateManager.PtvTemplateInfo a()
  {
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    do
    {
      Iterator localIterator = a().iterator();
      Object localObject;
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (blsw)localIterator.next();
        } while ((localObject == null) || (((blsw)localObject).jdField_a_of_type_JavaUtilList == null) || (((blsw)localObject).jdField_a_of_type_Int != blra.jdField_b_of_type_Int));
        localObject = ((blsw)localObject).jdField_a_of_type_JavaUtilList.iterator();
      }
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject).next();
    } while (!localPtvTemplateInfo.id.equals(blra.jdField_b_of_type_JavaLangString));
    if (QLog.isColorLevel()) {
      QLog.d("QIMRedDotConfig_PTV", 2, "selectPtvTemplateInfo= " + localPtvTemplateInfo);
    }
    return localPtvTemplateInfo;
    return null;
  }
  
  public PtvTemplateManager.PtvTemplateInfo a(String paramString)
  {
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    do
    {
      Iterator localIterator1 = a().iterator();
      Iterator localIterator2;
      while (!localIterator2.hasNext())
      {
        if (!localIterator1.hasNext()) {
          break;
        }
        localIterator2 = ((blsw)localIterator1.next()).jdField_a_of_type_JavaUtilList.iterator();
      }
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)localIterator2.next();
    } while (!localPtvTemplateInfo.id.equals(paramString));
    if (QLog.isColorLevel()) {
      QLog.d("QIMPtvTemplateManager", 2, "QIMPtvTemplateManager existTemplateInfo id=" + paramString);
    }
    return localPtvTemplateInfo;
    return null;
  }
  
  public Runnable a(File paramFile)
  {
    return new QIMPtvTemplateManager.5(this, paramFile);
  }
  
  public Runnable a(boolean paramBoolean)
  {
    return new QIMPtvTemplateManager.1(this, paramBoolean);
  }
  
  public String a()
  {
    return this.i;
  }
  
  public ArrayList<blsw> a()
  {
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
    if (!azjh.a(jdField_a_of_type_Int))
    {
      List localList = a();
      if ((localList != null) && (!localList.isEmpty())) {
        localArrayList.removeAll(localList);
      }
    }
    return localArrayList;
  }
  
  public ArrayList<blsw> a(boolean paramBoolean)
  {
    ArrayList localArrayList = a(a());
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Blsw == null)
      {
        this.jdField_a_of_type_Blsw = new blsw(alud.a(2131710214));
        this.jdField_a_of_type_Blsw.jdField_a_of_type_JavaUtilList = new ArrayList(100);
      }
      if (paramBoolean) {
        a(this.jdField_a_of_type_Blsw);
      }
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      this.jdField_b_of_type_Blsw = b(this.jdField_a_of_type_Blsw);
      localArrayList.add(0, this.jdField_b_of_type_Blsw);
      if (QLog.isColorLevel()) {
        QLog.d("QIMPtvTemplateManager", 2, "getRecentTemplateAndConfigTemplate needInitRecent: " + paramBoolean);
      }
      return localArrayList;
    }
  }
  
  public List<blsw> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      blsw localblsw = (blsw)localIterator.next();
      if (localblsw.jdField_a_of_type_Boolean) {
        localArrayList.add(localblsw);
      }
    }
    return localArrayList;
  }
  
  public List<blsw> a(File paramFile)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMPtvTemplateManager", 2, String.format("rebuildTemplateInfos, cur_runnable[%s]", new Object[] { Integer.valueOf(hashCode()) }));
    }
    paramFile = a(paramFile);
    if (TextUtils.isEmpty(paramFile)) {}
    do
    {
      return null;
      paramFile = a(this, paramFile);
    } while ((paramFile == null) || (paramFile.isEmpty()));
    Iterator localIterator = paramFile.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (blsw)localIterator.next();
      if ((((blsw)localObject).jdField_a_of_type_JavaUtilList != null) && (((blsw)localObject).jdField_a_of_type_JavaUtilList.size() != 0))
      {
        localObject = ((blsw)localObject).jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject).next();
          if (localPtvTemplateInfo != null) {
            localPtvTemplateInfo.usable = a(localPtvTemplateInfo);
          }
        }
      }
    }
    d();
    return paramFile;
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
        QLog.d("QIMPtvTemplateManager", 2, "notifyEventId eventId" + paramInt);
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
  
  public void a(AppInterface paramAppInterface, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, bnpi parambnpi)
  {
    if (paramPtvTemplateInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMPtvTemplateManager", 2, "startDownloadTemplate is null");
      }
      return;
    }
    b(paramAppInterface, paramPtvTemplateInfo, parambnpi);
  }
  
  public void a(MovieMaterial paramMovieMaterial)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterMaterialMovieMaterial = paramMovieMaterial;
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt)
  {
    for (;;)
    {
      int j;
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_Blsw == null)
        {
          this.jdField_a_of_type_Blsw = new blsw(alud.a(2131710217));
          this.jdField_a_of_type_Blsw.jdField_a_of_type_JavaUtilList = new ArrayList(100);
          a(this.jdField_a_of_type_Blsw);
        }
        if (this.jdField_b_of_type_Blsw == null) {
          this.jdField_b_of_type_Blsw = this.jdField_a_of_type_Blsw.a();
        }
        j = a(this.jdField_a_of_type_Blsw.jdField_a_of_type_JavaUtilList, paramPtvTemplateInfo.id);
        if (j == -1)
        {
          if (!b())
          {
            this.jdField_a_of_type_Blsw.jdField_a_of_type_JavaUtilList.add(0, paramPtvTemplateInfo);
            this.jdField_b_of_type_Blsw.jdField_a_of_type_JavaUtilList.add(0, paramPtvTemplateInfo);
            if (this.jdField_a_of_type_Azfy != null) {
              this.jdField_a_of_type_Azfy.a(paramInt, new Object[] { this.jdField_b_of_type_Blsw });
            }
            if (QLog.isColorLevel()) {
              QLog.d("QIMPtvTemplateManager", 2, "setCurrentTemplateInfoToRecent not isRecentTemplateFull ");
            }
            if (QLog.isColorLevel()) {
              QLog.d("QIMPtvTemplateManager", 2, "setCurrentTemplateInfoToRecent index=" + j);
            }
            return;
          }
          PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_Blsw.jdField_a_of_type_JavaUtilList.remove(99);
          this.jdField_a_of_type_Blsw.jdField_a_of_type_JavaUtilList.add(0, paramPtvTemplateInfo);
          this.jdField_b_of_type_Blsw.jdField_a_of_type_JavaUtilList.remove(localPtvTemplateInfo);
          this.jdField_b_of_type_Blsw.jdField_a_of_type_JavaUtilList.add(0, paramPtvTemplateInfo);
          if (this.jdField_a_of_type_Azfy == null) {
            continue;
          }
          this.jdField_a_of_type_Azfy.a(paramInt, new Object[] { this.jdField_b_of_type_Blsw });
        }
      }
      if (j != 0)
      {
        this.jdField_a_of_type_Blsw.jdField_a_of_type_JavaUtilList.remove(j);
        this.jdField_a_of_type_Blsw.jdField_a_of_type_JavaUtilList.add(0, paramPtvTemplateInfo);
      }
    }
  }
  
  public void a(String paramString)
  {
    this.i = paramString;
  }
  
  public void a(String paramString, int paramInt)
  {
    List localList = a(null, paramString);
    if ((localList == null) || (localList.isEmpty()))
    {
      QLog.d("QIMPtvTemplateManager", 1, "handleGetServerConfig no infos");
      return;
    }
    a(paramString, "ptv_template_new.cfg");
    a().notifyObservers(bltq.class, 3, true, null);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    blra.jdField_b_of_type_JavaLangString = paramString1;
    blra.jdField_b_of_type_Int = paramInt;
    blra.jdField_a_of_type_JavaLangString = paramString2;
    paramString1 = new StringBuilder("QIMPtvTemplateManager setSelectedPtvTemplate id=").append(paramString1).append(" categoryId =").append(paramInt).append(" currentPath=").append(paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("QIMPtvTemplateManager", 2, paramString1.toString());
    }
    a(113, null);
  }
  
  public void a(List<blsw> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    do
    {
      return;
      paramList = paramList.iterator();
    } while (!paramList.hasNext());
    Object localObject = (blsw)paramList.next();
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(((blsw)localObject).jdField_a_of_type_JavaUtilList);
    int j = 0;
    label63:
    if (j < localArrayList.size())
    {
      localObject = (PtvTemplateManager.PtvTemplateInfo)localArrayList.get(j);
      if ((localObject != null) && (((PtvTemplateManager.PtvTemplateInfo)localObject).predownload) && (!TextUtils.isEmpty(((PtvTemplateManager.PtvTemplateInfo)localObject).resurl))) {
        break label116;
      }
    }
    for (;;)
    {
      j += 1;
      break label63;
      break;
      label116:
      ThreadManager.getFileThreadHandler().post(new QIMPtvTemplateManager.4(this, (PtvTemplateManager.PtvTemplateInfo)localObject));
    }
  }
  
  public boolean a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramPtvTemplateInfo == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      try
      {
        if (paramPtvTemplateInfo.kind == 5)
        {
          paramPtvTemplateInfo.dgStageUsable = a(paramPtvTemplateInfo.dgStageName, paramPtvTemplateInfo.dgStageResmd5, false);
          paramPtvTemplateInfo.dgModelUsable = a(paramPtvTemplateInfo.dgModelName, paramPtvTemplateInfo.dgModelResmd5, false);
          boolean bool3 = a(paramPtvTemplateInfo.name, paramPtvTemplateInfo.md5, false);
          if (QLog.isColorLevel()) {
            QLog.d("QIMPtvTemplateManager", 2, String.format("isDGTemplateUsage stage[%s], model[%s], total[%s], id[%s]", new Object[] { Boolean.valueOf(paramPtvTemplateInfo.dgStageUsable), Boolean.valueOf(paramPtvTemplateInfo.dgModelUsable), Boolean.valueOf(bool3), paramPtvTemplateInfo.id }));
          }
          bool1 = bool2;
          if (!paramPtvTemplateInfo.dgStageUsable) {
            continue;
          }
          bool1 = bool2;
          if (!paramPtvTemplateInfo.dgModelUsable) {
            continue;
          }
          bool1 = bool3;
          continue;
        }
        if (paramPtvTemplateInfo.kind == 6)
        {
          paramPtvTemplateInfo.dgStageUsable = a(paramPtvTemplateInfo.dgStageName, paramPtvTemplateInfo.dgStageResmd5, false);
          bool1 = bool2;
          if (!paramPtvTemplateInfo.dgStageUsable) {
            continue;
          }
          bool1 = a(paramPtvTemplateInfo.name, paramPtvTemplateInfo.md5, false);
          continue;
        }
        bool1 = a(paramPtvTemplateInfo.name, paramPtvTemplateInfo.md5, true);
      }
      finally {}
    }
  }
  
  protected blsw b(blsw paramblsw)
  {
    if (paramblsw == null) {
      return null;
    }
    Object localObject = (bknb)blqr.a().c(13);
    paramblsw = paramblsw.a();
    if ((localObject == null) || (!((bknb)localObject).a())) {
      return paramblsw;
    }
    localObject = paramblsw.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject).next();
      if (!localPtvTemplateInfo.multivideosupport)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QIMPtvTemplateManager", 2, "should hide template not support segment, categoryID=" + localPtvTemplateInfo.categoryId + ", templateID = " + localPtvTemplateInfo.id + ", templateName = " + localPtvTemplateInfo.name);
        }
        ((Iterator)localObject).remove();
      }
    }
    return paramblsw;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Blsw = null;
    if (QLog.isColorLevel()) {
      QLog.d("QIMPtvTemplateManager", 2, "QIMPtvTemplateManager onDestroy");
    }
  }
  
  public void b(AppInterface paramAppInterface, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, bnpi parambnpi)
  {
    if ((paramPtvTemplateInfo == null) || (paramAppInterface == null)) {}
    for (;;)
    {
      return;
      paramPtvTemplateInfo.startDownloadTime = System.currentTimeMillis();
      baub localbaub = new baub();
      localbaub.jdField_a_of_type_Baug = new bnpn(this, paramPtvTemplateInfo, parambnpi);
      localbaub.jdField_a_of_type_JavaLangString = paramPtvTemplateInfo.resurl;
      localbaub.jdField_a_of_type_Int = 0;
      if (paramPtvTemplateInfo.name == null)
      {
        QLog.i("QIMPtvTemplateManager", 1, "startDownloadTemplate fail, info.name is null, url:" + paramPtvTemplateInfo.resurl);
        return;
      }
      localbaub.jdField_c_of_type_JavaLangString = new File(jdField_b_of_type_JavaIoFile, paramPtvTemplateInfo.name).getPath();
      localbaub.jdField_c_of_type_Int = bdin.a(bavg.a().a());
      localbaub.jdField_c_of_type_Long = 60000L;
      try
      {
        paramAppInterface.getNetEngine(0).a(localbaub);
        localbaub.jdField_a_of_type_Baug.onUpdateProgeress(localbaub, 1L, 100L);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("QIMPtvTemplateManager", 2, "startDownloadTemplate url: " + paramPtvTemplateInfo.resurl);
        return;
      }
      catch (Exception paramAppInterface)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            paramAppInterface.printStackTrace();
          }
        }
      }
    }
  }
  
  public void c()
  {
    e();
  }
  
  protected void d()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new QIMPtvTemplateManager.3(this), jdField_a_of_type_JavaLangLong.longValue());
  }
  
  public void e()
  {
    File localFile = new File(jdField_b_of_type_JavaIoFile, "ptv_template_new.cfg");
    if (!localFile.exists()) {}
    for (Runnable localRunnable = a(false);; localRunnable = a(localFile))
    {
      localRunnable.run();
      if (QLog.isDevelopLevel()) {
        QLog.d("QIMPtvTemplateManager", 4, new Object[] { "initTemplateConfig, cacheFile exists:", Boolean.valueOf(localFile.exists()), ", runnable:", Integer.valueOf(localRunnable.hashCode()) });
      }
      return;
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Blsw == null) {}
    StringBuilder localStringBuilder;
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.jdField_a_of_type_Blsw.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_Blsw.jdField_a_of_type_JavaUtilList.isEmpty()));
        localStringBuilder = new StringBuilder();
        localObject1 = this.jdField_a_of_type_Blsw.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject1).next();
          if (!TextUtils.isEmpty(((PtvTemplateManager.PtvTemplateInfo)localObject2).id))
          {
            localStringBuilder.append(((PtvTemplateManager.PtvTemplateInfo)localObject2).id).append("|");
            localStringBuilder.append(((PtvTemplateManager.PtvTemplateInfo)localObject2).categoryId).append("$");
          }
        }
      } while (TextUtils.isEmpty(localStringBuilder.toString()));
      Object localObject1 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      Object localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences(this.f, 0);
      ((SharedPreferences)localObject2).edit().putString(this.g + (String)localObject1, localStringBuilder.toString());
      ((SharedPreferences)localObject2).edit().commit();
    } while (!QLog.isColorLevel());
    QLog.d("QIMPtvTemplateManager", 2, "saveRecentTemplate list=" + localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnpl
 * JD-Core Version:    0.7.0.1
 */