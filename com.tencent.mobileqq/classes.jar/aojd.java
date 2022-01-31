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

public class aojd
{
  public static aojd a;
  static boolean jdField_a_of_type_Boolean;
  private aojj jdField_a_of_type_Aojj;
  private HashMap<String, aojj> jdField_a_of_type_JavaUtilHashMap;
  
  public static aojj a(String paramString)
  {
    Object localObject;
    try
    {
      localObject = Looper.getMainLooper();
      if ((Thread.currentThread() != ((Looper)localObject).getThread()) && (QLog.isColorLevel()))
      {
        apck.a();
        throw new NullPointerException("getVideoControl not in UI Thread");
      }
    }
    finally {}
    if (!jdField_a_of_type_Aojd.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
    {
      localObject = new aojj();
      ((aojj)localObject).b = false;
      aojj.a((aojj)localObject, paramString);
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramString + "]new VcControl");
      }
      jdField_a_of_type_Aojd.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject);
    }
    if (((aojj)jdField_a_of_type_Aojd.jdField_a_of_type_JavaUtilHashMap.get(paramString)).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory == null) {
      aojj.a((aojj)jdField_a_of_type_Aojd.jdField_a_of_type_JavaUtilHashMap.get(paramString), paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramString + "]get old VcControl");
    }
    paramString = (aojj)jdField_a_of_type_Aojd.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    return paramString;
  }
  
  public static void a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 1, "Release FileVideoManager!");
      }
      if ((jdField_a_of_type_Aojd == null) || (jdField_a_of_type_Aojd.jdField_a_of_type_JavaUtilHashMap == null) || (jdField_a_of_type_Aojd.jdField_a_of_type_JavaUtilHashMap.size() == 0))
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.i("FileVideoManager<FileAssistant>", 1, "No download return!");
        return;
      }
      Iterator localIterator = jdField_a_of_type_Aojd.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        localObject = (aojj)jdField_a_of_type_Aojd.jdField_a_of_type_JavaUtilHashMap.get(((Map.Entry)localObject).getKey());
        if (((aojj)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
        {
          ((aojj)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
          ((aojj)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
        }
        if (((aojj)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null)
        {
          if (QLog.isColorLevel())
          {
            QLog.i("FileVideoManager<FileAssistant>", 4, "[" + ((aojj)localObject).jdField_a_of_type_Aotv.a() + "]Release, stop playID[" + ((aojj)localObject).jdField_a_of_type_Int + "]");
            QLog.i("FileVideoManager<FileAssistant>", 4, "[" + ((aojj)localObject).jdField_a_of_type_Aotv.a() + "]Release, stop DownloadId[" + ((aojj)localObject).jdField_c_of_type_Int + "]");
          }
          if (((aojj)localObject).jdField_a_of_type_Int > 0)
          {
            ((aojj)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((aojj)localObject).jdField_a_of_type_Int);
            ((aojj)localObject).jdField_a_of_type_Int = -1;
          }
          if (((aojj)localObject).jdField_c_of_type_Int > 0)
          {
            ((aojj)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((aojj)localObject).jdField_c_of_type_Int);
            ((aojj)localObject).jdField_c_of_type_Int = -1;
          }
          if (((aojj)localObject).d > 0)
          {
            ((aojj)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((aojj)localObject).d);
            ((aojj)localObject).d = -1;
          }
          QLog.i("FileVideoManager<FileAssistant>", 1, "[" + ((aojj)localObject).jdField_a_of_type_Aotv.a() + "]free VideoCtrl bDownloading = false");
          ((aojj)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.setCallBackListener(20160714, null);
          ((aojj)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.DownloadDeinit(20160714);
          ((aojj)localObject).b = false;
        }
        localIterator.remove();
      }
      if (jdField_a_of_type_Aojd.jdField_a_of_type_JavaUtilHashMap.size() != 0) {
        break label421;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    jdField_a_of_type_Aojd.jdField_a_of_type_JavaUtilHashMap = null;
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
  
  public static void a(Context paramContext, aoji paramaoji)
  {
    Looper localLooper = Looper.getMainLooper();
    Handler localHandler = new Handler(localLooper);
    if (localLooper.getThread() != Thread.currentThread())
    {
      localHandler.post(new FileVideoManager.4(paramContext, paramaoji));
      return;
    }
    if (jdField_a_of_type_Aojd == null) {
      jdField_a_of_type_Aojd = new aojd();
    }
    if (jdField_a_of_type_Aojd.jdField_a_of_type_JavaUtilHashMap == null) {
      jdField_a_of_type_Aojd.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    jdField_a_of_type_Aojd.b(paramContext, paramaoji);
  }
  
  public static void a(aojj paramaojj)
  {
    Object localObject = Looper.getMainLooper();
    if ((Thread.currentThread() != ((Looper)localObject).getThread()) && (QLog.isColorLevel()))
    {
      apck.a();
      throw new NullPointerException("DownloadNext not in UI Thread");
    }
    if ((jdField_a_of_type_Aojd == null) || (jdField_a_of_type_Aojd.jdField_a_of_type_JavaUtilHashMap == null) || (jdField_a_of_type_Aojd.jdField_a_of_type_JavaUtilHashMap.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileVideoManager<FileAssistant>", 1, "download queue is zero, DeinitDownloadManager");
      }
      if ((paramaojj != null) && (paramaojj.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null))
      {
        paramaojj.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.DownloadDeinit(20160714);
        paramaojj.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr = null;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FileVideoManager<FileAssistant>", 1, "download queue is zero, return downloadNext");
      }
    }
    aojj localaojj;
    for (;;)
    {
      return;
      localObject = jdField_a_of_type_Aojd.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        localaojj = (aojj)jdField_a_of_type_Aojd.jdField_a_of_type_JavaUtilHashMap.get(str);
        if (localaojj != paramaojj) {
          break label223;
        }
        if (QLog.isColorLevel()) {
          QLog.d("FileVideoManager<FileAssistant>", 1, "[" + localaojj.hashCode() + "]find vc[" + str + "] continue");
        }
      }
    }
    label223:
    jdField_a_of_type_Aojd.jdField_a_of_type_Aojj = localaojj;
    localaojj.a(localaojj.jdField_a_of_type_Aotv, false);
  }
  
  public static void a(aotv paramaotv)
  {
    if (paramaotv.a())
    {
      a(paramaotv.a());
      return;
    }
    new Handler(Looper.getMainLooper()).post(new FileVideoManager.1(paramaotv));
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
        if ((jdField_a_of_type_Aojd != null) && (jdField_a_of_type_Aojd.jdField_a_of_type_JavaUtilHashMap != null) && (jdField_a_of_type_Aojd.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramString + "]queue is zero return");
      return;
      localObject = (aojj)jdField_a_of_type_Aojd.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      ((aojj)localObject).b = false;
      ((aojj)localObject).a();
      a((aojj)localObject);
      jdField_a_of_type_Aojd.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
    } while (!QLog.isColorLevel());
    QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramString + "]removed");
  }
  
  private void b(Context paramContext, aoji paramaoji)
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
      paramaoji.b();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FileVideoManager<FileAssistant>", 1, "TVK_SDKMgr Not Installed!");
    }
    if (badq.b(BaseApplication.getContext()) == 1) {}
    while (i != 0)
    {
      c(paramContext, paramaoji);
      bbmy.a(paramContext, paramContext.getResources().getString(2131632246), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131167766));
      return;
      i = 0;
    }
    try
    {
      babr.a(paramContext, 232, null, paramContext.getResources().getString(2131632243), new aojf(this, paramContext, paramaoji), new aojg(this, paramaoji)).show();
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
    if ((jdField_a_of_type_Aojd == null) || (jdField_a_of_type_Aojd.jdField_a_of_type_JavaUtilHashMap == null) || (jdField_a_of_type_Aojd.jdField_a_of_type_JavaUtilHashMap.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 1, "No download return!");
      }
      return;
    }
    Iterator localIterator = jdField_a_of_type_Aojd.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      localObject = (aojj)jdField_a_of_type_Aojd.jdField_a_of_type_JavaUtilHashMap.get(((Map.Entry)localObject).getKey());
      if ((((aojj)localObject).jdField_c_of_type_JavaLangString != null) || (((aojj)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null))
      {
        ((aojj)localObject).b();
        if (((aojj)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
        {
          ((aojj)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
          ((aojj)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
        }
        if (((aojj)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null)
        {
          if (QLog.isColorLevel())
          {
            QLog.i("FileVideoManager<FileAssistant>", 4, "[" + ((aojj)localObject).jdField_a_of_type_Aotv.a() + "]onNetworkChange, stop playID[" + ((aojj)localObject).jdField_a_of_type_Int + "]");
            QLog.i("FileVideoManager<FileAssistant>", 4, "[" + ((aojj)localObject).jdField_a_of_type_Aotv.a() + "]onNetworkChange, stop DownloadId[" + ((aojj)localObject).jdField_c_of_type_Int + "]");
          }
          if (((aojj)localObject).jdField_a_of_type_Int > 0)
          {
            ((aojj)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((aojj)localObject).jdField_a_of_type_Int);
            ((aojj)localObject).jdField_a_of_type_Int = -1;
          }
          if (((aojj)localObject).jdField_c_of_type_Int > 0)
          {
            ((aojj)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((aojj)localObject).jdField_c_of_type_Int);
            ((aojj)localObject).jdField_c_of_type_Int = -1;
          }
          if (((aojj)localObject).d > 0)
          {
            ((aojj)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((aojj)localObject).d);
            ((aojj)localObject).d = -1;
          }
          if (QLog.isColorLevel()) {
            QLog.i("FileVideoManager<FileAssistant>", 1, "[" + ((aojj)localObject).jdField_a_of_type_Aotv.a() + "]##########NetWorkChange########### bDownloading = false");
          }
          ((aojj)localObject).b = false;
        }
        localIterator.remove();
      }
    }
    if (jdField_a_of_type_Aojd.jdField_a_of_type_JavaUtilHashMap.size() == 0) {
      jdField_a_of_type_Aojd.jdField_a_of_type_JavaUtilHashMap = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "process all");
    }
    ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a().a(true, 3, null);
  }
  
  private void c(Context paramContext, aoji paramaoji)
  {
    System.currentTimeMillis();
    TVK_SDKMgr.installPlugin(paramContext, new aoje(this, paramaoji));
  }
  
  private static void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramString + "]DestroyMediaPlay");
    }
    if ((jdField_a_of_type_Aojd == null) || (jdField_a_of_type_Aojd.jdField_a_of_type_JavaUtilHashMap == null) || (!jdField_a_of_type_Aojd.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))) {
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramString + "]not in map return");
      }
    }
    for (;;)
    {
      return;
      aojj localaojj = (aojj)jdField_a_of_type_Aojd.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      if (localaojj.jdField_c_of_type_Boolean)
      {
        localaojj.a();
        if (QLog.isColorLevel()) {
          QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramString + "]download success return");
        }
      }
      else
      {
        if (localaojj.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
        {
          localaojj.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
          localaojj.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
        }
        if (localaojj.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null) {
          if (!localaojj.jdField_a_of_type_Aotv.a())
          {
            localaojj.a(localaojj.jdField_a_of_type_Aotv, false);
            if (localaojj.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null) {
              localaojj.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.setPlayerState(20160714, localaojj.jdField_c_of_type_Int, 6);
            }
          }
        }
        while (QLog.isColorLevel())
        {
          QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramString + "]DestroyMediaPlay,vc.bDownloading[" + localaojj.b + "]");
          return;
          a(paramString);
          continue;
          if (localaojj.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr == null) {
            a(paramString);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aojd
 * JD-Core Version:    0.7.0.1
 */