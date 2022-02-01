import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import com.tencent.mobileqq.shortvideo.VideoEnvironment64BitUtils;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import dov.com.qq.im.ae.download.AEResManager.1;
import dov.com.qq.im.ae.download.AEResManager.2;
import dov.com.qq.im.ae.download.AEResManager.3;
import dov.com.qq.im.ae.download.AEResManager.4;
import dov.com.qq.im.ae.download.AEResManager.6;
import dov.com.qq.im.ae.download.AEResManager.7;
import dov.com.qq.im.ae.download.AEResManager.8;
import dov.com.qq.im.ae.download.AEResManager.9;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class bnku
  implements bcya, bcyd
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "DOWNLOAD_STATUS_IDLE", "DOWNLOAD_STATUS_WAIT", "DOWNLOAD_STATUS_PREDOWNLOAD_WAIT", "DOWNLOAD_STATUS_DOWNLOADING", "DOWNLOAD_STATUS_READY" };
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("AEResManagerHandlerThread", 0);
  private List<ShortVideoResourceManager.SVConfigItem> jdField_a_of_type_JavaUtilList = new LinkedList();
  private Map<bnkt, Integer> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private Queue<bnkt> jdField_a_of_type_JavaUtilQueue = new ArrayDeque();
  private List<bnkw> jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private Map<bnkt, Long> jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  private bnku()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
  }
  
  public static bnku a()
  {
    return bnkx.a;
  }
  
  private void a(@NonNull bnkt parambnkt, @Nullable bnkw parambnkw, boolean paramBoolean1, boolean paramBoolean2)
  {
    bnrh.b("AEResManager", "[requestDownloadInternal] - BEGIN -, packageIndex=" + parambnkt.jdField_a_of_type_Int);
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(parambnkt)) {
      this.jdField_a_of_type_JavaUtilMap.put(parambnkt, Integer.valueOf(0));
    }
    int i = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(parambnkt)).intValue();
    bnrh.b("AEResManager", "[requestDownloadInternal], status=" + jdField_a_of_type_ArrayOfJavaLangString[i]);
    if (i == 4)
    {
      i = bnky.a(parambnkt.jdField_a_of_type_Int);
      if (i == 0) {
        break label682;
      }
    }
    label682:
    for (String str = bnky.a(parambnkt.jdField_b_of_type_JavaLangString + i);; str = null)
    {
      if (parambnkw != null) {
        parambnkw.onAEDownloadFinish(parambnkt, str, true, 0);
      }
      bnky.a(parambnkt, str);
      bnrh.b("AEResManager", "[requestDownloadInternal], packageIndex=" + parambnkt.jdField_a_of_type_Int + ", downloadStatus=DOWNLOAD_STATUS_READY");
      bnrh.b("AEResManager", "[requestDownloadInternal] - END -, packageIndex=" + parambnkt.jdField_a_of_type_Int);
      return;
      if (i == 3)
      {
        b(parambnkw);
        bnrh.b("AEResManager", "[requestDownloadInternal], packageIndex=" + parambnkt.jdField_a_of_type_Int + ", downloadStatus=DOWNLOAD_STATUS_DOWNLOADING");
        bnrh.b("AEResManager", "[requestDownloadInternal] - END -, packageIndex=" + parambnkt.jdField_a_of_type_Int);
        return;
      }
      if ((NetworkUtil.isNetworkAvailable(null)) && ((!paramBoolean1) || (NetworkUtil.isWifiConnected(null)))) {}
      for (i = 1; i == 0; i = 0)
      {
        if (parambnkw != null) {
          parambnkw.onAEDownloadFinish(parambnkt, null, false, -6);
        }
        bnrh.d("AEResManager", "[requestDownloadInternal], packageIndex=" + parambnkt.jdField_a_of_type_Int + ", networkStatus=UNUSABLE");
        bnrh.b("AEResManager", "[requestDownloadInternal] - END -, packageIndex=" + parambnkt.jdField_a_of_type_Int);
        return;
      }
      bnrh.b("AEResManager", "[requestDownloadInternal], packageIndex=" + parambnkt.jdField_a_of_type_Int + ", networkStatus=USABLE");
      b(parambnkw);
      if (!this.jdField_a_of_type_JavaUtilQueue.contains(parambnkt))
      {
        this.jdField_a_of_type_JavaUtilQueue.add(parambnkt);
        this.jdField_a_of_type_JavaUtilMap.put(parambnkt, Integer.valueOf(1));
      }
      if ((parambnkt.jdField_b_of_type_Boolean) && (paramBoolean2))
      {
        paramBoolean1 = true;
        parambnkt.jdField_b_of_type_Boolean = paramBoolean1;
        if (this.jdField_a_of_type_JavaUtilMap.containsKey(bnkt.jdField_a_of_type_Bnkt)) {
          break label609;
        }
        bnrh.b("AEResManager", "[requestDownloadInternal] 强制拉取配置列表" + parambnkt.jdField_a_of_type_Int);
        this.jdField_a_of_type_JavaUtilMap.put(bnkt.jdField_a_of_type_Bnkt, Integer.valueOf(3));
        ShortVideoResourceManager.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), this);
      }
      for (;;)
      {
        bnrh.b("AEResManager", "[requestDownloadInternal] - END -, packageIndex=" + parambnkt.jdField_a_of_type_Int);
        return;
        paramBoolean1 = false;
        break;
        label609:
        if ((this.jdField_a_of_type_JavaUtilMap.get(bnkt.jdField_a_of_type_Bnkt) != null) && (((Integer)this.jdField_a_of_type_JavaUtilMap.get(bnkt.jdField_a_of_type_Bnkt)).intValue() == 4))
        {
          bnrh.b("AEResManager", "[requestDownloadInternal] 配置列表已经存在, packageIndex = " + parambnkt.jdField_a_of_type_Int);
          onConfigResult(1, 0);
        }
      }
    }
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    boolean bool2 = false;
    bnrh.b("AEResManager", "[onDownloadFinishInternal] - BEGIN -, result=" + paramInt + ", name=" + paramString1 + ", filePath=" + paramString2);
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
      localObject2 = bnkt.jdField_b_of_type_ArrayOfBnkt;
      k = localObject2.length;
      j = 0;
    }
    for (;;)
    {
      if (j < k)
      {
        paramString1 = localObject2[j];
        if (((String)localObject1).startsWith(paramString1.jdField_b_of_type_JavaLangString))
        {
          bnrh.b("AEResManager", "[onDownloadFinishInternal], matched aeResInfo=" + paramString1);
          if (i == 0)
          {
            this.jdField_a_of_type_JavaUtilMap.put(paramString1, Integer.valueOf(4));
            this.jdField_a_of_type_JavaUtilQueue.remove(paramString1);
            bnky.a(paramString1, paramString2);
            j = Integer.valueOf(((String)localObject1).substring(paramString1.jdField_b_of_type_JavaLangString.length())).intValue();
            bnky.a(paramString1.jdField_a_of_type_Int, j);
            label200:
            localObject1 = this.jdField_b_of_type_JavaUtilList.iterator();
            label211:
            if (!((Iterator)localObject1).hasNext()) {
              break label298;
            }
            localObject2 = (bnkw)((Iterator)localObject1).next();
            if (i != 0) {
              break label292;
            }
          }
          label292:
          for (boolean bool1 = true;; bool1 = false)
          {
            ((bnkw)localObject2).onAEDownloadFinish(paramString1, paramString2, bool1, i);
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
            paramString2 = bnqm.a();
            bool1 = bool2;
            if (paramInt == 0) {
              bool1 = true;
            }
            paramString2.a(bool1, paramString1.jdField_a_of_type_Int, "", "", paramInt, l);
          }
          bnrh.b("AEResManager", "[onDownloadFinishInternal], start download next package");
          paramString1 = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
          a(new LinkedList(this.jdField_a_of_type_JavaUtilList), paramString1, true);
        }
      }
      else
      {
        bnrh.b("AEResManager", "[onDownloadFinishInternal] - END -");
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
    paramString = bnkt.jdField_b_of_type_ArrayOfBnkt;
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramString[i];
      if (str.startsWith(localObject.jdField_b_of_type_JavaLangString))
      {
        this.jdField_a_of_type_JavaUtilMap.put(localObject, Integer.valueOf(3));
        Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          ((bnkw)localIterator.next()).onAEProgressUpdate(localObject, paramLong1, paramLong2);
        }
      }
      i += 1;
    }
  }
  
  private void a(@NonNull List<ShortVideoResourceManager.SVConfigItem> paramList, @NonNull QQAppInterface paramQQAppInterface, @NonNull bnkt parambnkt)
  {
    bnrh.b("AEResManager", "[cancelPreDownLoad] - BEGIN -, aeResInfo=" + parambnkt);
    paramQQAppInterface = (PreDownloadController)paramQQAppInterface.getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (ShortVideoResourceManager.SVConfigItem)localIterator.next();
      if (paramList.name.startsWith(parambnkt.jdField_b_of_type_JavaLangString)) {
        bnrh.b("AEResManager", "[cancelPreDownLoad], chosenConfigItem matched");
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
        bnrh.b("AEResManager", "[cancelPreDownLoad], preDownloadController.isEnable() == " + paramQQAppInterface.isEnable());
        bnrh.b("AEResManager", "[cancelPreDownLoad] - END -, aeResInfo=" + parambnkt);
        return;
        label178:
        paramQQAppInterface.cancelPreDownload(paramList.armv7a_url);
      }
      paramList = null;
    }
  }
  
  private void a(@NonNull List<ShortVideoResourceManager.SVConfigItem> paramList, @NonNull QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    bnrh.b("AEResManager", "[startDownLoad] + BEGIN");
    if (CollectionUtils.isEmpty(this.jdField_a_of_type_JavaUtilQueue))
    {
      bnrh.d("AEResManager", "[startDownLoad], mDownLoadTaskQueue is empty");
      bnrh.b("AEResManager", "[startDownLoad] - END -");
      return;
    }
    bnkt localbnkt = (bnkt)this.jdField_a_of_type_JavaUtilQueue.peek();
    if (localbnkt == null)
    {
      bnrh.d("AEResManager", "[startDownLoad], mDownLoadTaskQueue top element is null");
      bnrh.b("AEResManager", "[startDownLoad] + END");
      return;
    }
    int i;
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(localbnkt))
    {
      i = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(localbnkt)).intValue();
      bnrh.a("AEResManager", "[startDownLoad], resNeedDownload=" + localbnkt);
      bnrh.a("AEResManager", "[startDownLoad], status=" + jdField_a_of_type_ArrayOfJavaLangString[i]);
      if ((!paramBoolean) && (localbnkt.jdField_b_of_type_Boolean)) {
        break label275;
      }
      bnrh.b("AEResManager", "[startDownLoad], isDownLoadImmediately=true");
      if (i != 3)
      {
        this.jdField_a_of_type_JavaUtilMap.put(localbnkt, Integer.valueOf(3));
        if (i == 2) {
          a(paramList, paramQQAppInterface, localbnkt);
        }
        this.jdField_b_of_type_JavaUtilMap.put(localbnkt, Long.valueOf(System.currentTimeMillis()));
        bnrh.b("AEResManager", "[startDownLoad], realDownloadResource()");
        bnkr.a(localbnkt, paramList, this);
      }
    }
    for (;;)
    {
      bnrh.b("AEResManager", "[startDownLoad] + END");
      return;
      bnrh.d("AEResManager", "[startDownLoad], cannot find resNeedDownload in mStatusMap");
      bnrh.b("AEResManager", "[startDownLoad] + END");
      return;
      label275:
      bnrh.b("AEResManager", "[startDownLoad], isDownLoadImmediately=false");
      if ((i == 3) || (i == 2)) {
        break;
      }
      if (!a(paramList, this, paramQQAppInterface, localbnkt))
      {
        a(paramList, paramQQAppInterface, localbnkt);
        localbnkt.jdField_b_of_type_Boolean = false;
        this.jdField_b_of_type_JavaUtilMap.put(localbnkt, Long.valueOf(System.currentTimeMillis()));
        bnrh.b("AEResManager", "[startDownLoad], realDownloadResource()");
        this.jdField_a_of_type_JavaUtilMap.put(localbnkt, Integer.valueOf(3));
        bnkr.a(localbnkt, paramList, this);
      }
      else
      {
        this.jdField_a_of_type_JavaUtilMap.put(localbnkt, Integer.valueOf(2));
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    boolean bool = true;
    bnrh.b("AEResManager", "[onConfigResultInternal] ++++++ BEGIN");
    int i;
    if (this.jdField_a_of_type_JavaUtilList.size() < 1)
    {
      bnrh.b("AEResManager", "[onConfigResultInternal] 内存中'还没有'列表信息，开始生成配置列表");
      i = ShortVideoResourceManager.a(null, this.jdField_a_of_type_JavaUtilList);
      bnrh.b("AEResManager", "[onConfigResultInternal] 生成配置列表结果 errCode = " + i);
      bnrh.b("AEResManager", "[onConfigResultInternal] 内存中'当前的'配置列表信息，size = " + this.jdField_a_of_type_JavaUtilList.size());
      if (i != 0) {
        break label523;
      }
      i = bnky.a(this.jdField_a_of_type_JavaUtilList);
    }
    label523:
    for (;;)
    {
      Object localObject1 = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      Object localObject2;
      if (i == 0)
      {
        this.jdField_a_of_type_JavaUtilMap.put(bnkt.jdField_a_of_type_Bnkt, Integer.valueOf(4));
        bnrh.b("AEResManager", "[onConfigResultInternal] 配置列表拉取成功，开始进行ZIP包下载");
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
        bnrh.b("AEResManager", "[onConfigResultInternal] ++++++ END");
        return;
        bnrh.b("AEResManager", "[onConfigResultInternal] 内存中'已经有'列表信息，执行检查刷新列表");
        localObject1 = new LinkedList();
        int j = ShortVideoResourceManager.a(null, (List)localObject1);
        bnrh.b("AEResManager", "[onConfigResultInternal] 内存中'已经有'列表信息，刷新后列表为 = " + localObject1);
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
        bnrh.b("AEResManager", "[onConfigResultInternal] 配置列表拉取失败，尝试构造内置列表进行下载");
        localObject2 = new LinkedList();
        i = ShortVideoResourceManager.a("[\n    {\n        \"name\": \"new_qq_android_native_short_filter_841033\",\n        \"arm_url\": \"https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_short_filter_841033.zip\",\n        \"armv7a_url\": \"https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_short_filter_841033.zip\",\n        \"x86_url\": \"https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_short_filter_841033.zip\",\n        \"arm64v8a_url\": \"https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_short_filter_841033_64bit.zip\",\n        \"arm_md5\": \"a504ba7ae2878bb1e3b746d92ef1ef9e\",\n        \"armv7a_md5\": \"a504ba7ae2878bb1e3b746d92ef1ef9e\",\n        \"x86_md5\": \"a504ba7ae2878bb1e3b746d92ef1ef9e\",\n        \"arm64v8a_md5\": \"b07d180ecabc6a0a2f6cb156f573f6c5\",\n        \"versionCode\": \"8410\",\n        \"predownload\": false\n    },\n    {\n        \"name\": \"new_qq_android_native_ptu_res_841033\",\n        \"arm_url\": \"https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_ptu_res_841033.zip\",\n        \"armv7a_url\": \"https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_ptu_res_841033.zip\",\n        \"x86_url\": \"https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_ptu_res_841033.zip\",\n        \"arm64v8a_url\": \"https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_ptu_res_841033_64bit.zip\",\n        \"arm_md5\": \"e0f968903ca7a8ba63af8f970246afe3\",\n        \"armv7a_md5\": \"e0f968903ca7a8ba63af8f970246afe3\",\n        \"x86_md5\": \"e0f968903ca7a8ba63af8f970246afe3\",\n        \"arm64v8a_md5\": \"ed0c00ee498a5f911698d4caa75e5ce6\",\n        \"versionCode\": \"8410\",\n        \"predownload\": false\n    }\n]", (List)localObject2);
        if ((i == 0) && (((List)localObject2).size() > 0))
        {
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject2);
        }
        if (i == 0)
        {
          this.jdField_a_of_type_JavaUtilMap.put(bnkt.jdField_a_of_type_Bnkt, Integer.valueOf(4));
          bnrh.b("AEResManager", "[onConfigResultInternal] 构造内置列表成功，开始下载");
          localObject2 = new LinkedList(this.jdField_a_of_type_JavaUtilList);
          if (!paramBoolean) {}
          for (paramBoolean = bool;; paramBoolean = false)
          {
            a((List)localObject2, (QQAppInterface)localObject1, paramBoolean);
            break;
          }
        }
        this.jdField_a_of_type_JavaUtilMap.remove(bnkt.jdField_a_of_type_Bnkt);
        bnrh.b("AEResManager", "[onConfigResultInternal] 构造内置列表失败，返回信息");
        if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0))
        {
          i = 0;
          while (i < bnkt.jdField_b_of_type_ArrayOfBnkt.length)
          {
            localObject1 = bnkt.jdField_a_of_type_ArrayOfBnkt[i];
            localObject2 = this.jdField_b_of_type_JavaUtilList.iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((bnkw)((Iterator)localObject2).next()).onAEDownloadFinish((bnkt)localObject1, null, false, -102);
            }
            i += 1;
          }
        }
      }
    }
  }
  
  private boolean a(@NonNull List<ShortVideoResourceManager.SVConfigItem> paramList, @NonNull bcya parambcya, @NonNull QQAppInterface paramQQAppInterface, @NonNull bnkt parambnkt)
  {
    bnrh.b("AEResManager", "[startPreDownLoad] - BEGIN -, aeResInfo=" + parambnkt);
    PreDownloadController localPreDownloadController = (PreDownloadController)paramQQAppInterface.getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2);
    Iterator localIterator = paramList.iterator();
    ShortVideoResourceManager.SVConfigItem localSVConfigItem;
    while (localIterator.hasNext())
    {
      localSVConfigItem = (ShortVideoResourceManager.SVConfigItem)localIterator.next();
      if (localSVConfigItem.name.startsWith(parambnkt.jdField_b_of_type_JavaLangString)) {
        bnrh.b("AEResManager", "[startPreDownLoad], chosenConfigItem matched");
      }
    }
    for (;;)
    {
      if ((localPreDownloadController != null) && (localPreDownloadController.isEnable()))
      {
        parambcya = new bnkv(this, paramQQAppInterface, "ae_camera_res", new AEResManager.4(this, parambnkt, paramList, parambcya), 4000L);
        if (localSVConfigItem != null)
        {
          if ((VideoEnvironment64BitUtils.checkIs64bit()) && (localSVConfigItem.check64BitReady())) {}
          for (paramList = localSVConfigItem.arm64v8a_url;; paramList = localSVConfigItem.armv7a_url)
          {
            boolean bool = localPreDownloadController.requestPreDownload(10091, null, localSVConfigItem.name, 0, paramList, bnky.a(localSVConfigItem.name), 4, 0, true, parambcya);
            bnrh.b("AEResManager", "[startPreDownLoad], preDownloadController.requestPreDownload(), succeeded=" + bool);
            bnrh.b("AEResManager", "[startPreDownLoad] - END -, aeResInfo=" + parambnkt);
            return bool;
          }
        }
        bnrh.b("AEResManager", "[startPreDownLoad], chosenConfigItem == nul");
        bnrh.b("AEResManager", "[startPreDownLoad] - END -, aeResInfo=" + parambnkt);
        return false;
      }
      bnrh.b("AEResManager", "[startPreDownLoad], preDownloadController.isEnable() == false");
      bnrh.b("AEResManager", "[startPreDownLoad] - END -, aeResInfo=" + parambnkt);
      return false;
      localSVConfigItem = null;
    }
  }
  
  private void b(@NonNull bnkt parambnkt, @Nullable bnkw parambnkw)
  {
    bnrh.b("AEResManager", "[requestDownloadWithoutLoginInternal] - BEGIN -, packageIndex=" + parambnkt.jdField_a_of_type_Int);
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(parambnkt)) {
      this.jdField_a_of_type_JavaUtilMap.put(parambnkt, Integer.valueOf(0));
    }
    int i = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(parambnkt)).intValue();
    bnrh.b("AEResManager", "[requestDownloadWithoutLoginInternal], status=" + jdField_a_of_type_ArrayOfJavaLangString[i]);
    if (i == 4)
    {
      i = bnky.a(parambnkt.jdField_a_of_type_Int);
      if (i == 0) {
        break label575;
      }
    }
    label575:
    for (String str = bnky.a(parambnkt.jdField_b_of_type_JavaLangString + i);; str = null)
    {
      if (parambnkw != null) {
        parambnkw.onAEDownloadFinish(parambnkt, str, true, 0);
      }
      bnrh.b("AEResManager", "[requestDownloadWithoutLoginInternal], packageIndex=" + parambnkt.jdField_a_of_type_Int + ", downloadStatus=DOWNLOAD_STATUS_READY");
      bnrh.b("AEResManager", "[requestDownloadWithoutLoginInternal] - END -, packageIndex=" + parambnkt.jdField_a_of_type_Int);
      return;
      if (i == 3)
      {
        b(parambnkw);
        bnrh.b("AEResManager", "[requestDownloadWithoutLoginInternal], packageIndex=" + parambnkt.jdField_a_of_type_Int + ", downloadStatus=DOWNLOAD_STATUS_DOWNLOADING");
        bnrh.b("AEResManager", "[requestDownloadWithoutLoginInternal] - END -, packageIndex=" + parambnkt.jdField_a_of_type_Int);
        return;
      }
      if (!NetworkUtil.isNetworkAvailable(null))
      {
        if (parambnkw != null) {
          parambnkw.onAEDownloadFinish(parambnkt, null, false, -6);
        }
        bnrh.b("AEResManager", "[requestDownloadWithoutLoginInternal], packageIndex=" + parambnkt.jdField_a_of_type_Int + ", networkStatus=UNUSABLE");
        bnrh.b("AEResManager", "[requestDownloadWithoutLoginInternal] - END -, packageIndex=" + parambnkt.jdField_a_of_type_Int);
        return;
      }
      bnrh.b("AEResManager", "[requestDownloadWithoutLoginInternal], packageIndex=" + parambnkt.jdField_a_of_type_Int + ", networkStatus=USABLE");
      b(parambnkw);
      if (!this.jdField_a_of_type_JavaUtilQueue.contains(parambnkt))
      {
        this.jdField_a_of_type_JavaUtilQueue.add(parambnkt);
        this.jdField_a_of_type_JavaUtilMap.put(parambnkt, Integer.valueOf(1));
      }
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(bnkt.jdField_a_of_type_Bnkt))
      {
        this.jdField_a_of_type_JavaUtilMap.put(bnkt.jdField_a_of_type_Bnkt, Integer.valueOf(3));
        bcxs.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), this);
      }
      for (;;)
      {
        bnrh.b("AEResManager", "[requestDownloadWithoutLoginInternal] - END -, packageIndex=" + parambnkt.jdField_a_of_type_Int);
        return;
        if ((this.jdField_a_of_type_JavaUtilMap.get(bnkt.jdField_a_of_type_Bnkt) != null) && (((Integer)this.jdField_a_of_type_JavaUtilMap.get(bnkt.jdField_a_of_type_Bnkt)).intValue() == 4)) {
          a(1, 0);
        }
      }
    }
  }
  
  private void b(@Nullable bnkw parambnkw)
  {
    if (parambnkw == null) {}
    while ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.contains(parambnkw))) {
      return;
    }
    this.jdField_b_of_type_JavaUtilList.add(parambnkw);
  }
  
  @Deprecated
  public int a(@NonNull bnkt parambnkt)
  {
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      parambnkt = (Integer)this.jdField_a_of_type_JavaUtilMap.get(parambnkt);
      if (parambnkt != null) {
        return parambnkt.intValue();
      }
      return 0;
    }
    return 0;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    bnrh.b("AEResManager", "[onConfigResultWithoutLogin] - BEGIN -, result=" + paramInt1 + ", serverError=" + paramInt2);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEResManager.9(this));
    bnrh.b("AEResManager", "[onConfigResultWithoutLogin] - END -, result=" + paramInt1 + ", serverError=" + paramInt2);
  }
  
  public void a(@NonNull bnkt parambnkt, @Nullable bnkw parambnkw)
  {
    bnrh.b("AEResManager", "[requestDownloadWithoutLogin] - BEGIN -, aeResInfo=" + parambnkt);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEResManager.3(this, parambnkt, parambnkw));
    bnrh.b("AEResManager", "[requestDownloadWithoutLogin] - END -, aeResInfo=" + parambnkt);
  }
  
  public void a(@NonNull bnkt parambnkt, @Nullable bnkw parambnkw, boolean paramBoolean)
  {
    bnrh.b("AEResManager", "[requestDownload] - BEGIN -, aeResInfo=" + parambnkt);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEResManager.1(this, parambnkt, parambnkw, paramBoolean));
    bnrh.b("AEResManager", "[requestDownload] - END -, aeResInfo=" + parambnkt);
  }
  
  public void a(@Nullable bnkw parambnkw)
  {
    if (parambnkw == null) {}
    while (this.jdField_b_of_type_JavaUtilList == null) {
      return;
    }
    this.jdField_b_of_type_JavaUtilList.remove(parambnkw);
  }
  
  public void b(@NonNull bnkt parambnkt, @Nullable bnkw parambnkw, boolean paramBoolean)
  {
    bnrh.b("AEResManager", "[requestDownload] - BEGIN -, aeResInfo=" + parambnkt);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEResManager.2(this, parambnkt, parambnkw, paramBoolean));
    bnrh.b("AEResManager", "[requestDownload] - END -, aeResInfo=" + parambnkt);
  }
  
  public void onConfigResult(int paramInt1, int paramInt2)
  {
    bnrh.b("AEResManager", "[onConfigResult] - BEGIN -, result=" + paramInt1 + ", serverError=" + paramInt2);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEResManager.6(this));
    bnrh.b("AEResManager", "[onConfigResult] - END -, result=" + paramInt1 + ", serverError=" + paramInt2);
  }
  
  public void onDownloadFinish(String paramString1, int paramInt, String paramString2)
  {
    bnrh.b("AEResManager", "[onDownloadFinish] - BEGIN -, result=" + paramInt + ", name=" + paramString1 + ", filePath=" + paramString2);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEResManager.7(this, paramString1, paramInt, paramString2));
    bnrh.b("AEResManager", "[onDownloadFinish] - END -");
  }
  
  public void onNetWorkNone()
  {
    bnrh.d("AEResManager", anvx.a(2131699506));
    bcxc.a(3, -1500);
  }
  
  public void onUpdateProgress(String paramString, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AEResManager.8(this, paramString, paramLong1, paramLong2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnku
 * JD-Core Version:    0.7.0.1
 */