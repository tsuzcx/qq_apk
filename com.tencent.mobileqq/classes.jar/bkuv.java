import android.content.Context;
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
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.capture.data.CaptureRedDotConfig;
import dov.com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager.1;
import dov.com.tencent.mobileqq.richmedia.capture.data.FilterCategory;
import dov.com.tencent.mobileqq.richmedia.capture.data.FilterCategoryItem;
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

public class bkuv
{
  public static int a;
  public static Object a;
  public static final String a;
  private static int jdField_b_of_type_Int;
  public static final String b;
  private static int c;
  public static String c;
  private static int d;
  public static String d;
  private static final String e;
  private static final String f;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bkux jdField_a_of_type_Bkux;
  private bkva jdField_a_of_type_Bkva;
  public CaptureRedDotConfig a;
  public FilterCategoryItem a;
  HashMap<String, FilterDesc> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final CopyOnWriteArrayList<FilterCategory> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  public boolean a;
  private final CopyOnWriteArrayList<FilterCategoryItem> jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  
  static
  {
    jdField_a_of_type_JavaLangString = ahvy.jdField_d_of_type_JavaLangString + "pddata/prd/dov_capture_qsvf" + File.separator;
    jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString + "capture_res" + File.separator;
    e = ahvy.jdField_d_of_type_JavaLangString + "qav" + File.separator + "beauty" + File.separator;
    f = e + "SKINCOLOR" + File.separator;
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_c_of_type_JavaLangString = jdField_a_of_type_JavaLangString + "lowlight";
    jdField_d_of_type_JavaLangString = jdField_c_of_type_JavaLangString + File.separator + "LowLight.png";
    jdField_b_of_type_Int = 2;
    jdField_c_of_type_Int = 1;
    jdField_d_of_type_Int = -1;
  }
  
  private bkuv()
  {
    GraphicRenderMgr.loadSo();
    String str = bbdh.h() + " " + bbdh.d();
    QLog.i("CaptureVideoFilterManager", 2, "DeviceInfo " + str);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  }
  
