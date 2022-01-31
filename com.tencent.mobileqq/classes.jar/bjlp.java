import NS_MOBILE_CLIENT_UPDATE.SQ_CLIENT_UPDATE_RSP;
import NS_MOBILE_CLIENT_UPDATE.UPDATE_INFO;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.PluginIntent;
import cooperation.qzone.plugin.PluginRecord;
import cooperation.qzone.report.lp.LpReportInfo_dc01500;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class bjlp
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  bjlr jdField_a_of_type_Bjlr;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Map<String, PluginRecord> jdField_a_of_type_JavaUtilMap;
  HashMap<String, PluginRecord> b = new HashMap();
  
  public bjlp(QQAppInterface paramQQAppInterface, Context paramContext, Handler paramHandler)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    paramQQAppInterface = new PluginRecord();
    paramQQAppInterface.ver = "0";
    this.jdField_a_of_type_JavaUtilHashMap.put("qzone_live_video_plugin_hack.apk", "com.tencent.mobileqq:qzonelive");
    paramQQAppInterface.name = "qzone_live_video_plugin_hack.apk";
    paramQQAppInterface.id = "qzone_live_video_plugin_hack.apk";
    this.b.put(paramQQAppInterface.id, paramQQAppInterface);
    paramQQAppInterface = new PluginRecord();
    paramQQAppInterface.ver = "0";
    paramQQAppInterface.name = "qzone_vertical_video_plugin.apk";
    paramQQAppInterface.id = "qzone_vertical_video_plugin.apk";
    this.b.put(paramQQAppInterface.id, paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilHashMap.put("qzone_vertical_video_plugin.apk", "com.tencent.mobileqq:qzone");
    paramQQAppInterface = new PluginRecord();
    paramQQAppInterface.ver = "0";
    paramQQAppInterface.name = "QZoneWeishiFeedsVideo";
    paramQQAppInterface.id = "qzone_weishi_feeds_plugin.apk";
    this.b.put(paramQQAppInterface.id, paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilHashMap.put("qzone_weishi_feeds_plugin.apk", "com.tencent.mobileqq:qzonelive");
    bjls.a(paramContext, this.jdField_a_of_type_JavaUtilMap);
  }
  
  public static String a(Map<Integer, String> paramMap, Integer paramInteger)
  {
    if (paramMap != null) {
      return (String)paramMap.get(paramInteger);
    }
    return null;
  }
  
  private void a(SQ_CLIENT_UPDATE_RSP paramSQ_CLIENT_UPDATE_RSP)
  {
    if (paramSQ_CLIENT_UPDATE_RSP != null)
    {
      String str1 = paramSQ_CLIENT_UPDATE_RSP.md5;
      String str2 = paramSQ_CLIENT_UPDATE_RSP.upUrl;
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QZonePluginUpdater", 2, "收到补丁包信息：" + paramSQ_CLIENT_UPDATE_RSP);
        }
        bjjr.a().a(str1, str2);
      }
    }
  }
  
  private void a(SQ_CLIENT_UPDATE_RSP paramSQ_CLIENT_UPDATE_RSP, String[] paramArrayOfString)
  {
    if (paramSQ_CLIENT_UPDATE_RSP != null)
    {
      if ((paramSQ_CLIENT_UPDATE_RSP.vPlugin != null) && (paramSQ_CLIENT_UPDATE_RSP.vPlugin.size() > 0))
      {
        a(paramSQ_CLIENT_UPDATE_RSP.vPlugin, paramArrayOfString);
        QLog.i("QZonePluginUpdater", 2, "plugin need update：" + paramSQ_CLIENT_UPDATE_RSP + ", size = " + paramSQ_CLIENT_UPDATE_RSP.vPlugin.size());
        return;
      }
      QLog.i("QZonePluginUpdater", 2, "plugin don not need update：" + paramSQ_CLIENT_UPDATE_RSP);
      return;
    }
    QLog.i("QZonePluginUpdater", 2, "response == null");
  }
  
  private void a(UPDATE_INFO paramUPDATE_INFO, PluginRecord paramPluginRecord)
  {
    if ((paramPluginRecord == null) || (paramUPDATE_INFO == null)) {
      return;
    }
    paramPluginRecord.app = paramUPDATE_INFO.app;
    paramPluginRecord.id = paramUPDATE_INFO.id;
    paramPluginRecord.actype = paramUPDATE_INFO.actype;
    paramPluginRecord.mainVersion = paramUPDATE_INFO.mainVersion;
    paramPluginRecord.md5 = paramUPDATE_INFO.md5;
    paramPluginRecord.name = paramUPDATE_INFO.name;
    paramPluginRecord.old_ver = paramPluginRecord.ver;
    paramPluginRecord.ver = paramUPDATE_INFO.ver;
    paramPluginRecord.actype = paramUPDATE_INFO.actype;
    paramPluginRecord.url = a(paramUPDATE_INFO.plugin_info, Integer.valueOf(0));
    paramPluginRecord.mProcesses = ((String)this.jdField_a_of_type_JavaUtilHashMap.get(paramPluginRecord.id));
    paramPluginRecord.mInstalledPath = bjls.a(BaseApplicationImpl.getContext(), paramPluginRecord.id).getAbsolutePath();
  }
  
  private void a(PluginRecord paramPluginRecord)
  {
    File localFile = bjls.c(BaseApplicationImpl.getContext(), paramPluginRecord.id);
    if ((localFile != null) && (localFile.exists())) {
      localFile.delete();
    }
    bjls.a(paramPluginRecord);
    LpReportInfo_dc01500.reportConfig(paramPluginRecord.id, paramPluginRecord.old_ver, paramPluginRecord.ver, 0);
  }
  
  private void a(String paramString)
  {
    paramString = bjls.c(BaseApplicationImpl.getContext(), paramString);
    if ((paramString != null) && (paramString.exists())) {
      paramString.delete();
    }
  }
  
  private void a(WeakReference<QQAppInterface> paramWeakReference, String[] paramArrayOfString)
  {
    PluginIntent localPluginIntent = new PluginIntent(BaseApplicationImpl.getContext(), bjjs.class);
    localPluginIntent.a = a();
    localPluginIntent.b = bjie.a().a();
    localPluginIntent.a(new bjlq(this));
    localPluginIntent.putExtra("forceDownLoadPlugins", paramArrayOfString);
    paramArrayOfString = null;
    if (paramWeakReference != null) {
      paramArrayOfString = (QQAppInterface)paramWeakReference.get();
    }
    if (paramArrayOfString != null) {
      paramArrayOfString.startServlet(localPluginIntent);
    }
  }
  
  private static void b(String paramString)
  {
    QLog.i("QZonePluginManger", 2, paramString);
  }
  
  public PluginRecord a(String paramString)
  {
    return (PluginRecord)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public ArrayList<UPDATE_INFO> a()
  {
    ArrayList localArrayList = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    this.b.putAll(this.jdField_a_of_type_JavaUtilMap);
    Iterator localIterator = this.b.values().iterator();
    while (localIterator.hasNext())
    {
      PluginRecord localPluginRecord = (PluginRecord)localIterator.next();
      UPDATE_INFO localUPDATE_INFO = new UPDATE_INFO();
      localUPDATE_INFO.id = localPluginRecord.id;
      localUPDATE_INFO.app = localPluginRecord.id;
      localUPDATE_INFO.ver = (localPluginRecord.ver + "");
      localArrayList.add(localUPDATE_INFO);
      localStringBuilder.append("id=").append(localUPDATE_INFO.id).append(",app=").append(localUPDATE_INFO.app).append(",ver=").append(localUPDATE_INFO.ver).append("\r\n");
    }
    b("getRequestUpdateInfo:" + localStringBuilder);
    return localArrayList;
  }
  
  Map<String, PluginRecord> a()
  {
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  public void a()
  {
    a(this.jdField_a_of_type_JavaLangRefWeakReference, null);
  }
  
  public void a(bjlr parambjlr)
  {
    this.jdField_a_of_type_Bjlr = parambjlr;
  }
  
  public void a(ArrayList<UPDATE_INFO> paramArrayList, String[] paramArrayOfString)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        paramArrayOfString = (UPDATE_INFO)paramArrayList.next();
        if (paramArrayOfString.actype == 4)
        {
          b("delete plugin, " + paramArrayOfString.name);
          if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramArrayOfString.id))
          {
            this.jdField_a_of_type_JavaUtilMap.remove(paramArrayOfString.id);
            a(paramArrayOfString.id);
          }
        }
        else
        {
          PluginRecord localPluginRecord1 = new PluginRecord();
          a(paramArrayOfString, localPluginRecord1);
          if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramArrayOfString.id))
          {
            PluginRecord localPluginRecord2 = (PluginRecord)this.jdField_a_of_type_JavaUtilMap.get(paramArrayOfString.id);
            if (!localPluginRecord1.equals(localPluginRecord2))
            {
              if (localPluginRecord2 == null) {
                break label241;
              }
              a(paramArrayOfString, localPluginRecord2);
            }
            for (;;)
            {
              a((PluginRecord)this.jdField_a_of_type_JavaUtilMap.get(paramArrayOfString.id));
              b("onPluginResponse contain update plugin, name = " + paramArrayOfString.name + ", ver = " + paramArrayOfString.ver);
              break;
              label241:
              this.jdField_a_of_type_JavaUtilMap.put(paramArrayOfString.id, localPluginRecord1);
            }
          }
          this.jdField_a_of_type_JavaUtilMap.put(paramArrayOfString.id, localPluginRecord1);
          a((PluginRecord)this.jdField_a_of_type_JavaUtilMap.get(paramArrayOfString.id));
          b("onPluginResponse not contain update plugin, name = " + paramArrayOfString.name + ", ver = " + paramArrayOfString.ver);
        }
      }
    }
  }
  
  public boolean a(PluginRecord paramPluginRecord)
  {
    if (paramPluginRecord == null) {
      return false;
    }
    PluginRecord localPluginRecord = b(paramPluginRecord.id);
    String str;
    if (QLog.isColorLevel())
    {
      QLog.d("QZonePluginUpdater", 2, "pre: " + paramPluginRecord.md5);
      StringBuilder localStringBuilder = new StringBuilder().append("new: ");
      if (localPluginRecord != null)
      {
        str = localPluginRecord.md5;
        QLog.d("QZonePluginUpdater", 2, str);
      }
    }
    else
    {
      if ((localPluginRecord == null) || (!localPluginRecord.md5.equals(paramPluginRecord.md5))) {
        break label121;
      }
    }
    label121:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      str = null;
      break;
    }
  }
  
  public PluginRecord b(String paramString)
  {
    return (PluginRecord)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjlp
 * JD-Core Version:    0.7.0.1
 */