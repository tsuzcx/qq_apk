import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.video.effect.lowlight.LowLightTools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.CaptureRedDotConfig;
import com.tencent.mobileqq.richmedia.capture.data.CaptureRedDotConfig.RedDotItemConfig;
import com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager.1;
import com.tencent.mobileqq.richmedia.capture.data.FilterCategory;
import com.tencent.mobileqq.richmedia.capture.data.FilterCategoryItem;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class avsd
{
  public static int a;
  public static Object a;
  public static final String a;
  private static int jdField_b_of_type_Int;
  public static final String b;
  private static boolean jdField_b_of_type_Boolean;
  private static int c;
  public static final String c;
  private static int d;
  public static String d;
  public static String e;
  private static final String f;
  private static final String g;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private avsf jdField_a_of_type_Avsf;
  private avsj jdField_a_of_type_Avsj;
  public CaptureRedDotConfig a;
  public FilterCategoryItem a;
  HashMap<String, FilterDesc> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final CopyOnWriteArrayList<FilterCategory> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  public boolean a;
  private final CopyOnWriteArrayList<FilterCategoryItem> jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  
  static
  {
    jdField_a_of_type_JavaLangString = ahwa.jdField_a_of_type_JavaLangString + "/capture_qsvf" + File.separator;
    jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString + "capture_res" + File.separator;
    f = ahwa.jdField_a_of_type_JavaLangString + "/qav" + File.separator + "beauty" + File.separator;
    g = f + "SKINCOLOR" + File.separator;
    jdField_c_of_type_JavaLangString = f;
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_d_of_type_JavaLangString = jdField_a_of_type_JavaLangString + "lowlight";
    e = jdField_d_of_type_JavaLangString + File.separator + "LowLight.png";
    jdField_b_of_type_Int = 2;
    jdField_c_of_type_Int = 1;
    jdField_d_of_type_Int = -1;
  }
  
  private avsd()
  {
    GraphicRenderMgr.loadSo();
    String str = bbct.h() + " " + bbct.d();
    QLog.i("CaptureVideoFilterManager", 2, "DeviceInfo " + str);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  }
  
  public static int a(Context paramContext)
  {
    int i = 0;
    int j = BaseApplicationImpl.getApplication().getSharedPreferences("capture_qq_video_filter_config", 4).getInt("capture_qq_video_filter_config_version", 0);
    if ((j > 0) && (!new File(jdField_a_of_type_JavaLangString + "filter_config.xml").exists())) {
      lcl.c("CaptureVideoFilterManager", "getQQShortVideoFilterConfigVersion config file don't exist!");
    }
    for (;;)
    {
      lcl.c("CaptureVideoFilterManager", "getQQShortVideoFilterConfigVersion:" + i);
      return i;
      i = j;
    }
  }
  
  public static final avsd a()
  {
    return avse.a();
  }
  
  private static avsk a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      lcl.c("CaptureVideoFilterManager", "parseConfig|content is empty.");
      return null;
    }
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(paramString).getJSONObject("skinColorFilter");
      }
      catch (JSONException localJSONException3)
      {
        JSONObject localJSONObject;
        int i;
        String str1;
        String str2;
        localavsk = null;
        continue;
      }
      try
      {
        i = Integer.valueOf(localJSONObject.getString("filterid")).intValue();
        str1 = localJSONObject.getString("resurl");
        str2 = localJSONObject.getString("md5");
        localavsk = new avsk(i, str1, str2);
        try
        {
          lcl.c("CaptureVideoFilterManager", "parseConfig:" + i + "|" + str1 + "|" + str2);
          return localavsk;
        }
        catch (JSONException localJSONException1) {}
      }
      catch (JSONException localJSONException4)
      {
        localavsk = null;
        continue;
      }
      try
      {
        localJSONException1.printStackTrace();
        lcl.c("CaptureVideoFilterManager", "parseConfig failed. info = " + localJSONObject);
        return localavsk;
      }
      catch (JSONException localJSONException2)
      {
        localJSONException2.printStackTrace();
        lcl.c("CaptureVideoFilterManager", "parseConfig|parse failed.context = " + paramString);
        return localavsk;
      }
    }
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      File localFile = new File(jdField_a_of_type_JavaLangString + "filter_config.xml");
      lcl.c("CaptureVideoFilterManager", "getQQShortVideoFilterConfig:" + jdField_a_of_type_JavaLangString + "filter_config.xml" + "|" + localFile.exists());
      if (localFile.exists()) {
        return bbdj.b(localFile);
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
  
  public static void a(Context paramContext)
  {
    try
    {
      if (b(paramContext))
      {
        c(paramContext);
        if (new File(g).exists()) {
          bbdj.a(g);
        }
      }
      paramContext = a(b(paramContext));
      if ((paramContext != null) && (!TextUtils.isEmpty(paramContext.jdField_a_of_type_JavaLangString)))
      {
        Object localObject = new File(g + "params.json");
        lcl.c("CaptureVideoFilterManager", "preDownloadResource :" + ((File)localObject).exists());
        if (!((File)localObject).exists())
        {
          localObject = new ayrv();
          ((ayrv)localObject).jdField_a_of_type_Aysa = new avsh();
          ((ayrv)localObject).jdField_a_of_type_JavaLangString = paramContext.jdField_a_of_type_JavaLangString;
          ((ayrv)localObject).jdField_a_of_type_Int = 0;
          ((ayrv)localObject).jdField_c_of_type_JavaLangString = (f + "skin_color.zip");
          ((ayrv)localObject).a(paramContext);
          lcm.a().a((aysw)localObject);
        }
      }
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    lcl.c("CaptureVideoFilterManager", "setQQShortVideoFilterConfigVersion:" + paramInt);
    paramContext = BaseApplicationImpl.getApplication().getSharedPreferences("capture_qq_video_filter_config", 4).edit();
    paramContext.putInt("capture_qq_video_filter_config_version", paramInt);
    paramContext.commit();
  }
  
  static void a(Context paramContext, String paramString1, String paramString2)
  {
    Iterator localIterator = null;
    long l1 = System.currentTimeMillis();
    if ((paramString1 != null) && (!paramString1.equals("")))
    {
      paramContext = new ArrayList();
      a(paramString1, paramContext);
    }
    for (;;)
    {
      if ((paramString2 != null) && (!paramString2.equals("")))
      {
        paramString1 = new ArrayList();
        a(paramString2, paramString1);
        if ((paramContext != null) && (paramContext.size() != 0)) {
          break label151;
        }
        lcl.c("CaptureVideoFilterManager", "compareContent newList.size=0");
        bbdj.a(jdField_b_of_type_JavaLangString);
      }
      for (;;)
      {
        long l2 = System.currentTimeMillis();
        lcl.c("CaptureVideoFilterManager", "compareContent :" + (l2 - l1));
        return;
        paramString1 = localIterator;
        if (!new File(jdField_b_of_type_JavaLangString).exists()) {
          break;
        }
        bbdj.a(jdField_b_of_type_JavaLangString);
        paramString1 = localIterator;
        break;
        label151:
        if (paramString1 != null)
        {
          paramString1 = paramString1.iterator();
          while (paramString1.hasNext())
          {
            paramString2 = (FilterDesc)paramString1.next();
            localIterator = paramContext.iterator();
            while (localIterator.hasNext())
            {
              FilterDesc localFilterDesc = (FilterDesc)localIterator.next();
              if ((localFilterDesc.name != null) && (localFilterDesc.name.equals(paramString2.name)))
              {
                lcl.c("CaptureVideoFilterManager", "compareContent res:" + localFilterDesc.name + "|" + localFilterDesc.resMD5 + "|" + paramString2.resMD5);
                if ((localFilterDesc.resMD5 != null) && (!localFilterDesc.resMD5.equals(paramString2.resMD5))) {
                  bbdj.a(paramString2.getResFold(jdField_b_of_type_JavaLangString));
                }
                lcl.c("CaptureVideoFilterManager", "compareContent iconMD5:" + localFilterDesc.name + "|" + localFilterDesc.iconMD5 + "|" + paramString2.iconMD5);
                if ((localFilterDesc.iconMD5 != null) && (!localFilterDesc.iconMD5.equals(paramString2.iconMD5))) {
                  bbdj.d(paramString2.getIconFile(jdField_b_of_type_JavaLangString));
                }
              }
            }
          }
        }
      }
      paramContext = null;
    }
  }
  
  static void a(String paramString, List<FilterDesc> paramList)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramList == null))
    {
      lcl.c("CaptureVideoFilterManager", "parseConfig|content is empty.");
      return;
    }
    paramList.clear();
    try
    {
      paramList.addAll(FilterDesc.parse(new JSONObject(paramString).getJSONArray("filters")));
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private boolean a()
  {
    String str = bbdj.d("filter_template.cfg");
    boolean bool = b(str);
    if (QLog.isColorLevel()) {
      QLog.i("CaptureVideoFilterManager", 2, "initFromAsset" + str + " result:" + bool);
    }
    return bool;
  }
  
  public static boolean a(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    int i = bbct.a();
    if (i < paramInt2)
    {
      lcl.c("CaptureVideoFilterManager", "isSupportOfDevice error OSversion: " + i);
      return false;
    }
    paramInt2 = lmb.e();
    if (paramInt2 < paramInt1)
    {
      lcl.c("CaptureVideoFilterManager", "isSupportOfDevice error cpucount: " + paramInt2);
      return false;
    }
    long l = lmb.c();
    if (l < paramLong1)
    {
      lcl.c("CaptureVideoFilterManager", "isSupportOfDevice error cpuFrequency: " + l);
      return false;
    }
    paramLong1 = bbct.d();
    if (paramLong1 < paramLong2)
    {
      lcl.c("CaptureVideoFilterManager", "isSupportOfDevice error memory: " + paramLong1);
      return false;
    }
    return true;
  }
  
  public static boolean a(Context paramContext)
  {
    if (jdField_b_of_type_Boolean) {
      return true;
    }
    if (!a(4, 1350000L, 1073741824L, 17))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CaptureVideoFilterManager", 2, "filter device note support");
      }
      return false;
    }
    jdField_b_of_type_Boolean = true;
    return jdField_b_of_type_Boolean;
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      File localFile = new File(f + "beauty_config.json");
      lcl.c("CaptureVideoFilterManager", "getVideoEffectBeautyConfig:" + f + "beauty_config.json" + "|" + localFile.exists());
      if (localFile.exists()) {
        return bbdj.b(localFile);
      }
      b(paramContext, 0);
      return null;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static void b(Context paramContext, int paramInt)
  {
    lcl.c("CaptureVideoFilterManager", "setVideoEffectBeautyConfigVersion:" + paramInt);
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("qav_effect_beauty_config_version", paramInt);
    paramContext.commit();
  }
  
  private static boolean b(Context paramContext)
  {
    boolean bool = false;
    int i = PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("qq_video_filter_config_first_launch", 0);
    lcl.c("CaptureVideoFilterManager", "getIsFirstLauncher:" + i);
    if (i == 0) {
      bool = true;
    }
    return bool;
  }
  
  private boolean b(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    for (;;)
    {
      int i;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        Object localObject3;
        try
        {
          paramString = new JSONObject(paramString);
          localObject2 = FilterDesc.parse(paramString.getJSONArray("filters")).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (FilterDesc)((Iterator)localObject2).next();
            this.jdField_a_of_type_JavaUtilHashMap.put(((FilterDesc)localObject3).name, localObject3);
            continue;
          }
          paramString = paramString.getJSONArray("categorys");
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
          return false;
        }
        Object localObject2 = new ArrayList(paramString.length());
        i = 0;
        if (i < paramString.length())
        {
          localObject3 = new FilterCategory(paramString.getJSONObject(i), null);
          if ((((FilterCategory)localObject3).a.size() <= 0) || ((((FilterCategory)localObject3).a.size() == 1) && (((FilterCategoryItem)((FilterCategory)localObject3).a.get(0)).a()))) {
            break label335;
          }
          ((ArrayList)localObject2).add(new FilterCategory(paramString.getJSONObject(i), null));
          break label335;
        }
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.addAll((Collection)localObject2);
        this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
        paramString = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        if (paramString.hasNext())
        {
          localObject2 = ((FilterCategory)paramString.next()).a.iterator();
          if (!((Iterator)localObject2).hasNext()) {
            continue;
          }
          localObject3 = (FilterCategoryItem)((Iterator)localObject2).next();
          if (((FilterCategoryItem)localObject3).jdField_a_of_type_Boolean) {
            continue;
          }
          localObject3 = ((FilterCategoryItem)localObject3).a();
          this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localObject3);
        }
      }
      if (this.jdField_a_of_type_Avsf != null) {
        this.jdField_a_of_type_Avsf.a();
      }
      return true;
      label335:
      i += 1;
    }
  }
  
  private static void c(Context paramContext)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("qq_video_filter_config_first_launch", 1);
    paramContext.commit();
  }
  
  private boolean c(Context paramContext)
  {
    paramContext = a(paramContext);
    boolean bool = b(paramContext);
    if (QLog.isColorLevel()) {
      QLog.i("CaptureVideoFilterManager", 2, "initFromCache" + paramContext + " result:" + bool);
    }
    return bool;
  }
  
  private void d()
  {
    File localFile = new File(e);
    if (localFile.exists()) {
      localFile.delete();
    }
    for (;;)
    {
      Object localObject = LowLightTools.getLowLightImage(3.0F, 0.88F, 0.96F, 1.22F, false);
      try
      {
        FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
        ((Bitmap)localObject).compress(Bitmap.CompressFormat.PNG, 100, localFileOutputStream);
        localFileOutputStream.flush();
        localFileOutputStream.close();
        if (!localFile.exists())
        {
          jdField_a_of_type_Int = jdField_d_of_type_Int;
          return;
          localObject = localFile.getParentFile();
          if (((File)localObject).exists()) {
            continue;
          }
          ((File)localObject).mkdirs();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.w("CaptureVideoFilterManager", 2, "LowLightTools saveBitmap:" + localException);
        }
        jdField_a_of_type_Int = jdField_b_of_type_Int;
      }
    }
  }
  
  public int a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig != null) && (!this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.hasChoose))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QIMRedDotConfig_PTV", 2, "getDefaultCategoryId=" + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultCategoryId);
        }
        int i = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultCategoryId;
        return i;
      }
      return -1;
    }
  }
  
  public FilterCategoryItem a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterCategoryItem;
  }
  
  public FilterDesc a(String paramString)
  {
    return (FilterDesc)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public List<FilterCategory> a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Avsf = null;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    for (;;)
    {
      StringBuilder localStringBuilder;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig == null) {
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.updateRedDotInfo(paramInt1, paramInt2, paramString))
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("updateRedDotInfo==> type=");
            localStringBuilder.append(paramInt1);
            if (paramInt1 == 2)
            {
              localStringBuilder.append(",categoryId=").append(paramInt2);
              QLog.d("QIMRedDotConfig_Filter", 2, localStringBuilder.toString());
            }
          }
          else
          {
            this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(null);
            this.jdField_a_of_type_AndroidOsHandler.post(new CaptureVideoFilterManager.1(this));
          }
        }
        else {
          return;
        }
      }
      if (paramInt1 == 3) {
        localStringBuilder.append(",id=").append(paramString);
      } else if (paramInt1 == 4) {
        localStringBuilder.append(",defaultId=").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultUseId);
      } else if (paramInt1 == 5) {
        localStringBuilder.append(",defaultCategoryId=").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultCategoryId);
      }
    }
  }
  
  public void a(Context paramContext, String paramString, int paramInt)
  {
    if (paramString == null)
    {
      lcl.c("CaptureVideoFilterManager", "updateQQShortVideoFilterConfig error ");
      return;
    }
    int i = a(paramContext);
    String str = "";
    if (i != 0) {
      str = a(paramContext);
    }
    a(paramContext, paramString, str);
    bbdj.a(jdField_a_of_type_JavaLangString, "filter_config.xml", paramString);
    a(paramContext, paramInt);
    c();
    a(paramString);
    lcl.c("CaptureVideoFilterManager", "updateQQShortVideoFilterConfig sendBroadcast");
    paramContext.sendBroadcast(new Intent("action_brocassreceiver_for_filter"));
  }
  
  public void a(avsf paramavsf)
  {
    this.jdField_a_of_type_Avsf = paramavsf;
  }
  
  public void a(avsj paramavsj)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)) {
      lcl.c("CaptureVideoFilterManager", "preDownloadResource list is empty!");
    }
    do
    {
      return;
      this.jdField_a_of_type_Avsj = paramavsj;
      lcl.c("CaptureVideoFilterManager", "preDownloadResource list size: " + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      paramavsj = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (paramavsj.hasNext())
      {
        Object localObject1 = (FilterCategory)paramavsj.next();
        if (((FilterCategory)localObject1).a != null)
        {
          localObject1 = ((FilterCategory)localObject1).a.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            FilterDesc localFilterDesc = ((FilterCategoryItem)((Iterator)localObject1).next()).a();
            if (localFilterDesc != null)
            {
              lcl.c("CaptureVideoFilterManager", "preDownloadResource predownload: " + localFilterDesc.predownload + ", iconurl: " + localFilterDesc.iconurl + ", resurl:" + localFilterDesc.resurl);
              if (localFilterDesc.predownload == 1)
              {
                Object localObject3;
                if (!TextUtils.isEmpty(localFilterDesc.iconurl))
                {
                  localObject2 = localFilterDesc.getIconFile(jdField_b_of_type_JavaLangString);
                  localObject3 = new File((String)localObject2);
                  lcl.c("CaptureVideoFilterManager", "preDownloadResource icon " + (String)localObject2 + " exist: " + ((File)localObject3).exists());
                  if (!((File)localObject3).exists())
                  {
                    localObject3 = new ayrv();
                    ((ayrv)localObject3).jdField_a_of_type_Aysa = new avsi(this);
                    ((ayrv)localObject3).jdField_a_of_type_JavaLangString = localFilterDesc.iconurl;
                    ((ayrv)localObject3).jdField_a_of_type_Int = 0;
                    ((ayrv)localObject3).jdField_c_of_type_JavaLangString = ((String)localObject2);
                    ((ayrv)localObject3).a(localFilterDesc);
                    lcm.a().a((aysw)localObject3);
                    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
                  }
                }
                Object localObject2 = localFilterDesc.getResFold(jdField_b_of_type_JavaLangString);
                if ((!TextUtils.isEmpty(localFilterDesc.resurl)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
                {
                  localObject3 = new File((String)localObject2 + "params.json");
                  lcl.c("CaptureVideoFilterManager", "preDownloadResource file " + (String)localObject2 + "params.json" + " exist: " + ((File)localObject3).exists());
                  if (!((File)localObject3).exists())
                  {
                    localObject2 = new ayrv();
                    ((ayrv)localObject2).jdField_a_of_type_Aysa = new avsg(this);
                    ((ayrv)localObject2).jdField_a_of_type_JavaLangString = localFilterDesc.resurl;
                    ((ayrv)localObject2).jdField_a_of_type_Int = 0;
                    ((ayrv)localObject2).jdField_c_of_type_JavaLangString = (jdField_b_of_type_JavaLangString + localFilterDesc.name + ".zip");
                    ((ayrv)localObject2).a(localFilterDesc);
                    lcm.a().a((aysw)localObject2);
                    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
                  }
                }
              }
            }
          }
        }
      }
    } while ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0) || (this.jdField_a_of_type_Avsj == null));
    this.jdField_a_of_type_Avsj.a(false);
  }
  
  public void a(FilterCategoryItem paramFilterCategoryItem)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterCategoryItem = paramFilterCategoryItem;
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterCategoryItem != null) && (!this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterCategoryItem.a())) {
      a(3, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterCategoryItem.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterCategoryItem.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.update))
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.update = false;
        CaptureRedDotConfig.saveRedDotConfig(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig, jdField_a_of_type_JavaLangString, "_Filter");
      }
      return;
    }
    CaptureRedDotConfig.saveRedDotConfig(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig, jdField_a_of_type_JavaLangString, "_Filter");
  }
  
  public boolean a(int paramInt1, int paramInt2, String paramString)
  {
    for (;;)
    {
      StringBuilder localStringBuilder;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig_Filter", 2, "needShowRedDot|mCaptureRedDotConfig is null");
          }
          return false;
        }
        boolean bool = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.needShowRedDot(paramInt1, paramInt2, paramString);
        if ((bool) && (QLog.isColorLevel()))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("ShowRedDot==> type=");
          localStringBuilder.append(paramInt1);
          if (paramInt1 == 2)
          {
            localStringBuilder.append(",categoryId=").append(paramInt2);
            QLog.d("QIMRedDotConfig_Filter", 2, localStringBuilder.toString());
          }
        }
        else
        {
          return bool;
        }
      }
      if (paramInt1 == 3) {
        localStringBuilder.append(",id=").append(paramString);
      } else if (paramInt1 == 4) {
        localStringBuilder.append(",defaultId=").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultUseId);
      } else if (paramInt1 == 5) {
        localStringBuilder.append(",defaultCategoryId=").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultCategoryId);
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    for (;;)
    {
      int i;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig = new CaptureRedDotConfig(1);
          if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig_Filter", 2, "updateFromServer config is null");
          }
        }
        try
        {
          Object localObject2 = new JSONObject(paramString);
          paramString = ((JSONObject)localObject2).getJSONArray("categorys");
          i = ((JSONObject)localObject2).optInt("iconRedDotVersion");
          boolean bool = ((JSONObject)localObject2).optBoolean("needRedDot");
          if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig_Filter", 2, "updateFromServer oldVer=" + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.iconVersion + ",ver=" + i + ",showRed " + bool);
          }
          int j = ((JSONObject)localObject2).optInt("redDotShowTime", CaptureRedDotConfig.SHOW_TIME_DEFAULT);
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.showTime = j;
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.iconVersion != i)
          {
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.iconVersion = i;
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.showRedDot = bool;
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.hasShow = false;
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.firstShowTime = 0L;
          }
          i = ((JSONObject)localObject2).optInt("defaultCategoryVersion");
          j = ((JSONObject)localObject2).optInt("defaultCategoryId", -1);
          if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig_Filter", 2, "updateFromServer oldVer=" + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultCategoryVer + ",ver=" + i + ",defaultCategoryId " + j);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultCategoryVer != i)
          {
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultCategoryVer = i;
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultCategoryId = j;
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.hasChoose = false;
          }
          i = ((JSONObject)localObject2).optInt("defaultUseVersion");
          Object localObject3 = ((JSONObject)localObject2).optString("defaultUseId");
          if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig_Filter", 2, "updateFromServer oldVer=" + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultUseVer + ",ver=" + i + ",defaultUseId " + (String)localObject3);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultUseVer != i)
          {
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultUseVer = i;
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultUseId = ((String)localObject3);
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.hasUse = false;
          }
          i = ((JSONObject)localObject2).optInt("itemRedDotVersion");
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.redDotVersion != i)
          {
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.redDotVersion = i;
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.redDotItems.clear();
            if (((JSONObject)localObject2).has("itemNeedRedDot"))
            {
              localObject2 = ((JSONObject)localObject2).getJSONArray("itemNeedRedDot");
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("updateFromServer redDotList: ");
              i = 0;
              if (i < ((JSONArray)localObject2).length())
              {
                String str = ((JSONArray)localObject2).optString(i);
                if (TextUtils.isEmpty(str)) {
                  break label708;
                }
                CaptureRedDotConfig.RedDotItemConfig localRedDotItemConfig = new CaptureRedDotConfig.RedDotItemConfig();
                localRedDotItemConfig.filterId = str;
                ((StringBuilder)localObject3).append(str).append(",");
                this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.redDotItems.put(str, localRedDotItemConfig);
                break label708;
              }
              if (QLog.isColorLevel()) {
                QLog.d("QIMRedDotConfig_Filter", 2, ((StringBuilder)localObject3).toString());
              }
            }
          }
          localObject2 = new ArrayList(paramString.length());
          i = 0;
          if (i < paramString.length())
          {
            ((ArrayList)localObject2).add(new FilterCategory(paramString.getJSONObject(i), this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig));
            i += 1;
            continue;
          }
          this.jdField_a_of_type_Boolean = true;
          a(false);
          return true;
        }
        catch (JSONException paramString)
        {
          if (QLog.isColorLevel()) {
            QLog.e("QIMRedDotConfig", 2, QLog.getStackTraceString(paramString));
          }
          return false;
        }
      }
      label708:
      i += 1;
    }
  }
  
  public List<FilterCategoryItem> b()
  {
    return this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      com.tencent.av.video.effect.QavVideoEffect.DEBUG_MODE = true;
    }
    c();
    if (!c(BaseApplicationImpl.sApplication)) {
      a();
    }
    lcl.c("CaptureVideoFilterManager", "init mFilterCategoryRaw size:" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
  }
  
  public void b(Context paramContext)
  {
    if (new File(f + "beauty_config.json").exists())
    {
      if (!new File(g + "params.json").exists())
      {
        lcl.c("CaptureVideoFilterManager", "!JasonFile.exists()");
        a(paramContext);
      }
      return;
    }
    lcl.c("CaptureVideoFilterManager", "BEAUTY_CONFIG  is not exsit");
  }
  
  public void c()
  {
    CaptureRedDotConfig localCaptureRedDotConfig = CaptureRedDotConfig.getRedDotConfigFromFile(jdField_a_of_type_JavaLangString, "_Filter");
    if (localCaptureRedDotConfig != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMRedDotConfig_Filter", 2, "CaptureVideoFilterManger init UpdateByServer= " + this.jdField_a_of_type_Boolean);
      }
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (!this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig = localCaptureRedDotConfig;
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avsd
 * JD-Core Version:    0.7.0.1
 */