  public static final bkuv a()
  {
    return bkuw.a();
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      File localFile = new File(jdField_a_of_type_JavaLangString + "filter_config.xml");
      lcg.c("CaptureVideoFilterManager", "getQQShortVideoFilterConfig:" + jdField_a_of_type_JavaLangString + "filter_config.xml" + "|" + localFile.exists());
      if (localFile.exists()) {
        return bbdx.b(localFile);
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
  
  public static void a(Context paramContext, int paramInt)
  {
    lcg.c("CaptureVideoFilterManager", "setQQShortVideoFilterConfigVersion:" + paramInt);
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("capture_qq_video_filter_config_version", paramInt);
    paramContext.commit();
  }
  
  private boolean a()
  {
    String str = bbdx.d("filter_template.cfg");
    boolean bool = a(str);
    if (QLog.isColorLevel()) {
      QLog.i("CaptureVideoFilterManager", 2, "initFromAsset" + str + " result:" + bool);
    }
    return bool;
  }
  
  private boolean a(Context paramContext)
  {
    paramContext = a(paramContext);
    boolean bool = a(paramContext);
    if (QLog.isColorLevel()) {
      QLog.i("CaptureVideoFilterManager", 2, "initFromCache" + paramContext + " result:" + bool);
    }
    return bool;
  }
  
  private boolean a(String paramString)
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
            break label334;
          }
          ((ArrayList)localObject2).add(new FilterCategory(paramString.getJSONObject(i), null));
          break label334;
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
      if (this.jdField_a_of_type_Bkux != null) {
        this.jdField_a_of_type_Bkux.a();
      }
      return true;
      label334:
      i += 1;
    }
  }
  
  private void e()
  {
    File localFile = new File(jdField_d_of_type_JavaLangString);
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
  
  public FilterDesc a(String paramString)
  {
    return (FilterDesc)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public FilterCategoryItem a()
  {
    return this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataFilterCategoryItem;
  }
  
  public List<FilterCategoryItem> a()
  {
    return this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bkux = null;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    for (;;)
    {
      StringBuilder localStringBuilder;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig == null) {
          return;
        }
        if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.updateRedDotInfo(paramInt1, paramInt2, paramString))
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
        localStringBuilder.append(",defaultId=").append(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultUseId);
      } else if (paramInt1 == 5) {
        localStringBuilder.append(",defaultCategoryId=").append(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultCategoryId);
      }
    }
  }
  
  public void a(bkux parambkux)
  {
    this.jdField_a_of_type_Bkux = parambkux;
  }
  
  public void a(bkva parambkva)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)) {
      lcg.c("CaptureVideoFilterManager", "preDownloadResource list is empty!");
    }
    do
    {
      return;
      this.jdField_a_of_type_Bkva = parambkva;
      lcg.c("CaptureVideoFilterManager", "preDownloadResource list size: " + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      parambkva = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (parambkva.hasNext())
      {
        Object localObject1 = (FilterCategory)parambkva.next();
        if (((FilterCategory)localObject1).a != null)
        {
          localObject1 = ((FilterCategory)localObject1).a.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            FilterDesc localFilterDesc = ((FilterCategoryItem)((Iterator)localObject1).next()).a();
            if (localFilterDesc != null)
            {
              lcg.c("CaptureVideoFilterManager", "preDownloadResource predownload: " + localFilterDesc.predownload + ", iconurl: " + localFilterDesc.iconurl + ", resurl:" + localFilterDesc.resurl);
              if (localFilterDesc.predownload == 1)
              {
                Object localObject3;
                if (!TextUtils.isEmpty(localFilterDesc.iconurl))
                {
                  localObject2 = localFilterDesc.getIconFile(jdField_b_of_type_JavaLangString);
                  localObject3 = new File((String)localObject2);
                  lcg.c("CaptureVideoFilterManager", "preDownloadResource icon " + (String)localObject2 + " exist: " + ((File)localObject3).exists());
                  if (!((File)localObject3).exists())
                  {
                    localObject3 = new ayrx();
                    ((ayrx)localObject3).jdField_a_of_type_Aysc = new bkuz(this);
                    ((ayrx)localObject3).jdField_a_of_type_JavaLangString = localFilterDesc.iconurl;
                    ((ayrx)localObject3).jdField_a_of_type_Int = 0;
                    ((ayrx)localObject3).jdField_c_of_type_JavaLangString = ((String)localObject2);
                    ((ayrx)localObject3).a(localFilterDesc);
                    lch.a().a((aysy)localObject3);
                    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
                  }
                }
                Object localObject2 = localFilterDesc.getResFold(jdField_b_of_type_JavaLangString);
                if ((!TextUtils.isEmpty(localFilterDesc.resurl)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
                {
                  localObject3 = new File((String)localObject2 + "params.json");
                  lcg.c("CaptureVideoFilterManager", "preDownloadResource file " + (String)localObject2 + "params.json" + " exist: " + ((File)localObject3).exists());
                  if (!((File)localObject3).exists())
                  {
                    localObject2 = new ayrx();
                    ((ayrx)localObject2).jdField_a_of_type_Aysc = new bkuy(this);
                    ((ayrx)localObject2).jdField_a_of_type_JavaLangString = localFilterDesc.resurl;
                    ((ayrx)localObject2).jdField_a_of_type_Int = 0;
                    ((ayrx)localObject2).jdField_c_of_type_JavaLangString = (jdField_b_of_type_JavaLangString + localFilterDesc.name + ".zip");
                    ((ayrx)localObject2).a(localFilterDesc);
                    lch.a().a((aysy)localObject2);
                    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
                  }
                }
              }
            }
          }
        }
      }
    } while ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0) || (this.jdField_a_of_type_Bkva == null));
    this.jdField_a_of_type_Bkva.a(false);
  }
  
  public void a(FilterCategoryItem paramFilterCategoryItem)
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataFilterCategoryItem = paramFilterCategoryItem;
    if ((this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataFilterCategoryItem != null) && (!this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataFilterCategoryItem.a())) {
      a(3, this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataFilterCategoryItem.jdField_b_of_type_Int, this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataFilterCategoryItem.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataFilterCategoryItem != null)
    {
      paramFilterCategoryItem = this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataFilterCategoryItem.a();
      if (paramFilterCategoryItem != null)
      {
        QQFilterRenderManager localQQFilterRenderManager = EffectsCameraCaptureView.b();
        if (localQQFilterRenderManager != null) {
          localQQFilterRenderManager.getBusinessOperation().setFilterEffect(paramFilterCategoryItem);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig != null) && (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.update))
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.update = false;
        CaptureRedDotConfig.saveRedDotConfig(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig, jdField_a_of_type_JavaLangString, "_Filter");
      }
      return;
    }
    CaptureRedDotConfig.saveRedDotConfig(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig, jdField_a_of_type_JavaLangString, "_Filter");
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      com.tencent.av.video.effect.QavVideoEffect.DEBUG_MODE = true;
    }
    c();
    if (!a(BaseApplicationImpl.sApplication)) {
      a();
    }
    lcg.c("CaptureVideoFilterManager", "init mFilterCategoryRaw size:" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
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
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig = localCaptureRedDotConfig;
        }
        return;
      }
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_Bkva = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkuv
 * JD-Core Version:    0.7.0.1
 */