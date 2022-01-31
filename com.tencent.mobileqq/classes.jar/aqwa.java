import android.content.BroadcastReceiver;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.1;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.10;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.11;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.12;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.13;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.14;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.15;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.2;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.3;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.6;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.7;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.8;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.9;
import com.tencent.mobileqq.filemanager.core.UniformDownloadPkgInstallReceiver;
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

public class aqwa
{
  private static aqwa jdField_a_of_type_Aqwa;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  public QQAppInterface a;
  private List<aqwh> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<String, aqwf> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  private Map<String, arpo> jdField_b_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_b_of_type_Boolean = true;
  
  private aqwa()
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
      aqwf localaqwf = (aqwf)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
      if (localaqwf != null)
      {
        arpo localarpo = a(paramString);
        if ((localaqwf.jdField_a_of_type_Arpl != null) && (localarpo != null)) {
          localaqwf.jdField_a_of_type_Arpl.a(localarpo);
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
        int k = localUnsupportedEncodingException.jdField_a_of_type_Arpl.f();
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
        if ((localObject2 != null) && ((localObject2 == null) || (((aqwf)localObject2).jdField_a_of_type_Arpl != null))) {
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
    localUnsupportedEncodingException.jdField_a_of_type_Arpl.a(paramString);
    localUnsupportedEncodingException.jdField_a_of_type_Arpl.a(paramString, false);
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
    arpl localarpl = new arpl(l, paramString1, paramBundle);
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("_PARAM_FILENAME", paramString2);
    ((Bundle)localObject).putLong("_PARAM_FILESIZE", paramLong);
    ((Bundle)localObject).putBundle("_PARAM_USER_DATA", paramBundle);
    localarpl.a((Bundle)localObject);
    if (1 == localarpl.g())
    {
      QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL][" + l + " - NEW_ID]. >>> create UniformDownloader.using appbaby. url: " + paramString1);
      localarpl.a(new aqwd(this), true);
      localObject = a(paramString1);
      if (localObject != null) {
        localarpl.a((arpo)localObject, false);
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
      paramInt = aqwi.a().a(localarpl, (Bundle)localObject, l, paramInt);
      a(paramString1, new aqwf(this, null, localarpl.g(), localarpl, l, paramInt));
      if (!paramBoolean) {
        break label435;
      }
      QLog.w("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL][" + l + "] preHadStarted. url:" + paramString1);
      localarpl.a(true);
    }
    for (;;)
    {
      if (b(paramString1) == 0)
      {
        localarpl.a(true);
        aqwi.a().b(paramInt, (Bundle)localObject);
      }
      this.jdField_b_of_type_Boolean = false;
      return 0;
      if (2 == localarpl.g())
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
        if (1 == localarpl.g()) {
          azmy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "Start_download_2-0_3-0");
        } else if (2 == localarpl.g()) {
          azmy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "Start_download_2-0_3-1");
        }
      }
    }
  }
  
  private long a()
  {
    return (int)(System.currentTimeMillis() / 1000L) << 32 | Math.abs(new Random().nextInt());
  }
  
  public static aqwa a()
  {
    try
    {
      if (jdField_a_of_type_Aqwa == null)
      {
        QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] UniformDownloadMgr.getInstance.create");
        jdField_a_of_type_Aqwa = new aqwa();
      }
      aqwa localaqwa = jdField_a_of_type_Aqwa;
      return localaqwa;
    }
    finally {}
  }
  
  private aqwf a(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramString = (aqwf)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      return paramString;
    }
  }
  
  private aqwg a(String paramString)
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
    paramString = new aqwg(this);
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
  
  private aqwh a(String paramString)
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
    return new aqwh(arrayOfString[0], Integer.parseInt(arrayOfString[1]));
  }
  
  private arpo a(String paramString)
  {
    if (paramString == null) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      try
      {
        paramString = (arpo)this.jdField_b_of_type_JavaUtilMap.get(paramString);
      }
      finally {}
    }
  }
  
  private String a(aqwg paramaqwg)
  {
    if (paramaqwg == null)
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] stringOfRbObject err, obj=null");
      return null;
    }
    return String.valueOf(paramaqwg.jdField_a_of_type_Int) + "^" + paramaqwg.jdField_a_of_type_JavaLangString + "^" + String.valueOf(paramaqwg.jdField_a_of_type_Long) + "^" + String.valueOf(paramaqwg.jdField_a_of_type_Boolean) + "^" + paramaqwg.b;
  }
  
  private String a(aqwh paramaqwh)
  {
    if (paramaqwh == null)
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] stringOfSucInfo err, obj=null");
      return null;
    }
    return String.valueOf(paramaqwh.jdField_a_of_type_JavaLangString) + "^" + String.valueOf(paramaqwh.jdField_a_of_type_Int);
  }
  
  private void a(String paramString, arpo paramarpo)
  {
    if ((paramString != null) && (paramarpo != null)) {}
    try
    {
      this.jdField_b_of_type_JavaUtilMap.put(paramString, paramarpo);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private boolean a(String paramString, aqwf paramaqwf)
  {
    if ((paramString == null) || (paramaqwf == null))
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] addDownloadInst.. param null");
      return false;
    }
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
        return false;
      }
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramString, paramaqwf);
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] addDownloadInst.. total[" + this.jdField_a_of_type_JavaUtilMap.size() + "] add it. url[" + paramString + "]");
    return true;
  }
  
  private int b(String paramString)
  {
    int i = 0;
    if ((bdee.d(BaseApplication.getContext())) && (!arni.a())) {}
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
          aqwf localaqwf = (aqwf)((Map.Entry)localIterator.next()).getValue();
          int n = j;
          k = i;
          if (localaqwf.jdField_a_of_type_Arpl != null)
          {
            n = j;
            k = i;
            if (localaqwf.jdField_a_of_type_Arpl.b())
            {
              i += 1;
              n = j;
              k = i;
              if (paramString != null)
              {
                n = j;
                k = i;
                if (paramString.equalsIgnoreCase(localaqwf.jdField_a_of_type_JavaLangString))
                {
                  QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] inPTryStartNextDownload.. download is runing. traceUrl:" + paramString);
                  n = 1;
                  k = i;
                }
              }
            }
          }
          ((List)localObject2).add(localaqwf);
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
            localObject2 = (aqwf)((Iterator)???).next();
            k = j;
            if (((aqwf)localObject2).jdField_a_of_type_Arpl == null) {
              break label526;
            }
            k = j;
            if (!((aqwf)localObject2).jdField_a_of_type_Arpl.a()) {
              break label526;
            }
            if (j < m)
            {
              QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>> Happy. start a download task, url:[" + ((aqwf)localObject2).jdField_a_of_type_JavaLangString + "]");
              j += 1;
              ((aqwf)localObject2).jdField_a_of_type_Arpl.a();
              k = j;
              if (paramString == null) {
                break label526;
              }
              k = j;
              if (!paramString.equalsIgnoreCase(((aqwf)localObject2).jdField_a_of_type_JavaLangString)) {
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
      arpg.a(paramString, new aqwe(this));
      aqwi.a().a(i, (Bundle)paramBundle.clone());
      b(null);
    }
    return 0;
  }
  
  private arpo b(String paramString)
  {
    try
    {
      paramString = (arpo)this.jdField_b_of_type_JavaUtilMap.remove(paramString);
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
    aqwf localaqwf = a(paramString);
    if (localaqwf != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        if (localaqwf.jdField_a_of_type_Int != 1) {
          break label71;
        }
        azmy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "Stop_download_2-2_3-0");
      }
      for (;;)
      {
        if (localaqwf.jdField_a_of_type_Arpl != null) {
          localaqwf.jdField_a_of_type_Arpl.b();
        }
        b(null);
        return 0;
        label71:
        azmy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "Stop_download_2-2_3-1");
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
    aqwf localaqwf = a(paramString);
    if (localaqwf != null)
    {
      if (localaqwf.jdField_a_of_type_Arpl != null)
      {
        paramString = a(paramString);
        if (paramString != null) {
          localaqwf.jdField_a_of_type_Arpl.a(paramString, false);
        }
        localaqwf.jdField_a_of_type_Arpl.c();
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
    aqwf localaqwf = a(paramString);
    if (localaqwf != null)
    {
      if (localaqwf.jdField_a_of_type_Arpl != null) {
        localaqwf.jdField_a_of_type_Arpl.d();
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
    azpb.a().addDownloadURL(paramString);
    HashMap localHashMap = new HashMap();
    localHashMap.put("url", paramString);
    localHashMap.put("NetworkType", bdee.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()) + "");
    if (bfgh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) {}
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
        azmz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "UniformDownloadEvent_NO_SOURCE", true, 0L, 0L, localHashMap, "");
        paramBundle = (String)localHashMap.get("isForeground");
        localObject1 = (String)localHashMap.get("isAPK");
        localObject2 = paramString.toString();
        localStringBuilder = new StringBuilder().append((String)localHashMap.get("Stack"));
        if (!localHashMap.containsKey("Stack1")) {
          continue;
        }
        paramString = (String)localHashMap.get("Stack1");
        azmj.b(null, "dc00898", "", "", "0X800A003", "0X800A003", 0, 0, paramBundle, (String)localObject1, (String)localObject2, paramString);
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
      azmz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "UniformDownloadEvent", true, 0L, 0L, localHashMap, "");
      paramBundle = (String)localHashMap.get("isForeground");
      localObject1 = (String)localHashMap.get("isAPK");
      localObject2 = paramString.toString();
      localStringBuilder = new StringBuilder().append((String)localHashMap.get("Stack"));
      if (!localHashMap.containsKey("Stack1")) {
        continue;
      }
      paramString = (String)localHashMap.get("Stack1");
      azmj.b(null, "dc00898", "", "", "0X800A002", "0X800A002", 0, 0, paramBundle, (String)localObject1, (String)localObject2, paramString);
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
            aqwh localaqwh = a((String)((Map.Entry)localIterator.next()).getKey());
            if (localaqwh == null) {
              break label207;
            }
            QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] initSucDownloadInfo, pkgName:[" + localaqwh.jdField_a_of_type_JavaLangString + "]] nId:[" + localaqwh.jdField_a_of_type_Int + "] ");
            synchronized (this.jdField_a_of_type_JavaUtilList)
            {
              this.jdField_a_of_type_JavaUtilList.add(localaqwh);
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
  
  public QQAppInterface a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] APP=null.");
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public List<aqwh> a(String paramString, boolean paramBoolean)
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
    aqwh localaqwh;
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localaqwh = (aqwh)localIterator.next();
        if ((localaqwh != null) && (paramString.equalsIgnoreCase("package:" + localaqwh.jdField_a_of_type_JavaLangString))) {
          localArrayList.add(localaqwh);
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
          localaqwh = (aqwh)localIterator.next();
          this.jdField_a_of_type_JavaUtilList.remove(localaqwh);
          paramString.remove(a(localaqwh));
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
  
  public Map<String, aqwg> a()
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
            QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] getDownloadingRbResmeInfo, url:[" + str + "]] nId:[" + ((aqwg)localObject2).jdField_a_of_type_Int + "] w:[" + ((aqwg)localObject2).jdField_a_of_type_Boolean + "]");
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
  
  public void a(aqwh paramaqwh)
  {
    if (paramaqwh == null) {
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      j();
      this.jdField_a_of_type_Boolean = true;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.add(paramaqwh);
      QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] saveSucDownloadInfo. pkgName:" + paramaqwh.jdField_a_of_type_JavaLangString + " notificationId:" + paramaqwh.jdField_a_of_type_Int + " size:" + this.jdField_a_of_type_JavaUtilList.size());
      try
      {
        ??? = BaseApplication.getContext().getSharedPreferences("download_suc_info", 0).edit();
        ((SharedPreferences.Editor)???).putString(a(paramaqwh), "-");
        ((SharedPreferences.Editor)???).commit();
        return;
      }
      catch (Exception paramaqwh)
      {
        paramaqwh.printStackTrace();
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
    arpo localarpo = b(paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = a(paramString);
      if ((paramString != null) && (paramString.jdField_a_of_type_Arpl != null) && (localarpo != null)) {
        paramString.jdField_a_of_type_Arpl.a(localarpo);
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
          localObject = (aqwh)localIterator.next();
          if ((localObject == null) || (!paramString.equalsIgnoreCase(((aqwh)localObject).jdField_a_of_type_JavaLangString)) || (paramInt != ((aqwh)localObject).jdField_a_of_type_Int)) {
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
            ((SharedPreferences.Editor)localObject).remove(a(new aqwh(paramString, paramInt)));
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
  
  public void a(String paramString, Bundle paramBundle, arpo paramarpo)
  {
    arpo localarpo = a(paramString);
    a(paramString, paramarpo);
    ThreadManager.getSubThreadHandler().post(new UniformDownloadMgr.9(this, paramBundle, paramString, localarpo));
  }
  
  public void a(String paramString1, String paramString2)
  {
    arpg.a(paramString1, new aqwc(this, paramString1, paramString2));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong, Bundle paramBundle, int paramInt, boolean paramBoolean)
  {
    try
    {
      QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] saveDownloadingRbResmeInfo, url:[" + paramString1 + "] nId:[" + paramInt + "] w:[" + paramBoolean + "]");
      SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("downloading_rb_resume_info", 0).edit();
      aqwg localaqwg = new aqwg(this);
      localaqwg.jdField_a_of_type_Int = paramInt;
      localaqwg.jdField_a_of_type_JavaLangString = paramString2;
      if (!TextUtils.isEmpty(paramString3)) {}
      for (localaqwg.b = paramString3;; localaqwg.b = paramString2)
      {
        localaqwg.jdField_a_of_type_Long = paramLong;
        localaqwg.jdField_a_of_type_Boolean = paramBoolean;
        localaqwg.jdField_a_of_type_AndroidOsBundle = paramBundle;
        localEditor.putString(paramString1, a(localaqwg));
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
          aqwf localaqwf = (aqwf)((Map.Entry)localIterator.next()).getValue();
          if ((localaqwf.jdField_a_of_type_Arpl != null) && (localaqwf.jdField_a_of_type_Arpl.b())) {
            QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>onQQProcessExit. stop download:url:" + localaqwf.jdField_a_of_type_JavaLangString);
          }
          Bundle localBundle = new Bundle();
          localBundle.putString("_notify_param_Url", localaqwf.jdField_a_of_type_JavaLangString);
          aqwi.a().c(localaqwf.b, localBundle);
          QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>onQQProcessExit. cancel notification:" + localaqwf.b);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqwa
 * JD-Core Version:    0.7.0.1
 */