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

public class bnpu
  implements bcfe, bcfh
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "DOWNLOAD_STATUS_IDLE", "DOWNLOAD_STATUS_WAIT", "DOWNLOAD_STATUS_PREDOWNLOAD_WAIT", "DOWNLOAD_STATUS_DOWNLOADING", "DOWNLOAD_STATUS_READY" };
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("AEResManagerHandlerThread", 0);
  private List<ShortVideoResourceManager.SVConfigItem> jdField_a_of_type_JavaUtilList = new LinkedList();
  private Map<bnpt, Integer> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private Queue<bnpt> jdField_a_of_type_JavaUtilQueue = new ArrayDeque();
  private List<bnpw> jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private Map<bnpt, Long> jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  private bnpu()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
  }
  
  public static bnpu a()
  {
    return bnpx.a;
  }
  
  private void a(@NonNull bnpt parambnpt, @Nullable bnpw parambnpw, boolean paramBoolean1, boolean paramBoolean2)
  {
    bnzb.b("AEResManager", "[requestDownloadInternal] - BEGIN -, packageIndex=" + parambnpt.jdField_a_of_type_Int);
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(parambnpt)) {
      this.jdField_a_of_type_JavaUtilMap.put(parambnpt, Integer.valueOf(0));
    }
    int i = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(parambnpt)).intValue();
    bnzb.b("AEResManager", "[requestDownloadInternal], status=" + jdField_a_of_type_ArrayOfJavaLangString[i]);
    if (i == 4)
    {
      i = bnpy.a(parambnpt.jdField_a_of_type_Int);
      if (i == 0) {
        break label682;
      }
    }
    label682:
    for (String str = bnpy.a(parambnpt.jdField_b_of_type_JavaLangString + i);; str = null)
    {
      if (parambnpw != null) {
        parambnpw.a(parambnpt, str, true, 0);
      }
      bnpy.a(parambnpt, str);
      bnzb.b("AEResManager", "[requestDownloadInternal], packageIndex=" + parambnpt.jdField_a_of_type_Int + ", downloadStatus=DOWNLOAD_STATUS_READY");
      bnzb.b("AEResManager", "[requestDownloadInternal] - END -, packageIndex=" + parambnpt.jdField_a_of_type_Int);
      return;
      if (i == 3)
      {
        b(parambnpw);
        bnzb.b("AEResManager", "[requestDownloadInternal], packageIndex=" + parambnpt.jdField_a_of_type_Int + ", downloadStatus=DOWNLOAD_STATUS_DOWNLOADING");
        bnzb.b("AEResManager", "[requestDownloadInternal] - END -, packageIndex=" + parambnpt.jdField_a_of_type_Int);
        return;
      }
      if ((bgnt.g(null)) && ((!paramBoolean1) || (bgnt.h(null)))) {}
      for (i = 1; i == 0; i = 0)
      {
        if (parambnpw != null) {
          parambnpw.a(parambnpt, null, false, -6);
        }
        bnzb.d("AEResManager", "[requestDownloadInternal], packageIndex=" + parambnpt.jdField_a_of_type_Int + ", networkStatus=UNUSABLE");
        bnzb.b("AEResManager", "[requestDownloadInternal] - END -, packageIndex=" + parambnpt.jdField_a_of_type_Int);
        return;
      }
      bnzb.b("AEResManager", "[requestDownloadInternal], packageIndex=" + parambnpt.jdField_a_of_type_Int + ", networkStatus=USABLE");
      b(parambnpw);
      if (!this.jdField_a_of_type_JavaUtilQueue.contains(parambnpt))
      {
        this.jdField_a_of_type_JavaUtilQueue.add(parambnpt);
        this.jdField_a_of_type_JavaUtilMap.put(parambnpt, Integer.valueOf(1));
      }
      if ((parambnpt.jdField_b_of_type_Boolean) && (paramBoolean2))
      {
        paramBoolean1 = true;
        parambnpt.jdField_b_of_type_Boolean = paramBoolean1;
        if (this.jdField_a_of_type_JavaUtilMap.containsKey(bnpt.jdField_a_of_type_Bnpt)) {
          break label609;
        }
        bnzb.b("AEResManager", "[requestDownloadInternal] 强制拉取配置列表" + parambnpt.jdField_a_of_type_Int);
        this.jdField_a_of_type_JavaUtilMap.put(bnpt.jdField_a_of_type_Bnpt, Integer.valueOf(3));
        ShortVideoResourceManager.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), this);
      }
      for (;;)
      {
        bnzb.b("AEResManager", "[requestDownloadInternal] - END -, packageIndex=" + parambnpt.jdField_a_of_type_Int);
        return;
        paramBoolean1 = false;
        break;
        label609:
        if ((this.jdField_a_of_type_JavaUtilMap.get(bnpt.jdField_a_of_type_Bnpt) != null) && (((Integer)this.jdField_a_of_type_JavaUtilMap.get(bnpt.jdField_a_of_type_Bnpt)).intValue() == 4))
        {
          bnzb.b("AEResManager", "[requestDownloadInternal] 配置列表已经存在, packageIndex = " + parambnpt.jdField_a_of_type_Int);
          a(1, 0);
        }
      }
    }
  }
  
  private void a(@NonNull List<ShortVideoResourceManager.SVConfigItem> paramList, @NonNull QQAppInterface paramQQAppInterface, @NonNull bnpt parambnpt)
  {
    bnzb.b("AEResManager", "[cancelPreDownLoad] - BEGIN -, aeResInfo=" + parambnpt);
    paramQQAppInterface = (beaw)paramQQAppInterface.getManager(193);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (ShortVideoResourceManager.SVConfigItem)localIterator.next();
      if (paramList.name.startsWith(parambnpt.jdField_b_of_type_JavaLangString)) {
        bnzb.b("AEResManager", "[cancelPreDownLoad], chosenConfigItem matched");
      }
    }
    for (;;)
    {
      if ((paramQQAppInterface != null) && (paramQQAppInterface.a()) && (paramList != null))
      {
        if ((!bcgg.a()) || (!paramList.check64BitReady())) {
          break label178;
        }
        paramQQAppInterface.a(paramList.arm64v8a_url);
      }
      for (;;)
      {
        bnzb.b("AEResManager", "[cancelPreDownLoad], preDownloadController.isEnable() == " + paramQQAppInterface.a());
        bnzb.b("AEResManager", "[cancelPreDownLoad] - END -, aeResInfo=" + parambnpt);
        return;
        label178:
        paramQQAppInterface.a(paramList.armv7a_url);
      }
      paramList = null;
    }
  }
  
  private void a(@NonNull List<ShortVideoResourceManager.SVConfigItem> paramList, @NonNull QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    bnzb.b("AEResManager", "[startDownLoad] + BEGIN");
    if (CollectionUtils.isEmpty(this.jdField_a_of_type_JavaUtilQueue))
    {
      bnzb.d("AEResManager", "[startDownLoad], mDownLoadTaskQueue is empty");
      bnzb.b("AEResManager", "[startDownLoad] - END -");
      return;
    }
    bnpt localbnpt = (bnpt)this.jdField_a_of_type_JavaUtilQueue.peek();
    if (localbnpt == null)
    {
      bnzb.d("AEResManager", "[startDownLoad], mDownLoadTaskQueue top element is null");
      bnzb.b("AEResManager", "[startDownLoad] + END");
      return;
    }
    int i;
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(localbnpt))
    {
      i = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(localbnpt)).intValue();
      bnzb.a("AEResManager", "[startDownLoad], resNeedDownload=" + localbnpt);
      bnzb.a("AEResManager", "[startDownLoad], status=" + jdField_a_of_type_ArrayOfJavaLangString[i]);
      if ((!paramBoolean) && (localbnpt.jdField_b_of_type_Boolean)) {
        break label275;
      }
      bnzb.b("AEResManager", "[startDownLoad], isDownLoadImmediately=true");
      if (i != 3)
      {
        this.jdField_a_of_type_JavaUtilMap.put(localbnpt, Integer.valueOf(3));
        if (i == 2) {
          a(paramList, paramQQAppInterface, localbnpt);
        }
        this.jdField_b_of_type_JavaUtilMap.put(localbnpt, Long.valueOf(System.currentTimeMillis()));
        bnzb.b("AEResManager", "[startDownLoad], realDownloadResource()");
        bnpr.a(localbnpt, paramList, this);
      }
    }
    for (;;)
    {
      bnzb.b("AEResManager", "[startDownLoad] + END");
      return;
      bnzb.d("AEResManager", "[startDownLoad], cannot find resNeedDownload in mStatusMap");
      bnzb.b("AEResManager", "[startDownLoad] + END");
      return;
      label275:
      bnzb.b("AEResManager", "[startDownLoad], isDownLoadImmediately=false");
      if ((i == 3) || (i == 2)) {
        break;
      }
      if (!a(paramList, this, paramQQAppInterface, localbnpt))
      {
        a(paramList, paramQQAppInterface, localbnpt);
        localbnpt.jdField_b_of_type_Boolean = false;
        this.jdField_b_of_type_JavaUtilMap.put(localbnpt, Long.valueOf(System.currentTimeMillis()));
        bnzb.b("AEResManager", "[startDownLoad], realDownloadResource()");
        this.jdField_a_of_type_JavaUtilMap.put(localbnpt, Integer.valueOf(3));
        bnpr.a(localbnpt, paramList, this);
      }
      else
      {
        this.jdField_a_of_type_JavaUtilMap.put(localbnpt, Integer.valueOf(2));
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    boolean bool = true;
    bnzb.b("AEResManager", "[onConfigResultInternal] ++++++ BEGIN");
    int i;
    if (this.jdField_a_of_type_JavaUtilList.size() < 1)
    {
      bnzb.b("AEResManager", "[onConfigResultInternal] 内存中'还没有'列表信息，开始生成配置列表");
      i = ShortVideoResourceManager.a(null, this.jdField_a_of_type_JavaUtilList);
      bnzb.b("AEResManager", "[onConfigResultInternal] 生成配置列表结果 errCode = " + i);
      bnzb.b("AEResManager", "[onConfigResultInternal] 内存中'当前的'配置列表信息，size = " + this.jdField_a_of_type_JavaUtilList.size());
      if (i != 0) {
        break label523;
      }
      i = bnpy.a(this.jdField_a_of_type_JavaUtilList);
    }
    label523:
    for (;;)
    {
      Object localObject1 = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      Object localObject2;
      if (i == 0)
      {
        this.jdField_a_of_type_JavaUtilMap.put(bnpt.jdField_a_of_type_Bnpt, Integer.valueOf(4));
        bnzb.b("AEResManager", "[onConfigResultInternal] 配置列表拉取成功，开始进行ZIP包下载");
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
        bnzb.b("AEResManager", "[onConfigResultInternal] ++++++ END");
        return;
        bnzb.b("AEResManager", "[onConfigResultInternal] 内存中'已经有'列表信息，执行检查刷新列表");
        localObject1 = new LinkedList();
        int j = ShortVideoResourceManager.a(null, (List)localObject1);
        bnzb.b("AEResManager", "[onConfigResultInternal] 内存中'已经有'列表信息，刷新后列表为 = " + localObject1);
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
        bnzb.b("AEResManager", "[onConfigResultInternal] 配置列表拉取失败，尝试构造内置列表进行下载");
        localObject2 = new LinkedList();
        i = ShortVideoResourceManager.a("[\n    {\n        \"name\": \"new_qq_android_native_short_filter_84107\",\n        \"arm_url\": \"https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_short_filter_84107.zip\",\n        \"armv7a_url\": \"https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_short_filter_84107.zip\",\n        \"x86_url\": \"https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_short_filter_84107.zip\",\n        \"arm64v8a_url\": \"https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_short_filter_84107_64bit.zip\",\n        \"arm_md5\": \"47f1b8948c6c228fd7cdc807e6b689f8\",\n        \"armv7a_md5\": \"47f1b8948c6c228fd7cdc807e6b689f8\",\n        \"x86_md5\": \"47f1b8948c6c228fd7cdc807e6b689f8\",\n        \"arm64v8a_md5\": \"3332ed94e478fe07b723fb7a97384fee\",\n        \"versionCode\": \"841\",\n        \"predownload\": false\n    },\n    {\n        \"name\": \"new_qq_android_native_ptu_res_84107\",\n        \"arm_url\": \"https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_ptu_res_84107.zip\",\n        \"armv7a_url\": \"https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_ptu_res_84107.zip\",\n        \"x86_url\": \"https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_ptu_res_84107.zip\",\n        \"arm64v8a_url\": \"https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_ptu_res_84107_64bit.zip\",\n        \"arm_md5\": \"4a7889f832aa9edaf5e8fc7fd01dac74\",\n        \"armv7a_md5\": \"4a7889f832aa9edaf5e8fc7fd01dac74\",\n        \"x86_md5\": \"4a7889f832aa9edaf5e8fc7fd01dac74\",\n        \"arm64v8a_md5\": \"f4af0371e8e856e02e1fe8474b6e2e30\",\n        \"versionCode\": \"841\",\n        \"predownload\": false\n    }\n]", (List)localObject2);
        if ((i == 0) && (((List)localObject2).size() > 0))
        {
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject2);
        }
        if (i == 0)
        {
          this.jdField_a_of_type_JavaUtilMap.put(bnpt.jdField_a_of_type_Bnpt, Integer.valueOf(4));
          bnzb.b("AEResManager", "[onConfigResultInternal] 构造内置列表成功，开始下载");
          localObject2 = new LinkedList(this.jdField_a_of_type_JavaUtilList);
          if (!paramBoolean) {}
          for (paramBoolean = bool;; paramBoolean = false)
          {
            a((List)localObject2, (QQAppInterface)localObject1, paramBoolean);
            break;
          }
        }
        this.jdField_a_of_type_JavaUtilMap.remove(bnpt.jdField_a_of_type_Bnpt);
        bnzb.b("AEResManager", "[onConfigResultInternal] 构造内置列表失败，返回信息");
        if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0))
        {
          i = 0;
          while (i < bnpt.jdField_b_of_type_ArrayOfBnpt.length)
          {
            localObject1 = bnpt.jdField_a_of_type_ArrayOfBnpt[i];
            localObject2 = this.jdField_b_of_type_JavaUtilList.iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((bnpw)((Iterator)localObject2).next()).a((bnpt)localObject1, null, false, -102);
            }
            i += 1;
          }
        }
      }
    }
  }
  
  private boolean a(@NonNull List<ShortVideoResourceManager.SVConfigItem> paramList, @NonNull bcfe parambcfe, @NonNull QQAppInterface paramQQAppInterface, @NonNull bnpt parambnpt)
  {
    bnzb.b("AEResManager", "[startPreDownLoad] - BEGIN -, aeResInfo=" + parambnpt);
    beaw localbeaw = (beaw)paramQQAppInterface.getManager(193);
    Iterator localIterator = paramList.iterator();
    ShortVideoResourceManager.SVConfigItem localSVConfigItem;
    while (localIterator.hasNext())
    {
      localSVConfigItem = (ShortVideoResourceManager.SVConfigItem)localIterator.next();
      if (localSVConfigItem.name.startsWith(parambnpt.jdField_b_of_type_JavaLangString)) {
        bnzb.b("AEResManager", "[startPreDownLoad], chosenConfigItem matched");
      }
    }
    for (;;)
    {
      if ((localbeaw != null) && (localbeaw.a()))
      {
        parambcfe = new bnpv(this, paramQQAppInterface, "ae_camera_res", new AEResManager.4(this, parambnpt, paramList, parambcfe), 4000L);
        if (localSVConfigItem != null)
        {
          if ((bcgg.a()) && (localSVConfigItem.check64BitReady())) {}
          for (paramList = localSVConfigItem.arm64v8a_url;; paramList = localSVConfigItem.armv7a_url)
          {
            boolean bool = localbeaw.a(10091, null, localSVConfigItem.name, 0, paramList, bnpy.a(localSVConfigItem.name), 4, 0, true, parambcfe);
            bnzb.b("AEResManager", "[startPreDownLoad], preDownloadController.requestPreDownload(), succeeded=" + bool);
            bnzb.b("AEResManager", "[startPreDownLoad] - END -, aeResInfo=" + parambnpt);
            return bool;
          }
        }
        bnzb.b("AEResManager", "[startPreDownLoad], chosenConfigItem == nul");
        bnzb.b("AEResManager", "[startPreDownLoad] - END -, aeResInfo=" + parambnpt);
        return false;
      }
      bnzb.b("AEResManager", "[startPreDownLoad], preDownloadController.isEnable() == false");
      bnzb.b("AEResManager", "[startPreDownLoad] - END -, aeResInfo=" + parambnpt);
      return false;
      localSVConfigItem = null;
    }
  }
  
  private void b(@NonNull bnpt parambnpt, @Nullable bnpw parambnpw)
  {
    bnzb.b("AEResManager", "[requestDownloadWithoutLoginInternal] - BEGIN -, packageIndex=" + parambnpt.jdField_a_of_type_Int);
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(parambnpt)) {
      this.jdField_a_of_type_JavaUtilMap.put(parambnpt, Integer.valueOf(0));
    }
    int i = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(parambnpt)).intValue();
    bnzb.b("AEResManager", "[requestDownloadWithoutLoginInternal], status=" + jdField_a_of_type_ArrayOfJavaLangString[i]);
    if (i == 4)
    {
      i = bnpy.a(parambnpt.jdField_a_of_type_Int);
      if (i == 0) {
        break label575;
      }
    }
    label575:
    for (String str = bnpy.a(parambnpt.jdField_b_of_type_JavaLangString + i);; str = null)
    {
      if (parambnpw != null) {
        parambnpw.a(parambnpt, str, true, 0);
      }
      bnzb.b("AEResManager", "[requestDownloadWithoutLoginInternal], packageIndex=" + parambnpt.jdField_a_of_type_Int + ", downloadStatus=DOWNLOAD_STATUS_READY");
      bnzb.b("AEResManager", "[requestDownloadWithoutLoginInternal] - END -, packageIndex=" + parambnpt.jdField_a_of_type_Int);
      return;
      if (i == 3)
      {
        b(parambnpw);
        bnzb.b("AEResManager", "[requestDownloadWithoutLoginInternal], packageIndex=" + parambnpt.jdField_a_of_type_Int + ", downloadStatus=DOWNLOAD_STATUS_DOWNLOADING");
        bnzb.b("AEResManager", "[requestDownloadWithoutLoginInternal] - END -, packageIndex=" + parambnpt.jdField_a_of_type_Int);
        return;
      }
      if (!bgnt.g(null))
      {
        if (parambnpw != null) {
          parambnpw.a(parambnpt, null, false, -6);
        }
        bnzb.b("AEResManager", "[requestDownloadWithoutLoginInternal], packageIndex=" + parambnpt.jdField_a_of_type_Int + ", networkStatus=UNUSABLE");
        bnzb.b("AEResManager", "[requestDownloadWithoutLoginInternal] - END -, packageIndex=" + parambnpt.jdField_a_of_type_Int);
        return;
      }
      bnzb.b("AEResManager", "[requestDownloadWithoutLoginInternal], packageIndex=" + parambnpt.jdField_a_of_type_Int + ", networkStatus=USABLE");
      b(parambnpw);
      if (!this.jdField_a_of_type_JavaUtilQueue.contains(parambnpt))
      {
        this.jdField_a_of_type_JavaUtilQueue.add(parambnpt);
        this.jdField_a_of_type_JavaUtilMap.put(parambnpt, Integer.valueOf(1));
      }
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(bnpt.jdField_a_of_type_Bnpt))
      {
        this.jdField_a_of_type_JavaUtilMap.put(bnpt.jdField_a_of_type_Bnpt, Integer.valueOf(3));
        bcew.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), this);
      }
      for (;;)
      {
        bnzb.b("AEResManager", "[requestDownloadWithoutLoginInternal] - END -, packageIndex=" + parambnpt.jdField_a_of_type_Int);
        return;
        if ((this.jdField_a_of_type_JavaUtilMap.get(bnpt.jdField_a_of_type_Bnpt) != null) && (((Integer)this.jdField_a_of_type_JavaUtilMap.get(bnpt.jdField_a_of_type_Bnpt)).intValue() == 4)) {
          b(1, 0);
        }
      }
    }
  }
  
  private void b(@Nullable bnpw parambnpw)
  {
    if (parambnpw == null) {}
    while ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.contains(parambnpw))) {
      return;
    }
    this.jdField_b_of_type_JavaUtilList.add(parambnpw);
  }
  
  private void b(String paramString1, int paramInt, String paramString2)
  {
    boolean bool2 = false;
    bnzb.b("AEResManager", "[onDownloadFinishInternal] - BEGIN -, result=" + paramInt + ", name=" + paramString1 + ", filePath=" + paramString2);
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
      localObject2 = bnpt.jdField_b_of_type_ArrayOfBnpt;
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
          bnzb.b("AEResManager", "[onDownloadFinishInternal], matched aeResInfo=" + paramString1);
          if (i == 0)
          {
            this.jdField_a_of_type_JavaUtilMap.put(paramString1, Integer.valueOf(4));
            this.jdField_a_of_type_JavaUtilQueue.remove(paramString1);
            bnpy.a(paramString1, paramString2);
            j = Integer.valueOf(((String)localObject1).substring(paramString1.jdField_b_of_type_JavaLangString.length())).intValue();
            bnpy.a(paramString1.jdField_a_of_type_Int, j);
            label200:
            localObject1 = this.jdField_b_of_type_JavaUtilList.iterator();
            label211:
            if (!((Iterator)localObject1).hasNext()) {
              break label298;
            }
            localObject2 = (bnpw)((Iterator)localObject1).next();
            if (i != 0) {
              break label292;
            }
          }
          label292:
          for (boolean bool1 = true;; bool1 = false)
          {
            ((bnpw)localObject2).a(paramString1, paramString2, bool1, i);
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
            paramString2 = bnyh.a();
            bool1 = bool2;
            if (paramInt == 0) {
              bool1 = true;
            }
            paramString2.a(bool1, paramString1.jdField_a_of_type_Int, "", "", paramInt, l);
          }
          bnzb.b("AEResManager", "[onDownloadFinishInternal], start download next package");
          paramString1 = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
          a(new LinkedList(this.jdField_a_of_type_JavaUtilList), paramString1, true);
        }
      }
      else
      {
        bnzb.b("AEResManager", "[onDownloadFinishInternal] - END -");
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
    paramString = bnpt.jdField_b_of_type_ArrayOfBnpt;
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
          ((bnpw)localIterator.next()).a(localObject, paramLong1, paramLong2);
        }
      }
      i += 1;
    }
  }
  
  public void B_()
  {
    bnzb.d("AEResManager", anni.a(2131698813));
    bceg.a(3, -1500);
  }
  
  @Deprecated
  public int a(@NonNull bnpt parambnpt)
  {
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      parambnpt = (Integer)this.jdField_a_of_type_JavaUtilMap.get(parambnpt);
      if (parambnpt != null) {
        return parambnpt.intValue();
      }
      return 0;
    }
    return 0;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    bnzb.b("AEResManager", "[onConfigResult] - BEGIN -, result=" + paramInt1 + ", serverError=" + paramInt2);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEResManager.6(this));
    bnzb.b("AEResManager", "[onConfigResult] - END -, result=" + paramInt1 + ", serverError=" + paramInt2);
  }
  
  public void a(@NonNull bnpt parambnpt, @Nullable bnpw parambnpw)
  {
    bnzb.b("AEResManager", "[requestDownloadWithoutLogin] - BEGIN -, aeResInfo=" + parambnpt);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEResManager.3(this, parambnpt, parambnpw));
    bnzb.b("AEResManager", "[requestDownloadWithoutLogin] - END -, aeResInfo=" + parambnpt);
  }
  
  public void a(@NonNull bnpt parambnpt, @Nullable bnpw parambnpw, boolean paramBoolean)
  {
    bnzb.b("AEResManager", "[requestDownload] - BEGIN -, aeResInfo=" + parambnpt);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEResManager.1(this, parambnpt, parambnpw, paramBoolean));
    bnzb.b("AEResManager", "[requestDownload] - END -, aeResInfo=" + parambnpt);
  }
  
  public void a(@Nullable bnpw parambnpw)
  {
    if (parambnpw == null) {}
    while (this.jdField_b_of_type_JavaUtilList == null) {
      return;
    }
    this.jdField_b_of_type_JavaUtilList.remove(parambnpw);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    bnzb.b("AEResManager", "[onDownloadFinish] - BEGIN -, result=" + paramInt + ", name=" + paramString1 + ", filePath=" + paramString2);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEResManager.7(this, paramString1, paramInt, paramString2));
    bnzb.b("AEResManager", "[onDownloadFinish] - END -");
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AEResManager.8(this, paramString, paramLong1, paramLong2));
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    bnzb.b("AEResManager", "[onConfigResultWithoutLogin] - BEGIN -, result=" + paramInt1 + ", serverError=" + paramInt2);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEResManager.9(this));
    bnzb.b("AEResManager", "[onConfigResultWithoutLogin] - END -, result=" + paramInt1 + ", serverError=" + paramInt2);
  }
  
  public void b(@NonNull bnpt parambnpt, @Nullable bnpw parambnpw, boolean paramBoolean)
  {
    bnzb.b("AEResManager", "[requestDownload] - BEGIN -, aeResInfo=" + parambnpt);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEResManager.2(this, parambnpt, parambnpw, paramBoolean));
    bnzb.b("AEResManager", "[requestDownload] - END -, aeResInfo=" + parambnpt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnpu
 * JD-Core Version:    0.7.0.1
 */