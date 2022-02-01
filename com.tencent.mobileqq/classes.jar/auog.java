import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hydevteam.common.progress.ProgressFuture;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.hydevteam.pluginframework.installedplugin.PluginRunningPath;
import com.tencent.hydevteam.pluginframework.pluginmanager.MultiTargetDownloadInfo;
import com.tencent.hydevteam.pluginframework.pluginmanager.TargetDownloadInfo;
import com.tencent.hydevteam.pluginframework.pluginmanager.UpgradeablePluginManager;
import com.tencent.hydevteam.pluginframework.pluginmanager.VersionCheckException;
import com.tencent.hydevteam.pluginframework.pluginmanager.VersionChecker;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.mobileqq.intervideo.huayang.HuayangPluginNewDownloader.2;
import com.tencent.mobileqq.intervideo.huayang.HuayangPluginNewDownloader.3;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class auog
{
  private static HashMap<String, auog> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final Context jdField_a_of_type_AndroidContentContext;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new auoh(this);
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private auoi jdField_a_of_type_Auoi;
  private final UpgradeablePluginManager jdField_a_of_type_ComTencentHydevteamPluginframeworkPluginmanagerUpgradeablePluginManager;
  private IVPluginDataReporter jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter;
  private Runnable jdField_a_of_type_JavaLangRunnable = new HuayangPluginNewDownloader.3(this);
  public String a;
  private volatile List<ProgressFuture<InstalledPlugin>> jdField_a_of_type_JavaUtilList;
  private Map<String, IVPluginInfo> jdField_a_of_type_JavaUtilMap;
  private final boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private volatile boolean jdField_b_of_type_Boolean;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  private volatile boolean jdField_c_of_type_Boolean;
  private String d;
  private String e;
  
  private auog(Context paramContext, File paramFile, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_Boolean = aunj.a();
    this.jdField_a_of_type_ComTencentHydevteamPluginframeworkPluginmanagerUpgradeablePluginManager = new UpgradeablePluginManager(paramFile, paramString, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter = new IVPluginDataReporter();
    this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opDepartment(paramString);
  }
  
  public static auog a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      String str = paramString2 + paramString1;
      auog localauog = (auog)jdField_a_of_type_JavaUtilHashMap.get(str);
      paramString1 = localauog;
      if (localauog == null)
      {
        paramString1 = new auog(paramContext.getApplicationContext(), a(paramContext), paramString2);
        jdField_a_of_type_JavaUtilHashMap.put(str, paramString1);
      }
      return paramString1;
    }
    finally {}
  }
  
  private InstalledPlugin a(ProgressFuture<InstalledPlugin> paramProgressFuture)
  {
    if (!this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 4, paramProgressFuture));
    }
    if ((!this.jdField_b_of_type_Boolean) && (auoj.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 1, 30, 0), 2000L);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 1, 70, 0), 6000L);
    }
    try
    {
      paramProgressFuture = (InstalledPlugin)paramProgressFuture.get();
      if (!this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
      }
      return paramProgressFuture;
    }
    catch (Exception paramProgressFuture)
    {
      if (!this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
      }
      throw paramProgressFuture;
    }
  }
  
  private InstalledPlugin a(InstalledPlugin paramInstalledPlugin)
  {
    a("HuayangPluginNewDownloader", "getPluginFromServer: 开始从服务器中获取DownloadedPluginInfo开始...");
    long l = System.currentTimeMillis();
    int i = this.jdField_a_of_type_ComTencentHydevteamPluginframeworkPluginmanagerUpgradeablePluginManager.upgradeIfNeededThenInit(10L, TimeUnit.SECONDS);
    l = System.currentTimeMillis() - l;
    a("HuayangPluginNewDownloader", "upgradeIfNeededThenInit status:" + i + " time:" + l);
    VersionChecker localVersionChecker;
    Object localObject2;
    StringBuilder localStringBuilder;
    label145:
    String str;
    Object localObject1;
    if (i != -1)
    {
      a("downloadPluginManagerFinish", i, (int)l, "", "");
      if (i == 1) {
        auoj.a("2653797");
      }
    }
    else
    {
      localVersionChecker = this.jdField_a_of_type_ComTencentHydevteamPluginframeworkPluginmanagerUpgradeablePluginManager.getVersionChecker();
      localObject2 = null;
      String[] arrayOfString = new String[2];
      arrayOfString[0] = "SOURCE_CGI";
      arrayOfString[1] = "SOURCE_BACKUP_STABLE";
      localStringBuilder = new StringBuilder();
      int k = arrayOfString.length;
      i = 0;
      if (i >= k) {
        break label1145;
      }
      str = arrayOfString[i];
      localObject1 = localObject2;
    }
    for (;;)
    {
      Object localObject3;
      try
      {
        TargetDownloadInfo localTargetDownloadInfo = localVersionChecker.checkForceUpdate(str, this.jdField_a_of_type_JavaLangString, this.d, this.jdField_a_of_type_Boolean, paramInstalledPlugin);
        localObject1 = localObject2;
        if (str.equals("SOURCE_CGI"))
        {
          localObject1 = localObject2;
          auoj.a("2653754");
          localObject1 = localObject2;
          a("HuayangPluginNewDownloader", amtj.a(2131704765) + localTargetDownloadInfo.url);
          localObject1 = localObject2;
          this.jdField_b_of_type_Long = localTargetDownloadInfo.size;
          localObject1 = localObject2;
          if ((localTargetDownloadInfo.forceUpdate) && (paramInstalledPlugin != null))
          {
            localObject1 = localObject2;
            b(paramInstalledPlugin);
          }
          localObject1 = localObject2;
          if (!(localTargetDownloadInfo instanceof MultiTargetDownloadInfo)) {
            continue;
          }
          localObject1 = localObject2;
          localObject4 = ((MultiTargetDownloadInfo)localTargetDownloadInfo).allSubTargets;
          if (localObject4 == null) {
            continue;
          }
          localObject1 = localObject2;
          localObject4 = ((Map)localObject4).entrySet().iterator();
          localObject1 = localObject2;
          if (!((Iterator)localObject4).hasNext()) {
            continue;
          }
          localObject1 = localObject2;
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject4).next();
          localObject1 = localObject2;
          if (!TextUtils.equals((CharSequence)localEntry.getKey(), this.jdField_b_of_type_JavaLangString)) {
            continue;
          }
          localObject1 = localObject2;
          this.jdField_b_of_type_Long = ((TargetDownloadInfo)localEntry.getValue()).size;
          continue;
        }
      }
      catch (Exception localException1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("HuayangPluginNewDownloader", 2, "从" + str + "获取插件失败。", localException1);
        }
        auns.a(localException1);
        localStringBuilder.append(localException1.toString());
        localStringBuilder.append("。");
        if ((str.equals("SOURCE_CGI")) && (this.jdField_b_of_type_Boolean))
        {
          paramInstalledPlugin = (InstalledPlugin)localObject1;
          localObject1 = new StringBuilder().append("getPluginFromServer: 开始从服务器中获取InstalledPlugin结束：result == null ? ");
          if (paramInstalledPlugin != null) {
            break label1139;
          }
          bool = true;
          a("HuayangPluginNewDownloader", bool);
          auoj.a("2653760");
          if (this.jdField_b_of_type_Boolean) {
            auoj.a("2528856");
          }
          throw new VersionCheckException("从服务器获取InstalledPlugin失败。" + localStringBuilder.toString());
          auoj.a("2653798");
          break;
          localObject1 = localException1;
          if (!str.equals("SOURCE_BACKUP_STABLE")) {
            continue;
          }
          localObject1 = localException1;
          auoj.a("2653758");
          continue;
        }
      }
      catch (VersionCheckException localVersionCheckException)
      {
        localObject1 = localException1;
        if (str.equals("SOURCE_CGI"))
        {
          localObject1 = localException1;
          auoj.a("2653755");
          localObject1 = localException1;
          throw localVersionCheckException;
        }
        localObject1 = localException1;
        if (!str.equals("SOURCE_BACKUP_STABLE")) {
          continue;
        }
        localObject1 = localException1;
        auoj.a("2653759");
        continue;
        localObject1 = localException1;
        Object localObject4 = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 0, Long.valueOf(this.jdField_b_of_type_Long));
        localObject1 = localException1;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject4);
        localObject1 = localException1;
        if ("checkVersion".equals(this.jdField_c_of_type_JavaLangString)) {
          return null;
        }
        localObject1 = localException1;
        if (!this.jdField_b_of_type_Boolean)
        {
          localObject1 = localException1;
          a(10);
        }
        localObject1 = localException1;
        a("HuayangPluginNewDownloader", "updatePlugin start");
        localObject1 = localException1;
        l = System.currentTimeMillis();
        localObject1 = localException1;
        this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentHydevteamPluginframeworkPluginmanagerUpgradeablePluginManager.updatePlugin(this.d, localVersionCheckException, this.jdField_b_of_type_JavaLangString);
        try
        {
          localInstalledPlugin = a((ProgressFuture)this.jdField_a_of_type_JavaUtilList.get(0));
          localObject3 = localInstalledPlugin;
          int m = (int)(System.currentTimeMillis() - l);
          if (localInstalledPlugin != null) {
            continue;
          }
          j = -1;
          localObject3 = localInstalledPlugin;
          a("updatePlugin", j, m, "", "");
          localObject3 = localInstalledPlugin;
          a("HuayangPluginNewDownloader", amtj.a(2131704779) + m);
          localObject3 = localInstalledPlugin;
          if (!str.equals("SOURCE_CGI")) {
            continue;
          }
          localObject3 = localInstalledPlugin;
          auoj.a("2653761");
          localObject1 = localInstalledPlugin;
          localObject3 = new StringBuilder().append("getPluginFromServer: 开始从服务器中获取InstalledPlugin结束：result == null ? ");
          if (localInstalledPlugin != null) {
            continue;
          }
          bool = true;
        }
        catch (Exception localException2)
        {
          InstalledPlugin localInstalledPlugin;
          int j;
          localObject1 = localObject3;
          if (!str.equals("SOURCE_CGI")) {
            continue;
          }
          localObject1 = localObject3;
          auoj.a("2653762");
          localObject1 = localObject3;
          throw localException2;
          localObject1 = localObject3;
          if (!str.equals("SOURCE_BACKUP_STABLE")) {
            continue;
          }
          localObject1 = localObject3;
          auoj.a("2653766");
          continue;
          bool = false;
          continue;
        }
        localObject1 = localInstalledPlugin;
        a("HuayangPluginNewDownloader", bool);
        return localInstalledPlugin;
        localObject3 = localInstalledPlugin;
        j = localInstalledPlugin.pluginFileType;
        continue;
        localObject3 = localInstalledPlugin;
        if (!str.equals("SOURCE_BACKUP_STABLE")) {
          continue;
        }
        localObject3 = localInstalledPlugin;
        auoj.a("2653765");
        continue;
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          localObject3 = this.jdField_a_of_type_JavaUtilList.iterator();
          if (((Iterator)localObject3).hasNext())
          {
            ((ProgressFuture)((Iterator)localObject3).next()).cancel(true);
            continue;
          }
          this.jdField_a_of_type_JavaUtilList = null;
        }
        i += 1;
        localObject3 = localObject1;
      }
      break label145;
      label1139:
      boolean bool = false;
      continue;
      label1145:
      paramInstalledPlugin = (InstalledPlugin)localObject3;
    }
  }
  
  public static File a(Context paramContext)
  {
    return paramContext.getFilesDir();
  }
  
  private void a(int paramInt)
  {
    Message localMessage = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 1, paramInt, 0);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void a(int paramInt, Object paramObject)
  {
    paramObject = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, paramInt, paramObject);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramObject);
  }
  
  private void a(InstalledPlugin paramInstalledPlugin)
  {
    String str2 = null;
    long l = System.currentTimeMillis();
    boolean bool = TextUtils.equals(this.d, "group_video");
    try
    {
      this.jdField_a_of_type_ComTencentHydevteamPluginframeworkPluginmanagerUpgradeablePluginManager.preloadApk(this.jdField_a_of_type_AndroidContentContext, paramInstalledPlugin, bool).get();
      a("HuayangPluginNewDownloader", amtj.a(2131704761));
      str1 = str2;
      if (!this.jdField_b_of_type_Boolean)
      {
        b(paramInstalledPlugin, true);
        str1 = str2;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1;
        int i;
        if (QLog.isColorLevel()) {
          QLog.e("HuayangPluginNewDownloader", 2, "预加载过程中出错：", localException);
        }
        if (!this.jdField_b_of_type_Boolean) {
          a(6, localException.toString());
        }
        auns.a(localException);
        continue;
        paramInstalledPlugin = "";
      }
    }
    i = (int)(System.currentTimeMillis() - l);
    str2 = paramInstalledPlugin.toString();
    if (str1 != null)
    {
      paramInstalledPlugin = str1.getMessage();
      a("preLoadFinish", 0, i, str2, paramInstalledPlugin);
      return;
    }
  }
  
  private void a(InstalledPlugin paramInstalledPlugin, Exception paramException, int paramInt)
  {
    if (paramInstalledPlugin != null)
    {
      a("preDownloadFinish", 1, paramInt, paramInstalledPlugin.toString(), null);
      return;
    }
    if (paramException != null) {}
    for (paramInstalledPlugin = paramException.getMessage();; paramInstalledPlugin = "")
    {
      a("preDownloadFinish", 0, paramInt, paramInstalledPlugin, null);
      return;
    }
  }
  
  private void a(InstalledPlugin paramInstalledPlugin, boolean paramBoolean)
  {
    Object localObject = new StringBuilder().append(amtj.a(2131704767));
    boolean bool;
    if (paramInstalledPlugin == null)
    {
      bool = true;
      a("HuayangPluginNewDownloader", bool);
      a(this.jdField_b_of_type_Boolean);
      a(2, paramInstalledPlugin);
      if (!paramBoolean) {
        break label85;
      }
    }
    label85:
    for (localObject = "fromCache";; localObject = "fromServer")
    {
      a(true, paramInstalledPlugin, (String)localObject, null);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
      return;
      bool = false;
      break;
    }
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    IVPluginDataReporter localIVPluginDataReporter = this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opType(paramString1);
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      paramString1 = "null";
      paramString2 = localIVPluginDataReporter.opName(paramString1).opIn(paramInt1).opResult(paramInt2).d1(paramString2).d2(paramString3);
      if (!this.jdField_b_of_type_Boolean) {
        break label86;
      }
    }
    label86:
    for (paramString1 = "1";; paramString1 = "0")
    {
      paramString2.d3(paramString1).d4(this.jdField_b_of_type_JavaLangString).report();
      return;
      paramString1 = this.jdField_c_of_type_JavaLangString;
      break;
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    Intent localIntent = new Intent(aunx.c(this.jdField_b_of_type_JavaLangString));
    int i;
    if (paramBoolean)
    {
      i = 1;
      localIntent.putExtra("key_isCache", i);
      this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
      if (!paramBoolean)
      {
        if (!aunx.a(this.jdField_b_of_type_JavaLangString)) {
          break label64;
        }
        auoj.a("2714209");
      }
    }
    label64:
    while (!aunx.b(this.jdField_b_of_type_JavaLangString))
    {
      return;
      i = 0;
      break;
    }
    auoj.a("2714208");
  }
  
  private void a(boolean paramBoolean, InstalledPlugin paramInstalledPlugin, String paramString1, String paramString2)
  {
    int j = (int)(System.currentTimeMillis() - this.jdField_a_of_type_Long);
    int i;
    if (paramBoolean)
    {
      i = 1;
      if (paramInstalledPlugin != null) {
        break label45;
      }
    }
    label45:
    for (paramInstalledPlugin = null;; paramInstalledPlugin = paramInstalledPlugin.pluginFile.toString())
    {
      a("downloadFinish", i, j, paramInstalledPlugin, paramString2);
      return;
      i = 0;
      break;
    }
  }
  
  private void b(InstalledPlugin paramInstalledPlugin)
  {
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_Auoi != null) {
      this.jdField_a_of_type_Auoi.a(10, new Object[0]);
    }
    a("doForceUpdate", 0, 0, paramInstalledPlugin.pluginPackageName, paramInstalledPlugin.pluginVersionForConfigPluginLoader);
    Intent localIntent = new Intent("action_iv_plugin_update");
    localIntent.putExtra("plugin", paramInstalledPlugin);
    BaseApplicationImpl.sApplication.sendBroadcast(localIntent);
    a("HuayangPluginNewDownloader", amtj.a(2131704781));
  }
  
  private void b(InstalledPlugin paramInstalledPlugin, boolean paramBoolean)
  {
    a("HuayangPluginNewDownloader", amtj.a(2131704769) + paramInstalledPlugin);
    paramInstalledPlugin = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 5, paramInstalledPlugin);
    if (paramBoolean) {}
    for (int i = 1;; i = -1)
    {
      paramInstalledPlugin.arg1 = i;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramInstalledPlugin);
      return;
    }
  }
  
  private void c()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentHydevteamPluginframeworkPluginmanagerUpgradeablePluginManager.getCachedLatestPlugin(this.d);
    Object localObject4;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject3 = new ArrayList();
      localObject4 = ((List)localObject1).iterator();
      while (((Iterator)localObject4).hasNext()) {
        ((List)localObject3).add(((InstalledPlugin)((Iterator)localObject4).next()).pluginVersionForPluginLoaderManage);
      }
      Collections.sort((List)localObject3);
      localObject3 = localObject3.toString();
      if ((this.e != null) && (!TextUtils.equals((CharSequence)localObject3, this.e)))
      {
        a("HuayangPluginNewDownloader", amtj.a(2131704776) + (String)localObject3 + " mPluginVersion:" + this.e);
        auoc.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getPackageName() + ":troophomework");
      }
      this.e = ((String)localObject3);
    }
    long l;
    if ((localObject1 != null) && (((List)localObject1).size() == 1) && (((InstalledPlugin)((List)localObject1).get(0)).pluginFileType == 0))
    {
      localObject3 = (InstalledPlugin)((List)localObject1).get(0);
      this.jdField_b_of_type_Boolean = true;
      a((InstalledPlugin)localObject3, true);
      b((InstalledPlugin)localObject3, true);
      l = 0L;
      if (this.jdField_b_of_type_Boolean) {
        l = System.currentTimeMillis();
      }
      if ((TextUtils.equals(this.jdField_c_of_type_JavaLangString, "slientDownload")) || (!this.jdField_b_of_type_Boolean)) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(7);
      }
      localObject1 = (IVPluginInfo)this.jdField_a_of_type_JavaUtilMap.get(this.jdField_b_of_type_JavaLangString);
      if (localObject1 == null) {
        break label553;
      }
      localObject1 = ((IVPluginInfo)localObject1).j;
      if (localObject1 == null) {
        break label553;
      }
    }
    boolean bool;
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        if (!((JSONObject)localObject1).has("preloadOnly")) {
          break label553;
        }
        bool = ((JSONObject)localObject1).getBoolean("preloadOnly");
        if ((!"huiyin".equals(this.d)) || (NetworkUtil.isWifiEnabled(this.jdField_a_of_type_AndroidContentContext)) || (!bool)) {
          break label559;
        }
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        localObject4 = ((List)localObject1).iterator();
        localObject1 = null;
        localObject3 = localObject1;
        if (!((Iterator)localObject4).hasNext()) {
          break;
        }
        localObject3 = (InstalledPlugin)((Iterator)localObject4).next();
        if (((InstalledPlugin)localObject3).pluginPackageName.equals(this.jdField_b_of_type_JavaLangString))
        {
          this.jdField_b_of_type_Boolean = true;
          a((InstalledPlugin)localObject3, true);
          b((InstalledPlugin)localObject3, true);
          localObject1 = localObject3;
          continue;
        }
        b((InstalledPlugin)localObject3, false);
        continue;
      }
      if (auok.jdField_a_of_type_JavaUtilMap.get(this.d) != null) {
        auoj.b(String.valueOf(((auok)auok.jdField_a_of_type_JavaUtilMap.get(this.d)).g));
      }
      localObject3 = null;
      break;
      label553:
      bool = false;
    }
    try
    {
      label559:
      localObject3 = a((InstalledPlugin)localObject3);
      Object localObject2 = null;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("HuayangPluginNewDownloader", 2, localException1, new Object[0]);
        }
        auns.a(localException1);
        localObject3 = null;
      }
    }
    if ("checkVersion".equals(this.jdField_c_of_type_JavaLangString))
    {
      this.jdField_c_of_type_Boolean = false;
      return;
    }
    if (!this.jdField_b_of_type_Boolean) {
      if (localException1 == null)
      {
        a(100);
        a((InstalledPlugin)localObject3, false);
        label645:
        if ((localObject3 == null) || (PluginRunningPath.isPreOdexFileExists(this.jdField_a_of_type_AndroidContentContext, ((InstalledPlugin)localObject3).pluginPackageName, ((InstalledPlugin)localObject3).pluginVersionForPluginLoaderManage, ((InstalledPlugin)localObject3).pluginFile.getName()))) {
          break label911;
        }
        a("HuayangPluginNewDownloader", amtj.a(2131704775));
        a((InstalledPlugin)localObject3);
      }
    }
    for (;;)
    {
      localObject4 = this.jdField_a_of_type_JavaUtilList;
      this.jdField_a_of_type_JavaUtilList = null;
      this.jdField_c_of_type_Boolean = false;
      if (localObject4 == null) {
        break;
      }
      int i = 1;
      while (i < ((List)localObject4).size())
      {
        try
        {
          localObject3 = (InstalledPlugin)((ProgressFuture)((List)localObject4).get(i)).get();
          if (localObject3 == null) {}
        }
        catch (Exception localException2)
        {
          label911:
          localObject3 = null;
        }
        try
        {
          if (!PluginRunningPath.isPreOdexFileExists(this.jdField_a_of_type_AndroidContentContext, ((InstalledPlugin)localObject3).pluginPackageName, ((InstalledPlugin)localObject3).pluginVersionForPluginLoaderManage, ((InstalledPlugin)localObject3).pluginFile.getName()))
          {
            bool = TextUtils.equals(this.d, "group_video");
            this.jdField_a_of_type_ComTencentHydevteamPluginframeworkPluginmanagerUpgradeablePluginManager.preloadApk(this.jdField_a_of_type_AndroidContentContext, (InstalledPlugin)localObject3, bool).get();
          }
          if ((localObject3 != null) && (!this.jdField_b_of_type_Boolean) && ((IVPluginInfo)this.jdField_a_of_type_JavaUtilMap.get(((InstalledPlugin)localObject3).pluginPackageName) != null))
          {
            auoj.a("2633399");
            b((InstalledPlugin)localObject3, false);
          }
          i += 1;
        }
        catch (Exception localException3)
        {
          break label938;
        }
      }
      a(3, localException1.toString());
      a(false, null, null, localException1.toString());
      break label645;
      a((InstalledPlugin)localObject3, localException1, (int)(System.currentTimeMillis() - l));
      break label645;
      if ((localObject3 != null) && (!this.jdField_b_of_type_Boolean)) {
        b((InstalledPlugin)localObject3, true);
      }
    }
    label938:
    auoj.a("2633400");
    if (localObject3 == null) {}
    for (Object localObject3 = null;; localObject3 = ((InstalledPlugin)localObject3).toString())
    {
      a("loadSecondPlugin", 0, 0, (String)localObject3, localException2.toString());
      break;
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      auoj.a("2597859");
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((ProgressFuture)localIterator.next()).cancel(true);
      }
    }
  }
  
  public void a(auoi paramauoi)
  {
    this.jdField_a_of_type_Auoi = paramauoi;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, Map<String, IVPluginInfo> paramMap)
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_JavaUtilMap = paramMap;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.d = paramString1;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 40000L);
    a("startDownload", 0, 0, "", "");
    ThreadManager.postDownLoadTask(new HuayangPluginNewDownloader.2(this), 8, null, false);
  }
  
  public void b()
  {
    a("cancelLauncher", 0, (int)(System.currentTimeMillis() - this.jdField_a_of_type_Long), "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auog
 * JD-Core Version:    0.7.0.1
 */