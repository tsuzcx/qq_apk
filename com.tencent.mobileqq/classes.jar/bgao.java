import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.mobileqq.vas.LzmaUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.PluginRecord;
import cooperation.qzone.report.lp.LpReportInfo_dc01500;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class bgao
  implements Handler.Callback
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  Map<String, bgaq> jdField_a_of_type_JavaUtilMap;
  Map<String, PluginRecord> b;
  
  bgao(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.b = new HashMap();
    bgap localbgap = new bgap(this);
    bgbf.a(paramContext, this.b, localbgap);
  }
  
  private boolean a(PluginRecord paramPluginRecord)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramPluginRecord != null)
    {
      if (!a(paramPluginRecord, bgbf.a(BaseApplicationImpl.getContext(), paramPluginRecord.id), false)) {
        break label69;
      }
      paramPluginRecord.state = 4;
    }
    for (bool1 = true;; bool1 = bool2)
    {
      QLog.i("plugin_tag", 1, "verifyInstalledPlugin :" + paramPluginRecord + "," + bool1);
      return bool1;
      label69:
      a(paramPluginRecord, null);
      paramPluginRecord.state = 0;
    }
  }
  
  static boolean a(@NonNull PluginRecord paramPluginRecord, @Nullable File paramFile, boolean paramBoolean)
  {
    boolean bool = true;
    String str2;
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isFile()))
    {
      QLog.e("plugin_tag", 1, "isValidPluginFile4LZMA file not exist");
      paramFile = paramPluginRecord.id;
      str1 = paramPluginRecord.old_ver;
      str2 = paramPluginRecord.ver;
      if (paramBoolean) {}
      for (paramPluginRecord = "0";; paramPluginRecord = "1")
      {
        LpReportInfo_dc01500.reportInstall(paramFile, str1, str2, -1.0D, 1, paramPluginRecord);
        bool = false;
        return bool;
      }
    }
    String str1 = PluginStatic.encodeFile(paramFile.getPath());
    if (paramBoolean)
    {
      paramFile = paramPluginRecord.md5;
      label93:
      if ((paramFile != null) && (paramFile.equalsIgnoreCase(str1))) {
        break label195;
      }
      QLog.e("plugin_tag", 1, "isValidPluginFile invalid:" + paramFile + ", " + str1 + ", " + paramBoolean);
      paramFile = paramPluginRecord.id;
      str1 = paramPluginRecord.old_ver;
      str2 = paramPluginRecord.ver;
      if (!paramBoolean) {
        break label197;
      }
    }
    label195:
    label197:
    for (paramPluginRecord = "0";; paramPluginRecord = "1")
    {
      LpReportInfo_dc01500.reportInstall(paramFile, str1, str2, -1.0D, 4, paramPluginRecord);
      return false;
      paramFile = paramPluginRecord.md5_2;
      break label93;
      break;
    }
  }
  
  private void b(bgaq parambgaq)
  {
    Object localObject1 = parambgaq.jdField_a_of_type_Bgar;
    PluginRecord localPluginRecord = parambgaq.jdField_a_of_type_CooperationQzonePluginPluginRecord;
    if (localObject1 != null) {
      ((bgar)localObject1).d(parambgaq.jdField_a_of_type_CooperationQzonePluginPluginRecord);
    }
    Object localObject2 = bgbf.e(this.jdField_a_of_type_AndroidContentContext, localPluginRecord.id);
    localObject1 = bgbf.a(this.jdField_a_of_type_AndroidContentContext, localPluginRecord.id);
    File localFile1 = bgbf.b(this.jdField_a_of_type_AndroidContentContext, localPluginRecord.id);
    long l1 = System.currentTimeMillis();
    if (!a(localPluginRecord, (File)localObject2, true))
    {
      QLog.w("QZonePluginManger", 1, "文件校验失败");
      Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 2, parambgaq).sendToTarget();
      return;
    }
    File localFile2 = ((File)localObject1).getParentFile();
    int i = LzmaUtils.a(this.jdField_a_of_type_AndroidContentContext, ((File)localObject2).getAbsolutePath(), localFile2.getAbsolutePath());
    QLog.d("QZonePluginManger", 1, "LZMA uncompress ret=" + i);
    long l2 = System.currentTimeMillis() - l1;
    if (QLog.isColorLevel()) {
      QLog.i("QZonePluginManger", 2, "解压缩LZMA的时间, cost=" + l2);
    }
    LpReportInfo_dc01500.reportInstall(localPluginRecord.id, localPluginRecord.old_ver, localPluginRecord.ver, l2 / 1000.0D, 100, i + "");
    if (i != 0)
    {
      QLog.w("QZonePluginManger", 1, "解压缩LZMA失败, ret=" + i);
      LpReportInfo_dc01500.reportInstall(localPluginRecord.id, localPluginRecord.old_ver, localPluginRecord.ver, l2 / 1000.0D, 5);
      Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 2, parambgaq).sendToTarget();
      return;
    }
    localPluginRecord.md5_2 = PluginStatic.encodeFile(((File)localObject1).getAbsolutePath());
    if (localFile1.exists())
    {
      localObject2 = localFile1.listFiles();
      if ((localObject2 != null) && (localObject2.length > 0))
      {
        QLog.i("QZonePluginManger", 2, "delete avsdk so libPath:" + localFile1.getAbsolutePath());
        int j = localObject2.length;
        i = 0;
        for (;;)
        {
          if (i < j)
          {
            localFile2 = localObject2[i];
            if (localFile2.exists()) {}
            try
            {
              boolean bool = localFile2.delete();
              QLog.i("QZonePluginManger", 2, "delete file:" + localFile2.getName() + " success:" + bool);
              i += 1;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                QLog.e("QZonePluginManger", 2, Log.getStackTraceString(localException));
              }
            }
          }
        }
      }
    }
    localObject1 = PluginUtils.extractLibs(((File)localObject1).getAbsolutePath(), localFile1.getAbsolutePath());
    l2 = System.currentTimeMillis() - l1 - l2;
    if (QLog.isColorLevel()) {
      QLog.i("QZonePluginManger", 2, "释放so的时间, cost=" + l2);
    }
    LpReportInfo_dc01500.reportInstall(localPluginRecord.id, localPluginRecord.old_ver, localPluginRecord.ver, l2 / 1000.0D, 101);
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      QLog.w("QZonePluginManger", 1, "释放so失败:" + (String)localObject1);
      LpReportInfo_dc01500.reportInstall(localPluginRecord.id, localPluginRecord.old_ver, localPluginRecord.ver, l2 / 1000.0D, 3, (String)localObject1);
      Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 2, parambgaq).sendToTarget();
      return;
    }
    l1 = System.currentTimeMillis() - l1;
    QLog.i("QZonePluginManger", 1, "插件安装成功, cost=" + l1);
    LpReportInfo_dc01500.reportInstall(localPluginRecord.id, localPluginRecord.old_ver, localPluginRecord.ver, l1 / 1000.0D, 0);
    Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 3, parambgaq).sendToTarget();
  }
  
  public PluginRecord a(String paramString)
  {
    return (PluginRecord)this.b.get(paramString);
  }
  
  public void a(bgaq parambgaq)
  {
    QLog.i("plugin_tag", 1, "unInstallPluginInner : " + parambgaq.jdField_a_of_type_CooperationQzonePluginPluginRecord);
    parambgaq = parambgaq.jdField_a_of_type_CooperationQzonePluginPluginRecord;
    File localFile1 = bgbf.a(this.jdField_a_of_type_AndroidContentContext, parambgaq.id);
    File localFile2 = bgbf.b(this.jdField_a_of_type_AndroidContentContext, parambgaq.id);
    localFile1.delete();
    localFile2.delete();
    bgbf.c(parambgaq);
  }
  
  public void a(PluginRecord paramPluginRecord, bgar parambgar)
  {
    QLog.i("plugin_tag", 1, "installPlugin: " + paramPluginRecord);
    bgaq localbgaq = new bgaq(this);
    localbgaq.jdField_a_of_type_CooperationQzonePluginPluginRecord = paramPluginRecord;
    localbgaq.jdField_a_of_type_Bgar = parambgar;
    localbgaq.jdField_a_of_type_JavaLangString = paramPluginRecord.id;
    Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 0, localbgaq).sendToTarget();
  }
  
  public void a(PluginRecord paramPluginRecord, bgas parambgas)
  {
    QLog.i("plugin_tag", 1, "unInstallPlugin: " + paramPluginRecord);
    bgaq localbgaq = new bgaq(this);
    localbgaq.jdField_a_of_type_CooperationQzonePluginPluginRecord = paramPluginRecord;
    localbgaq.jdField_a_of_type_Bgas = parambgas;
    Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 1, localbgaq).sendToTarget();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    Object localObject1;
    do
    {
      do
      {
        Object localObject2;
        do
        {
          do
          {
            do
            {
              return false;
              localObject2 = (bgaq)paramMessage.obj;
            } while (this.jdField_a_of_type_JavaUtilMap.containsKey(((bgaq)localObject2).jdField_a_of_type_JavaLangString));
            this.jdField_a_of_type_JavaUtilMap.put(((bgaq)localObject2).jdField_a_of_type_JavaLangString, localObject2);
            localObject1 = ((bgaq)localObject2).jdField_a_of_type_CooperationQzonePluginPluginRecord;
            localObject2 = ((bgaq)localObject2).jdField_a_of_type_Bgar;
            if (localObject2 != null) {
              ((bgar)localObject2).d((PluginRecord)localObject1);
            }
            b((bgaq)paramMessage.obj);
            return false;
            paramMessage = (bgaq)paramMessage.obj;
          } while (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramMessage.jdField_a_of_type_JavaLangString));
          localObject1 = paramMessage.jdField_a_of_type_CooperationQzonePluginPluginRecord;
          localObject2 = paramMessage.jdField_a_of_type_Bgar;
          if (localObject2 != null) {
            ((bgar)localObject2).a(false, (PluginRecord)localObject1);
          }
          this.jdField_a_of_type_JavaUtilMap.remove(paramMessage.jdField_a_of_type_JavaLangString);
          return false;
          paramMessage = (bgaq)paramMessage.obj;
          localObject1 = paramMessage.jdField_a_of_type_CooperationQzonePluginPluginRecord;
          localObject2 = paramMessage.jdField_a_of_type_Bgas;
          if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramMessage.jdField_a_of_type_JavaLangString))
          {
            if (localObject2 != null) {
              ((bgas)localObject2).e((PluginRecord)localObject1);
            }
            this.jdField_a_of_type_JavaUtilMap.put(paramMessage.jdField_a_of_type_JavaLangString, paramMessage);
            a(paramMessage);
            this.jdField_a_of_type_JavaUtilMap.remove(paramMessage.jdField_a_of_type_JavaLangString);
            this.b.remove(((PluginRecord)localObject1).id);
            bgbf.c((PluginRecord)localObject1);
            if (localObject2 != null) {
              ((bgas)localObject2).b(true, (PluginRecord)localObject1);
            }
          }
        } while (localObject2 == null);
        ((bgas)localObject2).b(false, (PluginRecord)localObject1);
        return false;
        localObject1 = (bgaq)paramMessage.obj;
      } while (!this.jdField_a_of_type_JavaUtilMap.containsKey(((bgaq)localObject1).jdField_a_of_type_JavaLangString));
      paramMessage = ((bgaq)localObject1).jdField_a_of_type_CooperationQzonePluginPluginRecord;
      this.jdField_a_of_type_JavaUtilMap.remove(((bgaq)localObject1).jdField_a_of_type_JavaLangString);
      paramMessage.state = 4;
      this.b.put(paramMessage.id, paramMessage);
      QLog.i("QZonePluginManger", 1, "QZonePluginInstaller 安装成功 record:" + paramMessage);
      bgbf.b(paramMessage);
      localObject1 = ((bgaq)localObject1).jdField_a_of_type_Bgar;
    } while (localObject1 == null);
    ((bgar)localObject1).a(true, paramMessage);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgao
 * JD-Core Version:    0.7.0.1
 */