import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import com.tencent.mobileqq.shortvideo.VideoEnvironment64BitUtils;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import dov.com.qq.im.ae.download.AEResInfo;
import dov.com.qq.im.ae.download.AEResManager.1;
import dov.com.qq.im.ae.download.AEResManager.2;
import dov.com.qq.im.ae.download.AEResManager.3;
import dov.com.qq.im.ae.download.AEResManager.4;
import dov.com.qq.im.ae.download.AEResManager.6;
import dov.com.qq.im.ae.download.AEResManager.7;
import dov.com.qq.im.ae.download.AEResManager.8;
import dov.com.qq.im.ae.download.AEResManager.9;
import dov.com.qq.im.ae.download.AEResUtil;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class blvn
  implements bbrg, bbrj
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "DOWNLOAD_STATUS_IDLE", "DOWNLOAD_STATUS_WAIT", "DOWNLOAD_STATUS_PREDOWNLOAD_WAIT", "DOWNLOAD_STATUS_DOWNLOADING", "DOWNLOAD_STATUS_READY" };
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("AEResManagerHandlerThread", 0);
  private List<ShortVideoResourceManager.SVConfigItem> jdField_a_of_type_JavaUtilList = new LinkedList();
  private Map<AEResInfo, Integer> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private Queue<AEResInfo> jdField_a_of_type_JavaUtilQueue = new ArrayDeque();
  private List<blvp> jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private Map<AEResInfo, Long> jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  private blvn()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
  }
  
  public static blvn a()
  {
    return blvq.a;
  }
  
  private void a(@NonNull AEResInfo paramAEResInfo, @Nullable blvp paramblvp, boolean paramBoolean1, boolean paramBoolean2)
  {
    bmbx.b("AEResManager", "[requestDownloadInternal] - BEGIN -, packageIndex=" + paramAEResInfo.index);
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramAEResInfo)) {
      this.jdField_a_of_type_JavaUtilMap.put(paramAEResInfo, Integer.valueOf(0));
    }
    int i = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(paramAEResInfo)).intValue();
    bmbx.b("AEResManager", "[requestDownloadInternal], status=" + jdField_a_of_type_ArrayOfJavaLangString[i]);
    if (i == 4)
    {
      i = AEResUtil.getDownloadPackageVersion(paramAEResInfo.index);
      if (i == 0) {
        break label683;
      }
    }
    label683:
    for (String str = AEResUtil.getZipFilePath(paramAEResInfo.resPrefix + i);; str = null)
    {
      if (paramblvp != null) {
        paramblvp.onAEDownloadFinish(paramAEResInfo, str, true, 0);
      }
      AEResUtil.sendBroadcast(paramAEResInfo, str);
      bmbx.b("AEResManager", "[requestDownloadInternal], packageIndex=" + paramAEResInfo.index + ", downloadStatus=DOWNLOAD_STATUS_READY");
      bmbx.b("AEResManager", "[requestDownloadInternal] - END -, packageIndex=" + paramAEResInfo.index);
      return;
      if (i == 3)
      {
        b(paramblvp);
        bmbx.b("AEResManager", "[requestDownloadInternal], packageIndex=" + paramAEResInfo.index + ", downloadStatus=DOWNLOAD_STATUS_DOWNLOADING");
        bmbx.b("AEResManager", "[requestDownloadInternal] - END -, packageIndex=" + paramAEResInfo.index);
        return;
      }
      if ((NetworkUtil.isNetworkAvailable(null)) && ((!paramBoolean1) || (NetworkUtil.isWifiConnected(null)))) {}
      for (i = 1; i == 0; i = 0)
      {
        if (paramblvp != null) {
          paramblvp.onAEDownloadFinish(paramAEResInfo, null, false, -6);
        }
        bmbx.d("AEResManager", "[requestDownloadInternal], packageIndex=" + paramAEResInfo.index + ", networkStatus=UNUSABLE");
        bmbx.b("AEResManager", "[requestDownloadInternal] - END -, packageIndex=" + paramAEResInfo.index);
        return;
      }
      bmbx.b("AEResManager", "[requestDownloadInternal], packageIndex=" + paramAEResInfo.index + ", networkStatus=USABLE");
      b(paramblvp);
      if (!this.jdField_a_of_type_JavaUtilQueue.contains(paramAEResInfo))
      {
        this.jdField_a_of_type_JavaUtilQueue.add(paramAEResInfo);
        this.jdField_a_of_type_JavaUtilMap.put(paramAEResInfo, Integer.valueOf(1));
      }
      if ((paramAEResInfo.isPredownload) && (paramBoolean2))
      {
        paramBoolean1 = true;
        paramAEResInfo.isPredownload = paramBoolean1;
        if (this.jdField_a_of_type_JavaUtilMap.containsKey(AEResInfo.AE_RES_CONFIG)) {
          break label609;
        }
        bmbx.b("AEResManager", "[requestDownloadInternal] 强制拉取配置列表" + paramAEResInfo.index);
        this.jdField_a_of_type_JavaUtilMap.put(AEResInfo.AE_RES_CONFIG, Integer.valueOf(3));
        ShortVideoResourceManager.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), this);
      }
      for (;;)
      {
        bmbx.b("AEResManager", "[requestDownloadInternal] - END -, packageIndex=" + paramAEResInfo.index);
        return;
        paramBoolean1 = false;
        break;
        label609:
        if ((this.jdField_a_of_type_JavaUtilMap.get(AEResInfo.AE_RES_CONFIG) != null) && (((Integer)this.jdField_a_of_type_JavaUtilMap.get(AEResInfo.AE_RES_CONFIG)).intValue() == 4))
        {
          bmbx.b("AEResManager", "[requestDownloadInternal] 配置列表已经存在, packageIndex = " + paramAEResInfo.index);
          onConfigResult(1, 0);
        }
      }
    }
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    boolean bool2 = false;
    bmbx.b("AEResManager", "[onDownloadFinishInternal] - BEGIN -, result=" + paramInt + ", name=" + paramString1 + ", filePath=" + paramString2);
    Object localObject1 = paramString1;
    if (paramString1 == null) {
      localObject1 = "";
    }
    int i;
    Object localObject2;
    int k;
    int j;
    if ((paramInt == 0) || (paramInt == 1))
    {
      i = 0;
      localObject2 = AEResInfo.packageValues;
      k = localObject2.length;
      j = 0;
    }
    for (;;)
    {
      if (j < k)
      {
        paramString1 = localObject2[j];
        if (((String)localObject1).startsWith(paramString1.resPrefix))
        {
          bmbx.b("AEResManager", "[onDownloadFinishInternal], matched aeResInfo=" + paramString1);
          if (i == 0)
          {
            this.jdField_a_of_type_JavaUtilMap.put(paramString1, Integer.valueOf(4));
            this.jdField_a_of_type_JavaUtilQueue.remove(paramString1);
            AEResUtil.sendBroadcast(paramString1, paramString2);
            j = Integer.valueOf(((String)localObject1).substring(paramString1.resPrefix.length())).intValue();
            AEResUtil.setDownLoadPackageVersion(paramString1.index, j);
            label200:
            localObject1 = this.jdField_b_of_type_JavaUtilList.iterator();
            label211:
            if (!((Iterator)localObject1).hasNext()) {
              break label298;
            }
            localObject2 = (blvp)((Iterator)localObject1).next();
            if (i != 0) {
              break label292;
            }
          }
          label292:
          for (boolean bool1 = true;; bool1 = false)
          {
            ((blvp)localObject2).onAEDownloadFinish(paramString1, paramString2, bool1, i);
            break label211;
            i = paramInt;
            break;
            this.jdField_a_of_type_JavaUtilMap.put(paramString1, Integer.valueOf(0));
            this.jdField_a_of_type_JavaUtilQueue.remove(paramString1);
            break label200;
          }
          label298:
          if (paramInt != 1)
          {
            long l = -1L;
            if (this.jdField_b_of_type_JavaUtilMap.get(paramString1) != null) {
              l = System.currentTimeMillis() - ((Long)this.jdField_b_of_type_JavaUtilMap.get(paramString1)).longValue();
            }
            paramString2 = bmbc.a();
            bool1 = bool2;
            if (paramInt == 0) {
              bool1 = true;
            }
            paramString2.a(bool1, paramString1.index, "", "", paramInt, l);
          }
          bmbx.b("AEResManager", "[onDownloadFinishInternal], start download next package");
          paramString1 = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
          a(new LinkedList(this.jdField_a_of_type_JavaUtilList), paramString1, true);
        }
      }
      else
      {
        bmbx.b("AEResManager", "[onDownloadFinishInternal] - END -");
        return;
      }
      j += 1;
    }
  }
  
  private void a(String paramString, long paramLong1, long paramLong2)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = AEResInfo.packageValues;
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramString[i];
      if (str.startsWith(localObject.resPrefix))
      {
        this.jdField_a_of_type_JavaUtilMap.put(localObject, Integer.valueOf(3));
        Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          ((blvp)localIterator.next()).onAEProgressUpdate(localObject, paramLong1, paramLong2);
        }
      }
      i += 1;
    }
  }
  
  private void a(@NonNull List<ShortVideoResourceManager.SVConfigItem> paramList, @NonNull QQAppInterface paramQQAppInterface, @NonNull AEResInfo paramAEResInfo)
  {
    bmbx.b("AEResManager", "[cancelPreDownLoad] - BEGIN -, aeResInfo=" + paramAEResInfo);
    paramQQAppInterface = (PreDownloadController)paramQQAppInterface.getManager(193);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (ShortVideoResourceManager.SVConfigItem)localIterator.next();
      if (paramList.name.startsWith(paramAEResInfo.resPrefix)) {
        bmbx.b("AEResManager", "[cancelPreDownLoad], chosenConfigItem matched");
      }
    }
    for (;;)
    {
      if ((paramQQAppInterface != null) && (paramQQAppInterface.isEnable()) && (paramList != null))
      {
        if ((!VideoEnvironment64BitUtils.checkIs64bit()) || (!paramList.check64BitReady())) {
          break label178;
        }
        paramQQAppInterface.cancelPreDownload(paramList.arm64v8a_url);
      }
      for (;;)
      {
        bmbx.b("AEResManager", "[cancelPreDownLoad], preDownloadController.isEnable() == " + paramQQAppInterface.isEnable());
        bmbx.b("AEResManager", "[cancelPreDownLoad] - END -, aeResInfo=" + paramAEResInfo);
        return;
        label178:
        paramQQAppInterface.cancelPreDownload(paramList.armv7a_url);
      }
      paramList = null;
    }
  }
  
  private void a(@NonNull List<ShortVideoResourceManager.SVConfigItem> paramList, @NonNull QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    bmbx.b("AEResManager", "[startDownLoad] + BEGIN");
    if (CollectionUtils.isEmpty(this.jdField_a_of_type_JavaUtilQueue))
    {
      bmbx.d("AEResManager", "[startDownLoad], mDownLoadTaskQueue is empty");
      bmbx.b("AEResManager", "[startDownLoad] - END -");
      return;
    }
    AEResInfo localAEResInfo = (AEResInfo)this.jdField_a_of_type_JavaUtilQueue.peek();
    if (localAEResInfo == null)
    {
      bmbx.d("AEResManager", "[startDownLoad], mDownLoadTaskQueue top element is null");
      bmbx.b("AEResManager", "[startDownLoad] + END");
      return;
    }
    int i;
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(localAEResInfo))
    {
      i = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(localAEResInfo)).intValue();
      bmbx.a("AEResManager", "[startDownLoad], resNeedDownload=" + localAEResInfo);
      bmbx.a("AEResManager", "[startDownLoad], status=" + jdField_a_of_type_ArrayOfJavaLangString[i]);
      if ((!paramBoolean) && (localAEResInfo.isPredownload)) {
        break label275;
      }
      bmbx.b("AEResManager", "[startDownLoad], isDownLoadImmediately=true");
      if (i != 3)
      {
        this.jdField_a_of_type_JavaUtilMap.put(localAEResInfo, Integer.valueOf(3));
        if (i == 2) {
          a(paramList, paramQQAppInterface, localAEResInfo);
        }
        this.jdField_b_of_type_JavaUtilMap.put(localAEResInfo, Long.valueOf(System.currentTimeMillis()));
        bmbx.b("AEResManager", "[startDownLoad], realDownloadResource()");
        blvl.a(localAEResInfo, paramList, this);
      }
    }
    for (;;)
    {
      bmbx.b("AEResManager", "[startDownLoad] + END");
      return;
      bmbx.d("AEResManager", "[startDownLoad], cannot find resNeedDownload in mStatusMap");
      bmbx.b("AEResManager", "[startDownLoad] + END");
      return;
      label275:
      bmbx.b("AEResManager", "[startDownLoad], isDownLoadImmediately=false");
      if ((i == 3) || (i == 2)) {
        break;
      }
      if (!a(paramList, this, paramQQAppInterface, localAEResInfo))
      {
        a(paramList, paramQQAppInterface, localAEResInfo);
        localAEResInfo.isPredownload = false;
        this.jdField_b_of_type_JavaUtilMap.put(localAEResInfo, Long.valueOf(System.currentTimeMillis()));
        bmbx.b("AEResManager", "[startDownLoad], realDownloadResource()");
        this.jdField_a_of_type_JavaUtilMap.put(localAEResInfo, Integer.valueOf(3));
        blvl.a(localAEResInfo, paramList, this);
      }
      else
      {
        this.jdField_a_of_type_JavaUtilMap.put(localAEResInfo, Integer.valueOf(2));
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    boolean bool = true;
    bmbx.b("AEResManager", "[onConfigResultInternal] ++++++ BEGIN");
    int i;
    if (this.jdField_a_of_type_JavaUtilList.size() < 1)
    {
      bmbx.b("AEResManager", "[onConfigResultInternal] 内存中'还没有'列表信息，开始生成配置列表");
      i = ShortVideoResourceManager.a(null, this.jdField_a_of_type_JavaUtilList);
      bmbx.b("AEResManager", "[onConfigResultInternal] 生成配置列表结果 errCode = " + i);
      bmbx.b("AEResManager", "[onConfigResultInternal] 内存中'当前的'配置列表信息，size = " + this.jdField_a_of_type_JavaUtilList.size());
      if (i != 0) {
        break label523;
      }
      i = AEResUtil.checkConfigUsable(this.jdField_a_of_type_JavaUtilList);
    }
    label523:
    for (;;)
    {
      Object localObject1 = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      Object localObject2;
      if (i == 0)
      {
        this.jdField_a_of_type_JavaUtilMap.put(AEResInfo.AE_RES_CONFIG, Integer.valueOf(4));
        bmbx.b("AEResManager", "[onConfigResultInternal] 配置列表拉取成功，开始进行ZIP包下载");
        localObject2 = new LinkedList(this.jdField_a_of_type_JavaUtilList);
        if (!paramBoolean)
        {
          paramBoolean = true;
          label170:
          a((List)localObject2, (QQAppInterface)localObject1, paramBoolean);
        }
      }
      for (;;)
      {
        bmbx.b("AEResManager", "[onConfigResultInternal] ++++++ END");
        return;
        bmbx.b("AEResManager", "[onConfigResultInternal] 内存中'已经有'列表信息，执行检查刷新列表");
        localObject1 = new LinkedList();
        int j = ShortVideoResourceManager.a(null, (List)localObject1);
        bmbx.b("AEResManager", "[onConfigResultInternal] 内存中'已经有'列表信息，刷新后列表为 = " + localObject1);
        i = j;
        if (j != 0) {
          break;
        }
        i = j;
        if (((List)localObject1).size() <= 0) {
          break;
        }
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject1);
        i = j;
        break;
        paramBoolean = false;
        break label170;
        bmbx.b("AEResManager", "[onConfigResultInternal] 配置列表拉取失败，尝试构造内置列表进行下载");
        localObject2 = new LinkedList();
        i = ShortVideoResourceManager.a("[\n    {\n        \"name\": \"new_qq_android_native_short_filter_84801\",\n        \"arm_url\": \"https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_short_filter_84801.zip\",\n        \"armv7a_url\": \"https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_short_filter_84801.zip\",\n        \"x86_url\": \"https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_short_filter_84801.zip\",\n        \"arm64v8a_url\": \"https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_short_filter_84801_64bit.zip\",\n        \"arm_md5\": \"37b9f4a38ef7959cbc2c9fbe5c49f79d\",\n        \"armv7a_md5\": \"37b9f4a38ef7959cbc2c9fbe5c49f79d\",\n        \"x86_md5\": \"37b9f4a38ef7959cbc2c9fbe5c49f79d\",\n        \"arm64v8a_md5\": \"97547129fe0215f8c2c0ad5ccb0166df\",\n        \"versionCode\": \"848\",\n        \"predownload\": false\n    },\n    {\n        \"name\": \"new_qq_android_native_ptu_res_84801\",\n        \"arm_url\": \"https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_ptu_res_84801.zip\",\n        \"armv7a_url\": \"https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_ptu_res_84801.zip\",\n        \"x86_url\": \"https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_ptu_res_84801.zip\",\n        \"arm64v8a_url\": \"https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_ptu_res_84801_64bit.zip\",\n        \"arm_md5\": \"83aa5ffa431cffeaccb62d80abdf8348\",\n        \"armv7a_md5\": \"83aa5ffa431cffeaccb62d80abdf8348\",\n        \"x86_md5\": \"83aa5ffa431cffeaccb62d80abdf8348\",\n        \"arm64v8a_md5\": \"01928fc296254f92999b7c83b3d8e879\",\n        \"versionCode\": \"848\",\n        \"predownload\": false\n    }\n]", (List)localObject2);
        if ((i == 0) && (((List)localObject2).size() > 0))
        {
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject2);
        }
        if (i == 0)
        {
          this.jdField_a_of_type_JavaUtilMap.put(AEResInfo.AE_RES_CONFIG, Integer.valueOf(4));
          bmbx.b("AEResManager", "[onConfigResultInternal] 构造内置列表成功，开始下载");
          localObject2 = new LinkedList(this.jdField_a_of_type_JavaUtilList);
          if (!paramBoolean) {}
          for (paramBoolean = bool;; paramBoolean = false)
          {
            a((List)localObject2, (QQAppInterface)localObject1, paramBoolean);
            break;
          }
        }
        this.jdField_a_of_type_JavaUtilMap.remove(AEResInfo.AE_RES_CONFIG);
        bmbx.b("AEResManager", "[onConfigResultInternal] 构造内置列表失败，返回信息");
        if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0))
        {
          i = 0;
          while (i < AEResInfo.packageValues.length)
          {
            localObject1 = AEResInfo.values[i];
            localObject2 = this.jdField_b_of_type_JavaUtilList.iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((blvp)((Iterator)localObject2).next()).onAEDownloadFinish((AEResInfo)localObject1, null, false, -102);
            }
            i += 1;
          }
        }
      }
    }
  }
  
  private boolean a(@NonNull List<ShortVideoResourceManager.SVConfigItem> paramList, @NonNull bbrg parambbrg, @NonNull QQAppInterface paramQQAppInterface, @NonNull AEResInfo paramAEResInfo)
  {
    bmbx.b("AEResManager", "[startPreDownLoad] - BEGIN -, aeResInfo=" + paramAEResInfo);
    PreDownloadController localPreDownloadController = (PreDownloadController)paramQQAppInterface.getManager(193);
    Iterator localIterator = paramList.iterator();
    ShortVideoResourceManager.SVConfigItem localSVConfigItem;
    while (localIterator.hasNext())
    {
      localSVConfigItem = (ShortVideoResourceManager.SVConfigItem)localIterator.next();
      if (localSVConfigItem.name.startsWith(paramAEResInfo.resPrefix)) {
        bmbx.b("AEResManager", "[startPreDownLoad], chosenConfigItem matched");
      }
    }
    for (;;)
    {
      if ((localPreDownloadController != null) && (localPreDownloadController.isEnable()))
      {
        parambbrg = new blvo(this, paramQQAppInterface, "ae_camera_res", new AEResManager.4(this, paramAEResInfo, paramList, parambbrg), 4000L);
        if (localSVConfigItem != null)
        {
          if ((VideoEnvironment64BitUtils.checkIs64bit()) && (localSVConfigItem.check64BitReady())) {}
          for (paramList = localSVConfigItem.arm64v8a_url;; paramList = localSVConfigItem.armv7a_url)
          {
            boolean bool = localPreDownloadController.requestPreDownload(10091, null, localSVConfigItem.name, 0, paramList, AEResUtil.getZipFilePath(localSVConfigItem.name), 4, 0, true, parambbrg);
            bmbx.b("AEResManager", "[startPreDownLoad], preDownloadController.requestPreDownload(), succeeded=" + bool);
            bmbx.b("AEResManager", "[startPreDownLoad] - END -, aeResInfo=" + paramAEResInfo);
            return bool;
          }
        }
        bmbx.b("AEResManager", "[startPreDownLoad], chosenConfigItem == nul");
        bmbx.b("AEResManager", "[startPreDownLoad] - END -, aeResInfo=" + paramAEResInfo);
        return false;
      }
      bmbx.b("AEResManager", "[startPreDownLoad], preDownloadController.isEnable() == false");
      bmbx.b("AEResManager", "[startPreDownLoad] - END -, aeResInfo=" + paramAEResInfo);
      return false;
      localSVConfigItem = null;
    }
  }
  
  private void b(@Nullable blvp paramblvp)
  {
    if (paramblvp == null) {}
    while ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.contains(paramblvp))) {
      return;
    }
    this.jdField_b_of_type_JavaUtilList.add(paramblvp);
  }
  
  private void b(@NonNull AEResInfo paramAEResInfo, @Nullable blvp paramblvp)
  {
    bmbx.b("AEResManager", "[requestDownloadWithoutLoginInternal] - BEGIN -, packageIndex=" + paramAEResInfo.index);
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramAEResInfo)) {
      this.jdField_a_of_type_JavaUtilMap.put(paramAEResInfo, Integer.valueOf(0));
    }
    int i = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(paramAEResInfo)).intValue();
    bmbx.b("AEResManager", "[requestDownloadWithoutLoginInternal], status=" + jdField_a_of_type_ArrayOfJavaLangString[i]);
    if (i == 4)
    {
      i = AEResUtil.getDownloadPackageVersion(paramAEResInfo.index);
      if (i == 0) {
        break label575;
      }
    }
    label575:
    for (String str = AEResUtil.getZipFilePath(paramAEResInfo.resPrefix + i);; str = null)
    {
      if (paramblvp != null) {
        paramblvp.onAEDownloadFinish(paramAEResInfo, str, true, 0);
      }
      bmbx.b("AEResManager", "[requestDownloadWithoutLoginInternal], packageIndex=" + paramAEResInfo.index + ", downloadStatus=DOWNLOAD_STATUS_READY");
      bmbx.b("AEResManager", "[requestDownloadWithoutLoginInternal] - END -, packageIndex=" + paramAEResInfo.index);
      return;
      if (i == 3)
      {
        b(paramblvp);
        bmbx.b("AEResManager", "[requestDownloadWithoutLoginInternal], packageIndex=" + paramAEResInfo.index + ", downloadStatus=DOWNLOAD_STATUS_DOWNLOADING");
        bmbx.b("AEResManager", "[requestDownloadWithoutLoginInternal] - END -, packageIndex=" + paramAEResInfo.index);
        return;
      }
      if (!NetworkUtil.isNetworkAvailable(null))
      {
        if (paramblvp != null) {
          paramblvp.onAEDownloadFinish(paramAEResInfo, null, false, -6);
        }
        bmbx.b("AEResManager", "[requestDownloadWithoutLoginInternal], packageIndex=" + paramAEResInfo.index + ", networkStatus=UNUSABLE");
        bmbx.b("AEResManager", "[requestDownloadWithoutLoginInternal] - END -, packageIndex=" + paramAEResInfo.index);
        return;
      }
      bmbx.b("AEResManager", "[requestDownloadWithoutLoginInternal], packageIndex=" + paramAEResInfo.index + ", networkStatus=USABLE");
      b(paramblvp);
      if (!this.jdField_a_of_type_JavaUtilQueue.contains(paramAEResInfo))
      {
        this.jdField_a_of_type_JavaUtilQueue.add(paramAEResInfo);
        this.jdField_a_of_type_JavaUtilMap.put(paramAEResInfo, Integer.valueOf(1));
      }
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(AEResInfo.AE_RES_CONFIG))
      {
        this.jdField_a_of_type_JavaUtilMap.put(AEResInfo.AE_RES_CONFIG, Integer.valueOf(3));
        bbqy.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), this);
      }
      for (;;)
      {
        bmbx.b("AEResManager", "[requestDownloadWithoutLoginInternal] - END -, packageIndex=" + paramAEResInfo.index);
        return;
        if ((this.jdField_a_of_type_JavaUtilMap.get(AEResInfo.AE_RES_CONFIG) != null) && (((Integer)this.jdField_a_of_type_JavaUtilMap.get(AEResInfo.AE_RES_CONFIG)).intValue() == 4)) {
          a(1, 0);
        }
      }
    }
  }
  
  @Deprecated
  public int a(@NonNull AEResInfo paramAEResInfo)
  {
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      paramAEResInfo = (Integer)this.jdField_a_of_type_JavaUtilMap.get(paramAEResInfo);
      if (paramAEResInfo != null) {
        return paramAEResInfo.intValue();
      }
      return 0;
    }
    return 0;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    bmbx.b("AEResManager", "[onConfigResultWithoutLogin] - BEGIN -, result=" + paramInt1 + ", serverError=" + paramInt2);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEResManager.9(this));
    bmbx.b("AEResManager", "[onConfigResultWithoutLogin] - END -, result=" + paramInt1 + ", serverError=" + paramInt2);
  }
  
  public void a(@Nullable blvp paramblvp)
  {
    if (paramblvp == null) {}
    while (this.jdField_b_of_type_JavaUtilList == null) {
      return;
    }
    this.jdField_b_of_type_JavaUtilList.remove(paramblvp);
  }
  
  public void a(@NonNull AEResInfo paramAEResInfo, @Nullable blvp paramblvp)
  {
    bmbx.b("AEResManager", "[requestDownloadWithoutLogin] - BEGIN -, aeResInfo=" + paramAEResInfo);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEResManager.3(this, paramAEResInfo, paramblvp));
    bmbx.b("AEResManager", "[requestDownloadWithoutLogin] - END -, aeResInfo=" + paramAEResInfo);
  }
  
  public void a(@NonNull AEResInfo paramAEResInfo, @Nullable blvp paramblvp, boolean paramBoolean)
  {
    bmbx.b("AEResManager", "[requestDownload] - BEGIN -, aeResInfo=" + paramAEResInfo);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEResManager.1(this, paramAEResInfo, paramblvp, paramBoolean));
    bmbx.b("AEResManager", "[requestDownload] - END -, aeResInfo=" + paramAEResInfo);
  }
  
  public void b(@NonNull AEResInfo paramAEResInfo, @Nullable blvp paramblvp, boolean paramBoolean)
  {
    bmbx.b("AEResManager", "[requestDownload] - BEGIN -, aeResInfo=" + paramAEResInfo);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEResManager.2(this, paramAEResInfo, paramblvp, paramBoolean));
    bmbx.b("AEResManager", "[requestDownload] - END -, aeResInfo=" + paramAEResInfo);
  }
  
  public void onConfigResult(int paramInt1, int paramInt2)
  {
    bmbx.b("AEResManager", "[onConfigResult] - BEGIN -, result=" + paramInt1 + ", serverError=" + paramInt2);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEResManager.6(this));
    bmbx.b("AEResManager", "[onConfigResult] - END -, result=" + paramInt1 + ", serverError=" + paramInt2);
  }
  
  public void onDownloadFinish(String paramString1, int paramInt, String paramString2)
  {
    bmbx.b("AEResManager", "[onDownloadFinish] - BEGIN -, result=" + paramInt + ", name=" + paramString1 + ", filePath=" + paramString2);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEResManager.7(this, paramString1, paramInt, paramString2));
    bmbx.b("AEResManager", "[onDownloadFinish] - END -");
  }
  
  public void onNetWorkNone()
  {
    bmbx.d("AEResManager", amtj.a(2131699155));
    bbqi.a(3, -1500);
  }
  
  public void onUpdateProgress(String paramString, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AEResManager.8(this, paramString, paramLong1, paramLong2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blvn
 * JD-Core Version:    0.7.0.1
 */