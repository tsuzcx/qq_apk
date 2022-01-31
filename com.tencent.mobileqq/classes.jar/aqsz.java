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

public class aqsz
{
  public static aqsz a;
  static boolean jdField_a_of_type_Boolean;
  private aqtf jdField_a_of_type_Aqtf;
  private HashMap<String, aqtf> jdField_a_of_type_JavaUtilHashMap;
  
  public static aqtf a(String paramString)
  {
    Object localObject;
    try
    {
      localObject = Looper.getMainLooper();
      if ((Thread.currentThread() != ((Looper)localObject).getThread()) && (QLog.isColorLevel()))
      {
        arni.a();
        throw new NullPointerException("getVideoControl not in UI Thread");
      }
    }
    finally {}
    if (!jdField_a_of_type_Aqsz.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
    {
      localObject = new aqtf();
      ((aqtf)localObject).b = false;
      aqtf.a((aqtf)localObject, paramString);
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramString + "]new VcControl");
      }
      jdField_a_of_type_Aqsz.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject);
    }
    if (((aqtf)jdField_a_of_type_Aqsz.jdField_a_of_type_JavaUtilHashMap.get(paramString)).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory == null) {
      aqtf.a((aqtf)jdField_a_of_type_Aqsz.jdField_a_of_type_JavaUtilHashMap.get(paramString), paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramString + "]get old VcControl");
    }
    paramString = (aqtf)jdField_a_of_type_Aqsz.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    return paramString;
  }
  
  public static void a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 1, "Release FileVideoManager!");
      }
      if ((jdField_a_of_type_Aqsz == null) || (jdField_a_of_type_Aqsz.jdField_a_of_type_JavaUtilHashMap == null) || (jdField_a_of_type_Aqsz.jdField_a_of_type_JavaUtilHashMap.size() == 0))
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.i("FileVideoManager<FileAssistant>", 1, "No download return!");
        return;
      }
      Iterator localIterator = jdField_a_of_type_Aqsz.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        localObject = (aqtf)jdField_a_of_type_Aqsz.jdField_a_of_type_JavaUtilHashMap.get(((Map.Entry)localObject).getKey());
        if (((aqtf)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
        {
          ((aqtf)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
          ((aqtf)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
        }
        if (((aqtf)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null)
        {
          if (QLog.isColorLevel())
          {
            QLog.i("FileVideoManager<FileAssistant>", 4, "[" + ((aqtf)localObject).jdField_a_of_type_Arek.a() + "]Release, stop playID[" + ((aqtf)localObject).jdField_a_of_type_Int + "]");
            QLog.i("FileVideoManager<FileAssistant>", 4, "[" + ((aqtf)localObject).jdField_a_of_type_Arek.a() + "]Release, stop DownloadId[" + ((aqtf)localObject).jdField_c_of_type_Int + "]");
          }
          if (((aqtf)localObject).jdField_a_of_type_Int > 0)
          {
            ((aqtf)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((aqtf)localObject).jdField_a_of_type_Int);
            ((aqtf)localObject).jdField_a_of_type_Int = -1;
          }
          if (((aqtf)localObject).jdField_c_of_type_Int > 0)
          {
            ((aqtf)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((aqtf)localObject).jdField_c_of_type_Int);
            ((aqtf)localObject).jdField_c_of_type_Int = -1;
          }
          if (((aqtf)localObject).d > 0)
          {
            ((aqtf)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((aqtf)localObject).d);
            ((aqtf)localObject).d = -1;
          }
          QLog.i("FileVideoManager<FileAssistant>", 1, "[" + ((aqtf)localObject).jdField_a_of_type_Arek.a() + "]free VideoCtrl bDownloading = false");
          ((aqtf)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.setCallBackListener(20160714, null);
          ((aqtf)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.DownloadDeinit(20160714);
          ((aqtf)localObject).b = false;
        }
        localIterator.remove();
      }
      if (jdField_a_of_type_Aqsz.jdField_a_of_type_JavaUtilHashMap.size() != 0) {
        break label421;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    jdField_a_of_type_Aqsz.jdField_a_of_type_JavaUtilHashMap = null;
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
  
  public static void a(Context paramContext, aqte paramaqte)
  {
    Looper localLooper = Looper.getMainLooper();
    Handler localHandler = new Handler(localLooper);
    if (localLooper.getThread() != Thread.currentThread())
    {
      localHandler.post(new FileVideoManager.4(paramContext, paramaqte));
      return;
    }
    if (jdField_a_of_type_Aqsz == null) {
      jdField_a_of_type_Aqsz = new aqsz();
    }
    if (jdField_a_of_type_Aqsz.jdField_a_of_type_JavaUtilHashMap == null) {
      jdField_a_of_type_Aqsz.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    jdField_a_of_type_Aqsz.b(paramContext, paramaqte);
  }
  
  public static void a(aqtf paramaqtf)
  {
    Object localObject = Looper.getMainLooper();
    if ((Thread.currentThread() != ((Looper)localObject).getThread()) && (QLog.isColorLevel()))
    {
      arni.a();
      throw new NullPointerException("DownloadNext not in UI Thread");
    }
    if ((jdField_a_of_type_Aqsz == null) || (jdField_a_of_type_Aqsz.jdField_a_of_type_JavaUtilHashMap == null) || (jdField_a_of_type_Aqsz.jdField_a_of_type_JavaUtilHashMap.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileVideoManager<FileAssistant>", 1, "download queue is zero, DeinitDownloadManager");
      }
      if ((paramaqtf != null) && (paramaqtf.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null))
      {
        paramaqtf.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.DownloadDeinit(20160714);
        paramaqtf.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr = null;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FileVideoManager<FileAssistant>", 1, "download queue is zero, return downloadNext");
      }
    }
    aqtf localaqtf;
    for (;;)
    {
      return;
      localObject = jdField_a_of_type_Aqsz.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        localaqtf = (aqtf)jdField_a_of_type_Aqsz.jdField_a_of_type_JavaUtilHashMap.get(str);
        if (localaqtf != paramaqtf) {
          break label223;
        }
        if (QLog.isColorLevel()) {
          QLog.d("FileVideoManager<FileAssistant>", 1, "[" + localaqtf.hashCode() + "]find vc[" + str + "] continue");
        }
      }
    }
    label223:
    jdField_a_of_type_Aqsz.jdField_a_of_type_Aqtf = localaqtf;
    localaqtf.a(localaqtf.jdField_a_of_type_Arek, false);
  }
  
  public static void a(arek paramarek)
  {
    if (paramarek.a())
    {
      a(paramarek.a());
      return;
    }
    new Handler(Looper.getMainLooper()).post(new FileVideoManager.1(paramarek));
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
        if ((jdField_a_of_type_Aqsz != null) && (jdField_a_of_type_Aqsz.jdField_a_of_type_JavaUtilHashMap != null) && (jdField_a_of_type_Aqsz.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramString + "]queue is zero return");
      return;
      localObject = (aqtf)jdField_a_of_type_Aqsz.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      ((aqtf)localObject).b = false;
      ((aqtf)localObject).a();
      a((aqtf)localObject);
      jdField_a_of_type_Aqsz.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
    } while (!QLog.isColorLevel());
    QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramString + "]removed");
  }
  
  private void b(Context paramContext, aqte paramaqte)
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
      paramaqte.b();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FileVideoManager<FileAssistant>", 1, "TVK_SDKMgr Not Installed!");
    }
    if (bdee.b(BaseApplication.getContext()) == 1) {}
    while (i != 0)
    {
      c(paramContext, paramaqte);
      QQToast.a(paramContext, paramContext.getResources().getString(2131698158), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131298914));
      return;
      i = 0;
    }
    try
    {
      bdcd.a(paramContext, 232, null, paramContext.getResources().getString(2131698155), new aqtb(this, paramContext, paramaqte), new aqtc(this, paramaqte)).show();
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
    if ((jdField_a_of_type_Aqsz == null) || (jdField_a_of_type_Aqsz.jdField_a_of_type_JavaUtilHashMap == null) || (jdField_a_of_type_Aqsz.jdField_a_of_type_JavaUtilHashMap.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 1, "No download return!");
      }
      return;
    }
    Iterator localIterator = jdField_a_of_type_Aqsz.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      localObject = (aqtf)jdField_a_of_type_Aqsz.jdField_a_of_type_JavaUtilHashMap.get(((Map.Entry)localObject).getKey());
      if ((((aqtf)localObject).jdField_c_of_type_JavaLangString != null) || (((aqtf)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null))
      {
        ((aqtf)localObject).b();
        if (((aqtf)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
        {
          ((aqtf)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
          ((aqtf)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
        }
        if (((aqtf)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null)
        {
          if (QLog.isColorLevel())
          {
            QLog.i("FileVideoManager<FileAssistant>", 4, "[" + ((aqtf)localObject).jdField_a_of_type_Arek.a() + "]onNetworkChange, stop playID[" + ((aqtf)localObject).jdField_a_of_type_Int + "]");
            QLog.i("FileVideoManager<FileAssistant>", 4, "[" + ((aqtf)localObject).jdField_a_of_type_Arek.a() + "]onNetworkChange, stop DownloadId[" + ((aqtf)localObject).jdField_c_of_type_Int + "]");
          }
          if (((aqtf)localObject).jdField_a_of_type_Int > 0)
          {
            ((aqtf)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((aqtf)localObject).jdField_a_of_type_Int);
            ((aqtf)localObject).jdField_a_of_type_Int = -1;
          }
          if (((aqtf)localObject).jdField_c_of_type_Int > 0)
          {
            ((aqtf)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((aqtf)localObject).jdField_c_of_type_Int);
            ((aqtf)localObject).jdField_c_of_type_Int = -1;
          }
          if (((aqtf)localObject).d > 0)
          {
            ((aqtf)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((aqtf)localObject).d);
            ((aqtf)localObject).d = -1;
          }
          if (QLog.isColorLevel()) {
            QLog.i("FileVideoManager<FileAssistant>", 1, "[" + ((aqtf)localObject).jdField_a_of_type_Arek.a() + "]##########NetWorkChange########### bDownloading = false");
          }
          ((aqtf)localObject).b = false;
        }
        localIterator.remove();
      }
    }
    if (jdField_a_of_type_Aqsz.jdField_a_of_type_JavaUtilHashMap.size() == 0) {
      jdField_a_of_type_Aqsz.jdField_a_of_type_JavaUtilHashMap = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "process all");
    }
    ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a().a(true, 3, null);
  }
  
  private void c(Context paramContext, aqte paramaqte)
  {
    System.currentTimeMillis();
    TVK_SDKMgr.installPlugin(paramContext, new aqta(this, paramaqte));
  }
  
  private static void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramString + "]DestroyMediaPlay");
    }
    if ((jdField_a_of_type_Aqsz == null) || (jdField_a_of_type_Aqsz.jdField_a_of_type_JavaUtilHashMap == null) || (!jdField_a_of_type_Aqsz.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))) {
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramString + "]not in map return");
      }
    }
    for (;;)
    {
      return;
      aqtf localaqtf = (aqtf)jdField_a_of_type_Aqsz.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      if (localaqtf.jdField_c_of_type_Boolean)
      {
        localaqtf.a();
        if (QLog.isColorLevel()) {
          QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramString + "]download success return");
        }
      }
      else
      {
        if (localaqtf.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
        {
          localaqtf.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
          localaqtf.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
        }
        if (localaqtf.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null) {
          if (!localaqtf.jdField_a_of_type_Arek.a())
          {
            localaqtf.a(localaqtf.jdField_a_of_type_Arek, false);
            if (localaqtf.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null) {
              localaqtf.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.setPlayerState(20160714, localaqtf.jdField_c_of_type_Int, 6);
            }
          }
        }
        while (QLog.isColorLevel())
        {
          QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramString + "]DestroyMediaPlay,vc.bDownloading[" + localaqtf.b + "]");
          return;
          a(paramString);
          continue;
          if (localaqtf.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr == null) {
            a(paramString);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqsz
 * JD-Core Version:    0.7.0.1
 */