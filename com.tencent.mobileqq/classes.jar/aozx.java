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

public class aozx
{
  public static aozx a;
  static boolean jdField_a_of_type_Boolean;
  private apad jdField_a_of_type_Apad;
  private HashMap<String, apad> jdField_a_of_type_JavaUtilHashMap;
  
  public static apad a(String paramString)
  {
    Object localObject;
    try
    {
      localObject = Looper.getMainLooper();
      if ((Thread.currentThread() != ((Looper)localObject).getThread()) && (QLog.isColorLevel()))
      {
        apue.a();
        throw new NullPointerException("getVideoControl not in UI Thread");
      }
    }
    finally {}
    if (!jdField_a_of_type_Aozx.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
    {
      localObject = new apad();
      ((apad)localObject).b = false;
      apad.a((apad)localObject, paramString);
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramString + "]new VcControl");
      }
      jdField_a_of_type_Aozx.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject);
    }
    if (((apad)jdField_a_of_type_Aozx.jdField_a_of_type_JavaUtilHashMap.get(paramString)).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory == null) {
      apad.a((apad)jdField_a_of_type_Aozx.jdField_a_of_type_JavaUtilHashMap.get(paramString), paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramString + "]get old VcControl");
    }
    paramString = (apad)jdField_a_of_type_Aozx.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    return paramString;
  }
  
  public static void a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 1, "Release FileVideoManager!");
      }
      if ((jdField_a_of_type_Aozx == null) || (jdField_a_of_type_Aozx.jdField_a_of_type_JavaUtilHashMap == null) || (jdField_a_of_type_Aozx.jdField_a_of_type_JavaUtilHashMap.size() == 0))
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.i("FileVideoManager<FileAssistant>", 1, "No download return!");
        return;
      }
      Iterator localIterator = jdField_a_of_type_Aozx.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        localObject = (apad)jdField_a_of_type_Aozx.jdField_a_of_type_JavaUtilHashMap.get(((Map.Entry)localObject).getKey());
        if (((apad)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
        {
          ((apad)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
          ((apad)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
        }
        if (((apad)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null)
        {
          if (QLog.isColorLevel())
          {
            QLog.i("FileVideoManager<FileAssistant>", 4, "[" + ((apad)localObject).jdField_a_of_type_Aplh.a() + "]Release, stop playID[" + ((apad)localObject).jdField_a_of_type_Int + "]");
            QLog.i("FileVideoManager<FileAssistant>", 4, "[" + ((apad)localObject).jdField_a_of_type_Aplh.a() + "]Release, stop DownloadId[" + ((apad)localObject).jdField_c_of_type_Int + "]");
          }
          if (((apad)localObject).jdField_a_of_type_Int > 0)
          {
            ((apad)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((apad)localObject).jdField_a_of_type_Int);
            ((apad)localObject).jdField_a_of_type_Int = -1;
          }
          if (((apad)localObject).jdField_c_of_type_Int > 0)
          {
            ((apad)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((apad)localObject).jdField_c_of_type_Int);
            ((apad)localObject).jdField_c_of_type_Int = -1;
          }
          if (((apad)localObject).d > 0)
          {
            ((apad)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((apad)localObject).d);
            ((apad)localObject).d = -1;
          }
          QLog.i("FileVideoManager<FileAssistant>", 1, "[" + ((apad)localObject).jdField_a_of_type_Aplh.a() + "]free VideoCtrl bDownloading = false");
          ((apad)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.setCallBackListener(20160714, null);
          ((apad)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.DownloadDeinit(20160714);
          ((apad)localObject).b = false;
        }
        localIterator.remove();
      }
      if (jdField_a_of_type_Aozx.jdField_a_of_type_JavaUtilHashMap.size() != 0) {
        break label421;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    jdField_a_of_type_Aozx.jdField_a_of_type_JavaUtilHashMap = null;
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
  
  public static void a(Context paramContext, apac paramapac)
  {
    Looper localLooper = Looper.getMainLooper();
    Handler localHandler = new Handler(localLooper);
    if (localLooper.getThread() != Thread.currentThread())
    {
      localHandler.post(new FileVideoManager.4(paramContext, paramapac));
      return;
    }
    if (jdField_a_of_type_Aozx == null) {
      jdField_a_of_type_Aozx = new aozx();
    }
    if (jdField_a_of_type_Aozx.jdField_a_of_type_JavaUtilHashMap == null) {
      jdField_a_of_type_Aozx.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    jdField_a_of_type_Aozx.b(paramContext, paramapac);
  }
  
  public static void a(apad paramapad)
  {
    Object localObject = Looper.getMainLooper();
    if ((Thread.currentThread() != ((Looper)localObject).getThread()) && (QLog.isColorLevel()))
    {
      apue.a();
      throw new NullPointerException("DownloadNext not in UI Thread");
    }
    if ((jdField_a_of_type_Aozx == null) || (jdField_a_of_type_Aozx.jdField_a_of_type_JavaUtilHashMap == null) || (jdField_a_of_type_Aozx.jdField_a_of_type_JavaUtilHashMap.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileVideoManager<FileAssistant>", 1, "download queue is zero, DeinitDownloadManager");
      }
      if ((paramapad != null) && (paramapad.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null))
      {
        paramapad.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.DownloadDeinit(20160714);
        paramapad.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr = null;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FileVideoManager<FileAssistant>", 1, "download queue is zero, return downloadNext");
      }
    }
    apad localapad;
    for (;;)
    {
      return;
      localObject = jdField_a_of_type_Aozx.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        localapad = (apad)jdField_a_of_type_Aozx.jdField_a_of_type_JavaUtilHashMap.get(str);
        if (localapad != paramapad) {
          break label223;
        }
        if (QLog.isColorLevel()) {
          QLog.d("FileVideoManager<FileAssistant>", 1, "[" + localapad.hashCode() + "]find vc[" + str + "] continue");
        }
      }
    }
    label223:
    jdField_a_of_type_Aozx.jdField_a_of_type_Apad = localapad;
    localapad.a(localapad.jdField_a_of_type_Aplh, false);
  }
  
  public static void a(aplh paramaplh)
  {
    if (paramaplh.a())
    {
      a(paramaplh.a());
      return;
    }
    new Handler(Looper.getMainLooper()).post(new FileVideoManager.1(paramaplh));
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
        if ((jdField_a_of_type_Aozx != null) && (jdField_a_of_type_Aozx.jdField_a_of_type_JavaUtilHashMap != null) && (jdField_a_of_type_Aozx.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramString + "]queue is zero return");
      return;
      localObject = (apad)jdField_a_of_type_Aozx.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      ((apad)localObject).b = false;
      ((apad)localObject).a();
      a((apad)localObject);
      jdField_a_of_type_Aozx.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
    } while (!QLog.isColorLevel());
    QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramString + "]removed");
  }
  
  private void b(Context paramContext, apac paramapac)
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
      paramapac.b();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FileVideoManager<FileAssistant>", 1, "TVK_SDKMgr Not Installed!");
    }
    if (bbev.b(BaseApplication.getContext()) == 1) {}
    while (i != 0)
    {
      c(paramContext, paramapac);
      bcpw.a(paramContext, paramContext.getResources().getString(2131697971), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131298865));
      return;
      i = 0;
    }
    try
    {
      bbcv.a(paramContext, 232, null, paramContext.getResources().getString(2131697968), new aozz(this, paramContext, paramapac), new apaa(this, paramapac)).show();
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
    if ((jdField_a_of_type_Aozx == null) || (jdField_a_of_type_Aozx.jdField_a_of_type_JavaUtilHashMap == null) || (jdField_a_of_type_Aozx.jdField_a_of_type_JavaUtilHashMap.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 1, "No download return!");
      }
      return;
    }
    Iterator localIterator = jdField_a_of_type_Aozx.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      localObject = (apad)jdField_a_of_type_Aozx.jdField_a_of_type_JavaUtilHashMap.get(((Map.Entry)localObject).getKey());
      if ((((apad)localObject).jdField_c_of_type_JavaLangString != null) || (((apad)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null))
      {
        ((apad)localObject).b();
        if (((apad)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
        {
          ((apad)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
          ((apad)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
        }
        if (((apad)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null)
        {
          if (QLog.isColorLevel())
          {
            QLog.i("FileVideoManager<FileAssistant>", 4, "[" + ((apad)localObject).jdField_a_of_type_Aplh.a() + "]onNetworkChange, stop playID[" + ((apad)localObject).jdField_a_of_type_Int + "]");
            QLog.i("FileVideoManager<FileAssistant>", 4, "[" + ((apad)localObject).jdField_a_of_type_Aplh.a() + "]onNetworkChange, stop DownloadId[" + ((apad)localObject).jdField_c_of_type_Int + "]");
          }
          if (((apad)localObject).jdField_a_of_type_Int > 0)
          {
            ((apad)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((apad)localObject).jdField_a_of_type_Int);
            ((apad)localObject).jdField_a_of_type_Int = -1;
          }
          if (((apad)localObject).jdField_c_of_type_Int > 0)
          {
            ((apad)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((apad)localObject).jdField_c_of_type_Int);
            ((apad)localObject).jdField_c_of_type_Int = -1;
          }
          if (((apad)localObject).d > 0)
          {
            ((apad)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((apad)localObject).d);
            ((apad)localObject).d = -1;
          }
          if (QLog.isColorLevel()) {
            QLog.i("FileVideoManager<FileAssistant>", 1, "[" + ((apad)localObject).jdField_a_of_type_Aplh.a() + "]##########NetWorkChange########### bDownloading = false");
          }
          ((apad)localObject).b = false;
        }
        localIterator.remove();
      }
    }
    if (jdField_a_of_type_Aozx.jdField_a_of_type_JavaUtilHashMap.size() == 0) {
      jdField_a_of_type_Aozx.jdField_a_of_type_JavaUtilHashMap = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "process all");
    }
    ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a().a(true, 3, null);
  }
  
  private void c(Context paramContext, apac paramapac)
  {
    System.currentTimeMillis();
    TVK_SDKMgr.installPlugin(paramContext, new aozy(this, paramapac));
  }
  
  private static void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramString + "]DestroyMediaPlay");
    }
    if ((jdField_a_of_type_Aozx == null) || (jdField_a_of_type_Aozx.jdField_a_of_type_JavaUtilHashMap == null) || (!jdField_a_of_type_Aozx.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))) {
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramString + "]not in map return");
      }
    }
    for (;;)
    {
      return;
      apad localapad = (apad)jdField_a_of_type_Aozx.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      if (localapad.jdField_c_of_type_Boolean)
      {
        localapad.a();
        if (QLog.isColorLevel()) {
          QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramString + "]download success return");
        }
      }
      else
      {
        if (localapad.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
        {
          localapad.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
          localapad.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
        }
        if (localapad.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null) {
          if (!localapad.jdField_a_of_type_Aplh.a())
          {
            localapad.a(localapad.jdField_a_of_type_Aplh, false);
            if (localapad.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null) {
              localapad.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.setPlayerState(20160714, localapad.jdField_c_of_type_Int, 6);
            }
          }
        }
        while (QLog.isColorLevel())
        {
          QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramString + "]DestroyMediaPlay,vc.bDownloading[" + localapad.b + "]");
          return;
          a(paramString);
          continue;
          if (localapad.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr == null) {
            a(paramString);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aozx
 * JD-Core Version:    0.7.0.1
 */