import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.opencl.OpenclInfoManager;
import com.tencent.mobileqq.shortvideo.filter.QQBaseFilter;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.device.DeviceInstance;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class bnxr
{
  private static bnxr jdField_a_of_type_Bnxr;
  public float a;
  private int jdField_a_of_type_Int = 1;
  public String a;
  public Map<Integer, Float> a;
  public boolean a;
  private int jdField_b_of_type_Int = 1;
  private String jdField_b_of_type_JavaLangString = "";
  private Map<Integer, akur> jdField_b_of_type_JavaUtilMap = new HashMap();
  public boolean b;
  private Map<Integer, akur> c;
  public boolean c;
  public boolean d;
  
  private bnxr()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Float = 0.5F;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_c_of_type_JavaUtilMap = new HashMap();
    a();
  }
  
  public static bnxr a()
  {
    if (jdField_a_of_type_Bnxr == null) {}
    try
    {
      if (jdField_a_of_type_Bnxr == null) {
        jdField_a_of_type_Bnxr = new bnxr();
      }
      return jdField_a_of_type_Bnxr;
    }
    finally {}
  }
  
  private String a()
  {
    String str2 = BaseApplicationImpl.getApplication().getSharedPreferences("short_video_gpu_config", 0).getString("cfg_content", "");
    String str1;
    if (TextUtils.isEmpty(str2))
    {
      str2 = FileUtils.readStringFromAsset("short_video_device_rule_config.xml");
      str1 = str2;
      if (QLog.isColorLevel())
      {
        QLog.d("DovSVParamManager", 2, "take local config");
        str1 = str2;
      }
    }
    do
    {
      return str1;
      str1 = str2;
    } while (!QLog.isColorLevel());
    QLog.d("DovSVParamManager", 2, "take server config");
    return str2;
  }
  
  private void a(String paramString)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String[] arrayOfString = paramString.split(";");
    for (;;)
    {
      int j;
      int i;
      boolean bool1;
      Object localObject;
      int k;
      int m;
      int n;
      try
      {
        if (this.jdField_a_of_type_JavaLangString.contains("Mali"))
        {
          j = arrayOfString.length;
          i = 0;
          bool1 = bool3;
          if (i < j)
          {
            paramString = arrayOfString[i].split("#");
            bool1 = bool3;
            if (paramString.length == 4)
            {
              localObject = paramString[0] + paramString[1];
              if (!this.jdField_a_of_type_JavaLangString.contains((CharSequence)localObject)) {
                break label383;
              }
              localObject = Pattern.compile("(G|T|\\-)(\\d+)(.+MP(\\d+))?").matcher(this.jdField_a_of_type_JavaLangString);
              bool1 = ((Matcher)localObject).find();
              if (!bool1) {
                break label383;
              }
            }
          }
        }
        bool1 = bool3;
      }
      catch (Exception paramString)
      {
        try
        {
          k = Integer.parseInt(((Matcher)localObject).group(4));
          m = Integer.parseInt(paramString[2]);
          n = Integer.parseInt(paramString[3]);
          if ((k > n) || (k < m)) {
            break label377;
          }
          bool1 = bool2;
          a(bool1);
          return;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
        paramString = paramString;
        paramString.printStackTrace();
        return;
      }
      if (this.jdField_a_of_type_JavaLangString.contains("Adreno"))
      {
        j = arrayOfString.length;
        i = 0;
        for (;;)
        {
          for (;;)
          {
            bool1 = bool3;
            if (i >= j) {
              break;
            }
            localObject = arrayOfString[i].split("#");
            paramString = "0";
            Matcher localMatcher = Pattern.compile("Adreno.*(\\d{3,4})").matcher(this.jdField_a_of_type_JavaLangString);
            if (localMatcher.find()) {
              paramString = localMatcher.group(1);
            }
            if ((localObject.length != 3) || (!paramString.substring(0, 1).equals(localObject[0])))
            {
              k = localObject.length;
              if (k != 2) {}
            }
            else
            {
              try
              {
                k = Integer.parseInt(paramString);
                m = Integer.parseInt(localObject[(localObject.length - 2)]);
                n = Integer.parseInt(localObject[(localObject.length - 1)]);
                bool1 = bool3;
                if (k > n) {
                  break;
                }
                bool1 = bool3;
                if (k < m) {
                  break;
                }
                bool1 = true;
              }
              catch (Exception paramString)
              {
                paramString.printStackTrace();
              }
            }
          }
          i += 1;
        }
        label377:
        bool1 = false;
        continue;
        label383:
        i += 1;
      }
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if ("large".equals(paramString1)) {
      a(paramString2, true);
    }
    do
    {
      return;
      if ("less".equals(paramString1))
      {
        a(paramString2, false);
        return;
      }
      if ("between".equals(paramString1))
      {
        a(paramString2);
        return;
      }
    } while (!"enum".equals(paramString1));
    b(paramString2);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String[] arrayOfString1 = paramString.split(";");
    label409:
    label415:
    for (;;)
    {
      int j;
      int i;
      boolean bool1;
      String[] arrayOfString2;
      int k;
      int m;
      try
      {
        if (!this.jdField_a_of_type_JavaLangString.contains("Mali")) {
          break label232;
        }
        j = arrayOfString1.length;
        i = 0;
        bool1 = bool3;
        if (i < j)
        {
          arrayOfString2 = arrayOfString1[i].split("#");
          if (arrayOfString2.length != 2) {
            break label185;
          }
          paramString = arrayOfString2[0];
          if (!this.jdField_a_of_type_JavaLangString.contains(paramString)) {
            break label415;
          }
          paramString = Pattern.compile("(G|T|\\-)(\\d+)(.+MP(\\d+))?").matcher(this.jdField_a_of_type_JavaLangString);
          k = arrayOfString2.length;
          bool1 = paramString.find();
          if (!bool1) {
            break label415;
          }
        }
        bool1 = bool3;
      }
      catch (Exception paramString)
      {
        try
        {
          k = Integer.parseInt(paramString.group((k - 1) * 2));
          m = Integer.parseInt(arrayOfString2[(arrayOfString2.length - 1)]);
          if (paramBoolean)
          {
            bool1 = bool2;
            if (k >= m) {}
          }
          else
          {
            if ((paramBoolean) || (k > m)) {
              break label409;
            }
            bool1 = bool2;
          }
          a(bool1);
          return;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
        paramString = paramString;
        paramString.printStackTrace();
        return;
      }
      label185:
      if (arrayOfString2.length == 3)
      {
        paramString = arrayOfString2[0] + arrayOfString2[1];
        continue;
        label232:
        bool1 = bool3;
        if (this.jdField_a_of_type_JavaLangString.contains("Adreno"))
        {
          j = arrayOfString1.length;
          i = 0;
          for (;;)
          {
            for (;;)
            {
              bool1 = bool3;
              if (i >= j) {
                break;
              }
              arrayOfString2 = arrayOfString1[i].split("#");
              paramString = "0";
              Matcher localMatcher = Pattern.compile("Adreno.*(\\d{3,4})").matcher(this.jdField_a_of_type_JavaLangString);
              if (localMatcher.find()) {
                paramString = localMatcher.group(1);
              }
              if ((arrayOfString2.length != 2) || (!paramString.substring(0, 1).equals(arrayOfString2[0])))
              {
                k = arrayOfString2.length;
                if (k != 1) {}
              }
              else
              {
                try
                {
                  k = Integer.parseInt(paramString);
                  m = Integer.parseInt(arrayOfString2[(arrayOfString2.length - 1)]);
                  if ((!paramBoolean) || (k < m))
                  {
                    bool1 = bool3;
                    if (paramBoolean) {
                      break;
                    }
                    bool1 = bool3;
                    if (k > m) {
                      break;
                    }
                  }
                  bool1 = true;
                }
                catch (Exception paramString)
                {
                  paramString.printStackTrace();
                }
              }
            }
            i += 1;
          }
          bool1 = false;
          continue;
          i += 1;
        }
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if ("white".equals(this.jdField_b_of_type_JavaLangString)) {
      if (paramBoolean)
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_Boolean = false;
      }
    }
    while (!"black".equals(this.jdField_b_of_type_JavaLangString))
    {
      return;
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    if (!paramBoolean)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void b(String paramString)
  {
    boolean bool2 = false;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = paramString.split(";");
    for (;;)
    {
      int i;
      try
      {
        int j = paramString.length;
        i = 0;
        boolean bool1 = bool2;
        if (i < j)
        {
          CharSequence localCharSequence = paramString[i];
          if (this.jdField_a_of_type_JavaLangString.contains(localCharSequence)) {
            bool1 = true;
          }
        }
        else
        {
          a(bool1);
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      i += 1;
    }
  }
  
  private void c(JSONObject paramJSONObject)
  {
    try
    {
      String[] arrayOfString = paramJSONObject.getString("verdor").split(";");
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if (this.jdField_a_of_type_JavaLangString.contains(str)) {
          d(paramJSONObject.getJSONObject(str));
        }
        i += 1;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private void d(JSONObject paramJSONObject)
  {
    try
    {
      String[] arrayOfString = paramJSONObject.getString("strategy").split(";");
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        JSONObject localJSONObject = paramJSONObject.getJSONObject(str);
        this.jdField_b_of_type_JavaLangString = str;
        e(localJSONObject);
        i += 1;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private void e(JSONObject paramJSONObject)
  {
    try
    {
      String[] arrayOfString = paramJSONObject.getString("rule").split(";");
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        a(str, paramJSONObject.getString(str));
        i += 1;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private void f(JSONObject paramJSONObject)
  {
    try
    {
      this.jdField_a_of_type_Float = Float.valueOf(paramJSONObject.getString("maxWeight")).floatValue();
      paramJSONObject = paramJSONObject.getJSONObject("renderListWeight");
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = paramJSONObject.getString(str1);
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(str1), Float.valueOf(str2));
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private void g(JSONObject paramJSONObject)
  {
    int i = 0;
    try
    {
      String[] arrayOfString1 = paramJSONObject.getString("resolutionList").split(";");
      paramJSONObject = paramJSONObject.getString("cpResolutionList").split(";");
      if (arrayOfString1.length == paramJSONObject.length) {
        while (i < arrayOfString1.length)
        {
          String[] arrayOfString2 = arrayOfString1[i].split("\\*");
          String[] arrayOfString3 = paramJSONObject[i].split("\\*");
          if ((arrayOfString2.length == 2) && (arrayOfString3.length == 2))
          {
            this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(i), new akur(Integer.valueOf(arrayOfString2[0]).intValue(), Integer.valueOf(arrayOfString2[1]).intValue()));
            this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(i), new akur(Integer.valueOf(arrayOfString3[0]).intValue(), Integer.valueOf(arrayOfString3[1]).intValue()));
          }
          i += 1;
        }
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private void h(JSONObject paramJSONObject)
  {
    try
    {
      String str1 = Build.MANUFACTURER + ";" + Build.MODEL;
      paramJSONObject = paramJSONObject.getJSONArray("blackList");
      int i = 0;
      for (;;)
      {
        if (i < paramJSONObject.length())
        {
          String str2 = paramJSONObject.getString(i);
          if (!str2.trim().equals(str1.trim())) {
            break label107;
          }
          this.d = true;
          if (QLog.isColorLevel()) {
            QLog.d("DovSVParamManager", 2, "parseJSONBlackList true =" + str2);
          }
        }
        return;
        label107:
        i += 1;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private void i(JSONObject paramJSONObject)
  {
    try
    {
      String str1 = DeviceInstance.getInstance().getDeviceName();
      paramJSONObject = paramJSONObject.getJSONArray("qijianList");
      int i = 0;
      for (;;)
      {
        if (i < paramJSONObject.length())
        {
          String str2 = paramJSONObject.getString(i);
          if (!str2.trim().equals(str1.trim())) {
            break label86;
          }
          this.jdField_c_of_type_Boolean = true;
          if (QLog.isColorLevel()) {
            QLog.d("DovSVParamManager", 2, "parseJSONQijianList true =" + str2);
          }
        }
        return;
        label86:
        i += 1;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private void j(JSONObject paramJSONObject)
  {
    try
    {
      this.jdField_a_of_type_Int = paramJSONObject.optInt("faceDetectSwitch", 1);
      if (QLog.isColorLevel()) {
        QLog.d("DovSVParamManager", 2, "parseJSONFaceDetectSwitch mFaceDetectType:" + this.jdField_a_of_type_Int);
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public float a(int paramInt)
  {
    return 1.0F;
  }
  
  public float a(List<QQBaseFilter> paramList)
  {
    paramList = paramList.iterator();
    float f = 0.0F;
    if (paramList.hasNext())
    {
      QQBaseFilter localQQBaseFilter = (QQBaseFilter)paramList.next();
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(localQQBaseFilter.getFilterType()))) {
        break label77;
      }
      f = ((Float)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(localQQBaseFilter.getFilterType()))).floatValue() + f;
    }
    label77:
    for (;;)
    {
      break;
      return f;
    }
  }
  
  public int a(int paramInt)
  {
    return 4000;
  }
  
  public int a(Context paramContext)
  {
    return paramContext.getSharedPreferences("short_video_gpu_config", 0).getInt("cfg_version", 0);
  }
  
  public akur a(int paramInt)
  {
    if (this.d) {}
    for (akur localakur = (akur)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(1));; localakur = (akur)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(0)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DovSVParamManager", 2, "getCameraResolution inBlackPhone = " + this.d + " dpcSize=" + localakur);
      }
      return localakur;
    }
  }
  
  public akur a(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    return new akur(localDisplayMetrics.heightPixels, localDisplayMetrics.widthPixels);
  }
  
  public babz a(Context paramContext)
  {
    babz localbabz = new babz();
    int i = babb.a();
    akur localakur1 = a(i);
    akur localakur2 = b(i);
    paramContext = a(paramContext);
    if (localakur1 != null)
    {
      localbabz.a(localakur1.a());
      localbabz.b(localakur1.b());
    }
    if (localakur2 != null)
    {
      localbabz.c(localakur2.a());
      localbabz.d(localakur2.b());
    }
    if (paramContext != null)
    {
      localbabz.e(paramContext.a());
      localbabz.f(paramContext.b());
    }
    localbabz.a(a(i));
    int j = a(i) * 1000;
    localbabz.h(j);
    com.tencent.mobileqq.shortvideo.mediadevice.CodecParam.mMaxrate = j;
    localbabz.i(1);
    localbabz.g(i);
    if ((bbwy.f()) && (Build.VERSION.SDK_INT < 27)) {
      localbabz.k(0);
    }
    return localbabz;
  }
  
  public blno a(Context paramContext, int paramInt)
  {
    paramContext = new blno();
    akur localakur1 = a(paramInt);
    akur localakur2 = b(paramInt);
    if (localakur1 != null)
    {
      paramContext.a(localakur1.a());
      paramContext.b(localakur1.b());
    }
    if (localakur2 != null)
    {
      paramContext.c(localakur2.a());
      paramContext.d(localakur2.b());
    }
    paramContext.a(a(paramInt));
    int i = a(paramInt) * 1000;
    paramContext.e(i);
    com.tencent.mobileqq.shortvideo.mediadevice.CodecParam.mMaxrate = i;
    paramContext.f(1);
    paramContext.g(paramInt);
    if ((bbwy.f()) && (Build.VERSION.SDK_INT < 27)) {
      paramContext.h(0);
    }
    return paramContext;
  }
  
  public blno a(blit paramblit)
  {
    blno localblno = new blno();
    localblno.a(paramblit.a().a());
    localblno.b(paramblit.a().b());
    localblno.a(paramblit.a().floatValue());
    localblno.e(paramblit.a().intValue());
    com.tencent.mobileqq.shortvideo.mediadevice.CodecParam.mMaxrate = paramblit.a().intValue();
    localblno.f(1);
    localblno.g(paramblit.g());
    return localblno;
  }
  
  public void a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(a());
      g(localJSONObject);
      f(localJSONObject);
      a(localJSONObject);
      h(localJSONObject);
      i(localJSONObject);
      j(localJSONObject);
      b(localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("DovSVParamManager", 2, "parse sv config error, stacktrace :  " + QLog.getStackTraceString(localException));
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    boolean bool = true;
    if ((Build.MODEL.contains("Pixel")) || (Build.MODEL.contains("Nexus")) || (Build.VERSION.SDK_INT >= 24) || (Build.VERSION.SDK_INT < 21)) {
      if (!a(4, 1200000L, 2573741824L, 17))
      {
        bool = true;
        this.jdField_a_of_type_Boolean = bool;
      }
    }
    do
    {
      c(paramJSONObject);
      return;
      bool = false;
      break;
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_JavaLangString = new OpenclInfoManager().a();
        QLog.d("DovSVParamManager", 1, "GPUInfo:" + this.jdField_a_of_type_JavaLangString);
      }
    } while (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString));
    if (!a(4, 1200000L, 2573741824L, 17)) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      break;
      bool = false;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    int i = DeviceInfoUtil.getOsVersion();
    if (i < paramInt2)
    {
      lba.f("DovSVParamManager", "isSupportOfDevice error OSversion: " + i);
      return false;
    }
    paramInt2 = lld.e();
    if (paramInt2 < paramInt1)
    {
      lba.f("DovSVParamManager", "isSupportOfDevice error cpucount: " + paramInt2);
      return false;
    }
    long l = lld.d();
    if (l < paramLong1)
    {
      lba.f("DovSVParamManager", "isSupportOfDevice error cpuFrequency: " + l);
      return false;
    }
    paramLong1 = DeviceInfoUtil.getSystemTotalMemory();
    if (paramLong1 < paramLong2)
    {
      lba.f("DovSVParamManager", "isSupportOfDevice error memory: " + paramLong1);
      return false;
    }
    return true;
  }
  
  public boolean a(String paramString, int paramInt, Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DovSVParamManager", 2, "saveGPUConfig :  " + paramString);
    }
    paramContext = paramContext.getSharedPreferences("short_video_gpu_config", 0).edit();
    paramContext.putString("cfg_content", paramString);
    paramContext.putInt("cfg_version", paramInt);
    return paramContext.commit();
  }
  
  public akur b(int paramInt)
  {
    if (this.d) {}
    for (akur localakur = (akur)this.jdField_c_of_type_JavaUtilMap.get(Integer.valueOf(1));; localakur = (akur)this.jdField_c_of_type_JavaUtilMap.get(Integer.valueOf(0)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DovSVParamManager", 2, "getDpcCompressResolution inBlackPhone = " + this.d + " dpcCompressSize=" + localakur);
      }
      return localakur;
    }
  }
  
  public babz b(Context paramContext)
  {
    paramContext = new babz();
    int i = babb.a();
    akur localakur = babl.a().a(i);
    paramContext.a(localakur.a());
    paramContext.b(localakur.b());
    paramContext.a(babl.a().a(i));
    int j = babl.a().a(i) * 1000;
    paramContext.h(j);
    com.tencent.mobileqq.shortvideo.mediadevice.CodecParam.mMaxrate = j;
    paramContext.i(1);
    paramContext.g(i);
    return paramContext;
  }
  
  public void b(JSONObject paramJSONObject)
  {
    try
    {
      this.jdField_b_of_type_Int = paramJSONObject.optInt("samSungCameraSwitch", 1);
      if (QLog.isColorLevel()) {
        QLog.d("DovSVParamManager", 2, "parseJsonSamSungSwitch parseJsonSamSungSwitch:" + this.jdField_b_of_type_Int);
      }
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  public boolean d()
  {
    return this.jdField_b_of_type_Int == 1;
  }
  
  public boolean e()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnxr
 * JD-Core Version:    0.7.0.1
 */