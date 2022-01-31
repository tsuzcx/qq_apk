import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileVideoManager.1;
import com.tencent.mobileqq.filemanager.core.FileVideoManager.11;
import com.tencent.mobileqq.filemanager.core.FileVideoManager.2;
import com.tencent.mobileqq.filemanager.core.FileVideoManager.3;
import com.tencent.mobileqq.filemanager.core.FileVideoManager.4;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IDownloadMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class apab
{
  public static apab a;
  static boolean jdField_a_of_type_Boolean;
  private apah jdField_a_of_type_Apah;
  private HashMap<String, apah> jdField_a_of_type_JavaUtilHashMap;
  
  public static apah a(String paramString)
  {
    Object localObject;
    try
    {
      localObject = Looper.getMainLooper();
      if ((Thread.currentThread() != ((Looper)localObject).getThread()) && (QLog.isColorLevel()))
      {
        apug.a();
        throw new NullPointerException("getVideoControl not in UI Thread");
      }
    }
    finally {}
    if (!jdField_a_of_type_Apab.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
    {
      localObject = new apah();
      ((apah)localObject).b = false;
      apah.a((apah)localObject, paramString);
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramString + "]new VcControl");
      }
      jdField_a_of_type_Apab.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject);
    }
    if (((apah)jdField_a_of_type_Apab.jdField_a_of_type_JavaUtilHashMap.get(paramString)).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory == null) {
      apah.a((apah)jdField_a_of_type_Apab.jdField_a_of_type_JavaUtilHashMap.get(paramString), paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramString + "]get old VcControl");
    }
    paramString = (apah)jdField_a_of_type_Apab.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    return paramString;
  }
  
  public static void a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 1, "Release FileVideoManager!");
      }
      if ((jdField_a_of_type_Apab == null) || (jdField_a_of_type_Apab.jdField_a_of_type_JavaUtilHashMap == null) || (jdField_a_of_type_Apab.jdField_a_of_type_JavaUtilHashMap.size() == 0))
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.i("FileVideoManager<FileAssistant>", 1, "No download return!");
        return;
      }
      Iterator localIterator = jdField_a_of_type_Apab.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        localObject = (apah)jdField_a_of_type_Apab.jdField_a_of_type_JavaUtilHashMap.get(((Map.Entry)localObject).getKey());
        if (((apah)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
        {
          ((apah)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
          ((apah)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
        }
        if (((apah)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null)
        {
          if (QLog.isColorLevel())
          {
            QLog.i("FileVideoManager<FileAssistant>", 4, "[" + ((apah)localObject).jdField_a_of_type_Apll.a() + "]Release, stop playID[" + ((apah)localObject).jdField_a_of_type_Int + "]");
            QLog.i("FileVideoManager<FileAssistant>", 4, "[" + ((apah)localObject).jdField_a_of_type_Apll.a() + "]Release, stop DownloadId[" + ((apah)localObject).jdField_c_of_type_Int + "]");
          }
          if (((apah)localObject).jdField_a_of_type_Int > 0)
          {
            ((apah)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((apah)localObject).jdField_a_of_type_Int);
            ((apah)localObject).jdField_a_of_type_Int = -1;
          }
          if (((apah)localObject).jdField_c_of_type_Int > 0)
          {
            ((apah)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((apah)localObject).jdField_c_of_type_Int);
            ((apah)localObject).jdField_c_of_type_Int = -1;
          }
          if (((apah)localObject).d > 0)
          {
            ((apah)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((apah)localObject).d);
            ((apah)localObject).d = -1;
          }
          QLog.i("FileVideoManager<FileAssistant>", 1, "[" + ((apah)localObject).jdField_a_of_type_Apll.a() + "]free VideoCtrl bDownloading = false");
          ((apah)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.setCallBackListener(20160714, null);
          ((apah)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.DownloadDeinit(20160714);
          ((apah)localObject).b = false;
        }
        localIterator.remove();
      }
      if (jdField_a_of_type_Apab.jdField_a_of_type_JavaUtilHashMap.size() != 0) {
        break label421;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    jdField_a_of_type_Apab.jdField_a_of_type_JavaUtilHashMap = null;
    label421:
    if (QLog.isColorLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "release all");
    }
    ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a().a(true, 3, null);
  }
  
  public static void a(int paramInt)
  {
    Looper localLooper = Looper.getMainLooper();
    if (localLooper.getThread() != Thread.currentThread())
    {
      new Handler(localLooper).post(new FileVideoManager.11(paramInt));
      return;
    }
    c(paramInt);
  }
  
  public static void a(Context paramContext, apag paramapag)
  {
    Looper localLooper = Looper.getMainLooper();
    Handler localHandler = new Handler(localLooper);
    if (localLooper.getThread() != Thread.currentThread())
    {
      localHandler.post(new FileVideoManager.4(paramContext, paramapag));
      return;
    }
    if (jdField_a_of_type_Apab == null) {
      jdField_a_of_type_Apab = new apab();
    }
    if (jdField_a_of_type_Apab.jdField_a_of_type_JavaUtilHashMap == null) {
      jdField_a_of_type_Apab.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    jdField_a_of_type_Apab.b(paramContext, paramapag);
  }
  
  public static void a(apah paramapah)
  {
    Object localObject = Looper.getMainLooper();
    if ((Thread.currentThread() != ((Looper)localObject).getThread()) && (QLog.isColorLevel()))
    {
      apug.a();
      throw new NullPointerException("DownloadNext not in UI Thread");
    }
    if ((jdField_a_of_type_Apab == null) || (jdField_a_of_type_Apab.jdField_a_of_type_JavaUtilHashMap == null) || (jdField_a_of_type_Apab.jdField_a_of_type_JavaUtilHashMap.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileVideoManager<FileAssistant>", 1, "download queue is zero, DeinitDownloadManager");
      }
      if ((paramapah != null) && (paramapah.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null))
      {
        paramapah.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.DownloadDeinit(20160714);
        paramapah.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr = null;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FileVideoManager<FileAssistant>", 1, "download queue is zero, return downloadNext");
      }
    }
    apah localapah;
    for (;;)
    {
      return;
      localObject = jdField_a_of_type_Apab.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        localapah = (apah)jdField_a_of_type_Apab.jdField_a_of_type_JavaUtilHashMap.get(str);
        if (localapah != paramapah) {
          break label223;
        }
        if (QLog.isColorLevel()) {
          QLog.d("FileVideoManager<FileAssistant>", 1, "[" + localapah.hashCode() + "]find vc[" + str + "] continue");
        }
      }
    }
    label223:
    jdField_a_of_type_Apab.jdField_a_of_type_Apah = localapah;
    localapah.a(localapah.jdField_a_of_type_Apll, false);
  }
  
  public static void a(apll paramapll)
  {
    if (paramapll.a())
    {
      a(paramapll.a());
      return;
    }
    new Handler(Looper.getMainLooper()).post(new FileVideoManager.1(paramapll));
  }
  
  public static void a(String paramString)
  {
    Object localObject = Looper.getMainLooper();
    if (Thread.currentThread() != ((Looper)localObject).getThread()) {
      new Handler((Looper)localObject).post(new FileVideoManager.2(paramString));
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramString + "]FreeVideoControl");
        }
        if ((jdField_a_of_type_Apab != null) && (jdField_a_of_type_Apab.jdField_a_of_type_JavaUtilHashMap != null) && (jdField_a_of_type_Apab.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramString + "]queue is zero return");
      return;
      localObject = (apah)jdField_a_of_type_Apab.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      ((apah)localObject).b = false;
      ((apah)localObject).a();
      a((apah)localObject);
      jdField_a_of_type_Apab.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
    } while (!QLog.isColorLevel());
    QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramString + "]removed");
  }
  
  private void b(Context paramContext, apag paramapag)
  {
    int i = 1;
    if (!jdField_a_of_type_Boolean)
    {
      TVK_SDKMgr.initSdk(paramContext, "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
      jdField_a_of_type_Boolean = true;
    }
    if (TVK_SDKMgr.isInstalled(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileVideoManager<FileAssistant>", 1, "TVK_SDKMgr Installed!");
      }
      paramapag.b();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FileVideoManager<FileAssistant>", 1, "TVK_SDKMgr Not Installed!");
    }
    if (bbfj.b(BaseApplication.getContext()) == 1) {}
    while (i != 0)
    {
      c(paramContext, paramapag);
      bcql.a(paramContext, paramContext.getResources().getString(2131697981), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131298865));
      return;
      i = 0;
    }
    try
    {
      bbdj.a(paramContext, 232, null, paramContext.getResources().getString(2131697978), new apad(this, paramContext, paramapag), new apae(this, paramapag)).show();
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static void b(String paramString)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new FileVideoManager.3(paramString));
      return;
    }
    d(paramString);
  }
  
  private static void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "onNeworkChanged!");
    }
    if ((jdField_a_of_type_Apab == null) || (jdField_a_of_type_Apab.jdField_a_of_type_JavaUtilHashMap == null) || (jdField_a_of_type_Apab.jdField_a_of_type_JavaUtilHashMap.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 1, "No download return!");
      }
      return;
    }
    Iterator localIterator = jdField_a_of_type_Apab.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      localObject = (apah)jdField_a_of_type_Apab.jdField_a_of_type_JavaUtilHashMap.get(((Map.Entry)localObject).getKey());
      if ((((apah)localObject).jdField_c_of_type_JavaLangString != null) || (((apah)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null))
      {
        ((apah)localObject).b();
        if (((apah)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
        {
          ((apah)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
          ((apah)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
        }
        if (((apah)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null)
        {
          if (QLog.isColorLevel())
          {
            QLog.i("FileVideoManager<FileAssistant>", 4, "[" + ((apah)localObject).jdField_a_of_type_Apll.a() + "]onNetworkChange, stop playID[" + ((apah)localObject).jdField_a_of_type_Int + "]");
            QLog.i("FileVideoManager<FileAssistant>", 4, "[" + ((apah)localObject).jdField_a_of_type_Apll.a() + "]onNetworkChange, stop DownloadId[" + ((apah)localObject).jdField_c_of_type_Int + "]");
          }
          if (((apah)localObject).jdField_a_of_type_Int > 0)
          {
            ((apah)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((apah)localObject).jdField_a_of_type_Int);
            ((apah)localObject).jdField_a_of_type_Int = -1;
          }
          if (((apah)localObject).jdField_c_of_type_Int > 0)
          {
            ((apah)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((apah)localObject).jdField_c_of_type_Int);
            ((apah)localObject).jdField_c_of_type_Int = -1;
          }
          if (((apah)localObject).d > 0)
          {
            ((apah)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((apah)localObject).d);
            ((apah)localObject).d = -1;
          }
          if (QLog.isColorLevel()) {
            QLog.i("FileVideoManager<FileAssistant>", 1, "[" + ((apah)localObject).jdField_a_of_type_Apll.a() + "]##########NetWorkChange########### bDownloading = false");
          }
          ((apah)localObject).b = false;
        }
        localIterator.remove();
      }
    }
    if (jdField_a_of_type_Apab.jdField_a_of_type_JavaUtilHashMap.size() == 0) {
      jdField_a_of_type_Apab.jdField_a_of_type_JavaUtilHashMap = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "process all");
    }
    ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a().a(true, 3, null);
  }
  
  private void c(Context paramContext, apag paramapag)
  {
    System.currentTimeMillis();
    TVK_SDKMgr.installPlugin(paramContext, new apac(this, paramapag));
  }
  
  private static void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramString + "]DestroyMediaPlay");
    }
    if ((jdField_a_of_type_Apab == null) || (jdField_a_of_type_Apab.jdField_a_of_type_JavaUtilHashMap == null) || (!jdField_a_of_type_Apab.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))) {
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramString + "]not in map return");
      }
    }
    for (;;)
    {
      return;
      apah localapah = (apah)jdField_a_of_type_Apab.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      if (localapah.jdField_c_of_type_Boolean)
      {
        localapah.a();
        if (QLog.isColorLevel()) {
          QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramString + "]download success return");
        }
      }
      else
      {
        if (localapah.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
        {
          localapah.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
          localapah.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
        }
        if (localapah.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null) {
          if (!localapah.jdField_a_of_type_Apll.a())
          {
            localapah.a(localapah.jdField_a_of_type_Apll, false);
            if (localapah.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null) {
              localapah.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.setPlayerState(20160714, localapah.jdField_c_of_type_Int, 6);
            }
          }
        }
        while (QLog.isColorLevel())
        {
          QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramString + "]DestroyMediaPlay,vc.bDownloading[" + localapah.b + "]");
          return;
          a(paramString);
          continue;
          if (localapah.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr == null) {
            a(paramString);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apab
 * JD-Core Version:    0.7.0.1
 */