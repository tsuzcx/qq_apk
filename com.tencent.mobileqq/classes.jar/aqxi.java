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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IDownloadMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class aqxi
{
  public static aqxi a;
  static boolean jdField_a_of_type_Boolean;
  private aqxo jdField_a_of_type_Aqxo;
  private HashMap<String, aqxo> jdField_a_of_type_JavaUtilHashMap;
  
  public static aqxo a(String paramString)
  {
    Object localObject;
    try
    {
      localObject = Looper.getMainLooper();
      if ((Thread.currentThread() != ((Looper)localObject).getThread()) && (QLog.isColorLevel()))
      {
        arrr.a();
        throw new NullPointerException("getVideoControl not in UI Thread");
      }
    }
    finally {}
    if (!jdField_a_of_type_Aqxi.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
    {
      localObject = new aqxo();
      ((aqxo)localObject).b = false;
      aqxo.a((aqxo)localObject, paramString);
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramString + "]new VcControl");
      }
      jdField_a_of_type_Aqxi.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject);
    }
    if (((aqxo)jdField_a_of_type_Aqxi.jdField_a_of_type_JavaUtilHashMap.get(paramString)).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory == null) {
      aqxo.a((aqxo)jdField_a_of_type_Aqxi.jdField_a_of_type_JavaUtilHashMap.get(paramString), paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramString + "]get old VcControl");
    }
    paramString = (aqxo)jdField_a_of_type_Aqxi.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    return paramString;
  }
  
  public static void a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 1, "Release FileVideoManager!");
      }
      if ((jdField_a_of_type_Aqxi == null) || (jdField_a_of_type_Aqxi.jdField_a_of_type_JavaUtilHashMap == null) || (jdField_a_of_type_Aqxi.jdField_a_of_type_JavaUtilHashMap.size() == 0))
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.i("FileVideoManager<FileAssistant>", 1, "No download return!");
        return;
      }
      Iterator localIterator = jdField_a_of_type_Aqxi.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        localObject = (aqxo)jdField_a_of_type_Aqxi.jdField_a_of_type_JavaUtilHashMap.get(((Map.Entry)localObject).getKey());
        if (((aqxo)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
        {
          ((aqxo)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
          ((aqxo)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
        }
        if (((aqxo)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null)
        {
          if (QLog.isColorLevel())
          {
            QLog.i("FileVideoManager<FileAssistant>", 4, "[" + ((aqxo)localObject).jdField_a_of_type_Arit.a() + "]Release, stop playID[" + ((aqxo)localObject).jdField_a_of_type_Int + "]");
            QLog.i("FileVideoManager<FileAssistant>", 4, "[" + ((aqxo)localObject).jdField_a_of_type_Arit.a() + "]Release, stop DownloadId[" + ((aqxo)localObject).jdField_c_of_type_Int + "]");
          }
          if (((aqxo)localObject).jdField_a_of_type_Int > 0)
          {
            ((aqxo)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((aqxo)localObject).jdField_a_of_type_Int);
            ((aqxo)localObject).jdField_a_of_type_Int = -1;
          }
          if (((aqxo)localObject).jdField_c_of_type_Int > 0)
          {
            ((aqxo)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((aqxo)localObject).jdField_c_of_type_Int);
            ((aqxo)localObject).jdField_c_of_type_Int = -1;
          }
          if (((aqxo)localObject).d > 0)
          {
            ((aqxo)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((aqxo)localObject).d);
            ((aqxo)localObject).d = -1;
          }
          QLog.i("FileVideoManager<FileAssistant>", 1, "[" + ((aqxo)localObject).jdField_a_of_type_Arit.a() + "]free VideoCtrl bDownloading = false");
          ((aqxo)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.setCallBackListener(20160714, null);
          ((aqxo)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.DownloadDeinit(20160714);
          ((aqxo)localObject).b = false;
        }
        localIterator.remove();
      }
      if (jdField_a_of_type_Aqxi.jdField_a_of_type_JavaUtilHashMap.size() != 0) {
        break label421;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    jdField_a_of_type_Aqxi.jdField_a_of_type_JavaUtilHashMap = null;
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
  
  public static void a(Context paramContext, aqxn paramaqxn)
  {
    Looper localLooper = Looper.getMainLooper();
    Handler localHandler = new Handler(localLooper);
    if (localLooper.getThread() != Thread.currentThread())
    {
      localHandler.post(new FileVideoManager.4(paramContext, paramaqxn));
      return;
    }
    if (jdField_a_of_type_Aqxi == null) {
      jdField_a_of_type_Aqxi = new aqxi();
    }
    if (jdField_a_of_type_Aqxi.jdField_a_of_type_JavaUtilHashMap == null) {
      jdField_a_of_type_Aqxi.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    jdField_a_of_type_Aqxi.b(paramContext, paramaqxn);
  }
  
  public static void a(aqxo paramaqxo)
  {
    Object localObject = Looper.getMainLooper();
    if ((Thread.currentThread() != ((Looper)localObject).getThread()) && (QLog.isColorLevel()))
    {
      arrr.a();
      throw new NullPointerException("DownloadNext not in UI Thread");
    }
    if ((jdField_a_of_type_Aqxi == null) || (jdField_a_of_type_Aqxi.jdField_a_of_type_JavaUtilHashMap == null) || (jdField_a_of_type_Aqxi.jdField_a_of_type_JavaUtilHashMap.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileVideoManager<FileAssistant>", 1, "download queue is zero, DeinitDownloadManager");
      }
      if ((paramaqxo != null) && (paramaqxo.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null))
      {
        paramaqxo.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.DownloadDeinit(20160714);
        paramaqxo.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr = null;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FileVideoManager<FileAssistant>", 1, "download queue is zero, return downloadNext");
      }
    }
    aqxo localaqxo;
    for (;;)
    {
      return;
      localObject = jdField_a_of_type_Aqxi.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        localaqxo = (aqxo)jdField_a_of_type_Aqxi.jdField_a_of_type_JavaUtilHashMap.get(str);
        if (localaqxo != paramaqxo) {
          break label223;
        }
        if (QLog.isColorLevel()) {
          QLog.d("FileVideoManager<FileAssistant>", 1, "[" + localaqxo.hashCode() + "]find vc[" + str + "] continue");
        }
      }
    }
    label223:
    jdField_a_of_type_Aqxi.jdField_a_of_type_Aqxo = localaqxo;
    localaqxo.a(localaqxo.jdField_a_of_type_Arit, false);
  }
  
  public static void a(arit paramarit)
  {
    if (paramarit.a())
    {
      a(paramarit.a());
      return;
    }
    new Handler(Looper.getMainLooper()).post(new FileVideoManager.1(paramarit));
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
        if ((jdField_a_of_type_Aqxi != null) && (jdField_a_of_type_Aqxi.jdField_a_of_type_JavaUtilHashMap != null) && (jdField_a_of_type_Aqxi.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramString + "]queue is zero return");
      return;
      localObject = (aqxo)jdField_a_of_type_Aqxi.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      ((aqxo)localObject).b = false;
      ((aqxo)localObject).a();
      a((aqxo)localObject);
      jdField_a_of_type_Aqxi.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
    } while (!QLog.isColorLevel());
    QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramString + "]removed");
  }
  
  private void b(Context paramContext, aqxn paramaqxn)
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
      paramaqxn.b();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FileVideoManager<FileAssistant>", 1, "TVK_SDKMgr Not Installed!");
    }
    if (bdin.b(BaseApplication.getContext()) == 1) {}
    while (i != 0)
    {
      c(paramContext, paramaqxn);
      QQToast.a(paramContext, paramContext.getResources().getString(2131698160), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131298914));
      return;
      i = 0;
    }
    try
    {
      bdgm.a(paramContext, 232, null, paramContext.getResources().getString(2131698157), new aqxk(this, paramContext, paramaqxn), new aqxl(this, paramaqxn)).show();
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
    if ((jdField_a_of_type_Aqxi == null) || (jdField_a_of_type_Aqxi.jdField_a_of_type_JavaUtilHashMap == null) || (jdField_a_of_type_Aqxi.jdField_a_of_type_JavaUtilHashMap.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 1, "No download return!");
      }
      return;
    }
    Iterator localIterator = jdField_a_of_type_Aqxi.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      localObject = (aqxo)jdField_a_of_type_Aqxi.jdField_a_of_type_JavaUtilHashMap.get(((Map.Entry)localObject).getKey());
      if ((((aqxo)localObject).jdField_c_of_type_JavaLangString != null) || (((aqxo)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null))
      {
        ((aqxo)localObject).b();
        if (((aqxo)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
        {
          ((aqxo)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
          ((aqxo)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
        }
        if (((aqxo)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null)
        {
          if (QLog.isColorLevel())
          {
            QLog.i("FileVideoManager<FileAssistant>", 4, "[" + ((aqxo)localObject).jdField_a_of_type_Arit.a() + "]onNetworkChange, stop playID[" + ((aqxo)localObject).jdField_a_of_type_Int + "]");
            QLog.i("FileVideoManager<FileAssistant>", 4, "[" + ((aqxo)localObject).jdField_a_of_type_Arit.a() + "]onNetworkChange, stop DownloadId[" + ((aqxo)localObject).jdField_c_of_type_Int + "]");
          }
          if (((aqxo)localObject).jdField_a_of_type_Int > 0)
          {
            ((aqxo)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((aqxo)localObject).jdField_a_of_type_Int);
            ((aqxo)localObject).jdField_a_of_type_Int = -1;
          }
          if (((aqxo)localObject).jdField_c_of_type_Int > 0)
          {
            ((aqxo)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((aqxo)localObject).jdField_c_of_type_Int);
            ((aqxo)localObject).jdField_c_of_type_Int = -1;
          }
          if (((aqxo)localObject).d > 0)
          {
            ((aqxo)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((aqxo)localObject).d);
            ((aqxo)localObject).d = -1;
          }
          if (QLog.isColorLevel()) {
            QLog.i("FileVideoManager<FileAssistant>", 1, "[" + ((aqxo)localObject).jdField_a_of_type_Arit.a() + "]##########NetWorkChange########### bDownloading = false");
          }
          ((aqxo)localObject).b = false;
        }
        localIterator.remove();
      }
    }
    if (jdField_a_of_type_Aqxi.jdField_a_of_type_JavaUtilHashMap.size() == 0) {
      jdField_a_of_type_Aqxi.jdField_a_of_type_JavaUtilHashMap = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "process all");
    }
    ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a().a(true, 3, null);
  }
  
  private void c(Context paramContext, aqxn paramaqxn)
  {
    System.currentTimeMillis();
    TVK_SDKMgr.installPlugin(paramContext, new aqxj(this, paramaqxn));
  }
  
  private static void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramString + "]DestroyMediaPlay");
    }
    if ((jdField_a_of_type_Aqxi == null) || (jdField_a_of_type_Aqxi.jdField_a_of_type_JavaUtilHashMap == null) || (!jdField_a_of_type_Aqxi.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))) {
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramString + "]not in map return");
      }
    }
    for (;;)
    {
      return;
      aqxo localaqxo = (aqxo)jdField_a_of_type_Aqxi.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      if (localaqxo.jdField_c_of_type_Boolean)
      {
        localaqxo.a();
        if (QLog.isColorLevel()) {
          QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramString + "]download success return");
        }
      }
      else
      {
        if (localaqxo.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
        {
          localaqxo.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
          localaqxo.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
        }
        if (localaqxo.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null) {
          if (!localaqxo.jdField_a_of_type_Arit.a())
          {
            localaqxo.a(localaqxo.jdField_a_of_type_Arit, false);
            if (localaqxo.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null) {
              localaqxo.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.setPlayerState(20160714, localaqxo.jdField_c_of_type_Int, 6);
            }
          }
        }
        while (QLog.isColorLevel())
        {
          QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramString + "]DestroyMediaPlay,vc.bDownloading[" + localaqxo.b + "]");
          return;
          a(paramString);
          continue;
          if (localaqxo.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr == null) {
            a(paramString);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqxi
 * JD-Core Version:    0.7.0.1
 */