package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.biz.common.util.OfflineSecurity;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext;
import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext.Callback;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TaskManager
{
  private static String JSSCRIPT_CHECK_DIR;
  private static String JSSCRIPT_DISTRIBUTION_DIR;
  private static String JSSCRIPT_EXTRACTION_DIR;
  private static String JSSCRIPT_PROCESS_DIR;
  private static final String KANDIANREPORT_SCRIPTS_OFFLINE_BID = "3412";
  private static String SCRIPT_ROOT_PATH;
  private static final int SUPPORT_SCRIPT_VERSION = 1;
  private static final String TAG = "kandianreport.taskmanager";
  private static String TASK_CONFIG_DIR;
  public static final String TASK_ID = "kandianreport.taskmanager";
  public static final String TASK_ON = "kandianreport_ON";
  private static TaskManager _instance;
  private static List<String> configTaskIds;
  public static boolean isConfigureOn;
  private static boolean isStarted;
  private static long lastTime;
  public static int scriptVersion = -1;
  private static long timeLimit;
  private boolean isNetWorkStateRegistered = false;
  private INetInfoHandler netHandler = new TaskManager.1(this);
  private ArrayList<Task> taskList = new ArrayList();
  
  static
  {
    isStarted = false;
    lastTime = 0L;
    timeLimit = 3600000L;
    _instance = new TaskManager();
    try
    {
      isConfigureOn = getConfigOn();
      SCRIPT_ROOT_PATH = OfflineEnvHelper.a("3412") + "3412";
      JSSCRIPT_EXTRACTION_DIR = SCRIPT_ROOT_PATH + "/extraction";
      JSSCRIPT_PROCESS_DIR = SCRIPT_ROOT_PATH + "/process";
      JSSCRIPT_DISTRIBUTION_DIR = SCRIPT_ROOT_PATH + "/distribution";
      JSSCRIPT_CHECK_DIR = SCRIPT_ROOT_PATH + "/check";
      TASK_CONFIG_DIR = SCRIPT_ROOT_PATH + "/task_config";
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("kandianreport.taskmanager", 2, localThrowable.getLocalizedMessage());
    }
  }
  
  private TaskManager()
  {
    ThreadManager.getFileThreadHandler().post(new TaskManager.2(this));
  }
  
  private void addConfigItem(ArrayList<Task.ConfigItem> paramArrayList, JSONObject paramJSONObject)
  {
    int j = 0;
    String str1 = paramJSONObject.optString("id");
    String str2 = paramJSONObject.optString("value");
    Object localObject2 = paramJSONObject.optJSONArray("output");
    Object localObject1 = paramJSONObject.optJSONArray("check");
    paramJSONObject = paramJSONObject.optJSONArray("args");
    Task.ConfigItem localConfigItem = new Task.ConfigItem();
    localConfigItem.id = str1;
    localConfigItem.value = str2;
    int i;
    if (localObject2 != null)
    {
      i = 0;
      while (i < ((JSONArray)localObject2).length())
      {
        str1 = (String)((JSONArray)localObject2).opt(i);
        localConfigItem.output.add(str1);
        i += 1;
      }
    }
    if (localObject1 != null)
    {
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        localObject2 = (String)((JSONArray)localObject1).opt(i);
        localConfigItem.check.add(localObject2);
        i += 1;
      }
    }
    if (paramJSONObject != null)
    {
      i = j;
      while (i < paramJSONObject.length())
      {
        localObject1 = (String)paramJSONObject.opt(i);
        localConfigItem.args.add(localObject1);
        i += 1;
      }
    }
    paramArrayList.add(localConfigItem);
  }
  
  @NotNull
  private JSContext.Callback alertCallback()
  {
    return new TaskManager.13(this);
  }
  
  @NotNull
  private JSContext.Callback clearIntervalCallback()
  {
    return new TaskManager.23(this);
  }
  
  public static String compress(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int k = 0;
    int i = 0;
    int m = 1;
    if (k < paramString.length())
    {
      char c = paramString.charAt(k);
      label51:
      int j;
      if ((i == 0) && (c == '\\'))
      {
        i = 1;
        if (m == 0) {
          break label109;
        }
        j = m;
        if (c != ' ')
        {
          j = m;
          if (c != '\r')
          {
            j = m;
            if (c != '\n')
            {
              if (c != '\t') {
                break label109;
              }
              j = m;
            }
          }
        }
      }
      for (;;)
      {
        k += 1;
        m = j;
        break;
        i = 0;
        break label51;
        label109:
        localStringBuilder.append(c);
        j = m;
        if (c == '"')
        {
          j = m;
          if (i == 0) {
            if (m == 0) {
              j = 1;
            } else {
              j = 0;
            }
          }
        }
      }
    }
    return localStringBuilder.toString().replaceAll("\r\n", "\\\\r\\\\n");
  }
  
  @NotNull
  private JSContext.Callback createRIJStorageCallback()
  {
    return new TaskManager.21(this);
  }
  
  @NotNull
  private JSContext.Callback decodeBase64Callback()
  {
    return new TaskManager.11(this);
  }
  
  private void doNext(JSContext paramJSContext, Object[] paramArrayOfObject, Task.ConfigItem[] paramArrayOfConfigItem, Task paramTask)
  {
    if (paramArrayOfConfigItem != null)
    {
      int i = 0;
      while (i < paramArrayOfConfigItem.length)
      {
        String str1 = paramArrayOfConfigItem[i].value;
        String str2 = (String)paramArrayOfObject[1];
        StringBuffer localStringBuffer = new StringBuffer();
        str1 = str1 + "('" + str2 + "'," + formatArray(paramArrayOfConfigItem[i].args) + ")";
        if (paramJSContext != null)
        {
          paramJSContext.evaluteStringWithException(str1, localStringBuffer);
          reportJsException(localStringBuffer, paramTask, str1);
        }
        i += 1;
      }
    }
  }
  
  @NotNull
  private JSContext.Callback doNextCallback(Task paramTask)
  {
    return new TaskManager.29(this, paramTask);
  }
  
  @NotNull
  private JSContext.Callback encodeBase64Callback()
  {
    return new TaskManager.10(this);
  }
  
  private String formatArray(ArrayList<String> paramArrayList)
  {
    if (paramArrayList != null)
    {
      String str1 = "[";
      int i = 0;
      for (;;)
      {
        str2 = str1;
        if (i >= paramArrayList.size()) {
          break;
        }
        str2 = str1;
        if (i != 0) {
          str2 = str1 + ',';
        }
        str1 = str2 + "'" + (String)paramArrayList.get(i) + "'";
        i += 1;
      }
    }
    String str2 = "[";
    return str2 + "]";
  }
  
  @NotNull
  private JSContext.Callback generateCustomDataCallback(Task paramTask)
  {
    return new TaskManager.15(this);
  }
  
  @NotNull
  private JSContext.Callback getAladdinConfigCallback()
  {
    return new TaskManager.12(this);
  }
  
  private ArrayList<String> getArgsByValue(ArrayList<Task.ConfigItem> paramArrayList, String paramString)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Task.ConfigItem localConfigItem = (Task.ConfigItem)paramArrayList.next();
      if (localConfigItem.value.equals(paramString)) {
        return localConfigItem.args;
      }
    }
    return null;
  }
  
  private ArrayList<String> getCheckByValue(ArrayList<Task.ConfigItem> paramArrayList, String paramString)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Task.ConfigItem localConfigItem = (Task.ConfigItem)paramArrayList.next();
      if (localConfigItem.value.equals(paramString)) {
        return localConfigItem.check;
      }
    }
    return null;
  }
  
  private ArrayList<String> getCheckName(Task paramTask, ArrayList<String> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramTask = getValueById(paramTask.check, paramArrayList);
    if ((paramTask != null) && (paramTask.length > 0)) {
      Collections.addAll(localArrayList, paramTask);
    }
    return localArrayList;
  }
  
  public static boolean getConfigOn()
  {
    return ((Integer)ReadInJoyHelper.a("kandianreport_ON", Integer.valueOf(0))).intValue() == 1;
  }
  
  public static TaskManager getInstance()
  {
    return _instance;
  }
  
  private String getMmapUtilsName(String paramString)
  {
    String str = ReadInJoyUtils.a().getAccount();
    return str + "_" + paramString;
  }
  
  private ArrayList<String> getOutputByValue(ArrayList<Task.ConfigItem> paramArrayList, String paramString)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Task.ConfigItem localConfigItem = (Task.ConfigItem)paramArrayList.next();
      if (localConfigItem.value.equals(paramString)) {
        return localConfigItem.output;
      }
    }
    return null;
  }
  
  @NotNull
  private JSContext.Callback getPlatformInfoCallback()
  {
    return new TaskManager.22(this);
  }
  
  @NotNull
  private JSContext.Callback getTaskIdCallback(Task paramTask)
  {
    return new TaskManager.26(this, paramTask);
  }
  
  private Task.ConfigItem[] getTasksById(ArrayList<Task.ConfigItem> paramArrayList, ArrayList<String> paramArrayList1)
  {
    if ((paramArrayList1 != null) && (paramArrayList1.size() > 0))
    {
      Task.ConfigItem[] arrayOfConfigItem = new Task.ConfigItem[paramArrayList1.size()];
      int i = 0;
      while (i < paramArrayList1.size())
      {
        Iterator localIterator = paramArrayList.iterator();
        while (localIterator.hasNext())
        {
          Task.ConfigItem localConfigItem = (Task.ConfigItem)localIterator.next();
          if (localConfigItem.id.equals(paramArrayList1.get(i))) {
            arrayOfConfigItem[i] = localConfigItem;
          }
        }
        i += 1;
      }
      return arrayOfConfigItem;
    }
    return null;
  }
  
  @NotNull
  private JSContext.Callback getUserUinCallback()
  {
    return new TaskManager.9(this);
  }
  
  private String[] getValueById(ArrayList<Task.ConfigItem> paramArrayList, ArrayList<String> paramArrayList1)
  {
    if ((paramArrayList1 != null) && (paramArrayList1.size() > 0))
    {
      String[] arrayOfString = new String[paramArrayList1.size()];
      int i = 0;
      while (i < paramArrayList1.size())
      {
        Iterator localIterator = paramArrayList.iterator();
        while (localIterator.hasNext())
        {
          Task.ConfigItem localConfigItem = (Task.ConfigItem)localIterator.next();
          if (localConfigItem.id.equals(paramArrayList1.get(i))) {
            arrayOfString[i] = localConfigItem.value;
          }
        }
        i += 1;
      }
      return arrayOfString;
    }
    return null;
  }
  
  @NotNull
  private JSContext.Callback getValueForKeyCallback()
  {
    return new TaskManager.19(this);
  }
  
  public static String getWifiStateJson(String paramString)
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("name", "NetworkEvent");
      localJSONObject1.put("timestamp", System.currentTimeMillis() / 1000L + "");
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("type", paramString);
      if (paramString.equals("WIFI"))
      {
        paramString = ((WifiManager)BaseApplication.getContext().getSystemService("wifi")).getConnectionInfo();
        if (paramString != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("kandianreport.taskmanager", 2, "checknetinfo get wifi ssid " + paramString.getSSID());
          }
          localJSONObject2.put("info", paramString.getBSSID());
        }
      }
      localJSONObject1.put("data", localJSONObject2);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    return localJSONObject1.toString();
  }
  
  @NotNull
  private JSContext.Callback httpCallback(Task paramTask)
  {
    return new TaskManager.14(this, paramTask);
  }
  
  private void importJs(Task paramTask, ArrayList<Task.ConfigItem> paramArrayList, int paramInt)
  {
    JSContext localJSContext = paramTask.jsContext;
    String str;
    if (paramInt == Task.TYPE_EXTRACTION) {
      str = JSSCRIPT_EXTRACTION_DIR;
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str))
      {
        paramArrayList = paramArrayList.iterator();
        for (;;)
        {
          if (!paramArrayList.hasNext()) {
            break label279;
          }
          Object localObject1 = (Task.ConfigItem)paramArrayList.next();
          Object localObject2 = str + "/" + ((Task.ConfigItem)localObject1).value + ".js";
          localObject1 = new File((String)localObject2);
          if (((File)localObject1).exists())
          {
            localObject2 = new StringBuffer();
            localObject1 = FileUtils.b((File)localObject1);
            if (localJSContext == null) {
              continue;
            }
            localJSContext.evaluteStringWithException((String)localObject1, (StringBuffer)localObject2);
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              continue;
            }
            QLog.d("kandianreport.taskmanager", 1, "evaluate js exception: " + localObject2);
            TaskException.reportException(paramTask.id, "evaluate js exception: " + localObject2);
            continue;
            if (paramInt == Task.TYPE_PROCESS)
            {
              str = JSSCRIPT_PROCESS_DIR;
              break;
            }
            if (paramInt == Task.TYPE_DISTRIBUTION)
            {
              str = JSSCRIPT_DISTRIBUTION_DIR;
              break;
            }
            if (paramInt != Task.TYPE_CHECK) {
              break label280;
            }
            str = JSSCRIPT_CHECK_DIR;
            break;
          }
          QLog.d("kandianreport.taskmanager", 2, "import js not exist: " + (String)localObject2);
        }
      }
      label279:
      return;
      label280:
      str = "";
    }
  }
  
  private void initTask(Task paramTask)
  {
    paramTask.jsContext = new JSContext();
    paramTask.jsContext.task = paramTask;
    paramTask.jsContext.initRIJStorage();
    paramTask.jsContext.registerFunction("doNext", doNextCallback(paramTask));
    paramTask.jsContext.registerFunction("setTimeout", setTimeOutCallback(paramTask));
    paramTask.jsContext.registerFunction("QLog", qlogCallback());
    paramTask.jsContext.registerFunction("getTaskId", getTaskIdCallback(paramTask));
    paramTask.jsContext.registerFunction("setInterval", setIntervalCallback(paramTask));
    paramTask.jsContext.registerFunction("reportToServer", reportToServerCallback());
    paramTask.jsContext.registerFunction("clearInterval", clearIntervalCallback());
    paramTask.jsContext.registerFunction("getPlatformInfo", getPlatformInfoCallback());
    paramTask.jsContext.registerFunction("createRIJStorage", createRIJStorageCallback());
    paramTask.jsContext.registerFunction("setValueForKey", setValueForKeyCallback());
    paramTask.jsContext.registerFunction("getValueForKey", getValueForKeyCallback());
    paramTask.jsContext.registerFunction("removeKey", removeKeyCallback());
    paramTask.jsContext.registerFunction("invalidate", invalidateCallback());
    paramTask.jsContext.registerFunction("reportCustomEvent", reportCustomEventCallback());
    paramTask.jsContext.registerFunction("generateCustomData", generateCustomDataCallback(paramTask));
    paramTask.jsContext.registerFunction("httpRequest", httpCallback(paramTask));
    paramTask.jsContext.registerFunction("alert", alertCallback());
    paramTask.jsContext.registerFunction("getAladdinConfig", getAladdinConfigCallback());
    paramTask.jsContext.registerFunction("decodeBase64", decodeBase64Callback());
    paramTask.jsContext.registerFunction("encodeBase64", encodeBase64Callback());
    paramTask.jsContext.registerFunction("getUserUin", getUserUinCallback());
    paramTask.jsContext.registerFunction("isPublicVersion", isPublicVersionCallback());
    paramTask.status = Task.STATUS_INIT;
  }
  
  @NotNull
  private JSContext.Callback invalidateCallback()
  {
    return new TaskManager.17(this);
  }
  
  @NotNull
  private JSContext.Callback isPublicVersionCallback()
  {
    return new TaskManager.8(this);
  }
  
  private boolean isTaskAvailable(Task paramTask)
  {
    int i = ((Integer)ReadInJoyHelper.a("kandianreport.taskmanager" + paramTask.id, Integer.valueOf(0))).intValue();
    return (i != Task.STATUS_FAIL) && (i != Task.STATUS_QUIT);
  }
  
  private void onResp(NetResp paramNetResp, String paramString, JSContext paramJSContext, Task paramTask)
  {
    if (paramNetResp.mRespData != null) {}
    for (String str1 = new String(paramNetResp.mRespData);; str1 = "")
    {
      StringBuffer localStringBuffer = new StringBuffer();
      if (paramNetResp.mRespProperties != null)
      {
        localObject1 = new JSONObject();
        Iterator localIterator = paramNetResp.mRespProperties.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Object localObject2 = (Map.Entry)localIterator.next();
          String str2 = (String)((Map.Entry)localObject2).getKey();
          localObject2 = (String)((Map.Entry)localObject2).getValue();
          try
          {
            ((JSONObject)localObject1).put(str2, localObject2);
          }
          catch (JSONException localJSONException)
          {
            QLog.e("kandianreport.taskmanager", 2, localJSONException.getMessage());
          }
        }
      }
      for (Object localObject1 = ((JSONObject)localObject1).toString();; localObject1 = "")
      {
        str1 = compress(str1);
        localObject1 = compress((String)localObject1);
        paramNetResp = paramString + "(" + paramNetResp.mHttpCode + ",'" + (String)localObject1 + "','" + str1 + "')";
        if (paramJSContext != null)
        {
          paramJSContext.evaluteStringWithException(paramNetResp, localStringBuffer);
          reportJsException(localStringBuffer, paramTask, paramNetResp);
        }
        return;
      }
    }
  }
  
  @NotNull
  private JSContext.Callback qlogCallback()
  {
    return new TaskManager.27(this);
  }
  
  private Task readTaskConfigFile(File paramFile)
  {
    return readTaskConfigJson(FileUtils.a(paramFile));
  }
  
  private Task readTaskConfigJson(String paramString)
  {
    int j = 0;
    paramString = new JSONObject(paramString);
    JSONArray localJSONArray1 = paramString.optJSONArray("filter");
    JSONArray localJSONArray2 = paramString.optJSONArray("extraction");
    JSONArray localJSONArray3 = paramString.optJSONArray("process");
    JSONArray localJSONArray4 = paramString.optJSONArray("distribution");
    JSONArray localJSONArray5 = paramString.optJSONArray("check");
    Task localTask = new Task();
    localTask.config = paramString;
    localTask.id = paramString.optString("id");
    int i;
    if ((localJSONArray1 != null) && (localJSONArray1.length() > 0))
    {
      i = 0;
      while (i < localJSONArray1.length())
      {
        addConfigItem(localTask.filter, (JSONObject)localJSONArray1.opt(i));
        i += 1;
      }
    }
    if ((localJSONArray2 != null) && (localJSONArray2.length() > 0))
    {
      i = 0;
      while (i < localJSONArray2.length())
      {
        addConfigItem(localTask.extraction, (JSONObject)localJSONArray2.opt(i));
        i += 1;
      }
    }
    if ((localJSONArray3 != null) && (localJSONArray3.length() > 0))
    {
      i = 0;
      while (i < localJSONArray3.length())
      {
        addConfigItem(localTask.process, (JSONObject)localJSONArray3.opt(i));
        i += 1;
      }
    }
    if ((localJSONArray4 != null) && (localJSONArray4.length() > 0))
    {
      i = 0;
      while (i < localJSONArray4.length())
      {
        addConfigItem(localTask.distribution, (JSONObject)localJSONArray4.opt(i));
        i += 1;
      }
    }
    if ((localJSONArray5 != null) && (localJSONArray5.length() > 0))
    {
      i = j;
      while (i < localJSONArray5.length())
      {
        addConfigItem(localTask.check, (JSONObject)localJSONArray5.opt(i));
        i += 1;
      }
    }
    return localTask;
  }
  
  private void readTaskIdsFromAladdinConfig()
  {
    configTaskIds = Arrays.asList(Aladdin.getConfig(177).getString("kandian_feature_compute_tasks", "").split("\\|"));
  }
  
  private void readTasksFromConfigFile()
  {
    QLog.d("kandianreport.taskmanager", 1, "readTasksFromConfigFile...");
    if (FileUtils.a(TASK_CONFIG_DIR))
    {
      Object localObject1 = new File(TASK_CONFIG_DIR).listFiles();
      this.taskList.clear();
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        int j = localObject1.length;
        int i = 0;
        for (;;)
        {
          if (i >= j) {
            break label163;
          }
          Object localObject2 = localObject1[i];
          try
          {
            localObject2 = readTaskConfigFile((File)localObject2);
            if ((configTaskIds != null) && (configTaskIds.size() > 0) && (("*".equals(configTaskIds.get(0))) || (configTaskIds.contains(((Task)localObject2).id)))) {
              this.taskList.add(localObject2);
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              QLog.d("kandianreport.taskmanager", 2, localException.getMessage());
              TaskException.reportException(localException.getMessage());
            }
          }
          i += 1;
        }
      }
      label163:
      if (this.taskList.size() > 0)
      {
        localObject1 = this.taskList.iterator();
        while (((Iterator)localObject1).hasNext()) {
          QLog.d("kandianreport.taskmanager", 1, ((Task)((Iterator)localObject1).next()).toString());
        }
      }
      QLog.d("kandianreport.taskmanager", 1, "tasklist empty");
    }
  }
  
  @NotNull
  private JSContext.Callback removeKeyCallback()
  {
    return new TaskManager.18(this);
  }
  
  @NotNull
  private JSContext.Callback reportCustomEventCallback()
  {
    return new TaskManager.16(this);
  }
  
  private void reportJsException(StringBuffer paramStringBuffer, Task paramTask, String paramString)
  {
    if (!TextUtils.isEmpty(paramStringBuffer))
    {
      markTaskFail(paramTask);
      QLog.d("kandianreport.taskmanager", 1, "evaluate js exception: " + paramString + " " + paramStringBuffer);
      TaskException.reportException(paramTask.id, "evaluate js exception: " + paramString + " " + paramStringBuffer);
    }
  }
  
  private void reportToServer(JSContext paramJSContext, String paramString1, String paramString2)
  {
    if (paramJSContext == null) {
      return;
    }
    paramString2 = new JSONObject(paramString2);
    paramString1 = getCheckScript(paramJSContext, paramString1);
    if (paramString1 != null)
    {
      paramString1 = paramString1.iterator();
      while (paramString1.hasNext())
      {
        String str1 = (String)paramString1.next();
        StringBuffer localStringBuffer = new StringBuffer();
        String str2 = str1 + "('" + str1 + "')";
        Object localObject = paramJSContext.evaluteStringWithException(str2, localStringBuffer);
        if (!TextUtils.isEmpty(localStringBuffer))
        {
          markTaskFail(paramJSContext.task);
          QLog.d("kandianreport.taskmanager", 2, "evaluate js exception: " + str2 + " " + localStringBuffer);
          TaskException.reportException(paramJSContext.task.id, "evaluate js exception: " + str2 + " " + localStringBuffer);
        }
        if (((Double)localObject).doubleValue() == 1.0D) {
          paramString2.put(str1, 1);
        } else {
          paramString2.put(str1, 0);
        }
      }
    }
    paramString2.put("taskId", paramJSContext.task.id);
    paramString2.put("version", scriptVersion + "");
    TaskDistribution.report(paramString2.toString());
    paramString1 = new JSONObject();
    paramString1.put("taskId", paramJSContext.task.id);
    paramString1.put("version", scriptVersion + "");
    paramString1.put("so_version", KandianReportSoLoader.getSoVersion() + "");
    paramString1.put("phone", Build.MODEL);
    paramString1.put("sys_version", DeviceInfoUtil.e());
    paramString1.put("qq_version", DeviceInfoUtil.c());
    paramString1.put("appid", AppSetting.a() + "");
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800982F", "0X800982F", 0, 0, "", "", "", paramString1.toString(), false);
  }
  
  @NotNull
  private JSContext.Callback reportToServerCallback()
  {
    return new TaskManager.24(this);
  }
  
  @NotNull
  private JSContext.Callback setIntervalCallback(Task paramTask)
  {
    return new TaskManager.25(this, paramTask);
  }
  
  @NotNull
  private JSContext.Callback setTimeOutCallback(Task paramTask)
  {
    return new TaskManager.28(this, paramTask);
  }
  
  @NotNull
  private JSContext.Callback setValueForKeyCallback()
  {
    return new TaskManager.20(this);
  }
  
  private void startTask(Task paramTask)
  {
    importJs(paramTask, paramTask.extraction, Task.TYPE_EXTRACTION);
    importJs(paramTask, paramTask.process, Task.TYPE_PROCESS);
    importJs(paramTask, paramTask.distribution, Task.TYPE_DISTRIBUTION);
    importJs(paramTask, paramTask.check, Task.TYPE_CHECK);
    paramTask.status = Task.STATUS_ACCEPT;
  }
  
  private void startTasks()
  {
    ThreadManager.getFileThreadHandler().post(new TaskManager.5(this));
  }
  
  private void startTasksIfExist()
  {
    try
    {
      if (isStarted) {
        return;
      }
      if (FileUtils.a(SCRIPT_ROOT_PATH)) {
        break label124;
      }
      QLog.d("kandianreport.taskmanager", 1, "startTasksIfExist: offline root dir is null");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("kandianreport.taskmanager", 2, "startAllTasks unexpected exception: " + localException.getMessage());
        TaskException.reportException("startAllTasks unexpected exception: " + localException.getMessage());
        return;
        try
        {
          if (OfflineSecurity.a(SCRIPT_ROOT_PATH, "3412")) {
            continue;
          }
          KandianReportSoLoader.logAndReport("startTasksIfExist: verification failed");
          return;
        }
        catch (Throwable localThrowable)
        {
          QLog.e("kandianreport.taskmanager", 1, localThrowable.getMessage());
          return;
        }
      }
    }
    catch (Error localError)
    {
      label124:
      QLog.d("kandianreport.taskmanager", 2, "startAllTasks unexpected error: " + localError.getMessage());
      TaskException.reportException("startAllTasks unexpected error: " + localError.getMessage());
    }
    readTaskIdsFromAladdinConfig();
    readTasksFromConfigFile();
    startTasksInList();
    KandianReportSoLoader.logAndReport("startTasksIfExist tasks size are: " + this.taskList.size());
    return;
  }
  
  private void startTasksInList()
  {
    QLog.d("kandianreport.taskmanager", 1, "startTasksInList...");
    Iterator localIterator = this.taskList.iterator();
    while (localIterator.hasNext())
    {
      Task localTask = (Task)localIterator.next();
      try
      {
        if (isTaskAvailable(localTask))
        {
          initTask(localTask);
          startTask(localTask);
        }
      }
      catch (Exception localException)
      {
        markTaskFail(localTask);
        QLog.d("kandianreport.taskmanager", 1, "startTasksInList unexpected exception: " + localException.getMessage());
        TaskException.reportException(localTask.id, "startTasksInList unexpected exception: " + localException.getMessage());
        continue;
        QLog.d("kandianreport.taskmanager", 1, localTask.id + " available status is " + localTask.status);
      }
      catch (Error localError)
      {
        markTaskFail(localTask);
        QLog.d("kandianreport.taskmanager", 1, "startTasksInList unexpected error: " + localError.getMessage());
        TaskException.reportException(localTask.id, "startTasksInList unexpected error: " + localError.getMessage());
      }
    }
    isStarted = true;
  }
  
  public void accept(String paramString)
  {
    if ((isConfigureOn) && (isStarted) && (!TextUtils.isEmpty(paramString)))
    {
      if (!KandianReportSoLoader.isSoFiledLoad()) {
        QLog.d("kandianreport.taskmanager", 2, "accept so not load");
      }
    }
    else {
      return;
    }
    ThreadManager.getFileThreadHandler().post(new TaskManager.6(this, paramString));
  }
  
  public void downloadScripts(boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    if (l - lastTime >= timeLimit) {
      TaskOfflineUtils.checkUpdate("3412", 1, new TaskManager.30(this, paramBoolean));
    }
    lastTime = l;
  }
  
  public ArrayList<String> getCheckScript(JSContext paramJSContext, String paramString)
  {
    paramJSContext = paramJSContext.task;
    if (paramJSContext != null)
    {
      ArrayList localArrayList = getCheckByValue(paramJSContext.filter, paramString);
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        return getCheckName(paramJSContext, localArrayList);
      }
      localArrayList = getCheckByValue(paramJSContext.extraction, paramString);
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        return getCheckName(paramJSContext, localArrayList);
      }
      localArrayList = getCheckByValue(paramJSContext.process, paramString);
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        return getCheckName(paramJSContext, localArrayList);
      }
      paramString = getCheckByValue(paramJSContext.distribution, paramString);
      if ((paramString != null) && (paramString.size() > 0)) {
        return getCheckName(paramJSContext, paramString);
      }
    }
    return null;
  }
  
  public Task.ConfigItem[] getNextScript(JSContext paramJSContext, String paramString)
  {
    if (paramJSContext == null) {}
    do
    {
      do
      {
        return null;
        paramJSContext = paramJSContext.task;
      } while (paramJSContext == null);
      ArrayList localArrayList = getOutputByValue(paramJSContext.filter, paramString);
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        return getTasksById(paramJSContext.extraction, localArrayList);
      }
      localArrayList = getOutputByValue(paramJSContext.extraction, paramString);
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        return getTasksById(paramJSContext.process, localArrayList);
      }
      localArrayList = getOutputByValue(paramJSContext.process, paramString);
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        return getTasksById(paramJSContext.distribution, localArrayList);
      }
      paramString = getOutputByValue(paramJSContext.distribution, paramString);
    } while ((paramString == null) || (paramString.size() <= 0));
    return getTasksById(paramJSContext.check, paramString);
  }
  
  public void markTaskFail(Task paramTask)
  {
    QLog.d("kandianreport.taskmanager", 2, "mark task fail " + paramTask.id);
    paramTask.status = Task.STATUS_FAIL;
    ReadInJoyHelper.a("kandianreport.taskmanager" + paramTask.id, Integer.valueOf(Task.STATUS_FAIL));
  }
  
  public void qlog(int paramInt, String paramString)
  {
    QLog.d("kandianreport.taskmanager", paramInt, paramString);
  }
  
  public void reStartTask(String paramString)
  {
    QLog.d("kandianreport.taskmanager", 1, "reStartTask: " + paramString);
    Iterator localIterator = this.taskList.iterator();
    while (localIterator.hasNext())
    {
      Task localTask = (Task)localIterator.next();
      if (localTask.id == paramString) {
        try
        {
          initTask(localTask);
          startTask(localTask);
          localTask.status = Task.STATUS_ACCEPT;
          ReadInJoyHelper.a("kandianreport.taskmanager" + paramString, Integer.valueOf(Task.STATUS_ACCEPT));
        }
        catch (Exception localException)
        {
          markTaskFail(localTask);
          QLog.d("kandianreport.taskmanager", 2, "reStartTask unexpected exception: " + localException.getMessage());
          TaskException.reportException(localTask.id, "reStartTask unexpected exception: " + localException.getMessage());
        }
        catch (Error localError)
        {
          markTaskFail(localTask);
          QLog.d("kandianreport.taskmanager", 2, "reStartTask unexpected error: " + localError.getMessage());
          TaskException.reportException(localTask.id, "reStartTask unexpected error: " + localError.getMessage());
        }
      }
    }
  }
  
  public void reset()
  {
    ThreadManager.getFileThreadHandler().post(new TaskManager.7(this));
  }
  
  public void restartAllTasks()
  {
    QLog.d("kandianreport.taskmanager", 2, "restartAllTasks");
    stopAllTasks();
    startAllTasks();
  }
  
  public void restore()
  {
    QLog.d("kandianreport.taskmanager", 1, "restore");
    ReadInJoyHelper.a("kandianreport_ON", Integer.valueOf(1));
  }
  
  public void startAllTasks()
  {
    for (;;)
    {
      try
      {
        isConfigureOn = getConfigOn();
        if ((!isConfigureOn) || (isStarted)) {
          break label160;
        }
        KandianReportSoLoader.logAndReport("startAllTasks");
        if (!this.isNetWorkStateRegistered)
        {
          AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getContext(), this.netHandler);
          this.isNetWorkStateRegistered = true;
        }
        scriptVersion = TaskOfflineUtils.checkOffLineConfig("3412", 1).version;
        if (!KandianReportSoLoader.isSoFiledLoad()) {
          continue;
        }
        QLog.d("kandianreport.taskmanager", 1, "so loaded, now startTasks");
        startTasks();
      }
      catch (Throwable localThrowable)
      {
        QLog.e("kandianreport.taskmanager", 2, "startAllTasks " + localThrowable);
        continue;
      }
      finally {}
      return;
      QLog.d("kandianreport.taskmanager", 1, "so not loaded, load first");
      if (!KandianReportSoLoader.isSoFileDownload())
      {
        KandianReportSoLoader.downLoadSoFiles(new TaskManager.3(this));
      }
      else
      {
        KandianReportSoLoader.loadSoFiles(new TaskManager.4(this));
        continue;
        label160:
        QLog.d("kandianreport.taskmanager", 2, "startAllTasks fail isConfigureOn: " + isConfigureOn + " isStarted: " + isStarted);
      }
    }
  }
  
  public void stopAllTasks()
  {
    try
    {
      if (isStarted)
      {
        QLog.d("kandianreport.taskmanager", 1, "stopAllTasks");
        isStarted = false;
        Iterator localIterator = this.taskList.iterator();
        while (localIterator.hasNext()) {
          stopTask(((Task)localIterator.next()).id);
        }
        this.isNetWorkStateRegistered = false;
      }
    }
    finally {}
  }
  
  public void stopTask(String paramString)
  {
    Iterator localIterator = this.taskList.iterator();
    while (localIterator.hasNext())
    {
      Task localTask = (Task)localIterator.next();
      if (localTask.id == paramString) {
        localTask.status = Task.STATUS_STOP;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskManager
 * JD-Core Version:    0.7.0.1
 */