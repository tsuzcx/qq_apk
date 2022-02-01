import android.content.BroadcastReceiver;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanageraux.core.UniformDownloadMgr.1;
import com.tencent.mobileqq.filemanageraux.core.UniformDownloadMgr.10;
import com.tencent.mobileqq.filemanageraux.core.UniformDownloadMgr.11;
import com.tencent.mobileqq.filemanageraux.core.UniformDownloadMgr.12;
import com.tencent.mobileqq.filemanageraux.core.UniformDownloadMgr.13;
import com.tencent.mobileqq.filemanageraux.core.UniformDownloadMgr.14;
import com.tencent.mobileqq.filemanageraux.core.UniformDownloadMgr.15;
import com.tencent.mobileqq.filemanageraux.core.UniformDownloadMgr.2;
import com.tencent.mobileqq.filemanageraux.core.UniformDownloadMgr.3;
import com.tencent.mobileqq.filemanageraux.core.UniformDownloadMgr.6;
import com.tencent.mobileqq.filemanageraux.core.UniformDownloadMgr.7;
import com.tencent.mobileqq.filemanageraux.core.UniformDownloadMgr.8;
import com.tencent.mobileqq.filemanageraux.core.UniformDownloadMgr.9;
import com.tencent.mobileqq.filemanageraux.core.UniformDownloadPkgInstallReceiver;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class auht
{
  private static auht jdField_a_of_type_Auht;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  public QQAppInterface a;
  private List<auia> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<String, auhy> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  private Map<String, aulc> jdField_b_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_b_of_type_Boolean = true;
  
  private auht()
  {
    try
    {
      UniformDownloadPkgInstallReceiver.a(BaseApplication.getContext());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private int a(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      auhy localauhy = (auhy)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
      if (localauhy != null)
      {
        aulc localaulc = a(paramString);
        if ((localauhy.jdField_a_of_type_Aukz != null) && (localaulc != null)) {
          localauhy.jdField_a_of_type_Aukz.a(localaulc);
        }
      }
      int i = this.jdField_a_of_type_JavaUtilMap.size();
      QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] delDownloadInst.. total[" + this.jdField_a_of_type_JavaUtilMap.size() + "] del it. url[" + paramString + "]");
      return i;
    }
  }
  
  private int a(String paramString, Bundle paramBundle)
  {
    int j = 0;
    int i;
    if ((paramString == null) || (paramBundle == null)) {
      i = -1;
    }
    Object localObject1;
    String str;
    long l;
    label201:
    do
    {
      return i;
      localObject1 = paramBundle.getString("_filename_from_dlg");
      try
      {
        localObject2 = URLDecoder.decode((String)localObject1, "utf-8");
        localObject1 = localObject2;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          Object localObject2;
          localUnsupportedEncodingException.printStackTrace();
          continue;
          paramBundle = localUnsupportedEncodingException;
          if (localUnsupportedEncodingException == null) {
            paramBundle = new Bundle();
          }
        }
        int k = localUnsupportedEncodingException.jdField_a_of_type_Aukz.f();
        QLog.w("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>inRStartDownload. instance is exist.status:" + k + " may be do something. url:" + paramString);
        i = j;
        switch (k)
        {
        }
      }
      g(paramString, paramBundle);
      str = paramBundle.getString("_notify_name_dialog", "");
      l = paramBundle.getLong("_filesize_from_dlg");
      localObject2 = paramBundle.getBundle("_user_data");
      if ((localObject2 == null) && (paramBundle.containsKey("big_brother_source_key")))
      {
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("big_brother_source_key", paramBundle.getString("big_brother_source_key"));
        paramBundle = (Bundle)localObject2;
        localObject2 = a(paramString);
        if ((localObject2 != null) && ((localObject2 == null) || (((auhy)localObject2).jdField_a_of_type_Aukz != null))) {
          break label201;
        }
        QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>inRStartDownload. run a new download. url:" + paramString);
        return a(paramString, (String)localObject1, l, str, paramBundle, -1, false);
      }
      return -4;
      return -3;
      paramString = a(paramString);
      i = j;
    } while (paramString == null);
    localUnsupportedEncodingException.jdField_a_of_type_Aukz.a(paramString);
    localUnsupportedEncodingException.jdField_a_of_type_Aukz.a(paramString, false);
    return 0;
    d(paramString);
    return 0;
    a(paramString);
    a(paramString, (String)localObject1, l, str, paramBundle, -1, false);
    return 0;
    d(paramString);
    return 0;
    a(paramString);
    return 0;
  }
  
  private int a(String paramString1, String paramString2, long paramLong, String paramString3, Bundle paramBundle, int paramInt, boolean paramBoolean)
  {
    if ((paramString1 == null) || (paramString2 == null))
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] createAndStartDownloadTask.. param = null");
      return -1;
    }
    long l = a();
    aukz localaukz = new aukz(l, paramString1, paramBundle);
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("_PARAM_FILENAME", paramString2);
    ((Bundle)localObject).putLong("_PARAM_FILESIZE", paramLong);
    ((Bundle)localObject).putBundle("_PARAM_USER_DATA", paramBundle);
    localaukz.a((Bundle)localObject);
    if (1 == localaukz.g())
    {
      QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL][" + l + " - NEW_ID]. >>> create UniformDownloader.using appbaby. url: " + paramString1);
      localaukz.a(new auhw(this), true);
      localObject = a(paramString1);
      if (localObject != null) {
        localaukz.a((aulc)localObject, false);
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("_notify_param_Filename", paramString2);
      if (TextUtils.isEmpty(paramString3)) {
        break label424;
      }
      ((Bundle)localObject).putString("_notify_param_ContentTitle", paramString3);
      label192:
      ((Bundle)localObject).putString("_notify_param_Url", paramString1);
      ((Bundle)localObject).putLong("_notify_param_Filesize", paramLong);
      ((Bundle)localObject).putBundle("_notify_param_userdata", paramBundle);
      paramInt = auib.a().a(localaukz, (Bundle)localObject, l, paramInt);
      a(paramString1, new auhy(this, null, localaukz.g(), localaukz, l, paramInt));
      if (!paramBoolean) {
        break label435;
      }
      QLog.w("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL][" + l + "] preHadStarted. url:" + paramString1);
      localaukz.a(true);
    }
    for (;;)
    {
      if (b(paramString1) == 0)
      {
        localaukz.a(true);
        auib.a().b(paramInt, (Bundle)localObject);
      }
      this.jdField_b_of_type_Boolean = false;
      return 0;
      if (2 == localaukz.g())
      {
        QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL][" + l + " - NEW_ID]. >>>create UniformDownloader.using common. url:" + paramString1);
        break;
      }
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL][" + l + " - NEW_ID] create UniformDownloader failed. url:" + paramString1);
      return -2;
      label424:
      ((Bundle)localObject).putString("_notify_param_ContentTitle", paramString2);
      break label192;
      label435:
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        if (1 == localaukz.g()) {
          bdlq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "Start_download_2-0_3-0");
        } else if (2 == localaukz.g()) {
          bdlq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "Start_download_2-0_3-1");
        }
      }
    }
  }
  
  private long a()
  {
    return (int)(System.currentTimeMillis() / 1000L) << 32 | Math.abs(new Random().nextInt());
  }
  
  public static auht a()
  {
    try
    {
      if (jdField_a_of_type_Auht == null)
      {
        QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] UniformDownloadMgr.getInstance.create");
        jdField_a_of_type_Auht = new auht();
      }
      auht localauht = jdField_a_of_type_Auht;
      return localauht;
    }
    finally {}
  }
  
  private auhy a(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramString = (auhy)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      return paramString;
    }
  }
  
  private auhz a(String paramString)
  {
    if (paramString == null)
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] rBobjectOfString err, str=null");
      return null;
    }
    String[] arrayOfString = paramString.split("\\^");
    if (arrayOfString.length < 4)
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] rBobjectOfString err,l=" + arrayOfString.length + " str=" + paramString);
      return null;
    }
    paramString = new auhz(this);
    paramString.jdField_a_of_type_Int = Integer.parseInt(arrayOfString[0]);
    paramString.jdField_a_of_type_JavaLangString = arrayOfString[1];
    paramString.jdField_a_of_type_Long = Long.parseLong(arrayOfString[2]);
    paramString.jdField_a_of_type_Boolean = Boolean.parseBoolean(arrayOfString[3]);
    if (arrayOfString.length > 4)
    {
      paramString.b = arrayOfString[4];
      return paramString;
    }
    paramString.b = paramString.jdField_a_of_type_JavaLangString;
    return paramString;
  }
  
  private auia a(String paramString)
  {
    if (paramString == null)
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] sucInfoOfString err, str=null");
      return null;
    }
    String[] arrayOfString = paramString.split("\\^");
    if (arrayOfString.length < 2)
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] sucInfoOfString err,l=" + arrayOfString.length + " str=" + paramString);
      return null;
    }
    return new auia(arrayOfString[0], Integer.parseInt(arrayOfString[1]));
  }
  
  private aulc a(String paramString)
  {
    if (paramString == null) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      try
      {
        paramString = (aulc)this.jdField_b_of_type_JavaUtilMap.get(paramString);
      }
      finally {}
    }
  }
  
  private String a(auhz paramauhz)
  {
    if (paramauhz == null)
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] stringOfRbObject err, obj=null");
      return null;
    }
    return String.valueOf(paramauhz.jdField_a_of_type_Int) + "^" + paramauhz.jdField_a_of_type_JavaLangString + "^" + String.valueOf(paramauhz.jdField_a_of_type_Long) + "^" + String.valueOf(paramauhz.jdField_a_of_type_Boolean) + "^" + paramauhz.b;
  }
  
  private String a(auia paramauia)
  {
    if (paramauia == null)
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] stringOfSucInfo err, obj=null");
      return null;
    }
    return String.valueOf(paramauia.jdField_a_of_type_JavaLangString) + "^" + String.valueOf(paramauia.jdField_a_of_type_Int);
  }
  
  private void a(String paramString, aulc paramaulc)
  {
    if ((paramString != null) && (paramaulc != null)) {}
    try
    {
      this.jdField_b_of_type_JavaUtilMap.put(paramString, paramaulc);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private boolean a(String paramString, auhy paramauhy)
  {
    if ((paramString == null) || (paramauhy == null))
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] addDownloadInst.. param null");
      return false;
    }
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
      {
        QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] url[" + paramString + "] exsited! total[" + this.jdField_a_of_type_JavaUtilMap.size() + "]");
        return false;
      }
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramString, paramauhy);
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] addDownloadInst.. total[" + this.jdField_a_of_type_JavaUtilMap.size() + "] add it. url[" + paramString + "]");
    return true;
  }
  
  private int b(String paramString)
  {
    int i = 0;
    if ((NetworkUtil.isNetSupport(BaseApplication.getContext())) && (!auea.a())) {}
    for (int m = 2;; m = 1)
    {
      QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] inPTryStartNextDownload. togetherDownloadMaxCount=" + m);
      Object localObject2 = new ArrayList();
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        if (this.jdField_a_of_type_JavaUtilMap.size() <= 0) {
          break label532;
        }
        Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
        j = 0;
        i = 0;
        if (localIterator.hasNext())
        {
          auhy localauhy = (auhy)((Map.Entry)localIterator.next()).getValue();
          int n = j;
          k = i;
          if (localauhy.jdField_a_of_type_Aukz != null)
          {
            n = j;
            k = i;
            if (localauhy.jdField_a_of_type_Aukz.b())
            {
              i += 1;
              n = j;
              k = i;
              if (paramString != null)
              {
                n = j;
                k = i;
                if (paramString.equalsIgnoreCase(localauhy.jdField_a_of_type_JavaLangString))
                {
                  QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] inPTryStartNextDownload.. download is runing. traceUrl:" + paramString);
                  n = 1;
                  k = i;
                }
              }
            }
          }
          ((List)localObject2).add(localauhy);
          j = n;
          i = k;
        }
      }
      int k = j;
      int j = i;
      i = k;
      for (;;)
      {
        if (j < m)
        {
          ??? = ((List)localObject2).iterator();
          k = i;
          if (((Iterator)???).hasNext())
          {
            localObject2 = (auhy)((Iterator)???).next();
            k = j;
            if (((auhy)localObject2).jdField_a_of_type_Aukz == null) {
              break label526;
            }
            k = j;
            if (!((auhy)localObject2).jdField_a_of_type_Aukz.a()) {
              break label526;
            }
            if (j < m)
            {
              QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>> Happy. start a download task, url:[" + ((auhy)localObject2).jdField_a_of_type_JavaLangString + "]");
              j += 1;
              ((auhy)localObject2).jdField_a_of_type_Aukz.a();
              k = j;
              if (paramString == null) {
                break label526;
              }
              k = j;
              if (!paramString.equalsIgnoreCase(((auhy)localObject2).jdField_a_of_type_JavaLangString)) {
                break label526;
              }
              QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] inPTryStartNextDownload.. download is started. traceUrl:" + paramString);
              i = 2;
            }
          }
        }
        for (;;)
        {
          break;
          QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] inPTryStartNextDownload.. total[" + this.jdField_a_of_type_JavaUtilMap.size() + "] the task of downloading is overload,other need waiting... 1");
          for (k = i;; k = i)
          {
            f();
            return k;
            QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] inPTrystartNextDownload.. total[" + this.jdField_a_of_type_JavaUtilMap.size() + "] the task of downloading is overload,other need waiting... 2");
          }
          label526:
          j = k;
        }
        label532:
        j = 0;
      }
    }
  }
  
  private int b(String paramString, Bundle paramBundle)
  {
    if ((paramString == null) || (paramBundle == null))
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] inRPauseDownload. param error!!");
      return -1;
    }
    int i = paramBundle.getInt("_notify_param_Id");
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>inRPauseDownload. URL:" + paramString + " nofiyid:" + i);
    if (-1 == c(paramString))
    {
      auku.a(paramString, new auhx(this));
      auib.a().a(i, (Bundle)paramBundle.clone());
      b(null);
    }
    return 0;
  }
  
  private aulc b(String paramString)
  {
    try
    {
      paramString = (aulc)this.jdField_b_of_type_JavaUtilMap.remove(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private int c(String paramString)
  {
    auhy localauhy = a(paramString);
    if (localauhy != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        if (localauhy.jdField_a_of_type_Int != 1) {
          break label71;
        }
        bdlq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "Stop_download_2-2_3-0");
      }
      for (;;)
      {
        if (localauhy.jdField_a_of_type_Aukz != null) {
          localauhy.jdField_a_of_type_Aukz.b();
        }
        b(null);
        return 0;
        label71:
        bdlq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "Stop_download_2-2_3-1");
      }
    }
    QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] inPPauseDownload.. inst not exsited. url:" + paramString);
    return -1;
  }
  
  private int c(String paramString, Bundle paramBundle)
  {
    if ((paramString == null) || (paramBundle == null))
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] inRResumeDownload. param error!!");
      return -1;
    }
    int i = paramBundle.getInt("_notify_param_Id");
    String str1 = paramBundle.getString("_notify_param_Filename");
    String str2 = paramBundle.getString("_notify_param_ContentTitle", "");
    long l = paramBundle.getLong("_notify_param_Filesize");
    paramBundle = paramBundle.getBundle("_notify_param_userdata");
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>inRResumeDownload. URL:" + paramString + " nofiyid:" + i);
    if (-1 == d(paramString)) {
      a(paramString, str1, l, str2, paramBundle, i, true);
    }
    return 0;
  }
  
  private int d(String paramString)
  {
    auhy localauhy = a(paramString);
    if (localauhy != null)
    {
      if (localauhy.jdField_a_of_type_Aukz != null)
      {
        paramString = a(paramString);
        if (paramString != null) {
          localauhy.jdField_a_of_type_Aukz.a(paramString, false);
        }
        localauhy.jdField_a_of_type_Aukz.c();
      }
      b(null);
      return 0;
    }
    QLog.w("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] inPResumeDownload.. inst not exsited. url:" + paramString);
    return -1;
  }
  
  private int d(String paramString, Bundle paramBundle)
  {
    return c(paramString, paramBundle);
  }
  
  private int e(String paramString)
  {
    auhy localauhy = a(paramString);
    if (localauhy != null)
    {
      if (localauhy.jdField_a_of_type_Aukz != null) {
        localauhy.jdField_a_of_type_Aukz.d();
      }
      return 0;
    }
    QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] inPStopDownload.. inst not exsited. url:" + paramString);
    return -1;
  }
  
  private void f() {}
  
  private void g()
  {
    ThreadManager.getSubThreadHandler().post(new UniformDownloadMgr.6(this));
  }
  
  private void g(String paramString, Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UniformDownloadEvent", 2, "params is null");
      }
      return;
    }
    bdmt.a().addDownloadURL(paramString);
    HashMap localHashMap = new HashMap();
    localHashMap.put("url", paramString);
    localHashMap.put("NetworkType", NetworkUtil.getNetworkType(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()) + "");
    if (bjjp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) {}
    Object localObject2;
    for (Object localObject1 = "1";; localObject1 = "0")
    {
      localHashMap.put("isForeground", localObject1);
      localHashMap.put("reportVia", "1");
      localObject1 = new Throwable().getStackTrace();
      localObject2 = new StringBuilder();
      int i = 1;
      while (i < localObject1.length)
      {
        ((StringBuilder)localObject2).append(localObject1[i].toString());
        i += 1;
      }
    }
    if (((StringBuilder)localObject2).length() < 950)
    {
      localHashMap.put("Stack", ((StringBuilder)localObject2).toString());
      label208:
      localHashMap.put("_filesize_from_dlg", paramBundle.getLong("_filesize_from_dlg") + "");
      localObject1 = paramBundle.getString("_filename_from_dlg");
      localHashMap.put("_filename_from_dlg", localObject1);
      if (((localObject1 == null) || (!((String)localObject1).endsWith(".apk"))) && (!paramBundle.getString("FILE_MIME_TYPE", "").equals("application/vnd.android.package-archive"))) {
        break label720;
      }
      localHashMap.put("isAPK", "1");
      label304:
      localHashMap.put("ReferURL", paramBundle.getString("param_refer_url", ""));
      paramBundle = paramBundle.getString("DOWNLOAD_BIG_BROTHER_SOURCE");
      paramString = new StringBuilder(paramString);
      paramString.append("|").append((String)localHashMap.get("NetworkType")).append("|").append(paramBundle).append("|").append((String)localObject1).append("|").append((String)localHashMap.get("_filesize_from_dlg")).append("|").append((String)localHashMap.get("ReferURL"));
    }
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramBundle)) {
          continue;
        }
        StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "UniformDownloadEvent_NO_SOURCE", true, 0L, 0L, localHashMap, "");
        paramBundle = (String)localHashMap.get("isForeground");
        localObject1 = (String)localHashMap.get("isAPK");
        localObject2 = paramString.toString();
        localStringBuilder = new StringBuilder().append((String)localHashMap.get("Stack"));
        if (!localHashMap.containsKey("Stack1")) {
          continue;
        }
        paramString = (String)localHashMap.get("Stack1");
        bdla.b(null, "dc00898", "", "", "0X800A003", "0X800A003", 0, 0, paramBundle, (String)localObject1, (String)localObject2, paramString);
      }
      catch (Throwable paramString)
      {
        StringBuilder localStringBuilder;
        label720:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("UniformDownloadMgr<FileAssistant>", 2, paramString.toString());
        continue;
        paramString = "";
        continue;
        QLog.d("UniformDownloadEvent", 2, paramString.toString());
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      paramString = new StringBuilder();
      paramBundle = localHashMap.keySet().iterator();
      if (!paramBundle.hasNext()) {
        continue;
      }
      localObject1 = (String)paramBundle.next();
      paramString.append((String)localObject1).append("=").append((String)localHashMap.get(localObject1)).append("\n");
      continue;
      localHashMap.put("Stack", ((StringBuilder)localObject2).substring(0, 950));
      if (((StringBuilder)localObject2).length() < 1901)
      {
        localHashMap.put("Stack1", ((StringBuilder)localObject2).substring(950));
        break label208;
      }
      localHashMap.put("Stack1", ((StringBuilder)localObject2).substring(950, 1900));
      break label208;
      localHashMap.put("isAPK", "0");
      break label304;
      paramString = "";
      continue;
      localHashMap.put("DOWNLOAD_BIG_BROTHER_SOURCE", paramBundle);
      StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "UniformDownloadEvent", true, 0L, 0L, localHashMap, "");
      paramBundle = (String)localHashMap.get("isForeground");
      localObject1 = (String)localHashMap.get("isAPK");
      localObject2 = paramString.toString();
      localStringBuilder = new StringBuilder().append((String)localHashMap.get("Stack"));
      if (!localHashMap.containsKey("Stack1")) {
        continue;
      }
      paramString = (String)localHashMap.get("Stack1");
      bdla.b(null, "dc00898", "", "", "0X800A002", "0X800A002", 0, 0, paramBundle, (String)localObject1, (String)localObject2, paramString);
    }
  }
  
  private void h()
  {
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] pauseSlienceRuningGenDownloadOfOldApp ...");
    ThreadManager.getSubThreadHandler().post(new UniformDownloadMgr.14(this));
  }
  
  private void i()
  {
    ThreadManager.getSubThreadHandler().post(new UniformDownloadMgr.15(this));
  }
  
  private void j()
  {
    for (;;)
    {
      try
      {
        QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] initSucDownloadInfo...");
        ??? = BaseApplication.getContext().getSharedPreferences("download_suc_info", 0).getAll();
        if (??? != null) {
          QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] initSucDownloadInfo, size:[" + ((Map)???).size() + "]");
        }
        if ((??? != null) && (((Map)???).size() > 0))
        {
          Iterator localIterator = ((Map)???).entrySet().iterator();
          if (localIterator.hasNext())
          {
            auia localauia = a((String)((Map.Entry)localIterator.next()).getKey());
            if (localauia == null) {
              break label207;
            }
            QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] initSucDownloadInfo, pkgName:[" + localauia.jdField_a_of_type_JavaLangString + "]] nId:[" + localauia.jdField_a_of_type_Int + "] ");
            synchronized (this.jdField_a_of_type_JavaUtilList)
            {
              this.jdField_a_of_type_JavaUtilList.add(localauia);
            }
          }
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      label207:
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] initSucDownloadInfo, value error. ");
    }
  }
  
  /* Error */
  public long a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 6
    //   3: iload_2
    //   4: ifgt +9 -> 13
    //   7: lconst_0
    //   8: lstore 8
    //   10: lload 8
    //   12: lreturn
    //   13: iconst_0
    //   14: istore_3
    //   15: iconst_0
    //   16: istore 5
    //   18: iconst_0
    //   19: istore 4
    //   21: aconst_null
    //   22: astore 10
    //   24: aconst_null
    //   25: astore 12
    //   27: new 744	java/net/URL
    //   30: dup
    //   31: aload_1
    //   32: invokespecial 745	java/net/URL:<init>	(Ljava/lang/String;)V
    //   35: invokevirtual 749	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   38: checkcast 751	java/net/HttpURLConnection
    //   41: astore 11
    //   43: iload 5
    //   45: istore_3
    //   46: aload 11
    //   48: invokevirtual 754	java/net/HttpURLConnection:getResponseCode	()I
    //   51: sipush 302
    //   54: if_icmpne +58 -> 112
    //   57: iconst_1
    //   58: istore_3
    //   59: iconst_1
    //   60: istore 4
    //   62: aload 11
    //   64: ldc_w 756
    //   67: invokevirtual 759	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   70: astore_1
    //   71: iload 4
    //   73: istore_3
    //   74: aload 11
    //   76: ifnull +132 -> 208
    //   79: aload 11
    //   81: invokevirtual 762	java/net/HttpURLConnection:disconnect	()V
    //   84: lload 6
    //   86: lstore 8
    //   88: iload_3
    //   89: ifeq -79 -> 10
    //   92: lload 6
    //   94: lstore 8
    //   96: aload_1
    //   97: invokestatic 237	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   100: ifne -90 -> 10
    //   103: aload_0
    //   104: aload_1
    //   105: iload_2
    //   106: iconst_1
    //   107: isub
    //   108: invokevirtual 764	auht:a	(Ljava/lang/String;I)J
    //   111: lreturn
    //   112: iload 5
    //   114: istore_3
    //   115: aload 11
    //   117: invokevirtual 767	java/net/HttpURLConnection:getContentLength	()I
    //   120: istore 5
    //   122: iload 5
    //   124: i2l
    //   125: lstore 6
    //   127: ldc 141
    //   129: astore_1
    //   130: iload 4
    //   132: istore_3
    //   133: goto -59 -> 74
    //   136: astore 11
    //   138: aload 12
    //   140: astore_1
    //   141: aload_1
    //   142: astore 10
    //   144: aload 11
    //   146: invokevirtual 51	java/lang/Exception:printStackTrace	()V
    //   149: aload_1
    //   150: ifnull +49 -> 199
    //   153: aload_1
    //   154: invokevirtual 762	java/net/HttpURLConnection:disconnect	()V
    //   157: lconst_0
    //   158: lstore 6
    //   160: ldc 141
    //   162: astore_1
    //   163: goto -79 -> 84
    //   166: astore_1
    //   167: aload 10
    //   169: ifnull +8 -> 177
    //   172: aload 10
    //   174: invokevirtual 762	java/net/HttpURLConnection:disconnect	()V
    //   177: aload_1
    //   178: athrow
    //   179: astore_1
    //   180: aload 11
    //   182: astore 10
    //   184: goto -17 -> 167
    //   187: astore 10
    //   189: aload 11
    //   191: astore_1
    //   192: aload 10
    //   194: astore 11
    //   196: goto -55 -> 141
    //   199: lconst_0
    //   200: lstore 6
    //   202: ldc 141
    //   204: astore_1
    //   205: goto -121 -> 84
    //   208: goto -124 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	this	auht
    //   0	211	1	paramString	String
    //   0	211	2	paramInt	int
    //   14	119	3	i	int
    //   19	112	4	j	int
    //   16	107	5	k	int
    //   1	200	6	l1	long
    //   8	87	8	l2	long
    //   22	161	10	localObject1	Object
    //   187	6	10	localException1	Exception
    //   41	75	11	localHttpURLConnection	java.net.HttpURLConnection
    //   136	54	11	localException2	Exception
    //   194	1	11	localException3	Exception
    //   25	114	12	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   27	43	136	java/lang/Exception
    //   27	43	166	finally
    //   144	149	166	finally
    //   46	57	179	finally
    //   62	71	179	finally
    //   115	122	179	finally
    //   46	57	187	java/lang/Exception
    //   62	71	187	java/lang/Exception
    //   115	122	187	java/lang/Exception
  }
  
  public QQAppInterface a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] APP=null.");
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public List<auia> a(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return null;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      j();
      this.jdField_a_of_type_Boolean = true;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator;
    auia localauia;
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localauia = (auia)localIterator.next();
        if ((localauia != null) && (paramString.equalsIgnoreCase("package:" + localauia.jdField_a_of_type_JavaLangString))) {
          localArrayList.add(localauia);
        }
      }
    }
    if ((localArrayList.size() > 0) && (paramBoolean))
    {
      QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] getSucDownloadInfoOfPkg. remove before size:" + this.jdField_a_of_type_JavaUtilList.size());
      try
      {
        paramString = BaseApplication.getContext().getSharedPreferences("download_suc_info", 0).edit();
        localIterator = localArrayList.iterator();
        while (localIterator.hasNext())
        {
          localauia = (auia)localIterator.next();
          this.jdField_a_of_type_JavaUtilList.remove(localauia);
          paramString.remove(a(localauia));
          continue;
          QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] getSucDownloadInfoOfPkg. remove after size:" + this.jdField_a_of_type_JavaUtilList.size());
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    for (;;)
    {
      return localArrayList;
      paramString.commit();
    }
  }
  
  public Map<String, auhz> a()
  {
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      String str;
      try
      {
        Object localObject1 = BaseApplication.getContext().getSharedPreferences("downloading_rb_resume_info", 0).getAll();
        if (localObject1 != null) {
          QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] getDownloadingRbResmeInfo, size:[" + ((Map)localObject1).size() + "]");
        }
        if ((localObject1 != null) && (((Map)localObject1).size() > 0))
        {
          localObject1 = ((Map)localObject1).entrySet().iterator();
          if (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
            str = (String)((Map.Entry)localObject2).getKey();
            localObject2 = a((String)((Map.Entry)localObject2).getValue());
            if (localObject2 == null) {
              break label220;
            }
            QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] getDownloadingRbResmeInfo, url:[" + str + "]] nId:[" + ((auhz)localObject2).jdField_a_of_type_Int + "] w:[" + ((auhz)localObject2).jdField_a_of_type_Boolean + "]");
            localHashMap.put(str, localObject2);
            continue;
          }
        }
        return localHashMap;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      label220:
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] getDownloadingRbResmeInfo, value error. url:[" + str + "]");
    }
  }
  
  public void a()
  {
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] UniformDownloadMgr onAppDestroy...");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    h();
    ThreadManager.executeOnSubThread(new UniformDownloadMgr.2(this));
  }
  
  public void a(auia paramauia)
  {
    if (paramauia == null) {
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      j();
      this.jdField_a_of_type_Boolean = true;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.add(paramauia);
      QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] saveSucDownloadInfo. pkgName:" + paramauia.jdField_a_of_type_JavaLangString + " notificationId:" + paramauia.jdField_a_of_type_Int + " size:" + this.jdField_a_of_type_JavaUtilList.size());
      try
      {
        ??? = BaseApplication.getContext().getSharedPreferences("download_suc_info", 0).edit();
        ((SharedPreferences.Editor)???).putString(a(paramauia), "-");
        ((SharedPreferences.Editor)???).commit();
        return;
      }
      catch (Exception paramauia)
      {
        paramauia.printStackTrace();
        return;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] UniformDownloadMgr onAppInit...");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    ThreadManager.executeOnSubThread(new UniformDownloadMgr.1(this));
  }
  
  public void a(String paramString)
  {
    aulc localaulc = b(paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = a(paramString);
      if ((paramString != null) && (paramString.jdField_a_of_type_Aukz != null) && (localaulc != null)) {
        paramString.jdField_a_of_type_Aukz.a(localaulc);
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] removeSucDownloadInfo. pkgName:" + paramString + " notificationId:" + paramInt);
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (localIterator.hasNext())
        {
          localObject = (auia)localIterator.next();
          if ((localObject == null) || (!paramString.equalsIgnoreCase(((auia)localObject).jdField_a_of_type_JavaLangString)) || (paramInt != ((auia)localObject).jdField_a_of_type_Int)) {
            continue;
          }
          if (localObject != null)
          {
            this.jdField_a_of_type_JavaUtilList.remove(localObject);
            QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] removeSucDownloadInfo done. pkgName:" + paramString + " notificationId:" + paramInt + " size:" + this.jdField_a_of_type_JavaUtilList.size());
          }
          try
          {
            localObject = BaseApplication.getContext().getSharedPreferences("download_suc_info", 0).edit();
            ((SharedPreferences.Editor)localObject).remove(a(new auia(paramString, paramInt)));
            ((SharedPreferences.Editor)localObject).commit();
            return;
          }
          catch (Exception paramString)
          {
            paramString.printStackTrace();
            return;
          }
        }
      }
      Object localObject = null;
    }
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    ThreadManager.getSubThreadHandler().post(new UniformDownloadMgr.7(this, paramString, paramBundle));
  }
  
  public void a(String paramString, Bundle paramBundle, aulc paramaulc)
  {
    aulc localaulc = a(paramString);
    a(paramString, paramaulc);
    ThreadManager.getSubThreadHandler().post(new UniformDownloadMgr.9(this, paramBundle, paramString, localaulc));
  }
  
  public void a(String paramString1, String paramString2)
  {
    auku.a(paramString1, new auhv(this, paramString1, paramString2));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong, Bundle paramBundle, int paramInt, boolean paramBoolean)
  {
    try
    {
      QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] saveDownloadingRbResmeInfo, url:[" + paramString1 + "] nId:[" + paramInt + "] w:[" + paramBoolean + "]");
      SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("downloading_rb_resume_info", 0).edit();
      auhz localauhz = new auhz(this);
      localauhz.jdField_a_of_type_Int = paramInt;
      localauhz.jdField_a_of_type_JavaLangString = paramString2;
      if (!TextUtils.isEmpty(paramString3)) {}
      for (localauhz.b = paramString3;; localauhz.b = paramString2)
      {
        localauhz.jdField_a_of_type_Long = paramLong;
        localauhz.jdField_a_of_type_Boolean = paramBoolean;
        localauhz.jdField_a_of_type_AndroidOsBundle = paramBundle;
        localEditor.putString(paramString1, a(localauhz));
        localEditor.commit();
        return;
      }
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public boolean a(String paramString)
  {
    return a(paramString) != null;
  }
  
  public void b()
  {
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] UniformDownloadMgr onActiveAccount...");
    i();
  }
  
  public void b(String paramString)
  {
    try
    {
      QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] removeDownloadingRbResmeInfo, url:[" + paramString + "]");
      SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("downloading_rb_resume_info", 0).edit();
      localEditor.remove(paramString);
      localEditor.commit();
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void b(String paramString, Bundle paramBundle)
  {
    ThreadManager.getSubThreadHandler().post(new UniformDownloadMgr.8(this, paramBundle, paramString));
  }
  
  public void c()
  {
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] UniformDownloadMgr onQQProcessExit...");
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      if (this.jdField_a_of_type_JavaUtilMap.size() > 0)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
        if (localIterator.hasNext())
        {
          auhy localauhy = (auhy)((Map.Entry)localIterator.next()).getValue();
          if ((localauhy.jdField_a_of_type_Aukz != null) && (localauhy.jdField_a_of_type_Aukz.b())) {
            QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>onQQProcessExit. stop download:url:" + localauhy.jdField_a_of_type_JavaLangString);
          }
          Bundle localBundle = new Bundle();
          localBundle.putString("_notify_param_Url", localauhy.jdField_a_of_type_JavaLangString);
          auib.a().c(localauhy.b, localBundle);
          QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>onQQProcessExit. cancel notification:" + localauhy.b);
        }
      }
    }
    e();
    d();
    ThreadManager.getSubThreadHandler().post(new UniformDownloadMgr.3(this));
  }
  
  public void c(String paramString, Bundle paramBundle)
  {
    ThreadManager.getSubThreadHandler().post(new UniformDownloadMgr.10(this, paramString, paramBundle));
  }
  
  public void d()
  {
    try
    {
      QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] clearDownloadingRbResmeInfo...");
      SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("downloading_rb_resume_info", 0).edit();
      localEditor.clear();
      localEditor.commit();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void d(String paramString, Bundle paramBundle)
  {
    ThreadManager.getSubThreadHandler().post(new UniformDownloadMgr.11(this, paramString, paramBundle));
  }
  
  public void e()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      int i = this.jdField_a_of_type_JavaUtilList.size();
      this.jdField_a_of_type_JavaUtilList.clear();
      QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] clearSucDownloadInfo...size:" + i);
    }
  }
  
  public void e(String paramString, Bundle paramBundle)
  {
    ThreadManager.getSubThreadHandler().post(new UniformDownloadMgr.12(this, paramString, paramBundle));
  }
  
  public void f(String paramString, Bundle paramBundle)
  {
    ThreadManager.getSubThreadHandler().post(new UniformDownloadMgr.13(this, paramString, paramBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auht
 * JD-Core Version:    0.7.0.1
 */