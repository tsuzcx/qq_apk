import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import dov.com.qq.im.ae.download.AEResManager.1;
import dov.com.qq.im.ae.download.AEResManager.2;
import dov.com.qq.im.ae.download.AEResManager.4;
import dov.com.qq.im.ae.download.AEResManager.5;
import dov.com.qq.im.ae.download.AEResManager.6;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class bkwi
  implements ayzw, ayzy
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "DOWNLOAD_STATUS_IDLE", "DOWNLOAD_STATUS_WAIT", "DOWNLOAD_STATUS_PREDOWNLOAD_WAIT", "DOWNLOAD_STATUS_DOWNLOADING", "DOWNLOAD_STATUS_READY" };
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("AEResManagerHandlerThread", 0);
  private List<ShortVideoResourceManager.SVConfigItem> jdField_a_of_type_JavaUtilList = new LinkedList();
  private Map<bkwh, Integer> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private Queue<bkwh> jdField_a_of_type_JavaUtilQueue = new ArrayDeque();
  private volatile boolean jdField_a_of_type_Boolean;
  private List<bkwk> jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private Map<bkwh, Long> jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  private bkwi()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
  }
  
  private int a(int paramInt)
  {
    return blev.a().a("key_ae_res_" + paramInt, 0, 4);
  }
  
  public static bkwi a()
  {
    return bkwl.a;
  }
  
  @NonNull
  public static String a(@NonNull bkwh parambkwh)
  {
    if (!parambkwh.jdField_a_of_type_Boolean) {
      return "";
    }
    if ("new_qq_android_native_short_filter_".equals(parambkwh.jdField_b_of_type_JavaLangString)) {
      return "";
    }
    if ("new_qq_android_native_ptu_res_".equals(parambkwh.jdField_b_of_type_JavaLangString)) {
      return bkkt.jdField_b_of_type_JavaLangString;
    }
    return "";
  }
  
  private void a()
  {
    blfg.b("AEResManager", "[onConfigResultInternal] - BEGIN -");
    int i;
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilList.size() < 1)
    {
      i = ShortVideoResourceManager.a(null, this.jdField_a_of_type_JavaUtilList);
      blfg.b("AEResManager", "[onConfigResultInternal] mConfigList.size=" + this.jdField_a_of_type_JavaUtilList.size());
      localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (i != 0) {
        break label181;
      }
      a(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_JavaUtilMap.put(bkwh.jdField_a_of_type_Bkwh, Integer.valueOf(4));
      blfg.b("AEResManager", "[onConfigResultInternal], download config succeeded");
      a(new LinkedList(this.jdField_a_of_type_JavaUtilList), (QQAppInterface)localObject);
    }
    for (;;)
    {
      blfg.b("AEResManager", "[onConfigResultInternal] - END -");
      return;
      localObject = new LinkedList();
      i = ShortVideoResourceManager.a(null, (List)localObject);
      if ((i == 0) && (((List)localObject).size() > 0))
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject);
      }
      break;
      label181:
      i = ShortVideoResourceManager.a("[{\n        \"name\": \"new_qq_android_native_short_filter_72\",\n        \"arm_url\": \"http://down.qq.com/shadow_qqcamera/Android/new_qq_android_native_short_filter_72.zip\",\n        \"armv7a_url\": \"http://down.qq.com/shadow_qqcamera/Android/new_qq_android_native_short_filter_72.zip\",\n        \"x86_url\": \"http://down.qq.com/shadow_qqcamera/Android/new_qq_android_native_short_filter_72.zip\",\n        \"arm64v8a_url\": \"http://down.qq.com/shadow_qqcamera/Android/new_qq_android_native_short_filter_72_64bit.zip\",\n        \"arm_md5\": \"5e5e78d4dd585b45ce9afe09871ccd3e\",\n        \"armv7a_md5\": \"5e5e78d4dd585b45ce9afe09871ccd3e\",\n        \"x86_md5\": \"5e5e78d4dd585b45ce9afe09871ccd3e\",\n        \"arm64v8a_md5\": \"a73e9dd385a963b641509b77c18a6a96\",\n        \"versionCode\": \"72\",\n        \"predownload\": false\n    },{\n        \"name\": \"new_qq_android_native_ptu_res_77\",\n        \"arm_url\": \"http://down.qq.com/shadow_qqcamera/Android/new_qq_android_native_ptu_res_77.zip\",\n        \"armv7a_url\": \"http://down.qq.com/shadow_qqcamera/Android/new_qq_android_native_ptu_res_77.zip\",\n        \"x86_url\": \"http://down.qq.com/shadow_qqcamera/Android/new_qq_android_native_ptu_res_77.zip\",\n        \"arm64v8a_url\": \"http://down.qq.com/shadow_qqcamera/Android/new_qq_android_native_ptu_res_77_64bit.zip\",\n        \"arm_md5\": \"c4f89190bbda13a3338ab3d208dbe6e5\",\n        \"armv7a_md5\": \"c4f89190bbda13a3338ab3d208dbe6e5\",\n        \"x86_md5\": \"c4f89190bbda13a3338ab3d208dbe6e5\",\n        \"arm64v8a_md5\": \"246f22c25e2f347cee293427c0c131ff\",\n        \"versionCode\": \"77\",\n        \"predownload\": false\n    }]", this.jdField_a_of_type_JavaUtilList);
      a(this.jdField_a_of_type_JavaUtilList);
      if (i == 0)
      {
        this.jdField_a_of_type_JavaUtilMap.put(bkwh.jdField_a_of_type_Bkwh, Integer.valueOf(4));
        blfg.b("AEResManager", "[onConfigResultInternal], use local config to download package");
        a(new LinkedList(this.jdField_a_of_type_JavaUtilList), (QQAppInterface)localObject);
      }
      else
      {
        this.jdField_a_of_type_JavaUtilMap.remove(bkwh.jdField_a_of_type_Bkwh);
        blfg.d("AEResManager", "[onConfigResultInternal], local config invalid");
        if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0))
        {
          i = 0;
          while (i < bkwh.jdField_b_of_type_ArrayOfBkwh.length)
          {
            localObject = bkwh.jdField_a_of_type_ArrayOfBkwh[i];
            Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
            while (localIterator.hasNext()) {
              ((bkwk)localIterator.next()).a((bkwh)localObject, null, false, -102);
            }
            i += 1;
          }
        }
      }
    }
  }
  
  private void a(@Nullable List<ShortVideoResourceManager.SVConfigItem> paramList)
  {
    if (CollectionUtils.isEmpty(paramList)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ShortVideoResourceManager.SVConfigItem localSVConfigItem = (ShortVideoResourceManager.SVConfigItem)paramList.next();
        if ((localSVConfigItem != null) && (!TextUtils.isEmpty(localSVConfigItem.name))) {
          if (localSVConfigItem.name.startsWith("new_qq_android_native_short_filter_"))
          {
            if (localSVConfigItem.versionCode < 72) {
              bkwd.a(localSVConfigItem);
            }
          }
          else if ((localSVConfigItem.name.startsWith("new_qq_android_native_ptu_res_")) && (localSVConfigItem.versionCode < 77)) {
            bkwd.b(localSVConfigItem);
          }
        }
      }
    }
  }
  
  private void a(@NonNull List<ShortVideoResourceManager.SVConfigItem> paramList, @NonNull QQAppInterface paramQQAppInterface)
  {
    blfg.b("AEResManager", "[startDownLoad] - BEGIN -");
    if (CollectionUtils.isEmpty(this.jdField_a_of_type_JavaUtilQueue))
    {
      blfg.d("AEResManager", "[startDownLoad], mDownLoadTaskQueue is empty");
      blfg.b("AEResManager", "[startDownLoad] - END -");
      return;
    }
    bkwh localbkwh = (bkwh)this.jdField_a_of_type_JavaUtilQueue.peek();
    if (localbkwh == null)
    {
      blfg.d("AEResManager", "[startDownLoad], mDownLoadTaskQueue top element is null");
      blfg.b("AEResManager", "[startDownLoad] - END -");
      return;
    }
    int i;
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(localbkwh))
    {
      i = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(localbkwh)).intValue();
      blfg.a("AEResManager", "[startDownLoad], resNeedDownload=" + localbkwh);
      blfg.a("AEResManager", "[startDownLoad], status=" + jdField_a_of_type_ArrayOfJavaLangString[i]);
      if (!a()) {
        break label270;
      }
      blfg.b("AEResManager", "[startDownLoad], isDownLoadImmediately=true");
      if (i != 3)
      {
        this.jdField_a_of_type_JavaUtilMap.put(localbkwh, Integer.valueOf(3));
        if (i == 2) {
          a(paramList, paramQQAppInterface, localbkwh);
        }
        this.jdField_b_of_type_JavaUtilMap.put(localbkwh, Long.valueOf(System.currentTimeMillis()));
        blfg.b("AEResManager", "[startDownLoad], ShortVideoResourceManager.doUserDownloadResource()");
        ShortVideoResourceManager.a(paramQQAppInterface, paramList, this, localbkwh.jdField_b_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      blfg.b("AEResManager", "[startDownLoad] - END -");
      return;
      blfg.d("AEResManager", "[startDownLoad], cannot find resNeedDownload in mStatusMap");
      blfg.b("AEResManager", "[startDownLoad] - END -");
      return;
      label270:
      blfg.b("AEResManager", "[startDownLoad], isDownLoadImmediately=false");
      if ((i == 3) || (i == 2)) {
        break;
      }
      if (!a(paramList, this, paramQQAppInterface, localbkwh))
      {
        a(paramList, paramQQAppInterface, localbkwh);
        this.jdField_b_of_type_JavaUtilMap.put(localbkwh, Long.valueOf(System.currentTimeMillis()));
        blfg.b("AEResManager", "[startDownLoad], ShortVideoResourceManager.doUserDownloadResource()");
        ShortVideoResourceManager.a(paramQQAppInterface, paramList, this, localbkwh.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilMap.put(localbkwh, Integer.valueOf(3));
      }
      else
      {
        this.jdField_a_of_type_JavaUtilMap.put(localbkwh, Integer.valueOf(2));
      }
    }
  }
  
  private void a(@NonNull List<ShortVideoResourceManager.SVConfigItem> paramList, @NonNull QQAppInterface paramQQAppInterface, @NonNull bkwh parambkwh)
  {
    blfg.b("AEResManager", "[cancelPreDownLoad] - BEGIN -, aeResInfo=" + parambkwh);
    paramQQAppInterface = (bavr)paramQQAppInterface.getManager(193);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (ShortVideoResourceManager.SVConfigItem)localIterator.next();
      if (paramList.name.startsWith(parambkwh.jdField_b_of_type_JavaLangString)) {
        blfg.b("AEResManager", "[cancelPreDownLoad], chosenConfigItem matched");
      }
    }
    for (;;)
    {
      if ((paramQQAppInterface.a()) && (paramList != null))
      {
        if ((!azax.a()) || (!paramList.check64BitReady())) {
          break label174;
        }
        paramQQAppInterface.a(paramList.arm64v8a_url);
      }
      for (;;)
      {
        blfg.b("AEResManager", "[cancelPreDownLoad], preDownloadController.isEnable() == " + paramQQAppInterface.a());
        blfg.b("AEResManager", "[cancelPreDownLoad] - END -, aeResInfo=" + parambkwh);
        return;
        label174:
        paramQQAppInterface.a(paramList.armv7a_url);
      }
      paramList = null;
    }
  }
  
  private boolean a(@NonNull List<ShortVideoResourceManager.SVConfigItem> paramList, @NonNull ayzw paramayzw, @NonNull QQAppInterface paramQQAppInterface, @NonNull bkwh parambkwh)
  {
    blfg.b("AEResManager", "[startPreDownLoad] - BEGIN -, aeResInfo=" + parambkwh);
    bavr localbavr = (bavr)paramQQAppInterface.getManager(193);
    Iterator localIterator = paramList.iterator();
    ShortVideoResourceManager.SVConfigItem localSVConfigItem;
    while (localIterator.hasNext())
    {
      localSVConfigItem = (ShortVideoResourceManager.SVConfigItem)localIterator.next();
      if (localSVConfigItem.name.startsWith(parambkwh.jdField_b_of_type_JavaLangString)) {
        blfg.b("AEResManager", "[startPreDownLoad], chosenConfigItem matched");
      }
    }
    for (;;)
    {
      if (localbavr.a())
      {
        paramayzw = new bkwj(this, paramQQAppInterface, "ae_camera_res", new AEResManager.2(this, parambkwh, paramQQAppInterface, paramList, paramayzw), 4000L);
        if (localSVConfigItem != null)
        {
          if ((azax.a()) && (localSVConfigItem.check64BitReady())) {}
          for (paramList = localSVConfigItem.arm64v8a_url;; paramList = localSVConfigItem.armv7a_url)
          {
            boolean bool = localbavr.a(10091, null, localSVConfigItem.name, 0, paramList, ShortVideoResourceManager.a(localSVConfigItem.name), 4, 0, true, paramayzw);
            blfg.b("AEResManager", "[startPreDownLoad], preDownloadController.requestPreDownload(), succeeded=" + bool);
            blfg.b("AEResManager", "[startPreDownLoad] - END -, aeResInfo=" + parambkwh);
            return bool;
          }
        }
        blfg.b("AEResManager", "[startPreDownLoad], chosenConfigItem == nul");
        blfg.b("AEResManager", "[startPreDownLoad] - END -, aeResInfo=" + parambkwh);
        return false;
      }
      blfg.b("AEResManager", "[startPreDownLoad], preDownloadController.isEnable() == false");
      blfg.b("AEResManager", "[startPreDownLoad] - END -, aeResInfo=" + parambkwh);
      return false;
      localSVConfigItem = null;
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    blev.a().a("key_ae_res_" + paramInt1, paramInt2, 4);
  }
  
  private void b(@NonNull bkwh parambkwh, @Nullable bkwk parambkwk, boolean paramBoolean)
  {
    blfg.b("AEResManager", "[requestDownloadInternal] - BEGIN -, packageIndex=" + parambkwh.jdField_a_of_type_Int);
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(parambkwh)) {
      this.jdField_a_of_type_JavaUtilMap.put(parambkwh, Integer.valueOf(0));
    }
    int i = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(parambkwh)).intValue();
    blfg.b("AEResManager", "[requestDownloadInternal], status=" + jdField_a_of_type_ArrayOfJavaLangString[i]);
    if (i == 4)
    {
      i = a(parambkwh.jdField_a_of_type_Int);
      if (i == 0) {
        break label661;
      }
    }
    label661:
    for (String str = ShortVideoResourceManager.b() + parambkwh.jdField_b_of_type_JavaLangString + i;; str = null)
    {
      if (parambkwk != null) {
        parambkwk.a(parambkwh, str, true, 0);
      }
      parambkwk = new Intent();
      parambkwk.setAction(parambkwh.jdField_b_of_type_JavaLangString);
      parambkwk.setPackage(BaseApplicationImpl.getContext().getPackageName());
      parambkwk.putExtra("ae_camera_res_downloadfinish_path", str);
      BaseApplicationImpl.getContext().sendBroadcast(parambkwk);
      blfg.b("AEResManager", "[requestDownloadInternal], packageIndex=" + parambkwh.jdField_a_of_type_Int + ", downloadStatus=DOWNLOAD_STATUS_READY");
      blfg.b("AEResManager", "[requestDownloadInternal] - END -, packageIndex=" + parambkwh.jdField_a_of_type_Int);
      return;
      if (i == 3)
      {
        b(parambkwk);
        blfg.b("AEResManager", "[requestDownloadInternal], packageIndex=" + parambkwh.jdField_a_of_type_Int + ", downloadStatus=DOWNLOAD_STATUS_DOWNLOADING");
        blfg.b("AEResManager", "[requestDownloadInternal] - END -, packageIndex=" + parambkwh.jdField_a_of_type_Int);
        return;
      }
      if ((bdee.g(null)) && ((!paramBoolean) || (bdee.h(null)))) {}
      for (i = 1; i == 0; i = 0)
      {
        if (parambkwk != null) {
          parambkwk.a(parambkwh, null, false, -6);
        }
        blfg.b("AEResManager", "[requestDownloadInternal], packageIndex=" + parambkwh.jdField_a_of_type_Int + ", networkStatus=UNUSABLE");
        blfg.b("AEResManager", "[requestDownloadInternal] - END -, packageIndex=" + parambkwh.jdField_a_of_type_Int);
        return;
      }
      blfg.b("AEResManager", "[requestDownloadInternal], packageIndex=" + parambkwh.jdField_a_of_type_Int + ", networkStatus=USABLE");
      b(parambkwk);
      if (!this.jdField_a_of_type_JavaUtilQueue.contains(parambkwh))
      {
        this.jdField_a_of_type_JavaUtilQueue.add(parambkwh);
        this.jdField_a_of_type_JavaUtilMap.put(parambkwh, Integer.valueOf(1));
      }
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(bkwh.jdField_a_of_type_Bkwh))
      {
        this.jdField_a_of_type_JavaUtilMap.put(bkwh.jdField_a_of_type_Bkwh, Integer.valueOf(3));
        ShortVideoResourceManager.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), this);
      }
      for (;;)
      {
        blfg.b("AEResManager", "[requestDownloadInternal] - END -, packageIndex=" + parambkwh.jdField_a_of_type_Int);
        return;
        if ((this.jdField_a_of_type_JavaUtilMap.get(bkwh.jdField_a_of_type_Bkwh) != null) && (((Integer)this.jdField_a_of_type_JavaUtilMap.get(bkwh.jdField_a_of_type_Bkwh)).intValue() == 4)) {
          a(1, 0);
        }
      }
    }
  }
  
  private void b(@Nullable bkwk parambkwk)
  {
    if (parambkwk == null) {}
    while ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.contains(parambkwk))) {
      return;
    }
    this.jdField_b_of_type_JavaUtilList.add(parambkwk);
  }
  
  private void b(String paramString1, int paramInt, String paramString2)
  {
    boolean bool2 = false;
    blfg.b("AEResManager", "[onDownloadFinishInternal] - BEGIN -, result=" + paramInt + ", name=" + paramString1 + ", filePath=" + paramString2);
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
      localObject2 = bkwh.jdField_b_of_type_ArrayOfBkwh;
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
          blfg.b("AEResManager", "[onDownloadFinishInternal], matched aeResInfo=" + paramString1);
          if (i == 0)
          {
            this.jdField_a_of_type_JavaUtilMap.put(paramString1, Integer.valueOf(4));
            this.jdField_a_of_type_JavaUtilQueue.remove(paramString1);
            localObject2 = new Intent();
            ((Intent)localObject2).setAction(paramString1.jdField_b_of_type_JavaLangString);
            ((Intent)localObject2).setPackage(BaseApplicationImpl.getContext().getPackageName());
            ((Intent)localObject2).putExtra("ae_camera_res_downloadfinish_path", paramString2);
            BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject2);
            j = Integer.valueOf(((String)localObject1).substring(paramString1.jdField_b_of_type_JavaLangString.length())).intValue();
            b(paramString1.jdField_a_of_type_Int, j);
            label244:
            localObject1 = this.jdField_b_of_type_JavaUtilList.iterator();
            label255:
            if (!((Iterator)localObject1).hasNext()) {
              break label342;
            }
            localObject2 = (bkwk)((Iterator)localObject1).next();
            if (i != 0) {
              break label336;
            }
          }
          label336:
          for (boolean bool1 = true;; bool1 = false)
          {
            ((bkwk)localObject2).a(paramString1, paramString2, bool1, i);
            break label255;
            i = paramInt;
            break;
            this.jdField_a_of_type_JavaUtilMap.put(paramString1, Integer.valueOf(0));
            this.jdField_a_of_type_JavaUtilQueue.remove(paramString1);
            break label244;
          }
          label342:
          if (paramInt != 1)
          {
            long l = -1L;
            if (this.jdField_b_of_type_JavaUtilMap.get(paramString1) != null) {
              l = System.currentTimeMillis() - ((Long)this.jdField_b_of_type_JavaUtilMap.get(paramString1)).longValue();
            }
            paramString2 = blen.a();
            bool1 = bool2;
            if (paramInt == 0) {
              bool1 = true;
            }
            paramString2.a(bool1, paramString1.jdField_a_of_type_Int, "", "", paramInt, l);
          }
          blfg.b("AEResManager", "[onDownloadFinishInternal], start download next package");
          paramString1 = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
          a(new LinkedList(this.jdField_a_of_type_JavaUtilList), paramString1);
        }
      }
      else
      {
        blfg.b("AEResManager", "[onDownloadFinishInternal] - END -");
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
    paramString = bkwh.jdField_b_of_type_ArrayOfBkwh;
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
          ((bkwk)localIterator.next()).a(localObject, paramLong1, paramLong2);
        }
      }
      i += 1;
    }
  }
  
  public void G_()
  {
    blfg.d("AEResManager", alpo.a(2131700375));
    ayyy.a(3, -1500);
  }
  
  @Deprecated
  public int a(@NonNull bkwh parambkwh)
  {
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      parambkwh = (Integer)this.jdField_a_of_type_JavaUtilMap.get(parambkwh);
      if (parambkwh != null) {
        return parambkwh.intValue();
      }
      return 0;
    }
    return 0;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    blfg.b("AEResManager", "[onConfigResult] - BEGIN -, result=" + paramInt1 + ", serverError=" + paramInt2);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEResManager.4(this));
    blfg.b("AEResManager", "[onConfigResult] - END -, result=" + paramInt1 + ", serverError=" + paramInt2);
  }
  
  public void a(@NonNull bkwh parambkwh, @Nullable bkwk parambkwk, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AEResManager.1(this, parambkwh, parambkwk, paramBoolean));
  }
  
  public void a(@Nullable bkwk parambkwk)
  {
    if (parambkwk == null) {}
    while (this.jdField_b_of_type_JavaUtilList == null) {
      return;
    }
    this.jdField_b_of_type_JavaUtilList.remove(parambkwk);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    blfg.b("AEResManager", "[onDownloadFinish] - BEGIN -, result=" + paramInt + ", name=" + paramString1 + ", filePath=" + paramString2);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEResManager.5(this, paramString1, paramInt, paramString2));
    blfg.b("AEResManager", "[onDownloadFinish] - END -");
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AEResManager.6(this, paramString, paramLong1, paramLong2));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkwi
 * JD-Core Version:    0.7.0.1
 */