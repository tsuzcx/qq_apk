import android.content.Intent;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import com.tencent.mobileqq.shortvideo.aekit.AEResDownloader.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.log.LogUtils;
import cooperation.qzone.QZoneVideoDownloadActivity;
import dov.com.tencent.mobileqq.richmedia.capture.fragment.CaptureQmcfSoDownloadFragment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class awgh
  implements awfg, awfi
{
  private static final awgh jdField_a_of_type_Awgh = new awgh();
  private static final String jdField_a_of_type_JavaLangString = awgh.class.getSimpleName();
  private HashMap<Integer, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<awgj> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private List<ShortVideoResourceManager.SVConfigItem> b;
  
  public static awgh a()
  {
    return jdField_a_of_type_Awgh;
  }
  
  private void a(String paramString)
  {
    int i = 0;
    if (paramString.startsWith("new_qq_android_native_short_filter_"))
    {
      i = Integer.parseInt(paramString.substring("new_qq_android_native_short_filter_".length()));
      bgxb.a().a("aekit_base_resource_version", i, 4);
    }
    for (;;)
    {
      LogUtils.d(jdField_a_of_type_JavaLangString, "[updateAEResVersion] updateAEResVersion name = " + paramString + ", version = " + i);
      return;
      if (paramString.startsWith("new_qq_android_native_ptu_res_"))
      {
        i = Integer.parseInt(paramString.substring("new_qq_android_native_ptu_res_".length()));
        bgxb.a().a("aekit_additional_resource_version", i, 4);
      }
    }
  }
  
  public void I_()
  {
    LogUtils.w(jdField_a_of_type_JavaLangString, ajjy.a(2131634207));
    awek.a(3, -1500);
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          if (((awgj)localIterator.next() instanceof CaptureQmcfSoDownloadFragment)) {
            localIterator.remove();
          }
        }
      }
    }
    finally {}
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QQAppInterface localQQAppInterface;
    ArrayList localArrayList;
    axxj localaxxj;
    Object localObject;
    ShortVideoResourceManager.SVConfigItem localSVConfigItem;
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        bhcs.b(jdField_a_of_type_JavaLangString, 4, Log.getStackTraceString(new Throwable()));
        LogUtils.d(jdField_a_of_type_JavaLangString, ajjy.a(2131634213));
        bhcs.b(jdField_a_of_type_JavaLangString, 1, ajjy.a(2131634213));
        ShortVideoResourceManager.a(ajjy.a(2131634212));
        awek.a(1, paramInt2);
        return;
      }
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a(localQQAppInterface, localArrayList);
      if (paramInt1 == 0) {
        if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(0))) && (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(0))).intValue() == 1))
        {
          this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(0), Integer.valueOf(2));
          localaxxj = (axxj)localQQAppInterface.getManager(193);
          localObject = localArrayList.iterator();
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localSVConfigItem = (ShortVideoResourceManager.SVConfigItem)((Iterator)localObject).next();
          } while (!localSVConfigItem.name.startsWith("new_qq_android_native_short_filter_"));
        }
      }
    }
    for (;;)
    {
      if ((localaxxj.a()) && (!this.jdField_a_of_type_Boolean))
      {
        localObject = new awgi(this, localQQAppInterface, "qq_camera_res", new AEResDownloader.1(this, localQQAppInterface, localArrayList, this), 4000L);
        if (localSVConfigItem != null)
        {
          boolean bool = localaxxj.a(10090, null, localSVConfigItem.name, 0, localSVConfigItem.armv7a_url, ShortVideoResourceManager.a(localSVConfigItem.name), 4, 0, true, (axxg)localObject);
          bhcs.a(jdField_a_of_type_JavaLangString, 1, "【onConfigResult】ctrl.requestPreDownload :" + bool);
          if (!bool) {
            ShortVideoResourceManager.b(localQQAppInterface, localArrayList, this);
          }
        }
      }
      while ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(1))) && (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1))).intValue() == 1))
      {
        if ((!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(0))) || (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(0))).intValue() != 2)) {
          break label468;
        }
        bhcs.a(jdField_a_of_type_JavaLangString, 1, "[onConfigResult] AEKIT_ADDITIONAL_PACKAGE waiting for AEKIT_BASE_PACKAGE ready");
        this.b = localArrayList;
        return;
        bhcs.a(jdField_a_of_type_JavaLangString, 1, "【AEResDownloader】svChooseConfigItem == null");
        continue;
        if (localaxxj.a()) {
          localaxxj.a(localSVConfigItem.armv7a_url);
        }
        ShortVideoResourceManager.b(localQQAppInterface, localArrayList, this);
        bhcs.a(jdField_a_of_type_JavaLangString, 1, "【AEResDownloader】follow doUserDownloadResourceFilterAsync");
      }
      break;
      label468:
      bhcs.a(jdField_a_of_type_JavaLangString, 1, "[onConfigResult] AEKIT_ADDITIONAL_PACKAGE:doUserDownloadResourceAsync");
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1), Integer.valueOf(2));
      awex.a(localQQAppInterface, localArrayList, this);
      return;
      bhcs.c(jdField_a_of_type_JavaLangString, 1, "[onConfigResult] checkConfigResourceIsOK, errCode = " + paramInt1);
      bhcs.b(jdField_a_of_type_JavaLangString, 4, Log.getStackTraceString(new Throwable()));
      ShortVideoResourceManager.a(ajjy.a(2131634210));
      awek.a(1, paramInt1);
      return;
      if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(0))) && (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(0))).intValue() == 1)) {
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(0), Integer.valueOf(0));
      }
      bhcs.b(jdField_a_of_type_JavaLangString, 4, Log.getStackTraceString(new Throwable()));
      ShortVideoResourceManager.a(ajjy.a(2131634211));
      awek.a(1, paramInt2);
      return;
      localSVConfigItem = null;
    }
  }
  
  public void a(int paramInt, awgj paramawgj)
  {
    if ((badq.h(null)) && (badq.g(null))) {}
    for (boolean bool = true; !bool; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "[requestAEKitDownloadInWifi] Wi-Fi无法链接，无法下载素材依赖包, netUsable = " + bool);
      }
      return;
    }
    bhcs.a(jdField_a_of_type_JavaLangString, 1, "【START】[requestAEKitDownloadInWifi]");
    b(paramInt, paramawgj);
  }
  
  public void a(awgj paramawgj)
  {
    if (paramawgj == null) {}
    while (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(paramawgj);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    boolean bool2 = false;
    boolean bool3 = true;
    LogUtils.d(jdField_a_of_type_JavaLangString, "[onDownloadFinish] name = " + paramString1 + ", totalLen = " + paramInt + ", filePath = " + paramString2);
    int i;
    if ((paramInt == 0) || (paramInt == 1))
    {
      i = 0;
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "[onDownloadFinish] name = " + paramString1 + ", totalLen = " + paramInt + ", filePath = " + paramString2);
      }
      if (!paramString1.startsWith("new_qq_android_native_short_filter_")) {
        break label416;
      }
      bhcs.a(jdField_a_of_type_JavaLangString, 1, "[onDownloadFinish] AEKIT_BASE_PACKAGE, result = " + paramInt + ", name = " + paramString1 + ", filePath = " + paramString2);
      if (i != 0) {
        break label309;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(0), Integer.valueOf(3));
      paramString2 = new Intent();
      paramString2.setAction("key_notify_filter_so_ready");
      paramString2.setPackage(BaseApplicationImpl.getContext().getPackageName());
      BaseApplicationImpl.getContext().sendBroadcast(paramString2);
      a(paramString1);
      label233:
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label334;
      }
      paramString1 = this.jdField_a_of_type_JavaUtilList.iterator();
      label262:
      if (!paramString1.hasNext()) {
        break label334;
      }
      paramString2 = (awgj)paramString1.next();
      if (i != 0) {
        break label328;
      }
    }
    label309:
    label328:
    for (boolean bool1 = true;; bool1 = false)
    {
      paramString2.a(0, bool1, i);
      break label262;
      i = paramInt;
      break;
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(0), Integer.valueOf(0));
      break label233;
    }
    label334:
    if (paramInt != 1)
    {
      paramString1 = bhci.a();
      bool1 = bool2;
      if (paramInt == 0) {
        bool1 = true;
      }
      paramString1.b(bool1);
    }
    if (this.b != null)
    {
      bhcs.a(jdField_a_of_type_JavaLangString, 1, "【onDownloadFinish】 【AEKIT_ADDITIONAL_PACKAGE】Download Start after AEKIT_BASE_PACKAGE");
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1), Integer.valueOf(2));
      awex.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), this.b, this);
      this.b = null;
    }
    label416:
    label561:
    label621:
    do
    {
      do
      {
        return;
      } while (!paramString1.startsWith("new_qq_android_native_ptu_res_"));
      bhcs.a(jdField_a_of_type_JavaLangString, 1, "[onDownloadFinish] AEKIT_ADDITIONAL_PACKAGE, result = " + paramInt + ", name = " + paramString1 + ", filePath = " + paramString2);
      if (i == 0)
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1), Integer.valueOf(3));
        paramString2 = new Intent();
        paramString2.setAction("key_notify_ptures_so_ready");
        paramString2.setPackage(BaseApplicationImpl.getContext().getPackageName());
        BaseApplicationImpl.getContext().sendBroadcast(paramString2);
        a(paramString1);
        if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
          continue;
        }
        paramString1 = this.jdField_a_of_type_JavaUtilList.iterator();
        if (!paramString1.hasNext()) {
          continue;
        }
        paramString2 = (awgj)paramString1.next();
        if (i != 0) {
          break label621;
        }
      }
      for (bool1 = true;; bool1 = false)
      {
        paramString2.a(1, bool1, i);
        break label561;
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1), Integer.valueOf(0));
        break;
      }
    } while (paramInt == 1);
    paramString1 = bhci.a();
    if (paramInt == 0) {}
    for (bool1 = bool3;; bool1 = false)
    {
      paramString1.c(bool1);
      return;
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    bhcs.a(jdField_a_of_type_JavaLangString, 1, "[onUpdateProgress] name = " + paramString + ", totalLen = " + paramLong2 + ", curOffset = " + paramLong1);
    if (paramString.startsWith("new_qq_android_native_short_filter_"))
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(0), Integer.valueOf(2));
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        paramString = this.jdField_a_of_type_JavaUtilList.iterator();
        while (paramString.hasNext()) {
          ((awgj)paramString.next()).a(0, paramLong1, paramLong2);
        }
      }
    }
    else if (paramString.startsWith("new_qq_android_native_ptu_res_"))
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1), Integer.valueOf(2));
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        paramString = this.jdField_a_of_type_JavaUtilList.iterator();
        while (paramString.hasNext()) {
          ((awgj)paramString.next()).a(1, paramLong1, paramLong2);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b(int paramInt, awgj paramawgj)
  {
    bhcs.a(jdField_a_of_type_JavaLangString, 1, "【START】[requestAEKitDownload] + BEGIN, index = " + paramInt);
    LogUtils.setEnable(true);
    boolean bool = badq.g(null);
    if (!bool)
    {
      LogUtils.d(jdField_a_of_type_JavaLangString, ajjy.a(2131634208) + bool);
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "[requestAEKitDownload] 网络存在问题，无法下载素材依赖包, netUsable = " + bool);
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_JavaUtilHashMap != null) {
        break;
      }
      LogUtils.e(jdField_a_of_type_JavaLangString, "[requestAEKitDownload] statusMap == null");
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, "[requestAEKitDownload] statusMap == null");
    return;
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), Integer.valueOf(0));
    }
    if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt)))) {}
    for (int i = ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt))).intValue();; i = 0)
    {
      if (i == 3)
      {
        LogUtils.w(jdField_a_of_type_JavaLangString, "[requestAEKitDownload] status is DOWNLOAND_STATUS_READY, callback onAEResDownloadResult");
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "[requestAEKitDownload] status is DOWNLOAND_STATUS_READY, callback onAEResDownloadResult");
        }
        if (paramawgj == null) {
          break;
        }
        paramawgj.a(paramInt, true, 0);
        return;
      }
      if ((i == 2) || (i == 1))
      {
        LogUtils.w(jdField_a_of_type_JavaLangString, "[requestAEKitDownload] status is DOWNLOAND_STATUS_DOWNLOADING || DOWNLOAND_STATUS_DOWNLOADING, add callback");
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "[requestAEKitDownload] status is DOWNLOAND_STATUS_DOWNLOADING || DOWNLOAND_STATUS_DOWNLOADING, add callback");
        }
        a(paramawgj);
        return;
      }
      a(paramawgj);
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), Integer.valueOf(1));
      ShortVideoResourceManager.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), this);
      bhcs.a(jdField_a_of_type_JavaLangString, 1, "【START】requestAEKitDownload-ShortVideoResourceManager.startUserDownloadConfig()");
      return;
    }
  }
  
  public void c()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          if (((awgj)localIterator.next() instanceof QZoneVideoDownloadActivity)) {
            localIterator.remove();
          }
        }
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awgh
 * JD-Core Version:    0.7.0.1
 */