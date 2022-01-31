import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mm.vfs.VFSFileOp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloadListener;
import com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloader.2;
import com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloaderTask;
import com.tencent.mobileqq.bigbrother.ServerApi.RspPreDownloadRecmd;
import com.tencent.mobileqq.data.RockDownloadInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

public class anvu
{
  private static awgf a;
  public static final String a;
  private static String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = bdzf.a(alof.aX + ".Rock/");
  }
  
  public static awgf a()
  {
    if (jdField_a_of_type_Awgf == null) {
      jdField_a_of_type_Awgf = new anwb().createEntityManager();
    }
    return jdField_a_of_type_Awgf;
  }
  
  public static RockDownloadInfo a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 16384);
    } while (paramContext == null);
    paramString = new RockDownloadInfo();
    paramString.setPackageName(paramContext.packageName);
    paramString.setRealVersionCode(paramContext.versionCode);
    return paramString;
  }
  
  public static String a()
  {
    if (jdField_b_of_type_JavaLangString == null)
    {
      jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString;
      VFSFile localVFSFile = new VFSFile(jdField_b_of_type_JavaLangString);
      if (!localVFSFile.exists()) {
        localVFSFile.mkdirs();
      }
    }
    return jdField_b_of_type_JavaLangString;
  }
  
  private static String a(RockDownloadInfo paramRockDownloadInfo)
  {
    return a() + paramRockDownloadInfo.getDownloadFileNameMD5();
  }
  
  public static ArrayList<RockDownloadInfo> a(RockDownloaderTask paramRockDownloaderTask)
  {
    ArrayList localArrayList = null;
    if (!paramRockDownloaderTask.getDownloadInfo().verifyDate(2))
    {
      paramRockDownloaderTask = localArrayList;
      if (QLog.isColorLevel())
      {
        QLog.d("RockDownloader", 2, "RockDownloadInfo verifyDate fail");
        paramRockDownloaderTask = localArrayList;
      }
    }
    do
    {
      do
      {
        return paramRockDownloaderTask;
        localObject = a().a(RockDownloadInfo.class, true, "businessName=? AND packageName=?", new String[] { paramRockDownloaderTask.getDownloadInfo().businessName, paramRockDownloaderTask.getDownloadInfo().packageName }, null, null, null, null);
        localArrayList = new ArrayList();
        paramRockDownloaderTask = localArrayList;
      } while (localObject == null);
      paramRockDownloaderTask = localArrayList;
    } while (((List)localObject).size() <= 0);
    if (QLog.isColorLevel()) {
      QLog.d("RockDownloader", 2, new Object[] { "result size=", Integer.valueOf(((List)localObject).size()) });
    }
    Object localObject = ((List)localObject).iterator();
    for (;;)
    {
      paramRockDownloaderTask = localArrayList;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      paramRockDownloaderTask = (awge)((Iterator)localObject).next();
      if ((paramRockDownloaderTask instanceof RockDownloadInfo))
      {
        RockDownloadInfo localRockDownloadInfo = (RockDownloadInfo)paramRockDownloaderTask;
        if ((!TextUtils.isEmpty(localRockDownloadInfo.localPath)) && (new VFSFile(localRockDownloadInfo.localPath).exists()))
        {
          localArrayList.add(localRockDownloadInfo);
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("RockDownloader", 2, new Object[] { "File Removed: ", paramRockDownloaderTask.toString() });
          }
          a().b(localRockDownloadInfo);
        }
      }
    }
  }
  
  public static void a(RockDownloaderTask paramRockDownloaderTask)
  {
    if (!paramRockDownloaderTask.getDownloadInfo().verifyDate(1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RockDownloader", 2, "RockDownloadInfo verifyDate fail");
      }
      if (paramRockDownloaderTask.getRockDownloadListener() != null) {
        paramRockDownloaderTask.getRockDownloadListener().onDownloadFail(paramRockDownloaderTask.getDownloadInfo(), "RockDownloadInfo verifyDate fail", 10001);
      }
      b(paramRockDownloaderTask, "0x800A1E6");
      return;
    }
    NewIntent localNewIntent = new NewIntent(paramRockDownloaderTask.getRuntime().getApplication(), anwa.class);
    localNewIntent.putExtra("BUNDLE_CMD", "QQApkSvc.pre_download_apk");
    localNewIntent.putExtra("BUNDLE_KEY_UIN", paramRockDownloaderTask.getRuntime().getLongAccountUin());
    localNewIntent.putExtra("BUNDLE_KEY_SOURCE", paramRockDownloaderTask.getDownloadInfo().getBusinessName());
    localNewIntent.putExtra("BUNDLE_KEY_SCENE", paramRockDownloaderTask.getDownloadInfo().getBusinessScene());
    localNewIntent.putExtra("BUNDLE_KEY_PKG_NAME", paramRockDownloaderTask.getDownloadInfo().getPackageName());
    localNewIntent.setObserver(new anvv(paramRockDownloaderTask));
    paramRockDownloaderTask.getRuntime().startServlet(localNewIntent);
    b(paramRockDownloaderTask, "0x800A1E8");
  }
  
  private static boolean a(Context paramContext, VFSFile paramVFSFile)
  {
    try
    {
      RandomAccessFile localRandomAccessFile = new RandomAccessFile(VFSFileOp.exportExternalPath(paramVFSFile.getAbsolutePath(), false), "rw");
      FileChannel localFileChannel = localRandomAccessFile.getChannel();
      MappedByteBuffer localMappedByteBuffer = localFileChannel.map(FileChannel.MapMode.READ_WRITE, 0L, 4L);
      int i = 0;
      for (;;)
      {
        int j;
        if (i < 4)
        {
          j = localMappedByteBuffer.get(i);
          if ((i != 0) || (j != 80)) {}
        }
        else
        {
          localMappedByteBuffer.flip();
          localMappedByteBuffer.force();
          localMappedByteBuffer.clear();
          localFileChannel.close();
          localRandomAccessFile.close();
          if (a(paramContext, VFSFileOp.exportExternalPath(paramVFSFile.getAbsolutePath(), false)) == null) {
            break;
          }
          return true;
        }
        localMappedByteBuffer.put(i, (byte)(j - 4));
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RockDownloader", 2, "getAPKFileInfo fail");
      }
      return false;
    }
    catch (FileNotFoundException paramContext)
    {
      paramContext.printStackTrace();
      return false;
    }
    catch (IOException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  private static boolean a(VFSFile paramVFSFile)
  {
    try
    {
      paramVFSFile = new RandomAccessFile(VFSFileOp.exportExternalPath(paramVFSFile.getAbsolutePath(), false), "rw");
      FileChannel localFileChannel = paramVFSFile.getChannel();
      MappedByteBuffer localMappedByteBuffer = localFileChannel.map(FileChannel.MapMode.READ_WRITE, 0L, 4L);
      int i = 0;
      while (i < 4)
      {
        localMappedByteBuffer.put(i, (byte)(localMappedByteBuffer.get(i) + 4));
        i += 1;
      }
      localMappedByteBuffer.flip();
      localMappedByteBuffer.force();
      localMappedByteBuffer.clear();
      localFileChannel.close();
      paramVFSFile.close();
      return true;
    }
    catch (FileNotFoundException paramVFSFile)
    {
      paramVFSFile = paramVFSFile;
      paramVFSFile.printStackTrace();
    }
    catch (IOException paramVFSFile)
    {
      paramVFSFile = paramVFSFile;
      paramVFSFile.printStackTrace();
    }
    finally {}
    return false;
  }
  
  public static boolean a(RockDownloaderTask paramRockDownloaderTask)
  {
    if (!paramRockDownloaderTask.getDownloadInfo().verifyDate(4)) {
      if (QLog.isColorLevel()) {
        QLog.d("RockDownloader", 2, "RockDownloadInfo verifyDate fail");
      }
    }
    VFSFile localVFSFile;
    do
    {
      return false;
      localVFSFile = new VFSFile(paramRockDownloaderTask.getDownloadInfo().localPath);
    } while ((!localVFSFile.exists()) || (!a(paramRockDownloaderTask.getRuntime().getApplication(), localVFSFile)));
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.putExtra("big_brother_source_key", paramRockDownloaderTask.getDownloadInfo().businessName);
    localIntent.setFlags(268435456);
    localIntent.setDataAndType(Uri.fromFile(new File(VFSFileOp.exportExternalPath(localVFSFile.getAbsolutePath(), false))), "application/vnd.android.package-archive");
    paramRockDownloaderTask.getRuntime().getApplication().startActivity(localIntent);
    b(paramRockDownloaderTask, "0x800A1E7");
    return true;
  }
  
  private static boolean a(RockDownloaderTask paramRockDownloaderTask, DownloadInfo paramDownloadInfo)
  {
    boolean bool2 = false;
    paramDownloadInfo = new VFSFile(paramDownloadInfo.l);
    paramRockDownloaderTask = new VFSFile(paramRockDownloaderTask.getDownloadInfo().getLocalPath());
    boolean bool1 = bool2;
    if (paramDownloadInfo.exists())
    {
      bool1 = bool2;
      if (a(paramDownloadInfo))
      {
        if (paramRockDownloaderTask.exists()) {
          break label62;
        }
        bool1 = paramDownloadInfo.renameTo(paramRockDownloaderTask);
      }
    }
    label62:
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!paramRockDownloaderTask.delete());
      bool1 = bool2;
    } while (!paramDownloadInfo.renameTo(paramRockDownloaderTask));
    return true;
  }
  
  public static void b(RockDownloaderTask paramRockDownloaderTask)
  {
    if (!paramRockDownloaderTask.getDownloadInfo().verifyDate(2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RockDownloader", 2, "RockDownloadInfo verifyDate fail");
      }
      if (paramRockDownloaderTask.getQueryAPKListener() != null) {
        paramRockDownloaderTask.getQueryAPKListener().a(paramRockDownloaderTask.getDownloadInfo(), "RockDownloadInfo verifyDate fail", 10001);
      }
      return;
    }
    ThreadManagerV2.executeOnFileThread(new RockDownloader.2(paramRockDownloaderTask));
  }
  
  private static void b(RockDownloaderTask paramRockDownloaderTask, DownloadInfo paramDownloadInfo, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RockDownloader", 2, new Object[] { "onDownloadFinish: info=", paramDownloadInfo });
    }
    Object localObject = a(paramRockDownloaderTask.getRuntime().getApplication(), paramDownloadInfo.l);
    boolean bool1;
    boolean bool2;
    if ((localObject != null) && (paramRockDownloaderTask.getDownloadInfo().getPackageName().equals(((RockDownloadInfo)localObject).getPackageName())))
    {
      paramRockDownloaderTask.getDownloadInfo().setRealVersionCode(((RockDownloadInfo)localObject).getRealVersionCode());
      bool1 = true;
      if (!bool1) {
        break label361;
      }
      paramRockDownloaderTask.getDownloadInfo().setLocalPath(a(paramRockDownloaderTask.getDownloadInfo()));
      bool2 = a(paramRockDownloaderTask, paramDownloadInfo);
      if ((!bool2) && (paramBoolean)) {
        paramRockDownloaderTask.getRockDownloadListener().onDownloadFail(paramRockDownloaderTask.getDownloadInfo(), "隐匿APK失败", 10007);
      }
      b(paramRockDownloaderTask, "0x800A1E6");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RockDownloader", 2, new Object[] { "CheckState=", Boolean.valueOf(bool1), " hiddenState=", Boolean.valueOf(bool2) });
      }
      if ((bool1) && (bool2))
      {
        e(paramRockDownloaderTask);
        a().b(paramRockDownloaderTask.getDownloadInfo());
        if (paramBoolean) {
          paramRockDownloaderTask.getRockDownloadListener().onDownloadSuccess(paramRockDownloaderTask.getDownloadInfo());
        }
        localObject = (DownloadInfo)bfkr.a().a().remove(paramDownloadInfo.jdField_b_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("RockDownloader", 2, new Object[] { "removedDownload=", localObject });
        }
        bfkp.a().a(paramDownloadInfo.jdField_b_of_type_JavaLangString);
        b(paramRockDownloaderTask, "0x800A1E5");
      }
      if (paramBoolean) {
        paramRockDownloaderTask.getRockDownloadListener().onDownloadFinish(paramRockDownloaderTask.getDownloadInfo());
      }
      return;
      if (paramDownloadInfo.l != null)
      {
        localObject = new VFSFile(paramDownloadInfo.l);
        if (((VFSFile)localObject).exists()) {
          ((VFSFile)localObject).delete();
        }
      }
      if (paramBoolean) {
        paramRockDownloaderTask.getRockDownloadListener().onDownloadFail(paramRockDownloaderTask.getDownloadInfo(), "解析APK失败或包名不匹配", 10008);
      }
      b(paramRockDownloaderTask, "0x800A1E6");
      bool1 = false;
      break;
      label361:
      bool2 = false;
    }
  }
  
  private static void b(@NonNull RockDownloaderTask paramRockDownloaderTask, String paramString)
  {
    Object localObject = paramRockDownloaderTask.getDownloadInfo();
    StringBuilder localStringBuilder = new StringBuilder();
    HashMap localHashMap = new HashMap();
    if (localObject != null)
    {
      localStringBuilder.append(((RockDownloadInfo)localObject).getBusinessName()).append("&").append(((RockDownloadInfo)localObject).getBusinessScene()).append("&").append(((RockDownloadInfo)localObject).getPackageName()).append("&").append(bhsp.a("0"));
      localHashMap.put("BusinessName", ((RockDownloadInfo)localObject).getBusinessName());
      localHashMap.put("BusinessScene", ((RockDownloadInfo)localObject).getBusinessScene());
      localHashMap.put("PackageName", ((RockDownloadInfo)localObject).getPackageName());
      localHashMap.put("IMEI", bhsp.a("0"));
      localHashMap.put("reportID", paramString);
    }
    try
    {
      if ((paramRockDownloaderTask.getRuntime() instanceof QQAppInterface))
      {
        azqs.b((QQAppInterface)paramRockDownloaderTask.getRuntime(), "dc00898", "", ((QQAppInterface)paramRockDownloaderTask.getRuntime()).c(), paramString, paramString, 1, 1, "", "", localStringBuilder.toString(), "");
        azri.a(((QQAppInterface)paramRockDownloaderTask.getRuntime()).getApp()).a(((QQAppInterface)paramRockDownloaderTask.getRuntime()).c(), "RockDownloader", true, 0L, 0L, localHashMap, "");
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        paramRockDownloaderTask = new StringBuilder();
        paramString = localHashMap.keySet().iterator();
        while (paramString.hasNext())
        {
          localObject = (String)paramString.next();
          paramRockDownloaderTask.append((String)localObject).append("=").append((String)localHashMap.get(localObject)).append("\n");
        }
        if (paramRockDownloaderTask.getRuntime() == null) {
          break;
        }
        azqs.b(null, "dc00898", "", paramRockDownloaderTask.getRuntime().getAccount(), paramString, paramString, 1, 1, "", "", localStringBuilder.toString(), "");
        azri.a(paramRockDownloaderTask.getRuntime().getApplication()).a(paramRockDownloaderTask.getRuntime().getAccount(), "RockDownloader", true, 0L, 0L, localHashMap, "");
      }
    }
    catch (Throwable paramRockDownloaderTask)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("RockDownloader", 2, paramRockDownloaderTask, new Object[0]);
          continue;
          azqs.b(null, "dc00898", "", "", paramString, paramString, 1, 1, "", "", localStringBuilder.toString(), "");
          azri.a(BaseApplicationImpl.context).a("", "RockDownloader", true, 0L, 0L, localHashMap, "");
        }
      }
      QLog.d("RockDownloader", 2, paramRockDownloaderTask.toString());
    }
  }
  
  public static boolean b(RockDownloaderTask paramRockDownloaderTask)
  {
    if (!paramRockDownloaderTask.getDownloadInfo().verifyDate(3)) {
      if (QLog.isColorLevel()) {
        QLog.d("RockDownloader", 2, "RockDownloadInfo verifyDate fail");
      }
    }
    VFSFile localVFSFile;
    do
    {
      return false;
      localVFSFile = new VFSFile(paramRockDownloaderTask.getDownloadInfo().localPath);
    } while (!localVFSFile.exists());
    a().b(paramRockDownloaderTask.getDownloadInfo());
    return localVFSFile.delete();
  }
  
  private static boolean b(ServerApi.RspPreDownloadRecmd paramRspPreDownloadRecmd, RockDownloaderTask paramRockDownloaderTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RockDownloader", 2, new Object[] { " download_url.", paramRspPreDownloadRecmd.download_url.get(), " start_time.", Integer.valueOf(paramRspPreDownloadRecmd.start_time.get()), " end_time.", Integer.valueOf(paramRspPreDownloadRecmd.end_time.get()), " interval.", Integer.valueOf(paramRspPreDownloadRecmd.interval.get()), " quota_num.", Integer.valueOf(paramRspPreDownloadRecmd.quota_num.get()), " daily_num.", Integer.valueOf(paramRspPreDownloadRecmd.daily_num.get()) });
    }
    long l = System.currentTimeMillis() / 1000L;
    if ((l < paramRspPreDownloadRecmd.start_time.get()) || (l > paramRspPreDownloadRecmd.end_time.get())) {
      if (QLog.isColorLevel()) {
        QLog.d("RockDownloader", 2, "checkDownloadPermission Task Time Error");
      }
    }
    do
    {
      do
      {
        return false;
        paramRockDownloaderTask.getDownloadInfo().startTime = paramRspPreDownloadRecmd.start_time.get();
        paramRockDownloaderTask.getDownloadInfo().endTime = paramRspPreDownloadRecmd.end_time.get();
        if (!paramRockDownloaderTask.getDownloadInfo().getDownloadURL().equals(paramRspPreDownloadRecmd.download_url.get()))
        {
          paramRockDownloaderTask.getDownloadInfo().setDownloadURL(paramRspPreDownloadRecmd.download_url.get());
          if (QLog.isColorLevel()) {
            QLog.d("RockDownloader", 2, "checkDownloadPermission URL Error");
          }
        }
        paramRockDownloaderTask = paramRockDownloaderTask.getRuntime().getApplication().getSharedPreferences("RockDownloader", 4);
        if ((System.currentTimeMillis() - paramRockDownloaderTask.getLong("LAST_TIME", 0L)) / 1000L >= paramRspPreDownloadRecmd.interval.get()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("RockDownloader", 2, "checkDownloadPermission interval Time Error");
      return false;
      String str = paramRockDownloaderTask.getString("DATE", "");
      if ((TextUtils.isEmpty(str)) || (!str.equals(DateFormat.getDateInstance().format(new Date()))) || (paramRockDownloaderTask.getInt("TIME", 0) <= paramRspPreDownloadRecmd.daily_num.get())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("RockDownloader", 2, "checkDownloadPermission daily number Error");
    return false;
    return true;
  }
  
  private static void d(RockDownloaderTask paramRockDownloaderTask)
  {
    DownloadInfo localDownloadInfo1 = new DownloadInfo();
    paramRockDownloaderTask.getDownloadInfo().setLocalPath(a(paramRockDownloaderTask.getDownloadInfo()));
    localDownloadInfo1.l = paramRockDownloaderTask.getDownloadInfo().getLocalPath();
    localDownloadInfo1.jdField_d_of_type_JavaLangString = paramRockDownloaderTask.getDownloadInfo().getDownloadURL();
    localDownloadInfo1.e = paramRockDownloaderTask.getDownloadInfo().getPackageName();
    localDownloadInfo1.m = paramRockDownloaderTask.getDownloadInfo().getBusinessName();
    localDownloadInfo1.jdField_b_of_type_Boolean = true;
    localDownloadInfo1.jdField_d_of_type_Boolean = false;
    localDownloadInfo1.a = false;
    localDownloadInfo1.h = paramRockDownloaderTask.getDownloadInfo().getBusinessName();
    if (paramRockDownloaderTask.getRockDownloadListener() != null) {}
    anvw localanvw;
    for (boolean bool = true;; bool = false)
    {
      localanvw = new anvw(paramRockDownloaderTask, bool);
      Iterator localIterator = bfkr.a().a().values().iterator();
      DownloadInfo localDownloadInfo2;
      do
      {
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localDownloadInfo2 = (DownloadInfo)localIterator.next();
        } while ((TextUtils.isEmpty(localDownloadInfo2.jdField_d_of_type_JavaLangString)) || (!localDownloadInfo2.jdField_d_of_type_JavaLangString.equals(localDownloadInfo1.jdField_d_of_type_JavaLangString)));
        if (QLog.isColorLevel()) {
          QLog.d("RockDownloader", 2, new Object[] { "find exist task, downloadInfo.urlStr=", localDownloadInfo2.jdField_d_of_type_JavaLangString, " downloadInfo.progress=", Integer.valueOf(localDownloadInfo2.f), " downloadInfo.filePath=", localDownloadInfo2.l });
        }
      } while (localDownloadInfo2.f == 100);
      bfkr.a().b(localDownloadInfo1);
      if (bool)
      {
        paramRockDownloaderTask.getRockDownloadListener().onDownloadFail(paramRockDownloaderTask.getDownloadInfo(), alud.a(2131713883), 10011);
        paramRockDownloaderTask.getRockDownloadListener().onDownloadFinish(paramRockDownloaderTask.getDownloadInfo());
      }
      return;
    }
    bfkr.a().a(localanvw);
    bfkr.a().b(localDownloadInfo1);
  }
  
  private static void e(RockDownloaderTask paramRockDownloaderTask)
  {
    Object localObject = new NewIntent(paramRockDownloaderTask.getRuntime().getApplication(), anwa.class);
    ((NewIntent)localObject).putExtra("BUNDLE_CMD", "QQApkSvc.update_download_count");
    try
    {
      ((NewIntent)localObject).putExtra("BUNDLE_KEY_UIN", Long.parseLong(paramRockDownloaderTask.getRuntime().getAccount()));
      ((NewIntent)localObject).putExtra("BUNDLE_KEY_SOURCE", paramRockDownloaderTask.getDownloadInfo().getBusinessName());
      ((NewIntent)localObject).putExtra("BUNDLE_KEY_SCENE", paramRockDownloaderTask.getDownloadInfo().getBusinessScene());
      ((NewIntent)localObject).putExtra("BUNDLE_KEY_PKG_NAME", paramRockDownloaderTask.getDownloadInfo().getPackageName());
      paramRockDownloaderTask.getRuntime().startServlet((NewIntent)localObject);
      paramRockDownloaderTask = paramRockDownloaderTask.getRuntime().getApplication().getSharedPreferences("RockDownloader", 4);
      localObject = paramRockDownloaderTask.edit();
      String str = paramRockDownloaderTask.getString("DATE", "");
      if ((!TextUtils.isEmpty(str)) && (str.equals(DateFormat.getDateInstance().format(new Date()))))
      {
        ((SharedPreferences.Editor)localObject).putInt("TIME", paramRockDownloaderTask.getInt("TIME", 0) + 1);
        ((SharedPreferences.Editor)localObject).putLong("LAST_TIME", System.currentTimeMillis());
        ((SharedPreferences.Editor)localObject).apply();
        return;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("RockDownloader", 2, localNumberFormatException, new Object[0]);
          ((NewIntent)localObject).putExtra("BUNDLE_KEY_UIN", 0);
          continue;
          ((SharedPreferences.Editor)localObject).putString("DATA", DateFormat.getDateInstance().format(new Date()));
          ((SharedPreferences.Editor)localObject).putInt("TIME", 1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anvu
 * JD-Core Version:    0.7.0.1
 */