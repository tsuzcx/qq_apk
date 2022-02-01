package com.tencent.aelight.camera.aioeditor.richmedia.capture.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.aelight.camera.struct.editor.FilterCategoryItem;
import com.tencent.av.AVLog;
import com.tencent.av.video.effect.lowlight.LowLightTools;
import com.tencent.mobileqq.activity.richmedia.PathUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CaptureVideoFilterManager
{
  public static final String a;
  public static final String b;
  public static Object d;
  public static String h;
  public static String i;
  public static int j = 0;
  private static boolean n;
  private static final String o;
  private static final String p;
  private static int q;
  private static int t = 2;
  private static int u = 1;
  private static int v = -1;
  private static int w = 0;
  public CaptureRedDotConfig c;
  public boolean e = false;
  public FilterCategoryItem f;
  HashMap<String, FilterDesc> g = new HashMap();
  private AtomicInteger k = new AtomicInteger(0);
  private CaptureVideoFilterManager.OnResourceDownloadListener l;
  private Handler m;
  private final CopyOnWriteArrayList<FilterCategory> r = new CopyOnWriteArrayList();
  private final CopyOnWriteArrayList<FilterCategoryItem> s = new CopyOnWriteArrayList();
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(PathUtils.d);
    localStringBuilder.append("pddata/prd/dov_capture_qsvf");
    localStringBuilder.append(File.separator);
    a = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append("capture_res");
    localStringBuilder.append(File.separator);
    b = localStringBuilder.toString();
    n = false;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(PathUtils.d);
    localStringBuilder.append("qav");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("beauty");
    localStringBuilder.append(File.separator);
    o = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(o);
    localStringBuilder.append("SKINCOLOR");
    localStringBuilder.append(File.separator);
    p = localStringBuilder.toString();
    q = 0;
    d = new Object();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append("lowlight");
    h = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(h);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("LowLight.png");
    i = localStringBuilder.toString();
  }
  
  private CaptureVideoFilterManager()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(DeviceInfoUtil.t());
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(DeviceInfoUtil.f());
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceInfo ");
    localStringBuilder.append((String)localObject);
    QLog.i("CaptureVideoFilterManager", 2, localStringBuilder.toString());
    this.m = new Handler(ThreadManager.getSubThreadLooper());
  }
  
  public static final CaptureVideoFilterManager a()
  {
    return CaptureVideoFilterManager.CaptureVideoFilterManagerHolder.a();
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(a);
      ((StringBuilder)localObject).append("filter_config.xml");
      localObject = new File(((StringBuilder)localObject).toString());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getQQShortVideoFilterConfig:");
      localStringBuilder.append(a);
      localStringBuilder.append("filter_config.xml");
      localStringBuilder.append("|");
      localStringBuilder.append(((File)localObject).exists());
      AVLog.printColorLog("CaptureVideoFilterManager", localStringBuilder.toString());
      if (((File)localObject).exists()) {
        return FileUtils.readFileToString((File)localObject);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setQQShortVideoFilterConfigVersion:");
    localStringBuilder.append(paramInt);
    AVLog.printColorLog("CaptureVideoFilterManager", localStringBuilder.toString());
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("capture_qq_video_filter_config_version", paramInt);
    paramContext.commit();
  }
  
  static void a(Context paramContext, String paramString1, String paramString2)
  {
    long l1 = System.currentTimeMillis();
    Iterator localIterator = null;
    if ((paramString1 != null) && (!paramString1.equals("")))
    {
      paramContext = new ArrayList();
      a(paramString1, paramContext);
    }
    else
    {
      paramContext = null;
    }
    if ((paramString2 != null) && (!paramString2.equals("")))
    {
      paramString1 = new ArrayList();
      a(paramString2, paramString1);
    }
    else
    {
      paramString1 = localIterator;
      if (new File(b).exists())
      {
        FileUtils.deleteDirectory(b);
        paramString1 = localIterator;
      }
    }
    if ((paramContext != null) && (paramContext.size() != 0))
    {
      if (paramString1 != null) {
        paramString1 = paramString1.iterator();
      }
    }
    else {
      while (paramString1.hasNext())
      {
        paramString2 = (FilterDesc)paramString1.next();
        localIterator = paramContext.iterator();
        while (localIterator.hasNext())
        {
          FilterDesc localFilterDesc = (FilterDesc)localIterator.next();
          if ((localFilterDesc.name != null) && (localFilterDesc.name.equals(paramString2.name)))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("compareContent res:");
            localStringBuilder.append(localFilterDesc.name);
            localStringBuilder.append("|");
            localStringBuilder.append(localFilterDesc.resMD5);
            localStringBuilder.append("|");
            localStringBuilder.append(paramString2.resMD5);
            AVLog.printColorLog("CaptureVideoFilterManager", localStringBuilder.toString());
            if ((localFilterDesc.resMD5 != null) && (!localFilterDesc.resMD5.equals(paramString2.resMD5))) {
              FileUtils.deleteDirectory(paramString2.getResFold(b));
            }
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("compareContent iconMD5:");
            localStringBuilder.append(localFilterDesc.name);
            localStringBuilder.append("|");
            localStringBuilder.append(localFilterDesc.iconMD5);
            localStringBuilder.append("|");
            localStringBuilder.append(paramString2.iconMD5);
            AVLog.printColorLog("CaptureVideoFilterManager", localStringBuilder.toString());
            if ((localFilterDesc.iconMD5 != null) && (!localFilterDesc.iconMD5.equals(paramString2.iconMD5))) {
              FileUtils.deleteFile(paramString2.getIconFile(b));
            }
          }
        }
        continue;
        AVLog.printColorLog("CaptureVideoFilterManager", "compareContent newList.size=0");
        FileUtils.deleteDirectory(b);
      }
    }
    long l2 = System.currentTimeMillis();
    paramContext = new StringBuilder();
    paramContext.append("compareContent :");
    paramContext.append(l2 - l1);
    AVLog.printColorLog("CaptureVideoFilterManager", paramContext.toString());
  }
  
  static void a(String paramString, List<FilterDesc> paramList)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramList != null))
    {
      paramList.clear();
      try
      {
        paramList.addAll(FilterDesc.parse(new JSONObject(paramString).getJSONArray("filters")));
        return;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    AVLog.printColorLog("CaptureVideoFilterManager", "parseConfig|content is empty.");
  }
  
  public static int b(Context paramContext)
  {
    int i2 = PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("capture_qq_video_filter_config_version", 0);
    int i1 = i2;
    if (i2 > 0)
    {
      paramContext = new StringBuilder();
      paramContext.append(a);
      paramContext.append("filter_config.xml");
      i1 = i2;
      if (!new File(paramContext.toString()).exists())
      {
        AVLog.printColorLog("CaptureVideoFilterManager", "getQQShortVideoFilterConfigVersion config file don't exist!");
        i1 = 0;
      }
    }
    paramContext = new StringBuilder();
    paramContext.append("getQQShortVideoFilterConfigVersion:");
    paramContext.append(i1);
    AVLog.printColorLog("CaptureVideoFilterManager", paramContext.toString());
    return i1;
  }
  
  private void e()
  {
    File localFile = new File(i);
    if (localFile.exists())
    {
      localFile.delete();
    }
    else
    {
      localObject1 = localFile.getParentFile();
      if (!((File)localObject1).exists()) {
        ((File)localObject1).mkdirs();
      }
    }
    Object localObject1 = LowLightTools.getLowLightImage(3.0F, 0.88F, 0.96F, 1.22F, false);
    try
    {
      localObject2 = new FileOutputStream(localFile);
      ((Bitmap)localObject1).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject2);
      ((FileOutputStream)localObject2).flush();
      ((FileOutputStream)localObject2).close();
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("LowLightTools saveBitmap:");
      ((StringBuilder)localObject2).append(localException);
      QLog.w("CaptureVideoFilterManager", 2, ((StringBuilder)localObject2).toString());
    }
    if (!localFile.exists())
    {
      j = v;
      return;
    }
    j = t;
  }
  
  public void a(Context paramContext, String paramString, int paramInt)
  {
    if (paramString == null)
    {
      AVLog.printColorLog("CaptureVideoFilterManager", "updateQQShortVideoFilterConfig error ");
      return;
    }
    a(paramContext, paramString, a(paramContext));
    FileUtils.writeFile(a, "filter_config.xml", paramString);
    a(paramContext, paramInt);
    b();
    a(paramString);
    AVLog.printColorLog("CaptureVideoFilterManager", "updateQQShortVideoFilterConfig sendBroadcast");
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      CaptureRedDotConfig localCaptureRedDotConfig = this.c;
      if ((localCaptureRedDotConfig != null) && (localCaptureRedDotConfig.update))
      {
        localCaptureRedDotConfig = this.c;
        localCaptureRedDotConfig.update = false;
        CaptureRedDotConfig.saveRedDotConfig(localCaptureRedDotConfig, a, "_Filter");
      }
    }
    else
    {
      CaptureRedDotConfig.saveRedDotConfig(this.c, a, "_Filter");
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, String paramString)
  {
    synchronized (d)
    {
      if (this.c == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QIMRedDotConfig_Filter", 2, "needShowRedDot|mCaptureRedDotConfig is null");
        }
        return false;
      }
      boolean bool = this.c.needShowRedDot(paramInt1, paramInt2, paramString);
      if ((bool) && (QLog.isColorLevel()))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ShowRedDot==> type=");
        localStringBuilder.append(paramInt1);
        if (paramInt1 == 2)
        {
          localStringBuilder.append(",categoryId=");
          localStringBuilder.append(paramInt2);
        }
        else if (paramInt1 == 3)
        {
          localStringBuilder.append(",id=");
          localStringBuilder.append(paramString);
        }
        else if (paramInt1 == 4)
        {
          localStringBuilder.append(",defaultId=");
          localStringBuilder.append(this.c.defaultUseId);
        }
        else if (paramInt1 == 5)
        {
          localStringBuilder.append(",defaultCategoryId=");
          localStringBuilder.append(this.c.defaultCategoryId);
        }
        QLog.d("QIMRedDotConfig_Filter", 2, localStringBuilder.toString());
      }
      return bool;
    }
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    int i1;
    label783:
    synchronized (d)
    {
      if (this.c == null)
      {
        this.c = new CaptureRedDotConfig(1);
        if (QLog.isColorLevel()) {
          QLog.d("QIMRedDotConfig_Filter", 2, "updateFromServer config is null");
        }
      }
      try
      {
        Object localObject2 = new JSONObject(paramString);
        paramString = ((JSONObject)localObject2).getJSONArray("categorys");
        i1 = ((JSONObject)localObject2).optInt("iconRedDotVersion");
        boolean bool = ((JSONObject)localObject2).optBoolean("needRedDot");
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("updateFromServer oldVer=");
          ((StringBuilder)localObject3).append(this.c.iconVersion);
          ((StringBuilder)localObject3).append(",ver=");
          ((StringBuilder)localObject3).append(i1);
          ((StringBuilder)localObject3).append(",showRed ");
          ((StringBuilder)localObject3).append(bool);
          QLog.d("QIMRedDotConfig_Filter", 2, ((StringBuilder)localObject3).toString());
        }
        int i2 = ((JSONObject)localObject2).optInt("redDotShowTime", CaptureRedDotConfig.SHOW_TIME_DEFAULT);
        this.c.showTime = i2;
        if (this.c.iconVersion != i1)
        {
          this.c.iconVersion = i1;
          this.c.showRedDot = bool;
          this.c.hasShow = false;
          this.c.firstShowTime = 0L;
        }
        i1 = ((JSONObject)localObject2).optInt("defaultCategoryVersion");
        i2 = ((JSONObject)localObject2).optInt("defaultCategoryId", -1);
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("updateFromServer oldVer=");
          ((StringBuilder)localObject3).append(this.c.defaultCategoryVer);
          ((StringBuilder)localObject3).append(",ver=");
          ((StringBuilder)localObject3).append(i1);
          ((StringBuilder)localObject3).append(",defaultCategoryId ");
          ((StringBuilder)localObject3).append(i2);
          QLog.d("QIMRedDotConfig_Filter", 2, ((StringBuilder)localObject3).toString());
        }
        if (this.c.defaultCategoryVer != i1)
        {
          this.c.defaultCategoryVer = i1;
          this.c.defaultCategoryId = i2;
          this.c.hasChoose = false;
        }
        i1 = ((JSONObject)localObject2).optInt("defaultUseVersion");
        Object localObject3 = ((JSONObject)localObject2).optString("defaultUseId");
        Object localObject4;
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("updateFromServer oldVer=");
          ((StringBuilder)localObject4).append(this.c.defaultUseVer);
          ((StringBuilder)localObject4).append(",ver=");
          ((StringBuilder)localObject4).append(i1);
          ((StringBuilder)localObject4).append(",defaultUseId ");
          ((StringBuilder)localObject4).append((String)localObject3);
          QLog.d("QIMRedDotConfig_Filter", 2, ((StringBuilder)localObject4).toString());
        }
        if (this.c.defaultUseVer != i1)
        {
          this.c.defaultUseVer = i1;
          this.c.defaultUseId = ((String)localObject3);
          this.c.hasUse = false;
        }
        i1 = ((JSONObject)localObject2).optInt("itemRedDotVersion");
        if (this.c.redDotVersion != i1)
        {
          this.c.redDotVersion = i1;
          this.c.redDotItems.clear();
          if (((JSONObject)localObject2).has("itemNeedRedDot"))
          {
            localObject2 = ((JSONObject)localObject2).getJSONArray("itemNeedRedDot");
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("updateFromServer redDotList: ");
            i1 = 0;
            if (i1 < ((JSONArray)localObject2).length())
            {
              localObject4 = ((JSONArray)localObject2).optString(i1);
              if (TextUtils.isEmpty((CharSequence)localObject4)) {
                break label783;
              }
              CaptureRedDotConfig.RedDotItemConfig localRedDotItemConfig = new CaptureRedDotConfig.RedDotItemConfig();
              localRedDotItemConfig.filterId = ((String)localObject4);
              ((StringBuilder)localObject3).append((String)localObject4);
              ((StringBuilder)localObject3).append(",");
              this.c.redDotItems.put(localObject4, localRedDotItemConfig);
              break label783;
            }
            if (QLog.isColorLevel()) {
              QLog.d("QIMRedDotConfig_Filter", 2, ((StringBuilder)localObject3).toString());
            }
          }
        }
        localObject2 = new ArrayList(paramString.length());
        i1 = 0;
        while (i1 < paramString.length())
        {
          ((ArrayList)localObject2).add(new FilterCategory(paramString.getJSONObject(i1), this.c));
          i1 += 1;
        }
        this.e = true;
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
  }
  
  public FilterDesc b(String paramString)
  {
    return (FilterDesc)this.g.get(paramString);
  }
  
  public void b()
  {
    CaptureRedDotConfig localCaptureRedDotConfig = CaptureRedDotConfig.getRedDotConfigFromFile(a, "_Filter");
    if (localCaptureRedDotConfig != null)
    {
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("CaptureVideoFilterManger init UpdateByServer= ");
        ((StringBuilder)???).append(this.e);
        QLog.d("QIMRedDotConfig_Filter", 2, ((StringBuilder)???).toString());
      }
      synchronized (d)
      {
        if (!this.e) {
          this.c = localCaptureRedDotConfig;
        }
        return;
      }
    }
  }
  
  public FilterCategoryItem c()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.richmedia.capture.data.CaptureVideoFilterManager
 * JD-Core Version:    0.7.0.1
 */