import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.cache.FileCacheService;
import cooperation.qzone.util.QZoneHttpDownloadUtil;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class ands
  implements Runnable
{
  public ands(String paramString1, String paramString2, int paramInt, String paramString3, AppInterface paramAppInterface) {}
  
  public void run()
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.i("QzoneZipCacheHelper", 2, String.format("delay 10s,url:%s,path:%s", new Object[] { this.jdField_a_of_type_JavaLangString, this.b }));
    }
    ??? = new File(this.b);
    boolean bool1 = bool2;
    if (((File)???).exists())
    {
      bool1 = bool2;
      if (((File)???).isDirectory())
      {
        ??? = ((File)???).listFiles();
        bool1 = bool2;
        if (??? != null) {
          if (this.jdField_a_of_type_Int != -1)
          {
            bool1 = bool2;
            if (???.length != this.jdField_a_of_type_Int) {}
          }
          else
          {
            bool1 = bool2;
            if (???.length > 0) {
              bool1 = true;
            }
          }
        }
      }
    }
    boolean bool3 = bool1;
    for (;;)
    {
      try
      {
        ??? = new File(this.b + ".zip");
        bool2 = bool1;
        if (!bool1)
        {
          bool3 = bool1;
          localObject2 = QZoneHttpDownloadUtil.b(this.c);
          bool3 = bool1;
          bool1 = QZoneHttpDownloadUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, (String)localObject2, (File)???);
          if (!bool1) {
            continue;
          }
          bool3 = bool1;
          QzoneZipCacheHelper.unzipFile(((File)???).getAbsolutePath(), this.b);
          bool3 = bool1;
          QzoneZipCacheHelper.access$100().a(this.b, true);
          bool2 = bool1;
          bool3 = bool1;
          if (QLog.isColorLevel())
          {
            bool3 = bool1;
            QLog.i("QzoneZipCacheHelper", 2, String.format("download succ,path:%s", new Object[] { this.b }));
            bool2 = bool1;
          }
        }
        bool3 = bool2;
        if (((File)???).exists())
        {
          bool3 = bool2;
          FileUtil.a((File)???);
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject2;
        Object localObject4;
        bool2 = bool3;
        continue;
        QzoneZipCacheHelper.access$300().remove(this.c);
      }
      synchronized (QzoneZipCacheHelper.access$200())
      {
        if (QzoneZipCacheHelper.access$300() == null) {
          continue;
        }
        localObject2 = (CopyOnWriteArrayList)QzoneZipCacheHelper.access$300().get(this.c);
        if (localObject2 == null) {
          continue;
        }
        localObject2 = ((CopyOnWriteArrayList)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          continue;
        }
        localObject4 = ((Iterator)localObject2).next();
        if (!(localObject4 instanceof QzoneZipCacheHelperCallBack)) {
          continue;
        }
        ((QzoneZipCacheHelperCallBack)localObject4).onResult(bool2);
        ((QzoneZipCacheHelperCallBack)localObject4).onResultOfNativeRequest(true, this.b, this.c);
      }
      bool2 = bool1;
      bool3 = bool1;
      if (QLog.isColorLevel())
      {
        bool3 = bool1;
        QLog.i("QzoneZipCacheHelper", 2, String.format("download fail,url:%s,path:%s", new Object[] { localObject3, this.b }));
        bool2 = bool1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ands
 * JD-Core Version:    0.7.0.1
 */