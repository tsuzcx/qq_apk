import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
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

public class borg
  implements bcxw, bcxz
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "DOWNLOAD_STATUS_IDLE", "DOWNLOAD_STATUS_WAIT", "DOWNLOAD_STATUS_PREDOWNLOAD_WAIT", "DOWNLOAD_STATUS_DOWNLOADING", "DOWNLOAD_STATUS_READY" };
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("AEResManagerHandlerThread", 0);
  private List<ShortVideoResourceManager.SVConfigItem> jdField_a_of_type_JavaUtilList = new LinkedList();
  private Map<borf, Integer> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private Queue<borf> jdField_a_of_type_JavaUtilQueue = new ArrayDeque();
  private List<bori> jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private Map<borf, Long> jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  private borg()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
  }
  
  public static borg a()
  {
    return borj.a;
  }
  
  private void a(@NonNull borf paramborf, @Nullable bori parambori, boolean paramBoolean1, boolean paramBoolean2)
  {
    bpam.b("AEResManager", "[requestDownloadInternal] - BEGIN -, packageIndex=" + paramborf.jdField_a_of_type_Int);
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramborf)) {
      this.jdField_a_of_type_JavaUtilMap.put(paramborf, Integer.valueOf(0));
    }
    int i = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(paramborf)).intValue();
    bpam.b("AEResManager", "[requestDownloadInternal], status=" + jdField_a_of_type_ArrayOfJavaLangString[i]);
    if (i == 4)
    {
      i = bork.a(paramborf.jdField_a_of_type_Int);
      if (i == 0) {
        break label682;
      }
    }
    label682:
    for (String str = bork.a(paramborf.jdField_b_of_type_JavaLangString + i);; str = null)
    {
      if (parambori != null) {
        parambori.a(paramborf, str, true, 0);
      }
      bork.a(paramborf, str);
      bpam.b("AEResManager", "[requestDownloadInternal], packageIndex=" + paramborf.jdField_a_of_type_Int + ", downloadStatus=DOWNLOAD_STATUS_READY");
      bpam.b("AEResManager", "[requestDownloadInternal] - END -, packageIndex=" + paramborf.jdField_a_of_type_Int);
      return;
      if (i == 3)
      {
        b(parambori);
        bpam.b("AEResManager", "[requestDownloadInternal], packageIndex=" + paramborf.jdField_a_of_type_Int + ", downloadStatus=DOWNLOAD_STATUS_DOWNLOADING");
        bpam.b("AEResManager", "[requestDownloadInternal] - END -, packageIndex=" + paramborf.jdField_a_of_type_Int);
        return;
      }
      if ((bhnv.g(null)) && ((!paramBoolean1) || (bhnv.h(null)))) {}
      for (i = 1; i == 0; i = 0)
      {
        if (parambori != null) {
          parambori.a(paramborf, null, false, -6);
        }
        bpam.d("AEResManager", "[requestDownloadInternal], packageIndex=" + paramborf.jdField_a_of_type_Int + ", networkStatus=UNUSABLE");
        bpam.b("AEResManager", "[requestDownloadInternal] - END -, packageIndex=" + paramborf.jdField_a_of_type_Int);
        return;
      }
      bpam.b("AEResManager", "[requestDownloadInternal], packageIndex=" + paramborf.jdField_a_of_type_Int + ", networkStatus=USABLE");
      b(parambori);
      if (!this.jdField_a_of_type_JavaUtilQueue.contains(paramborf))
      {
        this.jdField_a_of_type_JavaUtilQueue.add(paramborf);
        this.jdField_a_of_type_JavaUtilMap.put(paramborf, Integer.valueOf(1));
      }
      if ((paramborf.jdField_b_of_type_Boolean) && (paramBoolean2))
      {
        paramBoolean1 = true;
        paramborf.jdField_b_of_type_Boolean = paramBoolean1;
        if (this.jdField_a_of_type_JavaUtilMap.containsKey(borf.jdField_a_of_type_Borf)) {
          break label609;
        }
        bpam.b("AEResManager", "[requestDownloadInternal] 强制拉取配置列表" + paramborf.jdField_a_of_type_Int);
        this.jdField_a_of_type_JavaUtilMap.put(borf.jdField_a_of_type_Borf, Integer.valueOf(3));
        ShortVideoResourceManager.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), this);
      }
      for (;;)
      {
        bpam.b("AEResManager", "[requestDownloadInternal] - END -, packageIndex=" + paramborf.jdField_a_of_type_Int);
        return;
        paramBoolean1 = false;
        break;
        label609:
        if ((this.jdField_a_of_type_JavaUtilMap.get(borf.jdField_a_of_type_Borf) != null) && (((Integer)this.jdField_a_of_type_JavaUtilMap.get(borf.jdField_a_of_type_Borf)).intValue() == 4))
        {
          bpam.b("AEResManager", "[requestDownloadInternal] 配置列表已经存在, packageIndex = " + paramborf.jdField_a_of_type_Int);
          a(1, 0);
        }
      }
    }
  }
  
  private void a(@NonNull List<ShortVideoResourceManager.SVConfigItem> paramList, @NonNull QQAppInterface paramQQAppInterface, @NonNull borf paramborf)
  {
    bpam.b("AEResManager", "[cancelPreDownLoad] - BEGIN -, aeResInfo=" + paramborf);
    paramQQAppInterface = (bezv)paramQQAppInterface.getManager(193);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (ShortVideoResourceManager.SVConfigItem)localIterator.next();
      if (paramList.name.startsWith(paramborf.jdField_b_of_type_JavaLangString)) {
        bpam.b("AEResManager", "[cancelPreDownLoad], chosenConfigItem matched");
      }
    }
    for (;;)
    {
      if ((paramQQAppInterface != null) && (paramQQAppInterface.a()) && (paramList != null))
      {
        if ((!bcyy.a()) || (!paramList.check64BitReady())) {
          break label178;
        }
        paramQQAppInterface.a(paramList.arm64v8a_url);
      }
      for (;;)
      {
        bpam.b("AEResManager", "[cancelPreDownLoad], preDownloadController.isEnable() == " + paramQQAppInterface.a());
        bpam.b("AEResManager", "[cancelPreDownLoad] - END -, aeResInfo=" + paramborf);
        return;
        label178:
        paramQQAppInterface.a(paramList.armv7a_url);
      }
      paramList = null;
    }
  }
  
  private void a(@NonNull List<ShortVideoResourceManager.SVConfigItem> paramList, @NonNull QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    bpam.b("AEResManager", "[startDownLoad] + BEGIN");
    if (CollectionUtils.isEmpty(this.jdField_a_of_type_JavaUtilQueue))
    {
      bpam.d("AEResManager", "[startDownLoad], mDownLoadTaskQueue is empty");
      bpam.b("AEResManager", "[startDownLoad] - END -");
      return;
    }
    borf localborf = (borf)this.jdField_a_of_type_JavaUtilQueue.peek();
    if (localborf == null)
    {
      bpam.d("AEResManager", "[startDownLoad], mDownLoadTaskQueue top element is null");
      bpam.b("AEResManager", "[startDownLoad] + END");
      return;
    }
    int i;
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(localborf))
    {
      i = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(localborf)).intValue();
      bpam.a("AEResManager", "[startDownLoad], resNeedDownload=" + localborf);
      bpam.a("AEResManager", "[startDownLoad], status=" + jdField_a_of_type_ArrayOfJavaLangString[i]);
      if ((!paramBoolean) && (localborf.jdField_b_of_type_Boolean)) {
        break label275;
      }
      bpam.b("AEResManager", "[startDownLoad], isDownLoadImmediately=true");
      if (i != 3)
      {
        this.jdField_a_of_type_JavaUtilMap.put(localborf, Integer.valueOf(3));
        if (i == 2) {
          a(paramList, paramQQAppInterface, localborf);
        }
        this.jdField_b_of_type_JavaUtilMap.put(localborf, Long.valueOf(System.currentTimeMillis()));
        bpam.b("AEResManager", "[startDownLoad], realDownloadResource()");
        bord.a(localborf, paramList, this);
      }
    }
    for (;;)
    {
      bpam.b("AEResManager", "[startDownLoad] + END");
      return;
      bpam.d("AEResManager", "[startDownLoad], cannot find resNeedDownload in mStatusMap");
      bpam.b("AEResManager", "[startDownLoad] + END");
      return;
      label275:
      bpam.b("AEResManager", "[startDownLoad], isDownLoadImmediately=false");
      if ((i == 3) || (i == 2)) {
        break;
      }
      if (!a(paramList, this, paramQQAppInterface, localborf))
      {
        a(paramList, paramQQAppInterface, localborf);
        localborf.jdField_b_of_type_Boolean = false;
        this.jdField_b_of_type_JavaUtilMap.put(localborf, Long.valueOf(System.currentTimeMillis()));
        bpam.b("AEResManager", "[startDownLoad], realDownloadResource()");
        this.jdField_a_of_type_JavaUtilMap.put(localborf, Integer.valueOf(3));
        bord.a(localborf, paramList, this);
      }
      else
      {
        this.jdField_a_of_type_JavaUtilMap.put(localborf, Integer.valueOf(2));
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    boolean bool = true;
    bpam.b("AEResManager", "[onConfigResultInternal] ++++++ BEGIN");
    int i;
    if (this.jdField_a_of_type_JavaUtilList.size() < 1)
    {
      bpam.b("AEResManager", "[onConfigResultInternal] 内存中'还没有'列表信息，开始生成配置列表");
      i = ShortVideoResourceManager.a(null, this.jdField_a_of_type_JavaUtilList);
      bpam.b("AEResManager", "[onConfigResultInternal] 生成配置列表结果 errCode = " + i);
      bpam.b("AEResManager", "[onConfigResultInternal] 内存中'当前的'配置列表信息，size = " + this.jdField_a_of_type_JavaUtilList.size());
      if (i != 0) {
        break label523;
      }
      i = bork.a(this.jdField_a_of_type_JavaUtilList);
    }
    label523:
    for (;;)
    {
      Object localObject1 = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      Object localObject2;
      if (i == 0)
      {
        this.jdField_a_of_type_JavaUtilMap.put(borf.jdField_a_of_type_Borf, Integer.valueOf(4));
        bpam.b("AEResManager", "[onConfigResultInternal] 配置列表拉取成功，开始进行ZIP包下载");
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
        bpam.b("AEResManager", "[onConfigResultInternal] ++++++ END");
        return;
        bpam.b("AEResManager", "[onConfigResultInternal] 内存中'已经有'列表信息，执行检查刷新列表");
        localObject1 = new LinkedList();
        int j = ShortVideoResourceManager.a(null, (List)localObject1);
        bpam.b("AEResManager", "[onConfigResultInternal] 内存中'已经有'列表信息，刷新后列表为 = " + localObject1);
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
        bpam.b("AEResManager", "[onConfigResultInternal] 配置列表拉取失败，尝试构造内置列表进行下载");
        localObject2 = new LinkedList();
        i = ShortVideoResourceManager.a("[\n    {\n        \"name\": \"new_qq_android_native_short_filter_84503\",\n        \"arm_url\": \"https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_short_filter_84503.zip\",\n        \"armv7a_url\": \"https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_short_filter_84503.zip\",\n        \"x86_url\": \"https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_short_filter_84503.zip\",\n        \"arm64v8a_url\": \"https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_short_filter_84503_64bit.zip\",\n        \"arm_md5\": \"c68bcdfe88d15f5ef852178d09c1742e\",\n        \"armv7a_md5\": \"c68bcdfe88d15f5ef852178d09c1742e\",\n        \"x86_md5\": \"c68bcdfe88d15f5ef852178d09c1742e\",\n        \"arm64v8a_md5\": \"13a1959468f99f83d31a159b62c01ccd\",\n        \"versionCode\": \"845\",\n        \"predownload\": false\n    },\n    {\n        \"name\": \"new_qq_android_native_ptu_res_84503\",\n        \"arm_url\": \"https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_ptu_res_84503.zip\",\n        \"armv7a_url\": \"https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_ptu_res_84503.zip\",\n        \"x86_url\": \"https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_ptu_res_84503.zip\",\n        \"arm64v8a_url\": \"https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_ptu_res_84503_64bit.zip\",\n        \"arm_md5\": \"16ab7bb205448f8520b5000a30c12907\",\n        \"armv7a_md5\": \"16ab7bb205448f8520b5000a30c12907\",\n        \"x86_md5\": \"16ab7bb205448f8520b5000a30c12907\",\n        \"arm64v8a_md5\": \"6d1a5ad599e0e12413dfaa232bbb61bd\",\n        \"versionCode\": \"845\",\n        \"predownload\": false\n    }\n]", (List)localObject2);
        if ((i == 0) && (((List)localObject2).size() > 0))
        {
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject2);
        }
        if (i == 0)
        {
          this.jdField_a_of_type_JavaUtilMap.put(borf.jdField_a_of_type_Borf, Integer.valueOf(4));
          bpam.b("AEResManager", "[onConfigResultInternal] 构造内置列表成功，开始下载");
          localObject2 = new LinkedList(this.jdField_a_of_type_JavaUtilList);
          if (!paramBoolean) {}
          for (paramBoolean = bool;; paramBoolean = false)
          {
            a((List)localObject2, (QQAppInterface)localObject1, paramBoolean);
            break;
          }
        }
        this.jdField_a_of_type_JavaUtilMap.remove(borf.jdField_a_of_type_Borf);
        bpam.b("AEResManager", "[onConfigResultInternal] 构造内置列表失败，返回信息");
        if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0))
        {
          i = 0;
          while (i < borf.jdField_b_of_type_ArrayOfBorf.length)
          {
            localObject1 = borf.jdField_a_of_type_ArrayOfBorf[i];
            localObject2 = this.jdField_b_of_type_JavaUtilList.iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((bori)((Iterator)localObject2).next()).a((borf)localObject1, null, false, -102);
            }
            i += 1;
          }
        }
      }
    }
  }
  
  private boolean a(@NonNull List<ShortVideoResourceManager.SVConfigItem> paramList, @NonNull bcxw parambcxw, @NonNull QQAppInterface paramQQAppInterface, @NonNull borf paramborf)
  {
    bpam.b("AEResManager", "[startPreDownLoad] - BEGIN -, aeResInfo=" + paramborf);
    bezv localbezv = (bezv)paramQQAppInterface.getManager(193);
    Iterator localIterator = paramList.iterator();
    ShortVideoResourceManager.SVConfigItem localSVConfigItem;
    while (localIterator.hasNext())
    {
      localSVConfigItem = (ShortVideoResourceManager.SVConfigItem)localIterator.next();
      if (localSVConfigItem.name.startsWith(paramborf.jdField_b_of_type_JavaLangString)) {
        bpam.b("AEResManager", "[startPreDownLoad], chosenConfigItem matched");
      }
    }
    for (;;)
    {
      if ((localbezv != null) && (localbezv.a()))
      {
        parambcxw = new borh(this, paramQQAppInterface, "ae_camera_res", new AEResManager.4(this, paramborf, paramList, parambcxw), 4000L);
        if (localSVConfigItem != null)
        {
          if ((bcyy.a()) && (localSVConfigItem.check64BitReady())) {}
          for (paramList = localSVConfigItem.arm64v8a_url;; paramList = localSVConfigItem.armv7a_url)
          {
            boolean bool = localbezv.a(10091, null, localSVConfigItem.name, 0, paramList, bork.a(localSVConfigItem.name), 4, 0, true, parambcxw);
            bpam.b("AEResManager", "[startPreDownLoad], preDownloadController.requestPreDownload(), succeeded=" + bool);
            bpam.b("AEResManager", "[startPreDownLoad] - END -, aeResInfo=" + paramborf);
            return bool;
          }
        }
        bpam.b("AEResManager", "[startPreDownLoad], chosenConfigItem == nul");
        bpam.b("AEResManager", "[startPreDownLoad] - END -, aeResInfo=" + paramborf);
        return false;
      }
      bpam.b("AEResManager", "[startPreDownLoad], preDownloadController.isEnable() == false");
      bpam.b("AEResManager", "[startPreDownLoad] - END -, aeResInfo=" + paramborf);
      return false;
      localSVConfigItem = null;
    }
  }
  
  private void b(@NonNull borf paramborf, @Nullable bori parambori)
  {
    bpam.b("AEResManager", "[requestDownloadWithoutLoginInternal] - BEGIN -, packageIndex=" + paramborf.jdField_a_of_type_Int);
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramborf)) {
      this.jdField_a_of_type_JavaUtilMap.put(paramborf, Integer.valueOf(0));
    }
    int i = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(paramborf)).intValue();
    bpam.b("AEResManager", "[requestDownloadWithoutLoginInternal], status=" + jdField_a_of_type_ArrayOfJavaLangString[i]);
    if (i == 4)
    {
      i = bork.a(paramborf.jdField_a_of_type_Int);
      if (i == 0) {
        break label575;
      }
    }
    label575:
    for (String str = bork.a(paramborf.jdField_b_of_type_JavaLangString + i);; str = null)
    {
      if (parambori != null) {
        parambori.a(paramborf, str, true, 0);
      }
      bpam.b("AEResManager", "[requestDownloadWithoutLoginInternal], packageIndex=" + paramborf.jdField_a_of_type_Int + ", downloadStatus=DOWNLOAD_STATUS_READY");
      bpam.b("AEResManager", "[requestDownloadWithoutLoginInternal] - END -, packageIndex=" + paramborf.jdField_a_of_type_Int);
      return;
      if (i == 3)
      {
        b(parambori);
        bpam.b("AEResManager", "[requestDownloadWithoutLoginInternal], packageIndex=" + paramborf.jdField_a_of_type_Int + ", downloadStatus=DOWNLOAD_STATUS_DOWNLOADING");
        bpam.b("AEResManager", "[requestDownloadWithoutLoginInternal] - END -, packageIndex=" + paramborf.jdField_a_of_type_Int);
        return;
      }
      if (!bhnv.g(null))
      {
        if (parambori != null) {
          parambori.a(paramborf, null, false, -6);
        }
        bpam.b("AEResManager", "[requestDownloadWithoutLoginInternal], packageIndex=" + paramborf.jdField_a_of_type_Int + ", networkStatus=UNUSABLE");
        bpam.b("AEResManager", "[requestDownloadWithoutLoginInternal] - END -, packageIndex=" + paramborf.jdField_a_of_type_Int);
        return;
      }
      bpam.b("AEResManager", "[requestDownloadWithoutLoginInternal], packageIndex=" + paramborf.jdField_a_of_type_Int + ", networkStatus=USABLE");
      b(parambori);
      if (!this.jdField_a_of_type_JavaUtilQueue.contains(paramborf))
      {
        this.jdField_a_of_type_JavaUtilQueue.add(paramborf);
        this.jdField_a_of_type_JavaUtilMap.put(paramborf, Integer.valueOf(1));
      }
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(borf.jdField_a_of_type_Borf))
      {
        this.jdField_a_of_type_JavaUtilMap.put(borf.jdField_a_of_type_Borf, Integer.valueOf(3));
        bcxo.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), this);
      }
      for (;;)
      {
        bpam.b("AEResManager", "[requestDownloadWithoutLoginInternal] - END -, packageIndex=" + paramborf.jdField_a_of_type_Int);
        return;
        if ((this.jdField_a_of_type_JavaUtilMap.get(borf.jdField_a_of_type_Borf) != null) && (((Integer)this.jdField_a_of_type_JavaUtilMap.get(borf.jdField_a_of_type_Borf)).intValue() == 4)) {
          b(1, 0);
        }
      }
    }
  }
  
  private void b(@Nullable bori parambori)
  {
    if (parambori == null) {}
    while ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.contains(parambori))) {
      return;
    }
    this.jdField_b_of_type_JavaUtilList.add(parambori);
  }
  
  private void b(String paramString1, int paramInt, String paramString2)
  {
    boolean bool2 = false;
    bpam.b("AEResManager", "[onDownloadFinishInternal] - BEGIN -, result=" + paramInt + ", name=" + paramString1 + ", filePath=" + paramString2);
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
      localObject2 = borf.jdField_b_of_type_ArrayOfBorf;
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
          bpam.b("AEResManager", "[onDownloadFinishInternal], matched aeResInfo=" + paramString1);
          if (i == 0)
          {
            this.jdField_a_of_type_JavaUtilMap.put(paramString1, Integer.valueOf(4));
            this.jdField_a_of_type_JavaUtilQueue.remove(paramString1);
            bork.a(paramString1, paramString2);
            j = Integer.valueOf(((String)localObject1).substring(paramString1.jdField_b_of_type_JavaLangString.length())).intValue();
            bork.a(paramString1.jdField_a_of_type_Int, j);
            label200:
            localObject1 = this.jdField_b_of_type_JavaUtilList.iterator();
            label211:
            if (!((Iterator)localObject1).hasNext()) {
              break label298;
            }
            localObject2 = (bori)((Iterator)localObject1).next();
            if (i != 0) {
              break label292;
            }
          }
          label292:
          for (boolean bool1 = true;; bool1 = false)
          {
            ((bori)localObject2).a(paramString1, paramString2, bool1, i);
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
            paramString2 = bozr.a();
            bool1 = bool2;
            if (paramInt == 0) {
              bool1 = true;
            }
            paramString2.a(bool1, paramString1.jdField_a_of_type_Int, "", "", paramInt, l);
          }
          bpam.b("AEResManager", "[onDownloadFinishInternal], start download next package");
          paramString1 = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
          a(new LinkedList(this.jdField_a_of_type_JavaUtilList), paramString1, true);
        }
      }
      else
      {
        bpam.b("AEResManager", "[onDownloadFinishInternal] - END -");
        return;
      }
      j += 1;
    }
  }
  
  private void b(String paramString, long paramLong1, long paramLong2)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = borf.jdField_b_of_type_ArrayOfBorf;
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
          ((bori)localIterator.next()).a(localObject, paramLong1, paramLong2);
        }
      }
      i += 1;
    }
  }
  
  public void B_()
  {
    bpam.d("AEResManager", anzj.a(2131698920));
    bcwy.a(3, -1500);
  }
  
  @Deprecated
  public int a(@NonNull borf paramborf)
  {
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      paramborf = (Integer)this.jdField_a_of_type_JavaUtilMap.get(paramborf);
      if (paramborf != null) {
        return paramborf.intValue();
      }
      return 0;
    }
    return 0;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    bpam.b("AEResManager", "[onConfigResult] - BEGIN -, result=" + paramInt1 + ", serverError=" + paramInt2);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEResManager.6(this));
    bpam.b("AEResManager", "[onConfigResult] - END -, result=" + paramInt1 + ", serverError=" + paramInt2);
  }
  
  public void a(@NonNull borf paramborf, @Nullable bori parambori)
  {
    bpam.b("AEResManager", "[requestDownloadWithoutLogin] - BEGIN -, aeResInfo=" + paramborf);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEResManager.3(this, paramborf, parambori));
    bpam.b("AEResManager", "[requestDownloadWithoutLogin] - END -, aeResInfo=" + paramborf);
  }
  
  public void a(@NonNull borf paramborf, @Nullable bori parambori, boolean paramBoolean)
  {
    bpam.b("AEResManager", "[requestDownload] - BEGIN -, aeResInfo=" + paramborf);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEResManager.1(this, paramborf, parambori, paramBoolean));
    bpam.b("AEResManager", "[requestDownload] - END -, aeResInfo=" + paramborf);
  }
  
  public void a(@Nullable bori parambori)
  {
    if (parambori == null) {}
    while (this.jdField_b_of_type_JavaUtilList == null) {
      return;
    }
    this.jdField_b_of_type_JavaUtilList.remove(parambori);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    bpam.b("AEResManager", "[onDownloadFinish] - BEGIN -, result=" + paramInt + ", name=" + paramString1 + ", filePath=" + paramString2);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEResManager.7(this, paramString1, paramInt, paramString2));
    bpam.b("AEResManager", "[onDownloadFinish] - END -");
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AEResManager.8(this, paramString, paramLong1, paramLong2));
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    bpam.b("AEResManager", "[onConfigResultWithoutLogin] - BEGIN -, result=" + paramInt1 + ", serverError=" + paramInt2);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEResManager.9(this));
    bpam.b("AEResManager", "[onConfigResultWithoutLogin] - END -, result=" + paramInt1 + ", serverError=" + paramInt2);
  }
  
  public void b(@NonNull borf paramborf, @Nullable bori parambori, boolean paramBoolean)
  {
    bpam.b("AEResManager", "[requestDownload] - BEGIN -, aeResInfo=" + paramborf);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEResManager.2(this, paramborf, parambori, paramBoolean));
    bpam.b("AEResManager", "[requestDownload] - END -, aeResInfo=" + paramborf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     borg
 * JD-Core Version:    0.7.0.1
 */